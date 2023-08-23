package com.sprout.aldebarandialog

import android.content.Context




class AldebaranProgressDialog : AbsAldebaranDialog<AldebaranProgressDialog, AldebaranProgressDialog>{

    constructor(context: Context?) : super(context){}

    constructor(context: Context?, theme: Int) : super(context, theme)


    {
        setCancelable(false)
    }

    override val layout: Int
        get() = R.layout.dialog_progress

}