package com.example.thindie.surftrainee.presentation.screens.homescreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.thindie.surftrainee.presentation.navigation.CocktailBar

fun NavGraphBuilder.homeScreen(onClickAdd: () -> Unit, onClickCocktail: () -> Unit) {
    composable(route = CocktailBar.homeScreen) {

    }
}