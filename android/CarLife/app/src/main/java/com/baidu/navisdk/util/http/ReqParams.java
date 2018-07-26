package com.baidu.navisdk.util.http;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicNameValuePair;

public class ReqParams {
    private static String ENCODING = "UTF-8";
    private MultipartEntity mMultipartEntity;
    private List<NameValuePair> mNameValuePairs;
    private ParamsType mType;

    enum ParamsType {
        SIMPLE,
        MUTILPART
    }

    public ReqParams(ParamsType paramsType) {
        init(paramsType);
    }

    public ReqParams() {
        init(ParamsType.SIMPLE);
    }

    public List<NameValuePair> getNamePairList() {
        return this.mNameValuePairs;
    }

    private void init(ParamsType type) {
        this.mType = type;
        switch (this.mType) {
            case SIMPLE:
                this.mNameValuePairs = new ArrayList();
                return;
            case MUTILPART:
                this.mMultipartEntity = new MultipartEntity();
                return;
            default:
                return;
        }
    }

    public ReqParams putSimpleValue(String name, String value) {
        if (!(TextUtils.isEmpty(name) || TextUtils.isEmpty(value) || this.mNameValuePairs == null)) {
            this.mNameValuePairs.add(new BasicNameValuePair(name, value));
        }
        return this;
    }

    public ReqParams putMutilPart(String name, String value) {
        if (!(TextUtils.isEmpty(name) || TextUtils.isEmpty(value) || this.mMultipartEntity == null)) {
            try {
                this.mMultipartEntity.addPart(name, new StringBody(value, Charset.forName(ENCODING)));
            } catch (UnsupportedEncodingException e) {
            }
        }
        return this;
    }

    public ReqParams putSimpleValue(List<BasicNameValuePair> nameValuePairs) {
        if (!(nameValuePairs == null || this.mNameValuePairs == null)) {
            this.mNameValuePairs.addAll(nameValuePairs);
        }
        return this;
    }

    public String convertToString() {
        if (this.mNameValuePairs == null) {
            return null;
        }
        return URLEncodedUtils.format(this.mNameValuePairs, ENCODING);
    }

    public String buildQueryUrl(String url) {
        if (TextUtils.isEmpty(url) || this.mNameValuePairs == null) {
            return null;
        }
        String paramString = convertToString();
        if (url.endsWith("?")) {
            url = url + "&" + paramString;
        } else {
            url = url + "?" + paramString;
        }
        return url;
    }

    private HttpEntity convertToSimpleEntity() {
        if (this.mNameValuePairs == null) {
            return null;
        }
        try {
            return new UrlEncodedFormEntity(this.mNameValuePairs, ENCODING);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private HttpEntity convertToMutilEntity() {
        return this.mMultipartEntity;
    }

    public HttpEntity getEntity() {
        if (this.mType == ParamsType.SIMPLE) {
            return convertToSimpleEntity();
        }
        if (this.mType == ParamsType.MUTILPART) {
            return convertToMutilEntity();
        }
        return null;
    }
}
