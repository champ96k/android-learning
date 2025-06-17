package com.champ96k.newsstory.constants

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(isoDate: String?): String {
    return try {
        val zonedDateTime = ZonedDateTime.parse(isoDate)
        val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH)
        zonedDateTime.format(formatter)
    } catch (e: Exception) {
        "NA"
    }
}
