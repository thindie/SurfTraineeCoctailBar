package com.example.thindie.surftrainee.data.localsource

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val COCKTAILS = "cocktails"

@Entity(tableName = COCKTAILS)
data class CocktailDbModel(
    val name: String,
    val recipe: String,
    val description: String,
    val cocktailParts: List<String>,
    val isHasPhoto: Boolean,
    val photoPath: String,
    @PrimaryKey
    val timeStamp: Long = System.currentTimeMillis(),
)