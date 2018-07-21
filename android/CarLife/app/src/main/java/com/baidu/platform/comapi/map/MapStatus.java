package com.baidu.platform.comapi.map;

import java.io.Serializable;

public class MapStatus
  implements Serializable
{
  private static final long serialVersionUID = -6653836093940008535L;
  public int animationTime;
  public boolean bOverlookSpringback;
  public boolean bfpp;
  public double centerPtX;
  public double centerPtY;
  public double centerPtZ;
  public GeoBound geoRound;
  public int hasAnimation;
  public boolean isBirdEye;
  public float level;
  public int minOverlooking;
  public int overlooking;
  public String panoId;
  public float roadOffsetX;
  public float roadOffsetY;
  public int rotation;
  public int streetExt;
  public float streetIndicateAngle;
  public WinRound winRound;
  public float xOffset;
  public float yOffset;
  
  public MapStatus()
  {
    this.level = -1.0F;
    this.rotation = -1;
    this.overlooking = -1;
    this.centerPtX = -1.0D;
    this.centerPtY = -1.0D;
    this.centerPtZ = 0.0D;
    this.xOffset = 0.0F;
    this.yOffset = 0.0F;
    this.winRound = new WinRound();
    this.geoRound = new GeoBound();
    this.bfpp = false;
    this.panoId = "";
    this.streetIndicateAngle = 0.0F;
    this.isBirdEye = false;
    this.streetExt = 0;
    this.roadOffsetX = 0.0F;
    this.roadOffsetY = 0.0F;
    this.bOverlookSpringback = false;
    this.minOverlooking = -1;
  }
  
  public MapStatus(MapStatus paramMapStatus)
  {
    this.level = paramMapStatus.level;
    this.rotation = paramMapStatus.rotation;
    this.overlooking = paramMapStatus.overlooking;
    this.centerPtX = paramMapStatus.centerPtX;
    this.centerPtY = paramMapStatus.centerPtY;
    this.centerPtZ = paramMapStatus.centerPtZ;
    this.xOffset = paramMapStatus.xOffset;
    this.yOffset = paramMapStatus.yOffset;
    this.winRound = paramMapStatus.winRound;
    this.geoRound = paramMapStatus.geoRound;
    this.bfpp = paramMapStatus.bfpp;
    this.panoId = paramMapStatus.panoId;
    this.streetIndicateAngle = paramMapStatus.streetIndicateAngle;
    this.isBirdEye = paramMapStatus.isBirdEye;
    this.streetExt = paramMapStatus.streetExt;
    this.roadOffsetX = paramMapStatus.roadOffsetX;
    this.roadOffsetY = paramMapStatus.roadOffsetY;
    this.bOverlookSpringback = paramMapStatus.bOverlookSpringback;
    this.minOverlooking = paramMapStatus.minOverlooking;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MapStatus)) {
      break label86;
    }
    label86:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (this == paramObject) {
                return true;
              }
            } while (paramObject == null);
            paramObject = (MapStatus)paramObject;
          } while ((this.centerPtX != ((MapStatus)paramObject).centerPtX) || (this.centerPtY != ((MapStatus)paramObject).centerPtY) || (this.centerPtZ != ((MapStatus)paramObject).centerPtZ) || (this.bfpp != ((MapStatus)paramObject).bfpp));
          if (this.geoRound != null) {
            break;
          }
        } while (((MapStatus)paramObject).geoRound != null);
      } while ((Float.floatToIntBits(this.level) != Float.floatToIntBits(((MapStatus)paramObject).level)) || (this.overlooking != ((MapStatus)paramObject).overlooking) || (this.rotation != ((MapStatus)paramObject).rotation) || (this.yOffset != ((MapStatus)paramObject).yOffset) || (this.xOffset != ((MapStatus)paramObject).xOffset));
      if (this.winRound != null) {
        break label181;
      }
    } while (((MapStatus)paramObject).winRound != null);
    label181:
    while (this.winRound.equals(((MapStatus)paramObject).winRound))
    {
      return true;
      if (this.geoRound.equals(((MapStatus)paramObject).geoRound)) {
        break;
      }
      return false;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    double d1 = this.centerPtX;
    double d2 = this.centerPtY;
    double d3 = this.centerPtZ;
    double d4;
    label44:
    double d5;
    double d6;
    double d7;
    double d8;
    if (this.bfpp)
    {
      i = 1;
      d4 = i;
      if (this.geoRound != null) {
        break label155;
      }
      i = 0;
      d5 = i;
      d6 = Float.floatToIntBits(this.level);
      d7 = this.overlooking;
      d8 = this.rotation;
      if (this.winRound != null) {
        break label167;
      }
    }
    label155:
    label167:
    for (int i = j;; i = this.winRound.hashCode())
    {
      return (int)(31.0D * (31.0D * (31.0D * (31.0D * (31.0D * (31.0D * (31.0D * (31.0D * (31.0D * 1.0D + d1) + d2) + d3) + d4) + d5) + d6) + d7) + d8) + i);
      i = 0;
      break;
      i = this.geoRound.hashCode();
      break label44;
    }
  }
  
  public String toString()
  {
    return "MapStatus{level=" + this.level + ", rotation=" + this.rotation + ", overlooking=" + this.overlooking + ", centerPtX=" + this.centerPtX + ", centerPtY=" + this.centerPtY + ", centerPtZ=" + this.centerPtZ + ", winRound=" + this.winRound + ", geoRound=" + this.geoRound + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", bfpp=" + this.bfpp + ", panoId='" + this.panoId + '\'' + ", streetIndicateAngle=" + this.streetIndicateAngle + ", isBirdEye=" + this.isBirdEye + ", streetExt=" + this.streetExt + ", roadOffsetX=" + this.roadOffsetX + ", roadOffsetY=" + this.roadOffsetY + '}';
  }
  
  public static class GeoBound
    implements Serializable
  {
    private static final long serialVersionUID = -4289946562664743225L;
    public long bottom = 0L;
    public long left = 0L;
    public long right = 0L;
    public long top = 0L;
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool3 = false;
      if (this == paramObject) {
        bool1 = true;
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramObject == null);
              bool1 = bool3;
            } while (!(paramObject instanceof GeoBound));
            paramObject = (GeoBound)paramObject;
            bool1 = bool3;
          } while (this.bottom != ((GeoBound)paramObject).bottom);
          bool1 = bool3;
        } while (this.left != ((GeoBound)paramObject).left);
        bool1 = bool3;
      } while (this.right != ((GeoBound)paramObject).right);
      if (this.top == ((GeoBound)paramObject).top) {}
      for (boolean bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
    
    public int hashCode()
    {
      return ((((int)(this.bottom ^ this.bottom >>> 32) + 31) * 31 + (int)(this.left ^ this.left >>> 32)) * 31 + (int)(this.right ^ this.right >>> 32)) * 31 + (int)(this.top ^ this.top >>> 32);
    }
  }
  
  public static class WinRound
    implements Serializable
  {
    private static final long serialVersionUID = 8296028961543854239L;
    public int bottom = 0;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool3 = false;
      if (this == paramObject) {
        bool1 = true;
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramObject == null);
              bool1 = bool3;
            } while (!(paramObject instanceof WinRound));
            paramObject = (WinRound)paramObject;
            bool1 = bool3;
          } while (this.bottom != ((WinRound)paramObject).bottom);
          bool1 = bool3;
        } while (this.left != ((WinRound)paramObject).left);
        bool1 = bool3;
      } while (this.right != ((WinRound)paramObject).right);
      if (this.top == ((WinRound)paramObject).top) {}
      for (boolean bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
    
    public int hashCode()
    {
      return (((this.bottom + 31) * 31 + this.left) * 31 + this.right) * 31 + this.top;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MapStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */