package com.itemdatashow.itemdata.Interfaces

import com.google.gson.GsonBuilder
import com.itemdatashow.itemdata.model.OrderListData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/"

interface ItemsApi {
    @GET("stores.json")
    fun getItems() : Call<List<OrderListData>>

    companion object{

        operator fun invoke() : ItemsApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ItemsApi::class.java)
        }
    }

}