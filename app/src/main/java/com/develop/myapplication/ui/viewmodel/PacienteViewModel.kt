package com.develop.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.data.repository.paciente.PacienteRepository
import com.develop.myapplication.ui.model.Paciente
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PacienteViewModel @Inject constructor(
    private val pacienteRepository: PacienteRepository,
    private val hospitalRepository: HospitalRepository
) : ViewModel() {
    var nombre     by mutableStateOf("")
    var correo     by mutableStateOf("")
    var rut        by mutableStateOf("")
    var sexo       by mutableStateOf("")
    var celular    by mutableStateOf("")
    var password   by mutableStateOf("")
    var idHospital by mutableStateOf("")
    var hospital   by mutableStateOf("")

    val pacientes: StateFlow<List<Paciente>> = pacienteRepository.obtenerTodosPacientes()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    init {
        actualizarDatos()
    }
    fun actualizarDatos(){
        viewModelScope.launch {
            pacienteRepository.sincronizarPacientes()
        }
    }
     fun insertarPaciente() {
        viewModelScope.launch {
            val nuevoPaciente = Paciente(
                id         = 0,
                nombre     = nombre,
                rut        = rut.toInt(),
                sexo       = sexo,
                correo     = correo,
                password   = password,
                celular    = celular,
                idHospital = hospitalRepository.buscarPorNombre(hospital).id
            )
            pacienteRepository.insertarPacienteBackend(nuevoPaciente)
            resetForm()
        }
    }
    suspend fun eliminarPaciente(nombrePaciente: String){
        val pacienteBorra: Paciente = pacienteRepository.buscarPorNombre(nombrePaciente)
        pacienteRepository.borrarPaciente(pacienteBorra)
        nombre = ""
    }
    suspend fun buscarPaciente(){
        nombre = ""
        correo = ""
        val pacienteBusqueda:Paciente = pacienteRepository.buscarPorRut(rut.toInt())
        nombre = pacienteBusqueda.nombre
        correo = pacienteBusqueda.correo

    }

    private fun resetForm() {
        nombre   = ""
        sexo     = ""
        correo   = ""
        password = ""
        celular  = ""
        rut        = ""
        hospital   = ""
        idHospital = ""
    }
}