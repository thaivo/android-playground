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
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun ComposeArticleImage(contentDesc: String, modifer: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.bg_compose_background),
        contentDescription = contentDesc,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ComposeArticleTextParagraph(content: String, fontSize: Int, textAlign: TextAlign? = null, modifer: Modifier = Modifier) {
    Text(
        text = content,
        fontSize = fontSize.sp,
        modifier = modifer.padding(16.dp),
        textAlign = textAlign
    )
}

@Composable
fun ComposeArticle(header: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        ComposeArticleImage(contentDesc = "Background image")
        ComposeArticleTextParagraph(content = header, fontSize = 24)
        ComposeArticleTextParagraph(content = paragraph1, fontSize = 16, textAlign = TextAlign.Justify)
        ComposeArticleTextParagraph(content = paragraph2, fontSize = 16, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_article_practiceTheme {
        ComposeArticle(
            header = stringResource(R.string.compose_article_header),
            paragraph1 = stringResource(R.string.compose_article_paragraph_1),
            paragraph2 = stringResource(R.string.compose_article_paragraph_2)
        )
    }
}
