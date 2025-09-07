package omkar.android.projects

import android.app.Application
import omkar.android.projects.app.utils.KoinUtils

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinUtils.startKoin()
    }
}