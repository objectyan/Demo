package com.indooratlas.android.sdk._internal;

import com.baidu.mobstat.Config;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class fi {
    /* renamed from: a */
    public fh f23698a;
    /* renamed from: b */
    private int f23699b;

    public fi() {
        this((byte) 0);
    }

    private fi(byte b) {
        this.f23698a = null;
        this.f23698a = new fj();
        this.f23699b = 10;
    }

    /* renamed from: a */
    public static String m20555a(Map<String, List<String>> map) throws fl {
        StringBuilder stringBuilder = new StringBuilder("");
        for (String str : map.keySet()) {
            if (str.toLowerCase().startsWith("x-ida-")) {
                if (((List) map.get(str)).size() != 1) {
                    throw new fl("Invalid header count for: " + str);
                }
                stringBuilder.append(str.toLowerCase().trim() + Config.TRACE_TODAY_VISIT_SPLIT + ((String) ((List) map.get(str)).get(0)).toLowerCase().trim() + "\n");
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m20554a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str + "\n");
        if (str2 != null && str2.length() > 0) {
            int i;
            String str3;
            List arrayList;
            Map treeMap = new TreeMap();
            String[] split = str2.split("&");
            for (String str32 : split) {
                Object obj;
                String[] split2 = str32.split("=");
                String toLowerCase = split2[0].toLowerCase();
                str32 = "";
                if (split2.length > 1) {
                    obj = split2[1];
                } else {
                    String str4 = str32;
                }
                if (treeMap.containsKey(toLowerCase)) {
                    ((List) treeMap.get(toLowerCase)).add(obj);
                } else {
                    arrayList = new ArrayList();
                    arrayList.add(obj);
                    treeMap.put(toLowerCase, arrayList);
                }
            }
            for (String str322 : treeMap.keySet()) {
                stringBuilder.append(str322 + Config.TRACE_TODAY_VISIT_SPLIT);
                Collections.sort((List) treeMap.get(str322));
                arrayList = (List) treeMap.get(str322);
                i = 0;
                while (true) {
                    if (i != 0) {
                        stringBuilder.append(',');
                    }
                    int i2 = i + 1;
                    stringBuilder.append((String) arrayList.get(i));
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    i = i2;
                }
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public final String m20556a(byte[] bArr) throws NoSuchAlgorithmException {
        return this.f23698a.mo4677a(bArr);
    }
}
