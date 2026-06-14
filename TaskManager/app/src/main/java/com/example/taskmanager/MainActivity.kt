package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface ( modifier = Modifier.fillMaxSize() ) {
                    CompletingTask()
                }
            }
        }
    }
}

@Composable
fun CompletingTask(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        CompletedImage()
        CompletedTextOne(content = stringResource(R.string.all_task_completed_text))
        CompletedTextTwo(content = stringResource(R.string.nice_work_text))
    }

}

@Composable
fun CompletedImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.ic_task_completed),
        contentDescription = null
    )
}

@Composable
fun CompletedTextOne(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun CompletedTextTwo(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content,
        fontSize = 16.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        CompletingTask(
            modifier = Modifier.fillMaxSize()
        )
    }
}