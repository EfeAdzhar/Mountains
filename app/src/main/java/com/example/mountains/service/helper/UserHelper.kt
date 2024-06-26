package com.example.mountains.service.helper

interface UserHelper {
    fun validName(name : String): Boolean
    fun validEmail(email : String): Boolean
    fun validatePassword(password : String) : Boolean
}