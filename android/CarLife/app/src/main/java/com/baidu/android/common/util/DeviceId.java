package com.baidu.android.common.util;

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
import android.system.ErrnoException;
import android.system.Os;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.security.SHA1Util;
import java.io.File;
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
  private static final String ACTION_GLAXY_CUID = "com.baidu.intent.action.GALAXY";
  private static final String AES_KEY;
  private static final boolean CONFIG_WRITE_V1_STORAGE = true;
  private static final boolean DEBUG = false;
  private static final String DEFAULT_TM_DEVICEID = "";
  private static final String EXT_DIR = "backups/.SystemConfig";
  private static final String EXT_FILE = ".cuid";
  private static final String EXT_FILE_V2 = ".cuid2";
  private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
  private static final String KEY_DEVICE_ID_V2 = "com.baidu.deviceid.v2";
  private static final String KEY_IMEI = "bd_setting_i";
  private static final String META_KEY_GALAXY_SF = "galaxy_sf";
  private static final String META_KEY_GLAXY_DATA = "galaxy_data";
  private static final String OLD_EXT_DIR = "baidu";
  private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
  private static final int SDK_ANDROID_M = 23;
  private static final String SELF_CUID_FILE = "libcuid.so";
  private static final int STORAGE_SDCARD_V1 = 4;
  private static final int STORAGE_SDCARD_V2 = 8;
  private static final int STORAGE_SELF_FILE = 16;
  private static final int STORAGE_SYSTEM_SETTING_V1 = 1;
  private static final int STORAGE_SYSTEM_SETTING_V2 = 2;
  private static final int S_IRGRP = 32;
  private static final int S_IROTH = 4;
  private static final int S_IRUSR = 256;
  private static final int S_IRWXG = 56;
  private static final int S_IRWXO = 7;
  private static final int S_IRWXU = 448;
  private static final int S_IWGRP = 16;
  private static final int S_IWOTH = 2;
  private static final int S_IWUSR = 128;
  private static final int S_IXGRP = 8;
  private static final int S_IXOTH = 1;
  private static final int S_IXUSR = 64;
  private static final String TAG = "DeviceId";
  private static CUIDInfo sCachedCuidInfo;
  private final Context mContext;
  private PublicKey mPublicKey;
  private int mSaveMask = 0;
  
  static
  {
    String str1 = new String(Base64.decode(new byte[] { 77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61 }));
    String str2 = new String(Base64.decode(new byte[] { 90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61 }));
    AES_KEY = str1 + str2;
  }
  
  private DeviceId(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    initPublicKey();
  }
  
  private static String byte2hex(byte[] paramArrayOfByte)
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
  
  private boolean checkSelfPermission(String paramString)
  {
    return this.mContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0;
  }
  
  private List<CUIDBuddyInfo> collectBuddyInfos(Intent paramIntent, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = this.mContext.getPackageManager();
    paramIntent = localPackageManager.queryBroadcastReceivers(paramIntent, 0);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        Object localObject3 = (ResolveInfo)paramIntent.next();
        if ((((ResolveInfo)localObject3).activityInfo != null) && (((ResolveInfo)localObject3).activityInfo.applicationInfo != null)) {
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
              localObject1 = new CUIDBuddyInfo(null);
              ((CUIDBuddyInfo)localObject1).priority = ((JSONObject)localObject4).getInt("priority");
              ((CUIDBuddyInfo)localObject1).appInfo = ((ResolveInfo)localObject3).activityInfo.applicationInfo;
              if (this.mContext.getPackageName().equals(((ResolveInfo)localObject3).activityInfo.applicationInfo.packageName)) {
                ((CUIDBuddyInfo)localObject1).isSelf = true;
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
                  if (isSigsEqual(arrayOfString, formatAndroidSigArray(((PackageInfo)localObject3).signatures)))
                  {
                    localObject2 = decryptByPublicKey(Base64.decode(((String)localObject2).getBytes()), this.mPublicKey);
                    arrayOfByte = SHA1Util.sha1(arrayOfByte);
                    if ((localObject2 == null) || (!Arrays.equals((byte[])localObject2, arrayOfByte))) {
                      break label405;
                    }
                    i = 1;
                    if (i != 0) {
                      ((CUIDBuddyInfo)localObject1).sigMatched = true;
                    }
                  }
                }
              }
              localArrayList.add(localObject1);
            }
            catch (Exception localException) {}
            break;
            label405:
            int i = 0;
          }
        }
      }
    }
    Collections.sort(localArrayList, new Comparator()
    {
      public int compare(DeviceId.CUIDBuddyInfo paramAnonymousCUIDBuddyInfo1, DeviceId.CUIDBuddyInfo paramAnonymousCUIDBuddyInfo2)
      {
        int j = paramAnonymousCUIDBuddyInfo2.priority - paramAnonymousCUIDBuddyInfo1.priority;
        int i = j;
        if (j == 0)
        {
          if ((!paramAnonymousCUIDBuddyInfo1.isSelf) || (!paramAnonymousCUIDBuddyInfo2.isSelf)) {
            break label37;
          }
          i = 0;
        }
        label37:
        do
        {
          return i;
          if (paramAnonymousCUIDBuddyInfo1.isSelf) {
            return -1;
          }
          i = j;
        } while (!paramAnonymousCUIDBuddyInfo2.isSelf);
        return 1;
      }
    });
    return localArrayList;
  }
  
  private static byte[] decryptByPublicKey(byte[] paramArrayOfByte, PublicKey paramPublicKey)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPublicKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private static String decryptCUIDInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(paramString.getBytes())));
      return paramString;
    }
    catch (Exception paramString)
    {
      handleThrowable(paramString);
    }
    return "";
  }
  
  private static String encryptCUIDInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, paramString.getBytes()), "utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      handleThrowable(paramString);
      return "";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        handleThrowable(paramString);
      }
    }
  }
  
  private String[] formatAndroidSigArray(Signature[] paramArrayOfSignature)
  {
    String[] arrayOfString = new String[paramArrayOfSignature.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = byte2hex(SHA1Util.sha1(paramArrayOfSignature[i].toByteArray()));
      i += 1;
    }
    return arrayOfString;
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
    return getOrCreateCUIDInfo(paramContext).getFinalCUID();
  }
  
  private CUIDInfo getCUIDInfo()
  {
    Object localObject4 = null;
    int j = 0;
    Object localObject1 = collectBuddyInfos(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.mContext.getPackageName()), true);
    int i;
    boolean bool;
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      i = 0;
      while (i < 3)
      {
        Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
        i += 1;
      }
      bool = false;
    }
    label528:
    label943:
    label974:
    label988:
    for (;;)
    {
      localObject1 = new File(this.mContext.getFilesDir(), "libcuid.so");
      if (((File)localObject1).exists()) {}
      for (localObject1 = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent((File)localObject1)));; localObject1 = null)
      {
        Object localObject2 = localObject1;
        Object localObject5;
        if (localObject1 == null)
        {
          this.mSaveMask |= 0x10;
          localObject5 = collectBuddyInfos(new Intent("com.baidu.intent.action.GALAXY"), bool);
          localObject2 = localObject1;
          if (localObject5 != null)
          {
            localObject2 = this.mContext.getFilesDir();
            if ("files".equals(((File)localObject2).getName())) {
              break label974;
            }
            Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + ((File)localObject2).getAbsolutePath());
          }
        }
        for (Object localObject3 = ((File)localObject2).getName();; localObject3 = "files")
        {
          localObject5 = ((List)localObject5).iterator();
          do
          {
            localObject2 = localObject1;
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject2 = (CUIDBuddyInfo)((Iterator)localObject5).next();
          } while (((CUIDBuddyInfo)localObject2).isSelf);
          localObject2 = new File(new File(((CUIDBuddyInfo)localObject2).appInfo.dataDir, (String)localObject3), "libcuid.so");
          if (((File)localObject2).exists())
          {
            localObject2 = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent((File)localObject2)));
            localObject1 = localObject2;
            if (localObject2 == null) {}
          }
          for (localObject1 = localObject2;; localObject1 = localObject2)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue("com.baidu.deviceid.v2")));
            }
            bool = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
            if ((localObject2 == null) && (bool))
            {
              this.mSaveMask |= 0x2;
              localObject2 = getCuidInfoFromExternalV2();
            }
            for (;;)
            {
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                this.mSaveMask |= 0x8;
                localObject1 = getCUidInfoFromSystemSettingV1();
              }
              if ((localObject1 == null) && (bool))
              {
                this.mSaveMask |= 0x1;
                localObject2 = getIMEIFromSystem("");
                localObject1 = getExternalV1DeviceId((String)localObject2);
              }
              for (i = 1;; i = j)
              {
                if (localObject1 == null)
                {
                  this.mSaveMask |= 0x4;
                  if (i == 0) {
                    localObject2 = getIMEIFromSystem("");
                  }
                  localObject3 = new CUIDInfo(null);
                  localObject1 = getAndroidId(this.mContext);
                  if (Build.VERSION.SDK_INT < 23)
                  {
                    localObject5 = UUID.randomUUID().toString();
                    localObject1 = (String)localObject2 + (String)localObject1 + (String)localObject5;
                    ((CUIDInfo)localObject3).deviceId = MD5Util.toMd5(((String)localObject1).getBytes(), true);
                    ((CUIDInfo)localObject3).imei = ((String)localObject2);
                  }
                }
                for (;;)
                {
                  localObject2 = new File(this.mContext.getFilesDir(), "libcuid.so");
                  if ((this.mSaveMask & 0x10) == 0)
                  {
                    localObject1 = localObject4;
                    if (((File)localObject2).exists()) {}
                  }
                  else
                  {
                    if (!TextUtils.isEmpty(null)) {
                      break label943;
                    }
                  }
                  for (localObject1 = encryptCUIDInfo(((CUIDInfo)localObject3).toPersitString());; localObject1 = null)
                  {
                    writeToCuidFile((String)localObject1);
                    bool = hasWriteSettingsPermission();
                    localObject2 = localObject1;
                    if (bool) {
                      if ((this.mSaveMask & 0x2) == 0)
                      {
                        localObject2 = localObject1;
                        if (!TextUtils.isEmpty(getSystemSettingValue("com.baidu.deviceid.v2"))) {}
                      }
                      else
                      {
                        localObject2 = localObject1;
                        if (TextUtils.isEmpty((CharSequence)localObject1)) {
                          localObject2 = encryptCUIDInfo(((CUIDInfo)localObject3).toPersitString());
                        }
                        tryPutSystemSettingValue("com.baidu.deviceid.v2", (String)localObject2);
                      }
                    }
                    if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
                    {
                      localObject1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
                      if (((this.mSaveMask & 0x8) != 0) || (!((File)localObject1).exists()))
                      {
                        localObject1 = localObject2;
                        if (TextUtils.isEmpty((CharSequence)localObject2)) {
                          localObject1 = encryptCUIDInfo(((CUIDInfo)localObject3).toPersitString());
                        }
                        setExternalV2DeviceId((String)localObject1);
                      }
                    }
                    if ((bool) && (((this.mSaveMask & 0x1) != 0) || (TextUtils.isEmpty(getSystemSettingValue("com.baidu.deviceid")))))
                    {
                      tryPutSystemSettingValue("com.baidu.deviceid", ((CUIDInfo)localObject3).deviceId);
                      tryPutSystemSettingValue("bd_setting_i", ((CUIDInfo)localObject3).imei);
                    }
                    if ((bool) && (!TextUtils.isEmpty(((CUIDInfo)localObject3).imei)))
                    {
                      localObject1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
                      if (((this.mSaveMask & 0x2) != 0) || (!((File)localObject1).exists())) {
                        setExternalDeviceId(((CUIDInfo)localObject3).imei, ((CUIDInfo)localObject3).deviceId);
                      }
                    }
                    return (CUIDInfo)localObject3;
                    localObject1 = (CUIDBuddyInfo)((List)localObject1).get(0);
                    bool = ((CUIDBuddyInfo)localObject1).sigMatched;
                    if (((CUIDBuddyInfo)localObject1).sigMatched) {
                      break label988;
                    }
                    i = 0;
                    while (i < 3)
                    {
                      Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                      i += 1;
                    }
                    break;
                    localObject1 = "com.baidu" + (String)localObject1;
                    break label528;
                  }
                  localObject3 = localObject1;
                }
                localObject2 = null;
              }
            }
          }
        }
      }
    }
  }
  
  private CUIDInfo getCUidInfoFromSystemSettingV1()
  {
    Object localObject3 = getSystemSettingValue("com.baidu.deviceid");
    Object localObject2 = getSystemSettingValue("bd_setting_i");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = getIMEIFromSystem("");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        tryPutSystemSettingValue("bd_setting_i", (String)localObject2);
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = getAndroidId(this.mContext);
      localObject2 = getSystemSettingValue(MD5Util.toMd5(("com.baidu" + (String)localObject1 + (String)localObject2).getBytes(), true));
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new CUIDInfo(null);
      ((CUIDInfo)localObject3).deviceId = ((String)localObject2);
      ((CUIDInfo)localObject3).imei = ((String)localObject1);
      return (CUIDInfo)localObject3;
    }
    return null;
  }
  
  private CUIDInfo getCuidInfoFromExternalV2()
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
    if (((File)localObject).exists())
    {
      localObject = getFileContent((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = CUIDInfo.createFromJson(new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(((String)localObject).getBytes()))));
          return (CUIDInfo)localObject;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static String getDeviceID(Context paramContext)
  {
    return getOrCreateCUIDInfo(paramContext).deviceId;
  }
  
  /* Error */
  private CUIDInfo getExternalV1DeviceId(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: getstatic 531	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmpge +18 -> 25
    //   10: iconst_1
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +17 -> 30
    //   16: aload_1
    //   17: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +10 -> 30
    //   23: aconst_null
    //   24: areturn
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -15 -> 12
    //   30: ldc 28
    //   32: astore 6
    //   34: new 467	java/io/File
    //   37: dup
    //   38: invokestatic 572	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   41: ldc_w 600
    //   44: invokespecial 474	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 477	java/io/File:exists	()Z
    //   54: ifeq +98 -> 152
    //   57: new 602	java/io/BufferedReader
    //   60: dup
    //   61: new 604	java/io/FileReader
    //   64: dup
    //   65: aload 4
    //   67: invokespecial 607	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   70: invokespecial 610	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   73: astore 4
    //   75: new 136	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   82: astore 5
    //   84: aload 4
    //   86: invokevirtual 613	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 7
    //   91: aload 7
    //   93: ifnull +79 -> 172
    //   96: aload 5
    //   98: aload 7
    //   100: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 5
    //   106: ldc_w 615
    //   109: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: goto -29 -> 84
    //   116: astore 4
    //   118: aload_1
    //   119: astore 5
    //   121: aload 6
    //   123: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +192 -> 318
    //   129: new 11	com/baidu/android/common/util/DeviceId$CUIDInfo
    //   132: dup
    //   133: aconst_null
    //   134: invokespecial 524	com/baidu/android/common/util/DeviceId$CUIDInfo:<init>	(Lcom/baidu/android/common/util/DeviceId$1;)V
    //   137: astore_1
    //   138: aload_1
    //   139: aload 6
    //   141: putfield 547	com/baidu/android/common/util/DeviceId$CUIDInfo:deviceId	Ljava/lang/String;
    //   144: aload_1
    //   145: aload 5
    //   147: putfield 550	com/baidu/android/common/util/DeviceId$CUIDInfo:imei	Ljava/lang/String;
    //   150: aload_1
    //   151: areturn
    //   152: new 467	java/io/File
    //   155: dup
    //   156: invokestatic 572	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   159: ldc_w 579
    //   162: invokespecial 474	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   165: astore 4
    //   167: iconst_1
    //   168: istore_3
    //   169: goto -112 -> 57
    //   172: aload 4
    //   174: invokevirtual 618	java/io/BufferedReader:close	()V
    //   177: new 106	java/lang/String
    //   180: dup
    //   181: getstatic 148	com/baidu/android/common/util/DeviceId:AES_KEY	Ljava/lang/String;
    //   184: getstatic 148	com/baidu/android/common/util/DeviceId:AES_KEY	Ljava/lang/String;
    //   187: aload 5
    //   189: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokevirtual 351	java/lang/String:getBytes	()[B
    //   195: invokestatic 121	com/baidu/android/common/security/Base64:decode	([B)[B
    //   198: invokestatic 405	com/baidu/android/common/security/AESUtil:decrypt	(Ljava/lang/String;Ljava/lang/String;[B)[B
    //   201: invokespecial 125	java/lang/String:<init>	([B)V
    //   204: ldc_w 620
    //   207: invokevirtual 624	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   210: astore 5
    //   212: aload 5
    //   214: ifnull +146 -> 360
    //   217: aload 5
    //   219: arraylength
    //   220: iconst_2
    //   221: if_icmpne +139 -> 360
    //   224: iload_2
    //   225: ifeq +65 -> 290
    //   228: aload_1
    //   229: aload 5
    //   231: iconst_0
    //   232: aaload
    //   233: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   236: ifeq +54 -> 290
    //   239: aload 5
    //   241: iconst_1
    //   242: aaload
    //   243: astore 5
    //   245: aload_1
    //   246: astore 4
    //   248: aload 5
    //   250: astore_1
    //   251: aload_1
    //   252: astore 6
    //   254: aload 4
    //   256: astore 5
    //   258: iload_3
    //   259: ifne -138 -> 121
    //   262: aload 4
    //   264: aload_1
    //   265: invokestatic 582	com/baidu/android/common/util/DeviceId:setExternalDeviceId	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_1
    //   269: astore 6
    //   271: aload 4
    //   273: astore 5
    //   275: goto -154 -> 121
    //   278: astore 5
    //   280: aload_1
    //   281: astore 6
    //   283: aload 4
    //   285: astore 5
    //   287: goto -166 -> 121
    //   290: iload_2
    //   291: ifne +69 -> 360
    //   294: aload_1
    //   295: astore 4
    //   297: aload_1
    //   298: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   301: ifeq +9 -> 310
    //   304: aload 5
    //   306: iconst_1
    //   307: aaload
    //   308: astore 4
    //   310: aload 5
    //   312: iconst_1
    //   313: aaload
    //   314: astore_1
    //   315: goto -64 -> 251
    //   318: aconst_null
    //   319: areturn
    //   320: astore 4
    //   322: aload_1
    //   323: astore 5
    //   325: goto -204 -> 121
    //   328: astore 5
    //   330: aload_1
    //   331: astore 6
    //   333: aload 4
    //   335: astore 5
    //   337: goto -216 -> 121
    //   340: astore 4
    //   342: aload_1
    //   343: astore 5
    //   345: goto -224 -> 121
    //   348: astore 5
    //   350: aload_1
    //   351: astore 6
    //   353: aload 4
    //   355: astore 5
    //   357: goto -236 -> 121
    //   360: aload_1
    //   361: astore 4
    //   363: aload 6
    //   365: astore_1
    //   366: goto -115 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	DeviceId
    //   0	369	1	paramString	String
    //   11	280	2	i	int
    //   1	258	3	j	int
    //   47	38	4	localObject1	Object
    //   116	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   165	144	4	localObject2	Object
    //   320	14	4	localException1	Exception
    //   340	14	4	localIOException1	IOException
    //   361	1	4	str1	String
    //   82	192	5	localObject3	Object
    //   278	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   285	39	5	localObject4	Object
    //   328	1	5	localException2	Exception
    //   335	9	5	localObject5	Object
    //   348	1	5	localIOException2	IOException
    //   355	1	5	localIOException3	IOException
    //   32	332	6	str2	String
    //   89	10	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   57	84	116	java/io/FileNotFoundException
    //   84	91	116	java/io/FileNotFoundException
    //   96	113	116	java/io/FileNotFoundException
    //   172	212	116	java/io/FileNotFoundException
    //   217	224	116	java/io/FileNotFoundException
    //   228	239	116	java/io/FileNotFoundException
    //   297	304	116	java/io/FileNotFoundException
    //   262	268	278	java/io/FileNotFoundException
    //   57	84	320	java/lang/Exception
    //   84	91	320	java/lang/Exception
    //   96	113	320	java/lang/Exception
    //   172	212	320	java/lang/Exception
    //   217	224	320	java/lang/Exception
    //   228	239	320	java/lang/Exception
    //   297	304	320	java/lang/Exception
    //   262	268	328	java/lang/Exception
    //   57	84	340	java/io/IOException
    //   84	91	340	java/io/IOException
    //   96	113	340	java/io/IOException
    //   172	212	340	java/io/IOException
    //   217	224	340	java/io/IOException
    //   228	239	340	java/io/IOException
    //   297	304	340	java/io/IOException
    //   262	268	348	java/io/IOException
  }
  
  /* Error */
  private static String getFileContent(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 604	java/io/FileReader
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 607	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   11: astore_2
    //   12: aload_2
    //   13: astore_0
    //   14: sipush 8192
    //   17: newarray <illegal type>
    //   19: astore_3
    //   20: aload_2
    //   21: astore_0
    //   22: new 626	java/io/CharArrayWriter
    //   25: dup
    //   26: invokespecial 627	java/io/CharArrayWriter:<init>	()V
    //   29: astore 5
    //   31: aload_2
    //   32: astore_0
    //   33: aload_2
    //   34: aload_3
    //   35: invokevirtual 631	java/io/FileReader:read	([C)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifle +39 -> 79
    //   43: aload_2
    //   44: astore_0
    //   45: aload 5
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 635	java/io/CharArrayWriter:write	([CII)V
    //   53: goto -22 -> 31
    //   56: astore_3
    //   57: aload_2
    //   58: astore_0
    //   59: aload_3
    //   60: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   63: aload 4
    //   65: astore_0
    //   66: aload_2
    //   67: ifnull +10 -> 77
    //   70: aload_2
    //   71: invokevirtual 636	java/io/FileReader:close	()V
    //   74: aload 4
    //   76: astore_0
    //   77: aload_0
    //   78: areturn
    //   79: aload_2
    //   80: astore_0
    //   81: aload 5
    //   83: invokevirtual 637	java/io/CharArrayWriter:toString	()Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: astore_0
    //   89: aload_2
    //   90: ifnull -13 -> 77
    //   93: aload_2
    //   94: invokevirtual 636	java/io/FileReader:close	()V
    //   97: aload_3
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   104: aload_3
    //   105: areturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 636	java/io/FileReader:close	()V
    //   124: aload_2
    //   125: athrow
    //   126: astore_0
    //   127: aload_0
    //   128: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
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
  
  public static String getIMEI(Context paramContext)
  {
    return getOrCreateCUIDInfo(paramContext).imei;
  }
  
  private String getIMEIFromSystem(String paramString)
  {
    try
    {
      localObject = (TelephonyManager)this.mContext.getSystemService("phone");
      if (localObject == null) {
        break label48;
      }
      localObject = ((TelephonyManager)localObject).getDeviceId();
    }
    catch (Exception localException)
    {
      label48:
      String str;
      for (;;)
      {
        Object localObject;
        Log.e("DeviceId", "Read IMEI failed", localException);
        str = null;
      }
      return str;
    }
    localObject = imeiCheck((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return paramString;
    }
  }
  
  private static CUIDInfo getOrCreateCUIDInfo(Context paramContext)
  {
    if (sCachedCuidInfo == null) {}
    try
    {
      if (sCachedCuidInfo == null)
      {
        SystemClock.uptimeMillis();
        sCachedCuidInfo = new DeviceId(paramContext).getCUIDInfo();
        SystemClock.uptimeMillis();
      }
      return sCachedCuidInfo;
    }
    finally {}
  }
  
  private String getSystemSettingValue(String paramString)
  {
    try
    {
      paramString = Settings.System.getString(this.mContext.getContentResolver(), paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      handleThrowable(paramString);
    }
    return null;
  }
  
  private static void handleThrowable(Throwable paramThrowable) {}
  
  private boolean hasReadImeiPermission()
  {
    return checkSelfPermission("android.permission.READ_PHONE_STATE");
  }
  
  private boolean hasWriteSettingsPermission()
  {
    return checkSelfPermission("android.permission.WRITE_SETTINGS");
  }
  
  private static String imeiCheck(String paramString)
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
  
  /* Error */
  private void initPublicKey()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 684	java/io/ByteArrayInputStream
    //   5: dup
    //   6: invokestatic 689	com/baidu/android/common/util/CuidCertStore:getCertBytes	()[B
    //   9: invokespecial 690	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: astore_1
    //   13: aload_0
    //   14: ldc_w 692
    //   17: invokestatic 697	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   20: aload_1
    //   21: invokevirtual 701	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   24: invokevirtual 707	java/security/cert/Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   27: putfield 353	com/baidu/android/common/util/DeviceId:mPublicKey	Ljava/security/PublicKey;
    //   30: aload_1
    //   31: ifnull +7 -> 38
    //   34: aload_1
    //   35: invokevirtual 708	java/io/ByteArrayInputStream:close	()V
    //   38: return
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   44: return
    //   45: astore_1
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull -11 -> 38
    //   52: aload_1
    //   53: invokevirtual 708	java/io/ByteArrayInputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   62: return
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 708	java/io/ByteArrayInputStream:close	()V
    //   72: aload_1
    //   73: athrow
    //   74: astore_2
    //   75: aload_2
    //   76: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
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
  
  private boolean isSigsEqual(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int j = 0;
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length != paramArrayOfString2.length)) {
      return false;
    }
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
    return localHashSet.equals(paramArrayOfString1);
  }
  
  private static void setExternalDeviceId(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString2);
    paramString1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
    paramString2 = new File(paramString1, ".cuid");
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
      paramString1.write(Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, localStringBuilder.toString().getBytes()), "utf-8"));
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (IOException paramString1) {}catch (Exception paramString1) {}
  }
  
  private static void setExternalV2DeviceId(String paramString)
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
  
  private boolean tryPutSystemSettingValue(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = Settings.System.putString(this.mContext.getContentResolver(), paramString1, paramString2);
      return bool;
    }
    catch (Exception paramString1)
    {
      handleThrowable(paramString1);
    }
    return false;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  private boolean writeToCuidFile(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: getstatic 531	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 24
    //   10: if_icmplt +81 -> 91
    //   13: iconst_0
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 161	com/baidu/android/common/util/DeviceId:mContext	Landroid/content/Context;
    //   19: ldc 64
    //   21: iload_2
    //   22: invokevirtual 762	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   25: astore 5
    //   27: aload 5
    //   29: astore 4
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 351	java/lang/String:getBytes	()[B
    //   37: invokevirtual 766	java/io/FileOutputStream:write	([B)V
    //   40: aload 5
    //   42: astore 4
    //   44: aload 5
    //   46: invokevirtual 767	java/io/FileOutputStream:flush	()V
    //   49: aload 5
    //   51: ifnull +8 -> 59
    //   54: aload 5
    //   56: invokevirtual 768	java/io/FileOutputStream:close	()V
    //   59: iload_2
    //   60: ifne +29 -> 89
    //   63: new 467	java/io/File
    //   66: dup
    //   67: aload_0
    //   68: getfield 161	com/baidu/android/common/util/DeviceId:mContext	Landroid/content/Context;
    //   71: invokevirtual 471	android/content/Context:getFilesDir	()Ljava/io/File;
    //   74: ldc 64
    //   76: invokespecial 474	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   79: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   82: sipush 436
    //   85: invokestatic 772	com/baidu/android/common/util/DeviceId$TargetApiSupport:doChmodSafely	(Ljava/lang/String;I)Z
    //   88: istore_3
    //   89: iload_3
    //   90: ireturn
    //   91: iconst_1
    //   92: istore_2
    //   93: goto -78 -> 15
    //   96: astore_1
    //   97: aload_1
    //   98: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   101: goto -42 -> 59
    //   104: astore 4
    //   106: aconst_null
    //   107: astore_1
    //   108: aload 4
    //   110: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 768	java/io/FileOutputStream:close	()V
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_1
    //   124: aload_1
    //   125: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   128: goto -7 -> 121
    //   131: astore_1
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 768	java/io/FileOutputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: astore 4
    //   146: aload 4
    //   148: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   151: goto -9 -> 142
    //   154: astore 5
    //   156: aload_1
    //   157: astore 4
    //   159: aload 5
    //   161: astore_1
    //   162: goto -30 -> 132
    //   165: astore 4
    //   167: aload 5
    //   169: astore_1
    //   170: goto -62 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	DeviceId
    //   0	173	1	paramString	String
    //   14	79	2	i	int
    //   1	89	3	bool	boolean
    //   3	40	4	localObject1	Object
    //   104	34	4	localException1	Exception
    //   144	3	4	localException2	Exception
    //   157	1	4	str	String
    //   165	1	4	localException3	Exception
    //   25	30	5	localFileOutputStream	java.io.FileOutputStream
    //   154	14	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	96	java/lang/Exception
    //   15	27	104	java/lang/Exception
    //   117	121	123	java/lang/Exception
    //   15	27	131	finally
    //   31	40	131	finally
    //   44	49	131	finally
    //   137	142	144	java/lang/Exception
    //   108	113	154	finally
    //   31	40	165	java/lang/Exception
    //   44	49	165	java/lang/Exception
  }
  
  /* Error */
  private static void writeToFile(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 764	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 778	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_0
    //   11: aload_2
    //   12: aload_1
    //   13: invokevirtual 766	java/io/FileOutputStream:write	([B)V
    //   16: aload_2
    //   17: astore_0
    //   18: aload_2
    //   19: invokevirtual 767	java/io/FileOutputStream:flush	()V
    //   22: aload_2
    //   23: ifnull +7 -> 30
    //   26: aload_2
    //   27: invokevirtual 768	java/io/FileOutputStream:close	()V
    //   30: return
    //   31: astore_0
    //   32: aload_0
    //   33: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   36: return
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_2
    //   41: astore_0
    //   42: aload_1
    //   43: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   46: aload_2
    //   47: ifnull -17 -> 30
    //   50: aload_2
    //   51: invokevirtual 768	java/io/FileOutputStream:close	()V
    //   54: return
    //   55: astore_0
    //   56: aload_0
    //   57: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   60: return
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: astore_0
    //   66: aload_1
    //   67: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   70: aload_2
    //   71: ifnull -41 -> 30
    //   74: aload_2
    //   75: invokevirtual 768	java/io/FileOutputStream:close	()V
    //   78: return
    //   79: astore_0
    //   80: aload_0
    //   81: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   84: return
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 768	java/io/FileOutputStream:close	()V
    //   96: aload_1
    //   97: athrow
    //   98: astore_0
    //   99: aload_0
    //   100: invokestatic 169	com/baidu/android/common/util/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   103: goto -7 -> 96
    //   106: astore_1
    //   107: goto -19 -> 88
    //   110: astore_1
    //   111: goto -47 -> 64
    //   114: astore_1
    //   115: goto -75 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramFile	File
    //   0	118	1	paramArrayOfByte	byte[]
    //   8	67	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   26	30	31	java/io/IOException
    //   0	9	37	java/io/IOException
    //   50	54	55	java/io/IOException
    //   0	9	61	java/lang/SecurityException
    //   74	78	79	java/io/IOException
    //   0	9	85	finally
    //   92	96	98	java/io/IOException
    //   11	16	106	finally
    //   18	22	106	finally
    //   42	46	106	finally
    //   66	70	106	finally
    //   11	16	110	java/lang/SecurityException
    //   18	22	110	java/lang/SecurityException
    //   11	16	114	java/io/IOException
    //   18	22	114	java/io/IOException
  }
  
  private static class CUIDBuddyInfo
  {
    public ApplicationInfo appInfo;
    public boolean isSelf = false;
    public int priority = 0;
    public boolean sigMatched = false;
  }
  
  private static class CUIDInfo
  {
    private static final int VERSION = 2;
    public String deviceId;
    public String imei;
    public int version = 2;
    
    public static CUIDInfo createFromJson(String paramString)
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
            localObject = new CUIDInfo();
            ((CUIDInfo)localObject).deviceId = paramString;
            ((CUIDInfo)localObject).imei = str;
            ((CUIDInfo)localObject).version = i;
            return (CUIDInfo)localObject;
          }
        }
        catch (JSONException paramString)
        {
          DeviceId.handleThrowable(paramString);
        }
      }
      return null;
    }
    
    public String getFinalCUID()
    {
      String str2 = this.imei;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0";
      }
      str1 = new StringBuffer(str1).reverse().toString();
      return this.deviceId + "|" + str1;
    }
    
    public String toPersitString()
    {
      try
      {
        String str = new JSONObject().put("deviceid", this.deviceId).put("imei", this.imei).put("ver", this.version).toString();
        return str;
      }
      catch (JSONException localJSONException)
      {
        DeviceId.handleThrowable(localJSONException);
      }
      return null;
    }
  }
  
  static class TargetApiSupport
  {
    static boolean doChmodSafely(String paramString, int paramInt)
    {
      try
      {
        Os.chmod(paramString, paramInt);
        return true;
      }
      catch (ErrnoException paramString)
      {
        DeviceId.handleThrowable(paramString);
      }
      return false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/common/util/DeviceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */