package androidx.tv.material.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val topNavItems = listOf("Search", "For you", "Movies", "Shows", "Apps", "Library")

@Composable
fun TopNav(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Google TV",
                    fontSize = 13.sp,
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(end = 30.dp)
                )

                for (topNavItem in topNavItems) {
                    val content: @Composable (RowScope.() -> Unit) = {
                        if (topNavItem == "Search") {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                            Spacer(modifier = Modifier.width(5.dp))
                        }
                        Text(text = topNavItem)
                    }
                    TabButton(content = content)
                }
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = Color.Gray),
            ) {
                Text(text = "RV")
            }
        }
    }
}

@Composable
private fun TabButton(
        modifier: Modifier = Modifier,
        content: @Composable (RowScope.() -> Unit)) {
    val primary = MaterialTheme.colors.primary
    val onPrimary = MaterialTheme.colors.onPrimary
    var backgroundColor by remember { mutableStateOf(Color.Transparent) }
    var contentColor by remember { mutableStateOf(primary) }

    TextButton(
            onClick = {},
            modifier = modifier.onFocusChanged {
                  if (it.isFocused) {
                      backgroundColor = primary
                      contentColor = onPrimary
                  } else {
                      backgroundColor = Color.Transparent
                      contentColor = primary
                  }
            }.shadow(0.dp),
            colors = ButtonDefaults.buttonColors(
                    backgroundColor = backgroundColor,
                    contentColor = contentColor,
            ),
            content = content
    )
}

@Preview(device = Devices.NEXUS_10, showBackground = true)
@Composable
fun TopNavPreview() {
    TopNav()
}
