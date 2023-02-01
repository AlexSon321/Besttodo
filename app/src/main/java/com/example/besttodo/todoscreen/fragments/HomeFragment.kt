package com.example.besttodo.todoscreen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.besttodo.R
import com.example.besttodo.databinding.FragmentHomeBinding
import com.example.besttodo.homeweather.data.RetrofitWeather
import com.example.besttodo.homeweather.viewmodel.WeatherViewModel
import com.squareup.picasso.Picasso
import retrofit2.HttpException
import java.io.IOException

class HomeFragment : Fragment() {
        private lateinit var binding: FragmentHomeBinding
        private lateinit var model: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.exchangeOption.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_exchangeFragment)
        }

        binding.todoOption.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_rootFragment)
        }

        binding.fireBaseOption.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_fireRootFragment)
        }

        model = ViewModelProvider(this)[WeatherViewModel::class.java]




        lifecycleScope.launchWhenCreated {

            val response =  try {
                RetrofitWeather.api.getWeather()
            } catch (e: IOException){
                return@launchWhenCreated
            } catch (e: HttpException){
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body() != null){

                model.getWeather()

                model.weatherMain.observe(viewLifecycleOwner){ list ->
                    with(binding){
                        val imgUrl = list.body()!!.current.condition.icon


                        Picasso.get().load("https:$imgUrl").into(imageView6)
                        tvCity.text = list.body()!!.location.name
                        tvCountry.text = list.body()!!.location.country
                        tvTime.text = list.body()!!.location.localtime
                        tvWeather.text = "${list.body()!!.current.temp_c}℃ "


                        val weatherSnow = list.body()!!.current.condition.text



                    }



                }
            }



        }

        binding.citySet.setOnClickListener {
            val city = binding.urlmg.text.toString()
            model.getCity(city)


            model.weatherCity.observe(viewLifecycleOwner){ list ->
                with(binding){
                    val imgUrl = list.body()!!.current.condition.icon


                    Picasso.get().load("https:$imgUrl").into(imageView6)
                    tvCity.text = list.body()!!.location.name
                    tvCountry.text = list.body()!!.location.country
                    tvTime.text = list.body()!!.location.localtime
                    tvWeather.text = "${list.body()!!.current.temp_c}℃ "

                }
            }
        }













        return binding.root
    }

}