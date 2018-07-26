package com.baidu.navi.controller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C1262l;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.core.screen.presentation.p071a.C1319h;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.mobstat.Config;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.driveanalysis.CommonConstants;
import com.baidu.navi.fragment.NameSearchFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.protocol.model.RoutePlanDataStruct;
import com.baidu.navi.track.database.DataBaseConstants;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class LaunchIntentHelper implements LocationChangeListener {
    private static final int DEFAULT_SEARCH_RADIUS = 5000;
    private static final String KEY_SCREEN_ORIENTATION = "so";
    private static final String LOG_TAG = "LaunchIntentHelper";
    private static final int VIA_COUNT = 3;
    private int itemId;
    private CarlifeActivity mActivity;
    private String[] mCatalogIds;
    private String[] mCatalogNames;
    private Intent mIntent = null;
    private NaviFragmentManager mNaviFragmentManager;
    private C1277e mOnDialogListener;
    private Handler mRPHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(LaunchIntentHelper.this.mRPHandler);
                    if (LaunchIntentHelper.this.mNaviFragmentManager != null) {
                        LaunchIntentHelper.this.mNaviFragmentManager.showFragment(52, null);
                        return;
                    }
                    return;
                case 7:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(LaunchIntentHelper.this.mRPHandler);
                    return;
                case 32:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(LaunchIntentHelper.this.mRPHandler);
                    return;
                default:
                    return;
            }
        }
    };
    private Runnable mRunnable = null;
    private int mSearchRadius = 5000;
    private Uri mUri = null;

    /* renamed from: com.baidu.navi.controller.LaunchIntentHelper$2 */
    class C37042 implements C0672b {
        C37042() {
        }

        public void onClick() {
            Bundle bundle = new Bundle();
            bundle.putInt(BundleKey.FROM_FRAGMENT, 17);
            bundle.putInt(BundleKey.SELECT_POINT_ACTION, 4);
            LaunchIntentHelper.this.mNaviFragmentManager.showFragment(51, bundle);
        }
    }

    /* renamed from: com.baidu.navi.controller.LaunchIntentHelper$4 */
    class C37064 implements C0672b {
        C37064() {
        }

        public void onClick() {
            Bundle bundle = new Bundle();
            bundle.putInt(BundleKey.FROM_FRAGMENT, 17);
            bundle.putInt(BundleKey.SELECT_POINT_ACTION, 5);
            LaunchIntentHelper.this.mNaviFragmentManager.showFragment(51, bundle);
        }
    }

    /* renamed from: com.baidu.navi.controller.LaunchIntentHelper$5 */
    class C37075 implements Runnable {
        C37075() {
        }

        public void run() {
            C1307e.a().b("定位中，请稍候...");
        }
    }

    /* renamed from: com.baidu.navi.controller.LaunchIntentHelper$6 */
    class C37086 implements Runnable {
        C37086() {
        }

        public void run() {
            C1307e.a().c();
        }
    }

    /* renamed from: com.baidu.navi.controller.LaunchIntentHelper$8 */
    class C37108 implements Runnable {
        C37108() {
        }

        public void run() {
            LocationManager.getInstance().addLocationChangeLister(LaunchIntentHelper.this);
        }
    }

    public LaunchIntentHelper(CarlifeActivity activity, Intent intent, C1319h wrapper) {
        this.mActivity = activity;
        this.mOnDialogListener = wrapper;
        this.mNaviFragmentManager = C1328h.a().getNaviFragmentManager();
        initCatalogItemHelper(this.mActivity);
        this.mIntent = new Intent(intent);
        this.mUri = this.mIntent.getData();
    }

    public void handleLaunchIntent(Intent intent) {
        if (intent != null) {
            this.mIntent = new Intent(intent);
            handleLaunchIntent();
        }
    }

    public Boolean isInnerIntent() {
        return Boolean.valueOf(this.mUri == null);
    }

    public void handleLaunchIntent() {
        if (this.mIntent != null) {
            Uri uri = this.mIntent.getData();
            if (uri != null) {
                String scheme = uri.getScheme();
                String host = uri.getHost();
                if ("bdnavi".equals(scheme)) {
                    if ("query".equals(host)) {
                        preHandleLanuchIntent();
                        handleBDNaviQuery(uri);
                    } else if ("plan".equals(host)) {
                        preHandleLanuchIntent();
                        handleBDNaviPlan(uri);
                    } else if ("nearby".equals(host)) {
                        preHandleLanuchIntent();
                        handleBDNaviNearby(uri);
                    } else if ("where".equals(host)) {
                        preHandleLanuchIntent();
                        handleBDNaviWhere();
                    } else if ("gohome".equals(host)) {
                        preHandleLanuchIntent();
                        handleBDNaviGohome();
                    } else if ("gocompany".equals(host)) {
                        preHandleLanuchIntent();
                        handleBDNaviGocompany();
                    } else if ("data".equals(host)) {
                        handleBDNaviData();
                    } else if ("gohomebyshortcut".equals(host)) {
                        preHandleLanuchIntent();
                        handleBDNaviGohome();
                    } else if ("gocompanybyshortcut".equals(host)) {
                        preHandleLanuchIntent();
                        handleBDNaviGocompany();
                    } else if ("opennew".equals(host)) {
                        preHandleLanuchIntent();
                        handleOpneNew(this.mIntent.getStringExtra("link"));
                    } else if ("nameplan".equals(host)) {
                        preHandleLanuchIntent();
                        handleNamePlan(uri);
                    } else if ("customroute".equals(host)) {
                        preHandleLanuchIntent();
                        handleCustomRoute();
                    }
                } else if ("NAVI".equals(scheme)) {
                    preHandleLanuchIntent();
                    handleNavi(uri);
                } else if ("geo".equals(scheme)) {
                    preHandleLanuchIntent();
                    handleGeoScheme(uri);
                } else if ("baidumap".equals(scheme)) {
                    preHandleLanuchIntent();
                    handleBaiduMapScheme(uri);
                } else if ("http".equals(scheme)) {
                    preHandleLanuchIntent();
                    handleShortUriScheme(uri);
                }
            }
            this.mIntent = null;
        }
    }

    private void handleCustomRoute() {
    }

    private void handleOpneNew(String link) {
    }

    private void handleNamePlan(Uri uri) {
        if (uri != null) {
            String searchName = uri.getQueryParameter("destname");
            if (TextUtils.isEmpty(searchName)) {
                TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(C0965R.string.search_result_empty));
                return;
            }
            Bundle bd = new Bundle();
            bd.putInt("incoming_type", 4);
            bd.putBoolean("poi_center_mode", false);
            bd.putString(NameSearchFragment.VOICE_SEARCH_KEY, searchName);
            if (this.mNaviFragmentManager != null) {
                this.mNaviFragmentManager.showFragment(34, bd);
            }
        }
    }

    private void handleGeoScheme(Uri uri) {
        String data = uri.toString();
        int index1 = data.indexOf(44);
        int index2 = data.indexOf(63);
        if (index1 >= 0 && index2 >= 0 && index1 <= index2) {
            String lat = data.substring(4, index1);
            String lon = data.substring(index1 + 1, index2);
            String key = data.substring(index2 + 3);
            if (!"0".equals(lat) && !"0".equals(lon)) {
                handleGeoLocation(lat, lon, "wgs84");
            } else if (!StringUtils.isEmpty(key)) {
                String poikey = StringUtils.getUrlDecodeString(key);
                if (!StringUtils.isEmpty(poikey)) {
                    handleGeoKeySearch(poikey);
                }
            }
        }
    }

    private void handleGeoLocation(String lat, String lon, String coordType) {
        try {
            GeoPoint geopt;
            double latDouble = Double.parseDouble(lat);
            double lonDouble = Double.parseDouble(lon);
            if ("bd09ll".equals(coordType)) {
                geopt = CoordinateTransformUtil.transferBD09ToGCJ02(lonDouble, latDouble);
            } else if ("wgs84".equals(coordType)) {
                geopt = CoordinateTransformUtil.transferWGS84ToGCJ02(lonDouble, latDouble);
            } else {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("incoming_type", 87);
            bundle.putInt("lat", geopt.getLatitudeE6());
            bundle.putInt("lon", geopt.getLongitudeE6());
            this.mNaviFragmentManager.showFragment(33, bundle);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void handleGeoKeySearch(String key) {
        handleNameSearch(key);
    }

    private void handleBaiduMapScheme(Uri uri) {
        String host = uri.getHost();
        if (!StringUtils.isEmpty(host)) {
            if (host.equals("map")) {
                String path = uri.getPath();
                if (!StringUtils.isEmpty(path) && path.equals("/tts")) {
                    handleTTSVoice(uri.getQueryParameter(VoiceKey.ACTION), uri.getQueryParameter("ypid"));
                    return;
                }
            }
            String loc = uri.getQueryParameter("location");
            if (!StringUtils.isEmpty(loc)) {
                int index1 = loc.indexOf(44);
                if (index1 >= 0) {
                    handleGeoLocation(loc.substring(0, index1), loc.substring(index1 + 1), "bd09ll");
                }
            }
        }
    }

    private void handleTTSVoice(String action, String ypid) {
        if (action != null) {
            Bundle bundle = new Bundle();
            bundle.putString(VoiceKey.ACTION, action);
            if (action.equals("voicemain") || action.equals("download") || action.equals("record")) {
                if (ypid != null) {
                    bundle.putString("ypid", ypid);
                }
                BNVoice.getInstance().setExternalCall(true, bundle);
                if (this.mNaviFragmentManager.getCurrentFragmentType() == NaviFragmentManager.TYPE_VOICE_MAIN) {
                    BNVoice.getInstance().updateValues(bundle, 1);
                } else if (this.mNaviFragmentManager.findFragmentIndexInStack(NaviFragmentManager.TYPE_VOICE_MAIN) != -1) {
                    this.mNaviFragmentManager.backTo(NaviFragmentManager.TYPE_VOICE_MAIN, bundle);
                } else {
                    this.mNaviFragmentManager.showFragment(NaviFragmentManager.TYPE_VOICE_MAIN, bundle);
                }
            }
        }
    }

    private void handleShortUriScheme(Uri uri) {
        Bundle bundle = new Bundle();
        bundle.putInt("incoming_type", 87);
        bundle.putString("short_uri", uri.toString());
        this.mNaviFragmentManager.showFragment(33, bundle);
    }

    private void handleBDNaviData() {
        this.mNaviFragmentManager.showFragment(NaviFragmentManager.TYPE_OFFLINE_DATA, null);
    }

    private void handleBDNaviGohome() {
        final int longitude = AddressSettingModel.getHomeLon(this.mActivity);
        final int latitude = AddressSettingModel.getHomeLat(this.mActivity);
        final String address = AddressSettingModel.getHomeAddress(this.mActivity);
        final String name = AddressSettingModel.getHomeName(this.mActivity);
        if (longitude <= 0 || latitude <= 0) {
            this.mOnDialogListener.showDialog(new C1953c(this.mActivity).b(C0965R.string.alert_notification).a(C0965R.string.select_node_home_notset).c(C0965R.string.alert_setting).q().a(new C37042()).d(C0965R.string.alert_cancel));
            return;
        }
        GeoPoint geoPoint = getMypositionGeoPoint();
        if (geoPoint == null || !geoPoint.isValid()) {
            LocationManager.getInstance().addLocationChangeLister(this);
            showProgressDialog();
            this.mRunnable = new Runnable() {
                public void run() {
                    LaunchIntentHelper.this.cancelProgressDialog();
                    LaunchIntentHelper.this.planToHome(longitude, latitude, address, name);
                }
            };
            return;
        }
        planToHome(longitude, latitude, address, name);
    }

    private void handleBDNaviGocompany() {
        final int longitude = AddressSettingModel.getCompLon(this.mActivity);
        final int latitude = AddressSettingModel.getCompLat(this.mActivity);
        final String address = AddressSettingModel.getCompAddress(this.mActivity);
        final String name = AddressSettingModel.getCompName(this.mActivity);
        if (longitude > 0 && latitude > 0) {
            GeoPoint geoPoint = getMypositionGeoPoint();
            if (geoPoint == null || !geoPoint.isValid()) {
                LocationManager.getInstance().addLocationChangeLister(this);
                showProgressDialog();
                this.mRunnable = new Runnable() {
                    public void run() {
                        LaunchIntentHelper.this.cancelProgressDialog();
                        LaunchIntentHelper.this.planToCompany(longitude, latitude, address, name);
                    }
                };
                return;
            }
            planToCompany(longitude, latitude, address, name);
        } else if (this.mActivity != null) {
            this.mOnDialogListener.showDialog(new C1953c(this.mActivity).b(C0965R.string.alert_notification).a(C0965R.string.select_node_comp_notset).c(C0965R.string.alert_setting).q().a(new C37064()).d(C0965R.string.alert_cancel), C1265a.Center);
        }
    }

    private void showProgressDialog() {
        C1262l.a().post(new C37075());
    }

    private void cancelProgressDialog() {
        C1262l.a().post(new C37086());
    }

    private void handleBDNaviWhere() {
        this.mNaviFragmentManager.showFragment(17, null);
    }

    private void handleNavi(Uri uri) {
        if (uri != null) {
            String[] uriStringArr = uri.toString().split(Config.TRACE_TODAY_VISIT_SPLIT);
            if (uri == null || uriStringArr.length != 2 || TextUtils.isEmpty(uriStringArr[1])) {
                TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(C0965R.string.route_plan_toast_fail_wrong_coord));
                return;
            }
            GeoPoint point = parseGeoPointFromString(uriStringArr[1]);
            if (point != null) {
                calcRoute(point, null);
            } else {
                TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(C0965R.string.route_plan_toast_fail_wrong_coord));
            }
        }
    }

    private void handleBDNaviQuery(Uri uri) {
        if (uri != null) {
            String searchName = uri.getQueryParameter("name");
            if (TextUtils.isEmpty(searchName)) {
                TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(C0965R.string.search_result_empty));
            } else {
                handleNameSearch(searchName);
            }
        }
    }

    private void handleNameSearch(String searchName) {
        Bundle bd = new Bundle();
        bd.putInt("incoming_type", 4);
        bd.putBoolean("poi_center_mode", false);
        bd.putString(NameSearchFragment.VOICE_SEARCH_KEY, searchName);
        if (this.mNaviFragmentManager != null) {
            this.mNaviFragmentManager.showFragment(34, bd);
        }
    }

    private RoutePlanNode getMypositionNode() {
        GeoPoint point = getMypositionGeoPoint();
        if (point == null) {
            return null;
        }
        return new RoutePlanNode(point, 1, RoutePlanParams.MY_LOCATION, null);
    }

    private GeoPoint getMypositionGeoPoint() {
        GeoPoint point = GeoLocateModel.getInstance().getLastGeoPoint();
        if (point != null && point.isValid()) {
            return point;
        }
        LogUtil.m15791e(LOG_TAG, "Sys last known location is not valid!");
        return BNLocationManagerProxy.getInstance().getLastValidLocation();
    }

    private void handleBDNaviPlan(Uri uri) {
        if (uri != null) {
            ArrayList<RoutePlanNode> navNodes = new ArrayList(2);
            boolean needTrans = true;
            String coordType = uri.getQueryParameter(CommonConstants.COORD_TYPE);
            if (coordType == null || coordType.equals("bd09ll")) {
                needTrans = true;
            } else if (coordType.equals(LocationUtil.COORDINATE_SYSTEM_GCJ02)) {
                needTrans = false;
            }
            RoutePlanNode destNode = parseNavNodeFromString(uri.getQueryParameter(NaviCmdConstants.KEY_NAVI_CMD_DEST), needTrans);
            if (destNode == null) {
                TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(C0965R.string.route_plan_toast_route_node_not_complete));
                return;
            }
            String destName = uri.getQueryParameter("name");
            if (!TextUtils.isEmpty(destName)) {
                destNode.mName = destName;
            }
            RoutePlanNode startNode = parseNavNodeFromString(uri.getQueryParameter("start"), needTrans);
            if (startNode == null) {
                startNode = getMypositionNode();
            }
            if (startNode == null) {
                TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(C0965R.string.route_plan_toast_loc_invalid));
                return;
            }
            navNodes.add(startNode);
            String viaGeoString = uri.getQueryParameter(RoutePlanDataStruct.KEY_VIA);
            if (!TextUtils.isEmpty(viaGeoString)) {
                String[] viaGeoArr = viaGeoString.split(Config.TRACE_TODAY_VISIT_SPLIT);
                if (viaGeoArr != null && viaGeoArr.length > 0) {
                    int length = viaGeoArr.length;
                    if (length > 3) {
                        length = 3;
                    }
                    for (int i = 0; i < length; i++) {
                        RoutePlanNode navNode = parseNavNodeFromString(viaGeoArr[i], needTrans);
                        if (navNode != null) {
                            navNodes.add(navNode);
                        }
                    }
                }
            }
            navNodes.add(destNode);
            BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
            BNRoutePlaner.getInstance().setPointsToCalcRoute(navNodes);
        }
    }

    private void handleBDNaviNearby(Uri uri) {
        if (uri != null) {
            String radiusStr = uri.getQueryParameter(CommonConstants.RADIUS);
            if (!TextUtils.isEmpty(radiusStr)) {
                try {
                    this.mSearchRadius = Integer.valueOf(radiusStr).intValue();
                } catch (NumberFormatException e) {
                }
                if (this.mSearchRadius <= 0) {
                    this.mSearchRadius = 5000;
                }
            }
            String itemIdStr = uri.getQueryParameter("id");
            this.itemId = -1;
            if (TextUtils.isEmpty(itemIdStr)) {
                TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.search_space_result_failed);
                return;
            }
            try {
                this.itemId = Integer.valueOf(itemIdStr).intValue();
                if (this.itemId < 1 || this.itemId > 8 || this.mCatalogNames.length < this.itemId || this.mCatalogNames.length < this.itemId) {
                    TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.search_space_result_failed);
                    return;
                }
                String locString = uri.getQueryParameter(DataBaseConstants.TYPE_LOC);
                LogUtil.m15791e("", "trySearchSpace locString  " + locString);
                Bundle bd = new Bundle();
                bd.putInt("incoming_type", 4);
                bd.putBoolean("poi_center_mode", true);
                bd.putString(NameSearchFragment.VOICE_SEARCH_KEY, this.mCatalogIds[this.itemId - 1]);
                bd.putString(NameSearchFragment.INTENT_API_POI_POINT, locString);
                bd.putInt(NameSearchFragment.INTENT_API_POI_RADIUS, this.mSearchRadius);
                if (this.mNaviFragmentManager != null) {
                    this.mNaviFragmentManager.showFragment(34, bd);
                }
            } catch (NumberFormatException e2) {
                TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.search_space_result_failed);
            }
        }
    }

    private GeoPoint parseGeoPointFromString(String geoString) {
        if (TextUtils.isEmpty(geoString)) {
            return null;
        }
        String[] geoArr = geoString.split(",");
        if (geoArr == null || geoArr.length != 2 || TextUtils.isEmpty(geoArr[0]) || TextUtils.isEmpty(geoArr[0])) {
            return null;
        }
        try {
            return new GeoPoint((int) (Double.valueOf(geoArr[1]).doubleValue() * 100000.0d), (int) (100000.0d * Double.valueOf(geoArr[0]).doubleValue()));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private RoutePlanNode parseNavNodeFromString(String s, boolean needTrans) {
        if (TextUtils.isEmpty(s)) {
            return null;
        }
        String[] geoArr = s.split(",");
        if (geoArr == null || geoArr.length < 2 || TextUtils.isEmpty(geoArr[0]) || TextUtils.isEmpty(geoArr[0])) {
            return null;
        }
        try {
            String poiName;
            double lat = Double.valueOf(geoArr[0]).doubleValue();
            double lon = Double.valueOf(geoArr[1]).doubleValue();
            if (needTrans) {
                LocData gcj02LastLocation = new LocData();
                lat = gcj02LastLocation.latitude;
                lon = gcj02LastLocation.longitude;
            }
            GeoPoint point = new GeoPoint((int) (100000.0d * lon), (int) (100000.0d * lat));
            if (geoArr.length > 2) {
                poiName = geoArr[2];
            } else {
                poiName = this.mActivity.getString(C0965R.string.unknown_poi_point);
            }
            return new RoutePlanNode(point, 1, poiName, null);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void calcRoute(GeoPoint point, String name) {
        if (TextUtils.isEmpty(name)) {
            name = this.mActivity.getString(C0965R.string.unknown_poi_point);
        }
        RoutePlanNode navNode = new RoutePlanNode(point, 1, name, "");
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
        ArrayList<RoutePlanNode> nodes = new ArrayList(2);
        nodes.add(getMypositionNode());
        nodes.add(navNode);
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodes);
    }

    private void initCatalogItemHelper(Activity activity) {
        this.mCatalogIds = activity.getResources().getStringArray(C0965R.array.space_catalog_id_main);
        this.mCatalogNames = activity.getResources().getStringArray(C0965R.array.space_catalog_name_main);
    }

    private void preHandleLanuchIntent() {
        if (this.mNaviFragmentManager.getCurrentFragmentType() == 113) {
            BaiduNaviSDKManager.getInstance().quitNavi();
            this.mNaviFragmentManager.back(null);
        } else if (this.mNaviFragmentManager.getCurrentFragmentType() != 52) {
        }
    }

    public int getScreenOrientation() {
        if (this.mIntent == null) {
            return 2;
        }
        Uri uri = this.mIntent.getData();
        if (uri == null) {
            return 2;
        }
        try {
            String so = uri.getQueryParameter(KEY_SCREEN_ORIENTATION);
            if (NaviStatConstants.K_NSC_KEY_FINISHNAVI_LAND.equals(so)) {
                return 0;
            }
            if ("port".equals(so)) {
                return 1;
            }
            return 2;
        } catch (UnsupportedOperationException e) {
            return 2;
        }
    }

    public void onLocationChange(LocationManager.LocData arg0) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (this.mRunnable != null) {
            handler.post(this.mRunnable);
            this.mRunnable = null;
        }
        handler.post(new C37108());
    }

    public CoordType onGetCoordType() {
        return CoordType.CoordType_GCJ02;
    }

    private void planToHome(int longitude, int latitude, String address, String name) {
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
        ArrayList<RoutePlanNode> nodes = new ArrayList(2);
        nodes.add(getMypositionNode());
        nodes.add(AddressSettingModel.getHomeAddrNode(this.mActivity));
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodes);
    }

    private void planToCompany(int longitude, int latitude, String address, String name) {
        RoutePlanNode node = new RoutePlanNode(latitude, longitude, 5, name, address);
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
        ArrayList<RoutePlanNode> nodes = new ArrayList(2);
        nodes.add(getMypositionNode());
        nodes.add(AddressSettingModel.getCompAddrNode(this.mActivity));
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodes);
    }
}
