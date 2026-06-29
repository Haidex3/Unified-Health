package com.develop.myapplication.ui.screens.medico

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.data.model.Paciente
import com.develop.myapplication.ui.components.PacienteViewModel
import com.develop.myapplication.ui.model.Paciente

@Composable
fun RegistrarPacienteScreen(
    navController: NavHostController? = null,
    pacienteViewModel: PacienteViewModel = hiltViewModel()
) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var rut by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var hospitalId by remember { mutableStateOf("") }

    var mensaje by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Registrar paciente",
                style = MaterialTheme.typography.headlineSmall
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = correo,
                        onValueChange = { correo = it },
                        label = { Text("Correo") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )

                    OutlinedTextField(
                        value = rut,
                        onValueChange = { rut = it },
                        label = { Text("RUT") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = sexo,
                        onValueChange = { sexo = it },
                        label = { Text("Sexo") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = celular,
                        onValueChange = { celular = it },
                        label = { Text("Celular") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Contraseña") },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    OutlinedTextField(
                        value = hospitalId,
                        onValueChange = { hospitalId = it },
                        label = { Text("ID del hospital") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            val celularNumero = celular.toIntOrNull()
                            val hospitalIdNumero = hospitalId.toIntOrNull()

                            if (
                                nombre.isBlank() ||
                                correo.isBlank() ||
                                rut.isBlank() ||
                                sexo.isBlank() ||
                                celular.isBlank() ||
                                password.isBlank() ||
                                hospitalId.isBlank()
                            ) {
                                mensaje = "Debes completar todos los campos."
                            } else if (celularNumero == null) {
                                mensaje = "El celular debe ser un número válido."
                            } else if (hospitalIdNumero == null) {
                                mensaje = "El ID del hospital debe ser un número válido."
                            } else {
                                val nuevoPaciente = Paciente(
                                    id = 0,
                                    nombre = nombre,
                                    correo = correo,
                                    rut = rut,
                                    sexo = sexo,
                                    celular = 1,
                                    password = password,
                                    hospitalId = hospitalIdNumero
                                )

                                pacienteViewModel.crearPaciente(nuevoPaciente)

                                mensaje = "Paciente registrado correctamente."

                                nombre = ""
                                correo = ""
                                rut = ""
                                sexo = ""
                                celular = ""
                                password = ""
                                hospitalId = ""
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Registrar paciente")
                    }

                    if (mensaje.isNotBlank()) {
                        Text(
                            text = mensaje,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}