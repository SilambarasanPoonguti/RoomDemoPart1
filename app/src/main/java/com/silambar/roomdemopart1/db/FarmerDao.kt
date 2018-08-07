package com.silambar.roomdemopart1.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface FarmerDao {

    @Query("SELECT * FROM Farmer")
    fun getAllFarmers(): List<FarmerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFarmer(vararg farmers:FarmerEntity)
}












