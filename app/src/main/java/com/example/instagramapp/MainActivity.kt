package com.example.instagramapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramapp.model.Story
import com.example.instagramapp.ui.theme.MyComposableApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposableApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    DefaultPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposableApplicationTheme {
        mainScreen()
    }
}

@Composable
fun mainScreen() {
    Column {
        StoriesSessionView(
            listOf(
                Story(R.drawable.user_1, "User01"),
                Story(R.drawable.user_2, "User02"),
                Story(R.drawable.user_3,"User03"),
                Story(R.drawable.user_4, "User04"),
                Story(R.drawable.user_5, "User05")
            )
        )
        feedContent()
    }
}

@Composable
fun StoriesSessionView(stories: List<Story>){
    LazyRow(
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(stories) { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(75.dp)
                        .width(75.dp)
                ) {
                    Image(
                        painterResource(id = item.imageId),
                        contentDescription = null,
                        modifier = Modifier.clip(CircleShape)
                    )
                }
                Text(
                    text = item.userName,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@Composable
fun feedContent() {
    Column {
        feedHeader()
        feedBody()
    }
}

@Composable
fun feedHeader() {
    Row(
        Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        ) {
            Image(
                painterResource(id = R.drawable.user_1),
                contentDescription = null,
                modifier = Modifier.clip(CircleShape)
            )
        }
        Column(Modifier.weight(1f)) {
            Text(
                text = "User01",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(8.dp)
            )
        }
        Icon(
            Icons.Rounded.MoreVert,
            contentDescription = null,
        )
    }
}

@Composable
fun feedBody() {
    Box {
        Image(
            painterResource(id = R.drawable.feed_image_1),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}