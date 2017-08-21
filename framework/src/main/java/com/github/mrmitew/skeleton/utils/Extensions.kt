package com.github.mrmitew.skeleton.utils

import android.app.Fragment
import android.support.v4.app.FragmentActivity
import android.widget.Toast

/** small extension to the AppCompatActivity to create toasts **/
fun FragmentActivity.showToast(message: String){
    Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String){
    Toast.makeText(activity, message,Toast.LENGTH_SHORT).show()
}