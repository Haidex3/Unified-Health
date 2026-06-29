package com.develop.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.horarioHora.HorarioHoraRepository
import com.develop.myapplication.ui.model.HorarioHora
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HorarioHoraFormViewModel @Inject constructor(
    private val horarioHoraRepository: HorarioHoraRepository
) : ViewModel() {
    var hora        by mutableStateOf("")
    var disponible  by mutableStateOf("")
    var fecha       by mutableStateOf("")
    var idCita      by mutableStateOf("")
    var idMedico    by mutableStateOf("")

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
    fun insertarHorarios() {
        viewModelScope.launch {
            val nuevoHorarioHora = HorarioHora(
                id          = 0,
                hora        = hora,
                disponible  = disponible.toBoolean(),
                // true cuando disponible = "true"
                fecha       = fecha,
                idCita      = idCita.toInt(),
                idMedico    = idMedico.toInt()
            )
            horarioHoraRepository.insertarHorario(nuevoHorarioHora)
            resetForm()
        }
    }

    private fun resetForm() {
        hora        = ""
        disponible  = ""
        fecha       = ""
        idCita      = ""
        idMedico    = ""
    }
}