package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.carlife.view.C2252a.C2248c;

public class KeyboardEditText extends EditText {
    /* renamed from: a */
    private C2248c f7167a;
    /* renamed from: b */
    private String f7168b;

    public void setOnClickFinishListener(C2248c onClickFinishListener) {
        this.f7167a = onClickFinishListener;
    }

    public C2248c getOnClickFinishListener() {
        return this.f7167a;
    }

    public void setFinishText(String finishText) {
        this.f7168b = finishText;
    }

    public String getFinishText() {
        return this.f7168b;
    }

    public KeyboardEditText(Context context) {
        super(context, null);
    }

    public KeyboardEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyboardEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }
}
