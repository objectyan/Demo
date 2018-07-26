package com.baidu.navisdk.model.modelfactory;

import com.baidu.navisdk.CommonParams.Const.ModelName;
import java.util.HashMap;
import java.util.Map;

public class NaviDataEngine {
    private static Map<String, BaseModel> mModelList = new HashMap();
    private static volatile NaviDataEngine me = null;

    public NaviDataEngine() {
        mModelList.clear();
    }

    public static NaviDataEngine getInstance() {
        if (me == null) {
            synchronized (NaviDataEngine.class) {
                if (me == null) {
                    me = new NaviDataEngine();
                }
            }
        }
        return me;
    }

    private BaseModel instanceModel(String modelName) {
        if (ModelName.OFFLINE_DATA.equals(modelName)) {
            return new OfflineDataModel();
        }
        if (ModelName.POI_SEARCH.equals(modelName)) {
            return new PoiSearchModel();
        }
        if (ModelName.ROUTE_PLAN.equals(modelName)) {
            return new RoutePlanModel();
        }
        return null;
    }

    private void createModel(String modelName) {
        mModelList.put(modelName, instanceModel(modelName));
    }

    public void removeModel(String ModelName) {
        if (mModelList != null && mModelList.get(ModelName) != null) {
            mModelList.remove(ModelName);
        }
    }

    public BaseModel getModel(String modelName) {
        if (mModelList == null) {
            mModelList = new HashMap();
        }
        BaseModel model = (BaseModel) mModelList.get(modelName);
        if (model != null) {
            return model;
        }
        createModel(modelName);
        return (BaseModel) mModelList.get(modelName);
    }
}
