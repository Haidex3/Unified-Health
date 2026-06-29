package com.develop.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.ui.model.Hospital
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HospitalFormViewModel @Inject constructor(
    private val hospitalRepository: HospitalRepository
) : ViewModel() {
    var nombre by mutableStateOf("")
    var correo by mutableStateOf("")
    var telefono by mutableStateOf("")
    var ubicacion by mutableStateOf("")
    val hospitales: StateFlow<List<Hospital>> = hospitalRepository.obtenerTodosHospitales()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    init {
        actualizarDatos()
    }
    fun actualizarDatos(){
            viewModelScope.launch {
                hospitalRepository.sincronizarHospitales()
            }
    }
    fun insertarHospital() {

        viewModelScope.launch {
            val nuevoHospital = Hospital(
                id = 0,
                nombre = nombre,
                correo = correo,
                telefono = telefono.toInt(),
                ubicacion = ubicacion
            )
            hospitalRepository.insertarHospitalBackend(nuevoHospital)
            resetForm()
        }
    }
    suspend fun eliminarHospital(nombreHospital: String){
        val hospitalBorar: Hospital = hospitalRepository.buscarPorNombre(nombreHospital)
        hospitalRepository.borrarHospital(hospitalBorar)
        nombre = ""
    }
  /*  fun buscarIdPorNombre(nombre: String): String{
        val nombreBusqueda =  hospitalRepository.buscarIdPorNombre(nombre)
        return nombreBusqueda
    }*/
    private fun resetForm() {
        nombre = ""
        correo = ""
        telefono = ""
        ubicacion = ""
    }
}