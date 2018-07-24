package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.baidu.carlife.p075d.C1431b.C1421c;
import com.baidu.carlife.p075d.C1431b.C1424f;
import com.baidu.carlife.p075d.C1431b.C1425g;
import com.baidu.carlife.p075d.C1431b.C1430l;

public class TopBarView extends RelativeLayout {
    /* renamed from: a */
    public static final int f7297a = 0;
    /* renamed from: b */
    public static final int f7298b = 1;
    /* renamed from: c */
    private int f7299c;

    public TopBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7299c = 0;
        m8519a(context, attrs);
        m8518a(context);
    }

    /* renamed from: a */
    private void m8519a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, C1430l.TopBarView);
            this.f7299c = a.getInt(C1430l.TopBarView_TopBarType, 0);
            a.recycle();
        }
    }

    /* renamed from: a */
    private void m8518a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1425g.common_top_bar, this, true);
        BatteryView batteryView = (BatteryView) findViewById(C1424f.view_battery);
        TimeTextView timeView = (TimeTextView) findViewById(C1424f.view_time);
        if (this.f7299c == 1) {
            batteryView.setType(1);
            timeView.setTextColor(getResources().getColor(C1421c.text_navi_black_title));
            return;
        }
        batteryView.setType(0);
        timeView.setTextColor(getResources().getColor(C1421c.text_def_white_title));
    }

    /* renamed from: a */
    public void m8520a(boolean dayStyle) {
        BatteryView batteryView = (BatteryView) findViewById(C1424f.view_battery);
        TimeTextView timeView = (TimeTextView) findViewById(C1424f.view_time);
        if (dayStyle) {
            batteryView.setType(1);
            timeView.setTextColor(getResources().getColor(C1421c.battery_black));
            return;
        }
        batteryView.setType(0);
        timeView.setTextColor(getResources().getColor(C1421c.cl_text_a5_title));
    }
}
