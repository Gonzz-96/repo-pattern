package project.scripts

import project.scripts.Versions.daggerVersion
import project.scripts.Versions.materialVersion
import project.scripts.Versions.pokeKotlinVersion
import project.scripts.Versions.recyclerviewVersion
import project.scripts.Versions.roomVersion
import project.scripts.Versions.rxAndroidVersion
import project.scripts.Versions.rxJavaVersion

class Dependencies {

    object Androidx {
        const val RoomRuntime = "androidx.room:room-runtime:$roomVersion"
        const val RoomCompiler = "androidx.room:room-compiler:$roomVersion"
        const val RoomRx = "androidx.room:room-rxjava2:$roomVersion"
        const val xRecyclerView = "androidx.recyclerview:recyclerview:$recyclerviewVersion"
    }

    object Others {
        const val PokeKotlin = "me.sargunvohra.lib:pokekotlin:$pokeKotlinVersion"
        const val Material = "com.google.android.material:material:$materialVersion"
        const val RxJava = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
        const val RxAndroid = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"
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

    // Dagger version
    const val daggerVersion = "2.24"

    // Material version
    const val materialVersion = "1.1.0-alpha06"

    // RxJava
    const val rxJavaVersion = "2.2.13"
    const val rxAndroidVersion = "2.1.1"
}