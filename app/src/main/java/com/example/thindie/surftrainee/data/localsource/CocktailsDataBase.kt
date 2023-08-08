package com.example.thindie.surftrainee.data.localsource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [CocktailDbModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    BaseListConverter::class,
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getCocktailsDao(): CocktailsDao

}
