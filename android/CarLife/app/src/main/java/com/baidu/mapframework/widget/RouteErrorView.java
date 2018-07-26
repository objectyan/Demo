package com.baidu.mapframework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;

public class RouteErrorView extends RelativeLayout {
    /* renamed from: a */
    private View f19345a = findViewById(C0965R.id.route_error_repeat_button);
    /* renamed from: b */
    private TextView f19346b = ((TextView) findViewById(C0965R.id.route_error_text_button));
    /* renamed from: c */
    private View f19347c = findViewById(C0965R.id.route_error_repeat_text);

    public RouteErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(C0965R.layout.route_error_view, this);
    }

    public void setText(String text) {
        this.f19346b.setText(text);
    }

    public void setRepeatButtonListener(OnClickListener listener) {
        this.f19345a.setOnClickListener(listener);
    }

    public void setmRepeatButtonGone() {
        if (this.f19347c != null) {
            this.f19347c.setVisibility(8);
        }
    }

    public void setmRepeatButtonVisible() {
        if (this.f19347c != null) {
            this.f19347c.setVisibility(0);
        }
    }
}
