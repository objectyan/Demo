package com.facebook.common.internal;

import javax.annotation.Nullable;

/* compiled from: Preconditions */
/* renamed from: com.facebook.common.internal.k */
public final class C5350k {
    private C5350k() {
    }

    /* renamed from: a */
    public static void m18315a(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public static void m18316a(boolean expression, @Nullable Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    /* renamed from: a */
    public static void m18317a(boolean expression, @Nullable String errorMessageTemplate, @Nullable Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalArgumentException(C5350k.m18313a(errorMessageTemplate, errorMessageArgs));
        }
    }

    /* renamed from: b */
    public static void m18321b(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    public static void m18322b(boolean expression, @Nullable Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    /* renamed from: b */
    public static void m18323b(boolean expression, @Nullable String errorMessageTemplate, @Nullable Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalStateException(C5350k.m18313a(errorMessageTemplate, errorMessageArgs));
        }
    }

    /* renamed from: a */
    public static <T> T m18310a(T reference) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static <T> T m18311a(T reference, @Nullable Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    /* renamed from: a */
    public static <T> T m18312a(T reference, @Nullable String errorMessageTemplate, @Nullable Object... errorMessageArgs) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(C5350k.m18313a(errorMessageTemplate, errorMessageArgs));
    }

    /* renamed from: a */
    public static int m18308a(int index, int size) {
        return C5350k.m18309a(index, size, "index");
    }

    /* renamed from: a */
    public static int m18309a(int index, int size, @Nullable String desc) {
        if (index >= 0 && index < size) {
            return index;
        }
        throw new IndexOutOfBoundsException(C5350k.m18324c(index, size, desc));
    }

    /* renamed from: c */
    private static String m18324c(int index, int size, @Nullable String desc) {
        if (index < 0) {
            return C5350k.m18313a("%s (%s) must not be negative", desc, Integer.valueOf(index));
        } else if (size < 0) {
            throw new IllegalArgumentException("negative size: " + size);
        } else {
            return C5350k.m18313a("%s (%s) must be less than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        }
    }

    /* renamed from: b */
    public static int m18318b(int index, int size) {
        return C5350k.m18319b(index, size, "index");
    }

    /* renamed from: b */
    public static int m18319b(int index, int size, @Nullable String desc) {
        if (index >= 0 && index <= size) {
            return index;
        }
        throw new IndexOutOfBoundsException(C5350k.m18325d(index, size, desc));
    }

    /* renamed from: d */
    private static String m18325d(int index, int size, @Nullable String desc) {
        if (index < 0) {
            return C5350k.m18313a("%s (%s) must not be negative", desc, Integer.valueOf(index));
        } else if (size < 0) {
            throw new IllegalArgumentException("negative size: " + size);
        } else {
            return C5350k.m18313a("%s (%s) must not be greater than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        }
    }

    /* renamed from: a */
    public static void m18314a(int start, int end, int size) {
        if (start < 0 || end < start || end > size) {
            throw new IndexOutOfBoundsException(C5350k.m18320b(start, end, size));
        }
    }

    /* renamed from: b */
    private static String m18320b(int start, int end, int size) {
        if (start < 0 || start > size) {
            return C5350k.m18325d(start, size, "start index");
        }
        if (end < 0 || end > size) {
            return C5350k.m18325d(end, size, "end index");
        }
        return C5350k.m18313a("end index (%s) must not be less than start index (%s)", Integer.valueOf(end), Integer.valueOf(start));
    }

    /* renamed from: a */
    static String m18313a(@Nullable String template, @Nullable Object... args) {
        template = String.valueOf(template);
        StringBuilder builder = new StringBuilder(template.length() + (args.length * 16));
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            int i2 = i + 1;
            builder.append(args[i]);
            templateStart = placeholderStart + 2;
            i = i2;
        }
        builder.append(template.substring(templateStart));
        if (i < args.length) {
            builder.append(" [");
            i2 = i + 1;
            builder.append(args[i]);
            i = i2;
            while (i < args.length) {
                builder.append(", ");
                i2 = i + 1;
                builder.append(args[i]);
                i = i2;
            }
            builder.append(']');
        }
        return builder.toString();
    }
}
