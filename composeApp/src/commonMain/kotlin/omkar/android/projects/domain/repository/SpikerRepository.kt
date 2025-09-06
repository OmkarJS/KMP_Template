package omkar.android.projects.domain.repository

import omkar.android.projects.data.model.TranscriptResponse
import omkar.android.projects.data.remote.util.ApiResponseWrapper

interface SpikerRepository {
    suspend fun fetchTranscript(youtubeVideoID: String): ApiResponseWrapper<TranscriptResponse>
}