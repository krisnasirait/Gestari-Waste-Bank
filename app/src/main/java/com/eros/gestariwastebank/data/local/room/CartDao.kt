package com.eros.gestariwastebank.data.local.room

import androidx.room.*
import com.eros.gestariwastebank.data.model.cart.Cart

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: Cart)

    @Update
    fun update(item: Cart)

    @Delete
    fun delete(item: Cart)

    @Query("SELECT * FROM cart")
    fun getAll(): List<Cart>

    @Query("INSERT OR REPLACE INTO Cart(id, name, itemImage, amount, price) VALUES (:id, :name, :itemImage, COALESCE((SELECT amount FROM Cart WHERE id = :id), 0) + :amount, :price)")
    fun addOrInsertById(id: Int, name: String, itemImage: String, amount: Int, price: Int)

    @Query("SELECT COUNT(*) FROM customers")
    fun getRowCount(): Int

    @Query("UPDATE Cart SET amount = amount - 1 WHERE id = :id AND amount >= 1; DELETE FROM Cart WHERE id = :id AND amount < 1")
    fun decrementQuantity(productId: Int)

    @Query("UPDATE Cart SET amount = amount + 1 WHERE id = :id")
    fun incrementQuantity(productId: Int)
}