plugins{
    id(GradlePlugins.androidLib)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
}
apply{
    plugin(GradlePlugins.hilt)
}
android{
    compileSdkVersion(Android.targetSdk)
    defaultConfig {
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode(Android.versionCode)
        versionName(Android.versionName)

        testInstrumentationRunner = AndroidJUnit.runner
    }
    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = BuildType.minifyRelease
            proguardFiles(BuildType.proguardRelease)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}
dependencies{
    implementation(Libs.ktx)
//    implementation(Libs.appCompat)
  //  implementation(Libs.materialDesign)

    //Dagger
    implementation(Libs.hilt)
    kapt(Libs.hiltCompilerGoogle)

    //Coroutines
    implementation(Libs.coroutinesAndroid)
    implementation(Libs.coroutinesCore)

    //Gson
    implementation(Libs.gson)
    implementation(Libs.gsonScaler)


    //Retrofit
    implementation(Libs.retrofit)
    //implementation(Libs.okHttp)
    // implementation(Libs.retrofitOkHttpLogging)
    //implementation(Libs.retrofitCoroutineAdapter)

    //Room
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)


    //Domain
    implementation(project(Modules.domain))

}
