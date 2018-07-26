package com.baidu.navisdk.util.common;

import com.baidu.nplatform.comjni.tools.JNITools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
    public static final int DEFAULT_PROXY_PORT = 80;
    public static final int HTTP_OK_CODE = 202;
    public static final String http = "http://";
    public static final String https = "https://";

    public static String buildParamListInHttpRequest(List<NameValuePair> params) {
        StringBuffer sb = new StringBuffer();
        for (int index = 0; index < params.size(); index++) {
            sb.append(((NameValuePair) params.get(index)).getName());
            sb.append("=");
            sb.append(((NameValuePair) params.get(index)).getValue());
            if (index < params.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static String buildParamListInHttpRequestUrlEncode(List<NameValuePair> params) {
        StringBuffer sb = new StringBuffer();
        for (int index = 0; index < params.size(); index++) {
            try {
                sb.append(URLEncoder.encode(((NameValuePair) params.get(index)).getName(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            sb.append("=");
            try {
                sb.append(URLEncoder.encode(((NameValuePair) params.get(index)).getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            } catch (Exception e22) {
                e22.printStackTrace();
            }
            if (index < params.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static boolean isHttp(String s) {
        if (s == null) {
            return false;
        }
        return s.startsWith("http://");
    }

    public static boolean isHttps(String s) {
        if (s == null) {
            return false;
        }
        return s.startsWith("https://");
    }

    public static int safePositiveInteger(String intValue) {
        try {
            int value = Integer.parseInt(intValue);
            if (value < 0) {
                return 0;
            }
            return value;
        } catch (NumberFormatException e) {
            LogUtil.m15791e("", e.toString());
            return 0;
        }
    }

    public static Date strToDate(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str);
    }

    public static long safePositiveLong(String longValue) {
        try {
            long value = Long.parseLong(longValue);
            if (value < 0) {
                return 0;
            }
            return value;
        } catch (NumberFormatException e) {
            LogUtil.m15791e("", e.toString());
            return 0;
        }
    }

    public static String filterXmlTags(String strVal, List<String> tagList) {
        String newVal = strVal;
        if (tagList != null) {
            for (String tag : tagList) {
                String startTag = "<" + tag + ">";
                newVal = newVal.replaceAll(startTag, "").replaceAll("</" + tag + ">", "");
            }
        }
        return newVal;
    }

    public static String getContent(HttpResponse response) throws IOException {
        if (response == null) {
            return null;
        }
        boolean isGzip = false;
        Header[] headers = response.getHeaders("Content-Encoding");
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (header.getValue().toLowerCase().indexOf("gzip") > -1) {
                    isGzip = true;
                    break;
                }
            }
            if (isGzip) {
                InputStream is = response.getEntity().getContent();
                GZIPInputStream gis = new GZIPInputStream(is);
                BufferedReader br = new BufferedReader(new InputStreamReader(gis));
                StringBuffer sb = new StringBuffer();
                while (true) {
                    String line = br.readLine();
                    if (line != null) {
                        sb.append(line);
                    } else {
                        gis.close();
                        is.close();
                        return sb.toString();
                    }
                }
            }
        }
        return EntityUtils.toString(response.getEntity(), "uft-8");
    }

    public static String calcUrlSign(List<NameValuePair> params) {
        ArrayList<String> values = new ArrayList();
        for (int i = 0; i < params.size(); i++) {
            values.add(((NameValuePair) params.get(i)).getName());
            values.add(((NameValuePair) params.get(i)).getValue());
        }
        return JNITools.CalcUrlSign(values);
    }
}
