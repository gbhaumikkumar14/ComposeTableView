package com.bhaumikghodasara.composesamples.ui.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
fun ItemHeader(
    devices: SnapshotStateList<DeviceDetails>,
    deviceDetails: DeviceDetails,
    onDelete: () -> Unit){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.width(125.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
        ){
            AsyncImage(model = deviceDetails.imgUrl,
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .align(Alignment.Center)
                    .padding(top = 8.dp)
            )
            if(devices.size > 2){
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
            border = BorderStroke(width = 2.dp, color = TableBorder),
            modifier = Modifier.padding(start = 12.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Text(text = "Shop now",
                fontSize = 12.sp,
                fontWeight = FontWeight(weight = 510),
                color = textColorPrimary,
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemsCompareComposable(modifier: Modifier){
    val deviceList = getDevices()
    val devices = remember { mutableStateListOf(*deviceList.toTypedArray()) }
    val attrs = getAttrsList()
    val vertical = rememberScrollState()
    val horizontal = rememberScrollState()
    // This will stop over scroll effect
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        Column(modifier = modifier) {
            var headerheight by remember {
                mutableStateOf(0)
            }
            Row(
                Modifier
                    .onSizeChanged { headerheight = it.height }
                    .background(TableBackGround)
            ) {
                Text(text = "", modifier = Modifier
                    .width(105.dp)
                    .height(height = with(LocalDensity.current) { headerheight.toDp() }))
                VerticalDivider(height = headerheight)
                Row(
                    modifier = Modifier
                        .horizontalScroll(horizontal)
                        .background(TablePrimary)
                ) {
                    devices.forEach {
                        ItemHeader(devices = devices, deviceDetails = it) {
                            devices.remove(it)
                        }
                        VerticalDivider(height = headerheight)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .verticalScroll(vertical)
            ) {
                var count = 0
                attrs.forEach { attr ->
                    Row(
                        modifier = Modifier
                            .then(
                                if (count % 2 == 0) {
                                    Modifier.background(TablePrimary)
                                } else {
                                    Modifier.background(TableSecondary)
                                }
                            )
                    ) {
                        var height by remember {
                            mutableStateOf(0)
                        }
                        Column(modifier = Modifier.width(105.dp)) {
                            Divider(thickness = 1.dp, color = TableBorder)
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
                        Row(
                            modifier = Modifier
                                .onSizeChanged {
                                    height = it.height
                                }
                                .horizontalScroll(horizontal)
                        ) {
                            devices.forEach { device ->
                                Column(modifier = Modifier.width(125.dp)) {
                                    Divider(thickness = 1.dp, color = TableBorder)
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
fun VerticalDivider(height: Int?){
    Divider(
        color = TableBorder,
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewItemsCompareComposable(){
    ComposeSamplesTheme {
        ItemsCompareComposable(Modifier)
    }
}