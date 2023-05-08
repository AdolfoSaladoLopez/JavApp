package com.adolfosalado.javapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lesson(
    @PrimaryKey(autoGenerate = true)
    val lessonId: Int,
    val nameOfLesson: String,
    val firstDescription: String,
    val firstImage: Int?,
    val secondDescription: String,
    val secondImage: Int?,
    val thirdDescription: String?,
    val requiredLevel: Int,
    val isCompleted: Boolean,
    val userId: Int

)
