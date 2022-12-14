package me.dio.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BusinessCardDao {
    @Query("SELECT * FROM BusinessCard")
    fun getALl(): LiveData<List<BusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard:BusinessCard)
}