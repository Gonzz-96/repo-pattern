package project.scripts

import project.scripts.Versions.coroutinesVersion
import project.scripts.Versions.daggerVersion
import project.scripts.Versions.espressoCoreVersion
import project.scripts.Versions.junit4Version
import project.scripts.Versions.leakCanaryVersion
import project.scripts.Versions.materialVersion
import project.scripts.Versions.mockitoKotlinVersion
import project.scripts.Versions.mockitoVersion
import project.scripts.Versions.okhttpVersion
import project.scripts.Versions.pokeKotlinVersion
import project.scripts.Versions.recyclerviewVersion
<<<<<<< HEAD
import project.scripts.Versions.retrofitVersion
import project.scripts.Versions.roomVersion
import project.scripts.Versions.rxAndroidVersion
import project.scripts.Versions.rxJavaVersion
import project.scripts.Versions.rxRetroVersion
=======
import project.scripts.Versions.robolectricVersion
import project.scripts.Versions.roomVersion
import project.scripts.Versions.testRulesVersion
import project.scripts.Versions.testRunnerVersion
import project.scripts.Versions.workVersion
import project.scripts.Versions.xTestCoreVersion
import project.scripts.Versions.xTestExtJunitVersion
>>>>>>> develop

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

<<<<<<< HEAD
    object Networking {
        const val Retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val RxRetroAdapter = "com.squareup.retrofit2:adapter-rxjava2:$rxRetroVersion"
=======
    /**
     * Group test dependencies
     */
    object Testing {
        const val Junit4 = "junit:junit:$junit4Version"
        const val CoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"
        const val RoboElectric = "org.robolectric:robolectric:$robolectricVersion"
        const val MockitoCore = "org.mockito:mockito-core:$mockitoVersion"
        const val MockitoInline = "org.mockito:mockito-inline:$mockitoVersion"
        const val MockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlinVersion"
        const val xTestCore = "androidx.test:core:$xTestCoreVersion"
        const val xWorkTesting = "androidx.work:work-testing:$workVersion"
        const val OkHttpMockWebServer = "com.squareup.okhttp3:mockwebserver:$okhttpVersion"
    }

    /**
     * Group integration testing dependencies
     */
    object IntegrationTesting {
        const val xTestRunner = "androidx.test:runner:$testRunnerVersion"
        const val xTestExtJunit = "androidx.test.ext:junit:$xTestExtJunitVersion"
        const val xTestRules = "androidx.test:rules:$testRulesVersion"
        const val xEspressoCore = "androidx.test.espresso:espresso-core:$espressoCoreVersion"
        const val LeakCanaryInstrumentation = "com.squareup.leakcanary:leakcanary-android-instrumentation:$leakCanaryVersion"
>>>>>>> develop
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

<<<<<<< HEAD
    // RxJava
    const val rxJavaVersion = "2.2.13"
    const val rxAndroidVersion = "2.1.1"

    // Retrofit
    const val retrofitVersion = "2.6.2"
    const val rxRetroVersion = "2.6.2"
=======
    // Testing versions
    const val junit4Version = "4.13-beta-3"
    const val coroutinesVersion = "1.3.0-RC2"
    const val robolectricVersion = "4.3"
    const val xTestCoreVersion = "1.2.0"
    const val workVersion = "2.2.0"
    const val mockitoVersion = "2.23.0"
    const val mockitoKotlinVersion = "2.1.0"
    const val okhttpVersion = "4.1.1"

    // Instrumentation testing versions
    const val testRunnerVersion = "1.3.0-alpha02"
    const val xTestExtJunitVersion = "1.1.2-alpha02"
    const val testRulesVersion = "1.2.0"
    const val espressoCoreVersion = "3.2.0"
    const val leakCanaryVersion = "2.0-beta-2"
>>>>>>> develop
}