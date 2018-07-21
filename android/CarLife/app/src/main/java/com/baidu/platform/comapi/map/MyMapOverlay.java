package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MyMapOverlay
  extends InnerOverlay
{
  public static final int PB_LENGTH_SIGN = 32;
  private int deleteFlag = 0;
  private byte[] extData;
  private boolean isAddContent = false;
  private float level;
  private String qid = null;
  private int scene;
  private String uid = null;
  private double x;
  private double y;
  
  public MyMapOverlay()
  {
    super(37);
  }
  
  public MyMapOverlay(AppBaseMap paramAppBaseMap)
  {
    super(37, paramAppBaseMap);
  }
  
  private String generateAddJson()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("ud", this.uid);
        localJSONObject.put("scene", this.scene);
        if (!this.isAddContent) {
          continue;
        }
        i = 1;
        localJSONObject.put("rs_add", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        f.b(localJSONException.getMessage());
        continue;
      }
      return localJSONObject.toString();
      i = 0;
    }
  }
  
  private String generateRevJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ud", this.uid);
      localJSONObject.put("scene", this.scene);
      localJSONObject.put("rs_rev", this.deleteFlag);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        f.b(localJSONException.getMessage());
      }
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
  
  public String getLayerTag()
  {
    return "dynamicmap";
  }
  
  public Bundle getParam()
  {
    Bundle localBundle1 = new Bundle();
    if ((this.extData != null) && (this.extData.length > 1))
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putByteArray("data", this.extData);
      localBundle2.putInt("len", this.extData.length);
      localBundle1.putParcelableArray("imge_ext", new Bundle[] { localBundle2 });
      this.extData = null;
    }
    return localBundle1;
  }
  
  public void resetDeleteFlag()
  {
    this.deleteFlag = 0;
  }
  
  public void setData(String paramString)
  {
    super.setData(paramString);
  }
  
  public void setDeleteFlag(int paramInt)
  {
    this.deleteFlag = paramInt;
  }
  
  public void setExtData(byte[] paramArrayOfByte)
  {
    this.extData = getExtData(paramArrayOfByte);
  }
  
  public void setIsAddContent(boolean paramBoolean)
  {
    this.isAddContent = paramBoolean;
  }
  
  public void setLevel(float paramFloat)
  {
    this.level = paramFloat;
  }
  
  public void setQid(String paramString)
  {
    this.qid = paramString;
  }
  
  public void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MyMapOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */