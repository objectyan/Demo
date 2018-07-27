package com.baidu.carlife.core.screen.video;

import android.graphics.Bitmap.CompressFormat;

import com.baidu.carlife.core.LogUtil;

/* compiled from: ReceiverAndConverter50Thread */
/* renamed from: com.baidu.carlife.core.screen.video.b */
class ReceiverAndConverter50Thread extends BaseReceiverAndConverterThread {
    /* renamed from: h */
    private static final String Tag = "Recorder";
    /* renamed from: i */
    private static Recorder sRecorder = Recorder.newInstance();
    /* renamed from: j */
    private long f3841j = ((long) Recorder.f3864e);
    /* renamed from: k */
    private long f3842k = 0;

    public ReceiverAndConverter50Thread() {
        sBitmap = sRecorder.f3905f;
    }

    /* renamed from: a */
    public void mo1523a() {
        this.f3835a = false;
        sRecorder.m4891v();
    }

    /* renamed from: a */
    public void mo1524a(int newRate) {
        this.f3841j = (long) (1000 / newRate);
    }

    /* renamed from: c */
    private void stopThreadInner() {
        LogUtil.d(Tag, "ReceiverAndConverter50Thread  stopThreadInner");
        this.f3835a = false;
        sRecorder.m4891v();
        sRecorder.m4836C();
    }

    /* renamed from: d */
    private void m4794d() {
        m4795e();
        synchronized (sBitmap) {
            sBitmap.compress(CompressFormat.JPEG, 70, this.mByteArrayOutputStream);
        }
        if (sRecorder.m4853a(this.mByteArrayOutputStream.toByteArray(), this.mByteArrayOutputStream.size()) == -1) {
            stopThreadInner();
        }
        this.mByteArrayOutputStream.reset();
    }

    public void run() {
        if (sRecorder.m4879j()) {
            this.f3841j = (long) Recorder.f3864e;
            try {
                sRecorder.m4874g(true);
                LogUtil.d(Tag, "ReceiverAndConverter50Thread isRunning=" + this.f3835a);
                if (sRecorder.m4879j()) {
                    while (this.f3835a) {
                        m4794d();
                    }
                    return;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            LogUtil.d(Tag, "ReceiverAndConverter50Thread  run finished.");
            stopThreadInner();
        }
    }

    /* renamed from: e */
    private void m4795e() {
        long startTime = System.currentTimeMillis();
        if (startTime - this.f3842k < this.f3841j) {
            try {
                Thread.sleep((this.f3841j - startTime) + this.f3842k);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f3842k = System.currentTimeMillis();
    }
}
