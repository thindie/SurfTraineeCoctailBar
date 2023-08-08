package com.example.thindie.surftrainee.di

import android.app.Application
import androidx.room.Room
import com.example.thindie.surftrainee.data.localsource.AppDataBase
import com.example.thindie.surftrainee.data.localsource.CocktailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun provideCocktailDao(appDataBase: AppDataBase): CocktailsDao {
        return appDataBase.getCocktailsDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
 object DataBaseModule {
    @Provides
    @Singleton
    fun provideDataBase(application: Application): AppDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = AppDataBase::class.java,
            name = DB_NAME
        ).build()
    }
}

private const val DB_NAME = "cocktails.db"