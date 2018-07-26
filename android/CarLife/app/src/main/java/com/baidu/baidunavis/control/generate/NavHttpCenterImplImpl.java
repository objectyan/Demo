package com.baidu.baidunavis.control.generate;

import android.net.Uri;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.baidu.baidunavis.control.NavHttpCenterImpl;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import com.baidu.mapframework.nirvana.runtime.http.BMRetrofit;
import com.baidu.mapframework.nirvana.runtime.http.URLEncodeUtils;
import java.io.File;
import java.util.HashMap;
import org.apache.http.client.CookieStore;

@Keep
public final class NavHttpCenterImplImpl implements NavHttpCenterImpl {
    private BMRetrofit mRetrofit;

    private static final class HOLDER {
        static final NavHttpCenterImpl INSTANCE = new NavHttpCenterImplImpl();

        private HOLDER() {
        }
    }

    private NavHttpCenterImplImpl() {
        this.mRetrofit = new BMRetrofit();
    }

    public static NavHttpCenterImpl getInstance() {
        return HOLDER.INSTANCE;
    }

    public void get(boolean isSync, String url, HashMap<String, String> getMethodParams, CookieStore cookieStore, NirvanaResponseHandlerInterface handler) {
        HashMap<String, String> _urlParams = new HashMap();
        if (getMethodParams != null) {
            _urlParams.putAll(getMethodParams);
        }
        this.mRetrofit.build().setCookieStore(cookieStore);
        if (_urlParams != null) {
            StringBuilder _urlBuilder = new StringBuilder(url);
            if (!url.contains("?")) {
                _urlBuilder.append("?");
            } else if (!TextUtils.isEmpty(Uri.parse(url).getQuery())) {
                _urlBuilder.append("&");
            }
            _urlBuilder.append(URLEncodeUtils.getUrlQueryString(_urlParams, UrlEncodeType.JAVA));
            url = _urlBuilder.toString();
        }
        this.mRetrofit.build().getRequest(isSync, url, null, _urlParams, handler);
    }

    public void uploadFile(boolean isSync, String url, HashMap<String, String> postMethodParams, HashMap<String, File> postFileMap, CookieStore cookieStore, NirvanaResponseHandlerInterface handler) {
        HashMap<String, String> _postParams = new HashMap();
        if (postMethodParams != null) {
            _postParams.putAll(postMethodParams);
        }
        HashMap<String, File> _fileParams = new HashMap();
        if (postFileMap != null) {
            _fileParams.putAll(postFileMap);
        }
        this.mRetrofit.build().setCookieStore(cookieStore);
        this.mRetrofit.build().postRequest(isSync, url, null, _postParams, _fileParams, null, handler);
    }
}
