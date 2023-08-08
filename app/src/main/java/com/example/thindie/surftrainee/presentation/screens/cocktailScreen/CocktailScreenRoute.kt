package com.example.thindie.surftrainee.presentation.screens.cocktailScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.thindie.surftrainee.presentation.navigation.CocktailBar

fun NavGraphBuilder.cocktailScreen(onClickEdit: () -> Unit) {
    composable(route = CocktailBar.cocktailScreen) {
        CocktailScreen(onClickEdit = onClickEdit)
    }
}