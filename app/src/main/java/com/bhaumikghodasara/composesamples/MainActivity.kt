package com.bhaumikghodasara.composesamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bhaumikghodasara.composesamples.ui.composables.ItemsCompareComposable
import com.bhaumikghodasara.composesamples.ui.theme.ComposeSamplesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySampleApp()
        }
    }
}

@Composable
private fun MySampleApp(){
    ComposeSamplesTheme {
        Scaffold(topBar = {
            TopAppBar(title = {Text(text = "Compose Sample")})
        }) {
            paddingValues -> ItemsCompareComposable(modifier = Modifier.padding(paddingValues))
        }
    }
}
