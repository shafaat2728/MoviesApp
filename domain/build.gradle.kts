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

    //Dagger
    implementation(Libs.hilt)
    kapt(Libs.hiltCompilerGoogle)

    //Coroutines
    implementation(Libs.coroutinesAndroid)
    implementation(Libs.coroutinesCore)

    //Retrofit
    implementation(Libs.retrofit)
    kapt(Libs.roomCompiler)

    //Room
    implementation(Libs.roomKtx)

}