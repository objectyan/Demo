package com.baidu.ufosdk.ui;

import android.os.Message;
import java.util.TimerTask;

/* compiled from: FeedbackFacePageActivity */
final class aa extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ C5207z f21537a;

    aa(C5207z c5207z) {
        this.f21537a = c5207z;
    }

    public final void run() {
        Message message = new Message();
        message.what = 3;
        this.f21537a.f21686a.f21435z.sendMessage(message);
        if (this.f21537a.f21686a.f21426q != null) {
            this.f21537a.f21686a.f21426q.cancel();
            this.f21537a.f21686a.f21426q.purge();
        }
    }
}
