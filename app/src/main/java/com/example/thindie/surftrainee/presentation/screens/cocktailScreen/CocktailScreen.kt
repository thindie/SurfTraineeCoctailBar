package com.example.thindie.surftrainee.presentation.screens.cocktailScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.thindie.surftrainee.R
import com.example.thindie.surftrainee.domain.Cocktail
import com.example.thindie.surftrainee.presentation.commonelements.CocktailButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailScreen(
    viewModel: CocktailScreenViewModel = hiltViewModel(),
    onClickEdit: () -> Unit,
) {
    viewModel.onClickConcreteCocktail()

    val state: State<Cocktail?> =
        viewModel
            .concreteCocktail
            .collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)

    if (state.value != null) {
        BottomSheetScaffold(
            sheetContent = {
                CocktailInformation(cocktail = requireNotNull(state.value)){
                    viewModel
                }

            },
            sheetDragHandle = {},
            sheetPeekHeight = 400.dp,
            sheetContainerColor = Color.White,
            sheetContentColor = Color.White,
            sheetSwipeEnabled = false,
            sheetShape = RoundedCornerShape(topStart = 56.dp, topEnd = 56.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan)
            ) {

            }
        }
    }
}


@Composable
fun CocktailInformation(cocktail: Cocktail, onClickEdit: (Cocktail) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier.padding(top = 28.dp),
            text = cocktail.name,
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            modifier = Modifier.padding(bottom = 16.dp, top = 16.dp),
            text = cocktail.description,
            style = MaterialTheme.typography.bodyLarge
        )
        LazyColumn(
            modifier = Modifier.fillMaxHeight(0.4f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(cocktail.cocktailParts) { part ->
                Text(
                    modifier = Modifier.padding(bottom = 16.dp, top = 16.dp),
                    text = part,
                    style = MaterialTheme.typography.bodyLarge
                )
                Divider(
                    modifier = Modifier
                        .padding(0.dp)
                        .width(9.dp)
                        .height(1.dp)
                        .background(color = Color(0xFF79747E))
                )
            }
        }
        Text(
            modifier = Modifier.padding(bottom = 4.dp, top = 32.dp),
            text = stringResource(R.string.hint_recipe),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = cocktail.recipe,
            style = MaterialTheme.typography.bodyLarge
        )

        CocktailButton(label = R.string.button_label_edit, isColored = true) {
            onClickEdit(cocktail)
        }
    }

}


