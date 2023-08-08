package com.example.thindie.surftrainee.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.thindie.surftrainee.presentation.navigation.CocktailBar

@Composable
fun rememberCocktailBarAppState(
    navHostController: NavHostController = rememberNavController(),
): CocktailAppState {
    return remember(navHostController) {
        CocktailAppState(navHostController = navHostController)
    }
}

@Stable
class CocktailAppState(val navHostController: NavHostController) {
    val startDestination = CocktailBar.homeScreen
}