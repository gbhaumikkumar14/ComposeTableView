package com.bhaumikghodasara.composesamples.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhaumikghodasara.composesamples.R
import com.bhaumikghodasara.composesamples.ui.theme.ComposeSamplesTheme
import com.bhaumikghodasara.composesamples.ui.theme.textColorPrimary

@Composable
fun RatingBar(modifier: Modifier, ratingValue: Int, reviewCount: Int) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        for (i in 1..5){
            Icon(
                painter = if(i > ratingValue) painterResource(id = R.drawable.star_empty) else painterResource(id = R.drawable.star),
                contentDescription = "RatingStar",
            tint = Color.Unspecified)
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "($reviewCount)",
            color = textColorPrimary,
            fontSize = 12.sp,
            fontWeight = FontWeight(weight = 400)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRatingBar(){
    ComposeSamplesTheme {
        RatingBar(modifier = Modifier, ratingValue = 4, reviewCount = 456)
    }
}