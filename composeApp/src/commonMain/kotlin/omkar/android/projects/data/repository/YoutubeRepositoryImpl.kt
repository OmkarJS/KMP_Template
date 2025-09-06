package omkar.android.projects.data.repository

import omkar.android.projects.data.model.YoutubeSearchResponse
import omkar.android.projects.data.remote.YoutubeClient
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.domain.repository.YoutubeRepository

class YoutubeRepositoryImpl(
    private val youtubeClient: YoutubeClient
) : YoutubeRepository {
    override suspend fun searchVideos(
        query: String,
        maxResults: Int
    ): ApiResponseWrapper<YoutubeSearchResponse> {
        return youtubeClient.searchVideos(query, maxResults)
    }

    override suspend fun getSearchSuggestions(query: String): ApiResponseWrapper<List<String>> {
        return youtubeClient.getSearchSuggestions(query)
    }
}
