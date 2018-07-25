package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.carlife.p075d.C1431b.C1421c;
import com.baidu.carlife.p075d.C1431b.C1423e;
import com.baidu.carlife.p075d.C1431b.C1424f;
import com.baidu.carlife.p075d.C1431b.C1425g;
import com.baidu.carlife.p075d.C1431b.C1430l;
import com.baidu.carlife.p087l.CarlifeCoreSDK;

public class MainTopBarView extends RelativeLayout {
    /* renamed from: a */
    public static final int f7188a = 0;
    /* renamed from: b */
    public static final int f7189b = 1;
    /* renamed from: c */
    private int f7190c;

    public MainTopBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainTopBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7190c = 0;
        m8461a(context, attrs);
        m8460a(context);
    }

    /* renamed from: a */
    private void m8461a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, C1430l.TopBarView);
            this.f7190c = a.getInt(C1430l.TopBarView_TopBarType, 0);
            a.recycle();
        }
    }

    /* renamed from: a */
    private void m8460a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1425g.main_comm_top_bar, this, true);
        BatteryView batteryView = (BatteryView) findViewById(C1424f.view_battery);
        TimeTextView timeView = (TimeTextView) findViewById(C1424f.view_time);
        m8463b(CarlifeCoreSDK.m5979a().m5993N());
        if (this.f7190c == 1) {
            batteryView.setType(1);
            timeView.setTextColor(getResources().getColor(C1421c.text_navi_black_title));
            return;
        }
        batteryView.setType(0);
        timeView.setTextColor(getResources().getColor(C1421c.text_def_white_title));
    }

    /* renamed from: a */
    public void m8462a(boolean dayStyle) {
        BatteryView batteryView = (BatteryView) findViewById(C1424f.view_battery);
        TimeTextView timeView = (TimeTextView) findViewById(C1424f.view_time);
        if (dayStyle) {
            batteryView.setType(1);
            timeView.setTextColor(getResources().getColor(C1421c.text_navi_black_title));
            return;
        }
        batteryView.setType(0);
        timeView.setTextColor(getResources().getColor(C1421c.text_def_white_title));
    }

    /* renamed from: b */
    public void m8463b(boolean isConnected) {
        ImageView imgView = (ImageView) findViewById(C1424f.iv_connect);
        if (imgView != null) {
            if (isConnected) {
                imgView.setImageResource(C1423e.statusbaric_ic_connect);
            } else {
                imgView.setImageResource(C1423e.statusbaric_ic_disconnect);
            }
            imgView.setVisibility(0);
        }
    }
}
