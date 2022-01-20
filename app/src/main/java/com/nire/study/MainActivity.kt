package com.nire.study

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nire.study.ui.theme.StudyTheme

class MainActivity : ComponentActivity() {
    // Dz: Игра кликер, которая меняет изображения на экране после 5, 10 и 20 кликов
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lesson = Lesson("Jetpack Compose", "Pavlov Viktor")
        setContent {
            StudyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val scrollState = ScrollState(0)
                    Column(modifier = Modifier.verticalScroll(scrollState)) {
                        LessonTitle(lesson = lesson)
                        CardDemo("First")
                        CardDemo("Second")
                        CardDemo("Third")
                        CardDemo("First")
                        CardDemo("Second")
                        CardDemo("Third")
                        CardDemo("First")
                        CardDemo("Second")
                        CardDemo("Third")
                        CardDemo("First")
                        CardDemo("Second")
                        CardDemo("Third")
                        CardDemo("First")
                        CardDemo("Second")
                        CardDemo("Third")
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "logo"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CardDemo(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W900, color = Color(
                                0xFF45B882
                            )
                        )
                    ) {
                        append("Title: $title")
                    }
                }
            )
            Text(
                buildAnnotatedString {
                    append("welcome to ")
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                    ) {
                        append("Jetpack Compose Playground")
                    }
                }
            )
            Text(
                buildAnnotatedString {
                    append("Now you are in the ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                        append("Card")
                    }
                    append(" section")
                }
            )
        }
    }
}


@Composable
fun DropdownDemo() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("A", "B", "C", "D", "E", "F")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        Text(
            items[selectedIndex], modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .background(
                    Color.Gray
                )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Red
                )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    val disabledText = if (s == disabledValue) {
                        " (Disabled)"
                    } else {
                        ""
                    }
                    Text(text = s + disabledText)
                }
            }
        }
    }
}

@Composable
fun LessonTitle(lesson: Lesson) {
    Text(text = "Theme: ${lesson.theme}")
    Text(text = "Teacher: ${lesson.teacherName}")
}
