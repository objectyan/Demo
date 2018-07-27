package com.baidu.carlife.p078f;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;
import com.baidu.carlife.view.C2252a;
import com.baidu.carlife.view.KeyboardEditText;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FocusViewGroup */
/* renamed from: com.baidu.carlife.f.g */
public class C1443g extends C1436a implements OnFocusChangeListener {
    /* renamed from: v */
    private ArrayList<View> f4225v = new ArrayList();
    /* renamed from: w */
    private View f4226w;
    /* renamed from: x */
    private View f4227x;
    /* renamed from: y */
    private OnKeyListener f4228y;
    /* renamed from: z */
    private boolean f4229z = false;

    public C1443g(View view, int position) {
        super(view, position);
        view.setOnFocusChangeListener(this);
    }

    public C1443g(View view, int position, boolean isCyclic) {
        super(view, position, isCyclic);
        view.setOnFocusChangeListener(this);
    }

    /* renamed from: a */
    public void m5295a(OnKeyListener onKeyListener) {
        this.f4228y = onKeyListener;
    }

    /* renamed from: a */
    public boolean mo1554a() {
        LogUtil.d("FocusManager", "grantFocus FocusViewGroup");
        if (this.f4229z && this.f4226w != null && m5291f(this.f4226w)) {
            return true;
        }
        if (this.f4227x != null) {
            if (m5291f(this.f4227x)) {
                return true;
            }
            this.f4227x = null;
        }
        if (this.f4226w != null && m5291f(this.f4226w)) {
            return true;
        }
        for (int i = 0; i < this.f4225v.size(); i++) {
            this.f4226w = (View) this.f4225v.get(i);
            if (m5291f(this.f4226w)) {
                return true;
            }
        }
        this.f4226w = null;
        return false;
    }

    /* renamed from: e */
    public ArrayList<View> m5301e() {
        return this.f4225v;
    }

    /* renamed from: f */
    public View m5303f() {
        return this.f4226w;
    }

    /* renamed from: g */
    public View m5304g() {
        return this.f4227x;
    }

    /* renamed from: b */
    public C1443g m5298b(boolean isDefaultViewFirst) {
        this.f4229z = isDefaultViewFirst;
        return this;
    }

    /* renamed from: b */
    public C1443g m5297b(View view) {
        this.f4226w = view;
        return this;
    }

    /* renamed from: c */
    public C1443g m5299c(View view) {
        this.f4227x = view;
        return this;
    }

    /* renamed from: d */
    public C1443g m5300d(View view) {
        if (view.isFocusable()) {
            view.setOnKeyListener(this);
            if (view.getOnFocusChangeListener() == null) {
                view.setOnFocusChangeListener(this);
            }
            this.f4225v.add(view);
        }
        return this;
    }

    /* renamed from: h */
    public void m5305h() {
        if (this.f4225v != null) {
            Iterator it = this.f4225v.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnKeyListener(this);
            }
        }
    }

    /* renamed from: e */
    public boolean m5302e(View view) {
        View view2 = null;
        boolean removed = this.f4225v.remove(view);
        if (this.f4227x == view) {
            this.f4227x = this.f4225v.size() == 0 ? null : (View) this.f4225v.get(0);
        }
        if (this.f4226w == view) {
            if (this.f4225v.size() != 0) {
                view2 = (View) this.f4225v.get(0);
            }
            this.f4226w = view2;
        }
        return removed;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        LogUtil.d("FocusManager", "onFocusChange v=" + v + " hasFocus=" + hasFocus);
        if (v != null && v.isFocused()) {
            m5243a(v);
        }
        LogUtil.d("FocusManager", "hasFocus=" + v.isFocused());
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        LogUtil.d("FocusManager", "onKey keyCode=" + keyCode + " v=" + v + " action=" + (event.getAction() == 0 ? "ACTION_DOWN" : "ACTION_UP"));
        if (this.f4228y != null && this.f4228y.onKey(v, keyCode, event)) {
            return true;
        }
        if (event != null) {
            if (event.getAction() == 0) {
                switch (keyCode) {
                    case 23:
                        if (v instanceof KeyboardEditText) {
                            C2252a.m8531a().m8562a((KeyboardEditText) v);
                            return true;
                        }
                        break;
                    case 300:
                        if (!m5248d() && CarlifeViewContainer.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) {
                            return true;
                        }
                        m5291f(m5292g(v));
                        return true;
                    case 301:
                        if (!m5248d() && CarlifeViewContainer.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) {
                            return true;
                        }
                        m5291f(m5293h(v));
                        return true;
                }
            } else if ((v instanceof KeyboardEditText) && event.getAction() == 1 && keyCode == 23) {
                return C2252a.m8531a().m8565b((KeyboardEditText) v);
            }
        }
        return super.onKey(v, keyCode, event);
    }

    /* renamed from: f */
    private boolean m5291f(View view) {
        if (!m5294i(view) || !view.requestFocus()) {
            return false;
        }
        m5243a(view);
        LogUtil.d("FocusManager", "requestFocusForView view=" + view);
        this.f4227x = view;
        return true;
    }

    /* renamed from: g */
    private View m5292g(View view) {
        if (this.f4225v.size() == 0) {
            return null;
        }
        int index = this.f4225v.indexOf(view);
        if (index == -1) {
            return null;
        }
        if (index == this.f4225v.size() - 1 && !this.t) {
            return null;
        }
        int i = 1;
        while (i < this.f4225v.size() && (this.t || index + i < this.f4225v.size())) {
            int newIndex = (index + i) % this.f4225v.size();
            if (newIndex < this.f4225v.size()) {
                View next = (View) this.f4225v.get(newIndex);
                if (m5294i(next)) {
                    return next;
                }
            }
            i++;
        }
        return null;
    }

    /* renamed from: h */
    private View m5293h(View view) {
        if (this.f4225v.size() == 0) {
            return null;
        }
        int index = this.f4225v.indexOf(view);
        if (index == -1) {
            return null;
        }
        if (index == 0 && !this.t) {
            return null;
        }
        int i = 1;
        while (i < this.f4225v.size() && (this.t || index - i >= 0)) {
            int newIndex = ((index - i) + this.f4225v.size()) % this.f4225v.size();
            if (newIndex < this.f4225v.size()) {
                View previous = (View) this.f4225v.get(newIndex);
                if (m5294i(previous)) {
                    return previous;
                }
            }
            i++;
        }
        return null;
    }

    /* renamed from: i */
    private boolean m5294i(View view) {
        if (view != null && this.f4225v.contains(view) && view.isShown() && view.isEnabled()) {
            return true;
        }
        int code = 0;
        if (view == null) {
            code = 1;
        } else if (!this.f4225v.contains(view)) {
            code = 2;
        } else if (!view.isShown()) {
            code = 3;
        } else if (!view.isEnabled()) {
            code = 4;
        }
        LogUtil.m4443d("FocusManager", "illegalview view=" + view + " code=" + code);
        return false;
    }

    /* renamed from: i */
    public void m5306i() {
        this.f4227x = null;
        this.f4226w = null;
        if (this.f4225v != null) {
            this.f4225v.clear();
        }
    }
}
