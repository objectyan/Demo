package com.baidu.speech.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.util.common.SystemAuth;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public final class DeviceId {
    private static final String ACTION_GLAXY_CUID = "com.baidu.intent.action.GALAXY";
    private static final String AES_KEY;
    private static final boolean DEBUG = false;
    private static final String DEFAULT_TM_DEVICEID = "";
    private static final String EXT_DIR = "backups/.SystemConfig";
    private static final String EXT_FILE = ".cuid";
    private static final String EXT_FILE_V2 = ".cuid2";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String KEY_DEVICE_ID_V2 = "com.baidu.deviceid.v2";
    private static final String KEY_IMEI = "bd_setting_i";
    private static final String META_KEY_GALAXY_SF = "galaxy_sf";
    private static final String META_KEY_GLAXY_DATA = "galaxy_data";
    private static final String OLD_EXT_DIR = "baidu";
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final int SDK_ANDROID_M = 23;
    private static final String SELF_CUID_FILE = "libcuid.so";
    private static final int STORAGE_SDCARD_V1 = 4;
    private static final int STORAGE_SDCARD_V2 = 8;
    private static final int STORAGE_SELF_FILE = 16;
    private static final int STORAGE_SYSTEM_SETTING_V1 = 1;
    private static final int STORAGE_SYSTEM_SETTING_V2 = 2;
    private static final String TAG = "DeviceId";
    private static CUIDInfo sCachedCuidInfo;
    private final Context mContext;
    private PublicKey mPublicKey;
    private int mSaveMask = 0;

    /* renamed from: com.baidu.speech.utils.DeviceId$1 */
    class C49481 implements Comparator<CUIDBuddyInfo> {
        C49481() {
        }

        public int compare(CUIDBuddyInfo cUIDBuddyInfo, CUIDBuddyInfo cUIDBuddyInfo2) {
            int i = cUIDBuddyInfo2.priority - cUIDBuddyInfo.priority;
            return i == 0 ? (cUIDBuddyInfo.isSelf && cUIDBuddyInfo2.isSelf) ? 0 : cUIDBuddyInfo.isSelf ? -1 : cUIDBuddyInfo2.isSelf ? 1 : i : i;
        }
    }

    private static class CUIDBuddyInfo {
        public ApplicationInfo appInfo;
        public boolean isSelf;
        public int priority;
        public boolean sigMatched;

        private CUIDBuddyInfo() {
            this.priority = 0;
            this.sigMatched = false;
            this.isSelf = false;
        }
    }

    private static class CUIDInfo {
        private static final int VERSION = 2;
        public String deviceId;
        public String imei;
        public int version;

        private CUIDInfo() {
            this.version = 2;
        }

        public static CUIDInfo createFromJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Object string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                int i = jSONObject.getInt("ver");
                if (TextUtils.isEmpty(string) || string2 == null) {
                    return null;
                }
                CUIDInfo cUIDInfo = new CUIDInfo();
                cUIDInfo.deviceId = string;
                cUIDInfo.imei = string2;
                cUIDInfo.version = i;
                return cUIDInfo;
            } catch (Throwable e) {
                DeviceId.handleThrowable(e);
                return null;
            }
        }

        public String getFinalCUID() {
            String str = this.imei;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.deviceId + "|" + new StringBuffer(str).reverse().toString();
        }

        public String toPersitString() {
            try {
                return new JSONObject().put("deviceid", this.deviceId).put("imei", this.imei).put("ver", this.version).toString();
            } catch (Throwable e) {
                DeviceId.handleThrowable(e);
                return null;
            }
        }
    }

    static {
        String str = new String(Base64.decode(new byte[]{(byte) 77, (byte) 122, (byte) 65, (byte) 121, (byte) 77, (byte) 84, (byte) 73, (byte) 120, (byte) 77, (byte) 68, (byte) 73, (byte) 61}));
        AES_KEY = str + new String(Base64.decode(new byte[]{(byte) 90, (byte) 71, (byte) 108, (byte) 106, (byte) 100, (byte) 87, (byte) 82, (byte) 112, (byte) 89, (byte) 87, (byte) 73, (byte) 61}));
    }

    private DeviceId(Context context) {
        this.mContext = context.getApplicationContext();
        initPublicKey();
    }

    private static String byte2hex(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            str = toHexString.length() == 1 ? str + "0" + toHexString : str + toHexString;
        }
        return str.toLowerCase();
    }

    private boolean checkSelfPermission(String str) {
        return this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private List<CUIDBuddyInfo> collectBuddyInfos(Intent intent, boolean z) {
        List<CUIDBuddyInfo> arrayList = new ArrayList();
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (!(resolveInfo.activityInfo == null || resolveInfo.activityInfo.applicationInfo == null)) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            Object string = bundle.getString(META_KEY_GLAXY_DATA);
                            if (!TextUtils.isEmpty(string)) {
                                byte[] decode = Base64.decode(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(decode));
                                CUIDBuddyInfo cUIDBuddyInfo = new CUIDBuddyInfo();
                                cUIDBuddyInfo.priority = jSONObject.getInt(LogFactory.PRIORITY_KEY);
                                cUIDBuddyInfo.appInfo = resolveInfo.activityInfo.applicationInfo;
                                if (this.mContext.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    cUIDBuddyInfo.isSelf = true;
                                }
                                if (z) {
                                    Object string2 = bundle.getString(META_KEY_GALAXY_SF);
                                    if (!TextUtils.isEmpty(string2)) {
                                        int i;
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (isSigsEqual(strArr, formatAndroidSigArray(packageInfo.signatures))) {
                                            byte[] decryptByPublicKey = decryptByPublicKey(Base64.decode(string2.getBytes()), this.mPublicKey);
                                            i = (decryptByPublicKey == null || !Arrays.equals(decryptByPublicKey, SHA1Util.sha1(decode))) ? 0 : 1;
                                            if (i != 0) {
                                                cUIDBuddyInfo.sigMatched = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(cUIDBuddyInfo);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new C49481());
        return arrayList;
    }

    private static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    private static String decryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(str.getBytes())));
        } catch (Throwable e) {
            handleThrowable(e);
            return "";
        }
    }

    private static String encryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, str.getBytes()), "utf-8");
        } catch (Throwable e) {
            handleThrowable(e);
            return "";
        } catch (Throwable e2) {
            handleThrowable(e2);
            return "";
        }
    }

    private String[] formatAndroidSigArray(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = byte2hex(SHA1Util.sha1(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    public static String getCUID(Context context) {
        return getOrCreateCUIDInfo(context).getFinalCUID();
    }

    private CUIDInfo getCUIDInfo() {
        boolean z;
        CUIDBuddyInfo cUIDBuddyInfo;
        boolean z2;
        String str;
        String str2;
        CUIDInfo cUIDInfo;
        CUIDInfo cUIDInfo2;
        String str3 = null;
        int i = 0;
        List collectBuddyInfos = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID).setPackage(this.mContext.getPackageName()), true);
        int i2;
        if (collectBuddyInfos == null || collectBuddyInfos.size() == 0) {
            for (i2 = 0; i2 < 3; i2++) {
                Log.w(TAG, "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            cUIDBuddyInfo = (CUIDBuddyInfo) collectBuddyInfos.get(0);
            z2 = cUIDBuddyInfo.sigMatched;
            if (!cUIDBuddyInfo.sigMatched) {
                for (i2 = 0; i2 < 3; i2++) {
                    Log.w(TAG, "galaxy config err, In the release version of the signature should be matched");
                }
            }
            z = z2;
        }
        File file = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
        CUIDInfo createFromJson = file.exists() ? CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file))) : null;
        if (createFromJson == null) {
            this.mSaveMask |= 16;
            List<CUIDBuddyInfo> collectBuddyInfos2 = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID), z);
            if (collectBuddyInfos2 != null) {
                str = "files";
                file = this.mContext.getFilesDir();
                if (str.equals(file.getName())) {
                    str2 = str;
                } else {
                    Log.e(TAG, "fetal error:: app files dir name is unexpectedly :: " + file.getAbsolutePath());
                    str2 = file.getName();
                }
                for (CUIDBuddyInfo cUIDBuddyInfo2 : collectBuddyInfos2) {
                    if (!cUIDBuddyInfo2.isSelf) {
                        File file2 = new File(new File(cUIDBuddyInfo2.appInfo.dataDir, str2), SELF_CUID_FILE);
                        if (file2.exists()) {
                            createFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file2)));
                            if (createFromJson != null) {
                                cUIDInfo = createFromJson;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    createFromJson = createFromJson;
                }
            }
        }
        cUIDInfo = createFromJson;
        if (cUIDInfo == null) {
            cUIDInfo = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue(KEY_DEVICE_ID_V2)));
        }
        if (cUIDInfo == null) {
            this.mSaveMask |= 2;
            cUIDInfo = getCuidInfoFromDataFileV2(this.mContext);
        }
        if (cUIDInfo == null) {
            this.mSaveMask |= 8;
            cUIDInfo = getCUidInfoFromSystemSettingV1();
        }
        if (cUIDInfo == null) {
            this.mSaveMask |= 1;
            str = getIntlMobEqIdFromSystem("");
            cUIDInfo = getDataFileV1DeviceId(this.mContext, str);
            i = 1;
        } else {
            str = null;
        }
        if (cUIDInfo == null) {
            this.mSaveMask |= 4;
            if (i == 0) {
                str = getIntlMobEqIdFromSystem("");
            }
            CUIDInfo cUIDInfo3 = new CUIDInfo();
            str2 = getDroidId(this.mContext);
            cUIDInfo3.deviceId = MD5Util.toMd5((VERSION.SDK_INT < 23 ? str + str2 + UUID.randomUUID().toString() : "com.baidu" + str2).getBytes(), true);
            cUIDInfo3.imei = str;
            cUIDInfo2 = cUIDInfo3;
        } else {
            cUIDInfo2 = cUIDInfo;
        }
        file = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
        if (!((this.mSaveMask & 16) == 0 && file.exists())) {
            str2 = TextUtils.isEmpty(null) ? encryptCUIDInfo(cUIDInfo2.toPersitString()) : null;
            writeToCuidFile(str2);
            str3 = str2;
        }
        z2 = hasWriteSettingsPermission();
        if (z2 && ((this.mSaveMask & 2) != 0 || TextUtils.isEmpty(getSystemSettingValue(KEY_DEVICE_ID_V2)))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = encryptCUIDInfo(cUIDInfo2.toPersitString());
            }
            tryPutSystemSettingValue(KEY_DEVICE_ID_V2, str3);
        }
        File file3 = new File(this.mContext.getFilesDir(), "backups/.SystemConfig/.cuid2");
        if (!((this.mSaveMask & 8) == 0 && file3.exists())) {
            if (TextUtils.isEmpty(str3)) {
                str3 = encryptCUIDInfo(cUIDInfo2.toPersitString());
            }
            setDataFileV2DeviceId(this.mContext, str3);
        }
        if (z2 && ((this.mSaveMask & 1) != 0 || TextUtils.isEmpty(getSystemSettingValue(KEY_DEVICE_ID)))) {
            tryPutSystemSettingValue(KEY_DEVICE_ID, cUIDInfo2.deviceId);
            tryPutSystemSettingValue(KEY_IMEI, cUIDInfo2.imei);
        }
        if (z2 && !TextUtils.isEmpty(cUIDInfo2.imei)) {
            file = new File(this.mContext.getFilesDir(), "backups/.SystemConfig/.cuid");
            if (!((this.mSaveMask & 2) == 0 && file.exists())) {
                setDataFileDeviceId(this.mContext, cUIDInfo2.imei, cUIDInfo2.deviceId);
            }
        }
        return cUIDInfo2;
    }

    private CUIDInfo getCUidInfoFromSystemSettingV1() {
        Object systemSettingValue = getSystemSettingValue(KEY_DEVICE_ID);
        String systemSettingValue2 = getSystemSettingValue(KEY_IMEI);
        if (TextUtils.isEmpty(systemSettingValue2)) {
            systemSettingValue2 = getIntlMobEqIdFromSystem("");
            if (!TextUtils.isEmpty(systemSettingValue2)) {
                tryPutSystemSettingValue(KEY_IMEI, systemSettingValue2);
            }
        }
        if (TextUtils.isEmpty(systemSettingValue)) {
            systemSettingValue = getSystemSettingValue(MD5Util.toMd5(("com.baidu" + systemSettingValue2 + getDroidId(this.mContext)).getBytes(), true));
        }
        if (TextUtils.isEmpty(systemSettingValue)) {
            return null;
        }
        CUIDInfo cUIDInfo = new CUIDInfo();
        cUIDInfo.deviceId = systemSettingValue;
        cUIDInfo.imei = systemSettingValue2;
        return cUIDInfo;
    }

    private CUIDInfo getCuidInfoFromDataFileV2(Context context) {
        File file = new File(context.getFilesDir(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            Object fileContent = getFileContent(file);
            if (!TextUtils.isEmpty(fileContent)) {
                try {
                    return CUIDInfo.createFromJson(new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(fileContent.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private CUIDInfo getDataFileV1DeviceId(Context context, String str) {
        Object obj = 1;
        Object obj2 = VERSION.SDK_INT < 23 ? 1 : null;
        if (obj2 != null && TextUtils.isEmpty(str)) {
            return null;
        }
        String str2;
        CUIDInfo cUIDInfo;
        Object obj3 = "";
        File file = new File(context.getFilesDir(), "baidu/.cuid");
        if (file.exists()) {
            obj = null;
        } else {
            file = new File(context.getFilesDir(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
                stringBuilder.append("\r\n");
            }
            bufferedReader.close();
            String[] split = new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(stringBuilder.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (obj2 != null && str.equals(split[0])) {
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        setDataFileDeviceId(context, str2, obj3);
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    cUIDInfo = new CUIDInfo();
                    cUIDInfo.deviceId = obj3;
                    cUIDInfo.imei = str2;
                    return cUIDInfo;
                } else if (obj2 == null) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        try {
                            setDataFileDeviceId(context, str2, obj3);
                        } catch (FileNotFoundException e) {
                        } catch (IOException e2) {
                        } catch (Exception e3) {
                        }
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    cUIDInfo = new CUIDInfo();
                    cUIDInfo.deviceId = obj3;
                    cUIDInfo.imei = str2;
                    return cUIDInfo;
                }
            }
            str2 = str;
            if (obj == null) {
                setDataFileDeviceId(context, str2, obj3);
            }
        } catch (FileNotFoundException e4) {
            str2 = str;
        } catch (IOException e5) {
            str2 = str;
        } catch (Exception e6) {
            str2 = str;
        }
        if (!TextUtils.isEmpty(obj3)) {
            return null;
        }
        cUIDInfo = new CUIDInfo();
        cUIDInfo.deviceId = obj3;
        cUIDInfo.imei = str2;
        return cUIDInfo;
    }

    public static String getDevID(Context context) {
        return getOrCreateCUIDInfo(context).deviceId;
    }

    public static String getDroidId(Context context) {
        String str = "";
        Object string = Secure.getString(context.getContentResolver(), getDroidName() + "_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private static String getDroidName() {
        return "android";
    }

    private static String getFileContent(File file) {
        FileReader fileReader;
        Throwable e;
        Throwable th;
        String str = null;
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                str = charArrayWriter.toString();
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e2) {
                        e = e2;
                        handleThrowable(e);
                        return str;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    handleThrowable(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            e = e4;
                            handleThrowable(e);
                            return str;
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e5) {
                            handleThrowable(e5);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e5 = e6;
            Object obj = str;
            handleThrowable(e5);
            if (fileReader != null) {
                fileReader.close();
            }
            return str;
        } catch (Throwable e52) {
            fileReader = str;
            th = e52;
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
        return str;
    }

    public static String getIntlMobEqId(Context context) {
        return getOrCreateCUIDInfo(context).imei;
    }

    private String getIntlMobEqIdFromSystem(String str) {
        String devId;
        CharSequence imeiCheck;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager != null) {
                devId = Util.getDevId(telephonyManager);
                imeiCheck = imeiCheck(devId);
                return TextUtils.isEmpty(imeiCheck) ? str : imeiCheck;
            }
        } catch (Throwable e) {
            Log.e(TAG, "Read IntlMobEqId failed", e);
        }
        devId = null;
        imeiCheck = imeiCheck(devId);
        if (TextUtils.isEmpty(imeiCheck)) {
        }
    }

    private static CUIDInfo getOrCreateCUIDInfo(Context context) {
        synchronized (CUIDInfo.class) {
            if (sCachedCuidInfo == null) {
                SystemClock.uptimeMillis();
                sCachedCuidInfo = new DeviceId(context).getCUIDInfo();
                SystemClock.uptimeMillis();
            }
        }
        return sCachedCuidInfo;
    }

    private String getSystemSettingValue(String str) {
        try {
            return System.getString(this.mContext.getContentResolver(), str);
        } catch (Throwable e) {
            handleThrowable(e);
            return null;
        }
    }

    private static void handleThrowable(Throwable th) {
    }

    private boolean hasReadImeiPermission() {
        return checkSelfPermission(SystemAuth.READ_PHONE_STATE_AUTH);
    }

    private boolean hasWriteSettingsPermission() {
        return checkSelfPermission("android.permission.WRITE_SETTINGS");
    }

    private static String imeiCheck(String str) {
        return (str == null || !str.contains(Config.TRACE_TODAY_VISIT_SPLIT)) ? str : "";
    }

    private void initPublicKey() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable e;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(CuidCertStore.getCertBytes());
            try {
                this.mPublicKey = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            } catch (Exception e3) {
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        handleThrowable(e);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                byteArrayInputStream2 = byteArrayInputStream;
                e = th2;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th3) {
                        handleThrowable(th3);
                    }
                }
                throw e;
            }
        } catch (Exception e5) {
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
        } catch (Throwable th4) {
            e = th4;
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
            }
            throw e;
        }
    }

    private boolean isSigsEqual(String[] strArr, String[] strArr2) {
        int i = 0;
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (Object add : strArr) {
            hashSet.add(add);
        }
        HashSet hashSet2 = new HashSet();
        int length = strArr2.length;
        while (i < length) {
            hashSet2.add(strArr2[i]);
            i++;
        }
        return hashSet.equals(hashSet2);
    }

    private static void setDataFileDeviceId(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append(str2);
            File file = new File(context.getFilesDir(), EXT_DIR);
            File file2 = new File(file, EXT_FILE);
            try {
                if (file.exists() && !file.isDirectory()) {
                    File file3;
                    Random random = new Random();
                    File parentFile = file.getParentFile();
                    String name = file.getName();
                    do {
                        file3 = new File(parentFile, name + random.nextInt() + ".tmp");
                    } while (file3.exists());
                    file.renameTo(file3);
                    file3.delete();
                }
                file.mkdirs();
                FileWriter fileWriter = new FileWriter(file2, false);
                fileWriter.write(Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, stringBuilder.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    private static void setDataFileV2DeviceId(Context context, String str) {
        File file = new File(context.getFilesDir(), EXT_DIR);
        File file2 = new File(file, EXT_FILE_V2);
        try {
            if (file.exists() && !file.isDirectory()) {
                File file3;
                Random random = new Random();
                File parentFile = file.getParentFile();
                String name = file.getName();
                do {
                    file3 = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file3.exists());
                file.renameTo(file3);
                file3.delete();
            }
            file.mkdirs();
            FileWriter fileWriter = new FileWriter(file2, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }

    private boolean tryPutSystemSettingValue(String str, String str2) {
        try {
            return System.putString(this.mContext.getContentResolver(), str, str2);
        } catch (Throwable e) {
            handleThrowable(e);
            return false;
        }
    }

    private boolean writeToCuidFile(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.mContext.openFileOutput(SELF_CUID_FILE, 1);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            if (fileOutputStream == null) {
                return true;
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (Throwable e) {
                handleThrowable(e);
                return true;
            }
        } catch (Throwable e2) {
            handleThrowable(e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e22) {
                    handleThrowable(e22);
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e3) {
                    handleThrowable(e3);
                }
            }
        }
    }

    private static void writeToFile(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e = e4;
                            handleThrowable(e);
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e5) {
                            handleThrowable(e5);
                        }
                    }
                    throw e;
                }
            } catch (SecurityException e6) {
                e = e6;
                handleThrowable(e);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        e = e7;
                        handleThrowable(e);
                    }
                }
            }
        } catch (IOException e8) {
            e = e8;
            fileOutputStream = null;
            handleThrowable(e);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (SecurityException e9) {
            e = e9;
            fileOutputStream = null;
            handleThrowable(e);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }
}
