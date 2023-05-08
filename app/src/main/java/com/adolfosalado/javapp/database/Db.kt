package com.adolfosalado.javapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adolfosalado.javapp.daos.*
import com.adolfosalado.javapp.models.*

@Database(
    entities = [User::class, Lesson::class, Question::class, Answer::class, Tool::class],
    version = 1
)
abstract class Db : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun lessonDao(): LessonDao
    abstract fun questionDao(): QuestionDao
    abstract fun answerDao(): AnswerDao
    abstract fun toolDao(): ToolDao

    companion object {
        @Volatile
        private var INSTANCE: Db? = null

        fun getDatabase(context: Context): Db {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Db::class.java,
                    "jav_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}


