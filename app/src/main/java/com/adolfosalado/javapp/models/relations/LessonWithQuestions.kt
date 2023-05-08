package com.adolfosalado.javapp.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.adolfosalado.javapp.models.Lesson
import com.adolfosalado.javapp.models.Question

data class LessonWithQuestions(
    @Embedded val lesson: Lesson,
    @Relation(
        parentColumn = "lessonId",
        entityColumn = "lessonId"
    )
    val questions: List<Question>
)
