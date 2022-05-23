package com.trian.module.di

import android.content.Context
import com.google.gson.Gson
import com.trian.domain.utils.utils.PermissionUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Main Activity
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 13/10/2021
 **/

@Module
@InstallIn(SingletonComponent::class, ActivityComponent::class)
object CommonModule {
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun providePermissionUtils(@ApplicationContext appContext: Context): PermissionUtils {
        return PermissionUtils(appContext)
    }

}