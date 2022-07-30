package com.sprout.aldebarandialog

import android.view.View

interface ViewConfigurator<T : View?> {
    fun configureView(v: T)
}