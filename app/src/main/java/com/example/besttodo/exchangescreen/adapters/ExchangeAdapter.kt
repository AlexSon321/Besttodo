package com.example.besttodo.exchangescreen.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.R
import com.example.besttodo.databinding.ExchangeItemBinding
import com.example.besttodo.exchangescreen.model.ExchangeItem

class ExchangeAdapter: RecyclerView.Adapter<ExchangeAdapter.ExchangeViewHolder>() {

    var exchangeList = emptyList<ExchangeItem>()

    class ExchangeViewHolder(item: View): RecyclerView.ViewHolder(item){
        private var binding = ExchangeItemBinding.bind(item)
        fun bind(exchangeItem: ExchangeItem) = with(binding){
            sellValute.text = exchangeItem.sale
            getValute.text = exchangeItem.buy
            titleValute.text = exchangeItem.ccy
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.exchange_item, parent, false)
        return ExchangeViewHolder(item)
    }

    override fun onBindViewHolder(holder: ExchangeViewHolder, position: Int) {
        holder.bind(exchangeList[position])
    }

    override fun getItemCount(): Int {
        return exchangeList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addElem(exchangeItem: List<ExchangeItem>){
        exchangeList = exchangeItem
        notifyDataSetChanged()
    }

}