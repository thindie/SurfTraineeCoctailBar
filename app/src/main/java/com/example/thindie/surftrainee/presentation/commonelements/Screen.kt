package com.example.thindie.surftrainee.presentation.commonelements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Base Composable used as a container to others
 */
@Composable
fun Screen(
    modifier: Modifier = Modifier
        .padding(start = 8.dp, end = 8.dp),
    content: @Composable () -> Unit,
) {
    Column(
        modifier, verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}