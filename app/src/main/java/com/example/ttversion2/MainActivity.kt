package com.example.ttversion2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ttversion2.ui.theme.TTVERSION2Theme
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.window.Dialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TTVERSION2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    var showOnbordingScreen by rememberSaveable { mutableStateOf(true) }

    if(showOnbordingScreen){
        OnboardingScreen(OnContinueClicked = {showOnbordingScreen = false})
    }else{
        TTApp()
    }
}

@Composable
fun OnboardingScreen(OnContinueClicked: () -> Unit,modifier: Modifier=Modifier,){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.onboardingscreenlogo),
            contentDescription = "logo",
            Modifier
                .height(300.dp)
                .padding(end = 70.dp)
        )
        Text(
            text = "Welcome to the TT Tracker",
            color = Color.White,
            modifier = Modifier.padding(top = 10.dp),
            style = MaterialTheme.typography.titleMedium,
            fontStyle = FontStyle.Italic
        )
        Button(onClick = OnContinueClicked,modifier.padding(10.dp)) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun TTApp(
    modifier: Modifier=Modifier,
    names :List<String> = listOf("Aryan","Mistuu","Paras","Akshay","Samar","Chicki","Arman","Mohit","Ayush","Ayushi")
){
    LazyColumn(modifier.systemBarsPadding()) {
        items(names){ name->
            TT(name = name)
        }
    }
}

@Composable
fun TT(name:String,modifier: Modifier=Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var showDialog by rememberSaveable { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(text = name)
                if (expanded) {
                    Text(
                        text = when (name) {
                            "Aryan" -> "Aryan's timetable is here you can check"
                            "Mistuu" -> "Mistuu's timetable is here you can check"
                            "Paras" -> "Paras's timetable is here you can check"
                            "Akshay" -> "Akshay's timetable is here you can check"
                            "Samar" -> "Samar's timetable is here you can check"
                            "Arman" -> "Arman's timetable is here you can check"
                            "Chicki" -> "Chicki's timetable is here you can check"
                            "Ayushi" -> "Ayushi's timetable is here you can check"
                            "Mohit" -> "Mohit's timetable is here you can check"
                            else -> "Nothing to show"

                        }
                    )
                    Image(painter = painterResource(
                        id = when (name) {
                            "Aryan" -> R.drawable.aryantt
                            "Mistuu" -> R.drawable.mistuutt
                            "Samar" -> R.drawable.samartt
                            "Arman" -> R.drawable.armantt
                            "Chicki" -> R.drawable.chickkitt
                            "Ayushi" -> R.drawable.ayushitt
                            "Akshay" -> R.drawable.screenshot_2025_02_05_at_12_48_40pm
                            "Paras" -> R.drawable.parastt
//                            "Ayush" -> R.drawable.
                            else -> R.drawable.ic_launcher_foreground
                        }
                    ), contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showDialog = true }
                    )
                }
                if (showDialog) {
                    Dialog(onDismissRequest = { showDialog = false }) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(
                                    id = when (name) {
                                        "Aryan" -> R.drawable.aryantt // Replace with your actual drawable resource
                                        "Mistuu" -> R.drawable.mistuutt
                                        "Samar" -> R.drawable.samartt
                                        "Arman" -> R.drawable.armantt
                                        "Ayushi" -> R.drawable.ayushitt
                                        "Akshay" -> R.drawable.screenshot_2025_02_05_at_12_48_40pm
                                        "Paras" -> R.drawable.parastt
                                        "Chicki" -> R.drawable.chickkitt
//                                        "Ayush" -> R.drawable.
                                        else -> R.drawable.ic_launcher_foreground
                                    }
                                ),
                                contentDescription = "Zoomed image for $name",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.9f) // Scale the image within the dialog
                                    .clickable { showDialog = false } // Close dialog on image tap
                            )
                        }
                    }
                }
            }
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Filled.ExpandLess else Filled.ExpandMore,
                        contentDescription = null
                    )
                }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    TTVERSION2Theme {
        OnboardingScreen(OnContinueClicked = {})
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TTPreview() {
    TTVERSION2Theme {
       TTApp()
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyAppPreview() {
    TTVERSION2Theme {
        MyApp()
    }
}