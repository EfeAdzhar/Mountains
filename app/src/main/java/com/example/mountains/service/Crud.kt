package com.example.mountains.service

interface Crud<E> {
    fun create(model : E)
    fun read(id : String)
    fun update(id : String, newModel : E)
    fun delete(id : String)
}