package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.R;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;

public class CommonTipView extends RelativeLayout {
    /* renamed from: a */
    public static final int f7088a = 0;
    /* renamed from: b */
    public static final int f7089b = 1;
    /* renamed from: c */
    public static final int f7090c = 2;
    /* renamed from: d */
    private final int f7091d;
    /* renamed from: e */
    private final int f7092e;
    /* renamed from: f */
    private final int f7093f;
    /* renamed from: g */
    private String f7094g;
    /* renamed from: h */
    private int f7095h;
    /* renamed from: i */
    private int f7096i;
    /* renamed from: j */
    private TextView f7097j;
    /* renamed from: k */
    private ImageView f7098k;
    /* renamed from: l */
    private Button f7099l;
    /* renamed from: m */
    private C1526a f7100m;

    /* renamed from: com.baidu.carlife.view.CommonTipView$a */
    public interface C1526a {
        /* renamed from: a */
        void mo1575a();
    }

    /* renamed from: com.baidu.carlife.view.CommonTipView$1 */
    class C22081 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CommonTipView f7087a;

        C22081(CommonTipView this$0) {
            this.f7087a = this$0;
        }

        public void onClick(View v) {
            if (this.f7087a.f7100m != null) {
                this.f7087a.f7100m.mo1575a();
            }
        }
    }

    public void setCommonTipCallBack(C1526a commonTipCallBack) {
        this.f7100m = commonTipCallBack;
    }

    public CommonTipView(Context context) {
        this(context, null);
    }

    public CommonTipView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonTipView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7091d = 0;
        this.f7092e = 1;
        this.f7093f = 2;
        m8394a(context);
    }

    /* renamed from: a */
    private void m8394a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.common_tip_view, this, true);
        this.f7097j = (TextView) findViewById(R.id.tv_tip);
        this.f7098k = (ImageView) findViewById(R.id.iv_tip);
        this.f7099l = (Button) findViewById(R.id.btn_tip);
        this.f7099l.setOnClickListener(new C22081(this));
    }

    /* renamed from: a */
    public void m8396a() {
        m8399a(0, false);
    }

    /* renamed from: a */
    public void m8401a(boolean needCallBack) {
        m8399a(0, needCallBack);
    }

    /* renamed from: a */
    public void m8397a(int type) {
        m8399a(type, false);
    }

    /* renamed from: a */
    public void m8399a(int type, boolean needCallBack) {
        if (needCallBack) {
            this.f7098k.setVisibility(8);
            this.f7099l.setVisibility(0);
            if (type == 1) {
                this.f7097j.setText(R.string.common_error_nonetwork);
            } else if (type == 2) {
                this.f7097j.setText(R.string.common_error_nogps);
            } else {
                setDefaultTextView();
            }
            if (this.f7096i == 0) {
                this.f7099l.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(R.string.common_tip_reload));
                return;
            } else {
                this.f7099l.setText(this.f7096i);
                return;
            }
        }
        this.f7098k.setVisibility(0);
        this.f7099l.setVisibility(8);
        if (type == 1) {
            this.f7097j.setText(R.string.common_error_nonetwork);
            this.f7098k.setImageResource(R.drawable.com_ic_network_timeout);
        } else if (type == 2) {
            this.f7097j.setText(R.string.common_error_nogps);
            this.f7098k.setImageResource(R.drawable.com_ic_location_unavailable);
        } else {
            setDefaultTextView();
            if (this.f7095h == 0) {
                this.f7098k.setImageResource(R.drawable.com_ic_contents_empty);
            } else {
                this.f7098k.setImageResource(this.f7095h);
            }
        }
    }

    private void setDefaultTextView() {
        if (TextUtils.isEmpty(this.f7094g)) {
            this.f7097j.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(R.string.common_error_empty));
        } else {
            this.f7097j.setText(this.f7094g);
        }
    }

    /* renamed from: b */
    public void m8402b() {
        this.f7099l.performClick();
    }

    /* renamed from: b */
    public void m8403b(int tipTextId) {
        m8398a(tipTextId, 0);
    }

    /* renamed from: a */
    public void m8398a(int tipTextId, int resId) {
        m8400a(BaiduNaviApplication.getInstance().getString(tipTextId), resId);
    }

    /* renamed from: a */
    public void m8400a(String tipText, int resId) {
        this.f7094g = tipText;
        int type = m8395c(resId);
        if (type == 1) {
            this.f7096i = resId;
        } else if (type == 2) {
            this.f7095h = resId;
        } else {
            this.f7095h = 0;
            this.f7096i = 0;
        }
    }

    /* renamed from: c */
    private int m8395c(int rId) {
        if (rId == 0) {
            return 0;
        }
        try {
            String typeName = BaiduNaviApplication.getInstance().getResources().getResourceTypeName(rId);
            if (Regular.TYPE_STRING.equals(typeName)) {
                return 1;
            }
            if ("drawable".equals(typeName)) {
                return 2;
            }
            return 0;
        } catch (NotFoundException e) {
            return 0;
        }
    }

    public View getFocusView() {
        return this.f7099l;
    }
}
