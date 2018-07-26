package com.baidu.navisdk.lightnavi.utils;

import android.os.Handler;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.lightnavi.model.LightNaviGuideBean;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
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

public class CmdLightNaviGetGuideInfo {
    public static String errorMsg;
    public static List<LightNaviGuideBean> mGuideMsg = new ArrayList();

    /* renamed from: com.baidu.navisdk.lightnavi.utils.CmdLightNaviGetGuideInfo$1 */
    static class C41071 implements Callback {
        C41071() {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            return CmdLightNaviGetGuideInfo.parseJSON(jsonObj);
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_IPO_GET_GUIDE_MSG);
        }

        public List<NameValuePair> getRequestParams() {
            try {
                StringBuffer sb = new StringBuffer();
                List<NameValuePair> params = new ArrayList();
                int cid = 0;
                if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
                    cid = GeoLocateModel.getInstance().getCurrentDistrict().mId;
                }
                params.add(new BasicNameValuePair(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYCODE, "" + cid));
                sb.append("cityCode=");
                sb.append(URLEncoder.encode("" + cid, "utf-8"));
                params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
                sb.append("&cuid=");
                sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
                params.add(new BasicNameValuePair("os", "0"));
                sb.append("&os=");
                sb.append(URLEncoder.encode("0", "utf-8"));
                params.add(new BasicNameValuePair("qtv", "1"));
                sb.append("&qtv=");
                sb.append(URLEncoder.encode("1", "utf-8"));
                params.add(new BasicNameValuePair("sid", "1"));
                sb.append("&sid=");
                sb.append(URLEncoder.encode("1", "utf-8"));
                params.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
                sb.append("&sv=");
                sb.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
                LogUtil.m15791e("wangyang", "getRequestParams()=" + sb.toString());
                params.add(new BasicNameValuePair("sign", MD5.toMD5("mop" + sb.toString() + "6456bc093ca827bf3db43fb106fb2624").toLowerCase()));
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

    public static boolean requestLightNaviInfo(Handler mhander) {
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, mhander, CommandConst.K_MSG_GENERAL_HTTP_IPO_GUIDE_EXEC, 10000);
        CmdGeneralHttpRequestFunc.addFunc(reqdata, new C41071());
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
            JSONArray msgList = jsonObj.getJSONArray("data");
            if (msgList != null) {
                mGuideMsg.clear();
                for (int i = 0; i < msgList.length(); i++) {
                    JSONObject tmp = msgList.getJSONObject(i);
                    LightNaviGuideBean mBean = new LightNaviGuideBean();
                    mBean.type = tmp.getInt("type");
                    if (mBean.type == 1) {
                        mBean.cityCode = tmp.getInt(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYCODE);
                        mBean.title = tmp.getString("title");
                        mBean.content = tmp.getString("content");
                        if (tmp.has("play")) {
                            boolean z;
                            if (tmp.getInt("play") == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            mBean.isPlay = z;
                        } else {
                            mBean.isPlay = true;
                        }
                        mGuideMsg.add(mBean);
                    }
                }
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
