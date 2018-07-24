package com.baidu.carlife.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.Time;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.carlife.R;
import com.baidu.carlife.adpter.LoadMoreBaseAdapter.C0985a;
import com.baidu.carlife.adpter.MusicListAdapter;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.music.C1790b;
import com.baidu.carlife.logic.music.C1790b.C1539c;
import com.baidu.carlife.logic.music.C1799f;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1820j;
import com.baidu.carlife.logic.music.C1820j.C1531a;
import com.baidu.carlife.logic.music.C1852t;
import com.baidu.carlife.logic.voice.C1903m;
import com.baidu.carlife.model.C1931j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p083g.C1605a;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.CommonTipView.C1526a;
import com.baidu.carlife.view.MarqueeTextView;
import com.baidu.carlife.view.MultiImageView;
import com.baidu.carlife.view.MusicCircleProgressView;
import com.baidu.carlife.view.dialog.C2268a;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayerFragment extends ContentFragment {
    /* renamed from: F */
    private static final int f4600F = 10000;
    /* renamed from: A */
    private MultiImageView f4601A;
    /* renamed from: B */
    private AnimationDrawable f4602B;
    /* renamed from: C */
    private C2268a f4603C;
    /* renamed from: D */
    private long f4604D = -1;
    /* renamed from: E */
    private long f4605E = -1;
    /* renamed from: G */
    private Timer f4606G;
    /* renamed from: H */
    private TimerTask f4607H;
    /* renamed from: I */
    private C1539c f4608I = new C15401(this);
    /* renamed from: J */
    private OnClickListener f4609J = new C15434(this);
    /* renamed from: K */
    private OnItemClickListener f4610K = new C15445(this);
    /* renamed from: L */
    private MsgBaseHandler f4611L = new C15456(this);
    /* renamed from: M */
    private C1531a f4612M = new C15467(this);
    /* renamed from: a */
    protected final String f4613a = C1818h.f5590a;
    /* renamed from: b */
    protected ImageButton f4614b;
    /* renamed from: c */
    protected MarqueeTextView f4615c;
    /* renamed from: d */
    protected MarqueeTextView f4616d;
    /* renamed from: e */
    protected MarqueeTextView f4617e;
    /* renamed from: f */
    protected View f4618f;
    /* renamed from: g */
    protected CommonTipView f4619g;
    /* renamed from: h */
    protected MusicCircleProgressView f4620h;
    /* renamed from: i */
    protected ImageButton f4621i;
    /* renamed from: j */
    protected ImageButton f4622j;
    /* renamed from: k */
    protected ImageButton f4623k;
    /* renamed from: l */
    protected ImageButton f4624l;
    /* renamed from: m */
    protected ImageButton f4625m;
    /* renamed from: n */
    protected RelativeLayout f4626n;
    /* renamed from: o */
    protected C1443g f4627o = null;
    /* renamed from: p */
    protected C1443g f4628p = null;
    /* renamed from: q */
    protected C1443g f4629q = null;
    /* renamed from: r */
    protected RelativeLayout f4630r;
    /* renamed from: s */
    protected C2268a f4631s;
    /* renamed from: t */
    protected ImageView f4632t;
    /* renamed from: u */
    protected C1790b f4633u = null;
    /* renamed from: v */
    protected C1818h f4634v = null;
    /* renamed from: w */
    protected MusicListAdapter f4635w;
    /* renamed from: x */
    protected List<MusicSongModel> f4636x;
    /* renamed from: y */
    protected MusicSongModel f4637y;
    /* renamed from: z */
    protected int f4638z = 0;

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$1 */
    class C15401 implements C1539c {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4591a;

        C15401(MusicPlayerFragment this$0) {
            this.f4591a = this$0;
        }

        /* renamed from: a */
        public void mo1585a(int status) {
            this.f4591a.m5634a(status);
        }

        /* renamed from: a */
        public void mo1584a() {
            this.f4591a.m5665l();
        }

        /* renamed from: a */
        public void mo1586a(String albumId) {
            this.f4591a.m5640a(this.f4591a.f4633u.mo1696p());
            this.f4591a.m5649d();
            this.f4591a.m5642a(this.f4591a.f4633u.m6625f(albumId), this.f4591a.f4633u.m6649s());
            if (this.f4591a.f4635w.m3201b()) {
                this.f4591a.f4635w.m3198a(this.f4591a.f4633u.mo1686i(albumId) ? 0 : 1);
            }
        }

        /* renamed from: b */
        public void mo1587b() {
            this.f4591a.m5633a();
        }

        /* renamed from: c */
        public void mo1588c() {
            this.f4591a.m5667m();
        }

        /* renamed from: d */
        public void mo1589d() {
            this.f4591a.m5671o();
        }

        /* renamed from: e */
        public void mo1590e() {
            this.f4591a.m5681v();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$2 */
    class C15412 implements C0985a {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4592a;

        C15412(MusicPlayerFragment this$0) {
            this.f4592a = this$0;
        }

        /* renamed from: a */
        public void mo1591a() {
            if (CarlifeUtil.m4358a().m4401r()) {
                int result;
                if (this.f4592a.f4633u.m6644n().equalsIgnoreCase(C1799f.f5533C)) {
                    result = this.f4592a.f4633u.mo1688k();
                } else {
                    result = this.f4592a.f4633u.mo1654a(1, this.f4592a.f4633u.m6644n());
                }
                if (this.f4592a.f4635w != null) {
                    if (result == 0) {
                        this.f4592a.f4635w.m3198a(2);
                    } else if (result == 1) {
                        this.f4592a.f4635w.m3198a(0);
                    }
                }
                this.f4592a.m5682w();
                return;
            }
            C2201w.m8373a(this.f4592a.getContext().getString(R.string.carlife_update_no_network), 0);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$3 */
    class C15423 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4593a;

        C15423(MusicPlayerFragment this$0) {
            this.f4593a = this$0;
        }

        public void onClick(View v) {
            this.f4593a.f4634v.m6822l(this.f4593a.f4634v.m6808f());
            if (this.f4593a.f4634v.m6826n() >= 0) {
                Bundle arg = new Bundle();
                arg.putBoolean(C1790b.f5467j, true);
                ContentFragment curFrag = this.f4593a.getCurrentFragment();
                if (curFrag != null) {
                    if (curFrag.getType() == NaviFragmentManager.TYPE_MUSIC_PLAYER) {
                        curFrag.getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                        curFrag.onStart();
                        return;
                    }
                    this.f4593a.showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, arg);
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$4 */
    class C15434 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4594a;

        C15434(MusicPlayerFragment this$0) {
            this.f4594a = this$0;
        }

        public void onClick(View v) {
            if (C1772k.m6480a().m6489c() != 0) {
                C2201w.m8371a((int) R.string.phone_status_busy_music, 1);
                return;
            }
            switch (v.getId()) {
                case R.id.ib_left:
                    this.f4594a.m5659i();
                    return;
                case R.id.ib_mode:
                    this.f4594a.f4634v.m6825m();
                    this.f4594a.m5651e();
                    return;
                case R.id.ib_more:
                    this.f4594a.m5655g();
                    return;
                case R.id.music_prev:
                    C1903m.m7252a().m7255b();
                    if (this.f4594a.f4634v.m6829q()) {
                        this.f4594a.m5653f();
                    }
                    this.f4594a.f4634v.m6799c(false);
                    StatisticManager.onEvent(StatisticConstants.HOME_MUSIC_STATUS_CHANGE, StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PRE);
                    return;
                case R.id.music_play:
                    C1903m.m7252a().m7255b();
                    this.f4594a.m5653f();
                    if (this.f4594a.f4637y == null || !this.f4594a.f4637y.f5919k) {
                        StatisticManager.onEvent(StatisticConstants.HOME_MUSIC_STATUS_CHANGE, StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PLAY);
                        return;
                    } else {
                        StatisticManager.onEvent(StatisticConstants.HOME_MUSIC_STATUS_CHANGE, StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PAUSE);
                        return;
                    }
                case R.id.music_next:
                    C1903m.m7252a().m7255b();
                    if (this.f4594a.f4634v.m6829q()) {
                        this.f4594a.m5653f();
                    }
                    this.f4594a.f4634v.m6799c(true);
                    StatisticManager.onEvent(StatisticConstants.HOME_MUSIC_STATUS_CHANGE, StatisticConstants.HOME_MUSIC_STATUS_CHANGE_NEXT);
                    return;
                case R.id.iv_list:
                    if (this.f4594a.f4631s != null) {
                        if (C1343b.m4932a().m4935b()) {
                            this.f4594a.m5643a(FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving());
                        }
                        this.f4594a.showDialog(this.f4594a.f4631s, C1265a.Right);
                        this.f4594a.f4631s.m8600a(this.f4594a.f4633u.m6643m());
                        return;
                    }
                    return;
                case R.id.rl_music_type:
                    this.f4594a.m5674p();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$5 */
    class C15445 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4595a;

        C15445(MusicPlayerFragment this$0) {
            this.f4595a = this$0;
        }

        public void onItemClick(AdapterView<?> adapter, View arg1, int pos, long id) {
            if (this.f4595a.f4635w == null || this.f4595a.f4635w.getItemViewType(pos) != 1) {
                if (C1772k.m6480a().m6489c() != 0) {
                    C2201w.m8371a((int) R.string.phone_status_busy_music, 1);
                    return;
                }
                MusicSongModel song = (MusicSongModel) adapter.getItemAtPosition(pos);
                MusicSongModel curSong = this.f4595a.f4634v.m6816h();
                if (curSong == null || !song.equals(curSong)) {
                    this.f4595a.f4633u.m6627f(pos);
                    if (this.f4595a.f4633u.m6654x() == 3) {
                        this.f4595a.f4633u.m6634i(2);
                    }
                    MsgHandlerCenter.m4452a(307);
                    this.f4595a.f4634v.m6785a(this.f4595a.f4633u.m6649s(), song);
                }
                this.f4595a.dismissDialog(this.f4595a.f4631s);
            } else if (this.f4595a.f4635w.m3196a() != 2) {
                this.f4595a.f4635w.m3202c();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$6 */
    class C15456 extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4596a;

        C15456(MusicPlayerFragment this$0) {
            this.f4596a = this$0;
        }

        public void careAbout() {
            addMsg(307);
            addMsg(CommonParams.dG);
            addMsg(225);
            addMsg(CommonParams.dH);
            addMsg(218);
            addMsg(CommonParams.dR);
            addMsg(CommonParams.dZ);
            addMsg(CommonParams.bU);
            addMsg(407);
            addMsg(2004);
        }

        public void handleMessage(Message msg) {
            if (this.f4596a.f4633u == null) {
                sendMessageDelayed(Message.obtain(msg), 1000);
            }
            switch (msg.what) {
                case 218:
                    if (msg.arg1 == this.f4596a.f4633u.m6649s()) {
                        this.f4596a.m5683x();
                        this.f4596a.f4632t.setVisibility(0);
                        this.f4596a.f4633u.m6602a((Pair) msg.obj);
                        return;
                    }
                    return;
                case 225:
                    if (msg.arg1 == this.f4596a.f4633u.m6649s() && this.f4596a.f4623k != null) {
                        if (this.f4596a.f4637y == null || !this.f4596a.f4637y.f5919k) {
                            this.f4596a.f4623k.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_play));
                            return;
                        } else {
                            this.f4596a.f4623k.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_pause));
                            return;
                        }
                    }
                    return;
                case CommonParams.dG /*226*/:
                    if (msg.arg1 == this.f4596a.f4633u.m6649s()) {
                        removeMessages(307);
                        this.f4596a.f4633u.m6634i(2);
                        this.f4596a.m5640a(this.f4596a.f4634v.m6816h());
                        this.f4596a.m5649d();
                        return;
                    }
                    return;
                case CommonParams.dH /*227*/:
                    if (msg.arg1 == this.f4596a.f4633u.m6649s()) {
                        this.f4596a.f4634v.m6787a(this.f4596a.f4637y);
                        this.f4596a.f4633u.m6634i(3);
                        return;
                    }
                    return;
                case CommonParams.dR /*249*/:
                    if (msg.arg1 == this.f4596a.f4633u.m6649s()) {
                        this.f4596a.m5683x();
                        this.f4596a.m5667m();
                        if (msg.arg1 >= 3 && msg.arg2 != -1) {
                            C2201w.m8373a(this.f4596a.getString(R.string.module_music_thirdparty_null_list), 1);
                        }
                        if (this.f4596a.f4636x.isEmpty()) {
                            switch (msg.arg2) {
                                case -101:
                                    this.f4596a.f4633u.m6634i(4);
                                    break;
                                case -1:
                                    this.f4596a.f4633u.m6634i(6);
                                    break;
                                case 110:
                                    this.f4596a.f4633u.m6634i(5);
                                    break;
                                default:
                                    this.f4596a.f4633u.m6634i(3);
                                    break;
                            }
                            this.f4596a.f4632t.setVisibility(4);
                            return;
                        }
                        this.f4596a.f4635w.m3198a(1);
                        return;
                    }
                    return;
                case 307:
                    if (this.f4596a.f4620h != null && msg.arg2 == this.f4596a.f4633u.m6649s()) {
                        if (msg.arg1 < 3 || msg.arg1 % 3 == 0) {
                            this.f4596a.f4620h.setProgress(msg.arg1);
                            return;
                        }
                        return;
                    }
                    return;
                case CommonParams.dZ /*310*/:
                    this.f4596a.m5663k();
                    return;
                case 407:
                    this.f4596a.m5651e();
                    return;
                case 2004:
                    if (C1868q.m7089f().m7115b()) {
                        this.f4596a.dismissDialog(this.f4596a.f4631s);
                        this.f4596a.dismissDialog(this.f4596a.f4603C);
                        break;
                    }
                    break;
                case CommonParams.bU /*16875523*/:
                    break;
                default:
                    return;
            }
            if (msg.obj == null) {
                if (this.f4596a.f4631s != null) {
                    this.f4596a.f4631s.setBtnVisibility(8);
                }
                if (this.f4596a.f4603C != null) {
                    this.f4596a.f4603C.setBtnVisibility(8);
                }
            } else if (C1342a.m4926a().m4929b()) {
                if (this.f4596a.f4631s != null) {
                    this.f4596a.f4631s.setBtnVisibility(0);
                }
                if (this.f4596a.f4603C != null) {
                    this.f4596a.f4603C.setBtnVisibility(8);
                }
            } else if (C1343b.m4932a().m4935b()) {
                this.f4596a.m5643a(FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving());
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$7 */
    class C15467 implements C1531a {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4597a;

        C15467(MusicPlayerFragment this$0) {
            this.f4597a = this$0;
        }

        /* renamed from: a */
        public void mo1582a() {
            this.f4597a.dismissDialog(this.f4597a.f4603C);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$8 */
    class C15478 implements C1526a {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4598a;

        C15478(MusicPlayerFragment this$0) {
            this.f4598a = this$0;
        }

        /* renamed from: a */
        public void mo1575a() {
            if (C1772k.m6480a().m6489c() != 0) {
                C2201w.m8371a((int) R.string.phone_status_busy_music, 1);
            } else {
                this.f4598a.m5657h();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$9 */
    class C15489 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MusicPlayerFragment f4599a;

        C15489(MusicPlayerFragment this$0) {
            this.f4599a = this$0;
        }

        public void run() {
            this.f4599a.f4623k.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_play));
            this.f4599a.f4620h.setProgress(0);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f4634v = C1818h.m6730b();
        this.f4635w = new MusicListAdapter(getContext());
        this.f4636x = new ArrayList();
        MsgHandlerCenter.m4460a(this.f4611L);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f4604D = SystemClock.elapsedRealtime();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onStart() {
        m5675q();
        super.onStart();
        LogUtil.d(C1818h.f5590a, "------onStart()------");
    }

    public void onResume() {
        if (this.f4637y != null && this.f4637y.f5920l) {
            m5665l();
        }
        MsgHandlerCenter.m4461b((int) CommonParams.gS);
        super.onResume();
        onInitFocusAreas();
        LogUtil.m4434b(C1818h.f5590a);
        this.f4605E = SystemClock.elapsedRealtime();
        LogUtil.d(C1818h.f5590a, "--QA_Test---time:" + (this.f4605E - this.f4604D) + "ms");
    }

    public void onDestroyView() {
        dismissDialog();
        m5670n();
        super.onDestroyView();
    }

    public void onDetach() {
        this.f4611L.removeMessages(307);
        MsgHandlerCenter.m4464b(this.f4611L);
        this.f4611L = null;
        super.onDetach();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtil.m4434b(C1818h.f5590a);
        if (hidden) {
            m5670n();
        } else if (this.f4637y != null && this.f4637y.f5920l) {
            m5665l();
        }
    }

    public boolean onBackPressed() {
        if (this.f4633u == null || this.f4633u.m6649s() != 0) {
            m5659i();
        } else if (mActivity != null) {
            mActivity.m3108d();
        }
        return true;
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.frag_music_player, null);
        m5677r();
        m5680u();
        return this.mContentView;
    }

    @Deprecated
    protected void onInitView() {
    }

    @Deprecated
    protected void onUpdateOrientation(int orientation) {
    }

    @Deprecated
    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
        this.f4615c.setTextColor(C2188r.m8328a((int) R.color.cl_text_a4_title));
        this.f4617e.setTextColor(C2188r.m8328a((int) R.color.cl_text_a2_content));
        this.f4616d.setTextColor(C2188r.m8328a((int) R.color.cl_text_a2_content));
        this.f4621i.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_flipchannel));
        this.f4622j.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_lastsong));
        this.f4624l.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_nextsong));
        this.f4614b.setImageDrawable(C2188r.m8331b(R.drawable.com_ic_back));
        this.f4621i.setBackground(C2188r.m8331b(R.drawable.com_bg_btn_selector));
        this.f4622j.setBackground(C2188r.m8331b(R.drawable.com_bg_btn_selector));
        this.f4624l.setBackground(C2188r.m8331b(R.drawable.com_bg_btn_selector));
        this.f4614b.setBackground(C2251b.m8527a(getContext()));
        this.f4630r.setBackground(C2188r.m8331b(R.drawable.com_bg_btn_selector));
        if (this.f4637y == null || !this.f4637y.f5919k) {
            this.f4623k.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_play));
        } else {
            this.f4623k.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_pause));
        }
        this.f4623k.setBackground(C2188r.m8331b(R.drawable.com_bg_music_play_btn_selector));
        m5651e();
        this.f4630r.setBackground(C2251b.m8527a(mActivity));
        this.f4632t.setBackground(C2251b.m8527a(mActivity));
    }

    /* renamed from: a */
    private void m5633a() {
        m5640a(this.f4633u.mo1696p());
        m5642a(this.f4633u.mo1659g(), this.f4633u.m6649s());
        if (this.f4637y == null) {
            m5644b();
        } else if (this.f4634v.m6814g(this.f4633u.m6649s()) && this.f4637y.f5918j > 0) {
            m5649d();
            this.f4634v.m6803d(true);
            this.f4634v.m6774H();
        } else if (this.f4633u.m6649s() == 0 && this.f4634v.m6814g(-1)) {
            m5649d();
        } else {
            this.f4634v.m6811f(true);
            this.f4634v.m6785a(this.f4633u.m6649s(), this.f4637y);
        }
    }

    /* renamed from: b */
    private void m5644b() {
        if (this.f4633u.m6649s() != 0) {
            if (!this.f4634v.m6829q()) {
                this.f4634v.m6811f(true);
            }
            m5681v();
            this.f4633u.m6626f();
            return;
        }
        this.f4633u.m6634i(3);
    }

    /* renamed from: a */
    private void m5634a(int status) {
        this.f4618f.setVisibility(8);
        if (this.f4633u.m6649s() == 0) {
            this.f4614b.setVisibility(4);
            this.f4621i.setVisibility(4);
            this.f4619g.m8398a((int) R.string.module_music_null_hint, (int) R.drawable.com_ic_music_empty);
            this.f4619g.m8396a();
        } else if (this.f4633u.m6649s() == 1) {
            this.f4614b.setVisibility(0);
            this.f4621i.setVisibility(4);
            this.f4619g.m8398a((int) R.string.module_music_content_no_network, (int) R.string.module_music_content_reconnect);
            this.f4619g.m8401a(true);
        } else if (this.f4633u.m6649s() >= 2) {
            this.f4614b.setVisibility(0);
            this.f4621i.setVisibility(4);
            this.f4619g.m8398a((int) R.string.module_music_content_no_network, (int) R.string.module_music_content_reconnect);
            this.f4619g.m8401a(true);
        }
        switch (status) {
            case 2:
                this.f4626n.setVisibility(0);
                this.f4619g.setVisibility(8);
                break;
            case 3:
                this.f4626n.setVisibility(8);
                this.f4619g.setVisibility(0);
                if (this.f4633u.m6649s() == 0) {
                    this.f4618f.setVisibility(0);
                    break;
                }
                break;
            case 4:
                this.f4619g.m8398a((int) R.string.module_musicqq_downlist_empty, (int) R.string.module_music_content_reconnect);
                this.f4619g.m8401a(false);
                this.f4626n.setVisibility(8);
                this.f4619g.setVisibility(0);
                if (this.f4633u.m6649s() == 0) {
                    this.f4618f.setVisibility(0);
                    break;
                }
                break;
            case 5:
                this.f4619g.m8398a((int) R.string.module_musicqq_list_empty, (int) R.string.module_music_content_reconnect);
                this.f4619g.m8401a(true);
                this.f4626n.setVisibility(8);
                this.f4619g.setVisibility(0);
                if (this.f4633u.m6649s() == 0) {
                    this.f4618f.setVisibility(0);
                    break;
                }
                break;
            case 6:
                String appName = this.f4634v.m6779a(this.f4633u.m6647q());
                this.f4619g.m8398a((int) R.string.module_music_thirdparty_downlist_empty2, (int) R.string.module_music_content_reconnect);
                this.f4619g.m8401a(true);
                this.f4626n.setVisibility(8);
                this.f4619g.setVisibility(0);
                if (this.f4633u.m6649s() == 0) {
                    this.f4618f.setVisibility(0);
                    break;
                }
                break;
        }
        onInitFocusAreas();
    }

    /* renamed from: c */
    private void m5647c() {
        if (this.f4637y != null && this.f4637y.f5915g != null) {
            C1605a.m5868a(Uri.parse(this.f4637y.f5915g), getContext());
        }
    }

    /* renamed from: d */
    private void m5649d() {
        if (this.f4637y != null && this.f4615c != null) {
            try {
                this.f4638z = Integer.parseInt(this.f4637y.f5917i) / 1000;
            } catch (NumberFormatException e) {
                this.f4638z = 1;
            }
            this.f4620h.setMax(this.f4638z);
            this.f4620h.setProgress(this.f4637y.f5918j);
            if (this.f4637y.f5919k) {
                this.f4623k.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_pause));
            } else {
                this.f4623k.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_play));
            }
            this.f4615c.setText(this.f4637y.f5910b);
            this.f4617e.setText(this.f4637y.f5911c);
            this.f4616d.setText(this.f4637y.f5914f);
            m5651e();
        }
    }

    /* renamed from: e */
    private void m5651e() {
        this.f4625m.setBackground(C2188r.m8331b(R.drawable.com_bg_btn_selector));
        switch (this.f4634v.m6820k()) {
            case 0:
                this.f4625m.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_singlecycle));
                return;
            case 1:
                this.f4625m.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_random));
                return;
            case 2:
                this.f4625m.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_cycle));
                return;
            default:
                this.f4625m.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_cycle));
                return;
        }
    }

    /* renamed from: f */
    private void m5653f() {
        if (this.f4637y != null) {
            if (this.f4637y.f5920l) {
                C2201w.m8373a("正在缓冲", 0);
            } else if (this.f4634v.m6814g(this.f4633u.m6649s())) {
                if (this.f4637y.f5919k) {
                    this.f4634v.m6811f(true);
                    return;
                }
                if (this.f4634v.m6829q()) {
                    this.f4634v.m6785a(this.f4633u.m6649s(), this.f4637y);
                }
                this.f4634v.m6803d(true);
            } else if (this.f4633u.m6649s() == 0) {
                this.f4634v.m6785a(0, this.f4637y);
            }
        }
    }

    /* renamed from: g */
    private void m5655g() {
        if (this.f4633u != null) {
            this.f4633u.mo1660h();
            m5665l();
        }
    }

    /* renamed from: h */
    private void m5657h() {
        this.f4633u.mo1655b(true);
    }

    /* renamed from: i */
    private void m5659i() {
        if (this.f4633u != null) {
            this.f4633u.m6651u();
        }
    }

    /* renamed from: j */
    private void m5661j() {
        if (this.f4634v.m6828p()) {
            this.f4632t.setVisibility(0);
            this.f4632t.setImageResource(R.anim.anim_music_playing);
            this.f4602B = (AnimationDrawable) this.f4632t.getDrawable();
            this.f4602B.start();
        } else {
            this.f4632t.setVisibility(0);
            this.f4632t.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_player_normal));
            if (this.f4602B != null) {
                this.f4602B.stop();
            }
        }
        this.f4632t.setOnClickListener(new C15423(this));
    }

    /* renamed from: a */
    private void m5642a(List<MusicSongModel> list, int musicType) {
        this.f4636x.clear();
        if (!(list == null || list.isEmpty())) {
            this.f4636x.addAll(list);
        }
        if (musicType == 1) {
            this.f4635w.m3211b(false);
        } else {
            this.f4635w.m3211b(true);
        }
        this.f4635w.m3210a(this.f4636x);
        m5671o();
    }

    /* renamed from: a */
    private void m5640a(MusicSongModel song) {
        this.f4637y = song;
    }

    /* renamed from: k */
    private void m5663k() {
        this.f4635w.notifyDataSetChanged();
        dismissDialog(this.f4631s);
    }

    /* renamed from: l */
    private void m5665l() {
        this.f4634v.m6768B();
    }

    /* renamed from: m */
    private void m5667m() {
        this.f4634v.m6767A();
    }

    /* renamed from: n */
    private void m5670n() {
        C2342g.m8864e().m8895f();
    }

    /* renamed from: o */
    private void m5671o() {
        if (this.f4633u.mo1659g() == null || this.f4633u.mo1659g().isEmpty()) {
            this.f4632t.setVisibility(4);
            if (this.f4633u.m6649s() == 0 && this.f4634v.m6826n() > 0) {
                m5661j();
                return;
            }
            return;
        }
        this.f4632t.setVisibility(0);
        this.f4632t.setOnClickListener(this.f4609J);
        this.f4632t.setImageDrawable(C2188r.m8331b(R.drawable.music_ic_playlist));
        if (this.f4602B != null) {
            this.f4602B.stop();
        }
    }

    /* renamed from: p */
    private void m5674p() {
        if (C1343b.m4932a().m4935b()) {
            m5643a(FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving());
        }
        showDialog(this.f4603C, C1265a.Right);
    }

    /* renamed from: q */
    private void m5675q() {
        this.f4633u = this.f4634v.m6830r();
        this.f4633u.m6604a(this.f4608I);
        this.f4633u.mo1689a(getArguments());
        m5678s();
    }

    /* renamed from: r */
    private void m5677r() {
        this.f4615c = (MarqueeTextView) this.mContentView.findViewById(R.id.music_name);
        this.f4617e = (MarqueeTextView) this.mContentView.findViewById(R.id.music_album);
        this.f4616d = (MarqueeTextView) this.mContentView.findViewById(R.id.music_singer);
        this.f4622j = (ImageButton) this.mContentView.findViewById(R.id.music_prev);
        this.f4623k = (ImageButton) this.mContentView.findViewById(R.id.music_play);
        this.f4624l = (ImageButton) this.mContentView.findViewById(R.id.music_next);
        this.f4625m = (ImageButton) this.mContentView.findViewById(R.id.ib_mode);
        this.f4621i = (ImageButton) this.mContentView.findViewById(R.id.ib_more);
        this.f4614b = (ImageButton) this.mContentView.findViewById(R.id.ib_left);
        this.f4620h = (MusicCircleProgressView) this.mContentView.findViewById(R.id.cp_progress);
        this.f4601A = (MultiImageView) this.mContentView.findViewById(R.id.iv_music_type);
        this.f4632t = (ImageView) this.mContentView.findViewById(R.id.iv_list);
        this.f4619g = (CommonTipView) this.mContentView.findViewById(R.id.common_tip_view);
        this.f4619g.setCommonTipCallBack(new C15478(this));
        this.f4626n = (RelativeLayout) this.mContentView.findViewById(R.id.rl_music_content);
        this.f4618f = this.mContentView.findViewById(R.id.iv_null_arrow);
        this.f4630r = (RelativeLayout) this.mContentView.findViewById(R.id.rl_music_type);
        this.f4632t.setOnClickListener(this.f4609J);
        this.f4630r.setOnClickListener(this.f4609J);
        this.f4622j.setOnClickListener(this.f4609J);
        this.f4623k.setOnClickListener(this.f4609J);
        this.f4624l.setOnClickListener(this.f4609J);
        this.f4625m.setOnClickListener(this.f4609J);
        this.f4621i.setOnClickListener(this.f4609J);
        this.f4614b.setOnClickListener(this.f4609J);
        this.f4603C = new C2268a(mActivity, R.string.module_music_select_source, this.f4634v.m6771E(), this.f4634v.m6772F());
        this.f4603C.m8605j();
    }

    /* renamed from: s */
    private void m5678s() {
        int selectedPos = this.f4634v.m6812g();
        this.f4603C.m8600a(selectedPos);
        m5645b(selectedPos);
        m5680u();
        m5679t();
        m5671o();
    }

    /* renamed from: t */
    private void m5679t() {
        this.f4631s = new C2268a(mActivity, R.string.module_music_title_gedan, this.f4635w, this.f4610K);
        this.f4631s.m8605j();
        this.f4631s.setTitle(this.f4633u.m6645o());
        int type = this.f4633u.m6649s();
        String listID = this.f4633u.m6644n();
        if (type == 1 || type >= 3 || (listID != null && listID.equalsIgnoreCase(C1799f.f5533C))) {
            this.f4635w.m3200a(true);
            m5684y();
            return;
        }
        this.f4635w.m3200a(false);
    }

    /* renamed from: b */
    private void m5645b(int pos) {
        dismissDialog(this.f4603C);
        C1931j app = this.f4634v.m6824m(pos);
        if (app != null) {
            if (app.f6068c >= 3) {
                this.f4601A.setDefaultDrawable(C2188r.m8331b(R.drawable.music_ic_default));
                this.f4601A.setImageUrl(app.j);
            } else {
                this.f4601A.setDefaultDrawableResId(app.f6067b);
                this.f4601A.setImageUrl(null);
            }
            m5641a(app.m);
        }
    }

    /* renamed from: u */
    private void m5680u() {
        ((C1820j) this.f4634v.m6772F()).m6847a(this.f4612M);
    }

    /* renamed from: v */
    private void m5681v() {
        if (this.f4620h != null) {
            this.f4620h.post(new C15489(this));
        }
    }

    /* renamed from: w */
    private void m5682w() {
        LogUtil.d(C1818h.f5590a, "startTimerForLoadmore");
        final boolean isNetEasy = this.f4633u.m6649s() == 2;
        m5683x();
        final Handler handler = new Handler();
        try {
            this.f4606G = new Timer();
            this.f4607H = new TimerTask(this) {
                /* renamed from: c */
                final /* synthetic */ MusicPlayerFragment f4590c;

                /* renamed from: com.baidu.carlife.fragment.MusicPlayerFragment$10$1 */
                class C15381 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ AnonymousClass10 f4587a;

                    C15381(AnonymousClass10 this$1) {
                        this.f4587a = this$1;
                    }

                    public void run() {
                        if (isNetEasy) {
                            StatisticManager.onEvent(StatisticConstants.MUSIC_NETEASE_0005, "在线搜索歌单获取更多超时");
                        }
                        this.f4587a.f4590c.f4635w.m3198a(1);
                        C2201w.m8371a((int) R.string.module_music_getlist_timeout_hint, 1);
                    }
                }

                public void run() {
                    if (this.f4590c.f4606G != null) {
                        this.f4590c.m5683x();
                        handler.post(new C15381(this));
                    }
                }
            };
            this.f4606G.schedule(this.f4607H, BNOffScreenParams.MIN_ENTER_INTERVAL);
        } catch (Exception e) {
            LogUtil.d(C1818h.f5590a, "startTimer get exception");
            e.printStackTrace();
        }
    }

    /* renamed from: x */
    private void m5683x() {
        if (this.f4606G != null) {
            try {
                this.f4606G.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f4606G = null;
        }
        LogUtil.d(C1818h.f5590a, "stop timer");
    }

    /* renamed from: y */
    private void m5684y() {
        this.f4635w.m3199a(new C15412(this));
        if (this.f4633u.mo1686i(this.f4633u.m6644n())) {
            this.f4635w.m3198a(0);
        } else {
            this.f4635w.m3198a(1);
        }
    }

    /* renamed from: z */
    private C1443g m5685z() {
        if (this.f4627o == null) {
            this.f4627o = new C1443g(this.mContentView, 4);
            this.f4627o.m5300d(this.f4614b).m5300d(this.f4632t).m5300d(this.f4630r).m5300d(this.f4625m).m5300d(this.f4622j).m5300d(this.f4623k).m5300d(this.f4624l);
            this.f4627o.m5297b(this.f4623k);
        } else {
            this.f4627o.m5305h();
        }
        return this.f4627o;
    }

    /* renamed from: A */
    private C1443g m5631A() {
        if (this.f4628p == null) {
            this.f4628p = new C1443g(this.mContentView, 4);
            this.f4628p.m5300d(this.f4614b).m5300d(this.f4632t).m5300d(this.f4630r).m5300d(this.f4619g.getFocusView());
            this.f4628p.m5297b(this.f4619g.getFocusView());
        } else {
            this.f4628p.m5305h();
        }
        return this.f4628p;
    }

    /* renamed from: B */
    private C1443g m5632B() {
        if (this.f4629q == null) {
            this.f4629q = new C1443g(this.mContentView, 4);
            this.f4629q.m5300d(this.f4614b).m5300d(this.f4630r);
            this.f4629q.m5297b(this.f4614b);
        } else {
            this.f4629q.m5305h();
        }
        return this.f4629q;
    }

    public boolean onVoiceCommand(String strCommand, String strIntent) {
        LogUtil.d(C1818h.f5590a, "Voice Command: " + strCommand + " # " + strIntent);
        if (C1852t.m7034a().m7037a(strIntent) == -1) {
            return false;
        }
        this.f4634v.m6772F().onItemClick(null, null, C1852t.m7034a().m7037a(strIntent), 0);
        return true;
    }

    public void onInitFocusAreas() {
        if (this.f4634v != null && this.isDisplayed && this.f4633u != null && getCurrentFragmentType() == NaviFragmentManager.TYPE_MUSIC_PLAYER && !isDialogShown()) {
            C1440d focusManager = C1440d.m5251a();
            focusManager.m5267g();
            switch (this.f4633u.m6654x()) {
                case 2:
                    LogUtil.d(C1818h.f5590a, "onInitFocusAreas normal");
                    focusManager.m5256b(m5685z());
                    focusManager.m5268h(m5685z());
                    return;
                case 3:
                case 5:
                case 6:
                    LogUtil.d(C1818h.f5590a, "onInitFocusAreas nullfail");
                    focusManager.m5256b(m5631A());
                    focusManager.m5268h(m5631A());
                    return;
                case 4:
                    LogUtil.d(C1818h.f5590a, "onInitFocusAreas notbuttonfail");
                    focusManager.m5256b(m5632B());
                    focusManager.m5268h(m5632B());
                    return;
                default:
                    LogUtil.d(C1818h.f5590a, "onInitFocusAreas default");
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m5641a(String appPackageName) {
        long lastTimeLong = C2186p.m8304a().m8308a("DAU" + appPackageName, 0);
        if (lastTimeLong == 0) {
            StatisticManager.onEvent(StatisticConstants.HOME_MUSIC_DAU, appPackageName);
            C2186p.m8304a().m8318b("DAU" + appPackageName, System.currentTimeMillis());
            return;
        }
        Time lastTime = new Time();
        lastTime.set(lastTimeLong);
        Time nowTime = new Time();
        nowTime.setToNow();
        if (nowTime.year < lastTime.year) {
            return;
        }
        if (nowTime.year > lastTime.year || nowTime.yearDay > lastTime.yearDay) {
            StatisticManager.onEvent(StatisticConstants.HOME_MUSIC_DAU, appPackageName);
            C2186p.m8304a().m8318b("DAU" + appPackageName, System.currentTimeMillis());
        }
    }

    public void driving() {
        if (C1343b.m4932a().m4935b()) {
            m5643a(true);
        }
    }

    public void stopDriving() {
        if (C1343b.m4932a().m4935b()) {
            m5643a(false);
        }
    }

    /* renamed from: a */
    private void m5643a(boolean isShow) {
        if (isShow) {
            if (this.f4631s != null) {
                this.f4631s.setBtnVisibility(0);
            }
            if (this.f4603C != null) {
                this.f4603C.setBtnVisibility(0);
                return;
            }
            return;
        }
        if (this.f4631s != null) {
            this.f4631s.setBtnVisibility(8);
        }
        if (this.f4603C != null) {
            this.f4603C.setBtnVisibility(8);
        }
    }
}
