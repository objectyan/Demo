package com.baidu.navi.driveanalysis.network;

import android.text.TextUtils;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.p054k.p055a.C1618b;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.util.C2180k;
import com.baidu.navi.driveanalysis.model.TrackModel;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.json.JSONException;

public class EachMinuteRequest extends C1626e {
    private final String SIGN_KEY = "bd44977f4225b957923ddefa781e8f93";
    private final String SIGN_KEY_ID = "sign";
    private final String SIGN_PREFIX = "navi";
    private String URL = null;
    private final String URL_AND = "&";
    private final String URL_DEBUG = "http://cq01-rdqa-dev018.cq01.baidu.com:8080/carlife/orbitpostminute";
    private final String URL_EQUAL = "=";
    private final String URL_RELEASE = "https://vehicle.baidu.com/carlife/orbitpostminute";
    private List<TrackModel> mList;

    /* renamed from: com.baidu.navi.driveanalysis.network.EachMinuteRequest$1 */
    class C37751 extends C1622d {
        C37751() {
        }

        public HttpEntity getEntity() {
            C1618b multipartEntity = new C1618b();
            if (!this.urlParams.isEmpty()) {
                Iterator<NameValuePair> it = this.urlParams.iterator();
                while (it.hasNext()) {
                    NameValuePair pair = (NameValuePair) it.next();
                    if (TextUtils.isEmpty(pair.getName()) || TextUtils.isEmpty(pair.getValue())) {
                        it.remove();
                    } else {
                        multipartEntity.a(pair.getName(), EachMinuteRequest.this.urlEncode(pair.getValue()));
                    }
                }
                C1260i.b(EachMinuteRequest.this.tag, "the post params is:" + this.urlParams.toString());
                multipartEntity.a("sign", EachMinuteRequest.this.calcUrlSign(this.urlParams));
            }
            return multipartEntity;
        }
    }

    public EachMinuteRequest() {
        C1251e.a();
        if (C1251e.t()) {
            this.URL = "http://cq01-rdqa-dev018.cq01.baidu.com:8080/carlife/orbitpostminute";
        } else {
            this.URL = "https://vehicle.baidu.com/carlife/orbitpostminute";
        }
    }

    protected String getUrl() {
        return this.URL;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        return 0;
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C37751();
        boolean hasPutEntityName = false;
        int index = 0;
        for (TrackModel model : this.mList) {
            if (!hasPutEntityName) {
                params.put("entity_name", model.entityName);
                hasPutEntityName = true;
            }
            index++;
            params.put("coord" + index, "" + model.latitude + "," + model.longitude + "," + model.coordType + "," + model.speed + "," + model.direction + "," + model.height + "," + model.radius + "," + model.localTime + "," + model.isConnectWithVehicle);
        }
        params.toSign();
        return params;
    }

    private String urlEncode(String s) {
        String rst = null;
        try {
            rst = URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return rst;
    }

    private String calcUrlSign(List<NameValuePair> params) {
        TreeMap<String, String> treeMap = new TreeMap();
        for (NameValuePair pair : params) {
            treeMap.put(pair.getName(), pair.getValue());
        }
        StringBuffer sb = new StringBuffer("navi");
        try {
            for (Entry<String, String> entry : treeMap.entrySet()) {
                sb.append((String) entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue() == null ? "" : (String) entry.getValue(), "UTF-8")).append("&");
            }
        } catch (UnsupportedEncodingException e) {
        }
        sb.deleteCharAt(sb.length() - 1).append("bd44977f4225b957923ddefa781e8f93");
        return C2180k.a(sb.toString());
    }

    protected void responseErrorCallBack(int errorType) {
    }

    public void setParamsModel(List<TrackModel> list) {
        this.mList = list;
    }
}
