package com.baidu.carlife.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.adpter.C0989i;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.logic.music.C1790b;
import com.baidu.carlife.logic.music.C1790b.C1529a;
import com.baidu.carlife.logic.music.C1790b.C1535b;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1820j;
import com.baidu.carlife.logic.music.C1820j.C1531a;
import com.baidu.carlife.logic.music.C1838q;
import com.baidu.carlife.logic.music.C1852t;
import com.baidu.carlife.logic.music.p097b.C1789a;
import com.baidu.carlife.logic.music.views.ViewContainer;
import com.baidu.carlife.model.C1931j;
import com.baidu.carlife.p059c.C1102b.C1096a;
import com.baidu.carlife.p078f.C1437b;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.CommonTipView.C1526a;
import com.baidu.carlife.view.MultiImageView;
import com.baidu.carlife.view.dialog.C2282f;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

public class MusicAlbumListFragment extends ContentFragment implements OnClickListener, OnItemClickListener {
    /* renamed from: f */
    private static final String f4556f = "CarLifeMusic";
    /* renamed from: A */
    private View f4557A;
    /* renamed from: B */
    private C1789a f4558B;
    /* renamed from: C */
    private C1529a f4559C = new C15302(this);
    /* renamed from: D */
    private C1531a f4560D = new C15323(this);
    /* renamed from: E */
    private C0936j f4561E = new C15376(this);
    /* renamed from: a */
    protected C1437b f4562a;
    /* renamed from: b */
    protected C1443g f4563b = null;
    /* renamed from: c */
    protected C1443g f4564c = null;
    /* renamed from: d */
    protected C1443g f4565d;
    /* renamed from: e */
    Runnable f4566e = new C15334(this);
    /* renamed from: g */
    private C1818h f4567g;
    /* renamed from: h */
    private C1790b f4568h;
    /* renamed from: i */
    private C0989i f4569i;
    /* renamed from: j */
    private boolean f4570j;
    /* renamed from: k */
    private View f4571k;
    /* renamed from: l */
    private View f4572l;
    /* renamed from: m */
    private View f4573m;
    /* renamed from: n */
    private View f4574n;
    /* renamed from: o */
    private View f4575o;
    /* renamed from: p */
    private GridView f4576p;
    /* renamed from: q */
    private TextView f4577q;
    /* renamed from: r */
    private TextView f4578r;
    /* renamed from: s */
    private TextView f4579s;
    /* renamed from: t */
    private RelativeLayout f4580t;
    /* renamed from: u */
    private MultiImageView f4581u;
    /* renamed from: v */
    private ImageView f4582v;
    /* renamed from: w */
    private C2282f f4583w;
    /* renamed from: x */
    private AnimationDrawable f4584x;
    /* renamed from: y */
    private CommonTipView f4585y;
    /* renamed from: z */
    private ViewContainer f4586z;

    /* renamed from: com.baidu.carlife.fragment.MusicAlbumListFragment$1 */
    class C15271 implements C1526a {
        /* renamed from: a */
        final /* synthetic */ MusicAlbumListFragment f4546a;

        C15271(MusicAlbumListFragment this$0) {
            this.f4546a = this$0;
        }

        /* renamed from: a */
        public void mo1575a() {
            if (C1772k.m6480a().m6489c() != 0) {
                C2201w.m8371a((int) C0965R.string.phone_status_busy_music, 1);
            } else {
                this.f4546a.f4568h.mo1655b(true);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicAlbumListFragment$2 */
    class C15302 implements C1529a {
        /* renamed from: a */
        final /* synthetic */ MusicAlbumListFragment f4548a;

        /* renamed from: com.baidu.carlife.fragment.MusicAlbumListFragment$2$1 */
        class C15281 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C15302 f4547a;

            C15281(C15302 this$1) {
                this.f4547a = this$1;
            }

            public void run() {
                this.f4547a.f4548a.m5589c();
            }
        }

        C15302(MusicAlbumListFragment this$0) {
            this.f4548a = this$0;
        }

        /* renamed from: a */
        public void mo1576a() {
            this.f4548a.m5596e();
        }

        /* renamed from: b */
        public void mo1579b() {
            this.f4548a.m5598f();
        }

        /* renamed from: a */
        public void mo1577a(int type) {
            this.f4548a.m5585b(type);
        }

        /* renamed from: b */
        public void mo1580b(int status) {
            this.f4548a.m5597e(status);
        }

        /* renamed from: a */
        public void mo1578a(String packageName) {
            String appName = this.f4548a.f4567g.m6779a(packageName);
            if (!TextUtils.isEmpty(appName)) {
                C2201w.m8373a(appName + "断开连接了", 0);
            }
            mo1579b();
            C1790b dataManager = this.f4548a.f4567g.m6792b(packageName);
            if (dataManager != null && this.f4548a.f4567g.m6814g(dataManager.m6649s())) {
                this.f4548a.f4567g.m6811f(true);
                C1261k.m4452a((int) C1253f.dZ);
                this.f4548a.f4567g.m6809f(-1);
                if (dataManager.m6649s() == 1) {
                    mo1581c();
                }
            }
        }

        /* renamed from: c */
        public void mo1581c() {
            if (this.f4548a.f4561E != null) {
                this.f4548a.f4561E.post(new C15281(this));
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicAlbumListFragment$3 */
    class C15323 implements C1531a {
        /* renamed from: a */
        final /* synthetic */ MusicAlbumListFragment f4549a;

        C15323(MusicAlbumListFragment this$0) {
            this.f4549a = this$0;
        }

        /* renamed from: a */
        public void mo1582a() {
            this.f4549a.dismissDialog(this.f4549a.f4583w);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicAlbumListFragment$4 */
    class C15334 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MusicAlbumListFragment f4550a;

        C15334(MusicAlbumListFragment this$0) {
            this.f4550a = this$0;
        }

        public void run() {
            this.f4550a.m5606j();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicAlbumListFragment$5 */
    class C15365 implements C1535b {
        /* renamed from: a */
        final /* synthetic */ MusicAlbumListFragment f4554a;

        C15365(MusicAlbumListFragment this$0) {
            this.f4554a = this$0;
        }

        /* renamed from: a */
        public void mo1583a(final String albumId, final int size) {
            if (this.f4554a.f4558B != null) {
                ((C1838q) this.f4554a.f4568h).f5706Z.put(albumId, Integer.valueOf(size));
                BaseFragment.getNaviActivity().runOnUiThread(new Runnable(this) {
                    /* renamed from: c */
                    final /* synthetic */ C15365 f4553c;

                    public void run() {
                        this.f4553c.f4554a.f4558B.m6589a(albumId, size);
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.MusicAlbumListFragment$6 */
    class C15376 extends C0936j {
        /* renamed from: a */
        final /* synthetic */ MusicAlbumListFragment f4555a;

        C15376(MusicAlbumListFragment this$0) {
            this.f4555a = this$0;
        }

        public void careAbout() {
            addMsg(206);
            addMsg(C1253f.dQ);
            addMsg(C1253f.fm);
            addMsg(1002);
            addMsg(C1253f.gj);
        }

        public void handleMessage(Message msg) {
            C1790b dataManager;
            switch (msg.what) {
                case 206:
                    dataManager = this.f4555a.f4567g.m6815h(msg.arg2);
                    if (dataManager == null || !dataManager.m6635i()) {
                        dataManager.m6638j(2);
                        this.f4555a.m5598f();
                        if (this.f4555a.f4567g.m6812g() == msg.arg2) {
                            this.f4555a.m5585b(msg.arg1);
                            return;
                        }
                        return;
                    }
                    dataManager.m6609a(false);
                    C1260i.m4445e("CarLifeMusic", "MSG_MUSIC_UPDATE_ALBUMLIST-1-");
                    return;
                case C1253f.dQ /*248*/:
                    dataManager = this.f4555a.f4567g.m6815h(msg.arg1);
                    if (dataManager != null) {
                        dataManager.m6609a(true);
                        dataManager.m6638j(3);
                        if (msg.arg2 == -2) {
                            switch (msg.arg1) {
                                case 1:
                                    StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0014, "同步超时");
                                    break;
                                case 3:
                                    StatisticManager.onEvent(StatisticConstants.MUSIC_XMLY_0010, "同步超时");
                                    break;
                                case 4:
                                    StatisticManager.onEvent(StatisticConstants.MUSIC_KAOLA_0010, "同步超时");
                                    break;
                                case 5:
                                    StatisticManager.onEvent(StatisticConstants.MUSIC_CYB_0010, "同步超时");
                                    break;
                            }
                            msg.arg2 = -1;
                        }
                    }
                    if (this.f4555a.f4567g.m6812g() == msg.arg1) {
                        this.f4555a.m5598f();
                        return;
                    }
                    return;
                case 1002:
                    this.f4555a.m5588b(false);
                    return;
                case C1253f.fm /*1040*/:
                    this.f4555a.m5588b(true);
                    return;
                case C1253f.gj /*3013*/:
                    this.f4555a.m5606j();
                    return;
                default:
                    return;
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f4567g = C1818h.m6730b();
        C1261k.m4460a(this.f4561E);
        this.f4569i = new C0989i();
    }

    public void onStart() {
        super.onStart();
        C1260i.m4435b("CarLifeMusic", "-----MusicAlbumListFragment--onStart()---");
        m5601g();
    }

    public void onClick(View v) {
        if (this.f4568h == null) {
            m5601g();
            return;
        }
        switch (v.getId()) {
            case C0965R.id.ll_title_toplist:
                if (this.f4568h.m6653w() != 1) {
                    this.f4576p.setVisibility(4);
                    m5590c(1);
                    this.f4568h.m6641k(1);
                    return;
                }
                return;
            case C0965R.id.ll_title_playlist:
                if (this.f4568h.m6653w() != 2) {
                    this.f4576p.setVisibility(4);
                    m5590c(2);
                    this.f4568h.m6641k(2);
                    return;
                }
                return;
            case C0965R.id.iv_list:
                this.f4567g.m6822l(this.f4567g.m6808f());
                if (this.f4567g.m6826n() >= 0) {
                    Bundle arg = new Bundle();
                    arg.putBoolean(C1790b.f5467j, true);
                    ContentFragment curFrag = getCurrentFragment();
                    if (curFrag == null) {
                        return;
                    }
                    if (curFrag.getType() == NaviFragmentManager.TYPE_MUSIC_PLAYER) {
                        curFrag.getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                        curFrag.onStart();
                        return;
                    }
                    showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, arg);
                    return;
                }
                return;
            case C0965R.id.rl_music_type:
                showDialog(this.f4583w, C1265a.Right);
                return;
            default:
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        this.f4568h.m6633h(position);
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(C0965R.layout.frag_music_albumlist, null);
        m5578a();
        m5593d();
        return this.mContentView;
    }

    public void onResume() {
        super.onResume();
        C1260i.m4434b("CarLifeMusic");
        if (this.f4570j) {
            C2342g.m8864e().m8886a((int) C0965R.string.progress_loading);
        }
    }

    public boolean onBackPressed() {
        if (mActivity != null) {
            mActivity.m3108d();
        }
        return true;
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        C1260i.m4434b("CarLifeMusic");
        if (hidden) {
            C2342g.m8864e().m8895f();
        } else if (this.f4570j) {
            C2342g.m8864e().m8886a((int) C0965R.string.progress_loading);
        }
    }

    public void onPause() {
        super.onPause();
        C2342g.m8864e().m8895f();
    }

    public void onDestroyView() {
        dismissDialog(this.f4583w);
        super.onDestroyView();
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
        this.f4580t.setBackground(C2251b.m8527a(mActivity));
        this.f4582v.setBackground(C2251b.m8527a(mActivity));
    }

    /* renamed from: a */
    private void m5578a() {
        this.f4586z = (ViewContainer) this.mContentView.findViewById(C0965R.id.container);
        this.f4571k = this.mContentView.findViewById(C0965R.id.ll_title_playlist);
        this.f4572l = this.mContentView.findViewById(C0965R.id.ll_title_toplist);
        this.f4573m = this.mContentView.findViewById(C0965R.id.hint_selected_playlist);
        this.f4574n = this.mContentView.findViewById(C0965R.id.hint_selected_toplist);
        this.f4575o = this.mContentView.findViewById(C0965R.id.ll_title_alllist);
        this.f4571k.setOnClickListener(this);
        this.f4572l.setOnClickListener(this);
        this.f4580t = (RelativeLayout) this.mContentView.findViewById(C0965R.id.rl_music_type);
        this.f4581u = (MultiImageView) this.mContentView.findViewById(C0965R.id.iv_music_type);
        this.f4582v = (ImageView) this.mContentView.findViewById(C0965R.id.iv_list);
        this.f4582v.setImageResource(C0965R.anim.anim_music_playing);
        this.f4584x = (AnimationDrawable) this.f4582v.getDrawable();
        this.f4580t.setOnClickListener(this);
        this.f4582v.setOnClickListener(this);
        this.f4577q = (TextView) this.mContentView.findViewById(C0965R.id.tv_title_mysongs);
        this.f4578r = (TextView) this.mContentView.findViewById(C0965R.id.tv_title_playlist);
        this.f4579s = (TextView) this.mContentView.findViewById(C0965R.id.tv_title_toplist);
        this.f4576p = (GridView) this.mContentView.findViewById(C0965R.id.gv_playlist);
        this.f4576p.setAdapter(this.f4569i);
        this.f4576p.setOnItemClickListener(this);
        this.f4583w = new C2282f(mActivity, C0965R.string.module_music_select_source, this.f4567g.m6771E(), this.f4567g.m6772F());
        this.f4583w.m8636j();
        this.f4585y = (CommonTipView) this.mContentView.findViewById(C0965R.id.common_tip_view);
        this.f4585y.setCommonTipCallBack(new C15271(this));
        if (C1343b.m4932a().m4935b()) {
            m5583a(!C1328h.m4757a().getNaviFragmentManager().isDriving());
        }
        m5588b(C1663a.m5979a().m5993N());
    }

    /* renamed from: b */
    private void m5584b() {
        int selectedPos = this.f4567g.m6812g();
        this.f4583w.m8630a(selectedPos);
        m5579a(selectedPos);
        m5593d();
        m5589c();
    }

    /* renamed from: a */
    private void m5579a(int pos) {
        dismissDialog(this.f4583w);
        C1931j app = this.f4567g.m6824m(pos);
        if (app != null) {
            if (app.f6068c >= 3) {
                this.f4581u.setDefaultDrawable(C2188r.m8331b(C0965R.drawable.music_ic_default));
                this.f4581u.setImageUrl(app.j);
            } else {
                this.f4581u.setDefaultDrawableResId(app.f6067b);
                this.f4581u.setImageUrl(null);
            }
            m5582a(app.m);
        }
    }

    /* renamed from: c */
    private void m5589c() {
        if (this.f4567g.m6826n() == -1) {
            this.f4582v.setVisibility(4);
        } else if (this.f4567g.m6828p()) {
            this.f4582v.setVisibility(0);
            this.f4582v.setImageResource(C0965R.anim.anim_music_playing);
            this.f4584x = (AnimationDrawable) this.f4582v.getDrawable();
            this.f4584x.start();
        } else {
            this.f4582v.setVisibility(0);
            this.f4582v.setImageDrawable(C2188r.m8331b(C0965R.drawable.music_ic_player_normal));
            if (this.f4584x != null) {
                this.f4584x.stop();
            }
        }
    }

    /* renamed from: d */
    private void m5593d() {
        ((C1820j) this.f4567g.m6772F()).m6847a(this.f4560D);
    }

    /* renamed from: e */
    private void m5596e() {
        this.f4570j = true;
        C2342g.m8864e().m8886a((int) C0965R.string.progress_loading);
        if (this.f4561E != null) {
            this.f4561E.sendMessageDelayed(Message.obtain(this.f4561E, C1253f.dQ, this.f4568h.m6649s(), -2), 15000);
        }
    }

    /* renamed from: f */
    private void m5598f() {
        this.f4570j = false;
        if (this.f4561E != null) {
            this.f4561E.removeMessages(C1253f.dQ);
        }
        C2342g.m8864e().m8895f();
    }

    /* renamed from: g */
    private void m5601g() {
        this.f4568h = this.f4567g.m6830r();
        this.f4568h.m6603a(this.f4559C);
        m5584b();
        this.f4568h.m6612b(getArguments());
        if (this.f4568h.m6649s() == 2) {
            this.f4575o.setVisibility(0);
            this.f4577q.setVisibility(8);
            return;
        }
        this.f4575o.setVisibility(8);
        this.f4577q.setVisibility(0);
    }

    /* renamed from: b */
    private void m5585b(int albumType) {
        this.f4569i.m3208a(this.f4568h.m6629g(albumType));
        m5590c(albumType);
        this.f4576p.smoothScrollToPosition(0);
        this.f4568h.m6638j(2);
    }

    /* renamed from: c */
    private void m5590c(int status) {
        if (status == 2) {
            this.f4573m.setVisibility(0);
            this.f4574n.setVisibility(4);
            this.f4579s.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a2_title));
            this.f4578r.setTextColor(C2188r.m8328a((int) C0965R.color.white));
            this.f4571k.setBackgroundResource(C0965R.drawable.com_music_title_bg_selector);
            this.f4572l.setBackground(C2251b.m8530d(mActivity));
        } else if (status == 1) {
            this.f4573m.setVisibility(4);
            this.f4574n.setVisibility(0);
            this.f4579s.setTextColor(C2188r.m8328a((int) C0965R.color.white));
            this.f4578r.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a2_title));
            this.f4571k.setBackground(C2251b.m8530d(mActivity));
            this.f4572l.setBackgroundResource(C0965R.drawable.com_music_title_bg_selector);
        }
    }

    /* renamed from: d */
    private void m5594d(int status) {
        switch (status) {
            case 0:
            case 1:
                this.f4577q.setVisibility(8);
                this.f4572l.setVisibility(4);
                this.f4571k.setVisibility(4);
                this.mContentView.findViewById(C0965R.id.line_divider).setVisibility(4);
                break;
            default:
                if (this.f4568h.m6649s() != 1) {
                    if (this.f4568h.m6649s() != 2) {
                        this.f4577q.setText(C0965R.string.module_music_title_bangdan_thirdparty);
                        this.f4577q.setVisibility(0);
                        break;
                    }
                    this.f4572l.setVisibility(0);
                    this.f4571k.setVisibility(0);
                    this.mContentView.findViewById(C0965R.id.line_divider).setVisibility(0);
                    break;
                }
                this.f4577q.setText(C0965R.string.module_music_title_wodeyinyue);
                this.f4577q.setVisibility(0);
                break;
        }
        m5590c(this.f4568h.m6653w());
    }

    /* renamed from: e */
    private void m5597e(int status) {
        m5594d(status);
        this.f4586z.setVisibility(8);
        String temp;
        switch (status) {
            case 0:
                this.f4576p.setVisibility(4);
                if (TextUtils.isEmpty(this.f4567g.m6779a(this.f4568h.m6647q()))) {
                    temp = String.format(getContext().getString(C0965R.string.module_music_thirdparty_not_exist), new Object[]{"第三方"});
                } else {
                    temp = String.format(getContext().getString(C0965R.string.module_music_thirdparty_not_exist), new Object[]{appName});
                }
                this.f4585y.setVisibility(0);
                this.f4585y.m8400a(temp, (int) C0965R.string.module_music_thirdparty_download);
                if (!C1253f.jc.equals(C1253f.jt)) {
                    this.f4585y.m8401a(true);
                    break;
                } else {
                    this.f4585y.m8396a();
                    break;
                }
            case 1:
                this.f4576p.setVisibility(4);
                if (this.f4568h.m6649s() == 1) {
                    temp = getString(C0965R.string.module_musicqq_not_link);
                } else {
                    if (TextUtils.isEmpty(this.f4567g.m6779a(this.f4568h.m6647q()))) {
                        temp = String.format(getString(C0965R.string.module_music_thirdparty_not_link), new Object[]{"第三方"});
                    } else {
                        temp = String.format(getString(C0965R.string.module_music_thirdparty_not_link), new Object[]{appName});
                    }
                }
                this.f4585y.setVisibility(0);
                this.f4585y.m8400a(temp, (int) C0965R.string.module_music_thirdparty_sync);
                this.f4585y.m8401a(true);
                break;
            case 2:
                if (this.f4568h.m6649s() != 1) {
                    this.f4576p.setVisibility(0);
                    this.f4586z.setVisibility(8);
                    this.f4585y.setVisibility(8);
                    break;
                }
                m5602h();
                break;
            case 3:
                this.f4576p.setVisibility(4);
                this.f4585y.setVisibility(0);
                this.f4585y.m8398a((int) C0965R.string.module_music_content_null_hint, (int) C0965R.string.module_music_content_reconnect);
                this.f4585y.m8401a(true);
                break;
            case 7:
                this.f4576p.setVisibility(4);
                if (this.f4568h.m6649s() == 1) {
                    temp = getString(C0965R.string.module_musicqq_intercepte);
                } else {
                    if (TextUtils.isEmpty(this.f4567g.m6779a(this.f4568h.m6647q()))) {
                        temp = String.format(getString(C0965R.string.module_music_thirdparty_not_link), new Object[]{"第三方"});
                    } else {
                        temp = String.format(getString(C0965R.string.module_music_thirdparty_not_link), new Object[]{appName});
                    }
                }
                this.f4585y.setVisibility(0);
                this.f4585y.m8400a(temp, (int) C0965R.string.module_music_thirdparty_sync);
                this.f4585y.m8401a(true);
                break;
        }
        onInitFocusAreas();
    }

    /* renamed from: h */
    private void m5602h() {
        m5608l();
        m5605i();
    }

    /* renamed from: i */
    private void m5605i() {
        this.f4558B = new C1789a(this.f4568h);
        this.f4558B.mo1426a(m5607k());
        this.f4586z.m7041a(this.f4558B);
        this.f4586z.m7039a();
        this.f4558B.m6588a(this.f4566e, 1500);
    }

    /* renamed from: j */
    private void m5606j() {
        if (this.f4568h.m6649s() == 1 && this.f4558B != null) {
            ((C1838q) this.f4568h).m6964a(new C15365(this));
        }
    }

    @NonNull
    /* renamed from: k */
    private C1096a m5607k() {
        this.f4557A = getActivity().getLayoutInflater().inflate(C0965R.layout.item_four_card, this.f4586z, false);
        return new C1096a(this.f4557A, 0);
    }

    /* renamed from: l */
    private void m5608l() {
        this.f4585y.setVisibility(8);
        this.f4576p.setVisibility(8);
        this.f4586z.setVisibility(0);
    }

    public boolean onVoiceCommand(String strCommand, String strIntent) {
        C1260i.m4435b("CarLifeMusic", "Voice Command: [" + strCommand + "][" + strIntent + "]");
        if (strIntent.equals("download") || strIntent.equals("sync")) {
            m5609m();
            return true;
        }
        int nIndex = C1852t.m7034a().m7037a(strIntent);
        if (nIndex == -1) {
            return false;
        }
        this.f4567g.m6772F().onItemClick(null, null, nIndex, 0);
        return true;
    }

    /* renamed from: m */
    private void m5609m() {
        if (this.f4568h.m6654x() == 3 || this.f4568h.m6654x() == 0 || this.f4568h.m6654x() == 1) {
            this.f4585y.m8402b();
        }
    }

    /* renamed from: n */
    private C1443g m5610n() {
        if (this.f4563b == null) {
            this.f4563b = new C1443g(this.mContentView, 4);
        }
        this.f4563b.m5306i();
        this.f4563b.m5300d(this.f4572l).m5300d(this.f4571k).m5300d(this.f4582v).m5300d(this.f4580t).m5300d(this.f4585y.getFocusView());
        this.f4563b.m5297b(this.f4585y.getFocusView());
        return this.f4563b;
    }

    /* renamed from: o */
    private C1437b m5611o() {
        if (this.f4562a == null) {
            this.f4562a = new C1437b(this.f4576p, 6);
        }
        return this.f4562a;
    }

    /* renamed from: p */
    private C1443g m5612p() {
        if (this.f4564c == null) {
            this.f4564c = new C1443g(this.mContentView, 4);
        }
        this.f4564c.m5306i();
        this.f4564c.m5300d(this.f4582v).m5300d(this.f4580t).m5300d(this.f4585y.getFocusView());
        this.f4564c.m5297b(this.f4585y.getFocusView());
        return this.f4564c;
    }

    public void onInitFocusAreas() {
        if (this.f4567g != null && this.f4568h != null && getCurrentFragmentType() == NaviFragmentManager.TYPE_MUSIC_ALBUMLIST && !isDialogShown()) {
            C1440d focusManager = C1440d.m5251a();
            focusManager.m5267g();
            switch (this.f4568h.m6654x()) {
                case 0:
                case 1:
                    focusManager.m5256b(m5612p());
                    focusManager.m5268h(m5612p());
                    C1260i.m4445e("musicalbum", "DISPLAY_STATUS_UNDOWNLOADED");
                    return;
                case 2:
                    if (this.f4568h.m6649s() != 1) {
                        focusManager.m5256b(m5610n(), m5611o());
                        focusManager.m5268h(m5611o());
                        C1260i.m4445e("musicalbum", "DISPLAY_STATUS_NORMAL");
                        return;
                    } else if (this.f4557A != null) {
                        focusManager.m5256b(m5610n(), m5613q());
                        focusManager.m5268h(this.f4565d);
                        return;
                    } else {
                        return;
                    }
                case 3:
                    focusManager.m5256b(m5610n());
                    focusManager.m5268h(m5610n());
                    C1260i.m4445e("musicalbum", "DISPLAY_STATUS_LOAD_FAIL");
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: q */
    private C1443g m5613q() {
        if (this.f4557A == null) {
            return null;
        }
        if (this.f4565d == null) {
            this.f4565d = new C1443g(this.f4557A, 6);
        }
        this.f4565d.m5306i();
        this.f4565d.m5300d(this.f4557A.findViewById(C0965R.id.card_1)).m5300d(this.f4557A.findViewById(C0965R.id.card_2)).m5300d(this.f4557A.findViewById(C0965R.id.card_3)).m5300d(this.f4557A.findViewById(C0965R.id.card_4));
        return this.f4565d;
    }

    /* renamed from: a */
    private void m5582a(String appPackageName) {
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
        C1260i.m4435b("yftech", "MusicAlbumListFragment driving");
        if (C1343b.m4932a().m4935b()) {
            m5583a(false);
        }
    }

    public void stopDriving() {
        C1260i.m4435b("yftech", "MusicAlbumListFragment stopDriving");
        if (C1343b.m4932a().m4935b()) {
            m5583a(true);
        }
    }

    /* renamed from: a */
    private void m5583a(boolean enable) {
        this.f4585y.getFocusView().setAlpha(enable ? 1.0f : 0.2f);
        this.f4585y.getFocusView().setEnabled(enable);
    }

    /* renamed from: b */
    private void m5588b(boolean bConnected) {
        if (bConnected && C1249d.m4334m()) {
            this.f4576p.setNumColumns(6);
            this.f4576p.requestLayout();
            this.mContentView.requestLayout();
            C1260i.m4435b("CarLifeMusic", "Update Gv Columns:6");
            return;
        }
        this.f4576p.setNumColumns(4);
        this.f4576p.requestLayout();
        this.mContentView.requestLayout();
        C1260i.m4435b("CarLifeMusic", "Update Gv Columns:4");
    }
}
