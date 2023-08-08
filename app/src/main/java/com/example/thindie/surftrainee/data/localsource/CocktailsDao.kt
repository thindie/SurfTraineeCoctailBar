package com.example.thindie.surftrainee.data.localsource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

private const val COCKTAILS = "cocktails"

@Dao
interface CocktailsDao {
    @Query("SELECT * FROM $COCKTAILS ORDER BY timeStamp DESC")
    fun getAllCocktails(): Flow<List<CocktailDbModel>>

    @Query("SELECT * FROM $COCKTAILS WHERE name=:name LIMIT 1")
    suspend fun getConcreteCocktail(name: String): CocktailDbModel

    @Upsert
    suspend fun upsertCocktails(things: List<CocktailDbModel>)

    @Upsert
    suspend fun upsertCocktail(cocktailDbModel: CocktailDbModel)

    @Delete
    suspend fun deleteCocktail(cocktailDbModel: CocktailDbModel)
}

