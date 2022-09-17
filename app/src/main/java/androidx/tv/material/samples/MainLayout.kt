package androidx.tv.material.samples

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.tv.foundation.lazy.list.TvLazyColumn

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainLayout() {
    val paddedModifier = Modifier.padding(horizontal = 50.dp)
    val focusManager = LocalFocusManager.current

    TvLazyColumn(
        contentPadding = PaddingValues(bottom = 100.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        item {
            Box {
                TopNav(
                    modifier = paddedModifier
                        .zIndex(1f)
                        .align(Alignment.TopCenter)
                        .padding(top = 30.dp)
                )
                FeaturedCarousel(modifier = Modifier
                    .zIndex(0f)
                    .onFocusChanged {
                        if (it.isFocused) {
                            focusManager.moveFocus(FocusDirection.Enter)
                        }
                    }
                    .focusable()
                )
            }
        }
        item {
            SampleLazyRow("Popular movies and shows")
        }
        item {
            AppFestiveFamilyTime()
        }
        item {
            SampleLazyRow("Bollywood films")
        }
        item {
            SampleLazyRow("Biopics")
        }
        item {
            SampleLazyRow("Comedies")
        }
    }
}
