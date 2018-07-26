package com.baidu.platform.comjni.map.commonmemcache;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.track.database.DataService;
import com.baidu.platform.comjni.C2913c;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class NACommonMemCache extends C2913c {
    private static native long nativeCreate();

    private static native String nativeDecodeUsync(long j, String str);

    private static native String nativeEnCrypt(long j, String str);

    private static native String nativeEnCryptWithType(long j, String str, String str2);

    private static native String nativeEnCryptWithUsync(long j, String str);

    private static native String nativeGetPhoneInfoBundle(long j, boolean z);

    private static native String nativeGetPhoneInfoUrl(long j);

    private static native String nativeGetSataInfo(long j, boolean z, int i, int i2);

    private static native void nativeInit(long j, String str);

    private static native int nativeRelease(long j);

    private static native void nativeSetKeyBundle(long j, String str, String str2);

    private static native void nativeSetKeyDouble(long j, String str, double d);

    private static native void nativeSetKeyFloat(long j, String str, float f);

    private static native void nativeSetKeyInt(long j, String str, int i);

    private static native void nativeSetKeyString(long j, String str, String str2);

    public NACommonMemCache() {
        create();
    }

    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public int dispose() {
        if (this.mNativePointer == 0) {
            return 0;
        }
        int ret = nativeRelease(this.mNativePointer);
        this.mNativePointer = 0;
        return ret;
    }

    public void init(String json) {
        nativeInit(this.mNativePointer, json);
    }

    public void setKey(String strkey, int nValue) {
        nativeSetKeyInt(this.mNativePointer, strkey, nValue);
    }

    public void setKey(String strkey, String strValue) {
        nativeSetKeyString(this.mNativePointer, strkey, strValue);
    }

    public void setKey(String strkey, float fValue) {
        nativeSetKeyFloat(this.mNativePointer, strkey, fValue);
    }

    public void setKey(String strkey, double dValue) {
        nativeSetKeyDouble(this.mNativePointer, strkey, dValue);
    }

    public void setKeyJSON(String key, String json) {
        nativeSetKeyBundle(this.mNativePointer, key, json);
    }

    public String getPhoneInfoUrl() {
        return nativeGetPhoneInfoUrl(this.mNativePointer);
    }

    public Bundle getPhoneInfoBundle(boolean isUrlEncode) {
        String bundleStr = nativeGetPhoneInfoBundle(this.mNativePointer, isUrlEncode);
        Bundle bundle = new Bundle();
        if (!(bundleStr == null || bundleStr.isEmpty())) {
            try {
                JSONObject jsonObject = new JSONObject(bundleStr);
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    if (isUrlEncode || !DataService.EXTRA_BDUID.equals(key)) {
                        bundle.putString(key, jsonObject.optString(key));
                    } else {
                        String val = jsonObject.optString(key);
                        if (TextUtils.isEmpty(val)) {
                            bundle.putString(key, jsonObject.optString(key));
                        } else {
                            bundle.putString(key, enCrypt(val, DataService.EXTRA_BDUID));
                        }
                    }
                }
            } catch (JSONException e) {
            }
        }
        return bundle;
    }

    public String getSataInfo(boolean bValidLocation, int ptX, int ptY) {
        return nativeGetSataInfo(this.mNativePointer, bValidLocation, ptX, ptY);
    }

    public String enCrypt(String param) {
        return nativeEnCrypt(this.mNativePointer, param);
    }

    public String enCrypt(String param, String type) {
        if (TextUtils.isEmpty(type)) {
            type = DataService.EXTRA_BDUID;
        }
        Object obj = -1;
        switch (type.hashCode()) {
            case 93599950:
                if (type.equals(DataService.EXTRA_BDUID)) {
                    obj = null;
                    break;
                }
                break;
            case 109441797:
                if (type.equals("sinan")) {
                    obj = 1;
                    break;
                }
                break;
            case 111597712:
                if (type.equals("usync")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
                return nativeEnCryptWithType(this.mNativePointer, param, type);
            case 2:
                return nativeEnCryptWithUsync(this.mNativePointer, param);
            default:
                return nativeEnCryptWithType(this.mNativePointer, param, DataService.EXTRA_BDUID);
        }
    }

    public String decodeUsync(String param) {
        if (TextUtils.isEmpty(param)) {
            return "";
        }
        return nativeDecodeUsync(this.mNativePointer, param);
    }
}
