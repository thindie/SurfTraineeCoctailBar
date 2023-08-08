package com.example.thindie.surftrainee.domain

import kotlinx.coroutines.flow.Flow


interface RepositoryCocktails {
    fun getCocktails(): Flow<List<Cocktail>>

    suspend fun getCocktail(name: String)
}