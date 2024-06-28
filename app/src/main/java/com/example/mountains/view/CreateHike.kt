package com.example.mountains.view

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mountains.R
import com.example.mountains.dto.PersonalHikeDto
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlin.math.log

class CreateHike : AppCompatActivity() {

    private val dto = PersonalHikeDto()
    private lateinit var priceEditText : EditText

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

        val difficultyButtonToggleGroup =
            findViewById<MaterialButtonToggleGroup>(R.id.difficulty_toggle_button_group)
        val genderButtonToggleGroup =
            findViewById<MaterialButtonToggleGroup>(R.id.gender_toggle_button_group)
        val priceButtonToggleGroup =
            findViewById<MaterialButtonToggleGroup>(R.id.price_toggle_button_group)

        difficultyButtonToggleGroup.addOnButtonCheckedListener() { difficultyToggleGroup, id, isChecked ->
            if(isChecked) {
                when(id) {
                    R.id.easy_button -> dto.difficulty = "EASY"
                    R.id.medium_button -> dto.difficulty = "MEDIUM"
                    R.id.hard_button -> dto.difficulty = "HARD"
                }
            } else if(difficultyToggleGroup.id == View.NO_ID) {
                //TODO(should be added nextButton logic (if nothing is selected, you can't continue))
            }
        }
        genderButtonToggleGroup.addOnButtonCheckedListener() { genderToggleGroup, id, isChecked ->
            if(isChecked) {
                when(id) {
                    R.id.mixed_group -> dto.groupType = "MIXED"
                    R.id.female_group -> dto.groupType = "FEMALE_ONLY"
                    R.id.female_group -> dto.groupType = "MALE_ONLY"
                }
            } else if(genderToggleGroup.id == View.NO_ID) {
                //TODO(should be added nextButton logic (if nothing is selected, you can't continue))
            }
        }
        priceButtonToggleGroup.addOnButtonCheckedListener() {priceToggleGroup, id, isChecked ->
            if(isChecked) {
                when(id) {
                    R.id.free_hike -> dto.hikePrice = "FREE"
                    R.id.commercial_hike -> {
                        dto.hikePrice = "COMMERCIAL"
                        priceEditText.alpha = 1.0F
                      /* TODO(Make this check when moving to next Activity) try {
                            dto.price = priceEditText.text.toString().toInt()
                        } catch (e : Exception) {
                            println("Failure to convert Hike price to Integer")
                            println(e.localizedMessage)
                            throw e
                        }
                       */
                    }
                }
            }
        }
    }
}