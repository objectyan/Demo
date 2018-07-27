package com.baidu.carlife.core.screen.presentation.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.core.screen.OnHintChangeListener;
import com.baidu.carlife.core.screen.OnLightnessCoverListener;
import com.baidu.carlife.core.screen.OnProgressDialogListener;
import com.baidu.carlife.core.screen.OnUIListener;
import com.baidu.carlife.core.screen.OnWindowManagerViewListener;

/* compiled from: CarlifeView */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.f */
public abstract class CarlifeView implements OnDialogListener, OnHintChangeListener, OnLightnessCoverListener, OnProgressDialogListener, OnUIListener, OnWindowManagerViewListener {
    /* renamed from: a */
    protected View mView;
    /* renamed from: b */
    protected Context mContext;

    /* renamed from: e */
    public abstract Context mo1482e();

    /* renamed from: f */
    public abstract void mo1483f();

    public CarlifeView(Context context, int rId) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(rId, null);
    }

    /* renamed from: g */
    public View m4695g() {
        return this.mView;
    }

    /* renamed from: h */
    public void mo1484h() {
    }

    /* renamed from: i */
    public boolean m4697i() {
        return true;
    }

    /* renamed from: j */
    public boolean mo1489j() {
        return true;
    }
}
