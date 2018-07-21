package com.baidu.navisdk.module.ugc.data.datarepository;

import android.graphics.drawable.Drawable;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class UgcNaviDynamicMarkRespository
{
  private static UgcNaviDynamicMarkRespository instance = null;
  public boolean gotoSupDetailPageFlag = false;
  private ArrayList<NaviDynamicMark> list = null;
  private OnTapListener mOnTapListener = null;
  private ArrayList<NaviDynamicMark> upLoadingList = null;
  
  public static UgcNaviDynamicMarkRespository getInstance()
  {
    if (instance == null) {
      instance = new UgcNaviDynamicMarkRespository();
    }
    return instance;
  }
  
  public void addUgcReportInfoUploadPackage(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage)
  {
    if ((paramUgcReportInfoUploadPackage == null) || (paramUgcReportInfoUploadPackage.id == -1) || (paramUgcReportInfoUploadPackage.userPoint == null)) {}
    for (;;)
    {
      return;
      NaviDynamicMark localNaviDynamicMark = new NaviDynamicMark();
      int i = paramUgcReportInfoUploadPackage.userPoint.indexOf(",");
      if ((i <= 0) || (i >= paramUgcReportInfoUploadPackage.userPoint.length() - 1)) {
        continue;
      }
      String str1 = paramUgcReportInfoUploadPackage.userPoint.substring(0, i);
      String str2 = paramUgcReportInfoUploadPackage.userPoint.substring(i + 1, paramUgcReportInfoUploadPackage.userPoint.length());
      try
      {
        localNaviDynamicMark.x = Double.parseDouble(str1);
        localNaviDynamicMark.y = Double.parseDouble(str2);
        localNaviDynamicMark.id = paramUgcReportInfoUploadPackage.id;
        localNaviDynamicMark.type = paramUgcReportInfoUploadPackage.parentType;
        localNaviDynamicMark.mGeoPoint = paramUgcReportInfoUploadPackage.mGeoPoint;
        paramUgcReportInfoUploadPackage = BNStyleManager.getDrawable(UgcDataProvider.getDrawableIdByType(paramUgcReportInfoUploadPackage.parentType));
        if (paramUgcReportInfoUploadPackage == null) {
          continue;
        }
        localNaviDynamicMark.drawable = paramUgcReportInfoUploadPackage;
        if (this.list == null) {
          this.list = new ArrayList();
        }
        this.list.add(localNaviDynamicMark);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public void addUploadingDynamicMark(NaviDynamicMark paramNaviDynamicMark)
  {
    if (this.upLoadingList == null) {
      this.upLoadingList = new ArrayList();
    }
    if (paramNaviDynamicMark != null) {
      this.upLoadingList.add(paramNaviDynamicMark);
    }
  }
  
  public void clear()
  {
    if (this.list != null)
    {
      this.list.clear();
      this.list = null;
    }
    if (this.upLoadingList != null)
    {
      this.upLoadingList.clear();
      this.upLoadingList = null;
    }
  }
  
  public boolean containLoadingId(int paramInt)
  {
    if (this.upLoadingList != null)
    {
      int i = 0;
      while (i < this.upLoadingList.size())
      {
        if (((NaviDynamicMark)this.upLoadingList.get(i)).id == paramInt) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public ArrayList<NaviDynamicMark> getInfoPackageList()
  {
    return this.list;
  }
  
  public NaviDynamicMark getNaviDynamicMarkById(int paramInt)
  {
    if (this.list != null)
    {
      int i = 0;
      while (i < this.list.size())
      {
        if (((NaviDynamicMark)this.list.get(i)).id == paramInt) {
          return (NaviDynamicMark)this.list.get(i);
        }
        i += 1;
      }
    }
    return null;
  }
  
  public int getNaviDynamicMarkCounts()
  {
    if (this.list != null) {
      return this.list.size();
    }
    return 0;
  }
  
  public OnTapListener getOnTapListener()
  {
    return this.mOnTapListener;
  }
  
  public boolean hasContainUgcDynamicMark()
  {
    return (this.list != null) && (this.list.size() > 0);
  }
  
  public void removeId(int paramInt)
  {
    NaviDynamicMark localNaviDynamicMark = getNaviDynamicMarkById(paramInt);
    if (localNaviDynamicMark != null) {
      this.list.remove(localNaviDynamicMark);
    }
  }
  
  public void removeUploadingId(int paramInt)
  {
    if (this.upLoadingList != null)
    {
      int i = 0;
      while (i < this.upLoadingList.size())
      {
        if (((NaviDynamicMark)this.upLoadingList.get(i)).id == paramInt) {
          this.upLoadingList.remove(i);
        }
        i += 1;
      }
    }
  }
  
  public void setOnTapListener(OnTapListener paramOnTapListener)
  {
    this.mOnTapListener = paramOnTapListener;
  }
  
  public static class NaviDynamicMark
  {
    public Drawable drawable;
    public int id;
    public GeoPoint mGeoPoint;
    public int type;
    public double x;
    public double y;
  }
  
  public static abstract interface OnTapListener
  {
    public abstract void onTap(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/data/datarepository/UgcNaviDynamicMarkRespository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */