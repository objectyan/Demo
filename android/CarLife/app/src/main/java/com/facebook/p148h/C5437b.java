package com.facebook.p148h;

import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.facebook.common.internal.C5350k;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: JfifUtil */
/* renamed from: com.facebook.h.b */
public class C5437b {
    /* renamed from: a */
    public static final int f22213a = 255;
    /* renamed from: b */
    public static final int f22214b = 0;
    /* renamed from: c */
    public static final int f22215c = 216;
    /* renamed from: d */
    public static final int f22216d = 1;
    /* renamed from: e */
    public static final int f22217e = 217;
    /* renamed from: f */
    public static final int f22218f = 218;
    /* renamed from: g */
    public static final int f22219g = 225;
    /* renamed from: h */
    public static final int f22220h = 192;
    /* renamed from: i */
    public static final int f22221i = 208;
    /* renamed from: j */
    public static final int f22222j = 215;
    /* renamed from: k */
    public static final int f22223k = 1165519206;

    private C5437b() {
    }

    /* renamed from: a */
    public static int m18685a(int orientation) {
        return C5441d.m18692a(orientation);
    }

    /* renamed from: a */
    public static int m18687a(byte[] jpeg) {
        return C5437b.m18686a(new ByteArrayInputStream(jpeg));
    }

    /* renamed from: a */
    public static int m18686a(InputStream is) {
        int i = 0;
        try {
            int length = C5437b.m18689b(is);
            if (length != 0) {
                i = C5441d.m18693a(is, length);
            }
        } catch (IOException e) {
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m18688a(InputStream is, int markerToFind) throws IOException {
        C5350k.m18310a((Object) is);
        while (C5438c.m18691a(is, 1, false) == 255) {
            int marker = 255;
            while (marker == 255) {
                marker = C5438c.m18691a(is, 1, false);
            }
            if ((markerToFind == 192 && C5437b.m18690b(marker)) || marker == markerToFind) {
                return true;
            }
            if (!(marker == 216 || marker == 1)) {
                if (marker == 217 || marker == 218) {
                    return false;
                }
                is.skip((long) (C5438c.m18691a(is, 2, false) - 2));
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m18690b(int marker) {
        switch (marker) {
            case 192:
            case RouteLineResConst.LINE_YELLOW_GREY /*193*/:
            case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
            case RouteLineResConst.LINE_ARR_INTERNAL_NORMAL /*195*/:
            case RouteLineResConst.LINE_INTERNAL_GREY /*197*/:
            case 198:
            case 199:
            case 201:
            case 202:
            case 203:
            case 205:
            case 206:
            case 207:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: b */
    private static int m18689b(InputStream is) throws IOException {
        if (C5437b.m18688a(is, 225)) {
            int length = C5438c.m18691a(is, 2, false) - 2;
            if (length > 6) {
                int magic = C5438c.m18691a(is, 4, false);
                length -= 4;
                int zero = C5438c.m18691a(is, 2, false);
                length -= 2;
                if (magic == f22223k && zero == 0) {
                    return length;
                }
            }
        }
        return 0;
    }
}
