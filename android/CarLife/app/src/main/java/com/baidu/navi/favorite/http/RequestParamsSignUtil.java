package com.baidu.navi.favorite.http;

import com.baidu.carlife.util.C2180k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.NameValuePair;

public class RequestParamsSignUtil {
    private static final String URL_AND = "&";
    private static final String URL_EQUAL = "=";

    public static String calcUrlSign(List<NameValuePair> params) {
        StringBuffer sb = new StringBuffer("");
        try {
            for (NameValuePair pair : params) {
                String value = URLEncoder.encode(pair.getValue() == null ? "" : pair.getValue(), "UTF-8");
                if (value.contains("+")) {
                    value = value.replaceAll("\\+", "%20");
                }
                if (pair.getValue().contains("~")) {
                    value = value.replaceAll("%7E", "~");
                }
                sb.append(pair.getName()).append(URL_EQUAL).append(value).append(URL_AND);
            }
        } catch (UnsupportedEncodingException e) {
        }
        sb.deleteCharAt(sb.length() - 1).append("862e9198279d4c1b980b8eb394f82ae7");
        return C2180k.a(sb.toString()).toLowerCase();
    }
}
