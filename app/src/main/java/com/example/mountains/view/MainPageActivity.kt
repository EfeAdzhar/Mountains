package com.example.mountains.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ScrollingView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mountains.R

class MainPageActivity : AppCompatActivity() {

    private lateinit var linearLayout: LinearLayout
    private lateinit var travelFrameLayout : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        linearLayout = findViewById(R.id.linear_layout)
        val inflater = LayoutInflater.from(this)

        for(i in 0..4) {
            val travelFrameLayout = inflater.inflate(R.layout.travel_frame_layout, linearLayout, false)
            linearLayout.addView(travelFrameLayout)
        }
    }
}