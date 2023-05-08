package com.adolfosalado.javapp.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.adolfosalado.javapp.models.Lesson
import com.adolfosalado.javapp.models.User

data class UserWithLessons(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val lessons: List<Lesson>
)
