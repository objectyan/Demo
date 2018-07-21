package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;

public class OverlayLocationData
{
  private Bitmap bitmap;
  private int imgHeight;
  private String imgName;
  private int imgWidth;
  private int rotation;
  
  public Bitmap getImage()
  {
    return this.bitmap;
  }
  
  public int getImgHeight()
  {
    return this.imgHeight;
  }
  
  public String getImgName()
  {
    return this.imgName;
  }
  
  public int getImgWidth()
  {
    return this.imgWidth;
  }
  
  public int isRotation()
  {
    return this.rotation;
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public void setImgHeight(int paramInt)
  {
    this.imgHeight = paramInt;
  }
  
  public void setImgName(String paramString)
  {
    this.imgName = paramString;
  }
  
  public void setImgWidth(int paramInt)
  {
    this.imgWidth = paramInt;
  }
  
  public void setRotation(int paramInt)
  {
    this.rotation = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/OverlayLocationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */