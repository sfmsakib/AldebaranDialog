package com.sprout.aldebarandialog

import android.content.DialogInterface
import android.view.View

object AldebaranDialogCompat {
    fun wrap(listener: DialogInterface.OnClickListener?): View.OnClickListener {
        return DialogOnClickListenerAdapter(listener)
    }

    internal class DialogOnClickListenerAdapter(private val adapted: DialogInterface.OnClickListener?) :
        View.OnClickListener {
        fun onClick(dialogInterface: DialogInterface?, which: Int) {
            adapted?.onClick(dialogInterface, which)
        }

        override fun onClick(v: View) {}
    }
}