package androidx.tv.material.samples

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material.samples.data.Show
import androidx.tv.material.samples.utils.getImage
import androidx.tv.material.samples.utils.getRandomShows

@Composable
fun SampleLazyRow(
    heading: String,
    modifier: Modifier = Modifier,
    itemCount: Int = 5
) {
    val shows = remember(itemCount) { getRandomShows(itemCount) }
    var hasFocus by remember { mutableStateOf(false) }
    val titleColor = if (hasFocus) Color.White else Color.Gray
    val titleFontSize by animateFloatAsState(if (hasFocus) 30f else 14f)

    Column(
        modifier = modifier
            .padding(start = 50.dp)
            .onFocusChanged { hasFocus = it.hasFocus }
    ) {
        Text(
            text = heading,
            fontSize = titleFontSize.sp,
            color = titleColor
        )
        TvLazyRow(
            horizontalArrangement = Arrangement.spacedBy(25.dp),
            contentPadding = PaddingValues(end = 50.dp),
            modifier = Modifier
                .padding(top = 15.dp)
        ) {
            items(shows) { show -> Card(show = show) }
        }
    }
}

@Composable
fun Card(show: Show) {
    var isFocussed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (isFocussed) 1.1f else 1f)
    val borderColor = if (isFocussed) Color.White else Color.Transparent
    val itemTitleColor = if (isFocussed) Color.White else Color.Gray

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .width(200.dp)
            .scale(scale)
            .onFocusChanged { focusState -> isFocussed = focusState.isFocused }
            .focusable()
    ) {
        Image(
            painter = painterResource(id = remember { getImage(show.heroImageResource) }),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alpha = 0.6f,
            modifier = Modifier
                .height(120.dp)
                .border(
                    width = 3.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(5.dp)
                ),
        )
        Text(
            text = show.title,
            color = itemTitleColor,
            fontSize = 11.sp,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}

@Composable
fun AppFestiveFamilyTime(modifier: Modifier = Modifier) {
}
