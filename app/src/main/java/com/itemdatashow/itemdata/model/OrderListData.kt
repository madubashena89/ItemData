package com.itemdatashow.itemdata.model

import java.io.Serializable

data class OrderListData (
    val orderID : String,
    val address : String,
    val number : String ,
    val modeOfpayment : String,
    var orderStatus : OrderStatusEnum

   /*val  address : String,
   val city : String,
   val name : String,
   val latitude : String,
   val zipcode : String,
   val storeLogoURL : String,
   val phone : String,
   val longitude : String,
   val storeID : Int,
   val state : String*/
   ): Serializable