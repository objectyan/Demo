package com.baidu.che.codriver.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.protocol.data.nlp.StockData;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2709k;
import com.baidu.che.codriver.util.C2714a;
import com.baidu.che.codriver.util.C2725h;

public class StockCardView extends LinearLayout {
    /* renamed from: a */
    public static final String f9486a = StockCardView.class.getSimpleName();
    /* renamed from: b */
    private TextView f9487b;
    /* renamed from: c */
    private NetworkImageView f9488c;
    /* renamed from: d */
    private Context f9489d;

    public StockCardView(Context context) {
        super(context, null);
        this.f9489d = context;
    }

    public StockCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.f9489d = context;
    }

    public StockCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f9489d = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m10906a();
    }

    /* renamed from: a */
    private void m10906a() {
        this.f9487b = (TextView) findViewById(C0965R.id.stock_title);
        this.f9488c = (NetworkImageView) findViewById(C0965R.id.stock_pic);
    }

    /* renamed from: a */
    public void m10907a(C2549b model) {
        C2725h.m10207b(f9486a, "updateQrCodeInfo");
        StockData stockData = ((C2709k) model).f8881a;
        try {
            this.f9487b.setText(model.f8465g);
            if (!TextUtils.isEmpty(stockData.kurl)) {
                this.f9488c.setImageUrl(stockData.kurl, C2714a.m10135a());
            }
        } catch (NullPointerException mNull) {
            C2725h.m10214e("ConversationAdapter", mNull.getMessage().toString());
        }
    }
}
