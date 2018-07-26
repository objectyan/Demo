package com.baidu.ufosdk.ui;

/* compiled from: FeedbackInputActivity */
final class az implements da {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21563a;
    /* renamed from: b */
    private final /* synthetic */ cx f21564b;

    az(FeedbackInputActivity feedbackInputActivity, cx cxVar) {
        this.f21563a = feedbackInputActivity;
        this.f21564b = cxVar;
    }

    /* renamed from: a */
    public final void mo3929a(String str) {
        if (str == null || str.trim().length() == 0) {
            this.f21564b.dismiss();
            this.f21563a.ac.setVisibility(0);
            this.f21563a.ac.bringToFront();
            new Thread(new bb(this)).start();
            return;
        }
        this.f21564b.dismiss();
        this.f21563a.ac.setVisibility(0);
        this.f21563a.ac.bringToFront();
        new Thread(new ba(this, str)).start();
    }

    /* renamed from: a */
    public final void mo3928a() {
        this.f21564b.dismiss();
        this.f21563a.ac.setVisibility(0);
        this.f21563a.ac.bringToFront();
        new Thread(new bc(this)).start();
    }
}
