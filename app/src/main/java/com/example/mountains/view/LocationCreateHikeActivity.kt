package com.example.mountains.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mountains.R

class LocationCreateHikeActivity : AppCompatActivity() {

    private lateinit var cancelButton : TextView
    private lateinit var backTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.location_create_hike_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.location_create_hike_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cancelButton = findViewById(R.id.cancel_button_location_view)
        backTextView = findViewById(R.id.back_text_view)

        cancelButton.setOnClickListener() {
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
        }
        backTextView.setOnClickListener() {
            val intent = Intent(this, CreateHike::class.java)
            startActivity(intent)
        }
    }
}