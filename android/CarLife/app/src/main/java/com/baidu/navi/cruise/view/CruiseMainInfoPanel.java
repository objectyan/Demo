package com.baidu.navi.cruise.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.ui.cruise.model.CruiseState;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.ui.cruise.view.CruiseResHelper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseMainInfoPanel {
    private static final String TAG = "Cruise";
    public static final int UPDATE_TYPE_HIDE = 3;
    public static final int UPDATE_TYPE_SHOW = 1;
    public static final int UPDATE_TYPE_UPDATE = 2;
    private Activity mActivity;
    private TextView mCameraDistanceLable;
    private TextView mCameraDistanceTextView;
    private ImageView mCameraIconImageView;
    private View mCameraIconLayout;
    private View mCameraInfoLayout;
    private TextView mCameraSpeedTextView;
    private TextView mCameraTypeTextView;
    private View mCurrentSpeedInfoLayout;
    private TextView mCurrentSpeedTextView;
    private TextView mMiscStatusTextView;
    private TextView mNetStatusTextView;
    public View mRootView;
    private Matrix mRotateMatrix = new Matrix();
    private ImageView mSatelliteImageView;
    private TextView mSatelliteNumTextView;
    private ImageView mSecondCameraIconImageView;
    private View mSecondCameraIconLayout;
    private Bitmap mSpeedIndicatorBitmap;
    private ImageView mSpeedIndicatorImageView;
    private CruiseUIModel mUIModel = CruiseUIModel.getInstance();

    /* renamed from: com.baidu.navi.cruise.view.CruiseMainInfoPanel$1 */
    class C37531 implements OnTouchListener {
        C37531() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    public CruiseMainInfoPanel(Activity activity, ViewGroup parentView) {
        this.mActivity = activity;
        initViews(parentView);
    }

    public CruiseMainInfoPanel(Activity activity) {
        this.mActivity = activity;
        initViews(StyleManager.inflate(C0965R.layout.nsdk_layout_cruise_bar_top, null));
    }

    public View getView() {
        return this.mRootView;
    }

    private void initViews(View parentView) {
        if (parentView != null) {
            View mRootView = parentView.findViewById(C0965R.id.layout_cruise_top);
            this.mSatelliteNumTextView = (TextView) parentView.findViewById(C0965R.id.text_cruise_satellite_num);
            this.mSatelliteImageView = (ImageView) parentView.findViewById(C0965R.id.img_cruise_satellite);
            this.mNetStatusTextView = (TextView) parentView.findViewById(C0965R.id.text_cruise_net_status);
            this.mNetStatusTextView.setVisibility(4);
            if (mRootView != null) {
                mRootView.setOnTouchListener(new C37531());
                this.mCameraIconLayout = mRootView.findViewById(C0965R.id.layout_cruise_camera_icon);
                this.mCameraIconImageView = (ImageView) mRootView.findViewById(C0965R.id.img_cruise_camera_icon);
                this.mCameraSpeedTextView = (TextView) mRootView.findViewById(C0965R.id.text_cruise_camera_speed);
                this.mCameraSpeedTextView.setVisibility(4);
                this.mSpeedIndicatorImageView = (ImageView) mRootView.findViewById(C0965R.id.img_cruise_speed_indicator);
                this.mSecondCameraIconLayout = mRootView.findViewById(C0965R.id.layout_cruise_second_camera_icon);
                this.mSecondCameraIconImageView = (ImageView) mRootView.findViewById(C0965R.id.img_cruise_second_camera_icon);
                this.mCameraInfoLayout = mRootView.findViewById(C0965R.id.layout_cruise_camera_info);
                this.mCameraDistanceTextView = (TextView) this.mCameraInfoLayout.findViewById(C0965R.id.text_cruise_distance);
                this.mCameraDistanceLable = (TextView) this.mCameraInfoLayout.findViewById(C0965R.id.text_cruise_distance_suffix);
                this.mCameraTypeTextView = (TextView) this.mCameraInfoLayout.findViewById(C0965R.id.text_cruise_camera_type);
                this.mCurrentSpeedInfoLayout = mRootView.findViewById(C0965R.id.layout_cruise_speed_info);
                this.mCurrentSpeedTextView = (TextView) this.mCurrentSpeedInfoLayout.findViewById(C0965R.id.text_cruise_speed);
                this.mMiscStatusTextView = (TextView) mRootView.findViewById(C0965R.id.text_cruise_misc_status);
            }
            try {
                this.mSpeedIndicatorBitmap = ((BitmapDrawable) StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_cruise_speed_indicator)).getBitmap();
            } catch (OutOfMemoryError e) {
                LogUtil.m15791e("Cruise", "Error: " + e);
            }
            restoreViews();
        }
    }

    private void restoreViews() {
        switch (this.mUIModel.getCruiseState()) {
            case DISCONNECTED:
                setToDisconnected();
                break;
            case GPS_DISABLED:
                setViewWhenNoGPS();
                break;
            case GPS_WEAK:
                setViewWhenNotLocated();
                break;
            case NORMAL:
                hideCameraInfo();
                break;
            case SHOWING_CAMERA:
                showCameraInfo(this.mUIModel.getCameraIconResID(), this.mUIModel.getAssistType(), this.mUIModel.getCameraSpeed());
                if (this.mUIModel.getCameraProgress() > 0) {
                    updateCameraInfo(this.mUIModel.getCameraProgress());
                    break;
                }
                break;
        }
        updateCurrentSpeed(this.mUIModel.getCurrentSpeed());
        updateSatelliteViews(this.mUIModel.getSatelliteNum());
    }

    public void onResume() {
    }

    public void updateData(Bundle b) {
        int updateType = b.getInt("updatetype");
        int assistType = b.getInt("assisttype");
        LogUtil.m15791e("CruiseBugTest", "updateData b.assisttype = " + assistType);
        udpateCameraInfo(updateType, assistType, b.getInt("speed"));
    }

    private void udpateCameraInfo(int updateType, int assistType, int cameraSpeed) {
        if (updateType == 1) {
            int resId = getResIdByType(assistType, cameraSpeed);
            showCameraInfo(resId, assistType, cameraSpeed);
            setCruiseState(CruiseState.SHOWING_CAMERA);
            this.mUIModel.setAssistType(assistType);
            this.mUIModel.setCameraSpeed(cameraSpeed);
            this.mUIModel.setCameraIconResID(resId);
        } else if (updateType == 2) {
            updateCameraInfo(cameraSpeed);
            setCruiseState(CruiseState.SHOWING_CAMERA);
            this.mUIModel.setCameraProgress(cameraSpeed);
        } else if (updateType == 3) {
            hideCameraInfo();
            setCruiseState(CruiseState.NORMAL);
        }
    }

    private int getResIdByType(int assistType, int subType) {
        return CruiseResHelper.getCameraIconResIdByTypes(assistType, subType);
    }

    private void showCameraInfo(int cameraResId, int assistType, int cameraSpeed) {
        LogUtil.m15791e("Cruise", "showCamera: state " + getState() + ", assistType " + assistType + ", speed " + cameraSpeed);
        int visibility = this.mCameraIconLayout.getVisibility();
        if (visibility == 4 || visibility == 8 || assistType == 8 || assistType == 11) {
            showSpeedCameraInfo(cameraResId, assistType, cameraSpeed);
        } else {
            showSecondCameraInfo(cameraResId, assistType, cameraSpeed);
        }
    }

    private void showSpeedCameraInfo(int cameraResId, int assistType, int cameraSpeed) {
        switchToCameraInfoLayout();
        if (assistType == 8) {
            if (this.mCameraSpeedTextView != null) {
                this.mCameraSpeedTextView.setText(String.valueOf(cameraSpeed / 1000));
                this.mCameraSpeedTextView.setVisibility(0);
            }
        } else if (assistType == 11) {
            if (this.mCameraSpeedTextView != null) {
                this.mCameraSpeedTextView.setText(String.valueOf(cameraSpeed / 1000));
                this.mCameraSpeedTextView.setVisibility(0);
            }
        } else if (this.mCameraSpeedTextView != null) {
            this.mCameraSpeedTextView.setVisibility(8);
        }
        if (!(this.mCameraIconImageView == null || cameraResId == 0)) {
            try {
                this.mCameraIconImageView.setImageDrawable(JarUtils.getResources().getDrawable(cameraResId));
            } catch (Throwable th) {
            }
            this.mCameraIconImageView.setVisibility(0);
        }
        if (this.mCameraTypeTextView != null) {
            this.mCameraTypeTextView.setText(CruiseResHelper.getCameraNameByTypes(assistType, 0));
        }
        updateCameraInfo(0);
    }

    private void showSecondCameraInfo(int cameraResId, int assistType, int cameraSpeed) {
        this.mSecondCameraIconLayout.setVisibility(0);
        try {
            this.mSecondCameraIconImageView.setImageDrawable(JarUtils.getResources().getDrawable(cameraResId));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void switchToCameraInfoLayout() {
        LogUtil.m15791e("Cruise", "switchToCameraInfoLayout");
        if (!(this.mCurrentSpeedInfoLayout == null || this.mCameraInfoLayout == null)) {
            this.mCurrentSpeedInfoLayout.setVisibility(4);
            this.mCameraInfoLayout.setVisibility(0);
        }
        if (this.mCameraIconLayout != null) {
            this.mCameraIconLayout.setVisibility(0);
        }
        if (this.mSpeedIndicatorImageView != null) {
            this.mSpeedIndicatorImageView.setVisibility(4);
        }
        if (this.mMiscStatusTextView != null) {
            this.mMiscStatusTextView.setVisibility(4);
        }
    }

    private void switchToCurrentSpeedLayout() {
        LogUtil.m15791e("Cruise", "switchToCurrentSpeedLayout");
        if (!(this.mCurrentSpeedInfoLayout == null || this.mCameraInfoLayout == null)) {
            this.mCurrentSpeedInfoLayout.setVisibility(4);
            this.mCameraInfoLayout.setVisibility(4);
        }
        if (this.mCameraIconLayout != null) {
            this.mCameraIconLayout.setVisibility(4);
        }
        this.mSecondCameraIconLayout.setVisibility(4);
        if (this.mCameraSpeedTextView != null) {
            this.mCameraSpeedTextView.setVisibility(8);
        }
        if (this.mSpeedIndicatorImageView != null) {
            this.mSpeedIndicatorImageView.setVisibility(4);
        }
        if (this.mMiscStatusTextView != null) {
            this.mMiscStatusTextView.setVisibility(4);
        }
    }

    private void switchToMiscStatusInfoLayout() {
        LogUtil.m15791e("Cruise", "switchToMiscStatusInfoLayout");
        if (!(this.mCurrentSpeedInfoLayout == null || this.mCameraInfoLayout == null)) {
            this.mCurrentSpeedInfoLayout.setVisibility(4);
            this.mCameraInfoLayout.setVisibility(4);
        }
        if (this.mCameraIconLayout != null) {
            this.mCameraIconLayout.setVisibility(8);
        }
        if (this.mMiscStatusTextView != null) {
            this.mMiscStatusTextView.setVisibility(0);
        }
    }

    private void updateCameraInfo(int progress) {
        if (this.mCameraDistanceTextView != null) {
            LogUtil.m15791e("Cruise", "updateCameraInfo:  state " + getState() + ", distance " + this.mUIModel.getCameraDistance() + ", progress " + progress);
            this.mCameraDistanceTextView.setText(StyleManager.getString(C0965R.string.nsdk_string_cruise_camera_distance, Integer.valueOf(distance)));
        }
    }

    private void hideCameraInfo() {
        LogUtil.m15791e("Cruise", "hideCameraInfo: state " + getState());
        switchToCurrentSpeedLayout();
        if (this.mCameraIconImageView != null) {
            this.mCameraIconImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_cruise_speed_panel));
        }
    }

    public void updateSatelliteViews(int satelliteNum) {
        if (satelliteNum < 0) {
            satelliteNum = 0;
        }
        if (satelliteNum > 15) {
            satelliteNum = 15;
        }
        LogUtil.m15791e("Cruise", "updateSatelliteViews " + satelliteNum);
        this.mUIModel.setSatelliteNum(satelliteNum);
        if (this.mSatelliteNumTextView != null) {
            this.mSatelliteNumTextView.setText(String.valueOf(satelliteNum));
        }
        if (this.mSatelliteImageView == null) {
            return;
        }
        if (satelliteNum < 3) {
            this.mSatelliteImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_ic_satellite_red));
            this.mSatelliteNumTextView.setTextColor(StyleManager.getColor(C0965R.color.nsdk_cruise_satellite_text_red));
        } else if (satelliteNum >= 3 && satelliteNum < 6) {
            this.mSatelliteImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_ic_satellite_yellow));
            this.mSatelliteNumTextView.setTextColor(StyleManager.getColor(C0965R.color.nsdk_cruise_text_assis));
        } else if (satelliteNum >= 6) {
            this.mSatelliteImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_ic_satellite_green));
            this.mSatelliteNumTextView.setTextColor(StyleManager.getColor(C0965R.color.nsdk_cruise_text_assis));
        }
    }

    public void updateCurrentSpeed(int speed) {
        LogUtil.m15791e("Cruise", "update current speed: " + speed + ", state " + this.mUIModel.getCruiseState());
        this.mUIModel.setCurrentSpeed(speed);
        if (this.mCurrentSpeedTextView != null) {
            this.mCurrentSpeedTextView.setText(String.valueOf(speed));
        }
        if (this.mUIModel.getCruiseState() == CruiseState.DISCONNECTED || this.mUIModel.getCruiseState() == CruiseState.NORMAL) {
            rotateSpeedIndicator(speed);
        }
    }

    public void setToDisconnected() {
        boolean hasData = this.mUIModel.isProvinceDataDownloaded();
        LogUtil.m15791e("Cruise", "set to Disconnected, state " + getState() + ", hasData " + hasData);
        if (!hasData && this.mNetStatusTextView != null) {
            this.mNetStatusTextView.setText(StyleManager.getString(C0965R.string.nsdk_string_cruise_no_network_short));
        }
    }

    public void setToConnected() {
        LogUtil.m15791e("Cruise", "set to Connected, state " + getState());
        if (this.mNetStatusTextView != null) {
            this.mNetStatusTextView.setVisibility(4);
        }
    }

    public void setViewWhenNoGPS() {
        LogUtil.m15791e("Cruise", "set to NO GPS, state " + getState());
        setCruiseState(CruiseState.GPS_DISABLED);
        if (this.mMiscStatusTextView != null) {
            this.mMiscStatusTextView.setText(StyleManager.getString(C0965R.string.nsdk_string_cruise_nogps_map_tip));
        }
        updateCurrentSpeed(0);
        updateSatelliteViews(0);
        switchToMiscStatusInfoLayout();
    }

    public void setViewWhenGPSRecover() {
        LogUtil.m15791e("Cruise", "set to GPS Recovered, state " + getState());
        if (getState() == CruiseState.GPS_DISABLED || getState() == CruiseState.GPS_WEAK) {
            setCruiseState(CruiseState.NORMAL);
            if (this.mCameraIconImageView != null) {
                this.mCameraIconImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_cruise_speed_panel));
            }
            switchToCurrentSpeedLayout();
        }
    }

    public void setViewWhenNotLocated() {
        LogUtil.m15791e("Cruise", "set to Not Located, state " + getState());
        setCruiseState(CruiseState.GPS_WEAK);
        if (this.mCameraIconImageView != null) {
            this.mCameraIconImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_cruise_try_locate));
        }
        if (this.mMiscStatusTextView != null) {
            this.mMiscStatusTextView.setText(StyleManager.getString(C0965R.string.nsdk_string_cruise_try_locate));
        }
        switchToMiscStatusInfoLayout();
    }

    public void onUpdateStyle(boolean dayStyle) {
        this.mUIModel.setIsDayStyle(dayStyle);
        if (this.mRootView != null && this.mCameraDistanceTextView != null && this.mCameraTypeTextView != null) {
            this.mCameraDistanceTextView.setTextColor(-2130706433);
            this.mCameraTypeTextView.setTextColor(-1);
        }
    }

    public void show() {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(0);
        }
    }

    public void hide() {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(4);
        }
    }

    private void setCruiseState(CruiseState state) {
        CruiseUIModel.getInstance().setCruiseState(state);
    }

    private CruiseState getState() {
        return CruiseUIModel.getInstance().getCruiseState();
    }

    private void rotateSpeedIndicator(int speed) {
        if (this.mSpeedIndicatorImageView != null && speed >= 0 && this.mSpeedIndicatorBitmap != null) {
            try {
                this.mRotateMatrix.setRotate((float) ((speed * 3) / 2));
                this.mSpeedIndicatorImageView.setImageBitmap(Bitmap.createBitmap(this.mSpeedIndicatorBitmap, 0, 0, this.mSpeedIndicatorBitmap.getWidth(), this.mSpeedIndicatorBitmap.getHeight(), this.mRotateMatrix, true));
            } catch (OutOfMemoryError e) {
                LogUtil.m15791e("Cruise", "Error: " + e);
            }
        }
    }
}
