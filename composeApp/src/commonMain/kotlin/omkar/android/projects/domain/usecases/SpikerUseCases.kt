package omkar.android.projects.domain.usecases

import omkar.android.projects.data.model.TranscriptResponse
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.domain.repository.SpikerRepository

class FetchTranscriptUseCase(
    private val transcriptRepository: SpikerRepository
) {
    suspend operator fun invoke(videoID: String): ApiResponseWrapper<TranscriptResponse> {
        return transcriptRepository.fetchTranscript(videoID)
    }
}