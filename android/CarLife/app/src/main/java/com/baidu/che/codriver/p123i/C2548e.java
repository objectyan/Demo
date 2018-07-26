package com.baidu.che.codriver.p123i;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: WriteFileUtils */
/* renamed from: com.baidu.che.codriver.i.e */
public class C2548e {
    /* renamed from: a */
    private static final String f8457a = "WriteFileUtils";
    /* renamed from: b */
    private static C2548e f8458b;
    /* renamed from: c */
    private DataOutputStream f8459c;

    /* renamed from: a */
    public static C2548e m9654a() {
        if (f8458b == null) {
            f8458b = new C2548e();
        }
        return f8458b;
    }

    /* renamed from: a */
    public void m9655a(String path) {
        File audioFile = new File(path + ".pcm");
        File parent = audioFile.getParentFile();
        if (!(parent == null || parent.exists())) {
            parent.mkdirs();
        }
        try {
            if (!audioFile.exists()) {
                audioFile.createNewFile();
            }
            audioFile.setWritable(true);
            this.f8459c = new DataOutputStream(new FileOutputStream(audioFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m9656a(byte[] audioData) {
        if (audioData != null && audioData.length > 0) {
            try {
                if (this.f8459c != null) {
                    this.f8459c.write(audioData, 0, audioData.length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m9657b() {
        if (this.f8459c != null) {
            try {
                this.f8459c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f8459c = null;
    }
}
