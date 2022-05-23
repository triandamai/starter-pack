package com.trian.module.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.trian.module.ui.components.appbar.AppBarFeature
import com.trian.component.ui.theme.TesMultiModuleTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppbarFeatureTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp(){
        composeRule.setContent {
            TesMultiModuleTheme {
               AppBarFeature("Trian Damai","",{}){

               }
            }
        }
    }

    @Test
    fun shouldShowAppBar(){

        composeRule.onNodeWithText("Hello Trian Damai").assertExists()

    }
}