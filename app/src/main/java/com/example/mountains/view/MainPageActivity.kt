package com.example.mountains.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mountains.R

class MainPageActivity : AppCompatActivity() {

    private lateinit var linearLayout: LinearLayout
    private lateinit var addHike: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_page)

        linearLayout = findViewById(R.id.linear_layout)
        val inflater = LayoutInflater.from(this)

        addHike = findViewById(R.id.add_image_view)
        addHike.setOnClickListener() {
            val intent = Intent(this, CreateHike::class.java)
            startActivity(intent)
        }

        for(i in 0..4) {
            val travelLayout = inflater.inflate(R.layout.travel_constraint_layout, linearLayout, false)
            linearLayout.addView(travelLayout)
        }
    }
}