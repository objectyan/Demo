package com.baidu.che.codriver.sdk.p081a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.che.codriver.p120e.C2534b;
import com.baidu.che.codriver.p120e.C2534b.C2532a;
import com.baidu.che.codriver.p122h.C2539c;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2578b.C2576a;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2707i;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;

/* compiled from: CdPhoneManager */
/* renamed from: com.baidu.che.codriver.sdk.a.i */
public class C2598i {
    /* renamed from: a */
    private static final String f8605a = C2598i.class.getSimpleName();
    /* renamed from: b */
    private C1752b f8606b;
    /* renamed from: c */
    private Context f8607c = C2716c.m10141a();
    /* renamed from: d */
    private C2596a f8608d = C2596a.OTHER;

    /* compiled from: CdPhoneManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.i$b */
    public interface C1752b {
        /* renamed from: a */
        void mo1636a(String str);
    }

    /* compiled from: CdPhoneManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.i$a */
    public enum C2596a {
        DATABASE_READY,
        ACTION_PBAP_DOWNLOAD_SUPPORT,
        CONTACTS_DOWNLOAD_REQUEST,
        CONTACTS_DOWNLOAD_STARTED,
        CONTACTS_DOWNLOAD_PROGRESS,
        CONTACTS_DOWNLOAD_COMPLETE,
        CONTACTS_UPDATE_READY,
        CONTACTS_UPDATE_COMPLETE,
        CALLLOGS_DOWNLOAD_STARTED,
        CALLLOGS_DOWNLOAD_PROGRESS,
        CALLLOGS_DOWNLOAD_COMPLETE,
        OTHER
    }

    /* compiled from: CdPhoneManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.i$c */
    private static class C2597c {
        /* renamed from: a */
        private static C2598i f8604a = new C2598i();

        private C2597c() {
        }
    }

    /* renamed from: a */
    public C2596a m9806a() {
        return this.f8608d;
    }

    /* renamed from: a */
    public void m9808a(String status) {
        Object obj = -1;
        switch (status.hashCode()) {
            case 48:
                if (status.equals("0")) {
                    obj = null;
                    break;
                }
                break;
            case 49:
                if (status.equals("1")) {
                    obj = 1;
                    break;
                }
                break;
            case 50:
                if (status.equals("2")) {
                    obj = 2;
                    break;
                }
                break;
            case 51:
                if (status.equals("3")) {
                    obj = 3;
                    break;
                }
                break;
            case 52:
                if (status.equals("4")) {
                    obj = 4;
                    break;
                }
                break;
            case 53:
                if (status.equals("5")) {
                    obj = 5;
                    break;
                }
                break;
            case 54:
                if (status.equals(C2578b.f8568g)) {
                    obj = 6;
                    break;
                }
                break;
            case 55:
                if (status.equals("7")) {
                    obj = 7;
                    break;
                }
                break;
            case 56:
                if (status.equals(NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL)) {
                    obj = 8;
                    break;
                }
                break;
            case 57:
                if (status.equals("9")) {
                    obj = 9;
                    break;
                }
                break;
            case 1567:
                if (status.equals(C2142b.f6818b)) {
                    obj = 10;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.f8608d = C2596a.DATABASE_READY;
                return;
            case 1:
                this.f8608d = C2596a.ACTION_PBAP_DOWNLOAD_SUPPORT;
                return;
            case 2:
                this.f8608d = C2596a.CONTACTS_DOWNLOAD_REQUEST;
                return;
            case 3:
                this.f8608d = C2596a.CONTACTS_DOWNLOAD_STARTED;
                C2534b.m9598a().m9615e();
                return;
            case 4:
                this.f8608d = C2596a.CONTACTS_DOWNLOAD_PROGRESS;
                return;
            case 5:
                this.f8608d = C2596a.CONTACTS_DOWNLOAD_COMPLETE;
                return;
            case 6:
                this.f8608d = C2596a.CONTACTS_UPDATE_READY;
                return;
            case 7:
                this.f8608d = C2596a.CONTACTS_UPDATE_COMPLETE;
                return;
            case 8:
                this.f8608d = C2596a.CALLLOGS_DOWNLOAD_STARTED;
                return;
            case 9:
                this.f8608d = C2596a.CALLLOGS_DOWNLOAD_PROGRESS;
                return;
            case 10:
                this.f8608d = C2596a.CALLLOGS_DOWNLOAD_COMPLETE;
                return;
            default:
                this.f8608d = C2596a.OTHER;
                return;
        }
    }

    /* renamed from: b */
    public static C2598i m9805b() {
        return C2597c.f8604a;
    }

    /* renamed from: c */
    public C1752b m9812c() {
        return this.f8606b;
    }

    /* renamed from: a */
    public void m9807a(C1752b mPhoneTool) {
        this.f8606b = mPhoneTool;
    }

    /* renamed from: a */
    public void m9809a(String param, String data) {
        C2725h.m10214e("CdPhoneManager", "param:" + param + ";data:" + data);
        C2606l.m9828a().m9829a(C2606l.f8617c, param, data);
    }

    /* renamed from: a */
    public boolean m9810a(int status, C2673m listener) {
        C2725h.m10207b(f8605a, "getBTState:" + C2578b.m9741a().m9746c().toString());
        if (C2578b.m9741a().m9746c() == C2576a.DISABLED) {
            listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_bluetooth_disabled), C2539c.f8340H, 0, C2695a.TYPE_NORMAL_REQ));
            return true;
        } else if (C2578b.m9741a().m9746c() == C2576a.NOPAIR) {
            if (C2578b.m9741a().m9745b() == 1) {
                listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_bluetooth_not_pair_driving), 2, C2695a.TYPE_NORMAL_REQ));
                return true;
            }
            listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_bluetooth_not_pair_open), 2, C2695a.TYPE_NORMAL_REQ));
            C2578b.m9741a().m9747d();
            return true;
        } else if (C2578b.m9741a().m9746c() == C2576a.DISCONNECTED || C2578b.m9741a().m9746c() == C2576a.PAIRED) {
            if (status == 0) {
                listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_bluetooth_not_connected), 2, C2695a.TYPE_NORMAL_REQ));
            } else {
                listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_bluetooth_not_connected_already), 2, C2695a.TYPE_NORMAL_REQ));
            }
            C2578b.m9741a().m9747d();
            return true;
        } else if (C2578b.m9741a().m9746c() != C2576a.CONNECTING) {
            return false;
        } else {
            listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_contact_not_ready), 2, C2695a.TYPE_NORMAL_REQ));
            return true;
        }
    }

    /* renamed from: a */
    public boolean m9811a(C2673m listener) {
        if (C2534b.m9598a().m9614d() == C2532a.EMPTY || C2534b.m9598a().m9614d() == C2532a.REQUESTING) {
            listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_allow_to_read_contract), 2, C2695a.TYPE_NORMAL_REQ));
            return false;
        } else if (C2534b.m9598a().m9614d() == C2532a.DOWNLOADED && C2534b.m9598a().m9612c() == 0) {
            listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_bluetooth_not_contract_todownload), 2, C2695a.TYPE_NORMAL_REQ));
            C2578b.m9741a().m9748e();
            return false;
        } else if (C2598i.m9805b().m9806a() != C2596a.CONTACTS_DOWNLOAD_PROGRESS && C2598i.m9805b().m9806a() != C2596a.CONTACTS_DOWNLOAD_STARTED && C2598i.m9805b().m9806a() != C2596a.CONTACTS_DOWNLOAD_REQUEST) {
            return true;
        } else {
            listener.mo1928a(new C2707i(this.f8607c.getString(C0965R.string.phone_command_contact_reading), 2, C2695a.TYPE_NORMAL_REQ));
            return false;
        }
    }
}
