package utn.appmoviles.gamecapitalskotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import utn.appmoviles.gamecapitalskotlin.model.Routes
import utn.appmoviles.gamecapitalskotlin.ui.theme.colorBoton
import utn.appmoviles.gamecapitalskotlin.ui.theme.colorFondo
import utn.appmoviles.gamecapitalskotlin.ui.theme.colorTitulo


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationController = rememberNavController()

            NavHost(
                navController = navigationController,
                startDestination = Routes.PantallaInicio.route
            ) {
                composable(Routes.PantallaInicio.route) { PantallaInicio(navigationController) }
                composable(Routes.PantallaGame.route) { PantallaGame(navigationController) }
                composable(Routes.PantallaCapitals.route) { PantallaCapitals(navigationController) }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MostrarPantallaInicio() {
    PantallaInicio(null)
}

@Composable
fun PantallaInicio(navigationController: NavHostController?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorFondo)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "Trabajo Práctico N°2",
            fontSize = 35.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 40.dp),
            fontWeight = FontWeight.Bold,
            color = colorTitulo
        )

        // Logo de la facultad
        Image(
            painter = painterResource(id = R.drawable.logo_facultad),
            contentDescription = "Logo Facultad",
            modifier = Modifier.size(380.dp),
            contentScale = ContentScale.FillBounds
        )

        // Espacio entre logo y botones
        Spacer(modifier = Modifier.padding(24.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { navigationController?.navigate(Routes.PantallaGame.route) },
                colors = ButtonDefaults.buttonColors(containerColor = colorBoton),
                modifier = Modifier
                    .width(130.dp)
                    .height(45.dp))  {
                Text(text = "Juego",
                    fontSize = 18.sp)
            }
            Button(onClick = { navigationController?.navigate(Routes.PantallaCapitals.route) },
                modifier = Modifier.width(130.dp).height(45.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorBoton)){
                Text(text = "Capital",
                    fontSize = 18.sp)
            }
        }
    }
}