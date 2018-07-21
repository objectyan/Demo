package com.baidu.tts.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DeviceId
{
  private static final String a;
  private static b b;
  private final Context c;
  private int d = 0;
  private PublicKey e;
  
  static
  {
    String str1 = new String(Base64.decode(new byte[] { 77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61 }));
    String str2 = new String(Base64.decode(new byte[] { 90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61 }));
    a = str1 + str2;
  }
  
  private DeviceId(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    a();
  }
  
  private static b a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null)
      {
        SystemClock.uptimeMillis();
        b = new DeviceId(paramContext).b();
        SystemClock.uptimeMillis();
      }
      return b;
    }
    finally {}
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 100	java/io/FileReader
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 103	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   11: astore_2
    //   12: aload_2
    //   13: astore_0
    //   14: sipush 8192
    //   17: newarray <illegal type>
    //   19: astore_3
    //   20: aload_2
    //   21: astore_0
    //   22: new 105	java/io/CharArrayWriter
    //   25: dup
    //   26: invokespecial 106	java/io/CharArrayWriter:<init>	()V
    //   29: astore 5
    //   31: aload_2
    //   32: astore_0
    //   33: aload_2
    //   34: aload_3
    //   35: invokevirtual 110	java/io/FileReader:read	([C)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifle +39 -> 79
    //   43: aload_2
    //   44: astore_0
    //   45: aload 5
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 114	java/io/CharArrayWriter:write	([CII)V
    //   53: goto -22 -> 31
    //   56: astore_3
    //   57: aload_2
    //   58: astore_0
    //   59: aload_3
    //   60: invokestatic 117	com/baidu/tts/tools/DeviceId:b	(Ljava/lang/Throwable;)V
    //   63: aload 4
    //   65: astore_0
    //   66: aload_2
    //   67: ifnull +10 -> 77
    //   70: aload_2
    //   71: invokevirtual 120	java/io/FileReader:close	()V
    //   74: aload 4
    //   76: astore_0
    //   77: aload_0
    //   78: areturn
    //   79: aload_2
    //   80: astore_0
    //   81: aload 5
    //   83: invokevirtual 121	java/io/CharArrayWriter:toString	()Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: astore_0
    //   89: aload_2
    //   90: ifnull -13 -> 77
    //   93: aload_2
    //   94: invokevirtual 120	java/io/FileReader:close	()V
    //   97: aload_3
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokestatic 117	com/baidu/tts/tools/DeviceId:b	(Ljava/lang/Throwable;)V
    //   104: aload_3
    //   105: areturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokestatic 117	com/baidu/tts/tools/DeviceId:b	(Ljava/lang/Throwable;)V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 120	java/io/FileReader:close	()V
    //   124: aload_2
    //   125: athrow
    //   126: astore_0
    //   127: aload_0
    //   128: invokestatic 117	com/baidu/tts/tools/DeviceId:b	(Ljava/lang/Throwable;)V
    //   131: goto -7 -> 124
    //   134: astore_2
    //   135: goto -19 -> 116
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_2
    //   141: goto -84 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramFile	File
    //   38	12	1	i	int
    //   11	83	2	localFileReader	java.io.FileReader
    //   113	12	2	localObject1	Object
    //   134	1	2	localObject2	Object
    //   140	1	2	localObject3	Object
    //   19	29	3	arrayOfChar	char[]
    //   56	4	3	localException1	Exception
    //   86	19	3	str	String
    //   138	1	3	localException2	Exception
    //   1	74	4	localObject4	Object
    //   29	53	5	localCharArrayWriter	java.io.CharArrayWriter
    // Exception table:
    //   from	to	target	type
    //   14	20	56	java/lang/Exception
    //   22	31	56	java/lang/Exception
    //   33	39	56	java/lang/Exception
    //   45	53	56	java/lang/Exception
    //   81	87	56	java/lang/Exception
    //   93	97	99	java/lang/Exception
    //   70	74	106	java/lang/Exception
    //   3	12	113	finally
    //   120	124	126	java/lang/Exception
    //   14	20	134	finally
    //   22	31	134	finally
    //   33	39	134	finally
    //   45	53	134	finally
    //   59	63	134	finally
    //   81	87	134	finally
    //   3	12	138	java/lang/Exception
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Base64.encode(AESUtil.encrypt(a, a, paramString.getBytes()), "utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      b(paramString);
      return "";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b(paramString);
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }
    String str1 = "";
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1) {}
      for (str1 = str1 + "0" + str2;; str1 = str1 + str2)
      {
        i += 1;
        break;
      }
    }
    return str1.toLowerCase();
  }
  
  private List<a> a(Intent paramIntent, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = this.c.getPackageManager();
    paramIntent = localPackageManager.queryBroadcastReceivers(paramIntent, 0);
    if (paramIntent != null) {
      paramIntent = paramIntent.iterator();
    }
    Object localObject3;
    do
    {
      if (!paramIntent.hasNext())
      {
        Collections.sort(localArrayList, new Comparator()
        {
          public int a(DeviceId.a paramAnonymousa1, DeviceId.a paramAnonymousa2)
          {
            int j = paramAnonymousa2.b - paramAnonymousa1.b;
            int i = j;
            if (j == 0)
            {
              if ((!paramAnonymousa1.d) || (!paramAnonymousa2.d)) {
                break label37;
              }
              i = 0;
            }
            label37:
            do
            {
              return i;
              if (paramAnonymousa1.d) {
                return -1;
              }
              i = j;
            } while (!paramAnonymousa2.d);
            return 1;
          }
        });
        return localArrayList;
      }
      localObject3 = (ResolveInfo)paramIntent.next();
    } while ((((ResolveInfo)localObject3).activityInfo == null) || (((ResolveInfo)localObject3).activityInfo.applicationInfo == null));
    for (;;)
    {
      try
      {
        Object localObject2 = localPackageManager.getReceiverInfo(new ComponentName(((ResolveInfo)localObject3).activityInfo.packageName, ((ResolveInfo)localObject3).activityInfo.name), 128).metaData;
        if (localObject2 == null) {
          break;
        }
        Object localObject1 = ((Bundle)localObject2).getString("galaxy_data");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        byte[] arrayOfByte = Base64.decode(((String)localObject1).getBytes("utf-8"));
        Object localObject4 = new JSONObject(new String(arrayOfByte));
        localObject1 = new a(null);
        ((a)localObject1).b = ((JSONObject)localObject4).getInt("priority");
        ((a)localObject1).a = ((ResolveInfo)localObject3).activityInfo.applicationInfo;
        if (this.c.getPackageName().equals(((ResolveInfo)localObject3).activityInfo.applicationInfo.packageName)) {
          ((a)localObject1).d = true;
        }
        if (paramBoolean)
        {
          localObject2 = ((Bundle)localObject2).getString("galaxy_sf");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = localPackageManager.getPackageInfo(((ResolveInfo)localObject3).activityInfo.applicationInfo.packageName, 64);
            localObject4 = ((JSONObject)localObject4).getJSONArray("sigs");
            String[] arrayOfString = new String[((JSONArray)localObject4).length()];
            i = 0;
            if (i < arrayOfString.length)
            {
              arrayOfString[i] = ((JSONArray)localObject4).getString(i);
              i += 1;
              continue;
            }
            if (a(arrayOfString, a(((PackageInfo)localObject3).signatures)))
            {
              localObject2 = a(Base64.decode(((String)localObject2).getBytes()), this.e);
              arrayOfByte = SHA1Util.sha1(arrayOfByte);
              if ((localObject2 == null) || (!Arrays.equals((byte[])localObject2, arrayOfByte))) {
                break label419;
              }
              i = 1;
              if (i != 0) {
                ((a)localObject1).c = true;
              }
            }
          }
        }
        localArrayList.add(localObject1);
      }
      catch (Exception localException) {}
      break;
      label419:
      int i = 0;
    }
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 333	java/io/ByteArrayInputStream
    //   5: dup
    //   6: invokestatic 337	com/baidu/tts/tools/a:a	()[B
    //   9: invokespecial 338	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: astore_1
    //   13: aload_0
    //   14: ldc_w 340
    //   17: invokestatic 346	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   20: aload_1
    //   21: invokevirtual 350	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   24: invokevirtual 356	java/security/cert/Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   27: putfield 311	com/baidu/tts/tools/DeviceId:e	Ljava/security/PublicKey;
    //   30: aload_1
    //   31: ifnull +7 -> 38
    //   34: aload_1
    //   35: invokevirtual 357	java/io/ByteArrayInputStream:close	()V
    //   38: return
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 117	com/baidu/tts/tools/DeviceId:b	(Ljava/lang/Throwable;)V
    //   44: return
    //   45: astore_1
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull -11 -> 38
    //   52: aload_1
    //   53: invokevirtual 357	java/io/ByteArrayInputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokestatic 117	com/baidu/tts/tools/DeviceId:b	(Ljava/lang/Throwable;)V
    //   62: return
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 357	java/io/ByteArrayInputStream:close	()V
    //   72: aload_1
    //   73: athrow
    //   74: astore_2
    //   75: aload_2
    //   76: invokestatic 117	com/baidu/tts/tools/DeviceId:b	(Ljava/lang/Throwable;)V
    //   79: goto -7 -> 72
    //   82: astore_3
    //   83: aload_1
    //   84: astore_2
    //   85: aload_3
    //   86: astore_1
    //   87: goto -23 -> 64
    //   90: astore_2
    //   91: goto -43 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	DeviceId
    //   12	23	1	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   39	2	1	localException1	Exception
    //   45	1	1	localException2	Exception
    //   47	6	1	localObject1	Object
    //   57	2	1	localException3	Exception
    //   63	21	1	localObject2	Object
    //   86	1	1	localObject3	Object
    //   1	68	2	localObject4	Object
    //   74	2	2	localException4	Exception
    //   84	1	2	localObject5	Object
    //   90	1	2	localException5	Exception
    //   82	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   34	38	39	java/lang/Exception
    //   2	13	45	java/lang/Exception
    //   52	56	57	java/lang/Exception
    //   2	13	63	finally
    //   68	72	74	java/lang/Exception
    //   13	30	82	finally
    //   13	30	90	java/lang/Exception
  }
  
  private static void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString2);
      paramString1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
      paramString2 = new File(paramString1, ".cuid");
    }
    try
    {
      if ((paramString1.exists()) && (!paramString1.isDirectory()))
      {
        Random localRandom = new Random();
        File localFile1 = paramString1.getParentFile();
        String str = paramString1.getName();
        File localFile2;
        do
        {
          localFile2 = new File(localFile1, str + localRandom.nextInt() + ".tmp");
        } while (localFile2.exists());
        paramString1.renameTo(localFile2);
        localFile2.delete();
      }
      paramString1.mkdirs();
      paramString1 = new FileWriter(paramString2, false);
      paramString1.write(Base64.encode(AESUtil.encrypt(a, a, localStringBuilder.toString().getBytes()), "utf-8"));
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (Exception paramString1) {}catch (IOException paramString1) {}
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    boolean bool2 = false;
    int j = 0;
    boolean bool1 = bool2;
    if (paramArrayOfString1 != null)
    {
      bool1 = bool2;
      if (paramArrayOfString2 != null)
      {
        bool1 = bool2;
        if (paramArrayOfString1.length == paramArrayOfString2.length)
        {
          HashSet localHashSet = new HashSet();
          int k = paramArrayOfString1.length;
          int i = 0;
          while (i < k)
          {
            localHashSet.add(paramArrayOfString1[i]);
            i += 1;
          }
          paramArrayOfString1 = new HashSet();
          k = paramArrayOfString2.length;
          i = j;
          while (i < k)
          {
            paramArrayOfString1.add(paramArrayOfString2[i]);
            i += 1;
          }
          bool1 = localHashSet.equals(paramArrayOfString1);
        }
      }
    }
    return bool1;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, PublicKey paramPublicKey)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPublicKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private String[] a(Signature[] paramArrayOfSignature)
  {
    String[] arrayOfString = new String[paramArrayOfSignature.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = a(SHA1Util.sha1(paramArrayOfSignature[i].toByteArray()));
      i += 1;
    }
    return arrayOfString;
  }
  
  private b b()
  {
    Object localObject4 = null;
    int j = 0;
    Object localObject1 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.c.getPackageName()), true);
    boolean bool;
    int i;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = (a)((List)localObject1).get(0);
      bool = ((a)localObject1).c;
      if (!((a)localObject1).c)
      {
        i = 0;
        while (i < 3)
        {
          Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
          i += 1;
        }
      }
    }
    for (;;)
    {
      localObject1 = new File(this.c.getFilesDir(), "libcuid.so");
      if (((File)localObject1).exists()) {}
      for (localObject1 = b.a(b(a((File)localObject1)));; localObject1 = null)
      {
        Object localObject2 = localObject1;
        Object localObject5;
        if (localObject1 == null)
        {
          this.d |= 0x10;
          localObject5 = a(new Intent("com.baidu.intent.action.GALAXY"), bool);
          localObject2 = localObject1;
          if (localObject5 != null)
          {
            localObject2 = this.c.getFilesDir();
            if ("files".equals(((File)localObject2).getName())) {
              break label994;
            }
            Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + ((File)localObject2).getAbsolutePath());
          }
        }
        label564:
        label963:
        label994:
        for (Object localObject3 = ((File)localObject2).getName();; localObject3 = "files")
        {
          localObject5 = ((List)localObject5).iterator();
          localObject2 = localObject1;
          if (((Iterator)localObject5).hasNext())
          {
            Object localObject6 = (a)((Iterator)localObject5).next();
            localObject2 = localObject1;
            if (!((a)localObject6).d)
            {
              localObject6 = new File(new File(((a)localObject6).a.dataDir, (String)localObject3), "libcuid.so");
              localObject2 = localObject1;
              if (((File)localObject6).exists())
              {
                localObject1 = b.a(b(a((File)localObject6)));
                localObject2 = localObject1;
                if (localObject1 == null) {}
              }
            }
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = b.a(b(f("com.baidu.deviceid.v2")));
            }
            bool = g("android.permission.READ_EXTERNAL_STORAGE");
            if ((localObject2 == null) && (bool))
            {
              this.d |= 0x2;
              localObject2 = e();
            }
            for (;;)
            {
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                this.d |= 0x8;
                localObject1 = d();
              }
              if ((localObject1 == null) && (bool))
              {
                this.d |= 0x1;
                localObject2 = i("");
                localObject1 = h((String)localObject2);
              }
              for (i = 1;; i = j)
              {
                if (localObject1 == null)
                {
                  this.d |= 0x4;
                  if (i == 0) {
                    localObject2 = i("");
                  }
                  localObject3 = new b(null);
                  localObject1 = getAndroidId(this.c);
                  if (Build.VERSION.SDK_INT < 23)
                  {
                    localObject5 = UUID.randomUUID().toString();
                    localObject1 = (String)localObject2 + (String)localObject1 + (String)localObject5;
                    ((b)localObject3).a = MD5Util.toMd5(((String)localObject1).getBytes(), true);
                    ((b)localObject3).b = ((String)localObject2);
                  }
                }
                for (;;)
                {
                  localObject2 = new File(this.c.getFilesDir(), "libcuid.so");
                  if ((this.d & 0x10) == 0)
                  {
                    localObject1 = localObject4;
                    if (((File)localObject2).exists()) {}
                  }
                  else
                  {
                    if (!TextUtils.isEmpty(null)) {
                      break label963;
                    }
                  }
                  for (localObject1 = a(((b)localObject3).a());; localObject1 = null)
                  {
                    e((String)localObject1);
                    bool = c();
                    localObject2 = localObject1;
                    if (bool) {
                      if ((this.d & 0x2) == 0)
                      {
                        localObject2 = localObject1;
                        if (!TextUtils.isEmpty(f("com.baidu.deviceid.v2"))) {}
                      }
                      else
                      {
                        localObject2 = localObject1;
                        if (TextUtils.isEmpty((CharSequence)localObject1)) {
                          localObject2 = a(((b)localObject3).a());
                        }
                        b("com.baidu.deviceid.v2", (String)localObject2);
                      }
                    }
                    if (g("android.permission.WRITE_EXTERNAL_STORAGE"))
                    {
                      localObject1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
                      if (((this.d & 0x8) != 0) || (!((File)localObject1).exists()))
                      {
                        localObject1 = localObject2;
                        if (TextUtils.isEmpty((CharSequence)localObject2)) {
                          localObject1 = a(((b)localObject3).a());
                        }
                        c((String)localObject1);
                      }
                    }
                    if ((bool) && (((this.d & 0x1) != 0) || (TextUtils.isEmpty(f("com.baidu.deviceid")))))
                    {
                      b("com.baidu.deviceid", ((b)localObject3).a);
                      b("bd_setting_i", ((b)localObject3).b);
                    }
                    if ((bool) && (!TextUtils.isEmpty(((b)localObject3).b)))
                    {
                      localObject1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
                      if (((this.d & 0x2) != 0) || (!((File)localObject1).exists())) {
                        a(((b)localObject3).b, ((b)localObject3).a);
                      }
                    }
                    return (b)localObject3;
                    i = 0;
                    while (i < 3)
                    {
                      Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
                      i += 1;
                    }
                    localObject1 = localObject2;
                    break;
                    localObject1 = "com.baidu" + (String)localObject1;
                    break label564;
                  }
                  localObject3 = localObject1;
                }
                localObject2 = null;
              }
            }
            localObject1 = localObject2;
          }
        }
      }
      bool = false;
    }
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new String(AESUtil.decrypt(a, a, Base64.decode(paramString.getBytes())));
      return paramString;
    }
    catch (Exception paramString)
    {
      b(paramString);
    }
    return "";
  }
  
  private static void b(Throwable paramThrowable) {}
  
  private boolean b(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = Settings.System.putString(this.c.getContentResolver(), paramString1, paramString2);
      return bool;
    }
    catch (Exception paramString1)
    {
      b(paramString1);
    }
    return false;
  }
  
  private static void c(String paramString)
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
    File localFile1 = new File((File)localObject, ".cuid2");
    try
    {
      if ((((File)localObject).exists()) && (!((File)localObject).isDirectory()))
      {
        Random localRandom = new Random();
        File localFile2 = ((File)localObject).getParentFile();
        String str = ((File)localObject).getName();
        File localFile3;
        do
        {
          localFile3 = new File(localFile2, str + localRandom.nextInt() + ".tmp");
        } while (localFile3.exists());
        ((File)localObject).renameTo(localFile3);
        localFile3.delete();
      }
      ((File)localObject).mkdirs();
      localObject = new FileWriter(localFile1, false);
      ((FileWriter)localObject).write(paramString);
      ((FileWriter)localObject).flush();
      ((FileWriter)localObject).close();
      return;
    }
    catch (Exception paramString) {}catch (IOException paramString) {}
  }
  
  private boolean c()
  {
    return g("android.permission.WRITE_SETTINGS");
  }
  
  private b d()
  {
    Object localObject3 = f("com.baidu.deviceid");
    Object localObject2 = f("bd_setting_i");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = i("");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        b("bd_setting_i", (String)localObject2);
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = getAndroidId(this.c);
      localObject2 = f(MD5Util.toMd5(("com.baidu" + (String)localObject1 + (String)localObject2).getBytes(), true));
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new b(null);
      ((b)localObject3).a = ((String)localObject2);
      ((b)localObject3).b = ((String)localObject1);
      return (b)localObject3;
    }
    return null;
  }
  
  private static String d(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains(":")) {
        str = "";
      }
    }
    return str;
  }
  
  private b e()
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
    if (((File)localObject).exists())
    {
      localObject = a((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = b.a(new String(AESUtil.decrypt(a, a, Base64.decode(((String)localObject).getBytes()))));
          return (b)localObject;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private boolean e(String paramString)
  {
    localObject2 = null;
    Object localObject1 = null;
    try
    {
      FileOutputStream localFileOutputStream = this.c.openFileOutput("libcuid.so", 1);
      localObject1 = localFileOutputStream;
      localObject2 = localFileOutputStream;
      localFileOutputStream.write(paramString.getBytes());
      localObject1 = localFileOutputStream;
      localObject2 = localFileOutputStream;
      localFileOutputStream.flush();
      if (localFileOutputStream != null) {}
      try
      {
        localFileOutputStream.close();
        return true;
      }
      catch (Exception paramString)
      {
        b(paramString);
        return true;
      }
      try
      {
        ((FileOutputStream)localObject2).close();
        throw paramString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          b(localException);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject2 = localObject1;
      b(paramString);
      if (localObject1 != null) {}
      try
      {
        ((FileOutputStream)localObject1).close();
        return false;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          b(paramString);
        }
      }
    }
    finally
    {
      if (localObject2 == null) {}
    }
  }
  
  private String f(String paramString)
  {
    try
    {
      paramString = Settings.System.getString(this.c.getContentResolver(), paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      b(paramString);
    }
    return null;
  }
  
  private boolean g(String paramString)
  {
    return this.c.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0;
  }
  
  public static String getAndroidId(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "";
    }
    return paramContext;
  }
  
  public static String getCUID(Context paramContext)
  {
    return a(paramContext).b();
  }
  
  public static String getDeviceID(Context paramContext)
  {
    return a(paramContext).a;
  }
  
  public static String getIMEI(Context paramContext)
  {
    return a(paramContext).b;
  }
  
  /* Error */
  private b h(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: getstatic 531	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmpge +18 -> 25
    //   10: iconst_1
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +17 -> 30
    //   16: aload_1
    //   17: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +10 -> 30
    //   23: aconst_null
    //   24: areturn
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -15 -> 12
    //   30: ldc -108
    //   32: astore 6
    //   34: new 363	java/io/File
    //   37: dup
    //   38: invokestatic 369	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   41: ldc_w 642
    //   44: invokespecial 374	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 379	java/io/File:exists	()Z
    //   54: ifne +310 -> 364
    //   57: new 363	java/io/File
    //   60: dup
    //   61: invokestatic 369	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   64: ldc_w 570
    //   67: invokespecial 374	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore 4
    //   72: new 644	java/io/BufferedReader
    //   75: dup
    //   76: new 100	java/io/FileReader
    //   79: dup
    //   80: aload 4
    //   82: invokespecial 103	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   85: invokespecial 647	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   88: astore 4
    //   90: new 54	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   97: astore 5
    //   99: aload 4
    //   101: invokevirtual 650	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   104: astore 7
    //   106: aload 7
    //   108: ifnull +59 -> 167
    //   111: aload 5
    //   113: aload 7
    //   115: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 5
    //   121: ldc_w 652
    //   124: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: goto -29 -> 99
    //   131: astore 4
    //   133: aload_1
    //   134: astore 5
    //   136: aload 6
    //   138: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +172 -> 313
    //   144: new 11	com/baidu/tts/tools/DeviceId$b
    //   147: dup
    //   148: aconst_null
    //   149: invokespecial 522	com/baidu/tts/tools/DeviceId$b:<init>	(Lcom/baidu/tts/tools/DeviceId$1;)V
    //   152: astore_1
    //   153: aload_1
    //   154: aload 6
    //   156: putfield 545	com/baidu/tts/tools/DeviceId$b:a	Ljava/lang/String;
    //   159: aload_1
    //   160: aload 5
    //   162: putfield 547	com/baidu/tts/tools/DeviceId$b:b	Ljava/lang/String;
    //   165: aload_1
    //   166: areturn
    //   167: aload 4
    //   169: invokevirtual 653	java/io/BufferedReader:close	()V
    //   172: new 24	java/lang/String
    //   175: dup
    //   176: getstatic 66	com/baidu/tts/tools/DeviceId:a	Ljava/lang/String;
    //   179: getstatic 66	com/baidu/tts/tools/DeviceId:a	Ljava/lang/String;
    //   182: aload 5
    //   184: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokevirtual 134	java/lang/String:getBytes	()[B
    //   190: invokestatic 39	com/baidu/tts/tools/Base64:decode	([B)[B
    //   193: invokestatic 579	com/baidu/tts/tools/AESUtil:decrypt	(Ljava/lang/String;Ljava/lang/String;[B)[B
    //   196: invokespecial 43	java/lang/String:<init>	([B)V
    //   199: ldc_w 361
    //   202: invokevirtual 657	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   205: astore 5
    //   207: aload 5
    //   209: ifnull +146 -> 355
    //   212: aload 5
    //   214: arraylength
    //   215: iconst_2
    //   216: if_icmpne +139 -> 355
    //   219: iload_2
    //   220: ifeq +65 -> 285
    //   223: aload_1
    //   224: aload 5
    //   226: iconst_0
    //   227: aaload
    //   228: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +54 -> 285
    //   234: aload 5
    //   236: iconst_1
    //   237: aaload
    //   238: astore 5
    //   240: aload_1
    //   241: astore 4
    //   243: aload 5
    //   245: astore_1
    //   246: aload_1
    //   247: astore 6
    //   249: aload 4
    //   251: astore 5
    //   253: iload_3
    //   254: ifne -118 -> 136
    //   257: aload 4
    //   259: aload_1
    //   260: invokestatic 572	com/baidu/tts/tools/DeviceId:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_1
    //   264: astore 6
    //   266: aload 4
    //   268: astore 5
    //   270: goto -134 -> 136
    //   273: astore 5
    //   275: aload_1
    //   276: astore 6
    //   278: aload 4
    //   280: astore 5
    //   282: goto -146 -> 136
    //   285: iload_2
    //   286: ifne +69 -> 355
    //   289: aload_1
    //   290: astore 4
    //   292: aload_1
    //   293: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   296: ifeq +9 -> 305
    //   299: aload 5
    //   301: iconst_1
    //   302: aaload
    //   303: astore 4
    //   305: aload 5
    //   307: iconst_1
    //   308: aaload
    //   309: astore_1
    //   310: goto -64 -> 246
    //   313: aconst_null
    //   314: areturn
    //   315: astore 4
    //   317: aload_1
    //   318: astore 5
    //   320: goto -184 -> 136
    //   323: astore 5
    //   325: aload_1
    //   326: astore 6
    //   328: aload 4
    //   330: astore 5
    //   332: goto -196 -> 136
    //   335: astore 4
    //   337: aload_1
    //   338: astore 5
    //   340: goto -204 -> 136
    //   343: astore 5
    //   345: aload_1
    //   346: astore 6
    //   348: aload 4
    //   350: astore 5
    //   352: goto -216 -> 136
    //   355: aload_1
    //   356: astore 4
    //   358: aload 6
    //   360: astore_1
    //   361: goto -115 -> 246
    //   364: iconst_0
    //   365: istore_3
    //   366: goto -294 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	DeviceId
    //   0	369	1	paramString	String
    //   11	275	2	i	int
    //   1	365	3	j	int
    //   47	53	4	localObject1	Object
    //   131	37	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   241	63	4	str1	String
    //   315	14	4	localException1	Exception
    //   335	14	4	localIOException1	IOException
    //   356	1	4	str2	String
    //   97	172	5	localObject2	Object
    //   273	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   280	39	5	str3	String
    //   323	1	5	localException2	Exception
    //   330	9	5	localObject3	Object
    //   343	1	5	localIOException2	IOException
    //   350	1	5	localIOException3	IOException
    //   32	327	6	str4	String
    //   104	10	7	str5	String
    // Exception table:
    //   from	to	target	type
    //   72	99	131	java/io/FileNotFoundException
    //   99	106	131	java/io/FileNotFoundException
    //   111	128	131	java/io/FileNotFoundException
    //   167	207	131	java/io/FileNotFoundException
    //   212	219	131	java/io/FileNotFoundException
    //   223	234	131	java/io/FileNotFoundException
    //   292	299	131	java/io/FileNotFoundException
    //   257	263	273	java/io/FileNotFoundException
    //   72	99	315	java/lang/Exception
    //   99	106	315	java/lang/Exception
    //   111	128	315	java/lang/Exception
    //   167	207	315	java/lang/Exception
    //   212	219	315	java/lang/Exception
    //   223	234	315	java/lang/Exception
    //   292	299	315	java/lang/Exception
    //   257	263	323	java/lang/Exception
    //   72	99	335	java/io/IOException
    //   99	106	335	java/io/IOException
    //   111	128	335	java/io/IOException
    //   167	207	335	java/io/IOException
    //   212	219	335	java/io/IOException
    //   223	234	335	java/io/IOException
    //   292	299	335	java/io/IOException
    //   257	263	343	java/io/IOException
  }
  
  private String i(String paramString)
  {
    try
    {
      localObject = (TelephonyManager)this.c.getSystemService("phone");
      if (localObject == null) {
        break label49;
      }
      localObject = ((TelephonyManager)localObject).getDeviceId();
    }
    catch (Exception localException)
    {
      label49:
      String str;
      for (;;)
      {
        Object localObject;
        Log.e("DeviceId", "Read IMEI failed", localException);
        str = null;
      }
      return str;
    }
    localObject = d((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return paramString;
    }
  }
  
  private static class a
  {
    public ApplicationInfo a;
    public int b = 0;
    public boolean c = false;
    public boolean d = false;
  }
  
  private static class b
  {
    public String a;
    public String b;
    public int c = 2;
    
    public static b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        return null;
        try
        {
          Object localObject = new JSONObject(paramString);
          paramString = ((JSONObject)localObject).getString("deviceid");
          String str = ((JSONObject)localObject).getString("imei");
          int i = ((JSONObject)localObject).getInt("ver");
          if ((!TextUtils.isEmpty(paramString)) && (str != null))
          {
            localObject = new b();
            ((b)localObject).a = paramString;
            ((b)localObject).b = str;
            ((b)localObject).c = i;
            return (b)localObject;
          }
        }
        catch (JSONException paramString)
        {
          DeviceId.a(paramString);
        }
      }
      return null;
    }
    
    public String a()
    {
      try
      {
        String str = new JSONObject().put("deviceid", this.a).put("imei", this.b).put("ver", this.c).toString();
        return str;
      }
      catch (JSONException localJSONException)
      {
        DeviceId.a(localJSONException);
      }
      return null;
    }
    
    public String b()
    {
      String str2 = this.b;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0";
      }
      str1 = new StringBuffer(str1).reverse().toString();
      return this.a + "|" + str1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/DeviceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */