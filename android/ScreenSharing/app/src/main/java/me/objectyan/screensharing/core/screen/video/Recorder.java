package me.objectyan.screensharing.core.screen.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;

import me.objectyan.screensharing.core.AppContext;
import me.objectyan.screensharing.core.CarlifeScreenUtil;
import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.config.CarlifeConfig;
import me.objectyan.screensharing.core.connect.CarlifeCmdMessage;
import me.objectyan.screensharing.core.connect.ConnectClient;
import me.objectyan.screensharing.core.connect.ConnectManager;
import me.objectyan.screensharing.core.connect.config.AESManager;
import me.objectyan.screensharing.core.connect.config.EncryptSetupManager;
import me.objectyan.screensharing.core.screen.OnStatusChangeListener;
import me.objectyan.screensharing.core.screen.presentation.view.CarlifeMaskView;
import me.objectyan.screensharing.protobuf.CarlifeConnectExceptionProto.CarlifeConnectException;
import me.objectyan.screensharing.protobuf.CarlifeConnectExceptionProto.CarlifeConnectException.Builder;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;

import static android.media.MediaCodec.CONFIGURE_FLAG_ENCODE;


public class Recorder {

    static final String Tag = "Recorder";

    static int sContainerWidth = 832;

    static int sContainerHeight = 480;

    static int sDestFrameRate = 30;

    public static int sChangeFrameRate = (1000 / sDestFrameRate);

    private static final String NEED_RECTIFY_COLOR = "needRectifyColor";

    private static Recorder sRecorder;

    private static final int[] sColorFormat = new int[]{
            MediaCodecInfo.CodecCapabilities.COLOR_Format16bitRGB565,
            MediaCodecInfo.CodecCapabilities.COLOR_Format16bitBGR565,
            MediaCodecInfo.CodecCapabilities.COLOR_Format32bitBGRA8888,
            MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar,
            MediaCodecInfo.CodecCapabilities.COLOR_Format32bitARGB8888,
            MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar};

    private long mCurrentTimeMillis = 0;

    private MediaCodec mMediaCodec;

    private BaseReceiverAndConverterThread mBaseReceiverAndConverterThread;

    private VideoOutputThread mVideoOutputThread;

    private byte[] mVideoBuffer = new byte[12];

    private boolean mIsNeedCheckIDRCnt = false;

    private boolean f3885G = false;

    private boolean mIsNeedChangeColor = false;

    private boolean mIsFirstEncodeFrame = true;

    private boolean f3888J = true;

    private boolean f3889K = false;

    private boolean f3890L = false;

    private boolean f3891M = false;

    private boolean mIsFirstPausingFrame = true;

    private boolean mIsReleaseMediaCodec = false;

    private boolean mIsJPEGMode = false;

    private boolean f3895Q = false;

    private boolean mIsDelayInitScreenShare = false;

    private final Object mRecorderThreadObj = new Object();

    private final Object mMediaCodecThreadObj = new Object();

    private final Object mVideoBufferObj = new Object();

    private long mPresentationTimeUs = 0;

    private VideoMsgHandler mVideoMsgHandler;

    private SharedPreferences mSharedPreferences = null;

    private Editor mEditor = null;

    private AESManager mAESManager = new AESManager();
    private Handler mRecorderHandler = new RecorderHandler(this);
    private int mDensityDpi;
    private int ac = sContainerWidth;
    private int ad = sContainerHeight;
    private int mContainerWidth = sContainerWidth;
    private int mContainerHeight = sContainerHeight;
    private boolean mIsLollipop;
    private boolean mIsPauseBy50 = false;
    private boolean ai = false;
    private MediaProjectionManager mMediaProjectionManager;
    private MediaProjection mMediaProjection;
    private VirtualDisplay mVirtualDisplay;
    private Surface mInputSurface;

    public Bitmap mBitmap;

    public byte[] f3906g;

    ByteBuffer mByteBuffer;

    private OnStatusChangeListener mOnStatusChangeListener;

    private int mColorCurr = 0;

    private int mColorFormat = 0;

    private int f3911z = 0;


    class RecorderHandler extends Handler {

        final Recorder mRecorder;

        RecorderHandler(Recorder this$0) {
            this.mRecorder = this$0;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.mRecorder.m4814T();
                    return;
                default:
                    return;
            }
        }
    }


    class RecorderRunnable implements Runnable {

        final Recorder mRecorder;

        RecorderRunnable(Recorder this$0) {
            this.mRecorder = this$0;
        }

        public void run() {
            if (this.mRecorder.getIsPauseBy50()) {
                this.mRecorder.sendTypeMsgToService(3);
            }
        }
    }


    class RecorderThread extends Thread {

        final Recorder mRecorder;

        RecorderThread(Recorder this$0) {
            this.mRecorder = this$0;
        }

        public void run() {
            synchronized (this.mRecorder.mRecorderThreadObj) {
                synchronized (this.mRecorder.mMediaCodecThreadObj) {
                    try {
                        this.mRecorder.mMediaCodec.stop();
                        Log.d(Recorder.Tag, "Recorder mEncoder.stop()");
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                    try {
                        this.mRecorder.mMediaCodec.release();
                        Log.d(Recorder.Tag, "Recorder mEncoder.release");
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        this.mRecorder.mMediaCodec = null;
                        this.mRecorder.mIsReleaseMediaCodec = false;
                        if (this.mRecorder.mInputSurface != null) {
                            this.mRecorder.mInputSurface.release();
                            this.mRecorder.mInputSurface = null;
                            Log.d(Recorder.Tag, "Recorder mEncSurface.release");
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }


    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class RecorderCallback extends Callback {

        final Recorder mRecorder;

        private RecorderCallback(Recorder recorder) {
            this.mRecorder = recorder;
        }

        public void onStop() {
            this.mRecorder.mMediaProjection = null;
            this.mRecorder.releaseVirtualDisplay();
        }
    }

    private Recorder() {
        this.mIsLollipop = VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
        this.mVideoMsgHandler = new VideoMsgHandler();
        if (!this.mIsLollipop) {
            this.mSharedPreferences = AppContext.getAppContext().getSharedPreferences(CommonParams.CAR_LIFE_TEMP, Context.MODE_PRIVATE);
            this.mEditor = this.mSharedPreferences.edit();
            switch (this.mSharedPreferences.getInt(NEED_RECTIFY_COLOR, -1)) {
                case 0:
                    this.mIsNeedChangeColor = false;
                    this.f3885G = true;
                    return;
                case 1:
                    this.mIsNeedChangeColor = true;
                    this.f3885G = true;
                    return;
                default:
                    this.mIsNeedChangeColor = false;
                    this.f3885G = false;
                    saveSettingNeedRectifyColor();
                    return;
            }
        }
    }


    public Surface getInputSurface() {
        return this.mInputSurface;
    }


    public static Recorder newInstance() {
        if (sRecorder == null) {
            synchronized (Recorder.class) {
                if (sRecorder == null) {
                    sRecorder = new Recorder();
                }
            }
        }
        return sRecorder;
    }


    public static int getContainerWidth() {
        return sContainerWidth;
    }


    public static int getContainerHeight() {
        return sContainerHeight;
    }


    public boolean m4870e() {
        return this.f3889K;
    }


    public void setIsNeedCheckIDRCnt(boolean isNeedCheckIDRCnt) {
        this.mIsNeedCheckIDRCnt = isNeedCheckIDRCnt;
    }


    void m4871f() {
        this.f3890L = true;
        this.f3889K = true;
    }


    void m4873g() {
        this.f3890L = false;
        if (this.mVideoOutputThread != null) {
            this.mVideoOutputThread.setNeedDropFrame(true);
        }
        m4813S();
    }


    public void m4875h() {
        this.f3891M = true;
        this.f3889K = true;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void m4877i() {
        if (this.mIsDelayInitScreenShare) {
            if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                initMediaProjection();
            }
        }
        this.f3891M = false;
        if (this.mVideoOutputThread != null) {
            this.mVideoOutputThread.setNeedDropFrame(true);
        }
        m4813S();
    }


    public boolean getIsJPEGMode() {
        return this.mIsJPEGMode;
    }


    public void setIsJPEGMode(boolean isJPEGMode) {
        this.mIsJPEGMode = isJPEGMode;
    }


    public void m4866c(boolean isStart) {
        if (sDestFrameRate >= 15 && !this.mIsJPEGMode) {
            if (isStart) {
                this.mRecorderHandler.removeMessages(1);
                try {
                    if (CarlifeConfig.isSupportInternalScreen()) {
                        if (this.mVideoOutputThread != null) {
                            this.mVideoOutputThread.m4924a(sChangeFrameRate / 2);
                        }
                    } else if (this.mBaseReceiverAndConverterThread != null) {
                        this.mBaseReceiverAndConverterThread.changeFrameRate(sDestFrameRate);
                    }
                } catch (NullPointerException e) {
                }
            } else if (this.mRecorderHandler != null) {
                this.mRecorderHandler.sendEmptyMessageDelayed(1, 2000);
            }
        }
    }


    public boolean m4862a(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                m4866c(true);
                break;
            case 1:
            case 3:
                m4866c(false);
                break;
        }
        return false;
    }


    public void setStatusListener(OnStatusChangeListener listener) {
        this.mOnStatusChangeListener = listener;
        this.mVideoMsgHandler.setStatusChangeListener(listener);
    }


    public boolean m4880k() {
        if (!this.mIsJPEGMode && ConnectClient.newInstance().getIS()) {
            return this.f3885G;
        }
        return false;
    }


    public boolean m4881l() {
        return this.mIsNeedChangeColor;
    }


    public void m4868d(boolean isNeedChangeColor) {
        if (this.mIsNeedChangeColor != isNeedChangeColor && this.mEditor != null) {
            this.mIsNeedChangeColor = isNeedChangeColor;
            if (isNeedChangeColor) {
                this.mEditor.putInt(NEED_RECTIFY_COLOR, 1);
                this.mEditor.commit();
            } else {
                this.mEditor.putInt(NEED_RECTIFY_COLOR, 0);
                this.mEditor.commit();
            }
            if (this.mColorFormat != 0) {
                JniMethod.prepare(this.mColorFormat, sContainerWidth, sContainerHeight, isNeedChangeColor);
            }
        }
    }


    public void sendTypeMsgToService(int type) {
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.setServiceType(65591);
        Builder builder = CarlifeConnectException.newBuilder();
        builder.setExceptionType(type);
        CarlifeConnectException info = builder.build();
        command.setData(info.toByteArray());
        command.setLength(info.getSerializedSize());
        ConnectClient.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(), 1001, 0, command));
    }


    public void onActivityPause() {
        if (CarlifeConfig.isSupportInternalScreen()) {
            Log.d(Tag, " onActivityPause internal screen capture ");
        } else {
            Log.d(Tag, " onActivityPause fullscreen capture, Invoke's Recorder pauseFromMobile() ");
            m4866c(false);
            m4875h();
        }
        if (getIsPauseBy50() && this.mRecorderHandler != null) {
            this.mRecorderHandler.postDelayed(new RecorderRunnable(this), 300);
        }
    }


    public boolean m4883n() {
        if (CarlifeConfig.isSupportInternalScreen() || !this.mIsLollipop
                || this.mMediaProjection != null || getIsJPEGMode()) {
            return true;
        }
        return false;
    }


    public boolean getIsPauseBy50() {
        return this.mIsPauseBy50;
    }


    public void setIsPauseBy50(boolean mIsPauseBy50) {
        this.mIsPauseBy50 = mIsPauseBy50;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void m4885p() {
        if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            stopThread();
        }
        releaseVideoEncoder();
    }


    int getColorFormat() {
        return this.mColorFormat;
    }


    boolean getIsFirstEncodeFrame() {
        return this.mIsFirstEncodeFrame;
    }


    void setIsFirstEncodeFrame(boolean isFirstEncodeFrame) {
        this.mIsFirstEncodeFrame = isFirstEncodeFrame;
    }


    boolean getIsFirstPausingFrame() {
        return this.mIsFirstPausingFrame;
    }


    void setIsFirstPausingFrame(boolean isFirstPausingFrame) {
        this.mIsFirstPausingFrame = isFirstPausingFrame;
    }


    int m4889t() {
        return this.f3911z;
    }


    long getCurrentTimeMillis() {
        return this.mCurrentTimeMillis;
    }


    void setInputThreadNull() {
        Log.d(Tag, "setInputThreadNull...");
        this.mBaseReceiverAndConverterThread = null;
    }


    void setVideoOutputThreadNull(Object hehe) {
        this.mVideoOutputThread = null;
    }


    MediaCodec getMediaCodec() {
        return this.mMediaCodec;
    }


    Object getRecorderThreadObj() {
        return this.mRecorderThreadObj;
    }


    Object getMediaCodecThreadObj() {
        return this.mMediaCodecThreadObj;
    }


    long getPresentationTimeUs() {
        this.mPresentationTimeUs += 300000;
        return this.mPresentationTimeUs;
    }


    void startVideoOutputThread() {
        if (this.mVideoOutputThread == null) {
            this.mVideoOutputThread = new VideoOutputThread();
            this.mVideoOutputThread.start();
        }
    }


    void m4835B() {
        if (this.mBaseReceiverAndConverterThread != null) {
            this.mBaseReceiverAndConverterThread.setInputThreadNull();
        }
    }


    void m4836C() {
        if (this.mVideoOutputThread != null) {
            this.mVideoOutputThread.m4923a();
        }
    }


    boolean m4837D() {
        return this.f3888J;
    }


    boolean m4838E() {
        return this.mIsNeedCheckIDRCnt;
    }


    void m4876h(boolean isFirstConnect) {
        this.f3888J = isFirstConnect;
    }


    void m4839F() {
    }


    boolean m4840G() throws InterruptedException {
        if (this.mMediaCodec == null) {
            return false;
        }
        int dataLength;
        switch (this.mColorFormat) {
            case 6:
            case 7:
                dataLength = (sContainerWidth * sContainerHeight) * 2;
                break;
            case 15:
            case 16:
                dataLength = (sContainerWidth * sContainerHeight) * 4;
                break;
            case 19:
            case 21:
                dataLength = ((sContainerWidth * sContainerHeight) * 3) / 2;
                break;
            default:
                return false;
        }
        try {
            ByteBuffer[] byteBuffer = this.mMediaCodec.getInputBuffers();
            if (byteBuffer.length != 0 && byteBuffer[0].capacity() >= dataLength) {
                return true;
            }
            this.f3895Q = true;
            return m4817W();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return m4817W();
        }
    }


    boolean releaseVideoEncoder() {
        if (this.mMediaCodec == null || this.mIsReleaseMediaCodec) {
            return false;
        }
        Log.d(Tag, "Recorder releaseVideoEncoder");
        this.mIsReleaseMediaCodec = true;
        new RecorderThread(this).start();
        return true;
    }


    boolean releaseMediaCodec() {
        if (this.mMediaCodec == null || this.mIsReleaseMediaCodec) {
            return false;
        }
        this.mIsReleaseMediaCodec = true;
        synchronized (this.mRecorderThreadObj) {
            synchronized (this.mMediaCodecThreadObj) {
                try {
                    this.mMediaCodec.stop();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                try {
                    this.mMediaCodec.release();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
                try {
                    this.mMediaCodec = null;
                    this.mIsReleaseMediaCodec = false;
                    if (this.mInputSurface != null) {
                        this.mInputSurface.release();
                        this.mInputSurface = null;
                    }
                    if (CarlifeConfig.isSupportInternalScreen()) {
                        startMediaCodec(sContainerWidth, sContainerHeight);
                    } else {
                        initMediaCodec(sContainerWidth, sContainerHeight, 0);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return true;
    }


    boolean getIsReleaseMediaCodec() {
        return this.mIsReleaseMediaCodec;
    }


    private void m4813S() {
        if (!this.f3891M && !this.f3890L) {
            this.f3889K = false;
        }
    }


    void setThreadFrameRate(int newRate) {
        if (newRate >= 3 && newRate <= 30) {
            sDestFrameRate = newRate;
            sChangeFrameRate = 1000 / newRate;
            if (sDestFrameRate <= 15) {
                try {
                    if (CarlifeConfig.isSupportInternalScreen()) {
                        if (this.mVideoOutputThread != null) {
                            this.mVideoOutputThread.m4924a(sChangeFrameRate / 2);
                        }
                    } else if (this.mBaseReceiverAndConverterThread != null) {
                        this.mBaseReceiverAndConverterThread.changeFrameRate(sDestFrameRate);
                    }
                } catch (NullPointerException e) {
                }
            }
        }
    }


    private void m4814T() {
        if (sDestFrameRate >= 15) {
            try {
                if (!CarlifeConfig.isSupportInternalScreen() && this.mBaseReceiverAndConverterThread != null) {
                    this.mBaseReceiverAndConverterThread.changeFrameRate(15);
                }
            } catch (NullPointerException e) {
            }
        }
    }


    int startThread() {
        m4866c(true);
        m4866c(false);
        if (this.mIsJPEGMode) {
            if (this.mBaseReceiverAndConverterThread == null) {
                if (CarlifeConfig.isSupportInternalScreen()) {
                    this.mBaseReceiverAndConverterThread = new ReceiverAndConverter50Thread();
                } else {
                    this.mBaseReceiverAndConverterThread = new ReceiverAndConverterThread();
                }
                this.mBaseReceiverAndConverterThread.start();
                return 0;
            }
            Log.e(Tag, "The RecordThread didnt close last time");
            return -1;
        } else if (CarlifeConfig.isSupportInternalScreen()) {
            Log.d(Tag, "startThread internal screen capture.");
            m4818X();
            return 0;
        } else if (this.mIsLollipop) {
            m4818X();
            return 0;
        } else {
            Log.d(Tag, "startThread full screen capture.");
            if (this.mBaseReceiverAndConverterThread != null) {
                return -1;
            }
            this.mBaseReceiverAndConverterThread = new ReceiverAndConverterThread();
            this.mBaseReceiverAndConverterThread.start();
            return 0;
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void stopThread() {
        Log.d(Tag, "Recorder  ==============================> begin stopThread()");
        if ((CarlifeConfig.isSupportInternalScreen() || this.mIsLollipop) && !this.mIsJPEGMode) {
            if (!CarlifeConfig.isSupportInternalScreen()) {
                aa();
                if (this.mInputSurface != null) {
                    this.mInputSurface.release();
                }
            } else if (this.mVideoOutputThread != null) {
                this.mVideoOutputThread.m4923a();
            }
        } else if (this.mBaseReceiverAndConverterThread != null) {
            this.mBaseReceiverAndConverterThread.setInputThreadNull();
        }
        if (this.mVideoOutputThread != null) {
            this.mVideoOutputThread.m4923a();
        }
        Log.d(Tag, "Recorder  ==============================> end stopThread()");
    }


    private void saveSettingNeedRectifyColor() {
        if (this.mEditor != null) {
            if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("samsung")) {
                if (Build.DEVICE.contains("t03g") || Build.DEVICE.contains("m0")) {
                    this.f3885G = true;
                    this.mIsNeedChangeColor = false;
                    this.mEditor.putInt(NEED_RECTIFY_COLOR, 0);
                    this.mEditor.commit();
                }
                if (Build.DEVICE.equals("t03gchn") || Build.DEVICE.equals("m0") || Build.DEVICE.equals("t03gcmcc")) {
                    JniMethod.prepare(this.mColorFormat, sContainerWidth, sContainerHeight, true);
                    this.mIsNeedChangeColor = true;
                    this.mEditor.putInt(NEED_RECTIFY_COLOR, 1);
                    this.mEditor.commit();
                }
            } else if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("huawei")) {
                if (Build.DEVICE.contains("hwp6") || Build.DEVICE.contains("hwmt1")) {
                    this.f3885G = true;
                    this.mIsNeedChangeColor = false;
                    this.mEditor.putInt(NEED_RECTIFY_COLOR, 0);
                    this.mEditor.commit();
                }
                if (Build.DEVICE.equals("hwmt1-u06") || Build.DEVICE.equals("hwp6-u06") || Build.DEVICE.equals("hwp6-t00") || Build.DEVICE.equals("hwp6s-u06") || Build.DEVICE.equals("hwp6s-t00")) {
                    JniMethod.prepare(this.mColorFormat, sContainerWidth, sContainerHeight, true);
                    this.mIsNeedChangeColor = true;
                    this.mEditor.putInt(NEED_RECTIFY_COLOR, 1);
                    this.mEditor.commit();
                }
            }
        }
    }


    boolean initJPEGCodec(int destWidth, int destHeight, int destFrameRate) {
        if (destWidth <= 0 || destHeight <= 0) {
            destWidth = 832;
            destHeight = sContainerHeight;
        }
        CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.newInstance();
        int displayWidth = carlifeScreenUtil.getWidthPixels();
        int displayHeight = carlifeScreenUtil.getHeightPixels();
        if (displayWidth > destWidth) {
            this.mContainerWidth = destWidth;
            if (displayHeight > destHeight) {
                this.mContainerHeight = destHeight;
            } else {
                this.mContainerHeight = displayHeight;
            }
        } else {
            this.mContainerWidth = displayWidth;
            this.mContainerHeight = displayHeight;
        }
        sContainerWidth = this.mContainerWidth;
        sContainerHeight = this.mContainerHeight;
        if (destFrameRate >= 15) {
            destFrameRate = 10;
        }
        if (destFrameRate > 2) {
            sDestFrameRate = destFrameRate;
            sChangeFrameRate = 1000 / destFrameRate;
        }
        return true;
    }


    boolean initMediaCodec(int destWidth, int destHeight, int destFrameRate) {
        if (this.mMediaCodec != null) {
            return true;
        }
        if (destWidth <= 0 || destHeight <= 0) {
            destWidth = 832;
            destHeight = sContainerHeight;
        }
        if (destWidth < 800) {
            int wRemain = destWidth % 64;
            if (wRemain >= 32) {
                destWidth = (destWidth + 64) - wRemain;
            } else {
                destWidth -= wRemain;
            }
            sContainerWidth = destWidth;
        }
        CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.newInstance();
        int displayWidth = carlifeScreenUtil.getWidthPixels();
        int displayHeight = carlifeScreenUtil.getHeightPixels();
        if (displayWidth > sContainerWidth) {
            this.mContainerWidth = sContainerWidth;
            this.mContainerHeight = (this.mContainerWidth * displayHeight) / displayWidth;
            this.mContainerHeight -= this.mContainerHeight % 32;
        } else {
            this.mContainerWidth = displayWidth;
            this.mContainerHeight = displayHeight;
            this.mContainerWidth -= this.mContainerWidth % 64;
            this.mContainerHeight -= this.mContainerHeight % 32;
            if (this.mContainerHeight > displayHeight) {
                this.mContainerHeight -= 32;
            }
        }
        sContainerWidth = this.mContainerWidth;
        sContainerHeight = this.mContainerHeight;
        if (destFrameRate > 2) {
            sDestFrameRate = destFrameRate;
            sChangeFrameRate = 1000 / destFrameRate;
        }
        Log.e(Tag, "mContainerWidth = " + sContainerWidth + ", mContainerHeight = " + sContainerHeight);
        try {
            this.mMediaCodec = MediaCodec.createEncoderByType("video/avc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        MediaFormat mediaFormat = MediaFormat.createVideoFormat("video/avc", sContainerWidth, sContainerHeight);
        mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 4000000);
        mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE, 15);
        mediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);
        if (this.f3895Q) {
            this.mColorCurr++;
        }
        this.f3895Q = false;
        while (this.mColorCurr < sColorFormat.length) {
            this.mColorFormat = sColorFormat[this.mColorCurr];
            boolean isConfigSuccess = true;
            try {
                mediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, this.mColorFormat);
                mediaFormat.setInteger(MediaFormat.KEY_PROFILE, 1);
                mediaFormat.setInteger(MediaFormat.KEY_LEVEL, MediaCodecInfo.CodecProfileLevel.AVCLevel3);
                this.mMediaCodec.configure(mediaFormat, null, null, CONFIGURE_FLAG_ENCODE);
            } catch (Exception e2) {
                isConfigSuccess = false;
                e2.printStackTrace();
            }
            if (isConfigSuccess) {
                Log.e(Tag, "with level 3.0 mColorFormat=" + this.mColorFormat);
                break;
            }
            try {
                mediaFormat = MediaFormat.createVideoFormat("video/avc", sContainerWidth, sContainerHeight);
                mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 4000000);
                mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE, 15);
                mediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);
                mediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, this.mColorFormat);
                this.mMediaCodec.configure(mediaFormat, null, null, CONFIGURE_FLAG_ENCODE);
                Log.e(Tag, "mColorFormat=" + this.mColorFormat);
                break;
            } catch (Exception e22) {
                e22.printStackTrace();
                this.mColorCurr++;
            }
        }
        boolean needErgodic = this.mColorCurr >= sColorFormat.length;
        if (needErgodic) {
            this.mColorCurr = 0;
            this.mColorFormat = 0;
        }
        while (needErgodic) {
            switch (this.mColorCurr) {
                case 43:
                    this.mColorFormat = 2130706688;
                    break;
                case 44:
                    this.mColorFormat = 2141391872;
                    break;
                case 45:
                    this.mColorFormat = 2130708361;
                    break;
                default:
                    this.mColorFormat++;
                    break;
            }
            try {
                mediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, this.mColorFormat);
                this.mMediaCodec.configure(mediaFormat, null, null, CONFIGURE_FLAG_ENCODE);
            } catch (Exception e222) {
                e222.printStackTrace();
                if (this.mColorCurr < 46) {
                    this.mColorCurr++;
                }
            }
            if (this.mColorCurr != 45 || this.mColorCurr == 46) {
                Log.e(Tag, "没有合适的参数可完成初始化 n = " + this.mColorCurr);
                this.mMediaCodec = null;
                return false;
            }
            try {
                this.mMediaCodec.start();
                JniMethod.prepare(this.mColorFormat, sContainerWidth, sContainerHeight, false);
                if (this.f3885G) {
                    JniMethod.prepare(this.mColorFormat, sContainerWidth, sContainerHeight, this.mIsNeedChangeColor);
                }
                Log.d(Tag, "initMediaCodec mColorFormat=" + this.mColorFormat);
                if (CarlifeConfig.isSupportInternalScreen()) {
                }
                return true;
            } catch (IllegalStateException e3) {
                try {
                    this.mMediaCodec.release();
                } catch (IllegalStateException e1) {
                    e1.printStackTrace();
                }
                this.mMediaCodec = null;
                return false;
            }
        }
        if (this.mColorCurr != 45) {
        }
        Log.e(Tag, "没有合适的参数可完成初始化 n = " + this.mColorCurr);
        this.mMediaCodec = null;
        return false;
    }


    int sendEmptyPacket(byte[] input) {
        synchronized (this.mRecorderThreadObj) {
            if (this.mMediaCodec == null) {
                Log.e(Tag, "还没完成初始化, 或已经被释放");
                return -2;
            }
            try {
                ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
                int inputBufferIndex = this.mMediaCodec.dequeueInputBuffer(50000);
                if (inputBufferIndex >= 0) {
                    ByteBuffer inputBuffer = inputBuffers[inputBufferIndex];
                    inputBuffer.clear();
                    inputBuffer.put(input);
                    this.mPresentationTimeUs += 300000;
                    this.mMediaCodec.queueInputBuffer(inputBufferIndex, 0,
                            input.length, this.mPresentationTimeUs, 0);
                    return 0;
                }
                Log.w(Tag, "input2Encoder -1;sendEmptyPacket");
                writeVideo1();
            } catch (Throwable t) {
                t.printStackTrace();
            }
            return -1;
        }
    }


    int writeVideo1() {
        int status;
        synchronized (this.mVideoBufferObj) {
            this.mVideoBuffer[0] = (byte) 0;
            this.mVideoBuffer[1] = (byte) 0;
            this.mVideoBuffer[2] = (byte) 0;
            this.mVideoBuffer[3] = (byte) 0;
            long timeStamp = System.currentTimeMillis();
            this.mVideoBuffer[4] = (byte) ((int) ((2130706432 & timeStamp) >> 24));
            this.mVideoBuffer[5] = (byte) ((int) ((16711680 & timeStamp) >> 16));
            this.mVideoBuffer[6] = (byte) ((int) ((65280 & timeStamp) >> 8));
            this.mVideoBuffer[7] = (byte) ((int) (255 & timeStamp));
            this.mVideoBuffer[8] = (byte) 0;
            this.mVideoBuffer[9] = (byte) 2;
            this.mVideoBuffer[10] = (byte) 0;
            this.mVideoBuffer[11] = (byte) 1;
            status = ConnectManager.newInstance().writeVideo(this.mVideoBuffer, 12);
        }
        return status;
    }


    int writeVideo2() {
        int status;
        synchronized (this.mVideoBufferObj) {
            this.mVideoBuffer[0] = (byte) 0;
            this.mVideoBuffer[1] = (byte) 0;
            this.mVideoBuffer[2] = (byte) 0;
            this.mVideoBuffer[3] = (byte) 0;
            long timeStamp = System.currentTimeMillis();
            this.mVideoBuffer[4] = (byte) ((int) ((2130706432 & timeStamp) >> 24));
            this.mVideoBuffer[5] = (byte) ((int) ((16711680 & timeStamp) >> 16));
            this.mVideoBuffer[6] = (byte) ((int) ((65280 & timeStamp) >> 8));
            this.mVideoBuffer[7] = (byte) ((int) (255 & timeStamp));
            this.mVideoBuffer[8] = (byte) 0;
            this.mVideoBuffer[9] = (byte) 2;
            this.mVideoBuffer[10] = (byte) 0;
            this.mVideoBuffer[11] = (byte) 2;
            status = ConnectManager.newInstance().writeVideo(this.mVideoBuffer, 12);
        }
        return status;
    }


    int encryptVideoData(byte[] videoData, int length) {
        int status;
        byte[] sendDtata = videoData;
        int sendLen = length;
        if (EncryptSetupManager.newInstance().getFlag() && length > 0) {
            sendDtata = this.mAESManager.encrypt(videoData, length);
            if (sendDtata == null) {
                Log.e(Tag, "encrypt failed!");
                return -1;
            }
            sendLen = sendDtata.length;
        }
        long timeFlag = System.currentTimeMillis();
        if (timeFlag - this.mCurrentTimeMillis > 980) {
            this.mCurrentTimeMillis = timeFlag;
            this.f3911z = 1;
        } else {
            this.f3911z++;
        }
        synchronized (this.mVideoBufferObj) {
            this.mVideoBuffer[0] = (byte) ((-16777216 & sendLen) >> 24);
            this.mVideoBuffer[1] = (byte) ((16711680 & sendLen) >> 16);
            this.mVideoBuffer[2] = (byte) ((65280 & sendLen) >> 8);
            this.mVideoBuffer[3] = (byte) (sendLen & 255);
            long timeStamp = System.currentTimeMillis();
            this.mVideoBuffer[4] = (byte) ((int) ((-16777216 & timeStamp) >> 24));
            this.mVideoBuffer[5] = (byte) ((int) ((16711680 & timeStamp) >> 16));
            this.mVideoBuffer[6] = (byte) ((int) ((65280 & timeStamp) >> 8));
            this.mVideoBuffer[7] = (byte) ((int) (255 & timeStamp));
            this.mVideoBuffer[8] = (byte) 0;
            this.mVideoBuffer[9] = (byte) 2;
            this.mVideoBuffer[10] = (byte) 0;
            this.mVideoBuffer[11] = (byte) 1;
            ConnectManager.newInstance().writeVideo(this.mVideoBuffer, 12);
            status = ConnectManager.newInstance().writeVideo(sendDtata, sendLen);
        }
        return status;
    }


    private boolean m4817W() throws InterruptedException {
        releaseVideoEncoder();
        int i = 3;
        while (i > 0) {
            Thread.sleep(300);
            i--;
            if (this.f3891M) {
                writeVideo2();
            } else {
                writeVideo1();
            }
        }
        if (this.mIsReleaseMediaCodec) {
            this.mMediaCodec = null;
            return false;
        } else if (CarlifeConfig.isSupportInternalScreen()) {
            return false;
        } else {
            initMediaCodec(sContainerWidth, sContainerHeight, 0);
            if (this.mMediaCodec != null) {
                return m4840G();
            }
            return false;
        }
    }


    boolean startMediaCodec(int destWidth, int destHeight) {
        if (this.mMediaProjectionManager != null) {
            return true;
        }
        m4836C();
        synchronized (this.mRecorderThreadObj) {
            synchronized (this.mMediaCodecThreadObj) {
                if (!(this.mMediaCodec == null || this.mInputSurface == null)) {
                    try {
                        this.mMediaCodec.stop();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                    try {
                        this.mMediaCodec.release();
                        this.mMediaCodec = null;
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    }
                    if (this.mInputSurface != null) {
                        this.mInputSurface.release();
                        this.mInputSurface = null;
                    }
                }
                try {
                    this.mMediaCodec = MediaCodec.createEncoderByType("video/avc");
                    CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.newInstance();
                    if (destWidth >= 800 || carlifeScreenUtil.getWidthPixels() < 768) {
                        if (destWidth >= 800) {
                            if (carlifeScreenUtil.getWidthPixels() >= 832) {
                                this.mContainerWidth = 832;
                                this.mContainerHeight = 480;
                            }
                        }
                        this.mContainerWidth = carlifeScreenUtil.getWidthPixels();
                        this.mContainerHeight = carlifeScreenUtil.getHeightPixels();
                        if (this.mContainerWidth % 64 != 0) {
                            this.mContainerWidth -= this.mContainerWidth % 64;
                        }
                        if (this.mContainerHeight % 32 != 0) {
                            this.mContainerHeight -= this.mContainerHeight % 32;
                        }
                    } else {
                        this.mContainerWidth = 768;
                        this.mContainerHeight = 448;
                    }
                    if (CarlifeScreenUtil.isVehicleSupportScreenAdapt()) {
                        this.mContainerWidth = 1024;
                        this.mContainerHeight = 384;
                        Log.d(Tag, "####### Adapte Video size");
                    }
                    Log.d(Tag, "####### set vidoe size[" + this.mContainerWidth + " : " + this.mContainerHeight + "]");
                    if (!(sContainerWidth == this.mContainerWidth && sContainerHeight == this.mContainerHeight)) {
                        Log.d(Tag, "####### set setFirstEncodeFrame size[" + this.mContainerWidth + " : " + this.mContainerHeight + "]");
                        setIsFirstEncodeFrame(true);
                        VideoOutputThread.m4916c();
                    }
                    sContainerWidth = this.mContainerWidth;
                    sContainerHeight = this.mContainerHeight;
                    if (carlifeScreenUtil.getWindowWidthPixels() == carlifeScreenUtil.getWidthPixels()) {
                        this.ac = this.mContainerWidth;
                        this.ad = this.mContainerHeight;
                    } else if (carlifeScreenUtil.getWindowWidthPixels() > 0) {
                        this.ac = (this.mContainerWidth * carlifeScreenUtil.getWindowWidthPixels()) / carlifeScreenUtil.getWidthPixels();
                        this.ac++;
                        this.ad = (this.ac * carlifeScreenUtil.getWindowHeightPixels()) / carlifeScreenUtil.getWindowWidthPixels();
                        if (this.ad > this.mContainerHeight) {
                            this.ad = this.mContainerHeight;
                        }
                    } else {
                        this.ac = this.mContainerWidth;
                        this.ad = this.mContainerHeight;
                    }
                    boolean isConfigSuccess = true;
                    MediaFormat mediaFormat = MediaFormat.createVideoFormat("video/avc", this.mContainerWidth, this.mContainerHeight);
                    mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 4000000);
                    mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE, 10);
                    mediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);
                    mediaFormat.setInteger(MediaFormat.KEY_CAPTURE_RATE, 10);
                    mediaFormat.setLong(MediaFormat.KEY_REPEAT_PREVIOUS_FRAME_AFTER, 100000);
                    mediaFormat.setLong(MediaFormat.KEY_DURATION, 100000);
                    this.mColorFormat = 2130708361;
                    try {
                        mediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, this.mColorFormat);
                        mediaFormat.setInteger(MediaFormat.KEY_PROFILE, 1);
                        mediaFormat.setInteger(MediaFormat.KEY_LEVEL, 256);
                        this.mMediaCodec.configure(mediaFormat, null, null, CONFIGURE_FLAG_ENCODE);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        isConfigSuccess = false;
                    }
                    if (!isConfigSuccess) {
                        mediaFormat = MediaFormat.createVideoFormat("video/avc", this.mContainerWidth, this.mContainerHeight);
                        mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 4000000);
                        mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE, 10);
                        mediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);
                        mediaFormat.setInteger(MediaFormat.KEY_CAPTURE_RATE, 10);
                        mediaFormat.setLong(MediaFormat.KEY_REPEAT_PREVIOUS_FRAME_AFTER, 100000);
                        mediaFormat.setLong(MediaFormat.KEY_DURATION, 100000);
                        this.mColorFormat = 2130708361;
                        try {
                            mediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, this.mColorFormat);
                            this.mMediaCodec.configure(mediaFormat, null, null, CONFIGURE_FLAG_ENCODE);
                        } catch (Exception e32) {
                            e32.printStackTrace();
                            return false;
                        }
                    }
                    if (this.mInputSurface != null) {
                        this.mInputSurface.release();
                    }
                    this.mInputSurface = this.mMediaCodec.createInputSurface();
                    CarlifeMaskView.setDisplaySpec(this.mInputSurface);
                    this.mMediaCodec.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return false;
                } catch (IllegalArgumentException e22) {
                    e22.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }


    private void m4818X() {
        if (this.mVideoOutputThread == null) {
            this.mVideoOutputThread = new VideoOutputThread();
            this.mVideoOutputThread.start();
        }
    }


    boolean initMediaCodec50TextureView(int destWidth, int destHeight, int destFrameRate) {
        if (this.mBitmap != null) {
            Log.e(Tag, "重复调用了initMediaCodec50TextureView");
        } else {
            initJPEGCodec(destWidth, destHeight, destFrameRate);
            this.mBitmap = Bitmap.createBitmap(sContainerWidth, sContainerHeight, Config.ARGB_8888);
        }
        return true;
    }


    boolean getIsLollipop() {
        return this.mIsLollipop;
    }


    void setIsDelayInitScreenShare(boolean delayInitScreenShare) {
        this.mIsDelayInitScreenShare = delayInitScreenShare;
    }


    public boolean getIsDelayInitScreenShare() {
        return this.mIsDelayInitScreenShare;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void initMediaProjection() {
        this.mIsDelayInitScreenShare = false;
        if (this.mMediaProjectionManager == null) {
            Context context = AppContext.getAppContext();
            this.mDensityDpi = CarlifeScreenUtil.newInstance().getDensityDpi();
            this.mMediaProjectionManager = (MediaProjectionManager) context.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        }
        if (this.mMediaProjection == null) {
            this.mOnStatusChangeListener.startActivity(this.mMediaProjectionManager.createScreenCaptureIntent(), 4353);
            this.mIsPauseBy50 = true;
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void m4856a(int requestCode, int resultCode, Intent data) {
        if (requestCode == 4353) {
            setIsPauseBy50(false);
            if (resultCode != -1) {
                sendTypeMsgToService(2);
            } else if (this.mMediaProjectionManager != null) {
                if (this.mMediaProjection == null) {
                    if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        this.mMediaProjection = this.mMediaProjectionManager.getMediaProjection(resultCode, data);
                    }
                    this.mMediaProjection.registerCallback(new RecorderCallback(this), null);
                    this.mVirtualDisplay = m4820Z();
                }
                this.ai = true;
            }
        }
    }


    boolean m4850Q() {
        return this.ai;
    }


    private void releaseVirtualDisplay() {
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.release();
            this.mVirtualDisplay = null;
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void m4851R() {
        if (this.mMediaProjection != null && this.mVirtualDisplay == null) {
            if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                this.mVirtualDisplay = m4820Z();
            }
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private VirtualDisplay m4820Z() {
        if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return this.mMediaProjection.createVirtualDisplay("ScreenSharingDemo",
                    this.ac, this.ad, this.mDensityDpi, 25, this.mInputSurface, null, null);
        }
        return null;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void aa() {
        if (this.mMediaProjection != null) {
            if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                this.mMediaProjection.stop();
            }
            this.mMediaProjection = null;
        }
    }
}
