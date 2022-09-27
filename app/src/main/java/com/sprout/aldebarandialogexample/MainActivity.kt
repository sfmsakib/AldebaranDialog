package com.sprout.aldebarandialogexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import com.sprout.aldebarandialog.AldebaranDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnError = findViewById<Button>(R.id.btnError)
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
    private lateinit var errorDialog: AldebaranDialog

    private fun showErrorDialog() {
        errorDialog = AldebaranDialog(
            this,
            AldebaranDialog.ButtonLayout.HORIZONTAL)
            .setNegativeButton("No") {}
            .setPositiveButton("Yes") {}
            .setNegativeButtonColor(getColor(R.color.purple_200))
            .setPositiveButtonColor(getColor(com.sprout.aldebarandialog.R.color.pink500))
            .setCancelable(true)
            .setTopTitle("Top Title!!")
            .setTitle("Title!!")
            .setMessage("Hello Aldebaran Dialog User!")
            .setTopColor(Color.parseColor("#A30000"))
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