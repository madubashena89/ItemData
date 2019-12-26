package com.itemdatashow.itemdata.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.itemdatashow.itemdata.Interfaces.ItemsApi
import com.itemdatashow.itemdata.Interfaces.ListItemCallback
import com.itemdatashow.itemdata.adaptors.OrderListAdapter
import com.itemdatashow.itemdata.R
import com.itemdatashow.itemdata.model.OrderListData
import com.itemdatashow.itemdata.model.OrderStatusEnum
import kotlinx.android.synthetic.main.activity_order_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderListActivity : AppCompatActivity() {
    lateinit var mList : MutableList<OrderListData>
    lateinit var mAdapter : OrderListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        createDummyList()
        getList(mList)

        //====API call with Retrofit======
//        ItemsApi().getItems().enqueue(object : Callback<List<OrderListData>>{
//            override fun onFailure(call: Call<List<OrderListData>>, t: Throwable) {
//                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<List<OrderListData>>, response: Response<List<OrderListData>>) {
//               val items = response.body()
//                items?.let {
//                    getList(it)
//                }
//            }
//
//        })


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

     private fun getList(orderlistData : List<OrderListData>) {
         mAdapter = OrderListAdapter(applicationContext, mList, object : ListItemCallback{
            override fun orderStatusUpdate(updatedData: OrderListData, position: Int) {
                //super.orderStatusUpdate(updatedData)
                mList.set(position, updatedData)
                mAdapter.notifyDataSetChanged()
            }
        })
        orderListRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        orderListRecyclerView.adapter = mAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

//    privste fun showData(){
//
//    }


}
