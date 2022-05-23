package com.trian.module

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.plusAssign
import com.google.accompanist.insets.ExperimentalAnimatedInsets
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.trian.domain.utils.network.DataState
import com.trian.module.ui.pages.MainPage
import com.trian.module.ui.theme.CexupTheme
import com.trian.module.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * Main Activity
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 28/08/2021
 **/


@InternalCoroutinesApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialNavigationApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimatedInsets
@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navHostController = rememberAnimatedNavController()
            val bottomSheetNavigator = rememberBottomSheetNavigator()

            //make statusbar custom color
            val systemUiController = rememberSystemUiController()



            CexupTheme {
                ModalBottomSheetLayout(bottomSheetNavigator) {
                    AnimatedNavHost(
                        navController = navHostController,
                        startDestination = Routes.SPLASH
                    ) {

                        composable(
                            Routes.SPLASH,
                            enterTransition = {
                                fadeIn(animationSpec = tween(2000))
                            }
                        ) {
                            val mainViewModel = hiltViewModel<MainViewModel>()
                            val todos by mainViewModel.listTodos.observeAsState(initial = DataState.onLoading)

                            MainPage(datas = todos)
                        }

                    }

                }
            }


        }
    }


}

