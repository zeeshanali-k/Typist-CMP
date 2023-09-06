import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devscion.typistcmp.Typist


@Composable
fun App() {
    MaterialTheme {
        val greetingText = remember { "Typist is typing on ${getPlatformName()}" }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedButton(onClick = {}) {
                Typist(greetingText)
            }
            Spacer(Modifier.height(15.dp))
            OutlinedButton(onClick = {}) {
                Typist(greetingText, isInfinite = true)
            }
            Spacer(Modifier.height(15.dp))
            OutlinedButton(onClick = {}) {
                Typist(listOf(greetingText, "I just typed on ${getPlatformName()}"))
            }
            Spacer(Modifier.height(15.dp))
            OutlinedButton(onClick = {}) {
                Typist(
                    listOf(
                        greetingText, "I just typed on ${getPlatformName()}",
                    ),
                    isInfinite = true
                )
            }
        }
    }
}

expect fun  getPlatformName(): String