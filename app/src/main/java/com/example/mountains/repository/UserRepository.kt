package com.example.mountains.repository

import com.example.mountains.common.Crud
import com.example.mountains.model.User
import java.util.Optional

class UserRepository : Crud<User>{
    private val userList : MutableList<User> = mutableListOf()

    override fun create(model: User) {
        userList.add(model)
    }

    override fun read(id: String) : User? {
        return userList.find {user: User -> user.id == id}
    }

    override fun delete(id: String) {
        userList.remove(read(id))
    }

    override fun update(id: String, newModel: User) {
        delete(id)
        userList.add(newModel)
    }
}