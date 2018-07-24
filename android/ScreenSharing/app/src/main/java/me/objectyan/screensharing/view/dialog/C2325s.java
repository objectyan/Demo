package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import com.baidu.carlife.R;
import com.baidu.carlife.adpter.PhoneSoftInputListAdapter;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnDialogCancelListener;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.C1868q.C1561a;
import com.baidu.carlife.model.C1936n;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.C2323e;
import com.baidu.carlife.view.softinputphonekey.SoftInputPhoneKey;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import java.util.List;

/* compiled from: SoftInputPhoneDialog */
/* renamed from: com.baidu.carlife.view.dialog.s */
public class C2325s extends BaseDialog implements OnClickListener {
    /* renamed from: A */
    private C1443g f7611A;
    /* renamed from: B */
    private C1438c f7612B;
    /* renamed from: e */
    private boolean f7613e;
    /* renamed from: f */
    private EditText f7614f;
    /* renamed from: g */
    private View f7615g;
    /* renamed from: h */
    private ImageButton f7616h;
    /* renamed from: i */
    private SoftInputPhoneKey f7617i;
    /* renamed from: j */
    private SoftInputPhoneKey f7618j;
    /* renamed from: k */
    private SoftInputPhoneKey f7619k;
    /* renamed from: l */
    private SoftInputPhoneKey f7620l;
    /* renamed from: m */
    private SoftInputPhoneKey f7621m;
    /* renamed from: n */
    private SoftInputPhoneKey f7622n;
    /* renamed from: o */
    private SoftInputPhoneKey f7623o;
    /* renamed from: p */
    private SoftInputPhoneKey f7624p;
    /* renamed from: q */
    private SoftInputPhoneKey f7625q;
    /* renamed from: r */
    private SoftInputPhoneKey f7626r;
    /* renamed from: s */
    private SoftInputPhoneKey f7627s;
    /* renamed from: t */
    private SoftInputPhoneKey f7628t;
    /* renamed from: u */
    private ListView f7629u;
    /* renamed from: v */
    private PhoneSoftInputListAdapter f7630v;
    /* renamed from: w */
    private C1868q f7631w = C1868q.m7089f();
    /* renamed from: x */
    private View f7632x = null;
    /* renamed from: y */
    private C1561a f7633y = new C23206(this);
    /* renamed from: z */
    private OnKeyListener f7634z = new C23217(this);

    /* compiled from: SoftInputPhoneDialog */
    /* renamed from: com.baidu.carlife.view.dialog.s$1 */
    class C23151 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2325s f7600a;

        C23151(C2325s this$0) {
            this.f7600a = this$0;
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: SoftInputPhoneDialog */
    /* renamed from: com.baidu.carlife.view.dialog.s$2 */
    class C23162 implements OnLongClickListener {
        /* renamed from: a */
        final /* synthetic */ C2325s f7601a;

        C23162(C2325s this$0) {
            this.f7601a = this$0;
        }

        public boolean onLongClick(View v) {
            this.f7601a.m8828k();
            return true;
        }
    }

    /* compiled from: SoftInputPhoneDialog */
    /* renamed from: com.baidu.carlife.view.dialog.s$3 */
    class C23173 implements OnDialogCancelListener {
        /* renamed from: a */
        final /* synthetic */ C2325s f7602a;

        C23173(C2325s this$0) {
            this.f7602a = this$0;
        }

        public void onCancel() {
            this.f7602a.f7614f.setText("");
        }
    }

    /* compiled from: SoftInputPhoneDialog */
    /* renamed from: com.baidu.carlife.view.dialog.s$4 */
    class C23184 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ C2325s f7603a;

        C23184(C2325s this$0) {
            this.f7603a = this$0;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            C1936n model = (C1936n) parent.getItemAtPosition(position);
            if (model != null) {
                this.f7603a.f7631w.m7107a(this.f7603a.getContext(), model.f6105b);
                this.f7603a.mo1526d();
            }
        }
    }

    /* compiled from: SoftInputPhoneDialog */
    /* renamed from: com.baidu.carlife.view.dialog.s$5 */
    class C23195 implements TextWatcher {
        /* renamed from: a */
        final /* synthetic */ C2325s f7604a;

        C23195(C2325s this$0) {
            this.f7604a = this$0;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            String temp = s.toString();
            if (TextUtils.isEmpty(temp)) {
                this.f7604a.f7615g.setVisibility(4);
                this.f7604a.mo1530f();
            } else {
                this.f7604a.f7615g.setVisibility(0);
            }
            this.f7604a.f7614f.setSelection(temp.length());
            this.f7604a.m8819b(temp);
        }
    }

    /* compiled from: SoftInputPhoneDialog */
    /* renamed from: com.baidu.carlife.view.dialog.s$6 */
    class C23206 implements C1561a {
        /* renamed from: a */
        final /* synthetic */ C2325s f7605a;

        C23206(C2325s this$0) {
            this.f7605a = this$0;
        }

        /* renamed from: a */
        public void mo1595a() {
        }

        /* renamed from: a */
        public void mo1596a(int code) {
            this.f7605a.f7614f.append(String.valueOf((char) code));
        }

        /* renamed from: b */
        public void mo1597b() {
        }

        /* renamed from: c */
        public void mo1598c() {
        }
    }

    /* compiled from: SoftInputPhoneDialog */
    /* renamed from: com.baidu.carlife.view.dialog.s$7 */
    class C23217 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2325s f7606a;

        C23217(C2325s this$0) {
            this.f7606a = this$0;
        }

        public boolean onKey(View view, int keyCode, KeyEvent event) {
            if (event != null && event.getAction() == 0) {
                switch (keyCode) {
                    case 7:
                        this.f7606a.f7614f.append("0");
                        break;
                    case 8:
                        this.f7606a.f7614f.append("1");
                        break;
                    case 9:
                        this.f7606a.f7614f.append("2");
                        break;
                    case 10:
                        this.f7606a.f7614f.append("3");
                        break;
                    case 11:
                        this.f7606a.f7614f.append("4");
                        break;
                    case 12:
                        this.f7606a.f7614f.append("5");
                        break;
                    case 13:
                        this.f7606a.f7614f.append(C2578b.f8568g);
                        break;
                    case 14:
                        this.f7606a.f7614f.append("7");
                        break;
                    case 15:
                        this.f7606a.f7614f.append(NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL);
                        break;
                    case 16:
                        this.f7606a.f7614f.append("9");
                        break;
                    case 17:
                        this.f7606a.f7614f.append("*");
                        break;
                    case 18:
                        this.f7606a.f7614f.append("#");
                        break;
                    case 21:
                        if (!(this.f7606a.f7629u == null || view == null)) {
                            if (this.f7606a.f7629u.getVisibility() != 0) {
                                this.f7606a.mo1526d();
                                return true;
                            } else if (view.getId() == this.f7606a.f7629u.getId()) {
                                this.f7606a.mo1526d();
                                return true;
                            }
                        }
                        break;
                    case 22:
                        if (!(this.f7606a.f7629u == null || view == null || view.getId() == this.f7606a.f7629u.getId() || this.f7606a.f7630v == null || this.f7606a.f7630v.getCount() != 0)) {
                            return true;
                        }
                    case 28:
                        this.f7606a.m8828k();
                        return true;
                    case 67:
                        this.f7606a.m8827j();
                        return true;
                    case 157:
                        this.f7606a.f7614f.append("+");
                        break;
                }
            }
            return false;
        }
    }

    /* compiled from: SoftInputPhoneDialog */
    /* renamed from: com.baidu.carlife.view.dialog.s$a */
    private class C2324a extends C2323e {
        /* renamed from: a */
        final /* synthetic */ C2325s f7610a;

        private C2324a(C2325s c2325s) {
            this.f7610a = c2325s;
        }

        /* renamed from: b */
        public void mo1823b(String nameString) {
            if (this.f7610a.f7613e) {
                this.f7610a.f7631w.m7104a(nameString.charAt(0));
            } else {
                this.f7610a.f7614f.append(nameString);
            }
        }
    }

    /* renamed from: a */
    protected View mo1528a() {
        if (CarlifeScreenUtil.m4334m()) {
            LogUtil.d("BaseDialog", "phone: show big Screen input");
            this.f7632x = LayoutInflater.from(this.c).inflate(R.layout.layout_soft_input_phone_big_screen, null);
        } else {
            LogUtil.d("BaseDialog", "phone: show normal Screen input");
            this.f7632x = LayoutInflater.from(this.c).inflate(R.layout.layout_soft_input_phone, null);
        }
        this.f7632x.setOnClickListener(new C23151(this));
        return this.f7632x;
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7614f = (EditText) findViewById(R.id.et_input);
        this.f7615g = findViewById(R.id.btn_delete);
        this.f7615g.setOnClickListener(this);
        this.f7616h = (ImageButton) findViewById(R.id.btn_phone);
        this.f7616h.setOnClickListener(this);
        this.f7629u = (ListView) findViewById(R.id.lv_sug);
        this.f7629u.setOverScrollMode(2);
        this.f7617i = (SoftInputPhoneKey) findViewById(R.id.key1);
        this.f7618j = (SoftInputPhoneKey) findViewById(R.id.key2);
        this.f7619k = (SoftInputPhoneKey) findViewById(R.id.key3);
        this.f7620l = (SoftInputPhoneKey) findViewById(R.id.key4);
        this.f7621m = (SoftInputPhoneKey) findViewById(R.id.key5);
        this.f7622n = (SoftInputPhoneKey) findViewById(R.id.key6);
        this.f7623o = (SoftInputPhoneKey) findViewById(R.id.key7);
        this.f7624p = (SoftInputPhoneKey) findViewById(R.id.key8);
        this.f7625q = (SoftInputPhoneKey) findViewById(R.id.key9);
        this.f7626r = (SoftInputPhoneKey) findViewById(R.id.key_xing);
        this.f7627s = (SoftInputPhoneKey) findViewById(R.id.key0);
        this.f7628t = (SoftInputPhoneKey) findViewById(R.id.key_jing);
        C2324a mKeyListener = new C2324a();
        this.f7617i.setSoftInputKeyListener(mKeyListener);
        this.f7618j.setSoftInputKeyListener(mKeyListener);
        this.f7619k.setSoftInputKeyListener(mKeyListener);
        this.f7620l.setSoftInputKeyListener(mKeyListener);
        this.f7621m.setSoftInputKeyListener(mKeyListener);
        this.f7622n.setSoftInputKeyListener(mKeyListener);
        this.f7623o.setSoftInputKeyListener(mKeyListener);
        this.f7624p.setSoftInputKeyListener(mKeyListener);
        this.f7625q.setSoftInputKeyListener(mKeyListener);
        this.f7626r.setSoftInputKeyListener(mKeyListener);
        this.f7627s.setSoftInputKeyListener(mKeyListener);
        this.f7628t.setSoftInputKeyListener(mKeyListener);
        this.f7615g.setOnLongClickListener(new C23162(this));
        setOnDialogCancelListener(new C23173(this));
        setCanceledOnTouchOutside(true);
    }

    /* renamed from: i */
    private void m8826i() {
        if (this.f7613e) {
            this.f7616h.setImageResource(R.drawable.phone_ic_hangup);
            this.f7616h.setBackground(C2188r.m8331b(R.drawable.com_bg_btn_rounded_rectangle_c_selector));
            findViewById(R.id.temp1).setVisibility(8);
            this.f7629u.setVisibility(8);
            this.f7631w.m7108a(this.f7633y);
            return;
        }
        this.f7630v = new PhoneSoftInputListAdapter(getContext());
        this.f7629u.setAdapter(this.f7630v);
        this.f7629u.setOnItemClickListener(new C23184(this));
        this.f7616h.setImageResource(R.drawable.phone_ic_call);
        this.f7616h.setBackground(C2188r.m8331b(R.drawable.com_bg_btn_rounded_rectangle_a_selector));
        this.f7614f.setFilters(new InputFilter[]{new LengthFilter(40)});
        this.f7614f.addTextChangedListener(new C23195(this));
    }

    public C2325s(Context context, boolean isDTMF) {
        super(context);
        this.f7613e = isDTMF;
        m8826i();
    }

    public String getInputString() {
        return this.f7614f.getText().toString();
    }

    /* renamed from: a */
    public void mo1525a(OnDialogListener listener) {
        super.mo1525a(listener);
    }

    /* renamed from: d */
    public void mo1526d() {
        super.mo1526d();
        m8828k();
        this.f7612B = null;
        this.f7611A = null;
    }

    /* renamed from: a */
    public void m8831a(boolean bBigScreen) {
        LayoutParams para1;
        if (bBigScreen) {
            if (this.f7629u != null) {
                para1 = this.f7629u.getLayoutParams();
                para1.width = this.c.getResources().getDimensionPixelSize(R.dimen.soft_input_phone_dialog_width);
                this.f7629u.setLayoutParams(para1);
                this.f7632x.requestLayout();
            }
        } else if (this.f7629u != null) {
            para1 = this.f7629u.getLayoutParams();
            para1.width = this.c.getResources().getDimensionPixelSize(R.dimen.soft_input_phone_contact_width);
            this.f7629u.setLayoutParams(para1);
            this.f7632x.requestLayout();
        }
    }

    /* renamed from: b */
    private synchronized void m8819b(String input) {
        this.f7630v.m3219a(input);
        List contracts = this.f7631w.m7112b(input);
        if (contracts == null || contracts.isEmpty()) {
            this.f7629u.setVisibility(8);
        } else {
            this.f7630v.m3220a(contracts);
            if (this.f7629u.hasFocus() && this.f7630v.getCount() == 0) {
                mo1530f();
            }
            this.f7630v.notifyDataSetChanged();
            this.f7629u.setVisibility(0);
            this.f7629u.setSelection(0);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_delete:
                m8827j();
                return;
            case R.id.btn_phone:
                if (this.f7613e) {
                    this.f7631w.m7106a(getContext());
                    mo1526d();
                    return;
                } else if (!TextUtils.isEmpty(this.f7614f.getText().toString())) {
                    this.f7631w.m7107a(getContext(), this.f7614f.getText().toString());
                    mo1526d();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: j */
    private void m8827j() {
        String temp = this.f7614f.getText().toString();
        if (!TextUtils.isEmpty(temp)) {
            this.f7614f.setText(temp.substring(0, temp.length() - 1));
        }
    }

    /* renamed from: k */
    private void m8828k() {
        this.f7614f.setText("");
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7611A == null) {
            this.f7611A = new C1443g(findViewById(R.id.layout_right), 10);
            this.f7611A.m5300d(this.f7615g).m5300d(this.f7617i.getFocusView()).m5300d(this.f7618j.getFocusView()).m5300d(this.f7619k.getFocusView()).m5300d(this.f7620l.getFocusView()).m5300d(this.f7621m.getFocusView()).m5300d(this.f7622n.getFocusView()).m5300d(this.f7623o.getFocusView()).m5300d(this.f7624p.getFocusView()).m5300d(this.f7625q.getFocusView()).m5300d(this.f7626r.getFocusView()).m5300d(this.f7627s.getFocusView()).m5300d(this.f7628t.getFocusView()).m5300d(this.f7616h);
            this.f7611A.m5297b(this.f7617i.getFocusView());
        }
        if (this.f7612B == null) {
            this.f7612B = new C1438c(this.f7629u, 8);
        }
        this.f7612B.m5249a(this.f7634z);
        this.f7611A.m5295a(this.f7634z);
        this.f7612B.m5244a(true);
        this.f7611A.m5244a(true);
        C1440d.m5251a().m5253a(this.f7612B, this.f7611A);
        C1440d.m5251a().m5268h(this.f7611A);
    }
}
