package com.baidu.ufosdk.ui;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import java.net.URL;

/* compiled from: FeedbackInputActivity */
final class bk implements ImageGetter {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21579a;

    bk(FeedbackInputActivity feedbackInputActivity) {
        this.f21579a = feedbackInputActivity;
    }

    public final Drawable getDrawable(String str) {
        try {
            Drawable createFromStream = Drawable.createFromStream(new URL(str).openStream(), "");
            createFromStream.setBounds(0, 0, createFromStream.getIntrinsicWidth(), createFromStream.getIntrinsicHeight());
            return createFromStream;
        } catch (Exception e) {
            return null;
        }
    }
}
