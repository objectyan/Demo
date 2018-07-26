package com.baidu.navi.track.http;

import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navi.track.database.DataBaseConstants;
import com.baidu.navi.track.model.TrackSyncRequestModel;
import com.baidu.navi.track.model.TrackSyncResponseModel;
import com.baidu.navi.track.sync.SyncChannelConstant.Value;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackSyncRequest extends C1626e {
    private String guid;
    private boolean hasGuid;
    private int isResponse;
    private TrackSyncRequestModel requestModel;
    private TrackSyncResponseModel responseModel;

    public TrackSyncRequest() {
        this.tag = TrackSyncRequest.class.getSimpleName();
    }

    public boolean hasGuid() {
        return this.hasGuid;
    }

    public String getGuid() {
        return this.guid;
    }

    public int isResponse() {
        return this.isResponse;
    }

    public TrackSyncResponseModel getResponseModel() {
        return this.responseModel;
    }

    public void setParamsModel(TrackSyncRequestModel model) {
        this.requestModel = model;
        this.guid = "";
        this.hasGuid = false;
        this.isResponse = 0;
        this.responseModel = null;
    }

    protected String getUrl() {
        return Value.TRACK_UPLOAD_URL;
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C1622d();
        params.put("actiontype", this.requestModel.actionType);
        params.put("bduss", this.requestModel.bduss);
        params.put("client_guids", this.requestModel.guidList);
        params.put("guid", this.requestModel.guid);
        params.put("is_response", this.requestModel.isResponse);
        params.put("uid", this.requestModel.uid);
        if ("1".equals(this.requestModel.actionType) || "2".equals(this.requestModel.actionType)) {
            params.put("appver", this.requestModel.appVer);
            params.put("cuid", this.requestModel.cuid);
            params.put("channel", this.requestModel.channel);
            params.put("distance", this.requestModel.distance);
            params.put("duration", this.requestModel.duration);
            params.put("data_version", this.requestModel.dataVersion);
            params.put("isconn", this.requestModel.isConn);
            params.put("osversion", this.requestModel.osVersion);
            params.put("os", this.requestModel.os);
            params.put("mb", this.requestModel.mb);
            params.put("mcuid", this.requestModel.mCuid);
            params.put(DataBaseConstants.TYPE_LOC, this.requestModel.loc);
            params.put("imei", this.requestModel.imei);
            params.put("max_speed", this.requestModel.maxSpeed);
            params.put("name", this.requestModel.name);
            params.put("start_time", this.requestModel.createTime);
            params.put("start_end_coords", this.requestModel.startPosition + JNISearchConst.LAYER_ID_DIVIDER + this.requestModel.endPosition);
            params.put("speed", this.requestModel.speed);
            params.put("type", this.requestModel.type);
            params.put("version", this.requestModel.version);
        }
        params.sortParams();
        params.toSign();
        return params;
    }

    protected int responseSuccessCallBack(String data) {
        try {
            JSONObject json = new JSONObject(data);
            switch (parseError(json)) {
                case 0:
                    JSONObject jsonObject = new JSONObject(data);
                    this.isResponse = jsonObject.optInt("is_response");
                    if (this.isResponse == 0) {
                        this.guid = jsonObject.optString("guid");
                        if (!TextUtils.isEmpty(this.guid)) {
                            this.hasGuid = true;
                            break;
                        }
                        return -1;
                    } else if (this.isResponse == 1) {
                        this.responseModel = TrackSyncResponseModel.parseJson(jsonObject);
                        break;
                    } else {
                        return -1;
                    }
                case 51:
                    return 51;
                case 53:
                    return 53;
                case 54:
                case 56:
                    this.guid = json.optString("data");
                    if (!TextUtils.isEmpty(this.guid)) {
                        this.hasGuid = true;
                        break;
                    }
                    return -1;
            }
            return 0;
        } catch (JSONException e) {
            return -1;
        }
    }

    private int parseError(JSONObject json) throws JSONException {
        int mErrNo = 0;
        if (json.has("code")) {
            mErrNo = json.getInt("code");
        } else if (json.has(C2125n.f6745M)) {
            mErrNo = json.getInt(C2125n.f6745M);
        } else if (json.has("status")) {
            mErrNo = json.getInt("status");
        }
        if (json.has(C2125n.f6746N)) {
            String string = json.getString(C2125n.f6746N);
        } else if (json.has(PushConstants.EXTRA_PUSH_MESSAGE)) {
            json.getString(PushConstants.EXTRA_PUSH_MESSAGE);
        }
        return mErrNo;
    }
}
