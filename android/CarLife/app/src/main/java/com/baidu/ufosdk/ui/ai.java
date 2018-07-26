package com.baidu.ufosdk.ui;

import android.os.Message;
import java.util.TimerTask;

/* compiled from: FeedbackHotActivity */
final class ai extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ ag f21545a;

    ai(ag agVar) {
        this.f21545a = agVar;
    }

    public final void run() {
        Message message = new Message();
        message.what = 3;
        this.f21545a.f21543a.f21452q.sendMessage(message);
        this.f21545a.f21543a.f21451p.cancel();
        this.f21545a.f21543a.f21451p.purge();
    }
}
