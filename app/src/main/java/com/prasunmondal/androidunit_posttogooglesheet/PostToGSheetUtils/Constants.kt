package com.prasunmondal.androidunit_posttogooglesheet.PostToGSheetUtils

class Constants {
    fun createProfile(scriptURL: String, sheet_output_URL: String,
                      sheet_output_name: String, template_output_URL: String,
                      template_output_name: String) {
        var t: PostProfile = PostProfile(scriptURL, sheet_output_URL, sheet_output_name, template_output_URL, template_output_name)
    }
}

class PostProfile(scriptURL: String, sheet_output_URL: String,
                  sheet_output_name: String, template_output_URL: String,
                  template_output_name: String) {

    var scriptURL = scriptURL
    var sheet_output_URL = sheet_output_URL
    var sheet_output_name = sheet_output_name
    var template_output_URL = template_output_URL
    var template_output_name = template_output_name
}