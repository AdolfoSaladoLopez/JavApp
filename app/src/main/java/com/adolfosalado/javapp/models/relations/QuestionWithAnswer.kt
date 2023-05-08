package com.adolfosalado.javapp.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.adolfosalado.javapp.models.Answer
import com.adolfosalado.javapp.models.Question

data class QuestionWithAnswer(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "questionId",
        entityColumn = "questionId"
    )
    val answers: List<Answer>
)
