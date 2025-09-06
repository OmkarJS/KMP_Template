package omkar.android.projects.di


import omkar.android.projects.data.remote.ExampleClient
import omkar.android.projects.data.remote.HttpClientEngine
import omkar.android.projects.data.repository.ExampleRepositoryImpl
import omkar.android.projects.domain.repository.ExampleRepository
import omkar.android.projects.domain.usecases.ExampleUseCase
import omkar.android.projects.presentation.home.HomeViewModel
import org.koin.dsl.module

val commonModule = module {
    // Repository
    single<ExampleRepository> { ExampleRepositoryImpl(get()) }

    // Usecase
    single { ExampleUseCase(get()) }

    // Client
    val httpClient = HttpClientEngine().create()
    single { ExampleClient(httpClient = httpClient) }

    // Viewmodel
    single {
        // Returns single instance
        HomeViewModel(get())
    }

    factory {
        // Returns new viewmodel instance every time this is called. Add if needed.
    }
}