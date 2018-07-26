package com.baidu.tts.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p233f.C5086d;
import com.baidu.tts.p233f.C5097n;
import java.io.UnsupportedEncodingException;

public class ResourceTools {
    public static final int TEXT_LENGTH_LIMIT = 1024;

    public static String getAppFilesPath(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir + "/files/";
        } catch (Exception e) {
            return context.getFilesDir().getAbsolutePath() + "/";
        }
    }

    public static String getModelFileAbsName(Context context, String name) {
        return FileTools.jointPathAndName(getAppFilesPath(context) + "modelDir/", name);
    }

    public static String getByteMapAbsName(Context context, String datName) {
        return getModelFileAbsName(context, datName + ".bm");
    }

    public static String getAppFilesDirPath(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/";
    }

    @SuppressLint({"SdCardPath"})
    public static String getSdcardFilesDirPath(Context context) {
        return "/sdcard/tts/";
    }

    public static String getDefaultResourcePath(Context context, String fileName) {
        return getSdcardFilesDirPath(context) + fileName;
    }

    public static C5146i format(String oldFormat, String newFormat, C5146i textParams) {
        try {
            textParams.m17439b(new String(textParams.m17440c().getBytes(oldFormat), newFormat));
            textParams.m17441c(newFormat);
            return textParams;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static C5097n isTextValid(String text) {
        if (TextUtils.isEmpty(text)) {
            return C5097n.TEXT_IS_EMPTY;
        }
        try {
            if (text.getBytes(C5086d.GBK.m17269a()).length > 1024) {
                return C5097n.TEXT_IS_TOO_LONG;
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            return C5097n.TEXT_ENCODE_IS_WRONG;
        }
    }

    public static byte[] stringToByteArrayAddNull(String string) {
        if (string == null) {
            string = "";
        }
        Object bytes = string.getBytes();
        Object obj = new byte[]{null};
        Object obj2 = new byte[(bytes.length + 1)];
        System.arraycopy(bytes, 0, obj2, 0, bytes.length);
        System.arraycopy(obj, 0, obj2, bytes.length, obj.length);
        return obj2;
    }
}
