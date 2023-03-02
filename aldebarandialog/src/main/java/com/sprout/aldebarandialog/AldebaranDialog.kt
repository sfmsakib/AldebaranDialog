package com.sprout.aldebarandialog

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes

class AldebaranDialog : AbsAldebaranDialog<AldebaranDialog, AldebaranDialog> {
    private var positiveButton: Button? = null
    private var negativeButton: Button? = null
    private var neutralButton: Button? = null
    private var yesNoButtonLayout: LinearLayout? = null
    private var neutralButtonLayout: LinearLayout? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, theme: Int) : super(context, theme) {}
    constructor(context: Context?, buttonLayout: ButtonLayout) : super(context,
        0,
        buttonLayout.layout) {
    }

    constructor(context: Context?, theme: Int, buttonLayout: ButtonLayout) : super(context,
        theme,
        buttonLayout.layout) {
    }

    fun setPositiveButton(@StringRes text: Int, listener: View.OnClickListener?): AldebaranDialog {
        return setPositiveButton(string(text), listener)
    }

    fun setPositiveButton(text: String?, listener: View.OnClickListener?): AldebaranDialog {
        yesNoButtonLayout!!.visibility = View.VISIBLE
        neutralButtonLayout!!.visibility = View.GONE
        positiveButton!!.visibility = View.VISIBLE
        positiveButton!!.text = text
        positiveButton!!.setOnClickListener(ClickListenerDecorator(listener, true))
        return this
    }

    fun setNegativeButtonText(@StringRes text: Int): AldebaranDialog {
        return setNegativeButton(string(text), null)
    }

    fun setNegativeButtonText(text: String?): AldebaranDialog {
        return setNegativeButton(text, null)
    }

    fun setNegativeButton(@StringRes text: Int, listener: View.OnClickListener?): AldebaranDialog {
        return setNegativeButton(string(text), listener)
    }

    fun setNegativeButton(text: String?, listener: View.OnClickListener?): AldebaranDialog {
        yesNoButtonLayout!!.visibility = View.VISIBLE
        neutralButtonLayout!!.visibility = View.GONE
        negativeButton!!.visibility = View.VISIBLE
        negativeButton!!.text = text
        negativeButton!!.setOnClickListener(ClickListenerDecorator(listener, true))
        return this
    }

    fun setNeutralButtonText(@StringRes text: Int): AldebaranDialog {
        return setNeutralButton(string(text), null)
    }

    fun setNeutralButtonText(text: String?): AldebaranDialog {
        return setNeutralButton(text, null)
    }

    fun setNeutralButton(@StringRes text: Int, listener: View.OnClickListener?): AldebaranDialog {
        return setNeutralButton(string(text), listener)
    }

    fun setNeutralButton(text: String?, listener: View.OnClickListener?): AldebaranDialog {
        yesNoButtonLayout!!.visibility = View.GONE
        neutralButtonLayout!!.visibility = View.VISIBLE
        neutralButton!!.visibility = View.VISIBLE
        neutralButton!!.text = text
        neutralButton!!.setOnClickListener(ClickListenerDecorator(listener, true))
        return this
    }

    fun setButtonsColor(@ColorInt color: Int): AldebaranDialog {
        positiveButton!!.setTextColor(color)
        negativeButton!!.setTextColor(color)
        neutralButton!!.setTextColor(color)
        return this
    }

    fun setButtonsColorRes(@ColorRes colorRes: Int): AldebaranDialog {
        return setButtonsColor(color(colorRes))
    }

    fun setOnButtonClickListener(listener: View.OnClickListener?): AldebaranDialog {
        return setOnButtonClickListener(true, listener)
    }

    fun setOnButtonClickListener(
        closeOnClick: Boolean,
        listener: View.OnClickListener?
    ): AldebaranDialog {
        val clickHandler: View.OnClickListener = ClickListenerDecorator(listener, closeOnClick)
        positiveButton!!.setOnClickListener(clickHandler)
        neutralButton!!.setOnClickListener(clickHandler)
        negativeButton!!.setOnClickListener(clickHandler)
        return this
    }

    fun setPositiveButtonText(@StringRes text: Int): AldebaranDialog {
        return setPositiveButton(string(text), null)
    }

    fun setPositiveButtonText(text: String?): AldebaranDialog {
        return setPositiveButton(text, null)
    }

    fun setPositiveButtonColor(@ColorInt color: Int): AldebaranDialog {
        positiveButton!!.setTextColor(color)
        return this
    }

    fun setNegativeButtonColor(@ColorInt color: Int): AldebaranDialog {
        negativeButton!!.setTextColor(color)
        return this
    }

    fun setNeutralButtonColor(@ColorInt color: Int): AldebaranDialog {
        neutralButton!!.setBackgroundColor(color)
        return this
    }

    fun setNeutralButtonTextColor(@ColorInt color: Int): AldebaranDialog {
        neutralButton!!.setTextColor(color)
        return this
    }

    fun setPositiveButtonColorRes(@ColorRes colorRes: Int): AldebaranDialog {
        return setPositiveButtonColor(color(colorRes))
    }

    fun setNegativeButtonColorRes(@ColorRes colorRes: Int): AldebaranDialog {
        return setNegativeButtonColor(color(colorRes))
    }

    fun setNeutralButtonColorRes(@ColorRes colorRes: Int): AldebaranDialog {
        return setNeutralButtonColor(color(colorRes))
    }

    enum class ButtonLayout(@field:LayoutRes @param:LayoutRes val layout: Int) {
        HORIZONTAL(R.layout.dialog_alert_yes_no), VERTICAL(R.layout.dialog_alert_yes_no);
    }

    companion object {
        val POSITIVE_BUTTON = R.id.ld_btn_yes
        val NEGATIVE_BUTTON = R.id.ld_btn_no
        val NEUTRAL_BUTTON = R.id.ld_btn_neutral
    }

    init {
        positiveButton = findView<Button>(R.id.ld_btn_yes)
        negativeButton = findView<Button>(R.id.ld_btn_no)
        neutralButton = findView<Button>(R.id.ld_btn_neutral)
        yesNoButtonLayout = findView<LinearLayout>(R.id.ld_ll_yes_no)
        neutralButtonLayout = findView<LinearLayout>(R.id.ld_ll_neutral)
    }

    override val layout: Int
        get() = R.layout.dialog_alert_yes_no
}