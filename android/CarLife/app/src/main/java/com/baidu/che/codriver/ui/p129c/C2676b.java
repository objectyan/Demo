package com.baidu.che.codriver.ui.p129c;

import android.view.View;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;

/* compiled from: ConversationItem */
/* renamed from: com.baidu.che.codriver.ui.c.b */
public abstract class C2676b {
    /* renamed from: a */
    private C2549b f8808a;

    /* renamed from: a */
    abstract C2695a mo1948a();

    /* renamed from: a */
    abstract void mo1949a(View view);

    /* renamed from: a */
    public static C2676b m10066a(C2695a itemType) {
        switch (itemType) {
            case TYPE_NORMAL_ASK:
                return new C2686j();
            case TYPE_IMAGE_SEARCH:
                return new C2691o();
            case TYPE_BAIKE:
                return new C2677a();
            case TYPE_NORMAL_REQ:
                return new C2687k();
            case TYPE_NLP_WEATHER:
                return new C2685i();
            case TYPE_NLP_STOCK:
                return new C2692p();
            case TYPE_MUSIC_LIST:
                return new C2682f();
            case TYPE_NEARBY:
                return new C2683g();
            case TYPE_ROUTE:
                return new C2690n();
            case TYPE_NLP_MULTIMOVIE:
                return new C2684h();
            case TYPE_CARD_MOVIE:
                return new C2680d();
            case TYPE_MUSIC:
                return new C2681e();
            case TYPE_WIKI:
                return new C2693q();
            case TYPE_PHONE:
                return new C2689m();
            default:
                try {
                    throw new IllegalArgumentException("not a conversation item type");
                } catch (Exception e) {
                    e.printStackTrace();
                    return new C2686j();
                }
        }
    }

    /* renamed from: a */
    public View m10067a(View parent, View convertView) {
        if (convertView == null) {
            convertView = mo1950b(parent);
        }
        mo1949a(convertView);
        return convertView;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return parent;
    }

    /* renamed from: a */
    public void m10070a(C2549b conversationModel) {
        this.f8808a = conversationModel;
    }

    /* renamed from: b */
    public C2549b m10072b() {
        return this.f8808a;
    }
}
