package com.baidu.che.codriver.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/* compiled from: WakeUpTools */
/* renamed from: com.baidu.che.codriver.util.q */
public class C2737q {
    /* renamed from: a */
    public static byte[] m10260a(byte[] src) {
        byte[] dst = new byte[src.length];
        for (int i = 0; i < src.length; i++) {
            dst[i] = (byte) (src[i] ^ -1);
        }
        return dst;
    }

    /* renamed from: a */
    public static byte[] m10259a(String input) throws Exception {
        if (input == null && input.length() == 0) {
            throw new Exception("bad input!");
        }
        StringBuilder rawStringBuilder = new StringBuilder();
        while (rawStringBuilder.length() < 512) {
            rawStringBuilder.append(input + "\r\n");
        }
        return C2737q.m10260a(rawStringBuilder.toString().toString().getBytes("UTF-8"));
    }

    /* renamed from: a */
    static void m10257a(String input, File binFile) throws Exception {
        Throwable th;
        byte[] dst = C2737q.m10259a(input);
        FileOutputStream out = null;
        try {
            FileOutputStream out2 = new FileOutputStream(binFile);
            try {
                out2.write(dst);
                if (out2 != null) {
                    out2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                out = out2;
                if (out != null) {
                    out.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (out != null) {
                out.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    static String m10261b(byte[] binData) throws Exception {
        return new Scanner(new String(C2737q.m10260a(binData), "UTF-8")).nextLine();
    }

    /* renamed from: a */
    public static String m10256a(File binFile) throws Exception {
        Throwable th;
        DataInputStream in = null;
        try {
            DataInputStream in2 = new DataInputStream(new FileInputStream(binFile));
            try {
                byte[] buf = new byte[((int) binFile.length())];
                in2.readFully(buf);
                String b = C2737q.m10261b(buf);
                if (in2 != null) {
                    in2.close();
                }
                return b;
            } catch (Throwable th2) {
                th = th2;
                in = in2;
                if (in != null) {
                    in.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (in != null) {
                in.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static void m10258a(String[] args) throws Exception {
        File binFile = new File("test.bin");
        C2737q.m10257a("百度一下, 度秘你好", binFile);
        String output = C2737q.m10256a(binFile);
        System.out.println(String.format("in: %s, out: %s, equal ? %s", new Object[]{input, output, Boolean.valueOf("百度一下, 度秘你好".equals(output))}));
    }
}
