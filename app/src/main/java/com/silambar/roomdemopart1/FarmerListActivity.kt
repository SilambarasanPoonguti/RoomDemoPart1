package com.silambar.roomdemopart1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.silambar.roomdemopart1.db.FarmerDatabase
import com.silambar.roomdemopart1.db.FarmerEntity
import kotlinx.android.synthetic.main.activity_farmer_list.*

class FarmerListActivity : AppCompatActivity() {

    private var database: FarmerDatabase? = null
    private val DELAY_MILLIS: Long = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmer_list)

        database = FarmerDatabase.getDb(this)
        database?.let { insertDummyFarmers(it) }

        create_farmer.setOnClickListener {
            startActivity(
                    Intent(this@FarmerListActivity, CreateFarmerActivity::class.java)
            )
        }
    }

    override fun onStart() {
        super.onStart()
        farmer_list.layoutManager = LinearLayoutManager(this)
        farmer_list.itemAnimator = DefaultItemAnimator()
        val list: List<FarmerEntity>? = database?.getFarmerDao()?.getAllFarmers()
        farmer_list.adapter = list?.let { FarmerAdapter(it) }
    }

    private fun insertDummyFarmers(database: FarmerDatabase) {

        val farmer = FarmerEntity()
        farmer.farmerName = "Karthikaeyan"
        farmer.sonOf = "Sivan"
        farmer.age = 48
        farmer.place = "Maruthamalai, Coimbatore"
        database.getFarmerDao().insertFarmer(farmer)
        Thread.sleep(DELAY_MILLIS)

        val farmer1 = FarmerEntity()
        farmer1.farmerName = "Munish kanth"
        farmer1.sonOf = "Rama rajan"
        farmer1.age = 44
        farmer1.place = "Pollachi, Coimbatore"
        database.getFarmerDao().insertFarmer(farmer1)
        Thread.sleep(DELAY_MILLIS)

        val farmer2 = FarmerEntity()
        farmer2.farmerName = "Sinraasu"
        farmer2.sonOf = "Thiruthondar"
        farmer2.age = 48
        farmer2.place = "Vandicholai, Coimbatore"
        database.getFarmerDao().insertFarmer(farmer2)
        Thread.sleep(DELAY_MILLIS)
    }

    override fun onDestroy() {
        super.onDestroy()
        FarmerDatabase.clearDBInstance()
    }

}
