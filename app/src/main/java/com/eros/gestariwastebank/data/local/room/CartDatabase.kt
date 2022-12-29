package com.eros.gestariwastebank.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eros.gestariwastebank.data.model.cart.Cart

@Database(
    entities =[Cart::class],
    version = 1
)
abstract class CartDatabase : RoomDatabase() {

    abstract fun cartDao() : CartDao

    companion object {
        private var INSTANCE : CartDatabase? = null
        fun getInstance (context: Context) : CartDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CartDatabase::class.java,
                    "cart-db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}