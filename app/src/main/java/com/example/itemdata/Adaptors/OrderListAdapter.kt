package com.example.itemdata.Adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.itemdata.Adaptors.OrderListAdapter.*
import com.example.itemdata.R
import com.example.itemdata.model.OrderListData
import com.example.itemdata.model.OrderStatusEnum
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class OrderListAdapter(val mList: List<OrderListData>): RecyclerView.Adapter<OrderListAdapter.ViewHolder>(){
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
//            OrderStatusEnum.Cancelled -> holder.rg[0]
//            OrderStatusEnum.Pending -> holder.rg[1]
//            OrderStatusEnum.Delivered -> holder.rg[2]

            OrderStatusEnum.Cancelled -> holder.rgCancel
            OrderStatusEnum.Pending -> holder.rgPending
            OrderStatusEnum.Delivered -> holder.rgDeliverd
        }
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