package com.cricut.androidassessment.ui.screens
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val uiState:String = viewModel.prompt.collectAsState().value

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
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.size(16.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Button(
                onClick = onTrueClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF)),
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(id = R.string.True_String))
            }

            Button(
                onClick = onFalseClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF)),
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
