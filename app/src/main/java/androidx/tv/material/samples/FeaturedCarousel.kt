package androidx.tv.material.samples

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material.ExperimentalTvMaterialApi
import androidx.tv.material.carousel.Carousel
import androidx.tv.material.carousel.CarouselItem
import androidx.tv.material.samples.data.Show
import androidx.tv.material.samples.utils.getImage
import androidx.tv.material.samples.utils.getShowsByIds

@OptIn(ExperimentalTvMaterialApi::class)
@Composable
fun FeaturedCarousel(modifier: Modifier = Modifier) {
    val shows = remember { getShowsByIds(listOf(
        "thor-love-and-thunder",
        "student-of-the-year",
        "war",
        "khuda-haafiz-chapter-2-agni-pariksha",
        "simmba",
        "shivaay",
//        "chak-de-india",
        "zindagi-na-milegi-dobara",
        "kedarnath",
        "hasee-toh-phasee",
    )) }

    Carousel(
        slideCount = shows.size,
        modifier = modifier.fillMaxWidth(),
    ) { index ->
        val show = shows[index]
        FeaturedCarouselItem(show)
    }
}

@OptIn(ExperimentalTvMaterialApi::class)
@Composable
fun FeaturedCarouselItem(
    show: Show,
    modifier: Modifier = Modifier,
) {
    var isButtonFocussed by remember { mutableStateOf(false) }
    val itemHeight by animateFloatAsState(if (isButtonFocussed) 450f else 350f)
    val topPadding by animateFloatAsState(if (isButtonFocussed) 180f else 130f)

    CarouselItem(
        background = {},
        modifier = modifier
            .fillMaxWidth()
            .height(itemHeight.dp),
        overlayEnterTransitionStartDelayMillis = 0,
        overlayExitTransition = slideOutHorizontally { -it / 2 }
    ) {
        Image(
            painter = painterResource(id = remember { getImage(show.heroImageResource) }),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            alpha = 0.6f,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        )
        Column(
            modifier = Modifier.padding(start = 50.dp, end = 50.dp, top = topPadding.dp),
        ) {
            Text(
                text = show.title,
                fontSize = 35.sp,
                style = TextStyle(shadow = Shadow(color = Color.Black, blurRadius = 10f)),
            )
            Text(
                text = "Specials  |  ${show.shortDescription}",
                color = Color.White.copy(alpha = 0.6f),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(shadow = Shadow(color = Color.Black, blurRadius = 10f)),
                modifier = Modifier.padding(top = 10.dp),
            )

            val buttonTextSize by animateFloatAsState(if (isButtonFocussed) 20f else 16f)
            val buttonOutlineColor = if (isButtonFocussed) Color.White else Color.Transparent

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .border(
                        width = 2.dp,
                        color = buttonOutlineColor,
                        shape = RoundedCornerShape(50.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(50.dp),
                    contentPadding = PaddingValues(
                        vertical = ButtonDefaults.ContentPadding.calculateTopPadding(),
                        horizontal = 30.dp
                    ),
                    modifier = Modifier
                        .onFocusChanged { isButtonFocussed = it.isFocused }
                        .focusable()
                        .padding(vertical = 2.dp, horizontal = 5.dp)
                ) {
                    Text(
                        text = "Watch on Disney + Hotstar",
                        fontSize = buttonTextSize.sp
                    )
                }
            }
        }
    }
}
