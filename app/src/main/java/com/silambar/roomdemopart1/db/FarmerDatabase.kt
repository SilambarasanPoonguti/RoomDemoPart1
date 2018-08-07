package com.silambar.roomdemopart1.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [(FarmerEntity::class)], version = 1)
abstract class FarmerDatabase : RoomDatabase() {

    abstract fun getFarmerDao(): FarmerDao

    companion object {
        var DB_INSTANCE: FarmerDatabase? = null

        fun getDb(context: Context): FarmerDatabase? {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.inMemoryDatabaseBuilder(context.applicationContext, FarmerDatabase::class.java)
                        .allowMainThreadQueries()
                        .build()
            }

            return DB_INSTANCE
        }

        fun clearDBInstance() {
            DB_INSTANCE = null
        }
    }

}