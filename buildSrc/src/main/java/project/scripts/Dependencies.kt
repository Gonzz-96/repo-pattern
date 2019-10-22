package project.scripts

import project.scripts.Versions.roomVersion

class Dependencies {

    object Androidx {
        const val RoomRuntime = "androidx.room:room-runtime:$roomVersion"
        const val RoomCompiler = "androidx.room:room-compiler:$roomVersion"
    }
}

object Versions {
    // Room
    const val roomVersion = "2.2.0"
}