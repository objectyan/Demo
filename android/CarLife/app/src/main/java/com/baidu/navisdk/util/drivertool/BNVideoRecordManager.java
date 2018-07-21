package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog;
import com.baidu.navisdk.util.drivertool.view.BNVideoBoardDialog;
import java.io.File;

public class BNVideoRecordManager
{
  public static String NO_RECORD_AUTH_MSG = "请打开麦克风或者照相机权限";
  private static BNVideoRecordManager mInstance;
  private int count = 10;
  private boolean isRecording = false;
  private SurfaceHolder.Callback mCallback = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      BNVideoRecordManager.access$002(BNVideoRecordManager.this, 9);
      BNVideoRecordManager.this.mHandler.sendEmptyMessageDelayed(0, 1000L);
      if (BNSettingManager.isRecordingHighDefinition()) {}
      for (int i = 0;; i = 1)
      {
        BNVideoRecordManager.this.recordVideoInner(BNVideoRecordManager.access$300(BNVideoRecordManager.this), i);
        return;
      }
    }
    
    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder) {}
  };
  private Camera mCamera = null;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      if (i == 0) {
        if (BNVideoRecordManager.this.count >= 0)
        {
          if (BNVideoRecordManager.this.mVideoDialog != null) {
            BNVideoRecordManager.this.mVideoDialog.updateTimeText(BNVideoRecordManager.this.count);
          }
          BNVideoRecordManager.access$006(BNVideoRecordManager.this);
          BNVideoRecordManager.this.mHandler.sendEmptyMessageDelayed(0, 1000L);
        }
      }
      while (i != 1)
      {
        return;
        BNVideoRecordManager.this.mHandler.sendEmptyMessage(1);
        return;
      }
      BNVideoRecordManager.this.stopRecordVideo();
    }
  };
  private SurfaceHolder mHolder;
  private MediaRecorder mMediaRecorder = null;
  private SurfaceView mSurfaceView = null;
  private BNVideoBoardDialog mVideoDialog;
  
  private BNVideoRecordManager()
  {
    Activity localActivity = BNaviModuleManager.getNaviActivity();
    if (localActivity != null)
    {
      this.mVideoDialog = new BNVideoBoardDialog(localActivity);
      this.mSurfaceView = this.mVideoDialog.getVideoPanel();
      this.mVideoDialog.setCanceledOnTouchOutside(false);
    }
  }
  
  public static BNVideoRecordManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNVideoRecordManager();
    }
    return mInstance;
  }
  
  private String getPathStr()
  {
    return BNDrivingToolUtils.getAbsoluteFilePath(1);
  }
  
  private void recordVideoInner(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    for (;;)
    {
      try
      {
        this.mMediaRecorder = new MediaRecorder();
        this.mMediaRecorder.reset();
        this.mCamera = Camera.open();
        this.mCamera.setDisplayOrientation(90);
        this.mCamera.unlock();
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setAudioSource(1);
        this.mMediaRecorder.setVideoSource(1);
        i = 6;
        if (paramInt == 0)
        {
          i = 4;
          this.mMediaRecorder.setProfile(CamcorderProfile.get(i));
          this.mMediaRecorder.setOutputFile(paramString.getAbsolutePath());
          this.mMediaRecorder.setPreviewDisplay(this.mSurfaceView.getHolder().getSurface());
          this.mMediaRecorder.setOrientationHint(90);
          this.mMediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener()
          {
            public void onError(MediaRecorder paramAnonymousMediaRecorder, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              BNVideoRecordManager.this.mMediaRecorder.stop();
              BNVideoRecordManager.this.mMediaRecorder.release();
              BNVideoRecordManager.access$502(BNVideoRecordManager.this, null);
              BNVideoRecordManager.access$602(BNVideoRecordManager.this, false);
              if (BNVideoRecordManager.this.mCamera != null)
              {
                BNVideoRecordManager.this.mCamera.release();
                BNVideoRecordManager.access$702(BNVideoRecordManager.this, null);
              }
              if (BNVideoRecordManager.this.mHolder != null) {
                BNVideoRecordManager.this.mHolder.removeCallback(BNVideoRecordManager.this.mCallback);
              }
            }
          });
          this.mMediaRecorder.prepare();
          this.mMediaRecorder.start();
          this.isRecording = true;
          return;
        }
      }
      catch (Exception paramString)
      {
        int i;
        if (this.mMediaRecorder == null) {
          continue;
        }
        this.mMediaRecorder.stop();
        this.mMediaRecorder.release();
        this.mMediaRecorder = null;
        if (this.mCamera == null) {
          continue;
        }
        this.mCamera.release();
        this.mCamera = null;
        if (this.mHolder == null) {
          continue;
        }
        this.mHolder.removeCallback(this.mCallback);
      }
      if (paramInt == 1) {
        i = 0;
      }
    }
  }
  
  public boolean hasRecordAuth()
  {
    return (SystemAuth.checkAuth("android.permission.RECORD_AUDIO")) && (SystemAuth.checkAuth("android.permission.CAMERA"));
  }
  
  public boolean recordVideo()
  {
    if (this.mVideoDialog != null) {
      this.mVideoDialog.show();
    }
    this.mHolder = this.mSurfaceView.getHolder();
    this.mHolder.addCallback(this.mCallback);
    return true;
  }
  
  public void stopRecordVideo()
  {
    this.mHandler.removeMessages(0);
    this.mHandler.removeMessages(1);
    if (this.isRecording)
    {
      if (this.mMediaRecorder != null)
      {
        this.mMediaRecorder.stop();
        this.mMediaRecorder.release();
        this.mMediaRecorder = null;
        this.isRecording = false;
      }
      if (this.mCamera != null)
      {
        this.mCamera.release();
        this.mCamera = null;
      }
    }
    if (this.mVideoDialog != null) {
      this.mVideoDialog.dismiss();
    }
    if (this.mHolder != null) {
      this.mHolder.removeCallback(this.mCallback);
    }
    BNDrivingToolManager.getInstance().getIssueStoreDialog(1).show();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/BNVideoRecordManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */