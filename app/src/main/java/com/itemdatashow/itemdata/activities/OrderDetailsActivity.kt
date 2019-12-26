package com.itemdatashow.itemdata.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.itemdatashow.itemdata.R
import com.itemdatashow.itemdata.model.OrderListData

class OrderDetailsActivity : AppCompatActivity() {
    lateinit var mData : OrderListData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)
        mData = intent.getSerializableExtra("data") as OrderListData

        Log.d("OrderDetailsActivity", "received data ${mData.orderID}")
    }
}
