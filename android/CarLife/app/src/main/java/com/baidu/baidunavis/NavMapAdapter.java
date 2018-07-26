package com.baidu.baidunavis;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.baidu.baidumaps.base.localmap.C0692f;
import com.baidu.baidunavis.control.MapSearchAPIWrapper;
import com.baidu.baidunavis.control.NavCommonFuncController;
import com.baidu.baidunavis.control.NavInitController;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.logic.C1765g;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.mapframework.common.util.FileUtils;
import com.baidu.mapframework.common.util.StorageInformation;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.mapframework.widget.MProgressDialog;
import com.baidu.mapframework.widget.MToast;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.track.util.TrackInsertDataBackground;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.download.BNDownloadUIManager;
import com.baidu.navisdk.ui.download.BNDownloadUIManager.OnNewVersionListener;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.p132b.C2905c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NavMapAdapter {
    public static final int CAR_NAVI_PERMISSIONS = 8;
    public static final String ENERGY_REQUESTID_BUNDLE_KEY = "energy_requestid_bundle_key";
    public static final int MCarRoute = 18;
    public static final String NAVI_ENERGY_PROMOTE_EVENT = "NaviEnergyOperation";
    public static final String TAG = NavMapAdapter.class.getSimpleName();
    public static final String WEBSHELL_FLAG_KEY = "webshell_flag_key";
    public static final String WEBVIEW_URL_KEY = "webview_url";
    private static NavMapAdapter me;
    public static int nPageTime = 0;
    public static boolean sMonkey = false;
    public static final boolean sPageJumpEnable = false;
    public static boolean showBottomBarSwitch = false;
    private String[] mBNMapTasks = new String[0];
    private int mMapPushState;
    private ArrayList<PageUnit> mPageUnits = null;
    private int nPageindex = 0;

    /* renamed from: com.baidu.baidunavis.NavMapAdapter$1 */
    class C07481 implements OnNewVersionListener {
        C07481() {
        }

        public void onNewVersion(int[] provinceIds) {
            LogUtil.m3004e("BNDownload", "checkNewVer: onNewVersion");
        }
    }

    /* renamed from: com.baidu.baidunavis.NavMapAdapter$7 */
    class C07547 implements Runnable {
        C07547() {
        }

        public void run() {
            C1307e.m4686a().mo1468c();
        }
    }

    class PageUnit {
        public String name;
        public int time;

        PageUnit() {
        }

        public String toString() {
            return " PageName:" + this.name + ",time:" + this.time;
        }
    }

    public static NavMapAdapter getInstance() {
        if (me == null) {
            me = new NavMapAdapter();
        }
        return me;
    }

    public Bundle getCurLocation() {
        Bundle b = new Bundle();
        LocData locData = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09);
        b.putInt("x", (int) locData.longitude);
        b.putInt("y", (int) locData.latitude);
        return b;
    }

    public boolean isGPSLocationValid() {
        LocData locData = LocationManager.getInstance().getCurLocation(null);
        return locData != null && locData.type == 61;
    }

    public boolean isLightNaviLocationValid() {
        LocData locData = LocationManager.getInstance().getCurLocation(null);
        return locData != null && locData.type == 61 && locData.type == 161;
    }

    public boolean isGpsEnabled() {
        boolean enable = false;
        Context ctx = NavCommonFuncModel.getInstance().getContext();
        if (ctx != null) {
            android.location.LocationManager lm = (android.location.LocationManager) ctx.getSystemService("location");
            if (lm != null) {
                try {
                    enable = lm.isProviderEnabled("gps");
                } catch (Exception e) {
                }
            }
        }
        return enable;
    }

    public RouteNode getRouteNode(NavGeoPoint point, String name, String uid) {
        RouteNode node = new RouteNode();
        node.mGeoPoint = point;
        node.mName = name;
        node.mUID = uid;
        return node;
    }

    public NavGeoPoint getGeoPoint(Point pt, boolean bMyPt) {
        int xMC;
        int yMC;
        NavGeoPoint startGeoPoint = new NavGeoPoint();
        if (bMyPt) {
            LocData locData = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09);
            xMC = (int) locData.longitude;
            yMC = (int) locData.latitude;
        } else {
            xMC = pt.getIntX();
            yMC = pt.getIntY();
        }
        Bundle b = MC2LLE6(xMC, yMC);
        if (b != null) {
            startGeoPoint.setLongitudeE6(b.getInt("LLx"));
            startGeoPoint.setLatitudeE6(b.getInt("LLy"));
        }
        return startGeoPoint;
    }

    public static Bundle MC2LL(int mcX, int mcY) {
        Bundle bd;
        try {
            Point gcjLL = CoordinateUtil.bd09mcTogcj02ll((double) mcX, (double) mcY);
            if (gcjLL != null) {
                bd = new Bundle();
                bd.putDouble("LLx", gcjLL.getDoubleX());
                bd.putDouble("LLy", gcjLL.getDoubleY());
                return bd;
            }
        } catch (Throwable th) {
        }
        bd = new Bundle();
        bd.putDouble("LLx", 0.0d);
        bd.putDouble("LLy", 0.0d);
        return bd;
    }

    public static Bundle MC2LLE6(int MCx, int MCy) {
        Bundle bundle = MC2LL(MCx, MCy);
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putInt("LLx", 0);
            bundle.putInt("LLy", 0);
            return bundle;
        }
        int latE6 = (int) (bundle.getDouble("LLy") * 100000.0d);
        bundle.putInt("LLx", (int) (bundle.getDouble("LLx") * 100000.0d));
        bundle.putInt("LLy", latE6);
        return bundle;
    }

    public NavGeoPoint getNavGeoPoint(Point pt) {
        NavGeoPoint endGeoPoint = new NavGeoPoint();
        Bundle b = MC2LLE6(pt.getIntX(), pt.getIntY());
        endGeoPoint.setLongitudeE6(b.getInt("LLx"));
        endGeoPoint.setLatitudeE6(b.getInt("LLy"));
        return endGeoPoint;
    }

    public boolean getBaiduMapTraffic() {
        return MapViewConfig.getInstance().isTraffic();
    }

    public void setBaiduMapTraffic(boolean enable) {
        MapViewInterface mapViewInterface = MapViewFactory.getInstance().getMapView();
        if (mapViewInterface != null) {
            mapViewInterface.setTraffic(enable);
            MapViewConfig.getInstance().setTraffic(enable);
        }
    }

    public void restoreMapData() {
        LogUtil.m3004e("navSDK", "restoreMapData->autoJumpPage");
    }

    public static void importSettingToNaviSDK(Context context) {
        NavCommonFuncController.importSettingToNaviSDK(context);
    }

    public static void resetNavConfig(Context context) {
    }

    public boolean ReleaseSharedMapData() {
        return NavMapManager.getInstance().releaseSharedMapData();
    }

    public boolean updateShareMapData() {
        return NavMapManager.getInstance().updateShareMapData();
    }

    public void importMap() {
        C0692f.m2894a().m2948n();
    }

    public void checkNewVerData(Activity activity) {
        BNOfflineDataManager.getInstance();
        BNDownloadUIManager.checkNewVersion(activity, false, new C07481());
    }

    public void initNaviEngine(Activity activity, final Handler handler) {
        if (!BaiduNaviManager.sIsBaseEngineInitial && activity != null) {
            NavInitController.getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                public void engineInitSuccess() {
                    if (handler != null) {
                        Message msg = new Message();
                        msg.what = 1301;
                        msg.arg1 = 0;
                        handler.sendMessage(msg);
                    }
                }

                public void engineInitStart() {
                }

                public void engineInitFail() {
                    BaiduNaviManager.sIsEngineInitialFailed = false;
                    if (handler != null) {
                        Message msg = new Message();
                        msg.what = 1301;
                        msg.arg1 = -1;
                        handler.sendMessage(msg);
                    }
                }
            });
        }
    }

    public static void destroy() {
        NavInitController.destroy();
    }

    public void autoJumpPage() {
        LogUtil.m3004e("navSDK", "autoJumpPage");
        if (this.mPageUnits == null) {
            this.mPageUnits = readPageUnit();
        }
        Activity activity = NavCommonFuncModel.getInstance().getActivity();
        if (this.nPageindex >= 0 && this.nPageindex < this.mPageUnits.size()) {
            PageUnit pageUnit = (PageUnit) this.mPageUnits.get(this.nPageindex);
            if ("BNRouteGuideFragment".equals(pageUnit.name)) {
                LogUtil.m3004e("navSDK", "JumpPage BNRouteGuideFragment");
                nPageTime = pageUnit.time;
                BaiduNaviManager.getInstance().launchNavigator(activity, new NavGeoPoint(11394118, 2254282), RoutePlanParams.MY_LOCATION, new NavGeoPoint(11396185, 2256679), "地图上的点", 1, true, 2);
            } else if ("BNCruiserFragment".equals(pageUnit.name)) {
                LogUtil.m3004e("navSDK", "JumpPage BNCruiserFragment");
                BaiduNaviManager.getInstance().launchCruiser(activity, Boolean.valueOf(true));
            }
            this.nPageindex++;
        }
    }

    private ArrayList<PageUnit> readPageUnit() {
        ArrayList<PageUnit> pageList = new ArrayList();
        String path = StorageSettings.getInstance().getCurrentStorage().getRootPath() + "/BaiduNavi/track";
        String filename = "PageJump.xml";
        LogUtil.m3004e("navSDK", "path=" + path + ",filename=" + filename);
        File inFile = new File(path, filename);
        try {
            inFile.createNewFile();
        } catch (IOException e) {
            LogUtil.m3004e("navSDK", e.getMessage());
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        if (dbf != null) {
            try {
                db = dbf.newDocumentBuilder();
            } catch (ParserConfigurationException pce) {
                LogUtil.m3004e("navSDK", pce.getMessage());
            }
        }
        Document doc = null;
        if (db != null) {
            try {
                doc = db.parse(inFile);
            } catch (SAXException e2) {
                LogUtil.m3004e("navSDK", e2.getMessage());
            } catch (DOMException dom) {
                LogUtil.m3004e("navSDK", dom.getMessage());
            } catch (IOException ioe) {
                LogUtil.m3004e("navSDK", ioe.getMessage());
            }
        }
        Element root = null;
        if (doc != null) {
            root = doc.getDocumentElement();
        }
        NodeList pageUnits = null;
        if (root != null) {
            pageUnits = root.getElementsByTagName("page");
        }
        int i = 0;
        while (pageUnits != null && i < pageUnits.getLength()) {
            Element pageElement = (Element) pageUnits.item(i);
            PageUnit pageUnit = new PageUnit();
            try {
                pageUnit.name = pageElement.getAttribute("name");
                pageUnit.time = Integer.parseInt(pageElement.getAttribute(BaiduNaviParams.KEY_TIME));
            } catch (Exception ex) {
                LogUtil.m3004e("navSDK", ex.getMessage());
            }
            pageList.add(pageUnit);
            LogUtil.m3004e("navSDK", pageUnit.toString());
            i++;
        }
        return pageList;
    }

    public String getMengMengDaTTSPath() {
        return null;
    }

    public void onForeground() {
        if (BaiduNaviManager.isNaviSoLoadSuccess() && BaiduNaviManager.sIsBaseEngineInitialized) {
            NavCommonFuncController.getInstance().onForeground();
        }
    }

    public void onBackground() {
        if (BaiduNaviManager.sIsBaseEngineInitialized) {
            NavCommonFuncController.getInstance().onBackground();
        }
    }

    public NavCarInfo getCarInfoFromMap() {
        String localCarPANumber = BNSettingManager.getPlateFromLocal(getContext());
        if (localCarPANumber == null || localCarPANumber.length() <= 0) {
            return null;
        }
        return new NavCarInfo(localCarPANumber);
    }

    public void purgeMapDataForNavi(final Activity activity) {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
            protected String execute() {
                BNDownloadUIManager.pauseAllDownload();
                C0692f.m2894a().m2936e(0);
                activity.getWindow().clearFlags(128);
                return null;
            }
        }, new BNWorkerConfig(100, 0));
        NavCommonFuncModel.getInstance().mMapBrightState = GlobalConfig.getInstance().isAllBright();
        GlobalConfig.getInstance().setAllBright(Boolean.valueOf(false));
    }

    public int getCurrentLocalCityId() {
        return GeoLocateModel.getInstance().getCurrentDistrict().mCityId;
    }

    public void removeRequestByType(int type) {
    }

    public String getBduss() {
        return NaviAccountUtils.getInstance().syncGetBduss();
    }

    public int getIconId() {
        return C0965R.drawable.ic_launcher;
    }

    public String getUid() {
        return NaviAccountUtils.getInstance().getUid() != null ? NaviAccountUtils.getInstance().getUid() : "";
    }

    public boolean isLogin() {
        return NaviAccountUtils.getInstance().isLogin();
    }

    public int getRoamCityId() {
        return getCurrentLocalCityId();
    }

    public boolean hasCurMapLocationCityOfflineData() {
        if (!LocationManager.getInstance().isLocationValid() || !BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            return false;
        }
        LocData mapLocData = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09LL);
        com.baidu.navisdk.model.datastruct.LocData locData = new com.baidu.navisdk.model.datastruct.LocData();
        locData.accuracy = mapLocData.accuracy;
        locData.direction = mapLocData.direction;
        locData.satellitesNum = mapLocData.satellitesNum;
        locData.speed = mapLocData.speed;
        locData.type = mapLocData.type;
        locData.longitude = mapLocData.longitude;
        locData.latitude = mapLocData.latitude;
        if (locData.longitude == -1.0d && locData.latitude == -1.0d) {
            return false;
        }
        GeoPoint geoPoint = new GeoPoint();
        if (locData != null) {
            geoPoint.setLatitudeE6((int) (locData.latitude * 100000.0d));
            geoPoint.setLongitudeE6((int) (locData.longitude * 100000.0d));
        }
        DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(geoPoint, 0);
        while (districtInfo != null && districtInfo.mType > 2) {
            districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
        }
        if (districtInfo != null) {
            return BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId);
        }
        return false;
    }

    public boolean isExternalStorageEnabled() {
        return StorageSettings.getInstance().isExternalStorageEnabled();
    }

    public String getDataFolderName() {
        return "BaiduCarlife";
    }

    public String getDataPath() {
        return StorageSettings.getInstance().getCurrentStorage().getDataPath();
    }

    public void gotoNavi(Point startPoint, String startName, Point endPoint, String endName, String endUid, String endCityId, int entry) {
    }

    public int getmCarFocus() {
        return 0;
    }

    public String getCarRoutePlanMrsl() {
        return "";
    }

    public StorageSettings getStorageSettingsInstance() {
        return StorageSettings.getInstance();
    }

    public StorageInformation getCurrentStorage() {
        return StorageSettings.getInstance().getCurrentStorage();
    }

    public boolean setUgcInfo(String info) {
        return LocationManager.getInstance().setUgcInfo(info);
    }

    public void addLocationChangeLister(LocationChangeListener listener) {
        LocationManager.getInstance().addLocationChangeLister(listener);
    }

    public void removeLocationChangeLister(LocationChangeListener listener) {
        LocationManager.getInstance().removeLocationChangeLister(listener);
    }

    public void exceptionLog(Throwable throwable) {
    }

    public void navigateTo(Context ctx, String pageClsName, Bundle pageArgs) {
    }

    public void navigateTo(Context ctx, String pageClsName) {
    }

    public Activity getContainerActivity() {
        return BaseFragment.getNaviActivity();
    }

    public int getResultKeyMCarRoute() {
        return 18;
    }

    public void showMToast(Context context, String message) {
        MToast.show(context, message);
    }

    public void showMToast(Context context, int resId) {
        MToast.show(context, resId);
    }

    public void showMProgressDialog(FragmentActivity fragActivity, String title, String message) {
        final FragmentActivity fragmentActivity = fragActivity;
        final String str = title;
        final String str2 = message;
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("showMProgressDialog", null) {
            protected String execute() {
                MProgressDialog.show(fragmentActivity, str, str2);
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    public void showMProgressDialog(FragmentActivity fragActivity, String title, String message, OnCancelListener cancelListener) {
        final FragmentActivity fragmentActivity = fragActivity;
        final String str = title;
        final String str2 = message;
        final OnCancelListener onCancelListener = cancelListener;
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("showMProgressDialog", null) {
            protected String execute() {
                MProgressDialog.show(fragmentActivity, str, str2, onCancelListener);
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    public void dismissMProgressDialog() {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("dismissMProgressDialog", null) {
            protected String execute() {
                MProgressDialog.dismiss();
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    public Context getContext() {
        return BaseFragment.getNaviActivity();
    }

    public String getNavEnergyPromoteEvent() {
        return NAVI_ENERGY_PROMOTE_EVENT;
    }

    public boolean isCloudSwitchOn(String key) {
        return false;
    }

    public String getEnerGyRequestIDBundleKey() {
        return ENERGY_REQUESTID_BUNDLE_KEY;
    }

    public boolean addLog(String strAction) {
        return true;
    }

    public Application getBaiduMapApplicationInstance() {
        return BaiduNaviApplication.getInstance();
    }

    public SharedPreferences getBaiduMapApplicationSp(String name, int mode) {
        return BaiduNaviApplication.getInstance().getSharedPreferences(name, mode);
    }

    public void close(Closeable c) {
        FileUtils.close(c);
    }

    public boolean isNaviInjectSuccess() {
        return true;
    }

    public String getMapFramePageClassName() {
        return "MapFramePage.class";
    }

    public String getWebViewURLKey() {
        return WEBVIEW_URL_KEY;
    }

    public String getWebShellFlagKey() {
        return WEBSHELL_FLAG_KEY;
    }

    public void sendLightNavShortCut(Context context, String title, String vechile, String type, Bundle extBundle) {
    }

    public int getCarNaviPermissions() {
        return 8;
    }

    public int mapLightSearch(String naviSearchUrl, MsgHandler handler, int msgType, MapSearchAPIWrapper mapSearchAPIWrapper, long timeout) {
        NavLogUtils.m3003e(TAG, "mapLightSearch() url=" + naviSearchUrl);
        return 1;
    }

    public void cancleRequest(MapSearchAPIWrapper mapSearchAPIWrapper, int requestId) {
    }

    public void shareSafety(String linkUrl, String imgUrl, String title, String desc, boolean ori) {
    }

    public void startLogin(Fragment fragment, boolean jumpToBusinessPage, int requestCode) {
    }

    public void createCarNaviData() {
        TrackInsertDataBackground.createCarNaviData();
    }

    public void initNavGuideListener() {
    }

    public void exitCarNav(boolean isStoppedByWatch) {
    }

    public Context getJNIInitializerContext() {
        return C2907c.m10977f();
    }

    public boolean isGooglePlayChannel() {
        if (C1253f.jc.equals(C1253f.jt)) {
            return true;
        }
        return false;
    }

    public boolean getDebugConfigUserTest() {
        return false;
    }

    public boolean addPerformLog(int type, int level, String strAction, String actionParam) {
        return C2905c.m10957a().m10960a(type, level, strAction, actionParam);
    }

    public void setIsSupportNoHighway(boolean b) {
        RGCarPreferSettingController.sIsSupportNoHighway = b;
    }

    public void onSetLastPreferValue(int i) {
        BNRoutePlaner.getInstance().setCalcPrference(i);
    }

    public int onGetLastPreferValue() {
        return BNRoutePlaner.getInstance().getCalcPreference();
    }

    public void setIsSelectPlate() {
        RGCarPreferSettingController.getInstance().mIsSelectPlate = BNSettingManager.hasPlateFromLocal(getContext());
    }

    public void navigateToCarLogoPage() {
        String carIconUrl;
        if (BNSettingManager.isUseHttpsOfflineURL()) {
            carIconUrl = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/growth/car.html";
        } else {
            carIconUrl = getURLScheme() + "webpagenavi.baidu.com/static/webpage/growth/car.html";
        }
        String sv = PackageUtil.getVersionName();
        String os = "0";
        String cuid = PackageUtil.getCuid();
        String cityIdStr = "";
        DistrictInfo district = GeoLocateModel.getInstance().getCurrentDistrict();
        if (district != null) {
            cityIdStr = String.valueOf(district.mId);
        }
        carIconUrl = carIconUrl + "?cuid=" + cuid + "&sv=" + sv + "&os=" + os + "&cid=" + cityIdStr;
    }

    public void setCalcPrference(int prefer) {
        BNRoutePlaner.getInstance().setCalcPrference(prefer);
    }

    public void setIsfetchCarOwnerData(boolean b) {
        BNRoutePlaner.sIsfetchCarOwnerData = b;
    }

    public int mappingPreferValue(int oldPrefer) {
        return RGRouteSortController.getInstance().mappingPreferValue(oldPrefer);
    }

    public void setPreferValue(int preferValue) {
        RGRouteSortController.getInstance().setPreferValue(preferValue);
    }

    public int getPreferValue() {
        return RGRouteSortController.getInstance().getPreferValue();
    }

    public String getURLScheme() {
        return HttpURLManager.getInstance().getScheme();
    }

    public boolean isAllowNavRecoveryDialogShow() {
        return true;
    }

    public void dismissWaitProgressDialog() {
        if (getContainerActivity() != null) {
            getContainerActivity().runOnUiThread(new C07547());
        }
    }

    public void showProgressDialog(final String msg, final C0672b cancelListener) {
        if (getContainerActivity() != null) {
            getContainerActivity().runOnUiThread(new Runnable() {
                public void run() {
                    C1307e.m4686a().mo1465a(msg, cancelListener);
                }
            });
        }
    }

    public void showProgressDialog(final String msg, final C0672b cancelListener, final C0690d listener) {
        if (getContainerActivity() != null) {
            getContainerActivity().runOnUiThread(new Runnable() {
                public void run() {
                    C1307e.m4686a().mo1466a(msg, cancelListener, listener);
                }
            });
        }
    }

    public void showFragment(int type, Bundle bundle) {
        C1328h.m4757a().showFragment(type, bundle);
    }

    public boolean isMapModuleFragment() {
        return C1328h.m4757a().m4768d() == 4003;
    }

    public boolean buttomNaviTabHasFocus() {
        if (C1309g.m4699a().isDialogShown()) {
            return true;
        }
        return C1309g.m4699a().m4701b().mo1489j();
    }

    public boolean isFocusUIEnable() {
        return C1765g.m6424a().m6442c();
    }

    public void showBottomBar(boolean show) {
        if (showBottomBarSwitch) {
            LogUtil.m3004e("navSDK", "showBottomBar" + show);
            C1309g.m4699a().m4701b().setBottomBarStatus(show);
        }
    }

    public void closeCarLifeVR() {
        C1261k.m4461b(4160);
    }

    public void naviDownloadXiJiangSwitch() {
        if (BaseFragment.mActivity != null) {
            BaseFragment.mActivity.m3098a(2);
        }
    }
}
