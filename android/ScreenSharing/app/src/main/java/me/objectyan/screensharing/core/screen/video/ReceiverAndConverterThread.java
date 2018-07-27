package me.objectyan.screensharing.core.screen.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.util.Log;

import me.objectyan.screensharing.core.CarLifeSettings;
import me.objectyan.screensharing.core.CarlifeScreenUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;


class ReceiverAndConverterThread extends BaseReceiverAndConverterThread {

    private static final String Tag = "ReceiverAndConverter";

    private static final String DATA_LOCAL_TMP_SC_SOCK = "/data/local/tmp/sc.sock";

    private static byte[] f3846k;

    private static Recorder f3847l = Recorder.newInstance();

    private long mChangeFrameRate = ((long) Recorder.sChangeFrameRate);

    private LocalSocket f3849n;


    public void setInputThreadNull() {
        this.f3835a = false;
        f3847l.setInputThreadNull();
    }


    public void changeFrameRate(int newRate) {
        if (newRate > 0 && this.mDataOutputStream != null) {
            try {
                this.mDataOutputStream.write((byte) (newRate + 100));
                this.mChangeFrameRate = (long) (1000 / newRate);
            } catch (IOException e) {
                Log.e(Tag, "changeFrameRate Writer error");
                e.printStackTrace();
            }
        }
    }


    private void m4800c() {
        this.f3835a = false;
        m4802d();
        f3847l.setInputThreadNull();
        f3847l.m4836C();
    }


    private void m4802d() {
        if (this.f3849n != null) {
            try {
                if (!f3847l.getIsFirstPausingFrame()) {
                    this.mDataOutputStream.write(1);
                    f3847l.setIsFirstPausingFrame(true);
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
            if (f3847l.getIsJPEGMode() || f3847l.m4840G()) {
                this.mChangeFrameRate = (long) Recorder.sChangeFrameRate;
                try {
                    this.f3849n = new LocalSocket();
                    this.f3849n.connect(new LocalSocketAddress(DATA_LOCAL_TMP_SC_SOCK));
                    try {
                        Log.i(Tag, "accept");
                        this.mDataInputStream = new DataInputStream(this.f3849n.getInputStream());
                        this.mDataOutputStream = new DataOutputStream(this.f3849n.getOutputStream());
                        this.mDataOutputStream.writeInt(Recorder.sContainerWidth);
                        this.mDataOutputStream.writeInt(Recorder.sContainerHeight);
                        this.mDataOutputStream.writeInt(CarlifeScreenUtil.newInstance().getWidthPixels());
                        this.mDataOutputStream.writeInt(CarlifeScreenUtil.newInstance().getHeightPixels());
                        this.mDataOutputStream.writeInt(0);
                        this.mDataOutputStream.write((byte) (Recorder.sDestFrameRate + 100));
                        this.mDataOutputStream.write(1);
                        f3847l.setIsFirstPausingFrame(true);
                        int dataLength = (Recorder.sContainerWidth * Recorder.sContainerHeight) * 4;
                        if (f3831d == null || f3831d.length != dataLength) {
                            f3831d = new byte[dataLength];
                        }
                        while (!CarLifeSettings.m4069a().m4082e() && this.f3835a) {
                            if (f3847l.getIsFirstPausingFrame()) {
                                this.mDataInputStream.readFully(f3831d, 0, dataLength);
                                f3847l.setIsFirstPausingFrame(false);
                            }
                            if (f3847l.writeVideo1() == -1) {
                                break;
                            }
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (!f3847l.getIsFirstPausingFrame()) {
                            this.mDataOutputStream.write(1);
                            f3847l.setIsFirstPausingFrame(true);
                        }
                        m4792b();
                        int mColorFormat = f3847l.getColorFormat();
                        if (f3847l.getIsJPEGMode()) {
                            if (sByteBuffer == null || sBitmap == null || sBitmap.getWidth() != Recorder.sContainerWidth || sBitmap.getHeight() != Recorder.sContainerHeight) {
                                sByteBuffer = ByteBuffer.wrap(f3831d);
                                sBitmap = Bitmap.createBitmap(Recorder.sContainerWidth, Recorder.sContainerHeight, Config.ARGB_8888);
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
                            f3847l.startVideoOutputThread();
                            while (this.f3835a) {
                                m4803d(dataLength);
                            }
                        } else {
                            if ((f3847l.m4837D() && f3846k == null) || VideoOutputThread.m4915b()) {
                                if (mColorFormat == 6 || mColorFormat == 7) {
                                    f3846k = new byte[((Recorder.sContainerWidth * Recorder.sContainerHeight) * 2)];
                                } else {
                                    f3846k = new byte[(((Recorder.sContainerWidth * Recorder.sContainerHeight) * 3) / 2)];
                                }
                                f3847l.m4876h(false);
                            } else {
                                m4798a(true, dataLength);
                                VideoOutputThread.m4912a(f3846k);
                            }
                            f3847l.startVideoOutputThread();
                            while (this.f3835a) {
                                m4801c(dataLength);
                            }
                        }
                    } catch (IOException e2) {
                        Log.e(Tag, "LocalSocket 读写异常");
                        e2.printStackTrace();
                    } catch (NullPointerException e3) {
                        Log.i(Tag, "Output Thread closeLocalSocket lead to");
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    m4800c();
                    return;
                } catch (IOException e22) {
                    Log.e(Tag, "connect to localSocket fail");
                    f3847l.setInputThreadNull();
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


    private void m4799b(int imgDataLength) throws IOException {
        if (f3847l.m4870e()) {
            if (f3847l.getIsFirstPausingFrame()) {
                this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
                f3847l.setIsFirstPausingFrame(false);
            }
            if (f3847l.writeVideo2() == -1) {
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
        if (!f3847l.getIsFirstPausingFrame()) {
            this.mDataOutputStream.write(1);
            f3847l.setIsFirstPausingFrame(true);
        }
        long startTime = System.currentTimeMillis();
        this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
        Log.i(Tag, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        sByteBuffer.rewind();
        sBitmap.copyPixelsFromBuffer(sByteBuffer);
        sBitmap.compress(CompressFormat.JPEG, 70, this.mByteArrayOutputStream);
        int length = this.mByteArrayOutputStream.size();
        if (f3847l.encryptVideoData(this.mByteArrayOutputStream.toByteArray(), length) == -1) {
            this.mDataOutputStream.write(2);
            m4800c();
        }
        this.mDataOutputStream.write(1);
        this.mByteArrayOutputStream.reset();
        Log.i(Tag, "JAVA jpeg time = " + (System.currentTimeMillis() - startTime) + ", length = " + length);
    }


    private void m4801c(int imgDataLength) throws IOException {
        if (f3847l.m4870e()) {
            if (f3847l.getIsFirstPausingFrame()) {
                this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
                f3847l.setIsFirstPausingFrame(false);
            }
            if (f3847l.writeVideo2() == -1) {
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
        if (!f3847l.getIsFirstPausingFrame()) {
            this.mDataOutputStream.write(1);
            f3847l.setIsFirstPausingFrame(true);
        }
        long startTime = System.currentTimeMillis();
        this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
        Log.i(Tag, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        this.mDataOutputStream.write(1);
        startTime = System.currentTimeMillis();
        JniMethod.convert(f3831d, f3846k, Recorder.sContainerWidth, Recorder.sContainerHeight);
        Log.i(Tag, "JAVA native convert time = " + (System.currentTimeMillis() - startTime) + "~~~~~");
        startTime = System.currentTimeMillis();
        int flag = f3847l.sendEmptyPacket(f3846k);
        if (this.mChangeFrameRate * ((long) f3847l.m4889t()) < System.currentTimeMillis() - f3847l.getCurrentTimeMillis()) {
            flag = f3847l.sendEmptyPacket(f3846k);
        }
        if (flag == -2 && this.f3849n == null) {
            m4800c();
        }
        Log.i(Tag, "JAVA input2Encoder time = " + (System.currentTimeMillis() - startTime));
    }


    private void m4803d(int imgDataLength) throws IOException {
        if (f3847l.m4870e()) {
            if (f3847l.getIsFirstPausingFrame()) {
                this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
                f3847l.setIsFirstPausingFrame(false);
            }
            if (f3847l.writeVideo2() == -1) {
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
        if (!f3847l.getIsFirstPausingFrame()) {
            this.mDataOutputStream.write(1);
            f3847l.setIsFirstPausingFrame(true);
        }
        long startTime = System.currentTimeMillis();
        this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
        Log.i(Tag, "JAVA got frame time = " + (System.currentTimeMillis() - startTime));
        this.mDataOutputStream.write(1);
        startTime = System.currentTimeMillis();
        int flag = f3847l.sendEmptyPacket(f3831d);
        if (this.mChangeFrameRate * ((long) f3847l.m4889t()) < System.currentTimeMillis() - f3847l.getCurrentTimeMillis()) {
            flag = f3847l.sendEmptyPacket(f3831d);
        }
        if (flag == -2 && this.f3849n == null) {
            m4800c();
        }
        Log.i(Tag, "JAVA encode time = " + (System.currentTimeMillis() - startTime));
    }


    private void m4798a(boolean needConvert, int imgDataLength) throws IOException {
        if (!f3847l.getIsFirstPausingFrame()) {
            this.mDataOutputStream.write(1);
            f3847l.setIsFirstPausingFrame(true);
        }
        this.mDataInputStream.readFully(f3831d, 0, imgDataLength);
        this.mDataOutputStream.write(1);
        if (needConvert) {
            JniMethod.convert(f3831d, f3846k, Recorder.sContainerWidth, Recorder.sContainerHeight);
        }
    }
}
