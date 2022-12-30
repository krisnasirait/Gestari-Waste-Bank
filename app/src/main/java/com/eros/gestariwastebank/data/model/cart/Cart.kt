package com.eros.gestariwastebank.data.model.cart

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Cart(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id : Int?,
    @SerializedName("name")
    val name : String?,
    @SerializedName("itemImage")
    val itemImage : String?,
    @SerializedName("amount")
    val amount : Int?,
    @SerializedName("price")
    val price : String?
)