package omkar.android.projects.app.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import omkar.android.projects.app.components.ExtraSmallSpacer
import omkar.android.projects.app.components.SmallSpacer
import omkar.android.projects.app.utils.getBestAvailableThumbnail
import omkar.android.projects.data.model.YoutubeVideoItem
import omkar.android.projects.presentation.theme.LocalAppColors

@Composable
fun YoutubeVideoItem(
    videoItem: YoutubeVideoItem,
    onClick: () -> Unit
) {
    val colors = LocalAppColors.current
    val bestThumbnailUrl = getBestAvailableThumbnail(videoItem)

    @Composable
    fun VideoInfoView() {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Medium1Text(
                    text = videoItem.snippet.title,
                    maxLines = 2,
                    fontWeight = FontWeight.Bold
                )
            }

            Row {
                Small2Text(
                    text = videoItem.snippet.channelTitle,
                    fontWeight = FontWeight.Normal,
                    textColor = colors.grey
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }

    @Composable
    fun MainBody(string: String) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp).clickable { onClick() }
        ) {
            ExtraSmallSpacer()

            ThumbnailView(string)

            SmallSpacer()

            VideoInfoView()

            ExtraSmallSpacer()
        }
    }

    bestThumbnailUrl?.let {
        MainBody(it)
    }
}
