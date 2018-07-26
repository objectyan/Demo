package com.baidu.carlife.p057a;

import android.os.Message;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeAuthenResponseProto.CarlifeAuthenResponse;
import com.baidu.carlife.protobuf.CarlifeAuthenResponseProto.CarlifeAuthenResponse.Builder;
import com.baidu.carlife.protobuf.CarlifeAuthenResultProto.CarlifeAuthenResult;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: PrivateKeyManager */
/* renamed from: com.baidu.carlife.a.a */
public class C0967a {
    /* renamed from: a */
    private static final String f2428a = C0967a.class.getSimpleName();
    /* renamed from: b */
    private static C0967a f2429b = null;
    /* renamed from: c */
    private static final String f2430c = "_00.00.00";
    /* renamed from: d */
    private static final String f2431d = "RSA/ECB/PKCS1Padding";
    /* renamed from: e */
    private static final String f2432e = "0.0.0";
    /* renamed from: f */
    private static final String f2433f = "1.1.0";
    /* renamed from: h */
    private static final String f2434h = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALzoBR3Io5wxQH+IMy0ekUE50s9ZOEPOI/y3bSwXSZEqU0EgDGVRnFBYhr8MSEkv2THTn5HKsUM3gHd3rpQhRG2JrcaFY+iIEJs2iueXvfKd8UqTUFQOZrc7xCz1npg4KResY4VAEN+W19ez/DsKiCS5LaxmwE844xWibTgjspY9AgMBAAECgYA7C/cVcTKaztZPRr5gWw6iKbXYNBYfM58SDi+kuX64TleJor/dJ55JivJLY0ZxAfDM304gXw/7Z6zTKui5ypA9duYu1Pohk/e5UUMFr0+cEyWzTjCJp/XaA/gEhH8g311qeWcALSo6q55vYtTJpc/OUn98nlsrOMv4XLgaBI2fwQJBAPBw7TkR4Xuvue2tfxh2Fn2x2ONJSRjckS7EipfdLSsgZCbwdQ2XL/k6VX0lMfQaLQQ6YCF/vrALlgkXFBuzFpECQQDJIWJGcoM95ms546hHBzu7DONmEpEh9b9nMEqRmOkzkitxvGApv1VjvZaX6gMrSANADmoz4lSTGXFea4nviJLtAkEA29v3H4NZMveJxWsrV5vLjx5MG/FMdP5jh2dS7/DgN5pD2lNwRYAk7vnHaErVtccluMMEWj1siZ/ejutaiMWm8QJBAIMM+4nHZ3hXwJoRmj3dmq/AMBL8GhC0nShRMOU5awmtPh13jnjlMHAywgLt+W6kF2oPemegG1dVhqbtDw1CQekCQH3xugE28LS6e29233PUBdipwoyRcbDeth70WDS3l4bl7XlWbTXOWF/D28ZZ49NSr1dRhAQwM8VVC/gHdvNpcqA=";
    /* renamed from: g */
    private PrivateKey f2435g;

    /* renamed from: a */
    public static C0967a m3157a() {
        if (f2429b == null) {
            f2429b = new C0967a();
        }
        return f2429b;
    }

    private C0967a() {
        try {
            this.f2435g = m3161d(f2434h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3162a(String originalContent) {
        String rstStr = null;
        try {
            rstStr = Base64.encodeToString(m3159a("RSA/ECB/PKCS1Padding", m3160c(originalContent).getBytes("UTF-8"), this.f2435g), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1212c command = new C1212c(true);
        command.m4201c(C1253f.aQ);
        Builder builder = CarlifeAuthenResponse.newBuilder();
        builder.setEncryptValue(rstStr);
        CarlifeAuthenResponse response = builder.build();
        command.m4199b(response.toByteArray());
        command.m4203d(response.getSerializedSize());
        C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
    }

    /* renamed from: b */
    public String m3164b(String originalContent) {
        String rstStr = null;
        try {
            rstStr = Base64.encodeToString(m3159a("RSA/ECB/PKCS1Padding", m3160c(originalContent).getBytes("UTF-8"), this.f2435g), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rstStr;
    }

    /* renamed from: a */
    private byte[] m3159a(String transformation, byte[] plainText, PrivateKey key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(1, key);
        cipher.update(plainText);
        return cipher.doFinal();
    }

    /* renamed from: c */
    private String m3160c(String version) {
        String currentAppVersion = C1251e.m4373g();
        if (currentAppVersion.equals(f2432e)) {
            currentAppVersion = f2433f;
        }
        C1260i.m4435b(f2428a, "currentAppVersion= " + currentAppVersion);
        String[] currenAppVersionNum = currentAppVersion.split("\\.");
        String requestAppVersion = version.substring(version.indexOf(JNISearchConst.LAYER_ID_DIVIDER));
        String prefix = version.replace(requestAppVersion, "");
        String[] requestAppVersionNum = requestAppVersion.replace(JNISearchConst.LAYER_ID_DIVIDER, "").split("\\.");
        if (currenAppVersionNum.length != requestAppVersionNum.length) {
            return prefix + f2430c;
        }
        int i = 0;
        while (i < currenAppVersionNum.length) {
            try {
                if (Integer.parseInt(requestAppVersionNum[i]) > Integer.parseInt(currenAppVersionNum[i])) {
                    return prefix + f2430c;
                }
                if (Integer.parseInt(requestAppVersionNum[i]) < Integer.parseInt(currenAppVersionNum[i])) {
                    return version;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return version;
    }

    /* renamed from: a */
    public void m3163a(boolean result) {
        C1212c command = new C1212c(true);
        command.m4201c(C1253f.aS);
        CarlifeAuthenResult.Builder builder = CarlifeAuthenResult.newBuilder();
        builder.setAuthenResult(result);
        CarlifeAuthenResult response = builder.build();
        command.m4199b(response.toByteArray());
        command.m4203d(response.getSerializedSize());
        C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
    }

    /* renamed from: d */
    private PrivateKey m3161d(String key) throws Exception {
        return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(key, 2)));
    }

    /* renamed from: a */
    private String m3158a(Key key) throws Exception {
        return Base64.encodeToString(key.getEncoded(), 2);
    }
}
