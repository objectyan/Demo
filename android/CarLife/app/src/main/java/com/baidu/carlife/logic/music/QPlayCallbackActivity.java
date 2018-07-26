package com.baidu.carlife.logic.music;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1261k;

public class QPlayCallbackActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m6516a();
        startActivity(new Intent(this, CarlifeActivity.class));
        finish();
    }

    protected void onResume() {
        super.onResume();
        m6516a();
        startActivity(new Intent(this, CarlifeActivity.class));
        finish();
    }

    /* renamed from: a */
    private void m6516a() {
        Uri uri = getIntent().getData();
        if (uri == null) {
            return;
        }
        if (uri.getQueryParameter("qmlogin").equalsIgnoreCase("1")) {
            C1838q.f5704Y = true;
            C1261k.m4453a((int) C1253f.gj, 1000);
            return;
        }
        C1838q.f5704Y = false;
    }
}
