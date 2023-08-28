import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIDevice

fun MainViewController() = ComposeUIViewController { App() }

actual fun getPlatformName(): String = "${UIDevice.currentDevice.systemName} ${UIDevice.currentDevice.systemVersion}"