package com.bhaumikghodasara.composesamples.ui.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bhaumikghodasara.composesamples.R
import com.bhaumikghodasara.composesamples.model.*
import com.bhaumikghodasara.composesamples.ui.theme.*

@Composable
fun ItemHeaderLazy(
    devices: MutableList<DeviceDetails>,
    deviceDetails: DeviceDetails,
    onDelete: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.width(128.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = deviceDetails.imgUrl,
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .align(Alignment.Center)
                    .padding(top = 8.dp, end = 8.dp)
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
                .padding(start = 12.dp, end = 12.dp, top = 4.dp)
        )
        Text(
            text = "$${deviceDetails.price}",
            color = textColorEmphasis,
            fontSize = 12.sp,
            fontWeight = FontWeight(weight = 400),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
        )
        OutlinedButton(
            onClick = {},
            border = BorderStroke(width = 2.dp, color = colorBorderButtonSecondaryRest),
            modifier = Modifier.padding(start = 12.dp, top = 8.dp, bottom = 8.dp)
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemsCompareComposableLazy(modifier: Modifier) {
    val devices = getDevices()
    // todo NOTE :  below line causing issue for multiple scroll
//    val devices = remember { mutableStateListOf(*deviceList.toTypedArray()) }
    val attrs = getAttrsList()
    val horizontal = rememberLazyListState()
    val new = rememberLazyListState()

    // This will stop over scroll effect
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        Column() {
            var headerHeight by remember {
                mutableStateOf(0)
            }
            Row(
                Modifier
                    .onSizeChanged { headerHeight = it.height }
                    .background(tableBackGround)
            ) {
                Text(
                    text = "", modifier = Modifier
                        .width(104.dp)
                        .height(height = with(LocalDensity.current) { headerHeight.toDp() })
                )
                VerticalDivider(height = headerHeight)
                LazyRow(
                    state = horizontal,
                    modifier = Modifier
                        .background(tableCellColorPrimary)
                ) {
                    items(devices) {
                        ItemHeaderLazy(devices = devices, deviceDetails = it) {
                            devices.remove(it)
                        }
                        VerticalDivider(height = headerHeight)
                    }
                }
            }
            LazyColumn() {
                itemsIndexed(attrs) { index, attr ->
                    Row(
                        modifier = Modifier
                            .then(
                                if (index % 2 == 0) {
                                    Modifier.background(tableCellColorPrimary)
                                } else {
                                    Modifier.background(tableCellColorSecondary)
                                }
                            )
                    ) {
                        var height by remember {
                            mutableStateOf(0)
                        }
                        Column(modifier = Modifier.width(104.dp)) {
                            Divider(thickness = 1.dp, color = tableBorder)
                            Text(
                                text = getAttrDisplayNameFromAttr(attr),
                                fontSize = 13.sp,
                                color = textColorEmphasis,
                                fontWeight = FontWeight(weight = 510),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 12.dp)
                            )
                        }
                        VerticalDivider(height = height)
                        LazyRow(state = new,
                            modifier = Modifier
                            .onSizeChanged {
                                height = it.height
                            }
                        ) {
                            items(devices) { device ->
                                Column(modifier = Modifier.width(128.dp)) {
                                    Divider(thickness = 1.dp, color = tableBorder)
                                    if (attr == "rating") {
                                        RatingBar(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 8.dp, vertical = 12.dp),
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
                                                .padding(horizontal = 12.dp, vertical = 12.dp)
                                        )
                                    }
                                }
                                VerticalDivider(height)
                            }
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(new.firstVisibleItemScrollOffset) {
        horizontal.scrollToItem(new.firstVisibleItemIndex, new.firstVisibleItemScrollOffset)
    }

    LaunchedEffect(horizontal.firstVisibleItemScrollOffset) {
        new.scrollToItem(horizontal.firstVisibleItemIndex, horizontal.firstVisibleItemScrollOffset)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewItemsCompareComposableLazy() {
    ComposeSamplesTheme {
        ItemsCompareComposableLazy(Modifier)
    }
}

/**
 * Below works perfectly fine
 * Tried replacing it with lazyRow
 * Trying to scroll two lazy scrollers
 * DO NOT DELETE THIS
 */
@Composable
fun FinalCompareTable3(modifier: Modifier) {
    val devices = getDevices()
    val attrs = getAttrsList()
    val horizontal = rememberLazyListState()
    val new = rememberLazyListState()
    Column() {
        Row() {
            Text(text = "", modifier = Modifier.width(104.dp))
            LazyRow(state = horizontal) {
                items(devices) { device ->
                    Text(
                        text = device.deviceName!!,
                        fontSize = 24.sp,
                        fontWeight = FontWeight(weight = 700),
                        modifier = Modifier.width(128.dp)
                    )
                }
            }
        }
        LazyColumn() {
            items(attrs) { attr ->
                Row() {
                    Text(
                        text = getAttrDisplayNameFromAttr(attr),
                        fontWeight = FontWeight(weight = 700),
                        modifier = Modifier.width(104.dp)
                    )
                    LazyRow(state = new) {
                        items(devices) { device ->
                            if (attr == "rating") {
                                RatingBar(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 8.dp, vertical = 12.dp),
                                    ratingValue = device.rating!!,
                                    reviewCount = device.reviews!!
                                )
                            } else {
                                Text(
                                    text = getValueFromAttributeName(device, attr)!!,
                                    modifier = Modifier.width(128.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(new.firstVisibleItemScrollOffset) {
        horizontal.scrollToItem(new.firstVisibleItemIndex, new.firstVisibleItemScrollOffset)
    }
    LaunchedEffect(horizontal.firstVisibleItemScrollOffset) {
        new.scrollToItem(horizontal.firstVisibleItemIndex, horizontal.firstVisibleItemScrollOffset)
    }
}

