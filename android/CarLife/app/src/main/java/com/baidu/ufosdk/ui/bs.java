package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/* compiled from: FeedbackInputActivity */
final class bs implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ br f21588a;

    bs(br brVar) {
        this.f21588a = brVar;
    }

    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f21456b = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
            this.f21588a.f21586a.startActivity(new Intent(this.f21588a.f21586a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e) {
        }
    }
}
