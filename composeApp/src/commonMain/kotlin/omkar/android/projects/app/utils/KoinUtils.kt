package omkar.android.projects.app.utils

import omkar.android.projects.di.commonModule
import org.koin.core.context.startKoin

object KoinUtils {
    fun startKoin() {
        startKoin {
            modules(commonModule)
        }
    }
}