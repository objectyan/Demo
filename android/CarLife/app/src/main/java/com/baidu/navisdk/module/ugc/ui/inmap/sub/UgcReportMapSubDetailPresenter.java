package com.baidu.navisdk.module.ugc.ui.inmap.sub;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.ui.SubContentContract;
import com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailContract.View;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import java.io.IOException;
import java.text.NumberFormat;
import org.json.JSONArray;
import org.json.JSONObject;

public class UgcReportMapSubDetailPresenter extends Presenter {
    private static final int BNUGCUploadTypeDanger = 7;
    private static final int BNUGCUploadTypeElectronicEye = 6;
    private static final int BNUGCUploadTypeJam = 0;
    private static final int BNUGCUploadTypePoliceman = 8;
    private static final int BNUGCUploadTypeRoadAdd = 3;
    private static final int BNUGCUploadTypeRoadClosure = 4;
    private static final int BNUGCUploadTypeRoadConstruction = 2;
    private static final int BNUGCUploadTypeTrafficAccident = 1;
    private static final int BNUGCUploadTypeTrafficRegulations = 5;
    public static final int TYPE_GO_BACK = 2;
    public static final int TYPE_SET_HEIGHT = 1;
    private boolean hasInformComHeight = false;
    private boolean hasOnResume = false;
    private UgcImageLoaderUtils imageLoaderUtils;
    private Context mContext;
    private View mRootView;
    private UgcLayout mUgcLayout;
    private UgcSubDetailCallback mUgcReportCallback;
    private long st;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailPresenter$1 */
    class C42091 implements UgcHttpsResultCallBack {
        C42091() {
        }

        public void onUgcInfoReportUpLoadSuccess(JSONObject data) {
            String mRetTips = null;
            if (data != null) {
                try {
                    mRetTips = data.getString("tips");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(mRetTips)) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
            } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), mRetTips);
            }
            UgcReportMapSubDetailPresenter.this.callbackMapInfo(UgcReportMapSubDetailPresenter.this.infoPackage, data);
            try {
                if (UgcReportMapSubDetailPresenter.this.infoPackage.voicePath != null) {
                    FileUtils.del(UgcReportMapSubDetailPresenter.this.infoPackage.voicePath);
                }
                if (UgcReportMapSubDetailPresenter.this.infoPackage.photoPicPath != null) {
                    FileUtils.del(UgcReportMapSubDetailPresenter.this.infoPackage.photoPicPath);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public void onUgcInfoReportUpLoadFail(String reson) {
            if (reson != null) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), reson);
            } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail));
            }
            try {
                if (UgcReportMapSubDetailPresenter.this.infoPackage.voicePath != null) {
                    FileUtils.del(UgcReportMapSubDetailPresenter.this.infoPackage.voicePath);
                }
                if (UgcReportMapSubDetailPresenter.this.infoPackage.photoPicPath != null) {
                    FileUtils.del(UgcReportMapSubDetailPresenter.this.infoPackage.photoPicPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public interface UgcSubDetailCallback {
        void commonCallback(int i, Object obj, Object obj2);

        void gotoSubView();

        void maxMapLevel();

        void onBackBtnPress();

        void onUpLoadCompleted(JSONObject jSONObject);
    }

    public void onAddrInfoUpdate(String addr, String addrDesc) {
        if (TextUtils.isEmpty(addr)) {
            addr = TrackDataShop.SPECIAL_ADDR_IN_TRACK;
        }
        if (this.mRootView != null && this.mRootView.isSelectPointViewShowing()) {
            this.mRootView.showAddrInfoUpdate(addr, addrDesc);
        }
    }

    public UgcReportMapSubDetailPresenter(Context mContext, SubContentContract.View mRootView, UgcLayout mUgcLayout, UgcSubDetailCallback mUgcReportCallback) {
        super(mContext, mRootView, mUgcLayout);
        this.mRootView = (View) mRootView;
        this.mContext = mContext;
        this.mUgcReportCallback = mUgcReportCallback;
        this.imageLoaderUtils = new UgcImageLoaderUtils();
        this.mUgcLayout = mUgcLayout;
        mRootView.setPresenter(this);
        this.st = System.currentTimeMillis();
        if (this.infoPackage != null) {
            this.infoPackage.parentType = mUgcLayout.getSubType();
        }
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2, "1", null, null);
    }

    public void start() {
        super.start();
        if (this.mRootView != null) {
            this.mRootView.initPresenterView();
        }
        if (this.infoPackage != null) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_4, "1", this.infoPackage.parentType + "", null);
        }
    }

    public void ugcUpLoad() {
        if (this.infoPackage != null) {
            if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
            } else if (this.infoPackage.parentType == 6 && this.infoPackage.detailType == -1) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "信息不完整，请勾选事件详情");
            } else {
                if (TextUtils.isEmpty(this.infoPackage.userPoint)) {
                    this.infoPackage.userPoint = getCurrentLocationPoint();
                    if (TextUtils.isEmpty(this.infoPackage.userPoint)) {
                        this.infoPackage.userPoint = this.infoPackage.point;
                    }
                }
                new UgcHttpsUtils().addMapInfoTopackage(this.infoPackage);
                this.infoPackage.showLog("map_upload1");
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_1, "1", this.infoPackage.parentType + "", null);
                new UgcHttps().ugcReportInfoUpLoad(this.infoPackage, new C42091());
                finish();
            }
        }
    }

    public boolean onBackPress() {
        if ((this.infoPackage != null && (this.infoPackage.parentType == 6 || this.infoPackage.parentType == 7)) || !this.mRootView.isSelectPointViewShowing()) {
            return false;
        }
        showOriginPage();
        return true;
    }

    public void gotoSelectorPointPage() {
    }

    public void onDestroy() {
    }

    public void finish() {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.onBackBtnPress();
        }
    }

    public void goback() {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.commonCallback(2, null, null);
        }
    }

    public void getRubPointAdsorbInfo(double ptX, double ptY, UgcHttpsResultCallBack mcallback) {
        new UgcHttps().getRubPointAdsorbInfo(null, getFormatDouble(Double.valueOf(ptX)) + "," + getFormatDouble(Double.valueOf(ptY)), mcallback, 0);
    }

    private String getFormatDouble(Double d) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return nf.format(d);
    }

    private void callbackMapInfo(UgcReportInfoUploadPackage infoPackage, JSONObject data) {
        if (data != null) {
            try {
                Long uniqueId = Long.valueOf(data.getLong(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID));
                String mRetTips = data.getString("tips");
                int luid = (int) (uniqueId.longValue() & -1);
                int huid = (int) ((uniqueId.longValue() >>> 32) & -1);
                JSONObject retJsonObject = new JSONObject();
                JSONObject subJsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                String curPoint = infoPackage.point;
                if (curPoint == null) {
                    curPoint = infoPackage.userPoint;
                }
                if (curPoint != null) {
                    int i = 0;
                    int pty = 0;
                    int i2 = curPoint.indexOf(",");
                    if (i2 > 0 && i2 < curPoint.length() - 1) {
                        String xStr = curPoint.substring(0, i2);
                        try {
                            i = (int) Double.parseDouble(xStr);
                            pty = (int) Double.parseDouble(curPoint.substring(i2 + 1, curPoint.length()));
                        } catch (Exception e) {
                        }
                        subJsonObject.put(MapObjKey.OBJ_SL_PTX, i);
                        subJsonObject.put(MapObjKey.OBJ_SL_PTY, pty);
                        subJsonObject.put("st", this.st / 1000);
                        subJsonObject.put("et", (this.st / 1000) + 180);
                        subJsonObject.put("huid", huid);
                        subJsonObject.put("luid", luid);
                        subJsonObject.put("type", convertNaviTypeToUploadType(infoPackage.parentType));
                        array.put(subJsonObject);
                        retJsonObject.put("content", array);
                        if (mRetTips == null || mRetTips.trim().equals("")) {
                            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
                        } else {
                            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), mRetTips);
                        }
                        LogUtil.m15791e("callbackMapInfo:", retJsonObject.toString());
                        if (this.mUgcReportCallback != null) {
                            this.mUgcReportCallback.onUpLoadCompleted(retJsonObject);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private int convertNaviTypeToUploadType(int type) {
        switch (type) {
            case 1:
                return 3;
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 0;
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                return 4;
            case 9:
                return 8;
            case 10:
                return 7;
            default:
                return 0;
        }
    }

    public void onConfirm(int cityId, String cityName, Double x, Double y, String address) {
        if (this.infoPackage != null) {
            this.infoPackage.point = x + "," + y;
            this.infoPackage.name = address;
            this.infoPackage.cityId = cityId;
            this.infoPackage.cityName = cityName;
        }
        if (this.mRootView != null) {
            this.mRootView.showAddrInfoUpdate(address, null);
            showOriginPage();
        }
    }

    private void showOriginPage() {
        if (this.mRootView != null) {
            this.mRootView.showOriginPage();
        }
    }

    public void hasShowOriginPage() {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.gotoSubView();
        }
    }

    public void onPinUp(boolean isPinUp) {
        showSelectorPointStatus();
    }

    public void showSelectorPointStatus() {
        if (this.mRootView != null && !this.mRootView.isSelectPointViewShowing()) {
            this.mRootView.showSelectorPointStatus();
        }
    }

    public void hasShowSelectorPointStatus() {
        if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.maxMapLevel();
        }
    }

    public void informRubPointAdsorb(String point, final String address) {
        new UgcHttps().getRubPointAdsorbInfo(null, point, new UgcHttpsResultCallBack() {
            public void onUgcInfoReportUpLoadFail(String reson) {
                UgcReportMapSubDetailPresenter.this.mRootView.showAddrInfoUpdate(address, null);
            }

            public void onUgcInfoReportUpLoadSuccess(JSONObject data) {
                try {
                    String newPoint = data.getString("new_point");
                    String address = data.getString(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS);
                    String linkid = data.getString(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_LINKID);
                    UgcReportMapSubDetailPresenter.this.infoPackage.point = newPoint;
                    UgcReportMapSubDetailPresenter.this.infoPackage.linkid = linkid;
                    UgcReportMapSubDetailPresenter.this.mRootView.showAddrInfoUpdate(address, null);
                } catch (Exception e) {
                }
            }
        }, 0);
    }

    public void setLinkid(String linkid) {
        this.infoPackage.linkid = linkid;
    }

    public void onResume() {
        if (!this.hasOnResume) {
            this.hasOnResume = true;
        }
    }

    public void informComHeight() {
        if (!this.hasInformComHeight) {
            if (!(this.mRootView == null || this.mRootView.getMapComPanelContainer() == null)) {
                int height = this.mRootView.getMapComPanelContainer().getHeight();
                if (height != 0) {
                    if (this.mUgcReportCallback != null) {
                        this.mUgcReportCallback.commonCallback(1, Integer.valueOf(height), null);
                    }
                    this.hasInformComHeight = true;
                }
            }
            if (this.infoPackage == null) {
                return;
            }
            if (this.infoPackage.parentType == 6 || this.infoPackage.parentType == 7) {
                showSelectorPointStatus();
            }
        }
    }

    public boolean isRoadBuild() {
        if (this.infoPackage == null) {
            return false;
        }
        if (this.infoPackage.parentType == 6 || this.infoPackage.parentType == 7) {
            return true;
        }
        return false;
    }

    private String getCurrentLocationPoint() {
        LocData curLoaction = BNLocationManagerProxy.getInstance().getCurLocation();
        String retStr = "";
        if (curLoaction == null) {
            return retStr;
        }
        GeoPoint mGeoPoint = curLoaction.toGeoPoint();
        Bundle mBundle = CoordinateTransformUtil.LL2MC(curLoaction.longitude, curLoaction.latitude);
        if (mBundle != null) {
            return mBundle.getInt("MCx") + "," + mBundle.getInt("MCy");
        }
        return retStr;
    }
}
