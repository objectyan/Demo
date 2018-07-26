package com.baidu.navi.utils.http;

import android.os.Build;
import com.baidu.navisdk.util.common.PackageUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class BaseParamBean {
    public int appvercode = PackageUtil.getVersionCode();
    public String channel = PackageUtil.getChannel();
    public String cuid = PackageUtil.getCuid();
    public String mobile = Build.MODEL;
    public String os = "android";

    public List<BasicNameValuePair> toValuePair() {
        List<BasicNameValuePair> valuePairs = new ArrayList(5);
        valuePairs.add(new BasicNameValuePair("os", this.os));
        valuePairs.add(new BasicNameValuePair("mobile", this.mobile));
        valuePairs.add(new BasicNameValuePair("cuid", this.cuid == null ? "" : this.cuid));
        valuePairs.add(new BasicNameValuePair("channel", this.channel));
        valuePairs.add(new BasicNameValuePair("appvercode", this.appvercode + ""));
        return valuePairs;
    }

    public List<BasicNameValuePair> toValuePairEncode() {
        List<BasicNameValuePair> valuePairs = new ArrayList(5);
        valuePairs.add(new BasicNameValuePair("os", this.os));
        try {
            String str;
            valuePairs.add(new BasicNameValuePair("mobile", URLEncoder.encode(this.mobile, "utf-8")));
            String str2 = "cuid";
            if (this.cuid == null) {
                str = "";
            } else {
                str = URLEncoder.encode(this.cuid, "utf-8");
            }
            valuePairs.add(new BasicNameValuePair(str2, str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        valuePairs.add(new BasicNameValuePair("channel", this.channel));
        valuePairs.add(new BasicNameValuePair("appvercode", this.appvercode + ""));
        return valuePairs;
    }
}
