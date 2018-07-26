package com.baidu.platform.comapi.p133d;

import android.content.Context;
import com.facebook.common.p141m.C2924g;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ResourceReader */
/* renamed from: com.baidu.platform.comapi.d.c */
final class C4768c {
    /* renamed from: a */
    private JSONObject f19803a;

    public C4768c(Context context, String path) {
        InputStream stream = null;
        try {
            stream = context.getAssets().open(path);
            this.f19803a = new JSONObject(C4768c.m15840a(stream));
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    /* renamed from: a */
    public byte[] m15841a() {
        JSONArray version = this.f19803a.optJSONArray("ver");
        if (version == null) {
            return null;
        }
        byte[] bArr = new byte[version.length()];
        int len = version.length();
        for (int i = 0; i < len; i++) {
            bArr[i] = (byte) version.optInt(i);
        }
        return bArr;
    }

    /* renamed from: b */
    public String[] m15842b() {
        JSONArray res = this.f19803a.optJSONArray(C2924g.f12892f);
        if (res == null) {
            return null;
        }
        String[] strArr = new String[res.length()];
        int len = res.length();
        for (int i = 0; i < len; i++) {
            strArr[i] = res.optString(i);
        }
        return strArr;
    }

    /* renamed from: a */
    private static String m15840a(InputStream inputStream) throws IOException {
        IOException e;
        Throwable th;
        BufferedInputStream input = null;
        ByteArrayOutputStream output = null;
        try {
            BufferedInputStream input2 = new BufferedInputStream(inputStream);
            try {
                ByteArrayOutputStream output2 = new ByteArrayOutputStream();
                try {
                    byte[] buffer = new byte[512];
                    while (true) {
                        int count = input2.read(buffer);
                        if (count == -1) {
                            break;
                        }
                        output2.write(buffer, 0, count);
                    }
                    output2.flush();
                    String byteArrayOutputStream = output2.toString("UTF-8");
                    if (output2 != null) {
                        try {
                            output2.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (input2 != null) {
                        try {
                            input2.close();
                        } catch (IOException e3) {
                        }
                    }
                    return byteArrayOutputStream;
                } catch (IOException e4) {
                    e = e4;
                    output = output2;
                    input = input2;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    output = output2;
                    input = input2;
                    if (output != null) {
                        try {
                            output.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                input = input2;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                input = input2;
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            throw e;
        }
    }
}
