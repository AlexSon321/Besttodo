package com.example.besttodo.homeweather.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.R
import com.example.besttodo.databinding.WeatherItemBinding
import com.example.besttodo.homeweather.model.Condition
import com.example.besttodo.homeweather.model.Current
import com.example.besttodo.homeweather.model.Location
import com.squareup.picasso.Picasso

class WeatherAdapter(): RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var locationList = emptyList<Location>()
    private var conditionList = emptyList<Condition>()
    private var currentList = emptyList<Current>()


    class WeatherViewHolder(item: View): RecyclerView.ViewHolder(item){
        private var binding = WeatherItemBinding.bind(item)
        fun bindLocation(location: Location) = with(binding){
            tvCountry.text = location.country
            tvTime.text = location.localtime
            tvCity.text = location.name
        }

        fun bindCondition(condition: Condition) = with(binding){
            Picasso.get().load(condition.icon).into(tvImage)
        }

        fun bindCurrent(current: Current) = with(binding){
            tvWeather.text = "$current.temp_c℃"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bindCondition(conditionList[position])
        holder.bindCurrent(currentList[position])
        holder.bindLocation(locationList[position])
    }

    override fun getItemCount(): Int {
        return conditionList.size + locationList.size + currentList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCurrent(current: List<Current>){
        currentList = current
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addLocation(location: List<Location>){
        locationList = location
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCondition(condition: List<Condition>){
        conditionList = condition
        notifyDataSetChanged()
    }

}