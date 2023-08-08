package com.example.thindie.surftrainee.presentation.screens.cocktailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thindie.surftrainee.domain.Cocktail
import com.example.thindie.surftrainee.domain.ConcreteCocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class CocktailScreenViewModel
@Inject constructor(private val concreteCocktailRepository: ConcreteCocktailRepository) :
    ViewModel() {

    private val _concreteCocktail: MutableStateFlow<Cocktail?> = MutableStateFlow<Cocktail?>(null)
    val concreteCocktail: StateFlow<Cocktail?> = _concreteCocktail.stateIn(
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null,
        scope = viewModelScope
    )

    fun onClickConcreteCocktail() {
        viewModelScope.launch {
            _concreteCocktail.value =
                concreteCocktailRepository.getConcreteCocktail()
        }
    }
}