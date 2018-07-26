package com.baidu.che.codriver.p120e;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2721e;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2847o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PhoneManager */
/* renamed from: com.baidu.che.codriver.e.b */
public class C2534b {
    /* renamed from: a */
    private static final String f8281a = "PhoneManager";
    /* renamed from: b */
    private static final Object f8282b = new Object();
    /* renamed from: c */
    private static C2534b f8283c = null;
    /* renamed from: g */
    private static final String[] f8284g = new String[]{"display_name", "data1", "data2"};
    /* renamed from: h */
    private static final int f8285h = 0;
    /* renamed from: i */
    private static final int f8286i = 1;
    /* renamed from: j */
    private static final int f8287j = 2;
    /* renamed from: d */
    private Context f8288d;
    /* renamed from: e */
    private List<C2529a> f8289e = new ArrayList();
    /* renamed from: f */
    private C2532a f8290f = C2532a.EMPTY;

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.che.codriver.e.b$1 */
    class C25301 implements Comparator<C2529a> {
        /* renamed from: a */
        final /* synthetic */ C2534b f8271a;

        C25301(C2534b this$0) {
            this.f8271a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9595a((C2529a) obj, (C2529a) obj2);
        }

        /* renamed from: a */
        public int m9595a(C2529a lhs, C2529a rhs) {
            return lhs.m9591a().length() - rhs.m9591a().length();
        }
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.che.codriver.e.b$a */
    public enum C2532a {
        DOWNLOADED,
        EMPTY,
        DISABLED,
        DOWNLOADING,
        REQUESTING
    }

    /* compiled from: PhoneManager */
    /* renamed from: com.baidu.che.codriver.e.b$b */
    private class C2533b extends AsyncTask<Void, Void, List<C2529a>> {
        /* renamed from: a */
        final /* synthetic */ C2534b f8280a;

        private C2533b(C2534b c2534b) {
            this.f8280a = c2534b;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m9596a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m9597a((List) obj);
        }

        /* renamed from: a */
        protected List<C2529a> m9596a(Void... params) {
            return this.f8280a.m9606g();
        }

        /* renamed from: a */
        protected void m9597a(List<C2529a> result) {
            if (result != null) {
                this.f8280a.m9615e();
                this.f8280a.f8289e.addAll(result);
                C2725h.m10214e(C2534b.f8281a, "ContactTask-resultSize:" + result.size() + "");
                this.f8280a.m9601a((List) result);
            }
        }
    }

    private C2534b() {
    }

    /* renamed from: a */
    public static C2534b m9598a() {
        if (f8283c == null) {
            synchronized (f8282b) {
                if (f8283c == null) {
                    f8283c = new C2534b();
                }
            }
        }
        return f8283c;
    }

    /* renamed from: a */
    public void m9608a(Context context) {
        this.f8288d = context;
        m9605f();
    }

    /* renamed from: a */
    public List<C2529a> m9607a(String name) {
        if (TextUtils.isEmpty(name) || this.f8289e == null) {
            return null;
        }
        List<C2529a> result = new ArrayList();
        String pinyin = m9603d(C2716c.m10160f(name));
        String lastName = null;
        for (C2529a model : this.f8289e) {
            if (!model.m9591a().equals(lastName)) {
                String tempPinyin = m9603d(C2716c.m10160f(model.m9591a()));
                if (!TextUtils.isEmpty(tempPinyin) && tempPinyin.contains(pinyin)) {
                    result.add(model);
                    lastName = model.m9591a();
                }
            }
        }
        Collections.sort(result, new C25301(this));
        return result;
    }

    /* renamed from: b */
    public List<C2529a> m9610b(String name) {
        if (TextUtils.isEmpty(name) || this.f8289e == null) {
            return null;
        }
        List<C2529a> result = new ArrayList();
        for (C2529a model : this.f8289e) {
            if (!TextUtils.isEmpty(model.m9591a()) && model.m9591a().equals(name)) {
                result.add(model);
            }
        }
        if (result.size() > 0) {
            return result;
        }
        String pinyin = m9603d(C2716c.m10160f(name));
        for (C2529a model2 : this.f8289e) {
            String tempPinyin = m9603d(C2716c.m10160f(model2.m9591a()));
            if (!TextUtils.isEmpty(tempPinyin) && tempPinyin.contains(pinyin)) {
                result.add(model2);
            }
        }
        return result;
    }

    /* renamed from: a */
    public void m9609a(C2532a btPhoneState) {
        C2725h.m10207b(f8281a, "----onConnectedStatusChange------" + btPhoneState);
        this.f8290f = btPhoneState;
    }

    /* renamed from: b */
    public void m9611b() {
        m9605f();
    }

    /* renamed from: c */
    public void m9613c(String data) {
        m9604e(data);
    }

    /* renamed from: c */
    public int m9612c() {
        return this.f8289e.size();
    }

    /* renamed from: d */
    public C2532a m9614d() {
        return this.f8290f;
    }

    /* renamed from: f */
    private void m9605f() {
        new C2533b().execute(new Void[0]);
    }

    /* renamed from: e */
    public void m9615e() {
        if (this.f8289e != null) {
            this.f8289e.clear();
        }
    }

    /* renamed from: d */
    private String m9603d(String input) {
        if (TextUtils.isEmpty(input)) {
            return null;
        }
        return input.replaceAll("CH", "C").replaceAll("SH", "S").replaceAll("ZH", "Z").replaceAll("F", "H").replaceAll("R", "N").replaceAll("L", "N").replace(" ", "");
    }

    /* renamed from: a */
    private void m9601a(final List<C2529a> list) {
        if (list != null && !list.isEmpty()) {
            C2721e.m10184a().execute(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C2534b f8273b;

                public void run() {
                    int addTime = 0;
                    StringBuilder sb = new StringBuilder();
                    JSONArray jarr = new JSONArray();
                    Set<String> name = new HashSet();
                    for (C2529a tmp : list) {
                        name.add(tmp.m9591a());
                    }
                    for (String str : name) {
                        addTime++;
                        if (addTime > 400) {
                            break;
                        }
                        jarr.put(str);
                    }
                    C2725h.m10207b(C2534b.f8281a, "all-contact:" + jarr.toString() + "jarr size:" + jarr.length());
                    C2847o.m10687a().m10737a(jarr);
                }
            });
        }
    }

    /* renamed from: g */
    private List<C2529a> m9606g() {
        List<C2529a> list = null;
        Cursor phoneCursor = null;
        try {
            phoneCursor = this.f8288d.getContentResolver().query(Phone.CONTENT_URI, f8284g, null, null, "sort_key");
        } catch (Exception e) {
            C2725h.m10214e(f8281a, "queryContact Exception:" + e.toString());
        }
        if (phoneCursor != null) {
            list = new ArrayList();
            while (phoneCursor.moveToNext()) {
                String phoneNumber = (phoneCursor.getString(1) + "").replaceAll("[-() ]+", "");
                String contactName = phoneCursor.getString(0) + "";
                C2529a newContact = new C2529a();
                newContact.m9592a(contactName);
                newContact.m9594b(phoneNumber);
                list.add(newContact);
            }
            phoneCursor.close();
        }
        return list;
    }

    /* renamed from: e */
    private void m9604e(String data) {
        List<C2529a> result = new ArrayList();
        try {
            JSONObject res = new JSONObject(data);
            JSONArray displayNameList = res.getJSONArray("display_name");
            JSONArray phoneNumberList = res.getJSONArray("phone_number");
            for (int x = 0; x < displayNameList.length(); x++) {
                String contactName = displayNameList.getString(x);
                String phoneNumber = phoneNumberList.getString(x).replaceAll("[-() ]+", "");
                C2529a newContact = new C2529a();
                newContact.m9592a(contactName);
                newContact.m9594b(phoneNumber);
                result.add(newContact);
            }
        } catch (JSONException j) {
            j.printStackTrace();
        }
        if (result != null) {
            m9615e();
            this.f8289e.addAll(result);
        }
    }
}
