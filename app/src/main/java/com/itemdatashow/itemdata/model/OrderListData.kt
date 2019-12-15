package com.itemdatashow.itemdata.model

data class OrderListData(val orderID : String,
                         val address : String,
                         val number : String ,
                         val modeOfpayment : String,
                         var orderStatus : OrderStatusEnum) {
}