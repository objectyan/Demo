package com.baidu.navi.protocol.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FavoriteDataInfo
{
  public static String KEY_FAVADDR;
  public static String KEY_FAVCITYID;
  public static String KEY_FAVCITYNAME;
  public static String KEY_FAVKEY = "favkey";
  public static String KEY_FAVNAME = "favname";
  public static String KEY_FAVPHONE;
  public static String KEY_FAVTIME;
  public static String KEY_LATITUDE = "favlatitude";
  public static String KEY_LONGTITUDE;
  public String mFavAddr;
  public int mFavCityId;
  public String mFavCityName;
  public String mFavKey;
  public String mFavName;
  public String mFavTime;
  public int mLatitude;
  public int mLongtitude;
  public String mPhone;
  
  static
  {
    KEY_FAVADDR = "favaddr";
    KEY_FAVPHONE = "favphone";
    KEY_FAVCITYNAME = "favcityname";
    KEY_FAVCITYID = "favcityid";
    KEY_FAVTIME = "favtime";
    KEY_LONGTITUDE = "favlongtitude";
  }
  
  public FavoriteDataInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, String paramString6, int paramInt2, int paramInt3)
  {
    this.mFavKey = paramString1;
    this.mFavName = paramString2;
    this.mFavAddr = paramString3;
    this.mPhone = paramString4;
    this.mFavCityName = paramString5;
    this.mFavCityId = paramInt1;
    this.mFavTime = paramString6;
    this.mLongtitude = paramInt2;
    this.mLatitude = paramInt3;
  }
  
  public static JSONArray toJsonArray(List<FavoriteDataInfo> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = null;
      return (JSONArray)localObject;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      localObject = localJSONArray;
      if (i >= paramList.size()) {
        break;
      }
      localJSONArray.put(toJsonObject((FavoriteDataInfo)paramList.get(i)));
      i += 1;
    }
  }
  
  public static JSONObject toJsonObject(FavoriteDataInfo paramFavoriteDataInfo)
  {
    if (paramFavoriteDataInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(KEY_FAVCITYNAME, paramFavoriteDataInfo.mFavCityName);
      localJSONObject.put(KEY_FAVNAME, paramFavoriteDataInfo.mFavName);
      localJSONObject.put(KEY_FAVADDR, paramFavoriteDataInfo.mFavAddr);
      localJSONObject.put(KEY_FAVCITYID, paramFavoriteDataInfo.mFavCityId);
      localJSONObject.put(KEY_FAVKEY, paramFavoriteDataInfo.mFavKey);
      localJSONObject.put(KEY_FAVPHONE, paramFavoriteDataInfo.mPhone);
      localJSONObject.put(KEY_FAVTIME, paramFavoriteDataInfo.mFavTime);
      localJSONObject.put(KEY_LATITUDE, paramFavoriteDataInfo.mLatitude);
      localJSONObject.put(KEY_LONGTITUDE, paramFavoriteDataInfo.mLongtitude);
      return localJSONObject;
    }
    catch (JSONException paramFavoriteDataInfo)
    {
      paramFavoriteDataInfo.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static FavoriteDataInfo valueOf(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      String str1 = paramJSONObject.getString(KEY_FAVCITYNAME);
      String str2 = paramJSONObject.getString(KEY_FAVNAME);
      String str3 = paramJSONObject.getString(KEY_FAVADDR);
      int i = paramJSONObject.getInt(KEY_FAVCITYID);
      paramJSONObject = new FavoriteDataInfo(paramJSONObject.getString(KEY_FAVKEY), str2, str3, paramJSONObject.getString(KEY_FAVPHONE), str1, i, paramJSONObject.getString(KEY_FAVTIME), paramJSONObject.getInt(KEY_LONGTITUDE), paramJSONObject.getInt(KEY_LATITUDE));
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static List<FavoriteDataInfo> valueOf(JSONArray paramJSONArray)
  {
    Object localObject;
    if (paramJSONArray == null)
    {
      localObject = null;
      return (List<FavoriteDataInfo>)localObject;
    }
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= paramJSONArray.length()) {
        break;
      }
      try
      {
        localArrayList.add(valueOf(paramJSONArray.getJSONObject(i)));
        i += 1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/FavoriteDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */