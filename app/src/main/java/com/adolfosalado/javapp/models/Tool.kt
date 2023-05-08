package com.adolfosalado.javapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Tool(
    @PrimaryKey(autoGenerate = true)
    var toolId: Int,

    var nameOfTool: String,
    var dateObtained: Date?,
    var imageOfTool: Int?,

    var userId: Int?,
    var lessonId: Int

)
