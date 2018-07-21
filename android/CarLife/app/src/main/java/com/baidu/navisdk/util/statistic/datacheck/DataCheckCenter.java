package com.baidu.navisdk.util.statistic.datacheck;

import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataCheckCenter
{
  public static final boolean OPEN_RELEASE = false;
  public static final String TAG = DataCheckCenter.class.getSimpleName();
  private static DataCheckCenter sInstance = null;
  private static Object sSyncObj = new Object();
  private List<GeneralRegularData> mGeneralRegularDatas = new ArrayList();
  private boolean mIsInitOK = false;
  
  private GeneralRegularData getGeneralRegularData(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.mGeneralRegularDatas.size() == 0)) {
      return null;
    }
    int i = 0;
    while (i < this.mGeneralRegularDatas.size())
    {
      if (paramString.equals(((GeneralRegularData)this.mGeneralRegularDatas.get(i)).id)) {
        return (GeneralRegularData)this.mGeneralRegularDatas.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public static DataCheckCenter getInstance()
  {
    if (sInstance == null) {}
    synchronized (sSyncObj)
    {
      if (sInstance == null) {
        sInstance = new DataCheckCenter();
      }
      return sInstance;
    }
  }
  
  private void init()
  {
    DataCheckLogCenter.getInstance();
    this.mIsInitOK = loadRegular();
  }
  
  public static void log(String paramString)
  {
    LogUtil.e(TAG, paramString);
  }
  
  public static void toastTip(String paramString)
  {
    TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), paramString);
  }
  
  public boolean check(StatisitcsDataCheck paramStatisitcsDataCheck)
  {
    return false;
  }
  
  public boolean loadRegular()
  {
    this.mGeneralRegularDatas.clear();
    boolean bool = true;
    BufferedReader localBufferedReader;
    try
    {
      InputStream localInputStream = JarUtils.getResources().getAssets().open("datacheck.json");
      localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        GeneralRegularData localGeneralRegularData = new GeneralRegularData();
        bool &= localGeneralRegularData.loadRegular(str);
        this.mGeneralRegularDatas.add(localGeneralRegularData);
      }
      localException.close();
    }
    catch (Exception localException)
    {
      log("failed to load regular file.");
      return false;
    }
    localBufferedReader.close();
    log("success to load regular file.");
    return true;
  }
  
  public void uninit()
  {
    DataCheckLogCenter.getInstance().uninit();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/DataCheckCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */