package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.DynamicHeaderMessage;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.google.protobuf.micro.ByteStringMicro;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class BMBarDynamicMapOverlay
  extends InnerOverlay
{
  public static final int PB_LENGTH_SIGN = 32;
  private byte[] extData;
  private boolean isAccShow = false;
  private boolean isAddContent = false;
  private float level;
  private PoiResult poiResult;
  private String qid = null;
  private int scene;
  private boolean shouldDel = false;
  private boolean showAd;
  private String uid = null;
  private double x;
  private double y;
  
  public BMBarDynamicMapOverlay()
  {
    super(37);
  }
  
  public BMBarDynamicMapOverlay(AppBaseMap paramAppBaseMap)
  {
    super(37, paramAppBaseMap);
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
        i = 1;
        localJSONObject.put("rs_add", i);
        if (!this.isAccShow) {
          continue;
        }
        i = j;
        localJSONObject.put("show_force", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        continue;
      }
      return localJSONObject.toString();
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
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
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(0, 0, "dynamicmap");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, true);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
  
  public void clear()
  {
    super.clear();
  }
  
  public String getData()
  {
    if (((this.extData == null) || (this.poiResult == null)) && (this.shouldDel))
    {
      this.shouldDel = false;
      return generateDelJson();
    }
    if (((this.poiResult != null) && (this.poiResult.getContentsCount() > 0)) || ((this.extData != null) && (this.extData.length > 0))) {
      return generateJson();
    }
    return "";
  }
  
  public Bundle getParam()
  {
    Bundle localBundle = new Bundle();
    if ((this.poiResult != null) && (this.poiResult.getContentsCount() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = new Bundle();
      if (this.poiResult.hasImgeExt()) {
        arrayOfByte = this.poiResult.getImgeExt().toByteArray();
      }
      try
      {
        arrayOfByte = getExtData(DynamicHeaderMessage.parseFrom(arrayOfByte).getDynamicPbRes().toByteArray());
        if (arrayOfByte != null)
        {
          ((Bundle)localObject2).putByteArray("data", arrayOfByte);
          ((Bundle)localObject2).putInt("len", arrayOfByte.length);
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        localBundle.putParcelableArray("imge_ext", localException);
        this.poiResult = null;
      }
      localObject2 = new Bundle[((ArrayList)localObject1).size()];
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2[i] = ((Bundle)((ArrayList)localObject1).get(i));
        i += 1;
      }
    }
    while ((this.extData == null) || (this.extData.length <= 1))
    {
      Object localObject2;
      byte[] arrayOfByte;
      int i;
      return localBundle;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putByteArray("data", this.extData);
    ((Bundle)localObject1).putInt("len", this.extData.length);
    localBundle.putParcelableArray("imge_ext", new Bundle[] { localObject1 });
    this.extData = null;
    return localBundle;
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
  
  public void setPoiResult(PoiResult paramPoiResult)
  {
    this.poiResult = paramPoiResult;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/BMBarDynamicMapOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */