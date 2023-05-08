package com.adolfosalado.javapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Answer(
    @PrimaryKey(autoGenerate = true)
    var answerId: Int,

    var titleOfAnswer: String,
    var isCorrect: Boolean,
    var questionId: Int
)
