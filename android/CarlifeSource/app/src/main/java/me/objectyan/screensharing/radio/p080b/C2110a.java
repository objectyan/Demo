package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.p103a.C2108a;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.navi.util.StatisticManager;

/* compiled from: AbsRadioListRequest */
/* renamed from: com.baidu.carlife.radio.b.a */
public abstract class C2110a extends C2108a {
    /* renamed from: a */
    public abstract void mo1775a(C2124l c2124l);

    void f_() {
        mo1780a(null);
    }

    /* renamed from: a */
    void mo1780a(String channelId) {
        if (CarlifeUtil.m4381s() != 0) {
            StatisticManager.onEvent("CONTENT_REC_0001_REQ", "随心听请求次数");
            if (channelId != null) {
                C2105a channelModel = C2142b.m8067a().m8077c(channelId);
                if (channelModel != null) {
                    StatisticManager.onEvent(channelModel.m7899d() + "_REQ", channelModel.m7895b() + "请求次数");
                    return;
                }
                return;
            }
            StatisticManager.onEvent("CONTENT_REC_0011_REQ", "语音点播请求次数");
        }
    }
}
