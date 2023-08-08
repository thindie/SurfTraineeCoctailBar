package com.example.thindie.surftrainee.presentation.commonelements

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thindie.surftrainee.R
import com.example.thindie.surftrainee.presentation.theme.TraineeTheme

@Composable
fun CocktailButton(@StringRes label: Int, isColored: Boolean, onClick: () -> Unit) {
    val modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .fillMaxWidth()
    if (isColored) {
        Button(
            modifier = modifier, colors = if (isColored) ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4B97FF),
                contentColor = Color.White,
            ) else ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF4B97FF),
            ), onClick = onClick, shape = RoundedCornerShape(80.dp)
        ) {
            Text(text = stringResource(id = label), style = MaterialTheme.typography.titleLarge)
        }
    } else {
        OutlinedButton(
            modifier = modifier,
            colors = if (isColored) ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4B97FF),
                contentColor = Color.White,
            ) else ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF4B97FF),
            ),
            onClick = onClick,
            border = BorderStroke(2.dp, color = Color(0xFF4B97FF)),
            shape = RoundedCornerShape(80.dp)
        ) {
            Text(text = stringResource(id = label), style = MaterialTheme.typography.titleLarge)
        }
    }


}

@Preview
@Composable
fun PreviewButton() {
    TraineeTheme {
        Column {
            CocktailButton(label = R.string.button_label_edit, isColored = true) {

            }
            CocktailButton(label = R.string.button_label_cancel, isColored = false) {

            }
        }

    }
}