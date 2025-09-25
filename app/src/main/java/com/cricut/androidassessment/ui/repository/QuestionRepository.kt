package com.cricut.androidassessment.ui.repository



import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface QuestionRepository {
    fun observeQuestions(id: String): Flow<String>
    fun getQuestions()
}
class QuestionRepositoryImpl @Inject constructor(
   // private val api: QuestionApi,
): QuestionRepository {
    override fun observeQuestions(id: String): Flow<String> {
        TODO("Not yet implemented")
    }

    override fun getQuestions() {
        TODO("Not yet implemented")
        }
    }


