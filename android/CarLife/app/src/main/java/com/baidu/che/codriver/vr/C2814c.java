package com.baidu.che.codriver.vr;

import android.text.TextUtils;
import com.baidu.che.codriver.util.C2725h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: CustomCommandInterceptor */
/* renamed from: com.baidu.che.codriver.vr.c */
public class C2814c implements C2813i {
    /* renamed from: a */
    public static final String f9191a = "CustomCommandInterceptor";
    /* renamed from: b */
    private Map<String, Set<String>> f9192b = new HashMap();
    /* renamed from: c */
    private C2816f f9193c;

    public C2814c(C2816f listener) {
        this.f9193c = listener;
    }

    /* renamed from: a */
    public void m10640a(String pkg, String words) {
        C2725h.m10207b(f9191a, "registerCommand pkg=" + pkg + " words=" + words);
        if (!TextUtils.isEmpty(pkg) && !TextUtils.isEmpty(pkg)) {
            if (this.f9192b.containsKey(pkg)) {
                ((Set) this.f9192b.get(pkg)).addAll(Arrays.asList(words.split(",")));
                return;
            }
            Set<String> wordSet = new HashSet();
            wordSet.addAll(Arrays.asList(words.split(",")));
            this.f9192b.put(pkg, wordSet);
        }
    }

    /* renamed from: b */
    public void m10641b(String pkg, String words) {
        C2725h.m10207b(f9191a, "unRegisterCommand pkg=" + pkg + " words=" + words);
        Set<String> wordSet = (Set) this.f9192b.get(pkg);
        if (wordSet != null && words != null) {
            wordSet.removeAll(Arrays.asList(words.split(",")));
        }
    }

    /* renamed from: a */
    public void m10639a(String pkg) {
        C2725h.m10207b(f9191a, "unRegisterAll pkg=" + pkg);
        this.f9192b.remove(pkg);
    }

    /* renamed from: b */
    public boolean mo1976b(String result) {
        C2725h.m10207b(f9191a, "onIntercept result:" + result);
        for (String pkg : this.f9192b.keySet()) {
            if (((Set) this.f9192b.get(pkg)).contains(result) && this.f9193c != null) {
                this.f9193c.m10643a(pkg, result);
                return true;
            }
        }
        return false;
    }
}
