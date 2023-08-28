import androidx.compose.runtime.Composable

@Composable fun MainView() = App()

actual fun getPlatformName(): String = "Android ${android.os.Build.VERSION.SDK_INT}"