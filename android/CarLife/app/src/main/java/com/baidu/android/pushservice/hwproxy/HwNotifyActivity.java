package com.baidu.android.pushservice.hwproxy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0522f;
import com.baidu.android.pushservice.p031j.C0578p;

public class HwNotifyActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                String d = C0522f.m2195d(getApplicationContext(), intent);
                String c = C0522f.m2192c(getApplicationContext(), intent);
                if (!(TextUtils.isEmpty(c) || data == null || !C0522f.m2185a(getApplicationContext(), c, d))) {
                    C0578p.m2523a(getApplicationContext(), intent);
                }
            }
        } catch (Exception e) {
        }
        finish();
    }
}
