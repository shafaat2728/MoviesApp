object Versions {
    const val kotlin = "1.5.30"

    internal const val androidPlugin = "4.2.2"
    internal const val appCompat = "1.4.1"
    internal const val legacySupport = "1.0.0"
    internal const val androidxCore = "1.7.0"
    internal const val versionNav = "2.3.5"
    internal const val materialDesign = "1.2.0-alpha04"
    internal const val multidex = "2.0.1"
    internal const val lifecycle = "2.3.1"
    internal const val lifecycleViewModel = "2.4.0"
    internal const val lifecycleExt = "2.2.0"
    internal const val coroutines = "1.5.1"
    internal const val glide = "4.11.0"
    internal const val room = "2.4.2"
    internal const val fragmentKtx = "1.3.5"
    internal const val activityKtx = "1.2.3"
    internal const val okHttp = "4.9.0"
    internal const val gson = "2.9.0"
    internal const val gsonScaler = "2.6.0"
    internal const val retrofitCoroutineAdapter = "0.9.2"
    internal const val hiltViewModel = "1.0.0-alpha03"
    internal const val hiltCompiler = "1.0.0"
    internal const val hilt = "2.38.1"
    internal const val retrofit = "2.9.0"
    internal const val jUnit="4.13.2"
    internal const val jUnitTest="1.1.3"
    internal const val espresso="3.4.0"
    internal const val constraintLayout="2.1.3"
    internal const val shimmer="0.5.0"


}


object BuildPlugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafe = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.versionNav}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

object Android {
    const val minSdk = 21
    const val targetSdk = 31
    const val applicationId = "com.digitify.moviesapp"
    const val versionCode = 1
    const val versionName = "1.0"

}

object GradlePlugins {
    const val androidPlugin = "com.android.application"
    const val hilt = "dagger.hilt.android.plugin"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "android"
    const val kotlinExt = "android.extensions"
    const val kotlinApt = "kapt"
    const val kapt = "kotlin-kapt"
    const val javaLib = "java-library"
    const val androidLib = "com.android.library"
    const val navigationSafe = "androidx.navigation.safeargs"
    const val navigationSafeKotlin = "androidx.navigation.safeargs.kotlin"
  }

object Modules {
    const val domain = ":domain"
    const val network = ":network"
    const val di = ":di"
}

object AndroidJUnit {
    const val runner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildType {
    const val debug = "debug"
    const val release = "release"

    const val minifyRelease = false
    const val proguardRelease = "proguard-rules.pro"

    const val minifyDebug = false
    const val proguardDebug = "proguard-rules.pro"
}

object Libs {
    //appCompat
    const val appCompat="androidx.appcompat:appcompat:${Versions.appCompat}"

    //Material
    const val materialDesign="com.google.android.material:material:${Versions.materialDesign}"

    //Multidex
    const val multidex="androidx.multidex:multidex:${Versions.multidex}"


    // Constraint Layout
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Legacy Support
    const val support = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"


    //KTX
    const val ktx = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"


    // databinding compiler
    const val bindingCompiler = "androidx.databinding:databinding-compiler:${Versions.androidPlugin}"

    // room database
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // lifecycle
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycleViewModel}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExt}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"


    // retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val retrofitOkHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutineAdapter}"

    //Gson
    const val gson="com.squareup.retrofit2:converter-gson:${Versions.gson}"
    const val gsonScaler="com.squareup.retrofit2:converter-scalars:${Versions.gsonScaler}"




    // Navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.versionNav}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.versionNav}"

    // Glide for image loader
    const val glideRuntime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"


    // JUnit for testing
    const val junit = "junit:junit:${Versions.jUnit}"
    const val junitTestImpl = "androidx.test.ext:junit:${Versions.jUnitTest}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"



    //Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // daggerHilt
    const val  hilt="com.google.dagger:hilt-android:${Versions.hilt}"
    const val  hiltCompilerGoogle ="com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val  hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
    const val  hiltCompiler ="androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"

    //Shimmer
    const val shimmer="com.facebook.shimmer:shimmer:${Versions.shimmer}"

    //KTX
    const val activityKtx="androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragmentKtx="androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
}