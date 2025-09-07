package omkar.android.projects.presentation.expectuals

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

actual fun getViewModelScope(): CoroutineScope = MainScope()