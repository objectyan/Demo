package com.baidu.navisdk.logic.commandparser;

import android.os.Handler;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostFunc.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CmdDebugModeGetURL {
    public static String errorMsg;
    public static List<DebugModeMessageBean> mGuideMsg = new ArrayList();

    /* renamed from: com.baidu.navisdk.logic.commandparser.CmdDebugModeGetURL$1 */
    static class C41371 implements Callback {
        C41371() {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            return CmdDebugModeGetURL.parseJSON(jsonObj);
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_DEBUG_MODE_GET_URL);
        }

        public List<NameValuePair> getRequestParams() {
            try {
                StringBuffer sb = new StringBuffer();
                List<NameValuePair> params = new ArrayList();
                String tmpTime = String.valueOf(System.currentTimeMillis());
                params.add(new BasicNameValuePair(Config.EXCEPTION_CRASH_TYPE, tmpTime));
                sb.append("ct=");
                sb.append(URLEncoder.encode(tmpTime, "utf-8"));
                params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
                sb.append("&cuid=");
                sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
                params.add(new BasicNameValuePair("mb", PackageUtil.strPhoneType));
                sb.append("&mb=");
                sb.append(URLEncoder.encode(PackageUtil.strPhoneType, "utf-8"));
                params.add(new BasicNameValuePair("os", "0"));
                sb.append("&os=");
                sb.append(URLEncoder.encode("0", "utf-8"));
                params.add(new BasicNameValuePair("p", "1"));
                sb.append("&p=");
                sb.append(URLEncoder.encode("1", "utf-8"));
                params.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
                sb.append("&sv=");
                sb.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
                LogUtil.m15791e("wangyang", "getRequestParams()=" + sb.toString());
                params.add(new BasicNameValuePair("sign", MD5.toMD5("emode" + sb.toString() + "093ca827bf3645b106fb26246bcdb43f").toLowerCase()));
                return params;
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }

        public int getRequestType() {
            return 1;
        }

        public void responseImage(byte[] img) {
        }
    }

    public static boolean requestDebugModeUrl(Handler mhander) {
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC, 7, mhander, CommandConst.K_MSG_GENERAL_HTTP_DEBUG_MODE_GET_URL_EXEC, 10000);
        CmdGeneralHttpPostFunc.addFunc(reqdata, new C41371());
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    private static boolean parseJSON(JSONObject jsonObj) {
        if (jsonObj == null) {
            return false;
        }
        LogUtil.m15791e("wangyang", "parselightJSON json=" + jsonObj.toString());
        try {
            int errno = jsonObj.getInt(C2125n.f6745M);
            errorMsg = jsonObj.getString(C2125n.f6746N);
            if (errno != 0) {
                return false;
            }
            JSONArray msgSceneList = jsonObj.getJSONObject("data").getJSONArray("scene_list");
            if (mGuideMsg != null) {
                mGuideMsg.clear();
                for (int i = 0; i < msgSceneList.length(); i++) {
                    JSONObject msgSceneTmp = msgSceneList.getJSONObject(i);
                    DebugModeMessageBean mBean = new DebugModeMessageBean();
                    mBean.mId = msgSceneTmp.getInt("id");
                    mBean.mSceneName = msgSceneTmp.getString("scene_name");
                    JSONArray msgSerListTmp = msgSceneTmp.getJSONArray("serlist");
                    for (int j = 0; j < msgSerListTmp.length(); j++) {
                        JSONObject msgSerTmp = msgSerListTmp.getJSONObject(j);
                        DebugModeMessageSerBean serBean = new DebugModeMessageSerBean();
                        String key = msgSerTmp.getString("key");
                        if (key != null) {
                            if (key.startsWith("0")) {
                                serBean.type = 0;
                            } else {
                                serBean.type = 1;
                            }
                            serBean.key = msgSerTmp.getString("key").substring(2, key.length());
                            serBean.value = msgSerTmp.getString("host");
                            if (serBean.key.equals(ULRParam.URL_INIT_CLOUD_CONFIG)) {
                                serBean.flag = BNSettingManager.getInitCloudCfg();
                            }
                            mBean.serList.add(serBean);
                        }
                    }
                    mGuideMsg.add(mBean);
                }
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
