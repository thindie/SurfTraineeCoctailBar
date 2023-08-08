package com.example.thindie.surftrainee.presentation.screens.editScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thindie.surftrainee.domain.Cocktail
import com.example.thindie.surftrainee.domain.ConcreteCocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class EditScreenViewModel
@Inject constructor(private val concreteCocktailRepository: ConcreteCocktailRepository) :
    ViewModel() {
    fun onClickSave(cocktail: Cocktail) {
        viewModelScope.launch {
            concreteCocktailRepository.addCocktail(cocktail)
        }
    }
}
