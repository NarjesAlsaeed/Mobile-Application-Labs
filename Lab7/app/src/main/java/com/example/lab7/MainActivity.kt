package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab7.ui.theme.Lab7Theme
import com.example.lab7.ui.CourseRatingRoute
import com.example.lab7.ui.CampusNewsRoute

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.lab7.ui.CourseRatingRoute
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->



                    var showNews by remember { mutableStateOf(true) }


                    if (showNews) {
                        CampusNewsRoute(
                            onBackClick = { showNews = false },
                            modifier = Modifier.padding(innerPadding)
                        )
                    } else {
                        Column(
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            CourseRatingRoute(
                                code = "CSC 402",
                                modifier = Modifier.weight(1f)
                            )

                            Button(
                                onClick = { showNews = true }
                            ) {
                                Text("Go to Campus News")
                            }
                        }
                    }





                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab7Theme {
        Greeting("Android")
    }
}