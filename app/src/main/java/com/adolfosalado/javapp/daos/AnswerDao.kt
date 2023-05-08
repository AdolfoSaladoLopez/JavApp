package com.adolfosalado.javapp.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.adolfosalado.javapp.models.Answer
import com.adolfosalado.javapp.models.relations.QuestionWithAnswer

@Dao
interface AnswerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswer(answer: Answer)

    @Update
    suspend fun updateAnswer(answer: Answer)

    @Query("SELECT * FROM Answer")
    suspend fun getAnswers(): List<Answer>

    @Query("SELECT * FROM Answer WHERE answerId = :answerId")
    suspend fun getAnswerById(answerId: Int): Answer

    @Transaction
    @Query("SELECT * FROM Answer WHERE questionId = :questionId")
    suspend fun getQuestionWithAnswer(questionId: Int): List<QuestionWithAnswer>


}