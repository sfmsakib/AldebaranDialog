package com.sprout.aldebarandialog

import android.util.SparseArray
import android.os.Bundle
import java.lang.ref.WeakReference

class AldebaranSaveStateHandler {
    private val handledDialogs: SparseArray<WeakReference<AbsAldebaranDialog<*, *>?>> = SparseArray()
    fun saveInstanceState(outState: Bundle) {
        for (index in handledDialogs.size() - 1 downTo 0) {
            val dialogRef = handledDialogs.valueAt(index)
            if (dialogRef.get() == null) {
                handledDialogs.remove(index)
                continue
            }
            val dialog = dialogRef.get()
            if (dialog!!.isShowing) {
                dialog.onSaveInstanceState(outState)
                outState.putInt(KEY_DIALOG_ID, handledDialogs.keyAt(index))
                return
            }
        }
    }

    fun handleDialogStateSave(id: Int, dialog: AbsAldebaranDialog<*, *>?) {
        handledDialogs.put(id, WeakReference(dialog))
    }

    companion object {
        private const val KEY_DIALOG_ID = "id"
        fun wasDialogOnScreen(savedInstanceState: Bundle): Boolean {
            return savedInstanceState.keySet().contains(KEY_DIALOG_ID)
        }

        fun getSavedDialogId(savedInstanceState: Bundle): Int {
            return savedInstanceState.getInt(KEY_DIALOG_ID, -1)
        }
    }

}