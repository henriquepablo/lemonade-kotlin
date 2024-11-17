package com.lacerda.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lacerda.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    Lemonade(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(value = 1) }

    val random = (2..4).random()
    var count = 1;

    val imageLemon = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    val text = when (result) {
        1 -> R.string.text_1
        2 -> R.string.text_2
        3 -> R.string.text_3
        4 -> R.string.text_4
        else -> R.string.text_1
    }

    Column (
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Text (
            text = stringResource(R.string.title),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .background(color = colorResource(R.color.background_title))
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
    }

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box (
            modifier = modifier
                .clip(RoundedCornerShape(32.dp))
                .clickable {
                    when (result) {
                        1 -> result++
                        2 -> {
                            if (count != random) count++
                            else result++
                        }

                        3 -> result++
                        4 -> result = 1
                    }
                }
        ) {
            Image (
                painter = painterResource(imageLemon),
                contentDescription = imageLemon.toString(),
                modifier = modifier
                    .background(color = colorResource(R.color.background_image))
                    .padding(16.dp)
            )
        }

        Text (
            text = stringResource(text),
            modifier = modifier.padding(top = 16.dp)
        )
    }
}
