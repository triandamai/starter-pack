package com.trian.module


import android.app.Application
import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import androidx.work.Configuration
import com.yucheng.ycbtsdk.YCBTClient
import dagger.hilt.android.HiltAndroidApp
import logcat.AndroidLogcatLogger
import logcat.LogPriority
import logcat.logcat
import javax.inject.Inject

/**
 * Base Application
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 28/08/2021
 */

@HiltAndroidApp
class MainApplication : Application(),Configuration.Provider{

    @Inject lateinit var workerFactory: HiltWorkerFactory

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        YCBTClient.initClient(this,false)

        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)


    }


    override fun getWorkManagerConfiguration(): Configuration=
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}

