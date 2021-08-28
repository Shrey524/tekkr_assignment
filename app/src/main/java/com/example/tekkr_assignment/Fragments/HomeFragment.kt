package com.example.tekkr_assignment.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.tekkr_assignment.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = LayoutInflater.from(context).inflate(R.layout.fragment_home,null)
        view.FormButton.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_formPage1)
        }
        view.OrdersButton.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_ordersPage1)
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}