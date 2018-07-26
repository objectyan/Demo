package com.baidu.che.codriver.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.logic.codriver.adapter.AdapterDialog;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.che.codriver.p115a.C2509b;
import com.baidu.che.codriver.p122h.C2537a;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p127a.C2650b;
import com.baidu.che.codriver.ui.p128b.C2664a;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.p130a.C2761c;
import com.baidu.che.codriver.widget.C2886d;
import com.baidu.che.codriver.widget.DuerOSMicImageView;
import com.baidu.mobstat.StatService;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MainDialog */
/* renamed from: com.baidu.che.codriver.ui.b */
public class C2675b extends AdapterDialog {
    /* renamed from: g */
    private static final String f8799g = "MainDialog";
    /* renamed from: h */
    private ImageView f8800h;
    /* renamed from: i */
    private ImageView f8801i;
    /* renamed from: j */
    private TextView f8802j;
    /* renamed from: k */
    private ListView f8803k;
    /* renamed from: l */
    private C2664a f8804l;
    /* renamed from: m */
    private DuerOSMicImageView f8805m;
    /* renamed from: n */
    private C2650b f8806n;
    /* renamed from: o */
    private ArrayList<C2549b> f8807o;

    /* compiled from: MainDialog */
    /* renamed from: com.baidu.che.codriver.ui.b$2 */
    class C26632 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2675b f8757a;

        C26632(C2675b this$0) {
            this.f8757a = this$0;
        }

        public void run() {
            this.f8757a.m10051a(1, 500);
        }
    }

    public C2675b(Context context, C2664a listener) {
        super(context, null, C0965R.style.FullScreenDialog);
        this.f8804l = listener;
    }

    protected int getLayoutId() {
        return C0965R.layout.layout_voice_main;
    }

    /* renamed from: a */
    protected void mo1923a(Bundle savedInstanceState) {
        C2725h.m10207b(f8799g, "-----onCreate------");
        C2509b.m9521a().m9525b(this.c);
        mo1529b();
        this.f8807o = new ArrayList();
        this.f8806n = new C2650b(this.c, this.f8807o);
        this.f8803k.setAdapter(this.f8806n);
        StatService.setSessionTimeOut(30);
    }

    /* renamed from: j */
    protected void mo1946j() {
        super.mo1946j();
        C2725h.m10207b(f8799g, "-----onStart------");
        C1261k.m4452a(4100);
        C1261k.m4461b(4100);
        C2537a.m9625a().m9627b();
    }

    /* renamed from: k */
    protected void mo1947k() {
        super.mo1947k();
        C2725h.m10207b(f8799g, "-----onStop------");
        C2537a.m9625a().m9628c();
        if (C2761c.m10463a().m10481f()) {
            C2761c.m10463a().m10482g();
        } else if (C2761c.m10463a().m10480e()) {
            C2761c.m10463a().m10478d();
        }
        this.f8807o.clear();
        this.f8806n.notifyDataSetChanged();
        this.f8806n.m9914a(0);
        this.f8806n.m9915a(C2886d.m10926a());
    }

    /* renamed from: d */
    public void mo1526d() {
        C1261k.m4452a(4100);
        C1261k.m4461b(4100);
        super.mo1526d();
    }

    /* renamed from: f */
    public void mo1530f() {
        C1443g focusViewGroup = new C1443g(m6344a((int) C0965R.id.dialog_container), 9);
        focusViewGroup.m5300d(this.f8800h);
        focusViewGroup.m5244a(true);
        C1440d.m5251a().m5253a(focusViewGroup);
    }

    /* renamed from: b */
    protected void mo1529b() {
        C2725h.m10207b(f8799g, "-----initView-----");
        this.f8800h = (ImageView) m6344a((int) C0965R.id.voice_shut_down_button);
        this.f8801i = (ImageView) m6344a((int) C0965R.id.voice_setting_button);
        this.f8802j = (TextView) m6344a((int) C0965R.id.voice_status_text);
        this.f8803k = (ListView) m6344a((int) C0965R.id.voice_conversation_list);
        View footer = new View(this.c);
        footer.setLayoutParams(new LayoutParams(10, C2716c.m10154d() - getContext().getResources().getDimensionPixelSize(C0965R.dimen.default_44)));
        this.f8803k.addFooterView(footer);
        this.f8805m = (DuerOSMicImageView) m6344a((int) C0965R.id.v_BaiduMic);
        this.f8805m.setOnClickListener(this.f8804l);
        this.f8801i.setOnClickListener(this.f8804l);
        this.f8800h.setOnClickListener(this.f8804l);
        this.f8803k.setOnTouchListener(this.f8804l);
    }

    /* renamed from: a */
    public void m10054a(boolean wakeUp, String word) {
        C2725h.m10207b(f8799g, "------show-------");
        mo1630i();
    }

    /* renamed from: a */
    public void m10053a(C2549b model) {
        if (!m10048b(model)) {
            C2725h.m10207b(f8799g, "------addModel-------type:" + model.f8464f.name());
            Iterator<C2549b> iterator;
            if (model.f8464f == C2695a.TYPE_MUSIC) {
                iterator = this.f8807o.iterator();
                while (iterator.hasNext()) {
                    if (((C2549b) iterator.next()).f8464f == C2695a.TYPE_MUSIC) {
                        iterator.remove();
                        break;
                    }
                }
            } else if (model.f8464f == C2695a.TYPE_LOGIN) {
                iterator = this.f8807o.iterator();
                while (iterator.hasNext()) {
                    if (((C2549b) iterator.next()).f8464f == C2695a.TYPE_LOGIN) {
                        iterator.remove();
                        break;
                    }
                }
                this.f8803k.smoothScrollBy(1, 1);
            }
            this.f8802j.setVisibility(4);
            this.f8803k.setVisibility(0);
            this.f8807o.add(model);
            this.f8806n.notifyDataSetChanged();
            m10062m();
        }
    }

    /* renamed from: b */
    private boolean m10048b(C2549b model) {
        return model == null || !m6351l() || (TextUtils.isEmpty(model.f8465g) && model.f8464f == C2695a.TYPE_NORMAL_REQ);
    }

    /* renamed from: a */
    public void m10051a(int count, int duration) {
        int size = this.f8807o.size();
        int position = size - count;
        C2725h.m10207b(f8799g, "size=" + size + " pos=" + position);
        if (position >= 0 && position <= size) {
            m10046a(this.f8803k, position, duration);
            C2725h.m10207b(f8799g, "smoothScrollToBottom pos=" + position);
        }
    }

    /* renamed from: a */
    private void m10046a(AbsListView view, final int position, int duration) {
        if (!m10047a(view, m10044a((AdapterView) view, position))) {
            view.setOnScrollListener(new OnScrollListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2675b f8756b;

                public void onScrollStateChanged(final AbsListView view, int scrollState) {
                    if (scrollState == 0) {
                        view.setOnScrollListener(null);
                        this.f8756b.f8803k.post(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C26621 f8754b;

                            public void run() {
                                view.setSelection(position);
                            }
                        });
                    }
                }

                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                }
            });
            view.smoothScrollToPositionFromTop(position, 0, duration);
        }
    }

    /* renamed from: a */
    private boolean m10047a(AbsListView view, View child) {
        if (child != null) {
            if (child.getTop() == 0) {
                return true;
            }
            if (child.getTop() > 0 && !view.canScrollVertically(1)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private View m10044a(AdapterView view, int position) {
        int index = position - view.getFirstVisiblePosition();
        if (index < 0 || index >= view.getChildCount()) {
            return null;
        }
        return view.getChildAt(index);
    }

    public void setStatusText(int resId) {
        if (this.f8802j != null) {
            this.f8802j.setVisibility(0);
            this.f8802j.setText(resId);
        }
    }

    public void setStatusText(String text) {
        if (this.f8802j != null) {
            this.f8802j.setVisibility(0);
            this.f8803k.setVisibility(4);
            this.f8802j.setText(text);
        }
    }

    public void setStatusGone() {
        if (this.f8802j != null) {
            this.f8802j.setText("");
            this.f8802j.setVisibility(8);
        }
    }

    public void setStateIniting(String msg) {
        C2725h.m10207b(f8799g, "setStateIniting");
        this.f8805m.mo1980a();
        this.f8802j.setText(msg);
        this.f8802j.setVisibility(0);
        this.f8803k.setVisibility(4);
    }

    public void setStatePrepared() {
        C2725h.m10207b(f8799g, "setStatePrepared");
        this.f8805m.mo1980a();
        this.f8802j.setVisibility(4);
        this.f8802j.setText("");
        this.f8803k.setVisibility(0);
    }

    public void setStateListening() {
        C2725h.m10207b(f8799g, "setStateListening");
        this.f8805m.mo1981b();
        if (m10049q()) {
            this.f8802j.setVisibility(4);
            this.f8802j.setText("");
            this.f8803k.setVisibility(4);
        }
    }

    public void setStateRecording() {
        C2725h.m10207b(f8799g, "setStateRecording");
        this.f8805m.mo1981b();
        if (m10049q()) {
            this.f8802j.setVisibility(0);
            this.f8803k.setVisibility(4);
        }
    }

    public void setStatePrecessing() {
        C2725h.m10207b(f8799g, "setStatePrecessing");
        this.f8805m.mo1982c();
        this.f8802j.setVisibility(4);
        this.f8802j.setText("");
        this.f8803k.setVisibility(0);
    }

    /* renamed from: q */
    private boolean m10049q() {
        if (this.f8807o.isEmpty()) {
            return true;
        }
        C2549b lastConversation = (C2549b) this.f8807o.get(this.f8807o.size() - 1);
        if (lastConversation == null || lastConversation.f8464f == C2695a.TYPE_NORMAL_REQ || lastConversation.f8468j != 1) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public void m10062m() {
        this.f8803k.post(new C26632(this));
    }

    /* renamed from: b */
    public void m10056b(String text) {
        setStatusText(text);
    }

    /* renamed from: n */
    public boolean m10063n() {
        m10062m();
        return !(this.f8806n.m9913a() instanceof C2886d) && m10050r();
    }

    /* renamed from: r */
    private boolean m10050r() {
        return this.f8806n.m9916b() <= this.f8803k.getLastVisiblePosition() && this.f8806n.m9916b() >= this.f8803k.getFirstVisiblePosition();
    }

    /* renamed from: o */
    public boolean m10064o() {
        return this.f8806n.m9913a().mo1983b();
    }

    /* renamed from: p */
    public boolean m10065p() {
        return this.f8806n.m9913a().mo1984c();
    }

    /* renamed from: c */
    public void mo1629c() {
        this.f = true;
        this.f8804l.mo1925a();
    }
}
