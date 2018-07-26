package com.baidu.ufosdk.p248b;

import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.ufosdk.util.C5212e;
import com.baidu.ufosdk.util.C5216i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* compiled from: LogcatCollector */
/* renamed from: com.baidu.ufosdk.b.a */
public final class C5168a {
    /* renamed from: a */
    public static String m17555a() {
        String readLine;
        List arrayList = new ArrayList();
        arrayList.add("logcat");
        Collection arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList(new String[]{"-t", "2000", "-v", BaiduNaviParams.KEY_TIME}));
        int indexOf = arrayList2.indexOf("-t");
        if (indexOf >= 0 && indexOf < arrayList2.size() && C5216i.m17756a() < 8) {
            arrayList2.remove(indexOf + 1);
            arrayList2.remove(indexOf);
            arrayList2.add("-d");
        }
        LinkedList c5212e = new C5212e();
        String str = "";
        arrayList.addAll(arrayList2);
        try {
            Process exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
            new Thread(new C5169b(exec)).start();
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                c5212e.add(new StringBuilder(String.valueOf(readLine)).append("\n").toString());
            }
            readLine = c5212e.toString();
            try {
                if (readLine.length() > 65535) {
                    return readLine.substring(readLine.length() - 65535, readLine.length() - 1);
                }
                return readLine;
            } catch (IOException e) {
                return readLine;
            }
        } catch (IOException e2) {
            return str;
        }
    }
}
