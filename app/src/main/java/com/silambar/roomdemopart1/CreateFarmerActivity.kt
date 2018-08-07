package com.silambar.roomdemopart1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.silambar.roomdemopart1.db.FarmerDatabase
import com.silambar.roomdemopart1.db.FarmerEntity
import kotlinx.android.synthetic.main.activity_create_farmer.*

class CreateFarmerActivity : AppCompatActivity() {

    private var database: FarmerDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_farmer)

        database = FarmerDatabase.getDb(this)

        back.setOnClickListener { finish() }
        insert.setOnClickListener { insertFarmer() }
    }

    private fun insertFarmer() {
        val farmer = FarmerEntity()
        farmer.farmerName = name.text.toString()
        farmer.sonOf = father_name.text.toString()
        farmer.age = Integer.parseInt(age.text.toString())
        farmer.place = place.text.toString()
        database?.getFarmerDao()?.insertFarmer(farmer)

        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        FarmerDatabase.clearDBInstance()
    }

}
