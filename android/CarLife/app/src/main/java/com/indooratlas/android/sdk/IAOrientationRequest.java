package com.indooratlas.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class IAOrientationRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IAOrientationRequest> CREATOR = new Parcelable.Creator() {};
  private final double a;
  private final double b;
  
  public IAOrientationRequest(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  protected IAOrientationRequest(Parcel paramParcel)
  {
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final double getHeadingSensitivity()
  {
    return this.a;
  }
  
  public final double getOrientationSensitivity()
  {
    return this.b;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/IAOrientationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */