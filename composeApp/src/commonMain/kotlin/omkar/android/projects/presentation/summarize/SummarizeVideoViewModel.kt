package omkar.android.projects.presentation.summarize

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import omkar.android.projects.data.model.TranscriptItem
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.domain.usecases.FetchTranscriptUseCase
import omkar.android.projects.presentation.expectuals.getViewModelScope

class SummarizeVideoViewModel(
    private val fetchTranscriptUseCase: FetchTranscriptUseCase
) {
    private val viewModelScope: CoroutineScope = getViewModelScope()

    private val _transcriptUiState = MutableStateFlow(SummarizeVideoUiState())
    val transcriptUiState: StateFlow<SummarizeVideoUiState> = _transcriptUiState.asStateFlow()

    fun fetchTranscript(youtubeVideoID: String) {
        _transcriptUiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            when(val result = fetchTranscriptUseCase.invoke(youtubeVideoID)) {
                is ApiResponseWrapper.Success -> {
                    Logger.withTag("Omi").d("fetchTranscript: ApiResponseWrapper Success")
                    _transcriptUiState.update {
                        it.copy(
                            isLoading = false,
                            transcriptList = result.data.transcript,
                        )
                    }
                }

                is ApiResponseWrapper.Failure -> {
                    Logger.withTag("Omi").d("fetchTranscript: ApiResponseWrapper Failure, Message: ${result.message}")
                    _transcriptUiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }

                is ApiResponseWrapper.NetworkError -> {
                    Logger.withTag("Omi").d("fetchTranscript: ApiResponseWrapper Failure, Message: ${result.reason}")
                    _transcriptUiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.reason
                        )
                    }
                }

                is ApiResponseWrapper.UnknownError -> {
                    Logger.withTag("Omi").d("fetchTranscript: ApiResponseWrapper Failure, Message: ${result.error}")
                    _transcriptUiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.error
                        )
                    }
                }
            }
        }
    }
}

data class SummarizeVideoUiState (
    val isLoading: Boolean = false,
    val transcriptList: List<TranscriptItem>? = emptyList(),
    val error: String? = null
)