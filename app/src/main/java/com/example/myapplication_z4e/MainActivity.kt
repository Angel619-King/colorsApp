import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication_z4e.ui.theme.MyApplication_Z4ETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            pantalla()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun pantalla() {
    var backgroundcolor by remember {
        mutableStateOf(Color.Transparent)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundcolor // Agrega el color de fondo aquí
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "App KNNZ",
                fontSize = 40.sp,
                color = Color.Black
            )
            Spacer(Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.height(50.dp)
            ) {
                var context = LocalContext.current
                ColorButton("Morado", Color.Magenta) {
                    backgroundcolor = it
                }

                ColorButton("Azul", Color.Blue) {
                    backgroundcolor = it
                }

                ColorButton("Rojo chido", Color.Red) {
                    backgroundcolor = it
                }

                ColorButton("Amarillo pollo XD", Color.Yellow) {
                    backgroundcolor = it
                }
            }
        }
    }
}

@Composable
fun ColorButton(text: String, backgroundColor: Color, onColorSelected: (Color) -> Unit) {
    Button(
        onClick = { onColorSelected(backgroundColor) },
        modifier = Modifier
            .background(backgroundColor)
            .padding(5.dp)
            .width(100.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 15.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPreview() {
    MyApplication_Z4ETheme {
        pantalla()
    }
}
