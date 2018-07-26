package com.baidu.tts.p241l;

import android.content.Context;
import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.LibEngineParams;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.C5068a;
import com.baidu.tts.database.C5071d;
import com.baidu.tts.p229d.C5061b;
import com.baidu.tts.p229d.C5064d;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p241l.p242a.C5119h;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* compiled from: ModelMediator */
/* renamed from: com.baidu.tts.l.a */
public class C5120a {
    /* renamed from: a */
    private Context f21242a;
    /* renamed from: b */
    private C5068a f21243b;
    /* renamed from: c */
    private C5071d f21244c;
    /* renamed from: d */
    private C5119h f21245d;
    /* renamed from: e */
    private C5064d f21246e;

    public C5120a(Context context) {
        this.f21242a = context;
        m17356g();
    }

    /* renamed from: g */
    private void m17356g() {
        this.f21243b = new C5068a(this);
        this.f21244c = new C5071d(this);
        this.f21245d = new C5119h(this);
        this.f21246e = new C5064d();
        this.f21246e.m17188a(this);
        this.f21246e.m17187a();
    }

    /* renamed from: a */
    public BasicHandler<ModelBags> m17358a(Conditions conditions) {
        return this.f21245d.m17350a(conditions);
    }

    /* renamed from: a */
    public BasicHandler<ModelBags> m17359a(Conditions conditions, boolean z) {
        return this.f21245d.m17351a(conditions, z);
    }

    /* renamed from: a */
    public LibEngineParams m17362a() {
        return this.f21245d.m17353a();
    }

    /* renamed from: a */
    public BasicHandler<ModelFileBags> m17360a(Set<String> set) {
        return this.f21245d.m17352a((Set) set);
    }

    /* renamed from: b */
    public BasicHandler<ModelFileBags> m17367b(Set<String> set) {
        return this.f21245d.m17355b(set);
    }

    /* renamed from: b */
    public BasicHandler<ModelBags> m17366b() {
        return this.f21245d.m17354b();
    }

    /* renamed from: a */
    public String m17363a(String str, String str2) {
        return this.f21243b.m17206a(str, str2);
    }

    /* renamed from: a */
    public boolean m17365a(String str) {
        Map d = this.f21243b.m17216d(str);
        if (DataTool.isMapEmpty(d)) {
            return false;
        }
        String str2 = (String) d.get(C5089g.ABS_PATH.m17274b());
        String str3 = (String) d.get(C5089g.LENGTH.m17274b());
        String str4 = (String) d.get(C5089g.MD5.m17274b());
        File file = new File(str2);
        if (!file.exists()) {
            return false;
        }
        if (file.length() != Long.parseLong(str3)) {
            return false;
        }
        return MD5.getInstance().getBigFileMd5(file).equalsIgnoreCase(str4);
    }

    /* renamed from: b */
    public boolean m17368b(String str) {
        Map e = this.f21243b.m17217e(str);
        if (DataTool.isMapEmpty(e)) {
            return false;
        }
        return m17365a((String) e.get(C5089g.TEXT_DATA_ID.m17274b())) && m17365a((String) e.get(C5089g.SPEECH_DATA_ID.m17274b()));
    }

    /* renamed from: a */
    public DownloadHandler m17361a(C5061b c5061b) {
        return this.f21246e.m17185a(c5061b);
    }

    /* renamed from: c */
    public void m17369c() {
        this.f21246e.m17189b();
    }

    /* renamed from: d */
    public Context m17371d() {
        return this.f21242a;
    }

    /* renamed from: e */
    public C5068a m17372e() {
        return this.f21243b;
    }

    /* renamed from: c */
    public void m17370c(String str) {
        this.f21244c.m17222a(str);
    }

    /* renamed from: a */
    public void m17364a(String str, String str2, String str3) {
        this.f21244c.m17221a(str, str2, str3);
    }

    /* renamed from: f */
    public Map<String, ArrayList> m17373f() {
        return this.f21244c.m17223a();
    }

    /* renamed from: a */
    public int m17357a(int i, int i2) {
        return this.f21244c.m17220a(i, i2);
    }
}
