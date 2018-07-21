package com.baidu.navisdk.util.common;

import android.content.Context;
import android.os.Build;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.json.JSONObject;

public class SystemInfoUtils
{
  public static final String K_CPU_FEATURE_NEON = "neon";
  public static final String K_CPU_FEATURE_UNKNOWN = "unknown";
  public static final String K_CPU_FEATURE_VFP = "vfp";
  public static final String K_CPU_FEATURE_VFPV3 = "vfpv3";
  public static final String K_CPU_MODEL_UNKNOWN = "unknown";
  public static final String K_CPU_MODEL_V5 = "armv5";
  public static final String K_CPU_MODEL_V6 = "armv6";
  public static final String K_CPU_MODEL_V7 = "armv7";
  public static final String K_CPU_MODEL_X86 = "x86";
  private static final String kCpuInfoMaxFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";
  
  public static CPUInfo getCPUInfo()
  {
    for (;;)
    {
      try
      {
        localObject = new byte['Ѐ'];
        new RandomAccessFile("/proc/cpuinfo", "r").read((byte[])localObject);
        localObject = new String((byte[])localObject);
        int i = ((String)localObject).indexOf(0);
        if (i == -1) {
          continue;
        }
        localObject = ((String)localObject).substring(0, i);
      }
      catch (IOException localIOException)
      {
        Object localObject = "";
        localIOException.printStackTrace();
        continue;
      }
      localObject = parseCPUInfo((String)localObject);
      ((CPUInfo)localObject).mCPUMaxFreq = getMaxCpuFreq();
      return (CPUInfo)localObject;
    }
  }
  
  public static String getCpuFeature()
  {
    CPUInfo localCPUInfo = getCPUInfo();
    if ((localCPUInfo.mCPUFeature & 0x100) == 256) {
      return "neon";
    }
    if ((localCPUInfo.mCPUFeature & 0x1) == 1) {
      return "vfp";
    }
    if ((localCPUInfo.mCPUFeature & 0x10) == 16) {
      return "vfpv3";
    }
    return "unknown";
  }
  
  public static String getCpuModel()
  {
    CPUInfo localCPUInfo = getCPUInfo();
    if ((localCPUInfo.mCPUType & 0x1) == 1) {
      return "armv5";
    }
    if ((localCPUInfo.mCPUType & 0x10) == 16) {
      return "armv6";
    }
    if ((localCPUInfo.mCPUType & 0x100) == 256) {
      return "armv7";
    }
    return "unknown";
  }
  
  public static String getCpuString()
  {
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return "Intel";
    }
    try
    {
      Object localObject = new byte['Ѐ'];
      new RandomAccessFile("/proc/cpuinfo", "r").read((byte[])localObject);
      localObject = new String((byte[])localObject);
      int i = ((String)localObject).indexOf(0);
      if (i != -1)
      {
        localObject = ((String)localObject).substring(0, i);
        return (String)localObject;
      }
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return "";
  }
  
  public static String getCpuType()
  {
    String str2 = getCpuString();
    String str1;
    if (str2.contains("ARMv5"))
    {
      str1 = "armv5";
      if (!str2.contains("neon")) {
        break label95;
      }
      str1 = str1 + "_neon";
    }
    for (;;)
    {
      return str1;
      if (str2.contains("ARMv6"))
      {
        str1 = "armv6";
        break;
      }
      if (str2.contains("ARMv7"))
      {
        str1 = "armv7";
        break;
      }
      if (str2.contains("Intel"))
      {
        str1 = "x86";
        break;
      }
      return "unknown";
      label95:
      if (str2.contains("vfpv3")) {
        str1 = str1 + "_vfpv3";
      } else if (str2.contains(" vfp")) {
        str1 = str1 + "_vfp";
      } else {
        str1 = str1 + "_none";
      }
    }
  }
  
  public static String getIpAddress(Context paramContext)
  {
    localObject = null;
    try
    {
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      if (localEnumeration1.hasMoreElements())
      {
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        paramContext = (Context)localObject;
        for (;;)
        {
          localObject = paramContext;
          if (!localEnumeration2.hasMoreElements()) {
            break;
          }
          localObject = (InetAddress)localEnumeration2.nextElement();
          if (!((InetAddress)localObject).isLoopbackAddress()) {
            paramContext = ((InetAddress)localObject).getHostAddress().toString();
          }
        }
      }
      return (String)localObject;
    }
    catch (SocketException paramContext)
    {
      return null;
    }
  }
  
  /* Error */
  private static int getMaxCpuFreq()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_0
    //   4: aconst_null
    //   5: astore 9
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 8
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 6
    //   21: aconst_null
    //   22: astore 5
    //   24: new 181	java/io/FileReader
    //   27: dup
    //   28: ldc 36
    //   30: invokespecial 184	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   33: astore_2
    //   34: new 186	java/io/BufferedReader
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 189	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 192	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull +12 -> 63
    //   54: aload 4
    //   56: invokevirtual 195	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 201	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore_0
    //   63: aload_2
    //   64: ifnull +7 -> 71
    //   67: aload_2
    //   68: invokevirtual 204	java/io/FileReader:close	()V
    //   71: aload_3
    //   72: ifnull +228 -> 300
    //   75: aload_3
    //   76: invokevirtual 205	java/io/BufferedReader:close	()V
    //   79: iload_0
    //   80: ireturn
    //   81: astore_2
    //   82: aload_2
    //   83: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   86: goto -15 -> 71
    //   89: astore_2
    //   90: aload_2
    //   91: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   94: iload_0
    //   95: ireturn
    //   96: astore 6
    //   98: aload 8
    //   100: astore_2
    //   101: aload 5
    //   103: astore_3
    //   104: aload_2
    //   105: astore 4
    //   107: aload 6
    //   109: invokevirtual 206	java/io/FileNotFoundException:printStackTrace	()V
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 204	java/io/FileReader:close	()V
    //   120: iload_1
    //   121: istore_0
    //   122: aload 5
    //   124: ifnull -45 -> 79
    //   127: aload 5
    //   129: invokevirtual 205	java/io/BufferedReader:close	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: astore_2
    //   135: aload_2
    //   136: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_2
    //   142: aload_2
    //   143: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   146: goto -26 -> 120
    //   149: astore 6
    //   151: aload 9
    //   153: astore_2
    //   154: aload 7
    //   156: astore 5
    //   158: aload 5
    //   160: astore_3
    //   161: aload_2
    //   162: astore 4
    //   164: aload 6
    //   166: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 204	java/io/FileReader:close	()V
    //   177: iload_1
    //   178: istore_0
    //   179: aload 5
    //   181: ifnull -102 -> 79
    //   184: aload 5
    //   186: invokevirtual 205	java/io/BufferedReader:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_2
    //   199: aload_2
    //   200: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   203: goto -26 -> 177
    //   206: astore_2
    //   207: aload 4
    //   209: ifnull +8 -> 217
    //   212: aload 4
    //   214: invokevirtual 204	java/io/FileReader:close	()V
    //   217: aload_3
    //   218: ifnull +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 205	java/io/BufferedReader:close	()V
    //   225: aload_2
    //   226: athrow
    //   227: astore 4
    //   229: aload 4
    //   231: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   234: goto -17 -> 217
    //   237: astore_3
    //   238: aload_3
    //   239: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   242: goto -17 -> 225
    //   245: astore 5
    //   247: aload 6
    //   249: astore_3
    //   250: aload_2
    //   251: astore 4
    //   253: aload 5
    //   255: astore_2
    //   256: goto -49 -> 207
    //   259: astore 5
    //   261: aload_2
    //   262: astore 4
    //   264: aload 5
    //   266: astore_2
    //   267: goto -60 -> 207
    //   270: astore 6
    //   272: aload 7
    //   274: astore 5
    //   276: goto -118 -> 158
    //   279: astore 6
    //   281: aload_3
    //   282: astore 5
    //   284: goto -126 -> 158
    //   287: astore 6
    //   289: goto -188 -> 101
    //   292: astore 6
    //   294: aload_3
    //   295: astore 5
    //   297: goto -196 -> 101
    //   300: iload_0
    //   301: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	298	0	i	int
    //   1	177	1	j	int
    //   33	35	2	localFileReader	FileReader
    //   81	2	2	localIOException1	IOException
    //   89	2	2	localIOException2	IOException
    //   100	17	2	localObject1	Object
    //   134	2	2	localIOException3	IOException
    //   141	2	2	localIOException4	IOException
    //   153	21	2	localObject2	Object
    //   191	2	2	localIOException5	IOException
    //   198	2	2	localIOException6	IOException
    //   206	45	2	localObject3	Object
    //   255	12	2	localObject4	Object
    //   17	205	3	localObject5	Object
    //   237	2	3	localIOException7	IOException
    //   249	46	3	localObject6	Object
    //   8	205	4	localObject7	Object
    //   227	3	4	localIOException8	IOException
    //   251	12	4	localObject8	Object
    //   22	163	5	localObject9	Object
    //   245	9	5	localObject10	Object
    //   259	6	5	localObject11	Object
    //   274	22	5	localObject12	Object
    //   19	1	6	localObject13	Object
    //   96	12	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   149	99	6	localIOException9	IOException
    //   270	1	6	localIOException10	IOException
    //   279	1	6	localIOException11	IOException
    //   287	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   292	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   14	259	7	localObject14	Object
    //   11	88	8	localObject15	Object
    //   5	147	9	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   67	71	81	java/io/IOException
    //   75	79	89	java/io/IOException
    //   24	34	96	java/io/FileNotFoundException
    //   127	132	134	java/io/IOException
    //   116	120	141	java/io/IOException
    //   24	34	149	java/io/IOException
    //   184	189	191	java/io/IOException
    //   173	177	198	java/io/IOException
    //   24	34	206	finally
    //   107	112	206	finally
    //   164	169	206	finally
    //   212	217	227	java/io/IOException
    //   221	225	237	java/io/IOException
    //   34	43	245	finally
    //   43	49	259	finally
    //   54	63	259	finally
    //   34	43	270	java/io/IOException
    //   43	49	279	java/io/IOException
    //   54	63	279	java/io/IOException
    //   34	43	287	java/io/FileNotFoundException
    //   43	49	292	java/io/FileNotFoundException
    //   54	63	292	java/io/FileNotFoundException
  }
  
  public static String getMobileInfo()
  {
    localJSONObject = new JSONObject();
    try
    {
      Field[] arrayOfField = Build.class.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        localField.setAccessible(true);
        localJSONObject.put(localField.getName(), localField.get(null).toString());
        i += 1;
      }
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static long getTotalMemory()
  {
    long l = 0L;
    try
    {
      FileReader localFileReader = new FileReader("/proc/meminfo");
      BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
      String str = localBufferedReader.readLine();
      if (str != null) {
        l = Integer.valueOf(str.split("\\s+")[1]).intValue() / 1024;
      }
      localBufferedReader.close();
      localFileReader.close();
      return l;
    }
    catch (IOException localIOException) {}
    return -1L;
  }
  
  private static CPUInfo parseCPUInfo(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramString = null;
    }
    CPUInfo localCPUInfo;
    String[] arrayOfString;
    int k;
    int i;
    label146:
    do
    {
      return paramString;
      localCPUInfo = new CPUInfo();
      localCPUInfo.mCPUType = 0;
      localCPUInfo.mCPUFeature = 0;
      localCPUInfo.mCPUCount = 1;
      localCPUInfo.mBogoMips = 0.0D;
      if (!paramString.contains("ARMv5")) {
        break;
      }
      localCPUInfo.mCPUType = 1;
      if (paramString.contains("neon")) {
        localCPUInfo.mCPUFeature |= 0x100;
      }
      if (paramString.contains("vfpv3")) {
        localCPUInfo.mCPUFeature |= 0x10;
      }
      if (paramString.contains(" vfp")) {
        localCPUInfo.mCPUFeature |= 0x1;
      }
      arrayOfString = paramString.split("\n");
      k = arrayOfString.length;
      i = 0;
      paramString = localCPUInfo;
    } while (i >= k);
    paramString = arrayOfString[i];
    int j;
    if (paramString.contains("CPU variant"))
    {
      j = paramString.indexOf(": ");
      if (j >= 0) {
        paramString = paramString.substring(j + 2);
      }
    }
    for (;;)
    {
      try
      {
        localCPUInfo.mCPUCount = Integer.decode(paramString).intValue();
        if (localCPUInfo.mCPUCount != 0) {
          continue;
        }
        j = 1;
        localCPUInfo.mCPUCount = j;
      }
      catch (NumberFormatException paramString)
      {
        localCPUInfo.mCPUCount = 1;
        continue;
      }
      i += 1;
      break label146;
      if (paramString.contains("ARMv6"))
      {
        localCPUInfo.mCPUType = 16;
        break;
      }
      if (!paramString.contains("ARMv7")) {
        break;
      }
      localCPUInfo.mCPUType = 256;
      break;
      j = localCPUInfo.mCPUCount;
      continue;
      if (paramString.contains("BogoMIPS"))
      {
        j = paramString.indexOf(": ");
        if (j >= 0) {
          paramString.substring(j + 2);
        }
      }
    }
  }
  
  public static class CPUInfo
  {
    public static final int CPU_FEATURE_NEON = 256;
    public static final int CPU_FEATURE_UNKNOWS = 0;
    public static final int CPU_FEATURE_VFP = 1;
    public static final int CPU_FEATURE_VFPV3 = 16;
    public static final int CPU_TYPE_ARMV5TE = 1;
    public static final int CPU_TYPE_ARMV6 = 16;
    public static final int CPU_TYPE_ARMV7 = 256;
    public static final int CPU_TYPE_UNKNOWN = 0;
    public double mBogoMips;
    public int mCPUCount;
    public int mCPUFeature;
    public long mCPUMaxFreq;
    public int mCPUType;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/SystemInfoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */