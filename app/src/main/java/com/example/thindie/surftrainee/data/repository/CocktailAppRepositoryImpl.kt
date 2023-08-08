package com.example.thindie.surftrainee.data.repository

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.thindie.surftrainee.data.localsource.CocktailsDao
import com.example.thindie.surftrainee.data.toCocktail
import com.example.thindie.surftrainee.data.toCocktailDbModel
import com.example.thindie.surftrainee.domain.Cocktail
import com.example.thindie.surftrainee.domain.ConcreteCocktailRepository
import com.example.thindie.surftrainee.domain.RepositoryCocktails
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
@Singleton
class CocktailAppRepositoryImpl @Inject constructor(private val cocktailsDao: CocktailsDao) :
    ConcreteCocktailRepository, RepositoryCocktails {

    private val cocktail = mutableStateOf(INITIAL_VALUE)
    override suspend fun getCocktail(name: String) {
        Log.d("SERVICE_TAG", name)
        cocktail.value = name
    }

    override suspend fun getConcreteCocktail(): Cocktail {
        Log.d("SERVICE_TAG_CONCRETE", cocktail.value)
        return cocktailsDao.getConcreteCocktail(cocktail.value).toCocktail()
    }


    override suspend fun removeCocktail(name: String) {
        cocktailsDao.deleteCocktail(cocktailsDao.getConcreteCocktail(name))
    }

    override suspend fun addCocktail(cocktail: Cocktail) {
        cocktailsDao.upsertCocktail(cocktail.toCocktailDbModel())
    }

    override fun getCocktails(): Flow<List<Cocktail>> {
        return cocktailsDao
            .getAllCocktails()
            .map { dbModelList -> dbModelList.map { it.toCocktail() } }
    }

    companion object {
        private const val INITIAL_VALUE = ""
    }
}