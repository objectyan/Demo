package com.baidu.carlife.logic;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.bluetooth.C1043a;
import com.baidu.carlife.bluetooth.C1047b;
import com.baidu.carlife.bluetooth.C1047b.C1045a;
import com.baidu.carlife.bluetooth.C1048c;
import com.baidu.carlife.bluetooth.C1049d;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.logic.voice.C1903m;
import com.baidu.carlife.model.C1935m;
import com.baidu.carlife.model.C1936n;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.util.C2204x;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.CharacterParser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: PhoneManager */
/* renamed from: com.baidu.carlife.logic.q */
public class C1868q {
    /* renamed from: b */
    private static final String f5757b = C1868q.class.getSimpleName();
    /* renamed from: c */
    private static final SimpleDateFormat f5758c = new SimpleDateFormat("HH:mm");
    /* renamed from: d */
    private static final SimpleDateFormat f5759d = new SimpleDateFormat("yy/MM/dd");
    /* renamed from: e */
    private static final int f5760e = 1;
    /* renamed from: f */
    private static final String[] f5761f = new String[]{"display_name", "data1", "data2"};
    /* renamed from: g */
    private static final int f5762g = 0;
    /* renamed from: h */
    private static final int f5763h = 1;
    /* renamed from: i */
    private static final int f5764i = 2;
    /* renamed from: j */
    private static final String[] f5765j = new String[]{"name", C2848p.aL, "type", "date"};
    /* renamed from: k */
    private static final int f5766k = 0;
    /* renamed from: l */
    private static final int f5767l = 1;
    /* renamed from: m */
    private static final int f5768m = 2;
    /* renamed from: n */
    private static final int f5769n = 3;
    /* renamed from: o */
    private static C1868q f5770o;
    /* renamed from: A */
    private boolean f5771A;
    /* renamed from: B */
    private boolean f5772B;
    /* renamed from: C */
    private List<C1561a> f5773C;
    /* renamed from: D */
    private boolean f5774D;
    /* renamed from: E */
    private boolean f5775E;
    /* renamed from: F */
    private boolean f5776F = false;
    /* renamed from: G */
    private Handler f5777G = new Handler(this, Looper.getMainLooper()) {
        /* renamed from: a */
        final /* synthetic */ C1868q f5743a;

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (this.f5743a.f5788w != null) {
                        C1260i.m4435b(C1868q.f5757b, "onloadedCallLog");
                        this.f5743a.f5788w.mo1599b();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    /* renamed from: H */
    private C1045a f5778H = new C18625(this);
    /* renamed from: I */
    private C1049d f5779I = new C18636(this);
    /* renamed from: a */
    C1867f f5780a = null;
    /* renamed from: p */
    private TelephonyManager f5781p;
    /* renamed from: q */
    private boolean f5782q;
    /* renamed from: r */
    private List<C1060g> f5783r;
    /* renamed from: s */
    private Map<String, String> f5784s;
    /* renamed from: t */
    private C1565d f5785t;
    /* renamed from: u */
    private List<C1936n> f5786u;
    /* renamed from: v */
    private List<C1935m> f5787v;
    /* renamed from: w */
    private C1564b f5788w;
    /* renamed from: x */
    private volatile boolean f5789x;
    /* renamed from: y */
    private String f5790y;
    /* renamed from: z */
    private C1047b f5791z;

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$g */
    public interface C1060g {
        /* renamed from: a */
        void mo1389a();

        /* renamed from: a */
        void mo1390a(boolean z);

        /* renamed from: b */
        void mo1391b(boolean z);

        /* renamed from: c */
        void mo1392c(boolean z);

        /* renamed from: d */
        void mo1393d(boolean z);
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$a */
    public interface C1561a {
        /* renamed from: a */
        void mo1595a();

        /* renamed from: a */
        void mo1596a(int i);

        /* renamed from: b */
        void mo1597b();

        /* renamed from: c */
        void mo1598c();
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$b */
    public interface C1564b {
        /* renamed from: b */
        void mo1599b();
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$d */
    public interface C1565d {
        /* renamed from: c */
        void mo1600c();
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$4 */
    class C18614 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1868q f5750a;

        C18614(C1868q this$0) {
            this.f5750a = this$0;
        }

        public void run() {
            this.f5750a.m7101s();
        }
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$5 */
    class C18625 implements C1045a {
        /* renamed from: a */
        final /* synthetic */ C1868q f5751a;

        C18625(C1868q this$0) {
            this.f5751a = this$0;
        }

        /* renamed from: a */
        public void mo1697a(int type, int status, int code) {
            this.f5751a.f5772B = false;
            if (status != 0) {
                switch (type) {
                    case 3:
                        if (this.f5751a.f5773C != null) {
                            for (C1561a callBack : this.f5751a.f5773C) {
                                callBack.mo1595a();
                            }
                            return;
                        }
                        return;
                    case 5:
                        if (this.f5751a.f5773C != null) {
                            for (C1561a callBack2 : this.f5751a.f5773C) {
                                callBack2.mo1596a(code);
                            }
                            return;
                        }
                        return;
                    case 6:
                        if (this.f5751a.f5773C != null) {
                            for (C1561a callBack22 : this.f5751a.f5773C) {
                                callBack22.mo1597b();
                                this.f5751a.f5774D = true;
                            }
                            return;
                        }
                        return;
                    case 7:
                        if (this.f5751a.f5773C != null) {
                            for (C1561a callBack222 : this.f5751a.f5773C) {
                                callBack222.mo1598c();
                                this.f5751a.f5774D = false;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$6 */
    class C18636 implements C1049d {
        /* renamed from: a */
        final /* synthetic */ C1868q f5752a;

        C18636(C1868q this$0) {
            this.f5752a = this$0;
        }

        /* renamed from: a */
        public void mo1384a(boolean isEnable) {
            if (this.f5752a.f5771A != isEnable) {
                this.f5752a.m7069a(this.f5752a.m7116c(), isEnable);
            }
            this.f5752a.f5771A = isEnable;
            C1260i.m4435b("Bt", "isBTConnected = " + this.f5752a.f5771A);
        }

        /* renamed from: a */
        public void mo1383a() {
        }

        /* renamed from: b */
        public void mo1385b() {
        }

        /* renamed from: c */
        public void mo1386c() {
            if (this.f5752a.f5783r != null && !this.f5752a.f5783r.isEmpty()) {
                if (this.f5752a.f5775E) {
                    for (C1060g callBack : this.f5752a.f5783r) {
                        callBack.mo1393d(false);
                    }
                } else {
                    for (C1060g callBack2 : this.f5752a.f5783r) {
                        callBack2.mo1389a();
                    }
                }
                this.f5752a.f5775E = false;
            }
        }

        /* renamed from: d */
        public void mo1387d() {
        }

        /* renamed from: e */
        public void mo1388e() {
            if (this.f5752a.f5783r != null && !this.f5752a.f5783r.isEmpty()) {
                for (C1060g callBack : this.f5752a.f5783r) {
                    callBack.mo1393d(true);
                }
                this.f5752a.f5775E = true;
            }
        }
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$7 */
    class C18647 implements Comparator<C1936n> {
        /* renamed from: a */
        final /* synthetic */ C1868q f5753a;

        C18647(C1868q this$0) {
            this.f5753a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7063a((C1936n) obj, (C1936n) obj2);
        }

        /* renamed from: a */
        public int m7063a(C1936n arg0, C1936n arg1) {
            if (TextUtils.isEmpty(arg0.f6106c) || TextUtils.isEmpty(arg1.f6106c)) {
                return 0;
            }
            if (arg0.f6106c.equals(arg1.f6106c)) {
                return arg0.f6104a.compareTo(arg1.f6104a);
            }
            return arg0.f6106c.compareTo(arg1.f6106c);
        }
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$c */
    private class C1865c extends ContentObserver {
        /* renamed from: a */
        final /* synthetic */ C1868q f5754a;

        public C1865c(C1868q c1868q, Handler handler) {
            this.f5754a = c1868q;
            super(handler);
        }

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            C1260i.m4435b(C1868q.f5757b, "CallLogContentObserver onChange:" + selfChange);
            this.f5754a.m7123i();
        }
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$e */
    private class C1866e extends AsyncTask<Void, Void, List<String>> {
        /* renamed from: a */
        final /* synthetic */ C1868q f5755a;

        private C1866e(C1868q c1868q) {
            this.f5755a = c1868q;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7064a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m7065a((List) obj);
        }

        /* renamed from: a */
        protected List<String> m7064a(Void... params) {
            return this.f5755a.m7100r();
        }

        /* renamed from: a */
        protected void m7065a(List<String> list) {
            super.onPostExecute(list);
            if (this.f5755a.f5785t != null) {
                this.f5755a.f5785t.mo1600c();
            }
        }
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.carlife.logic.q$f */
    private class C1867f extends PhoneStateListener {
        /* renamed from: a */
        final /* synthetic */ C1868q f5756a;

        private C1867f(C1868q c1868q) {
            this.f5756a = c1868q;
        }

        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch (state) {
                case 0:
                    C1260i.m4435b(C1868q.f5757b, "CALL_STATE_IDLE:" + incomingNumber);
                    C1261k.m4461b(2009);
                    this.f5756a.m7098p();
                    C1048c.m3431a();
                    this.f5756a.f5782q = false;
                    this.f5756a.f5775E = false;
                    this.f5756a.f5790y = null;
                    break;
                case 1:
                    C1260i.m4435b(C1868q.f5757b, "CALL_STATE_RINGING:" + incomingNumber);
                    C1903m.m7252a().m7255b();
                    C1261k.m4461b(2004);
                    this.f5756a.m7119d(incomingNumber);
                    if (!TextUtils.isEmpty(incomingNumber)) {
                        this.f5756a.f5790y = this.f5756a.m7117c(incomingNumber);
                    }
                    this.f5756a.f5782q = true;
                    break;
                case 2:
                    C1260i.m4435b(C1868q.f5757b, "CALL_STATE_OFFHOOK:" + incomingNumber);
                    if (!TextUtils.isEmpty(incomingNumber)) {
                        this.f5756a.f5790y = this.f5756a.m7117c(incomingNumber);
                    }
                    C1261k.m4461b(2002);
                    if (!this.f5756a.f5776F) {
                        this.f5756a.m7125k();
                        break;
                    } else {
                        this.f5756a.f5776F = false;
                        break;
                    }
            }
            this.f5756a.m7069a(state, this.f5756a.f5771A);
        }
    }

    /* renamed from: a */
    public String m7102a() {
        C1260i.m4435b(f5757b, "getCurrentName() : mCurrentName = " + this.f5790y);
        if (TextUtils.isEmpty(this.f5790y)) {
            return BaiduNaviApplication.getInstance().getApplicationContext().getString(C0965R.string.phone_name_unknown);
        }
        return this.f5790y;
    }

    /* renamed from: b */
    public boolean m7115b() {
        return this.f5771A;
    }

    /* renamed from: c */
    public int m7116c() {
        if (this.f5781p != null) {
            return this.f5781p.getCallState();
        }
        return 0;
    }

    /* renamed from: d */
    public List<C1936n> m7118d() {
        return this.f5786u;
    }

    /* renamed from: e */
    public List<C1935m> m7120e() {
        return this.f5787v;
    }

    /* renamed from: a */
    public void m7111a(C1060g phoneStateCallBack) {
        if (this.f5783r == null) {
            this.f5783r = new ArrayList();
        }
        if (!this.f5783r.contains(phoneStateCallBack) && phoneStateCallBack != null) {
            this.f5783r.add(phoneStateCallBack);
        }
    }

    /* renamed from: b */
    public void m7114b(C1060g phoneStateCallBack) {
        if (this.f5783r != null && phoneStateCallBack != null) {
            this.f5783r.remove(phoneStateCallBack);
        }
    }

    /* renamed from: a */
    public void m7108a(C1561a callBack) {
        if (this.f5773C == null) {
            this.f5773C = new ArrayList();
        }
        if (!this.f5773C.contains(callBack) && callBack != null) {
            this.f5773C.add(callBack);
        }
    }

    /* renamed from: b */
    public void m7113b(C1561a callBack) {
        if (this.f5773C != null && callBack != null) {
            this.f5773C.remove(callBack);
        }
    }

    /* renamed from: a */
    public void m7109a(C1564b callLogCallBack) {
        this.f5788w = callLogCallBack;
    }

    /* renamed from: a */
    public void m7110a(C1565d contactCallBack) {
        this.f5785t = contactCallBack;
    }

    /* renamed from: f */
    public static C1868q m7089f() {
        if (f5770o == null) {
            f5770o = new C1868q();
        }
        return f5770o;
    }

    /* renamed from: g */
    public void m7121g() {
        m7122h();
        m7099q();
        m7097o();
    }

    /* renamed from: a */
    public List<C1936n> m7103a(String name) {
        if (TextUtils.isEmpty(name) || this.f5786u == null) {
            return null;
        }
        String pinyin = m7086e(CharacterParser.getSelling(name).toUpperCase());
        List<C1936n> result = new ArrayList();
        for (C1936n model : this.f5786u) {
            String tempPinyin = m7086e(model.f6106c);
            if (!TextUtils.isEmpty(tempPinyin) && tempPinyin.contains(pinyin)) {
                result.add(model);
            }
        }
        return result;
    }

    /* renamed from: a */
    public void m7107a(final Context context, String phoneNum) {
        if (context != null && !TextUtils.isEmpty(phoneNum)) {
            if (this.f5781p.getCallState() != 0) {
                C2201w.m8371a((int) C0965R.string.module_tele_call_in_used, 0);
                return;
            }
            if (phoneNum.length() > 40) {
                phoneNum = phoneNum.substring(0, 40);
            }
            final String temp = phoneNum;
            if (C1663a.m5979a().m5993N() && !m7115b() && C1043a.m3360a().f2697w) {
                C2201w.m8371a((int) C0965R.string.phone_bt_tip, 0);
                new Thread(this) {
                    /* renamed from: c */
                    final /* synthetic */ C1868q f5746c;

                    public void run() {
                        C1261k.m4453a((int) C1253f.gV, 400);
                        this.f5746c.m7079b(context, temp);
                        C1261k.m4452a((int) C1253f.gV);
                        C1261k.m4461b((int) C1253f.gW);
                    }
                }.start();
                return;
            }
            new Thread(this) {
                /* renamed from: c */
                final /* synthetic */ C1868q f5749c;

                public void run() {
                    C1261k.m4453a((int) C1253f.gV, 400);
                    this.f5749c.m7079b(context, temp);
                    C1261k.m4452a((int) C1253f.gV);
                    C1261k.m4461b((int) C1253f.gW);
                }
            }.start();
        }
    }

    /* renamed from: b */
    private void m7079b(Context context, String phoneNum) {
        Uri uri = Uri.parse("tel:" + phoneNum);
        Intent it = new Intent();
        it.setAction("android.intent.action.CALL");
        it.setData(uri);
        it.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        try {
            context.startActivity(it);
            this.f5790y = m7117c(phoneNum);
            StatisticManager.onEvent(StatisticConstants.PHONE_002);
        } catch (SecurityException e) {
            C1260i.m4435b(f5757b, e.toString());
            C2201w.m8371a((int) C0965R.string.module_tele_no_call_permission, 0);
        } catch (Exception e2) {
            C1260i.m4435b(f5757b, e2.toString());
            C2201w.m8371a((int) C0965R.string.module_tele_dial_exception, 0);
        }
    }

    /* renamed from: h */
    public void m7122h() {
        new C1866e().execute(new Void[0]);
    }

    /* renamed from: i */
    public void m7123i() {
        if (!this.f5789x) {
            new Thread(new C18614(this)).start();
        }
    }

    /* renamed from: e */
    private String m7086e(String input) {
        if (TextUtils.isEmpty(input)) {
            return null;
        }
        return input.replaceAll("CH", "C").replaceAll("SH", "S").replaceAll("ZH", "Z").replace(" ", "");
    }

    /* renamed from: o */
    private void m7097o() {
        this.f5781p = (TelephonyManager) BaiduNaviApplication.getInstance().getSystemService("phone");
        this.f5780a = new C1867f();
        this.f5781p.listen(this.f5780a, 32);
        if (C1047b.m3397a().f2728A) {
            this.f5776F = true;
        }
        this.f5791z = C1047b.m3397a();
        this.f5791z.m3413a(this.f5779I);
        this.f5791z.m3412a(this.f5778H);
    }

    /* renamed from: a */
    public void m7105a(int state, String incomingNumber) {
        if (this.f5780a != null) {
            this.f5780a.onCallStateChanged(state, incomingNumber);
        }
    }

    /* renamed from: j */
    public boolean m7124j() {
        return this.f5782q;
    }

    /* renamed from: a */
    private void m7069a(int state, boolean isBTConnected) {
        if (this.f5783r != null && !this.f5783r.isEmpty()) {
            switch (state) {
                case 1:
                    for (C1060g callBack : this.f5783r) {
                        callBack.mo1391b(isBTConnected);
                    }
                    return;
                case 2:
                    for (C1060g callBack2 : this.f5783r) {
                        callBack2.mo1392c(isBTConnected);
                    }
                    return;
                default:
                    for (C1060g callBack22 : this.f5783r) {
                        callBack22.mo1390a(isBTConnected);
                    }
                    return;
            }
        }
    }

    /* renamed from: b */
    public List<C1936n> m7112b(String input) {
        if (TextUtils.isEmpty(input) || this.f5786u == null) {
            return null;
        }
        List<C1936n> list = new ArrayList();
        for (C1936n model : this.f5786u) {
            if (!TextUtils.isEmpty(model.f6105b) && model.f6105b.contains(input)) {
                list.add(model);
            }
        }
        return list;
    }

    /* renamed from: c */
    public String m7117c(String num) {
        if (this.f5784s != null && this.f5784s.containsKey(num)) {
            return (String) this.f5784s.get(num);
        }
        if (TextUtils.isEmpty(num)) {
            return null;
        }
        return num;
    }

    /* renamed from: k */
    public void m7125k() {
        C1772k.m6480a().m6485a(1, 2);
        if (C1663a.m5979a().m5993N()) {
            C1212c command = new C1212c(true);
            command.m4201c(C1253f.ai);
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: d */
    public void m7119d(String incomingNumber) {
        C1772k.m6480a().m6485a(1, 1);
        if (C1663a.m5979a().m5993N()) {
            C1212c command = new C1212c(true);
            command.m4201c(C1253f.ah);
            if (!TextUtils.isEmpty(incomingNumber)) {
                command.m4199b(incomingNumber.getBytes());
                command.m4203d(incomingNumber.length());
            }
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: p */
    private void m7098p() {
        C1772k.m6480a().m6485a(1, 0);
        if (C1663a.m5979a().m5993N()) {
            C1212c command = new C1212c(true);
            command.m4201c(C1253f.aj);
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: q */
    private void m7099q() {
        BaiduNaviApplication.getInstance().getContentResolver().registerContentObserver(Calls.CONTENT_URI, true, new C1865c(this, null));
    }

    /* renamed from: r */
    private List<String> m7100r() {
        ContentResolver resolver = BaiduNaviApplication.getInstance().getContentResolver();
        Cursor phoneCursor = null;
        C1261k.m4453a((int) C1253f.gV, 400);
        try {
            phoneCursor = resolver.query(Phone.CONTENT_URI, f5761f, null, null, null);
        } catch (Exception e) {
            C1260i.m4445e(f5757b, "queryPhoneContacts Exception:" + e.toString());
        }
        C1261k.m4452a((int) C1253f.gV);
        C1261k.m4461b((int) C1253f.gW);
        if (phoneCursor == null) {
            return null;
        }
        this.f5784s = new HashMap();
        this.f5786u = new ArrayList();
        SparseArray<List<C1936n>> contactSortKeyMap = new SparseArray();
        List<String> contactNameList = new ArrayList();
        while (phoneCursor.moveToNext()) {
            String phoneNumber = phoneCursor.getString(1);
            if (!TextUtils.isEmpty(phoneNumber)) {
                phoneNumber = phoneNumber.replaceAll("[-() ]+", "");
                String contactName = phoneCursor.getString(0);
                if (!(this.f5784s.containsKey(phoneNumber) || TextUtils.isEmpty(contactName))) {
                    this.f5784s.put(phoneNumber, contactName);
                }
                if (!TextUtils.isEmpty(contactName)) {
                    contactNameList.add(contactName);
                }
                String pinyin = C1251e.m4372f(contactName);
                char key = '\u0000';
                if (!TextUtils.isEmpty(pinyin)) {
                    key = pinyin.charAt(0);
                }
                if (key < 'A' || key > 'Z') {
                    key = '#';
                }
                C1936n newContact = new C1936n();
                newContact.f6104a = contactName;
                newContact.f6105b = phoneNumber;
                newContact.f6106c = pinyin;
                newContact.f6107d = key;
                List<C1936n> tempList = (List) contactSortKeyMap.get(key);
                if (tempList == null) {
                    tempList = new ArrayList();
                    contactSortKeyMap.put(key, tempList);
                }
                tempList.add(newContact);
            }
        }
        phoneCursor.close();
        for (int i = 65; i <= 90; i++) {
            m7073a((List) contactSortKeyMap.get(i));
        }
        m7073a((List) contactSortKeyMap.get(35));
        return contactNameList;
    }

    /* renamed from: a */
    private void m7073a(List<C1936n> list) {
        if (list != null) {
            try {
                Collections.sort(list, new C18647(this));
            } catch (Throwable e) {
                C1260i.m4433a(e);
            }
            for (C1936n model : list) {
                if (!this.f5786u.isEmpty()) {
                    C1936n frontModel = (C1936n) this.f5786u.get(this.f5786u.size() - 1);
                    if (!TextUtils.isEmpty(frontModel.f6104a) && frontModel.f6104a.equals(model.f6104a)) {
                        frontModel.f6110g = true;
                        model.f6109f = true;
                    }
                }
                this.f5786u.add(model);
            }
        }
    }

    /* renamed from: b */
    private static String m7076b(int type) {
        switch (type) {
            case 1:
                return BaiduNaviApplication.getInstance().getApplicationContext().getString(C0965R.string.phone_contract_type_home);
            case 2:
                return BaiduNaviApplication.getInstance().getApplicationContext().getString(C0965R.string.phone_contract_type_mobile);
            case 3:
                return BaiduNaviApplication.getInstance().getApplicationContext().getString(C0965R.string.phone_contract_type_company);
            default:
                return BaiduNaviApplication.getInstance().getApplicationContext().getString(C0965R.string.phone_contract_type_other);
        }
    }

    /* renamed from: a */
    public static String m7068a(Date time) {
        if (time == null) {
            return "";
        }
        return f5759d.format(time);
    }

    /* renamed from: b */
    public static String m7077b(Date time) {
        if (time == null) {
            return "";
        }
        return f5758c.format(time);
    }

    /* renamed from: s */
    private synchronized void m7101s() {
        this.f5789x = true;
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(5, calendar.get(5) - 1);
        String nowDateString = C1868q.m7068a(nowDate);
        String yesterdayDateString = C1868q.m7068a(calendar.getTime());
        String yesterdayString = BaiduNaviApplication.getInstance().getApplicationContext().getString(C0965R.string.phone_calllog_yesterday);
        calendar.set(2, calendar.get(2) - 1);
        long monthAgo = calendar.getTime().getTime();
        ContentResolver resolver = BaiduNaviApplication.getInstance().getContentResolver();
        Cursor callLogCursor = null;
        C1261k.m4453a((int) C1253f.gV, 400);
        try {
            String[] selectionArgs = new String[]{String.valueOf(monthAgo)};
            Uri uri = Calls.CONTENT_URI;
            String[] strArr = f5765j;
            callLogCursor = resolver.query(uri, strArr, "date>?", selectionArgs, "date DESC");
        } catch (Exception e) {
        }
        C1261k.m4452a((int) C1253f.gV);
        C1261k.m4461b((int) C1253f.gW);
        if (callLogCursor != null && callLogCursor.getCount() < 1) {
            try {
                callLogCursor = resolver.query(Calls.CONTENT_URI, f5765j, null, null, "date DESC limit 100");
            } catch (Exception e2) {
            }
        }
        if (callLogCursor == null) {
            this.f5777G.sendEmptyMessage(1);
        } else {
            this.f5787v = new LinkedList();
            while (callLogCursor.moveToNext()) {
                C1935m record = new C1935m();
                record.f6099b = callLogCursor.getString(1);
                record.f6101d = callLogCursor.getInt(2);
                record.f6102e = new Date(callLogCursor.getLong(3));
                String recodeDate = C1868q.m7068a(record.f6102e);
                if (nowDateString.equals(recodeDate)) {
                    record.f6103f = C1868q.m7077b(record.f6102e);
                } else if (yesterdayDateString.equals(recodeDate)) {
                    record.f6103f = yesterdayString;
                } else {
                    record.f6103f = recodeDate;
                }
                if (this.f5787v.isEmpty()) {
                    m7070a(callLogCursor, record);
                } else {
                    C1935m temp = (C1935m) this.f5787v.get(this.f5787v.size() - 1);
                    if (!TextUtils.isEmpty(temp.f6099b) && temp.f6099b.equals(record.f6099b) && temp.f6101d == record.f6101d && C1868q.m7068a(temp.f6102e).equals(recodeDate) && record.f6101d != 0) {
                        temp.f6100c++;
                    } else {
                        m7070a(callLogCursor, record);
                    }
                }
            }
            callLogCursor.close();
            this.f5789x = false;
            this.f5777G.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    private void m7070a(Cursor callLogCursor, C1935m record) {
        record.f6098a = callLogCursor.getString(0);
        if (TextUtils.isEmpty(record.f6098a)) {
            record.f6098a = m7117c(record.f6099b);
        }
        record.f6100c = 1;
        this.f5787v.add(record);
    }

    /* renamed from: l */
    public void m7126l() {
        if (C2204x.m8382b()) {
            C2201w.m8371a((int) C0965R.string.phone_mute_tip, 0);
        } else if (this.f5791z != null && !this.f5772B) {
            this.f5772B = true;
            if (this.f5774D) {
                this.f5791z.m3427i();
            } else {
                this.f5791z.m3426h();
            }
        }
    }

    /* renamed from: m */
    public void m7127m() {
        if (this.f5791z != null && !this.f5772B) {
            this.f5772B = true;
            this.f5791z.m3423e();
        }
    }

    /* renamed from: a */
    public void m7104a(int code) {
        if (this.f5791z != null && !this.f5772B) {
            this.f5772B = true;
            this.f5791z.m3410a(code);
        }
    }

    /* renamed from: a */
    public void m7106a(Context context) {
        boolean result = true;
        try {
            Object telephonyObject = m7075b(context);
            if (telephonyObject != null) {
                Method endCallMethod = telephonyObject.getClass().getMethod("endCall", new Class[0]);
                endCallMethod.setAccessible(true);
                endCallMethod.invoke(telephonyObject, new Object[0]);
            }
        } catch (SecurityException e) {
            result = false;
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            result = false;
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            result = false;
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            result = false;
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            result = false;
            e5.printStackTrace();
        }
        if (result) {
            StatisticManager.onEvent(StatisticConstants.PHONE_003);
        } else {
            C2201w.m8372a("请使用系统电话挂断!");
        }
    }

    /* renamed from: b */
    private Object m7075b(Context context) {
        Object telephonyObject = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method getITelephony = telephonyManager.getClass().getDeclaredMethod("getITelephony", new Class[0]);
            getITelephony.setAccessible(true);
            telephonyObject = getITelephony.invoke(telephonyManager, new Object[0]);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return telephonyObject;
    }

    /* renamed from: b */
    private String m7078b(List<String> contactList) {
        if (contactList == null || contactList.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((String) contactList.get(0));
        for (int i = 1; i < contactList.size(); i++) {
            sb.append(",").append((String) contactList.get(i));
        }
        return sb.toString();
    }
}
