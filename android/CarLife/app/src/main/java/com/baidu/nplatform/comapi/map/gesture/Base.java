package com.baidu.nplatform.comapi.map.gesture;

import android.view.MotionEvent;

public class Base
{
  public static final Line HORIZONTAL = new Line(new Point(0.0D, 0.0D), new Point(1.0D, 0.0D));
  public static final Line VERTICAL = new Line(new Point(0.0D, 0.0D), new Point(0.0D, 1.0D));
  
  public static class Line
  {
    public Base.Point a;
    public Base.Point b;
    
    public Line(Base.Point paramPoint1, Base.Point paramPoint2)
    {
      this.a = paramPoint1;
      this.b = paramPoint2;
    }
    
    public static Line make(MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(0);
      float f3 = paramMotionEvent.getX(1);
      float f4 = paramMotionEvent.getY(1);
      return new Line(new Base.Point(f1, f2), new Base.Point(f3, f4));
    }
    
    public Base.Point center()
    {
      return new Base.Point((this.a.x + this.b.x) / 2.0D, (this.a.y + this.b.y) / 2.0D);
    }
    
    public double length()
    {
      return Math.sqrt((this.a.x - this.b.x) * (this.a.x - this.b.x) + (this.a.y - this.b.y) * (this.a.y - this.b.y));
    }
    
    public String toString()
    {
      return getClass().getSimpleName() + "  a : " + this.a.toString() + " b : " + this.b.toString();
    }
    
    public Base.Vector vector()
    {
      return new Base.Vector(this.b.x - this.a.x, this.b.y - this.a.y);
    }
  }
  
  public static class Point
  {
    public double x;
    public double y;
    
    public Point(double paramDouble1, double paramDouble2)
    {
      this.x = paramDouble1;
      this.y = paramDouble2;
    }
    
    public String toString()
    {
      return getClass().getSimpleName() + " x : " + this.x + " y : " + this.y;
    }
  }
  
  public static class Translation
  {
    public final Base.Vector move;
    public final double rotate;
    public final double scale;
    
    public Translation(Base.Line paramLine1, Base.Line paramLine2)
    {
      this.move = new Base.Vector(paramLine1.center(), paramLine2.center());
      double d = paramLine1.length();
      if ((d > 1.0E-7D) || (d < -1.0E-7D)) {}
      for (this.scale = (paramLine2.length() / d);; this.scale = 0.0D)
      {
        this.rotate = Base.Vector.angle(paramLine1.vector(), paramLine2.vector());
        return;
      }
    }
    
    public String toString()
    {
      return getClass().getSimpleName() + " rotate : " + this.rotate + " scale : " + this.scale * 100.0D + " move : " + this.move.toString();
    }
  }
  
  public static class Vector
  {
    public double x;
    public double y;
    
    public Vector(double paramDouble1, double paramDouble2)
    {
      this.x = paramDouble1;
      this.y = paramDouble2;
    }
    
    public Vector(Base.Point paramPoint1, Base.Point paramPoint2)
    {
      this.x = (paramPoint2.x - paramPoint1.x);
      this.y = (paramPoint2.y - paramPoint1.y);
    }
    
    public static double angle(Vector paramVector1, Vector paramVector2)
    {
      return (Math.atan2(paramVector1.y, paramVector1.x) - Math.atan2(paramVector2.y, paramVector2.x)) * 180.0D / 3.141592653589793D;
    }
    
    public String toString()
    {
      return getClass().getSimpleName() + " x : " + this.x + " y : " + this.y;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/gesture/Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */