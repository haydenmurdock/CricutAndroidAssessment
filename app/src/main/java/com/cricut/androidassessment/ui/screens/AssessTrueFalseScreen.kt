package com.cricut.androidassessment.ui.screens
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cricut.androidassessment.R
import com.cricut.androidassessment.ui.theme.AndroidAssessmentTheme
import com.cricut.androidassessment.ui.viewModels.AssessViewModel

@Composable
fun AssessTrueFalseScreen(
   navController: NavController,
) {
    val viewModel:AssessViewModel = viewModel()
    val uiState:String = viewModel.tfPrompt.collectAsState().value

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
    TrueFalseButtons(
    uiState,
    onTrueClick = {
        println("User picked True")
        navController.navigate("AssessMultipleChoiceScreen")
                  },
    onFalseClick = {
        println("User picked False")
        navController.navigate("AssessMultipleChoiceScreen")
        })
    }
}
@Composable
fun TrueFalseButtons(
    question: String,
    onTrueClick: () -> Unit,
    onFalseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = question,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            style = TextStyle.Default.copy(
                lineBreak = LineBreak.Paragraph
            )
        )
        Spacer(Modifier.size(16.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            val interactionSourceTrue = remember { MutableInteractionSource() }
            val isPressedTrue by interactionSourceTrue.collectIsPressedAsState()
            val interactionSourceFalse = remember { MutableInteractionSource() }
            val isPressedFalse by interactionSourceFalse.collectIsPressedAsState()
            Button(
                onClick = onTrueClick,
                colors =  if (isPressedTrue)
                    ButtonDefaults.buttonColors(containerColor = Color.Green) else ButtonDefaults.buttonColors(containerColor = Color.Blue) ,
                interactionSource = interactionSourceTrue,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(id = R.string.True_String))
            }
            val buttonColor =  Color.Blue
            Button(
                onClick = onFalseClick,
                colors =  if (isPressedFalse)
                    ButtonDefaults.buttonColors(containerColor = Color.Green) else ButtonDefaults.buttonColors(containerColor = buttonColor) ,
                interactionSource = interactionSourceFalse,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(id = R.string.False_String))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun PreviewAssessmentScreen() {
    AndroidAssessmentTheme {
        val navController = rememberNavController()
        AssessTrueFalseScreen(navController)
    }
}
