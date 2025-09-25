package com.cricut.androidassessment.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cricut.androidassessment.ui.theme.AndroidAssessmentTheme


@Composable
fun AssessMultipleChoiceScreen(
    navController: NavController,
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            BackButton {
                navController.navigate("AssessTrueFalseScreen")
            }
            ChoiceUI(
                "What food is the current OS named after?",
                onButtonOneClick = {
                    println("User touched option 1")
                },
                onButtonTwoClick = {
                    println("User touched option 2")
                },
                onButtonThreeClick = {
                    println("User touched option 3")
                },
                onButtonFourClick = {
                    println("User touched option 4")
                }
            )
        }

}

@Composable
fun ChoiceUI(
    question: String,
    onButtonOneClick: () -> Unit,
    onButtonTwoClick: () -> Unit,
    onButtonThreeClick: () -> Unit,
    onButtonFourClick: () -> Unit,
) {
            Column(
                modifier = Modifier
                    .fillMaxWidth().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text = question,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                val backgroundColor =  Color.Blue
                Button(
                    onClick = onButtonOneClick,
                    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Oreo")
                }
                Button(
                    onClick = onButtonTwoClick,
                    colors = ButtonDefaults.buttonColors(containerColor =  backgroundColor),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Baklava")
                }
                Button(
                    onClick = onButtonThreeClick,
                    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("ice cream sandwich")
                }
                Button(
                    onClick = onButtonFourClick,
                    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Pizza roll")
                }
            }
    }

@Composable
fun BackButton(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        contentAlignment = Alignment.TopStart
        // lock to top-left
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    private fun PreviewMultipleChoiceScreen() {
        AndroidAssessmentTheme {
            val navController = rememberNavController()
            AssessMultipleChoiceScreen(navController)
        }
    }