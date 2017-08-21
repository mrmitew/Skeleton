package com.github.mrmitew.skeleton.utils

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/** small extension to the AppCompatActivity to create toasts **/
fun AppCompatActivity.showToast(message: String){
    Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
}