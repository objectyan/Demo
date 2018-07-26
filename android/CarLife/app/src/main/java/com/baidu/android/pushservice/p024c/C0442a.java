package com.baidu.android.pushservice.p024c;

import com.baidu.android.pushservice.p027f.C0521b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* renamed from: com.baidu.android.pushservice.c.a */
public class C0442a {
    /* renamed from: a */
    public static String m1908a() {
        return "QM/LurxEwvmX7RXA7cj5A6YOE9UNth30QE0T/8ZIdzn+9n7bHEY83yXrh+PjawH+NvooDz6aiM/AHshDo/AvNNyF5eOIihFbRNb4SSf56B6CFneI7NUf9VlyZVKcyfwfJbxO8YS4KG8y891gB5xNw+La7Ib4auEcw5yQdePhK1lvCJdWCbMJUUelU9uEihUy5Pjdt5apgOkU0+TrgJtJ3pr4JJdzrbEJGfruCK1tcACGqKK5KnPI50uXEGc3F0cXPMed6Y3x+9cj9p9/G8nMMkklQUJHTYlLd2Kt470Ipf68c7hlVZ6nESJznJcAjM6DreiD+c/MMXV3mMAEqM9EBh0EPk8ymMj1Ej+1+HfHLgHEz0mIP1y/GGooVglxvrbfLFuHAmKXcSThHYhjv+kVmMZQ71Iyj6Pkdq6LFDuSEFU57tCkBBBRcn5Lol62xz3y15o9/xoSp8vvfyi92YvXRHSdrAC7lTUhUqe9dXSUMO7HiO+gdBwYf9EDiTPom2lcwuEfjyThWKDTEPTF2cishBSYgtRQuXRHkc4wsrhGMPhUZOKZNFHLlMzGQMVoRhU5gs7PB+B/9r5LfFh9+YTrNuLt50orgsGM+/zVgexNgBP73fPLuyfNqJv8zNWc/ZiUPA+0h5KPK+7rYH9xqn1ywA==";
    }

    /* renamed from: a */
    public static String m1909a(String str) {
        BufferedReader bufferedReader;
        InputStream b = C0442a.m1911b(str);
        if (b == null) {
            return C0442a.m1908a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(b, "utf-8"));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuilder.append(readLine);
            }
            C0521b.m2169a(bufferedReader);
        } catch (IOException e) {
            C0521b.m2169a(bufferedReader);
        } catch (UnsupportedEncodingException e2) {
            C0521b.m2169a(b);
        } catch (Throwable th) {
            C0521b.m2169a(b);
        }
        C0521b.m2169a(b);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static boolean m1910a(String str, String str2) {
        Object obj;
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        Writer fileWriter;
        BufferedWriter bufferedWriter;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (Exception e) {
                obj = fileWriter;
                C0521b.m2169a(closeable2, closeable);
                return false;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedWriter = null;
                th = th3;
                C0521b.m2169a(bufferedWriter, fileWriter);
                throw th;
            }
            try {
                bufferedWriter.write(str2);
                C0521b.m2169a(bufferedWriter, fileWriter);
                return true;
            } catch (Exception e2) {
                Object obj2 = bufferedWriter;
                obj = fileWriter;
                C0521b.m2169a(closeable2, closeable);
                return false;
            } catch (Throwable th4) {
                th = th4;
                C0521b.m2169a(bufferedWriter, fileWriter);
                throw th;
            }
        } catch (Exception e3) {
            closeable = null;
            C0521b.m2169a(closeable2, closeable);
            return false;
        } catch (Throwable th22) {
            fileWriter = null;
            th = th22;
            bufferedWriter = null;
            C0521b.m2169a(bufferedWriter, fileWriter);
            throw th;
        }
    }

    /* renamed from: b */
    private static InputStream m1911b(String str) {
        try {
            File file = new File(str);
            return file.exists() ? new FileInputStream(file) : null;
        } catch (Exception e) {
            return null;
        }
    }
}
