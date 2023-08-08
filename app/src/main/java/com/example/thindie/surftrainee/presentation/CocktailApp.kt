package com.example.thindie.surftrainee.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
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
        cocktailScreen(onClickEdit = appState::edit)
        editScreen(
            onClickSave = appState::home,
            onClickCancel = appState::home
        )
        homeScreen(
            onClickAdd = appState::edit,
            onClickCockTail = appState::cocktail
        )
    }
}