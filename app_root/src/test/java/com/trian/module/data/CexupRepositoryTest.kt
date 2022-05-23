package com.trian.module.data

import com.google.gson.Gson
import com.trian.module.repository.design.MainRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import javax.inject.Inject


@HiltAndroidTest
@Config(
    application = HiltTestApplication::class,
    sdk = [29],
    manifest = Config.NONE
)
@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class CexupRepositoryTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)


    @Inject
    lateinit var repository: MainRepository

    @Inject
    lateinit var gson: Gson

    @Before
    fun setup() {
        hiltRule.inject()

    }

    @Test
    fun `user should insert to local when network failed`() = runBlocking {

    }

}

