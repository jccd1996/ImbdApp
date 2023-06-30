package com.jccd.imbd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jccd.imbdapp.R
import com.jccd.imbdapp.ui.theme.ImbdAppTheme
import com.jccd.imbdapp.ui.theme.ImbdBackgroundYellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ImbdAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = ImbdBackgroundYellow
                ) {
                    Column( modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        LoginCard()
                        Spacer(modifier = Modifier.padding(vertical = 32.dp))
                        RegisterInfo()
                    }
                }
            }
        }
    }
}

@Composable
fun LoginCard() {
    val imageModifier = Modifier
        .size(150.dp)

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Image(
        painter = painterResource(id = R.drawable.imbd_logo),
        contentDescription = stringResource(id = R.string.accessibility_logo),
        modifier = imageModifier,
    )
    BasicTextField(
        modifier= Modifier.background(Color.White),
        value = user,
        onValueChange = { user = it },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    BasicTextField(
        value = password,
        modifier= Modifier.background(Color.White),

        onValueChange = { password = it },

        )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Button(onClick = { /*TODO*/ }) {
        Text("Login")
    }
}

@Composable
private fun RegisterInfo() {
    Text("O podes ingresar con")
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    SocialNetworks()
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Row() {
        Text("¿No tienes cuenta?")
        Text(fontWeight = FontWeight.Bold, text = " Registrate")
    }
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Text(fontWeight = FontWeight.Bold, text = "Continuar como invitado")

}

@Composable
private fun SocialNetworks() {
    val logosModifier = Modifier
        .padding(8.dp)
        .size(30.dp)
    val boxModifier = Modifier
        .background(Color.White, shape = CircleShape)
    Row(
    ) {
        Box(modifier = boxModifier) {
            Image(
                painter = painterResource(id = R.drawable.apple_logo),
                contentDescription = stringResource(id = R.string.accessibility_logo),
                modifier = logosModifier,
            )
        }

        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        Box(modifier = boxModifier) {
            Image(
                painter = painterResource(id = R.drawable.fb_logo),
                contentDescription = stringResource(id = R.string.accessibility_logo),
                modifier = logosModifier,
            )
        }

        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        Box(modifier = boxModifier) {
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = stringResource(id = R.string.accessibility_logo),
                modifier = logosModifier,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImbdAppTheme {
        LoginCard()
    }
}