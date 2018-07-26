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
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class BNDrivingToolUtils {
    public static boolean sCanShow = false;
    public static boolean sColladaRenderShow = false;
    public static boolean sIsOnlineURL = true;
    public static long sIssueOccurTime = 0;
    public static boolean sMapRenderShow = false;
    public static int sScreenShotCount = 0;
    public static boolean sSwitchRenderShow = false;

    public static void showToastMsg(String msg) {
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), msg);
    }

    public static int getCurrentScreenCount() {
        if (BNScreentShotManager.getInstance().mScreenState == 1 || BNScreentShotManager.getInstance().mScreenState == 2) {
            return 2;
        }
        return 1;
    }

    public static int getCurrentScreenState() {
        boolean isNaviBegin = BNavigator.getInstance().isNaviBegin();
        boolean isColladaShow = RGViewController.getInstance().ismIsShowColladaView();
        boolean isNavingState = NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState());
        boolean isEnlageShow = RGViewController.getInstance().isShowEnlargeRoadMap();
        if (isNaviBegin && isColladaShow) {
            return 1;
        }
        if (isNaviBegin && isNavingState && !isEnlageShow) {
            return 2;
        }
        if (isNaviBegin && isEnlageShow) {
            return 3;
        }
        return 0;
    }

    public static boolean canDrivingToolOpen() {
        Context ctx = BNaviModuleManager.getContext();
        if (ctx != null) {
            if (!NetworkUtils.isNetworkAvailable(ctx)) {
                showToastMsg(BNDrivingToolParams.OPEN_FAIL_NO_NETWORK);
            } else if (!BNDrivingToolManager.getInstance().isLoging.booleanValue()) {
                showToastMsg(BNDrivingToolParams.OPEN_FAIL_NO_LOGIN);
            } else if (!BNavigator.getInstance().isNaviBegin()) {
                return true;
            } else {
                showToastMsg(BNDrivingToolParams.OPEN_FAIL_IN_NAVI);
            }
        }
        return false;
    }

    public static boolean canDrivingToolShow() {
        if (!BNSettingManager.isShowingDrivingTool()) {
            return false;
        }
        BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
        if (TextUtils.isEmpty(BNDrivingToolManager.getInstance().mTaskID)) {
            String drivingInfo = BNSettingManager.getLastDrivingInfo();
            if (drivingInfo != null) {
                String[] infoArray = drivingInfo.split(",");
                if (infoArray != null && infoArray.length > 0) {
                    BNDrivingToolManager.getInstance().mTaskID = infoArray[0];
                    BNDrivingToolManager.getInstance().mRouteID = "0";
                }
            }
        }
        LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "on create canDrivingToolShow task, route is" + BNDrivingToolManager.getInstance().mTaskID + BNDrivingToolManager.getInstance().mRouteID);
        sCanShow = true;
        return true;
    }

    public static boolean canColladaScreenShot() {
        return sCanShow && RGViewController.getInstance().ismIsShowColladaView();
    }

    public static boolean isMobileRoot() {
        String binPath = "/system/bin/su";
        String xBinPath = "/system/xbin/su";
        if (new File(binPath).exists() && isExecutable(binPath)) {
            return true;
        }
        if (new File(xBinPath).exists() && isExecutable(xBinPath)) {
            return true;
        }
        return false;
    }

    private static boolean isExecutable(String filePath) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ls -l " + filePath);
            String str = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            if (str != null && str.length() >= 4) {
                char flag = str.charAt(3);
                if (flag == 's' || flag == 'x') {
                    if (process == null) {
                        return true;
                    }
                    process.destroy();
                    return true;
                }
            }
            if (process != null) {
                process.destroy();
            }
        } catch (Exception e) {
            if (process != null) {
                process.destroy();
            }
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
        }
        return false;
    }

    public static boolean canSwitchScreenShot() {
        return sCanShow && !RGViewController.getInstance().ismIsShowColladaView() && NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState());
    }

    public static void setSurfaceViewState(boolean isShow) {
        sMapRenderShow = isShow;
        sColladaRenderShow = isShow;
        sSwitchRenderShow = isShow;
    }

    public static Bitmap addWaterMark(Bitmap bitmap, String locationInfo, String timeInfo, Object obj) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint textPaint = new Paint(257);
        if (obj != null) {
            textPaint.setTextSize(8.0f);
        } else {
            textPaint.setTextSize(30.0f);
        }
        textPaint.setColor(InputDeviceCompat.SOURCE_ANY);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setShadowLayer(3.0f, 1.0f, 1.0f, -65536);
        canvas.drawText(locationInfo, (float) (width / 10), (float) (((double) height) * 0.7d), textPaint);
        canvas.drawText(timeInfo, (float) (width / 8), (float) (((double) height) * 0.9d), textPaint);
        canvas.save(31);
        canvas.restore();
        return bitmap;
    }

    public static String getCurrentTimeInfo() {
        return BNDrivingToolParams.DATE_FORMAT.format(new Date(sIssueOccurTime));
    }

    public static String getTimeInfo(long time) {
        return BNDrivingToolParams.DATE_FORMAT.format(new Date(time)).replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "").replace(" ", "-");
    }

    public static String getLocationInfo() {
        StringBuffer buf = new StringBuffer();
        buf.append(RGSimpleGuideModel.getInstance().getCurRoadName());
        buf.append("-");
        buf.append(BNDrivingToolManager.getInstance().mCurrentAddressName);
        return buf.toString();
    }

    public static String getCarPointString() {
        LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "getCarPointString");
        GeoPoint mPoint = RGEngineControl.getInstance().getCarGeoPoint();
        if (mPoint == null) {
            mPoint = BNExtGPSLocationManager.getInstance().getLastValidLocation();
        }
        Bundle bundle = JNITools.CoordSysChangeByType(5, ((double) mPoint.getLongitudeE6()) / ((double) 1203982336), ((double) mPoint.getLatitudeE6()) / ((double) 1203982336));
        if (bundle == null) {
            return null;
        }
        double longtitude = bundle.getDouble("x");
        double latitude = bundle.getDouble("y");
        StringBuffer buf = new StringBuffer();
        buf.append(String.valueOf(longtitude));
        buf.append(",");
        buf.append(String.valueOf(latitude));
        return buf.toString();
    }

    public static void freeBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public static String getLoginUserID() {
        return "dingbin";
    }

    public static String getDrivingToolDir() {
        File file = new File(SysOSAPI.getInstance().GetSDCardPath() + File.separator + BNDrivingToolParams.DRIVING_TOOL_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getSuffixByType(int type) {
        if (type == 3) {
            return BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX;
        }
        if (type == 2) {
            return BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX;
        }
        if (type == 1) {
            return BNDrivingToolParams.RESOURCE_VIDEO_SUFFIX;
        }
        return null;
    }

    public static String createResourceName(int resourceType) {
        StringBuffer buf = new StringBuffer();
        if (resourceType == 3) {
            buf.append("JP");
            buf.append("-");
        } else if (resourceType == 2) {
            buf.append("ZP");
            buf.append("-");
        } else if (resourceType == 1) {
            buf.append("LX");
            buf.append("-");
        }
        buf.append(BNDrivingToolManager.getInstance().mUserID);
        buf.append("-");
        buf.append(getTimeInfo(Long.parseLong(BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime)));
        BNDrivingToolManager.getInstance().mIndexFileName = buf.toString();
        String sufix = getSuffixByType(resourceType);
        if (sufix != null) {
            buf.append(sufix);
        }
        return buf.toString();
    }

    public static String getAbsoluteFilePath(int type) {
        return getDrivingToolDir() + File.separator + createResourceName(type);
    }

    public static void log(String msg) {
        if (BNSettingManager.isShowJavaLog()) {
            String filePath = getDrivingToolDir() + File.separator + "dtLog.txt";
            String strLog = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date()) + " " + makeLogDetailInfoString(BNDrivingToolManager.MODULENAME, msg, new Throwable().getStackTrace()[1]) + "\r\n";
            try {
                FileWriter writer = new FileWriter(filePath, true);
                writer.write(strLog);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                LogUtil.m15791e("", e.toString());
            }
        }
    }

    private static String makeLogDetailInfoString(String moduleName, String str, StackTraceElement ste) {
        return ("[" + moduleName + "]-" + ste.getFileName() + "(" + ste.getLineNumber() + "): ") + str;
    }

    public static void storeDrivingToolTask() {
        String taskId = BNDrivingToolManager.getInstance().mTaskID;
        String taskName = null;
        if (!TextUtils.isEmpty(taskId)) {
            Map<String, String> taskMap = BNDrivingToolManager.getInstance().mTaskMap;
            if (taskMap != null && taskMap.size() > 0) {
                for (Entry<String, String> entry : taskMap.entrySet()) {
                    if (((String) entry.getValue()).equals(taskId)) {
                        taskName = (String) entry.getKey();
                        break;
                    }
                }
                BNSettingManager.setLastDrivingInfo(taskId + "," + taskName);
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "taskid ,taskname " + taskId + ", " + taskName);
            }
        }
    }

    public static byte[] decodeBitmapFromFile(String filePath, int reqWidth, int reqHeight) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "sample size is " + options.inSampleSize);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 40, baos);
        return baos.toByteArray();
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        if (height <= reqHeight && width <= reqWidth) {
            return 1;
        }
        int heightRatio = Math.round(((float) height) / ((float) reqHeight));
        int widthRatio = Math.round(((float) width) / ((float) reqWidth));
        if (heightRatio < widthRatio) {
            return heightRatio;
        }
        return widthRatio;
    }
}
