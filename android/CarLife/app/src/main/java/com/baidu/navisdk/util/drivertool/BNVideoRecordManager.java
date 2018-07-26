package com.baidu.navisdk.util.drivertool;

import android.content.Context;
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
import com.baidu.navisdk.util.drivertool.view.BNVideoBoardDialog;
import java.io.File;

public class BNVideoRecordManager {
    public static String NO_RECORD_AUTH_MSG = "请打开麦克风或者照相机权限";
    private static BNVideoRecordManager mInstance;
    private int count = 10;
    private boolean isRecording = false;
    private Callback mCallback = new C46722();
    private Camera mCamera = null;
    private Handler mHandler = new C46711();
    private SurfaceHolder mHolder;
    private MediaRecorder mMediaRecorder = null;
    private SurfaceView mSurfaceView = null;
    private BNVideoBoardDialog mVideoDialog;

    /* renamed from: com.baidu.navisdk.util.drivertool.BNVideoRecordManager$1 */
    class C46711 extends Handler {
        C46711() {
        }

        public void handleMessage(Message msg) {
            int type = msg.what;
            if (type == 0) {
                if (BNVideoRecordManager.this.count >= 0) {
                    if (BNVideoRecordManager.this.mVideoDialog != null) {
                        BNVideoRecordManager.this.mVideoDialog.updateTimeText(BNVideoRecordManager.this.count);
                    }
                    BNVideoRecordManager.access$006(BNVideoRecordManager.this);
                    BNVideoRecordManager.this.mHandler.sendEmptyMessageDelayed(0, 1000);
                    return;
                }
                BNVideoRecordManager.this.mHandler.sendEmptyMessage(1);
            } else if (type == 1) {
                BNVideoRecordManager.this.stopRecordVideo();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.BNVideoRecordManager$2 */
    class C46722 implements Callback {
        C46722() {
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
        }

        public void surfaceCreated(SurfaceHolder holder) {
            int defination;
            BNVideoRecordManager.this.count = 9;
            BNVideoRecordManager.this.mHandler.sendEmptyMessageDelayed(0, 1000);
            if (BNSettingManager.isRecordingHighDefinition()) {
                defination = 0;
            } else {
                defination = 1;
            }
            BNVideoRecordManager.this.recordVideoInner(BNVideoRecordManager.this.getPathStr(), defination);
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.BNVideoRecordManager$3 */
    class C46733 implements OnErrorListener {
        C46733() {
        }

        public void onError(MediaRecorder mr, int what, int extra) {
            BNVideoRecordManager.this.mMediaRecorder.stop();
            BNVideoRecordManager.this.mMediaRecorder.release();
            BNVideoRecordManager.this.mMediaRecorder = null;
            BNVideoRecordManager.this.isRecording = false;
            if (BNVideoRecordManager.this.mCamera != null) {
                BNVideoRecordManager.this.mCamera.release();
                BNVideoRecordManager.this.mCamera = null;
            }
            if (BNVideoRecordManager.this.mHolder != null) {
                BNVideoRecordManager.this.mHolder.removeCallback(BNVideoRecordManager.this.mCallback);
            }
        }
    }

    static /* synthetic */ int access$006(BNVideoRecordManager x0) {
        int i = x0.count - 1;
        x0.count = i;
        return i;
    }

    private BNVideoRecordManager() {
        Context ctx = BNaviModuleManager.getNaviActivity();
        if (ctx != null) {
            this.mVideoDialog = new BNVideoBoardDialog(ctx);
            this.mSurfaceView = this.mVideoDialog.getVideoPanel();
            this.mVideoDialog.setCanceledOnTouchOutside(false);
        }
    }

    public static BNVideoRecordManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNVideoRecordManager();
        }
        return mInstance;
    }

    private String getPathStr() {
        return BNDrivingToolUtils.getAbsoluteFilePath(1);
    }

    public boolean recordVideo() {
        if (this.mVideoDialog != null) {
            this.mVideoDialog.show();
        }
        this.mHolder = this.mSurfaceView.getHolder();
        this.mHolder.addCallback(this.mCallback);
        return true;
    }

    private void recordVideoInner(String pathStr, int definition) {
        File file = new File(pathStr);
        try {
            this.mMediaRecorder = new MediaRecorder();
            this.mMediaRecorder.reset();
            this.mCamera = Camera.open();
            this.mCamera.setDisplayOrientation(90);
            this.mCamera.unlock();
            this.mMediaRecorder.setCamera(this.mCamera);
            this.mMediaRecorder.setAudioSource(1);
            this.mMediaRecorder.setVideoSource(1);
            int quality = 6;
            if (definition == 0) {
                quality = 4;
            } else if (definition == 1) {
                quality = 0;
            }
            this.mMediaRecorder.setProfile(CamcorderProfile.get(quality));
            this.mMediaRecorder.setOutputFile(file.getAbsolutePath());
            this.mMediaRecorder.setPreviewDisplay(this.mSurfaceView.getHolder().getSurface());
            this.mMediaRecorder.setOrientationHint(90);
            this.mMediaRecorder.setOnErrorListener(new C46733());
            this.mMediaRecorder.prepare();
            this.mMediaRecorder.start();
            this.isRecording = true;
        } catch (Exception e) {
            if (this.mMediaRecorder != null) {
                this.mMediaRecorder.stop();
                this.mMediaRecorder.release();
                this.mMediaRecorder = null;
            }
            if (this.mCamera != null) {
                this.mCamera.release();
                this.mCamera = null;
            }
            if (this.mHolder != null) {
                this.mHolder.removeCallback(this.mCallback);
            }
        }
    }

    public void stopRecordVideo() {
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(1);
        if (this.isRecording) {
            if (this.mMediaRecorder != null) {
                this.mMediaRecorder.stop();
                this.mMediaRecorder.release();
                this.mMediaRecorder = null;
                this.isRecording = false;
            }
            if (this.mCamera != null) {
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

    public boolean hasRecordAuth() {
        if (SystemAuth.checkAuth("android.permission.RECORD_AUDIO") && SystemAuth.checkAuth(SystemAuth.PHOTO_CAPTURE_AUTH)) {
            return true;
        }
        return false;
    }
}
