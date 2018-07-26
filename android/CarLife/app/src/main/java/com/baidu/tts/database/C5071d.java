package com.baidu.tts.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p241l.C5120a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StatisticsDbManager */
/* renamed from: com.baidu.tts.database.d */
public class C5071d {
    /* renamed from: a */
    private C5120a f20980a;
    /* renamed from: b */
    private C5070c f20981b;
    /* renamed from: c */
    private ReadWriteLock f20982c = new ReentrantReadWriteLock();
    /* renamed from: d */
    private Lock f20983d = this.f20982c.writeLock();
    /* renamed from: e */
    private Lock f20984e = this.f20982c.readLock();

    public C5071d(C5120a c5120a) {
        this.f20980a = c5120a;
        this.f20981b = new C5070c(this.f20980a.m17371d());
    }

    /* renamed from: a */
    public long m17222a(String str) {
        this.f20983d.lock();
        SQLiteDatabase b = m17218b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("uuid", str);
            long insert = b.insert("StatisticsInfo", null, contentValues);
            return insert;
        } finally {
            b.close();
            this.f20983d.unlock();
        }
    }

    /* renamed from: a */
    public int m17221a(String str, String str2, String str3) {
        this.f20983d.lock();
        SQLiteDatabase b = m17218b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, str3);
            int update = b.update("StatisticsInfo", contentValues, "uuid=?", new String[]{str});
            if (update == 0) {
                b.insert("StatisticsInfo", null, contentValues);
            }
            b.close();
            this.f20983d.unlock();
            return update;
        } catch (Throwable th) {
            b.close();
            this.f20983d.unlock();
        }
    }

    /* renamed from: a */
    public Map<String, ArrayList> m17223a() {
        Map<String, ArrayList> hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f20984e.lock();
        SQLiteDatabase c = m17219c();
        Cursor rawQuery = c.rawQuery("select * from StatisticsInfo limit 0,100", null);
        while (rawQuery.moveToNext()) {
            try {
                JSONObject jSONObject = new JSONObject();
                int i = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                jSONObject.put("uuid", rawQuery.getString(rawQuery.getColumnIndex("uuid")));
                jSONObject.put("startInfo", rawQuery.getString(rawQuery.getColumnIndex("startInfo")));
                jSONObject.put("endInfo", rawQuery.getString(rawQuery.getColumnIndex("endInfo")));
                arrayList2.add(Integer.valueOf(i));
                arrayList.add(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                rawQuery.close();
                c.close();
                this.f20984e.unlock();
            }
        }
        hashMap.put("listId", arrayList2);
        hashMap.put("list", arrayList);
        rawQuery.close();
        c.close();
        this.f20984e.unlock();
        return hashMap;
    }

    /* renamed from: a */
    public int m17220a(int i, int i2) {
        this.f20983d.lock();
        SQLiteDatabase c = m17219c();
        try {
            int delete = c.delete("StatisticsInfo", "id between ? and ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            LoggerProxy.m17001d("StatisticsDbManager", "delete database=" + delete + "=" + i + "=" + i2);
            return delete;
        } finally {
            c.close();
            this.f20983d.unlock();
        }
    }

    /* renamed from: b */
    private SQLiteDatabase m17218b() {
        return this.f20981b.getWritableDatabase();
    }

    /* renamed from: c */
    private SQLiteDatabase m17219c() {
        return this.f20981b.getReadableDatabase();
    }
}
