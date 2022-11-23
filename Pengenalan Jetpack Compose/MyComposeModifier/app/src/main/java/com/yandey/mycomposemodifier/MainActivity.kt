package com.yandey.mycomposemodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.yandey.mycomposemodifier.ui.theme.MyComposeModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

data class User(
    val name: String
)

class UserPreviewParameterProvider : PreviewParameterProvider<User> {
    override val values: Sequence<User> = sequenceOf(
        User("Muhammad Rafi Triandi"),
        User("Rangga Madhipa Sutra Jiwa Cordosega Akre Askhala Mughal Iikhanat Akbar")
    )

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(@PreviewParameter(UserPreviewParameterProvider::class) user: User) {
    MyComposeModifierTheme {
        ContactCard(user = user)
    }
}

@Composable
fun ContactCard(user: User) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(4.dp))
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
                ContactPicture()
                ContactContent(user.name)
            }
        }
    }
}

@Composable
fun ContactPicture() {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = Color.Green),
        modifier = Modifier
            .size(48.dp)
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_person),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
fun ContactContent(name: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(6.dp), verticalArrangement = Arrangement.aligned(Alignment.CenterVertically)
    ) {
        Text(text = name, fontWeight = FontWeight.Bold)
        Text(text = "Online")
    }
}