package com.baidu.navi.driveanalysis.network;

import android.text.TextUtils;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.p054k.p055a.C1618b;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1622d.C1621a;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.util.C2180k;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.json.JSONException;

public class FileUploadRequest extends C1626e {
    private final String SIGN_KEY = "bd44977f4225b957923ddefa781e8f93";
    private final String SIGN_KEY_ID = "sign";
    private final String SIGN_PREFIX = "navi";
    private String URL = null;
    private final String URL_AND = "&";
    private final String URL_DEBUG = "http://cq01-rdqa-dev018.cq01.baidu.com:8080/carlife/orbitpost";
    private final String URL_EQUAL = "=";
    private final String URL_RELEASE = "https://vehicle.baidu.com/carlife/orbitpost";
    private String mCuid;
    private String mFileName;
    private InputStream mInputStream;

    /* renamed from: com.baidu.navi.driveanalysis.network.FileUploadRequest$1 */
    class C37761 extends C1622d {
        C37761() {
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
                        multipartEntity.a(pair.getName(), FileUploadRequest.this.urlEncode(pair.getValue()));
                    }
                }
                C1260i.b(FileUploadRequest.this.tag, "the post params is:" + this.urlParams.toString());
                multipartEntity.a("sign", FileUploadRequest.this.calcUrlSign(this.urlParams));
            }
            if (!this.fileParams.isEmpty()) {
                int currentIndex = 0;
                int lastIndex = this.fileParams.entrySet().size() - 1;
                for (Entry<String, C1621a> entry : this.fileParams.entrySet()) {
                    C1621a file = (C1621a) entry.getValue();
                    if (file.f4959a != null) {
                        boolean isLast = currentIndex == lastIndex;
                        if (file.f4961c != null) {
                            multipartEntity.a((String) entry.getKey(), file.a(), file.f4959a, file.f4961c, isLast);
                        } else {
                            multipartEntity.a((String) entry.getKey(), file.a(), file.f4959a, isLast);
                        }
                        C1260i.b(FileUploadRequest.this.tag, "the post file is:" + file.a());
                    }
                    currentIndex++;
                }
            }
            return multipartEntity;
        }
    }

    public FileUploadRequest(String cuid, String fileName, InputStream in) {
        this.mCuid = cuid;
        this.mFileName = fileName;
        this.mInputStream = in;
        C1251e.a();
        if (C1251e.t()) {
            this.URL = "http://cq01-rdqa-dev018.cq01.baidu.com:8080/carlife/orbitpost";
        } else {
            this.URL = "https://vehicle.baidu.com/carlife/orbitpost";
        }
    }

    protected String getUrl() {
        return this.URL;
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C37761();
        params.put("entity_name", this.mCuid);
        params.put("point_list", this.mInputStream, this.mFileName);
        params.toSign();
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        return 0;
    }

    protected void responseErrorCallBack(int errorType) {
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
                if (!((String) entry.getKey()).equals("point_list")) {
                    sb.append((String) entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue() == null ? "" : (String) entry.getValue(), "UTF-8")).append("&");
                }
            }
        } catch (UnsupportedEncodingException e) {
        }
        sb.deleteCharAt(sb.length() - 1).append("bd44977f4225b957923ddefa781e8f93");
        return C2180k.a(sb.toString());
    }
}
