package com.baidu.carlife.core.screen.video;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.config.CarlifeConfig;
import java.nio.ByteBuffer;

/* compiled from: VideoOutputThread */
/* renamed from: com.baidu.carlife.core.screen.video.g */
public class VideoOutputThread extends Thread {
    /* renamed from: a */
    private static final String f3916a = "Recorder";
    /* renamed from: b */
    private static final long f3917b = 50000;
    /* renamed from: c */
    private static boolean f3918c = false;
    /* renamed from: d */
    private static Recorder f3919d = Recorder.m4826b();
    /* renamed from: e */
    private static MediaCodec f3920e = f3919d.m4892w();
    /* renamed from: f */
    private static final Object f3921f = f3919d.m4893x();
    /* renamed from: g */
    private static final Object f3922g = f3919d.m4894y();
    /* renamed from: h */
    private static int f3923h = 0;
    /* renamed from: i */
    private static byte[] f3924i;
    /* renamed from: j */
    private static byte[] f3925j = new byte[1];
    /* renamed from: k */
    private static BufferInfo f3926k = new BufferInfo();
    /* renamed from: l */
    private boolean f3927l = true;
    /* renamed from: m */
    private boolean f3928m = false;
    /* renamed from: n */
    private int f3929n = 0;
    /* renamed from: o */
    private int f3930o = 0;
    /* renamed from: p */
    private long f3931p = ((long) (Recorder.f3864e / 2));
    /* renamed from: q */
    private long f3932q = ((long) Recorder.f3864e);

    public VideoOutputThread() {
        f3920e = f3919d.m4892w();
    }

    /* renamed from: a */
    public void m4924a(int time) {
        this.f3931p = (long) time;
        this.f3932q = (long) (time * 2);
    }

    /* renamed from: a */
    public void m4923a() {
        LogUtil.d(f3916a, "VideoOutputThread ifStopInputThread=" + (!CarlifeConfig.m4065a()));
        this.f3927l = false;
        f3919d.m4858a(null);
        if (!CarlifeConfig.m4065a()) {
            f3919d.m4835B();
        }
    }

    /* renamed from: a */
    public void m4925a(boolean needDropFrame) {
        if (!this.f3928m) {
            this.f3928m = needDropFrame;
            this.f3929n = 0;
        }
    }

    public void run() {
        this.f3932q = (long) Recorder.f3864e;
        if (CarlifeConfig.m4065a()) {
            f3923h = 0;
            LogUtil.d(f3916a, "VideoOutputThread  isFirstEncodeFrame=" + f3919d.m4887r() + ", isRunning=" + this.f3927l);
            if (f3919d.m4887r()) {
                while (m4917d() == 0) {
                    if (!this.f3927l) {
                        break;
                    }
                }
            }
            m4920g();
            LogUtil.d(f3916a, "VideoOutputThread  isRunning=" + this.f3927l);
            while (this.f3927l) {
                if (m4919f() < 0) {
                    m4923a();
                } else {
                    try {
                        Thread.sleep(this.f3932q);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (f3919d.m4847N()) {
            while (!f3919d.m4850Q()) {
                if (f3919d.m4846M() < 0) {
                    m4923a();
                    return;
                }
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            f3919d.m4851R();
            if (f3919d.m4887r()) {
                while (m4917d() == 0) {
                    if (!this.f3927l) {
                        break;
                    }
                }
            }
            m4920g();
            while (this.f3927l) {
                if (Recorder.m4826b().m4870e()) {
                    if (f3919d.m4846M() < 0) {
                        m4923a();
                    }
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e22) {
                        e22.printStackTrace();
                    }
                } else if (m4919f() < 0) {
                    m4923a();
                } else {
                    try {
                        Thread.sleep(this.f3932q);
                    } catch (InterruptedException e222) {
                        e222.printStackTrace();
                    }
                }
            }
        } else {
            if (f3919d.m4887r()) {
                while (m4917d() == 0) {
                    if (!this.f3927l) {
                        break;
                    }
                }
            }
            while (this.f3927l) {
                if (m4918e() < 0) {
                    m4923a();
                }
            }
        }
    }

    /* renamed from: d */
    private int m4917d() {
        int outDataLength = 0;
        if (f3920e == null) {
            LogUtil.m4443d(f3916a, "还没完成初始化, 或已经被释放");
            return -1;
        }
        try {
            if (f3919d.m4843J()) {
                Thread.sleep(5);
            }
            synchronized (f3922g) {
                int outputBufferIndex = f3920e.dequeueOutputBuffer(f3926k, f3917b);
                ByteBuffer[] outputBuffers = f3920e.getOutputBuffers();
                if (outputBufferIndex >= 0) {
                    ByteBuffer outputBuffer = outputBuffers[outputBufferIndex];
                    if (f3925j.length < f3926k.size) {
                        f3925j = new byte[f3926k.size];
                    }
                    outputBuffer.get(f3925j, 0, f3926k.size);
                    outDataLength = f3926k.size;
                    outputBuffer.clear();
                    f3920e.releaseOutputBuffer(outputBufferIndex, false);
                    if (f3919d.m4887r()) {
                        outputBufferIndex = f3920e.dequeueOutputBuffer(f3926k, f3917b);
                        while (outputBufferIndex < 0 && this.f3927l) {
                            outputBufferIndex = f3920e.dequeueOutputBuffer(f3926k, f3917b);
                        }
                        if (f3924i == null) {
                            f3924i = new byte[outDataLength];
                            System.arraycopy(f3925j, 0, f3924i, 0, outDataLength);
                        }
                        outputBuffer = outputBuffers[outputBufferIndex];
                        f3925j = new byte[(f3924i.length + f3926k.size)];
                        outDataLength = f3924i.length + f3926k.size;
                        System.arraycopy(f3924i, 0, f3925j, 0, f3924i.length);
                        if (VideoOutputThread.m4914a(outputBuffer)) {
                            outputBuffer.get(f3925j, f3924i.length, f3926k.size);
                            outputBuffer.clear();
                            f3920e.releaseOutputBuffer(outputBufferIndex, false);
                            f3919d.m4872f(false);
                            LogUtil.d(f3916a, "VideoOutputThread outputSpsPpsAndFirstFrame isFirstEncodeFrame");
                        } else {
                            outputBuffer.clear();
                            f3920e.releaseOutputBuffer(outputBufferIndex, false);
                            f3919d.m4872f(false);
                            m4920g();
                            LogUtil.d(f3916a, "isTEST true, return 20!");
                            return 20;
                        }
                    }
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            LogUtil.e(f3916a, "outputSpsPpsAndFirstFrame" + t.toString());
        }
        LogUtil.d(f3916a, "VideoOutputThread  outputSpsPpsAndFirstFrame outDataLength=" + outDataLength);
        if (outDataLength == 0 || f3925j == null) {
            return 0;
        }
        return f3919d.m4853a(f3925j, outDataLength);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    private int m4918e() {
        /*
        r12 = this;
        r4 = -1;
        r6 = 0;
        r0 = 0;
        r7 = f3920e;
        if (r7 != 0) goto L_0x0011;
    L_0x0007:
        r6 = "Recorder";
        r7 = "还没完成初始化, 或已经被释放";
        com.baidu.carlife.core.LogUtil.m4443d(r6, r7);
    L_0x0010:
        return r4;
    L_0x0011:
        r7 = f3919d;	 Catch:{ Throwable -> 0x003e }
        r7 = r7.m4843J();	 Catch:{ Throwable -> 0x003e }
        if (r7 == 0) goto L_0x001e;
    L_0x0019:
        r8 = 5;
        java.lang.Thread.sleep(r8);	 Catch:{ Throwable -> 0x003e }
    L_0x001e:
        r7 = f3919d;	 Catch:{ Throwable -> 0x003e }
        r7 = r7.m4838E();	 Catch:{ Throwable -> 0x003e }
        if (r7 == 0) goto L_0x005e;
    L_0x0026:
        r7 = f3923h;	 Catch:{ Throwable -> 0x003e }
        r8 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        if (r7 <= r8) goto L_0x005e;
    L_0x002d:
        r7 = f3920e;	 Catch:{ Throwable -> 0x003e }
        if (r7 == 0) goto L_0x005e;
    L_0x0031:
        r7 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4922i();	 Catch:{ Throwable -> 0x003e }
        if (r7 != 0) goto L_0x004a;
    L_0x0037:
        r7 = f3919d;	 Catch:{ Throwable -> 0x003e }
        r8 = 1;
        r7.m4855a(r8);	 Catch:{ Throwable -> 0x003e }
        goto L_0x0010;
    L_0x003e:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0042:
        if (r0 == 0) goto L_0x0048;
    L_0x0044:
        r7 = f3925j;
        if (r7 != 0) goto L_0x00ec;
    L_0x0048:
        r4 = r6;
        goto L_0x0010;
    L_0x004a:
        r7 = 0;
        f3923h = r7;	 Catch:{ Throwable -> 0x003e }
    L_0x004d:
        r7 = r12.f3927l;	 Catch:{ Throwable -> 0x003e }
        if (r7 == 0) goto L_0x005e;
    L_0x0051:
        r4 = r12.m4921h();	 Catch:{ Throwable -> 0x003e }
        if (r4 == 0) goto L_0x004d;
    L_0x0057:
        r7 = 12;
        if (r4 == r7) goto L_0x004d;
    L_0x005b:
        if (r4 >= 0) goto L_0x0010;
    L_0x005d:
        goto L_0x0010;
    L_0x005e:
        r8 = f3922g;	 Catch:{ Throwable -> 0x003e }
        monitor-enter(r8);	 Catch:{ Throwable -> 0x003e }
        r7 = f3920e;	 Catch:{ all -> 0x00cb }
        r3 = r7.getOutputBuffers();	 Catch:{ all -> 0x00cb }
        r7 = f3920e;	 Catch:{ all -> 0x00cb }
        r9 = f3926k;	 Catch:{ all -> 0x00cb }
        r10 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        r2 = r7.dequeueOutputBuffer(r9, r10);	 Catch:{ all -> 0x00cb }
        if (r2 < 0) goto L_0x00c8;
    L_0x0074:
        r1 = r3[r2];	 Catch:{ all -> 0x00cb }
        r7 = f3925j;	 Catch:{ all -> 0x00cb }
        r7 = r7.length;	 Catch:{ all -> 0x00cb }
        r9 = f3926k;	 Catch:{ all -> 0x00cb }
        r9 = r9.size;	 Catch:{ all -> 0x00cb }
        if (r7 >= r9) goto L_0x0087;
    L_0x007f:
        r7 = f3926k;	 Catch:{ all -> 0x00cb }
        r7 = r7.size;	 Catch:{ all -> 0x00cb }
        r7 = new byte[r7];	 Catch:{ all -> 0x00cb }
        f3925j = r7;	 Catch:{ all -> 0x00cb }
    L_0x0087:
        r7 = f3919d;	 Catch:{ all -> 0x00cb }
        r7 = r7.m4838E();	 Catch:{ all -> 0x00cb }
        if (r7 == 0) goto L_0x009b;
    L_0x008f:
        r7 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4914a(r1);	 Catch:{ all -> 0x00cb }
        if (r7 == 0) goto L_0x009b;
    L_0x0095:
        r7 = f3923h;	 Catch:{ all -> 0x00cb }
        r7 = r7 + 1;
        f3923h = r7;	 Catch:{ all -> 0x00cb }
    L_0x009b:
        r7 = r12.f3928m;	 Catch:{ all -> 0x00cb }
        if (r7 == 0) goto L_0x00b1;
    L_0x009f:
        r7 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4914a(r1);	 Catch:{ all -> 0x00cb }
        if (r7 == 0) goto L_0x00ce;
    L_0x00a5:
        r7 = r12.f3929n;	 Catch:{ all -> 0x00cb }
        r9 = 10;
        if (r7 <= r9) goto L_0x00ce;
    L_0x00ab:
        r7 = 0;
        r12.f3928m = r7;	 Catch:{ all -> 0x00cb }
        r7 = 0;
        r12.f3929n = r7;	 Catch:{ all -> 0x00cb }
    L_0x00b1:
        r7 = f3925j;	 Catch:{ all -> 0x00cb }
        r9 = 0;
        r10 = f3926k;	 Catch:{ all -> 0x00cb }
        r10 = r10.size;	 Catch:{ all -> 0x00cb }
        r1.get(r7, r9, r10);	 Catch:{ all -> 0x00cb }
        r7 = f3926k;	 Catch:{ all -> 0x00cb }
        r0 = r7.size;	 Catch:{ all -> 0x00cb }
        r1.clear();	 Catch:{ all -> 0x00cb }
        r7 = f3920e;	 Catch:{ all -> 0x00cb }
        r9 = 0;
        r7.releaseOutputBuffer(r2, r9);	 Catch:{ all -> 0x00cb }
    L_0x00c8:
        monitor-exit(r8);	 Catch:{ all -> 0x00cb }
        goto L_0x0042;
    L_0x00cb:
        r7 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00cb }
        throw r7;	 Catch:{ Throwable -> 0x003e }
    L_0x00ce:
        r1.clear();	 Catch:{ all -> 0x00cb }
        r7 = f3920e;	 Catch:{ all -> 0x00cb }
        r9 = 0;
        r7.releaseOutputBuffer(r2, r9);	 Catch:{ all -> 0x00cb }
        r7 = r12.f3929n;	 Catch:{ all -> 0x00cb }
        r7 = r7 + 1;
        r12.f3929n = r7;	 Catch:{ all -> 0x00cb }
        r7 = r12.f3929n;	 Catch:{ all -> 0x00cb }
        r7 = r7 % 3;
        if (r7 != 0) goto L_0x00e8;
    L_0x00e3:
        r7 = f3919d;	 Catch:{ all -> 0x00cb }
        r7.m4845L();	 Catch:{ all -> 0x00cb }
    L_0x00e8:
        monitor-exit(r8);	 Catch:{ all -> 0x00cb }
        r4 = r6;
        goto L_0x0010;
    L_0x00ec:
        r6 = f3919d;
        r7 = f3925j;
        r4 = r6.m4853a(r7, r0);
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.screen.video.g.e():int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    private int m4919f() {
        /*
        r12 = this;
        r6 = -1;
        r4 = 0;
        r0 = 0;
        r7 = f3920e;
        if (r7 != 0) goto L_0x0012;
    L_0x0007:
        r7 = "Recorder";
        r8 = "还没完成初始化, 或已经被释放";
        com.baidu.carlife.core.LogUtil.m4443d(r7, r8);
        r4 = r6;
    L_0x0011:
        return r4;
    L_0x0012:
        r7 = f3919d;	 Catch:{ Throwable -> 0x00ed }
        r7 = r7.m4843J();	 Catch:{ Throwable -> 0x00ed }
        if (r7 == 0) goto L_0x001f;
    L_0x001a:
        r8 = 5;
        java.lang.Thread.sleep(r8);	 Catch:{ Throwable -> 0x00ed }
    L_0x001f:
        r7 = f3919d;	 Catch:{ Throwable -> 0x00ed }
        r7 = r7.m4838E();	 Catch:{ Throwable -> 0x00ed }
        if (r7 == 0) goto L_0x0050;
    L_0x0027:
        r7 = f3923h;	 Catch:{ Throwable -> 0x00ed }
        r8 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        if (r7 <= r8) goto L_0x0050;
    L_0x002e:
        r7 = f3920e;	 Catch:{ Throwable -> 0x00ed }
        if (r7 == 0) goto L_0x0050;
    L_0x0032:
        r7 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4922i();	 Catch:{ Throwable -> 0x00ed }
        if (r7 != 0) goto L_0x0040;
    L_0x0038:
        r7 = f3919d;	 Catch:{ Throwable -> 0x00ed }
        r8 = 1;
        r7.m4855a(r8);	 Catch:{ Throwable -> 0x00ed }
        r4 = r6;
        goto L_0x0011;
    L_0x0040:
        r7 = 0;
        f3923h = r7;	 Catch:{ Throwable -> 0x00ed }
    L_0x0043:
        r4 = r12.m4921h();	 Catch:{ Throwable -> 0x00ed }
        if (r4 == 0) goto L_0x0043;
    L_0x0049:
        r7 = 12;
        if (r4 == r7) goto L_0x0043;
    L_0x004d:
        if (r4 >= 0) goto L_0x0011;
    L_0x004f:
        goto L_0x0011;
    L_0x0050:
        r8 = f3922g;	 Catch:{ Throwable -> 0x00ed }
        monitor-enter(r8);	 Catch:{ Throwable -> 0x00ed }
        r7 = f3920e;	 Catch:{ all -> 0x00ea }
        r3 = r7.getOutputBuffers();	 Catch:{ all -> 0x00ea }
        r7 = f3920e;	 Catch:{ all -> 0x00ea }
        r9 = f3926k;	 Catch:{ all -> 0x00ea }
        r10 = r12.f3931p;	 Catch:{ all -> 0x00ea }
        r2 = r7.dequeueOutputBuffer(r9, r10);	 Catch:{ all -> 0x00ea }
        if (r2 < 0) goto L_0x0112;
    L_0x0065:
        r7 = 0;
        r12.f3930o = r7;	 Catch:{ all -> 0x00ea }
        r1 = r3[r2];	 Catch:{ all -> 0x00ea }
        r7 = f3925j;	 Catch:{ all -> 0x00ea }
        r7 = r7.length;	 Catch:{ all -> 0x00ea }
        r9 = f3926k;	 Catch:{ all -> 0x00ea }
        r9 = r9.size;	 Catch:{ all -> 0x00ea }
        if (r7 >= r9) goto L_0x007b;
    L_0x0073:
        r7 = f3926k;	 Catch:{ all -> 0x00ea }
        r7 = r7.size;	 Catch:{ all -> 0x00ea }
        r7 = new byte[r7];	 Catch:{ all -> 0x00ea }
        f3925j = r7;	 Catch:{ all -> 0x00ea }
    L_0x007b:
        r7 = f3919d;	 Catch:{ all -> 0x00ea }
        r7 = r7.m4838E();	 Catch:{ all -> 0x00ea }
        if (r7 == 0) goto L_0x008f;
    L_0x0083:
        r7 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4914a(r1);	 Catch:{ all -> 0x00ea }
        if (r7 == 0) goto L_0x008f;
    L_0x0089:
        r7 = f3923h;	 Catch:{ all -> 0x00ea }
        r7 = r7 + 1;
        f3923h = r7;	 Catch:{ all -> 0x00ea }
    L_0x008f:
        r7 = r12.f3928m;	 Catch:{ all -> 0x00ea }
        if (r7 == 0) goto L_0x00b0;
    L_0x0093:
        r7 = r12.f3929n;	 Catch:{ all -> 0x00ea }
        r7 = r7 % 10;
        if (r7 != 0) goto L_0x009e;
    L_0x0099:
        r7 = 1038; // 0x40e float:1.455E-42 double:5.13E-321;
        com.baidu.carlife.core.MsgHandlerCenter.dispatchMessage(r7);	 Catch:{ all -> 0x00ea }
    L_0x009e:
        r7 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4914a(r1);	 Catch:{ all -> 0x00ea }
        if (r7 == 0) goto L_0x00d8;
    L_0x00a4:
        r7 = r12.f3929n;	 Catch:{ all -> 0x00ea }
        r9 = 15;
        if (r7 <= r9) goto L_0x00d8;
    L_0x00aa:
        r7 = 0;
        r12.f3928m = r7;	 Catch:{ all -> 0x00ea }
        r7 = 0;
        r12.f3929n = r7;	 Catch:{ all -> 0x00ea }
    L_0x00b0:
        r7 = f3925j;	 Catch:{ all -> 0x00ea }
        r9 = 0;
        r10 = f3926k;	 Catch:{ all -> 0x00ea }
        r10 = r10.size;	 Catch:{ all -> 0x00ea }
        r1.get(r7, r9, r10);	 Catch:{ all -> 0x00ea }
        r7 = f3926k;	 Catch:{ all -> 0x00ea }
        r0 = r7.size;	 Catch:{ all -> 0x00ea }
        r1.clear();	 Catch:{ all -> 0x00ea }
        r7 = f3920e;	 Catch:{ all -> 0x00ea }
        r9 = 0;
        r7.releaseOutputBuffer(r2, r9);	 Catch:{ all -> 0x00ea }
        monitor-exit(r8);	 Catch:{ all -> 0x00ea }
        r6 = f3919d;
        r6 = r6.m4870e();
        if (r6 == 0) goto L_0x0131;
    L_0x00d0:
        r6 = f3919d;
        r4 = r6.m4846M();
        goto L_0x0011;
    L_0x00d8:
        r1.clear();	 Catch:{ all -> 0x00ea }
        r7 = f3920e;	 Catch:{ all -> 0x00ea }
        r9 = 0;
        r7.releaseOutputBuffer(r2, r9);	 Catch:{ all -> 0x00ea }
        r7 = r12.f3929n;	 Catch:{ all -> 0x00ea }
        r7 = r7 + 1;
        r12.f3929n = r7;	 Catch:{ all -> 0x00ea }
        monitor-exit(r8);	 Catch:{ all -> 0x00ea }
        goto L_0x0011;
    L_0x00ea:
        r7 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00ea }
        throw r7;	 Catch:{ Throwable -> 0x00ed }
    L_0x00ed:
        r5 = move-exception;
        r5.printStackTrace();
        r7 = "Recorder";
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "outputFromEncoder50 ";
        r8 = r8.append(r9);
        r9 = r5.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        com.baidu.carlife.core.LogUtil.e(r7, r8);
        r4 = r6;
        goto L_0x0011;
    L_0x0112:
        r7 = r12.f3930o;	 Catch:{ all -> 0x00ea }
        r7 = r7 + 1;
        r12.f3930o = r7;	 Catch:{ all -> 0x00ea }
        r7 = r12.f3930o;	 Catch:{ all -> 0x00ea }
        r9 = 5;
        if (r7 <= r9) goto L_0x012e;
    L_0x011d:
        r7 = 1038; // 0x40e float:1.455E-42 double:5.13E-321;
        com.baidu.carlife.core.MsgHandlerCenter.dispatchMessage(r7);	 Catch:{ all -> 0x00ea }
        r7 = 0;
        r12.f3930o = r7;	 Catch:{ all -> 0x00ea }
        r7 = f3919d;	 Catch:{ all -> 0x00ea }
        r4 = r7.m4845L();	 Catch:{ all -> 0x00ea }
        monitor-exit(r8);	 Catch:{ all -> 0x00ea }
        goto L_0x0011;
    L_0x012e:
        monitor-exit(r8);	 Catch:{ all -> 0x00ea }
        goto L_0x0011;
    L_0x0131:
        r6 = f3919d;
        r7 = f3925j;
        r4 = r6.m4853a(r7, r0);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.screen.video.g.f():int");
    }

    /* renamed from: a */
    public static int m4912a(byte[] input) {
        int outDataLength = 0;
        if (input == null) {
            LogUtil.m4440c(f3916a, "input buffer is null");
            return 0;
        }
        LogUtil.e(f3916a, "Into firstSendEncodeFrame(byte[] input) input=" + input.length);
        if (f3920e == null) {
            LogUtil.m4443d(f3916a, "还没完成初始化, 或已经被释放");
            return 0;
        }
        BufferInfo bufferInfo;
        int outputBufferIndex;
        ByteBuffer outputBuffer;
        long enterTimeStamp = System.currentTimeMillis();
        while (true) {
            ByteBuffer[] outputBuffers = null;
            try {
                synchronized (f3921f) {
                    ByteBuffer[] inputBuffers = f3920e.getInputBuffers();
                    outputBuffers = f3920e.getOutputBuffers();
                    int inputBufferIndex = f3920e.dequeueInputBuffer(f3917b);
                    if (inputBufferIndex >= 0) {
                        ByteBuffer inputBuffer = inputBuffers[inputBufferIndex];
                        inputBuffer.clear();
                        inputBuffer.put(input);
                        f3920e.queueInputBuffer(inputBufferIndex, 0, input.length, f3919d.m4895z(), 0);
                        LogUtil.e(f3916a, "firstSendEncodeFrame_inputBufferIndex >= 0");
                    } else {
                        LogUtil.e(f3916a, "firstSendEncodeFrame_inputBufferIndex < 0");
                    }
                    bufferInfo = new BufferInfo();
                    outputBufferIndex = f3920e.dequeueOutputBuffer(bufferInfo, f3917b);
                    if (outputBufferIndex >= 0) {
                        outputBuffer = outputBuffers[outputBufferIndex];
                        if (VideoOutputThread.m4914a(outputBuffer)) {
                            break;
                        }
                        outDataLength = 0;
                        outputBuffer.clear();
                        f3920e.releaseOutputBuffer(outputBufferIndex, false);
                        LogUtil.e(f3916a, "firstSendEncodeFrame_outputBufferIndex >= 0");
                    } else {
                        LogUtil.e(f3916a, "firstSendEncodeFrame_outputBufferIndex < 0");
                    }
                }
            } catch (IllegalStateException e) {
                LogUtil.e(f3916a, "firstSendEncodeFrame_IllegalStateException");
                e.printStackTrace();
                if (!(f3920e == null || VideoOutputThread.m4922i())) {
                    f3919d.m4855a(1);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
            VideoOutputThread.m4913a(enterTimeStamp, outputBuffers);
        }
        outDataLength = bufferInfo.size;
        if (f3925j == null || f3925j.length < f3924i.length + outDataLength) {
            f3925j = new byte[(f3924i.length + outDataLength)];
        }
        System.arraycopy(f3924i, 0, f3925j, 0, f3924i.length);
        outputBuffer.get(f3925j, f3924i.length, outDataLength);
        outputBuffer.clear();
        f3920e.releaseOutputBuffer(outputBufferIndex, false);
        outDataLength += f3924i.length;
        if (outDataLength == 0 || f3925j == null) {
            LogUtil.m4440c(f3916a, "firstSendEncodeFrame 不是I帧啊");
            f3919d.m4845L();
            return 0;
        }
        LogUtil.e(f3916a, "firstSendEncodeFrame(byte[] input) data=" + f3925j + ", outDataLength=" + outDataLength);
        f3919d.m4853a(f3925j, outDataLength);
        LogUtil.e(f3916a, "End firstSendEncodeFrame(byte[] input)");
        return outDataLength;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    private int m4920g() {
        /*
        r15 = this;
        r8 = -1;
        r7 = 0;
        r2 = 0;
        r1 = 0;
        r9 = f3922g;
        monitor-enter(r9);
        r10 = f3920e;	 Catch:{ all -> 0x0149 }
        if (r10 != 0) goto L_0x0020;
    L_0x000b:
        r8 = "Recorder";
        r10 = "还没完成初始化, 或已经被释放";
        com.baidu.carlife.core.LogUtil.m4443d(r8, r10);	 Catch:{ all -> 0x0149 }
        monitor-exit(r9);	 Catch:{ all -> 0x0149 }
    L_0x0015:
        return r7;
    L_0x0016:
        r2 = 0;
        r3.clear();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = f3920e;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = 0;
        r10.releaseOutputBuffer(r4, r11);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
    L_0x0020:
        r10 = r15.f3927l;	 Catch:{ all -> 0x0149 }
        if (r10 == 0) goto L_0x00a0;
    L_0x0024:
        r10 = f3920e;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r5 = r10.getOutputBuffers();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = f3920e;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = f3926k;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r12 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        r4 = r10.dequeueOutputBuffer(r11, r12);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = "Recorder";
        r11 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11.<init>();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r12 = "firstSendEncodeFrame() outputBufferIndex=";
        r11 = r11.append(r12);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = r11.append(r4);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = r11.toString();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        com.baidu.carlife.core.LogUtil.e(r10, r11);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        if (r4 < 0) goto L_0x00f3;
    L_0x0051:
        r3 = r5[r4];	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4914a(r3);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        if (r10 == 0) goto L_0x00d5;
    L_0x0059:
        r10 = "Recorder";
        r11 = "firstSendEncodeFrame() isIFrame yes";
        com.baidu.carlife.core.LogUtil.m4440c(r10, r11);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = f3926k;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r2 = r10.size;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = f3925j;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        if (r10 == 0) goto L_0x0073;
    L_0x006a:
        r10 = f3925j;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = r10.length;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = f3924i;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = r11.length;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = r11 + r2;
        if (r10 >= r11) goto L_0x007b;
    L_0x0073:
        r10 = f3924i;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = r10.length;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = r10 + r2;
        r10 = new byte[r10];	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        f3925j = r10;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
    L_0x007b:
        r10 = f3924i;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = 0;
        r12 = f3925j;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r13 = 0;
        r14 = f3924i;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r14 = r14.length;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        java.lang.System.arraycopy(r10, r11, r12, r13, r14);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = f3925j;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = f3924i;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = r11.length;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r12 = f3926k;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r12 = r12.size;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r3.get(r10, r11, r12);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r3.clear();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = f3920e;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = 0;
        r10.releaseOutputBuffer(r4, r11);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = f3924i;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r8 = r10.length;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r2 = r2 + r8;
    L_0x00a0:
        monitor-exit(r9);	 Catch:{ all -> 0x0149 }
        r8 = "Recorder";
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "firstSendEncodeFrame() data=";
        r9 = r9.append(r10);
        r10 = f3925j;
        r9 = r9.append(r10);
        r10 = ", outDataLength=";
        r9 = r9.append(r10);
        r9 = r9.append(r2);
        r9 = r9.toString();
        com.baidu.carlife.core.LogUtil.e(r8, r9);
        if (r2 == 0) goto L_0x00ce;
    L_0x00ca:
        r8 = f3925j;
        if (r8 != 0) goto L_0x0152;
    L_0x00ce:
        r8 = f3919d;
        r8.m4845L();
        goto L_0x0015;
    L_0x00d5:
        r10 = "Recorder";
        r11 = "firstSendEncodeFrame() isIFrame no";
        com.baidu.carlife.core.LogUtil.m4440c(r10, r11);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = f3919d;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = r10.m4845L();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        if (r10 >= 0) goto L_0x0016;
    L_0x00e6:
        r10 = "Recorder";
        r11 = "firstSendEncodeFrame() sendEmptyPacketForeground failed";
        com.baidu.carlife.core.LogUtil.e(r10, r11);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        monitor-exit(r9);	 Catch:{ all -> 0x0149 }
        r7 = r8;
        goto L_0x0015;
    L_0x00f3:
        r1 = r1 + 1;
        r10 = 5;
        if (r1 <= r10) goto L_0x0113;
    L_0x00f8:
        r10 = f3919d;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r10 = r10.m4845L();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        if (r10 >= 0) goto L_0x010d;
    L_0x0100:
        r10 = "Recorder";
        r11 = "firstSendEncodeFrame() sendEmptyPacketForeground failed";
        com.baidu.carlife.core.LogUtil.e(r10, r11);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        monitor-exit(r9);	 Catch:{ all -> 0x0149 }
        r7 = r8;
        goto L_0x0015;
    L_0x010d:
        r1 = 0;
        r10 = 1038; // 0x40e float:1.455E-42 double:5.13E-321;
        com.baidu.carlife.core.MsgHandlerCenter.dispatchMessage(r10);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
    L_0x0113:
        r10 = "Recorder";
        r11 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11.<init>();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r12 = "firstSendEncodeFrame() emptyCount=";
        r11 = r11.append(r12);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = r11.append(r1);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        r11 = r11.toString();	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        com.baidu.carlife.core.LogUtil.e(r10, r11);	 Catch:{ IllegalStateException -> 0x012f, Throwable -> 0x014c }
        goto L_0x0020;
    L_0x012f:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0149 }
        r10 = f3920e;	 Catch:{ all -> 0x0149 }
        if (r10 == 0) goto L_0x0020;
    L_0x0137:
        r10 = r15.f3927l;	 Catch:{ all -> 0x0149 }
        if (r10 == 0) goto L_0x0020;
    L_0x013b:
        r10 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4922i();	 Catch:{ all -> 0x0149 }
        if (r10 != 0) goto L_0x0020;
    L_0x0141:
        r8 = f3919d;	 Catch:{ all -> 0x0149 }
        r10 = 1;
        r8.m4855a(r10);	 Catch:{ all -> 0x0149 }
        goto L_0x00a0;
    L_0x0149:
        r7 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0149 }
        throw r7;
    L_0x014c:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x0149 }
        goto L_0x0020;
    L_0x0152:
        r7 = f3919d;
        r8 = f3925j;
        r7.m4853a(r8, r2);
        r7 = r2;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.screen.video.g.g():int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    private int m4921h() {
        /*
        r12 = this;
        r6 = 0;
        r1 = 0;
        r7 = f3922g;	 Catch:{ Throwable -> 0x007e }
        monitor-enter(r7);	 Catch:{ Throwable -> 0x007e }
        r8 = f3920e;	 Catch:{ all -> 0x007b }
        r4 = r8.getOutputBuffers();	 Catch:{ all -> 0x007b }
        r0 = new android.media.MediaCodec$BufferInfo;	 Catch:{ all -> 0x007b }
        r0.<init>();	 Catch:{ all -> 0x007b }
        r8 = f3920e;	 Catch:{ all -> 0x007b }
        r10 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        r3 = r8.dequeueOutputBuffer(r0, r10);	 Catch:{ all -> 0x007b }
        if (r3 < 0) goto L_0x00a2;
    L_0x001b:
        r8 = 0;
        r12.f3930o = r8;	 Catch:{ all -> 0x007b }
        r2 = r4[r3];	 Catch:{ all -> 0x007b }
        r8 = f3925j;	 Catch:{ all -> 0x007b }
        r8 = r8.length;	 Catch:{ all -> 0x007b }
        r9 = f3926k;	 Catch:{ all -> 0x007b }
        r9 = r9.size;	 Catch:{ all -> 0x007b }
        if (r8 >= r9) goto L_0x0031;
    L_0x0029:
        r8 = f3926k;	 Catch:{ all -> 0x007b }
        r8 = r8.size;	 Catch:{ all -> 0x007b }
        r8 = new byte[r8];	 Catch:{ all -> 0x007b }
        f3925j = r8;	 Catch:{ all -> 0x007b }
    L_0x0031:
        r8 = com.baidu.carlife.core.screen.video.VideoOutputThread.m4914a(r2);	 Catch:{ all -> 0x007b }
        if (r8 == 0) goto L_0x0070;
    L_0x0037:
        r8 = f3923h;	 Catch:{ all -> 0x007b }
        r8 = r8 + 1;
        f3923h = r8;	 Catch:{ all -> 0x007b }
        r8 = f3925j;	 Catch:{ all -> 0x007b }
        r9 = 0;
        r10 = f3926k;	 Catch:{ all -> 0x007b }
        r10 = r10.size;	 Catch:{ all -> 0x007b }
        r2.get(r8, r9, r10);	 Catch:{ all -> 0x007b }
        r8 = f3926k;	 Catch:{ all -> 0x007b }
        r1 = r8.size;	 Catch:{ all -> 0x007b }
        r2.clear();	 Catch:{ all -> 0x007b }
        r8 = f3920e;	 Catch:{ all -> 0x007b }
        r9 = 0;
        r8.releaseOutputBuffer(r3, r9);	 Catch:{ all -> 0x007b }
    L_0x0054:
        monitor-exit(r7);	 Catch:{ all -> 0x007b }
        if (r1 != 0) goto L_0x00a9;
    L_0x0057:
        r7 = r12.f3930o;
        r8 = 5;
        if (r7 <= r8) goto L_0x006f;
    L_0x005c:
        r7 = com.baidu.carlife.core.p069b.CarlifeConfig.m4065a();
        if (r7 == 0) goto L_0x0067;
    L_0x0062:
        r7 = 1038; // 0x40e float:1.455E-42 double:5.13E-321;
        com.baidu.carlife.core.MsgHandlerCenter.dispatchMessage(r7);
    L_0x0067:
        r12.f3930o = r6;
        r6 = f3919d;
        r6 = r6.m4846M();
    L_0x006f:
        return r6;
    L_0x0070:
        r2.clear();	 Catch:{ all -> 0x007b }
        r8 = f3920e;	 Catch:{ all -> 0x007b }
        r9 = 0;
        r8.releaseOutputBuffer(r3, r9);	 Catch:{ all -> 0x007b }
        monitor-exit(r7);	 Catch:{ all -> 0x007b }
        goto L_0x006f;
    L_0x007b:
        r6 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x007b }
        throw r6;	 Catch:{ Throwable -> 0x007e }
    L_0x007e:
        r5 = move-exception;
        r5.printStackTrace();
        r6 = "Recorder";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "getFirstIFrameAfterReset ";
        r7 = r7.append(r8);
        r8 = r5.toString();
        r7 = r7.append(r8);
        r7 = r7.toString();
        com.baidu.carlife.core.LogUtil.e(r6, r7);
        r6 = -1;
        goto L_0x006f;
    L_0x00a2:
        r8 = r12.f3930o;	 Catch:{ all -> 0x007b }
        r8 = r8 + 1;
        r12.f3930o = r8;	 Catch:{ all -> 0x007b }
        goto L_0x0054;
    L_0x00a9:
        r6 = f3919d;
        r7 = f3925j;
        r6 = r6.m4853a(r7, r1);
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.screen.video.g.h():int");
    }

    /* renamed from: a */
    private static boolean m4914a(ByteBuffer frameData) {
        if (frameData != null && (frameData.get(4) & 31) == 5) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m4913a(long enterTime, ByteBuffer[] outputBuffers) {
        if (System.currentTimeMillis() - enterTime > 2000 && !f3918c) {
            f3918c = true;
            int length = outputBuffers != null ? outputBuffers.length : 8;
            for (int i = 0; i < length; i++) {
                try {
                    f3920e.releaseOutputBuffer(i, false);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
            MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.fj, (Object) "缓冲区已清空");
        }
    }

    /* renamed from: i */
    private static boolean m4922i() {
        f3920e = null;
        f3919d.m4842I();
        f3920e = f3919d.m4892w();
        if (f3920e == null) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m4915b() {
        return f3924i == null;
    }

    /* renamed from: c */
    public static void m4916c() {
        f3924i = null;
    }
}
