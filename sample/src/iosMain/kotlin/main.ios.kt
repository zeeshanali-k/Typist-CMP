import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIDevice

fun MainViewController() = ComposeUIViewController { App() }

actual fun getPlatformName(): String = "iOS ${UIDevice.currentDevice.systemName} ${UIDevice.currentDevice.systemVersion}"