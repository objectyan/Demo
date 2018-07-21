package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.io.IOException;

public class AndroidProcess
  implements Parcelable
{
  public static final Parcelable.Creator<AndroidProcess> CREATOR = new Parcelable.Creator()
  {
    public AndroidProcess a(Parcel paramAnonymousParcel)
    {
      return new AndroidProcess(paramAnonymousParcel);
    }
    
    public AndroidProcess[] a(int paramAnonymousInt)
    {
      return new AndroidProcess[paramAnonymousInt];
    }
  };
  public final String c;
  public final int d;
  
  public AndroidProcess(int paramInt)
    throws IOException
  {
    this.d = paramInt;
    this.c = a(paramInt);
  }
  
  protected AndroidProcess(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
  }
  
  static String a(int paramInt)
    throws IOException
  {
    Object localObject1 = null;
    try
    {
      localObject2 = ProcFile.b(String.format("/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) })).trim();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = Stat.a(paramInt).b();
    }
    return (String)localObject2;
  }
  
  public String a(String paramString)
    throws IOException
  {
    return ProcFile.b(String.format("/proc/%d/%s", new Object[] { Integer.valueOf(this.d), paramString }));
  }
  
  public String b()
    throws IOException
  {
    return a("attr/current");
  }
  
  public String c()
    throws IOException
  {
    return a("cmdline");
  }
  
  public Cgroup d()
    throws IOException
  {
    return Cgroup.a(this.d);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
    throws IOException
  {
    return Integer.parseInt(a("oom_score"));
  }
  
  public int f()
    throws IOException
  {
    return Integer.parseInt(a("oom_adj"));
  }
  
  public int g()
    throws IOException
  {
    return Integer.parseInt(a("oom_score_adj"));
  }
  
  public Stat h()
    throws IOException
  {
    return Stat.a(this.d);
  }
  
  public Statm i()
    throws IOException
  {
    return Statm.a(this.d);
  }
  
  public Status j()
    throws IOException
  {
    return Status.a(this.d);
  }
  
  public String k()
    throws IOException
  {
    return a("wchan");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/models/AndroidProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */