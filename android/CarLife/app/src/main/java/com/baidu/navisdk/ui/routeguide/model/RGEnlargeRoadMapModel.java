package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.ExpandMap;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RasterType;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RGEnlargeRoadMapModel {
    public static final int Vector_Car_Point_Height = 46;
    public static final int Vector_Car_Point_Width = 42;
    private static RGEnlargeRoadMapModel mInstance = null;
    private Boolean IsClickToStreetView = Boolean.valueOf(false);
    private final String TAG = ModuleName.ROUTEGUIDE;
    private Bitmap mArrowBitmap = null;
    private String mArrowName;
    private Bitmap mBGBitmap = null;
    private String mBGName;
    private int mCurrentAddDistance = 0;
    private int mEnlargeMapTypeForStatisitcs = 0;
    private boolean mIsAnyEnlargeRoadMapShowing = false;
    private int mLastCurPosRotate = 0;
    private int mLastCurPosX = 0;
    private int mLastCurPosY = 0;
    private Bundle mLastestData = null;
    private int mLatestAddDistance = 0;
    private String mStreetUid = null;
    private int mVectorImgHeight;
    private int mVectorImgWidth;

    public String getmStreetUid() {
        return this.mStreetUid;
    }

    public void setmStreetUid(String mStreetUid) {
        this.mStreetUid = mStreetUid;
    }

    public static RGEnlargeRoadMapModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGEnlargeRoadMapModel();
        }
        return mInstance;
    }

    public int getmCurrentAddDistance() {
        return this.mCurrentAddDistance;
    }

    public void setmCurrentAddDistance(int mCurrentAddDistance) {
        this.mCurrentAddDistance = mCurrentAddDistance;
    }

    public int getmLatestAddDistance() {
        return this.mLatestAddDistance;
    }

    public void setmLatestAddDistance(int mLatestAddDistance) {
        this.mLatestAddDistance = mLatestAddDistance;
    }

    public boolean canEnlargeViewHide() {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "dingbbin canEnlargeViewHide() mLatestAddDistance is " + this.mLatestAddDistance + " mCurrentAddDistance is " + this.mCurrentAddDistance);
        if (this.mLatestAddDistance == this.mCurrentAddDistance) {
            return true;
        }
        return false;
    }

    public void setLatestAddDistance(Bundle bundle) {
        if (bundle != null && bundle.containsKey(ExpandMap.AddDistance)) {
            this.mLatestAddDistance = bundle.getInt(ExpandMap.AddDistance);
        }
    }

    public Bundle getData(String rasterType, boolean isUpdateProgress, int nTotalDist, int nRemDist, Bundle bundle) {
        if (rasterType == null || (!RasterType.GRID.equals(rasterType) && !RasterType.DIRECT_BOARD.equals(rasterType))) {
            return null;
        }
        String bgName = null;
        String arrowName = null;
        String roadName = null;
        String tagContent = null;
        int resid = -1;
        int gridmapKind = 0;
        if (bundle != null) {
            bgName = bundle.getString(ExpandMap.BgName);
            arrowName = bundle.getString(ExpandMap.ArrowName);
            roadName = bundle.getString("road_name");
            if (bundle.containsKey("icon_name")) {
                String iconName = bundle.getString("icon_name");
                resid = RGSimpleGuideModel.getInstance().getTurnIconRes(iconName);
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "RasterRoadMap.getData() iconname=" + iconName + ", resid=" + resid);
            }
            if (!isUpdateProgress) {
                this.mCurrentAddDistance = bundle.getInt(ExpandMap.AddDistance);
            }
            if (bundle.containsKey(ExpandMap.GridmapKind)) {
                gridmapKind = bundle.getInt(ExpandMap.GridmapKind);
            }
            if (bundle.containsKey(ExpandMap.TagContent)) {
                tagContent = bundle.getString(ExpandMap.TagContent);
            }
        }
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "BG=" + bgName + "  AR=" + arrowName + "  RN=" + roadName + "  TD=" + nTotalDist + "  RD=" + nTotalDist + ", gridmapKind=" + gridmapKind + ", TagContent=" + tagContent);
        this.mLastestData = new Bundle();
        this.mLastestData.putString(ExpandMap.RasterType, rasterType);
        this.mLastestData.putBoolean(ExpandMap.UpdateProgress, isUpdateProgress);
        this.mLastestData.putString(ExpandMap.BgName, bgName);
        this.mLastestData.putString(ExpandMap.ArrowName, arrowName);
        this.mLastestData.putString("road_name", roadName);
        this.mLastestData.putInt(ExpandMap.TotalDist, nTotalDist);
        this.mLastestData.putInt(ExpandMap.RemainDist, nRemDist);
        this.mLastestData.putInt(ExpandMap.GridmapKind, gridmapKind);
        this.mLastestData.putString(ExpandMap.TagContent, tagContent);
        this.mLastestData.putInt("resid", resid);
        return this.mLastestData;
    }

    public Bundle getVectorMapData(boolean isUpdateProgress, Bundle b) {
        if (b == null) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "!# getVectorMapData param bundle is null");
            return null;
        }
        int resid = -1;
        if (b != null && b.containsKey("icon_name")) {
            String iconName = b.getString("icon_name");
            resid = RGSimpleGuideModel.getInstance().getTurnIconRes(iconName);
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "RasterRoadMap.getVectorMapData() iconname=" + iconName + ", resid=" + resid);
        }
        this.mLastestData = new Bundle();
        this.mLastestData.putString(ExpandMap.RasterType, RasterType.VECTOR);
        this.mLastestData.putBoolean(ExpandMap.UpdateProgress, isUpdateProgress);
        if (b.containsKey("road_name")) {
            this.mLastestData.putString("road_name", b.getString("road_name"));
        }
        if (b.containsKey(ExpandMap.TotalDist)) {
            this.mLastestData.putInt(ExpandMap.TotalDist, b.getInt(ExpandMap.TotalDist));
        }
        if (b.containsKey(ExpandMap.RemainDist)) {
            this.mLastestData.putInt(ExpandMap.RemainDist, b.getInt(ExpandMap.RemainDist));
        }
        if (b.containsKey(ExpandMap.AddDistance) && !isUpdateProgress) {
            this.mCurrentAddDistance = b.getInt(ExpandMap.AddDistance);
        }
        this.mLastestData.putInt("resid", resid);
        this.mLastestData.putInt(ExpandMap.LastCarPosX, this.mLastCurPosX);
        this.mLastestData.putInt(ExpandMap.LastCarPosY, this.mLastCurPosY);
        this.mLastestData.putInt(ExpandMap.LastCarRotate, this.mLastCurPosRotate);
        this.mLastestData.putInt(ExpandMap.CarPosX, b.getInt(ExpandMap.CarPosX, 0));
        this.mLastestData.putInt(ExpandMap.CarPosY, b.getInt(ExpandMap.CarPosY, 0));
        this.mLastestData.putInt(ExpandMap.CarRotate, b.getInt(ExpandMap.CarRotate, 0));
        if (!isUpdateProgress) {
            this.mLastestData.putInt(ExpandMap.LastCarPosX, 0);
            this.mLastestData.putInt(ExpandMap.LastCarPosY, 0);
            this.mLastestData.putInt(ExpandMap.LastCarRotate, 0);
            int[] imageBytes = b.getIntArray(ExpandMap.ImageBytes);
            if (imageBytes != null) {
                this.mVectorImgWidth = b.getInt(ExpandMap.ImageWidth, 0);
                this.mVectorImgHeight = b.getInt(ExpandMap.ImageHeight, 0);
                if (!getInstance().setRasterImage(imageBytes, this.mVectorImgWidth, this.mVectorImgHeight)) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "!# setRasterImage fail");
                    return null;
                }
            }
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "!# null vector image buffer!");
            return null;
        }
        return this.mLastestData;
    }

    public Bundle getStreetViewData(boolean isUpdateProgress, Bundle b) {
        if (b == null) {
            return null;
        }
        this.mLastestData = new Bundle();
        this.mLastestData.putString(ExpandMap.RasterType, RasterType.STREET);
        this.mLastestData.putBoolean(ExpandMap.UpdateProgress, isUpdateProgress);
        if (b.containsKey("road_name")) {
            this.mLastestData.putString("road_name", getRoadName(b.getString("road_name")));
        }
        if (b.containsKey(ExpandMap.StreetUid)) {
            String streetUid = b.getString(ExpandMap.StreetUid);
            this.mLastestData.putString(ExpandMap.StreetUid, streetUid);
            setmStreetUid(streetUid);
        }
        if (b.containsKey(ExpandMap.TotalDist)) {
            this.mLastestData.putInt(ExpandMap.TotalDist, b.getInt(ExpandMap.TotalDist));
        }
        if (b.containsKey(ExpandMap.RemainDist)) {
            this.mLastestData.putInt(ExpandMap.RemainDist, b.getInt(ExpandMap.RemainDist));
        }
        if (b.containsKey(ExpandMap.AddDistance) && !isUpdateProgress) {
            this.mCurrentAddDistance = b.getInt(ExpandMap.AddDistance);
        }
        if (!isUpdateProgress) {
            byte[] imageBytes = b.getByteArray(ExpandMap.ImageBytes);
            if (imageBytes == null || imageBytes.length <= 0) {
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "getStreetViewData BG Image Buf is Null!");
            } else {
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "getStreetViewData BG Image Buf is not Null!");
                try {
                    this.mBGBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                } catch (OutOfMemoryError e) {
                    this.mBGBitmap = null;
                }
            }
        }
        return this.mLastestData;
    }

    private String getRoadName(String roadName) {
        if ("地图上的点".equals(roadName) || RoutePlanParams.MY_LOCATION.equals(roadName) || "未知路".equals(roadName) || TrackDataShop.SPECIAL_ADDR_IN_TRACK.equals(roadName)) {
            return RoutePlanParams.TURN_TYPE_ID_END;
        }
        return roadName;
    }

    public int getVectorImgWidth() {
        return this.mVectorImgWidth;
    }

    public int getVectorImgHeight() {
        return this.mVectorImgHeight;
    }

    public void updateLastCarPos(int x, int y, int rotate) {
        this.mLastCurPosX = x;
        this.mLastCurPosY = y;
        this.mLastCurPosRotate = rotate;
    }

    public void setAnyEnlargeRoadMapShowing(boolean showing) {
        this.mIsAnyEnlargeRoadMapShowing = showing;
    }

    public boolean isAnyEnlargeRoadMapShowing() {
        return this.mIsAnyEnlargeRoadMapShowing;
    }

    public Bundle getLastestData() {
        return this.mLastestData;
    }

    public Boolean getIsClickToStreetView() {
        return this.IsClickToStreetView;
    }

    public void setIsClickToStreetView(Boolean isClickToStreetView) {
        this.IsClickToStreetView = isClickToStreetView;
    }

    public synchronized boolean isRasterImageValid(String bgName, String arrowName) {
        int i;
        byte[] arrowbuf;
        boolean z = true;
        synchronized (this) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "isRasterImageValid===>bgName=" + bgName + ", arrowName=" + arrowName);
            if (!(TextUtils.isEmpty(bgName) || bgName.equals(this.mBGName))) {
                if (!(this.mBGBitmap == null || this.mBGBitmap.isRecycled())) {
                    this.mBGBitmap.recycle();
                }
                this.mBGBitmap = null;
                this.mBGName = bgName;
                byte[] bgbuf = BNRouteGuider.getInstance().getRasterExpandMapImage(this.mBGName, 1);
                if (bgbuf != null && bgbuf.length > 0) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "BG Image Buf is not Null!");
                    i = 0;
                    try {
                        i = BitmapFactory.decodeByteArray(bgbuf, 0, bgbuf.length);
                        this.mBGBitmap = i;
                    } catch (OutOfMemoryError e) {
                        this.mBGBitmap = i;
                        this.mArrowBitmap.recycle();
                        this.mArrowBitmap = null;
                        this.mArrowName = arrowName;
                        arrowbuf = BNRouteGuider.getInstance().getRasterExpandMapImage(this.mArrowName, 0);
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "Arrow Image Buf is not Null!");
                        i = 0;
                        try {
                            i = BitmapFactory.decodeByteArray(arrowbuf, 0, arrowbuf.length);
                            this.mArrowBitmap = i;
                        } catch (OutOfMemoryError e2) {
                            this.mArrowBitmap = i;
                            z = false;
                            return z;
                        } finally {
                        }
                        z = false;
                        return z;
                    } finally {
                    }
                }
            }
            if (!(TextUtils.isEmpty(arrowName) || arrowName.equals(this.mArrowName))) {
                if (!(this.mArrowBitmap == null || this.mArrowBitmap.isRecycled())) {
                    this.mArrowBitmap.recycle();
                }
                this.mArrowBitmap = null;
                this.mArrowName = arrowName;
                arrowbuf = BNRouteGuider.getInstance().getRasterExpandMapImage(this.mArrowName, 0);
                if (arrowbuf != null && arrowbuf.length > 0) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "Arrow Image Buf is not Null!");
                    i = 0;
                    i = BitmapFactory.decodeByteArray(arrowbuf, 0, arrowbuf.length);
                    this.mArrowBitmap = i;
                }
            }
            if (this.mArrowBitmap == null || this.mBGBitmap == null) {
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean setRasterImage(int[] imageBuf, int width, int height) {
        boolean z;
        if (imageBuf != null) {
            if (imageBuf.length > 0 && width > 0 && height > 0) {
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "!# setRasterImage: image width=" + width + ", height=" + height);
                releaseBGBitmap();
                try {
                    this.mBGBitmap = Bitmap.createBitmap(imageBuf, width, height, Config.ARGB_8888);
                } catch (OutOfMemoryError e) {
                    this.mBGBitmap = null;
                }
                if (this.mBGBitmap == null) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "!# setRasterImage: create bitmap failed!!!!");
                }
                releaseArrowBitmap();
                z = true;
            }
        }
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "!# setRasterImage: null imageBuf!!");
        z = false;
        return z;
    }

    public Bitmap getArrowBitmap() {
        return this.mArrowBitmap;
    }

    public void releaseArrowBitmap() {
        try {
            if (!(this.mArrowBitmap == null || this.mArrowBitmap.isRecycled())) {
                this.mArrowBitmap.recycle();
            }
            this.mArrowBitmap = null;
        } catch (Exception e) {
            this.mArrowBitmap = null;
        }
    }

    public boolean isBGBitmapValid() {
        if (this.mBGBitmap != null) {
            return true;
        }
        return false;
    }

    public Bitmap getBGBitmap() {
        return this.mBGBitmap;
    }

    public void releaseBGBitmap() {
        try {
            if (!(this.mBGBitmap == null || this.mBGBitmap.isRecycled())) {
                this.mBGBitmap.recycle();
            }
            this.mBGBitmap = null;
        } catch (Exception e) {
            this.mBGBitmap = null;
        }
    }

    public void reset() {
        releaseArrowBitmap();
        releaseBGBitmap();
        this.mIsAnyEnlargeRoadMapShowing = false;
        if (this.mLastestData != null) {
            this.mLastestData.clear();
            this.mLastestData = null;
        }
        this.mBGName = null;
        this.mArrowName = null;
        this.mStreetUid = null;
    }

    public void saveBGBitmap() {
        if (this.mBGBitmap != null) {
            File dir = new File(SysOSAPI.getInstance().GetSDCardPath() + "/enlarge");
            if (!dir.exists()) {
                dir.mkdir();
            }
            if (dir.exists()) {
                String name = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + "-android.png";
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "saveBGBitmap() path=" + SysOSAPI.getInstance().GetSDCardPath() + "/enlarge" + name);
                File f = new File(SysOSAPI.getInstance().GetSDCardPath() + "/enlarge", name);
                if (f.exists()) {
                    f.delete();
                }
                try {
                    FileOutputStream out = new FileOutputStream(f);
                    this.mBGBitmap.compress(CompressFormat.PNG, 90, out);
                    out.flush();
                    out.close();
                    return;
                } catch (FileNotFoundException e) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "saveBGBitmap() FileNotFoundException.");
                    e.printStackTrace();
                    return;
                } catch (IOException e2) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "saveBGBitmap() IOException.");
                    e2.printStackTrace();
                    return;
                }
            }
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "saveBGBitmap() failed to create dir.");
            return;
        }
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "saveBGBitmap() bg is null.");
    }

    public String getRoadName() {
        if (this.mLastestData != null) {
            return this.mLastestData.getString("road_name");
        }
        return "未知路";
    }

    public int getRoadmapProgress() {
        int remDist = getRoadmapRemainDis();
        int totalDist = this.mLastestData.getInt(ExpandMap.TotalDist);
        if (remDist <= 0 || totalDist <= 0) {
            return 100;
        }
        return ((totalDist - remDist) * 100) / totalDist;
    }

    public int getRoadmapRemainDis() {
        if (this.mLastestData != null) {
            return this.mLastestData.getInt(ExpandMap.RemainDist);
        }
        return 0;
    }

    public int getEnlargeMapTypeForStatisitcs() {
        return this.mEnlargeMapTypeForStatisitcs;
    }

    public void setEnlargeMapTypeForStatisitcs(int type) {
        this.mEnlargeMapTypeForStatisitcs = type;
    }
}
