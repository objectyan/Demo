package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.subview.BNavR;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.DateTimeUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class RGSimpleGuideModel {
    public static final int UPDATE_TYPE_NEXTINFO = 1;
    public static final int UPDATE_TYPE_TOTALINFO = 2;
    public static int mCalcRouteType = 0;
    private static RGSimpleGuideModel mInstance = null;
    public static boolean mIsOfflineToOnline = false;
    public static boolean mIsRPPrefer = false;
    public static boolean mIsSafetyShareGuideShow = false;
    public static boolean mIsSatellite = false;
    public static boolean mIsUgcOfficialEvent = false;
    public static Bundle sSimpleGuideBundle = new Bundle();
    private final String TAG = ModuleName.ROUTEGUIDE;
    public boolean canSilentIconShow = false;
    public boolean isCalcRouteFail = false;
    public boolean isFirstDataOk = false;
    private long mArriveTime = 0;
    private String mArriveTimeS = "";
    public double mCompletePercentage = 0.0d;
    private String mCurIconName = new String();
    private String mCurRoadName = "";
    private int mDistCur2NextGP = 1000;
    private int mFirstGuideMatchMode;
    private boolean mIsGPSFixed = false;
    private boolean mIsGarlogoFree = false;
    private boolean mIsHighwayExCur2NextGP = false;
    private boolean mIsStraight = false;
    private boolean mIsYawing = false;
    private String mLastIconName = new String();
    private Bundle mNextGuideInfoBundle = new Bundle();
    private int mNextTurnKind = 0;
    private int mSatelliteNum = 0;
    private String mTTSText = null;
    private Bundle mTotalInfoBundle = new Bundle();
    private String mTotalRemainDistS = "";
    private String mTotalRemainTime = "";
    public HashMap<String, Integer> mTurnIconMap = new HashMap();
    HashMap<String, String> mTurnNameMap = new HashMap();

    public interface CalcRouteTypeInNav {
        public static final int TYPE_ADD_VIA = 1;
        public static final int TYPE_CAR_PLATE = 3;
        public static final int TYPE_END_CAR_PARK = 4;
        public static final int TYPE_INVALID = 0;
        public static final int TYPE_ROUTE_SORT = 2;
    }

    public RGSimpleGuideModel() {
        int size = RouteGuideParams.gTurnIconName.length;
        for (int i = 0; i < size; i++) {
            this.mTurnIconMap.put(RouteGuideParams.gTurnIconName[i], Integer.valueOf(BNavR.gTurnIconID[i]));
            this.mTurnNameMap.put(RouteGuideParams.gTurnIconName[i], RouteGuideParams.gTurnTypeDesc[i]);
        }
        this.mLastIconName = "";
        this.mCurIconName = "";
    }

    public static RGSimpleGuideModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGSimpleGuideModel();
        }
        return mInstance;
    }

    public String getTurnNameFromTurnIcon(String turnIcon) {
        if (turnIcon == null) {
            return null;
        }
        return (String) this.mTurnNameMap.get(turnIcon);
    }

    public int getTurnIconRes(String iconName) {
        int resId = -1;
        if (iconName != null && this.mTurnIconMap.containsKey(iconName)) {
            resId = ((Integer) this.mTurnIconMap.get(iconName)).intValue();
        }
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "getTurnIconRes() in=" + iconName + ", id=" + resId);
        return resId;
    }

    public Bundle updateNextGuideInfo() {
        boolean z;
        boolean z2 = true;
        this.mNextGuideInfoBundle.putInt("updatetype", 1);
        String nextRoad = sSimpleGuideBundle.getString("road_name");
        String iconName = sSimpleGuideBundle.getString("icon_name");
        int nDist = sSimpleGuideBundle.getInt(SimpleGuideInfo.RemainDist);
        int nStartDist = sSimpleGuideBundle.getInt(SimpleGuideInfo.StartDist);
        if (sSimpleGuideBundle.getInt("straight", 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.mIsStraight = z;
        this.mNextGuideInfoBundle.putBoolean("straight", this.mIsStraight);
        LogUtil.m15791e("test", "nextRoad = " + nextRoad);
        int resId = ((Integer) this.mTurnIconMap.get(RouteGuideParams.gTurnIconName[0])).intValue();
        if (iconName != null && this.mTurnIconMap.containsKey(iconName)) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "updateGuideInfo==   iconName=" + iconName);
            this.mNextGuideInfoBundle.putInt("resid", ((Integer) this.mTurnIconMap.get(iconName)).intValue());
            this.mNextGuideInfoBundle.putString("icon_name", iconName);
            viaPointProcess(iconName);
        }
        if (nextRoad != null) {
            this.mNextGuideInfoBundle.putString("road_name", nextRoad);
        }
        String curRoadName = sSimpleGuideBundle.getString(SimpleGuideInfo.CurRoadName);
        if (curRoadName != null) {
            this.mNextGuideInfoBundle.putString(SimpleGuideInfo.CurRoadName, curRoadName);
        }
        this.mNextGuideInfoBundle.putInt(SimpleGuideInfo.RemainDist, nDist);
        this.mNextGuideInfoBundle.putInt(SimpleGuideInfo.StartDist, nStartDist);
        this.mNextTurnKind = 0;
        if (sSimpleGuideBundle.containsKey(SimpleGuideInfo.NextTurnKind)) {
            this.mNextTurnKind = sSimpleGuideBundle.getInt(SimpleGuideInfo.NextTurnKind);
        }
        this.mDistCur2NextGP = 1000;
        if (sSimpleGuideBundle.containsKey(SimpleGuideInfo.DistCur2NextGP)) {
            this.mDistCur2NextGP = sSimpleGuideBundle.getInt(SimpleGuideInfo.DistCur2NextGP);
        }
        this.mIsHighwayExCur2NextGP = false;
        if (sSimpleGuideBundle.containsKey(SimpleGuideInfo.HighwayExCur2NextGP)) {
            if (sSimpleGuideBundle.getInt(SimpleGuideInfo.HighwayExCur2NextGP) <= 0) {
                z2 = false;
            }
            this.mIsHighwayExCur2NextGP = z2;
        }
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "RGSimpleGuideModel.updateNextGuideInfo() mNextTurnKind=" + this.mNextTurnKind + ", mDistCur2NextGP=" + this.mDistCur2NextGP + ", mIsHighwayExCur2NextGP=" + this.mIsHighwayExCur2NextGP);
        return this.mNextGuideInfoBundle;
    }

    public Bundle getNextGuideInfo() {
        return this.mNextGuideInfoBundle;
    }

    public boolean isFirstGuideFuzzy() {
        return this.mFirstGuideMatchMode == 1;
    }

    public String getFuzzyTV() {
        Bundle bundle = new Bundle();
        JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
        return bundle.getString(SimpleGuideInfo.PlanarName);
    }

    public boolean isStraight() {
        return this.mIsStraight;
    }

    public String updateTTSText(String text) {
        String ttsText = text;
        if (ttsText == null || ttsText.length() == 0) {
            return ttsText;
        }
        this.mTTSText = ttsText;
        if (ttsText.startsWith("嘀嘀嘀")) {
            this.mTTSText = ttsText.substring("嘀嘀嘀".length());
        }
        return this.mTTSText;
    }

    public String getTTSText() {
        return this.mTTSText;
    }

    public boolean isGPSOpened() {
        return BNSysLocationManager.getInstance().isGpsEnabled();
    }

    public void updateGPSFixed(boolean isFixed) {
        this.mIsGPSFixed = isFixed;
        BNEventManager.getInstance().onOtherAction(this.mIsGPSFixed ? 5 : 6, 0, 0, null);
    }

    public boolean isGPSFixed() {
        if (BNavConfig.pRGLocateMode == 2) {
            return true;
        }
        return this.mIsGPSFixed;
    }

    public void updateCarlogoFree(boolean isFree) {
        this.mIsGarlogoFree = isFree;
    }

    public boolean isCarlogoFree() {
        if (BNavConfig.pRGLocateMode == 2) {
            return false;
        }
        return this.mIsGarlogoFree;
    }

    public void updateSatelliteNum(int satelliteNum) {
        if (satelliteNum < 0) {
            satelliteNum = 0;
        }
        if (satelliteNum > 15) {
            satelliteNum = 15;
        }
        this.mSatelliteNum = satelliteNum;
    }

    public int getSatelliteNum() {
        if (this.mIsGPSFixed) {
            return this.mSatelliteNum;
        }
        return 0;
    }

    public Bundle updateTotalRemainDistAndTime(int nDist, int nTime) {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "updateTotalRemainDistAndTime() nDist=" + nDist + ", nTime=" + nTime);
        this.mTotalInfoBundle.putInt("updatetype", 2);
        this.mTotalInfoBundle.putInt(SimpleGuideInfo.TotalDist, nDist);
        this.mTotalInfoBundle.putInt(SimpleGuideInfo.TotalTime, nTime);
        NaviStatItem.getInstance().mDistToDest = (long) nDist;
        calculateCompletePercentage(nDist);
        calculateTotalRemainDistString(nDist);
        calculateArriveTime(nTime);
        calculateTotalRemainTimeString(nTime);
        return this.mTotalInfoBundle;
    }

    public Bundle getTotalInfo() {
        return this.mTotalInfoBundle;
    }

    private void calculateTotalRemainDistString(int nDist) {
        StringBuffer builder = new StringBuffer("剩余");
        StringUtils.formatDistance(nDist, UnitLangEnum.ZH, builder);
        this.mTotalRemainDistS = builder.toString();
    }

    private void calculateTotalRemainTimeString(int nTime) {
        this.mTotalRemainTime = StringUtils.getFormatTime((long) nTime);
    }

    public String getTotalRemainDistString() {
        return this.mTotalRemainDistS;
    }

    public String getTotalRemainTimeString() {
        return this.mTotalRemainTime;
    }

    private void calculateArriveTime(int remainTime) {
        this.mArriveTime = System.currentTimeMillis();
        Date curDate = new Date(this.mArriveTime);
        this.mArriveTime += (long) (remainTime * 1000);
        Date arriveDate = new Date(this.mArriveTime);
        this.mArriveTimeS = new SimpleDateFormat("HH:mm").format(arriveDate);
        GregorianCalendar curCal = new GregorianCalendar();
        curCal.setTime(curDate);
        GregorianCalendar arriveCal = new GregorianCalendar();
        arriveCal.setTime(arriveDate);
        if (curCal.get(5) == arriveCal.get(5)) {
            this.mArriveTimeS = String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{this.mArriveTimeS});
            return;
        }
        int interval = getIntervalDays(curDate, arriveDate);
        if (interval == 1) {
            this.mArriveTimeS = String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time_at_tomorrow), new Object[]{this.mArriveTimeS});
        } else if (interval > 1) {
            String weekDay = DateTimeUtils.getWeek(arriveDate);
            this.mArriveTimeS = String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time_at_week_day), new Object[]{weekDay, this.mArriveTimeS});
        } else {
            this.mArriveTimeS = String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{this.mArriveTimeS});
        }
    }

    public String getArriveTimeString() {
        return this.mArriveTimeS;
    }

    public String getArriveTimeChineseString() {
        String str = null;
        if (this.mArriveTimeS != null && this.mArriveTimeS.length() > 0) {
            String[] s = this.mArriveTimeS.substring(0, 5).split(Config.TRACE_TODAY_VISIT_SPLIT);
            if (s != null && s.length >= 2) {
                try {
                    StringBuffer sb = new StringBuffer();
                    sb.append(StringUtils.doubleNumberToChineseWord(Integer.parseInt(s[0])));
                    sb.append("点");
                    sb.append(StringUtils.doubleNumberToChineseWord(Integer.parseInt(s[1])));
                    sb.append("分到达");
                    str = sb.toString();
                } catch (Exception e) {
                }
            }
        }
        return str;
    }

    private static int getIntervalDays(Date fDate, Date oDate) {
        if (fDate == null || oDate == null) {
            return 0;
        }
        long intervalMilli = oDate.getTime() - fDate.getTime();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            intervalMilli = sdf.parse(sdf.format(oDate)).getTime() - sdf.parse(sdf.format(fDate)).getTime();
        } catch (Exception e) {
        }
        return (int) (intervalMilli / 86400000);
    }

    public Bundle getDataFromRouteResult(int turnType, int nRemainDist, String nextRoad, int nDist, int nTime) {
        try {
            this.mNextGuideInfoBundle.putInt("updatetype", 1);
            int resId = BNavR.gTurnIconID[1];
            if (turnType < BNavR.gTurnIconID.length - 1) {
                resId = BNavR.gTurnIconID[turnType];
            }
            this.mNextGuideInfoBundle.putInt("resid", resId);
            if (turnType < RouteGuideParams.gTurnIconName.length) {
                this.mNextGuideInfoBundle.putString("icon_name", RouteGuideParams.gTurnIconName[turnType]);
            }
            this.mNextGuideInfoBundle.putInt(SimpleGuideInfo.RemainDist, nRemainDist);
            if (nextRoad == null) {
                this.mNextGuideInfoBundle.putString("road_name", "");
            } else {
                this.mNextGuideInfoBundle.putString("road_name", nextRoad);
            }
            updateTotalRemainDistAndTime(nDist, nTime);
            sSimpleGuideBundle.putAll(this.mTotalInfoBundle);
            sSimpleGuideBundle.putAll(this.mNextGuideInfoBundle);
        } catch (Exception e) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "getDataFromRouteResult err:" + e.getMessage());
        }
        return sSimpleGuideBundle;
    }

    public Bundle updateNextGuideInfo(int turnType, int nRemainDist, String nextRoad) {
        try {
            this.mNextGuideInfoBundle.putInt("updatetype", 1);
            int resId = BNavR.gTurnIconID[1];
            if (turnType < BNavR.gTurnIconID.length - 1) {
                resId = BNavR.gTurnIconID[turnType];
            }
            this.mNextGuideInfoBundle.putInt("resid", resId);
            if (turnType < RouteGuideParams.gTurnIconName.length) {
                this.mNextGuideInfoBundle.putString("icon_name", RouteGuideParams.gTurnIconName[turnType]);
            }
            this.mNextGuideInfoBundle.putInt(SimpleGuideInfo.RemainDist, nRemainDist);
            if (nextRoad == null) {
                this.mNextGuideInfoBundle.putString("road_name", "");
            } else {
                this.mNextGuideInfoBundle.putString("road_name", nextRoad);
            }
            sSimpleGuideBundle.putAll(this.mNextGuideInfoBundle);
        } catch (Exception e) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "updateNextGuiInfoOnly err:" + e.getMessage());
        }
        return this.mNextGuideInfoBundle;
    }

    private void viaPointProcess(String iconName) {
        this.mLastIconName = this.mCurIconName;
        this.mCurIconName = iconName;
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "mLastIconName = " + this.mLastIconName + ", mCurIconName = " + this.mCurIconName);
    }

    public String getFormatAfterMeters(int nextRemainDist) {
        StringUtils.formatDistance(nextRemainDist, UnitLangEnum.ZH, new StringBuffer());
        return JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_sg_after_meters, new Object[]{distance});
    }

    public String getFormatGoNextRoad(String nextRoad) {
        return JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_sg_go_nextroad, new Object[]{nextRoad});
    }

    public String getFormatNextRoadInfo(int nextRemainDist, String nextRoad) {
        StringUtils.formatDistance(nextRemainDist, UnitLangEnum.ZH, new StringBuffer());
        return JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_sg_nextroadinfo, new Object[]{distance, nextRoad});
    }

    public String getDistStart(String str) {
        if (str != null) {
            if (str.endsWith("米")) {
                return str.substring(0, str.length() - 1);
            }
            if (str.endsWith("公里")) {
                return str.substring(0, str.length() - 2);
            }
        }
        return null;
    }

    public String getDistEnd(String str) {
        if (str != null) {
            if (str.endsWith("米")) {
                return "米";
            }
            if (str.endsWith("公里")) {
                return "公里";
            }
        }
        return null;
    }

    public void updateCurRoadName(String curRoadName) {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "engine updateRoadName --> " + curRoadName);
        this.mCurRoadName = curRoadName;
    }

    public String getCurRoadName() {
        if (this.mCurRoadName == null || this.mCurRoadName.length() == 0) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_sg_cur_road_word);
        }
        return this.mCurRoadName;
    }

    public int getTotalRemainDist() {
        try {
            if (this.mTotalInfoBundle != null && this.mTotalInfoBundle.containsKey(SimpleGuideInfo.TotalDist)) {
                return this.mTotalInfoBundle.getInt(SimpleGuideInfo.TotalDist);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public String getNextGuidanceChineseWord() {
        StringBuffer sb = new StringBuffer();
        if (this.mNextGuideInfoBundle != null) {
            sb = new StringBuffer();
            int remainDist = this.mNextGuideInfoBundle.getInt(SimpleGuideInfo.RemainDist, 0);
            if (remainDist >= 0) {
                sb.append(StringUtils.formatDistanceToChineseString(remainDist));
            }
            String nextRoad = this.mNextGuideInfoBundle.getString("road_name");
            if (nextRoad != null) {
                sb.append("后进入");
                sb.append(nextRoad);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return "没有下一路口数据";
    }

    public boolean isShowFollowInfo() {
        boolean z = true;
        if (this.mNextGuideInfoBundle == null || !this.mNextGuideInfoBundle.containsKey(SimpleGuideInfo.RemainDist) || this.mNextTurnKind <= 0 || this.mNextTurnKind >= RouteGuideParams.gTurnTypeDescForFollowInfo.length) {
            return false;
        }
        int remainDist = this.mNextGuideInfoBundle.getInt(SimpleGuideInfo.RemainDist);
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "isShowFollowInfo() remainDist=" + remainDist + ", mIsHighwayExCur2NextGP=" + this.mIsHighwayExCur2NextGP + ", mDistCur2NextGP=" + this.mDistCur2NextGP);
        if (remainDist > 2000) {
            return false;
        }
        if (this.mIsHighwayExCur2NextGP) {
            if (this.mDistCur2NextGP < 0 || this.mDistCur2NextGP > 200) {
                z = false;
            }
            return z;
        }
        if (this.mDistCur2NextGP < 0 || this.mDistCur2NextGP > 100) {
            z = false;
        }
        return z;
    }

    public String getFollowInfo() {
        if (this.mNextTurnKind <= 0 || this.mNextTurnKind >= RouteGuideParams.gTurnTypeDescForFollowInfo.length) {
            return "";
        }
        return "随后" + RouteGuideParams.gTurnTypeDescForFollowInfo[this.mNextTurnKind];
    }

    public int getFollowIcon() {
        if (this.mNextTurnKind <= 0 || this.mNextTurnKind >= BNavR.gTurnIconID.length) {
            return -1;
        }
        return BNavR.gTurnIconID[this.mNextTurnKind];
    }

    public void setIsYawing(boolean yawing) {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "setIsYawing :" + yawing);
        this.mIsYawing = yawing;
    }

    public boolean isYawing() {
        return this.mIsYawing;
    }

    public void reset() {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "reset");
        this.mIsStraight = false;
        this.mIsYawing = false;
        this.mTTSText = null;
        this.mIsGPSFixed = false;
        this.mSatelliteNum = 0;
        this.mIsGarlogoFree = false;
        this.mLastIconName = "";
        this.mCurIconName = "";
        mIsOfflineToOnline = false;
        mIsRPPrefer = false;
        mIsUgcOfficialEvent = false;
        mIsSatellite = false;
        this.mNextTurnKind = 0;
        this.mDistCur2NextGP = 1000;
        this.mIsHighwayExCur2NextGP = false;
        mIsSafetyShareGuideShow = false;
        this.isFirstDataOk = false;
        this.isCalcRouteFail = false;
        this.mTotalRemainDistS = "";
        this.mTotalRemainTime = "";
        this.mCompletePercentage = 0.0d;
        if (sSimpleGuideBundle != null) {
            sSimpleGuideBundle.clear();
        }
        if (this.mNextGuideInfoBundle != null) {
            this.mNextGuideInfoBundle.clear();
        }
        if (this.mTotalInfoBundle != null) {
            this.mTotalInfoBundle.clear();
        }
        mCalcRouteType = 0;
    }

    public void setFirstRGInfo(Bundle bundle) {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "setFirstRGInfo=" + bundle.toString());
        this.mFirstGuideMatchMode = 0;
        int totalTime = bundle.getInt(SimpleGuideInfo.TotalTime, 0);
        int totalDist = bundle.getInt(SimpleGuideInfo.TotalDist, 0);
        int remainDist = bundle.getInt(SimpleGuideInfo.RemainDist, 0);
        int resId = bundle.getInt("resid", 0);
        String nextRoad = bundle.getString("road_name");
        this.mFirstGuideMatchMode = bundle.getInt("resid", 0);
        if ((resId > 0 && totalTime > 0) || isFirstGuideFuzzy()) {
            getDataFromRouteResult(resId, remainDist, nextRoad, totalDist, totalTime);
            this.isFirstDataOk = true;
        }
    }

    private void calculateCompletePercentage(int remainDist) {
        int planedDist = BNNaviResultModel.getInstance().getEstimatedRemainDist();
        if (planedDist == 0) {
            this.mCompletePercentage = 0.0d;
        } else {
            this.mCompletePercentage = ((double) (planedDist - remainDist)) / ((double) planedDist);
        }
    }
}
