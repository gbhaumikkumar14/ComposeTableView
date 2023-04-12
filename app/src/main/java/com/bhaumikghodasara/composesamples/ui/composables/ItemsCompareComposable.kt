package com.bhaumikghodasara.composesamples.ui.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bhaumikghodasara.composesamples.R
import com.bhaumikghodasara.composesamples.model.*
import com.bhaumikghodasara.composesamples.ui.theme.*
import com.bhaumikghodasara.composesamples.ui.viewmodel.CompareItemsViewModel

/**
 * Below improvement can be added for actual implementation
 *
 * 1. Width for cells can be computed programmatically as per device screen width
 * 2. dimensions can be converted to constants
 * 3. Font Weight can be converted to constants
 * 4. For different view types we can create function with attribute name to return content
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemsCompareComposable(modifier: Modifier, viewModel: CompareItemsViewModel = viewModel()) {
    val devices by viewModel.devices.collectAsStateWithLifecycle()
    val attrs = getAttrsList()
    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()
    // This will stop over scroll effect
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        Column(modifier = modifier) {
            var headerheight by remember {
                mutableStateOf(0)
            }
            Row(
                Modifier
                    .onSizeChanged { headerheight = it.height }
                    .background(tableBackGround)
            ) {
                Text(
                    text = "", modifier = Modifier
                        .width(dimen104)
                        .height(height = with(LocalDensity.current) { headerheight.toDp() })
                )
                VerticalDivider(height = headerheight)
                Row(
                    modifier = Modifier
                        .horizontalScroll(horizontalScrollState)
                        .background(tableCellColorPrimary)
                ) {
                    devices.forEach {
                        ItemHeader(devices = devices, deviceDetails = it) {
                            viewModel.removeDevice(it)
                        }
                        VerticalDivider(height = headerheight)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .verticalScroll(verticalScrollState)
            ) {
                var count = 0
                attrs.forEach { attr ->
                    Row(
                        modifier = Modifier
                            .then(
                                if (count % 2 == 0) {
                                    Modifier.background(tableCellColorPrimary)
                                } else {
                                    Modifier.background(tableCellColorSecondary)
                                }
                            )
                    ) {
                        var height by remember {
                            mutableStateOf(0)
                        }
                        Column(modifier = Modifier.width(dimen104)) {
                            Divider(thickness = dimen1, color = tableBorder)
                            Text(
                                text = getAttrDisplayNameFromAttr(attr),
                                fontSize = 13.sp,
                                color = textColorEmphasis,
                                fontWeight = FontWeight(weight = 510),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = dimen16, vertical = dimen12)
                            )
                        }
                        VerticalDivider(height = height)
                        Row(
                            modifier = Modifier
                                .onSizeChanged {
                                    height = it.height
                                }
                                .horizontalScroll(horizontalScrollState)
                        ) {
                            devices.forEach { device ->
                                Column(modifier = Modifier.width(dimen128)) {
                                    Divider(thickness = dimen1, color = tableBorder)
                                    if (attr == "rating") {
                                        RatingBar(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = dimen8, vertical = dimen12),
                                            ratingValue = device.rating!!,
                                            reviewCount = device.reviews!!
                                        )
                                    } else {
                                        Text(
                                            text = getValueFromAttributeName(device, attr)!!,
                                            color = textColorPrimary,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight(weight = 400),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(dimen12)
                                        )
                                    }
                                }
                                VerticalDivider(height)
                            }
                        }
                        count++
                    }
                }
            }
        }
    }
}

@Composable
fun ItemHeader(
    devices: List<DeviceDetails>,
    deviceDetails: DeviceDetails,
    onDelete: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.width(dimen128)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = deviceDetails.imgUrl,
                contentDescription = "Item image",
                modifier = Modifier
                    .height(dimen100)
                    .align(Alignment.Center)
                    .padding(top = dimen8, end = dimen8)
            )
            if (devices.size > 2) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .clickable {
                            onDelete()
                        }
                )
            }
        }
        Text(
            text = deviceDetails.deviceName!!,
            color = textColorEmphasis,
            fontSize = 13.sp,
            fontWeight = FontWeight(weight = 500),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dimen12, end = dimen12, top = dimen4)
        )
        Text(
            text = "$${deviceDetails.price}",
            color = textColorEmphasis,
            fontSize = 12.sp,
            fontWeight = FontWeight(weight = 400),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimen12, vertical = dimen4)
        )
        OutlinedButton(
            onClick = {},
            border = BorderStroke(width = dimen2, color = colorBorderButtonSecondaryRest),
            modifier = Modifier.padding(start = dimen12, top = dimen8, bottom = dimen8)
        ) {
            Text(
                text = "Shop now",
                fontSize = 12.sp,
                fontWeight = FontWeight(weight = 510),
                color = textColorPrimary,
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewItemsCompareComposable() {
    ComposeSamplesTheme {
        ItemsCompareComposable(Modifier)
    }
}