package com.baidu.baidunavis.control;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.network.asynchttp.NirvanaBinaryHttpResponseHandler;
import com.baidu.mapframework.nirvana.network.asynchttp.NirvanaFileAsyncHttpResponseHandler;
import com.baidu.mapframework.nirvana.network.asynchttp.NirvanaTextHttpResponseHandler;
import com.baidu.mapframework.nirvana.runtime.http.HttpProxy;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.center.BNHttpBinaryResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpFileResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.http.center.IBNHttpResponseHandler;
import com.baidu.platform.comapi.p208c.C4762a;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

public class NavHttpCenter implements IBNHttpCenter {
    private static final String TAG = NavHttpCenter.class.getSimpleName();
    private ScheduleConfig config = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
    private CookieStore cookieStore = null;
    private Module module = Module.NAV_MODULE;

    private CookieStore getCookieStore(String url) {
        if (NavMapAdapter.getInstance().getBduss() == null) {
            return null;
        }
        BasicClientCookie cookie = new BasicClientCookie("BDUSS", NavMapAdapter.getInstance().getBduss());
        CookieStore cookieStore = new BasicCookieStore();
        cookie.setDomain(".baidu.com");
        cookie.setPath("/");
        cookie.setVersion(0);
        cookieStore.addCookie(cookie);
        if (url == null || url.length() <= 0) {
            return cookieStore;
        }
        String ip = C4762a.a().getIP(URI.create(url).getHost());
        if (ip == null || ip.length() <= 0) {
            return cookieStore;
        }
        BasicClientCookie cookie2 = new BasicClientCookie("BDUSS", NavMapAdapter.getInstance().getBduss());
        cookie2.setDomain(ip);
        cookie2.setPath("/");
        cookie2.setVersion(0);
        cookieStore.addCookie(cookie2);
        return cookieStore;
    }

    public void get(String url, HashMap<String, String> getMethodarams, IBNHttpResponseHandler handler, BNHttpParams moreParams) {
        LogUtil.e(TAG, "get() url=" + url);
        BNHttpParams tmpParams = moreParams;
        if (tmpParams == null) {
            tmpParams = new BNHttpParams();
        }
        if (handler instanceof BNHttpTextResponseHandler) {
            final String str = url;
            final IBNHttpResponseHandler iBNHttpResponseHandler = handler;
            ((NavHttpCenterImpl) HttpProxy.getDefault().create(NavHttpCenterImpl.class)).get(!tmpParams.isAsync, url, getMethodarams, getCookieStore(url), new NirvanaTextHttpResponseHandler(this.module, this.config) {
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(NavHttpCenter.TAG, "get.text.onFailure() url=" + str + ", statusCode=" + statusCode + ", responseString=" + responseString);
                    }
                    if (iBNHttpResponseHandler != null) {
                        ((BNHttpTextResponseHandler) iBNHttpResponseHandler).onFailure(statusCode, responseString, throwable);
                    }
                }

                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(NavHttpCenter.TAG, "get.text.onSuccess() url=" + str + ", statusCode=" + statusCode + ", responseString=" + responseString);
                    }
                    if (iBNHttpResponseHandler != null) {
                        ((BNHttpTextResponseHandler) iBNHttpResponseHandler).onSuccess(statusCode, responseString);
                    }
                }
            });
        } else if (handler instanceof BNHttpFileResponseHandler) {
            boolean z;
            NavHttpCenterImpl navHttpCenterImpl = (NavHttpCenterImpl) HttpProxy.getDefault().create(NavHttpCenterImpl.class);
            if (tmpParams.isAsync) {
                z = false;
            } else {
                z = true;
            }
            r5 = url;
            r6 = handler;
            navHttpCenterImpl.get(z, url, getMethodarams, getCookieStore(url), new NirvanaFileAsyncHttpResponseHandler(this.module, this.config, NavCommonFuncModel.getInstance().getActivity()) {
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(NavHttpCenter.TAG, "get.file.onFailure() url=" + r5 + ", statusCode=" + statusCode + "， throwable=" + throwable.getMessage());
                        throwable.printStackTrace();
                    }
                    if (r6 != null) {
                        ((BNHttpFileResponseHandler) r6).onFailure(statusCode, throwable, file);
                    }
                }

                public void onSuccess(int statusCode, Header[] headers, File file) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(NavHttpCenter.TAG, "get.file.onSuccess() url=" + r5 + ", statusCode=" + statusCode);
                    }
                    if (r6 != null) {
                        ((BNHttpFileResponseHandler) r6).onSuccess(statusCode, file);
                    }
                }
            });
        } else if (handler instanceof BNHttpBinaryResponseHandler) {
            r5 = url;
            r6 = handler;
            ((NavHttpCenterImpl) HttpProxy.getDefault().create(NavHttpCenterImpl.class)).get(!tmpParams.isAsync, url, getMethodarams, getCookieStore(url), new NirvanaBinaryHttpResponseHandler(this.module, this.config, new String[]{"text/plain", "application/octet-stream", "image/jpeg", "image/png", "image/gif", "application/octet-stream".concat(";charset=utf-8"), "image/jpeg;charset=utf-8", "image/png;charset=utf-8", "image/gif;charset=utf-8"}) {
                public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(NavHttpCenter.TAG, "get.binary.onSuccess() url=" + r5 + ", statusCode=" + statusCode);
                    }
                    if (r6 != null) {
                        ((BNHttpBinaryResponseHandler) r6).onSuccess(statusCode, binaryData);
                    }
                }

                public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(NavHttpCenter.TAG, "get.binary.onFailure() url=" + r5 + ", statusCode=" + statusCode + "， error=" + error.getMessage());
                        error.printStackTrace();
                    }
                    if (r6 != null) {
                        ((BNHttpBinaryResponseHandler) r6).onFailure(statusCode, binaryData, error);
                    }
                }
            });
        }
    }

    public void post(String url, HashMap<String, String> postMethodParams, IBNHttpResponseHandler handler, BNHttpParams moreParams) {
        LogUtil.e("NavHttpCenter", "post() url=" + url);
        BNHttpParams tmpParams = moreParams;
        if (tmpParams == null) {
            tmpParams = new BNHttpParams();
        }
        HashMap<String, File> fileMap = null;
        if (tmpParams.postFileMap != null) {
            fileMap = tmpParams.postFileMap;
        } else if (!(tmpParams.fileKey == null || tmpParams.file == null)) {
            fileMap = new HashMap();
            fileMap.put(tmpParams.fileKey, tmpParams.file);
        }
        if (handler instanceof BNHttpTextResponseHandler) {
            final String str = url;
            final IBNHttpResponseHandler iBNHttpResponseHandler = handler;
            ((NavHttpCenterImpl) HttpProxy.getDefault().create(NavHttpCenterImpl.class)).uploadFile(!tmpParams.isAsync, url, postMethodParams, fileMap, getCookieStore(url), new NirvanaTextHttpResponseHandler(this.module, this.config) {
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(NavHttpCenter.TAG, "post.text.onFailure() url=" + str + ", statusCode=" + statusCode + ", responseString=" + responseString);
                    }
                    if (iBNHttpResponseHandler != null) {
                        ((BNHttpTextResponseHandler) iBNHttpResponseHandler).onFailure(statusCode, responseString, throwable);
                    }
                }

                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(NavHttpCenter.TAG, "post.text.onSuccess() url=" + str + ", statusCode=" + statusCode + ", responseString=" + responseString);
                    }
                    if (iBNHttpResponseHandler != null) {
                        ((BNHttpTextResponseHandler) iBNHttpResponseHandler).onSuccess(statusCode, responseString);
                    }
                }
            });
        }
    }
}
