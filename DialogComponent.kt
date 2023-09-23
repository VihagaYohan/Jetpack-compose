package com.example.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.components.ui.theme.ComponentsTheme

class DialogComponent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Dialog()
                }
            }
        }
    }
}

@Composable
fun Dialog() {
    // state
    var openAlertDialog by remember { mutableStateOf(true) }

    when {
        openAlertDialog == true -> {
            AlertDialogExample(
                onDismissRequest = { openAlertDialog = false },
                onConfirmation = {
                    openAlertDialog = true
                    println("Confirmation registerec")
                },
                dialogTitle = "Alert dialog example",
                dialogText = "This is an example of an alert dialog with dialog",
                icon = Icons.Default.Info
            )
        }
    }
}

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(onClick = { onConfirmation() }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text(text = "Dismiss")
            }
        },
        icon = {
            Icon(imageVector = icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
    )
}

@Composable
fun BasicExample() {
    androidx.compose.ui.window.Dialog(onDismissRequest = { /*TODO*/ }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "This is a minimal dialog",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun AdvancedExample() {
    androidx.compose.ui.window.Dialog(onDismissRequest = { /*TODO*/ }) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "image content description",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(8.dp)
                )

                Text(
                    text = "This is a dialog with buttons and an image",
                    modifier = Modifier.padding(16.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
                        Text(text = "Dissmiss")
                    }

                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
                        Text(text = "Confirm")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogPreview() {
    ComponentsTheme {
        AdvancedExample()
    }
}