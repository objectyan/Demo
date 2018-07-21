package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMCommonNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;

public class RGCommonNotificationModel
{
  private static final String TAG = RGCommonNotificationModel.class.getSimpleName();
  public int mAutoHideTime = 0;
  public RGMMNotificationBaseView.NotificationDisplayListener mDisplayListener = null;
  public Handler mHandler = null;
  public String mID = null;
  public BNImageLoadingListener mIconListener = null;
  public BNDisplayImageOptions mIconOptions = null;
  public String mIconUrl = null;
  public int mMainTitleColor = 0;
  public String mMainTitleText = null;
  public int mNotificationColor = 0;
  public Drawable mNotificationIcon = null;
  public int mNotificationType = 0;
  public int mPriority = 0;
  public int mSubTitleColor = 0;
  public String mSubTitleText = null;
  public int mThirdTitleColor = 0;
  public String mThirdTitleText = null;
  public RGMMCommonNotificationView mView = null;
  
  public RGCommonNotificationModel(RGMMCommonNotificationView paramRGMMCommonNotificationView, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4, int paramInt5, Drawable paramDrawable, int paramInt6, RGMMNotificationBaseView.NotificationDisplayListener paramNotificationDisplayListener, String paramString5, BNDisplayImageOptions paramBNDisplayImageOptions, BNImageLoadingListener paramBNImageLoadingListener, int paramInt7)
  {
    this.mView = paramRGMMCommonNotificationView;
    this.mID = paramString1;
    this.mPriority = paramInt1;
    this.mAutoHideTime = paramInt2;
    this.mMainTitleText = paramString2;
    this.mSubTitleText = paramString3;
    this.mThirdTitleText = paramString4;
    this.mMainTitleColor = paramInt3;
    this.mSubTitleColor = paramInt4;
    this.mThirdTitleColor = paramInt5;
    this.mNotificationIcon = paramDrawable;
    this.mNotificationColor = paramInt6;
    this.mDisplayListener = paramNotificationDisplayListener;
    this.mIconUrl = paramString5;
    this.mIconOptions = paramBNDisplayImageOptions;
    this.mIconListener = paramBNImageLoadingListener;
    this.mNotificationType = paramInt7;
    this.mHandler = new Handler(Looper.myLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        RGNotificationController.getInstance().hideCommonViewByHandler(RGCommonNotificationModel.this.mView);
      }
    };
  }
  
  public RGCommonNotificationModel(String paramString)
  {
    this.mID = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof RGCommonNotificationModel))
    {
      RGCommonNotificationModel localRGCommonNotificationModel = (RGCommonNotificationModel)paramObject;
      if ((!TextUtils.isEmpty(this.mID)) && (!TextUtils.isEmpty(localRGCommonNotificationModel.mID))) {
        return this.mID.equals(localRGCommonNotificationModel.mID);
      }
    }
    return super.equals(paramObject);
  }
  
  public void reset()
  {
    this.mView = null;
    this.mID = null;
    this.mPriority = 0;
    this.mAutoHideTime = 0;
    this.mMainTitleText = null;
    this.mSubTitleText = null;
    this.mThirdTitleText = null;
    this.mMainTitleColor = 0;
    this.mSubTitleColor = 0;
    this.mThirdTitleColor = 0;
    this.mNotificationIcon = null;
    this.mNotificationColor = 0;
    this.mDisplayListener = null;
    this.mIconUrl = null;
    this.mIconOptions = null;
    this.mIconListener = null;
    this.mNotificationType = 0;
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1000);
    }
    this.mHandler = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGCommonNotificationModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */