package com.adolfosalado.javapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true)
    val questionId: Int,

    val titleOfQuestion: String,
    val imageOfQuestion: Int?,
    val lessonId: Int


)
