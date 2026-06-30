package com.develop.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.ui.model.Medico
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicoViewModel @Inject constructor(
    private val medicoRepository: MedicoRepository,
    private val hospitalRepository: HospitalRepository
) : ViewModel() {
    var nombre      by mutableStateOf("")
    var correo      by mutableStateOf("")
    var celular     by mutableStateOf("")
    var password    by mutableStateOf("")
    var rut         by mutableStateOf("")
    var idHospital  by mutableStateOf("")
    var hospital    by mutableStateOf("")
    val medicos: StateFlow<List<Medico>> = medicoRepository.obtenerTodosMedicos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5000), // Se apaga 5s después de cerrar la pantalla
            initialValue = emptyList()
        )
    init {
        actualizarDatos()
    }
    fun actualizarDatos(){
        viewModelScope.launch {
            medicoRepository.sincronizarMedicos()
        }
    }
    fun insertarMedico() {

        viewModelScope.launch {
            val nuevoMedico = Medico(
                id = 0,
                nombre = nombre,
                correo = correo,
                celular = celular,
                password = password,
                rut = rut.toInt(),
                idHospital = hospitalRepository.buscarPorNombre(hospital).id
            )
            medicoRepository.insertarMedicoBackend(nuevoMedico)
            resetForm()
        }
    }
    suspend fun eliminarMedico(nombreMedico: String){
        val medicoBorrar: Medico = medicoRepository.buscarPorNombre(nombreMedico)
        medicoRepository.borrarMedico(medicoBorrar)
        nombre = ""
    }
    private fun resetForm() {
        nombre   = ""
        correo   = ""
        celular  = ""
        password = ""
        rut      = ""
        hospital = ""
        idHospital = ""
    }
}