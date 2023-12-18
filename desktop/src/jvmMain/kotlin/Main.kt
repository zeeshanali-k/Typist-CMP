import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main(): Unit = application {
    Window(
        title = "Typist CMP",
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
