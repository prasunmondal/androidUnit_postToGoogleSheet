package com.prasunmondal.androidunit_posttogooglesheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prasunmondal.androidunit_posttogooglesheet.PostToGSheetUtils.PostToSheets

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PostToSheets.Singleton.instance.po.post("startTime","endTime","calcTime",this)
    }
}
