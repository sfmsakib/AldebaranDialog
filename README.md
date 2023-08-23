# AldebaranDialog

Add it in your root settings.gradle at the end of repositories:
 ```
allprojects { 
    repositories { 
      ... 
      maven {url 'https://jitpack.io' } 
    } 
}
```
Add the dependency:
```
dependencies {    
      ... 
      implementation 'com.github.sfmsakib:AldebaranDialog:1.0.5'
}
```

#### AldebaranDialog
Basic Aldebaran Dialog:
You can configure positive and/or negative or neutral button. Each button can have its own listener set, or all three can share one listener. Alternatively, no listener can be set at all, in which case clicking any button will simply dismiss the dialog.
##
```Kotlin
AldebaranDialog(
            this,
            AldebaranDialog.ButtonLayout.HORIZONTAL)
            .setNegativeButton("No") {}
            .setPositiveButton("Yes") {}
            .setNegativeButtonColor(getColor(R.color.purple_200))
            .setPositiveButtonColor(getColor(R.color.pink500))
            .setCancelable(true)
            .setTopTitle("Top Title!!")
            .setTitle("Title!!")
            .setMessage("Hello Aldebaran Dialog User!")
            .setTopColor(Color.parseColor("#A30000"))
            .setTopTitleColor(getColor(R.color.white))
            .setTitleColor(getColor(R.color.red))
            .setMessageGravity(Gravity.START)
            .setTitleGravity(Gravity.START)
            .setIcon(R.drawable.icon)
```
#### AldebaranDialog
Aldebaran Progress Dialog:
To show progress dialog:
##
```Kotlin
        AldebaranProgressDialog(this)
            .setCancelable(true)
            .setTitle("Please wait!!")
            .setMessage("Uploading your data...")
            .setTopTitle("Data Uploading")
            .setIcon(com.sprout.aldebarandialog.R.drawable.baseline_cloud_upload_24)
            .setTopColor(getColor(R.color.purple_200))
            .show()
```