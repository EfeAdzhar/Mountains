package com.example.mountains.service

import com.example.mountains.model.User
import com.example.mountains.common.Crud
import com.example.mountains.repository.UserRepository

class UserService : Crud<User> {

private val repository = UserRepository()

    override fun create(model: User) {
        this.repository.create(model)
    }

    override fun read(id: String) : User? {
       return this.repository.read(id)
    }

    override fun delete(id: String) {
        this.repository.delete(id)
    }

    override fun update(id: String, newModel: User) {
        this.repository.update(id, newModel)
    }
}