package com.example.thindie.surftrainee.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thindie.surftrainee.R
import com.example.thindie.surftrainee.domain.Cocktail
import com.example.thindie.surftrainee.presentation.commonelements.CocktailFab
import com.example.thindie.surftrainee.presentation.commonelements.Screen
import com.example.thindie.surftrainee.presentation.theme.TraineeTheme

@Composable
fun HomeScreen(
    cocktails: List<Cocktail>,
    onClickAdd: () -> Unit,
    onClickCocktail: (String) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            CocktailFab {
                onClickAdd()
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { scaffoldPadding ->
        Screen(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .padding(scaffoldPadding)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 24.dp),
                text = stringResource(R.string.display_my_cocktails_homescreen),
                style = MaterialTheme.typography.displayLarge
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(cocktails) { cocktail ->
                    CocktailUnit(cocktail = cocktail) { name ->
                        onClickCocktail(name)
                    }
                }
            }
        }
    }
}


@Composable
fun CocktailUnit(cocktail: Cocktail, onClickCocktail: (String) -> Unit) {

    Box(modifier = Modifier
        .padding(
            start = 4.dp, end = 4.dp, bottom = 8.dp
        )
        .clip(RoundedCornerShape(54.dp))
        .background(color = Color.Black)
        .clickable {
            onClickCocktail(cocktail.name)
        }
        .height(200.dp)
        .fillMaxWidth(0.5f), contentAlignment = Alignment.BottomCenter) {
        if (cocktail.isHasPhoto) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.cocktail_home),
                contentScale = ContentScale.Fit,
                contentDescription = ""
            )
        }
        Text(
            modifier = Modifier.padding(bottom = 34.dp),
            text = cocktail.name,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun PreviewCocktails() {
    TraineeTheme {
        HomeScreen(cocktails = fakeStorage, onClickAdd = { }, onClickCocktail = {})
    }
}

val fakeCocktail = Cocktail(
    name = "GAYISH DJANDANGO",
    recipe = "Muddle lime with leaves from the mint using a pestle and mortar. Mix with sprite. Add ice if needed.",
    description = "To make this homemade lemonade, simply combine all the ingredients in a pitcher.",
    cocktailParts = listOf("9 cups sprite", "small bunch mint", "3 limes, juiced"),
    isHasPhoto = false,
    photoPath = ""
)
private val fakeStorage = buildList<Cocktail>(10) {
    repeat(9) {
        add(fakeCocktail)
    }

}
