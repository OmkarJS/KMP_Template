package omkar.android.projects.data.repository

import omkar.android.projects.data.model.TranscriptResponse
import omkar.android.projects.data.remote.SpikerClient
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.domain.repository.SpikerRepository

class SpikerRepositoryImpl(
    private val ktorClient: SpikerClient
): SpikerRepository {
    override suspend fun fetchTranscript(youtubeVideoID: String): ApiResponseWrapper<TranscriptResponse> {
        return ktorClient.fetchYoutubeTranscript(youtubeVideoID)
    }
}