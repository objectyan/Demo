package com.baidu.tts.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p241l.C5120a;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.SqlTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: DbManager */
/* renamed from: com.baidu.tts.database.a */
public class C5068a {
    /* renamed from: a */
    private C5120a f20975a;
    /* renamed from: b */
    private C5069b f20976b;
    /* renamed from: c */
    private ReadWriteLock f20977c = new ReentrantReadWriteLock();
    /* renamed from: d */
    private Lock f20978d = this.f20977c.writeLock();
    /* renamed from: e */
    private Lock f20979e = this.f20977c.readLock();

    public C5068a(C5120a c5120a) {
        this.f20975a = c5120a;
        this.f20976b = new C5069b(this.f20975a.m17371d());
    }

    /* renamed from: a */
    public int m17205a(String str) {
        int a;
        this.f20978d.lock();
        SQLiteDatabase a2;
        try {
            a2 = m17203a();
            a = SpeechModelTable.m17199a(a2, str);
            a2.close();
            this.f20978d.unlock();
        } catch (Exception e) {
            a = -1;
            a2.close();
            this.f20978d.unlock();
        } catch (Throwable th) {
            this.f20978d.unlock();
        }
        return a;
    }

    /* renamed from: b */
    public int m17213b(String str) {
        SQLiteDatabase a;
        int a2;
        this.f20978d.lock();
        try {
            a = m17203a();
            a2 = ModelFileTable.m17194a(a, str);
            a.close();
            this.f20978d.unlock();
        } catch (Exception e) {
            a2 = -1;
            a.close();
            this.f20978d.unlock();
        } catch (Throwable th) {
            this.f20978d.unlock();
        }
        return a2;
    }

    /* renamed from: a */
    public String m17206a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("select b.absPath from speechModel a left join modelFile b on a.");
        stringBuilder.append(str);
        stringBuilder.append("=b.id where a.id=?");
        Map a = m17209a(stringBuilder.toString(), new String[]{str2});
        if (a != null) {
            return (String) a.get(C5089g.ABS_PATH.m17274b());
        }
        return null;
    }

    /* renamed from: a */
    public void m17212a(String str, int i) {
        SQLiteDatabase a;
        this.f20978d.lock();
        try {
            String str2 = "replace into fsFileInfo (absPath,state) values (?, ?)";
            String valueOf = String.valueOf(i);
            String[] strArr = new String[]{str, valueOf};
            a = m17203a();
            a.execSQL(str2, strArr);
            a.close();
            this.f20978d.unlock();
        } catch (Throwable th) {
            this.f20978d.unlock();
        }
    }

    /* renamed from: c */
    public Map<String, String> m17215c(String str) {
        return m17209a("select * from fsFileInfo where absPath=?", new String[]{str});
    }

    /* renamed from: d */
    public Map<String, String> m17216d(String str) {
        return m17209a("select * from modelFile where id=?", new String[]{str});
    }

    /* renamed from: e */
    public Map<String, String> m17217e(String str) {
        return m17209a("select * from speechModel where id=?", new String[]{str});
    }

    /* renamed from: a */
    public void m17211a(ModelFileBags modelFileBags) {
        this.f20978d.lock();
        try {
            ModelFileTable.m17196a(m17203a(), modelFileBags);
        } finally {
            this.f20978d.unlock();
        }
    }

    /* renamed from: a */
    public void m17210a(ModelBags modelBags) {
        this.f20978d.lock();
        try {
            SpeechModelTable.m17201a(m17203a(), modelBags);
        } finally {
            this.f20978d.unlock();
        }
    }

    /* renamed from: a */
    public List<Map<String, String>> m17207a(Conditions conditions) {
        String str = null;
        String[] strArr = null;
        if (!StringTool.isEmpty(conditions.getVersion())) {
            str = "version_min <= ? and version_max >= ?";
            strArr = new String[]{conditions.getVersion(), conditions.getVersion()};
        }
        String[] domainArray = conditions.getDomainArray();
        String[] languageArray = conditions.getLanguageArray();
        String[] qualityArray = conditions.getQualityArray();
        String[] genderArray = conditions.getGenderArray();
        String[] speakerArray = conditions.getSpeakerArray();
        String[] modelIdsArray = conditions.getModelIdsArray();
        String buildInCondition = SqlTool.buildInCondition("domain", domainArray);
        String buildInCondition2 = SqlTool.buildInCondition(SpeechConstant.LANGUAGE, languageArray);
        String buildInCondition3 = SqlTool.buildInCondition("quality", qualityArray);
        String buildInCondition4 = SqlTool.buildInCondition("gender", genderArray);
        String buildInCondition5 = SqlTool.buildInCondition("speaker", speakerArray);
        String buildInCondition6 = SqlTool.buildInCondition("id", modelIdsArray);
        str = SqlTool.buildConditions("and", str, buildInCondition, buildInCondition2, buildInCondition3, buildInCondition4, buildInCondition5, buildInCondition6);
        if (StringTool.isEmpty(str)) {
            return null;
        }
        return m17214b("select * from speechModel where " + str, DataTool.connect(strArr, domainArray, languageArray, qualityArray, genderArray, speakerArray, modelIdsArray));
    }

    /* renamed from: a */
    public List<Map<String, String>> m17208a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        String[] fromSetToArray = DataTool.fromSetToArray(set);
        return m17214b("select * from modelFile where " + SqlTool.buildInCondition("id", fromSetToArray), fromSetToArray);
    }

    /* renamed from: a */
    private SQLiteDatabase m17203a() {
        return this.f20976b.getWritableDatabase();
    }

    /* renamed from: b */
    private SQLiteDatabase m17204b() {
        return this.f20976b.getReadableDatabase();
    }

    /* renamed from: a */
    public Map<String, String> m17209a(String str, String[] strArr) {
        SQLiteDatabase b;
        Exception exception;
        this.f20979e.lock();
        try {
            Map<String, String> map;
            b = m17204b();
            try {
                Cursor rawQuery = b.rawQuery(str, strArr);
                if (rawQuery != null) {
                    Map<String, String> hashMap;
                    if (rawQuery.moveToFirst()) {
                        hashMap = new HashMap();
                        try {
                            String[] columnNames = rawQuery.getColumnNames();
                            int length = columnNames.length;
                            for (int i = 0; i < length; i++) {
                                hashMap.put(columnNames[i], rawQuery.getString(rawQuery.getColumnIndex(columnNames[i])));
                            }
                        } catch (Exception e) {
                            Exception exception2 = e;
                            map = hashMap;
                            exception = exception2;
                            exception.printStackTrace();
                            if (b != null) {
                                b.close();
                            }
                            this.f20979e.unlock();
                            return map;
                        }
                    }
                    hashMap = null;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    map = hashMap;
                } else {
                    map = null;
                }
                if (b != null) {
                    b.close();
                }
            } catch (Exception e2) {
                exception = e2;
                map = null;
                exception.printStackTrace();
                if (b != null) {
                    b.close();
                }
                this.f20979e.unlock();
                return map;
            }
            this.f20979e.unlock();
            return map;
        } catch (Throwable th) {
            this.f20979e.unlock();
        }
    }

    /* renamed from: b */
    public java.util.List<java.util.Map<java.lang.String, java.lang.String>> m17214b(java.lang.String r10, java.lang.String[] r11) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.baidu.tts.database.a.b(java.lang.String, java.lang.String[]):java.util.List<java.util.Map<java.lang.String, java.lang.String>>. bs: [B:17:0x004a, B:23:0x0056]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r9 = this;
        r2 = 0;
        r0 = r9.f20979e;
        r0.lock();
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0053 }
        r0.<init>();	 Catch:{ Exception -> 0x0053 }
        r2 = r9.m17204b();	 Catch:{ Exception -> 0x006d }
        r3 = r2.rawQuery(r10, r11);	 Catch:{ Exception -> 0x006d }
        if (r3 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x006d }
    L_0x0015:
        r1 = r3.moveToFirst();	 Catch:{ Exception -> 0x006d }
        if (r1 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x006d }
    L_0x001b:
        r4 = r3.getColumnNames();	 Catch:{ Exception -> 0x006d }
    L_0x001f:
        r5 = new java.util.HashMap;	 Catch:{ Exception -> 0x006d }
        r5.<init>();	 Catch:{ Exception -> 0x006d }
        r6 = r4.length;	 Catch:{ Exception -> 0x006d }
        r1 = 0;	 Catch:{ Exception -> 0x006d }
    L_0x0026:
        if (r1 >= r6) goto L_0x003a;	 Catch:{ Exception -> 0x006d }
    L_0x0028:
        r7 = r4[r1];	 Catch:{ Exception -> 0x006d }
        r8 = r4[r1];	 Catch:{ Exception -> 0x006d }
        r8 = r3.getColumnIndex(r8);	 Catch:{ Exception -> 0x006d }
        r8 = r3.getString(r8);	 Catch:{ Exception -> 0x006d }
        r5.put(r7, r8);	 Catch:{ Exception -> 0x006d }
        r1 = r1 + 1;	 Catch:{ Exception -> 0x006d }
        goto L_0x0026;	 Catch:{ Exception -> 0x006d }
    L_0x003a:
        r0.add(r5);	 Catch:{ Exception -> 0x006d }
        r1 = r3.moveToNext();	 Catch:{ Exception -> 0x006d }
        if (r1 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x006d }
    L_0x0043:
        if (r3 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x006d }
    L_0x0045:
        r3.close();	 Catch:{ Exception -> 0x006d }
    L_0x0048:
        if (r2 == 0) goto L_0x004d;
    L_0x004a:
        r2.close();	 Catch:{ all -> 0x005f }
    L_0x004d:
        r1 = r9.f20979e;
        r1.unlock();
        return r0;
    L_0x0053:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0056:
        r1.printStackTrace();	 Catch:{ all -> 0x0066 }
        if (r2 == 0) goto L_0x004d;
    L_0x005b:
        r2.close();	 Catch:{ all -> 0x005f }
        goto L_0x004d;
    L_0x005f:
        r0 = move-exception;
        r1 = r9.f20979e;
        r1.unlock();
        throw r0;
    L_0x0066:
        r0 = move-exception;
        if (r2 == 0) goto L_0x006c;
    L_0x0069:
        r2.close();	 Catch:{ all -> 0x005f }
    L_0x006c:
        throw r0;	 Catch:{ all -> 0x005f }
    L_0x006d:
        r1 = move-exception;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.database.a.b(java.lang.String, java.lang.String[]):java.util.List<java.util.Map<java.lang.String, java.lang.String>>");
    }
}
