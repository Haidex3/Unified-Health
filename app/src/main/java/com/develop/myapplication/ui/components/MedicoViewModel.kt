package com.develop.myapplication.ui.components

/*
@HiltViewModel
class FormViewModel @Inject constructor(
    private val hospitalRepository: HospitalRepository
) : ViewModel() {
    var nombre by mutableStateOf("")
    var correo by mutableStateOf("")
    var telefono by mutableStateOf("")
    var ubicacion by mutableStateOf("")

    val hospitales: StateFlow<List<Hospital>> = hospitalRepository.obtenerTodosHospitales()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000), // Se apaga 5s después de cerrar la pantalla
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
                id = 0, // Room lo autogenera
                nombre = nombre,
                correo = correo,
                telefono = telefono.toInt(),
                ubicacion = ubicacion
            )
            hospitalRepository.insertarHospital(nuevoHospital)
            resetForm()
        }
    }
    private fun resetForm() {
        nombre = ""
        correo = ""
        telefono = ""
        ubicacion = ""
    }
}


/*
data class DoctorUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

class MedicoViewModel : ViewModel() {

    var uiState by mutableStateOf(DoctorUiState())
        private set

    fun registrarMedico(
        nombre: String,
        correo: String,
        password: String,
        rut: String,
        celular: String,
        hospitalId: Int
    ) {
        viewModelScope.launch {

            uiState = uiState.copy(isLoading = true)

            try {
                val medico = Medico(
                    nombre = nombre,
                    correo = correo,
                    password = password,
                    rut = rut,
                    celular = celular,
                    hospital_id = hospitalId
                )


                DataBaseModule.api.createDoctor(medico)

                uiState = uiState.copy(
                    isLoading = false,
                    mensaje = "Doctor creado correctamente"
                )

            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Error al crear doctor"
                )
            }
        }
    }

    fun limpiarMensaje() {
        uiState = uiState.copy(
            mensaje = null,
            error = null
        )
    }
}*/