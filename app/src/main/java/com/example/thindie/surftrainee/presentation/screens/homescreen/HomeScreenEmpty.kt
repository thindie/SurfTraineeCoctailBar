package com.example.thindie.surftrainee.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thindie.surftrainee.R
import com.example.thindie.surftrainee.presentation.commonelements.CocktailFab
import com.example.thindie.surftrainee.presentation.commonelements.Screen
import com.example.thindie.surftrainee.presentation.theme.TraineeTheme

@Composable
fun HomeScreenEmpty(onClickAdd: () -> Unit) {
    Screen(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 38.dp, end = 39.dp, top = 33.dp, bottom = 21.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.47f)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.cocktail_home),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }



        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = stringResource(R.string.display_my_cocktails_home),
                style = MaterialTheme.typography.displayLarge
            )
            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = stringResource(R.string.add_your_first_n_cocktail_here),

                style = MaterialTheme.typography.bodySmall
            )

            Image(
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                painter = painterResource(id = R.drawable.img_xml_arrow_down),
                contentDescription = "",
            )
            CocktailFab {
                onClickAdd()
            }
        }
    }
}

@Preview
@Composable
fun previewEmptyHome() {
    TraineeTheme {
        HomeScreenEmpty {}
    }
}