package com.adolfosalado.javapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val idUser: Int,

    val level: Int,
)
