package com.tencent.mm.sdk.p285a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.p285a.p286a.C6090b;
import com.tencent.mm.sdk.p287b.C6094b;
import com.tencent.mm.sdk.p287b.C6102h;

/* renamed from: com.tencent.mm.sdk.a.a */
public final class C6091a {

    /* renamed from: com.tencent.mm.sdk.a.a$a */
    public static class C6087a {
        /* renamed from: W */
        public String f24745W;
        /* renamed from: X */
        public String f24746X;
        /* renamed from: Y */
        public String f24747Y;
        /* renamed from: Z */
        public Bundle f24748Z;
        public int flags = -1;

        public final String toString() {
            return "targetPkgName:" + this.f24745W + ", targetClassName:" + this.f24746X + ", content:" + this.f24747Y + ", flags:" + this.flags + ", bundle:" + this.f24748Z;
        }
    }

    /* renamed from: a */
    public static boolean m21674a(Context context, C6087a c6087a) {
        if (context == null) {
            C6094b.m21682b("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (C6102h.m21697h(c6087a.f24745W)) {
            C6094b.m21682b("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c6087a.f24745W);
            return false;
        } else {
            if (C6102h.m21697h(c6087a.f24746X)) {
                c6087a.f24746X = c6087a.f24745W + ".wxapi.WXEntryActivity";
            }
            C6094b.m21685e("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c6087a.f24745W + ", targetClassName = " + c6087a.f24746X);
            Intent intent = new Intent();
            intent.setClassName(c6087a.f24745W, c6087a.f24746X);
            if (c6087a.f24748Z != null) {
                intent.putExtras(c6087a.f24748Z);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c6087a.f24747Y);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C6090b.m21673a(c6087a.f24747Y, 587268097, packageName));
            if (c6087a.flags == -1) {
                intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL).addFlags(134217728);
            } else {
                intent.setFlags(c6087a.flags);
            }
            try {
                context.startActivity(intent);
                C6094b.m21685e("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
                return true;
            } catch (Exception e) {
                C6094b.m21681a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
                return false;
            }
        }
    }
}
