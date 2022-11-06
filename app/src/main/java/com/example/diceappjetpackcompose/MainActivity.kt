package com.example.diceappjetpackcompose

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceappjetpackcompose.ui.theme.DiceAppJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceAppJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceWithButton(
                        Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun DiceWithButton(modifier: Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = when (result){
            1 -> painterResource(id = R.drawable.dice_1)
            2 -> painterResource(id = R.drawable.dice_2)
            3 -> painterResource(id = R.drawable.dice_3)
            4 -> painterResource(id = R.drawable.dice_4)
            5 -> painterResource(id = R.drawable.dice_5)
            else -> painterResource(id = R.drawable.dice_6)
        }
        Image(painter = image, contentDescription = "1")
        Spacer(Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random()}) {
            Text(text = stringResource(id = R.string.roll))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiceAppJetpackComposeTheme {
        DiceWithButton(
            Modifier
                .fillMaxSize()
        )
    }
}