package com.develop.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.paciente.PacienteRepository
import com.develop.myapplication.ui.model.Medico
import com.develop.myapplication.ui.model.Paciente
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PacienteViewModel @Inject constructor(
    private val pacienteRepository: PacienteRepository
) : ViewModel() {
    var nombre     by mutableStateOf("")
    var correo     by mutableStateOf("")
    var rut        by mutableStateOf("")
    var sexo       by mutableStateOf("")
    var celular    by mutableStateOf("")
    var password   by mutableStateOf("")
    var idHospital by mutableStateOf("")

    val paciente: StateFlow<List<Paciente>> = pacienteRepository.obtenerTodosPacientes()
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
                idHospital = idHospital.toInt()
            )
            pacienteRepository.insertarPaciente(nuevoPaciente)
            resetForm()
        }
    }
    private fun resetForm() {
        nombre   = ""
        rut      = ""
        sexo     = ""
        correo   = ""
        password = ""
        celular  = ""
        idHospital = ""
    }
}