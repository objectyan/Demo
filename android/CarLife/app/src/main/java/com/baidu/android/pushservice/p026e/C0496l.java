package com.baidu.android.pushservice.p026e;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.speech.asr.SpeechConstant;

/* renamed from: com.baidu.android.pushservice.e.l */
public class C0496l {
    /* renamed from: a */
    public String f1603a = "";
    /* renamed from: b */
    public String f1604b = "";
    /* renamed from: c */
    public String f1605c = "";
    /* renamed from: d */
    public String f1606d = "";
    /* renamed from: e */
    public String f1607e = "";
    /* renamed from: f */
    public String f1608f = "";
    /* renamed from: g */
    public String f1609g = "";
    /* renamed from: h */
    public String f1610h = "";
    /* renamed from: i */
    public String f1611i = "";
    /* renamed from: j */
    public String f1612j = "";
    /* renamed from: k */
    public boolean f1613k = false;
    /* renamed from: l */
    public String f1614l = "";
    /* renamed from: m */
    public boolean f1615m = true;

    public C0496l(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f1607e = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f1607e)) {
            this.f1607e = intent.getStringExtra(PushConstants.PACKAGE_NAME);
        }
        this.f1606d = intent.getStringExtra("access_token");
        this.f1611i = intent.getStringExtra("secret_key");
        this.f1603a = intent.getStringExtra("method");
        this.f1604b = intent.getStringExtra("method_type");
        this.f1605c = intent.getStringExtra("method_version");
        this.f1610h = intent.getStringExtra("bduss");
        this.f1608f = intent.getStringExtra(SpeechConstant.APP_ID);
        this.f1612j = intent.getStringExtra("is_baidu_internal_bind");
        this.f1613k = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f1614l = intent.getStringExtra("push_proxy");
        this.f1615m = intent.getBooleanExtra("should_notify_user", true);
    }

    public String toString() {
        return "method=" + this.f1603a + ", accessToken=" + this.f1606d + ", packageName=" + this.f1607e + ", appId=" + this.f1608f + ", userId=" + this.f1609g + ", rsaBduss=" + this.f1610h + ", isInternalBind=" + this.f1612j;
    }
}
