package omkar.android.projects

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform