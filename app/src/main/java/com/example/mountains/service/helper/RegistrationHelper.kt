package com.example.mountains.service.helper

class RegistrationHelper : UserHelper {

    override fun validName(name: String): Boolean {
        return name.isNotEmpty()
    }

    override fun validEmail(email: String): Boolean {
        return !(!email.contains("@")
                || !email.contains("mail")
                || !email.contains("com"))
    }

    override fun validatePassword(password: String): Boolean {
           return password.length >= 6
        }
    }