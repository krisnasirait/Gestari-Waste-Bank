package com.eros.gestariwastebank.data.local.room

import androidx.room.*
import com.eros.gestariwastebank.data.model.cart.Cart

@Dao
interface CartDao {
    @Insert
    fun insert(item: Cart)

    @Update
    fun update(item: Cart)

    @Delete
    fun delete(item: Cart)

    @Query("SELECT * FROM cart")
    fun getAll(): List<Cart>
}