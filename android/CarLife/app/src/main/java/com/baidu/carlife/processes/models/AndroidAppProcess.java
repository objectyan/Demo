package com.baidu.carlife.processes.models;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.File;
import java.io.IOException;

public class AndroidAppProcess
  extends AndroidProcess
{
  public static final Parcelable.Creator<AndroidAppProcess> CREATOR = new Parcelable.Creator()
  {
    public AndroidAppProcess a(Parcel paramAnonymousParcel)
    {
      return new AndroidAppProcess(paramAnonymousParcel);
    }
    
    public AndroidAppProcess[] a(int paramAnonymousInt)
    {
      return new AndroidAppProcess[paramAnonymousInt];
    }
  };
  private static final boolean e = new File("/dev/cpuctl/tasks").exists();
  public final boolean a;
  public final int b;
  
  public AndroidAppProcess(int paramInt)
    throws IOException, AndroidAppProcess.a
  {
    super(paramInt);
    if (e)
    {
      localObject = d();
      ControlGroup localControlGroup = ((Cgroup)localObject).a("cpuacct");
      localObject = ((Cgroup)localObject).a("cpu");
      if (Build.VERSION.SDK_INT >= 21)
      {
        if ((localObject == null) || (localControlGroup == null) || (!localControlGroup.c.contains("pid_"))) {
          throw new a(paramInt);
        }
        if (((ControlGroup)localObject).c.contains("bg_non_interactive")) {}
      }
      for (;;)
      {
        try
        {
          paramInt = Integer.parseInt(localControlGroup.c.split("/")[1].replace("uid_", ""));
          this.a = bool1;
          this.b = paramInt;
          return;
          bool1 = false;
          continue;
        }
        catch (Exception localException1)
        {
          paramInt = j().a();
          continue;
        }
        if ((localObject == null) || (localException1 == null) || (!((ControlGroup)localObject).c.contains("apps"))) {
          throw new a(paramInt);
        }
        if (!((ControlGroup)localObject).c.contains("bg_non_interactive")) {}
        for (bool1 = bool2;; bool1 = false) {
          try
          {
            paramInt = Integer.parseInt(localException1.c.substring(localException1.c.lastIndexOf("/") + 1));
          }
          catch (Exception localException2)
          {
            paramInt = j().a();
          }
        }
      }
    }
    if ((this.c.startsWith("/")) || (!new File("/data/data", a()).exists())) {
      throw new a(paramInt);
    }
    Stat localStat = h();
    Object localObject = j();
    if (localStat.O() == 0) {}
    for (bool1 = bool3;; bool1 = false)
    {
      paramInt = ((Status)localObject).a();
      break;
    }
  }
  
  protected AndroidAppProcess(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      this.b = paramParcel.readInt();
      return;
    }
  }
  
  public PackageInfo a(Context paramContext, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return paramContext.getPackageManager().getPackageInfo(a(), paramInt);
  }
  
  public String a()
  {
    return this.c.split(":")[0];
  }
  
  public String toString()
  {
    return "AndroidAppProcess{foreground=" + this.a + ", uid=" + this.b + ", name=" + this.c + ", pid=" + this.d + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.a) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.b);
      return;
    }
  }
  
  public static final class a
    extends Exception
  {
    public a(int paramInt)
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/models/AndroidAppProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */