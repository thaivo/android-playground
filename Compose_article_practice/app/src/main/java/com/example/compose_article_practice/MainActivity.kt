package com.example.compose_article_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_article_practice.ui.theme.Compose_article_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_article_practiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeArticle(
                        header = stringResource(R.string.compose_article_header),
                        paragraph1 = stringResource(R.string.compose_article_paragraph_1),
                        paragraph2 = stringResource(R.string.compose_article_paragraph_2),
                        image = painterResource(R.drawable.bg_compose_background),
                        imageDescription = stringResource(R.string.compose_article_image_content_desc),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(header: String, paragraph1: String, paragraph2: String, image: Painter, imageDescription: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = imageDescription,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = header,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = paragraph1,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paragraph2,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_article_practiceTheme {
        ComposeArticle(
            header = stringResource(R.string.compose_article_header),
            paragraph1 = stringResource(R.string.compose_article_paragraph_1),
            paragraph2 = stringResource(R.string.compose_article_paragraph_2),
            image = painterResource(R.drawable.bg_compose_background),
            imageDescription = stringResource(R.string.compose_article_image_content_desc)
        )
    }
}
