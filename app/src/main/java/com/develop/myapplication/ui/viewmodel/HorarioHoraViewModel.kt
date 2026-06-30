package com.develop.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.horarioHora.HorarioHoraRepository
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.ui.model.HorarioHora
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject


@HiltViewModel
class HorarioHoraFormViewModel @Inject constructor(
    private val horarioHoraRepository: HorarioHoraRepository,
    private val medicoRepository: MedicoRepository
) : ViewModel() {
    var hora        by mutableStateOf("")
    var disponible  by mutableStateOf("")
    var fecha       by mutableStateOf("")
    var idMedico    by mutableStateOf("")
    var nombreMedico by mutableStateOf("")
    var showDate     by mutableStateOf(false)

    val horarios: StateFlow<List<HorarioHora>> = horarioHoraRepository.obtenerTodosHorarios()
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
            horarioHoraRepository.sincronizarHorarios()
        }
    }
    fun insertarHorario() {
        viewModelScope.launch {
            val nuevoHorarioHora = HorarioHora(
                id          = 0,
                hora        = hora,
                disponible  = disponible.toBoolean(),
                fecha       = fecha,
                idMedico    = medicoRepository.buscarPorNombre(nombreMedico).id
            )
            horarioHoraRepository.insertarHorario(nuevoHorarioHora)
            resetForm()
        }
    }

    private fun resetForm() {
        hora        = ""
        disponible  = ""
        fecha       = ""
        idMedico    = ""
    }
}