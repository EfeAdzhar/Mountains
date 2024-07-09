package com.example.mountains.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mountains.R
import com.example.mountains.dto.UserPasswordDto
import com.example.mountains.model.User
import com.example.mountains.service.UserPasswordService
import com.example.mountains.service.UserService
import com.example.mountains.service.helper.RegistrationHelper
import com.example.mountains.service.helper.UserPasswordHelper
import java.util.UUID

class RegistrationActivity : AppCompatActivity() {
    private lateinit var userEmail: EditText
    private lateinit var userPassword: EditText
    private lateinit var userLogin: EditText
    private lateinit var errorMessage: TextView
    private lateinit var registrationButton: TextView
    private lateinit var skipButton: TextView
    private var registrationHelper = RegistrationHelper()
    private val service: UserService = UserService()
    private var passwordService = UserPasswordService()
    private var userEmailString: String = ""
    private var userLoginString: String = ""
    private var userPasswordString: String = ""
    private var validUserEmail = false
    private var validUserPassword= false
    private var validUserLogin = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registration_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.registration)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userEmail = findViewById(R.id.user_email)
        userPassword = findViewById(R.id.password)
        userLogin = findViewById(R.id.name)
        errorMessage = findViewById(R.id.error_message)
        registrationButton = findViewById(R.id.registration_button)

        skipButton = findViewById(R.id.skip_button)

        skipButton.setOnClickListener() {
            changeActivity()
        }

        registrationButton.setOnClickListener() {
            if(validUserEmail && validUserLogin && validUserPassword) {
                changeActivity()
            }
            else if (!validUserEmail) {
                userEmailString = userEmail.text.toString()
                if (registrationHelper.validEmail(userEmailString)) {
                    userPassword.alpha = 1.0F
                    errorMessage.alpha = 0.0F
                    errorMessage.text = this.getString(R.string.empty_error_message)
                    validUserEmail = true
                } else {
                    errorMessage.text = this.getString(R.string.invalid_email)
                    errorMessage.alpha = 1.0F
                }
            } else if (!validUserPassword) {
                userPasswordString = userPassword.text.toString()
                if (registrationHelper.validatePassword(userPasswordString)) {
                    userLogin.alpha = 1.0F
                    errorMessage.alpha = 0.0F
                    errorMessage.text = this.getString(R.string.empty_error_message)
                    validUserPassword = true
                } else {
                    this.errorMessage.text = this.getString(R.string.invalid_password)
                    this.errorMessage.alpha = 1.0F
                }
            }
            else if (!validUserLogin) {
                userLoginString = userLogin.text.toString()
                if (registrationHelper.validName(userLoginString)) {
                    errorMessage.alpha = 0.0F
                    errorMessage.text = this.getString(R.string.empty_error_message)
                    validUserLogin = true

                    val user = User(
                        UUID.randomUUID().toString(), userLoginString, userEmailString)

                    //TODO(Ceaser Chifr works incorrectly (should be second argument in dto))
                    val passwordDto = UserPasswordDto(
                        user.id,
                       userPasswordString)
                    //TODO(services)
                    //service.create(user)
                    //passwordService.saveSecuredPass(passwordDto)
                    changeActivity()
                } else {
                    errorMessage.text = this.getString(R.string.invalid_login)
                    errorMessage.alpha = 1.0F
                }
            }
        }
    }

    private fun changeActivity() {
        val intent = Intent(
            this,
            MainPageActivity::class.java)
        this.startActivity(intent)
    }
}