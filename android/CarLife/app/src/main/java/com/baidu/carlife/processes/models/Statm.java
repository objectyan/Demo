package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.IOException;

public final class Statm
  extends ProcFile
{
  public static final Parcelable.Creator<Statm> CREATOR = new Parcelable.Creator()
  {
    public Statm a(Parcel paramAnonymousParcel)
    {
      return new Statm(paramAnonymousParcel, null);
    }
    
    public Statm[] a(int paramAnonymousInt)
    {
      return new Statm[paramAnonymousInt];
    }
  };
  public final String[] a;
  
  private Statm(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createStringArray();
  }
  
  private Statm(String paramString)
    throws IOException
  {
    super(paramString);
    this.a = this.b.split("\\s+");
  }
  
  public static Statm a(int paramInt)
    throws IOException
  {
    return new Statm(String.format("/proc/%d/statm", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public long a()
  {
    return Long.parseLong(this.a[0]) * 1024L;
  }
  
  public long b()
  {
    return Long.parseLong(this.a[1]) * 1024L;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeStringArray(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/models/Statm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */