package com.example.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.example.components.ui.theme.ComponentsTheme

class FloatingActionButtonComponent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FloatingButtonExample()
                }
            }
        }
    }
}

// General floating action button
@Composable
fun FloatingButtonExample() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Floating action button.")
    }
}

// Small floating action button
@Composable
fun SmallFloatingButtonExample() {
    SmallFloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Small floating action button.")
    }
}

// Large floating action button
@Composable
fun LargeFloatingButtonExample() {
    LargeFloatingActionButton(
        onClick = { /*TODO*/ },
        shape = CircleShape
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Large floating action button")
    }
}

// Extended button
@Composable
fun ExtendedExample() {
    ExtendedFloatingActionButton(text = { Text(text = "Extended Tab") }, icon = {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "Extended floating action button"
        )
    }, onClick = { /*TODO*/ })
}

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonPreview() {
    ComponentsTheme {
        ExtendedExample()
    }
}