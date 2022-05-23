package com.trian.component.dsl

import androidx.compose.runtime.Composable

@DslMarker
annotation class sidebar
@DslMarker
annotation class content
@DslMarker
annotation class left
@DslMarker
annotation class right

class BaseContentDSL{
    @left
    @Composable
    fun left(){}

    @right
    @Composable
    fun right(){}
}

class BaseCorporateDSL {
    @sidebar
    @Composable
    fun sidebar(){}

    @content
    @Composable
    fun content(){}
}

@Composable
fun BaseCorporate(
    content: @Composable BaseCorporateDSL.()->Unit
){
    val dt = BaseCorporateDSL()
    content.invoke(dt)
}

@Composable
fun BaseContent(
    content: @Composable BaseContentDSL.() -> Unit
){
    val dt = BaseContentDSL()
    content.invoke(dt)
}