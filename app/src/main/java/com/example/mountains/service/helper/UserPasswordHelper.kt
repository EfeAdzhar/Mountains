package com.example.mountains.service.helper

import com.example.mountains.dto.UserPasswordDto

class UserPasswordHelper {
    companion object {
        @JvmStatic
        fun ceaserChifr(password : String) : String {
            try {
                val alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray()
                val passwordCharArray = password.toCharArray()

                for (letter in passwordCharArray) {
                    for (alphabetLetter in alphabet) {
                        if (letter.equals(alphabetLetter, ignoreCase = true)) {
                            val alpIndex = alphabet.indexOf(alphabetLetter)
                            val passIndex = passwordCharArray.indexOf(letter)
                            passwordCharArray[passIndex] = alphabet[alpIndex + 8]
                        }
                    }
                }
                return passwordCharArray.toString()
            } catch (e : Exception) {
                println(e.localizedMessage)
                throw e
            }
        }
    }
}