package omkar.android.projects.app.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import omkar.android.projects.presentation.theme.LocalAppColors

/**
 - Configuration class for text styling
 - Add new properties here and they'll be available to all text composable
 */
data class TextConfig(
    val textAlign: TextAlign = TextAlign.Start,
    val maxLines: Int = 1,
    val overflow: TextOverflow = TextOverflow.Ellipsis,
    val modifier: Modifier = Modifier,
    val fontWeight: FontWeight = FontWeight.Normal
)

/**
 - Base text composable that all other text variants use.
 - Add new styling properties to TextConfig and they'll automatically work everywhere.
 */
@Composable
private fun BaseText(
    text: String,
    color: Color,
    fontSize: TextUnit,
    config: TextConfig = TextConfig()
) = Text(
    text = text,
    modifier = config.modifier,
    color = color,
    fontSize = fontSize,
    fontWeight = config.fontWeight,
    textAlign = config.textAlign,
    maxLines = config.maxLines,
    overflow = config.overflow
)

@Composable
fun ExtraSmallText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig()
) = BaseText(
    text = text,
    color = color,
    fontSize = 10.sp,
    config = config
)

@Composable
fun SmallText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig()
) = BaseText(
    text = text,
    color = color,
    fontSize = 12.sp,
    config = config
)

@Composable
fun SemiMediumText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig()
) = BaseText(
    text = text,
    color = color,
    fontSize = 14.sp,
    config = config
)

@Composable
fun MediumText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig()
) = BaseText(
    text = text,
    color = color,
    fontSize = 16.sp,
    config = config
)

@Composable
fun SemiLargeText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig()
) = BaseText(
    text = text,
    color = color,
    fontSize = 18.sp,
    config = config
)

@Composable
fun LargeText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig()
) = BaseText(
    text = text,
    color = color,
    fontSize = 20.sp,
    config = config
)

@Composable
fun ExtraLargeText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig()
) = BaseText(
    text = text,
    color = color,
    fontSize = 22.sp,
    config = config
)

@Composable
fun TitleSmallText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig(fontWeight = FontWeight.Bold)
) = BaseText(
    text = text,
    color = color,
    fontSize = 24.sp,
    config = config
)

@Composable
fun TitleMediumText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig(fontWeight = FontWeight.Bold)
) = BaseText(
    text = text,
    color = color,
    fontSize = 26.sp,
    config = config
)

@Composable
fun TitleLargeText(
    text: String,
    color: Color = LocalAppColors.current.black,
    config: TextConfig = TextConfig(fontWeight = FontWeight.Bold)
) = BaseText(
    text = text,
    color = color,
    fontSize = 28.sp,
    config = config
)

