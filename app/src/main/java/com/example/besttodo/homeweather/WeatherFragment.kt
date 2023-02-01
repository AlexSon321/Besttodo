package com.example.besttodo.homeweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.besttodo.databinding.FragmentWeatherBinding
import com.example.besttodo.homeweather.adapter.WeatherAdapter
import com.example.besttodo.homeweather.viewmodel.WeatherViewModel


class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private lateinit var model: WeatherViewModel
    private var adapter = WeatherAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container , false)

        model = ViewModelProvider(this)[WeatherViewModel::class.java]
//
//        binding.recView.adapter = adapter
//        binding.recView.layoutManager = LinearLayoutManager(activity as AppCompatActivity)

        lifecycleScope.launchWhenCreated {





//            val responseWeather = try {
//                RetrofitWeather.api.getCurrent()
//            } catch (e: IOException){
//                binding.textView9.visibility = View.VISIBLE
//                return@launchWhenCreated
//            } catch (e: HttpException){
//                binding.textView9.visibility = View.VISIBLE
//                return@launchWhenCreated
//            }
//
//            if(responseWeather.isSuccessful && responseWeather.body() != null){
//
//                model.getCurrent()
//
//                model.currentList.observe(viewLifecycleOwner){ list ->
//                    list.body()?.let {
//                        adapter.addCurrent(it)
//                    }
//                }
//
//            }
//
//            val responseLocation = try {
//                RetrofitWeather.api.getLocation()
//            } catch (e: IOException){
//                binding.textView9.visibility = View.VISIBLE
//                return@launchWhenCreated
//            } catch (e: HttpException){
//                binding.textView9.visibility = View.VISIBLE
//                return@launchWhenCreated
//            }
//
//            if(responseLocation.isSuccessful && responseLocation.body() != null){
//
//                model.getLocation()
//
//                model.locationList.observe(viewLifecycleOwner){ list ->
//                    list.body()?.let {
//                        adapter.addLocation(it)
//                    }
//                }
//
//            }
//
//            val responseCondition = try {
//                RetrofitWeather.api.getCurrent()
//            } catch (e: IOException){
//                binding.textView9.visibility = View.VISIBLE
//                return@launchWhenCreated
//            } catch (e: HttpException){
//                binding.textView9.visibility = View.VISIBLE
//                return@launchWhenCreated
//            }
//
//            if(responseCondition.isSuccessful && responseCondition.body() != null){
//
//                model.getCondition()
//
//                model.conditionList.observe(viewLifecycleOwner){ list ->
//                    list.body()?.let {
//                        adapter.addCondition(it)
//                    }
//                }
//
//            }
        }
        return binding.root
    }

}