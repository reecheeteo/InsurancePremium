package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var myData: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)
        display()
       // var total: Double

        cal_btn.setOnClickListener(){
           // total = getPremium()
           // totalPremium.text = "RM " + "%.2f".format(total).toString()
            myData.premiumAmount = getPremium()
            display()
        }

        reset_btn.setOnClickListener(){
            spinnerAge.setSelection(0)
            radGroup.clearCheck()
            chkSmoker.setChecked(false)
            myData.premiumAmount = 0.0
            totalPremium.text =""
        }


    }
    fun display(){
        if(myData.premiumAmount!=0.0)
            totalPremium.text = "RM " + "%.2f".format(myData.premiumAmount).toString()
    }

    fun getPremium():Double{
        return when(spinnerAge.selectedItemPosition) {
            0 -> 60.0
            1 -> 70.0 + (if(radMale.isChecked) 50.0 else 0.0) + (if(chkSmoker.isChecked) 100.0 else 0.0)
            2 -> 90.0 + (if(radMale.isChecked) 100.0 else 0.0) + (if(chkSmoker.isChecked) 150.0 else 0.0)
            3 -> 120.0 + (if(radMale.isChecked) 150.0 else 0.0) + (if(chkSmoker.isChecked) 200.0 else 0.0)
            4 -> 150.0 + (if(radMale.isChecked) 200.0 else 0.0) + (if(chkSmoker.isChecked) 250.0 else 0.0)
            else ->150.0 + (if(radMale.isChecked) 200.0 else 0.0) + (if(chkSmoker.isChecked) 300.0 else 0.0)
        }
    }
}
