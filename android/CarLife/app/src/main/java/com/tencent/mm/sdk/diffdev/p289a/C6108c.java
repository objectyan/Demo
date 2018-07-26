package com.tencent.mm.sdk.diffdev.p289a;

import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.sdk.diffdev.a.c */
final class C6108c implements Runnable {
    final /* synthetic */ C6107b ah;

    C6108c(C6107b c6107b) {
        this.ah = c6107b;
    }

    public final void run() {
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.ah.ag.ad);
        for (OAuthListener onQrcodeScanned : arrayList) {
            onQrcodeScanned.onQrcodeScanned();
        }
    }
}
