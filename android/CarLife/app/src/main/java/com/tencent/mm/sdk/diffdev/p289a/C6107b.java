package com.tencent.mm.sdk.diffdev.p289a;

import android.util.Log;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.sdk.diffdev.a.b */
final class C6107b implements OAuthListener {
    final /* synthetic */ C6106a ag;

    C6107b(C6106a c6106a) {
        this.ag = c6106a;
    }

    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[]{oAuthErrCode.toString(), str}));
        this.ag.ae = null;
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.ag.ad);
        for (OAuthListener onAuthFinish : arrayList) {
            onAuthFinish.onAuthFinish(oAuthErrCode, str);
        }
    }

    public final void onAuthGotQrcode(String str, byte[] bArr) {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.ag.ad);
        for (OAuthListener onAuthGotQrcode : arrayList) {
            onAuthGotQrcode.onAuthGotQrcode(str, bArr);
        }
    }

    public final void onQrcodeScanned() {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.ag.ac != null) {
            this.ag.ac.post(new C6108c(this));
        }
    }
}
