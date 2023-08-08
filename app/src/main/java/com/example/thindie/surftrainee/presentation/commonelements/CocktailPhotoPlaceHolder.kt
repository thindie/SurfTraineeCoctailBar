package com.example.thindie.surftrainee.presentation.commonelements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thindie.surftrainee.R
import com.example.thindie.surftrainee.presentation.theme.TraineeTheme

@Composable
fun CocktailPlaceHolder(
    modifier: Modifier = Modifier,
    @DrawableRes img: Int = 0,
    onClickImage: () -> Unit,
) {
    if (img == 0) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(216.dp)
                .clip(RoundedCornerShape(54.dp))
                .background(Color(0xFFEEEEEE))
                .clickable { onClickImage() }

        ) {
            Image(
                modifier = modifier,
                painter = painterResource(id = R.drawable.img_xml_camera),
                contentDescription = ""
            )
        }
    } else {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(54.dp))
                .clickable { onClickImage() },
            painter = painterResource(id = img),
            contentScale = ContentScale.Fit,
            contentDescription = ""
        )
    }
}

@Composable
@Preview
fun PreviewCocktail() {
    TraineeTheme {
        CocktailPlaceHolder(Modifier.padding(all = 20.dp)) {

        }
    }
}