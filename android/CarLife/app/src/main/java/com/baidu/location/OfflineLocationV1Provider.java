package com.baidu.location;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import com.baidu.location.p193e.C3349d;

public final class OfflineLocationV1Provider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String nameForUid = getContext().getPackageManager().getNameForUid(Binder.getCallingUid());
        C3349d.m14172a(getContext());
        return !C3349d.m14171a().m14184b(nameForUid) ? C3349d.m14171a().m14181a(strArr) : null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
