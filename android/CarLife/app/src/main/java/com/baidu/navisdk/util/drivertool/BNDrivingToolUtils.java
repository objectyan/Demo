package com.baidu.navisdk.util.drivertool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.drivertool.model.DrivingToolIssueInfo;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BNDrivingToolUtils
{
  public static boolean sCanShow;
  public static boolean sColladaRenderShow;
  public static boolean sIsOnlineURL = true;
  public static long sIssueOccurTime = 0L;
  public static boolean sMapRenderShow;
  public static int sScreenShotCount;
  public static boolean sSwitchRenderShow;
  
  static
  {
    sCanShow = false;
    sMapRenderShow = false;
    sColladaRenderShow = false;
    sSwitchRenderShow = false;
    sScreenShotCount = 0;
  }
  
  public static Bitmap addWaterMark(Bitmap paramBitmap, String paramString1, String paramString2, Object paramObject)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Canvas localCanvas = new Canvas(paramBitmap);
    Paint localPaint = new Paint(257);
    if (paramObject != null) {
      localPaint.setTextSize(8.0F);
    }
    for (;;)
    {
      localPaint.setColor(65280);
      localPaint.setTypeface(Typeface.DEFAULT_BOLD);
      localPaint.setShadowLayer(3.0F, 1.0F, 1.0F, -65536);
      localCanvas.drawText(paramString1, i / 10, (float)(j * 0.7D), localPaint);
      localCanvas.drawText(paramString2, i / 8, (float)(j * 0.9D), localPaint);
      localCanvas.save(31);
      localCanvas.restore();
      return paramBitmap;
      localPaint.setTextSize(30.0F);
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int i = 1;
    if ((k > paramInt2) || (j > paramInt1))
    {
      i = Math.round(k / paramInt2);
      paramInt1 = Math.round(j / paramInt1);
      if (i >= paramInt1) {}
    }
    else
    {
      return i;
    }
    return paramInt1;
  }
  
  public static boolean canColladaScreenShot()
  {
    boolean bool = RGViewController.getInstance().ismIsShowColladaView();
    return (sCanShow) && (bool);
  }
  
  public static boolean canDrivingToolOpen()
  {
    Context localContext = BNaviModuleManager.getContext();
    if (localContext != null)
    {
      if (!NetworkUtils.isNetworkAvailable(localContext)) {
        break label53;
      }
      if (!BNDrivingToolManager.getInstance().isLoging.booleanValue()) {
        break label45;
      }
      if (!BNavigator.getInstance().isNaviBegin()) {
        return true;
      }
      showToastMsg("请在导航前设置");
    }
    for (;;)
    {
      return false;
      label45:
      showToastMsg("请登录后再试");
      continue;
      label53:
      showToastMsg("请开启网络后再试");
    }
  }
  
  public static boolean canDrivingToolShow()
  {
    if (BNSettingManager.isShowingDrivingTool())
    {
      BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
      if (TextUtils.isEmpty(BNDrivingToolManager.getInstance().mTaskID))
      {
        Object localObject = BNSettingManager.getLastDrivingInfo();
        if (localObject != null)
        {
          localObject = ((String)localObject).split(",");
          if ((localObject != null) && (localObject.length > 0))
          {
            BNDrivingToolManager.getInstance().mTaskID = localObject[0];
            BNDrivingToolManager.getInstance().mRouteID = "0";
          }
        }
      }
      LogUtil.e("drivingTool", "on create canDrivingToolShow task, route is" + BNDrivingToolManager.getInstance().mTaskID + BNDrivingToolManager.getInstance().mRouteID);
      sCanShow = true;
      return true;
    }
    return false;
  }
  
  public static boolean canSwitchScreenShot()
  {
    boolean bool1 = RGViewController.getInstance().ismIsShowColladaView();
    boolean bool2 = "NAV_STATE_NAVING".equals(RGControlPanelModel.getInstance().getNavState());
    return (sCanShow) && (!bool1) && (bool2);
  }
  
  public static String createResourceName(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt == 3)
    {
      localStringBuffer.append("JP");
      localStringBuffer.append("-");
    }
    for (;;)
    {
      localStringBuffer.append(BNDrivingToolManager.getInstance().mUserID);
      localStringBuffer.append("-");
      localStringBuffer.append(getTimeInfo(Long.parseLong(BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime)));
      BNDrivingToolManager.getInstance().mIndexFileName = localStringBuffer.toString();
      String str = getSuffixByType(paramInt);
      if (str != null) {
        localStringBuffer.append(str);
      }
      return localStringBuffer.toString();
      if (paramInt == 2)
      {
        localStringBuffer.append("ZP");
        localStringBuffer.append("-");
      }
      else if (paramInt == 1)
      {
        localStringBuffer.append("LX");
        localStringBuffer.append("-");
      }
    }
  }
  
  public static byte[] decodeBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = calculateInSampleSize((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    LogUtil.e("drivingTool", "sample size is " + ((BitmapFactory.Options)localObject).inSampleSize);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    localObject = new ByteArrayOutputStream();
    paramString.compress(Bitmap.CompressFormat.JPEG, 40, (OutputStream)localObject);
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  public static void freeBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  public static String getAbsoluteFilePath(int paramInt)
  {
    return getDrivingToolDir() + File.separator + createResourceName(paramInt);
  }
  
  public static String getCarPointString()
  {
    LogUtil.e("drivingTool", "getCarPointString");
    GeoPoint localGeoPoint = RGEngineControl.getInstance().getCarGeoPoint();
    Object localObject = localGeoPoint;
    if (localGeoPoint == null) {
      localObject = BNExtGPSLocationManager.getInstance().getLastValidLocation();
    }
    localObject = JNITools.CoordSysChangeByType(5, ((GeoPoint)localObject).getLongitudeE6() / 100000.0F, ((GeoPoint)localObject).getLatitudeE6() / 100000.0F);
    if (localObject == null) {
      return null;
    }
    double d1 = ((Bundle)localObject).getDouble("x");
    double d2 = ((Bundle)localObject).getDouble("y");
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(String.valueOf(d1));
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(String.valueOf(d2));
    return ((StringBuffer)localObject).toString();
  }
  
  public static int getCurrentScreenCount()
  {
    if (BNScreentShotManager.getInstance().mScreenState == 1) {}
    while (BNScreentShotManager.getInstance().mScreenState == 2) {
      return 2;
    }
    return 1;
  }
  
  public static int getCurrentScreenState()
  {
    int j = 0;
    boolean bool1 = BNavigator.getInstance().isNaviBegin();
    boolean bool2 = RGViewController.getInstance().ismIsShowColladaView();
    boolean bool3 = "NAV_STATE_NAVING".equals(RGControlPanelModel.getInstance().getNavState());
    boolean bool4 = RGViewController.getInstance().isShowEnlargeRoadMap();
    int i;
    if ((bool1) && (bool2)) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        if ((bool1) && (bool3) && (!bool4)) {
          return 2;
        }
        i = j;
      } while (!bool1);
      i = j;
    } while (!bool4);
    return 3;
  }
  
  public static String getCurrentTimeInfo()
  {
    return BNDrivingToolParams.DATE_FORMAT.format(new Date(sIssueOccurTime));
  }
  
  public static String getDrivingToolDir()
  {
    File localFile = new File(SysOSAPI.getInstance().GetSDCardPath() + File.separator + "DrivingTool");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath();
  }
  
  public static String getLocationInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(RGSimpleGuideModel.getInstance().getCurRoadName());
    localStringBuffer.append("-");
    localStringBuffer.append(BNDrivingToolManager.getInstance().mCurrentAddressName);
    return localStringBuffer.toString();
  }
  
  public static String getLoginUserID()
  {
    return "dingbin";
  }
  
  public static String getSuffixByType(int paramInt)
  {
    String str = null;
    if (paramInt == 3) {
      str = ".png";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return ".png";
      }
    } while (paramInt != 1);
    return ".mp4";
  }
  
  public static String getTimeInfo(long paramLong)
  {
    return BNDrivingToolParams.DATE_FORMAT.format(new Date(paramLong)).replaceAll(":", "").replace(" ", "-");
  }
  
  private static boolean isExecutable(String paramString)
  {
    str2 = null;
    str1 = null;
    try
    {
      paramString = Runtime.getRuntime().exec("ls -l " + paramString);
      str1 = paramString;
      str2 = paramString;
      String str3 = new BufferedReader(new InputStreamReader(paramString.getInputStream())).readLine();
      if (str3 != null)
      {
        str1 = paramString;
        str2 = paramString;
        if (str3.length() >= 4)
        {
          str1 = paramString;
          str2 = paramString;
          int i = str3.charAt(3);
          if ((i == 115) || (i == 120)) {
            return true;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (str1 != null) {
          str1.destroy();
        }
      }
    }
    finally
    {
      if (str2 == null) {
        break label140;
      }
      str2.destroy();
    }
    return false;
  }
  
  public static boolean isMobileRoot()
  {
    if ((new File("/system/bin/su").exists()) && (isExecutable("/system/bin/su"))) {}
    while ((new File("/system/xbin/su").exists()) && (isExecutable("/system/xbin/su"))) {
      return true;
    }
    return false;
  }
  
  public static void log(String paramString)
  {
    if (!BNSettingManager.isShowJavaLog()) {
      return;
    }
    Object localObject = getDrivingToolDir() + File.separator + "dtLog.txt";
    String str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date());
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
    paramString = str + " " + makeLogDetailInfoString("drivingTool", paramString, localStackTraceElement) + "\r\n";
    try
    {
      localObject = new FileWriter((String)localObject, true);
      ((FileWriter)localObject).write(paramString);
      ((FileWriter)localObject).flush();
      ((FileWriter)localObject).close();
      return;
    }
    catch (IOException paramString)
    {
      LogUtil.e("", paramString.toString());
    }
  }
  
  private static String makeLogDetailInfoString(String paramString1, String paramString2, StackTraceElement paramStackTraceElement)
  {
    paramString1 = "[" + paramString1 + "]-" + paramStackTraceElement.getFileName() + "(" + paramStackTraceElement.getLineNumber() + "): ";
    return paramString1 + paramString2;
  }
  
  public static void setSurfaceViewState(boolean paramBoolean)
  {
    sMapRenderShow = paramBoolean;
    sColladaRenderShow = paramBoolean;
    sSwitchRenderShow = paramBoolean;
  }
  
  public static void showToastMsg(String paramString)
  {
    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), paramString);
  }
  
  public static void storeDrivingToolTask()
  {
    String str = BNDrivingToolManager.getInstance().mTaskID;
    Object localObject2 = null;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = BNDrivingToolManager.getInstance().mTaskMap;
      if ((localObject1 != null) && (((Map)localObject1).size() > 0)) {}
    }
    else
    {
      return;
    }
    Iterator localIterator = ((Map)localObject1).entrySet().iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (Map.Entry)localIterator.next();
    } while (!((String)((Map.Entry)localObject1).getValue()).equals(str));
    Object localObject1 = (String)((Map.Entry)localObject1).getKey();
    BNSettingManager.setLastDrivingInfo(str + "," + (String)localObject1);
    LogUtil.e("drivingTool", "taskid ,taskname " + str + ", " + (String)localObject1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/BNDrivingToolUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */