package com.indooratlas.android.sdk.resources;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class IAFloorPlan
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {};
  private String a;
  private String b;
  private String c;
  private int d;
  private int e;
  private float f;
  private float g;
  private int h;
  private double[] i;
  private double[] j;
  private boolean k;
  private Matrix l;
  private Matrix m;
  private float n;
  private float o;
  private double p;
  private IALatLng q;
  private IALatLng r;
  private IALatLng s;
  private IALatLng t;
  
  protected IAFloorPlan(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.createDoubleArray();
    this.j = paramParcel.createDoubleArray();
    this.k = false;
  }
  
  public IAFloorPlan(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt1;
    this.e = paramInt2;
    this.h = paramInt3;
    this.i = paramArrayOfDouble1;
    this.j = paramArrayOfDouble2;
    this.k = false;
  }
  
  private Location a(double paramDouble1, double paramDouble2)
  {
    Location localLocation = new Location("");
    double[] arrayOfDouble = a(paramDouble1, paramDouble2, this.i);
    localLocation.setLatitude(arrayOfDouble[0]);
    localLocation.setLongitude(arrayOfDouble[1]);
    return localLocation;
  }
  
  private static IALatLng a(Location paramLocation)
  {
    return new IALatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
  }
  
  private void a()
  {
    if (this.k) {}
    while ((this.i.length != 6) || (this.j.length != 6)) {
      return;
    }
    Object localObject = new float[9];
    int i1 = 0;
    while (i1 < 6)
    {
      localObject[i1] = ((float)this.i[i1]);
      i1 += 1;
    }
    localObject[6] = 0.0F;
    localObject[7] = 0.0F;
    localObject[8] = 1.0F;
    this.m = new Matrix();
    this.m.setValues((float[])localObject);
    i1 = 0;
    while (i1 < 6)
    {
      localObject[i1] = ((float)this.j[i1]);
      i1 += 1;
    }
    this.l = new Matrix();
    this.l.setValues((float[])localObject);
    localObject = a(this.d / 2.0D, this.e / 2.0D, this.i);
    this.q = new IALatLng(localObject[0], localObject[1]);
    localObject = a(0.0D, 0.0D);
    this.r = a((Location)localObject);
    Location localLocation1 = a(0.0D, this.e);
    this.s = a(localLocation1);
    Location localLocation2 = a(this.d, 0.0D);
    this.t = a(localLocation2);
    this.o = localLocation1.distanceTo((Location)localObject);
    this.n = ((Location)localObject).distanceTo(localLocation2);
    double d3 = this.s.latitude;
    double d1 = this.s.longitude;
    double d4 = this.r.latitude;
    double d2 = this.r.longitude;
    d3 *= 0.017453292519943295D;
    d4 *= 0.017453292519943295D;
    d1 = d2 * 0.017453292519943295D - d1 * 0.017453292519943295D;
    this.p = ((Math.atan2(Math.sin(d1) * Math.cos(d4), Math.cos(d3) * Math.sin(d4) - Math.sin(d3) * Math.cos(d4) * Math.cos(d1)) / 0.017453292519943295D + 360.0D) % 360.0D);
    this.g = ((this.d / this.n + this.e / this.o) / 2.0F);
    this.f = (1.0F / this.g);
    this.k = true;
  }
  
  private static double[] a(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble)
  {
    return new double[] { paramArrayOfDouble[0] * paramDouble1 + paramArrayOfDouble[1] * paramDouble2 + paramArrayOfDouble[2], paramArrayOfDouble[3] * paramDouble1 + paramArrayOfDouble[4] * paramDouble2 + paramArrayOfDouble[5] };
  }
  
  public PointF coordinateToPoint(IALatLng paramIALatLng)
  {
    paramIALatLng = a(paramIALatLng.latitude, paramIALatLng.longitude, this.j);
    return new PointF((float)paramIALatLng[0], (float)paramIALatLng[1]);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Matrix getAffinePix2wgs()
  {
    a();
    return this.m;
  }
  
  public Matrix getAffineWgs2pix()
  {
    a();
    return this.l;
  }
  
  public float getBearing()
  {
    a();
    return (float)this.p;
  }
  
  public int getBitmapHeight()
  {
    return this.e;
  }
  
  public int getBitmapWidth()
  {
    return this.d;
  }
  
  public IALatLng getBottomLeft()
  {
    a();
    return this.s;
  }
  
  public IALatLng getCenter()
  {
    a();
    return this.q;
  }
  
  public int getFloorLevel()
  {
    return this.h;
  }
  
  public float getHeightMeters()
  {
    a();
    return this.o;
  }
  
  public String getId()
  {
    return this.a;
  }
  
  public float getMetersToPixels()
  {
    a();
    return this.g;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public float getPixelsToMeters()
  {
    a();
    return this.f;
  }
  
  public IALatLng getTopLeft()
  {
    a();
    return this.r;
  }
  
  public IALatLng getTopRight()
  {
    a();
    return this.t;
  }
  
  public String getUrl()
  {
    return this.c;
  }
  
  public float getWidthMeters()
  {
    a();
    return this.n;
  }
  
  public IALatLng pointToCoordinate(PointF paramPointF)
  {
    paramPointF = a(paramPointF.x, paramPointF.y, this.i);
    return new IALatLng(paramPointF[0], paramPointF[1]);
  }
  
  public String toString()
  {
    return "IAFloorPlan{id='" + this.a + '\'' + ", name='" + this.b + '\'' + ", url='" + this.c + '\'' + ", bitmapWidth=" + this.d + ", bitmapHeight=" + this.e + ", pixelsToMeters=" + this.f + ", metersToPixels=" + this.g + ", floorLevel=" + this.h + ", pixelToWgs=" + Arrays.toString(this.i) + ", wgsToPixel=" + Arrays.toString(this.j) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.h);
    paramParcel.writeDoubleArray(this.i);
    paramParcel.writeDoubleArray(this.j);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/resources/IAFloorPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */