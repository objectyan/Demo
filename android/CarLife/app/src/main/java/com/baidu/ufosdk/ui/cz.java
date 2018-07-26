package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.C0965R;

/* compiled from: InputContactDialog */
final class cz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ cx f21654a;

    private cz(cx cxVar) {
        this.f21654a = cxVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case C0965R.raw.bdspeech_speech_end:
                da a = this.f21654a.f21650i;
                this.f21654a.f21651j.getText().toString();
                a.mo3928a();
                return;
            case C0965R.raw.cruiser_pass:
                this.f21654a.f21650i.mo3929a(this.f21654a.f21651j.getText().toString());
                return;
            default:
                return;
        }
    }
}
