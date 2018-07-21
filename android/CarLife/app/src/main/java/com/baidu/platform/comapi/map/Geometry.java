package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.JsonBuilder;

public abstract class Geometry
{
  protected static final int DATA_TYPE_INVALID = -1;
  protected static final int DATA_TYPE_PATH = 0;
  protected static final int DATA_TYPE_SGEO = 1;
  public static final int DIFFER_HEADER_SIZE = 5;
  public static final int LINE_POINTS_MINSIZE = 2;
  public static final int POLYGON_POINTS_MINSIZE = 3;
  public static final int TY_MASK = 3200;
  public static final int TY_POLYGON = 3100;
  public static final int TY_TEXTURE = 32;
  protected int dataType = -1;
  protected boolean isNeedRefresh = true;
  protected JsonBuilder jsonBuilder;
  protected double[] mDifferArray;
  protected GeoPoint mLL = new GeoPoint(0, 0);
  protected GeoPoint mRU = new GeoPoint(0, 0);
  public boolean showVirtuleLine;
  protected Style style;
  protected int styleType = 0;
  
  public Geometry(Style paramStyle)
  {
    this.style = paramStyle;
  }
  
  public abstract String getData();
  
  protected String getData(int paramInt)
  {
    this.jsonBuilder = new JsonBuilder();
    this.jsonBuilder.object();
    if (paramInt == 0)
    {
      this.jsonBuilder.key("path").arrayValue();
      if (this.mDifferArray != null)
      {
        paramInt = 0;
        while (paramInt < this.mDifferArray.length)
        {
          this.jsonBuilder.value(this.mDifferArray[paramInt]);
          paramInt += 1;
        }
      }
      this.jsonBuilder.endArrayValue();
      this.jsonBuilder.key("ud").value(String.valueOf(hashCode()));
      this.jsonBuilder.key("dir").value(0);
      if ((this.style == null) || (this.style.getTextureId() == 0)) {
        break label692;
      }
      this.jsonBuilder.key("nst").value(this.style.getTextureId());
      this.jsonBuilder.key("fst").value(this.style.getTextureId());
      this.jsonBuilder.key("ty").value(32);
    }
    for (;;)
    {
      this.jsonBuilder.key("of").value(0);
      this.jsonBuilder.key("in").value(0);
      this.jsonBuilder.key("tx").value("");
      this.jsonBuilder.key("dis").value(0);
      this.jsonBuilder.key("align").value(0);
      if (this.showVirtuleLine)
      {
        this.jsonBuilder.key("dash").value(1);
        this.jsonBuilder.key("ty").value(this.styleType);
      }
      this.jsonBuilder.key("style").object();
      if (this.style != null)
      {
        this.jsonBuilder.key("width").value(this.style.getWidth());
        this.jsonBuilder.key("color").value(Style.transColorVal(this.style.getColor()));
        if ((this.styleType == 3) || (this.styleType == 4)) {
          this.jsonBuilder.key("scolor").value(Style.transColorVal(this.style.getFillColor()));
        }
      }
      this.jsonBuilder.endObject();
      this.jsonBuilder.endObject();
      return this.jsonBuilder.toString();
      if (paramInt != 1) {
        break;
      }
      this.jsonBuilder.key("sgeo");
      this.jsonBuilder.object();
      this.jsonBuilder.key("bound").arrayValue();
      if ((this.mLL != null) && (this.mRU != null))
      {
        this.jsonBuilder.value(this.mLL.getLongitude());
        this.jsonBuilder.value(this.mLL.getLatitude());
        this.jsonBuilder.value(this.mRU.getLongitude());
        this.jsonBuilder.value(this.mRU.getLatitude());
      }
      this.jsonBuilder.endArrayValue();
      if (this.styleType == 4) {
        this.jsonBuilder.key("type").value(3);
      }
      for (;;)
      {
        this.jsonBuilder.key("elements").arrayValue();
        this.jsonBuilder.object();
        this.jsonBuilder.key("points").arrayValue();
        if (this.mDifferArray == null) {
          break;
        }
        paramInt = 0;
        while (paramInt < this.mDifferArray.length)
        {
          this.jsonBuilder.value(this.mDifferArray[paramInt]);
          paramInt += 1;
        }
        this.jsonBuilder.key("type").value(this.styleType);
      }
      this.jsonBuilder.endArrayValue();
      this.jsonBuilder.endObject();
      this.jsonBuilder.endArrayValue();
      this.jsonBuilder.endObject();
      break;
      label692:
      if (this.styleType == 3) {
        this.jsonBuilder.key("ty").value(3100);
      } else if (this.styleType == 4) {
        this.jsonBuilder.key("ty").value(3200);
      } else {
        this.jsonBuilder.key("ty").value(-1);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/Geometry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */