package com.baidu.navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.carlife.CarlifeActivity;

public class NaviOfflineActivityStarter extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getIntent());
        intent.setClass(this, CarlifeActivity.class);
        startActivity(intent);
        finish();
    }
}
