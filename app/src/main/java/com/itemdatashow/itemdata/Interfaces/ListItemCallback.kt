package com.itemdatashow.itemdata.Interfaces

import com.itemdatashow.itemdata.model.OrderListData

interface ListItemCallback {
    fun orderStatusUpdate(updatedData : OrderListData, position : Int){

    }
}