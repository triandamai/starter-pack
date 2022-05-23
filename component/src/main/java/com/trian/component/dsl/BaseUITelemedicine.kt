package com.trian.component.dsl

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@DslMarker
annotation class ContentDSL

@ContentDSL
class ContentUIDSL{
    @Composable
    fun header(content:@Composable ()->Unit)=
        content.invoke()

    @Composable
    fun body(content:@Composable ()->Unit) {
        content.invoke()
    }

    @Composable
    fun footer(content:@Composable ()->Unit) {
        content.invoke()
    }
}

@Composable
fun ContentUI(
    appBar: @Composable ()->Unit,
    bottomBar:@Composable ()->Unit,
    scaffoldState: ScaffoldState,
    scrollState: ScrollState = rememberScrollState(),
    content:@Composable ContentUIDSL.()->Unit,
) {
    val dt = ContentUIDSL()
    Scaffold(
        topBar = {
            appBar()
        },
        backgroundColor = MaterialTheme.colors.background,
        scaffoldState = scaffoldState,
        bottomBar = {
            bottomBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            content.invoke(dt)
        }
    }
}