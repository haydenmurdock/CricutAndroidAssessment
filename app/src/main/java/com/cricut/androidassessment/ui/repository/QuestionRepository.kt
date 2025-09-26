package com.cricut.androidassessment.ui.repository



import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
In a perfect project, the process would be the following:
 The questions would be in a server and we would make an api call to get them during the application launch.
Next we would put the questions into an array or Dict on Repo as a source of true.
After we would use the viewModel to decide what type of U.I. to display from the repo. e.g. true or false, multiple choice, etc...
from there we would track users answers and save them via room. If needed we would send answers to api if need under a userId.

I'm not sure on the depth you want in this test, but thought I would make my intentions clear on what I would have done given more time
*/




interface QuestionRepository {
    fun observeQuestions(id: String): Flow<String>
    fun getQuestions()
}
class QuestionRepositoryImpl @Inject constructor(
   // private val api: QuestionApi,
    //private val questionDao: QuestionDao
): QuestionRepository {
    var questions: MutableList<String> = mutableListOf()
    override fun observeQuestions(id: String): Flow<String> {

        return TODO("Provide the return value")
    }

    override fun getQuestions() {
        }
}


