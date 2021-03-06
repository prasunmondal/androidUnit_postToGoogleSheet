package com.prasunmondal.androidunit_posttogooglesheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prasunmondal.androidunit_posttogooglesheet.PostToGSheetUtils.PostToSheets

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PostToSheets.Singleton.instance.qo.updatePrependList(listOf("Prasun Mondal"))
        PostToSheets.Singleton.instance.qo.post(listOf("startTime","endTime","calcTime"),this)
        PostToSheets.Singleton.instance.qo.postIntoTab(listOf("startTime","endTime","calcTime"),"newTab",this)
        PostToSheets.Singleton.instance.qo.post(listOf("startTime","endTime","calcTime"), this)
        PostToSheets.Singleton.instance.po.post(listOf("startTime","endTime","calcTime"), this)
    }
}