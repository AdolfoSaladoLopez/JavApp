package com.adolfosalado.javapp.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.adolfosalado.javapp.models.Tool
import com.adolfosalado.javapp.models.relations.LessonWithTool
import com.adolfosalado.javapp.models.relations.UserWithTools

@Dao
interface ToolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTool(tool: Tool)

    @Update
    suspend fun updateTool(tool: Tool)

    @Query("SELECT * FROM Tool")
    suspend fun getTools(): List<Tool>

    @Query("SELECT * FROM Tool WHERE toolId = :toolId")
    suspend fun getToolById(toolId: Int): Tool

    @Transaction
    @Query("SELECT * FROM Tool WHERE userId = :userId")
    suspend fun getToolsByUser(userId: Int): List<UserWithTools>

    @Transaction
    @Query("SELECT * FROM Tool WHERE lessonId = :lessonId")
    suspend fun getToolByLesson(lessonId: Int): List<LessonWithTool>
}