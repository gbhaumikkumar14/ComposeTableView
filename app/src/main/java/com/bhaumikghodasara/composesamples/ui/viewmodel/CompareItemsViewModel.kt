package com.bhaumikghodasara.composesamples.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.bhaumikghodasara.composesamples.model.DeviceDetails
import com.bhaumikghodasara.composesamples.model.getAttrsList
import com.bhaumikghodasara.composesamples.model.getDevices
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CompareItemsViewModel: ViewModel() {
    private val _mutableDevices = MutableStateFlow(getDevices().toMutableList())
    val devices: StateFlow<List<DeviceDetails>> get() = _mutableDevices

    private val _attributesList = MutableStateFlow(getAttrsList())
    val attrs :StateFlow<List<String>> get() = _attributesList

    fun removeDevice(deviceDetails: DeviceDetails){
        val updatedList = mutableListOf<DeviceDetails>()
        updatedList.addAll(_mutableDevices.value)
        updatedList.remove(deviceDetails)
        _mutableDevices.value = updatedList
    }
}