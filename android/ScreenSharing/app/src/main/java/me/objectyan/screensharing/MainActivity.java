package me.objectyan.screensharing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import me.objectyan.screensharing.service.PhoneStateService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String packageName = getIntent().getStringExtra("thirdparty_package");
        Log.v(MainActivity.class.getSimpleName(), packageName);
//        PhoneStateService.start(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        PhoneStateService.stop(this);
    }
}
