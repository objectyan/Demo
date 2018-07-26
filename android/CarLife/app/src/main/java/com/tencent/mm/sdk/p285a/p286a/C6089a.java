package com.tencent.mm.sdk.p285a.p286a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.p287b.C6094b;
import com.tencent.mm.sdk.p287b.C6102h;

/* renamed from: com.tencent.mm.sdk.a.a.a */
public final class C6089a {

    /* renamed from: com.tencent.mm.sdk.a.a.a$a */
    public static class C6088a {
        /* renamed from: Y */
        public String f24749Y;
        /* renamed from: Z */
        public Bundle f24750Z;
        public String aa;
        public String ab;
    }

    /* renamed from: a */
    public static boolean m21672a(Context context, C6088a c6088a) {
        if (context == null) {
            C6094b.m21682b("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (C6102h.m21697h(c6088a.ab)) {
            C6094b.m21682b("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = null;
            if (!C6102h.m21697h(c6088a.aa)) {
                str = c6088a.aa + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c6088a.ab);
            if (c6088a.f24750Z != null) {
                intent.putExtras(c6088a.f24750Z);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c6088a.f24749Y);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C6090b.m21673a(c6088a.f24749Y, 587268097, packageName));
            context.sendBroadcast(intent, str);
            C6094b.m21685e("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
