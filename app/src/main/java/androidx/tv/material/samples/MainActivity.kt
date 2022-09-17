package androidx.tv.material.samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.tv.material.samples.ui.theme.EAPDemoAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { App() }
  }
}

@Composable
fun App() {
  EAPDemoAppTheme {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight(),
      color = Color.Black,
      contentColor = Color.White,
    ) {
      MainLayout()
    }
  }
}
