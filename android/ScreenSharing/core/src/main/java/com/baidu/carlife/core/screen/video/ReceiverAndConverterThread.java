package com.baidu.carlife.core.screen.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.LogUtil;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ReceiverAndConverterThread */
/* renamed from: com.baidu.carlife.core.screen.video.c */
class ReceiverAndConverterThread extends BaseReceiverAndConverterThread {
    /* renamed from: h */
    private static final String f3843h = "ReceiverAndConverter";
    /* renamed from: i */
    private static final String f3844i = "--QA-TEST--";
    /* renamed from: j */
    private static final String f3845j = "/data/local/tmp/sc.sock";
    /* renamed from: k */
    private static byte[] f3846k;
    /* renamed from: l */
    private static Recorder f3847l = Recorder.m4826b();
    /* renamed from: m */
    private long f3848m = ((long) Recorder.f3864e);
    /* renamed from: n */
    private LocalSocket f3849n;

    /* renamed from: a */
    public void mo1523a() {
        this.a = false;
        f3847l.m4891v();
    }

    /* renamed from: a */
    public void mo1524a(int newRate) {
        if (newRate > 0 && this.c != null) {
            try {
                this.c.write((byte) (newRate + 100));
                this.f3848m = (long) (1000 / newRate);
            } catch (IOException e) {
                LogUtil.m4445e(f3844i, "changeFrameRate Writer error");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m4800c() {
        this.a = false;
        m4802d();
        f3847l.m4891v();
        f3847l.m4836C();
    }

    /* renamed from: d */
    private void m4802d() {
        if (this.f3849n != null) {
            try {
                if (!f3847l.m4888s()) {
                    this.c.write(1);
                    f3847l.m4874g(true);
                }
                this.c.write(2);
                this.b.readFully(d, 0, d.length);
                this.c.close();
                this.b.close();
                this.f3849n.close();
                this.c = null;
                this.b = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f3849n = null;
        }
    }

    public void run() {
        if (f3847l.m4879j() || f3847l.m4840G()) {
            this.f3848m = (long) Recorder.f3864e;
            try {
                this.f3849n = new LocalSocket();
                this.f3849n.connect(new LocalSocketAddress(f3845j));
                try {
                    LogUtil.m4440c(f3844i, "accept");
                    this.b = new DataInputStream(this.f3849n.getInputStream());
                    this.c = new DataOutputStream(this.f3849n.getOutputStream());
                    this.c.writeInt(Recorder.f3861b);
                    this.c.writeInt(Recorder.f3862c);
                    this.c.writeInt(CarlifeScreenUtil.m4331a().m4351h());
                    this.c.writeInt(CarlifeScreenUtil.m4331a().m4352i());
                    this.c.writeInt(0);
                    this.c.write((byte) (Recorder.f3863d + 100));
                    this.c.write(1);
                    f3847l.m4874g(true);
                    int dataLength = (Recorder.f3861b * Recorder.f3862c) * 4;
                    if (d == null || d.length != dataLength) {
                        d = new byte[dataLength];
                    }
                    while (!CarLifeSettings.m4069a().m4082e() && this.a) {
                        if (f3847l.m4888s()) {
                            this.b.readFully(d, 0, dataLength);
                            f3847l.m4874g(false);
                        }
                        if (f3847l.m4845L() == -1) {
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!f3847l.m4888s()) {
                        this.c.write(1);
                        f3847l.m4874g(true);
                    }
                    m4792b();
                    int mColorFormat = f3847l.m4886q();
                    if (f3847l.m4879j()) {
                        if (e == null || f == null || f.getWidth() != Recorder.f3861b || f.getHeight() != Recorder.f3862c) {
                            e = ByteBuffer.wrap(d);
                            f = Bitmap.createBitmap(Recorder.f3861b, Recorder.f3862c, Config.ARGB_8888);
                        }
                        while (this.a) {
                            m4799b(dataLength);
                        }
                    } else if (mColorFormat == 15 || mColorFormat == 16) {
                        if (f3847l.m4837D() || VideoOutputThread.m4915b()) {
                            f3847l.m4876h(false);
                        } else {
                            m4798a(false, dataLength);
                            VideoOutputThread.m4912a(d);
                        }
                        f3847l.m4834A();
                        while (this.a) {
                            m4803d(dataLength);
                        }
                    } else {
                        if ((f3847l.m4837D() && f3846k == null) || VideoOutputThread.m4915b()) {
                            if (mColorFormat == 6 || mColorFormat == 7) {
                                f3846k = new byte[((Recorder.f3861b * Recorder.f3862c) * 2)];
                            } else {
                                f3846k = new byte[(((Recorder.f3861b * Recorder.f3862c) * 3) / 2)];
                            }
                            f3847l.m4876h(false);
                        } else {
                            m4798a(true, dataLength);
                            VideoOutputThread.m4912a(f3846k);
                        }
                        f3847l.m4834A();
                        while (this.a) {
                            m4801c(dataLength);
                        }
                    }
                } catch (IOException e2) {
                    LogUtil.m4445e(f3843h, "LocalSocket 读写异常");
                    e2.printStackTrace();
                } catch (NullPointerException e3) {
                    LogUtil.m4440c(f3843h, "Output Thread closeLocalSocket lead to");
                }
                m4800c();
                return;
            } catch (IOException e22) {
                LogUtil.m4445e(f3843h, "connect to localSocket fail");
                f3847l.m4891v();
                this.f3849n = null;
                e22.printStackTrace();
                return;
            }
        }
        m4800c();
    }

    /* renamed from: b */
    private void m4799b(int imgDataLength) throws IOException {
        if (f3847l.m4870e()) {
            if (f3847l.m4888s()) {
                this.b.readFully(d, 0, imgDataLength);
                f3847l.m4874g(false);
            }
            if (f3847l.m4846M() == -1) {
                m4800c();
            }
            try {
                Thread.sleep(50);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (!f3847l.m4888s()) {
            this.c.write(1);
            f3847l.m4874g(true);
        }
        long startTime = System.currentTimeMillis();
        this.b.readFully(d, 0, imgDataLength);
        LogUtil.m4440c(f3844i, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        e.rewind();
        f.copyPixelsFromBuffer(e);
        f.compress(CompressFormat.JPEG, 70, this.g);
        int length = this.g.size();
        if (f3847l.m4853a(this.g.toByteArray(), length) == -1) {
            this.c.write(2);
            m4800c();
        }
        this.c.write(1);
        this.g.reset();
        LogUtil.m4440c(f3844i, "JAVA jpeg time = " + (System.currentTimeMillis() - startTime) + ", length = " + length);
    }

    /* renamed from: c */
    private void m4801c(int imgDataLength) throws IOException {
        if (f3847l.m4870e()) {
            if (f3847l.m4888s()) {
                this.b.readFully(d, 0, imgDataLength);
                f3847l.m4874g(false);
            }
            if (f3847l.m4846M() == -1) {
                m4800c();
            }
            try {
                Thread.sleep(50);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (!f3847l.m4888s()) {
            this.c.write(1);
            f3847l.m4874g(true);
        }
        long startTime = System.currentTimeMillis();
        this.b.readFully(d, 0, imgDataLength);
        LogUtil.m4440c(f3844i, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        this.c.write(1);
        startTime = System.currentTimeMillis();
        JniMethod.convert(d, f3846k, Recorder.f3861b, Recorder.f3862c);
        LogUtil.m4440c(f3844i, "JAVA native convert time = " + (System.currentTimeMillis() - startTime) + "~~~~~");
        startTime = System.currentTimeMillis();
        int flag = f3847l.m4852a(f3846k);
        if (this.f3848m * ((long) f3847l.m4889t()) < System.currentTimeMillis() - f3847l.m4890u()) {
            flag = f3847l.m4852a(f3846k);
        }
        if (flag == -2 && this.f3849n == null) {
            m4800c();
        }
        LogUtil.m4440c(f3844i, "JAVA input2Encoder time = " + (System.currentTimeMillis() - startTime));
    }

    /* renamed from: d */
    private void m4803d(int imgDataLength) throws IOException {
        if (f3847l.m4870e()) {
            if (f3847l.m4888s()) {
                this.b.readFully(d, 0, imgDataLength);
                f3847l.m4874g(false);
            }
            if (f3847l.m4846M() == -1) {
                m4800c();
            }
            try {
                Thread.sleep(50);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (!f3847l.m4888s()) {
            this.c.write(1);
            f3847l.m4874g(true);
        }
        long startTime = System.currentTimeMillis();
        this.b.readFully(d, 0, imgDataLength);
        LogUtil.m4440c(f3844i, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        this.c.write(1);
        startTime = System.currentTimeMillis();
        int flag = f3847l.m4852a(d);
        if (this.f3848m * ((long) f3847l.m4889t()) < System.currentTimeMillis() - f3847l.m4890u()) {
            flag = f3847l.m4852a(d);
        }
        if (flag == -2 && this.f3849n == null) {
            m4800c();
        }
        LogUtil.m4440c(f3844i, "JAVA encode time = " + (System.currentTimeMillis() - startTime));
    }

    /* renamed from: a */
    private void m4798a(boolean needConvert, int imgDataLength) throws IOException {
        if (!f3847l.m4888s()) {
            this.c.write(1);
            f3847l.m4874g(true);
        }
        this.b.readFully(d, 0, imgDataLength);
        this.c.write(1);
        if (needConvert) {
            JniMethod.convert(d, f3846k, Recorder.f3861b, Recorder.f3862c);
        }
    }
}
