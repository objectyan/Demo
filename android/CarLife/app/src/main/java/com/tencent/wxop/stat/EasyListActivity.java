package com.tencent.wxop.stat;

import android.app.ListActivity;

public class EasyListActivity extends ListActivity {
    protected void onPause() {
        super.onPause();
        C6159i.m22080c(this);
    }

    protected void onResume() {
        super.onResume();
        C6159i.m22075b(this);
    }
}
