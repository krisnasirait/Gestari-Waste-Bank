package com.eros.gestariwastebank.data.model.cart

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Cart(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,
    var name : String?,
    var itemImage : String?,
    var amount : Int?,
    var price : String?
) : Parcelable