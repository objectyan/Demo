package com.baidu.mobstat;

import java.util.Comparator;

class ce implements Comparator<String> {
    /* renamed from: a */
    final /* synthetic */ cc f19554a;

    ce(cc ccVar) {
        this.f19554a = ccVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15547a((String) obj, (String) obj2);
    }

    /* renamed from: a */
    public int m15547a(String str, String str2) {
        return str.compareTo(str2);
    }
}
