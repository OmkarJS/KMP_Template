package omkar.android.projects.domain.repository

import omkar.android.projects.data.model.YoutubeSearchResponse
import omkar.android.projects.data.remote.util.ApiResponseWrapper

interface YoutubeRepository {
    suspend fun searchVideos(query: String, maxResults: Int): ApiResponseWrapper<YoutubeSearchResponse>

    suspend fun getSearchSuggestions(query: String): ApiResponseWrapper<List<String>>
}