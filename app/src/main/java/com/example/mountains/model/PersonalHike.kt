package com.example.mountains.model

import androidx.annotation.OpenForTesting
import com.example.mountains.model.enums.HikeDifficulty
import com.example.mountains.model.enums.HikeGroup
import com.example.mountains.model.enums.HikePrice
import com.example.mountains.model.enums.HikeTransfer

data class PersonalHike(val difficulty : HikeDifficulty,
                        val groupType : HikeGroup,
                        val hikePrice : HikePrice,
                        val transferType : HikeTransfer,
                        val price : Int) {}
