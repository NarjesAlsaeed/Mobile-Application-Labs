package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.AndroidGreen
import com.example.lab2.ui.theme.Navy
import com.example.lab2.ui.theme.ScreenBackground

data class TeamTask(
    val id: Int,
    val title: String,
    val owner: String,
    val isDone: Boolean = false
)

@Composable
fun TeamTaskTracker() {

    val tasks = remember {
        mutableStateListOf(
            TeamTask(1, "Create database repository", "Sara", true),
            TeamTask(2, "Write project proposal", "Noura", true),
            TeamTask(3, "Design the login screen", "Reem"),
            TeamTask(4, "Set up Android Studio", "Narjes")
        )
    }

    val doneCount = tasks.count { it.isDone }
    val openCount = tasks.count { !it.isDone }
    val totalCount = tasks.size

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
                text = "Team Task Tracker",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 11 - Challenge",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Navy
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TaskStatItem(doneCount.toString(), "Done")
                TaskStatItem(openCount.toString(), "Open")
                TaskStatItem(totalCount.toString(), "Total")
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = tasks,
                key = { it.id }
            ) { task ->

                TaskRow(
                    task = task,
                    onToggle = {
                        val index = tasks.indexOfFirst {
                            it.id == task.id
                        }

                        if (index != -1) {
                            tasks[index] = task.copy(
                                isDone = !task.isDone
                            )
                        }
                    }
                )
            }
        }

        Button(
            onClick = {
                val nextId =
                    (tasks.maxOfOrNull { it.id } ?: 0) + 1

                tasks.add(
                    TeamTask(
                        id = nextId,
                        title = "New task",
                        owner = "Narjes"
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AndroidGreen
            )
        ) {
            Text("+ Add task")
        }
    }
}

@Composable
fun TaskRow(
    task: TeamTask,
    onToggle: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    onToggle()
                }
            )

            Column {
                Text(
                    text = task.title,
                    fontWeight = FontWeight.Bold,
                    textDecoration =
                        if (task.isDone)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                    color =
                        if (task.isDone)
                            Color.Gray
                        else
                            Color.Black
                )

                Text(
                    text = task.owner,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun TaskStatItem(
    value: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            color = AndroidGreen,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            color = Color.White,
            fontSize = 11.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TeamTaskTrackerPreview() {
    TeamTaskTracker()
}