package project.scripts

import project.scripts.Versions.daggerVersion
import project.scripts.Versions.pokeKotlinVersion
import project.scripts.Versions.recyclerviewVersion
import project.scripts.Versions.roomVersion

class Dependencies {

    object Androidx {
        const val RoomRuntime = "androidx.room:room-runtime:$roomVersion"
        const val RoomCompiler = "androidx.room:room-compiler:$roomVersion"
        const val RoomRx = "androidx.room:room-rxjava2:$roomVersion"
        const val xRecyclerView = "androidx.recyclerview:recyclerview:$recyclerviewVersion"
    }

    object Others {
        const val PokeKotlin = "me.sargunvohra.lib:pokekotlin:$pokeKotlinVersion"
    }

    object DependencyInjection {
        const val Dagger = "com.google.dagger:dagger:$daggerVersion"
        const val DaggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"

        const val DaggerAndroid = "com.google.dagger:dagger-android:$daggerVersion"
        const val DaggerAndroidSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
        const val DaggerAndroidAnnotationProcessor = "com.google.dagger:dagger-android-processor:$daggerVersion"
    }
}

object Versions {
    // Room
    const val roomVersion = "2.2.0"

    // Pokekotlin
    const val pokeKotlinVersion = "2.3.0"

    // Recyclerview
    const val recyclerviewVersion = "1.0.0"

    // Daggerversion
    const val daggerVersion = "2.24"
}