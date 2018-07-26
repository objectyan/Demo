package com.baidu.ufosdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: InputContactDialog */
public final class cx extends Dialog {
    /* renamed from: a */
    private final int f21642a = C0965R.raw.bdspeech_recognition_error;
    /* renamed from: b */
    private final int f21643b = C0965R.raw.bdspeech_recognition_start;
    /* renamed from: c */
    private final int f21644c = C0965R.raw.bdspeech_recognition_start_16k;
    /* renamed from: d */
    private final int f21645d = C0965R.raw.bdspeech_recognition_success;
    /* renamed from: e */
    private final int f21646e = C0965R.raw.bdspeech_speech_end;
    /* renamed from: f */
    private final int f21647f = C0965R.raw.cruiser_pass;
    /* renamed from: g */
    private final int f21648g = C0965R.raw.dididi;
    /* renamed from: h */
    private Context f21649h;
    /* renamed from: i */
    private da f21650i;
    /* renamed from: j */
    private EditText f21651j;
    /* renamed from: k */
    private String f21652k = "";

    public cx(Context context, String str) {
        super(context);
        this.f21649h = context;
        this.f21652k = str;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(C5167a.f21379y);
        gradientDrawable.setCornerRadius((float) C5216i.m17757a(this.f21649h, 4.0f));
        View relativeLayout = new RelativeLayout(this.f21649h);
        relativeLayout.setId(C0965R.raw.bdspeech_recognition_error);
        relativeLayout.setBackgroundDrawable(gradientDrawable);
        View textView = new TextView(this.f21649h);
        textView.setId(C0965R.raw.dididi);
        textView.setTextColor(-16777216);
        textView.setTextSize(18.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setText("邮箱/手机/QQ号");
        textView.setGravity(17);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(C5216i.m17757a(this.f21649h, 10.0f), C5216i.m17757a(this.f21649h, 20.0f), C5216i.m17757a(this.f21649h, 10.0f), 0);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
        View textView2 = new TextView(this.f21649h);
        textView2.setId(C0965R.raw.bdspeech_recognition_start);
        textView2.setTextColor(-16777216);
        textView2.setTextSize(15.0f);
        textView2.setText("您的反馈将提交我们跟进，请留下您的联系方式。");
        textView2.setGravity(17);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(C5216i.m17757a(this.f21649h, 20.0f), C5216i.m17757a(this.f21649h, 20.0f), C5216i.m17757a(this.f21649h, 20.0f), 0);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        relativeLayout.addView(textView2, layoutParams2);
        int a = C5216i.m17757a(this.f21649h, 4.0f);
        int parseColor = Color.parseColor("#2E3135");
        int parseColor2 = Color.parseColor("#DFDFE0");
        Drawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(parseColor2);
        gradientDrawable2.setCornerRadius((float) a);
        gradientDrawable2.setStroke(1, parseColor);
        this.f21651j = new EditText(this.f21649h);
        this.f21651j.setId(C0965R.raw.bdspeech_recognition_start_16k);
        this.f21651j.setTextSize(15.0f);
        if (this.f21652k.length() > 0) {
            this.f21651j.setText(this.f21652k);
            this.f21651j.setSelection(this.f21652k.length());
        }
        this.f21651j.setHint("请输入您的联系方式");
        this.f21651j.setBackgroundDrawable(gradientDrawable2);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.setMargins(C5216i.m17757a(this.f21649h, 25.0f), C5216i.m17757a(this.f21649h, 20.0f), C5216i.m17757a(this.f21649h, 25.0f), C5216i.m17757a(this.f21649h, 10.0f));
        relativeLayout.addView(this.f21651j, layoutParams3);
        textView = new LinearLayout(this.f21649h);
        textView.setId(C0965R.raw.bdspeech_recognition_success);
        textView.setOrientation(0);
        textView.setBackgroundColor(0);
        textView.setGravity(17);
        textView2 = new TextView(this.f21649h);
        textView2.setId(C0965R.raw.bdspeech_speech_end);
        textView2.setText("取消");
        textView2.setTextColor(C5216i.m17759a(C5167a.f21377w, C5167a.f21375u, C5167a.f21377w, C5167a.f21377w));
        textView2.setBackgroundColor(0);
        textView2.setTextSize(17.0f);
        textView2.setGravity(17);
        textView2.setOnClickListener(new cz());
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        textView.addView(textView2, layoutParams2);
        textView2 = new View(this.f21649h);
        layoutParams2 = new LinearLayout.LayoutParams(C5216i.m17757a(this.f21649h, 0.8f), -1);
        layoutParams2.setMargins(0, C5216i.m17757a(this.f21649h, 10.0f), 0, 0);
        textView2.setBackgroundColor(-6710887);
        textView.addView(textView2, layoutParams2);
        textView2 = new TextView(this.f21649h);
        textView2.setId(C0965R.raw.cruiser_pass);
        textView2.setText("提交");
        textView2.setTextColor(C5216i.m17759a(C5167a.f21377w, C5167a.f21375u, C5167a.f21377w, C5167a.f21377w));
        textView2.setBackgroundColor(0);
        textView2.setTextSize(17.0f);
        textView2.setGravity(17);
        textView2.setOnClickListener(new cz());
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        textView.addView(textView2, layoutParams2);
        layoutParams = new RelativeLayout.LayoutParams(-1, C5216i.m17757a(this.f21649h, 50.0f));
        layoutParams.addRule(3, this.f21651j.getId());
        relativeLayout.addView(textView, layoutParams);
        setContentView(relativeLayout, new LayoutParams(-1, -2));
        this.f21651j.addTextChangedListener(new cy(this));
    }

    /* renamed from: a */
    public final void m17722a(da daVar) {
        this.f21650i = daVar;
    }
}
