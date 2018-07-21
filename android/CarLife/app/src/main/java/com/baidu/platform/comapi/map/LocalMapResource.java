package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocalMapResource
{
  public Point center;
  public List<LocalMapResource> children;
  public int downloadProgress;
  public int downloadStatus;
  public int formatVersion;
  public int frc;
  public int id;
  public int level;
  public long mapoldsize;
  public long mappatchsize;
  public long mapsize;
  public String name;
  public boolean needUpdate;
  public String pinyin;
  public long remainSize;
  public long searcholdsize;
  public long searchpatchsize;
  public long searchsize;
  public int type;
  public int updateStatus;
  public int version;
  
  public static LocalMapResource fromJson(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = fromJson(new JSONObject(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static LocalMapResource fromJson(JSONObject paramJSONObject)
  {
    boolean bool = true;
    LocalMapResource localLocalMapResource1 = new LocalMapResource();
    localLocalMapResource1.id = paramJSONObject.optInt("id");
    localLocalMapResource1.name = paramJSONObject.optString("name");
    localLocalMapResource1.pinyin = paramJSONObject.optString("pinyin");
    localLocalMapResource1.frc = paramJSONObject.optInt("frc");
    localLocalMapResource1.type = paramJSONObject.optInt("cty");
    localLocalMapResource1.center = new Point(paramJSONObject.optInt("x"), paramJSONObject.optInt("y"));
    localLocalMapResource1.level = paramJSONObject.optInt("lev");
    localLocalMapResource1.mapsize = paramJSONObject.optLong("mapsize");
    localLocalMapResource1.mappatchsize = paramJSONObject.optLong("mappatchsize");
    localLocalMapResource1.searchsize = paramJSONObject.optLong("searchsize");
    localLocalMapResource1.searchpatchsize = paramJSONObject.optLong("searchpatchsize");
    localLocalMapResource1.mapoldsize = paramJSONObject.optLong("mapoldsize");
    localLocalMapResource1.searcholdsize = paramJSONObject.optLong("searcholdsize");
    localLocalMapResource1.downloadProgress = paramJSONObject.optInt("ratio");
    localLocalMapResource1.version = paramJSONObject.optInt("ver");
    localLocalMapResource1.formatVersion = paramJSONObject.optInt("fm");
    localLocalMapResource1.downloadStatus = paramJSONObject.optInt("status");
    if (paramJSONObject.optInt("up") == 1) {}
    Object localObject;
    LocalMapResource localLocalMapResource2;
    for (;;)
    {
      localLocalMapResource1.needUpdate = bool;
      localLocalMapResource1.updateStatus = paramJSONObject.optInt("note");
      if (!paramJSONObject.has("child")) {
        break;
      }
      localObject = paramJSONObject.optJSONArray("child");
      localLocalMapResource1.children = new ArrayList(((JSONArray)localObject).length() + 1);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localLocalMapResource2 = fromJson(((JSONArray)localObject).optJSONObject(i));
        localLocalMapResource1.children.add(localLocalMapResource2);
        i += 1;
      }
      bool = false;
    }
    if ((localLocalMapResource1.children != null) && (localLocalMapResource1.children.size() > 0))
    {
      localObject = new LocalMapResource();
      ((LocalMapResource)localObject).id = localLocalMapResource1.id;
      ((LocalMapResource)localObject).name = "所有城市";
      ((LocalMapResource)localObject).pinyin = localLocalMapResource1.pinyin;
      ((LocalMapResource)localObject).version = localLocalMapResource1.version;
      ((LocalMapResource)localObject).formatVersion = paramJSONObject.optInt("fm");
      ((LocalMapResource)localObject).type = localLocalMapResource1.type;
      ((LocalMapResource)localObject).center = new Point(localLocalMapResource1.center.getIntX(), localLocalMapResource1.center.getIntY());
      ((LocalMapResource)localObject).level = localLocalMapResource1.level;
      ((LocalMapResource)localObject).mapsize = 0L;
      ((LocalMapResource)localObject).searchsize = 0L;
      ((LocalMapResource)localObject).downloadProgress = 0;
      ((LocalMapResource)localObject).needUpdate = localLocalMapResource1.needUpdate;
      ((LocalMapResource)localObject).updateStatus = localLocalMapResource1.updateStatus;
      ((LocalMapResource)localObject).downloadStatus = localLocalMapResource1.downloadStatus;
      paramJSONObject = localLocalMapResource1.children.iterator();
      while (paramJSONObject.hasNext())
      {
        localLocalMapResource2 = (LocalMapResource)paramJSONObject.next();
        ((LocalMapResource)localObject).mapsize += localLocalMapResource2.mapsize;
        ((LocalMapResource)localObject).searchsize += localLocalMapResource2.searchsize;
      }
      localLocalMapResource1.mapsize = ((LocalMapResource)localObject).mapsize;
      localLocalMapResource1.searchsize = ((LocalMapResource)localObject).searchsize;
      localLocalMapResource1.children.add(0, localObject);
    }
    return localLocalMapResource1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/LocalMapResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */