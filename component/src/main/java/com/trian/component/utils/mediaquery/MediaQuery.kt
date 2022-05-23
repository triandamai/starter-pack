package com.trian.component.utils.mediaquery

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

/**
 * `Support Different Screen Size`
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 13/10/2021
 */
@Composable
fun TextStyle.layout(small: TextStyle, normal: TextStyle, large: TextStyle,xlarge:TextStyle, xxlarge: TextStyle): TextStyle {
    var data : TextStyle by remember {
        mutableStateOf(TextStyle())
    }
    BoxWithConstraints {
        //smal
        if(maxWidth <=320.dp ){
            data = small
        }
        //normal
        else if(maxWidth >320.dp && maxWidth <=380.dp){
            data = normal
        }
        //large
        else if(maxWidth >380.dp && maxWidth <=480.dp){
            data = large
        }
        //xlarge
        else if(maxWidth >=480.dp && maxWidth<720.dp){
            data = xlarge
        }
        //xxlarge
        else if(maxWidth >= 720.dp){
            data = xxlarge
        }

    }
    return data
}