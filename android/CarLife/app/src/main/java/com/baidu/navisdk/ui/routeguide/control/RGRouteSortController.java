package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class RGRouteSortController {
    private static final String TAG = RGRouteSortController.class.getSimpleName();
    private static RGRouteSortController sInstance = null;
    public boolean mIsRouteSortOpen = true;
    public boolean mIsShowDefaultSettingBtn = false;
    private NavRouteSortListener mListener = null;
    private int mPreferValue = 0;
    private ArrayList<RGRouteSortModel> mRouteSortList = null;

    public interface NavRouteSortListener {
        void onClickItemAction(boolean z);

        void onCloseAction();

        void onSettingDefaultAction();
    }

    public static class PageConstant {
        public static final int INVALID = 0;
        public static final int NAVIGATION_PAGE = 2;
        public static final int ROUTE_RESULT_DETAIL_PAGE = 1;
    }

    public static RGRouteSortController getInstance() {
        if (sInstance == null) {
            synchronized (RGRouteSortController.class) {
                if (sInstance == null) {
                    sInstance = new RGRouteSortController();
                }
            }
        }
        return sInstance;
    }

    public int mappingPreferValue(int oldPrefer) {
        LogUtil.m15791e(TAG, "mappingPreferValue oldPrefer = " + oldPrefer);
        int newPrefer = oldPrefer;
        if ((oldPrefer & 32) != 0) {
            newPrefer ^= 32;
        }
        if (newPrefer == 2) {
            newPrefer = 512;
        } else if (newPrefer == 4 || newPrefer == 8) {
            newPrefer = 8;
        } else if (newPrefer == 18) {
            newPrefer = 512;
        } else if (newPrefer == 20) {
            newPrefer = 8;
        } else if (newPrefer == 24) {
            newPrefer = 8;
        } else if (newPrefer == 12) {
            newPrefer = 8;
        } else if (newPrefer == 28) {
            newPrefer = 8;
        }
        if ((oldPrefer & 32) != 0) {
            newPrefer |= 32;
        }
        if (newPrefer == 0) {
            LogUtil.m15791e(TAG, "mappingPreferValue newPrefer is invalid and mapping it to default value");
            newPrefer = 1;
        }
        LogUtil.m15791e(TAG, "mappingPreferValue newPrefer = " + newPrefer);
        return newPrefer;
    }

    public ArrayList<RGRouteSortModel> getRouteSortList() {
        if (this.mRouteSortList == null) {
            initRouteSortList();
        }
        return this.mRouteSortList;
    }

    private void initRouteSortList() {
        this.mRouteSortList = new ArrayList();
        this.mRouteSortList.add(new RGRouteSortModel("智能推荐", 1));
        this.mRouteSortList.add(new RGRouteSortModel("时间优先", 256));
        this.mRouteSortList.add(new RGRouteSortModel("距离优先", 128));
        this.mRouteSortList.add(new RGRouteSortModel("躲避拥堵", 16));
        this.mRouteSortList.add(new RGRouteSortModel("收费较少", 8));
        this.mRouteSortList.add(new RGRouteSortModel("大路优先", 512));
    }

    public void setPreferValue(int prefer) {
        this.mPreferValue = prefer;
    }

    public int getPreferValue() {
        return this.mPreferValue;
    }

    public void uninit() {
        this.mIsShowDefaultSettingBtn = false;
    }

    public boolean parseCloudJson(JSONObject data) {
        try {
            JSONObject routeSortJSONObject = data.getJSONObject("road_sort");
            if (routeSortJSONObject == null) {
                return false;
            }
            boolean z;
            if (routeSortJSONObject.getInt("open") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.mIsRouteSortOpen = z;
            JSONArray routeSortJSONLabelsArr = routeSortJSONObject.getJSONArray("labels");
            if (routeSortJSONLabelsArr == null || routeSortJSONLabelsArr.length() == 0) {
                return false;
            }
            this.mRouteSortList = new ArrayList();
            for (int i = 0; i < routeSortJSONLabelsArr.length(); i++) {
                JSONObject obj = routeSortJSONLabelsArr.getJSONObject(i);
                this.mRouteSortList.add(new RGRouteSortModel(obj.getString(BNRCEventDetailsModel.BN_RC_KEY_LABEL), obj.getInt("tag")));
            }
            return true;
        } catch (Exception e) {
            this.mRouteSortList = null;
            return false;
        }
    }

    public void checkCloudConfig() {
        if (!hasSelectedPrefer()) {
            if ((BNaviModuleManager.getLastPreferValue() & 32) != 0) {
                BNaviModuleManager.setLastPreferValue(33);
                setPreferValue(33);
                return;
            }
            BNaviModuleManager.setLastPreferValue(1);
            setPreferValue(1);
        }
    }

    private boolean hasSelectedPrefer() {
        if (this.mRouteSortList == null || this.mRouteSortList.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.mRouteSortList.size(); i++) {
            RGRouteSortModel model = (RGRouteSortModel) this.mRouteSortList.get(i);
            if (model != null && (model.mPreferValue & BNaviModuleManager.getLastPreferValue()) != 0) {
                return true;
            }
        }
        return false;
    }

    public void setRouteSortListener(NavRouteSortListener listener) {
        this.mListener = listener;
    }

    public void onClickItemAction(boolean isPreferChange) {
        if (this.mListener != null) {
            this.mListener.onClickItemAction(isPreferChange);
        }
    }

    public void onCloseAction() {
        if (this.mListener != null) {
            this.mListener.onCloseAction();
        }
    }

    public void onSettingDefaultAction() {
        if (this.mListener != null) {
            this.mListener.onSettingDefaultAction();
        }
    }

    public String getCurrentRouteSortName() {
        ArrayList<RGRouteSortModel> list = getInstance().getRouteSortList();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                RGRouteSortModel model = (RGRouteSortModel) list.get(i);
                if (model != null && (model.mPreferValue & getInstance().getPreferValue()) != 0) {
                    return model.mItemName;
                }
            }
        }
        return "";
    }

    public int getmPreferIconId(int preferValue, boolean isSelected) {
        switch (preferValue) {
            case 1:
                return !isSelected ? C4048R.drawable.nsdk_drawable_route_sort_default_normal : C4048R.drawable.nsdk_drawable_route_sort_default_selected;
            case 8:
                return isSelected ? C4048R.drawable.nsdk_drawable_route_sort_notoll_selected : C4048R.drawable.nsdk_drawable_route_sort_notoll_normal;
            case 16:
                return isSelected ? C4048R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_selected : C4048R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_normal;
            case 128:
                return isSelected ? C4048R.drawable.nsdk_drawable_route_sort_distance_first_selected : C4048R.drawable.nsdk_drawable_route_sort_distance_first_normal;
            case 256:
                return isSelected ? C4048R.drawable.nsdk_drawable_route_sort_time_first_selected : C4048R.drawable.nsdk_drawable_route_sort_time_first_normal;
            case 512:
                return isSelected ? C4048R.drawable.nsdk_drawable_route_sort_road_first_selected : C4048R.drawable.nsdk_drawable_route_sort_road_first_normal;
            default:
                return isSelected ? C4048R.drawable.nsdk_drawable_route_sort_default_selected : C4048R.drawable.nsdk_drawable_route_sort_default_normal;
        }
    }
}
