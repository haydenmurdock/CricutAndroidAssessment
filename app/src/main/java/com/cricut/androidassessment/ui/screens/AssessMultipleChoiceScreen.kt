package com.cricut.androidassessment.ui.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cricut.androidassessment.ui.theme.AndroidAssessmentTheme
import com.cricut.androidassessment.ui.viewModels.AssessViewModel


@Composable
fun AssessMultipleChoiceScreen(
    navController: NavController,
    ) {
    val viewModel:AssessViewModel = viewModel()
    val multiChoicePrompt:String = viewModel.multiPrompt.collectAsState().value
         Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            BackButton {
                navController.navigate("AssessTrueFalseScreen")
            }
            ChoiceUI(
                multiChoicePrompt,
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
                val interactionSource = remember { MutableInteractionSource() }
                val isPressed by interactionSource.collectIsPressedAsState()
                val interactionSourceTwo = remember { MutableInteractionSource() }
                val isPressedTwo by interactionSourceTwo.collectIsPressedAsState()
                val interactionSourceThree= remember { MutableInteractionSource() }
                val isPressedThree by interactionSourceThree.collectIsPressedAsState()
                val interactionSourceFour = remember { MutableInteractionSource() }
                val isPressedFour by interactionSourceFour.collectIsPressedAsState()
                Text(
                    text = question,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    style = TextStyle.Default.copy(
                        lineBreak = LineBreak.Paragraph
                    )
                )
                val buttonColor =  Color.Blue
                Button(
                    onClick = onButtonOneClick,
                    colors =  if (isPressed)
                        ButtonDefaults.buttonColors(containerColor = Color.Green) else ButtonDefaults.buttonColors(containerColor = buttonColor) ,
                    interactionSource = interactionSource,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Oreo")
                }
                Button(
                    onClick = onButtonTwoClick,
                    colors = if (isPressedTwo)
                        ButtonDefaults.buttonColors(containerColor = Color.Green) else ButtonDefaults.buttonColors(containerColor = buttonColor),
                    interactionSource = interactionSourceTwo,
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Text("Baklava")
                }
                Button(
                    onClick = onButtonThreeClick,
                    colors = if (isPressedThree)
                        ButtonDefaults.buttonColors(containerColor = Color.Green) else ButtonDefaults.buttonColors(containerColor = buttonColor),
                    interactionSource = interactionSourceThree,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("ice cream sandwich")
                }
                Button(
                    onClick = onButtonFourClick,
                    colors= if (isPressedFour)
                        ButtonDefaults.buttonColors(containerColor = Color.Green) else ButtonDefaults.buttonColors(containerColor = buttonColor),
                    interactionSource = interactionSourceFour,
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
    ) {
        Button(
            onClick = onBackClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier.height(40.dp)
        ) {
            Text("Back", color = Color.Black)
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