package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

data class Artwork(
    @get:DrawableRes val imageRes: Int,
    val title: String,
    val artist: String
)

val artworks = listOf(
    Artwork(R.drawable.amora, "Title 1", "Artist 1"),
    Artwork(R.drawable.anthropomorphic_happy_pear, "Title 2", "Artist 2"),
    Artwork(R.drawable.cute_dinosaur_cartoonish_1782068268, "Title 3", "Artist 3"),
    Artwork(R.drawable.fairytale_castle_1782068699, "Title 4", "Artist 4"),
    Artwork(R.drawable.kiwi, "Title 5", "Artist 5"),
    Artwork(R.drawable.newspapers_cup_of_tea_relax_1782413743, "Title 6", "Artist 6"),
    Artwork(R.drawable.nicubunu_pineapple, "Title 7", "Artist 7"),
    Artwork(R.drawable.pitr_bananas_icon_1, "Title 8", "Artist 8"),

)



@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    // option 1
    var currentArtworkIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = artworks[currentArtworkIndex].imageRes),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
//                .padding(12.dp)
                .weight(10f)
                .shadow(4.dp, shape = RoundedCornerShape(12.dp), ambientColor = colorResource(R.color.dark_blue), spotColor = colorResource(R.color.black))
//                .border(15.dp,
//                    color = colorResource(R.color.dark_blue),
//                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.weight(0.5f))
        Box(
            modifier = Modifier.weight(1.5f)
                .background(color = colorResource(R.color.dark_blue), shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                .wrapContentSize(unbounded = true)
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = artworks[currentArtworkIndex].title,
                color = Color.White,
                modifier = Modifier.wrapContentHeight(Alignment.CenterVertically)
//                    .padding(20.dp)
//                    .align(Alignment.TopCenter)
                        ,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.weight(0.5f))
        Box(
            modifier = Modifier.weight(1.5f)
                .background(color = colorResource(R.color.dark_blue), shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                .wrapContentSize(unbounded = true)
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = artworks[currentArtworkIndex].artist,
                color = Color.White,
                modifier = Modifier.wrapContentHeight(Alignment.CenterVertically),
                )
        }
        Spacer(modifier = Modifier.weight(0.5f))
        Row(
            modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    if (currentArtworkIndex > 0) {
                        currentArtworkIndex--
                    } else {
                        currentArtworkIndex = artworks.size - 1
                    }
                },
                modifier = Modifier.weight(2f)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    if (currentArtworkIndex in 0..(artworks.size - 2)) {
                        currentArtworkIndex++
                    } else {
                        currentArtworkIndex = 0
                    }
                },
                modifier = Modifier.weight(2f)
            ) {
                Text(text = "Next")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}