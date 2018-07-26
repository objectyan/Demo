package com.baidu.navi.logic.model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.logic.codriver.adapter.C1754b;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.BaseModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.json.JSONException;
import org.json.JSONObject;

public class UIModel extends BaseModel {
    private static UIModel mInstance;
    private boolean mIsAutoUpdateData = false;
    private boolean mIsNewData = false;
    private int mSearchDistrictID = NaviFragmentManager.TYPE_CAR_DRV_LIST;
    private String mSearchDistrictName = "北京市";

    private UIModel() {
    }

    public static UIModel getInstance() {
        if (mInstance == null) {
            mInstance = new UIModel();
        }
        return mInstance;
    }

    public void setIsAutoUpdateDataStatus(boolean update) {
        this.mIsAutoUpdateData = update;
    }

    public void setNewData(boolean newData) {
        this.mIsNewData = newData;
    }

    private static boolean isSettingCompAddr(Bundle budle) {
        return budle.getInt(BundleKey.SELECT_POINT_ACTION) == 5;
    }

    private static boolean isSettingHomeAddr(Bundle budle) {
        return budle.getInt(BundleKey.SELECT_POINT_ACTION, -1) == 4;
    }

    public static void syncAddressToCoDriverForAppStart() {
        if (AddressSettingModel.hasSetCompAddr(C1157a.a())) {
            RoutePlanNode node = AddressSettingModel.getCompAddrNode(C1157a.a());
            SearchPoi poi = new SearchPoi();
            poi.mName = node.mName;
            poi.mAddress = node.mDescription;
            poi.mGuidePoint = node.mGeoPoint;
            Bundle bundle = new Bundle();
            bundle.putInt(BundleKey.SELECT_POINT_ACTION, 5);
            syncAddressToCoDriver(poi, bundle);
        }
        if (AddressSettingModel.hasSetHomeAddr(C1157a.a())) {
            node = AddressSettingModel.getHomeAddrNode(C1157a.a());
            poi = new SearchPoi();
            poi.mName = node.mName;
            poi.mAddress = node.mDescription;
            poi.mGuidePoint = node.mGeoPoint;
            bundle = new Bundle();
            bundle.putInt(BundleKey.SELECT_POINT_ACTION, 4);
            syncAddressToCoDriver(poi, bundle);
        }
    }

    public static void syncAddressToCoDriver(SearchPoi poi, Bundle bundle) {
        if (poi != null && poi.mGuidePoint != null) {
            JSONObject jsonObject;
            JSONObject data;
            GeoPoint point;
            if (isSettingHomeAddr(bundle)) {
                jsonObject = new JSONObject();
                try {
                    jsonObject.put("domain", "navigate_instruction");
                    jsonObject.put("intent", "set_home");
                    data = new JSONObject();
                    data.put("name", poi.mName);
                    data.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, poi.mAddress);
                    point = new GeoPoint(poi.mGuidePoint.getLongitudeE6(), poi.mGuidePoint.getLatitudeE6());
                    data.put("lat", point.getLatitudeE6());
                    data.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, point.getLongitudeE6());
                    data.put("type", "home");
                    jsonObject.put("data", data);
                    C1754b.a().a(jsonObject.toString());
                } catch (JSONException e) {
                }
            } else if (isSettingCompAddr(bundle)) {
                jsonObject = new JSONObject();
                try {
                    jsonObject.put("domain", "navigate_instruction");
                    jsonObject.put("intent", "set_work");
                    data = new JSONObject();
                    data.put("name", poi.mName);
                    data.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, poi.mAddress);
                    point = new GeoPoint(poi.mGuidePoint.getLongitudeE6(), poi.mGuidePoint.getLatitudeE6());
                    data.put("lat", point.getLatitudeE6());
                    data.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, point.getLongitudeE6());
                    data.put("type", NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY);
                    jsonObject.put("data", data);
                    C1754b.a().a(jsonObject.toString());
                } catch (JSONException e2) {
                }
            }
        }
    }

    public static void settingAddress(SearchPoi node, Context context, Bundle bundle) {
        if (settingAddress(RoutePlanModel.changeToRoutePlanNode(node), context, bundle)) {
            syncAddressToCoDriver(node, bundle);
        }
    }

    public static boolean settingAddress(RoutePlanNode node, Context context, Bundle bundle) {
        if (node.getLatitudeE6() < 0 || node.getLongitudeE6() < 0) {
            TipTool.onCreateToastDialog(context, context.getString(C0965R.string.set_addr_fail));
            return false;
        } else if (isSettingHomeAddr(bundle)) {
            return setHomeAddress(node, context);
        } else {
            if (isSettingCompAddr(bundle)) {
                return setCompAddr(node, context);
            }
            return false;
        }
    }

    private static boolean setCompAddr(RoutePlanNode node, Context context) {
        if (AddressSettingModel.setCompAddress(context, node)) {
            TipTool.onCreateToastDialog(context, context.getString(C0965R.string.set_comp_addr_sucess));
            return true;
        }
        TipTool.onCreateToastDialog(context, context.getString(C0965R.string.set_addr_fail));
        return false;
    }

    private static boolean setHomeAddress(RoutePlanNode node, Context context) {
        if (AddressSettingModel.setHomeAddress(context, node)) {
            TipTool.onCreateToastDialog(context, context.getString(C0965R.string.set_home_addr_sucess));
            return true;
        }
        TipTool.onCreateToastDialog(context, context.getString(C0965R.string.set_addr_fail));
        return false;
    }

    public void goSettingFragment(int action, NaviFragmentManager mNaviFragmentManager) {
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.FROM_FRAGMENT, 304);
        bundle.putInt(BundleKey.SELECT_POINT_ACTION, action);
        mNaviFragmentManager.showFragment(49, bundle);
    }

    public void showToast(Activity mActivity, int result) {
        TipTool.onCreateToastDialog((Context) mActivity, result);
    }
}
