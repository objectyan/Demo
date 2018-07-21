package com.baidu.platform.comapi.util;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelItem
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelItem> CREATOR = new Parcelable.Creator()
  {
    public ParcelItem a(Parcel paramAnonymousParcel)
    {
      ParcelItem localParcelItem = new ParcelItem();
      localParcelItem.a(paramAnonymousParcel.readBundle());
      return localParcelItem;
    }
    
    public ParcelItem[] a(int paramAnonymousInt)
    {
      return new ParcelItem[paramAnonymousInt];
    }
  };
  private Bundle a;
  
  public Bundle a()
  {
    return this.a;
  }
  
  public void a(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/ParcelItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */