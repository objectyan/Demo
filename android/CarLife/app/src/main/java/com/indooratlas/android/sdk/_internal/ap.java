package com.indooratlas.android.sdk._internal;

import com.baidu.mobstat.Config;
import com.indooratlas.android.sdk._internal.gf.C5920a;
import com.indooratlas.android.sdk._internal.gk.C5925a;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

final class ap implements gf {
    /* renamed from: a */
    private final an f22970a;

    ap(an anVar) {
        this.f22970a = anVar;
    }

    /* renamed from: a */
    public final gm mo4589a(C5920a c5920a) throws IOException {
        Object obj;
        gk a = c5920a.mo4689a();
        String a2 = a.m20710a("X-IA-Skip-Signature");
        if (!this.f22970a.a() || ((a2 != null && "true".equals(a2)) || !a.m20710a("Host").endsWith(".indooratlas.com"))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return c5920a.mo4690a(a);
        }
        CharSequence a3 = a.m20710a("Content-Type");
        String a4 = a.m20710a("Date");
        ge a5 = a.m20709a();
        String d = a5.m20650d();
        a2 = a5.m20653g();
        String b = a.m20711b();
        a2 = a2 != null ? URLDecoder.decode(a2, "UTF-8") : null;
        Map emptyMap = Collections.emptyMap();
        byte[] bArr = null;
        gl d2 = a.m20713d();
        if (d2 != null) {
            io inVar = new in();
            d2.mo4587a(inVar);
            inVar.close();
            bArr = inVar.b().n();
        }
        try {
            String str;
            String a6;
            Date a7 = af.m19797a(a4);
            fi fiVar = new fi();
            if (af.m19798a(a3)) {
                str = "";
            } else {
                CharSequence charSequence = a3;
            }
            an anVar = this.f22970a;
            anVar.b();
            String str2 = anVar.b;
            anVar = this.f22970a;
            anVar.b();
            String str3 = anVar.c;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(a7);
            String str4 = "";
            if (bArr != null) {
                fiVar.m20556a(bArr);
                a6 = fiVar.m20556a(bArr);
            } else {
                a6 = str4;
            }
            str4 = (a6 == null || "".equals(a6)) ? "" : str.split(";")[0];
            Map treeMap = new TreeMap(emptyMap);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.toUpperCase().trim() + "\n");
            stringBuilder.append(a6 + "\n");
            stringBuilder.append(str4 + "\n");
            stringBuilder.append(format + "\n");
            stringBuilder.append(fi.m20555a(treeMap));
            stringBuilder.append(fi.m20554a(d, a2));
            a2 = fiVar.f23698a.mo4676a(str3, stringBuilder.toString());
            fk fkVar = new fk();
            fkVar.f23702c = "HMAC-256 " + str2 + Config.TRACE_TODAY_VISIT_SPLIT + a2;
            fkVar.f23701b = format;
            fkVar.f23703d = a6;
            fkVar.f23700a = a2;
            C5925a a8 = a.m20714e().m20704a("Authorization", fkVar.f23702c).m20704a("Date", fkVar.f23701b);
            if (!af.m19798a(fkVar.f23703d)) {
                a8.m20704a("Content-SHA256", fkVar.f23703d);
            }
            return c5920a.mo4690a(a8.m20706a());
        } catch (Throwable e) {
            throw new IOException("Failed to parse Date header value: '" + a4 + "'", e);
        } catch (Throwable e2) {
            throw new IOException("Signing request failed", e2);
        } catch (Throwable e22) {
            throw new IOException("Signing request failed", e22);
        }
    }
}
