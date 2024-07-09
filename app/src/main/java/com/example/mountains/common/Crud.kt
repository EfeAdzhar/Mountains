package com.example.mountains.common

import java.util.Optional

interface Crud<E> {
    fun create(model : E)
    fun read(id : String) : E?
    fun update(id : String, newModel : E)
    fun delete(id : String)
}