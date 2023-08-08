package com.example.thindie.surftrainee.presentation.commonelements

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thindie.surftrainee.R

@Composable
fun CocktailFab(onClickAdd: () -> Unit) {
    FloatingActionButton(
        modifier = Modifier.size(80.dp),
        shape = CircleShape,
        containerColor = Color(0xFF4B97FF),
        onClick = onClickAdd
    ) {
        Text(
            text = stringResource(R.string.fab_hint),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayMedium.copy(color = Color(0xFFFFFFFF))
        )
    }
}