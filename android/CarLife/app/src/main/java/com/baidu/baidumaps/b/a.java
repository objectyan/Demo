package com.baidu.baidumaps.b;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapframework.common.mapview.MapInfo;
import com.baidu.mapframework.common.mapview.MapInfoProvider;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.basestruct.Point;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static final String a = "baidu_lauch";
  public static final String b = "launch_mode";
  public static final String c = "(\\?|&+)(.+?)=([^&]*)";
  private static final String d = "com.baidu.baidumaps.action.ENTRY";
  
  public static Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.baidu.baidumaps.action.ENTRY");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  public static Intent a(Class paramClass, a parama, Bundle paramBundle)
  {
    paramClass = Uri.parse("baidu_lauch://" + paramClass.getName() + "?" + "launch_mode" + "=" + parama.toString());
    parama = new Intent();
    parama.setData(paramClass);
    if (paramBundle != null) {
      parama.putExtras(paramBundle);
    }
    return parama;
  }
  
  public static MapBound a(Point paramPoint, int paramInt)
  {
    MapBound localMapBound = new MapBound();
    Point localPoint1 = new Point();
    Point localPoint2 = new Point();
    localPoint1.setIntX(paramPoint.getIntX() - paramInt);
    localPoint1.setIntY(paramPoint.getIntY() - paramInt);
    localPoint2.setIntX(paramPoint.getIntX() + paramInt);
    localPoint2.setIntY(paramPoint.getIntY() + paramInt);
    localMapBound.setLeftBottomPt(localPoint1);
    localMapBound.setRightTopPt(localPoint2);
    return localMapBound;
  }
  
  public static Map<String, String> a(String paramString)
  {
    return a(paramString, false);
  }
  
  public static Map<String, String> a(String paramString, boolean paramBoolean)
  {
    paramString = Pattern.compile("(\\?|&+)(.+?)=([^&]*)").matcher(paramString);
    HashMap localHashMap = new HashMap();
    while (paramString.find()) {
      if (paramBoolean) {
        localHashMap.put(paramString.group(2), e(paramString.group(3)));
      } else {
        localHashMap.put(paramString.group(2), paramString.group(3));
      }
    }
    return localHashMap;
  }
  
  public static void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramBundle.putString(paramString1, paramString2);
    }
  }
  
  public static boolean a(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.isAbsolute()) && (paramUri.isHierarchical()) && (paramUri.getHost() != null) && (paramUri.getPath() != null);
  }
  
  private static boolean a(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.getIntX() > paramPoint2.getIntX()) || (paramPoint1.getIntY() > paramPoint2.getIntY()) || (paramPoint1.getIntX() < 0) || (paramPoint1.getIntY() < 0) || (paramPoint2.getIntX() < 0) || (paramPoint2.getIntY() < 0);
  }
  
  public static int b()
  {
    return (int)MapInfoProvider.getMapInfo().getMapLevel();
  }
  
  public static Bundle b(String paramString)
  {
    paramString = Pattern.compile("(\\?|&+)(.+?)=([^&]*)").matcher(paramString);
    Bundle localBundle = new Bundle();
    while (paramString.find()) {
      localBundle.putString(paramString.group(2), paramString.group(3));
    }
    return localBundle;
  }
  
  public static String c(String paramString)
  {
    try
    {
      paramString = Pattern.compile("(\\?|&+)(.+?)=([^&]*)").matcher(paramString);
      localJSONObject = new JSONObject();
      try
      {
        while (paramString.find())
        {
          localJSONObject.put(paramString.group(2), paramString.group(3));
          continue;
          return "";
        }
      }
      catch (JSONException paramString) {}
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      for (;;) {}
    }
    if (localJSONObject != null) {
      return localJSONObject.toString();
    }
    return "";
  }
  
  public static boolean c()
  {
    return LocationManager.getInstance().isLocationValid();
  }
  
  public static Point d()
  {
    Point localPoint = new Point(0.0D, 0.0D);
    if (LocationManager.getInstance().isLocationValid())
    {
      localPoint.setIntX((int)LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09).longitude);
      localPoint.setIntY((int)LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09).latitude);
    }
    return localPoint;
  }
  
  public static String d(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  public static String e(String paramString)
  {
    while (paramString.contains("%")) {
      paramString = Uri.decode(paramString);
    }
    return paramString;
  }
  
  public static a f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals(a.b.toString())) {
        return a.b;
      }
      if (paramString.equals(a.d.toString())) {
        return a.d;
      }
      if (paramString.equals(a.a.toString())) {
        return a.a;
      }
      if (paramString.equals(a.c.toString())) {
        return a.c;
      }
      return a.a;
    }
    return a.a;
  }
  
  public static enum a
  {
    private final String f;
    
    private a(String paramString)
    {
      this.f = paramString;
    }
    
    public String toString()
    {
      return this.f;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */