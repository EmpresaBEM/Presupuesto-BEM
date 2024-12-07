package com.bem.presupuesto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bem.presupuesto.ui.theme.PresupuestoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresupuestoTheme() {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("My App")},
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFF1E3A8A),
                                titleContentColor = Color.White,
                                navigationIconContentColor = Color.White
                            ),
                            navigationIcon = {
                                IconButton(onClick = {("d")}){
                                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                                }
                            },
                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Default.MoreVert, contentDescription = "More")
                                }
                            })

                    }
                )
                {
                        innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier=Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id=R.drawable.fondo),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier=Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier=Modifier.height(56.dp))
            Text(
                text="Aplicación que se encargará de realizar las siguientes acciones:",
                modifier=Modifier
                    .padding(top = 40.dp),
                color = androidx.compose.ui.graphics.Color.White,
                style= MaterialTheme.typography.headlineMedium,
                maxLines = Int.MAX_VALUE,
                softWrap = true
            )
            ListaEjemplo()
        }
    }
}
@Composable
fun ListaEjemplo(){
    val elementos= listOf("Registrar ingresos","Retirada de capital","Plan de consumo mensual")
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(elementos){elemento->
            Text(
                text=elemento,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color=androidx.compose.ui.graphics.Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = MaterialTheme.typography.headlineSmall.fontWeight
                )
            )}
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PresupuestoTheme() {
        Greeting("Android")
    }
}