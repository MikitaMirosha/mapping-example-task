package com.heapix.mapexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.heapix.mapexample.utils.extensions.convertToVendorCar
import com.heapix.mapexample.utils.extensions.filterAllPastDays
import com.heapix.mapexample.utils.extensions.filterEmptyItem
import org.joda.time.DateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vendorResponse: List<VendorResponse> =
            arrayListOf(

                VendorResponse(
                    2,
                    mutableListOf(
                        Item(
                            "name1",
                            TypeContainer(
                                "1",
                                Type.CAR
                            )
                        ),
                        Item(
                            "name2",
                            TypeContainer(
                                "2",
                                Type.BOX
                            )
                        ),
                    ),
                    DateTime.now().plusDays(3),
                    10.1
                ),
                VendorResponse(
                    3,
                    mutableListOf(
                        Item(
                            "qwer",
                            TypeContainer(
                                "1",
                                Type.TABLE
                            )
                        ),
                        Item(
                            "qwer2",
                            TypeContainer(
                                "2",
                                Type.BOX
                            )
                        ),
                    ),
                    DateTime.now().plusDays(2),
                    10.1
                ),
                VendorResponse(
                    5,
                    mutableListOf(
                        Item(
                            "asdfg1",
                            TypeContainer(
                                "1",
                                Type.CAR
                            )
                        ),
                        Item(
                            "asdfg2",
                            TypeContainer(
                                "2",
                                Type.TABLE
                            )
                        ),
                    ),
                    DateTime.now().minusDays(1),
                    10.1
                ),

                VendorResponse(
                    6,
                    mutableListOf(
                        Item(
                            "name3",
                            TypeContainer(
                                "1",
                                Type.CAR
                            )
                        ),
                    ),
                    DateTime.now().plusDays(1),
                    15.1
                )


            )

        val a = magicMapping(vendorResponse)


        Log.d("12345", a.toString())
    }

    private fun magicMapping(vendorResponse: List<VendorResponse>): List<VendorCar> {

        return vendorResponse
            .filterAllPastDays()
            .map {
                it.convertToVendorCar()
            }
            .filterEmptyItem()
    }

}