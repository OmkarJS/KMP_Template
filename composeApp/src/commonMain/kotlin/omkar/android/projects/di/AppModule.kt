package omkar.android.projects.di


import omkar.android.projects.data.remote.SpikerClient
import omkar.android.projects.data.remote.YoutubeClient
import omkar.android.projects.domain.repository.SpikerRepository
import omkar.android.projects.domain.repository.YoutubeRepository
import omkar.android.projects.data.repository.SpikerRepositoryImpl
import omkar.android.projects.data.repository.YoutubeRepositoryImpl
import omkar.android.projects.domain.usecases.FetchTranscriptUseCase
import omkar.android.projects.domain.usecases.SearchYoutubeVideosUseCase
import org.koin.dsl.module
import omkar.android.projects.app.constants.Constants
import omkar.android.projects.data.remote.HttpClientEngine
import omkar.android.projects.domain.usecases.GetSearchSuggestions
import omkar.android.projects.domain.usecases.YoutubeUseCases
import omkar.android.projects.presentation.home.HomeViewModel
import omkar.android.projects.presentation.summarize.SummarizeVideoViewModel

val commonModule = module {
    // Repository
    single<YoutubeRepository> { YoutubeRepositoryImpl(get()) }
    single<SpikerRepository> { SpikerRepositoryImpl(get()) }

    // Usecase
    single {
        YoutubeUseCases(
            SearchYoutubeVideosUseCase(get()),
            GetSearchSuggestions(get())
        )
    }
    single { FetchTranscriptUseCase(get()) }

    // Client
    val httpClient = HttpClientEngine().create()
    single { YoutubeClient(apiKey = Constants.Youtube.YOUTUBE_DATA_KEY, httpClient = httpClient) }
    single { SpikerClient(httpClient = httpClient) }

    // Viewmodel
    single {
        HomeViewModel(get())
    }

    factory {
        SummarizeVideoViewModel(
            fetchTranscriptUseCase = get()
        )
    }
}