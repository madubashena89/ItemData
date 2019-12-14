package com.example.itemdata.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itemdata.Interfaces.ListItemCallback
import com.example.itemdata.R
import com.example.itemdata.model.OrderListData
import com.example.itemdata.model.OrderStatusEnum

class OrderListAdapter(val mList: List<OrderListData>, val listItemCallback : ListItemCallback): RecyclerView.Adapter<OrderListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.order_list_row,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data = mList[position]
        holder.tvorderID.text = data.orderID
        holder.tvAddress.text = data.address
        holder.tvNumber.text = data.number
        holder.tvPaymentMode.text = data.modeOfpayment

        when(data.orderStatus){
            OrderStatusEnum.Cancelled -> holder.rg.verticalScrollbarPosition = 0
            OrderStatusEnum.Pending -> holder.rg.verticalScrollbarPosition = 1
            OrderStatusEnum.Delivered -> holder.rg.verticalScrollbarPosition = 2

//            OrderStatusEnum.Cancelled -> holder.rgCancel
//            OrderStatusEnum.Pending -> holder.rgPending
//            OrderStatusEnum.Delivered -> holder.rgDeliverd
        }

//        holder.rg.setOnClickListener{
//            when(position){
//                0 --> data.orderStatus.Cancelled
//            }
//            listItemCallback.onOr
//        }
    }


    class ViewHolder (v: View) : RecyclerView.ViewHolder(v){
        val tvorderID : TextView
        val tvAddress : TextView
        val tvNumber : TextView
        val tvPaymentMode : TextView
        val rg : RadioGroup
        val rgCancel : RadioButton
        val rgPending : RadioButton
        val rgDeliverd : RadioButton

        init {
            tvorderID = v.findViewById(R.id.tvOrder)
            tvAddress = v.findViewById(R.id.tvAddress)
            tvNumber = v.findViewById(R.id.tvMobile)
            tvPaymentMode = v.findViewById(R.id.tvPaymentMode)
            rg = v.findViewById(R.id.rg)
            rgCancel = v.findViewById(R.id.rg_cancel)
            rgPending = v.findViewById(R.id.rg_pending)
            rgDeliverd = v.findViewById(R.id.rg_delivered)
        }

    }
}