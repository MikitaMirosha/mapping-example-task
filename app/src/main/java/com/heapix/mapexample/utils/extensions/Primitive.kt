package com.heapix.mapexample.utils.extensions

import com.heapix.mapexample.Item
import com.heapix.mapexample.Type
import com.heapix.mapexample.VendorCar
import com.heapix.mapexample.VendorResponse


fun List<VendorResponse>.filterAllPastDays(): List<VendorResponse> {
    return this.filter { it.dateClosed?.isAfterNow ?: false }
}

fun List<Item>.removeAllNotCarItems(): List<Item> {
    return this.filter { itemType -> itemType.typeCont.type == Type.CAR }
}

fun List<VendorCar>.filterEmptyItem(): List<VendorCar> {
    return this.filter { it.items.isNotEmpty() }
}

fun VendorResponse.convertToVendorCar(): VendorCar {
    return VendorCar(
        id = this.id.toString(),
        items = this.items
            .removeAllNotCarItems()
            .toNames(),
        deliveryPrice = this.deliveryPrice ?: 0.0
    )
}

fun List<Item>.toNames(): MutableList<String> {
    return this.map { itemName -> itemName.name }.toMutableList()
}