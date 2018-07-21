package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationClickListener;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;

public class RGOperableNotificationModel
{
  private static final String TAG = RGCommonNotificationModel.class.getSimpleName();
  public int mAutoHideTime = 0;
  public Drawable mCancelBackground = null;
  public int mCancelColor = 0;
  public String mCancelText = null;
  public Drawable mConfirmBackground = null;
  public int mConfirmColor = 0;
  public String mConfirmText = null;
  public int mCountingSecs = 0;
  public RGMMNotificationBaseView.NotificationDisplayListener mDisplayListener = null;
  public Handler mHandler = null;
  public String mID = null;
  public BNImageLoadingListener mIconListener = null;
  public BNDisplayImageOptions mIconOptions = null;
  public String mIconUrl = null;
  public boolean mIsShowMasking = false;
  public int mMainTitleColor = 0;
  public String mMainTitleText = null;
  public int mNotificationColor = 0;
  public Drawable mNotificationIcon = null;
  public int mNotificationType = 0;
  public RGMMOperableNotificationView.NotificationClickListener mOnBtnClickListener = null;
  public int mPriority = 0;
  public int mSubTitleColor = 0;
  public String mSubTitleText = null;
  public RGMMOperableNotificationView mView = null;
  
  public RGOperableNotificationModel(RGMMOperableNotificationView paramRGMMOperableNotificationView, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, String paramString4, String paramString5, int paramInt5, int paramInt6, Drawable paramDrawable1, int paramInt7, Drawable paramDrawable2, Drawable paramDrawable3, RGMMOperableNotificationView.NotificationClickListener paramNotificationClickListener, RGMMNotificationBaseView.NotificationDisplayListener paramNotificationDisplayListener, String paramString6, BNDisplayImageOptions paramBNDisplayImageOptions, BNImageLoadingListener paramBNImageLoadingListener, int paramInt8, boolean paramBoolean)
  {
    this.mView = paramRGMMOperableNotificationView;
    this.mID = paramString1;
    this.mPriority = paramInt1;
    this.mAutoHideTime = paramInt2;
    this.mMainTitleText = paramString2;
    this.mSubTitleText = paramString3;
    this.mMainTitleColor = paramInt3;
    this.mSubTitleColor = paramInt4;
    this.mConfirmText = paramString4;
    this.mCancelText = paramString5;
    this.mConfirmColor = paramInt5;
    this.mCancelColor = paramInt6;
    this.mNotificationIcon = paramDrawable1;
    this.mNotificationColor = paramInt7;
    this.mConfirmBackground = paramDrawable2;
    this.mCancelBackground = paramDrawable3;
    this.mOnBtnClickListener = paramNotificationClickListener;
    this.mDisplayListener = paramNotificationDisplayListener;
    this.mIconUrl = paramString6;
    this.mIconOptions = paramBNDisplayImageOptions;
    this.mIconListener = paramBNImageLoadingListener;
    this.mNotificationType = paramInt8;
    this.mIsShowMasking = paramBoolean;
    this.mHandler = new Handler(Looper.myLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        do
        {
          return;
          RGNotificationController.getInstance().hideOperableViewByHandler(RGOperableNotificationModel.this.mView);
          return;
          paramAnonymousMessage = RGOperableNotificationModel.this;
          paramAnonymousMessage.mCountingSecs -= 1;
          RGNotificationController.getInstance().updateOperableViewCountingByHandler(RGOperableNotificationModel.this.mView);
          removeMessages(1001);
        } while (RGOperableNotificationModel.this.mCountingSecs <= 0);
        sendEmptyMessageDelayed(1001, 1000L);
      }
    };
  }
  
  public RGOperableNotificationModel(String paramString)
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
    this.mMainTitleColor = 0;
    this.mSubTitleColor = 0;
    this.mConfirmText = null;
    this.mCancelText = null;
    this.mConfirmColor = 0;
    this.mCancelColor = 0;
    this.mNotificationIcon = null;
    this.mNotificationColor = 0;
    this.mConfirmBackground = null;
    this.mCancelBackground = null;
    this.mOnBtnClickListener = null;
    this.mDisplayListener = null;
    this.mIconUrl = null;
    this.mIconOptions = null;
    this.mIconListener = null;
    this.mNotificationType = 0;
    this.mIsShowMasking = false;
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1000);
    }
    this.mHandler = null;
    this.mCountingSecs = 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGOperableNotificationModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */