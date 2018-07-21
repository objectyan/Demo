package com.indooratlas.android.sdk._internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class bp
  implements Parcelable
{
  public static final Parcelable.Creator<bp> CREATOR = new Parcelable.Creator() {};
  public final int a;
  public final int b;
  public final Bundle c;
  
  public bp(int paramInt)
  {
    this.a = 1;
    this.b = paramInt;
    this.c = null;
  }
  
  private bp(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readBundle();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (bp)paramObject;
      if (this.a != ((bp)paramObject).a) {
        return false;
      }
    } while (this.b == ((bp)paramObject).b);
    return false;
  }
  
  public final int hashCode()
  {
    return this.a * 31 + this.b;
  }
  
  public final String toString()
  {
    return "IAServiceState{category=" + this.a + ", status=" + this.b + ", extras=" + this.c + '}';
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeBundle(this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */