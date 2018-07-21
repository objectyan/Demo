package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

public class MapBound
  implements Serializable
{
  private static final long serialVersionUID = 9060448268138558778L;
  public Point leftBottomPt = new Point();
  public Point rightTopPt = new Point();
  
  public MapBound() {}
  
  public MapBound(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setLeftBottomPt(paramInt1, paramInt2);
    setRightTopPt(paramInt3, paramInt4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MapBound)) {
        return false;
      }
      paramObject = (MapBound)paramObject;
      if (this.leftBottomPt != null)
      {
        if (this.leftBottomPt.equals(((MapBound)paramObject).leftBottomPt)) {}
      }
      else {
        while (((MapBound)paramObject).leftBottomPt != null) {
          return false;
        }
      }
      if (this.rightTopPt == null) {
        break;
      }
    } while (this.rightTopPt.equals(((MapBound)paramObject).rightTopPt));
    while (((MapBound)paramObject).rightTopPt != null) {
      return false;
    }
    return true;
  }
  
  public Point getCenterPt()
  {
    return new Point((this.leftBottomPt.getIntX() + this.rightTopPt.getIntX()) / 2, (this.leftBottomPt.getIntY() + this.rightTopPt.getIntY()) / 2);
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.leftBottomPt != null) {}
    for (int i = this.leftBottomPt.hashCode();; i = 0)
    {
      if (this.rightTopPt != null) {
        j = this.rightTopPt.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public void setLeftBottomPt(int paramInt1, int paramInt2)
  {
    this.leftBottomPt.setTo(paramInt1, paramInt2);
  }
  
  public void setLeftBottomPt(Point paramPoint)
  {
    this.leftBottomPt.setTo(paramPoint);
  }
  
  public void setRightTopPt(int paramInt1, int paramInt2)
  {
    this.rightTopPt.setTo(paramInt1, paramInt2);
  }
  
  public void setRightTopPt(Point paramPoint)
  {
    this.rightTopPt.setTo(paramPoint);
  }
  
  public String toQuery()
  {
    return String.format("(%d,%d;%d,%d)", new Object[] { Integer.valueOf(this.leftBottomPt.getIntX()), Integer.valueOf(this.leftBottomPt.getIntY()), Integer.valueOf(this.rightTopPt.getIntX()), Integer.valueOf(this.rightTopPt.getIntY()) });
  }
  
  public String toString()
  {
    return "MapBound{leftBottomPt=" + this.leftBottomPt + ", rightTopPt=" + this.rightTopPt + '}';
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/basestruct/MapBound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */