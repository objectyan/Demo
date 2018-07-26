package com.baidu.navi.track.model;

import android.text.TextUtils;
import com.baidu.navi.track.database.DataBaseConstants;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrackSyncResponseModel {
    private static final String TAG = TrackSyncResponseModel.class.getSimpleName();
    public ArrayList<CarNaviModel> dataList = new ArrayList();
    public ArrayList<String> guidList = new ArrayList();
    public int isResponse = 0;
    public String lastver;
    public TrackAcmp trackAcmp = new TrackAcmp();

    public static TrackSyncResponseModel parseJson(JSONObject jsonObject) {
        TrackSyncResponseModel model = new TrackSyncResponseModel();
        if (jsonObject != null) {
            model.isResponse = 1;
            JSONArray oribitTotal = jsonObject.optJSONArray("orbitTotal");
            if (oribitTotal != null && oribitTotal.length() > 0) {
                JSONObject object = oribitTotal.optJSONObject(0);
                if (object != null) {
                    model.trackAcmp.setCarMaxDuration(object.optInt("longest_conn_time"));
                    model.trackAcmp.setCarWeekMileage(object.optInt("week_mileage"));
                    model.trackAcmp.setCarNaviDistance(object.optInt("total_mileage"));
                }
            }
            JSONArray jsonArray = jsonObject.optJSONArray("allorbits");
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.optJSONObject(i);
                    if (item != null) {
                        String[] split;
                        CarNaviModel carNaviModel = new CarNaviModel();
                        carNaviModel.cleanCarInfo();
                        carNaviModel.setUseId(item.optString("uid"));
                        carNaviModel.getPBData().setSid("111");
                        if (item.optInt("is_deleted") == 0) {
                            carNaviModel.setSyncState(3);
                        } else {
                            carNaviModel.setSyncState(2);
                        }
                        carNaviModel.getPBData().setGuid(item.optString("guid"));
                        carNaviModel.getPBData().setDuration(item.optInt("duration"));
                        carNaviModel.getPBData().setDistance(item.optInt("distance"));
                        carNaviModel.getPBData().setMaxSpeed(item.optDouble("max_speed"));
                        carNaviModel.getPBData().setAvgSpeed(item.optDouble("speed"));
                        carNaviModel.getPBData().setType(DataBaseConstants.TYPE_CAR);
                        carNaviModel.getPBData().setCtime(item.optInt("start_time"));
                        String name = item.optString("name");
                        String startEndCoords = item.optString("start_end_coords");
                        NaviPoint startPoint = new NaviPoint();
                        NaviPoint endPoint = new NaviPoint();
                        if (!TextUtils.isEmpty(name)) {
                            split = name.split(JNISearchConst.LAYER_ID_DIVIDER, 2);
                            if (split != null && split.length == 2) {
                                startPoint.setAddr(split[0]);
                                endPoint.setAddr(split[1]);
                            }
                        }
                        if (!TextUtils.isEmpty(startEndCoords)) {
                            split = startEndCoords.split(JNISearchConst.LAYER_ID_DIVIDER, 2);
                            if (split != null && split.length == 2) {
                                String start = split[0];
                                String end = split[1];
                                String[] startCoords = start.split(",", 2);
                                String[] endCoords = end.split(",", 2);
                                if (startCoords != null) {
                                    try {
                                        if (startCoords.length == 2) {
                                            startPoint.setLng(Double.valueOf(startCoords[0]).doubleValue());
                                            startPoint.setLat(Double.valueOf(startCoords[1]).doubleValue());
                                        }
                                    } catch (NumberFormatException e) {
                                    }
                                }
                                if (endCoords != null && endCoords.length == 2) {
                                    endPoint.setLng(Double.valueOf(endCoords[0]).doubleValue());
                                    endPoint.setLat(Double.valueOf(endCoords[1]).doubleValue());
                                }
                            }
                        }
                        carNaviModel.getPBData().setStartPoint(startPoint);
                        carNaviModel.getPBData().setEndPoint(endPoint);
                        model.dataList.add(carNaviModel);
                    }
                }
            }
        }
        return model;
    }

    public String toString() {
        return "TrackSyncResponseModel[ lastver=" + this.lastver + ", trackAcmp=" + this.trackAcmp + ", isResponse=" + this.isResponse + ", dataList=" + this.dataList + ", guidList=" + this.guidList + " ]";
    }
}
