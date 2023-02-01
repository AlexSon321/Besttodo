package com.example.besttodo.exchangescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.besttodo.R
import com.example.besttodo.databinding.FragmentExchangeBinding
import com.example.besttodo.exchangescreen.adapters.ExchangeAdapter
import com.example.besttodo.exchangescreen.data.RetrofitInstance
import com.example.besttodo.exchangescreen.viewmodel.ExchangeViewModel
import retrofit2.HttpException
import java.io.IOException


class ExchangeFragment : Fragment() {
    private lateinit var binding: FragmentExchangeBinding
    private lateinit var model: ExchangeViewModel
    private val adapter = ExchangeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExchangeBinding.inflate(inflater, container , false)

        model = ViewModelProvider(this)[ExchangeViewModel::class.java]
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity as AppCompatActivity)

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getExchange()
            } catch (e: IOException){
                return@launchWhenCreated
            } catch (e: HttpException){
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body() != null){

                model.getExchange()

                model.exchangeList.observe(viewLifecycleOwner){ list ->
                    list.body()?.let {
                        adapter.addElem(it)
                    }
                }

            }


        }

        return binding.root
    }

}