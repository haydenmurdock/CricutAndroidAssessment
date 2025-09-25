package com.cricut.androidassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cricut.androidassessment.ui.screens.AssessMultipleChoiceScreen
import com.cricut.androidassessment.ui.screens.AssessTrueFalseScreen
import com.cricut.androidassessment.ui.viewModels.AssessViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppNavHost(navController)
        }
    }
}
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "AssessTrueFalseScreen") {
        composable("AssessTrueFalseScreen") { AssessTrueFalseScreen(navController) }
        composable("AssessMultipleChoiceScreen") {AssessMultipleChoiceScreen(navController) }
    }
}
