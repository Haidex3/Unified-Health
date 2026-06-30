package com.develop.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.cita.CitaRepository
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.data.repository.paciente.PacienteRepository
import com.develop.myapplication.ui.model.Cita
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CitaFormViewModel @Inject constructor(
    private val citaRepository: CitaRepository,
    private val medicoRepository: MedicoRepository
) : ViewModel() {
    var fecha           by mutableStateOf("")
    var detalle         by mutableStateOf("")
    var conclusiones    by mutableStateOf("")
    var idHorarioHora   by mutableStateOf("")
    var idPaciente        by mutableStateOf("")


    val citas: StateFlow<List<Cita>> = citaRepository.obtenerTodosCitas()
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
            citaRepository.sincronizarCitas()
        }
    }
    fun insertarCita() {
        viewModelScope.launch {
            val nuevaCita = Cita(
                id = 0,
                fecha = fecha,
                detalle = detalle,
                conclusiones = conclusiones,
                idHorarioHora = idHorarioHora.toInt(),
                idPaciente = idPaciente.toInt()

            )
            citaRepository.insertarCita(nuevaCita)
            resetForm()
        }
    }


    private fun resetForm() {
        fecha = ""
        fecha = ""
        detalle = ""
        conclusiones= ""
        idHorarioHora = ""
        idPaciente = ""
    }
}