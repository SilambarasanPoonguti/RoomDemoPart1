package com.silambar.roomdemopart1.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Farmer")
class FarmerEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "name")
    var farmerName: String = ""

    @ColumnInfo(name = "fatherName")
    var sonOf: String = ""

    var age: Int = 0

    var place: String = ""
}