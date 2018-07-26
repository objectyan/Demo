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
    private static final String Tag = "ReceiverAndConverter";
    /* renamed from: i */
    private static final String f3844i = "--QA-TEST--";
    /* renamed from: j */
    private static final String f3845j = "/data/local/tmp/sc.sock";
    /* renamed from: k */
    private static byte[] f3846k;
    /* renamed from: l */
    private static Recorder f3847l = Recorder.newInstance();
    /* renamed from: m */
    private long f3848m = ((long) Recorder.f3864e);
    /* renamed from: n */
    private LocalSocket f3849n;

    /* renamed from: a */
    public void mo1523a() {
        this.f3835a = false;
        f3847l.m4891v();
    }

    /* renamed from: a */
    public void mo1524a(int newRate) {
        if (newRate > 0 && this.mDataOutputStream != null) {
            try {
                this.mDataOutputStream.write((byte) (newRate + 100));
                this.f3848m = (long) (1000 / newRate);
            } catch (IOException e) {
                LogUtil.e(f3844i, "changeFrameRate Writer error");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m4800c() {
        this.f3835a = false;
        m4802d();
        f3847l.m4891v();
        f3847l.m4836C();
    }

    /* renamed from: d */
    private void m4802d() {
        if (this.f3849n != null) {
            try {
                if (!f3847l.m4888s()) {
                    this.mDataOutputStream.write(1);
                    f3847l.m4874g(true);
                }
                this.mDataOutputStream.write(2);
                this.mDataInputStream.readFully(f3831d, 0, f3831d.length);
                this.mDataOutputStream.close();
                this.mDataInputStream.close();
                this.f3849n.close();
                this.mDataOutputStream = null;
                this.mDataInputStream = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f3849n = null;
        }
    }

    public void run() {
        try {
            if (f3847l.m4879j() || f3847l.m4840G()) {
                this.f3848m = (long) Recorder.f3864e;
                try {
                    this.f3849n = new LocalSocket();
                    this.f3849n.connect(new LocalSocketAddress(f3845j));
                    try {
                        LogUtil.m4440c(f3844i, "accept");
                        this.mDataInputStream = new DataInputStream(this.f3849n.getInputStream());
                        this.mDataOutputStream = new DataOutputStream(this.f3849n.getOutputStream());
                        this.mDataOutputStream.writeInt(Recorder.f3861b);
                        this.mDataOutputStream.writeInt(Recorder.f3862c);
                        this.mDataOutputStream.writeInt(CarlifeScreenUtil.m4331a().m4351h());
                        this.mDataOutputStream.writeInt(CarlifeScreenUtil.m4331a().m4352i());
                        this.mDataOutputStream.writeInt(0);
                        this.mDataOutputStream.write((byte) (Recorder.f3863d + 100));
                        this.mDataOutputStream.write(1);
                        f3847l.m4874g(true);
                        int dataLength = (Recorder.f3861b * Recorder.f3862c) * 4;
                        if (f3831d == null || f3831d.length != dataLength) {
                            f3831d = new byte[dataLength];
                        }
                        while (!CarLifeSettings.m4069a().m4082e() && this.f3835a) {
                            if (f3847l.m4888s()) {
                                this.mDataInputStream.readFully(f3831d, 0, dataLength);
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
                            this.mDataOutputStream.write(1);
                            f3847l.m4874g(true);
                        }
                        m4792b();
                        int mColorFormat = f3847l.m4886q();
                        if (f3847l.m4879j()) {
                            if (sByteBuffer == null || sBitmap == null || sBitmap.getWidth() != Recorder.f3861b || sBitmap.getHeight() != Recorder.f3862c) {
                                sByteBuffer = ByteBuffer.wrap(f3831d);
                                sBitmap = Bitmap.createBitmap(Recorder.f3861b, Recorder.f3862c, Config.ARGB_8888);
                            }
                            while (this.f3835a) {
                                m4799b(dataLength);
                            }
                        } else if (mColorFormat == 15 || mColorFormat == 16) {
                            if (f3847l.m4837D() || VideoOutputThread.m4915b()) {
                                f3847l.m4876h(false);
                            } else {
                                m4798a(false, dataLength);
                                VideoOutputThread.m4912a(f3831d);
                            }
                            f3847l.m4834A();
                            while (this.f3835a) {
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
                            while (this.f3835a) {
                                m4801c(dataLength);
                            }
                        }
                    } catch (IOException e2) {
                        LogUtil.e(Tag, "LocalSocket 读写异常");
                        e2.printStackTrace();
                    } catch (NullPointerException e3) {
                        LogUtil.m4440c(Tag, "Output Thread closeLocalSocket lead to");
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    m4800c();
                    return;
                } catch (IOException e22) {
                    LogUtil.e(Tag, "connect to localSocket fail");
                    f3847l.m4891v();
                    this.f3849n = null;
                    e22.printStackTrace();
                    return;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m4800c();
    }

    /* renamed from: b */
    private void m4799b(int imgDataLength) throws IOException {
        if (f3847l.m4870e()) {
            if (f3847l.m4888s()) {
                this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
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
            this.mDataOutputStream.write(1);
            f3847l.m4874g(true);
        }
        long startTime = System.currentTimeMillis();
        this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
        LogUtil.m4440c(f3844i, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        sByteBuffer.rewind();
        sBitmap.copyPixelsFromBuffer(sByteBuffer);
        sBitmap.compress(CompressFormat.JPEG, 70, this.mByteArrayOutputStream);
        int length = this.mByteArrayOutputStream.size();
        if (f3847l.m4853a(this.mByteArrayOutputStream.toByteArray(), length) == -1) {
            this.mDataOutputStream.write(2);
            m4800c();
        }
        this.mDataOutputStream.write(1);
        this.mByteArrayOutputStream.reset();
        LogUtil.m4440c(f3844i, "JAVA jpeg time = " + (System.currentTimeMillis() - startTime) + ", length = " + length);
    }

    /* renamed from: c */
    private void m4801c(int imgDataLength) throws IOException {
        if (f3847l.m4870e()) {
            if (f3847l.m4888s()) {
                this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
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
            this.mDataOutputStream.write(1);
            f3847l.m4874g(true);
        }
        long startTime = System.currentTimeMillis();
        this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
        LogUtil.m4440c(f3844i, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        this.mDataOutputStream.write(1);
        startTime = System.currentTimeMillis();
        JniMethod.convert(f3831d, f3846k, Recorder.f3861b, Recorder.f3862c);
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
                this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
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
            this.mDataOutputStream.write(1);
            f3847l.m4874g(true);
        }
        long startTime = System.currentTimeMillis();
        this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
        LogUtil.m4440c(f3844i, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        this.mDataOutputStream.write(1);
        startTime = System.currentTimeMillis();
        int flag = f3847l.m4852a(f3831d);
        if (this.f3848m * ((long) f3847l.m4889t()) < System.currentTimeMillis() - f3847l.m4890u()) {
            flag = f3847l.m4852a(f3831d);
        }
        if (flag == -2 && this.f3849n == null) {
            m4800c();
        }
        LogUtil.m4440c(f3844i, "JAVA encode time = " + (System.currentTimeMillis() - startTime));
    }

    /* renamed from: a */
    private void m4798a(boolean needConvert, int imgDataLength) throws IOException {
        if (!f3847l.m4888s()) {
            this.mDataOutputStream.write(1);
            f3847l.m4874g(true);
        }
        this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
        this.mDataOutputStream.write(1);
        if (needConvert) {
            JniMethod.convert(f3831d, f3846k, Recorder.f3861b, Recorder.f3862c);
        }
    }
}
