package com.sprout.aldebarandialog

import android.content.Context
import androidx.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View

class AldebaranCustomDialog : AbsAldebaranDialog<AldebaranCustomDialog, AldebaranCustomDialog> {
    private var addedView: View? = null
    private var instanceStateManager: InstanceStateManager? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, theme: Int) : super(context, theme) {}

    fun setView(@LayoutRes layout: Int): AldebaranCustomDialog {
        val inflater = LayoutInflater.from(context)
        val parent = findView<ViewGroup>(R.id.ld_custom_view_container)
        addedView = inflater.inflate(layout, parent, true)
        return this
    }

    fun setView(customView: View?): AldebaranCustomDialog {
        val container = findView<ViewGroup>(R.id.ld_custom_view_container)
        container.addView(customView)
        addedView = customView
        return this
    }

    override fun configureView(viewViewConfigurator: ViewConfigurator<View?>): AldebaranCustomDialog {
        checkNotNull(addedView) { string(R.string.ex_msg_dialog_view_not_set) }
        viewViewConfigurator.configureView(addedView)
        return this
    }

    fun setListener(viewId: Int, listener: View.OnClickListener?): AldebaranCustomDialog {
        return setListener(viewId, false, listener)
    }

    fun setListener(
        viewId: Int,
        dismissOnClick: Boolean,
        listener: View.OnClickListener?
    ): AldebaranCustomDialog {
        checkNotNull(addedView) { string(R.string.ex_msg_dialog_view_not_set) }
        val clickListener: View.OnClickListener = ClickListenerDecorator(listener, dismissOnClick)
        findView<View>(viewId).setOnClickListener(clickListener)
        return this
    }

    fun setInstanceStateManager(instanceStateManager: InstanceStateManager?): AldebaranCustomDialog {
        this.instanceStateManager = instanceStateManager
        return this
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        instanceStateManager!!.saveInstanceState(outState)
    }

    override fun restoreState(savedState: Bundle?) {
        super.restoreState(savedState)
        instanceStateManager!!.restoreInstanceState(savedState)
    }

    override val layout: Int
        protected get() = R.layout.dialog_custom

    interface InstanceStateManager {
        fun saveInstanceState(outState: Bundle?)
        fun restoreInstanceState(savedState: Bundle?)
    }
}