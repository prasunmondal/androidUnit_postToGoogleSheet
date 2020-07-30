package com.prasunmondal.androidunit_posttogooglesheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prasunmondal.androidunit_posttogooglesheet.PostToGSheetUtils.PostToSheets

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PostToSheets.Singleton.instance.qo.post(mutableListOf("startTime","endTime","calcTime"),this)
        PostToSheets.Singleton.instance.qo.postIntoTab(mutableListOf("startTime","endTime","calcTime"),"newTab",this)
        PostToSheets.Singleton.instance.qo.post(mutableListOf("startTime","endTime","calcTime"), this)
    }
}
