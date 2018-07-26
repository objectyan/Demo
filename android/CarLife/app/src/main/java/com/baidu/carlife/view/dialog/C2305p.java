package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1192c;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2186p;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;

/* compiled from: NewFeatureDialog */
/* renamed from: com.baidu.carlife.view.dialog.p */
public class C2305p extends BaseDialog implements OnClickListener {
    /* renamed from: e */
    private C1443g f7559e;
    /* renamed from: f */
    private ImageView f7560f;
    /* renamed from: g */
    private ImageView f7561g;
    /* renamed from: h */
    private Button f7562h;
    /* renamed from: i */
    private String f7563i;

    public C2305p(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(C0965R.layout.new_feature_introduction, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7560f = (ImageView) findViewById(C0965R.id.iv_display_icon);
        this.f7561g = (ImageView) findViewById(C0965R.id.iv_display_hint);
        this.f7562h = (Button) findViewById(C0965R.id.btn_close);
        this.f7562h.setOnClickListener(this);
        setOnClickListener(null);
        LayoutParams layoutParams = new LayoutParams(ScreenUtil.getInstance().dip2px((int) RouteLineResConst.LINE_DARK_RED_NORMAL), ScreenUtil.getInstance().dip2px(44));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = ScreenUtil.getInstance().dip2px(24);
        this.f7562h.setLayoutParams(layoutParams);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.btn_close:
                mo1526d();
                return;
            default:
                return;
        }
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7559e == null) {
            this.f7559e = new C1443g(findViewById(C0965R.id.dialog_layout_newfeature), 12);
            this.f7559e.m5300d(findViewById(C0965R.id.btn_close));
        }
        this.f7559e.m5244a(true);
        C1440d.m5251a().m5259c(this.f7559e);
    }

    /* renamed from: g */
    public void mo1527g() {
        C1440d.m5251a().m5258c();
    }

    /* renamed from: a */
    public void m8776a(int[] pos, int iconId, int hintId) {
        this.f7563i = "HOME";
        this.f7560f.setX((float) pos[0]);
        this.f7560f.setY((float) pos[1]);
        this.f7560f.setImageResource(iconId);
        hintPos = new int[2];
        int[] hintSize = new int[]{pos[0] - ScreenUtil.getInstance().dip2px(48), pos[1] + ScreenUtil.getInstance().dip2px(72)};
        hintSize[0] = ScreenUtil.getInstance().dip2px(356);
        hintSize[1] = ScreenUtil.getInstance().dip2px(88);
        this.f7561g.setX((float) hintPos[0]);
        this.f7561g.setY((float) hintPos[1]);
        this.f7561g.setImageResource(hintId);
        this.f7561g.setLayoutParams(new LayoutParams(hintSize[0], hintSize[1]));
    }

    /* renamed from: a */
    public void m8775a(int iconId, int hintId) {
        this.f7563i = "VOICE";
        this.f7560f.setX(0.0f);
        this.f7560f.setY(0.0f);
        LayoutParams layoutParams = new LayoutParams(ScreenUtil.getInstance().dip2px(48), ScreenUtil.getInstance().dip2px(48));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = ScreenUtil.getInstance().dip2px(8);
        this.f7560f.setImageResource(iconId);
        this.f7560f.setLayoutParams(layoutParams);
        this.f7561g.setX(0.0f);
        this.f7561g.setY(0.0f);
        layoutParams = new LayoutParams(ScreenUtil.getInstance().dip2px((int) RGHUDDataModel.MAX_CAR_SPEED), ScreenUtil.getInstance().dip2px(64));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = ScreenUtil.getInstance().dip2px(16);
        layoutParams.topMargin = ScreenUtil.getInstance().dip2px(48);
        this.f7561g.setImageResource(hintId);
        this.f7561g.setLayoutParams(layoutParams);
    }

    /* renamed from: d */
    public void mo1526d() {
        super.mo1526d();
        if ("VOICE".equals(this.f7563i)) {
            C1192c.m4069a().m4086g(false);
        } else if ("HOME".equals(this.f7563i)) {
            C2186p.m8304a().m8323c(C1253f.f3570if, false);
        }
    }

    protected int getCustomWidth() {
        return C1249d.m4331a().m4351h();
    }

    public int getCustomHeight() {
        return C1249d.m4331a().m4352i();
    }
}
