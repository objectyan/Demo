package com.baidu.navisdk.model.modelfactory;

import java.util.HashMap;
import java.util.Map;

public class NaviDataEngine
{
  private static Map<String, BaseModel> mModelList = new HashMap();
  private static volatile NaviDataEngine me = null;
  
  public NaviDataEngine()
  {
    mModelList.clear();
  }
  
  private void createModel(String paramString)
  {
    BaseModel localBaseModel = instanceModel(paramString);
    mModelList.put(paramString, localBaseModel);
  }
  
  public static NaviDataEngine getInstance()
  {
    if (me == null) {}
    try
    {
      if (me == null) {
        me = new NaviDataEngine();
      }
      return me;
    }
    finally {}
  }
  
  private BaseModel instanceModel(String paramString)
  {
    OfflineDataModel localOfflineDataModel = null;
    if ("OfflineDataModel".equals(paramString)) {
      localOfflineDataModel = new OfflineDataModel();
    }
    do
    {
      return localOfflineDataModel;
      if ("PoiSearchModel".equals(paramString)) {
        return new PoiSearchModel();
      }
    } while (!"RoutePlanModel".equals(paramString));
    return new RoutePlanModel();
  }
  
  public BaseModel getModel(String paramString)
  {
    if (mModelList == null) {
      mModelList = new HashMap();
    }
    BaseModel localBaseModel = (BaseModel)mModelList.get(paramString);
    if (localBaseModel == null)
    {
      createModel(paramString);
      return (BaseModel)mModelList.get(paramString);
    }
    return localBaseModel;
  }
  
  public void removeModel(String paramString)
  {
    if ((mModelList != null) && (mModelList.get(paramString) != null)) {
      mModelList.remove(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/modelfactory/NaviDataEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */