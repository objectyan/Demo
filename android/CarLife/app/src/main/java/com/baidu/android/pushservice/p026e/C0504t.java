package com.baidu.android.pushservice.p026e;

import android.content.Context;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviNet;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.t */
public class C0504t extends C0487c {
    public C0504t(C0496l c0496l, Context context) {
        super(c0496l, context);
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", NavUserBehaviourNaviNet.BEHAVIOUR_NAVI_NET_ONLINE);
    }
}
