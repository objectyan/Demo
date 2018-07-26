package com.baidu.che.codriver.ui;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;

public class MainActivity extends BaseActivity {
    /* renamed from: a */
    private static final String f8689a = "MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String mode = null;
        if (bundle != null) {
            mode = bundle.getString(NaviStatConstants.K_NSC_KEY_MODE_TYPE, null);
        }
        C2674b.m9985b().m10007a((BaseActivity) this);
        C2674b.m9985b().m10028e(mode);
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
