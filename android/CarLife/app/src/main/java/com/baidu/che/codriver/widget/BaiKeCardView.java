package com.baidu.che.codriver.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.model.BaiKeConversationModel;
import com.baidu.che.codriver.model.BaiKeConversationModel.BaiKe;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.util.C2714a;

public class BaiKeCardView extends LinearLayout {
    /* renamed from: a */
    private TextView f9385a;
    /* renamed from: b */
    private NetworkImageView f9386b;
    /* renamed from: c */
    private TextView f9387c;
    /* renamed from: d */
    private TextView f9388d;

    public BaiKeCardView(Context context) {
        this(context, null);
    }

    public BaiKeCardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaiKeCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs == null) {
            LayoutInflater.from(context).inflate(C0965R.layout.item_baike, this);
            m10843a();
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m10843a();
    }

    /* renamed from: a */
    private void m10843a() {
        this.f9385a = (TextView) findViewById(C0965R.id.baikeIntroductionTV);
        this.f9386b = (NetworkImageView) findViewById(C0965R.id.baikeImageView);
        this.f9387c = (TextView) findViewById(C0965R.id.baikeTitleTv);
        this.f9388d = (TextView) findViewById(C0965R.id.baikeDetailTv);
    }

    /* renamed from: a */
    public void m10844a(C2549b model) {
        if (model != null) {
            BaiKe baiKe = ((BaiKeConversationModel) model).f8470a;
            if (baiKe != null) {
                this.f9386b.setVisibility(0);
                if (baiKe.images == null || baiKe.images.size() <= 0) {
                    this.f9386b.setImageResource(C0965R.drawable.default_normal);
                } else {
                    this.f9386b.setImageUrl((String) baiKe.images.get(0), C2714a.m10135a());
                }
                if (TextUtils.isEmpty(baiKe.title)) {
                    this.f9387c.setVisibility(8);
                } else {
                    this.f9387c.setVisibility(0);
                    this.f9387c.setText(baiKe.title);
                }
                if (TextUtils.isEmpty(model.f8465g)) {
                    this.f9388d.setText("暂无介绍");
                    this.f9385a.setVisibility(8);
                    return;
                }
                this.f9385a.setText(m10842a(model.f8465g));
                this.f9385a.setVisibility(0);
                this.f9388d.setText(model.f8465g);
                return;
            }
            this.f9385a.setVisibility(8);
            this.f9387c.setVisibility(8);
            this.f9386b.setVisibility(8);
            this.f9388d.setText(TextUtils.isEmpty(model.f8465g) ? "暂无介绍" : model.f8465g);
        }
    }

    /* renamed from: a */
    private String m10842a(String content) {
        int jhIndex = content.indexOf("。");
        int fhIndexENG = content.indexOf(";");
        int fhIndexCH = content.indexOf("；");
        int gthIndexENG = content.indexOf("!");
        int gthIndexCH = content.indexOf("！");
        int[] tempIndexs = new int[]{fhIndexENG, fhIndexCH, gthIndexENG, gthIndexCH};
        int index = jhIndex;
        int i = 0;
        while (i < tempIndexs.length) {
            if (index <= 0) {
                index = tempIndexs[i];
            } else if (tempIndexs[i] > 0 && tempIndexs[i] < index) {
                index = tempIndexs[i];
            }
            i++;
        }
        if (index > 0) {
            return content.substring(0, index);
        }
        int dhIndexENG = content.indexOf(",");
        int dhIndexCH = content.indexOf("，");
        if (dhIndexCH > 0 && dhIndexENG > 0) {
            if (dhIndexCH >= dhIndexENG) {
                dhIndexCH = dhIndexENG;
            }
            return content.substring(0, dhIndexCH);
        } else if (dhIndexCH > 0) {
            return content.substring(0, dhIndexCH);
        } else {
            if (dhIndexENG > 0) {
                return content.substring(0, dhIndexENG);
            }
            return content;
        }
    }
}
