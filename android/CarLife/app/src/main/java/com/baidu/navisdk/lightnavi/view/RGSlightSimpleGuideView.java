package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.lightnavi.model.BNIPOSimpleGuide;
import com.baidu.navisdk.lightnavi.utils.LightNaviCalculateUtils;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGSlightSimpleGuideView
  extends RGSlightBaseView
{
  private TextView mArriveTime;
  private TextView mArriveTimeLock;
  private ImageView mIVNextTurn;
  private TextView mOverSpeed;
  private BNIPOSimpleGuide mSimpleGuide;
  private SimpleGuideMassageUpdateBean mSimpleGuideMassageUpdateBean;
  private TextView mTVNextRoadDis;
  private TextView mTVNextRoadName;
  private TextView mTotalDis;
  private TextView mTotalDisLock;
  
  public RGSlightSimpleGuideView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    initView();
    initListener();
    this.mSimpleGuide = new BNIPOSimpleGuide();
  }
  
  public void initListener() {}
  
  public void initView()
  {
    this.mTotalDis = ((TextView)this.mRootViewGroup.findViewById(1711866189));
    this.mArriveTime = ((TextView)this.mRootViewGroup.findViewById(1711866188));
    this.mTVNextRoadDis = ((TextView)this.mRootViewGroup.findViewById(1711866184));
    this.mTVNextRoadName = ((TextView)this.mRootViewGroup.findViewById(1711866186));
    this.mOverSpeed = ((TextView)this.mRootViewGroup.findViewById(1711866187));
    this.mIVNextTurn = ((ImageView)this.mRootViewGroup.findViewById(1711866185));
    this.mTotalDisLock = ((TextView)this.mRootViewGroup.findViewById(1711866200));
    this.mArriveTimeLock = ((TextView)this.mRootViewGroup.findViewById(1711866199));
  }
  
  public void onUpdateSimpleGuide(Message paramMessage, boolean paramBoolean)
  {
    LogUtil.e("wangyang", "onUpdateSimpleGuide");
    if (paramBoolean) {}
    String str1;
    String str2;
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          paramMessage = (Bundle)paramMessage.obj;
        } while (paramMessage == null);
        str1 = paramMessage.getString("road_name");
      } while ((str1 == null) || (TextUtils.isEmpty(str1)));
      str2 = paramMessage.getString("icon_name");
      i = paramMessage.getInt("remain_dist");
      j = paramMessage.getInt("straightIcon");
      if (this.mSimpleGuideMassageUpdateBean == null) {
        this.mSimpleGuideMassageUpdateBean = new SimpleGuideMassageUpdateBean();
      }
    } while (this.mSimpleGuideMassageUpdateBean.isEqaul(str1, str2, j, i));
    this.mSimpleGuideMassageUpdateBean.mNextRoadName = str1;
    this.mSimpleGuideMassageUpdateBean.mTurnPng = str2;
    this.mSimpleGuideMassageUpdateBean.isStright = j;
    this.mSimpleGuideMassageUpdateBean.mNextRoadDis = i;
    if ((this.mTVNextRoadName != null) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      if (!str2.equals("turn_dest.png")) {
        break label278;
      }
      this.mTVNextRoadName.setText("到达" + str1 + " ");
    }
    for (;;)
    {
      if ((str2 != null) && (str2.length() > 0))
      {
        j = this.mSimpleGuide.getResIdByIconName(str2);
        if ((j > 0) && (this.mIVNextTurn != null)) {
          this.mIVNextTurn.setImageDrawable(JarUtils.getResources().getDrawable(j));
        }
      }
      if (this.mTVNextRoadDis == null) {
        break;
      }
      if (i >= 10) {
        break label354;
      }
      this.mTVNextRoadDis.setText("现在");
      return;
      label278:
      if (j == 1) {
        this.mTVNextRoadName.setText("沿" + str1 + " ");
      } else {
        this.mTVNextRoadName.setText("进入" + str1 + " ");
      }
    }
    label354:
    paramMessage = LightNaviCalculateUtils.calculateTotalRemainDistString(i);
    this.mTVNextRoadDis.setText(paramMessage + "后");
  }
  
  public void onUpdateSpeed(boolean paramBoolean, Message paramMessage)
  {
    if (paramBoolean)
    {
      LogUtil.e("wangyang", "onUpdateSpeed show");
      Bundle localBundle = (Bundle)paramMessage.obj;
      if (!localBundle.containsKey("description")) {}
      float f;
      int i;
      do
      {
        do
        {
          return;
        } while (BNavigator.getInstance().getLocDataCache() == null);
        f = BNavigator.getInstance().getLocDataCache().speed;
        i = paramMessage.arg2;
        paramMessage = null;
        if (localBundle != null) {
          paramMessage = localBundle.getString("description");
        }
        LogUtil.e("wangyang", "onUpdateSpeed=" + paramMessage + " cameraSpeed=" + i + " currentSpeed=" + f);
      } while ((3600.0F * f <= i) || (this.mOverSpeed == null) || (paramMessage == null));
      this.mOverSpeed.setText(paramMessage);
      this.mOverSpeed.setVisibility(0);
      return;
    }
    if (this.mOverSpeed != null) {
      this.mOverSpeed.setVisibility(8);
    }
    LogUtil.e("wangyang", "onUpdateSpeed hide ");
  }
  
  public void showBrightRemainTimeAndDis(int paramInt1, int paramInt2)
  {
    this.mTotalDis.setText(LightNaviCalculateUtils.calculateTotalRemainDistString(paramInt1));
    this.mArriveTime.setText(LightNaviCalculateUtils.calculateTotalRemainTimeString(paramInt2));
  }
  
  public void showOverSpeed(boolean paramBoolean)
  {
    if (this.mOverSpeed != null)
    {
      if (paramBoolean) {
        this.mOverSpeed.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mOverSpeed.setVisibility(8);
  }
  
  public void showRemainTimeAndDis(int paramInt1, int paramInt2)
  {
    this.mTotalDis.setText(LightNaviCalculateUtils.calculateTotalRemainDistString(paramInt1));
    this.mArriveTime.setText(LightNaviCalculateUtils.calculateTotalRemainTimeString(paramInt2));
    this.mTotalDisLock.setText(LightNaviCalculateUtils.calculateTotalRemainDistString(paramInt1));
    this.mArriveTimeLock.setText(LightNaviCalculateUtils.calculateTotalRemainTimeString(paramInt2));
  }
  
  public class SimpleGuideMassageUpdateBean
  {
    public int isStright = 0;
    public int mNextRoadDis = 0;
    public String mNextRoadName = "";
    public String mTurnPng = "";
    
    public SimpleGuideMassageUpdateBean() {}
    
    public boolean isEqaul(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      return (RGSlightSimpleGuideView.this.mSimpleGuideMassageUpdateBean.mNextRoadName.equals(paramString1)) && (RGSlightSimpleGuideView.this.mSimpleGuideMassageUpdateBean.mTurnPng.equals(paramString2)) && (RGSlightSimpleGuideView.this.mSimpleGuideMassageUpdateBean.isStright == paramInt1) && (RGSlightSimpleGuideView.this.mSimpleGuideMassageUpdateBean.mNextRoadDis == paramInt2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/view/RGSlightSimpleGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */