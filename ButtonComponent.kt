package com.example.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.components.ui.theme.ComponentsTheme

class ButtonComponent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonExample()
                }
            }
        }
    }
}

@Composable
fun ButtonExample() {
    Column {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Filled")
        }

        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text("Tonal")
        }

        OutlinedButton(onClick = { /*TODO*/ }) {
            Text("Outlined")
        }

        ElevatedButton(onClick = { /*TODO*/ }) {
            Text("Elevated")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text("Text Button")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ComponentsTheme {
        ButtonExample()
    }
}