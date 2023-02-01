package com.example.besttodo.firebasescreen.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.webkit.WebChromeClient

import android.webkit.WebViewClient

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.besttodo.databinding.FragmentFireVideoBinding

import com.google.firebase.database.*

class FireVideoFragment : Fragment() {
    private lateinit var binding: FragmentFireVideoBinding
    private val args by navArgs<FireBaseFragmentArgs>()



    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFireVideoBinding.inflate(inflater, container , false)

        binding.wbView.webChromeClient = object : WebChromeClient(){
            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                super.onShowCustomView(view, callback)
                binding.cmView.visibility = View.VISIBLE
                binding.wbView.visibility = View.GONE
                binding.button.visibility = View.GONE
                binding.cmView.addView(view)
            }

            override fun onHideCustomView() {
                super.onHideCustomView()
                binding.cmView.visibility = View.GONE
                binding.wbView.visibility = View.VISIBLE
                binding.button.visibility = View.VISIBLE
            }

        }

        binding.wbView.loadUrl(args.currentVideo.empVideoUrl!!)


        binding.button.setOnClickListener {
            val action =
                FireVideoFragmentDirections.actionFireVideoFragmentToFireAddFragment(
                    args.currentVideo.empName!!
                )
            findNavController().navigate(action)
        }


        binding.wbView.settings.javaScriptEnabled = true
        binding.wbView.webViewClient = WebViewClient()


        return binding.root
    }



}