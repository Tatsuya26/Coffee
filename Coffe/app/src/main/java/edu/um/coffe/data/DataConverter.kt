package edu.um.coffe.data

import androidx.room.TypeConverter
import java.time.LocalDateTime

object DataConverter {
    @TypeConverter
    fun toDate(dateString: String?): LocalDateTime? {
        return if (dateString == null) {
            null
        } else {
            LocalDateTime.parse(dateString)
        }
    }

    @TypeConverter
    fun toDateString(date: LocalDateTime?): String? {
        return if (date == null) {
            null
        } else {
            date.toString()
        }
    }
}