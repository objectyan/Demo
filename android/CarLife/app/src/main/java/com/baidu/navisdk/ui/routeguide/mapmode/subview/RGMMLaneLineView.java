package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RGMMLaneLineView
  extends BNBaseView
{
  public static final int SEPARATE_LINE_NUMBER = 9;
  private int containerId = 1711866434;
  private int layoutId = 1711472683;
  private ImageView mLaneLine1 = null;
  private ImageView mLaneLine2 = null;
  private ImageView mLaneLine3 = null;
  private ImageView mLaneLine4 = null;
  private ImageView mLaneLine5 = null;
  private ImageView mLaneLine6 = null;
  private ImageView mLaneLine7 = null;
  private ImageView mLaneLine8 = null;
  private ImageView mLaneLine9 = null;
  private ViewGroup mLaneLineContainer = null;
  private ArrayList<ImageView> mLaneLineList = new ArrayList();
  private View mLaneLineView = null;
  private ImageView mSeparate0 = null;
  private ImageView mSeparate1 = null;
  private ImageView mSeparate2 = null;
  private ImageView mSeparate3 = null;
  private ImageView mSeparate4 = null;
  private ImageView mSeparate5 = null;
  private ImageView mSeparate6 = null;
  private ImageView mSeparate7 = null;
  private ImageView mSeparate8 = null;
  private ImageView mSeparate9 = null;
  private ArrayList<ImageView> mSeparateList = new ArrayList();
  
  public RGMMLaneLineView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener, int paramInt)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews(paramInt);
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  private void initViews(int paramInt)
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    if (paramInt == 100) {
      this.containerId = 1711866546;
    }
    for (this.layoutId = 1711472683;; this.layoutId = 1711472683)
    {
      this.mLaneLineContainer = ((ViewGroup)this.mRootViewGroup.findViewById(this.containerId));
      if (this.mLaneLineContainer == null) {
        break;
      }
      this.mLaneLineContainer.removeAllViews();
      this.mLaneLineView = JarUtils.inflate((Activity)this.mContext, this.layoutId, null);
      if ((this.mLaneLineContainer == null) || (this.mLaneLineView == null)) {
        break;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      this.mLaneLineContainer.addView(this.mLaneLineView, localLayoutParams);
      this.mSeparate0 = ((ImageView)this.mLaneLineView.findViewById(1711866211));
      this.mSeparate1 = ((ImageView)this.mLaneLineView.findViewById(1711866213));
      this.mSeparate2 = ((ImageView)this.mLaneLineView.findViewById(1711866215));
      this.mSeparate3 = ((ImageView)this.mLaneLineView.findViewById(1711866217));
      this.mSeparate4 = ((ImageView)this.mLaneLineView.findViewById(1711866219));
      this.mSeparate5 = ((ImageView)this.mLaneLineView.findViewById(1711866221));
      this.mSeparate6 = ((ImageView)this.mLaneLineView.findViewById(1711866223));
      this.mSeparate7 = ((ImageView)this.mLaneLineView.findViewById(1711866225));
      this.mSeparate8 = ((ImageView)this.mLaneLineView.findViewById(1711866227));
      this.mSeparate9 = ((ImageView)this.mLaneLineView.findViewById(1711866229));
      this.mSeparateList.clear();
      this.mSeparateList.add(this.mSeparate0);
      this.mSeparateList.add(this.mSeparate1);
      this.mSeparateList.add(this.mSeparate2);
      this.mSeparateList.add(this.mSeparate3);
      this.mSeparateList.add(this.mSeparate4);
      this.mSeparateList.add(this.mSeparate5);
      this.mSeparateList.add(this.mSeparate6);
      this.mSeparateList.add(this.mSeparate7);
      this.mSeparateList.add(this.mSeparate8);
      this.mSeparateList.add(this.mSeparate9);
      this.mLaneLine1 = ((ImageView)this.mLaneLineView.findViewById(1711866212));
      this.mLaneLine2 = ((ImageView)this.mLaneLineView.findViewById(1711866214));
      this.mLaneLine3 = ((ImageView)this.mLaneLineView.findViewById(1711866216));
      this.mLaneLine4 = ((ImageView)this.mLaneLineView.findViewById(1711866218));
      this.mLaneLine5 = ((ImageView)this.mLaneLineView.findViewById(1711866220));
      this.mLaneLine6 = ((ImageView)this.mLaneLineView.findViewById(1711866222));
      this.mLaneLine7 = ((ImageView)this.mLaneLineView.findViewById(1711866224));
      this.mLaneLine8 = ((ImageView)this.mLaneLineView.findViewById(1711866226));
      this.mLaneLine9 = ((ImageView)this.mLaneLineView.findViewById(1711866228));
      this.mLaneLineList.clear();
      this.mLaneLineList.add(this.mLaneLine1);
      this.mLaneLineList.add(this.mLaneLine2);
      this.mLaneLineList.add(this.mLaneLine3);
      this.mLaneLineList.add(this.mLaneLine4);
      this.mLaneLineList.add(this.mLaneLine5);
      this.mLaneLineList.add(this.mLaneLine6);
      this.mLaneLineList.add(this.mLaneLine7);
      this.mLaneLineList.add(this.mLaneLine8);
      this.mLaneLineList.add(this.mLaneLine9);
      return;
      this.containerId = 1711866434;
    }
  }
  
  public int getVisibility()
  {
    int i = 8;
    if (this.mLaneLineContainer != null) {
      i = this.mLaneLineContainer.getVisibility();
    }
    return i;
  }
  
  public void hide()
  {
    super.hide();
    LogUtil.e(RGLaneInfoModel.TAG, "RGMMLaneLineView hide() ");
    if (this.mLaneLineContainer != null) {
      this.mLaneLineContainer.setVisibility(8);
    }
    if (this.mLaneLineView != null) {
      this.mLaneLineView.setVisibility(8);
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    super.orientationChanged(paramViewGroup, paramInt1);
    initViews(paramInt2);
    updateStyle(BNStyleManager.getDayStyle());
    if (RGLaneInfoModel.getModel(false).isShowLaneLineView())
    {
      LogUtil.e(RGLaneInfoModel.TAG, "onOrientationChanged RGLaneInfoModel");
      RGMapModeViewController.getInstance().handleLaneEnlargeShow(RGMapModeViewController.getInstance().isEnlargeOrColladaShow());
      RGMapModeViewController.getInstance().updateLaneLineImage(RGLaneInfoModel.getModel(false).mImalgeIdList);
      RGMapModeViewController.getInstance().updateEnlargeLaneLineImage(RGLaneInfoModel.getModel(false).mImalgeIdList);
      RGMapModeViewController.getInstance().requestShowExpendView(7, true, 2);
    }
  }
  
  public void show()
  {
    super.show();
    LogUtil.e(RGLaneInfoModel.TAG, "RGMMLaneLineView show() ");
    if (this.mLaneLineContainer != null) {
      this.mLaneLineContainer.setVisibility(0);
    }
    if (this.mLaneLineView != null) {
      this.mLaneLineView.setVisibility(0);
    }
  }
  
  public void updateImageView(ArrayList<Integer> paramArrayList)
  {
    int i = paramArrayList.size();
    int j = 0;
    for (;;)
    {
      if (j < i)
      {
        ImageView localImageView = (ImageView)this.mLaneLineList.get(j);
        localImageView.setVisibility(0);
        if (localImageView != null) {}
        try
        {
          localImageView.setBackgroundDrawable(BNStyleManager.getDrawable(((Integer)paramArrayList.get(j)).intValue()));
          j += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            LogUtil.e(RGLaneInfoModel.TAG, "e " + localException.getCause());
            localImageView.setVisibility(8);
          }
        }
      }
    }
    j = 0;
    for (;;)
    {
      RGLaneInfoModel.getModel(false);
      if (j > 9) {
        break;
      }
      ((ImageView)this.mSeparateList.get(j)).setVisibility(0);
      j += 1;
    }
    LogUtil.e(RGLaneInfoModel.TAG, this.layoutId + "lenght is " + i + "," + this.mLaneLineList.size() + "," + this.mSeparateList.size());
    if (9 - i > 0)
    {
      j = i;
      while (j < 9)
      {
        paramArrayList = (ImageView)this.mLaneLineList.get(j);
        if (paramArrayList != null) {
          paramArrayList.setVisibility(8);
        }
        j += 1;
      }
    }
    if (i >= 1)
    {
      paramArrayList = (ImageView)this.mSeparateList.get(0);
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
      while (i <= 9)
      {
        paramArrayList = (ImageView)this.mSeparateList.get(i);
        if (paramArrayList != null) {
          paramArrayList.setVisibility(8);
        }
        i += 1;
      }
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMLaneLineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */