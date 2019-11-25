package com.example.itemdata.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itemdata.Adaptors.OrderListAdapter
import com.example.itemdata.R
import com.example.itemdata.model.OrderListData
import com.example.itemdata.model.OrderStatusEnum
import kotlinx.android.synthetic.main.activity_order_list.*

class OrderListActivity : AppCompatActivity() {
    lateinit var mList : MutableList<OrderListData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)
        createDummyList()
        getList()
    }



    private fun createDummyList(){
        mList = mutableListOf()
        mList.add(OrderListData("OD6780", "2800 E Bolved", "34567884", "Cash", OrderStatusEnum.Cancelled))
        mList.add(OrderListData("OD6781", "2800 S Bolved", "36567884", "Online", OrderStatusEnum.Delivered))
        mList.add(OrderListData("OD6783", "6800 N Solved", "44567884", "Cash", OrderStatusEnum.Pending))
        mList.add(OrderListData("OD6785", "7800 N Bolved", "94567884", "Cash", OrderStatusEnum.Cancelled))
        mList.add(OrderListData("OD6787", "9800 S Bolved", "54587884", "Online", OrderStatusEnum.Cancelled))
        mList.add(OrderListData("OD6789", "8800 E Bolved", "94567884", "Cash", OrderStatusEnum.Pending))
        mList.add(OrderListData("OD6786", "4800 N Bolved", "84567884", "Online", OrderStatusEnum.Cancelled))
        mList.add(OrderListData("OD6770", "8800 S Bolved", "64567889", "Online", OrderStatusEnum.Cancelled))
        mList.add(OrderListData("OD6700", "4600 E Bolved", "34567885", "Cash", OrderStatusEnum.Delivered))
    }

    private fun getList() {
        val mAdapter = OrderListAdapter(mList)
        orderListRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        orderListRecyclerView.adapter = mAdapter
    }

}
