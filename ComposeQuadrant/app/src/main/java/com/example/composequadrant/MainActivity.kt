package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposableLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//val globalModifier = Modifier.fillMaxSize()

@Composable
fun ComposableLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        val reusableColumnModifier = Modifier.fillMaxSize().weight(1f)
        Row(
            modifier = reusableColumnModifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val reusableRowModifier = Modifier.fillMaxSize().weight(1f)
            ComposableCard(
                category = stringResource(R.string.text_str),
                type = stringResource(R.string.composable_str),
                definition = stringResource(R.string.text_def_str),
                modifier = reusableRowModifier.background(colorResource(R.color.first_quad))
            )
            ComposableCard(
                category = stringResource(R.string.image_str),
                type = stringResource(R.string.composable_str),
                definition = stringResource(R.string.image_def_str),
                modifier = reusableRowModifier.background(colorResource(R.color.second_quad))
            )
        }
        Row(
            modifier = reusableColumnModifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val reusableRowModifier = Modifier.fillMaxSize().weight(1f)
            ComposableCard(
                category = stringResource(R.string.row_str),
                type = stringResource(R.string.composable_str),
                definition = stringResource(R.string.row_def_str),
                modifier = reusableRowModifier.background(colorResource(R.color.third_quad))
            )
            ComposableCard(
                category = stringResource(R.string.col_str),
                type = stringResource(R.string.composable_str),
                definition = stringResource(R.string.col_def_str),
                modifier = reusableRowModifier.background(colorResource(R.color.fourth_quad))
            )
        }
    }
}

@Composable
fun ComposableCard(category: String, type: String, definition: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "$category $type",
            fontWeight = FontWeight.Bold
//            modifier = modifier.padding(bottom = 16.dp)
        )
        // I assume that the Text composable would set default font size without passing its size
        Text(
            text = definition,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposableLayout()
    }
}