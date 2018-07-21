package com.baidu.speech.utils;

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
  private static final String ACTION_GLAXY_CUID = "com.baidu.intent.action.GALAXY";
  private static final String AES_KEY;
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
                break label419;
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
      label419:
      int i = 0;
    }
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
  
  public static String getCUID(Context paramContext)
  {
    return getOrCreateCUIDInfo(paramContext).getFinalCUID();
  }
  
  private CUIDInfo getCUIDInfo()
  {
    Object localObject4 = null;
    int j = 0;
    Object localObject1 = collectBuddyInfos(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.mContext.getPackageName()), true);
    boolean bool;
    int i;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = (CUIDBuddyInfo)((List)localObject1).get(0);
      bool = ((CUIDBuddyInfo)localObject1).sigMatched;
      if (!((CUIDBuddyInfo)localObject1).sigMatched)
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
              break label979;
            }
            Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + ((File)localObject2).getAbsolutePath());
          }
        }
        label557:
        label955:
        label979:
        for (Object localObject3 = ((File)localObject2).getName();; localObject3 = "files")
        {
          localObject5 = ((List)localObject5).iterator();
          localObject2 = localObject1;
          if (((Iterator)localObject5).hasNext())
          {
            Object localObject6 = (CUIDBuddyInfo)((Iterator)localObject5).next();
            localObject2 = localObject1;
            if (!((CUIDBuddyInfo)localObject6).isSelf)
            {
              localObject6 = new File(new File(((CUIDBuddyInfo)localObject6).appInfo.dataDir, (String)localObject3), "libcuid.so");
              localObject2 = localObject1;
              if (((File)localObject6).exists())
              {
                localObject1 = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent((File)localObject6)));
                localObject2 = localObject1;
                if (localObject1 != null) {
                  localObject2 = localObject1;
                }
              }
            }
          }
          for (;;)
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue("com.baidu.deviceid.v2")));
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              this.mSaveMask |= 0x2;
              localObject2 = getCuidInfoFromDataFileV2(this.mContext);
            }
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              this.mSaveMask |= 0x8;
              localObject1 = getCUidInfoFromSystemSettingV1();
            }
            if (localObject1 == null)
            {
              this.mSaveMask |= 0x1;
              localObject2 = getIntlMobEqIdFromSystem("");
              localObject1 = getDataFileV1DeviceId(this.mContext, (String)localObject2);
            }
            for (i = 1;; i = j)
            {
              if (localObject1 == null)
              {
                this.mSaveMask |= 0x4;
                if (i == 0) {
                  localObject2 = getIntlMobEqIdFromSystem("");
                }
                localObject3 = new CUIDInfo(null);
                localObject1 = getDroidId(this.mContext);
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
                    break label955;
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
                  localObject1 = new File(this.mContext.getFilesDir(), "backups/.SystemConfig/.cuid2");
                  if (((this.mSaveMask & 0x8) != 0) || (!((File)localObject1).exists()))
                  {
                    localObject1 = localObject2;
                    if (TextUtils.isEmpty((CharSequence)localObject2)) {
                      localObject1 = encryptCUIDInfo(((CUIDInfo)localObject3).toPersitString());
                    }
                    setDataFileV2DeviceId(this.mContext, (String)localObject1);
                  }
                  if ((bool) && (((this.mSaveMask & 0x1) != 0) || (TextUtils.isEmpty(getSystemSettingValue("com.baidu.deviceid")))))
                  {
                    tryPutSystemSettingValue("com.baidu.deviceid", ((CUIDInfo)localObject3).deviceId);
                    tryPutSystemSettingValue("bd_setting_i", ((CUIDInfo)localObject3).imei);
                  }
                  if ((bool) && (!TextUtils.isEmpty(((CUIDInfo)localObject3).imei)))
                  {
                    localObject1 = new File(this.mContext.getFilesDir(), "backups/.SystemConfig/.cuid");
                    if (((this.mSaveMask & 0x2) != 0) || (!((File)localObject1).exists())) {
                      setDataFileDeviceId(this.mContext, ((CUIDInfo)localObject3).imei, ((CUIDInfo)localObject3).deviceId);
                    }
                  }
                  return (CUIDInfo)localObject3;
                  i = 0;
                  while (i < 3)
                  {
                    Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
                    i += 1;
                  }
                  localObject1 = localObject2;
                  break;
                  localObject1 = "com.baidu" + (String)localObject1;
                  break label557;
                }
                localObject3 = localObject1;
              }
              localObject2 = null;
            }
          }
        }
      }
      bool = false;
    }
  }
  
  private CUIDInfo getCUidInfoFromSystemSettingV1()
  {
    Object localObject3 = getSystemSettingValue("com.baidu.deviceid");
    Object localObject2 = getSystemSettingValue("bd_setting_i");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = getIntlMobEqIdFromSystem("");
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
      localObject2 = getDroidId(this.mContext);
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
  
  private CUIDInfo getCuidInfoFromDataFileV2(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "backups/.SystemConfig/.cuid2");
    if (paramContext.exists())
    {
      paramContext = getFileContent(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        try
        {
          paramContext = CUIDInfo.createFromJson(new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(paramContext.getBytes()))));
          return paramContext;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
    return null;
  }
  
  /* Error */
  private CUIDInfo getDataFileV1DeviceId(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: getstatic 498	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 23
    //   8: if_icmpge +18 -> 26
    //   11: iconst_1
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq +17 -> 31
    //   17: aload_2
    //   18: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +10 -> 31
    //   24: aconst_null
    //   25: areturn
    //   26: iconst_0
    //   27: istore_3
    //   28: goto -15 -> 13
    //   31: ldc 23
    //   33: astore 7
    //   35: new 436	java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokevirtual 440	android/content/Context:getFilesDir	()Ljava/io/File;
    //   43: ldc_w 557
    //   46: invokespecial 443	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore 5
    //   51: aload 5
    //   53: invokevirtual 446	java/io/File:exists	()Z
    //   56: ifne +307 -> 363
    //   59: new 436	java/io/File
    //   62: dup
    //   63: aload_1
    //   64: invokevirtual 440	android/content/Context:getFilesDir	()Ljava/io/File;
    //   67: ldc_w 540
    //   70: invokespecial 443	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: astore 5
    //   75: new 559	java/io/BufferedReader
    //   78: dup
    //   79: new 561	java/io/FileReader
    //   82: dup
    //   83: aload 5
    //   85: invokespecial 564	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   88: invokespecial 567	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   91: astore 5
    //   93: new 113	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   100: astore 6
    //   102: aload 5
    //   104: invokevirtual 570	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   107: astore 8
    //   109: aload 8
    //   111: ifnull +58 -> 169
    //   114: aload 6
    //   116: aload 8
    //   118: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 6
    //   124: ldc_w 572
    //   127: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: goto -29 -> 102
    //   134: astore_1
    //   135: aload_2
    //   136: astore 6
    //   138: aload 7
    //   140: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne +173 -> 316
    //   146: new 11	com/baidu/speech/utils/DeviceId$CUIDInfo
    //   149: dup
    //   150: aconst_null
    //   151: invokespecial 490	com/baidu/speech/utils/DeviceId$CUIDInfo:<init>	(Lcom/baidu/speech/utils/DeviceId$1;)V
    //   154: astore_1
    //   155: aload_1
    //   156: aload 7
    //   158: putfield 514	com/baidu/speech/utils/DeviceId$CUIDInfo:deviceId	Ljava/lang/String;
    //   161: aload_1
    //   162: aload 6
    //   164: putfield 517	com/baidu/speech/utils/DeviceId$CUIDInfo:imei	Ljava/lang/String;
    //   167: aload_1
    //   168: areturn
    //   169: aload 5
    //   171: invokevirtual 575	java/io/BufferedReader:close	()V
    //   174: new 83	java/lang/String
    //   177: dup
    //   178: getstatic 125	com/baidu/speech/utils/DeviceId:AES_KEY	Ljava/lang/String;
    //   181: getstatic 125	com/baidu/speech/utils/DeviceId:AES_KEY	Ljava/lang/String;
    //   184: aload 6
    //   186: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokevirtual 337	java/lang/String:getBytes	()[B
    //   192: invokestatic 98	com/baidu/speech/utils/Base64:decode	([B)[B
    //   195: invokestatic 382	com/baidu/speech/utils/AESUtil:decrypt	(Ljava/lang/String;Ljava/lang/String;[B)[B
    //   198: invokespecial 102	java/lang/String:<init>	([B)V
    //   201: ldc_w 577
    //   204: invokevirtual 581	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   207: astore 6
    //   209: aload 6
    //   211: ifnull +143 -> 354
    //   214: aload 6
    //   216: arraylength
    //   217: iconst_2
    //   218: if_icmpne +136 -> 354
    //   221: iload_3
    //   222: ifeq +66 -> 288
    //   225: aload_2
    //   226: aload 6
    //   228: iconst_0
    //   229: aaload
    //   230: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifeq +55 -> 288
    //   236: aload 6
    //   238: iconst_1
    //   239: aaload
    //   240: astore 6
    //   242: aload_2
    //   243: astore 5
    //   245: aload 6
    //   247: astore_2
    //   248: aload_2
    //   249: astore 7
    //   251: aload 5
    //   253: astore 6
    //   255: iload 4
    //   257: ifne -119 -> 138
    //   260: aload_1
    //   261: aload 5
    //   263: aload_2
    //   264: invokestatic 544	com/baidu/speech/utils/DeviceId:setDataFileDeviceId	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_2
    //   268: astore 7
    //   270: aload 5
    //   272: astore 6
    //   274: goto -136 -> 138
    //   277: astore_1
    //   278: aload_2
    //   279: astore 7
    //   281: aload 5
    //   283: astore 6
    //   285: goto -147 -> 138
    //   288: iload_3
    //   289: ifne +65 -> 354
    //   292: aload_2
    //   293: astore 5
    //   295: aload_2
    //   296: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifeq +9 -> 308
    //   302: aload 6
    //   304: iconst_1
    //   305: aaload
    //   306: astore 5
    //   308: aload 6
    //   310: iconst_1
    //   311: aaload
    //   312: astore_2
    //   313: goto -65 -> 248
    //   316: aconst_null
    //   317: areturn
    //   318: astore_1
    //   319: aload_2
    //   320: astore 6
    //   322: goto -184 -> 138
    //   325: astore_1
    //   326: aload_2
    //   327: astore 7
    //   329: aload 5
    //   331: astore 6
    //   333: goto -195 -> 138
    //   336: astore_1
    //   337: aload_2
    //   338: astore 6
    //   340: goto -202 -> 138
    //   343: astore_1
    //   344: aload_2
    //   345: astore 7
    //   347: aload 5
    //   349: astore 6
    //   351: goto -213 -> 138
    //   354: aload_2
    //   355: astore 5
    //   357: aload 7
    //   359: astore_2
    //   360: goto -112 -> 248
    //   363: iconst_0
    //   364: istore 4
    //   366: goto -291 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	DeviceId
    //   0	369	1	paramContext	Context
    //   0	369	2	paramString	String
    //   12	277	3	i	int
    //   1	364	4	j	int
    //   49	307	5	localObject1	Object
    //   100	250	6	localObject2	Object
    //   33	325	7	str1	String
    //   107	10	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   75	102	134	java/io/FileNotFoundException
    //   102	109	134	java/io/FileNotFoundException
    //   114	131	134	java/io/FileNotFoundException
    //   169	209	134	java/io/FileNotFoundException
    //   214	221	134	java/io/FileNotFoundException
    //   225	236	134	java/io/FileNotFoundException
    //   295	302	134	java/io/FileNotFoundException
    //   260	267	277	java/io/FileNotFoundException
    //   75	102	318	java/lang/Exception
    //   102	109	318	java/lang/Exception
    //   114	131	318	java/lang/Exception
    //   169	209	318	java/lang/Exception
    //   214	221	318	java/lang/Exception
    //   225	236	318	java/lang/Exception
    //   295	302	318	java/lang/Exception
    //   260	267	325	java/lang/Exception
    //   75	102	336	java/io/IOException
    //   102	109	336	java/io/IOException
    //   114	131	336	java/io/IOException
    //   169	209	336	java/io/IOException
    //   214	221	336	java/io/IOException
    //   225	236	336	java/io/IOException
    //   295	302	336	java/io/IOException
    //   260	267	343	java/io/IOException
  }
  
  public static String getDevID(Context paramContext)
  {
    return getOrCreateCUIDInfo(paramContext).deviceId;
  }
  
  public static String getDroidId(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), getDroidName() + "_id");
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "";
    }
    return paramContext;
  }
  
  private static String getDroidName()
  {
    return "android";
  }
  
  /* Error */
  private static String getFileContent(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 561	java/io/FileReader
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 564	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   14: astore_2
    //   15: aload_2
    //   16: astore_0
    //   17: sipush 8192
    //   20: newarray <illegal type>
    //   22: astore_3
    //   23: aload_2
    //   24: astore_0
    //   25: new 600	java/io/CharArrayWriter
    //   28: dup
    //   29: invokespecial 601	java/io/CharArrayWriter:<init>	()V
    //   32: astore 6
    //   34: aload_2
    //   35: astore_0
    //   36: aload_2
    //   37: aload_3
    //   38: invokevirtual 605	java/io/FileReader:read	([C)I
    //   41: istore_1
    //   42: iload_1
    //   43: ifle +39 -> 82
    //   46: aload_2
    //   47: astore_0
    //   48: aload 6
    //   50: aload_3
    //   51: iconst_0
    //   52: iload_1
    //   53: invokevirtual 609	java/io/CharArrayWriter:write	([CII)V
    //   56: goto -22 -> 34
    //   59: astore_3
    //   60: aload_2
    //   61: astore_0
    //   62: aload_3
    //   63: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   66: aload 5
    //   68: astore_3
    //   69: aload_2
    //   70: ifnull +10 -> 80
    //   73: aload_2
    //   74: invokevirtual 610	java/io/FileReader:close	()V
    //   77: aload 5
    //   79: astore_3
    //   80: aload_3
    //   81: areturn
    //   82: aload_2
    //   83: astore_0
    //   84: aload 6
    //   86: invokevirtual 611	java/io/CharArrayWriter:toString	()Ljava/lang/String;
    //   89: astore_3
    //   90: aload_3
    //   91: astore_0
    //   92: aload_0
    //   93: astore_3
    //   94: aload_2
    //   95: ifnull -15 -> 80
    //   98: aload_2
    //   99: invokevirtual 610	java/io/FileReader:close	()V
    //   102: aload_0
    //   103: areturn
    //   104: astore_2
    //   105: aload_2
    //   106: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   109: aload_0
    //   110: areturn
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 610	java/io/FileReader:close	()V
    //   122: aload_2
    //   123: athrow
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   129: goto -7 -> 122
    //   132: astore_2
    //   133: aload 4
    //   135: astore_0
    //   136: goto -31 -> 105
    //   139: astore_2
    //   140: goto -26 -> 114
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_2
    //   146: goto -86 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramFile	File
    //   41	12	1	i	int
    //   14	85	2	localFileReader	java.io.FileReader
    //   104	2	2	localException1	Exception
    //   111	12	2	localObject1	Object
    //   132	1	2	localException2	Exception
    //   139	1	2	localObject2	Object
    //   145	1	2	localObject3	Object
    //   22	29	3	arrayOfChar	char[]
    //   59	4	3	localException3	Exception
    //   68	26	3	localObject4	Object
    //   143	1	3	localException4	Exception
    //   1	133	4	localObject5	Object
    //   4	74	5	localObject6	Object
    //   32	53	6	localCharArrayWriter	java.io.CharArrayWriter
    // Exception table:
    //   from	to	target	type
    //   17	23	59	java/lang/Exception
    //   25	34	59	java/lang/Exception
    //   36	42	59	java/lang/Exception
    //   48	56	59	java/lang/Exception
    //   84	90	59	java/lang/Exception
    //   98	102	104	java/lang/Exception
    //   6	15	111	finally
    //   118	122	124	java/lang/Exception
    //   73	77	132	java/lang/Exception
    //   17	23	139	finally
    //   25	34	139	finally
    //   36	42	139	finally
    //   48	56	139	finally
    //   62	66	139	finally
    //   84	90	139	finally
    //   6	15	143	java/lang/Exception
  }
  
  public static String getIntlMobEqId(Context paramContext)
  {
    return getOrCreateCUIDInfo(paramContext).imei;
  }
  
  private String getIntlMobEqIdFromSystem(String paramString)
  {
    try
    {
      localObject = (TelephonyManager)this.mContext.getSystemService("phone");
      if (localObject == null) {
        break label48;
      }
      localObject = Util.getDevId((TelephonyManager)localObject);
    }
    catch (Exception localException)
    {
      label48:
      String str;
      for (;;)
      {
        Object localObject;
        Log.e("DeviceId", "Read IntlMobEqId failed", localException);
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
    //   2: new 663	java/io/ByteArrayInputStream
    //   5: dup
    //   6: invokestatic 668	com/baidu/speech/utils/CuidCertStore:getCertBytes	()[B
    //   9: invokespecial 669	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: astore_1
    //   13: aload_0
    //   14: ldc_w 671
    //   17: invokestatic 676	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   20: aload_1
    //   21: invokevirtual 680	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   24: invokevirtual 686	java/security/cert/Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   27: putfield 339	com/baidu/speech/utils/DeviceId:mPublicKey	Ljava/security/PublicKey;
    //   30: aload_1
    //   31: ifnull +7 -> 38
    //   34: aload_1
    //   35: invokevirtual 687	java/io/ByteArrayInputStream:close	()V
    //   38: return
    //   39: astore_1
    //   40: aload_2
    //   41: ifnull +7 -> 48
    //   44: aload_2
    //   45: invokevirtual 687	java/io/ByteArrayInputStream:close	()V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull -16 -> 38
    //   57: aload_1
    //   58: invokevirtual 687	java/io/ByteArrayInputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: aload_1
    //   64: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   67: return
    //   68: astore_2
    //   69: aload_2
    //   70: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   73: goto -25 -> 48
    //   76: astore_1
    //   77: goto -14 -> 63
    //   80: astore_3
    //   81: aload_1
    //   82: astore_2
    //   83: aload_3
    //   84: astore_1
    //   85: goto -45 -> 40
    //   88: astore_2
    //   89: goto -36 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	DeviceId
    //   12	23	1	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   39	10	1	localObject1	Object
    //   50	1	1	localException1	Exception
    //   52	6	1	localObject2	Object
    //   62	2	1	localException2	Exception
    //   76	6	1	localException3	Exception
    //   84	1	1	localObject3	Object
    //   1	44	2	localObject4	Object
    //   68	2	2	localException4	Exception
    //   82	1	2	localObject5	Object
    //   88	1	2	localException5	Exception
    //   80	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	39	finally
    //   2	13	50	java/lang/Exception
    //   57	61	62	java/lang/Exception
    //   44	48	68	java/lang/Exception
    //   34	38	76	java/lang/Exception
    //   13	30	80	finally
    //   13	30	88	java/lang/Exception
  }
  
  private boolean isSigsEqual(String[] paramArrayOfString1, String[] paramArrayOfString2)
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
  
  private static void setDataFileDeviceId(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString2);
      paramContext = new File(paramContext.getFilesDir(), "backups/.SystemConfig");
      paramString1 = new File(paramContext, ".cuid");
    }
    try
    {
      if ((paramContext.exists()) && (!paramContext.isDirectory()))
      {
        paramString2 = new Random();
        File localFile1 = paramContext.getParentFile();
        String str = paramContext.getName();
        File localFile2;
        do
        {
          localFile2 = new File(localFile1, str + paramString2.nextInt() + ".tmp");
        } while (localFile2.exists());
        paramContext.renameTo(localFile2);
        localFile2.delete();
      }
      paramContext.mkdirs();
      paramContext = new FileWriter(paramString1, false);
      paramContext.write(Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, localStringBuilder.toString().getBytes()), "utf-8"));
      paramContext.flush();
      paramContext.close();
      return;
    }
    catch (Exception paramContext) {}catch (IOException paramContext) {}
  }
  
  private static void setDataFileV2DeviceId(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getFilesDir(), "backups/.SystemConfig");
    File localFile1 = new File(paramContext, ".cuid2");
    try
    {
      if ((paramContext.exists()) && (!paramContext.isDirectory()))
      {
        Random localRandom = new Random();
        File localFile2 = paramContext.getParentFile();
        String str = paramContext.getName();
        File localFile3;
        do
        {
          localFile3 = new File(localFile2, str + localRandom.nextInt() + ".tmp");
        } while (localFile3.exists());
        paramContext.renameTo(localFile3);
        localFile3.delete();
      }
      paramContext.mkdirs();
      paramContext = new FileWriter(localFile1, false);
      paramContext.write(paramString);
      paramContext.flush();
      paramContext.close();
      return;
    }
    catch (Exception paramContext) {}catch (IOException paramContext) {}
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
  
  private boolean writeToCuidFile(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("libcuid.so", 1);
      localObject1 = localFileOutputStream;
      localObject2 = localFileOutputStream;
      localFileOutputStream.write(paramString.getBytes());
      localObject1 = localFileOutputStream;
      localObject2 = localFileOutputStream;
      localFileOutputStream.flush();
      if (localFileOutputStream != null) {}
      return true;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      localObject2 = localObject1;
      handleThrowable(paramString);
      if (localObject1 == null) {}
    }
    finally
    {
      try
      {
        ((FileOutputStream)localObject1).close();
        return false;
        paramString = finally;
        if (localObject2 != null) {}
        try
        {
          ((FileOutputStream)localObject2).close();
          throw paramString;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            handleThrowable(localException);
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          handleThrowable(paramString);
        }
      }
    }
  }
  
  /* Error */
  private static void writeToFile(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 740	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 749	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_0
    //   11: aload_2
    //   12: aload_1
    //   13: invokevirtual 742	java/io/FileOutputStream:write	([B)V
    //   16: aload_2
    //   17: astore_0
    //   18: aload_2
    //   19: invokevirtual 743	java/io/FileOutputStream:flush	()V
    //   22: aload_2
    //   23: ifnull +7 -> 30
    //   26: aload_2
    //   27: invokevirtual 744	java/io/FileOutputStream:close	()V
    //   30: return
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_2
    //   34: aload_2
    //   35: astore_0
    //   36: aload_1
    //   37: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   40: aload_2
    //   41: ifnull -11 -> 30
    //   44: aload_2
    //   45: invokevirtual 744	java/io/FileOutputStream:close	()V
    //   48: return
    //   49: astore_0
    //   50: aload_0
    //   51: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   54: return
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: aload_1
    //   61: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   64: aload_2
    //   65: ifnull -35 -> 30
    //   68: aload_2
    //   69: invokevirtual 744	java/io/FileOutputStream:close	()V
    //   72: return
    //   73: astore_0
    //   74: goto -24 -> 50
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 744	java/io/FileOutputStream:close	()V
    //   88: aload_1
    //   89: athrow
    //   90: astore_0
    //   91: aload_0
    //   92: invokestatic 146	com/baidu/speech/utils/DeviceId:handleThrowable	(Ljava/lang/Throwable;)V
    //   95: goto -7 -> 88
    //   98: astore_0
    //   99: goto -49 -> 50
    //   102: astore_1
    //   103: goto -23 -> 80
    //   106: astore_1
    //   107: goto -49 -> 58
    //   110: astore_1
    //   111: goto -77 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramFile	File
    //   0	114	1	paramArrayOfByte	byte[]
    //   8	61	2	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	9	31	java/io/IOException
    //   44	48	49	java/io/IOException
    //   0	9	55	java/lang/SecurityException
    //   68	72	73	java/io/IOException
    //   0	9	77	finally
    //   84	88	90	java/io/IOException
    //   26	30	98	java/io/IOException
    //   11	16	102	finally
    //   18	22	102	finally
    //   36	40	102	finally
    //   60	64	102	finally
    //   11	16	106	java/lang/SecurityException
    //   18	22	106	java/lang/SecurityException
    //   11	16	110	java/io/IOException
    //   18	22	110	java/io/IOException
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/DeviceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */