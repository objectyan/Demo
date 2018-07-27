package com.baidu.carlife.p078f;

import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.logic.C1765g;
import com.baidu.navi.fragment.ContentFragment;

/* compiled from: FocusManager */
/* renamed from: com.baidu.carlife.f.d */
public class C1440d implements OnFocusChangeListener, OnKeyListener, OnTouchListener, OnGlobalFocusChangeListener, OnTouchModeChangeListener {
    /* renamed from: a */
    private static C1440d f4198a = null;
    /* renamed from: u */
    private static final int f4199u = 200;
    /* renamed from: v */
    private static final int f4200v = 201;
    /* renamed from: b */
    private View f4201b;
    /* renamed from: c */
    private C1436a f4202c;
    /* renamed from: d */
    private C1436a f4203d;
    /* renamed from: e */
    private C1436a f4204e;
    /* renamed from: f */
    private C1436a f4205f;
    /* renamed from: g */
    private C1436a f4206g;
    /* renamed from: h */
    private C1436a f4207h;
    /* renamed from: i */
    private C1436a f4208i;
    /* renamed from: j */
    private C1436a f4209j;
    /* renamed from: k */
    private C1436a f4210k;
    /* renamed from: l */
    private C1436a f4211l;
    /* renamed from: m */
    private C1436a f4212m;
    /* renamed from: n */
    private C1436a f4213n;
    /* renamed from: o */
    private C1436a f4214o;
    /* renamed from: p */
    private C1436a f4215p;
    /* renamed from: q */
    private C1436a f4216q;
    /* renamed from: r */
    private C1436a f4217r;
    /* renamed from: s */
    private C1436a f4218s;
    /* renamed from: t */
    private boolean f4219t = true;
    /* renamed from: w */
    private Handler f4220w = new C14391(this);

    /* compiled from: FocusManager */
    /* renamed from: com.baidu.carlife.f.d$1 */
    class C14391 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1440d f4197a;

        C14391(C1440d this$0) {
            this.f4197a = this$0;
        }

        public void handleMessage(Message msg) {
            if (this.f4197a.m5257b()) {
                this.f4197a.m5267g();
            }
            if (msg.what == 200 && msg.obj != null && (msg.obj instanceof C1436a)) {
                ((C1436a) msg.obj).mo1554a();
            }
        }
    }

    private C1440d() {
    }

    /* renamed from: a */
    public static C1440d m5251a() {
        if (f4198a == null) {
            f4198a = new C1440d();
        }
        return f4198a;
    }

    /* renamed from: a */
    public void m5254a(View view) {
        this.f4201b = view;
        this.f4201b.getViewTreeObserver().addOnTouchModeChangeListener(this);
        this.f4201b.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
        this.f4220w.sendEmptyMessage(201);
    }

    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
    }

    /* renamed from: b */
    public boolean m5257b() {
        if (this.f4201b == null) {
            return false;
        }
        return this.f4201b.isInTouchMode();
    }

    /* renamed from: a */
    public C1440d m5252a(C1436a focusArea) {
        this.f4202c = focusArea;
        return this;
    }

    /* renamed from: b */
    public C1440d m5255b(C1436a focusArea) {
        if (focusArea == null && this.f4207h != null && this.f4207h.m5247c()) {
            focusArea = C1440d.m5251a().m5260d(this.f4207h);
            LogUtil.d("FocusManager", "setFocusAreaTop focusArea = " + focusArea);
            if (focusArea != null) {
                focusArea.mo1554a();
            }
            this.f4207h = null;
        } else {
            this.f4207h = focusArea;
        }
        return this;
    }

    /* renamed from: a */
    public C1440d m5253a(C1436a... focusAreas) {
        m5263e();
        if (focusAreas != null) {
            for (int i = 0; i < focusAreas.length; i++) {
                if (focusAreas[i] != null) {
                    switch (focusAreas[i].m5246b()) {
                        case 7:
                            this.f4209j = focusAreas[i];
                            break;
                        case 8:
                            this.f4210k = focusAreas[i];
                            break;
                        case 9:
                            this.f4211l = focusAreas[i];
                            break;
                        case 10:
                            this.f4215p = focusAreas[i];
                            break;
                        case 11:
                            this.f4216q = focusAreas[i];
                            break;
                        case 13:
                            this.f4212m = focusAreas[i];
                            break;
                        case 14:
                            this.f4213n = focusAreas[i];
                            break;
                        case 15:
                            this.f4214o = focusAreas[i];
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if (this.f4210k != null) {
            this.f4218s = this.f4210k;
            this.f4210k.mo1554a();
        } else if (this.f4212m != null) {
            this.f4218s = this.f4212m;
            this.f4212m.mo1554a();
        } else if (this.f4211l != null) {
            this.f4218s = this.f4211l;
            this.f4211l.mo1554a();
        } else if (this.f4215p != null) {
            this.f4218s = this.f4215p;
            this.f4215p.mo1554a();
        } else if (this.f4209j != null) {
            this.f4218s = this.f4209j;
            this.f4209j.mo1554a();
        } else if (this.f4216q != null) {
            this.f4218s = this.f4216q;
            this.f4216q.mo1554a();
        }
        return this;
    }

    /* renamed from: c */
    public C1440d m5259c(C1436a focusArea) {
        if (focusArea != null) {
            this.f4217r = focusArea;
            this.f4217r.mo1554a();
        }
        return this;
    }

    /* renamed from: c */
    public C1440d m5258c() {
        this.f4217r = null;
        return this;
    }

    /* renamed from: b */
    public C1440d m5256b(C1436a... focusAreas) {
        m5261d();
        if (focusAreas != null) {
            for (int i = 0; i < focusAreas.length; i++) {
                if (focusAreas[i] != null) {
                    switch (focusAreas[i].m5246b()) {
                        case 2:
                            this.f4203d = focusAreas[i];
                            break;
                        case 3:
                            this.f4204e = focusAreas[i];
                            break;
                        case 4:
                            this.f4206g = focusAreas[i];
                            break;
                        case 5:
                            this.f4205f = focusAreas[i];
                            break;
                        case 6:
                            this.f4208i = focusAreas[i];
                            break;
                        case 7:
                            this.f4209j = focusAreas[i];
                            break;
                        case 8:
                            this.f4210k = focusAreas[i];
                            break;
                        case 9:
                            this.f4211l = focusAreas[i];
                            break;
                        case 10:
                            this.f4215p = focusAreas[i];
                            break;
                        case 11:
                            this.f4216q = focusAreas[i];
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return this;
    }

    /* renamed from: d */
    public C1440d m5261d() {
        this.f4204e = null;
        this.f4206g = null;
        this.f4205f = null;
        this.f4208i = null;
        this.f4203d = null;
        return this;
    }

    /* renamed from: e */
    public C1440d m5263e() {
        this.f4216q = null;
        this.f4209j = null;
        this.f4211l = null;
        this.f4215p = null;
        this.f4210k = null;
        this.f4212m = null;
        this.f4213n = null;
        this.f4214o = null;
        this.f4218s = null;
        return this;
    }

    /* renamed from: d */
    public C1436a m5260d(C1436a focusArea) {
        if (focusArea == null) {
            return null;
        }
        switch (focusArea.m5246b()) {
            case 0:
                if (this.f4203d != null) {
                    return this.f4203d;
                }
                if (this.f4204e != null) {
                    return this.f4204e;
                }
                if (this.f4206g != null) {
                    return this.f4206g;
                }
                if (this.f4205f != null) {
                    return this.f4205f;
                }
                if (this.f4208i != null) {
                    return this.f4208i;
                }
                return this.f4202c;
            case 1:
            case 11:
            case 12:
                return null;
            case 2:
                if (this.f4204e != null) {
                    return this.f4204e;
                }
                if (this.f4206g != null) {
                    return this.f4206g;
                }
                if (this.f4205f != null) {
                    return this.f4205f;
                }
                if (this.f4208i != null) {
                    return this.f4208i;
                }
                return this.f4202c;
            case 3:
            case 4:
            case 5:
                if (this.f4208i != null) {
                    return this.f4208i;
                }
                return this.f4202c;
            case 6:
                return this.f4202c;
            case 7:
                if (this.f4212m != null) {
                    return this.f4212m;
                }
                if (this.f4210k != null) {
                    return this.f4210k;
                }
                if (this.f4211l != null) {
                    return this.f4211l;
                }
                if (this.f4215p != null) {
                    return this.f4215p;
                }
                if (this.f4216q != null) {
                    return this.f4216q;
                }
                return null;
            case 8:
            case 9:
            case 10:
            case 15:
                if (this.f4216q != null) {
                    return this.f4216q;
                }
                return null;
            case 13:
                if (this.f4213n != null) {
                    return this.f4213n;
                }
                return null;
            case 14:
                if (this.f4214o != null) {
                    return this.f4214o;
                }
                return null;
            default:
                return null;
        }
    }

    /* renamed from: e */
    public C1436a m5262e(C1436a focusArea) {
        if (focusArea == null) {
            return null;
        }
        switch (focusArea.m5246b()) {
            case 0:
            case 7:
            case 12:
                return null;
            case 1:
                if (this.f4208i != null) {
                    return this.f4208i;
                }
                if (this.f4204e != null) {
                    return this.f4204e;
                }
                if (this.f4206g != null) {
                    return this.f4206g;
                }
                if (this.f4205f != null) {
                    return this.f4205f;
                }
                if (this.f4203d != null) {
                    return this.f4203d;
                }
                return this.f4207h;
            case 2:
                return this.f4207h;
            case 3:
            case 4:
            case 5:
                if (this.f4203d != null) {
                    return this.f4203d;
                }
                return this.f4207h;
            case 6:
                if (this.f4204e != null) {
                    return this.f4204e;
                }
                if (this.f4206g != null) {
                    return this.f4206g;
                }
                if (this.f4205f != null) {
                    return this.f4205f;
                }
                if (this.f4203d != null) {
                    return this.f4203d;
                }
                return this.f4207h;
            case 8:
            case 9:
            case 10:
            case 13:
                if (this.f4209j != null) {
                    return this.f4209j;
                }
                return null;
            case 11:
                if (this.f4214o != null) {
                    return this.f4214o;
                }
                if (this.f4210k != null) {
                    return this.f4210k;
                }
                if (this.f4211l != null) {
                    return this.f4211l;
                }
                if (this.f4215p != null) {
                    return this.f4215p;
                }
                if (this.f4209j != null) {
                    return this.f4209j;
                }
                return null;
            case 14:
                if (this.f4212m != null) {
                    return this.f4212m;
                }
                return null;
            case 15:
                if (this.f4213n != null) {
                    return this.f4213n;
                }
                return null;
            default:
                return null;
        }
    }

    /* renamed from: f */
    public C1436a m5264f(C1436a focusArea) {
        if (focusArea == null) {
            return null;
        }
        switch (focusArea.m5246b()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
                return null;
            case 4:
                return this.f4204e;
            case 5:
                if (this.f4206g != null) {
                    return this.f4206g;
                }
                return this.f4204e;
            case 9:
                return this.f4210k;
            case 10:
                if (this.f4211l != null) {
                    return this.f4211l;
                }
                return this.f4210k;
            default:
                return null;
        }
    }

    /* renamed from: g */
    public C1436a m5266g(C1436a focusArea) {
        if (focusArea == null) {
            return null;
        }
        switch (focusArea.m5246b()) {
            case 0:
            case 1:
            case 2:
            case 5:
            case 6:
            case 7:
            case 10:
            case 11:
            case 12:
                return null;
            case 3:
                if (this.f4206g != null) {
                    return this.f4206g;
                }
                return this.f4205f;
            case 4:
                return this.f4205f;
            case 8:
                if (this.f4211l != null) {
                    return this.f4211l;
                }
                return this.f4215p;
            case 9:
                return this.f4215p;
            default:
                return null;
        }
    }

    /* renamed from: h */
    public void m5268h(C1436a focusArea) {
        if (focusArea != null && this.f4220w != null) {
            this.f4220w.removeMessages(200);
            Message msg = new Message();
            msg.what = 200;
            msg.arg1 = focusArea.m5246b();
            msg.obj = focusArea;
            this.f4220w.sendMessageDelayed(msg, 100);
        }
    }

    /* renamed from: f */
    public void m5265f() {
        if (this.f4220w != null) {
            this.f4220w.removeMessages(200);
        }
    }

    /* renamed from: g */
    public void m5267g() {
        if (C1765g.m6424a().m6442c() && this.f4201b != null && m5257b()) {
            this.f4201b.requestFocusFromTouch();
            if (this.f4217r != null) {
                this.f4217r.mo1554a();
            } else if (this.f4218s != null) {
                this.f4218s.mo1554a();
            }
        }
    }

    /* renamed from: h */
    public boolean m5269h() {
        if (!C1765g.m6424a().m6442c()) {
            return false;
        }
        if (this.f4217r != null) {
            this.f4217r.mo1554a();
            return false;
        } else if (this.f4218s == null) {
            return true;
        } else {
            this.f4218s.mo1554a();
            return false;
        }
    }

    /* renamed from: i */
    public boolean m5270i() {
        if (this.f4217r != null) {
            this.f4217r.mo1554a();
            return false;
        } else if (this.f4218s == null) {
            return true;
        } else {
            this.f4218s.mo1554a();
            return false;
        }
    }

    /* renamed from: j */
    public void m5271j() {
        if (C1765g.m6424a().m6442c()) {
            ContentFragment contentFragment = FragmentManagerCallbackProxy.m4757a().getCurrentFragment();
            if (this.f4217r != null) {
                this.f4217r.mo1554a();
            } else if (this.f4218s != null) {
                this.f4218s.mo1554a();
            } else if (contentFragment != null && contentFragment.isDisplayed) {
                contentFragment.onInitFocusAreas();
            }
        }
    }

    public void onTouchModeChanged(boolean isInTouchMode) {
        if (C1765g.m6424a().m6442c()) {
            this.f4219t = isInTouchMode;
            if (isInTouchMode && this.f4201b != null) {
                this.f4201b.requestFocusFromTouch();
                if (this.f4217r != null) {
                    this.f4217r.mo1554a();
                } else if (this.f4218s != null) {
                    this.f4218s.mo1554a();
                }
            }
        }
    }

    public void onFocusChange(View v, boolean hasFocus) {
    }

    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
}
