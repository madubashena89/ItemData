package com.itemdatashow.itemdata.adaptors

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.itemdatashow.itemdata.Interfaces.ListItemCallback
import com.itemdatashow.itemdata.R
import com.itemdatashow.itemdata.activities.OrderDetailsActivity
import com.itemdatashow.itemdata.model.OrderListData
import com.itemdatashow.itemdata.model.OrderStatusEnum

class OrderListAdapter(val mContext : Context, val mList: List<OrderListData>, val listItemCallback : ListItemCallback):
    RecyclerView.Adapter<OrderListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.order_list_row, parent,
            false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mList[position]
//        holder.storID.text = data.storeID.toString()
//        holder.zipCode.text = data.zipcode
//        //holder.storeLogo. = data.storeLogoURL
//        holder.storeAdress.text= data.address
//        holder.storephone.text = data.phone
//
//        Glide.with(holder.itemView)
//            .load(data.storeLogoURL)
//            .into(holder.storeLogo)

        holder.tvorderID.text = data.orderID
        holder.tvAddress.text = data.address
        holder.tvNumber.text = data.number
        holder.tvPaymentMode.text = data.modeOfpayment

        when (data.orderStatus) {
            OrderStatusEnum.Cancelled -> holder.rg.verticalScrollbarPosition = 0
            OrderStatusEnum.Pending -> holder.rg.verticalScrollbarPosition = 1
            OrderStatusEnum.Delivered -> holder.rg.verticalScrollbarPosition = 2

//            OrderStatusEnum.Cancelled -> holder.rgCancel
////            OrderStatusEnum.Pending -> holder.rgPending
////            OrderStatusEnum.Delivered -> holder.rgDeliverd
        }

        holder.rg.setOnClickListener {

            when (data.orderStatus) {
                OrderStatusEnum.Cancelled -> holder.rg.verticalScrollbarPosition = 0
                OrderStatusEnum.Pending -> holder.rg.verticalScrollbarPosition = 1
                OrderStatusEnum.Delivered -> holder.rg.verticalScrollbarPosition = 2
            }

            /*position ->
            when (position) {
                0 -> data.orderStatus = OrderStatusEnum.Cancelled
                1 -> data.orderStatus = OrderStatusEnum.Pending
                2 -> data.orderStatus = OrderStatusEnum.Delivered
            }*/
            listItemCallback.orderStatusUpdate(data, holder.adapterPosition)
        }

        holder.card.setOnClickListener{
            val intent = Intent(mContext, OrderDetailsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("data", data)
            mContext.startActivity(Intent(intent))
        }
    }

    class ViewHolder (v: View) : RecyclerView.ViewHolder(v) {
        val tvorderID: TextView
        val tvAddress: TextView
        val tvNumber: TextView
        val tvPaymentMode: TextView
        val rg: RadioGroup
        val rgCancel: RadioButton
        val rgPending: RadioButton
        val rgDeliverd: RadioButton
        val card : MaterialCardView

        init {
            tvorderID = v.findViewById(R.id.tvOrder)
            tvAddress = v.findViewById(R.id.tvAddress)
            tvNumber = v.findViewById(R.id.tvMobile)
            tvPaymentMode = v.findViewById(R.id.tvPaymentMode)
            rg = v.findViewById(R.id.rg)
            rgCancel = v.findViewById(R.id.rg_cancel)
            rgPending = v.findViewById(R.id.rg_pending)
            rgDeliverd = v.findViewById(R.id.rg_delivered)
            card = v.findViewById(R.id.card)
        }
//        val storeAdress: TextView
//        val storeLogo: ImageView
//        val storephone: TextView
//        val zipCode: TextView
//        val storID: TextView
//
//        init {
//            storeAdress = v.findViewById(R.id.store_address)
//            storeLogo = v.findViewById(R.id.store_logo_image)
//            storephone = v.findViewById(R.id.phoneNo)
//            zipCode = v.findViewById(R.id.zip_code)
//            storID = v.findViewById(R.id.storeID)
//        }
//
//    }
    }
}

