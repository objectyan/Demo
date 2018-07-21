package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.DynamicHeaderMessage;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.google.protobuf.micro.ByteStringMicro;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiDynamicMapOverlay
  extends InnerOverlay
{
  public static final int PB_LENGTH_SIGN = 32;
  private byte[] extData;
  private boolean isAccShow = false;
  private boolean isAddContent = false;
  private float level;
  private List<PoiResult> poiResultList;
  private String qid = null;
  private int scene;
  private boolean shouldClear = false;
  private boolean shouldDel = false;
  private boolean showAd;
  private String uid = null;
  private double x;
  private double y;
  
  public PoiDynamicMapOverlay()
  {
    super(37);
  }
  
  public PoiDynamicMapOverlay(AppBaseMap paramAppBaseMap)
  {
    super(37, paramAppBaseMap);
  }
  
  private String generateClearJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scene", this.scene);
      localJSONObject.put("rs_add", 0);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  private String generateDelJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ud", this.uid);
      localJSONObject.put("scene", this.scene);
      localJSONObject.put("rs_rev", 1);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  private String generateJson()
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("ud", this.uid);
        localJSONObject.put("scene", this.scene);
        if (!this.showAd) {
          continue;
        }
        i = 1;
        localJSONObject.put("show_ad", i);
        localJSONObject.put("qid", this.qid);
        localJSONObject.put("level", this.level);
        localJSONObject.put("x", this.x);
        localJSONObject.put("y", this.y);
        if (!this.isAddContent) {
          continue;
        }
        this.isAddContent = false;
        localJSONObject.put("rs_add", 1);
        if (!this.isAccShow) {
          continue;
        }
        i = j;
      }
      catch (JSONException localJSONException)
      {
        continue;
        int i = 0;
        continue;
      }
      localJSONObject.put("show_force", i);
      return localJSONObject.toString();
      i = 0;
      continue;
      localJSONObject.put("rs_add", 0);
    }
  }
  
  private byte[] getExtData(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length >= 32) {
        break label25;
      }
      arrayOfByte1 = arrayOfByte2;
    }
    label25:
    int j;
    int k;
    int m;
    int n;
    do
    {
      return arrayOfByte1;
      i = paramArrayOfByte[0];
      j = paramArrayOfByte[1];
      k = paramArrayOfByte[2];
      m = paramArrayOfByte[3];
      n = paramArrayOfByte.length;
      arrayOfByte1 = arrayOfByte2;
    } while (((i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF) != n - 32);
    arrayOfByte2 = new byte[n - 32];
    int i = 0;
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (i >= arrayOfByte2.length) {
        break;
      }
      arrayOfByte2[i] = paramArrayOfByte[(i + 32)];
      i += 1;
    }
  }
  
  public void clear()
  {
    super.clear();
  }
  
  public String getData()
  {
    if (this.shouldClear)
    {
      this.shouldClear = false;
      return generateClearJson();
    }
    if (((this.extData == null) || (this.poiResultList == null)) && (this.shouldDel))
    {
      this.shouldDel = false;
      return generateDelJson();
    }
    if (((this.poiResultList != null) && (this.poiResultList.size() > 0)) || ((this.extData != null) && (this.extData.length > 0))) {
      return generateJson();
    }
    return "";
  }
  
  public String getLayerTag()
  {
    return "dynamicmap";
  }
  
  public Bundle getParam()
  {
    Bundle localBundle1 = new Bundle();
    if ((this.poiResultList != null) && (this.poiResultList.size() > 0))
    {
      localObject = new ArrayList();
      i = 0;
      while ((i < this.poiResultList.size()) && (i < 1))
      {
        localBundle2 = new Bundle();
        if (((PoiResult)this.poiResultList.get(i)).hasImgeExt()) {
          arrayOfByte = ((PoiResult)this.poiResultList.get(i)).getImgeExt().toByteArray();
        }
        try
        {
          arrayOfByte = getExtData(DynamicHeaderMessage.parseFrom(arrayOfByte).getDynamicPbRes().toByteArray());
          if (arrayOfByte != null)
          {
            localBundle2.putByteArray("data", arrayOfByte);
            localBundle2.putInt("len", arrayOfByte.length);
            ((ArrayList)localObject).add(localBundle2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        i += 1;
      }
      arrayOfBundle = new Bundle[((ArrayList)localObject).size()];
      i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        arrayOfBundle[i] = ((Bundle)((ArrayList)localObject).get(i));
        i += 1;
      }
      localBundle1.putParcelableArray("imge_ext", arrayOfBundle);
      this.poiResultList = null;
    }
    while ((this.extData == null) || (this.extData.length <= 1))
    {
      int i;
      Bundle localBundle2;
      byte[] arrayOfByte;
      Bundle[] arrayOfBundle;
      return localBundle1;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putByteArray("data", this.extData);
    ((Bundle)localObject).putInt("len", this.extData.length);
    localBundle1.putParcelableArray("imge_ext", new Bundle[] { localObject });
    this.extData = null;
    return localBundle1;
  }
  
  public void setExtData(byte[] paramArrayOfByte)
  {
    this.extData = getExtData(paramArrayOfByte);
  }
  
  public void setIsAccShow(boolean paramBoolean)
  {
    this.isAccShow = paramBoolean;
  }
  
  public void setIsAddContent(boolean paramBoolean)
  {
    this.isAddContent = paramBoolean;
  }
  
  public void setLevel(float paramFloat)
  {
    this.level = paramFloat;
  }
  
  public void setPoiResultList(List<PoiResult> paramList)
  {
    this.poiResultList = paramList;
  }
  
  public void setPoiUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setQid(String paramString)
  {
    this.qid = paramString;
  }
  
  public void setRouteExtData(byte[] paramArrayOfByte)
  {
    this.extData = paramArrayOfByte;
  }
  
  public void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void setShouldClear(boolean paramBoolean)
  {
    this.shouldClear = paramBoolean;
  }
  
  public void setShouldDel(boolean paramBoolean)
  {
    this.shouldDel = paramBoolean;
  }
  
  public void setShowAd(boolean paramBoolean)
  {
    this.showAd = paramBoolean;
  }
  
  public void setX(double paramDouble)
  {
    this.x = paramDouble;
  }
  
  public void setY(double paramDouble)
  {
    this.y = paramDouble;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/PoiDynamicMapOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */