package com.example.thindie.surftrainee.presentation.screens.editScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.thindie.surftrainee.presentation.navigation.CocktailBar

private const val MODE_ADD = ""
fun NavGraphBuilder.editScreen(
    cocktail: String = MODE_ADD,
    onClickSave: () -> Unit,
    onClickCancel: () -> Unit,
) {
    composable(route = CocktailBar.editScreen) {
        EditScreen(cocktail = cocktail, onClickSave = onClickSave) {
            onClickCancel()
        }
    }
}