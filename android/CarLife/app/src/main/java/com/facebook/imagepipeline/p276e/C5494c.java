package com.facebook.imagepipeline.p276e;

import javax.annotation.Nullable;

/* compiled from: Priority */
/* renamed from: com.facebook.imagepipeline.e.c */
public enum C5494c {
    LOW,
    MEDIUM,
    HIGH;

    /* renamed from: a */
    public static C5494c m18864a(@Nullable C5494c priority1, @Nullable C5494c priority2) {
        if (priority1 == null) {
            return priority2;
        }
        if (priority2 == null) {
            return priority1;
        }
        if (priority1.ordinal() > priority2.ordinal()) {
            return priority1;
        }
        return priority2;
    }
}
