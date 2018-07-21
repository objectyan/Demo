package com.baidu.navisdk.debug;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.CommonConfig;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class BNEyeSpyPaperModel
{
  private static final String TAG = "BNEyeSpyPaperModel";
  private boolean hasPostSuccess = true;
  private boolean isInTestPlaner = false;
  public String mDespText = null;
  public String mProblemId = null;
  public int mUploadSource = 0;
  
  private void postUserStatus(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        HashMap localHashMap = new HashMap();
        localHashMap.put("bduss", "");
        localStringBuffer.append("bduss=");
        localStringBuffer.append(URLEncoder.encode("", "utf-8"));
        localHashMap.put("cuid", PackageUtil.getCuid());
        localStringBuffer.append("&cuid=");
        localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
        localHashMap.put("ignoreLogin", "1");
        localStringBuffer.append("&ignoreLogin=");
        localStringBuffer.append(URLEncoder.encode("1", "utf-8"));
        if (paramBoolean)
        {
          String str1 = "1";
          localHashMap.put("option", str1);
          localStringBuffer.append("&option=");
          if (paramBoolean)
          {
            str1 = "1";
            localStringBuffer.append(URLEncoder.encode(str1, "utf-8"));
            localHashMap.put("os", "0");
            localStringBuffer.append("&os=");
            localStringBuffer.append(URLEncoder.encode("0", "utf-8"));
            localHashMap.put("osv", VDeviceAPI.getOsVersion());
            localStringBuffer.append("&osv=");
            localStringBuffer.append(URLEncoder.encode(VDeviceAPI.getOsVersion(), "utf-8"));
            localHashMap.put("sv", PackageUtil.getVersionName());
            localStringBuffer.append("&sv=");
            localStringBuffer.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
            str1 = "skyeye" + localStringBuffer.toString() + "b428c8dad16d0bc031b4d7ef4e7bec80";
            localHashMap.put("sign", MD5.toMD5(str1).toLowerCase());
            LogUtil.e("BNEyeSpyPaperModel", "postUserStatus().ok signStr=" + str1);
            BNHttpCenter.getInstance().get(HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_SKYEYE_USER_STATUS), localHashMap, new BNHttpTextResponseHandler()
            {
              public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
              {
                LogUtil.e("BNEyeSpyPaperModel", "postUserStatus().err statusCode=" + paramAnonymousInt + ", s=" + paramAnonymousString);
                BNEyeSpyPaperModel.access$002(BNEyeSpyPaperModel.this, false);
              }
              
              public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
              {
                LogUtil.e("BNEyeSpyPaperModel", "postUserStatus().ok statusCode=" + paramAnonymousInt + ", s=" + paramAnonymousString);
                int j = 0;
                int i = j;
                if (paramAnonymousInt == 200) {}
                try
                {
                  paramAnonymousInt = new JSONObject(paramAnonymousString).optInt("errno", -1);
                  i = j;
                  if (paramAnonymousInt == 0) {
                    i = 1;
                  }
                }
                catch (Exception paramAnonymousString)
                {
                  for (;;)
                  {
                    paramAnonymousString.printStackTrace();
                    i = j;
                  }
                  BNEyeSpyPaperModel.access$002(BNEyeSpyPaperModel.this, true);
                }
                if (i == 0)
                {
                  BNEyeSpyPaperModel.access$002(BNEyeSpyPaperModel.this, false);
                  return;
                }
              }
            }, null);
            return;
          }
          str1 = "2";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
  
  private void uploadFile(final File paramFile, boolean paramBoolean)
    throws UnsupportedEncodingException
  {
    BNHttpParams localBNHttpParams = new BNHttpParams();
    localBNHttpParams.isAsync = true;
    localBNHttpParams.fileKey = "datafile";
    localBNHttpParams.file = paramFile;
    StringBuffer localStringBuffer = new StringBuffer();
    HashMap localHashMap = new HashMap();
    localHashMap.put("buildtime", PackageUtil.getBuildNo());
    localStringBuffer.append("buildtime=");
    localStringBuffer.append(URLEncoder.encode(PackageUtil.getBuildNo(), "utf-8"));
    if (TextUtils.isEmpty(this.mDespText))
    {
      localObject = "";
      localHashMap.put("content", localObject);
      localStringBuffer.append("&content=");
      if (!TextUtils.isEmpty(this.mDespText)) {
        break label754;
      }
    }
    label754:
    for (Object localObject = "";; localObject = this.mDespText)
    {
      localStringBuffer.append(URLEncoder.encode((String)localObject, "utf-8"));
      localHashMap.put("cuid", PackageUtil.getCuid());
      localStringBuffer.append("&cuid=");
      localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
      localHashMap.put("file_type", "2");
      localStringBuffer.append("&file_type=");
      localStringBuffer.append(URLEncoder.encode("2", "utf-8"));
      localHashMap.put("ignoreLogin", "1");
      localStringBuffer.append("&ignoreLogin=");
      localStringBuffer.append(URLEncoder.encode("1", "utf-8"));
      localHashMap.put("mb", "" + VDeviceAPI.getPhoneType());
      localStringBuffer.append("&mb=");
      localStringBuffer.append(URLEncoder.encode(VDeviceAPI.getPhoneType(), "utf-8"));
      localHashMap.put("os", "0");
      localStringBuffer.append("&os=");
      localStringBuffer.append(URLEncoder.encode("0", "utf-8"));
      localHashMap.put("pic", "");
      localStringBuffer.append("&pic=");
      localStringBuffer.append(URLEncoder.encode("", "utf-8"));
      GeoPoint localGeoPoint = RGEngineControl.getInstance().getCurrentGeoPoint();
      localObject = null;
      if (localGeoPoint != null) {
        localObject = CoordinateTransformUtil.LLE62MC(localGeoPoint.getLongitudeE6(), localGeoPoint.getLatitudeE6());
      }
      if (localObject != null)
      {
        int i = ((Bundle)localObject).getInt("MCx", 0);
        int j = ((Bundle)localObject).getInt("MCy", 0);
        localHashMap.put("point", i + "," + j);
        localStringBuffer.append("&point=");
        localStringBuffer.append(URLEncoder.encode(i + "," + j, "utf-8"));
      }
      if (TextUtils.isEmpty(this.mProblemId)) {
        generateProblemId();
      }
      localHashMap.put("problem_id", this.mProblemId);
      localStringBuffer.append("&problem_id=");
      localStringBuffer.append(URLEncoder.encode(this.mProblemId, "utf-8"));
      localHashMap.put("screenshot", "");
      localStringBuffer.append("&screenshot=");
      localStringBuffer.append(URLEncoder.encode("", "utf-8"));
      localHashMap.put("source", this.mUploadSource + "");
      localStringBuffer.append("&source=");
      localStringBuffer.append(URLEncoder.encode(this.mUploadSource + "", "utf-8"));
      localHashMap.put("sv", PackageUtil.getVersionName());
      localStringBuffer.append("&sv=");
      localStringBuffer.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
      localHashMap.put("sign", MD5.toMD5("skyeye" + localStringBuffer.toString() + "b428c8dad16d0bc031b4d7ef4e7bec80").toLowerCase());
      BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_SKYEYE_POST_LOG), localHashMap, new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          try
          {
            if ((paramFile != null) && (paramFile.exists())) {
              paramFile.delete();
            }
            return;
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
          }
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          if (paramAnonymousInt == 200) {}
          try
          {
            paramAnonymousInt = new JSONObject(paramAnonymousString).optInt("errno", -1);
            if (paramAnonymousInt == 0) {}
            return;
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              try
              {
                if ((paramFile != null) && (paramFile.exists())) {
                  paramFile.delete();
                }
                return;
              }
              catch (Exception paramAnonymousString)
              {
                paramAnonymousString.printStackTrace();
              }
              paramAnonymousString = paramAnonymousString;
              paramAnonymousString.printStackTrace();
            }
          }
        }
      }, localBNHttpParams);
      return;
      localObject = this.mDespText;
      break;
    }
  }
  
  public void addToTestPlaner()
  {
    if ((!isInTestPlaner()) || (!this.hasPostSuccess))
    {
      this.isInTestPlaner = true;
      postUserStatus(this.isInTestPlaner);
    }
  }
  
  public String generateProblemId()
  {
    this.mProblemId = (PackageUtil.getCuid() + "_" + System.currentTimeMillis());
    LogUtil.e("BNEyeSpyPaperModel", "mProblemId:" + this.mProblemId);
    return this.mProblemId;
  }
  
  public void initParmsAfterCloud()
  {
    this.isInTestPlaner = CloudlConfigDataModel.getInstance().mCommonConfig.isEyespyPagerOpen;
  }
  
  public boolean isInTestPlaner()
  {
    return this.isInTestPlaner;
  }
  
  public boolean isKeyLogExist()
  {
    File localFile = new File(SDKDebugFileUtil.getInstance().getCoreLogDir());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localFile != null)
    {
      localObject1 = localObject2;
      if (localFile.exists()) {
        localObject1 = localFile.listFiles();
      }
    }
    return (localObject1 != null) && (localObject1.length > 0);
  }
  
  public void removeFormTestPlaner()
  {
    this.isInTestPlaner = false;
    postUserStatus(this.isInTestPlaner);
  }
  
  /* Error */
  public void uploadLogFile()
  {
    // Byte code:
    //   0: invokestatic 339	com/baidu/navisdk/debug/SDKDebugFileUtil:getInstance	()Lcom/baidu/navisdk/debug/SDKDebugFileUtil;
    //   3: invokevirtual 342	com/baidu/navisdk/debug/SDKDebugFileUtil:getCoreLogDir	()Ljava/lang/String;
    //   6: astore 5
    //   8: new 334	java/io/File
    //   11: dup
    //   12: aload 5
    //   14: invokespecial 345	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aconst_null
    //   20: astore 4
    //   22: aload 4
    //   24: astore 7
    //   26: aload 6
    //   28: ifnull +22 -> 50
    //   31: aload 4
    //   33: astore 7
    //   35: aload 6
    //   37: invokevirtual 348	java/io/File:exists	()Z
    //   40: ifeq +10 -> 50
    //   43: aload 6
    //   45: invokevirtual 352	java/io/File:listFiles	()[Ljava/io/File;
    //   48: astore 7
    //   50: new 334	java/io/File
    //   53: dup
    //   54: aload 5
    //   56: ldc_w 356
    //   59: invokespecial 358	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: astore 8
    //   64: aconst_null
    //   65: astore 4
    //   67: aconst_null
    //   68: astore 5
    //   70: aload 8
    //   72: invokestatic 364	com/baidu/navisdk/util/common/ZipUtils:getZipOutputStream	(Ljava/io/File;)Ljava/util/zip/ZipOutputStream;
    //   75: astore 6
    //   77: aload 7
    //   79: ifnull +184 -> 263
    //   82: aload 6
    //   84: astore 5
    //   86: aload 6
    //   88: astore 4
    //   90: aload 7
    //   92: arraylength
    //   93: ifle +170 -> 263
    //   96: aload 6
    //   98: astore 5
    //   100: aload 6
    //   102: astore 4
    //   104: aload 7
    //   106: arraylength
    //   107: istore_2
    //   108: iconst_0
    //   109: istore_1
    //   110: iload_1
    //   111: iload_2
    //   112: if_icmpge +151 -> 263
    //   115: aload 7
    //   117: iload_1
    //   118: aaload
    //   119: astore 5
    //   121: aload 6
    //   123: astore 4
    //   125: aload 5
    //   127: aload 6
    //   129: aload 5
    //   131: invokevirtual 367	java/io/File:getName	()Ljava/lang/String;
    //   134: invokestatic 371	com/baidu/navisdk/util/common/ZipUtils:zip	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   137: iload_1
    //   138: iconst_1
    //   139: iadd
    //   140: istore_1
    //   141: goto -31 -> 110
    //   144: astore 9
    //   146: aload 6
    //   148: astore 5
    //   150: aload 6
    //   152: astore 4
    //   154: aload 9
    //   156: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   159: aload 6
    //   161: astore 5
    //   163: aload 6
    //   165: astore 4
    //   167: ldc 15
    //   169: new 115	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 376
    //   179: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 9
    //   184: invokevirtual 379	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 148	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: goto -59 -> 137
    //   199: astore 6
    //   201: aload 5
    //   203: astore 4
    //   205: aload 6
    //   207: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   210: aload 5
    //   212: astore 4
    //   214: ldc 15
    //   216: new 115	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 381
    //   226: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 6
    //   231: invokevirtual 379	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 148	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 5
    //   245: astore 4
    //   247: invokestatic 384	com/baidu/navisdk/util/common/LogUtil:printCallStatck	()V
    //   250: aload 5
    //   252: invokestatic 388	com/baidu/navisdk/util/common/ZipUtils:closeStrem	(Ljava/io/Closeable;)V
    //   255: aload_0
    //   256: aload 8
    //   258: iconst_0
    //   259: invokespecial 390	com/baidu/navisdk/debug/BNEyeSpyPaperModel:uploadFile	(Ljava/io/File;Z)V
    //   262: return
    //   263: aload 6
    //   265: astore 5
    //   267: aload 6
    //   269: astore 4
    //   271: getstatic 396	com/baidu/navisdk/jni/nativeif/JNINaviManager:sInstance	Lcom/baidu/navisdk/jni/nativeif/JNINaviManager;
    //   274: iconst_0
    //   275: invokevirtual 400	com/baidu/navisdk/jni/nativeif/JNINaviManager:getInitLogPath	(I)Ljava/lang/String;
    //   278: astore 7
    //   280: aload 7
    //   282: ifnull +61 -> 343
    //   285: aload 6
    //   287: astore 5
    //   289: aload 6
    //   291: astore 4
    //   293: new 334	java/io/File
    //   296: dup
    //   297: aload 7
    //   299: invokespecial 345	java/io/File:<init>	(Ljava/lang/String;)V
    //   302: astore 7
    //   304: aload 7
    //   306: ifnull +190 -> 496
    //   309: aload 6
    //   311: astore 5
    //   313: aload 6
    //   315: astore 4
    //   317: aload 7
    //   319: invokevirtual 348	java/io/File:exists	()Z
    //   322: istore_3
    //   323: iload_3
    //   324: ifeq +172 -> 496
    //   327: aload 6
    //   329: astore 4
    //   331: aload 7
    //   333: aload 6
    //   335: aload 7
    //   337: invokevirtual 367	java/io/File:getName	()Ljava/lang/String;
    //   340: invokestatic 371	com/baidu/navisdk/util/common/ZipUtils:zip	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   343: aload 6
    //   345: astore 5
    //   347: aload 6
    //   349: astore 4
    //   351: getstatic 396	com/baidu/navisdk/jni/nativeif/JNINaviManager:sInstance	Lcom/baidu/navisdk/jni/nativeif/JNINaviManager;
    //   354: iconst_1
    //   355: invokevirtual 400	com/baidu/navisdk/jni/nativeif/JNINaviManager:getInitLogPath	(I)Ljava/lang/String;
    //   358: astore 7
    //   360: aload 7
    //   362: ifnull +61 -> 423
    //   365: aload 6
    //   367: astore 5
    //   369: aload 6
    //   371: astore 4
    //   373: new 334	java/io/File
    //   376: dup
    //   377: aload 7
    //   379: invokespecial 345	java/io/File:<init>	(Ljava/lang/String;)V
    //   382: astore 7
    //   384: aload 7
    //   386: ifnull +184 -> 570
    //   389: aload 6
    //   391: astore 5
    //   393: aload 6
    //   395: astore 4
    //   397: aload 7
    //   399: invokevirtual 348	java/io/File:exists	()Z
    //   402: istore_3
    //   403: iload_3
    //   404: ifeq +166 -> 570
    //   407: aload 6
    //   409: astore 4
    //   411: aload 7
    //   413: aload 6
    //   415: aload 7
    //   417: invokevirtual 367	java/io/File:getName	()Ljava/lang/String;
    //   420: invokestatic 371	com/baidu/navisdk/util/common/ZipUtils:zip	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   423: aload 6
    //   425: invokestatic 388	com/baidu/navisdk/util/common/ZipUtils:closeStrem	(Ljava/io/Closeable;)V
    //   428: goto -173 -> 255
    //   431: astore 7
    //   433: aload 6
    //   435: astore 5
    //   437: aload 6
    //   439: astore 4
    //   441: aload 7
    //   443: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   446: aload 6
    //   448: astore 5
    //   450: aload 6
    //   452: astore 4
    //   454: ldc 15
    //   456: new 115	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 376
    //   466: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 7
    //   471: invokevirtual 379	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   474: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 148	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: goto -140 -> 343
    //   486: astore 5
    //   488: aload 4
    //   490: invokestatic 388	com/baidu/navisdk/util/common/ZipUtils:closeStrem	(Ljava/io/Closeable;)V
    //   493: aload 5
    //   495: athrow
    //   496: aload 6
    //   498: astore 5
    //   500: aload 6
    //   502: astore 4
    //   504: ldc 15
    //   506: ldc_w 402
    //   509: invokestatic 148	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: goto -169 -> 343
    //   515: astore 7
    //   517: aload 6
    //   519: astore 5
    //   521: aload 6
    //   523: astore 4
    //   525: aload 7
    //   527: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   530: aload 6
    //   532: astore 5
    //   534: aload 6
    //   536: astore 4
    //   538: ldc 15
    //   540: new 115	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 376
    //   550: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 7
    //   555: invokevirtual 379	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   558: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 148	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: goto -144 -> 423
    //   570: aload 6
    //   572: astore 5
    //   574: aload 6
    //   576: astore 4
    //   578: ldc 15
    //   580: ldc_w 404
    //   583: invokestatic 148	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: goto -163 -> 423
    //   589: astore 4
    //   591: aload 4
    //   593: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   596: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	BNEyeSpyPaperModel
    //   109	32	1	i	int
    //   107	6	2	j	int
    //   322	82	3	bool	boolean
    //   20	557	4	localObject1	Object
    //   589	3	4	localException1	Exception
    //   6	443	5	localObject2	Object
    //   486	8	5	localObject3	Object
    //   498	75	5	localObject4	Object
    //   17	147	6	localObject5	Object
    //   199	376	6	localException2	Exception
    //   24	392	7	localObject6	Object
    //   431	39	7	localException3	Exception
    //   515	39	7	localException4	Exception
    //   62	195	8	localFile	File
    //   144	39	9	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   125	137	144	java/lang/Exception
    //   70	77	199	java/lang/Exception
    //   90	96	199	java/lang/Exception
    //   104	108	199	java/lang/Exception
    //   154	159	199	java/lang/Exception
    //   167	196	199	java/lang/Exception
    //   271	280	199	java/lang/Exception
    //   293	304	199	java/lang/Exception
    //   317	323	199	java/lang/Exception
    //   351	360	199	java/lang/Exception
    //   373	384	199	java/lang/Exception
    //   397	403	199	java/lang/Exception
    //   441	446	199	java/lang/Exception
    //   454	483	199	java/lang/Exception
    //   504	512	199	java/lang/Exception
    //   525	530	199	java/lang/Exception
    //   538	567	199	java/lang/Exception
    //   578	586	199	java/lang/Exception
    //   331	343	431	java/lang/Exception
    //   70	77	486	finally
    //   90	96	486	finally
    //   104	108	486	finally
    //   125	137	486	finally
    //   154	159	486	finally
    //   167	196	486	finally
    //   205	210	486	finally
    //   214	243	486	finally
    //   247	250	486	finally
    //   271	280	486	finally
    //   293	304	486	finally
    //   317	323	486	finally
    //   331	343	486	finally
    //   351	360	486	finally
    //   373	384	486	finally
    //   397	403	486	finally
    //   411	423	486	finally
    //   441	446	486	finally
    //   454	483	486	finally
    //   504	512	486	finally
    //   525	530	486	finally
    //   538	567	486	finally
    //   578	586	486	finally
    //   411	423	515	java/lang/Exception
    //   255	262	589	java/lang/Exception
  }
  
  public static abstract interface UploadSource
  {
    public static final int AUTO_INIT_FILA = 4;
    public static final int AUTO_TIMEOUT = 3;
    public static final int CAR_RESULT = 1;
    public static final int INVILATE = 0;
    public static final int NAVING = 2;
    public static final int ROUTE_PLAN_TIMEOUT = 5;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/debug/BNEyeSpyPaperModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */