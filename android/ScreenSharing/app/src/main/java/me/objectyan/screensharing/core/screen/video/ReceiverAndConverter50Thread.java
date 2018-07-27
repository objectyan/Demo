package me.objectyan.screensharing.core.screen.video;

import android.graphics.Bitmap.CompressFormat;
import android.util.Log;

/* 50Thread */
//
class ReceiverAndConverter50Thread extends BaseReceiverAndConverterThread {

    private static final String Tag = "Recorder";

    private static Recorder sRecorder = Recorder.newInstance();

    private long mChangeFrameRate = ((long) Recorder.sChangeFrameRate);

    private long f3842k = 0;

    public ReceiverAndConverter50Thread() {
        sBitmap = sRecorder.mBitmap;
    }


    public void setInputThreadNull() {
        this.f3835a = false;
        sRecorder.setInputThreadNull();
    }


    public void changeFrameRate(int newRate) {
        this.mChangeFrameRate = (long) (1000 / newRate);
    }


    private void stopThreadInner() {
        Log.d(Tag, "ReceiverAndConverter50Thread  stopThreadInner");
        this.f3835a = false;
        sRecorder.setInputThreadNull();
        sRecorder.m4836C();
    }


    private void m4794d() {
        m4795e();
        synchronized (sBitmap) {
            sBitmap.compress(CompressFormat.JPEG, 70, this.mByteArrayOutputStream);
        }
        if (sRecorder.encryptVideoData(this.mByteArrayOutputStream.toByteArray(), this.mByteArrayOutputStream.size()) == -1) {
            stopThreadInner();
        }
        this.mByteArrayOutputStream.reset();
    }

    public void run() {
        if (sRecorder.getIsJPEGMode()) {
            this.mChangeFrameRate = (long) Recorder.sChangeFrameRate;
            try {
                sRecorder.setIsFirstPausingFrame(true);
                Log.d(Tag, "ReceiverAndConverter50Thread isRunning=" + this.f3835a);
                if (sRecorder.getIsJPEGMode()) {
                    while (this.f3835a) {
                        m4794d();
                    }
                    return;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            Log.d(Tag, "ReceiverAndConverter50Thread  run finished.");
            stopThreadInner();
        }
    }


    private void m4795e() {
        long startTime = System.currentTimeMillis();
        if (startTime - this.f3842k < this.mChangeFrameRate) {
            try {
                Thread.sleep((this.mChangeFrameRate - startTime) + this.f3842k);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f3842k = System.currentTimeMillis();
    }
}
