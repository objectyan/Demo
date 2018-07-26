package com.baidu.baidunavis.control;

import android.support.annotation.Keep;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import java.io.File;
import java.util.HashMap;
import org.apache.http.client.CookieStore;

@Keep
public interface NavHttpCenterImpl {
    void get(boolean z, String str, HashMap<String, String> hashMap, CookieStore cookieStore, NirvanaResponseHandlerInterface nirvanaResponseHandlerInterface);

    void uploadFile(boolean z, String str, HashMap<String, String> hashMap, HashMap<String, File> hashMap2, CookieStore cookieStore, NirvanaResponseHandlerInterface nirvanaResponseHandlerInterface);
}
