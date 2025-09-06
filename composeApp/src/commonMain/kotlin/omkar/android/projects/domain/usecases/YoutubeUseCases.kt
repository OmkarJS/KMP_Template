package omkar.android.projects.domain.usecases

import omkar.android.projects.data.model.YoutubeSearchResponse
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.domain.repository.YoutubeRepository

class YoutubeUseCases (
    val searchYoutubeVideosUseCase: SearchYoutubeVideosUseCase,
    val getSearchSuggestions: GetSearchSuggestions
)

class SearchYoutubeVideosUseCase(
    private val youtubeRepository: YoutubeRepository
) {
    suspend operator fun invoke(query: String, maxResults: Int): ApiResponseWrapper<YoutubeSearchResponse> {
        return youtubeRepository.searchVideos(query, maxResults)
    }
}

class GetSearchSuggestions(
    private val youtubeRepository: YoutubeRepository
) {
    suspend operator fun invoke(query: String): ApiResponseWrapper<List<String>> {
         return youtubeRepository.getSearchSuggestions(query)
    }
}