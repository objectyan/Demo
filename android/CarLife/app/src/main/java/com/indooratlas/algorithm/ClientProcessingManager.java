package com.indooratlas.algorithm;

import com.indooratlas.android.sdk._internal.C6008t;
import java.io.Closeable;
import java.nio.ByteBuffer;

public class ClientProcessingManager implements Closeable {
    public static final int AVAILABLE_BOTH = 3;
    public static final int AVAILABLE_CALIBRATED = 1;
    public static final int AVAILABLE_NONE = 0;
    public static final int AVAILABLE_UNCALIBRATED = 2;
    public static final int LOG_MESSAGE_TYPE_DEBUG = 2;
    public static final int LOG_MESSAGE_TYPE_ERROR = 0;
    public static final int LOG_MESSAGE_TYPE_WARNING = 1;
    public static final int MOVING = 1;
    public static final int NOTMOVING = 0;
    public static final int TYPE_ACCELEROMETER = 2;
    public static final int TYPE_BAROMETER = 5;
    public static final int TYPE_GYROSCOPE = 1;
    public static final int TYPE_MAGNETOMETER_CALIBRATED = 3;
    public static final int TYPE_MAGNETOMETER_CLOUD_BIAS = 4;
    public static final int TYPE_MAGNETOMETER_UNCALIBRATED = 0;
    private Long nativePtr = null;
    private C6008t tracker;

    public static native String getVersion();

    private native void jnim_addPosition(long j, long j2, double d, double d2, double d3, double d4, double d5, double[] dArr, double d6, double d7, boolean z);

    private native void jnim_addSampleIMU(long j, int i, long j2, double d, double d2, double d3);

    private native void jnim_configurePredictor(long j, boolean z, double d, boolean z2, double d2);

    private native void jnim_configurePredictorHeading(long j, double d);

    private native void jnim_configurePredictorOrientation(long j, double d);

    private native void jnim_defineAvailableSensors(long j, int i, int i2, int i3, int i4);

    private native void jnim_disposeClientProcessingManager(long j);

    private native long jnim_initializeClientProcessingManager();

    private native void jnim_setDeviceBias(long j, double d, double d2, double d3, int i);

    private native void jnim_setParameters(long j, ByteBuffer byteBuffer);

    private native void jnim_setTime(long j, long j2, long j3);

    private native void jnim_startPositioning(long j);

    private native void jnim_stopPositioning(long j);

    private static native void setLogMask(int i);

    static {
        try {
            System.loadLibrary("cpaJNI");
        } catch (Error e) {
            System.err.println("Unable to find required IndoorAtlas SDK native libraries. Please check integration instructions.");
        }
    }

    public ClientProcessingManager(C6008t c6008t) {
        this.tracker = c6008t;
        close();
        this.nativePtr = Long.valueOf(jnim_initializeClientProcessingManager());
    }

    protected void finalize() {
        close();
    }

    public void close() {
        if (this.nativePtr != null) {
            jnim_disposeClientProcessingManager(this.nativePtr.longValue());
            this.nativePtr = null;
        }
    }

    public void defineAvailableSensors(int i, int i2, int i3, int i4) {
        jnim_defineAvailableSensors(this.nativePtr.longValue(), ensureValid(i), ensureValid(i2), ensureValid(i3), ensureValid(i4));
    }

    public void addSampleIMU(int i, long j, double d, double d2, double d3) {
        jnim_addSampleIMU(this.nativePtr.longValue(), i, j, d, d2, d3);
    }

    public void startPositioning() {
        jnim_startPositioning(this.nativePtr.longValue());
    }

    public void stopPositioning() {
        jnim_stopPositioning(this.nativePtr.longValue());
    }

    public void setParameters(ByteBuffer byteBuffer) {
        jnim_setParameters(this.nativePtr.longValue(), byteBuffer);
    }

    public void setDeviceBias(double d, double d2, double d3, int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Accuracy " + i + " not in range [0, 3].");
        }
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        jnim_setDeviceBias(this.nativePtr.longValue(), d4, d5, d6, new int[]{0, 1, 3, 2}[i]);
    }

    public void addPosition(long j, double d, double d2, double d3, double d4, double d5, double[] dArr, double d6, double d7, boolean z) {
        jnim_addPosition(this.nativePtr.longValue(), j, d, d2, d3, d4, d5, dArr, d6, d7, z);
    }

    public void configurePredictor(boolean z, double d, boolean z2, double d2) {
        jnim_configurePredictor(this.nativePtr.longValue(), z, d, z2, d2);
    }

    public void configurePredictorHeading(double d) {
        jnim_configurePredictorHeading(this.nativePtr.longValue(), d);
    }

    public void configurePredictorOrientation(double d) {
        jnim_configurePredictorOrientation(this.nativePtr.longValue(), d);
    }

    public void setTime(long j, long j2) {
        jnim_setTime(this.nativePtr.longValue(), j, j2);
    }

    public void onTrackNode(byte[] bArr) {
        this.tracker.a(bArr);
    }

    public void onBackgroundCalibrationRunning(boolean z) {
        this.tracker.a(z);
    }

    public void onBackgroundCalibrationQuality(double d, int i) {
        this.tracker.a(d, i);
    }

    public void onBackgroundCalibrationPacket(byte[] bArr) {
        this.tracker.b(bArr);
    }

    public void onMovementStateChange(int i) {
        this.tracker.a(i);
    }

    public void onLogPacket(byte[] bArr, long j, long j2, String str) {
        this.tracker.a(bArr, j, j2, str);
    }

    public void onPositionOutputPacket(long j, double d, double d2, double d3, double d4) {
        this.tracker.a(j, d, d2, d3, d4);
    }

    public void onLogMessage(int i, String str) {
        this.tracker.a(i, str);
    }

    public void onOrientationChange(long j, double[] dArr) {
        this.tracker.a(j, dArr);
    }

    public void onHeadingChange(long j, double d) {
        this.tracker.a(j, d);
    }

    private static int ensureValid(int i) {
        if (i >= 0 && i <= 3) {
            return i;
        }
        throw new IllegalArgumentException("Value " + i + " does not define sensor availability");
    }

    public static void setLog(int i) {
        int i2 = 0;
        if (i >= 2) {
            i2 = 1;
        } else if (i > 0) {
            i2 = 3;
        } else if (i >= 0) {
            i2 = 7;
        }
        setLogMask(i2);
    }
}
