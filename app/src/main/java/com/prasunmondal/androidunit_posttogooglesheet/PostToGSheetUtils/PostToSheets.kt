package com.prasunmondal.androidunit_posttogooglesheet.PostToGSheetUtils

class PostToSheets {
    var po: PostToSheet_DO_NOT_USE =
        PostToSheet_DO_NOT_USE(
            "https://script.google.com/macros/s/AKfycbyoYcCSDEbXuDuGf0AhQjEi61ECAkl8JUv4ffNofz1yBIKfcT4/exec",
            "https://docs.google.com/spreadsheets/d/1gZA5tqllOArlLJb2nLcmLqfNR-cdgFzNqTl9ZKyzcOI/edit#gid=0",
            "test",
            "https://docs.google.com/spreadsheets/d/1gZA5tqllOArlLJb2nLcmLqfNR-cdgFzNqTl9ZKyzcOI/edit#gid=0",
            "run_logs",
            true, null
        )

    var qo: PostToSheet_DO_NOT_USE =
        PostToSheet_DO_NOT_USE(
            "https://script.google.com/macros/s/AKfycbyoYcCSDEbXuDuGf0AhQjEi61ECAkl8JUv4ffNofz1yBIKfcT4/exec",
            "https://docs.google.com/spreadsheets/d/1T0VRVqzwcaUCrB4_17ExJfH9cVYvwljlPj-8w6USL_8/edit#gid=0",
            "test",
            "https://docs.google.com/spreadsheets/d/1gZA5tqllOArlLJb2nLcmLqfNR-cdgFzNqTl9ZKyzcOI/edit#gid=0",
            "run_logs",
            true, listOf("Prasun")
        )

    fun skipPost(): Boolean {
        return false
    }

    object Singleton {
        var instance = PostToSheets()
    }
}