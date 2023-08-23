package com.sprout.aldebarandialog;

import android.view.View;

public interface ViewConfigurator<T extends View> {
    void configureView(T v);
}