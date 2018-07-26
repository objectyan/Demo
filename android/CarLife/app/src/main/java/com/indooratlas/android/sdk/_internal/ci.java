package com.indooratlas.android.sdk._internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import com.baidu.che.codriver.platform.PlatformConstants;
import java.util.UUID;

public final class ci {
    /* renamed from: a */
    public static final String f23311a = bd.f23074a;
    /* renamed from: b */
    public static final Uri f23312b = Uri.parse("content://" + f23311a);

    /* renamed from: com.indooratlas.android.sdk._internal.ci$a */
    public static final class C5836a implements BaseColumns {
        /* renamed from: a */
        public static final Uri f23310a = Uri.withAppendedPath(ci.f23312b, "events");

        /* renamed from: a */
        public static int m20213a(cj cjVar, String str) {
            SQLiteDatabase a = cjVar.m20220a();
            if (a == null) {
                return 0;
            }
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("sync_batch_id", str);
            return a.update("event", contentValues, "sync_status=?", new String[]{PlatformConstants.CONNECT_EXTRA_VALUE_LOCAL});
        }

        /* renamed from: a */
        public static Cursor m20214a(cj cjVar, String str, String[] strArr, int i) {
            SQLiteDatabase b = cjVar.m20221b();
            if (b == null) {
                return null;
            }
            String valueOf;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sync_batch_id=?");
            String[] strArr2 = new String[]{str};
            String str2 = "event";
            String stringBuilder2 = stringBuilder.toString();
            String str3 = "_id asc";
            if (i != -1) {
                valueOf = String.valueOf(i);
            } else {
                valueOf = null;
            }
            return b.query(str2, strArr, stringBuilder2, strArr2, null, null, str3, valueOf);
        }

        /* renamed from: b */
        public static int m20215b(cj cjVar, String str) {
            SQLiteDatabase a = cjVar.m20220a();
            if (a == null) {
                return 0;
            }
            return a.delete("event", "sync_batch_id=?", new String[]{str});
        }

        /* renamed from: c */
        public static int m20216c(cj cjVar, String str) {
            SQLiteDatabase a = cjVar.m20220a();
            if (a == null) {
                return 0;
            }
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("sync_batch_id", null);
            return a.update("event", contentValues, "sync_batch_id=?", new String[]{str});
        }
    }

    /* renamed from: a */
    public static String m20217a() {
        return UUID.randomUUID().toString();
    }
}
