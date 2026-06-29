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
    var mensaje by mutableStateOf<String?>(null)

    val hospitales: StateFlow<List<Hospital>> = hospitalRepository.obtenerTodosHospitales()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init { actualizarDatos() }

    fun actualizarDatos() {
        viewModelScope.launch { hospitalRepository.sincronizarHospitales() }
    }

    fun insertarHospital() {
<<<<<<< HEAD:app/src/main/java/com/develop/myapplication/ui/components/HospitalViewModel.kt
        if (nombre.isBlank() || correo.isBlank() || telefono.isBlank() || ubicacion.isBlank()) {
            mensaje = "Completa todos los campos"
            return
        }
=======

>>>>>>> Cristian:app/src/main/java/com/develop/myapplication/ui/viewmodel/HospitalViewModel.kt
        viewModelScope.launch {
            hospitalRepository.insertarHospitalBackend(
                Hospital(nombre = nombre, correo = correo, telefono = telefono, ubicacion = ubicacion)
            )
            mensaje = "Hospital guardado"
            resetForm()
            actualizarDatos()
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