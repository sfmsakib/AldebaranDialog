package com.sprout.aldebarandialogexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.sprout.aldebarandialog.AldebaranDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnError.setOnClickListener { showErrorDialog() }

//        btnInfo.setOnClickListener { showInfoDialog() }
//
//        btnProgress.setOnClickListener { showProgressDialog() }
//
//        btnWarning.setOnClickListener { showWarningDialog() }
//
//        btnNotice.setOnClickListener { showNoticeDialog() }
//
//        btnSuccess.setOnClickListener { showSuccessDialog() }
    }
    lateinit var errorDialog: AldebaranDialog

    private fun showErrorDialog() {
        errorDialog = AldebaranDialog(
            this,
            AldebaranDialog.ButtonLayout.HORIZONTAL)
            .setNegativeButton("No") {}
            .setPositiveButton("Yes") {}
            .setPositiveButtonColor(getColor(R.color.white))
            .setNegativeButtonColor(getColor(R.color.white))
            .setCancelable(false)
            .setTopTitle("Top Title!!")
            .setTitle("Title!!")
            .setMessage("Text Message!!")
            .setTopColor(Color.parseColor("#B20020"))
            .setTopTitleColor(getColor(R.color.white))
            .setTitleColor(getColor(com.sprout.aldebarandialog.R.color.red))
            .setMessageGravity(Gravity.START)
            .setTitleGravity(Gravity.START)
            .setIcon(com.sprout.aldebarandialog.R.drawable.baseline_filter_vintage_24)
        errorDialog.show()

    }

//    private fun showInfoDialog() {
//        AwesomeInfoDialog(this).setPositiveButtonText(getString(R.string.dialog_ok_button), false).show()
//    }
//
//    private fun showProgressDialog() {
//        AwesomeProgressDialog(this).show()
//    }
//
//    private fun showWarningDialog() {
//        AwesomeWarningDialog(this).setButtonText(getString(R.string.dialog_ok_button)).show()
//    }
//
//    private fun showNoticeDialog() {
//        AwesomeNoticeDialog(this).setButtonText(getString(R.string.dialog_ok_button)).show()
//    }
//
//    private fun showSuccessDialog() {
//        AwesomeSuccessDialog(this).setPositiveButtonText(getString(R.string.dialog_ok_button)).show()
//    }
}