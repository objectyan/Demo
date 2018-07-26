package com.baidu.carlife.logic.p082b.p091c.p093b;

import com.baidu.carlife.C0965R;
import com.baidu.carlife.logic.p082b.p090b.C1717a;
import com.baidu.carlife.logic.p082b.p091c.p092a.C1726c;
import com.baidu.carlife.logic.p082b.p094d.C1744b;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.p061f.C1139a.C1132a;
import com.baidu.carlife.p059c.p066e.C1135b;
import com.baidu.carlife.p059c.p067g.C1148b;
import com.baidu.che.codriver.ui.C2660a;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

/* compiled from: HomeHelpListPresenter */
/* renamed from: com.baidu.carlife.logic.b.c.b.a */
public class C1734a extends C1135b<C1717a> {
    /* renamed from: a */
    private static final int f5256a = 0;
    /* renamed from: b */
    private static final int f5257b = 1;
    /* renamed from: c */
    private static final int f5258c = 2;
    /* renamed from: d */
    private static final int f5259d = 3;
    /* renamed from: e */
    private ContentFragment f5260e;

    /* compiled from: HomeHelpListPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.b.a$1 */
    class C17291 extends C1726c {
        /* renamed from: a */
        final /* synthetic */ C1734a f5251a;

        /* compiled from: HomeHelpListPresenter */
        /* renamed from: com.baidu.carlife.logic.b.c.b.a$1$1 */
        class C17281 extends C1105d<Void, Void> {
            /* renamed from: a */
            final /* synthetic */ C17291 f5250a;

            /* compiled from: HomeHelpListPresenter */
            /* renamed from: com.baidu.carlife.logic.b.c.b.a$1$1$1 */
            class C17271 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C17281 f5249a;

                C17271(C17281 this$2) {
                    this.f5249a = this$2;
                }

                public void run() {
                    new C2660a(this.f5249a.f5250a.f5251a.f5260e.getContext()).m9956a(false);
                }
            }

            C17281(C17291 this$1) {
                this.f5250a = this$1;
            }

            /* renamed from: a */
            public void m6306a(Void input) {
                C1148b.m3848a().m3849a(new C17271(this));
            }
        }

        C17291(C1734a this$0) {
            this.f5251a = this$0;
        }

        /* renamed from: f */
        protected C1105d<Void, Void> mo1624f() {
            return new C17281(this);
        }
    }

    /* compiled from: HomeHelpListPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.b.a$2 */
    class C17302 extends C1726c {
        /* renamed from: a */
        final /* synthetic */ C1734a f5252a;

        C17302(C1734a this$0) {
            this.f5252a = this$0;
        }

        /* renamed from: f */
        protected C1105d<Void, Void> mo1624f() {
            return new C1744b(NaviFragmentManager.TYPE_CONNECT_HELP, null);
        }
    }

    /* compiled from: HomeHelpListPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.b.a$3 */
    class C17323 extends C1726c {
        /* renamed from: a */
        final /* synthetic */ C1734a f5254a;

        /* compiled from: HomeHelpListPresenter */
        /* renamed from: com.baidu.carlife.logic.b.c.b.a$3$1 */
        class C17311 extends C1105d<Void, Void> {
            /* renamed from: a */
            final /* synthetic */ C17323 f5253a;

            C17311(C17323 this$1) {
                this.f5253a = this$1;
            }

            /* renamed from: a */
            public void m6310a(Void input) {
                this.f5253a.f5254a.f5260e.openWebView(0, NaviFragmentManager.TYPE_COMMON_QUESTION, this.f5253a.f5254a.f5260e.getStringUtil(C0965R.string.home_more_common_question), "http://carlife.baidu.com/static/carlifeweb/problems/android.html");
            }
        }

        C17323(C1734a this$0) {
            this.f5254a = this$0;
        }

        /* renamed from: f */
        protected C1105d<Void, Void> mo1624f() {
            return new C17311(this);
        }
    }

    /* compiled from: HomeHelpListPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.b.a$4 */
    class C17334 extends C1726c {
        /* renamed from: a */
        final /* synthetic */ C1734a f5255a;

        C17334(C1734a this$0) {
            this.f5255a = this$0;
        }

        /* renamed from: f */
        protected C1105d<Void, Void> mo1624f() {
            return new C1744b(NaviFragmentManager.TYPE_SETTING_FEEDBACK, null);
        }
    }

    public C1734a(ContentFragment fragment) {
        this.f5260e = fragment;
    }

    /* renamed from: d */
    public C1132a mo1625d(int position) {
        switch (position) {
            case 0:
                return new C17291(this);
            case 1:
                return new C17302(this);
            case 2:
                return new C17323(this);
            case 3:
                return new C17334(this);
            default:
                throw new IllegalArgumentException("position out of bound");
        }
    }
}
