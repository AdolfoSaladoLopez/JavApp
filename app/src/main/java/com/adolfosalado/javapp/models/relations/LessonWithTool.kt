package com.adolfosalado.javapp.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.adolfosalado.javapp.models.Lesson
import com.adolfosalado.javapp.models.Tool

data class LessonWithTool(
    @Embedded val lesson: Lesson,
    @Relation(
        parentColumn = "lessonId",
        entityColumn = "lessonId"
    )
    val tool: Tool
)
