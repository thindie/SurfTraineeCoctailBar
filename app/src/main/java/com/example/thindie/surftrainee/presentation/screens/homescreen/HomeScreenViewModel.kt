package com.example.thindie.surftrainee.presentation.screens.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thindie.surftrainee.domain.Cocktail
import com.example.thindie.surftrainee.domain.RepositoryCocktails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: RepositoryCocktails) :
    ViewModel() {

    private val _screenState = MutableStateFlow(HomeScreenState())
    val screenState = _screenState.stateIn(
        started = SharingStarted.WhileSubscribed(5_000L),
        scope = viewModelScope,
        initialValue = HomeScreenState()
    )

    @Inject
    fun onStart() {
        viewModelScope.launch {
            repository
                .getCocktails()
                .onEach { cocktails ->
                    _screenState.value = HomeScreenState(cocktails = cocktails)
                }.launchIn(this)
        }
    }

    fun onClickCocktail(name: String) {
        viewModelScope.launch {
            repository.getCocktail(name)
        }
    }

    data class HomeScreenState(
        val cocktails: List<Cocktail> = emptyList(),
        val shouldShowOnboarding: Boolean = cocktails.isEmpty(),
    )
}