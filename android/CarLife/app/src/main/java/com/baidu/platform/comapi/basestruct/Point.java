package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

public class Point
  implements Serializable
{
  private static final long serialVersionUID = -5301955526770473401L;
  private double x;
  private double y;
  
  public Point() {}
  
  public Point(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public Point(Point paramPoint)
  {
    if (paramPoint != null)
    {
      this.x = paramPoint.getDoubleX();
      this.y = paramPoint.getDoubleY();
    }
  }
  
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
          return bool1;
          bool1 = bool3;
        } while (paramObject == null);
        bool1 = bool3;
      } while (getClass() != paramObject.getClass());
      paramObject = (Point)paramObject;
      bool1 = bool3;
    } while (getDoubleX() != ((Point)paramObject).getDoubleX());
    if (getDoubleY() == ((Point)paramObject).getDoubleY()) {}
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public double getDoubleX()
  {
    return this.x;
  }
  
  public double getDoubleY()
  {
    return this.y;
  }
  
  public int getIntX()
  {
    return (int)this.x;
  }
  
  public int getIntY()
  {
    return (int)this.y;
  }
  
  public int hashCode()
  {
    return (getIntX() + 31) * 31 + getIntY();
  }
  
  public void setDoubleX(double paramDouble)
  {
    this.x = paramDouble;
  }
  
  public void setDoubleY(double paramDouble)
  {
    this.y = paramDouble;
  }
  
  public void setIntX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setIntY(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setTo(double paramDouble1, double paramDouble2)
  {
    setDoubleX(paramDouble1);
    setDoubleY(paramDouble2);
  }
  
  public void setTo(Point paramPoint)
  {
    if (paramPoint != null)
    {
      setDoubleX(paramPoint.getDoubleX());
      setDoubleY(paramPoint.getDoubleY());
    }
  }
  
  public String toQuery()
  {
    return String.format("(%d,%d)", new Object[] { Integer.valueOf(getIntX()), Integer.valueOf(getIntY()) });
  }
  
  public String toString()
  {
    return "Point [x=" + getDoubleX() + ", y=" + getDoubleY() + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/basestruct/Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */