package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class RGRouteSortController
{
  private static final String TAG = RGRouteSortController.class.getSimpleName();
  private static RGRouteSortController sInstance = null;
  public boolean mIsRouteSortOpen = true;
  public boolean mIsShowDefaultSettingBtn = false;
  private NavRouteSortListener mListener = null;
  private int mPreferValue = 0;
  private ArrayList<RGRouteSortModel> mRouteSortList = null;
  
  public static RGRouteSortController getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new RGRouteSortController();
      }
      return sInstance;
    }
    finally {}
  }
  
  private boolean hasSelectedPrefer()
  {
    if ((this.mRouteSortList == null) || (this.mRouteSortList.isEmpty())) {
      return false;
    }
    int i = 0;
    label21:
    RGRouteSortModel localRGRouteSortModel;
    if (i < this.mRouteSortList.size())
    {
      localRGRouteSortModel = (RGRouteSortModel)this.mRouteSortList.get(i);
      if (localRGRouteSortModel != null) {
        break label55;
      }
    }
    label55:
    while ((localRGRouteSortModel.mPreferValue & BNaviModuleManager.getLastPreferValue()) == 0)
    {
      i += 1;
      break label21;
      break;
    }
    return true;
  }
  
  private void initRouteSortList()
  {
    this.mRouteSortList = new ArrayList();
    this.mRouteSortList.add(new RGRouteSortModel("智能推荐", 1));
    this.mRouteSortList.add(new RGRouteSortModel("时间优先", 256));
    this.mRouteSortList.add(new RGRouteSortModel("距离优先", 128));
    this.mRouteSortList.add(new RGRouteSortModel("躲避拥堵", 16));
    this.mRouteSortList.add(new RGRouteSortModel("收费较少", 8));
    this.mRouteSortList.add(new RGRouteSortModel("大路优先", 512));
  }
  
  public void checkCloudConfig()
  {
    if (!hasSelectedPrefer())
    {
      if ((BNaviModuleManager.getLastPreferValue() & 0x20) != 0)
      {
        BNaviModuleManager.setLastPreferValue(33);
        setPreferValue(33);
      }
    }
    else {
      return;
    }
    BNaviModuleManager.setLastPreferValue(1);
    setPreferValue(1);
  }
  
  public String getCurrentRouteSortName()
  {
    ArrayList localArrayList = getInstance().getRouteSortList();
    if (localArrayList != null)
    {
      int i = 0;
      if (i < localArrayList.size())
      {
        RGRouteSortModel localRGRouteSortModel = (RGRouteSortModel)localArrayList.get(i);
        if (localRGRouteSortModel == null) {}
        while ((localRGRouteSortModel.mPreferValue & getInstance().getPreferValue()) == 0)
        {
          i += 1;
          break;
        }
        return localRGRouteSortModel.mItemName;
      }
    }
    return "";
  }
  
  public int getPreferValue()
  {
    return this.mPreferValue;
  }
  
  public ArrayList<RGRouteSortModel> getRouteSortList()
  {
    if (this.mRouteSortList == null) {
      initRouteSortList();
    }
    return this.mRouteSortList;
  }
  
  public int getmPreferIconId(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      if (!paramBoolean) {
        break;
      }
    case 1: 
      do
      {
        return 1711407830;
      } while (paramBoolean);
      return 1711407828;
    case 256: 
      if (paramBoolean) {
        return 1711407847;
      }
      return 1711407845;
    case 128: 
      if (paramBoolean) {
        return 1711407834;
      }
      return 1711407832;
    case 16: 
      if (paramBoolean) {
        return 1711407826;
      }
      return 1711407824;
    case 8: 
      if (paramBoolean) {
        return 1711407841;
      }
      return 1711407839;
    case 512: 
      if (paramBoolean) {
        return 1711407844;
      }
      return 1711407842;
    }
    return 1711407828;
  }
  
  public int mappingPreferValue(int paramInt)
  {
    LogUtil.e(TAG, "mappingPreferValue oldPrefer = " + paramInt);
    int i = paramInt;
    int j = i;
    if ((paramInt & 0x20) != 0) {
      j = i ^ 0x20;
    }
    if (j == 2) {
      i = 512;
    }
    for (;;)
    {
      j = i;
      if ((paramInt & 0x20) != 0) {
        j = i | 0x20;
      }
      paramInt = j;
      if (j == 0)
      {
        LogUtil.e(TAG, "mappingPreferValue newPrefer is invalid and mapping it to default value");
        paramInt = 1;
      }
      LogUtil.e(TAG, "mappingPreferValue newPrefer = " + paramInt);
      return paramInt;
      if ((j == 4) || (j == 8))
      {
        i = 8;
      }
      else if (j == 18)
      {
        i = 512;
      }
      else if (j == 20)
      {
        i = 8;
      }
      else if (j == 24)
      {
        i = 8;
      }
      else if (j == 12)
      {
        i = 8;
      }
      else
      {
        i = j;
        if (j == 28) {
          i = 8;
        }
      }
    }
  }
  
  public void onClickItemAction(boolean paramBoolean)
  {
    if (this.mListener != null) {
      this.mListener.onClickItemAction(paramBoolean);
    }
  }
  
  public void onCloseAction()
  {
    if (this.mListener != null) {
      this.mListener.onCloseAction();
    }
  }
  
  public void onSettingDefaultAction()
  {
    if (this.mListener != null) {
      this.mListener.onSettingDefaultAction();
    }
  }
  
  public boolean parseCloudJson(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("road_sort");
      if (paramJSONObject == null) {
        return false;
      }
      if (paramJSONObject.getInt("open") == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.mIsRouteSortOpen = bool1;
        paramJSONObject = paramJSONObject.getJSONArray("labels");
        bool1 = bool2;
        if (paramJSONObject == null) {
          return bool1;
        }
        bool1 = bool2;
        if (paramJSONObject.length() == 0) {
          return bool1;
        }
        this.mRouteSortList = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          this.mRouteSortList.add(new RGRouteSortModel(localJSONObject.getString("label"), localJSONObject.getInt("tag")));
          i += 1;
        }
      }
      bool1 = true;
    }
    catch (Exception paramJSONObject)
    {
      this.mRouteSortList = null;
      return false;
    }
    return bool1;
  }
  
  public void setPreferValue(int paramInt)
  {
    this.mPreferValue = paramInt;
  }
  
  public void setRouteSortListener(NavRouteSortListener paramNavRouteSortListener)
  {
    this.mListener = paramNavRouteSortListener;
  }
  
  public void uninit()
  {
    this.mIsShowDefaultSettingBtn = false;
  }
  
  public static abstract interface NavRouteSortListener
  {
    public abstract void onClickItemAction(boolean paramBoolean);
    
    public abstract void onCloseAction();
    
    public abstract void onSettingDefaultAction();
  }
  
  public static class PageConstant
  {
    public static final int INVALID = 0;
    public static final int NAVIGATION_PAGE = 2;
    public static final int ROUTE_RESULT_DETAIL_PAGE = 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/control/RGRouteSortController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */