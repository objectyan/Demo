package com.baidu.carlife.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1253f.C1252a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.view.dialog.C1953c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VehicleChannelUtils */
/* renamed from: com.baidu.carlife.util.x */
public class C2204x {
    /* renamed from: a */
    public static final String f7052a = "VehicleChannelUtils";
    /* renamed from: b */
    private static C1953c f7053b = null;
    /* renamed from: c */
    private static List<String> f7054c = new ArrayList();

    /* compiled from: VehicleChannelUtils */
    /* renamed from: com.baidu.carlife.util.x$1 */
    static class C22021 implements C0672b {
        C22021() {
        }

        public void onClick() {
            C1663a.m5979a().m5994O();
            C2204x.f7053b = null;
        }
    }

    /* compiled from: VehicleChannelUtils */
    /* renamed from: com.baidu.carlife.util.x$2 */
    static class C22032 implements C0690d {
        C22032() {
        }

        public void onCancel() {
            C1663a.m5979a().m5994O();
            C2204x.f7053b = null;
        }
    }

    /* renamed from: a */
    public static void m8380a(Context context, C1277e listener) {
        if (context != null) {
            if (f7053b == null) {
                f7053b = new C1953c(context);
                f7053b.m7442b((int) C0965R.string.alert_notification);
                f7053b.m7447c((int) C0965R.string.alert_confirm_a);
                f7053b.m7435a((int) C0965R.string.dialog_illegal_version);
                f7053b.m7438a(new C22021());
                f7053b.setOnDialogCancelListener(new C22032());
            }
            if (listener != null) {
                listener.showDialog(f7053b);
            }
        }
    }

    /* renamed from: a */
    public static boolean m8381a(Context context, String channel, C1277e listener) {
        if (channel == null) {
            return false;
        }
        channel = channel.trim();
        if (!TextUtils.isEmpty(channel) && channel.matches("2(\\d){7}") && !C1252a.VEHICLE_CHANNEL_AFTERMARKET.m4403a().equals(channel) && !C1252a.VEHICLE_CHANNEL_PREINSTALLMARKET.m4403a().equals(channel)) {
            return true;
        }
        C2204x.m8380a(context, listener);
        return false;
    }

    /* renamed from: a */
    public static void m8379a() {
        f7054c.clear();
        f7054c.add("20062100");
        f7054c.add("20062101");
        f7054c.add("20062102");
        f7054c.add("20062103");
        f7054c.add("20062104");
        f7054c.add("20062105");
    }

    /* renamed from: b */
    public static boolean m8382b() {
        String channel = C1253f.jx.m4403a();
        for (String benzChannel : f7054c) {
            if (TextUtils.equals(channel, benzChannel)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m8383c() {
        return false;
    }
}
