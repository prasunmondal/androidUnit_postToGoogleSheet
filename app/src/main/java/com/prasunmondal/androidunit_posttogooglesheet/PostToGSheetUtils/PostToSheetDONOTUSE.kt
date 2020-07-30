package com.prasunmondal.androidunit_posttogooglesheet.PostToGSheetUtils

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Response
import com.android.volley.RetryPolicy
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.StringRequest
import java.text.SimpleDateFormat
import java.util.*

class PostToSheetDONOTUSE(
    private var scriptURL: String,
    private var sheetURL: String,
    private var sheetTabname: String,
    private var templateSheetURL: String,
    private var templateSheetTabname: String,
    private var prependTimestamp: Boolean,
    var prependList: List<String>?
) {
    private fun write(
        context: Context,
        scriptID: String,
        spreadsheetURL: String,
        sheetName: String,
        templateSheetURL: String,
        templateSheetTabname: String,
        list: List<String>
    ) {
        val sendString = TextUtils.join("◔", list)

        val stringRequest: StringRequest =
            object : StringRequest(
                Method.POST, scriptID,
                Response.Listener { },
                Response.ErrorListener {}
            ) {
                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> =
                        HashMap()
                    params["action"] = "addItem"
                    params["spreadsheetURL"] = spreadsheetURL
                    params["sheetName"] = sheetName
                    params["templateSheetURL"] = templateSheetURL
                    params["templateTabName"] = templateSheetTabname
                    params["text"] = sendString
                    return params
                }
            }
        val socketTimeOut = 120000 // u can change this .. here it is 120 seconds
        val retryPolicy: RetryPolicy =
            DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        stringRequest.retryPolicy = retryPolicy
        val queue = Volley.newRequestQueue(context)
        queue.add(stringRequest)
    }

    @SuppressLint("SimpleDateFormat")
    fun post(list: List<String>, context: Context) {
        if (PostToSheets().skipPost())
            return
        val constructList: MutableList<String> = mutableListOf()
        try {
            val format = "yyyy-MM-dd HH:mm:ss:SSS"
            val sdf = SimpleDateFormat(format)

            if (this.prependTimestamp) {
                constructList.add(0, sdf.format(Date()))
            }
            if (!this.prependList.isNullOrEmpty()) {
                constructList.addAll(prependList!!)
            }
            constructList.addAll(list)
            write(
                context,
                this.scriptURL,
                this.sheetURL,
                this.sheetTabname,
                this.templateSheetURL,
                this.templateSheetTabname,
                constructList
            )
        } catch (e: Exception) {
        }
    }

    fun postIntoTab(list: List<String>, tabName: String, context: Context) {
        val temp = this.sheetTabname
        this.sheetTabname = tabName
        post(list, context)
        this.sheetTabname = temp
    }
}