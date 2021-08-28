package com.example.tekkr_assignment.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tekkr_assignment.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException

class FormPage2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = LayoutInflater.from(context).inflate(R.layout.fragment_form_page2,null)
        val list: ArrayList<String?> = fetchData()
        return view
    }

    fun fetchData(): ArrayList<String?>{
        val list: ArrayList<String?> = arrayListOf()
        val url = "http://3.6.99.194/mock_api/form_controls/"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("api_data",e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i("api_data",response.toString())
                val body = response.body()?.string()
                val type = object : TypeToken<List<Map<String, Any?>>>() {}.type
                val parent: List<Map<String, Any?>> = Gson().fromJson(body, type)

                var logo_url: Map<String, String?>? = null
                var heading: Map<String, String?>? = null
                for (item in parent) {
                    logo_url = item.get("logo-url") as Map<String, String?>
                    heading = item.get("heading-text") as Map<String, String?>
                    list.add(logo_url["logo-url"])
                    list.add(heading["heading-text"])
                }
            }
        })
        return list
    }
}