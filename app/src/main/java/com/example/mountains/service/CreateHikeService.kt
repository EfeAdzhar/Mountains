package com.example.mountains.service

import com.example.mountains.model.PersonalHike
import com.example.mountains.common.Crud
import com.example.mountains.repository.UserRepository

class CreateHikeService : Crud<PersonalHike> {

    override fun create(model: PersonalHike) {
    }

    override fun read(id: String) : PersonalHike? {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun update(id: String, newModel: PersonalHike) {
        TODO("Not yet implemented")
    }
}