package com.baidu.navisdk.util.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProcessManagerUtils
{
  private static final String APP_ID_PATTERN = "app_\\d+";
  private static final String OPEN_API_DEFAULT_FLAG = "1";
  private static final String[] OPEN_API_OS_SRC = { "com.sdu.didi", "com.ubercab.driver", "com.szzc.ucar.pilot", "com.ehaidriver.activity", "com.yongche" };
  private static final String TAG = "ProcessManager";
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      APP_ID_PATTERN = "u\\d+_a\\d+";
      return;
    }
  }
  
  public static String getOpenApiStatFlag()
  {
    Object localObject2;
    int i;
    try
    {
      localObject2 = getRunningApps();
      if (localObject2 == null) {
        return "1";
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localObject1 = new ArrayList();
      if (Build.VERSION.SDK_INT < 17) {
        break label208;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Process localProcess = (Process)((Iterator)localObject2).next();
        i = 0;
        if (i < OPEN_API_OS_SRC.length)
        {
          if ((localProcess.getPackageName() == null) || (!localProcess.getPackageName().startsWith(OPEN_API_OS_SRC[i]))) {
            break label302;
          }
          if (!((ArrayList)localObject1).contains(Integer.valueOf(i + 2))) {
            ((ArrayList)localObject1).add(Integer.valueOf(i + 2));
          }
          LogUtil.e("ProcessManagerUtils is osSrc:", localProcess.getPackageName());
          break label302;
        }
        LogUtil.e("ProcessManagerUtils:", localProcess.getPackageName());
      }
      Collections.sort((List)localObject1);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return "1";
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty(localException.toString())) {
        localException.append("-");
      }
      localException.append(localObject2);
      continue;
      label208:
      if (((List)localObject2).size() <= 1) {
        return "1";
      }
      localObject1 = (Process)((List)localObject2).get(((List)localObject2).size() - 1);
      i = 0;
    }
    for (;;)
    {
      if (i < OPEN_API_OS_SRC.length)
      {
        if ((((Process)localObject1).getPackageName() != null) && (((Process)localObject1).getPackageName().equals(OPEN_API_OS_SRC[i]))) {
          localException.append(i + 2);
        }
      }
      else
      {
        if (TextUtils.isEmpty(localException.toString())) {
          return "1";
        }
        String str = localException.toString();
        return str;
        label302:
        i += 1;
        break;
      }
      i += 1;
    }
  }
  
  public static List<Process> getRunningApps()
  {
    localArrayList = new ArrayList();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("toolbox ps -p -P -x -c").getInputStream()));
      localBufferedReader.readLine();
      int i = android.os.Process.myPid();
      for (;;)
      {
        Object localObject = localBufferedReader.readLine();
        if (localObject == null) {
          break;
        }
        localObject = new Process((String)localObject, null);
        if ((((Process)localObject).user.matches(APP_ID_PATTERN)) && (((Process)localObject).ppid != i) && (!((Process)localObject).name.equals("toolbox"))) {
          localArrayList.add(localObject);
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static List<Process> getRunningProcesses()
  {
    localArrayList = new ArrayList();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("toolbox ps -p -P -x -c").getInputStream()));
      localBufferedReader.readLine();
      android.os.Process.myPid();
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localArrayList.add(new Process(str, null));
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static class Process
    implements Parcelable
  {
    public static final Parcelable.Creator<Process> CREATOR = new Parcelable.Creator()
    {
      public ProcessManagerUtils.Process createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ProcessManagerUtils.Process(paramAnonymousParcel, null);
      }
      
      public ProcessManagerUtils.Process[] newArray(int paramAnonymousInt)
      {
        return new ProcessManagerUtils.Process[paramAnonymousInt];
      }
    };
    public final int cpu;
    public final String name;
    public final int niceness;
    public final String pc;
    public final int pid;
    public final String policy;
    public final int ppid;
    public final int priority;
    public final int realTimePriority;
    public final long rss;
    public final int schedulingPolicy;
    public final String state;
    public final long systemTime;
    public final int uid;
    public final String user;
    public final long userTime;
    public final long vsize;
    public final String wchan;
    
    private Process(Parcel paramParcel)
    {
      this.user = paramParcel.readString();
      this.uid = paramParcel.readInt();
      this.pid = paramParcel.readInt();
      this.ppid = paramParcel.readInt();
      this.vsize = paramParcel.readLong();
      this.rss = paramParcel.readLong();
      this.cpu = paramParcel.readInt();
      this.priority = paramParcel.readInt();
      this.niceness = paramParcel.readInt();
      this.realTimePriority = paramParcel.readInt();
      this.schedulingPolicy = paramParcel.readInt();
      this.policy = paramParcel.readString();
      this.wchan = paramParcel.readString();
      this.pc = paramParcel.readString();
      this.state = paramParcel.readString();
      this.name = paramParcel.readString();
      this.userTime = paramParcel.readLong();
      this.systemTime = paramParcel.readLong();
    }
    
    private Process(String paramString)
      throws Exception
    {
      paramString = paramString.split("\\s+");
      this.user = paramString[0];
      this.uid = android.os.Process.getUidForName(this.user);
      this.pid = Integer.parseInt(paramString[1]);
      this.ppid = Integer.parseInt(paramString[2]);
      this.vsize = (Integer.parseInt(paramString[3]) * 1024);
      this.rss = (Integer.parseInt(paramString[4]) * 1024);
      this.cpu = Integer.parseInt(paramString[5]);
      this.priority = Integer.parseInt(paramString[6]);
      this.niceness = Integer.parseInt(paramString[7]);
      this.realTimePriority = Integer.parseInt(paramString[8]);
      this.schedulingPolicy = Integer.parseInt(paramString[9]);
      if (paramString.length == 16)
      {
        this.policy = "";
        this.wchan = paramString[10];
        this.pc = paramString[11];
        this.state = paramString[12];
        this.name = paramString[13];
        this.userTime = (Integer.parseInt(paramString[14].split(":")[1].replace(",", "")) * 1000);
        this.systemTime = (Integer.parseInt(paramString[15].split(":")[1].replace(")", "")) * 1000);
        return;
      }
      this.policy = paramString[10];
      this.wchan = paramString[11];
      this.pc = paramString[12];
      this.state = paramString[13];
      this.name = paramString[14];
      this.userTime = (Integer.parseInt(paramString[15].split(":")[1].replace(",", "")) * 1000);
      this.systemTime = (Integer.parseInt(paramString[16].split(":")[1].replace(")", "")) * 1000);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public ApplicationInfo getApplicationInfo(Context paramContext, int paramInt)
      throws PackageManager.NameNotFoundException
    {
      String str = getPackageName();
      if (str == null) {
        throw new PackageManager.NameNotFoundException(this.name + " is not an application process");
      }
      return paramContext.getPackageManager().getApplicationInfo(str, paramInt);
    }
    
    public PackageInfo getPackageInfo(Context paramContext, int paramInt)
      throws PackageManager.NameNotFoundException
    {
      String str = getPackageName();
      if (str == null) {
        throw new PackageManager.NameNotFoundException(this.name + " is not an application process");
      }
      return paramContext.getPackageManager().getPackageInfo(str, paramInt);
    }
    
    public String getPackageName()
    {
      if (!this.user.matches(ProcessManagerUtils.APP_ID_PATTERN)) {
        return null;
      }
      if (this.name.contains(":")) {
        return this.name.split(":")[0];
      }
      return this.name;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.user);
      paramParcel.writeInt(this.uid);
      paramParcel.writeInt(this.pid);
      paramParcel.writeInt(this.ppid);
      paramParcel.writeLong(this.vsize);
      paramParcel.writeLong(this.rss);
      paramParcel.writeInt(this.cpu);
      paramParcel.writeInt(this.priority);
      paramParcel.writeInt(this.niceness);
      paramParcel.writeInt(this.realTimePriority);
      paramParcel.writeInt(this.schedulingPolicy);
      paramParcel.writeString(this.policy);
      paramParcel.writeString(this.wchan);
      paramParcel.writeString(this.pc);
      paramParcel.writeString(this.state);
      paramParcel.writeString(this.name);
      paramParcel.writeLong(this.userTime);
      paramParcel.writeLong(this.systemTime);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/ProcessManagerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */