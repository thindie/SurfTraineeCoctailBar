package com.example.thindie.surftrainee.presentation.commonelements

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thindie.surftrainee.R
import com.example.thindie.surftrainee.presentation.theme.TraineeTheme

@Composable
fun CocktailInputField(modifier: Modifier = Modifier, state: CocktailInputFieldState) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .height(
                state.height
            ),
        textStyle = MaterialTheme.typography.labelLarge.copy(textAlign = TextAlign.Start),
        singleLine = !state.isMajor,
        value = state.fieldState.value,
        onValueChange = state::onValueChange,
        colors = state.textFieldColorsState,
        shape = RoundedCornerShape(34.dp),
        isError = state.isError.value,
        label = { state.fieldHint },
        supportingText = { state.fieldSupport }
    )
}


@Composable
fun rememberInputState(
    isMajor: Boolean,
    @StringRes hint: Int,
    @StringRes supportingText: Int,
): CocktailInputFieldState {
    return remember(isMajor) {
        CocktailInputFieldState(isMajor, hint, supportingText)
    }
}

@Stable
class CocktailInputFieldState(
    val isMajor: Boolean,
    @StringRes private val hint: Int,
    @StringRes private val supportingText: Int,
) {

    val fieldHint
        @Composable get() = Text(
            text = stringResource(id = hint),
            style = MaterialTheme.typography.labelSmall
        )

    val fieldSupport
        @Composable get() = Text(
            text = stringResource(id = supportingText),
            style = MaterialTheme.typography.labelSmall
        )

    private val _isError = mutableStateOf(false)

    val height = if (isMajor) 56.dp else 154.dp
    val isError: State<Boolean>
        get() = _isError

    private val _fieldValue = mutableStateOf("")
    val fieldState: State<String>
        get() = _fieldValue

    fun onValueChange(value: String) {
        _isError.value = false
        _fieldValue.value = value
    }

    fun isValid(): Boolean {
        return if (isMajor) {
            if (_fieldValue.value.isBlank()) {
                _isError.value = true
            }
            _fieldValue.value.isBlank()
        } else true
    }


    val textFieldColorsState
        @Composable get() = OutlinedTextFieldDefaults.colors(
            disabledTextColor = Color(0xFF79747E),
            cursorColor = Color(0xFF4B97FF),
            errorCursorColor = Color(0xFFFF0000),
            focusedTextColor = Color(0xFF313131),
            unfocusedTextColor = Color(0xFF79747E),
            errorTextColor = Color(0xFFFF0000),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            errorContainerColor = Color.White,
            focusedLabelColor = Color(0xFF79747E),
            unfocusedLabelColor = Color(0xFF79747E),
            disabledLabelColor = Color(0xFF79747E),
            errorLabelColor = Color(0xFFFF0000),
            focusedPlaceholderColor = Color(0xFFFF0000),
            unfocusedPlaceholderColor = Color(0xFF79747E),
            disabledPlaceholderColor = Color(0xFF79747E),
            errorPlaceholderColor = Color(0xFFFF0000),
            focusedBorderColor = Color(0xFF79747E),
            unfocusedBorderColor = Color(0xFF79747E),
            disabledBorderColor = Color(0xFF79747E),
            errorBorderColor = Color(0xFF79747E),
        )

}


@Preview
@Composable
fun PreviewCocktailInput() {
    TraineeTheme {
        Column {
            CocktailInputField(
                state = rememberInputState(
                    isMajor = true,
                    hint = R.string.hint_add_title,
                    supportingText = R.string.hint_add_title
                )
            )
            CocktailInputField(
                state = rememberInputState(
                    isMajor = false,
                    hint = R.string.hint_add_title,
                    supportingText = R.string.hint_add_title
                )
            )
        }

    }
}