package omkar.android.projects

import android.app.Application
import omkar.android.projects.di.commonModule
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(commonModule)
        }
    }
}