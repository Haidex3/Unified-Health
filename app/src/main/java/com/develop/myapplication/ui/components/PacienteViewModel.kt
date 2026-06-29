package com.develop.myapplication.ui.components

import com.develop.myapplication.data.repository.paciente.PacienteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.ui.model.Paciente
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class PacienteViewModel @Inject constructor(
    private val pacienteRepository: PacienteRepository
) : ViewModel() {
    var nombre by mutableStateOf("")
    var correo by mutableStateOf("")
    var rut by mutableStateOf("")
    var sexo by mutableStateOf("")
    var celular by mutableStateOf("")
    var password by mutableStateOf("")
    var hospitalId by mutableStateOf("")
    var mensaje by mutableStateOf<String?>(null)

    val pacientes: StateFlow<List<Paciente>> = pacienteRepository.obtenerTodosPacientes()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init { actualizarDatos() }

    fun actualizarDatos() {
        viewModelScope.launch { pacienteRepository.sincronizarPacientes() }
    }

    fun insertarPaciente() {
        val hospital = hospitalId.toIntOrNull()
        if (nombre.isBlank() || correo.isBlank() || rut.isBlank() || sexo.isBlank() || celular.isBlank() || password.isBlank() || hospital == null) {
            mensaje = "Completa todos los campos. Hospital ID debe ser número."
            return
        }
        viewModelScope.launch {
            pacienteRepository.insertarPacienteBackend(
                Paciente(nombre = nombre, correo = correo, RUT = rut, sexo = sexo, celular = celular, password = password, hospitalId = hospital)
            )
            mensaje = "Paciente guardado"
            resetForm()
            actualizarDatos()
        }
    }

    private fun resetForm() {
        nombre = ""
        correo = ""
        rut = ""
        sexo = ""
        celular = ""
        password = ""
        hospitalId = ""
    }
}
