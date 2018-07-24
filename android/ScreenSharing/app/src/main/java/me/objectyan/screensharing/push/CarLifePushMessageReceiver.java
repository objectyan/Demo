package com.baidu.carlife.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.sapi2.result.FillUserProfileResult;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CarLifePushMessageReceiver extends PushMessageReceiver {
    /* renamed from: a */
    public static final String f6676a = CarLifePushMessageReceiver.class.getSimpleName();

    public void onBind(Context context, int errorCode, String appid, String userId, String channelId, String requestId) {
        Log.d(f6676a, "onBind errorCode=" + errorCode + " appid=" + appid + " userId=" + userId + " channelId=" + channelId + " requestId=" + requestId);
        if (errorCode == 0) {
            Log.d(f6676a, FillUserProfileResult.RESULT_MSG_SUCCESS);
        }
    }

    public void onMessage(Context context, String message, String customContentString) {
        JSONException e;
        Log.d(f6676a, "透传消息 onMessage=\"" + message + "\" customContentString=" + customContentString);
        if (!TextUtils.isEmpty(customContentString)) {
            try {
                JSONObject customJson = new JSONObject(customContentString);
                try {
                    if (!customJson.isNull("mykey")) {
                        customJson.getString("mykey");
                    }
                } catch (JSONException e2) {
                    e = e2;
                    JSONObject jSONObject = customJson;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
            }
        }
    }

    public void onNotificationArrived(Context context, String title, String description, String customContentString) {
        JSONException e;
        Log.d(f6676a, "通知到达 onNotificationArrived  title=\"" + title + "\" description=\"" + description + "\" customContent=" + customContentString);
        if (!TextUtils.isEmpty(customContentString)) {
            try {
                JSONObject customJson = new JSONObject(customContentString);
                try {
                    if (!customJson.isNull("mykey")) {
                        customJson.getString("mykey");
                    }
                } catch (JSONException e2) {
                    e = e2;
                    JSONObject jSONObject = customJson;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
            }
        }
    }

    public void onNotificationClicked(Context context, String title, String description, String customContentString) {
        JSONException e;
        Log.d(f6676a, "通知点击 onNotificationClicked title=\"" + title + "\" description=\"" + description + "\" customContent=" + customContentString);
        if (!TextUtils.isEmpty(customContentString)) {
            try {
                JSONObject customJson = new JSONObject(customContentString);
                try {
                    if (!customJson.isNull("urlkey")) {
                        Object myvalue = customJson.getString("urlkey");
                        myvalue.replace("\\", "");
                        if (!myvalue.isEmpty()) {
                            C2103a.m7881a((String) myvalue);
                            MsgHandlerCenter.m4456a((int) CommonParams.fr, 0, 0, myvalue);
                            LogUtil.d(f6676a, "GetValue: " + myvalue);
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    JSONObject jSONObject = customJson;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
            }
        }
    }

    public void onSetTags(Context context, int errorCode, List<String> successTags, List<String> failTags, String requestId) {
        Log.d(f6676a, "onSetTags errorCode=" + errorCode + " successTags=" + successTags + " failTags=" + failTags + " requestId=" + requestId);
    }

    public void onDelTags(Context context, int errorCode, List<String> successTags, List<String> failTags, String requestId) {
        Log.d(f6676a, "onDelTags errorCode=" + errorCode + " successTags=" + successTags + " failTags=" + failTags + " requestId=" + requestId);
    }

    public void onListTags(Context context, int errorCode, List<String> tags, String requestId) {
        Log.d(f6676a, "onListTags errorCode=" + errorCode + " tags=" + tags);
    }

    public void onUnbind(Context context, int errorCode, String requestId) {
        Log.d(f6676a, "onUnbind errorCode=" + errorCode + " requestId = " + requestId);
        if (errorCode == 0) {
            Log.d(f6676a, "解绑成功");
        }
    }
}
