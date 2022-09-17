package androidx.tv.material.samples.data

import androidx.tv.material.samples.R

enum class ShowType {
  TvShow,
  Movie,
}

data class Show(
  /**
   * Title of the show
   */
  val title: String,

  /**
   * Short blurb about the show
   */
  val shortDescription: String,

  /**
   * Link to the hero image
   */
  val heroImageLink: String,

  /**
   * Image from the app's resources
   */
  val heroImageResource: Int,

  /**
   * Which app is is available on? Netflix or Hotstar or Amazon Prime Video
   */
  val applicationName: String
)

val sampleImages = listOf(
        R.drawable.color1,
        R.drawable.color2,
        R.drawable.color3,
        R.drawable.color4,
        R.drawable.color5,
        R.drawable.color6,
        R.drawable.color7,
        R.drawable.color8,
        R.drawable.color9,
        R.drawable.color10,
)

val sampleShows: List<Show> = listOf(
  Show(
    title = "Thor: Love and Thunder",
    shortDescription = "God of Thunder joins old friends to battle a god killer",
    heroImageLink = "https://i.imgur.com/OGKVWFs.jpg",
    heroImageResource = R.drawable.thor_love_and_thunder,
    applicationName = "Hotstar",
  ),
  Show(
    title = "Khuda Haafiz: Chapter 2 - Agni Pariksha",
    shortDescription = "Sameer and Nandini's life engulfs in new problems",
    heroImageLink = "https://i.imgur.com/G7ZiwDK.jpg",
    heroImageResource = R.drawable.khuda_haafiz,
    applicationName = "ZEE5",
  ),
  Show(
    title = "War",
    shortDescription = "India's top agent Kabir leads the Elite Shadow Unit of R&AW, a compact group of crème de la crème of the armed forces who are personally tra...",
    heroImageLink = "https://i.imgur.com/hnVKnfW.jpg",
    heroImageResource = R.drawable.war,
    applicationName = "Prime Video",
  ),
  Show(
    title = "Simmba",
    shortDescription = "A corrupt police officer enjoys the perks of being an immortal and unethical police office until an event which transforms his life completely and forces him to choos...",
    heroImageLink = "https://i.imgur.com/J6vO71J.jpg",
    applicationName = "ZEE5",
  ),
  Show(
    title = "Shivaay",
    shortDescription = "Shivaay, a fearless Himalayan mountaineer covered in Lord Shiva tattoos, heads to Bulgaria to fulfill his nine-year-old daughter Gaura's wish of seeing her Mother Olga,...",
    heroImageLink = "https://i.imgur.com/6eIS5VY.jpg",
    applicationName = "ZEE5",
  ),
  Show(
    title = "Chak De India",
    shortDescription = "Kabir Khan knows what it's like to come back from the dead. The ex India Captain has now come back in the avatar of the Coach of the Indian ...",
    heroImageLink = "https://i.imgur.com/wxLGtYq.jpg",
    applicationName = "ZEE5",
  ),
  Show(
    title = "Student of the year",
    shortDescription = "The road from youth to adulthood is paved with a myriad of emotions and Student Of The Year celebrates this colorful coming of age. It is the story of Abhimanyu Sin...",
    heroImageLink = "https://i.imgur.com/yV9mXA5.jpg",
    applicationName = "ZEE5",
  ),
  Show(
    title = "Zindagi Na Milegi Dobara",
    shortDescription = "Three young men take a holiday that changes their lives forever. Kabir meets Natasha, and six months later they are engaged. He wants to go on an exten...",
    heroImageLink = "https://i.imgur.com/CRowLCC.jpg",
    applicationName = "ZEE5",
  ),
  Show(
    title = "Kedarnath",
    shortDescription = "Mansoor, a reserved and reticent Pithoo, helps pilgrims make an arduous journey upwards to the temple town. His world turns around when he meets the beautiful a...",
    heroImageLink = "https://i.imgur.com/x5hbYSZ.jpg",
    applicationName = "ZEE5",
  ),
  Show(
    title = "Hasee Toh Phasee",
    shortDescription = "The film is about the relationship between the quirky, rebellious Meeta and the mischievous Nikhil struggling with their respec...",
    heroImageLink = "https://i.imgur.com/xweGhul.jpg",
    applicationName = "ZEE5",
  ),
)
