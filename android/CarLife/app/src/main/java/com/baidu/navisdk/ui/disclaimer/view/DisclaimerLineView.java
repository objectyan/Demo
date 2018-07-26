package com.baidu.navisdk.ui.disclaimer.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;

public class DisclaimerLineView extends RelativeLayout {
    public DisclaimerLineView(Context context) {
        this(context, null);
    }

    public DisclaimerLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DisclaimerLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_disclaimer_line, this);
        TypedArray ta = context.obtainStyledAttributes(attrs, C4048R.styleable.DisclaimerLineView);
        String content = ta.getString(0);
        ta.recycle();
        TextView contentView = (TextView) view.findViewById(C4048R.id.content);
        if (!TextUtils.isEmpty(content)) {
            contentView.setText(String.format("　 %s", new Object[]{content}));
        }
    }
}
