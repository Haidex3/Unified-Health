package com.develop.myapplication.ui.model.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.cita.CitaRepository
import com.develop.myapplication.ui.model.Cita
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class CitaViewModel @Inject constructor(
    private val citaRepository: CitaRepository
) : ViewModel() {
    private val medicoIdSeleccionado = MutableStateFlow(0)

    val citas: StateFlow<List<Cita>> = medicoIdSeleccionado
        .flatMapLatest { medicoId ->
            if (medicoId == 0) citaRepository.obtenerTodosCitas() else citaRepository.obtenerCitasPorMedico(medicoId)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun cargarCitasMedico(medicoId: Int) {
        medicoIdSeleccionado.value = medicoId
        viewModelScope.launch { citaRepository.sincronizarCitasPorMedico(medicoId) }
    }
}