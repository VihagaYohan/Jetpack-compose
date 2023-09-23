package com.example.components

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.components.ui.theme.ComponentsTheme

class ChipComponent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AssistChipExample()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistChipExample() {
    AssistChip(onClick = { Log.d("Assist chip", "hello world") }, label = {
        Text(text = "Assist chip")
    },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipExample() {
    var selected by remember { mutableStateOf(false) }

    FilterChip(selected = selected, onClick = { selected = !selected },
        label = {
            Text(text = "Filter chip")
        },
        leadingIcon = {
            if (selected) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done Icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            } else {
                null
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChipExample(text: String, onDismiss: () -> Unit) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = {
            Text(text = text)
        },
        avatar = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuggestionChipExample() {
    SuggestionChip(onClick = { Log.d("Suggestion chip", "Hello, world") }, label = {
        Text(text = "Suggestion chip")
    })
}

@Preview(showBackground = true)
@Composable
fun ChipPreview() {
    ComponentsTheme {
        SuggestionChipExample()
    }
}