package com.example.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.components.ui.theme.ComponentsTheme

class CardComponent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicCardExample()
                }
            }
        }
    }
}

// basic card example
@Composable
fun BasicCardExample() {
    Card {
        Text(text = "Hello, world")
    }
}

// filled card example
@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Filled Card",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

// elevated card example
@Composable
fun ElevatedCardExample() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Elevated card",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

// outlined card example
@Composable
fun OutlinedCardExample() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(width = 1.dp, color= Color.Black),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ) {
        Text(text = "Outlined",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ComponentsTheme {
        OutlinedCardExample()
    }
}