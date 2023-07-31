@file:OptIn(ExperimentalMaterial3Api::class)

package com.jccd.imbdapp.ui.register

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jccd.imbdapp.R
import com.jccd.imbdapp.ui.theme.ImbdAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ImbdAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        AppBar()
                        Box(modifier = Modifier.padding(horizontal = 48.dp)){
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {
                                smallLogo()
                                registerFields()
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun smallLogo(){
    val imageModifier = Modifier
        .width(90.dp)
        .height(100.dp)

    Image(
        painter = painterResource(id = R.drawable.imbd_logo),
        contentDescription = stringResource(id = R.string.accessibility_logo),
        modifier = imageModifier,
    )
}

@Composable
fun registerFields(){
    val sizeModifier = Modifier.fillMaxWidth()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Text(text = "Crear una cuenta")
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    TextField(
        value = name,
        singleLine = true,
        modifier = sizeModifier,
        label = { Text("Nombre") },
        onValueChange = { name = it },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    TextField(
        value = email,
        singleLine = true,
        modifier = sizeModifier,
        label = { Text("Correo electronico") },
        onValueChange = { email = it },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    TextField(
        value = password,
        singleLine = true,
        modifier = sizeModifier,
        label = { Text("Contraseña") },
        onValueChange = { password = it },
        placeholder = { Text("Password") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description)
            }
        }
        )
    Spacer(modifier = Modifier.padding(vertical = 6.dp))
    Text(
        fontSize = 12.sp,
        text = "La contraseña debe tener 8 caracteres")
    Spacer(modifier = Modifier.padding(vertical = 16.dp))
    Button(
        modifier = sizeModifier,
        onClick = {

    }) {
        Text("Aceptar")
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun AppBar() {
    val activity = (LocalContext.current as? Activity)
    TopAppBar(
        title = {

        },
        navigationIcon = {
            IconButton(onClick = {
                activity?.finish()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImbdAppTheme {
        Greeting("Android")
    }
}