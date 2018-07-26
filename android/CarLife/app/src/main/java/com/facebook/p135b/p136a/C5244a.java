package com.facebook.p135b.p136a;

import javax.annotation.Nullable;

/* compiled from: CacheErrorLogger */
/* renamed from: com.facebook.b.a.a */
public interface C5244a {

    /* compiled from: CacheErrorLogger */
    /* renamed from: com.facebook.b.a.a$a */
    public enum C5243a {
        READ_DECODE,
        READ_FILE,
        READ_FILE_NOT_FOUND,
        READ_INVALID_ENTRY,
        WRITE_ENCODE,
        WRITE_CREATE_TEMPFILE,
        WRITE_UPDATE_FILE_NOT_FOUND,
        WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND,
        WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND,
        WRITE_RENAME_FILE_OTHER,
        WRITE_CREATE_DIR,
        WRITE_CALLBACK_ERROR,
        WRITE_INVALID_ENTRY,
        DELETE_FILE,
        EVICTION,
        GENERIC_IO,
        OTHER
    }

    /* renamed from: a */
    void mo3937a(C5243a c5243a, Class<?> cls, String str, @Nullable Throwable th);
}
