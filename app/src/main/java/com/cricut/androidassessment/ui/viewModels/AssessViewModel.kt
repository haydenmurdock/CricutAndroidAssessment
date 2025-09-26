package com.cricut.androidassessment.ui.viewModels
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AssessViewModel @Inject constructor(
    //private val repository: QuestionRepository,
) : ViewModel() {
   // private val userId: String = savedStateHandle["userId"] ?: "default"
    private val _trueFalsePrompt = MutableStateFlow<String>("You can create Android SDK's in C#")
    private val _multipleChoicePrompt = MutableStateFlow<String>("What food is the current OS named after?")
    val tfPrompt: StateFlow<String> = _trueFalsePrompt.asStateFlow()
    val multiPrompt: StateFlow<String> = _multipleChoicePrompt.asStateFlow()

}



