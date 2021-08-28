package com.example.tekkr_assignment.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.tekkr_assignment.Models.Form
import com.example.tekkr_assignment.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_form_page1.view.*
import okhttp3.*
import java.io.IOException

class FormPage1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var logo_url: Any? = fetchImage()
        val view:View = LayoutInflater.from(context).inflate(R.layout.fragment_form_page1,null)
        view.Logo.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_formPage1_to_formPage2)
        }
        Glide.with(this)
            .load(logo_url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(view.Logo)
        return view
    }

    fun fetchImage(): Any?{
        val url = "http://3.6.99.194/mock_api/form_controls/"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        var logo_url : String?=null
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("api_data",e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i("api_data",response.toString())
                val body = response.body()?.string()
                val gson = GsonBuilder().create()

                val data = gson.fromJson(body, Form::class.java)
                logo_url = data.logo_url
                Log.i("api_data",logo_url.toString())
            }
        })
        return logo_url
    }
}