package omkar.android.projects

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import omkar.android.projects.app.utils.KoinUtils

fun main() = application {
    KoinUtils.startKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Spike",
    ) {
        App()
    }
}