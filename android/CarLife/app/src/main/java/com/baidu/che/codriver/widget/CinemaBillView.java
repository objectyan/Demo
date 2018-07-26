package com.baidu.che.codriver.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.util.C2714a;

public class CinemaBillView extends LinearLayout {
    /* renamed from: a */
    View f9401a;
    /* renamed from: b */
    C2866a f9402b;

    /* renamed from: com.baidu.che.codriver.widget.CinemaBillView$a */
    public static class C2866a {
        /* renamed from: a */
        public NetworkImageView f9397a;
        /* renamed from: b */
        public TextView f9398b;
        /* renamed from: c */
        public RatingBar f9399c;
        /* renamed from: d */
        public TextView f9400d;

        /* renamed from: a */
        public void m10847a() {
            this.f9397a.setVisibility(4);
            this.f9399c.setVisibility(4);
            this.f9398b.setText("");
            this.f9400d.setText("");
        }

        /* renamed from: a */
        public void m10848a(String name) {
            this.f9398b.setVisibility(0);
            this.f9398b.setText(name);
        }

        /* renamed from: b */
        public void m10849b(String score) {
            this.f9399c.setVisibility(8);
            TextView textView = this.f9400d;
            if (TextUtils.isEmpty(score)) {
                score = "暂无评分";
            }
            textView.setText(score);
        }

        /* renamed from: c */
        public void m10850c(String url) {
            this.f9397a.setImageUrl(url, C2714a.m10135a());
            if (this.f9397a.getVisibility() != 0) {
                this.f9397a.setVisibility(0);
            }
        }
    }

    public CinemaBillView(Context context) {
        this(context, null);
    }

    public CinemaBillView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public CinemaBillView(Context context, AttributeSet attr, int defValue) {
        super(context, attr, defValue);
        m10851a();
    }

    /* renamed from: a */
    private void m10851a() {
        removeAllViews();
        this.f9401a = inflate(getContext(), C0965R.layout.multi_movie_card, this);
        if (this.f9402b == null) {
            this.f9402b = new C2866a();
        }
        this.f9402b.f9397a = (NetworkImageView) this.f9401a.findViewById(C0965R.id.multi_movie_image);
        this.f9402b.f9398b = (TextView) this.f9401a.findViewById(C0965R.id.multi_movie_name);
        this.f9402b.f9399c = (RatingBar) this.f9401a.findViewById(C0965R.id.multi_movie_ratingbar);
        this.f9402b.f9400d = (TextView) this.f9401a.findViewById(C0965R.id.multi_movie_score);
        setTag(C0965R.string.key_cinema_holder, this.f9402b);
    }
}
