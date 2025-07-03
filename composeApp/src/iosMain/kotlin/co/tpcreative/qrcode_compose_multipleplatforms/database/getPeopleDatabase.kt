package com.example.demo.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import co.tpcreative.qrcode_compose_multipleplatforms.database.PeopleDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSUserDomainMask

//fun  getPeopleDatabase() : PeopleDatabase {
//    val dbFile = NSHomeDirectory() + "/people.db"
//    return Room.databaseBuilder<PeopleDatabase>(name = dbFile, factory = {
//        PeopleDatabase::class.instantiateImpl()
//    })
//        .setDriver(BundledSQLiteDriver())
//        .build()
//}


fun getPeopleDatabase(): RoomDatabase.Builder<PeopleDatabase> {
    val dbFilePath = documentDirectory() + "/people.db"
    return Room.databaseBuilder<PeopleDatabase>(
        name = dbFilePath,
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}


//fun getDatabaseBuilder(): PeopleDatabase.Builder<PeopleDatabase> {
//    val dbFilePath = documentDirectory() + "/movie_database.db"
//    return Room.databaseBuilder<PeopleDatabase>(
//        name = dbFilePath,
//    )
//}
//
//@OptIn(ExperimentalForeignApi::class)
//private fun documentDirectory(): String {
//    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
//        directory = NSDocumentDirectory,
//        inDomain = NSUserDomainMask,
//        appropriateForURL = null,
//        create = false,
//        error = null,
//    )
//
//    return requireNotNull(documentDirectory?.path)
//}
