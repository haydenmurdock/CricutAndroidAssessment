package com.cricut.androidassessment.ui.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AssessViewModel @Inject constructor(
    //private val repository: QuestionRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val userId: String = savedStateHandle["userId"] ?: "default"
    private val _uiState = MutableStateFlow<String>("You can create Android SDK's in C#")
    val prompt: StateFlow<String> = _uiState.asStateFlow()

}



