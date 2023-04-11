package com.bhaumikghodasara.composesamples.ui.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.bhaumikghodasara.composesamples.ui.theme.tableBorder

@Composable
fun VerticalDivider(height: Int?) {
    Divider(
        color = tableBorder,
        modifier = Modifier
            .then(
                if (height != null)
                    Modifier.height(height = with(LocalDensity.current) { height.toDp() })
                else
                    Modifier.fillMaxHeight()
            )
            .width(1.dp)
    )
}