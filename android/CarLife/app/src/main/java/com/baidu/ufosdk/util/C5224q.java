package com.baidu.ufosdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;

/* compiled from: ImageHandler */
/* renamed from: com.baidu.ufosdk.util.q */
public final class C5224q extends Handler {
    /* renamed from: a */
    ImageView f21718a;
    /* renamed from: b */
    Handler f21719b;
    /* renamed from: c */
    Context f21720c;
    /* renamed from: d */
    TextView f21721d = null;

    public C5224q(Context context, TextView textView, Handler handler) {
        this.f21721d = textView;
        this.f21719b = handler;
        this.f21720c = context;
    }

    public C5224q(Context context, ImageView imageView, Handler handler) {
        this.f21718a = imageView;
        this.f21719b = handler;
        this.f21720c = context;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.obj != null) {
            Bitmap bitmap = (Bitmap) message.obj;
            if (this.f21721d != null) {
                ImageSpan imageSpan = new ImageSpan(this.f21720c, bitmap);
                CharSequence spannableString = new SpannableString(HUDGuideDataStruct.KEY_ICON_NAME);
                spannableString.setSpan(imageSpan, 0, 4, 33);
                this.f21721d.setText(spannableString);
                return;
            }
            this.f21718a.setImageBitmap(bitmap);
            if (bitmap.getHeight() > bitmap.getWidth()) {
                this.f21718a.setMaxWidth(C5216i.m17757a(this.f21720c, 80.0f));
                this.f21718a.setMaxHeight(C5216i.m17757a(this.f21720c, 120.0f));
            } else {
                this.f21718a.setMaxWidth(C5216i.m17757a(this.f21720c, 120.0f));
                this.f21718a.setMaxHeight(C5216i.m17757a(this.f21720c, 80.0f));
            }
        }
        if (this.f21719b != null) {
            this.f21719b.obtainMessage(6).sendToTarget();
        }
    }
}
