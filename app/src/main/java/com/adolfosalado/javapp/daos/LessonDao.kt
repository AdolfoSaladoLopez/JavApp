package com.adolfosalado.javapp.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.adolfosalado.javapp.models.Lesson
import com.adolfosalado.javapp.models.relations.LessonWithQuestions
import com.adolfosalado.javapp.models.relations.UserWithLessons

@Dao
interface LessonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLesson(lesson: Lesson)

    @Update
    suspend fun updateLesson(lesson: Lesson)

    @Query("SELECT * FROM Lesson")
    suspend fun getLessons(): List<Lesson>

    @Query("SELECT * FROM Lesson WHERE lessonId = :lessonId")
    suspend fun getLessonById(lessonId: Int): Lesson

    @Query("SELECT * FROM Lesson WHERE isCompleted = 1")
    suspend fun getLessonCompleted(): List<Lesson>

    @Query("SELECT * FROM Lesson WHERE isCompleted = 0")
    suspend fun getLessonNotCompleted(): List<Lesson>

    @Transaction
    @Query("SELECT * FROM Lesson WHERE lessonId = :lessonId")
    suspend fun getLessonWithQuestions(lessonId: Int): List<LessonWithQuestions>

    @Transaction
    @Query("SELECT * FROM Lesson WHERE userId = :userId")
    suspend fun getUserWithLessons(userId: Int): List<UserWithLessons>
}