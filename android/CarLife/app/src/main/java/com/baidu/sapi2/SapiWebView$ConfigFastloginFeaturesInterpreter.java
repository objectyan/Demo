package com.baidu.sapi2;

import com.baidu.sapi2.utils.enums.FastLoginFeature;
import java.util.List;

class SapiWebView$ConfigFastloginFeaturesInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20102a;

    SapiWebView$ConfigFastloginFeaturesInterpreter(SapiWebView sapiWebView) {
        this.f20102a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        List<FastLoginFeature> fastLoginFeatureList = SapiWebView.d(this.f20102a).fastLoginFeatureList;
        if (fastLoginFeatureList == null) {
            return null;
        }
        if (!C4891b.m16250a(this.f20102a.getContext()).m16274b() && fastLoginFeatureList.contains(FastLoginFeature.DEVICE_LOGIN)) {
            fastLoginFeatureList.remove(FastLoginFeature.DEVICE_LOGIN);
        }
        StringBuilder buffer = new StringBuilder();
        if (C4891b.m16250a(this.f20102a.getContext()).m16277c()) {
            return buffer.toString();
        }
        for (int i = 0; i < fastLoginFeatureList.size(); i++) {
            FastLoginFeature f = (FastLoginFeature) fastLoginFeatureList.get(i);
            if (i == 0) {
                buffer.append(f.getStrValue());
            } else {
                buffer.append(",").append(f.getStrValue());
            }
        }
        return buffer.toString();
    }
}
