package co.tpcreative.qrcode_compose_multipleplatforms

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import co.tpcreative.qrcode_compose_multipleplatforms.database.getDatabaseBuilder
import kotlinx.coroutines.Dispatchers

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "demo",
    ) {

        val dao = getDatabaseBuilder().setDriver(BundledSQLiteDriver()).setQueryCoroutineContext(Dispatchers.IO).build().peopleDao()
        App(dao)
    }
}