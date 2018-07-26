package com.baidu.carlife.logic.p082b.p091c.p093b;

import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.logic.p082b.p090b.C1717a;
import com.baidu.carlife.logic.p082b.p091c.p092a.C1723b;
import com.baidu.carlife.logic.p082b.p091c.p092a.C1726c;
import com.baidu.carlife.logic.p082b.p094d.C1735a;
import com.baidu.carlife.logic.p082b.p094d.C1744b;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.p061f.C1139a.C1132a;
import com.baidu.carlife.p059c.p066e.C1135b;
import com.baidu.carlife.util.C2186p;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

/* compiled from: MapSettingListPresenter */
/* renamed from: com.baidu.carlife.logic.b.c.b.b */
public class C1741b extends C1135b<C1717a> {
    /* renamed from: a */
    private static final int f5268a = 0;
    /* renamed from: b */
    private static final int f5269b = 1;
    /* renamed from: c */
    private static final int f5270c = 2;

    /* compiled from: MapSettingListPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.b.b$1 */
    class C17371 extends C1726c {
        /* renamed from: a */
        final /* synthetic */ C1741b f5264a;

        C17371(C1741b this$0) {
            this.f5264a = this$0;
        }

        /* renamed from: f */
        protected C1105d<Void, Void> mo1624f() {
            return new C1735a(this, NaviFragmentManager.TYPE_SETTING_NAVI, null) {
                /* renamed from: a */
                final /* synthetic */ C17371 f5263a;

                /* renamed from: b */
                protected void mo1626b() {
                    C2186p.m8304a().m8323c(C1253f.jD, false);
                    ((C1717a) this.f5263a.m3818e()).m6278c().mo1419b(Boolean.valueOf(false));
                }
            };
        }
    }

    /* compiled from: MapSettingListPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.b.b$2 */
    class C17392 extends C1723b {
        /* renamed from: a */
        final /* synthetic */ C1741b f5266a;

        C17392(C1741b this$0) {
            this.f5266a = this$0;
        }

        /* renamed from: f */
        protected C1105d<Void, Void> mo1627f() {
            return new C1735a(this, NaviFragmentManager.TYPE_LOCAL_MAP_MANAGER, null) {
                /* renamed from: a */
                final /* synthetic */ C17392 f5265a;

                /* renamed from: b */
                protected void mo1626b() {
                    C2186p.m8304a().m8323c(C1253f.jC, false);
                    ((C1717a) this.f5265a.m3818e()).m6278c().mo1419b(Boolean.valueOf(false));
                }
            };
        }
    }

    /* compiled from: MapSettingListPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.b.b$3 */
    class C17403 extends C1723b {
        /* renamed from: a */
        final /* synthetic */ C1741b f5267a;

        C17403(C1741b this$0) {
            this.f5267a = this$0;
        }

        /* renamed from: f */
        protected C1105d<Void, Void> mo1627f() {
            return new C1744b(NaviFragmentManager.TYPE_OFFLINE_DATA, null);
        }
    }

    /* renamed from: d */
    public C1132a mo1625d(int position) {
        switch (position) {
            case 0:
                StatisticManager.onEvent(StatisticConstants.NAVI_0033, StatisticConstants.NAVI_0033);
                return new C17392(this);
            case 1:
                return new C17403(this);
            case 2:
                return new C17371(this);
            default:
                throw new IllegalArgumentException("position out of bound");
        }
    }
}
