package com.facebook.imagepipeline.p153l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p141m.C2924g;
import com.facebook.common.p257e.C5320a;
import com.facebook.imagepipeline.memory.C5628c;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p276e.C5495d;
import com.facebook.p148h.C5437b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: LocalContentUriThumbnailFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.w */
public class C2956w extends C5552y implements av<C2952d> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f13179a = "LocalContentUriThumbnailFetchProducer";
    /* renamed from: b */
    private static final Class<?> f13180b = C2956w.class;
    /* renamed from: c */
    private static final String[] f13181c = new String[]{"_id", "_data"};
    /* renamed from: d */
    private static final String[] f13182d = new String[]{"_data"};
    /* renamed from: e */
    private static final Rect f13183e = new Rect(0, 0, 512, C5628c.f22756b);
    /* renamed from: f */
    private static final Rect f13184f = new Rect(0, 0, 96, 96);
    /* renamed from: g */
    private static final int f13185g = 0;
    /* renamed from: h */
    private final ContentResolver f13186h;

    public C2956w(Executor executor, C5642z pooledByteBufferFactory, ContentResolver contentResolver, boolean decodeFileDescriptorEnabled) {
        super(executor, pooledByteBufferFactory, decodeFileDescriptorEnabled);
        this.f13186h = contentResolver;
    }

    /* renamed from: a */
    public boolean m11907a(C5495d resizeOptions) {
        return aw.a(f13183e.width(), f13183e.height(), resizeOptions);
    }

    /* renamed from: a */
    protected C2952d m11905a(C2959c imageRequest) throws IOException {
        Uri uri = imageRequest.m11919b();
        if (C2924g.m11282e(uri)) {
            C2952d cameraImage = m11901a(uri, imageRequest.m11922e());
            if (cameraImage != null) {
                return cameraImage;
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    private C2952d m11901a(Uri uri, C5495d resizeOptions) throws IOException {
        Cursor cursor = this.f13186h.query(uri, f13181c, null, null, null);
        if (cursor == null) {
            return null;
        }
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            String pathname = cursor.getString(cursor.getColumnIndex("_data"));
            if (resizeOptions != null) {
                C2952d thumbnail = m11902a(resizeOptions, cursor.getInt(cursor.getColumnIndex("_id")));
                if (thumbnail != null) {
                    thumbnail.m11790c(C2956w.m11904b(pathname));
                    cursor.close();
                    return thumbnail;
                }
            }
            cursor.close();
            return null;
        } finally {
            cursor.close();
        }
    }

    /* renamed from: a */
    private C2952d m11902a(C5495d resizeOptions, int imageId) throws IOException {
        C2952d c2952d = null;
        int thumbnailKind = C2956w.m11903b(resizeOptions);
        if (thumbnailKind != 0) {
            Cursor thumbnailCursor = null;
            try {
                thumbnailCursor = Thumbnails.queryMiniThumbnail(this.f13186h, (long) imageId, thumbnailKind, f13182d);
                if (thumbnailCursor != null) {
                    thumbnailCursor.moveToFirst();
                    if (thumbnailCursor.getCount() > 0) {
                        String thumbnailUri = thumbnailCursor.getString(thumbnailCursor.getColumnIndex("_data"));
                        if (new File(thumbnailUri).exists()) {
                            c2952d = b(new FileInputStream(thumbnailUri), C2956w.m11900a(thumbnailUri));
                            if (thumbnailCursor != null) {
                                thumbnailCursor.close();
                            }
                        }
                    }
                    if (thumbnailCursor != null) {
                        thumbnailCursor.close();
                    }
                } else if (thumbnailCursor != null) {
                    thumbnailCursor.close();
                }
            } catch (Throwable th) {
                if (thumbnailCursor != null) {
                    thumbnailCursor.close();
                }
            }
        }
        return c2952d;
    }

    /* renamed from: b */
    private static int m11903b(C5495d resizeOptions) {
        if (aw.a(f13184f.width(), f13184f.height(), resizeOptions)) {
            return 3;
        }
        if (aw.a(f13183e.width(), f13183e.height(), resizeOptions)) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    private static int m11900a(String pathname) {
        return pathname == null ? -1 : (int) new File(pathname).length();
    }

    /* renamed from: a */
    protected String m11906a() {
        return f13179a;
    }

    /* renamed from: b */
    private static int m11904b(String pathname) {
        int i = 0;
        if (pathname != null) {
            try {
                i = C5437b.a(new ExifInterface(pathname).getAttributeInt("Orientation", 1));
            } catch (IOException ioe) {
                C5320a.e(f13180b, ioe, "Unable to retrieve thumbnail rotation for %s", new Object[]{pathname});
            }
        }
        return i;
    }
}
