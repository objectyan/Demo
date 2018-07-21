package com.indooratlas.algorithm;

import com.indooratlas.android.sdk._internal.t;
import java.io.Closeable;
import java.io.PrintStream;
import java.nio.ByteBuffer;

public class ClientProcessingManager
  implements Closeable
{
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
  private Long nativePtr;
  private t tracker;
  
  static
  {
    try
    {
      System.loadLibrary("cpaJNI");
      return;
    }
    catch (Error localError)
    {
      System.err.println("Unable to find required IndoorAtlas SDK native libraries. Please check integration instructions.");
    }
  }
  
  public ClientProcessingManager(t paramt)
  {
    this.tracker = paramt;
    this.nativePtr = null;
    close();
    this.nativePtr = Long.valueOf(jnim_initializeClientProcessingManager());
  }
  
  private static int ensureValid(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("Value " + paramInt + " does not define sensor availability");
    }
    return paramInt;
  }
  
  public static native String getVersion();
  
  private native void jnim_addPosition(long paramLong1, long paramLong2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double[] paramArrayOfDouble, double paramDouble6, double paramDouble7, boolean paramBoolean);
  
  private native void jnim_addSampleIMU(long paramLong1, int paramInt, long paramLong2, double paramDouble1, double paramDouble2, double paramDouble3);
  
  private native void jnim_configurePredictor(long paramLong, boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2);
  
  private native void jnim_configurePredictorHeading(long paramLong, double paramDouble);
  
  private native void jnim_configurePredictorOrientation(long paramLong, double paramDouble);
  
  private native void jnim_defineAvailableSensors(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void jnim_disposeClientProcessingManager(long paramLong);
  
  private native long jnim_initializeClientProcessingManager();
  
  private native void jnim_setDeviceBias(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt);
  
  private native void jnim_setParameters(long paramLong, ByteBuffer paramByteBuffer);
  
  private native void jnim_setTime(long paramLong1, long paramLong2, long paramLong3);
  
  private native void jnim_startPositioning(long paramLong);
  
  private native void jnim_stopPositioning(long paramLong);
  
  public static void setLog(int paramInt)
  {
    int i = 0;
    if (paramInt >= 2) {
      i = 1;
    }
    for (;;)
    {
      setLogMask(i);
      return;
      if (paramInt > 0) {
        i = 3;
      } else if (paramInt >= 0) {
        i = 7;
      }
    }
  }
  
  private static native void setLogMask(int paramInt);
  
  public void addPosition(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double[] paramArrayOfDouble, double paramDouble6, double paramDouble7, boolean paramBoolean)
  {
    jnim_addPosition(this.nativePtr.longValue(), paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramArrayOfDouble, paramDouble6, paramDouble7, paramBoolean);
  }
  
  public void addSampleIMU(int paramInt, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    jnim_addSampleIMU(this.nativePtr.longValue(), paramInt, paramLong, paramDouble1, paramDouble2, paramDouble3);
  }
  
  public void close()
  {
    if (this.nativePtr != null)
    {
      jnim_disposeClientProcessingManager(this.nativePtr.longValue());
      this.nativePtr = null;
    }
  }
  
  public void configurePredictor(boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2)
  {
    jnim_configurePredictor(this.nativePtr.longValue(), paramBoolean1, paramDouble1, paramBoolean2, paramDouble2);
  }
  
  public void configurePredictorHeading(double paramDouble)
  {
    jnim_configurePredictorHeading(this.nativePtr.longValue(), paramDouble);
  }
  
  public void configurePredictorOrientation(double paramDouble)
  {
    jnim_configurePredictorOrientation(this.nativePtr.longValue(), paramDouble);
  }
  
  public void defineAvailableSensors(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    jnim_defineAvailableSensors(this.nativePtr.longValue(), ensureValid(paramInt1), ensureValid(paramInt2), ensureValid(paramInt3), ensureValid(paramInt4));
  }
  
  protected void finalize()
  {
    close();
  }
  
  public void onBackgroundCalibrationPacket(byte[] paramArrayOfByte)
  {
    this.tracker.b(paramArrayOfByte);
  }
  
  public void onBackgroundCalibrationQuality(double paramDouble, int paramInt)
  {
    this.tracker.a(paramDouble, paramInt);
  }
  
  public void onBackgroundCalibrationRunning(boolean paramBoolean)
  {
    this.tracker.a(paramBoolean);
  }
  
  public void onHeadingChange(long paramLong, double paramDouble)
  {
    this.tracker.a(paramLong, paramDouble);
  }
  
  public void onLogMessage(int paramInt, String paramString)
  {
    this.tracker.a(paramInt, paramString);
  }
  
  public void onLogPacket(byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString)
  {
    this.tracker.a(paramArrayOfByte, paramLong1, paramLong2, paramString);
  }
  
  public void onMovementStateChange(int paramInt)
  {
    this.tracker.a(paramInt);
  }
  
  public void onOrientationChange(long paramLong, double[] paramArrayOfDouble)
  {
    this.tracker.a(paramLong, paramArrayOfDouble);
  }
  
  public void onPositionOutputPacket(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.tracker.a(paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  public void onTrackNode(byte[] paramArrayOfByte)
  {
    this.tracker.a(paramArrayOfByte);
  }
  
  public void setDeviceBias(double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 3))
    {
      jnim_setDeviceBias(this.nativePtr.longValue(), paramDouble1, paramDouble2, paramDouble3, new int[] { 0, 1, 3, 2 }[paramInt]);
      return;
    }
    throw new IllegalArgumentException("Accuracy " + paramInt + " not in range [0, 3].");
  }
  
  public void setParameters(ByteBuffer paramByteBuffer)
  {
    jnim_setParameters(this.nativePtr.longValue(), paramByteBuffer);
  }
  
  public void setTime(long paramLong1, long paramLong2)
  {
    jnim_setTime(this.nativePtr.longValue(), paramLong1, paramLong2);
  }
  
  public void startPositioning()
  {
    jnim_startPositioning(this.nativePtr.longValue());
  }
  
  public void stopPositioning()
  {
    jnim_stopPositioning(this.nativePtr.longValue());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/algorithm/ClientProcessingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */