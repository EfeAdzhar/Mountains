package com.example.mountains.dto

class PersonalHikeDto {
   private var _difficulty: String = ""
   private var _groupType: String = ""
   private var _hikePrice: String = ""
   private var _price: Int = 0
   private var _transferType: String = ""

   var difficulty: String
      get() = _difficulty
      set(value) {
         _difficulty = value
      }

   var groupType: String
      get() = _groupType
      set(value) {
         _groupType = value
      }

   var hikePrice: String
      get() = _hikePrice
      set(value) {
         _hikePrice = value
      }

   var transferType: String
      get() = _transferType
      set(value) {
         _transferType = value
      }

   var price: Int
      get() = _price
      set(value) {
         _price = value
      }
}