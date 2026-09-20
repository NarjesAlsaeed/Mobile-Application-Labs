package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.AndroidGreen
import com.example.lab2.ui.theme.Navy
import com.example.lab2.ui.theme.ScreenBackground

@Composable
fun CourseListScreen() {

    val courses = remember {
        listOf(
            Course(
                "CSC 402",
                "Mobile Application Programming",
                3,
                "Mon / Wed"
            ),
            Course(
                "CSC 311",
                "Database Systems",
                4,
                "Sun / Tue"
            ),
            Course(
                "CSC 340",
                "Operating Systems",
                3,
                "Mon / Wed"
            ),
            Course(
                "MATH 202",
                "Discrete Mathematics",
                3,
                "Sun / Thu"
            ),
            Course(
                "ENG 214",
                "Technical Writing",
                2,
                "Tue"
            ),
            Course(
                "PHYS 105",
                "General Physics II",
                4,
                "Sun / Tue"
            ),
            Course(
                "ISLM 101",
                "Islamic Culture",
                2,
                "Thu"
            )
        )
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
                text = "My Courses",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 10 - LazyColumn & data class",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        LazyColumn(
            modifier = Modifier.padding(12.dp),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(courses) { course ->
                CourseRow(course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Box(
                modifier = Modifier
                    .width(5.dp)
                    .height(60.dp)
                    .background(AndroidGreen)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = course.code,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = course.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = course.days,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            Text(
                text = "${course.credits} cr",
                color = AndroidGreen
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}