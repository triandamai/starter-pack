package com.trian.component.utils.responsivecomponent

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun ResponsiveRow(
    small : @Composable () -> Unit,
    medium : @Composable () -> Unit,
    large : @Composable () -> Unit,
    xlarge : @Composable () -> Unit
){
    BoxWithConstraints() {
        constraints

        if(maxWidth <= 480.dp){
            small()
        }
        else if ( maxWidth >480.dp && maxWidth <= 600.dp) {
            medium()
        }
        else if(maxWidth >600.dp && maxWidth <= 720.dp) {
            large()
        }else{
            xlarge()
        }


    }

}