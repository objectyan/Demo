package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6149r;

class ac {
    /* renamed from: f */
    private static volatile long f24801f = 0;
    /* renamed from: a */
    private C6119e f24802a;
    /* renamed from: b */
    private C6158h f24803b = null;
    /* renamed from: c */
    private boolean f24804c = false;
    /* renamed from: d */
    private Context f24805d = null;
    /* renamed from: e */
    private long f24806e = System.currentTimeMillis();

    public ac(C6119e c6119e) {
        this.f24802a = c6119e;
        this.f24803b = C6156f.m21971a();
        this.f24804c = c6119e.m21716f();
        this.f24805d = c6119e.m21715e();
    }

    /* renamed from: a */
    private void m21745a(av avVar) {
        aw.m21813b(C6160j.f25107t).m21814a(this.f24802a, avVar);
    }

    /* renamed from: b */
    private void m21747b() {
        if (this.f24802a.m21714d() != null && this.f24802a.m21714d().m22152a()) {
            this.f24803b = C6158h.INSTANT;
        }
        if (C6156f.f25059j && C6162l.m22161a(C6160j.f25107t).m22172e()) {
            this.f24803b = C6158h.INSTANT;
        }
        if (C6156f.m21997b()) {
            C6160j.f25104q.m21825b("strategy=" + this.f24803b.name());
        }
        switch (C6169s.f25135a[this.f24803b.ordinal()]) {
            case 1:
                m21748c();
                return;
            case 2:
                ag.m21760a(this.f24805d).m21789a(this.f24802a, null, this.f24804c, false);
                if (C6156f.m21997b()) {
                    C6160j.f25104q.m21825b("PERIOD currTime=" + this.f24806e + ",nextPeriodSendTs=" + C6160j.f25090c + ",difftime=" + (C6160j.f25090c - this.f24806e));
                }
                if (C6160j.f25090c == 0) {
                    C6160j.f25090c = C6149r.m21911a(this.f24805d, "last_period_ts", 0);
                    if (this.f24806e > C6160j.f25090c) {
                        C6160j.m22145j(this.f24805d);
                    }
                    long m = this.f24806e + ((long) ((C6156f.m22034m() * 60) * 1000));
                    if (C6160j.f25090c > m) {
                        C6160j.f25090c = m;
                    }
                    ar.m21801a(this.f24805d).m21802a();
                }
                if (C6156f.m21997b()) {
                    C6160j.f25104q.m21825b("PERIOD currTime=" + this.f24806e + ",nextPeriodSendTs=" + C6160j.f25090c + ",difftime=" + (C6160j.f25090c - this.f24806e));
                }
                if (this.f24806e > C6160j.f25090c) {
                    C6160j.m22145j(this.f24805d);
                    return;
                }
                return;
            case 3:
            case 4:
                ag.m21760a(this.f24805d).m21789a(this.f24802a, null, this.f24804c, false);
                return;
            case 5:
                ag.m21760a(this.f24805d).m21789a(this.f24802a, new ad(this), this.f24804c, true);
                return;
            case 6:
                if (C6162l.m22161a(C6160j.f25107t).m22170c() == 1) {
                    m21748c();
                    return;
                } else {
                    ag.m21760a(this.f24805d).m21789a(this.f24802a, null, this.f24804c, false);
                    return;
                }
            case 7:
                if (C6144m.m21880e(this.f24805d)) {
                    m21745a(new ae(this));
                    return;
                }
                return;
            default:
                C6160j.f25104q.m21831g("Invalid stat strategy:" + C6156f.m21971a());
                return;
        }
    }

    /* renamed from: c */
    private void m21748c() {
        if (ag.m21774b().f24813a <= 0 || !C6156f.f25062m) {
            m21745a(new af(this));
            return;
        }
        ag.m21774b().m21789a(this.f24802a, null, this.f24804c, true);
        ag.m21774b().m21788a(-1);
    }

    /* renamed from: d */
    private boolean m21750d() {
        if (C6156f.f25057h > 0) {
            if (this.f24806e > C6160j.f25095h) {
                C6160j.f25094g.clear();
                C6160j.f25095h = this.f24806e + C6156f.f25058i;
                if (C6156f.m21997b()) {
                    C6160j.f25104q.m21825b("clear methodsCalledLimitMap, nextLimitCallClearTime=" + C6160j.f25095h);
                }
            }
            Integer valueOf = Integer.valueOf(this.f24802a.mo5015a().m21728a());
            Integer num = (Integer) C6160j.f25094g.get(valueOf);
            if (num != null) {
                C6160j.f25094g.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > C6156f.f25057h) {
                    if (C6156f.m21997b()) {
                        C6160j.f25104q.m21832h("event " + this.f24802a.m21717g() + " was discard, cause of called limit, current:" + num + ", limit:" + C6156f.f25057h + ", period:" + C6156f.f25058i + " ms");
                    }
                    return true;
                }
            }
            C6160j.f25094g.put(valueOf, Integer.valueOf(1));
        }
        return false;
    }

    /* renamed from: a */
    public void m21751a() {
        if (!m21750d()) {
            if (C6156f.f25063n > 0 && this.f24806e >= f24801f) {
                C6160j.m22143i(this.f24805d);
                f24801f = this.f24806e + C6156f.f25064o;
                if (C6156f.m21997b()) {
                    C6160j.f25104q.m21825b("nextFlushTime=" + f24801f);
                }
            }
            if (C6162l.m22161a(this.f24805d).m22173f()) {
                if (C6156f.m21997b()) {
                    C6160j.f25104q.m21825b("sendFailedCount=" + C6160j.f25088a);
                }
                if (C6160j.m22109a()) {
                    ag.m21760a(this.f24805d).m21789a(this.f24802a, null, this.f24804c, false);
                    if (this.f24806e - C6160j.f25089b > 1800000) {
                        C6160j.m22139g(this.f24805d);
                        return;
                    }
                    return;
                }
                m21747b();
                return;
            }
            ag.m21760a(this.f24805d).m21789a(this.f24802a, null, this.f24804c, false);
        }
    }
}
