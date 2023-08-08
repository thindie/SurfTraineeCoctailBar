package com.example.thindie.surftrainee.presentation.screens.editScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thindie.surftrainee.R
import com.example.thindie.surftrainee.domain.Cocktail
import com.example.thindie.surftrainee.presentation.commonelements.CocktailButton
import com.example.thindie.surftrainee.presentation.commonelements.CocktailInputField
import com.example.thindie.surftrainee.presentation.commonelements.CocktailInputFieldState
import com.example.thindie.surftrainee.presentation.commonelements.CocktailPlaceHolder
import com.example.thindie.surftrainee.presentation.commonelements.Screen
import com.example.thindie.surftrainee.presentation.commonelements.rememberInputState
import com.example.thindie.surftrainee.presentation.theme.TraineeTheme

@Suppress("LongParameterList")
@Composable
fun EditScreen(
    editScreenViewModel: EditScreenViewModel = hiltViewModel(),
    titleInputField: CocktailInputFieldState = rememberInputState(
        isMajor = true,
        hint = R.string.hint_title,
        supportingText = R.string.hint_add_title
    ),
    description: CocktailInputFieldState = rememberInputState(
        isMajor = false,
        hint = R.string.hint_description,
        supportingText = R.string.hint_optional
    ),
    recipe: CocktailInputFieldState = rememberInputState(
        isMajor = false,
        hint = R.string.hint_recipe_no_dots,
        supportingText = R.string.hint_optional
    ),
    ingredientsListState: IngredientsListState = rememberIngredientsListState(),
    cocktail: String,
    onClickSave: () -> Unit,
    onClickCancel: () -> Unit,
) {
    Screen {
        CocktailPlaceHolder(
            modifier = Modifier.padding(
                start = 72.dp,
                end = 73.dp,
                top = 40.dp,
                bottom = 40.dp,
            ),
            onClickImage = {}
        )
        LazyColumn() {
            item {
                CocktailInputField(
                    modifier = Modifier.padding(bottom = 24.dp),
                    state = titleInputField
                )
            }
            item {
                CocktailInputField(
                    modifier = Modifier.padding(bottom = 24.dp),
                    state = description
                )
            }
            item { IngredientsList(state = ingredientsListState) }
            item {
                CocktailInputField(
                    modifier = Modifier.padding(bottom = 24.dp, top = 24.dp),
                    state = recipe
                )
            }
            item {
                CocktailButton(
                    modifier = Modifier.padding(bottom = 8.dp),
                    label = R.string.button_label_save,
                    isColored = true
                ) {
                    if (!titleInputField.isValid()) {
                        val readyCocktailRecipe = Cocktail(
                            name = titleInputField.fieldState.value,
                            recipe = recipe.fieldState.value,
                            description = description.fieldState.value,
                            cocktailParts = ingredientsListState.list.value,
                            isHasPhoto = false,
                            photoPath = ""
                        )
                        editScreenViewModel.onClickSave(readyCocktailRecipe)
                        onClickSave()
                    }
                }
            }
            item {
                CocktailButton(label = R.string.button_label_cancel, isColored = false) {
                    onClickCancel()
                }
            }
        }


    }
}


@Composable
fun IngredientsList(state: IngredientsListState) {

    val inputState = rememberInputState(
        isMajor = true,
        hint = R.string.hint_ingredient,
        supportingText = R.string.hint_add_title
    )

    if (state.isNeedAddUnit.value) {
        Dialog(
            onDismissRequest = { state.isNeedAddUnit.value = false },
        ) {
            Surface(
                modifier = Modifier.size(330.dp),
                shape = RoundedCornerShape(54.dp),
                color = Color.White
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 24.dp),
                        text = stringResource(id = R.string.display_add_ingredient),
                        style = MaterialTheme.typography.displayMedium
                    )

                    CocktailInputField(
                        modifier = Modifier.padding(bottom = 24.dp),
                        state = inputState
                    )

                    CocktailButton(label = R.string.button_label_add, isColored = true) {
                        if (!inputState.isValid()) {
                            state.onAdd(inputState.fieldState.value)
                            inputState.onValueChange("")
                            state.isNeedAddUnit.value = false
                        }
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    CocktailButton(label = R.string.button_label_cancel, isColored = false) {
                        state.isNeedAddUnit.value = false
                    }

                }
            }

        }
    }

    LazyRow(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(state.list.value) {
            IngredientUnit(label = it, onDelete = state::onDelete)
        }
        item {
            Image(modifier = Modifier.clickable {
                state.isNeedAddUnit.value = true
            }, painter = painterResource(id = R.drawable.icon_plus), contentDescription = "")
        }
    }
}


@Composable
fun rememberIngredientsListState(ingredientsList: List<String> = emptyList()): IngredientsListState {
    return remember(ingredientsList) {
        IngredientsListState(ingredientsList)
    }
}


@Stable
class IngredientsListState(private val ingredientsList: List<String>) {
    private val _list = mutableStateOf(ingredientsList)

    val isNeedAddUnit = mutableStateOf(false)
    val list: State<List<String>>
        get() = _list

    fun onAdd(ingredient: String) {
        val moddedList = _list.value.toMutableList()
        moddedList.add(ingredient)
        _list.value = moddedList
    }

    fun onDelete(ingredient: String) {
        val moddedList = _list.value.toMutableList()
        moddedList.remove(ingredient)
        _list.value = moddedList
    }
}

@Composable
private fun IngredientUnit(label: String, onDelete: (String) -> Unit) {
    OutlinedCard(
        shape = RoundedCornerShape(56.dp),
        modifier = Modifier
            .height(24.dp)
            .padding(end = 8.dp)
            .wrapContentWidth()
    ) {
        Row(
            modifier = Modifier.padding(top = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, end = 4.dp),
                text = label,
                style = MaterialTheme.typography.labelSmall,
            )
            Image(
                painter = painterResource(id = R.drawable.icon_dismiss),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { onDelete(label) })
        }
    }
}


@Preview
@Composable
fun PreviewIngredients() {
    TraineeTheme {
        IngredientsList(state = rememberIngredientsListState())
    }
}

@Preview
@Composable
fun PreviewEditScreen() {
    TraineeTheme {
        EditScreen(cocktail = "", onClickSave = { }) {

        }
    }
}