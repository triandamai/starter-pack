package com.trian.component.utils.ecg

import android.content.Context
import android.content.ContextWrapper
import android.graphics.*

import android.view.View
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception


/**
 * Smartwatch ViewModel Class
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 01/09/2021
 * Convert square bitmap to circle
 * @param Bitmap - square bitmap
 * @return circle bitmap
 */
fun View.canvasToBitmap(): Bitmap? {
//  if(this.width == 0 || this.height ==0){
//        return null
//  }
    val w = 2700
    val h = 1000
    val createBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(createBitmap)
    this.layout(0, 0, w, h)
    this.draw(canvas)
    return createBitmap
}



