package com.baidu.nplatform.comapi.basestruct;

public class MapStatus
{
  public int _CenterPtX = -1;
  public int _CenterPtY = -1;
  public int _CenterPtZ = 0;
  public GeoBound _GeoRound = new GeoBound();
  public float _Level = -1.0F;
  public int _Overlooking = -1;
  public int _Rotation = -1;
  public WinRound _WinRound = new WinRound();
  public long _Xoffset = 0L;
  public long _Yoffset = 0L;
  public boolean _bfpp = false;
  public String _panoId = "";
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        paramObject = (MapStatus)paramObject;
        if (this._CenterPtX != ((MapStatus)paramObject)._CenterPtX) {
          return false;
        }
        if (this._CenterPtY != ((MapStatus)paramObject)._CenterPtY) {
          return false;
        }
        if (this._bfpp != ((MapStatus)paramObject)._bfpp) {
          return false;
        }
        if (this._GeoRound == null)
        {
          if (((MapStatus)paramObject)._GeoRound != null) {
            return false;
          }
        }
        else if (!this._GeoRound.equals(((MapStatus)paramObject)._GeoRound)) {
          return false;
        }
        if (Float.floatToIntBits(this._Level) != Float.floatToIntBits(((MapStatus)paramObject)._Level)) {
          return false;
        }
        if (this._Overlooking != ((MapStatus)paramObject)._Overlooking) {
          return false;
        }
        if (this._Rotation != ((MapStatus)paramObject)._Rotation) {
          return false;
        }
        if (this._Yoffset != ((MapStatus)paramObject)._Yoffset) {
          return false;
        }
        if (this._Xoffset != ((MapStatus)paramObject)._Xoffset) {
          return false;
        }
        if (this._WinRound != null) {
          break;
        }
      } while (((MapStatus)paramObject)._WinRound == null);
      return false;
    } while (this._WinRound.equals(((MapStatus)paramObject)._WinRound));
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this._CenterPtX;
    int n = this._CenterPtY;
    int i;
    int j;
    label32:
    int i1;
    int i2;
    int i3;
    if (this._bfpp)
    {
      i = 1;
      if (this._GeoRound != null) {
        break label110;
      }
      j = 0;
      i1 = Float.floatToIntBits(this._Level);
      i2 = this._Overlooking;
      i3 = this._Rotation;
      if (this._WinRound != null) {
        break label121;
      }
    }
    for (;;)
    {
      return (((((((m + 31) * 31 + n) * 31 + i) * 31 + j) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + k;
      i = 0;
      break;
      label110:
      j = this._GeoRound.hashCode();
      break label32;
      label121:
      k = this._WinRound.hashCode();
    }
  }
  
  public String toString()
  {
    return "MapStatus{level=" + this._Level + ", rotation=" + this._Rotation + ", overlooking=" + this._Overlooking + ", centerPtX=" + this._CenterPtX + ", centerPtY=" + this._CenterPtY + ", centerPtZ=" + this._CenterPtZ + ", winRound=" + this._WinRound + ", geoRound=" + this._GeoRound + ", xOffset=" + this._Xoffset + ", yOffset=" + this._Yoffset + ", bfpp=" + this._bfpp + ", panoId='" + this._panoId + '}';
  }
  
  public class GeoBound
  {
    public long bottom = 0L;
    public Point lb = new Point(0, 0);
    public long left = 0L;
    public Point lt = new Point(0, 0);
    public Point rb = new Point(0, 0);
    public long right = 0L;
    public Point rt = new Point(0, 0);
    public long top = 0L;
    
    public GeoBound() {}
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (!(paramObject instanceof GeoBound)) {
          return false;
        }
        paramObject = (GeoBound)paramObject;
        if (this.bottom != ((GeoBound)paramObject).bottom) {
          return false;
        }
        if (this.left != ((GeoBound)paramObject).left) {
          return false;
        }
        if (this.right != ((GeoBound)paramObject).right) {
          return false;
        }
      } while (this.top == ((GeoBound)paramObject).top);
      return false;
    }
    
    public int hashCode()
    {
      return ((((int)(this.bottom ^ this.bottom >>> 32) + 31) * 31 + (int)(this.left ^ this.left >>> 32)) * 31 + (int)(this.right ^ this.right >>> 32)) * 31 + (int)(this.top ^ this.top >>> 32);
    }
  }
  
  public class WinRound
  {
    public int bottom = 0;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    
    public WinRound() {}
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (!(paramObject instanceof WinRound)) {
          return false;
        }
        paramObject = (WinRound)paramObject;
        if (this.bottom != ((WinRound)paramObject).bottom) {
          return false;
        }
        if (this.left != ((WinRound)paramObject).left) {
          return false;
        }
        if (this.right != ((WinRound)paramObject).right) {
          return false;
        }
      } while (this.top == ((WinRound)paramObject).top);
      return false;
    }
    
    public int hashCode()
    {
      return (((this.bottom + 31) * 31 + this.left) * 31 + this.right) * 31 + this.top;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/basestruct/MapStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */