package com.indooratlas.android.sdk._internal;

import java.io.File;
import java.io.IOException;

public interface ih {
    /* renamed from: a */
    public static final ih f24355a = new C59801();

    /* renamed from: com.indooratlas.android.sdk._internal.ih$1 */
    static class C59801 implements ih {
        C59801() {
        }

        /* renamed from: a */
        public final void mo4737a(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }
    }

    /* renamed from: a */
    void mo4737a(File file) throws IOException;
}
