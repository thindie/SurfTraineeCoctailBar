package com.example.thindie.surftrainee.presentation.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.thindie.surftrainee.presentation.CocktailAppState
import com.example.thindie.surftrainee.presentation.rememberCocktailBarAppState
import com.example.thindie.surftrainee.presentation.screens.cocktailScreen.cocktailScreen
import com.example.thindie.surftrainee.presentation.screens.editScreen.editScreen
import com.example.thindie.surftrainee.presentation.screens.homescreen.homeScreen

@Composable
fun CocktailApp(
    appState: CocktailAppState = rememberCocktailBarAppState(),
) {
    NavHost(
        navController = appState.navHostController,
        startDestination = appState.startDestination
    ) {
        cocktailScreen { }
        editScreen(onClickSave = {}, onClickCancel = {})
        homeScreen(onClickAdd = {}, onClickCockTail = {})
    }
}