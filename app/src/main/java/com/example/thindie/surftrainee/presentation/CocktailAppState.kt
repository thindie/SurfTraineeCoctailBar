package com.example.thindie.surftrainee.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
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

    private fun navigate(route: String) {
        navHostController.navigateSingleTopTo(route)
    }

    fun edit() {
        navigate(CocktailBar.editScreen)
    }

    fun home() {
        navigate(CocktailBar.homeScreen)
    }

    fun cocktail() {
        navigate(CocktailBar.cocktailScreen)
    }



    private fun NavHostController.navigateSingleTopTo(route: String) =
        this.navigate(route) {
            popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
}