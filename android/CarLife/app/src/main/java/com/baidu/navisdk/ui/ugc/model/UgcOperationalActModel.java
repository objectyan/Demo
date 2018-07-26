package com.baidu.navisdk.ui.ugc.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UgcOperationalActModel {
    private static final String TAG = UgcOperationalActModel.class.getName();
    public static final int TYPE_DEFAULT_ELECTRON_EYE = 3;
    public static final int TYPE_DEFAULT_FACING_DIRECTION = 27;
    public static final int TYPE_DEFAULT_FORBID_REVERSE = 22;
    public static final int TYPE_DEFAULT_FORBID_TURN_LEFT = 21;
    public static final int TYPE_DEFAULT_FORBID_TURN_RIGHT = 23;
    public static final int TYPE_DEFAULT_MAP_POINT = 29;
    public static final int TYPE_DEFAULT_NEW_ROAD = 1;
    public static final int TYPE_DEFAULT_REGULATIONS_BREAK = 24;
    public static final int TYPE_DEFAULT_ROAD_BUILD = 6;
    public static final int TYPE_DEFAULT_ROAD_CLOSED = 7;
    public static final int TYPE_DEFAULT_SAME_DIRECTION = 28;
    public static final int TYPE_DEFAULT_SPEED_LIMITED = 26;
    public static final int TYPE_DEFAULT_TRAFIC_ACCIDENT = 5;
    public static final int TYPE_DEFAULT_TRAFIC_JAM = 4;
    public static final int TYPE_DEFAULT_TRAFIC_LIGHT = 25;
    public static final int TYPE_DEFAULT_TRAFIC_REGULATE = 8;
    public static final int TYPE_DEFAULT_TRAFIC_RULE = 2;
    public static final int TYPE_UGC_ACT_BANNER_ICON = 4097;
    public static final int TYPE_UGC_ACT_CAMARA_ICON = 4098;
    public static final int TYPE_UGC_ACT_ENTRY_ICON = 4096;
    public static final int TYPE_UGC_CAMARA_ICON = 4099;
    public static final int TYPE_UGC_MAP_POINT_ICON = 4100;
    public static final int TYPE_UGC_REPORT_UP_ICON = 4101;
    private static UgcOperationalActModel instance;
    private static Map<Integer, SoftReference<Bitmap>> mBitMapCache;
    public static ArrayList<UgcBaseDataModel> mDefaultMapUgcDataList = null;
    public static ArrayList<UgcBaseDataModel> mDefaultNaviUgcDataList = null;
    private static Map<Integer, Integer> mDrawableIdCache = null;
    private static Map<Integer, String> mUrlCache;
    public boolean isWebDataValid = false;
    private actBaseDataModel mActBaseDataModel = null;
    private CommonBaseDataModel mCommonBaseDataModel = null;
    public ArrayList<UgcBaseDataModel> mMapUgcDataList = null;
    public ArrayList<UgcBaseDataModel> mNaviUgcDataList = null;
    public UgcReportSerInfoPackage mUgcReportSerInfoPackage = new UgcReportSerInfoPackage();
    public UgcViewShowModel mUgcViewShowModel = new UgcViewShowModel();
    public ArrayList<Long> ugcReportEventIdList = new ArrayList();

    public interface BaseDataModel {
        String getSpecificDataLog();

        void initIconUrl();

        void setIcon(String str, Bitmap bitmap);
    }

    public static class CommonBaseDataModel implements BaseDataModel {
        public SoftReference<Bitmap> caramaIcon = null;
        public String caramaIconUrl = null;
        public String caramaTitle = null;
        public String mapPointIconUrl = null;
        public String mapPointTitle = null;
        public String textLeft = null;
        public String textNew = null;
        public String textRight = null;

        public CommonBaseDataModel(String caramaTitle, String caramaIconUrl, String mapPointTitle, String mapPointIconUrl) {
            this.caramaTitle = caramaTitle;
            this.caramaIconUrl = caramaIconUrl;
            this.mapPointTitle = mapPointTitle;
            this.mapPointIconUrl = mapPointIconUrl;
        }

        public void setFeedbackStyle(String textLeft, String textRight, String textNew) {
            this.textLeft = textLeft;
            this.textRight = textRight;
            this.textNew = textNew;
        }

        public String getSpecificDataLog() {
            StringBuffer sb = new StringBuffer();
            sb.append("carama:{");
            sb.append("caramaTitle:" + this.caramaTitle + ",");
            sb.append("caramaIconUrl:" + this.caramaIconUrl);
            sb.append("}");
            sb.append("map_point:{");
            sb.append("mapPointTitle:" + this.mapPointTitle + ",");
            sb.append("mapPointIconUrl:" + this.mapPointIconUrl);
            sb.append("}");
            return sb.toString();
        }

        public void initIconUrl() {
            if (UgcOperationalActModel.mUrlCache == null) {
                UgcOperationalActModel.mUrlCache = new HashMap();
            }
            if (this.caramaIconUrl != null && this.mapPointIconUrl != null) {
                UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4099), this.caramaIconUrl);
                UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4100), this.mapPointIconUrl);
            }
        }

        public Bitmap getCaramaIcon(ImageView mImageView) {
            if (this.caramaIconUrl == null || this.caramaIcon == null || this.caramaIcon.get() == null) {
                return null;
            }
            return (Bitmap) this.caramaIcon.get();
        }

        public void setIcon(String url, Bitmap mBitmap) {
            if (url != null && mBitmap != null && this.caramaIconUrl != null && this.caramaIconUrl.endsWith(url)) {
                this.caramaIcon = new SoftReference(mBitmap);
            }
        }
    }

    public static class UgcBaseDataModel implements BaseDataModel {
        public SoftReference<Bitmap> iconImage;
        public String iconUrl;
        public String title;
        public int type;
        public ArrayList<UgcBaseDataModel> ugcDataSub = null;

        public UgcBaseDataModel(String title, int type, String iconUrl) {
            this.title = title;
            this.type = type;
            this.iconUrl = iconUrl;
            initIconUrl();
        }

        public void addSubUgcData(UgcBaseDataModel mUgcDataModel) {
            if (this.ugcDataSub == null) {
                this.ugcDataSub = new ArrayList();
            }
            if (this.ugcDataSub != null) {
                this.ugcDataSub.add(mUgcDataModel);
            }
        }

        public String getSpecificDataLog() {
            StringBuffer sb = new StringBuffer();
            sb.append("{");
            sb.append("title:" + this.title + ",");
            sb.append("type:" + this.type + ",");
            sb.append("iconUrl:" + this.iconUrl);
            if (this.ugcDataSub != null) {
                Iterator it = this.ugcDataSub.iterator();
                while (it.hasNext()) {
                    sb.append(((UgcBaseDataModel) it.next()).getSpecificDataLog());
                }
            }
            sb.append("}");
            return sb.toString();
        }

        public void initIconUrl() {
            if (UgcOperationalActModel.mUrlCache == null) {
                UgcOperationalActModel.mUrlCache = new HashMap();
            }
            if (this.iconUrl != null) {
                UgcOperationalActModel.mUrlCache.put(Integer.valueOf(this.type), this.iconUrl);
            }
        }

        public void setIcon(String url, Bitmap mBitmap) {
            if (this.iconUrl != null && url != null && mBitmap != null && this.iconUrl.equals(url)) {
                this.iconImage = new SoftReference(mBitmap);
            }
        }
    }

    public static class UgcReportSerInfoPackage {
        public String Name = "";
        public String business_trigger = "1";
        public String content = "";
        public String fromName = "";
        public String fromPoint = "";
        public String fromUid = "";
        public String parentType = QPlayAutoJNI.SONG_LIST_ROOT_ID;
        public String photoPicPath = null;
        public String photoPoint = "";
        public String point = "";
        public String screenshotPicPath = null;
        public String sessionId = "";
        public String subType = "";
        public String toName = "";
        public String toPoint = "";
        public String toUid = "";
        public String uploadType = "1";
        public String userPoint = "";
        public String voicePath = null;

        public void clearInfo() {
            this.uploadType = "1";
            this.fromPoint = "";
            this.fromUid = "";
            this.fromName = "";
            this.toPoint = "";
            this.toUid = "";
            this.toName = "";
            this.business_trigger = "1";
            this.Name = "";
            this.parentType = QPlayAutoJNI.SONG_LIST_ROOT_ID;
            this.subType = "";
            this.content = "";
            this.screenshotPicPath = null;
            this.photoPicPath = null;
            this.voicePath = null;
            this.point = "";
            this.photoPoint = "";
            this.userPoint = "";
            this.sessionId = "";
        }

        public String resportInfoComplemented() {
            return null;
        }
    }

    public static class UgcViewShowModel {
        public String content = null;
        public boolean hasPhoto = false;
        public int parentType = -1;
        public int subType = -1;
        public int sumTime = -1;

        public void dataClear() {
            this.parentType = -1;
            this.subType = -1;
            this.content = null;
            this.sumTime = -1;
            this.hasPhoto = false;
        }
    }

    public static class actBaseDataModel implements BaseDataModel {
        public SoftReference<Bitmap> bannerIcon = null;
        public String bannerIconUrl = null;
        public String bannerTips = null;
        public String bottonTips = null;
        public SoftReference<Bitmap> camaraIcon = null;
        public String camaraIconUrl = null;
        public String camraTips = null;
        public SoftReference<Bitmap> entryIcon = null;
        public String entryIconUrl = null;
        public String entryTips = null;

        public actBaseDataModel(String entryIconUrl, String bannerIconUrl, String camaraIconUrl, String entryTips, String bannerTips, String camraTips, String bottonTips) {
            this.entryIconUrl = entryIconUrl;
            this.bannerIconUrl = bannerIconUrl;
            this.camaraIconUrl = camaraIconUrl;
            this.entryTips = entryTips;
            this.bannerTips = bannerTips;
            this.camraTips = camraTips;
            this.bottonTips = bottonTips;
            initIconUrl();
        }

        public String getSpecificDataLog() {
            StringBuffer sb = new StringBuffer();
            sb.append("act:{");
            sb.append("entryIconUrl:" + this.entryIconUrl + ",");
            sb.append("bannerIconUrl:" + this.bannerIconUrl + ",");
            sb.append("camaraIconUrl:" + this.camaraIconUrl + ",");
            sb.append("entryTips:" + this.entryTips + ",");
            sb.append("bannerTips:" + this.bannerTips + ",");
            sb.append("camraTips:" + this.camraTips + ",");
            sb.append("bottonTips:" + this.bottonTips);
            sb.append("}");
            return sb.toString();
        }

        public void initIconUrl() {
            if (UgcOperationalActModel.mUrlCache == null) {
                UgcOperationalActModel.mUrlCache = new HashMap();
            }
            if (this.entryIconUrl != null && this.bannerIconUrl != null && this.camaraIconUrl != null) {
                UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4096), this.entryIconUrl);
                UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4097), this.bannerIconUrl);
                UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4098), this.camaraIconUrl);
            }
        }

        public void setIcon(String url, Bitmap mBitmap) {
            if (url != null && mBitmap != null) {
                if (this.entryIconUrl != null && this.entryIconUrl.endsWith(url)) {
                    this.entryIcon = new SoftReference(mBitmap);
                } else if (this.bannerIconUrl != null && this.bannerIconUrl.endsWith(url)) {
                    this.bannerIcon = new SoftReference(mBitmap);
                } else if (this.camaraIconUrl != null && this.camaraIconUrl.endsWith(url)) {
                    this.camaraIcon = new SoftReference(mBitmap);
                }
            }
        }
    }

    private UgcOperationalActModel() {
        mBitMapCache = new HashMap();
        mDrawableIdCache = new HashMap();
        mDrawableIdCache.put(Integer.valueOf(4096), Integer.valueOf(C4048R.drawable.ugc_upload));
        mDrawableIdCache.put(Integer.valueOf(4098), Integer.valueOf(C4048R.drawable.ugc_report_camera_icon));
        mDrawableIdCache.put(Integer.valueOf(4099), Integer.valueOf(C4048R.drawable.ugc_report_camera_icon));
        mDrawableIdCache.put(Integer.valueOf(4100), Integer.valueOf(C4048R.drawable.ugc_report_map_point_icon));
        mDrawableIdCache.put(Integer.valueOf(1), Integer.valueOf(C4048R.drawable.type_default_new_road));
        mDrawableIdCache.put(Integer.valueOf(2), Integer.valueOf(C4048R.drawable.type_default_trafic_rule));
        mDrawableIdCache.put(Integer.valueOf(3), Integer.valueOf(C4048R.drawable.type_default_electron_eye));
        mDrawableIdCache.put(Integer.valueOf(4), Integer.valueOf(C4048R.drawable.type_default_trafic_jam));
        mDrawableIdCache.put(Integer.valueOf(5), Integer.valueOf(C4048R.drawable.type_default_trafic_accident));
        mDrawableIdCache.put(Integer.valueOf(6), Integer.valueOf(C4048R.drawable.type_default_road_build));
        mDrawableIdCache.put(Integer.valueOf(7), Integer.valueOf(C4048R.drawable.type_default_road_closed));
        mDrawableIdCache.put(Integer.valueOf(8), Integer.valueOf(C4048R.drawable.ugc_default_pic));
        mDrawableIdCache.put(Integer.valueOf(21), Integer.valueOf(C4048R.drawable.type_default_forbid_turn_left));
        mDrawableIdCache.put(Integer.valueOf(22), Integer.valueOf(C4048R.drawable.type_default_forbid_reverse));
        mDrawableIdCache.put(Integer.valueOf(23), Integer.valueOf(C4048R.drawable.type_default_forbid_turn_right));
        mDrawableIdCache.put(Integer.valueOf(24), Integer.valueOf(C4048R.drawable.type_default_regulations_break));
        mDrawableIdCache.put(Integer.valueOf(25), Integer.valueOf(C4048R.drawable.type_default_trafic_light));
        mDrawableIdCache.put(Integer.valueOf(26), Integer.valueOf(C4048R.drawable.type_default_speed_limited));
        mDrawableIdCache.put(Integer.valueOf(27), Integer.valueOf(C4048R.drawable.type_default_facing_direction));
        mDrawableIdCache.put(Integer.valueOf(28), Integer.valueOf(C4048R.drawable.type_default_same_direction));
        mDrawableIdCache.put(Integer.valueOf(29), Integer.valueOf(C4048R.drawable.ugc_report_map_point_icon));
    }

    public static void initDefaultData() {
        mDefaultMapUgcDataList = new ArrayList();
        UgcBaseDataModel mMapPointDataModel = new UgcBaseDataModel("地图选点", 29, null);
        UgcBaseDataModel mUgcBaseDataModel = new UgcBaseDataModel("拥堵", 4, null);
        mUgcBaseDataModel.addSubUgcData(mMapPointDataModel);
        mDefaultMapUgcDataList.add(mUgcBaseDataModel);
        mUgcBaseDataModel = new UgcBaseDataModel("事故", 5, null);
        mUgcBaseDataModel.addSubUgcData(mMapPointDataModel);
        mDefaultMapUgcDataList.add(mUgcBaseDataModel);
        mUgcBaseDataModel = new UgcBaseDataModel("施工", 6, null);
        mUgcBaseDataModel.addSubUgcData(mMapPointDataModel);
        mDefaultMapUgcDataList.add(mUgcBaseDataModel);
        mUgcBaseDataModel = new UgcBaseDataModel("封路", 7, null);
        mUgcBaseDataModel.addSubUgcData(mMapPointDataModel);
        mDefaultMapUgcDataList.add(mUgcBaseDataModel);
        mDefaultNaviUgcDataList = new ArrayList();
        UgcBaseDataModel mFacingDirectionDataModel = new UgcBaseDataModel("对向车道", 27, null);
        UgcBaseDataModel mSameDirectionDataModel = new UgcBaseDataModel("同向车道", 28, null);
        mDefaultNaviUgcDataList.add(new UgcBaseDataModel("新路", 1, null));
        mUgcBaseDataModel = new UgcBaseDataModel("交规", 2, null);
        mUgcBaseDataModel.addSubUgcData(new UgcBaseDataModel("禁左", 21, null));
        mUgcBaseDataModel.addSubUgcData(new UgcBaseDataModel("禁调头", 22, null));
        mUgcBaseDataModel.addSubUgcData(new UgcBaseDataModel("禁右", 23, null));
        mDefaultNaviUgcDataList.add(mUgcBaseDataModel);
        mUgcBaseDataModel = new UgcBaseDataModel("电子眼", 3, null);
        mUgcBaseDataModel.addSubUgcData(new UgcBaseDataModel("违章", 24, null));
        mUgcBaseDataModel.addSubUgcData(new UgcBaseDataModel("红绿灯", 25, null));
        mUgcBaseDataModel.addSubUgcData(new UgcBaseDataModel("限速", 26, null));
        mDefaultNaviUgcDataList.add(mUgcBaseDataModel);
        mUgcBaseDataModel = new UgcBaseDataModel("拥堵", 4, null);
        mUgcBaseDataModel.addSubUgcData(mFacingDirectionDataModel);
        mUgcBaseDataModel.addSubUgcData(mSameDirectionDataModel);
        mDefaultNaviUgcDataList.add(mUgcBaseDataModel);
        mUgcBaseDataModel = new UgcBaseDataModel("事故", 5, null);
        mUgcBaseDataModel.addSubUgcData(mFacingDirectionDataModel);
        mUgcBaseDataModel.addSubUgcData(mSameDirectionDataModel);
        mDefaultNaviUgcDataList.add(mUgcBaseDataModel);
        mUgcBaseDataModel = new UgcBaseDataModel("施工", 6, null);
        mUgcBaseDataModel.addSubUgcData(mFacingDirectionDataModel);
        mUgcBaseDataModel.addSubUgcData(mSameDirectionDataModel);
        mDefaultNaviUgcDataList.add(mUgcBaseDataModel);
        mUgcBaseDataModel = new UgcBaseDataModel("封路", 7, null);
        mUgcBaseDataModel.addSubUgcData(mFacingDirectionDataModel);
        mUgcBaseDataModel.addSubUgcData(mSameDirectionDataModel);
        mDefaultNaviUgcDataList.add(mUgcBaseDataModel);
    }

    public static UgcOperationalActModel getInstance() {
        if (instance == null) {
            instance = new UgcOperationalActModel();
        }
        return instance;
    }

    public void addMapUgcBaseDataModel(UgcBaseDataModel mUgcBaseDataModel) {
        if (this.mMapUgcDataList == null) {
            this.mMapUgcDataList = new ArrayList();
        }
        if (this.mMapUgcDataList != null) {
            this.mMapUgcDataList.add(mUgcBaseDataModel);
        }
    }

    public void addNaviUgcBaseDataModel(UgcBaseDataModel mUgcBaseDataModel) {
        if (this.mNaviUgcDataList == null) {
            this.mNaviUgcDataList = new ArrayList();
        }
        if (this.mNaviUgcDataList != null) {
            this.mNaviUgcDataList.add(mUgcBaseDataModel);
        }
    }

    public CommonBaseDataModel getCommonBaseDataModel() {
        return this.mCommonBaseDataModel;
    }

    public void setCommonBaseDataModel(CommonBaseDataModel mCommonBaseDataModel) {
        this.mCommonBaseDataModel = mCommonBaseDataModel;
    }

    public actBaseDataModel getActBaseDataModel() {
        return this.mActBaseDataModel;
    }

    public void setActBaseDataModel(actBaseDataModel mActBaseDataModel) {
        this.mActBaseDataModel = mActBaseDataModel;
    }

    public void showSpecificDataLog() {
        Iterator it;
        UgcBaseDataModel mUgcBaseDataModel;
        StringBuffer sb = new StringBuffer();
        if (this.mActBaseDataModel != null) {
            sb.append(this.mActBaseDataModel.getSpecificDataLog());
            sb.append("\r\n");
        }
        if (this.mCommonBaseDataModel != null) {
            sb.append(this.mCommonBaseDataModel.getSpecificDataLog());
            sb.append("\r\n");
        }
        if (this.mMapUgcDataList != null) {
            it = this.mMapUgcDataList.iterator();
            while (it.hasNext()) {
                mUgcBaseDataModel = (UgcBaseDataModel) it.next();
                if (mUgcBaseDataModel != null) {
                    sb.append(mUgcBaseDataModel.getSpecificDataLog());
                    sb.append("\r\n");
                }
            }
        }
        if (!(this.mNaviUgcDataList == null || this.mNaviUgcDataList == null)) {
            it = this.mNaviUgcDataList.iterator();
            while (it.hasNext()) {
                mUgcBaseDataModel = (UgcBaseDataModel) it.next();
                if (mUgcBaseDataModel != null) {
                    sb.append(mUgcBaseDataModel.getSpecificDataLog());
                    sb.append("\r\n");
                }
            }
        }
        LogUtil.m15791e(TAG, sb.toString());
    }

    public void clearBaseDataModel() {
        if (this.mMapUgcDataList != null) {
            this.mMapUgcDataList.clear();
            this.mMapUgcDataList = null;
        }
        if (this.mNaviUgcDataList != null) {
            this.mNaviUgcDataList.clear();
            this.mNaviUgcDataList = null;
        }
        this.mActBaseDataModel = null;
        this.mCommonBaseDataModel = null;
    }

    public boolean isInOperationAct() {
        return this.mActBaseDataModel != null;
    }

    public void setUgcBitMapWithType(int type, Bitmap mBitmap) {
        if (mBitmap != null) {
            if (mBitMapCache == null) {
                mBitMapCache = new HashMap();
            }
            mBitMapCache.put(Integer.valueOf(type), new SoftReference(mBitmap));
        }
    }

    public Bitmap getUgcBitMapByType(int type) {
        if (mBitMapCache == null || !mBitMapCache.containsKey(Integer.valueOf(type))) {
            return null;
        }
        return (Bitmap) ((SoftReference) mBitMapCache.get(Integer.valueOf(type))).get();
    }

    public int getUgcDrawableIdByType(int type) {
        if (mDrawableIdCache == null || !mDrawableIdCache.containsKey(Integer.valueOf(type))) {
            return -1;
        }
        return ((Integer) mDrawableIdCache.get(Integer.valueOf(type))).intValue();
    }

    public String getUrlByType(int type) {
        if (mUrlCache == null || !mUrlCache.containsKey(Integer.valueOf(type))) {
            return null;
        }
        return (String) mUrlCache.get(Integer.valueOf(type));
    }

    public boolean isContainsEventId(Long eventId) {
        if (this.ugcReportEventIdList != null) {
            Iterator it = this.ugcReportEventIdList.iterator();
            while (it.hasNext()) {
                if (((Long) it.next()) == eventId) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addEventId(Long eventId) {
        if (this.ugcReportEventIdList == null) {
            this.ugcReportEventIdList = new ArrayList();
        }
        this.ugcReportEventIdList.add(eventId);
    }
}
