package com.example.thindie.surftrainee.di

import com.example.thindie.surftrainee.data.repository.CocktailAppRepositoryImpl
import com.example.thindie.surftrainee.domain.ConcreteCocktailRepository
import com.example.thindie.surftrainee.domain.RepositoryCocktails
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindRepositoryCocktails(impl: CocktailAppRepositoryImpl): RepositoryCocktails

    @Binds
    fun bindRepoCocktail(impl: CocktailAppRepositoryImpl): ConcreteCocktailRepository
}