package co.tpcreative.qrcode_compose_multipleplatforms.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class PersonEntity(val name: String, @PrimaryKey(autoGenerate = true)val id: Int = 0)
