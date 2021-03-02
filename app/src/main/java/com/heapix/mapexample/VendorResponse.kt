package com.heapix.mapexample

import org.joda.time.DateTime

data class VendorResponse(
    var id: Int?,
    var items: List<Item>,
    var dateClosed: DateTime?,
    var deliveryPrice: Double?
)