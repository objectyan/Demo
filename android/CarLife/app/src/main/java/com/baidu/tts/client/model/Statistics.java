package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.p245p.C5155b;

public class Statistics {
    public static boolean isStatistics = true;
    /* renamed from: a */
    private C5155b f20891a;

    public Statistics(Context context) {
        this.f20891a = new C5155b(context);
    }

    public static void setEnable(boolean mIsStatistics) {
        isStatistics = mIsStatistics;
    }

    public int start() {
        this.f20891a.m17500a();
        return 0;
    }

    public int stop() {
        this.f20891a.m17501b();
        return 0;
    }
}
