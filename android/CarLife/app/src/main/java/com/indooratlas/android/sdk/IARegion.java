package com.indooratlas.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.indooratlas.android.sdk._internal.eh;
import com.indooratlas.android.sdk._internal.ei;

public class IARegion
  implements Parcelable
{
  public static final Parcelable.Creator<IARegion> CREATOR = new Parcelable.Creator() {};
  public static final int TYPE_FLOOR_PLAN = 1;
  public static final int TYPE_UNKNOWN = -1;
  public static final int TYPE_VENUE = 2;
  private final int a;
  private final String b;
  private final long c;
  private final String d;
  
  public IARegion(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != -1)) {
      throw new IllegalArgumentException("unsupported region type: " + paramInt);
    }
    if ((paramInt != -1) && (ei.a(paramString1))) {
      throw new IllegalArgumentException("regionId cannot be empty for region type: " + eh.a(IARegion.class, paramString1));
    }
    this.c = paramLong;
    this.a = paramInt;
    this.b = paramString1;
    this.d = paramString2;
  }
  
  protected IARegion(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readString();
  }
  
  public static IARegion floorPlan(String paramString)
  {
    return new IARegion(1, System.currentTimeMillis(), paramString, null);
  }
  
  public static IARegion unknown()
  {
    return new IARegion(-1, System.currentTimeMillis(), null, null);
  }
  
  public static IARegion venue(String paramString)
  {
    return new IARegion(2, System.currentTimeMillis(), paramString, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (IARegion)paramObject;
        if (this.a != ((IARegion)paramObject).a) {
          return false;
        }
        if (this.b == null)
        {
          if (((IARegion)paramObject).b != null) {
            return false;
          }
        }
        else if (!this.b.equals(((IARegion)paramObject).b)) {
          return false;
        }
        if (this.d != null) {
          break;
        }
      } while (((IARegion)paramObject).d == null);
      return false;
    } while (this.d.equals(((IARegion)paramObject).d));
    return false;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public long getTimestamp()
  {
    return this.c;
  }
  
  public int getType()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    int j = this.a;
    int i = j;
    if (this.b != null) {
      i = (j * 31 + this.b.hashCode()) * 31 + this.d.hashCode();
    }
    return i;
  }
  
  public String toString()
  {
    return "IARegion{mRegionType=" + this.a + ", mTimestamp='" + this.c + "', mRegionId='" + this.b + '\'' + ", mRegionName='" + this.d + "'}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.d);
  }
  
  public static abstract interface Listener
  {
    public abstract void onEnterRegion(IARegion paramIARegion);
    
    public abstract void onExitRegion(IARegion paramIARegion);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/IARegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */