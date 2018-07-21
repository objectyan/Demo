package com.indooratlas.android.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class IALocationRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IALocationRequest> CREATOR = new Parcelable.Creator() {};
  private Bundle a;
  private long b = -1L;
  private float c = -1.0F;
  
  private IALocationRequest() {}
  
  private IALocationRequest(Parcel paramParcel)
  {
    this.a = paramParcel.readBundle(getClass().getClassLoader());
    this.b = paramParcel.readLong();
    this.c = paramParcel.readFloat();
  }
  
  private void a()
  {
    if (this.a == null) {
      this.a = new Bundle();
    }
  }
  
  public static IALocationRequest create()
  {
    return new IALocationRequest();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final long getFastestInterval()
  {
    return this.b;
  }
  
  public final <T extends Parcelable> T getParcelableExtra(String paramString)
  {
    if (this.a != null) {}
    for (paramString = this.a.getParcelable(paramString); paramString == null; paramString = null) {
      return null;
    }
    return paramString;
  }
  
  public final float getSmallestDisplacement()
  {
    return this.c;
  }
  
  public final String getStringExtra(String paramString)
  {
    if (this.a != null) {
      return this.a.getString(paramString);
    }
    return null;
  }
  
  public final IALocationRequest putExtra(String paramString, Parcelable paramParcelable)
  {
    a();
    this.a.putParcelable(paramString, paramParcelable);
    return this;
  }
  
  public final IALocationRequest putExtra(String paramString1, String paramString2)
  {
    a();
    this.a.putString(paramString1, paramString2);
    return this;
  }
  
  public final IALocationRequest setFastestInterval(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public final IALocationRequest setSmallestDisplacement(float paramFloat)
  {
    this.c = paramFloat;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeFloat(this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/IALocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */