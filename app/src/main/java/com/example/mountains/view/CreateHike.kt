package com.example.mountains.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mountains.R
import com.example.mountains.dto.PersonalHikeDto
import com.example.mountains.service.CreateHikeService
import com.google.android.material.button.MaterialButtonToggleGroup


class CreateHike : AppCompatActivity() {

    private val dto = PersonalHikeDto()
    private lateinit var priceEditText: EditText
    private lateinit var nextStep: TextView
    private lateinit var errorMessage: TextView
    private lateinit var cancelTextView : TextView
    private val createHikeService = CreateHikeService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.create_hike_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.create_hike_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        priceEditText = findViewById(R.id.price_edit_view)
        nextStep = findViewById(R.id.next_step_text_view)
        cancelTextView = findViewById(R.id.cancel_text_view)

        val difficultyButtonToggleGroup =
            findViewById<MaterialButtonToggleGroup>(R.id.difficulty_toggle_button_group)
        val genderButtonToggleGroup =
            findViewById<MaterialButtonToggleGroup>(R.id.gender_toggle_button_group)
        val priceButtonToggleGroup =
            findViewById<MaterialButtonToggleGroup>(R.id.price_toggle_button_group)
        val transferButtonToggleGroup =
            findViewById<MaterialButtonToggleGroup>(R.id.transfer_toggle_button_group)

        cancelTextView.setOnClickListener() {
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
        }

        difficultyButtonToggleGroup.addOnButtonCheckedListener() { difficultyToggleGroup, id, isChecked ->
            if (isChecked) {
                when (id) {
                    R.id.easy_button -> dto.difficulty = "EASY"
                    R.id.medium_button -> dto.difficulty = "MEDIUM"
                    R.id.hard_button -> dto.difficulty = "HARD"
                }
            } else if (difficultyToggleGroup.id == View.NO_ID) {
                //TODO(should be added nextButton logic (if nothing is selected, you can't continue))
            }
        }
        genderButtonToggleGroup.addOnButtonCheckedListener() { genderToggleGroup, id, isChecked ->
            if (isChecked) {
                when (id) {
                    R.id.mixed_group -> dto.groupType = "MIXED"
                    R.id.female_group -> dto.groupType = "FEMALE_ONLY"
                    R.id.female_group -> dto.groupType = "MALE_ONLY"
                }
            } else if (genderToggleGroup.id == View.NO_ID) {
                //TODO(should be added nextButton logic (if nothing is selected, you can't continue))
            }
        }
        priceButtonToggleGroup.addOnButtonCheckedListener() { priceToggleGroup, id, isChecked ->
            if (isChecked) {
                when (id) {
                    R.id.free_hike -> {
                        dto.hikePrice = "FREE"
                        priceEditText.alpha = 0.0F
                    }

                    R.id.commercial_hike -> {
                        dto.hikePrice = "COMMERCIAL"
                        priceEditText.alpha = 1.0F
                    }
                }
            } else if (priceToggleGroup.id == View.NO_ID) {
                //TODO(should be added nextButton logic (if nothing is selected, you can't continue))
            }
        }
        transferButtonToggleGroup.addOnButtonCheckedListener() { transgerToggleGroup, id, isChecked ->
            if (isChecked) {
                when (id) {
                    R.id.solely_button -> dto.transferType = "SOLELY"
                    R.id.fueд_only_button -> dto.transferType = "FUEL_ONLY"
                    R.id.free_button -> dto.transferType = "FREE"
                }
            }
        }
        errorMessage = findViewById(R.id.error_message_text)

        nextStep.setOnClickListener() {
            if (dto.difficulty.isEmpty()) {
                errorMessage.alpha = 1.0F
                errorMessage.text = getString(R.string.difficulty_not_selected)
            } else if(dto.groupType.isEmpty()) {
                errorMessage.alpha = 1.0F
                errorMessage.text = getString(R.string.group_not_selected)
            }
            else if (dto.hikePrice.isEmpty()) {
                errorMessage.text = getString(R.string.price_not_selected)
                errorMessage.alpha = 1.0F
            } else if (dto.transferType.isEmpty()) {
                errorMessage.text = getString(R.string.transfer_not_selected)
                errorMessage.alpha = 1.0F
            } else {
                try {
                    if(dto.hikePrice.equals("COMMERCIAL")) {
                        if (priceEditText.text.isEmpty()) {
                            errorMessage.text = getString(R.string.worth_not_specified)
                            errorMessage.alpha = 1.0F
                        } else {
                            errorMessage.alpha = 0.0F
                            val priceEditTextString = priceEditText.text.toString().toInt()
                            dto.price = priceEditTextString
                        }
                    }

                    //createHikeService.create(dto)

                    val intent = Intent(
                        this,
                        LocationCreateHikeActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    errorMessage.alpha = 1.0F
                    errorMessage.text = getString(R.string.invalid_price)
                }
            }
        }
    }
}