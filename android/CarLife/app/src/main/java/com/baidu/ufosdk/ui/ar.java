package com.baidu.ufosdk.ui;

import com.baidu.ufosdk.p251e.C5180a;
import com.tencent.qplayauto.device.QPlayAutoJNI;

/* compiled from: FeedbackInputActivity */
final class ar implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aq f21555a;

    ar(aq aqVar) {
        this.f21555a = aqVar;
    }

    public final void run() {
        try {
            C5180a.m17571a(this.f21555a.f21554a.f21469M, QPlayAutoJNI.SONG_LIST_ROOT_ID);
        } catch (Exception e) {
        }
    }
}
