package com.baidu.che.codriver.model;

import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.util.INoProguard;
import java.util.ArrayList;

public class BaiKeConversationModel extends C2549b {
    /* renamed from: a */
    public BaiKe f8470a;

    public static class BaiKe implements INoProguard {
        public ArrayList<String> images;
        public String title;
    }

    public BaiKeConversationModel(BaiKe baiKe) {
        this.f = C2695a.TYPE_BAIKE;
        this.f8470a = baiKe;
    }
}
