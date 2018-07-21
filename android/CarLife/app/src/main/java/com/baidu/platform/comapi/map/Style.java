package com.baidu.platform.comapi.map;

public class Style
{
  public static final int TYPE_LINE = 2;
  public static final int TYPE_MASK = 4;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_POINT = 1;
  public static final int TYPE_POLYGON = 3;
  private int color;
  private int fillColor;
  private int textureId;
  private int width;
  
  static int transColorVal(int paramInt)
  {
    return 0xFF000000 & paramInt | (paramInt & 0xFF) << 16 | 0xFF00 & paramInt | (0xFF0000 & paramInt) >> 16;
  }
  
  public int getColor()
  {
    return this.color;
  }
  
  public int getFillColor()
  {
    return this.fillColor;
  }
  
  public int getTextureId()
  {
    return this.textureId;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public Style setColor(int paramInt)
  {
    this.color = paramInt;
    return this;
  }
  
  public Style setFillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }
  
  public Style setTextureId(int paramInt)
  {
    this.textureId = paramInt;
    return this;
  }
  
  public Style setWidth(int paramInt)
  {
    this.width = paramInt;
    return this;
  }
  
  public String toString()
  {
    return "Style: color:" + Integer.toHexString(this.color) + " width:" + this.width + " fillcolor:" + Integer.toHexString(this.fillColor);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/Style.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */