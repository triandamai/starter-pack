package com.trian.domain.utils.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.timepicker.MaterialTimePicker

import com.trian.domain.R
import es.dmoral.toasty.Toasty

/**
 * Utility for context
 * author Trian Damai
 * created_at 29/01/22 - 22.08
 * site https://trian.app
 */
fun Context.intentTo(destination: String) {
    val ctx = this
    Intent(
        Intent.ACTION_VIEW,
        Uri.parse(destination)
    ).apply {
        ctx.startActivity(this, Bundle())
    }

}

fun Context.hideKeyboard() {
    val activity = (this as Activity)
    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = activity.currentFocus
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

@SuppressLint("QueryPermissionsNeeded")
fun Context.emailTo(from: String = "", to: String, subject: String) {

    Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$to?subject=$subject&body=$subject - ")
        putExtra(Intent.EXTRA_EMAIL, from)
    }.also { intent ->
        this.startActivity(intent)

    }
}

fun Context.gotoApp() {
    val uri: Uri = Uri.parse("market://details?id=$packageName")
    Intent(Intent.ACTION_VIEW, uri).apply {
        addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )
    }.also { intent ->
        this.startActivity(intent)
    }
}


fun Context.toastSuccess(message: String) {
    Toasty.success(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toastError(message: String) {
    Toasty.error(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toastWarning(message: String) {
    Toasty.warning(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toastInfo(message: String) {
    Toasty.info(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toastNormal(message: String) {
    Toasty.normal(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showTimePicker(
    hourMinute: Pair<Int, Int>,
    onSelect: (Pair<Int, Int>) -> Unit,
    onDismiss: () -> Unit
) {
    MaterialTimePicker.Builder()
        .setHour(hourMinute.first)
        .setMinute(hourMinute.second)
        .build()
        .apply {
            addOnPositiveButtonClickListener {
                onSelect(Pair(hour, minute))
            }
            addOnDismissListener { onDismiss() }

            //   show(supportFragmentManager,"Tag")
        }
}

fun Context.findActivity(): AppCompatActivity? = when (this) {
    is AppCompatActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}