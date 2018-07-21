package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.IOException;

public final class Status
  extends ProcFile
{
  public static final Parcelable.Creator<Status> CREATOR = new Parcelable.Creator()
  {
    public Status a(Parcel paramAnonymousParcel)
    {
      return new Status(paramAnonymousParcel, null);
    }
    
    public Status[] a(int paramAnonymousInt)
    {
      return new Status[paramAnonymousInt];
    }
  };
  
  private Status(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  private Status(String paramString)
    throws IOException
  {
    super(paramString);
  }
  
  public static Status a(int paramInt)
    throws IOException
  {
    return new Status(String.format("/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public int a()
  {
    int i = -1;
    try
    {
      String str = a("Uid");
      if (str != null) {
        i = Integer.parseInt(str.split("\\s+")[0]);
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public String a(String paramString)
  {
    String[] arrayOfString = this.b.split("\n");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.startsWith(paramString + ":")) {
        return str.split(paramString + ":")[1].trim();
      }
      i += 1;
    }
    return null;
  }
  
  public int b()
  {
    int i = -1;
    try
    {
      String str = a("Gid");
      if (str != null) {
        i = Integer.parseInt(str.split("\\s+")[0]);
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/models/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */