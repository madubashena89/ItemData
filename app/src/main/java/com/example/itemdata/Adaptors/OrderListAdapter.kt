package com.example.itemdata.Adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itemdata.Adaptors.OrderListAdapter.*
import com.example.itemdata.R
import com.example.itemdata.model.OrderListData
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
    }


    class ViewHolder (v: View) : RecyclerView.ViewHolder(v){
        val tvorderID : TextView
        val tvAddress : TextView
        val tvNumber : TextView
        val tvPaymentMode : TextView

        init {
            tvorderID = v.findViewById(R.id.tvOrder)
            tvAddress = v.findViewById(R.id.tvAddress)
            tvNumber = v.findViewById(R.id.tvMobile)
            tvPaymentMode = v.findViewById(R.id.tvPaymentMode)
        }

    }
}