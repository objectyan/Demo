package com.baidu.location.indoor.p197b;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.baidu.location.indoor.b.d */
public final class C3416d {
    /* renamed from: a */
    private byte[] f18505a;
    /* renamed from: b */
    private int f18506b;

    public C3416d() {
        this(512);
    }

    private C3416d(int i) {
        this.f18506b = i;
        this.f18505a = new byte[this.f18506b];
    }

    /* renamed from: a */
    public void m14594a(String str, String str2) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (name == null || !name.contains("../")) {
                        name = str2 + nextEntry.getName();
                        File file = new File(name);
                        if (nextEntry.isDirectory()) {
                            file.mkdirs();
                        } else {
                            File parentFile = file.getParentFile();
                            if (!(parentFile == null || parentFile.exists())) {
                                parentFile.mkdirs();
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(name);
                            while (true) {
                                int read = zipInputStream.read(this.f18505a);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(this.f18505a, 0, read);
                            }
                            fileOutputStream.close();
                        }
                        zipInputStream.closeEntry();
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
