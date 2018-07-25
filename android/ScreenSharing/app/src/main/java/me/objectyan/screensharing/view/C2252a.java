package com.baidu.carlife.view;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.R;
import com.baidu.carlife.KeyboardService;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.view.KeyboardResultView.C2227c;
import com.baidu.carlife.view.dialog.C2298l;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Keyboard */
/* renamed from: com.baidu.carlife.view.a */
public class C2252a implements C2227c {
    /* renamed from: a */
    public static boolean f7336a = false;
    /* renamed from: c */
    private static C2252a f7337c;
    /* renamed from: b */
    private Activity f7338b;
    /* renamed from: d */
    private boolean f7339d = false;
    /* renamed from: e */
    private boolean f7340e = false;
    /* renamed from: f */
    private boolean f7341f = false;
    /* renamed from: g */
    private boolean f7342g = false;
    /* renamed from: h */
    private OnDialogListener f7343h;
    /* renamed from: i */
    private C2298l f7344i;
    /* renamed from: j */
    private TextView f7345j;
    /* renamed from: k */
    private TextView f7346k;
    /* renamed from: l */
    private TextView[] f7347l;
    /* renamed from: m */
    private ImageView f7348m;
    /* renamed from: n */
    private int f7349n;
    /* renamed from: o */
    private char[] f7350o;
    /* renamed from: p */
    private TextView f7351p;
    /* renamed from: q */
    private KeyboardEditText f7352q;
    /* renamed from: r */
    private TextView f7353r;
    /* renamed from: s */
    private View f7354s;
    /* renamed from: t */
    private View f7355t;
    /* renamed from: u */
    private KeyboardResultView f7356u;
    /* renamed from: v */
    private EditText f7357v;
    /* renamed from: w */
    private C2254b f7358w;
    /* renamed from: x */
    private boolean f7359x = false;
    /* renamed from: y */
    private C2247b f7360y = new C2247b();

    /* compiled from: Keyboard */
    /* renamed from: com.baidu.carlife.view.a$a */
    public class C2245a implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C2252a f7323a;

        public C2245a(C2252a this$0, KeyboardEditText editText) {
            this(this$0, editText, 0, null, null);
        }

        public C2245a(final C2252a this$0, KeyboardEditText editText, int imeOptions, C2248c finishListener, final C2249d onFocusChangeListener) {
            this.f7323a = this$0;
            editText.setOnClickFinishListener(finishListener);
            switch (imeOptions) {
                case 3:
                    editText.setFinishText(BaiduNaviApplication.getInstance().getString(R.string.keyboard_search));
                    break;
                default:
                    editText.setFinishText(BaiduNaviApplication.getInstance().getString(R.string.keyboard_finish));
                    break;
            }
            editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                /* renamed from: c */
                final /* synthetic */ C2245a f7322c;

                public void onFocusChange(View v, boolean hasFocus) {
                    if (onFocusChangeListener != null) {
                        onFocusChangeListener.onFocusChange(v, hasFocus);
                    }
                }
            });
        }

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case 0:
                    this.f7323a.m8562a((KeyboardEditText) v);
                    break;
                case 1:
                    this.f7323a.m8565b((KeyboardEditText) v);
                    break;
            }
            return false;
        }
    }

    /* compiled from: Keyboard */
    /* renamed from: com.baidu.carlife.view.a$b */
    private class C2247b extends C2246d {
        /* renamed from: a */
        final /* synthetic */ C2252a f7327a;

        private C2247b(C2252a c2252a) {
            this.f7327a = c2252a;
        }

        /* renamed from: a */
        public void mo1799a(View v) {
            boolean z = true;
            C2252a c2252a;
            switch (v.getId()) {
                case R.id.keyboard_result_hide:
                    this.f7327a.m8567d();
                    return;
                case R.id.keyboard_result_left:
                    this.f7327a.f7356u.m8456b();
                    return;
                case R.id.keyboard_result_right:
                    this.f7327a.f7356u.m8455a();
                    return;
                case R.id.keyboard_q:
                case R.id.keyboard_w:
                case R.id.keyboard_e:
                case R.id.keyboard_r:
                case R.id.keyboard_t:
                case R.id.keyboard_y:
                case R.id.keyboard_u:
                case R.id.keyboard_i:
                case R.id.keyboard_o:
                case R.id.keyboard_p:
                case R.id.keyboard_a:
                case R.id.keyboard_s:
                case R.id.keyboard_d:
                case R.id.keyboard_f:
                case R.id.keyboard_g:
                case R.id.keyboard_h:
                case R.id.keyboard_j:
                case R.id.keyboard_k:
                case R.id.keyboard_l:
                case R.id.keyboard_z:
                case R.id.keyboard_x:
                case R.id.keyboard_c:
                case R.id.keyboard_v:
                case R.id.keyboard_b:
                case R.id.keyboard_n:
                case R.id.keyboard_m:
                    String temp1 = ((TextView) v).getText().toString();
                    if (this.f7327a.f7341f || this.f7327a.f7340e) {
                        this.f7327a.m8535a(temp1);
                        this.f7327a.m8542c(false);
                        return;
                    }
                    this.f7327a.f7357v.append(temp1);
                    this.f7327a.f7357v.setSelection(this.f7327a.f7357v.getText().length());
                    this.f7327a.m8544d(true);
                    this.f7327a.m8536a(KeyboardService.getInstance().search(this.f7327a.f7357v.getText().toString()));
                    return;
                case R.id.keyboard_letter_shift:
                    c2252a = this.f7327a;
                    if (this.f7327a.f7340e) {
                        z = false;
                    }
                    c2252a.f7340e = z;
                    this.f7327a.m8542c(this.f7327a.f7340e);
                    this.f7327a.m8552f();
                    return;
                case R.id.keyboard_letter_delete:
                case R.id.keyboard_num_delete:
                    if (this.f7327a.f7352q != null) {
                        String english = this.f7327a.f7357v.getText().toString();
                        if (english.length() > 0) {
                            english = english.substring(0, english.length() - 1);
                            this.f7327a.f7357v.setText(english);
                            this.f7327a.f7357v.setSelection(english.length());
                            if (TextUtils.isEmpty(english)) {
                                this.f7327a.m8544d(false);
                            } else {
                                this.f7327a.m8544d(true);
                            }
                            this.f7327a.m8536a(KeyboardService.getInstance().search(english));
                            return;
                        } else if (this.f7327a.f7358w.getCount() > 0) {
                            this.f7327a.m8536a(null);
                            return;
                        } else {
                            this.f7327a.m8544d(false);
                            Editable editable = this.f7327a.f7352q.getText();
                            int start = this.f7327a.f7352q.getSelectionStart();
                            if (editable != null && editable.length() > 0 && start > 0) {
                                editable.delete(start - 1, start);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case R.id.keyboard_letter_switch:
                case R.id.keyboard_num_switch:
                    c2252a = this.f7327a;
                    if (this.f7327a.f7339d) {
                        z = false;
                    }
                    c2252a.f7339d = z;
                    this.f7327a.m8552f();
                    this.f7327a.m8550e(this.f7327a.f7339d);
                    return;
                case R.id.keyboard_letter_language:
                    c2252a = this.f7327a;
                    if (this.f7327a.f7341f) {
                        z = false;
                    }
                    c2252a.f7341f = z;
                    this.f7327a.m8539b(this.f7327a.f7341f);
                    this.f7327a.m8542c(false);
                    this.f7327a.m8552f();
                    return;
                case R.id.keyboard_letter_space:
                case R.id.keyboard_num_space:
                    if (!this.f7327a.m8552f()) {
                        this.f7327a.m8535a(" ");
                        return;
                    }
                    return;
                case R.id.keyboard_letter_finish:
                case R.id.keyboard_num_finish:
                    String temp2 = this.f7327a.f7357v.getText().toString();
                    if (!this.f7327a.f7342g || TextUtils.isEmpty(temp2) || this.f7327a.f7352q == null) {
                        if (!(this.f7327a.f7352q == null || this.f7327a.f7352q.getOnClickFinishListener() == null)) {
                            this.f7327a.f7352q.getOnClickFinishListener().onClickFinish();
                        }
                        this.f7327a.m8567d();
                        return;
                    }
                    this.f7327a.m8535a(temp2);
                    this.f7327a.m8554g();
                    return;
                case R.id.keyboard_char1:
                case R.id.keyboard_1:
                case R.id.keyboard_2:
                case R.id.keyboard_3:
                case R.id.keyboard_char2:
                case R.id.keyboard_4:
                case R.id.keyboard_5:
                case R.id.keyboard_6:
                case R.id.keyboard_char3:
                case R.id.keyboard_char4:
                case R.id.keyboard_7:
                case R.id.keyboard_8:
                case R.id.keyboard_9:
                case R.id.keyboard_char5:
                case R.id.keyboard_0:
                case R.id.keyboard_char6:
                    this.f7327a.m8535a(((TextView) v).getText().toString());
                    return;
                case R.id.cover_view:
                    StatisticManager.onEvent(StatisticConstants.EVENT_USE_COVER_KEYBOARD);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: Keyboard */
    /* renamed from: com.baidu.carlife.view.a$c */
    public interface C2248c {
        void onClickFinish();
    }

    /* compiled from: Keyboard */
    /* renamed from: com.baidu.carlife.view.a$d */
    public interface C2249d {
        void onFocusChange(View view, boolean z);
    }

    /* renamed from: a */
    public static C2252a m8531a() {
        if (f7337c == null) {
            f7337c = new C2252a();
        }
        return f7337c;
    }

    /* renamed from: a */
    public void m8561a(Activity activity, OnDialogListener listener) {
        this.f7343h = listener;
        this.f7338b = activity;
        m8548e();
    }

    /* renamed from: e */
    private void m8548e() {
        this.f7344i = new C2298l(AppContext.m3876a());
        this.f7344i.setOnClickListener(this.f7360y);
        this.f7344i.setResultItemClickListener(this);
        this.f7345j = this.f7344i.getLetterSpaceKey();
        this.f7346k = this.f7344i.getLetterLanguageKey();
        this.f7347l = this.f7344i.getLetterKeys();
        this.f7348m = this.f7344i.getLetterShiftKey();
        this.f7349n = this.f7344i.getLetterSize();
        this.f7350o = this.f7344i.getLetters();
        this.f7351p = this.f7344i.getLetterFinishKey();
        this.f7353r = this.f7344i.getNumFinishKey();
        this.f7354s = this.f7344i.getLetterKeyboard();
        this.f7355t = this.f7344i.getNumKeyboard();
        this.f7356u = this.f7344i.getResultKeyboard();
        this.f7357v = this.f7344i.getResultEditText();
        this.f7358w = this.f7344i.getResultAdapter();
        m8539b(false);
        if (this.f7359x) {
            this.f7344i.mo1630i();
        }
        this.f7339d = false;
    }

    /* renamed from: a */
    private void m8536a(ArrayList<String> results) {
        this.f7358w.m8569a((List) results);
        this.f7358w.notifyDataSetChanged();
    }

    /* renamed from: b */
    private void m8539b(boolean isEnglish) {
        this.f7341f = isEnglish;
        SpannableString span = new SpannableString("中/英");
        int a4 = BaiduNaviApplication.getInstance().getResources().getColor(R.color.cl_text_a4_bgtext);
        int a1 = BaiduNaviApplication.getInstance().getResources().getColor(R.color.cl_text_a1_bgtext);
        if (isEnglish) {
            span.setSpan(new ForegroundColorSpan(a1), 0, 2, 17);
            span.setSpan(new AbsoluteSizeSpan(12, true), 0, 2, 17);
            span.setSpan(new ForegroundColorSpan(a4), 2, 3, 17);
            span.setSpan(new AbsoluteSizeSpan(16, true), 2, 3, 17);
            this.f7345j.setText("Space");
        } else {
            span.setSpan(new ForegroundColorSpan(a4), 0, 1, 17);
            span.setSpan(new AbsoluteSizeSpan(16, true), 0, 1, 17);
            span.setSpan(new ForegroundColorSpan(a1), 1, 3, 17);
            span.setSpan(new AbsoluteSizeSpan(12, true), 1, 3, 17);
            this.f7345j.setText("空格");
        }
        this.f7346k.setText(span);
    }

    /* renamed from: c */
    private void m8542c(boolean isUpper) {
        this.f7340e = isUpper;
        int i;
        if (isUpper) {
            for (i = 0; i < this.f7349n; i++) {
                this.f7347l[i].setText(String.valueOf((char) (this.f7350o[i] - 32)));
            }
            this.f7348m.setImageResource(R.drawable.input_ic_keyboard_shift_focus);
            return;
        }
        for (i = 0; i < this.f7349n; i++) {
            this.f7347l[i].setText(String.valueOf(this.f7350o[i]));
        }
        this.f7348m.setImageResource(R.drawable.input_ic_keyboard_shift);
    }

    /* renamed from: d */
    private void m8544d(boolean isConfirm) {
        this.f7342g = isConfirm;
        if (isConfirm) {
            this.f7351p.setText(R.string.keyboard_confirm);
            this.f7351p.setSelected(true);
            return;
        }
        String finishText = AppContext.m3876a().getString(R.string.keyboard_finish);
        if (!(this.f7352q == null || TextUtils.isEmpty(this.f7352q.getFinishText()))) {
            finishText = this.f7352q.getFinishText();
        }
        this.f7351p.setText(finishText);
        this.f7351p.setSelected(false);
        this.f7353r.setText(finishText);
    }

    /* renamed from: e */
    private void m8550e(boolean isNum) {
        this.f7339d = isNum;
        if (isNum) {
            this.f7354s.setVisibility(8);
            this.f7355t.setVisibility(0);
        } else {
            this.f7354s.setVisibility(0);
            this.f7355t.setVisibility(8);
        }
        this.f7344i.setNumType(isNum);
        m8542c(false);
    }

    /* renamed from: a */
    private void m8535a(String insertString) {
        int start = this.f7352q.getSelectionStart();
        Editable editable = this.f7352q.getEditableText();
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

    /* renamed from: f */
    private boolean m8552f() {
        if (this.f7352q == null) {
            return true;
        }
        if (this.f7356u.getChildCount() > 0) {
            m8535a(((TextView) this.f7356u.getChildAt(0)).getText().toString());
            m8554g();
            return true;
        } else if (TextUtils.isEmpty(this.f7357v.getText().toString())) {
            return false;
        } else {
            m8535a(this.f7357v.getText().toString());
            this.f7357v.setText("");
            m8544d(false);
            return true;
        }
    }

    /* renamed from: g */
    private void m8554g() {
        this.f7357v.setText("");
        m8544d(false);
        m8536a(null);
    }

    /* renamed from: b */
    public boolean m8564b() {
        if (this.f7343h == null || !this.f7343h.isDialogShown()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m8563a(boolean bForbid) {
        this.f7359x = bForbid;
        if (!m8564b() || this.f7344i == null) {
            return;
        }
        if (bForbid) {
            this.f7344i.mo1630i();
        } else {
            this.f7344i.m8737j();
        }
    }

    /* renamed from: c */
    public void m8566c() {
        m8548e();
        if (this.f7343h != null) {
            this.f7343h.showDialog(this.f7344i, C1265a.Bottom);
            if (CarlifeUtil.m4387z() >= 5) {
                StatisticManager.onEvent(StatisticConstants.EVENT_USE_KEYBOARD_OVER_SPEED);
            }
        }
    }

    /* renamed from: d */
    public void m8567d() {
        if (this.f7343h != null && this.f7343h.isDialogShown()) {
            this.f7343h.dismissDialog(this.f7344i);
            m8554g();
            this.f7339d = false;
            m8542c(false);
            m8539b(false);
            this.f7352q = null;
        }
    }

    /* renamed from: a */
    public void m8562a(KeyboardEditText et) {
        this.f7352q = et;
        if (CarlifeCoreSDK.m5979a().m5993N()) {
            this.f7352q.setShowSoftInputOnFocus(false);
            this.f7338b.getWindow().setSoftInputMode(2);
            return;
        }
        this.f7352q.setShowSoftInputOnFocus(true);
        this.f7338b.getWindow().setSoftInputMode(2);
    }

    /* renamed from: b */
    public boolean m8565b(KeyboardEditText et) {
        if (CarlifeCoreSDK.m5979a().m5993N()) {
            f7336a = true;
            if (C1765g.m6424a().m6442c()) {
                m8566c();
                return true;
            } else if (KeyboardService.getInstance().isLoadLibSuc()) {
                m8566c();
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo1800a(int position, View itemView) {
        String s = ((TextView) itemView.findViewById(R.id.keyboard_result_item_tv)).getText().toString();
        m8535a(s);
        this.f7357v.setText("");
        m8544d(false);
        m8536a(KeyboardService.getInstance().relateWords(s));
        if (this.f7344i != null) {
            this.f7344i.setNeedGrantResultFocus(true);
        }
        if (!TextUtils.isEmpty(s)) {
            KeyboardService.getInstance().userSelected(s);
        }
    }
}
