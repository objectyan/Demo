package com.baidu.navi.protocol;

import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.pack.BasePacker;
import com.baidu.navi.protocol.pack.PackerFactory;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class BNaviProtocol
{
  private static BNaviProtocol instance;
  
  public static BNaviProtocol getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new BNaviProtocol();
      }
      return instance;
    }
    finally {}
  }
  
  public static int getVersion()
  {
    return 2;
  }
  
  public String pack(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramDataStruct.mCmd))
      {
        BasePacker localBasePacker = PackerFactory.getPacker(paramDataStruct.mCmd);
        localObject1 = localObject2;
        if (localBasePacker != null) {
          localObject1 = localBasePacker.pack(paramDataStruct);
        }
      }
    }
    return (String)localObject1;
  }
  
  public String packResult(DataStruct paramDataStruct)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataStruct != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramDataStruct.mCmd))
      {
        BasePacker localBasePacker = PackerFactory.getPacker(paramDataStruct.mCmd);
        localObject1 = localObject2;
        if (localBasePacker != null) {
          localObject1 = localBasePacker.packResult(paramDataStruct);
        }
      }
    }
    return (String)localObject1;
  }
  
  public void setModuleName(String paramString)
  {
    com.baidu.navi.protocol.util.BNaviProtocolDef.moduleName = paramString;
  }
  
  public DataStruct unpack(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      BasePacker localBasePacker = PackerFactory.getPacker(PackerUtil.getCommand(paramString));
      localObject1 = localObject2;
      if (localBasePacker != null) {
        localObject1 = localBasePacker.unpack(paramString);
      }
      return (DataStruct)localObject1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/BNaviProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */