package com.facebook.common.p141m;

import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore.Images.Media;
import javax.annotation.Nullable;

/* compiled from: UriUtil */
/* renamed from: com.facebook.common.m.g */
public class C2924g {
    /* renamed from: a */
    public static final String f12887a = "http";
    /* renamed from: b */
    public static final String f12888b = "https";
    /* renamed from: c */
    public static final String f12889c = "file";
    /* renamed from: d */
    public static final String f12890d = "content";
    /* renamed from: e */
    public static final String f12891e = "asset";
    /* renamed from: f */
    public static final String f12892f = "res";
    /* renamed from: g */
    public static final String f12893g = "data";
    /* renamed from: h */
    private static final String f12894h = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();

    @javax.annotation.Nullable
    /* renamed from: a */
    public static java.lang.String m11277a(android.content.ContentResolver r9, android.net.Uri r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x002d in list [B:13:0x002a]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r8 = 0;
        r0 = com.facebook.common.p141m.C2924g.m11280c(r10);
        if (r0 == 0) goto L_0x0035;
    L_0x0007:
        r6 = 0;
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r9;
        r1 = r10;
        r6 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x002e }
        if (r6 == 0) goto L_0x0028;	 Catch:{ all -> 0x002e }
    L_0x0014:
        r0 = r6.moveToFirst();	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x002e }
    L_0x001a:
        r0 = "_data";	 Catch:{ all -> 0x002e }
        r7 = r6.getColumnIndex(r0);	 Catch:{ all -> 0x002e }
        r0 = -1;	 Catch:{ all -> 0x002e }
        if (r7 == r0) goto L_0x0028;	 Catch:{ all -> 0x002e }
    L_0x0024:
        r8 = r6.getString(r7);	 Catch:{ all -> 0x002e }
    L_0x0028:
        if (r6 == 0) goto L_0x002d;
    L_0x002a:
        r6.close();
    L_0x002d:
        return r8;
    L_0x002e:
        r0 = move-exception;
        if (r6 == 0) goto L_0x0034;
    L_0x0031:
        r6.close();
    L_0x0034:
        throw r0;
    L_0x0035:
        r0 = com.facebook.common.p141m.C2924g.m11279b(r10);
        if (r0 == 0) goto L_0x002d;
    L_0x003b:
        r8 = r10.getPath();
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.m.g.a(android.content.ContentResolver, android.net.Uri):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m11278a(@Nullable Uri uri) {
        String scheme = C2924g.m11286i(uri);
        return f12888b.equals(scheme) || "http".equals(scheme);
    }

    /* renamed from: b */
    public static boolean m11279b(@Nullable Uri uri) {
        return f12889c.equals(C2924g.m11286i(uri));
    }

    /* renamed from: c */
    public static boolean m11280c(@Nullable Uri uri) {
        return "content".equals(C2924g.m11286i(uri));
    }

    /* renamed from: d */
    public static boolean m11281d(Uri uri) {
        return C2924g.m11280c(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(f12894h);
    }

    /* renamed from: e */
    public static boolean m11282e(Uri uri) {
        String uriString = uri.toString();
        return uriString.startsWith(Media.EXTERNAL_CONTENT_URI.toString()) || uriString.startsWith(Media.INTERNAL_CONTENT_URI.toString());
    }

    /* renamed from: f */
    public static boolean m11283f(@Nullable Uri uri) {
        return f12891e.equals(C2924g.m11286i(uri));
    }

    /* renamed from: g */
    public static boolean m11284g(@Nullable Uri uri) {
        return f12892f.equals(C2924g.m11286i(uri));
    }

    /* renamed from: h */
    public static boolean m11285h(@Nullable Uri uri) {
        return "data".equals(C2924g.m11286i(uri));
    }

    @Nullable
    /* renamed from: i */
    public static String m11286i(@Nullable Uri uri) {
        return uri == null ? null : uri.getScheme();
    }

    /* renamed from: a */
    public static Uri m11276a(@Nullable String uriAsString) {
        return uriAsString != null ? Uri.parse(uriAsString) : null;
    }
}
