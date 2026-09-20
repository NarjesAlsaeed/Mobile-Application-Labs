package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.AndroidGreen
import com.example.lab2.ui.theme.Navy
import com.example.lab2.ui.theme.ScreenBackground

@Composable
fun StudentIdScreen() {
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
                text = "Student ID",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 7 - Row & Column",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Navy),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "NA",
                        color = AndroidGreen,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Narjes AlSaeed",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Computer Science",
                        color = Color.Gray
                    )

                    Text(
                        text = "2240001195",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 12.sp
                    )

                    Row {
                        Text(
                            text = "Level 6",
                            color = AndroidGreen,
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "CSHJ",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            HorizontalDivider()
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem("4.42", "GPA")
                StatItem("78", "Credits")
                StatItem("Active", "Status")
            }
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            color = Color.Gray,
            fontSize = 11.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StudentIdScreenPreview() {
    StudentIdScreen()
}