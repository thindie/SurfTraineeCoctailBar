package com.example.thindie.surftrainee.presentation.screens.homescreen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.thindie.surftrainee.presentation.navigation.CocktailBar

fun NavGraphBuilder.homeScreen(onClickAdd: () -> Unit, onClickCocktail: () -> Unit) {
    composable(route = CocktailBar.homeScreen) {
        HomeScreenOnboard(onClickAdd = onClickAdd, onClickCocktail = onClickCocktail)
    }
}

@Composable
fun HomeScreenOnboard(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    onClickAdd: () -> Unit,
    onClickCocktail: () -> Unit,
) {
    val state =
        viewModel.screenState.collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)

    if (state.value.shouldShowOnboarding) {
        HomeScreenEmpty(onClickAdd = onClickAdd)
    } else {
        HomeScreen(
            cocktails = state.value.cocktails,
            onClickAdd = onClickAdd,
            onClickCocktail = {
                Log.d("SERVICE_TAG", it)
                viewModel.onClickCocktail(it)
                onClickCocktail()
            }
        )
    }
}