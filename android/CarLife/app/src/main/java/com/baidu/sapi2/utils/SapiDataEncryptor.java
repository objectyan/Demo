package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;

public class SapiDataEncryptor {
    /* renamed from: a */
    public static final String f20517a = TextUtils.join("", new String[]{"b", Config.APP_VERSION_CODE, "i", "d", "u", "v", Config.OS, "i", "c", Config.SESSTION_END_TIME, "3", "5", "h", "y", "1", "2"});
    /* renamed from: b */
    public static final String f20518b = TextUtils.join("", new String[]{"b", Config.APP_VERSION_CODE, "i", "d", "u", Regular.CATEGORY_FIX_VALUE, Config.APP_VERSION_CODE, "c", Config.SESSTION_END_TIME, "D", MapObjKey.OBJ_SS_ARROW_Z, "T", "9", "9", "1", "1"});
    /* renamed from: c */
    private static final String f20519c = "0123456789ABCDEF";
    /* renamed from: d */
    private String f20520d;
    /* renamed from: e */
    private C4917a f20521e;

    /* renamed from: com.baidu.sapi2.utils.SapiDataEncryptor$a */
    public static class C4914a {
        /* renamed from: a */
        public static final int f20513a = 1;
        /* renamed from: b */
        public static final String f20514b = "-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----";
    }

    /* renamed from: com.baidu.sapi2.utils.SapiDataEncryptor$b */
    public static class C4915b {
        /* renamed from: a */
        public static final int f20515a = 2;
        /* renamed from: b */
        public static final String f20516b = "-----BEGIN CERTIFICATE-----\nMIIChzCCAfACAQAwDQYJKoZIhvcNAQEEBQAwgYsxCzAJBgNVBAYTAkNOMRAwDgYD\nVQQIEwdiZWlqaW5nMRAwDgYDVQQHEwdiZWlqaW5nMQ4wDAYDVQQKEwViYWlkdTEO\nMAwGA1UECxMFYmFpZHUxFjAUBgNVBAMTDXd3dy5iYWlkdS5jb20xIDAeBgkqhkiG\n9w0BCQEWEXBhc3MtcmRAYmFpZHUuY29tMB4XDTEzMDMyMjA5NTYyM1oXDTIzMDMy\nMDA5NTYyM1owgYsxCzAJBgNVBAYTAkNOMRAwDgYDVQQIEwdiZWlqaW5nMRAwDgYD\nVQQHEwdiZWlqaW5nMQ4wDAYDVQQKEwViYWlkdTEOMAwGA1UECxMFYmFpZHUxFjAU\nBgNVBAMTDXd3dy5iYWlkdS5jb20xIDAeBgkqhkiG9w0BCQEWEXBhc3MtcmRAYmFp\nZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzxh67pGWcTONjkofu\nhx8fSPeTDql3mRx6/jzEQv6klkMhLn1XDIU/NoBlzFeiAUZm2orn1JP9R9FxwNiU\n7uPtf5n2eYt//XtYcyJwOK0j4xl2MajLZCITufJ9SQGrDZK/onVCrokIVTlu2Sd1\nJVyXf1wwLx5+1LHjacEstrGCLwIDAQABMA0GCSqGSIb3DQEBBAUAA4GBAFaJ31WX\nD5F1MOFVQtK5Z22eaClL1NZaqjlt7IC22ovWhfO836K07YrYgF97w3DdAsJxXpG+\ny/y8HAvAnPN5IzI1Or6nMgEVZLawkkbvttbcAkhW4fleZPsn06aVYZ1sSxQok/k/\nZOj/cz22nU8JgmiJL0ZChHeHyC3VusOHtUW3\n-----END CERTIFICATE-----";
    }

    public SapiDataEncryptor() {
        this.f20520d = "kf1t9tsczk16vc8z";
        this.f20520d = m16380b();
        this.f20521e = new C4917a();
    }

    /* renamed from: a */
    public String m16384a() {
        return this.f20520d;
    }

    /* renamed from: a */
    public String m16386a(String cert, String text) throws CertificateException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        if (TextUtils.isEmpty(cert) || TextUtils.isEmpty(text)) {
            return null;
        }
        int blockCount;
        Key publicKey = X509Certificate.getInstance(new ByteArrayInputStream(cert.getBytes())).getPublicKey();
        JSONArray array = new JSONArray();
        byte[] by = text.getBytes("UTF-8");
        if (by.length % 116 == 0) {
            blockCount = by.length / 116;
        } else {
            blockCount = (by.length / 116) + 1;
        }
        for (int i = 0; i < blockCount; i++) {
            if (1 == blockCount) {
                array.put(Base64.encode(m16379a(publicKey, by), "UTF-8"));
            } else if (i != blockCount - 1) {
                byDst = new byte[116];
                System.arraycopy(by, i * 116, byDst, 0, 116);
                array.put(Base64.encode(m16379a(publicKey, byDst), "UTF-8"));
            } else {
                int lastBlockLen = by.length - (i * 116);
                byDst = new byte[lastBlockLen];
                System.arraycopy(by, i * 116, byDst, 0, lastBlockLen);
                array.put(Base64.encode(m16379a(publicKey, byDst), "UTF-8"));
            }
        }
        return Base64.encode(array.toString().getBytes("UTF-8"), "UTF-8");
    }

    /* renamed from: a */
    public String m16385a(String decText) throws Exception {
        return new String(this.f20521e.m16393a(Base64.decode(decText.getBytes()), new StringBuffer(this.f20520d).reverse().toString(), this.f20520d), "UTF-8");
    }

    /* renamed from: b */
    private String m16380b() {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(base.charAt(random.nextInt(base.length())));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private byte[] m16379a(Key pubkey, byte[] bytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher rsa = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        rsa.init(1, pubkey);
        return rsa.doFinal(bytes);
    }

    /* renamed from: b */
    public static String m16381b(String cipherUid, String key) {
        String uid = "";
        try {
            uid = new String(new C4917a().m16393a(Base64.decode(cipherUid.getBytes()), new StringBuffer(key).reverse().toString(), key), "UTF-8").trim();
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        return uid;
    }

    /* renamed from: c */
    public static String m16383c(String uid, String key) {
        String cipherUid = "";
        try {
            cipherUid = Base64.encode(new C4917a().m16392a(uid, new StringBuffer(key).reverse().toString(), key), "UTF-8");
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        return cipherUid;
    }

    /* renamed from: b */
    public static byte[] m16382b(String hex) {
        int len = hex.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hex.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return result;
    }

    /* renamed from: a */
    public static String m16378a(byte[] buf) {
        if (buf == null) {
            return null;
        }
        StringBuilder result = new StringBuilder(buf.length * 2);
        for (byte aBuf : buf) {
            result.append(f20519c.charAt((aBuf >> 4) & 15)).append(f20519c.charAt(aBuf & 15));
        }
        return result.toString();
    }

    public static String encryptPwd(String plainPwd) {
        if (plainPwd == null) {
            return null;
        }
        byte[] cipher = C4918b.m16394a(String.valueOf(TextUtils.getReverse(plainPwd, 0, plainPwd.length())), C4915b.f20516b);
        if (cipher != null) {
            return m16378a(cipher);
        }
        return null;
    }
}
