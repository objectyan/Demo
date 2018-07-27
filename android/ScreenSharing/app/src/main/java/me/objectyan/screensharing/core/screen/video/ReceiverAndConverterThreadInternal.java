package me.objectyan.screensharing.core.screen.video;


import android.util.Log;

public class ReceiverAndConverterThreadInternal extends BaseReceiverAndConverterThread {

    private static final String f3850h = "Recorder";

    private static final String f3851i = "--QA-TEST--";

    private static byte[] f3852j;

    private static Recorder f3853k = Recorder.newInstance();

    private long f3854l = ((long) Recorder.sChangeFrameRate);

    private long f3855m = 0;

    public ReceiverAndConverterThreadInternal() {
        f3831d = f3853k.f3906g;
        sByteBuffer = f3853k.mByteBuffer;
        sBitmap = f3853k.mBitmap;
    }


    public void setInputThreadNull() {
        this.f3835a = false;
        f3853k.setInputThreadNull();
    }


    public void changeFrameRate(int newRate) {
        this.f3854l = (long) (1000 / newRate);
    }


    private void m4807c() {
        Log.d(f3850h, "ReceiverAndConverterThreadInternal  stopThreadInner");
        this.f3835a = false;
        f3853k.setInputThreadNull();
        f3853k.m4836C();
    }

    public void run() {
        try {
            if (f3853k.getIsJPEGMode() || f3853k.m4840G()) {
                this.f3854l = (long) Recorder.sChangeFrameRate;
                try {
                    f3853k.setIsFirstPausingFrame(true);
                    Log.d(f3850h, "ReceiverAndConverterThreadInternal isRunning=" + this.f3835a);
                    int mColorFormat = f3853k.getColorFormat();
                    Log.d(f3850h, "isJPEGMode=" + f3853k.getIsJPEGMode() + ", mColorFormat=" + mColorFormat);
                    if (!f3853k.getIsJPEGMode()) {
                        if (mColorFormat == 15 || mColorFormat == 16) {
                            if (f3853k.m4837D() || VideoOutputThread.m4915b()) {
                                f3853k.m4876h(false);
                            } else {
                                m4806a(false);
                                VideoOutputThread.m4912a(f3831d);
                            }
                            f3853k.startVideoOutputThread();
                            while (this.f3835a) {
                                m4809e();
                            }
                            Log.d(f3850h, "ReceiverAndConverterThreadInternal  run finished.");
                            m4807c();
                        }
                        if ((f3853k.m4837D() && f3852j == null) || VideoOutputThread.m4915b()) {
                            if (mColorFormat == 6 || mColorFormat == 7) {
                                f3852j = new byte[((Recorder.sContainerWidth * Recorder.sContainerHeight) * 2)];
                            } else {
                                f3852j = new byte[(((Recorder.sContainerWidth * Recorder.sContainerHeight) * 3) / 2)];
                            }
                            f3853k.m4876h(false);
                            Log.i(f3850h, "run mColorFormat == 6 || mColorFormat == 7");
                        } else {
                            m4806a(true);
                            VideoOutputThread.m4912a(f3852j);
                            Log.i(f3850h, "VideoOutputThread.firstSendEncodeFrame(mDestFormatBuf);");
                        }
                        f3853k.startVideoOutputThread();
                        while (this.f3835a) {
                            Log.i(f3850h, "enter  readAndConvert, isRunning=" + this.f3835a);
                            m4808d();
                        }
                        Log.d(f3850h, "ReceiverAndConverterThreadInternal  run finished.");
                        m4807c();
                    }
                } catch (NullPointerException e) {
                    Log.i(f3850h, "Output Thread closeLocalSocket lead to");
                }
            } else {
                m4807c();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void m4808d() {
        if (f3853k.m4870e()) {
            if (f3853k.writeVideo2() == -1) {
                m4807c();
            }
            try {
                Thread.sleep(50);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        m4810f();
        JniMethod.convert(f3831d, f3852j, Recorder.sContainerWidth, Recorder.sContainerHeight);
        int flag = f3853k.sendEmptyPacket(f3852j);
        if (flag == -2 && !f3853k.getIsReleaseMediaCodec()) {
            m4807c();
        }
        Log.i(f3850h, "input2Encoder success flag= " + flag);
    }


    private void m4809e() {
        if (f3853k.m4870e()) {
            if (f3853k.writeVideo2() == -1) {
                m4807c();
            }
            try {
                Thread.sleep(50);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        long startTime = System.currentTimeMillis();
        m4810f();
        Log.i(f3851i, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        if (f3853k.sendEmptyPacket(f3831d) == -2 && !f3853k.getIsReleaseMediaCodec()) {
            m4807c();
        }
        Log.i(f3851i, "JAVA encode time = " + (System.currentTimeMillis() - startTime));
    }


    private void m4806a(boolean needConvert) {
        m4810f();
        if (needConvert) {
            JniMethod.convert(f3831d, f3852j, Recorder.sContainerWidth, Recorder.sContainerHeight);
        }
    }


    private void m4810f() {
        long startTime = System.currentTimeMillis();
        if (startTime - this.f3855m < this.f3854l) {
            try {
                Thread.sleep((this.f3854l - startTime) + this.f3855m);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f3855m = System.currentTimeMillis();
        synchronized (sBitmap) {
            sByteBuffer.clear();
            sBitmap.copyPixelsToBuffer(sByteBuffer);
        }
    }
}
