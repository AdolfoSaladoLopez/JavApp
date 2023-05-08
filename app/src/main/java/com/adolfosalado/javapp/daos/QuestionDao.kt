package com.adolfosalado.javapp.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.adolfosalado.javapp.models.Question
import com.adolfosalado.javapp.models.relations.LessonWithQuestions
import com.adolfosalado.javapp.models.relations.QuestionWithAnswer

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question)

    @Update
    suspend fun updateQuestion(question: Question)

    @Query("SELECT * FROM Question")
    suspend fun getQuestions(): List<Question>

    @Query("SELECT * FROM Question WHERE questionId = :questionId")
    suspend fun getQuestionById(questionId: Int): Question

    @Transaction
    @Query("SELECT * FROM Question WHERE lessonId = :lessonId")
    suspend fun getQuestionByLessonId(lessonId: Int): List<LessonWithQuestions>

    @Transaction
    @Query("SELECT * FROM Question")
    suspend fun getQuestionsWithAnswers(): List<QuestionWithAnswer>

    @Transaction
    @Query("SELECT * FROM Question WHERE questionId = :questionId")
    suspend fun getQuestionWithAnswersById(questionId: Int): List<QuestionWithAnswer>
}