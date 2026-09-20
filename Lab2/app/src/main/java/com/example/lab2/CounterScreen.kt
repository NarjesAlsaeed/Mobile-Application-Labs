package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.AndroidGreen
import com.example.lab2.ui.theme.Navy
import com.example.lab2.ui.theme.ScreenBackground

@Composable
fun AttendanceCounter() {
    var count by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(16.dp)
        ) {
            Text(
                text = "Attendance Counter",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 8 - Remember & State",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "STUDENTS PRESENT",
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            Card(
                modifier = Modifier
                    .width(170.dp)
                    .height(120.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = count.toString(),
                        fontSize = 52.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Button(
                    onClick = {
                        if (count > 0) count--
                    },
                    enabled = count > 0
                ) {
                    Text("-")
                }

                Button(
                    onClick = {
                        count++
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AndroidGreen
                    )
                ) {
                    Text("+")
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    count = 0
                },
                enabled = count > 0
            ) {
                Text("Reset")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = if (count == 0)
                    "Tap + to check a student in."
                else
                    "$count of 30 students checked in.",
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceCounterPreview() {
    AttendanceCounter()
}