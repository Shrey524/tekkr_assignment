package com.example.tekkr_assignment.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.tekkr_assignment.R
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        mContext = this
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        userName.setText(sharedPreferences.getString("USERNAME",""))
        button.setOnClickListener(View.OnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("CHECKBOX", false)
            editor.apply()
            val intent = Intent(mContext, LoginPage::class.java)
            startActivity(intent)})
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.FragmentHost) as NavHostFragment
        val navController = navHostFragment.navController
    }
}
