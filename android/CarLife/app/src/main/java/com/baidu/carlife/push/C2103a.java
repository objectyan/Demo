package com.baidu.carlife.push;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.baidu.android.pushservice.BasicPushNotificationBuilder;
import com.baidu.android.pushservice.CustomPushNotificationBuilder;
import com.baidu.android.pushservice.PushManager;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.util.C2186p;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CarLifePushManager */
/* renamed from: com.baidu.carlife.push.a */
public class C2103a {
    /* renamed from: a */
    private static final String f6677a = "CarLifePushManager";
    /* renamed from: b */
    private static C2103a f6678b = null;
    /* renamed from: d */
    private static final String f6679d = "sNSt3EBpSKeOTqnvN7LZjKGW";
    /* renamed from: e */
    private static String f6680e = null;
    /* renamed from: c */
    private Context f6681c = null;

    /* renamed from: a */
    public static C2103a m7880a() {
        if (f6678b == null) {
            f6678b = new C2103a();
        }
        return f6678b;
    }

    /* renamed from: a */
    public static void m7881a(String strUrl) {
        f6680e = strUrl;
    }

    /* renamed from: b */
    public static String m7883b() {
        return f6680e;
    }

    /* renamed from: a */
    public void m7887a(Context mcontext) {
        C1260i.m4435b(f6677a, "Start push work");
        String strKey = f6679d;
        this.f6681c = mcontext;
        PushManager.startWork(C1157a.m3876a().getApplicationContext(), 0, strKey);
        C1260i.m4435b(f6677a, "End push work");
        BasicPushNotificationBuilder bBuilder = new BasicPushNotificationBuilder();
        bBuilder.setChannelId("testDefaultChannelId");
        bBuilder.setChannelName("testDefaultChannelName");
        CustomPushNotificationBuilder cBuilder = new CustomPushNotificationBuilder(C0965R.layout.notification_custom_builder, C0965R.id.notification_icon, C0965R.id.notification_title, C0965R.id.notification_text);
        cBuilder.setNotificationFlags(16);
        cBuilder.setNotificationDefaults(2);
        cBuilder.setStatusbarIcon(mcontext.getApplicationInfo().icon);
        cBuilder.setNotificationSound(Uri.withAppendedPath(Media.INTERNAL_CONTENT_URI, C2578b.f8568g).toString());
        cBuilder.setChannelId("testId");
        cBuilder.setChannelName("testName");
        PushManager.setNotificationBuilder(mcontext, 1, cBuilder);
        List<String> tags = new ArrayList();
        tags.add(C2186p.m8304a().m8309a(C1253f.jA, "20022100"));
        PushManager.setTags(this.f6681c, tags);
    }

    /* renamed from: d */
    private void m7884d() {
        PushManager.startWork(this.f6681c.getApplicationContext(), 0, C2104b.m7890a(this.f6681c, "api_key"));
    }

    /* renamed from: c */
    public void m7888c() {
        PushManager.stopWork(this.f6681c.getApplicationContext());
    }

    /* renamed from: e */
    private void m7885e() {
        PushManager.listTags(this.f6681c.getApplicationContext());
    }

    /* renamed from: f */
    private void m7886f() {
        if (null == null && null == null && null == null && null == null) {
            Toast.makeText(this.f6681c, "已取消 免打扰时段功能", 0).show();
        } else if (0 > 0 || (0 == 0 && 0 > 0)) {
            m7882a("第一天的" + 0 + Config.TRACE_TODAY_VISIT_SPLIT + 0, "第二天的" + 0 + Config.TRACE_TODAY_VISIT_SPLIT + 0);
        } else {
            m7882a(0 + Config.TRACE_TODAY_VISIT_SPLIT + 0, 0 + Config.TRACE_TODAY_VISIT_SPLIT + 0);
        }
        PushManager.setNoDisturbMode(this.f6681c, 0, 0, 0, 0);
    }

    /* renamed from: a */
    private void m7882a(String start, String end) {
        int indexTotal = start.length() + 13;
        int indexPosition = (indexTotal + 3) + end.length();
        SpannableString s = new SpannableString("设置成功，免打扰时段为：\\n%1$s - %2$s");
        s.setSpan(new ForegroundColorSpan(this.f6681c.getResources().getColor(C0965R.color.common_bottom_text_red_color)), 13, indexTotal, 17);
        s.setSpan(new ForegroundColorSpan(this.f6681c.getResources().getColor(C0965R.color.common_bottom_text_red_color)), indexTotal + 3, indexPosition, 17);
        Toast.makeText(this.f6681c, s, 1).show();
    }
}
