package com.baidu.che.codriver.protocol.p125a;

import com.baidu.che.codriver.protocol.C2556b;
import com.baidu.che.codriver.protocol.C2560a;
import com.baidu.che.codriver.protocol.C2566d;
import com.baidu.che.codriver.protocol.data.ChannelResult;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ChannelTask */
/* renamed from: com.baidu.che.codriver.protocol.a.a */
public class C2557a extends C2556b<ChannelResult> {
    /* renamed from: a */
    public static final String f8476a = C2557a.class.getSimpleName();

    public C2557a(C2566d<ChannelResult> listener, Class<ChannelResult> clazz) {
        super(listener, clazz);
    }

    /* renamed from: b */
    protected String mo1882b() {
        return C2560a.m9680c();
    }

    /* renamed from: a */
    protected int mo1881a() {
        return 1;
    }

    /* renamed from: h */
    protected byte[] mo1883h() {
        List<BasicNameValuePair> pairList = new ArrayList();
        pairList.add(new BasicNameValuePair("uuid", C2716c.m10168n()));
        pairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_CAR_PLATE, C2716c.m10164j()));
        pairList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        pairList.add(new BasicNameValuePair("an", C2716c.m10159f()));
        pairList.add(new BasicNameValuePair("ac", String.valueOf(C2716c.m10161g())));
        return URLEncodedUtils.format(pairList, "UTF-8").getBytes();
    }
}
