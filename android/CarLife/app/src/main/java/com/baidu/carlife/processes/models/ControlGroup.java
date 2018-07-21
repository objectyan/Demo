package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ControlGroup
  implements Parcelable
{
  public static final Parcelable.Creator<ControlGroup> CREATOR = new Parcelable.Creator()
  {
    public ControlGroup a(Parcel paramAnonymousParcel)
    {
      return new ControlGroup(paramAnonymousParcel);
    }
    
    public ControlGroup[] a(int paramAnonymousInt)
    {
      return new ControlGroup[paramAnonymousInt];
    }
  };
  public final int a;
  public final String b;
  public final String c;
  
  protected ControlGroup(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  protected ControlGroup(String paramString)
    throws NumberFormatException, IndexOutOfBoundsException
  {
    paramString = paramString.split(":");
    this.a = Integer.parseInt(paramString[0]);
    this.b = paramString[1];
    this.c = paramString[2];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("%d:%s:%s", new Object[] { Integer.valueOf(this.a), this.b, this.c });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/models/ControlGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */