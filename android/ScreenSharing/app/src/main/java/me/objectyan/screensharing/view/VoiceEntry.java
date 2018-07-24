package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.baidu.carlife.R;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.util.C2188r;

public class VoiceEntry extends ImageView {

    /* renamed from: com.baidu.carlife.view.VoiceEntry$1 */
    class C22421 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ VoiceEntry f7304a;

        C22421(VoiceEntry this$0) {
            this.f7304a = this$0;
        }

        public void onClick(View v) {
            C1912n.m7270a().m7307f();
        }
    }

    public VoiceEntry(Context context) {
        this(context, null);
    }

    public VoiceEntry(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VoiceEntry(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m8521b();
    }

    /* renamed from: a */
    public void m8522a() {
        setBackground(C2188r.m8331b(R.drawable.com_bg_btn_selector));
        setImageDrawable(C2188r.m8331b(R.drawable.com_ic_voice));
    }

    /* renamed from: b */
    private void m8521b() {
        setOnClickListener(new C22421(this));
        m8522a();
    }
}
