package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    BusinessCard(modifier = Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().background(colorResource(R.color.teal_200)).padding(5.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth().weight(7f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier.size(120.dp).background(Color.DarkGray)
            )
            Spacer(Modifier.size(16.dp))
            Text(
                text = "Nguyen Thai Vo",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.size(5.dp))
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 15.sp
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            Column() {
                Row(
                    modifier = Modifier.weight(1f),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_contact_phone_24),
                        contentDescription = null,
                        Modifier.size(width = 16.dp, height = 16.dp).align(Alignment.CenterVertically)

                    )
                    Text(
                        text = "+84 123 456 789",
                        modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterVertically),
                        fontSize = 15.sp
                    )
                }
                Row(
                    modifier = Modifier.weight(1f),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.outline_all_inclusive_24),
                        contentDescription = null,
                        Modifier.size(width = 16.dp, height = 16.dp).align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "@AndroidDev",
                        modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterVertically),
                        fontSize = 15.sp
                    )
                }
                Row(
                    modifier = Modifier.weight(1f),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.outline_alternate_email_24),
                        contentDescription = null,
                        Modifier.size(width = 16.dp, height = 16.dp).align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "email.addr@domain.com",
                        modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterVertically),
                        fontSize = 15.sp
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}