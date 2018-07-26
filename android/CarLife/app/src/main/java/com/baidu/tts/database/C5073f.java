package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: TransactionTask */
/* renamed from: com.baidu.tts.database.f */
public class C5073f {
    /* renamed from: a */
    private SQLiteDatabase f20985a;
    /* renamed from: b */
    private C5065a f20986b;

    /* compiled from: TransactionTask */
    /* renamed from: com.baidu.tts.database.f$a */
    public interface C5065a {
        /* renamed from: a */
        boolean mo3879a(SQLiteDatabase sQLiteDatabase);
    }

    public C5073f(SQLiteDatabase sQLiteDatabase, C5065a c5065a) {
        this.f20985a = sQLiteDatabase;
        this.f20986b = c5065a;
    }

    /* renamed from: a */
    public boolean m17226a() {
        boolean z = false;
        if (!(this.f20986b == null || this.f20985a == null)) {
            try {
                this.f20985a.beginTransaction();
                z = this.f20986b.mo3879a(this.f20985a);
                if (z) {
                    this.f20985a.setTransactionSuccessful();
                }
                if (this.f20985a != null) {
                    this.f20985a.endTransaction();
                    this.f20985a.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.f20985a != null) {
                    this.f20985a.endTransaction();
                    this.f20985a.close();
                }
            } catch (Throwable th) {
                if (this.f20985a != null) {
                    this.f20985a.endTransaction();
                    this.f20985a.close();
                }
            }
        }
        return z;
    }
}
