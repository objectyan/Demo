package com.baidu.carlife.fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

public class EditRescueInfoFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    public static final String f4270a = EditRescueInfoFragment.class.getSimpleName();
    /* renamed from: b */
    TextWatcher f4271b = new C14531(this);
    /* renamed from: c */
    private Button f4272c;
    /* renamed from: d */
    private EditText f4273d;
    /* renamed from: e */
    private EditText f4274e;
    /* renamed from: f */
    private EditText f4275f;
    /* renamed from: g */
    private EditText f4276g;
    /* renamed from: h */
    private EditText f4277h;
    /* renamed from: i */
    private EditText f4278i;
    /* renamed from: j */
    private String f4279j;
    /* renamed from: k */
    private String f4280k;
    /* renamed from: l */
    private String f4281l;
    /* renamed from: m */
    private String f4282m;
    /* renamed from: n */
    private String f4283n;
    /* renamed from: o */
    private String f4284o;
    /* renamed from: p */
    private String f4285p;
    /* renamed from: q */
    private C1953c f4286q;

    /* renamed from: com.baidu.carlife.fragment.EditRescueInfoFragment$1 */
    class C14531 implements TextWatcher {
        /* renamed from: a */
        final /* synthetic */ EditRescueInfoFragment f4267a;

        C14531(EditRescueInfoFragment this$0) {
            this.f4267a = this$0;
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            C1260i.m4440c(EditRescueInfoFragment.f4270a, "onTextChanged");
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            C1260i.m4440c(EditRescueInfoFragment.f4270a, "beforeTextChanged");
        }

        public void afterTextChanged(Editable s) {
            if (TextUtils.isEmpty(this.f4267a.f4273d.getText().toString()) && TextUtils.isEmpty(this.f4267a.f4274e.getText().toString()) && TextUtils.isEmpty(this.f4267a.f4275f.getText().toString()) && TextUtils.isEmpty(this.f4267a.f4276g.getText().toString()) && TextUtils.isEmpty(this.f4267a.f4277h.getText().toString()) && TextUtils.isEmpty(this.f4267a.f4278i.getText().toString())) {
                this.f4267a.f4272c.setSelected(false);
                this.f4267a.f4272c.setClickable(false);
                this.f4267a.f4272c.setAlpha(0.2f);
                return;
            }
            this.f4267a.f4272c.setSelected(true);
            this.f4267a.f4272c.setClickable(true);
            this.f4267a.f4272c.setAlpha(1.0f);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.EditRescueInfoFragment$2 */
    class C14542 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ EditRescueInfoFragment f4268a;

        C14542(EditRescueInfoFragment this$0) {
            this.f4268a = this$0;
        }

        public void onClick() {
            this.f4268a.m5317b();
            this.f4268a.back();
            C1261k.m4461b(3011);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.EditRescueInfoFragment$3 */
    class C14553 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ EditRescueInfoFragment f4269a;

        C14553(EditRescueInfoFragment this$0) {
            this.f4269a = this$0;
        }

        public void onClick() {
            this.f4269a.back();
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        C1260i.m4440c(f4270a, "onCreateContentView");
        View contentView = inflater.inflate(C0965R.layout.frag_edit_rescue_info, null);
        setCommonTitleBar(contentView, getResources().getString(C0965R.string.rescue_contact_info));
        this.f4272c = (Button) contentView.findViewById(C0965R.id.btn_save_info);
        this.f4273d = (EditText) contentView.findViewById(C0965R.id.et_rescue_name);
        this.f4274e = (EditText) contentView.findViewById(C0965R.id.et_rescue_phone);
        this.f4275f = (EditText) contentView.findViewById(C0965R.id.et_rescue_car_num);
        this.f4276g = (EditText) contentView.findViewById(C0965R.id.et_rescue_car_color);
        this.f4277h = (EditText) contentView.findViewById(C0965R.id.et_rescue_contact_name);
        this.f4278i = (EditText) contentView.findViewById(C0965R.id.et_rescue_contact_phone);
        ImageButton btnBack = (ImageButton) contentView.findViewById(C0965R.id.ib_left);
        this.f4272c.setOnClickListener(this);
        this.f4272c.setSelected(false);
        btnBack.setOnClickListener(this);
        this.f4273d.addTextChangedListener(this.f4271b);
        this.f4274e.addTextChangedListener(this.f4271b);
        this.f4275f.addTextChangedListener(this.f4271b);
        this.f4276g.addTextChangedListener(this.f4271b);
        this.f4277h.addTextChangedListener(this.f4271b);
        this.f4278i.addTextChangedListener(this.f4271b);
        this.f4279j = C2186p.m8304a().m8309a(RoadRescueFragment.f4749b, null);
        this.f4280k = C2186p.m8304a().m8309a(RoadRescueFragment.f4750c, null);
        this.f4281l = C2186p.m8304a().m8309a(RoadRescueFragment.f4753f, null);
        this.f4282m = C2186p.m8304a().m8309a(RoadRescueFragment.f4754g, null);
        this.f4283n = C2186p.m8304a().m8309a(RoadRescueFragment.f4751d, null);
        this.f4284o = C2186p.m8304a().m8309a(RoadRescueFragment.f4752e, null);
        this.f4285p = this.f4279j + this.f4280k + this.f4281l + this.f4282m + this.f4283n + this.f4284o;
        if (!TextUtils.isEmpty(this.f4279j)) {
            this.f4273d.setText(this.f4279j);
        }
        if (!TextUtils.isEmpty(this.f4280k)) {
            this.f4274e.setText(this.f4280k);
        }
        if (!TextUtils.isEmpty(this.f4281l)) {
            this.f4277h.setText(this.f4281l);
        }
        if (!TextUtils.isEmpty(this.f4282m)) {
            this.f4278i.setText(this.f4282m);
        }
        if (!TextUtils.isEmpty(this.f4283n)) {
            this.f4275f.setText(this.f4283n);
        }
        if (!TextUtils.isEmpty(this.f4284o)) {
            this.f4276g.setText(this.f4284o);
        }
        if (TextUtils.isEmpty(this.f4279j) && TextUtils.isEmpty(this.f4280k) && TextUtils.isEmpty(this.f4281l) && TextUtils.isEmpty(this.f4282m) && TextUtils.isEmpty(this.f4283n) && TextUtils.isEmpty(this.f4284o)) {
            this.f4272c.setSelected(false);
            this.f4272c.setClickable(false);
            this.f4272c.setAlpha(0.2f);
        } else {
            this.f4272c.setSelected(true);
            this.f4272c.setClickable(true);
            this.f4272c.setAlpha(1.0f);
        }
        return contentView;
    }

    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            setBottomBarStatus(false);
        }
        super.onHiddenChanged(hidden);
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
        this.f4272c.setBackground(C2188r.m8331b(C0965R.drawable.com_bg_btn_a_selector));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.ib_left:
                m5319c();
                String name = this.f4273d.getText().toString();
                String phone = this.f4274e.getText().toString();
                String carNum = this.f4275f.getText().toString();
                String carColor = this.f4276g.getText().toString();
                String contactName = this.f4277h.getText().toString();
                String modifyStr = name + phone + carNum + carColor + contactName + this.f4278i.getText().toString();
                this.f4279j = C2186p.m8304a().m8309a(RoadRescueFragment.f4749b, null);
                this.f4280k = C2186p.m8304a().m8309a(RoadRescueFragment.f4750c, null);
                this.f4281l = C2186p.m8304a().m8309a(RoadRescueFragment.f4753f, null);
                this.f4282m = C2186p.m8304a().m8309a(RoadRescueFragment.f4754g, null);
                this.f4283n = C2186p.m8304a().m8309a(RoadRescueFragment.f4751d, null);
                this.f4284o = C2186p.m8304a().m8309a(RoadRescueFragment.f4752e, null);
                this.f4285p = this.f4279j + this.f4280k + this.f4283n + this.f4284o + this.f4281l + this.f4282m;
                if (TextUtils.isEmpty(modifyStr)) {
                    back();
                    return;
                } else if (TextUtils.isEmpty(modifyStr) || !modifyStr.equals(this.f4285p)) {
                    m5315a();
                    return;
                } else {
                    back();
                    return;
                }
            case C0965R.id.btn_save_info:
                if (!TextUtils.isEmpty(this.f4273d.getText().toString()) || !TextUtils.isEmpty(this.f4274e.getText().toString()) || !TextUtils.isEmpty(this.f4275f.getText().toString()) || !TextUtils.isEmpty(this.f4276g.getText().toString()) || !TextUtils.isEmpty(this.f4277h.getText().toString()) || !TextUtils.isEmpty(this.f4278i.getText().toString())) {
                    m5317b();
                    back();
                    C1261k.m4461b(3011);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m5315a() {
        if (this.f4286q == null) {
            this.f4286q = new C1953c(getContext()).m7435a((int) C0965R.string.rescue_save_contact_info).m7457g(17).m7447c((int) C0965R.string.alert_confirm).m7458q().m7450d((int) C0965R.string.alert_cancel);
            this.f4286q.m7438a(new C14542(this));
            this.f4286q.m7443b(new C14553(this));
        }
        showDialog(this.f4286q);
    }

    public boolean onBackPressed() {
        String name = this.f4273d.getText().toString();
        String phone = this.f4274e.getText().toString();
        String carNum = this.f4275f.getText().toString();
        String carColor = this.f4276g.getText().toString();
        String contactName = this.f4277h.getText().toString();
        String modifyStr = name + phone + carNum + carColor + contactName + this.f4278i.getText().toString();
        this.f4279j = C2186p.m8304a().m8309a(RoadRescueFragment.f4749b, null);
        this.f4280k = C2186p.m8304a().m8309a(RoadRescueFragment.f4750c, null);
        this.f4281l = C2186p.m8304a().m8309a(RoadRescueFragment.f4753f, null);
        this.f4282m = C2186p.m8304a().m8309a(RoadRescueFragment.f4754g, null);
        this.f4283n = C2186p.m8304a().m8309a(RoadRescueFragment.f4751d, null);
        this.f4284o = C2186p.m8304a().m8309a(RoadRescueFragment.f4752e, null);
        this.f4285p = this.f4279j + this.f4280k + this.f4283n + this.f4284o + this.f4281l + this.f4282m;
        if (TextUtils.isEmpty(modifyStr)) {
            return false;
        }
        C1260i.m4440c(f4270a, "mOriginalStr=" + this.f4285p + "\n,modifyStr=" + modifyStr);
        if (!TextUtils.isEmpty(modifyStr) && modifyStr.equals(this.f4285p)) {
            return false;
        }
        m5315a();
        return true;
    }

    /* renamed from: b */
    private void m5317b() {
        C2186p.m8304a().m8319b(RoadRescueFragment.f4749b, this.f4273d.getText().toString());
        C2186p.m8304a().m8319b(RoadRescueFragment.f4750c, this.f4274e.getText().toString());
        C2186p.m8304a().m8319b(RoadRescueFragment.f4751d, this.f4275f.getText().toString());
        C2186p.m8304a().m8319b(RoadRescueFragment.f4752e, this.f4276g.getText().toString());
        C2186p.m8304a().m8319b(RoadRescueFragment.f4753f, this.f4277h.getText().toString());
        C2186p.m8304a().m8319b(RoadRescueFragment.f4754g, this.f4278i.getText().toString());
        C2186p.m8304a().m8323c(RoadRescueFragment.f4755h, true);
        StatisticManager.onEvent(StatisticConstants.HOME_DISCOVERY_RESCUE_INFO, StatisticConstants.HOME_DISCOVERY_RESCUE_INFO);
        StatisticManager.onEvent(StatisticConstants.DISCOVER_HJY_0004);
    }

    /* renamed from: c */
    private void m5319c() {
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService("input_method");
        View view = mActivity.getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }
}
