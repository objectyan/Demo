package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.carlife.C0965R;

public class ImageSearchView extends RelativeLayout {
    /* renamed from: a */
    ImageView f9448a;

    public ImageSearchView(Context context) {
        super(context);
    }

    public ImageSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m10887a();
    }

    /* renamed from: a */
    private void m10887a() {
        this.f9448a = (ImageView) findViewById(C0965R.id.imageView);
    }
}
