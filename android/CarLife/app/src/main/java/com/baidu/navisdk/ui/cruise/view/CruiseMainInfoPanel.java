package com.baidu.navisdk.ui.cruise.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.navisdk.ui.cruise.model.CruiseState;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseMainInfoPanel
{
  private static final String TAG = "Cruise";
  public static final int UPDATE_TYPE_HIDE = 3;
  public static final int UPDATE_TYPE_SHOW = 1;
  public static final int UPDATE_TYPE_UPDATE = 2;
  private TextView mCameraDistanceLable;
  private TextView mCameraDistanceTextView;
  private ImageView mCameraIconImageView;
  private View mCameraIconLayout;
  private View mCameraInfoLayout;
  private TextView mCameraSpeedTextView;
  private TextView mCameraTypeTextView;
  private Context mContext;
  private View mCurrentSpeedInfoLayout;
  private TextView mCurrentSpeedTextView;
  private TextView mMiscStatusTextView;
  private TextView mNetStatusTextView;
  public View mRootView;
  private Matrix mRotateMatrix = new Matrix();
  private ImageView mSatelliteImageView;
  private TextView mSatelliteNumTextView;
  private Bitmap mSpeedIndicatorBitmap;
  private ImageView mSpeedIndicatorImageView;
  private CruiseUIModel mUIModel = CruiseUIModel.getInstance();
  
  public CruiseMainInfoPanel(Activity paramActivity)
  {
    this.mContext = paramActivity;
    initViews(JarUtils.inflate(paramActivity, 1711472658, null));
  }
  
  public CruiseMainInfoPanel(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.mContext = paramActivity;
    initViews(paramViewGroup);
  }
  
  private int getResIdByType(int paramInt1, int paramInt2)
  {
    return CruiseResHelper.getCameraIconResIdByTypes(paramInt1, paramInt2);
  }
  
  private CruiseState getState()
  {
    return CruiseUIModel.getInstance().getCruiseState();
  }
  
  private void hideCameraInfo()
  {
    LogUtil.e("Cruise", "hideCameraInfo: state " + getState());
    switchToCurrentSpeedLayout();
    if (this.mCameraIconImageView != null) {
      this.mCameraIconImageView.setImageDrawable(JarUtils.getResources().getDrawable(1711407617));
    }
  }
  
  private void initViews(View paramView)
  {
    if (paramView == null) {
      return;
    }
    View localView = paramView.findViewById(1711865905);
    this.mSatelliteNumTextView = ((TextView)paramView.findViewById(1711865924));
    this.mSatelliteImageView = ((ImageView)paramView.findViewById(1711865923));
    this.mNetStatusTextView = ((TextView)paramView.findViewById(1711865937));
    this.mNetStatusTextView.setVisibility(4);
    if (localView != null)
    {
      localView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.mCameraIconLayout = localView.findViewById(1711865931);
      this.mCameraIconImageView = ((ImageView)localView.findViewById(1711865932));
      this.mCameraSpeedTextView = ((TextView)localView.findViewById(1711865934));
      this.mCameraSpeedTextView.setVisibility(4);
      this.mSpeedIndicatorImageView = ((ImageView)localView.findViewById(1711865933));
      this.mCameraInfoLayout = localView.findViewById(1711865908);
      this.mCameraDistanceTextView = ((TextView)this.mCameraInfoLayout.findViewById(1711865917));
      this.mCameraDistanceLable = ((TextView)this.mCameraInfoLayout.findViewById(1711865918));
      this.mCameraTypeTextView = ((TextView)this.mCameraInfoLayout.findViewById(1711865921));
      this.mCurrentSpeedInfoLayout = localView.findViewById(1711865909);
      this.mCurrentSpeedTextView = ((TextView)this.mCurrentSpeedInfoLayout.findViewById(1711865911));
      this.mMiscStatusTextView = ((TextView)localView.findViewById(1711865936));
    }
    try
    {
      this.mSpeedIndicatorBitmap = ((BitmapDrawable)JarUtils.getResources().getDrawable(1711407616)).getBitmap();
      restoreViews();
      return;
    }
    catch (OutOfMemoryError paramView)
    {
      for (;;)
      {
        LogUtil.e("Cruise", "Error: " + paramView);
      }
    }
  }
  
  private void restoreViews()
  {
    switch (this.mUIModel.getCruiseState())
    {
    }
    for (;;)
    {
      updateCurrentSpeed(this.mUIModel.getCurrentSpeed());
      updateSatelliteViews(this.mUIModel.getSatelliteNum());
      return;
      setToDisconnected();
      continue;
      setViewWhenNoGPS();
      continue;
      setViewWhenNotLocated();
      continue;
      hideCameraInfo();
      continue;
      showCameraInfo(this.mUIModel.getCameraIconResID(), this.mUIModel.getAssistType(), this.mUIModel.getCameraSpeed());
      if (this.mUIModel.getCameraProgress() > 0) {
        updateCameraInfo(this.mUIModel.getCameraProgress());
      }
    }
  }
  
  private void rotateSpeedIndicator(int paramInt)
  {
    if ((this.mSpeedIndicatorImageView != null) && (paramInt >= 0) && (this.mSpeedIndicatorBitmap != null)) {}
    try
    {
      this.mRotateMatrix.setRotate(paramInt * 3 / 2);
      Bitmap localBitmap = Bitmap.createBitmap(this.mSpeedIndicatorBitmap, 0, 0, this.mSpeedIndicatorBitmap.getWidth(), this.mSpeedIndicatorBitmap.getHeight(), this.mRotateMatrix, true);
      this.mSpeedIndicatorImageView.setImageBitmap(localBitmap);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      LogUtil.e("Cruise", "Error: " + localOutOfMemoryError);
    }
  }
  
  private void setCruiseState(CruiseState paramCruiseState)
  {
    CruiseUIModel.getInstance().setCruiseState(paramCruiseState);
  }
  
  private void showCameraInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtil.e("Cruise", "showCamera: state " + getState() + ", assistType " + paramInt2 + ", speed " + paramInt3);
    switchToCameraInfoLayout();
    if (paramInt2 == 8) {
      if (this.mCameraSpeedTextView != null)
      {
        paramInt3 /= 1000;
        this.mCameraSpeedTextView.setText(String.valueOf(paramInt3));
        this.mCameraSpeedTextView.setVisibility(0);
      }
    }
    for (;;)
    {
      if ((this.mCameraIconImageView != null) && (paramInt1 != 0)) {}
      try
      {
        this.mCameraIconImageView.setImageDrawable(JarUtils.getResources().getDrawable(paramInt1));
        this.mCameraIconImageView.setVisibility(0);
        if (this.mCameraTypeTextView != null)
        {
          String str = CruiseResHelper.getCameraNameByTypes(paramInt2, 0);
          this.mCameraTypeTextView.setText(str);
        }
        updateCameraInfo(0);
        return;
        if (paramInt2 == 11)
        {
          if (this.mCameraSpeedTextView == null) {
            continue;
          }
          paramInt3 /= 1000;
          this.mCameraSpeedTextView.setText(String.valueOf(paramInt3));
          this.mCameraSpeedTextView.setVisibility(0);
          continue;
        }
        if (this.mCameraSpeedTextView == null) {
          continue;
        }
        this.mCameraSpeedTextView.setVisibility(8);
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  private void switchToCameraInfoLayout()
  {
    LogUtil.e("Cruise", "switchToCameraInfoLayout");
    if ((this.mCurrentSpeedInfoLayout != null) && (this.mCameraInfoLayout != null))
    {
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
  
  private void switchToCurrentSpeedLayout()
  {
    LogUtil.e("Cruise", "switchToCurrentSpeedLayout");
    if ((this.mCurrentSpeedInfoLayout != null) && (this.mCameraInfoLayout != null))
    {
      this.mCurrentSpeedInfoLayout.setVisibility(0);
      this.mCameraInfoLayout.setVisibility(4);
    }
    if (this.mCameraIconLayout != null) {
      this.mCameraIconLayout.setVisibility(0);
    }
    if (this.mCameraSpeedTextView != null) {
      this.mCameraSpeedTextView.setVisibility(8);
    }
    if (this.mSpeedIndicatorImageView != null) {
      this.mSpeedIndicatorImageView.setVisibility(0);
    }
    if (this.mMiscStatusTextView != null) {
      this.mMiscStatusTextView.setVisibility(4);
    }
  }
  
  private void switchToMiscStatusInfoLayout()
  {
    LogUtil.e("Cruise", "switchToMiscStatusInfoLayout");
    if ((this.mCurrentSpeedInfoLayout != null) && (this.mCameraInfoLayout != null))
    {
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
  
  private void udpateCameraInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 1)
    {
      paramInt1 = getResIdByType(paramInt2, paramInt3);
      showCameraInfo(paramInt1, paramInt2, paramInt3);
      setCruiseState(CruiseState.SHOWING_CAMERA);
      this.mUIModel.setAssistType(paramInt2);
      this.mUIModel.setCameraSpeed(paramInt3);
      this.mUIModel.setCameraIconResID(paramInt1);
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        updateCameraInfo(paramInt3);
        setCruiseState(CruiseState.SHOWING_CAMERA);
        this.mUIModel.setCameraProgress(paramInt3);
        return;
      }
    } while (paramInt1 != 3);
    hideCameraInfo();
    setCruiseState(CruiseState.NORMAL);
  }
  
  private void updateCameraInfo(int paramInt)
  {
    if (this.mCameraDistanceTextView != null)
    {
      paramInt = this.mUIModel.getCameraDistance();
      this.mCameraDistanceTextView.setText(JarUtils.getResources().getString(1711669726, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public View getView()
  {
    return this.mRootView;
  }
  
  public void hide()
  {
    if (this.mRootView != null) {
      this.mRootView.setVisibility(4);
    }
  }
  
  public void onResume() {}
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    this.mUIModel.setIsDayStyle(paramBoolean);
    if ((this.mRootView == null) || (this.mCameraDistanceTextView == null) || (this.mCameraTypeTextView == null)) {
      return;
    }
    this.mCameraDistanceTextView.setTextColor(-2130706433);
    this.mCameraTypeTextView.setTextColor(-1);
  }
  
  public void setToConnected()
  {
    LogUtil.e("Cruise", "set to Connected, state " + getState());
    if (this.mNetStatusTextView != null) {
      this.mNetStatusTextView.setVisibility(4);
    }
  }
  
  public void setToDisconnected()
  {
    boolean bool = this.mUIModel.isProvinceDataDownloaded();
    LogUtil.e("Cruise", "set to Disconnected, state " + getState() + ", hasData " + bool);
    if ((!bool) && (this.mNetStatusTextView != null))
    {
      this.mNetStatusTextView.setVisibility(0);
      this.mNetStatusTextView.setText(JarUtils.getResources().getString(1711669730));
    }
  }
  
  public void setViewWhenGPSRecover()
  {
    LogUtil.e("Cruise", "set to GPS Recovered, state " + getState());
    if ((getState() == CruiseState.GPS_DISABLED) || (getState() == CruiseState.GPS_WEAK))
    {
      setCruiseState(CruiseState.NORMAL);
      if (this.mCameraIconImageView != null) {
        this.mCameraIconImageView.setImageDrawable(BNStyleManager.getDrawable(1711407617));
      }
      switchToCurrentSpeedLayout();
    }
  }
  
  public void setViewWhenNoGPS()
  {
    LogUtil.e("Cruise", "set to NO GPS, state " + getState());
    setCruiseState(CruiseState.GPS_DISABLED);
    if (this.mMiscStatusTextView != null) {
      this.mMiscStatusTextView.setText(JarUtils.getResources().getString(1711669722));
    }
    updateCurrentSpeed(0);
    updateSatelliteViews(0);
    switchToMiscStatusInfoLayout();
  }
  
  public void setViewWhenNotLocated()
  {
    LogUtil.e("Cruise", "set to Not Located, state " + getState());
    setCruiseState(CruiseState.GPS_WEAK);
    if (this.mCameraIconImageView != null) {
      this.mCameraIconImageView.setImageDrawable(JarUtils.getResources().getDrawable(1711407618));
    }
    if (this.mMiscStatusTextView != null) {
      this.mMiscStatusTextView.setText(JarUtils.getResources().getString(1711669724));
    }
    switchToMiscStatusInfoLayout();
  }
  
  public void show()
  {
    if (this.mRootView != null) {
      this.mRootView.setVisibility(0);
    }
  }
  
  public void updateCurrentSpeed(int paramInt)
  {
    LogUtil.e("Cruise", "update current speed: " + paramInt + ", state " + this.mUIModel.getCruiseState());
    this.mUIModel.setCurrentSpeed(paramInt);
    if (this.mCurrentSpeedTextView != null) {
      this.mCurrentSpeedTextView.setText(String.valueOf(paramInt));
    }
    if ((this.mUIModel.getCruiseState() == CruiseState.DISCONNECTED) || (this.mUIModel.getCruiseState() == CruiseState.NORMAL)) {
      rotateSpeedIndicator(paramInt);
    }
  }
  
  public void updateData(Bundle paramBundle)
  {
    int i = paramBundle.getInt("updatetype");
    int j = paramBundle.getInt("assisttype");
    LogUtil.e("CruiseBugTest", "updateData b.assisttype = " + j);
    udpateCameraInfo(i, j, paramBundle.getInt("speed"));
  }
  
  public void updateSatelliteViews(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i > 15) {
      paramInt = 15;
    }
    LogUtil.e("Cruise", "updateSatelliteViews " + paramInt);
    this.mUIModel.setSatelliteNum(paramInt);
    if (this.mSatelliteNumTextView != null) {
      this.mSatelliteNumTextView.setText(String.valueOf(paramInt));
    }
    if (this.mSatelliteImageView != null)
    {
      if (paramInt >= 3) {
        break label115;
      }
      this.mSatelliteImageView.setImageDrawable(JarUtils.getResources().getDrawable(1711407692));
      this.mSatelliteNumTextView.setTextColor(JarUtils.getResources().getColor(1711800460));
    }
    label115:
    do
    {
      return;
      if ((paramInt >= 3) && (paramInt < 6))
      {
        this.mSatelliteImageView.setImageDrawable(JarUtils.getResources().getDrawable(1711407693));
        this.mSatelliteNumTextView.setTextColor(JarUtils.getResources().getColor(1711800458));
        return;
      }
    } while (paramInt < 6);
    this.mSatelliteImageView.setImageDrawable(JarUtils.getResources().getDrawable(1711407691));
    this.mSatelliteNumTextView.setTextColor(JarUtils.getResources().getColor(1711800458));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/view/CruiseMainInfoPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */