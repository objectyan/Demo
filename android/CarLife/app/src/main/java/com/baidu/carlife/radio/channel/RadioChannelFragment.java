package com.baidu.carlife.radio.channel;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.p088a.C1702j;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.radio.p079c.C2139a;
import com.baidu.carlife.radio.p079c.C2139a.C1491a;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p079c.C2143c;
import com.baidu.carlife.radio.p080b.C2112c;
import com.baidu.carlife.radio.p080b.ab;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.view.recyclingviewpager.RecyclingViewPager;
import com.baidu.carlife.view.recyclingviewpager.RecyclingViewPager.C2149a;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticManager;
import java.util.HashMap;

public class RadioChannelFragment extends ContentFragment {
    /* renamed from: a */
    private static final int f6851a = 0;
    /* renamed from: b */
    private static final int f6852b = 8000;
    /* renamed from: c */
    private View f6853c;
    /* renamed from: d */
    private RecyclingViewPager f6854d;
    /* renamed from: e */
    private ImageButton f6855e;
    /* renamed from: f */
    private ViewGroup f6856f;
    /* renamed from: g */
    private int f6857g;
    /* renamed from: h */
    private RadioChannelAdapter f6858h;
    /* renamed from: i */
    private boolean f6859i = false;
    /* renamed from: j */
    private Handler f6860j = new C21451(this);
    /* renamed from: k */
    private C1443g f6861k;
    /* renamed from: l */
    private C1443g f6862l;
    /* renamed from: m */
    private boolean f6863m = false;
    /* renamed from: n */
    private C0936j f6864n = new C21462(this);

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$1 */
    class C21451 extends Handler {
        /* renamed from: a */
        final /* synthetic */ RadioChannelFragment f6839a;

        C21451(RadioChannelFragment this$0) {
            this.f6839a = this$0;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    this.f6839a.dismissGuideHint();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$2 */
    class C21462 extends C0936j {
        /* renamed from: a */
        final /* synthetic */ RadioChannelFragment f6840a;

        C21462(RadioChannelFragment this$0) {
            this.f6840a = this$0;
        }

        public void careAbout() {
            addMsg(230);
            addMsg(225);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 225:
                    this.f6840a.m8119e();
                    return;
                case 230:
                    this.f6840a.m8115d();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$3 */
    class C21473 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ RadioChannelFragment f6841a;

        C21473(RadioChannelFragment this$0) {
            this.f6841a = this$0;
        }

        public void onClick(View v) {
            this.f6841a.back();
        }
    }

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$4 */
    class C21484 extends SimpleOnPageChangeListener {
        /* renamed from: a */
        final /* synthetic */ RadioChannelFragment f6842a;

        C21484(RadioChannelFragment this$0) {
            this.f6842a = this$0;
        }

        public void onPageSelected(int position) {
            if (this.f6842a.f6854d.m8941a()) {
                if (this.f6842a.f6859i && !this.f6842a.f6854d.m8943b()) {
                    this.f6842a.f6859i = false;
                    this.f6842a.f6854d.setTouch(false);
                    String currentId = C1818h.m6730b().m6831s().m6644n();
                    if (C2142b.f6818b.equals(currentId)) {
                        int start = position;
                        int offsetRight = this.f6842a.f6858h.m8090a(currentId) - this.f6842a.f6858h.m8090a(this.f6842a.f6858h.m8092a(start).m7893a());
                        int offsetLeft = offsetRight - this.f6842a.f6858h.m8089a();
                        if (offsetRight < 0) {
                            offsetLeft = offsetRight + this.f6842a.f6858h.m8089a();
                        }
                        if (Math.abs(offsetLeft) < Math.abs(offsetRight)) {
                            this.f6842a.f6857g = start + offsetLeft;
                        } else {
                            this.f6842a.f6857g = start + offsetRight;
                        }
                        this.f6842a.f6854d.setCurrentItem(this.f6842a.f6857g);
                        return;
                    }
                }
                this.f6842a.m8099a(position);
                this.f6842a.m8100a(this.f6842a.f6858h.m8092a(position));
                return;
            }
            this.f6842a.f6854d.setSelectEnable(true);
        }
    }

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$5 */
    class C21505 implements C2149a {
        /* renamed from: a */
        final /* synthetic */ RadioChannelFragment f6843a;

        C21505(RadioChannelFragment this$0) {
            this.f6843a = this$0;
        }

        /* renamed from: a */
        public void mo1783a(RecyclingViewPager viewPager, int position) {
            this.f6843a.m8111c(this.f6843a.f6858h.m8092a(position));
        }
    }

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$6 */
    class C21516 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ RadioChannelFragment f6844a;

        C21516(RadioChannelFragment this$0) {
            this.f6844a = this$0;
        }

        public boolean onTouch(View v, MotionEvent event) {
            return this.f6844a.f6854d.m8942a(event);
        }
    }

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$7 */
    class C21527 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RadioChannelFragment f6845a;

        C21527(RadioChannelFragment this$0) {
            this.f6845a = this$0;
        }

        public void run() {
            this.f6845a.m8099a(this.f6845a.f6857g);
        }
    }

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$8 */
    class C21558 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ RadioChannelFragment f6848a;

        /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$8$1 */
        class C21531 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C21558 f6846a;

            C21531(C21558 this$1) {
                this.f6846a = this$1;
            }

            public void run() {
                this.f6846a.f6848a.f6863m = false;
            }
        }

        /* renamed from: com.baidu.carlife.radio.channel.RadioChannelFragment$8$2 */
        class C21542 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C21558 f6847a;

            C21542(C21558 this$1) {
                this.f6847a = this$1;
            }

            public void run() {
                this.f6847a.f6848a.f6863m = false;
            }
        }

        C21558(RadioChannelFragment this$0) {
            this.f6848a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event != null && event.getAction() == 0) {
                switch (keyCode) {
                    case 23:
                        this.f6848a.m8111c(this.f6848a.f6858h.m8092a(this.f6848a.f6854d.getCurrentItem()));
                        return true;
                    case 300:
                        if (this.f6848a.f6863m) {
                            return true;
                        }
                        if (C1309g.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) {
                            return true;
                        }
                        this.f6848a.f6854d.setCurrentItem(this.f6848a.f6854d.getCurrentItem() + 1);
                        this.f6848a.f6863m = true;
                        this.f6848a.f6864n.postDelayed(new C21531(this), 300);
                        return true;
                    case 301:
                        if (this.f6848a.f6863m) {
                            return true;
                        }
                        if (C1309g.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) {
                            return true;
                        }
                        this.f6848a.f6854d.setCurrentItem(this.f6848a.f6854d.getCurrentItem() - 1);
                        this.f6848a.f6863m = true;
                        this.f6848a.f6864n.postDelayed(new C21542(this), 300);
                        return true;
                }
            }
            return false;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        this.f6859i = false;
        if (this.mBackBundle != null) {
            this.f6859i = this.mBackBundle.getBoolean("is_from_player");
        }
        if (this.f6859i) {
            this.f6854d.setTouch(false);
        }
        return rootView;
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        if (C1249d.m4334m() && C1663a.m5979a().m5993N()) {
            this.f6853c = inflater.inflate(C0965R.layout.fragment_radio_chnl_big_screen, null);
        } else {
            this.f6853c = inflater.inflate(C0965R.layout.fragment_radio_channel, null);
        }
        C1261k.m4460a(this.f6864n);
        new ab().mo1769c();
        new C2112c().mo1769c();
        m8105b();
        return this.f6853c;
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onResume() {
        super.onResume();
        C1261k.m4461b((int) C1253f.gS);
    }

    public void onPause() {
        super.onPause();
        dismissGuideHint();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        dismissGuideHint();
        C2342g.m8864e().m8895f();
    }

    public void onDetach() {
        this.f6864n.removeMessages(230);
        C1261k.m4464b(this.f6864n);
        this.f6864n = null;
        super.onDetach();
    }

    /* renamed from: b */
    private void m8105b() {
        m8110c();
        this.f6855e = (ImageButton) this.f6853c.findViewById(C0965R.id.fragment_radio_channel_back);
        this.f6855e.setBackground(C2251b.m8528b(getContext()));
        this.f6855e.setOnClickListener(new C21473(this));
    }

    /* renamed from: c */
    private void m8110c() {
        this.f6854d = (RecyclingViewPager) this.f6853c.findViewById(C0965R.id.fragment_radio_channel_viewpager);
        this.f6854d.setOffscreenPageLimit(9);
        this.f6858h = new RadioChannelAdapter(getContext(), this.f6854d);
        this.f6858h.m8093a(C2142b.m8067a().m8080e());
        this.f6854d.setAdapter(this.f6858h);
        this.f6854d.addOnPageChangeListener(new C21484(this));
        this.f6854d.setOnItemClickListener(new C21505(this));
        this.f6853c.findViewById(C0965R.id.fragment_radio_channel_viewpager_container).setOnTouchListener(new C21516(this));
        if (this.f6858h.m8089a() > 0) {
            this.f6857g = this.f6858h.m8090a(C1818h.m6730b().m6831s().m6644n()) + ((this.f6858h.getCount() / 2) - ((this.f6858h.getCount() / 2) % this.f6858h.m8089a()));
            this.f6854d.setCurrentItem(this.f6857g);
            this.f6854d.post(new C21527(this));
        }
    }

    public void onInitFocusAreas() {
        if (this.f6861k == null) {
            this.f6861k = new C1443g(this.f6853c, 2, true);
            this.f6861k.m5300d(this.f6853c.findViewById(C0965R.id.fragment_radio_channel_back));
        }
        if (this.f6862l == null) {
            View focusView = this.f6853c.findViewById(C0965R.id.fragment_radio_channel_focus_view);
            this.f6862l = new C1443g(this.f6853c, 4, true);
            this.f6862l.m5300d(focusView);
            this.f6862l.m5295a(new C21558(this));
        }
        C1440d.m5251a().m5256b(this.f6861k, this.f6862l);
        C1440d.m5251a().m5268h(this.f6862l);
    }

    /* renamed from: a */
    private void m8099a(int position) {
        this.f6854d.bringChildToFront(this.f6854d.m8940a(position - 3));
        this.f6854d.bringChildToFront(this.f6854d.m8940a(position + 3));
        this.f6854d.bringChildToFront(this.f6854d.m8940a(position - 2));
        this.f6854d.bringChildToFront(this.f6854d.m8940a(position + 2));
        this.f6854d.bringChildToFront(this.f6854d.m8940a(position - 1));
        this.f6854d.bringChildToFront(this.f6854d.m8940a(position + 1));
        this.f6854d.bringChildToFront(this.f6854d.m8940a(position));
        m8119e();
    }

    /* renamed from: a */
    private void m8100a(final C2105a channel) {
        if (C1251e.m4358a().m4401r()) {
            new C2139a(getContext()).m8066a(this, new C1491a(this) {
                /* renamed from: b */
                final /* synthetic */ RadioChannelFragment f6850b;

                /* renamed from: a */
                public void mo1562a() {
                    if (this.f6850b.m8108b(channel)) {
                        C2201w.m8370a((int) C0965R.string.module_music_not_yet_played);
                        return;
                    }
                    C1702j.m6181a().m6184a(Integer.valueOf(channel.m7893a()).intValue());
                    if (!(TextUtils.equals(channel.m7893a(), C1818h.m6730b().m6831s().m6644n()) && C1818h.m6730b().m6835w())) {
                        StatisticManager.onEvent("CONTENT_REC_0001_CLICK");
                        StatisticManager.onEvent(channel.m7899d() + "_CLICK");
                        C1818h.m6730b().m6798c(channel.m7893a());
                    }
                    this.f6850b.m8116d(channel);
                }
            });
        } else {
            C2201w.m8370a((int) C0965R.string.network_unconnected);
        }
    }

    /* renamed from: b */
    private boolean m8108b(C2105a channel) {
        return C2142b.f6818b.equals(channel.m7893a()) && TextUtils.isEmpty(C2186p.m8304a().m8309a(C1253f.ic, ""));
    }

    /* renamed from: c */
    private void m8111c(final C2105a channel) {
        if (C1251e.m4358a().m4401r()) {
            new C2139a(getContext()).m8066a(this, new C1491a(this) {
                /* renamed from: b */
                final /* synthetic */ RadioChannelFragment f6838b;

                /* renamed from: a */
                public void mo1562a() {
                    if (this.f6838b.m8108b(channel)) {
                        C2201w.m8370a((int) C0965R.string.module_music_not_yet_played);
                        return;
                    }
                    C1702j.m6181a().m6184a(Integer.valueOf(channel.m7893a()).intValue());
                    C1818h.m6730b().m6831s().m6998b(channel.m7893a(), channel.m7895b());
                }
            });
        } else {
            C2201w.m8370a((int) C0965R.string.network_unconnected);
        }
    }

    /* renamed from: d */
    private void m8116d(C2105a channelModel) {
        dismissGuideHint();
        this.f6860j.removeMessages(0);
        String hint = C2143c.m8082a(channelModel.m7895b());
        if (!TextUtils.isEmpty(hint)) {
            showGuideHint(hint);
        }
        this.f6860j.sendEmptyMessageDelayed(0, 8000);
    }

    /* renamed from: d */
    private void m8115d() {
        if (!this.f6858h.m8092a(this.f6854d.getCurrentItem()).m7893a().equals(C2142b.f6818b)) {
            int start = this.f6854d.getCurrentItem();
            int offsetRight = this.f6858h.m8090a(C2142b.f6818b) - this.f6858h.m8090a(this.f6858h.m8092a(start).m7893a());
            int offsetLeft = offsetRight - this.f6858h.m8089a();
            if (offsetRight < 0) {
                offsetLeft = offsetRight + this.f6858h.m8089a();
            }
            if (Math.abs(offsetLeft) < Math.abs(offsetRight)) {
                this.f6857g = start + offsetLeft;
            } else {
                this.f6857g = start + offsetRight;
            }
            this.f6854d.setCurrentItem(this.f6857g);
        }
    }

    /* renamed from: e */
    private void m8119e() {
        HashMap<View, Integer> childrenViews = this.f6854d.getChildrenViews();
        for (View view : childrenViews.keySet()) {
            ImageView flagImageView = (ImageView) view.findViewById(C0965R.id.radio_channel_item_flag_play);
            if (((Integer) childrenViews.get(view)).intValue() == this.f6854d.getCurrentItem()) {
                flagImageView.setVisibility(0);
                if (C1818h.m6730b().m6834v()) {
                    flagImageView.setImageResource(C0965R.drawable.anim_radio_channel_playing);
                    ((AnimationDrawable) flagImageView.getDrawable()).start();
                } else {
                    flagImageView.setImageResource(C0965R.drawable.radio_ic_play_dynamic07);
                }
            } else {
                flagImageView.setVisibility(8);
                flagImageView.setImageBitmap(null);
            }
        }
    }

    /* renamed from: a */
    public void m8124a() {
        if (C1249d.m4334m() && this.f6856f != null) {
            int nContainerWidth = this.f6856f.getWidth();
            int nContainerHeight = this.f6856f.getHeight();
            int nViewpageWidth = this.f6854d.getWidth();
            C1260i.m4435b("Framework", "before adapte: ContainerWidth: " + nContainerWidth + " # ViewpageWidth: " + nViewpageWidth + " # Height: " + nContainerHeight);
            this.f6854d.setOffscreenPageLimit(9);
            this.f6856f.setLayoutParams(new LayoutParams(nViewpageWidth * 7, nContainerHeight));
            this.f6856f.requestLayout();
            nContainerWidth = this.f6856f.getWidth();
            C1260i.m4435b("Framework", "after adapte: ContainerWidth: " + nContainerWidth + " # ViewpageWidth: " + this.f6854d.getWidth() + " # Height: " + this.f6856f.getHeight());
        }
    }
}
