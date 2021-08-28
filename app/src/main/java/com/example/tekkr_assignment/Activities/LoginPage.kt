package com.example.tekkr_assignment.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tekkr_assignment.R
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var isRemember = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemember = sharedPreferences.getBoolean("CHECKBOX", false)

        if(isRemember){
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
            finish()
        }

        login_button.setOnClickListener {
            val userName: String = username_ET.text.toString()
            val password: String = password_ET.text.toString()
            var isChecked: Boolean = checkBox.isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("USERNAME", userName)
            editor.putString("PASSWORD", password)
            editor.putBoolean("CHECKBOX", isChecked)
            editor.apply()

            Toast.makeText(this,"Welcome", Toast.LENGTH_LONG).show()
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
            finish()
        }
    }
}