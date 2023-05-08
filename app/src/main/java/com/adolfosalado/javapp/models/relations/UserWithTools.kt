package com.adolfosalado.javapp.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.adolfosalado.javapp.models.Tool
import com.adolfosalado.javapp.models.User

data class UserWithTools(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val tools: List<Tool>
)
