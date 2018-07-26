package com.facebook.imagepipeline.p153l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p141m.C2924g;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: LocalContentUriFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.v */
public class C2955v extends C5552y {
    @VisibleForTesting
    /* renamed from: a */
    static final String f13176a = "LocalContentUriFetchProducer";
    /* renamed from: b */
    private static final String[] f13177b = new String[]{"_id", "_data"};
    /* renamed from: c */
    private final ContentResolver f13178c;

    public C2955v(Executor executor, C5642z pooledByteBufferFactory, ContentResolver contentResolver, boolean decodeFileDescriptorEnabled) {
        super(executor, pooledByteBufferFactory, decodeFileDescriptorEnabled);
        this.f13178c = contentResolver;
    }

    /* renamed from: a */
    protected C2952d m11898a(C2959c imageRequest) throws IOException {
        Uri uri = imageRequest.m11919b();
        if (C2924g.m11281d(uri)) {
            InputStream inputStream;
            if (uri.toString().endsWith("/photo")) {
                inputStream = this.f13178c.openInputStream(uri);
            } else {
                inputStream = Contacts.openContactPhotoInputStream(this.f13178c, uri);
                if (inputStream == null) {
                    throw new IOException("Contact photo does not exist: " + uri);
                }
            }
            return b(inputStream, -1);
        }
        if (C2924g.m11282e(uri)) {
            C2952d cameraImage = m11897a(uri);
            if (cameraImage != null) {
                return cameraImage;
            }
        }
        return b(this.f13178c.openInputStream(uri), -1);
    }

    @Nullable
    /* renamed from: a */
    private C2952d m11897a(Uri uri) throws IOException {
        C2952d c2952d = null;
        Cursor cursor = this.f13178c.query(uri, f13177b, null, null, null);
        if (cursor != null) {
            try {
                if (cursor.getCount() != 0) {
                    cursor.moveToFirst();
                    String pathname = cursor.getString(cursor.getColumnIndex("_data"));
                    if (pathname != null) {
                        c2952d = b(new FileInputStream(pathname), C2955v.m11896a(pathname));
                        cursor.close();
                    } else {
                        cursor.close();
                    }
                }
            } finally {
                cursor.close();
            }
        }
        return c2952d;
    }

    /* renamed from: a */
    private static int m11896a(String pathname) {
        return pathname == null ? -1 : (int) new File(pathname).length();
    }

    /* renamed from: a */
    protected String m11899a() {
        return f13176a;
    }
}
