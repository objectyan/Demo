package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.File;
import java.io.FileOutputStream;

public class BNTakePhotoManager {
    public static final int REQUEST_TAKE_PHOTO_CODE = 256;
    private static BNTakePhotoManager mInstance;
    private Bitmap mBitmap = null;
    private Object mObj = null;

    private BNTakePhotoManager() {
    }

    public static BNTakePhotoManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNTakePhotoManager();
        }
        return mInstance;
    }

    public void takePhoto() {
        BNDrivingToolUtils.sIssueOccurTime = System.currentTimeMillis();
        Activity activity = BNaviModuleManager.getNaviActivity();
        if (activity != null) {
            activity.startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), 256);
        }
    }

    public String getPathStr() {
        return BNDrivingToolUtils.getAbsoluteFilePath(2);
    }

    public void onPhotoTakeActionFinish(Bitmap bitmap, Object obj) {
        BNDrivingToolManager.getInstance().asynAntiGeoSearch(BNaviModuleManager.getNaviActivity());
        this.mBitmap = bitmap;
        this.mObj = obj;
    }

    public void photoFinishAction() {
        Throwable th;
        if (this.mBitmap != null) {
            if (!this.mBitmap.isMutable()) {
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "photoFinishAction bitmap is not mutable");
                this.mBitmap = this.mBitmap.copy(Config.RGB_565, true);
            }
            BNDrivingToolUtils.addWaterMark(this.mBitmap, BNDrivingToolUtils.getLocationInfo(), BNDrivingToolUtils.getCurrentTimeInfo(), this.mObj);
            FileOutputStream fout = null;
            try {
                FileOutputStream fout2 = new FileOutputStream(new File(getPathStr()));
                try {
                    this.mBitmap.compress(CompressFormat.PNG, 90, fout2);
                    if (fout2 != null) {
                        try {
                            fout2.flush();
                            fout2.close();
                        } catch (Exception e) {
                        }
                    }
                    if (this.mBitmap == null || this.mBitmap.isRecycled()) {
                        fout = fout2;
                    } else {
                        this.mBitmap.recycle();
                        this.mBitmap = null;
                        fout = fout2;
                    }
                } catch (Exception e2) {
                    fout = fout2;
                    if (fout != null) {
                        try {
                            fout.flush();
                            fout.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                        this.mBitmap.recycle();
                        this.mBitmap = null;
                    }
                    BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
                    BNDrivingToolManager.getInstance().getIssueStoreDialog(2).show();
                } catch (Throwable th2) {
                    th = th2;
                    fout = fout2;
                    if (fout != null) {
                        try {
                            fout.flush();
                            fout.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                        this.mBitmap.recycle();
                        this.mBitmap = null;
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (fout != null) {
                    fout.flush();
                    fout.close();
                }
                this.mBitmap.recycle();
                this.mBitmap = null;
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
                BNDrivingToolManager.getInstance().getIssueStoreDialog(2).show();
            } catch (Throwable th3) {
                th = th3;
                if (fout != null) {
                    fout.flush();
                    fout.close();
                }
                this.mBitmap.recycle();
                this.mBitmap = null;
                throw th;
            }
            BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
            BNDrivingToolManager.getInstance().getIssueStoreDialog(2).show();
        }
    }
}
