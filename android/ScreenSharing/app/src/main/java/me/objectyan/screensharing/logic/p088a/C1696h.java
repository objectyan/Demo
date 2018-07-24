package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.che.codriver.sdk.p081a.C1695n;
import com.baidu.che.codriver.sdk.p081a.C1695n.C2608a;
import com.baidu.che.codriver.sdk.p081a.C1695n.C2609b;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

/* compiled from: PrivateRadioToolImpl */
/* renamed from: com.baidu.carlife.logic.a.h */
public class C1696h implements C1695n {
    /* renamed from: a */
    public void mo1619a(C2609b model, C2608a listener) {
        C1818h.m6730b().m6831s().m6993a(model.f8632e, listener);
    }

    /* renamed from: a */
    public void mo1618a() {
        C1818h.m6730b().m6831s().mo1661z();
        if (!C1663a.m5979a().m5993N()) {
            StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0004);
        }
    }
}
