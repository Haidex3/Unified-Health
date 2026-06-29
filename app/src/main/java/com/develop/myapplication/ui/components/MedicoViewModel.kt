package com.develop.myapplication.ui.components

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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.ui.model.Medico
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class MedicoViewModel @Inject constructor(
    private val medicoRepository: MedicoRepository
) : ViewModel() {
    var nombre by mutableStateOf("")
    var correo by mutableStateOf("")
    var rut by mutableStateOf("")
    var password by mutableStateOf("")
    var celular by mutableStateOf("")
    var hospitalId by mutableStateOf("")
    var mensaje by mutableStateOf<String?>(null)

    val medicos: StateFlow<List<Medico>> = medicoRepository.obtenerTodosMedicos()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init { actualizarDatos() }

    fun actualizarDatos() {
        viewModelScope.launch { medicoRepository.sincronizarMedicos() }
    }

    fun insertarMedico() {
        val hospital = hospitalId.toIntOrNull()
        if (nombre.isBlank() || correo.isBlank() || rut.isBlank() || password.isBlank() || celular.isBlank() || hospital == null) {
            mensaje = "Completa todos los campos. Hospital ID debe ser número."
            return
        }
        viewModelScope.launch {
            medicoRepository.insertarMedicoBackend(
                Medico(nombre = nombre, correo = correo, RUT = rut, password = password, celular = celular, hospitalId = hospital)
            )
            mensaje = "Médico guardado"
            resetForm()
            actualizarDatos()
        }
    }

    private fun resetForm() {
        nombre = ""
        correo = ""
        rut = ""
        password = ""
        celular = ""
        hospitalId = ""
    }
}