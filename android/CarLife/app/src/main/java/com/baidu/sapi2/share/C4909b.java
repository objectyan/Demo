package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.C4917a;
import com.baidu.sapi2.utils.C4923f;
import com.baidu.sapi2.utils.SapiDataEncryptor;

/* compiled from: ShareEncryptor */
/* renamed from: com.baidu.sapi2.share.b */
public final class C4909b {
    /* renamed from: a */
    private static String f20508a = null;

    /* renamed from: a */
    public static String m16354a(Context context, String string) {
        String str = null;
        if (!(context == null || TextUtils.isEmpty(string))) {
            try {
                str = SapiDataEncryptor.m16378a(new C4917a(C4923f.f20618w, C4923f.f20617v).m16392a(string, C4923f.f20619x, C4909b.m16353a(context)));
            } catch (Exception e) {
                C4913L.m16374e(e);
            }
        }
        return str;
    }

    /* renamed from: b */
    public static String m16356b(Context context, String string) {
        String str = null;
        if (!(context == null || TextUtils.isEmpty(string))) {
            try {
                str = new String(new C4917a(C4923f.f20618w, C4923f.f20617v).m16393a(SapiDataEncryptor.m16382b(string), C4923f.f20619x, C4909b.m16353a(context))).trim();
            } catch (Exception e) {
                C4913L.m16374e(e);
            }
        }
        return str;
    }

    /* renamed from: a */
    private static String m16353a(Context context) {
        if (f20508a != null) {
            return f20508a;
        }
        String key;
        String imei = null;
        String blockSize = null;
        String blockCount = null;
        if (VERSION.SDK_INT < 23) {
            imei = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        }
        String model = Build.MODEL;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs sf = new StatFs(Environment.getExternalStorageDirectory().getPath());
            blockSize = sf.getBlockSize() + "";
            blockCount = sf.getBlockCount() + "";
        }
        if (TextUtils.isEmpty(imei)) {
            key = String.format("%1$s-%2$s-%3$s", new Object[]{model, blockSize, blockCount});
        } else {
            key = String.format("%1$s-%2$s-%3$s-%4$s", new Object[]{model, imei, blockSize, blockCount});
        }
        key = key.substring(0, 16);
        String keyEnd = "----------------";
        if (TextUtils.isEmpty(key)) {
            key = keyEnd;
        }
        if (key.length() < 16) {
            key = (key + keyEnd).substring(0, 16);
        }
        f20508a = key;
        return f20508a;
    }

    /* renamed from: a */
    static SapiAccount m16352a(Context context, SapiAccount account) {
        if (context == null || account == null) {
            return null;
        }
        SapiAccount encryptedAccount = new SapiAccount();
        encryptedAccount.displayname = C4909b.m16354a(context, account.displayname);
        encryptedAccount.uid = C4909b.m16354a(context, account.uid);
        encryptedAccount.username = C4909b.m16354a(context, account.username);
        encryptedAccount.app = C4909b.m16354a(context, account.app);
        encryptedAccount.bduss = C4909b.m16354a(context, account.bduss);
        encryptedAccount.ptoken = C4909b.m16354a(context, account.ptoken);
        encryptedAccount.stoken = C4909b.m16354a(context, account.stoken);
        encryptedAccount.email = C4909b.m16354a(context, account.email);
        encryptedAccount.extra = C4909b.m16354a(context, account.extra);
        encryptedAccount.phone = C4909b.m16354a(context, account.phone);
        return encryptedAccount;
    }

    /* renamed from: b */
    static SapiAccount m16355b(Context context, SapiAccount encryptedAccount) {
        if (context == null || encryptedAccount == null) {
            return null;
        }
        SapiAccount decryptedAccount = new SapiAccount();
        decryptedAccount.displayname = C4909b.m16356b(context, encryptedAccount.displayname);
        decryptedAccount.uid = C4909b.m16356b(context, encryptedAccount.uid);
        decryptedAccount.username = C4909b.m16356b(context, encryptedAccount.username);
        decryptedAccount.app = C4909b.m16356b(context, encryptedAccount.app);
        decryptedAccount.bduss = C4909b.m16356b(context, encryptedAccount.bduss);
        decryptedAccount.ptoken = C4909b.m16356b(context, encryptedAccount.ptoken);
        decryptedAccount.stoken = C4909b.m16356b(context, encryptedAccount.stoken);
        decryptedAccount.email = C4909b.m16356b(context, encryptedAccount.email);
        decryptedAccount.extra = C4909b.m16356b(context, encryptedAccount.extra);
        decryptedAccount.phone = C4909b.m16356b(context, encryptedAccount.phone);
        return decryptedAccount;
    }
}
