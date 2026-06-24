package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                lemonadeProcess()
            }
        }
    }
}

@Composable
fun lemonadeProcess(modifier: Modifier = Modifier) {
    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableIntStateOf(1) }
    var lemonSize by remember { mutableIntStateOf(0) }
    var squeezeCount by remember { mutableIntStateOf(0) }

    val (imageResource, imageContentDescription, instruction) = when (currentStep) {
        1 -> Triple(R.drawable.lemon_tree, R.string.lemon_tree_img_cd, R.string.lemon_tree_tap)
        2 -> Triple(R.drawable.lemon_squeeze, R.string.lemon_img_cd, R.string.lemon_tap)
        3 -> Triple(R.drawable.lemon_drink, R.string.glass_of_lemonade_img_cd, R.string.lemon_drink_tap)
        else -> Triple(R.drawable.lemon_restart, R.string.empty_glass_img_cd, R.string.empty_lemon_glass_tap)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(modifier = modifier.fillMaxSize().height(5.dp).weight(1f).background(Color.Yellow)){
            Text(
                text = stringResource(R.string.app_name),
                modifier = modifier.align(Alignment.Center),
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = modifier.weight(10f).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(imageContentDescription),
                modifier = modifier.background(
                    colorResource(R.color.accent_green) ,
                    shape = RoundedCornerShape(4.dp)
                ).border(width = 4.dp, color = Color(105, 205, 216), shape = RoundedCornerShape(4.dp)).clickable(
                    onClick = {
                        when (currentStep) {
                            1 -> {
                                currentStep = 2
                                lemonSize = (2..4).random()
                            }

                            2 -> {
                                squeezeCount++
                                lemonSize--
                                if (lemonSize == 0) {
                                    currentStep = 3
                                }
                            }

                            3 -> {
                                currentStep = 4
                            }

                            4 -> {
                                currentStep = 1
                                squeezeCount = 0
                            }
                        }
                    },
                ),

                )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = instruction),
                modifier = modifier,
                fontSize = 18.sp
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        lemonadeProcess()
    }
}