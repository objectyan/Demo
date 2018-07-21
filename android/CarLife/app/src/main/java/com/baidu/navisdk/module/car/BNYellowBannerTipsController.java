package com.baidu.navisdk.module.car;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions.Builder;
import com.baidu.navisdk.util.navimageloader.BNImageLoader;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;
import java.util.ArrayList;

public class BNYellowBannerTipsController
{
  public static final int MAX_LOCAL_POSITION = 256;
  private static final String OFFLINE_DATA_TIPS = "offline.data.tips";
  public static final int POSITION_BAD_WEATER = 259;
  public static final int POSITION_NAVI_LIGHT = 258;
  public static final int POSITION_NO_NET = 257;
  public static final int POSITION_PASS_AREAT = 261;
  public static final int POSITION_SERVIER_AREA = 260;
  private static final int SHOW_TIME = 10;
  private static BNYellowBannerTipsController instance;
  ArrayList<Integer> PriorityList = null;
  
  private BNYellowBannerTipsModel.TipsType[] clonTipsTypeList(ArrayList<BNYellowBannerTipsModel.TipsType> paramArrayList)
  {
    Object localObject;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      localObject = null;
    }
    for (;;)
    {
      return (BNYellowBannerTipsModel.TipsType[])localObject;
      try
      {
        BNYellowBannerTipsModel.TipsType[] arrayOfTipsType = new BNYellowBannerTipsModel.TipsType[paramArrayList.size()];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfTipsType;
          if (i >= paramArrayList.size()) {
            break;
          }
          arrayOfTipsType[i] = ((BNYellowBannerTipsModel.TipsType)paramArrayList.get(i));
          i += 1;
        }
        return null;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
  }
  
  private boolean compareTo(BNYellowBannerTipsModel.TipsType paramTipsType1, BNYellowBannerTipsModel.TipsType paramTipsType2)
  {
    if ((paramTipsType1 == null) || (paramTipsType2 == null)) {}
    while (paramTipsType1.priority >= paramTipsType2.priority) {
      return true;
    }
    return false;
  }
  
  public static BNYellowBannerTipsController getInstance()
  {
    if (instance == null) {
      instance = new BNYellowBannerTipsController();
    }
    return instance;
  }
  
  private void initPriorityList()
  {
    BNYellowBannerTipsModel.TipsType[] arrayOfTipsType = clonTipsTypeList(BNYellowBannerTipsModel.getInstance().TipsTypeList);
    int i;
    if (arrayOfTipsType != null)
    {
      i = 0;
      while (i < arrayOfTipsType.length)
      {
        int j = i + 1;
        while (j < arrayOfTipsType.length)
        {
          if (compareTo(arrayOfTipsType[i], arrayOfTipsType[j]))
          {
            BNYellowBannerTipsModel.TipsType localTipsType = arrayOfTipsType[i];
            arrayOfTipsType[i] = arrayOfTipsType[j];
            arrayOfTipsType[j] = localTipsType;
          }
          j += 1;
        }
        i += 1;
      }
    }
    this.PriorityList = new ArrayList();
    if (arrayOfTipsType != null)
    {
      i = 0;
      while (i < arrayOfTipsType.length)
      {
        this.PriorityList.add(Integer.valueOf(arrayOfTipsType[i].type));
        i += 1;
      }
    }
  }
  
  public String getBackground(int paramInt)
  {
    if (BNYellowBannerTipsModel.getInstance().bgcolors == null) {
      BNYellowBannerTipsModel.getInstance().initBackGroundColor();
    }
    try
    {
      if ((BNYellowBannerTipsModel.getInstance().bgcolors.length <= paramInt) || (paramInt < 0))
      {
        String str = BNYellowBannerTipsModel.getInstance().bgcolors[0];
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    return BNYellowBannerTipsModel.getInstance().bgcolors[paramInt];
  }
  
  public int getPriorityPosistion(ArrayList<Integer> paramArrayList)
  {
    if ((this.PriorityList == null) || (this.PriorityList.size() <= 0)) {
      initPriorityList();
    }
    if ((this.PriorityList == null) || (paramArrayList == null)) {
      j = -1;
    }
    int i;
    int k;
    do
    {
      do
      {
        return j;
        i = -1;
        k = 0;
        j = i;
      } while (k >= this.PriorityList.size());
      j = i;
    } while (i != -1);
    int j = paramArrayList.size() - 1;
    for (;;)
    {
      int m = i;
      if (j >= 0)
      {
        if (((Integer)paramArrayList.get(j)).intValue() == ((Integer)this.PriorityList.get(k)).intValue()) {
          m = j;
        }
      }
      else
      {
        k += 1;
        i = m;
        break;
      }
      j -= 1;
    }
  }
  
  public int getShowTime()
  {
    if (BNYellowBannerTipsModel.getInstance().expireTime > 0) {
      return BNYellowBannerTipsModel.getInstance().expireTime;
    }
    return 10;
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {}
    int i;
    int j;
    do
    {
      return;
      if (paramInt <= 0) {
        paramImageView.setVisibility(8);
      }
      if (paramInt >= 256)
      {
        switch (paramInt)
        {
        case 259: 
        default: 
          paramImageView.setVisibility(8);
          return;
        case 258: 
          paramImageView.setImageDrawable(BNStyleManager.getDrawable(1711408173));
          return;
        }
        paramImageView.setImageDrawable(BNStyleManager.getDrawable(1711408167));
        return;
      }
      i = 0;
      j = 0;
      if ((BNYellowBannerTipsModel.getInstance().icons == null) || (BNYellowBannerTipsModel.getInstance().icons.length <= paramInt) || (BNYellowBannerTipsModel.getInstance().icons[paramInt] == null)) {
        i = 1;
      }
      if ((BNYellowBannerTipsModel.getInstance().iconsId == null) || (BNYellowBannerTipsModel.getInstance().iconsId.length <= paramInt)) {
        j = 1;
      }
      if ((i != 0) && (j != 0))
      {
        paramImageView.setVisibility(8);
        return;
      }
      if ((i != 0) && (j == 0))
      {
        paramImageView.setImageDrawable(BNStyleManager.getDrawable(BNYellowBannerTipsModel.getInstance().iconsId[paramInt]));
        return;
      }
      if ((i == 0) && (j != 0)) {
        BNImageLoader.getInstance().displayImage(BNYellowBannerTipsModel.getInstance().icons[paramInt], paramImageView, null, new BNImageLoadingListener()
        {
          public void onLoadingComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, int paramAnonymousInt) {}
          
          public void onLoadingFailed(String paramAnonymousString1, View paramAnonymousView, String paramAnonymousString2)
          {
            paramAnonymousView.setVisibility(8);
          }
          
          public void onLoadingStarted(String paramAnonymousString, View paramAnonymousView) {}
        });
      }
    } while ((i != 0) || (j != 0));
    BNDisplayImageOptions localBNDisplayImageOptions = new BNDisplayImageOptions.Builder().showImageOnLoading(BNYellowBannerTipsModel.getInstance().iconsId[paramInt]).build();
    BNImageLoader.getInstance().displayImage(BNYellowBannerTipsModel.getInstance().icons[paramInt], paramImageView, localBNDisplayImageOptions, null);
  }
  
  public void setOfflineDataTipsFlag(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    PreferenceHelper.getInstance(paramContext).putBoolean("offline.data.tips", paramBoolean);
  }
  
  public boolean shouldShowOfflineDataTips(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (!PreferenceHelper.getInstance(paramContext).contains("offline.data.tips")) {
      PreferenceHelper.getInstance(paramContext).putBoolean("offline.data.tips", BNOfflineDataManager.getInstance().hasContainOfflineData());
    }
    return PreferenceHelper.getInstance(paramContext).getBoolean("offline.data.tips", false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/car/BNYellowBannerTipsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */