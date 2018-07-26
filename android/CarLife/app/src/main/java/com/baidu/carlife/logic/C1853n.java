package com.baidu.carlife.logic;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

/* compiled from: NoUnderLineClickableSpan */
/* renamed from: com.baidu.carlife.logic.n */
public abstract class C1853n extends ClickableSpan {
    public void updateDrawState(TextPaint ds) {
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(false);
    }
}
