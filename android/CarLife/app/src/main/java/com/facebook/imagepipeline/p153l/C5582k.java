package com.facebook.imagepipeline.p153l;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p256c.C5303a;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* compiled from: DataFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.k */
public class C5582k extends C5552y {
    /* renamed from: a */
    private static final String f22597a = "DataFetchProducer";

    public C5582k(C5642z pooledByteBufferFactory, boolean fileDescriptorEnabled) {
        super(C5303a.m18087a(), pooledByteBufferFactory, fileDescriptorEnabled);
    }

    /* renamed from: a */
    protected C2952d mo4123a(C2959c imageRequest) throws IOException {
        byte[] data = C5582k.m19319a(imageRequest.b().toString());
        return m19149a(new ByteArrayInputStream(data), data.length);
    }

    /* renamed from: a */
    protected String mo4124a() {
        return f22597a;
    }

    @VisibleForTesting
    /* renamed from: a */
    static byte[] m19319a(String uri) {
        C5350k.m18315a(uri.substring(0, 5).equals("data:"));
        int commaPos = uri.indexOf(44);
        String dataStr = uri.substring(commaPos + 1, uri.length());
        if (C5582k.m19320b(uri.substring(0, commaPos))) {
            return Base64.decode(dataStr, 0);
        }
        return Uri.decode(dataStr).getBytes();
    }

    @VisibleForTesting
    /* renamed from: b */
    static boolean m19320b(String prefix) {
        if (!prefix.contains(";")) {
            return false;
        }
        String[] parameters = prefix.split(";");
        return parameters[parameters.length - 1].equals("base64");
    }
}
