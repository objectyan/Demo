package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.baidunavis.BaiduNaviParams;
import java.util.ArrayList;

class ag extends C3586x {
    public ag() {
        super("ap_list3", "Create table if not exists ap_list3(_id Integer primary key AUTOINCREMENT,time VARCHAR(50),content TEXT);");
    }

    /* renamed from: a */
    public ArrayList<C3608w> mo2723a(int i, int i2) {
        Cursor a = m15309a(BaiduNaviParams.KEY_TIME, i, i2);
        ArrayList<C3608w> a2 = m15316a(a);
        if (a != null) {
            a.close();
        }
        return a2;
    }

    /* renamed from: a */
    public long mo2722a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaiduNaviParams.KEY_TIME, str);
        contentValues.put("content", str2);
        return m15307a(contentValues);
    }

    /* renamed from: b */
    public boolean mo2724b(long j) {
        return m15313a(j);
    }

    /* renamed from: a */
    private ArrayList<C3608w> m15316a(Cursor cursor) {
        ArrayList<C3608w> arrayList = new ArrayList();
        if (!(cursor == null || cursor.getCount() == 0)) {
            int columnIndex = cursor.getColumnIndex("_id");
            int columnIndex2 = cursor.getColumnIndex(BaiduNaviParams.KEY_TIME);
            int columnIndex3 = cursor.getColumnIndex("content");
            while (cursor.moveToNext()) {
                arrayList.add(new C3608w(cursor.getLong(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3)));
            }
        }
        return arrayList;
    }
}
