package androidx.tv.material.samples.utils

import androidx.tv.material.samples.data.Show
import androidx.tv.material.samples.data.sampleImages
import androidx.tv.material.samples.data.sampleShows

fun getImage(imageId: Int? = null): Int {
    if (imageId != null) {
        return imageId
    }
    return getRandomImage()
}

fun getRandomImage(): Int {
    return sampleImages.shuffled()[0]
}

fun getShowsByIds(ids: List<String>): List<Show> = ids
    .filter { id -> id in sampleShows.map { show -> show.id } }
    .map { id ->
        sampleShows.find { show -> show.id == id }!!
    }

fun getRandomShows(count: Int = 3): List<Show> {
    if (count >= sampleShows.size) {
        return sampleShows
    }
    return sampleShows.shuffled().subList(0, count)
}
