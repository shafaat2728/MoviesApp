plugins {
    id(GradlePlugins.androidPlugin)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
}
apply {
    plugin(GradlePlugins.hilt)
    plugin(GradlePlugins.navigationSafeKotlin)
}
android {
    compileSdkVersion(Android.targetSdk)
    defaultConfig {
        applicationId = Android.applicationId
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode(Android.versionCode)
        versionName(Android.versionName)
        multiDexEnabled = true

        testInstrumentationRunner = AndroidJUnit.runner
    }
    buildFeatures {
        dataBinding = true

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
dependencies {
    implementation(Libs.ktx)
    implementation(Libs.appCompat)
    implementation(Libs.materialDesign)
    implementation(Libs.constraintlayout)
    implementation(Libs.support)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.junitTestImpl)

    //Material Design
    implementation(Libs.materialDesign)

    //Multidex
    implementation(Libs.multidex)

    //LifeCycle
    implementation(Libs.lifecycleLiveDataKtx)
    implementation(Libs.lifecycleJava8)
    implementation(Libs.lifecycleExtensions)


    //Dagger
    implementation(Libs.hilt)
    kapt(Libs.hiltCompilerGoogle)
    implementation(Libs.hiltViewModel)
    implementation(Libs.hiltCompiler)


    //Coroutines
    implementation(Libs.coroutinesAndroid)
    implementation(Libs.coroutinesCore)

    //Glide
    implementation(Libs.glideRuntime)
    kapt(Libs.glideCompiler)

    //Navigation
    implementation(Libs.navigationUiKtx)
    implementation(Libs.navigationFragment)

    //Shimmer
    implementation(Libs.shimmer)

    //Activity, Fragment ktx
    implementation(Libs.activityKtx)
    implementation(Libs.fragmentKtx)

    //Domain
    implementation(project(Modules.domain))

    //Network
    implementation(project(Modules.network))

    //di
    implementation(project(Modules.di))


}

