package com.example.itemdata.Interfaces

import com.example.itemdata.model.OrderListData
import com.example.itemdata.model.OrderStatusEnum

interface ListItemCallback {
    fun orderStatusUpdate(updatedData : OrderListData){

    }
}