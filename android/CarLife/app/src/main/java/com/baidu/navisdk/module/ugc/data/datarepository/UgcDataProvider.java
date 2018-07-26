package com.baidu.navisdk.module.ugc.data.datarepository;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository.UgcBaseDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UgcDataProvider {
    private static Map<Integer, Integer> mDrawableIdCache = null;
    private static Map<Integer, String> mUrlCache = null;

    public static class UgcLayout {
        private ArrayList<UgcBaseDataModel> dynamicMoselList;
        private int position;
        private ArrayList<UgcBaseDataModel> ugcMainList;
        private UgcBaseDataModel ugcSubModel;

        public UgcLayout(ArrayList<UgcBaseDataModel> ugcMainList, UgcBaseDataModel ugcSubModel) {
            this(ugcMainList, ugcSubModel, -1);
        }

        public UgcLayout(ArrayList<UgcBaseDataModel> ugcMainList, UgcBaseDataModel ugcSubModel, int position) {
            this(ugcMainList, null, ugcSubModel, position);
        }

        public UgcLayout(ArrayList<UgcBaseDataModel> ugcMainList, ArrayList<UgcBaseDataModel> dynamicMoselList, UgcBaseDataModel ugcSubModel, int position) {
            this.ugcMainList = null;
            this.ugcSubModel = null;
            this.dynamicMoselList = null;
            this.position = -1;
            this.ugcMainList = ugcMainList;
            this.ugcSubModel = ugcSubModel;
            this.position = position;
            this.dynamicMoselList = dynamicMoselList;
        }

        public int getSubType() {
            if (this.ugcSubModel != null) {
                return this.ugcSubModel.type;
            }
            return -1;
        }

        public UgcBaseDataModel getUgcSubModel() {
            return this.ugcSubModel;
        }

        public ArrayList<UgcBaseDataModel> getMainList() {
            return this.ugcMainList;
        }

        public int getDetailSize() {
            if (this.ugcSubModel == null || this.ugcSubModel.ugcSubDataDetail == null) {
                return 0;
            }
            return this.ugcSubModel.ugcSubDataDetail.size();
        }

        public int getPositionSize() {
            if (this.ugcSubModel == null || this.ugcSubModel.ugcSubDataPosition == null) {
                return 0;
            }
            return this.ugcSubModel.ugcSubDataPosition.size();
        }

        public String getDetailTitle(int index) {
            if (index < 0 || index >= getDetailSize() || this.ugcSubModel.ugcSubDataDetail.get(index) == null) {
                return null;
            }
            return ((UgcBaseDataModel) this.ugcSubModel.ugcSubDataDetail.get(index)).title;
        }

        public String getPositionTitle(int index) {
            if (index < 0 || index >= getPositionSize() || this.ugcSubModel.ugcSubDataPosition.get(index) == null) {
                return null;
            }
            return ((UgcBaseDataModel) this.ugcSubModel.ugcSubDataPosition.get(index)).title;
        }

        public String getSubTitle() {
            if (this.ugcSubModel != null) {
                return this.ugcSubModel.title;
            }
            return null;
        }

        public int getPositionType(int index) {
            if (index < 0 || index >= getPositionSize() || this.ugcSubModel.ugcSubDataPosition.get(index) == null) {
                return -1;
            }
            return ((UgcBaseDataModel) this.ugcSubModel.ugcSubDataPosition.get(index)).type;
        }

        public int getDetailType(int index) {
            if (index < 0 || index >= getDetailSize() || this.ugcSubModel.ugcSubDataDetail.get(index) == null) {
                return -1;
            }
            return ((UgcBaseDataModel) this.ugcSubModel.ugcSubDataDetail.get(index)).type;
        }

        public int getMainItemsSize() {
            if (this.ugcMainList != null) {
                return this.ugcMainList.size();
            }
            return 0;
        }

        public int getMainItemsType(int index) {
            if (getMainItemsSize() <= index || index < 0 || this.ugcMainList.get(index) == null) {
                return -1;
            }
            return ((UgcBaseDataModel) this.ugcMainList.get(index)).type;
        }

        public String getMainItemsTitle(int index) {
            if (getMainItemsSize() <= index || index < 0 || this.ugcMainList.get(index) == null) {
                return null;
            }
            return ((UgcBaseDataModel) this.ugcMainList.get(index)).title;
        }

        public int getLaneSize() {
            if (this.ugcSubModel == null || this.ugcSubModel.ugcSubDataLane == null) {
                return 0;
            }
            return this.ugcSubModel.ugcSubDataLane.size();
        }

        public String getLaneTitle(int index) {
            if (index < 0 || index >= getLaneSize() || this.ugcSubModel.ugcSubDataLane.get(index) == null) {
                return null;
            }
            return ((UgcBaseDataModel) this.ugcSubModel.ugcSubDataLane.get(index)).title;
        }

        public int getLaneType(int index) {
            if (index < 0 || index >= getLaneSize() || this.ugcSubModel.ugcSubDataLane.get(index) == null) {
                return -1;
            }
            return ((UgcBaseDataModel) this.ugcSubModel.ugcSubDataLane.get(index)).type;
        }

        public int getDynamicItemsSize() {
            if (this.dynamicMoselList != null) {
                return this.dynamicMoselList.size();
            }
            return 0;
        }

        public String getDynamicItemsTitle(int index) {
            if (getDynamicItemsSize() <= index || index < 0 || this.dynamicMoselList.get(index) == null) {
                return null;
            }
            return ((UgcBaseDataModel) this.dynamicMoselList.get(index)).title;
        }

        public int getDynamicItemsType(int index) {
            if (getDynamicItemsSize() <= index || index < 0 || this.dynamicMoselList.get(index) == null) {
                return -1;
            }
            return ((UgcBaseDataModel) this.dynamicMoselList.get(index)).type;
        }
    }

    public static int getDrawableIdByType(int type) {
        if (mDrawableIdCache == null) {
            initDrawableIdCache();
        }
        Integer object = (Integer) mDrawableIdCache.get(Integer.valueOf(type));
        if (object == null) {
            return -1;
        }
        return object.intValue();
    }

    public static String getUrlByType(int type) {
        if (mUrlCache == null) {
            initUrlCache();
        }
        return (String) mUrlCache.get(Integer.valueOf(type));
    }

    public static UgcLayout obtainUgcNaviLayout() {
        return new UgcLayout(UgcDataRepository.getInstance().obtainNaviUgcDataList(), UgcDataRepository.getInstance().obtainNaviDynamicUgcDataList(), null, -1);
    }

    public static UgcLayout obtainUgcMapLayout() {
        return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), null, -1);
    }

    public static UgcLayout obtainUgcMapSubLayout(int position) {
        ArrayList<UgcBaseDataModel> mMainList = UgcDataRepository.getInstance().obtainMapUgcDataList();
        UgcBaseDataModel mSubModel = null;
        if (mMainList != null && mMainList.size() > position && position >= 0) {
            mSubModel = (UgcBaseDataModel) mMainList.get(position);
        }
        return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), mSubModel, position);
    }

    public static UgcLayout obtainUgcNaviSubLayout(int position) {
        ArrayList<UgcBaseDataModel> mMainList = UgcDataRepository.getInstance().obtainNaviUgcDataList();
        UgcBaseDataModel mSubModel = null;
        if (mMainList != null && mMainList.size() > position && position >= 0) {
            mSubModel = (UgcBaseDataModel) mMainList.get(position);
        }
        return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), mSubModel, position);
    }

    public static UgcLayout obtainDynamicUgcNaviSubLayout(int position) {
        ArrayList<UgcBaseDataModel> mMainList = UgcDataRepository.getInstance().obtainNaviDynamicUgcDataList();
        UgcBaseDataModel mSubModel = null;
        if (mMainList != null && mMainList.size() > position && position >= 0) {
            mSubModel = (UgcBaseDataModel) mMainList.get(position);
        }
        return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), mMainList, mSubModel, position);
    }

    public static UgcLayout obtainDynamicUgcNaviSubLayoutByType(int type) {
        ArrayList<UgcBaseDataModel> mMainList = UgcDataRepository.getInstance().obtainNaviDynamicUgcDataList();
        UgcBaseDataModel mSubModel = null;
        int position = -1;
        for (int i = 0; i < mMainList.size(); i++) {
            if (((UgcBaseDataModel) mMainList.get(i)).type == type) {
                mSubModel = (UgcBaseDataModel) mMainList.get(i);
                position = i;
                break;
            }
        }
        if (mSubModel == null) {
            return null;
        }
        return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), mMainList, mSubModel, position);
    }

    private static void initUrlCache() {
        int i;
        mUrlCache = new HashMap();
        ArrayList<UgcBaseDataModel> mModelList = UgcDataRepository.getInstance().obtainNaviUgcDataList();
        if (mModelList != null) {
            i = 0;
            while (i < mModelList.size()) {
                if (!(mModelList.get(i) == null || ((UgcBaseDataModel) mModelList.get(i)).iconUrl == null)) {
                    mUrlCache.put(Integer.valueOf(((UgcBaseDataModel) mModelList.get(i)).type), ((UgcBaseDataModel) mModelList.get(i)).iconUrl);
                }
                i++;
            }
        }
        mModelList = UgcDataRepository.getInstance().obtainMapUgcDataList();
        if (mModelList != null) {
            i = 0;
            while (i < mModelList.size()) {
                if (!(mModelList.get(i) == null || ((UgcBaseDataModel) mModelList.get(i)).iconUrl == null)) {
                    mUrlCache.put(Integer.valueOf(((UgcBaseDataModel) mModelList.get(i)).type + 61440), ((UgcBaseDataModel) mModelList.get(i)).iconUrl);
                }
                i++;
            }
        }
        if (UgcDataRepository.getInstance().getActBaseDataModel() != null) {
            mUrlCache.put(Integer.valueOf(4096), UgcDataRepository.getInstance().getActBaseDataModel().entryIconUrl);
        }
    }

    private static void initDrawableIdCache() {
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
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_TRAFIC_ACCIDENT), Integer.valueOf(C4048R.drawable.type_map_default_trafic_accident));
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_TRAFIC_JAM), Integer.valueOf(C4048R.drawable.type_map_default_trafic_jam));
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_POLICE), Integer.valueOf(C4048R.drawable.type_map_default_road_police));
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_DANGEROU), Integer.valueOf(C4048R.drawable.type_map_default_dangerous));
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_ROAD_BUILD), Integer.valueOf(C4048R.drawable.type_map_default_road_build));
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_DEFAULT_MAP_MAIN_ROAD_CLOSED), Integer.valueOf(C4048R.drawable.type_map_default_road_closed));
        mDrawableIdCache.put(Integer.valueOf(8), Integer.valueOf(C4048R.drawable.ugc_default_traffic_regulate));
        mDrawableIdCache.put(Integer.valueOf(9), Integer.valueOf(C4048R.drawable.type_default_road_police));
        mDrawableIdCache.put(Integer.valueOf(10), Integer.valueOf(C4048R.drawable.type_default_dangerous));
        mDrawableIdCache.put(Integer.valueOf(15), Integer.valueOf(C4048R.drawable.type_default_limited_speed));
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_UGC_MAP_MAIN_FEEDBACK_ICON_NEW), Integer.valueOf(C4048R.drawable.nsdk_ugc_map_main_new_position));
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_UGC_MAP_MAIN_FEEDBACK_ICON_ERR), Integer.valueOf(C4048R.drawable.nsdk_ugc_map_main_err_position));
        mDrawableIdCache.put(Integer.valueOf(IUgcDataParams.TYPE_UGC_MAP_MAIN_FEEDBACK_ICON_FEEDBACK), Integer.valueOf(C4048R.drawable.nsdk_ugc_map_main_more_feedback));
    }
}
