package com.develop.myapplication.ui.screens.hospital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.develop.myapplication.ui.ViewModel.HospitalFormViewModel

@Composable
fun VerHospitalesScreen(formViewModel: HospitalFormViewModel = hiltViewModel()) {
    val hospitales by formViewModel.hospitales.collectAsStateWithLifecycle()
    Scaffold() { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    items = hospitales
                ) {
                    Card(
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(it.nombre)
                            Text(it.correo)
                            Text(it.telefono.toString())
                            Text(it.ubicacion)
                        }
                    }
                }
            }
        }
    }
}