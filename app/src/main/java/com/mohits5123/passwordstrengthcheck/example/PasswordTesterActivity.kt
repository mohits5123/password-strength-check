package com.mohits5123.passwordstrengthcheck.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohits5123.passwordstrengthcheck.PasswordChecker

class PasswordTesterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { Surface(modifier = Modifier.fillMaxSize()) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(
                start = 25.dp,
                end = 25.dp,
                top = 25.dp
            )
            .verticalScroll(rememberScrollState())
    ) {
        var textState = remember { mutableStateOf("") }
        var strength = remember { mutableStateOf("") }

        TextField(
            value = textState.value,
            onValueChange = {
                textState.value = it
                strength.value = PasswordChecker().getPasswordStrength(textState.value).toString()
            }
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "Strength = ${strength.value}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Greeting()
    }
}