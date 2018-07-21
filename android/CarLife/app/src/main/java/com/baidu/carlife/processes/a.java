package com.baidu.carlife.processes;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.processes.models.AndroidAppProcess;
import com.baidu.carlife.processes.models.AndroidAppProcess.a;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static final String a = "AndroidProcesses";
  private static final int b = 1;
  private static final int c = 2;
  private static final String d = "com.android.incallui";
  private static List<String> e = new ArrayList();
  private static List<String> f;
  private static List<String> g;
  
  static
  {
    e.add("com.motorola.audiomonitor");
    e.add("com.qiyi.video");
    f = new ArrayList();
    f.add("com.google.android.dialer");
    f.add("com.android.incallui");
    f.add("com.android.dialer");
    if (Build.VERSION.SDK_INT < 21) {
      f.add("com.android.phone");
    }
    g = new ArrayList();
    g.add("SM-N9106W");
    g.add("SCH-I959");
    g.add("SM-G9008V");
    g.add("SM-G9200");
  }
  
  private a()
  {
    throw new AssertionError("no instances");
  }
  
  /* Error */
  public static List<AndroidAppProcess> a()
  {
    // Byte code:
    //   0: new 27	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 30	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 83	java/io/File
    //   11: dup
    //   12: ldc 85
    //   14: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 92	java/io/File:listFiles	()[Ljava/io/File;
    //   20: astore 4
    //   22: aload 4
    //   24: arraylength
    //   25: istore_1
    //   26: iconst_0
    //   27: istore_0
    //   28: iload_0
    //   29: iload_1
    //   30: if_icmpge +53 -> 83
    //   33: aload 4
    //   35: iload_0
    //   36: aaload
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 96	java/io/File:isDirectory	()Z
    //   44: ifeq +27 -> 71
    //   47: aload 5
    //   49: invokevirtual 100	java/io/File:getName	()Ljava/lang/String;
    //   52: invokestatic 106	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   55: istore_2
    //   56: aload_3
    //   57: new 108	com/baidu/carlife/processes/models/AndroidAppProcess
    //   60: dup
    //   61: iload_2
    //   62: invokespecial 111	com/baidu/carlife/processes/models/AndroidAppProcess:<init>	(I)V
    //   65: invokeinterface 40 2 0
    //   70: pop
    //   71: iload_0
    //   72: iconst_1
    //   73: iadd
    //   74: istore_0
    //   75: goto -47 -> 28
    //   78: astore 5
    //   80: goto -9 -> 71
    //   83: aload_3
    //   84: areturn
    //   85: astore 5
    //   87: goto -16 -> 71
    //   90: astore 5
    //   92: goto -21 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	48	0	i	int
    //   25	6	1	j	int
    //   55	7	2	k	int
    //   7	77	3	localArrayList	ArrayList
    //   20	14	4	arrayOfFile	File[]
    //   37	11	5	localFile	File
    //   78	1	5	localNumberFormatException	NumberFormatException
    //   85	1	5	localIOException	IOException
    //   90	1	5	locala	AndroidAppProcess.a
    // Exception table:
    //   from	to	target	type
    //   47	56	78	java/lang/NumberFormatException
    //   56	71	85	java/io/IOException
    //   56	71	90	com/baidu/carlife/processes/models/AndroidAppProcess$a
  }
  
  public static List<AndroidAppProcess> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = new File("/proc").listFiles();
    paramContext = paramContext.getPackageManager();
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label165;
      }
      Object localObject = arrayOfFile[i];
      if (((File)localObject).isDirectory()) {}
      for (;;)
      {
        try
        {
          k = Integer.parseInt(((File)localObject).getName());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int k;
          continue;
        }
        try
        {
          localObject = new AndroidAppProcess(k);
          if ((((AndroidAppProcess)localObject).a) && (!((AndroidAppProcess)localObject).c.contains(":")) && (((((AndroidAppProcess)localObject).b >= 1000) && (((AndroidAppProcess)localObject).b <= 9999)) || ((paramContext.getLaunchIntentForPackage(((AndroidAppProcess)localObject).a()) != null) || (f.contains(((AndroidAppProcess)localObject).a()))))) {
            localArrayList.add(localObject);
          }
        }
        catch (IOException localIOException) {}catch (AndroidAppProcess.a locala) {}
      }
      i += 1;
    }
    label165:
    return localArrayList;
  }
  
  public static boolean b()
  {
    Object localObject = a();
    int i = Process.myPid();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AndroidAppProcess localAndroidAppProcess = (AndroidAppProcess)((Iterator)localObject).next();
      if ((localAndroidAppProcess.d == i) && (localAndroidAppProcess.a)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    return e(paramContext);
  }
  
  public static String c(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      String str1 = i(paramContext);
      if ((Build.MANUFACTURER.equals("motorola")) || (Build.MANUFACTURER.equals("sony")))
      {
        str1 = "";
        i.b("AndroidProcesses", "motorola's mobile need special handle。 model=" + Build.MODEL);
      }
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = g(paramContext);
      }
      return str2;
    }
    return h(paramContext);
  }
  
  private static boolean d(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = a(paramContext);
      if (!paramContext.isEmpty())
      {
        Object localObject = null;
        Iterator localIterator = paramContext.iterator();
        do
        {
          paramContext = (Context)localObject;
          if (!localIterator.hasNext()) {
            break;
          }
          paramContext = (AndroidAppProcess)localIterator.next();
        } while (!f.contains(paramContext.a()));
        if ((paramContext != null) && (paramContext.b >= 1000) && (paramContext.b < 10000)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean e(Context paramContext)
  {
    return f.contains(c(paramContext));
  }
  
  private static boolean f(Context paramContext)
  {
    Object localObject = a(paramContext);
    paramContext = paramContext.getPackageName();
    int m = 0;
    int i = 0;
    int k = 0;
    int j = 0;
    if (!((List)localObject).isEmpty())
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        k = j;
        m = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        AndroidAppProcess localAndroidAppProcess = (AndroidAppProcess)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localAndroidAppProcess.a())) && (f.contains(localAndroidAppProcess.a()))) {
          i = 1;
        } else if ((!TextUtils.isEmpty(localAndroidAppProcess.a())) && (TextUtils.equals(paramContext, localAndroidAppProcess.a()))) {
          j = 1;
        }
      }
    }
    return (m != 0) && (k == 0);
  }
  
  private static String g(Context paramContext)
  {
    String str = "";
    List localList = a(paramContext);
    paramContext = str;
    if (!localList.isEmpty())
    {
      paramContext = e.iterator();
      while (paramContext.hasNext())
      {
        str = (String)paramContext.next();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if (TextUtils.equals(str, ((AndroidAppProcess)localIterator.next()).a())) {
            localIterator.remove();
          }
        }
      }
      Collections.sort(localList, new a());
      paramContext = ((AndroidAppProcess)localList.get(0)).a();
    }
    return paramContext;
  }
  
  private static String h(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(Integer.MAX_VALUE);
    paramContext = null;
    if (localList != null) {
      paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName();
    }
    return paramContext;
  }
  
  private static String i(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      localObject3 = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
      localObject1 = localObject3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject3;
        Iterator localIterator;
        i.e("AndroidProcesses", localException1.getMessage());
      }
    }
    localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    do
    {
      do
      {
        paramContext = (Context)localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject3 = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      } while ((((ActivityManager.RunningAppProcessInfo)localObject3).importance != 100) || (((ActivityManager.RunningAppProcessInfo)localObject3).importanceReasonCode != 0));
      paramContext = null;
      try
      {
        int i = ((Field)localObject1).getInt(localObject3);
        paramContext = Integer.valueOf(i);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          i.e("AndroidProcesses", localException2.getMessage());
        }
      }
    } while ((paramContext == null) || ((paramContext.intValue() != 2) && (paramContext.intValue() != 1)));
    paramContext = (Context)localObject3;
    if (paramContext != null) {
      return paramContext.processName;
    }
    return "";
  }
  
  public static final class a
    implements Comparator<AndroidAppProcess>
  {
    public int a(AndroidAppProcess paramAndroidAppProcess1, AndroidAppProcess paramAndroidAppProcess2)
    {
      try
      {
        int i = paramAndroidAppProcess1.e();
        int j = paramAndroidAppProcess2.e();
        return i - j;
      }
      catch (IOException paramAndroidAppProcess1)
      {
        paramAndroidAppProcess1.printStackTrace();
      }
      return 0;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */