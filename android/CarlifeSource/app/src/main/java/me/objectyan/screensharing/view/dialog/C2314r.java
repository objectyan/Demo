package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;

/* compiled from: SoftInputDialog */
/* renamed from: com.baidu.carlife.view.dialog.r */
public class C2314r extends BaseDialog implements OnClickListener {
    /* renamed from: e */
    private static final int f7582e = 0;
    /* renamed from: f */
    private static final int f7583f = 1;
    /* renamed from: g */
    private static final String f7584g = "abc";
    /* renamed from: h */
    private static final String f7585h = "123";
    /* renamed from: i */
    private String[] f7586i;
    /* renamed from: j */
    private String[] f7587j;
    /* renamed from: k */
    private EditText f7588k;
    /* renamed from: l */
    private HorizontalScrollView f7589l;
    /* renamed from: m */
    private LinearLayout f7590m;
    /* renamed from: n */
    private Button f7591n;
    /* renamed from: o */
    private ImageButton f7592o;
    /* renamed from: p */
    private ImageButton f7593p;
    /* renamed from: q */
    private int f7594q;
    /* renamed from: r */
    private TextView f7595r;
    /* renamed from: s */
    private int f7596s;
    /* renamed from: t */
    private int f7597t;
    /* renamed from: u */
    private OnFocusChangeListener f7598u;
    /* renamed from: v */
    private OnKeyListener f7599v;

    /* compiled from: SoftInputDialog */
    /* renamed from: com.baidu.carlife.view.dialog.r$1 */
    class C23091 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2314r f7576a;

        C23091(C2314r this$0) {
            this.f7576a = this$0;
        }

        public void onClick(View view) {
            this.f7576a.mo1526d();
        }
    }

    /* compiled from: SoftInputDialog */
    /* renamed from: com.baidu.carlife.view.dialog.r$2 */
    class C23102 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C2314r f7577a;

        C23102(C2314r this$0) {
            this.f7577a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            Button temp = (Button) v;
            if (hasFocus) {
                temp.setTextSize(22.0f);
            } else {
                temp.setTextSize(18.0f);
            }
        }
    }

    /* compiled from: SoftInputDialog */
    /* renamed from: com.baidu.carlife.view.dialog.r$3 */
    class C23123 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C2314r f7580a;

        C23123(C2314r this$0) {
            this.f7580a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (v instanceof Button) {
                final Button temp = (Button) v;
                if (hasFocus) {
                    temp.setTextSize(30.0f);
                    this.f7580a.setKeyWidth(temp, this.f7580a.f7596s);
                    if (this.f7580a.f7586i[this.f7580a.f7586i.length - 1].equals(temp.getText().toString()) || this.f7580a.f7587j[this.f7580a.f7587j.length - 1].equals(temp.getText().toString())) {
                        new Handler().post(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C23123 f7579b;

                            public void run() {
                                this.f7579b.f7580a.f7589l.scrollTo(temp.getRight(), 0);
                            }
                        });
                        return;
                    }
                    return;
                }
                temp.setTextSize(20.0f);
                this.f7580a.setKeyWidth(temp, this.f7580a.f7597t);
            }
        }
    }

    /* compiled from: SoftInputDialog */
    /* renamed from: com.baidu.carlife.view.dialog.r$4 */
    class C23134 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2314r f7581a;

        C23134(C2314r this$0) {
            this.f7581a = this$0;
        }

        public boolean onKey(View view, int keyCode, KeyEvent event) {
            if (event != null && event.getAction() == 0) {
                switch (keyCode) {
                    case 20:
                        this.f7581a.mo1526d();
                        return true;
                    case 28:
                        this.f7581a.f7588k.setText("");
                        return true;
                    case 67:
                        this.f7581a.m8800l();
                        return true;
                }
            }
            return false;
        }
    }

    public C2314r(Context context) {
        this(context, null);
    }

    public C2314r(Context context, EditText editText) {
        super(context, null, R.style.SoftInputDialog);
        this.f7594q = 0;
        this.f7598u = new C23123(this);
        this.f7599v = new C23134(this);
        this.f7588k = editText;
        this.f7596s = this.c.getResources().getDimensionPixelSize(R.dimen.softinput_key_size);
        this.f7597t = this.c.getResources().getDimensionPixelSize(R.dimen.softinput_key_small);
    }

    /* renamed from: a */
    protected View mo1528a() {
        View contentView = LayoutInflater.from(this.c).inflate(R.layout.layout_soft_input, null);
        contentView.setOnClickListener(new C23091(this));
        return contentView;
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7586i = new String[]{Config.APP_VERSION_CODE, "b", "c", "d", Config.SESSTION_END_TIME, Regular.CATEGORY_FIX_VALUE, "g", "h", "i", "j", Config.APP_KEY, "l", Config.MODEL, "n", Config.OS, "p", "q", "r", "s", "t", "u", "v", Config.DEVICE_WIDTH, "x", "y", MapObjKey.OBJ_SS_ARROW_Z};
        this.f7587j = this.c.getResources().getStringArray(R.array.soft_input_num);
        this.f7589l = (HorizontalScrollView) findViewById(R.id.hsv_key);
        this.f7590m = (LinearLayout) findViewById(R.id.layout_key);
        this.f7593p = (ImageButton) findViewById(R.id.key_space);
        this.f7593p.setOnClickListener(this);
        this.f7592o = (ImageButton) findViewById(R.id.key_delete);
        this.f7592o.setOnClickListener(this);
        this.f7591n = (Button) findViewById(R.id.btn_mode);
        this.f7591n.setOnClickListener(this);
        this.f7595r = (TextView) findViewById(R.id.cover_view);
        this.f7591n.setOnFocusChangeListener(new C23102(this));
        findViewById(R.id.btn_hide).setOnClickListener(this);
        m8790a(this.f7594q);
        setCanceledOnTouchOutside(true);
    }

    public int getCustomHeight() {
        return this.c.getResources().getDimensionPixelSize(R.dimen.softinput_keyboard_height);
    }

    public void setEditText(EditText editText) {
        this.f7588k = editText;
    }

    /* renamed from: a */
    private void m8790a(int mode) {
        if (mode == 0) {
            this.f7591n.setText(f7585h);
            this.f7591n.requestFocus();
            m8792a(this.f7586i);
            return;
        }
        this.f7591n.setText(f7584g);
        this.f7591n.requestFocus();
        m8792a(this.f7587j);
    }

    /* renamed from: a */
    private void m8792a(String[] keys) {
        this.f7590m.removeAllViews();
        for (CharSequence text : keys) {
            Button temp = (Button) View.inflate(this.c, R.layout.softinput_item, null);
            setKeyWidth(temp, this.f7597t);
            temp.setText(text);
            temp.setOnClickListener(this);
            temp.setOnFocusChangeListener(this.f7598u);
            this.f7590m.addView(temp);
        }
    }

    private void setKeyWidth(View key, int width) {
        LayoutParams params = (LayoutParams) key.getLayoutParams();
        if (params != null) {
            params.width = width;
            return;
        }
        params = new LayoutParams(width, this.f7596s);
        params.gravity = 17;
        key.setLayoutParams(params);
    }

    /* renamed from: a */
    public void mo1525a(OnDialogListener listener) {
        m8790a(this.f7594q);
        super.mo1525a(listener);
    }

    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btn_mode) {
            this.f7594q = this.f7594q == 0 ? 1 : 0;
            m8790a(this.f7594q);
            mo1530f();
        } else if (viewId == R.id.btn_hide) {
            mo1526d();
        } else if (this.f7588k == null) {
        } else {
            if (viewId == R.id.key_space) {
                m8793b(" ");
            } else if (viewId == R.id.key_delete) {
                m8800l();
            } else if (v instanceof Button) {
                m8793b(((Button) v).getText().toString());
            }
        }
    }

    /* renamed from: b */
    private void m8793b(String insertString) {
        if (this.f7588k != null) {
            int start = this.f7588k.getSelectionStart();
            Editable editable = this.f7588k.getEditableText();
            if (start >= 0) {
                try {
                    if (start < editable.length()) {
                        editable.insert(start, insertString);
                        return;
                    }
                } catch (Exception e) {
                    return;
                }
            }
            editable.append(insertString);
        }
    }

    /* renamed from: l */
    private void m8800l() {
        Editable editable = this.f7588k.getText();
        int start = this.f7588k.getSelectionStart();
        if (editable != null && editable.length() > 0 && start > 0) {
            editable.delete(start - 1, start);
        }
    }

    /* renamed from: f */
    public void mo1530f() {
        C1443g mFocusViewGroup = new C1443g(findViewById(R.id.temp), 11, true);
        mFocusViewGroup.m5300d(this.f7591n).m5300d(this.f7592o).m5300d(this.f7593p);
        int child = this.f7590m.getChildCount();
        for (int i = 0; i < child; i++) {
            mFocusViewGroup.m5300d(this.f7590m.getChildAt(i));
        }
        mFocusViewGroup.m5297b(this.f7591n);
        mFocusViewGroup.m5295a(this.f7599v);
        mFocusViewGroup.m5244a(true);
        C1440d.m5251a().m5253a(mFocusViewGroup);
    }

    /* renamed from: i */
    public void mo1630i() {
        if (this.f7595r.getVisibility() == 0) {
            MsgHandlerCenter.m4452a((int) CommonParams.hJ);
            MsgHandlerCenter.m4454a((int) CommonParams.hJ, 50, 100);
        }
    }

    /* renamed from: j */
    public void m8806j() {
        if (this.f7595r != null) {
            this.f7591n.setEnabled(false);
            this.f7595r.setVisibility(0);
            setClickable(false);
        }
    }

    /* renamed from: k */
    public void m8807k() {
        if (this.f7595r != null) {
            this.f7595r.setVisibility(8);
            this.f7591n.setEnabled(true);
            setClickable(true);
        }
    }
}
