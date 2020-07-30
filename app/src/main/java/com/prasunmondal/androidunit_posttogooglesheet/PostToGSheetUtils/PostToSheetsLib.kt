package com.prasunmondal.androidunit_posttogooglesheet.PostToGSheetUtils

import android.content.Context
import android.text.TextUtils
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Response
import com.android.volley.RetryPolicy
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.StringRequest
import com.prasunmondal.androidunit_posttogooglesheet.BuildConfig
import java.text.SimpleDateFormat
import java.util.*

class PostToSheet_DO_NOT_USE(scriptURL: String, sheet_output_URL: String,
                             sheet_output_name: String, template_output_URL: String,
                             template_output_name: String, prependTimestamp: Boolean) {

    private var scriptURL = scriptURL
    private var sheet_output_URL = sheet_output_URL
    private var sheet_output_name = sheet_output_name
    private var template_output_URL = template_output_URL
    private var template_output_name = template_output_name
    private var prependTimestamp = prependTimestamp

    private fun write(context: Context, scriptID: String, spreadsheetURL: String, sheetName: String, list: List<String>) {
        var sendString = TextUtils.join("◔", list)

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


    fun post(list: MutableList<String>, context: Context) {
        var isDev = false

        if(isDev)
            return
        try {
            var appVersion = BuildConfig.VERSION_CODE.toString()

            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val format = "yyyy-MM-dd HH:mm:ss:SSS"
            val sdf = SimpleDateFormat(format)
            dateFormat.timeZone = TimeZone.getTimeZone("IST")

            if(this.prependTimestamp) {
                list.add(0, "0")
            }

            write(context,
                this.scriptURL,
                this.sheet_output_URL,
                this.sheet_output_name,
                list)
        } catch (e: Exception) {
        }
    }

    fun postIntoTab(list: MutableList<String>, tabName: String, context: Context) {
        var temp = this.sheet_output_name
        this.sheet_output_name = tabName
        post(list, context)
        this.sheet_output_name = temp
    }
}

