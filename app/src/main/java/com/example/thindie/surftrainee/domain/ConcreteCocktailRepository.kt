package com.example.thindie.surftrainee.domain

interface ConcreteCocktailRepository {

    suspend fun removeCocktail(name: String)
    suspend fun addCocktail(cocktail: Cocktail)
    suspend fun getConcreteCocktail(): Cocktail
}