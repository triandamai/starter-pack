
plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")

}

android{
    compileSdk = 31
    defaultConfig {
        minSdk = 23
        targetSdk = 30
    }
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))


    with(Libs.AndroidX.Room){
        implementation(roomRuntime)
        implementation(roomPaging)
        implementation(roomKtx)
        kapt(roomCompiler)
        testImplementation(roomTesting)

    }

    implementation(Libs.JodaTime.jodaTime)

    with(Libs.AndroidX.Compose){
        implementation(Libs.AndroidX.Compose.Ui.ui)
        // https://stackoverflow.com/questions/68224361/jetpack-compose-cant-preview-after-updating-to-1-0-0-rc01
        implementation(Libs.AndroidX.Compose.Ui.uiTooling)
        implementation(Libs.AndroidX.Compose.Ui.uiToolingPreview)
        implementation(Libs.AndroidX.Compose.Material.material)
        implementation(Libs.AndroidX.Compose.Runtime.runtimeLivedata)
        implementation(Libs.AndroidX.Compose.Material.icons)
        implementation(Libs.AndroidX.Compose.Material.iconsExtended)
        androidTestImplementation(Libs.AndroidX.Compose.Ui.uiTestJunit4)
        debugImplementation(Libs.AndroidX.Compose.Ui.uiTestManifest)
        debugImplementation(Libs.AndroidX.Compose.Ui.uiTooling)

    }

    implementation(Libs.Com.Google.Android.Material.material)
    implementation(Libs.Com.Google.Android.Gms.auth)
    implementation(Libs.Com.Google.Code.Gson.gson)
    implementation(Libs.Com.Google.Dagger.hiltAndroid)
    kapt(Libs.Com.Google.Dagger.hiltAndroidCompiler)
    //chart
    implementation(Libs.Com.Github.PhilJay.mpAndroidChart)
    implementation(Libs.JodaTime.jodaTime)

    //toasty
    implementation(Libs.Com.Github.GrenderG.toasty)

}

