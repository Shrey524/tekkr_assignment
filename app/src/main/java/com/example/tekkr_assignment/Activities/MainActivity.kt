package com.example.tekkr_assignment.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.tekkr_assignment.R

class MainActivity : AppCompatActivity() {
	private val handler = Handler()
	private lateinit var mContext: Context
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		mContext = this
		handler.postDelayed(object : Runnable {
			override fun run() {
				val intent = Intent(mContext, LoginPage::class.java)
				startActivity(intent)
				overridePendingTransition(0, R.anim.fade)
				handler.removeCallbacks(this)
			}
		}, 3000)
	}
}