package omkar.android.projects.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import omkar.android.projects.data.model.YoutubeVideoItem
import omkar.android.projects.presentation.home.HomePage
import omkar.android.projects.presentation.profile.ProfilePage
import omkar.android.projects.presentation.summarize.SummarizeVideoPage

inline fun <reified T> T.toJson(): String = Json.encodeToString(this)

sealed class Screens() : Screen {

    object HomePage : Screens() {
        @Composable
        override fun Content() {
            HomePage()
        }
    }

    object ProfilePage : Screens() {
        @Composable
        override fun Content() {
            ProfilePage()
        }
    }

    data class SummaryPage(val videoJson: String) : Screens() {
        @Composable
        override fun Content() {
            val video = remember(videoJson) {
                Json.decodeFromString<YoutubeVideoItem>(videoJson)
            }
            SummarizeVideoPage(video)
        }
    }
}