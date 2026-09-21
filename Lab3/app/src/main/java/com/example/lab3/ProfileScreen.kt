package com.example.lab3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    val students = listOf(
        Student(
            name = "Narjes Alsaeed",
            program = "Computer Science - Level 6",
            gpa = "4.62",
            email = "2240001195@iau.edu.sa",
            city = "Qatif"
        ),
        Student(
            name = "Sara Ahmed",
            program = "Computer Science - Level 6",
            gpa = "4.40",
            email = "sara@iau.edu.sa",
            city = "Jubail"
        ),
        Student(
            name = "Noura Ali",
            program = "Computer Science - Level 6",
            gpa = "4.35",
            email = "noura@iau.edu.sa",
            city = "Dammam"
        ),
        Student(
            name = "Reem Hassan",
            program = "Computer Science - Level 6",
            gpa = "4.20",
            email = "reem@iau.edu.sa",
            city = "Khobar"
        ),
        Student(
            name = "Layan Mohammed",
            program = "Computer Science - Level 6",
            gpa = "4.55",
            email = "layan@iau.edu.sa",
            city = "Jubail"
        )
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("My Profile")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit profile"
                )
            }
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Students")
                    Text("${students.size}")
                }
            }

            items(students) { student ->
                StudentCard(
                    student = student
                )
            }
        }
    }
}