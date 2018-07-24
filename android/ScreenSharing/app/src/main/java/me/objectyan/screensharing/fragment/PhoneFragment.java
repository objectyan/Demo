package com.baidu.carlife.fragment;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.adpter.CallLogListAdapter;
import com.baidu.carlife.adpter.PhoneContactsListAdapter;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.core.screen.presentation.view.CarlifeProgressDialogContainer;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.C1868q.C1060g;
import com.baidu.carlife.logic.C1868q.C1561a;
import com.baidu.carlife.logic.C1868q.C1564b;
import com.baidu.carlife.logic.C1868q.C1565d;
import com.baidu.carlife.model.C1935m;
import com.baidu.carlife.model.C1936n;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.CommonTipView.C1526a;
import com.baidu.carlife.view.dialog.C2325s;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.che.codriver.util.C2736p;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.List;

public class PhoneFragment extends ContentFragment implements OnClickListener, OnTouchListener, C1564b, C1565d, C1060g {
    /* renamed from: a */
    public static final String f4685a = PhoneFragment.class.getSimpleName();
    /* renamed from: A */
    private CommonTipView f4686A;
    /* renamed from: B */
    private View f4687B;
    /* renamed from: C */
    private View f4688C;
    /* renamed from: D */
    private View f4689D;
    /* renamed from: E */
    private View f4690E;
    /* renamed from: F */
    private ListView f4691F;
    /* renamed from: G */
    private ListView f4692G;
    /* renamed from: H */
    private CallLogListAdapter f4693H;
    /* renamed from: I */
    private PhoneContactsListAdapter f4694I;
    /* renamed from: J */
    private PopupWindow f4695J;
    /* renamed from: K */
    private TextView f4696K;
    /* renamed from: L */
    private ImageButton f4697L;
    /* renamed from: M */
    private C2325s f4698M;
    /* renamed from: N */
    private C2325s f4699N;
    /* renamed from: O */
    private boolean f4700O;
    /* renamed from: P */
    private boolean f4701P;
    /* renamed from: Q */
    private int f4702Q;
    /* renamed from: R */
    private C1868q f4703R;
    /* renamed from: S */
    private boolean f4704S;
    /* renamed from: T */
    private C1440d f4705T;
    /* renamed from: U */
    private C1443g f4706U;
    /* renamed from: V */
    private C1563a f4707V;
    /* renamed from: W */
    private String f4708W = "";
    /* renamed from: X */
    private C1526a f4709X = new C15561(this);
    /* renamed from: Y */
    private C1526a f4710Y = new C15572(this);
    /* renamed from: Z */
    private OnItemClickListener f4711Z = new C15583(this);
    private OnScrollListener aa = new C15594(this);
    private OnScrollListener ab = new C15605(this);
    private C1561a ac = new C15626(this);
    /* renamed from: b */
    private List<C1936n> f4712b;
    /* renamed from: c */
    private List<C1935m> f4713c;
    /* renamed from: d */
    private CommonTipView f4714d;
    /* renamed from: e */
    private RelativeLayout f4715e;
    /* renamed from: f */
    private RelativeLayout f4716f;
    /* renamed from: g */
    private View f4717g;
    /* renamed from: h */
    private View f4718h;
    /* renamed from: i */
    private View f4719i;
    /* renamed from: j */
    private View f4720j;
    /* renamed from: k */
    private View f4721k;
    /* renamed from: l */
    private View f4722l;
    /* renamed from: m */
    private ImageButton f4723m;
    /* renamed from: n */
    private ImageButton f4724n;
    /* renamed from: o */
    private ViewGroup f4725o;
    /* renamed from: p */
    private View f4726p;
    /* renamed from: q */
    private AbsListView f4727q;
    /* renamed from: r */
    private int f4728r = 0;
    /* renamed from: s */
    private int f4729s = 0;
    /* renamed from: t */
    private int f4730t = 0;
    /* renamed from: u */
    private int f4731u = 0;
    /* renamed from: v */
    private int f4732v = 0;
    /* renamed from: w */
    private int f4733w = 0;
    /* renamed from: x */
    private boolean f4734x = true;
    /* renamed from: y */
    private boolean f4735y = true;
    /* renamed from: z */
    private View f4736z;

    /* renamed from: com.baidu.carlife.fragment.PhoneFragment$1 */
    class C15561 implements C1526a {
        /* renamed from: a */
        final /* synthetic */ PhoneFragment f4678a;

        C15561(PhoneFragment this$0) {
            this.f4678a = this$0;
        }

        /* renamed from: a */
        public void mo1575a() {
            CarlifeProgressDialogContainer.m4686a().mo1467b(this.f4678a.getString(R.string.progress_loading));
            this.f4678a.f4703R.m7123i();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.PhoneFragment$2 */
    class C15572 implements C1526a {
        /* renamed from: a */
        final /* synthetic */ PhoneFragment f4679a;

        C15572(PhoneFragment this$0) {
            this.f4679a = this$0;
        }

        /* renamed from: a */
        public void mo1575a() {
            CarlifeProgressDialogContainer.m4686a().mo1467b(this.f4679a.getString(R.string.progress_loading));
            this.f4679a.f4703R.m7122h();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.PhoneFragment$3 */
    class C15583 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ PhoneFragment f4680a;

        C15583(PhoneFragment this$0) {
            this.f4680a = this$0;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            this.f4680a.m5758h();
            C1935m object = parent.getItemAtPosition(position);
            if (object instanceof C1935m) {
                C1935m callLog = object;
                StatisticManager.onEvent(StatisticConstants.PHONE_CALL_HISTORY, StatisticConstants.PHONE_CALL_HISTORY);
                this.f4680a.f4703R.m7107a(this.f4680a.getContext(), callLog.f6099b);
            } else if (object instanceof C1936n) {
                C1936n contact = (C1936n) object;
                StatisticManager.onEvent(StatisticConstants.PHONE_CALL_ADDRESS, StatisticConstants.PHONE_CALL_ADDRESS);
                this.f4680a.f4703R.m7107a(this.f4680a.getContext(), contact.f6105b);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.PhoneFragment$4 */
    class C15594 implements OnScrollListener {
        /* renamed from: a */
        final /* synthetic */ PhoneFragment f4681a;

        C15594(PhoneFragment this$0) {
            this.f4681a = this$0;
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 0 && !this.f4681a.f4704S && this.f4681a.f4690E.isSelected()) {
                this.f4681a.m5745a(String.valueOf(((C1936n) view.getItemAtPosition(this.f4681a.f4702Q)).f6107d));
                return;
            }
            this.f4681a.m5758h();
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (view.equals(this.f4681a.f4727q)) {
                this.f4681a.m5740a(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.PhoneFragment$5 */
    class C15605 implements OnScrollListener {
        /* renamed from: a */
        final /* synthetic */ PhoneFragment f4682a;

        C15605(PhoneFragment this$0) {
            this.f4682a = this$0;
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (view.equals(this.f4682a.f4727q)) {
                this.f4682a.m5740a(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.PhoneFragment$6 */
    class C15626 implements C1561a {
        /* renamed from: a */
        final /* synthetic */ PhoneFragment f4683a;

        C15626(PhoneFragment this$0) {
            this.f4683a = this$0;
        }

        /* renamed from: a */
        public void mo1595a() {
        }

        /* renamed from: a */
        public void mo1596a(int code) {
        }

        /* renamed from: b */
        public void mo1597b() {
            this.f4683a.f4720j.setSelected(true);
        }

        /* renamed from: c */
        public void mo1598c() {
            this.f4683a.f4720j.setSelected(false);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.PhoneFragment$a */
    private class C1563a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ PhoneFragment f4684a;

        private C1563a(PhoneFragment phoneFragment) {
            this.f4684a = phoneFragment;
        }

        public void careAbout() {
            addMsg(4001);
            addMsg(4004);
            addMsg(4003);
            addMsg(CommonParams.fS);
            addMsg(CommonParams.fT);
            addMsg(CommonParams.bU);
            addMsg(CommonParams.fm);
            addMsg(1002);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try {
                switch (msg.what) {
                    case 1002:
                        if (this.f4684a.f4698M != null) {
                            this.f4684a.f4698M.m8831a(false);
                        }
                        if (this.f4684a.f4699N != null) {
                            this.f4684a.f4699N.m8831a(false);
                            return;
                        }
                        return;
                    case CommonParams.fm /*1040*/:
                        if (this.f4684a.f4698M != null) {
                            this.f4684a.f4698M.m8831a(true);
                        }
                        if (this.f4684a.f4699N != null) {
                            this.f4684a.f4699N.m8831a(true);
                            return;
                        }
                        return;
                    case CommonParams.fS /*2026*/:
                        if (this.f4684a.f4698M == null) {
                            switch (this.f4684a.f4703R.m7116c()) {
                                case 0:
                                    LogUtil.d(PhoneFragment.f4685a, "current status is CALL_STATE_IDLE");
                                    if (this.f4684a.f4689D.isSelected() && this.f4684a.f4691F.hasFocus()) {
                                        this.f4684a.f4703R.m7107a(this.f4684a.getContext(), ((C1935m) this.f4684a.f4691F.getSelectedItem()).f6099b);
                                        return;
                                    } else if (this.f4684a.f4690E.isSelected() && this.f4684a.f4692G.hasFocus()) {
                                        this.f4684a.f4703R.m7107a(this.f4684a.getContext(), ((C1936n) this.f4684a.f4692G.getSelectedItem()).f6105b);
                                        return;
                                    } else {
                                        return;
                                    }
                                case 1:
                                    LogUtil.d(PhoneFragment.f4685a, "current status is CALL_STATE_RINGING");
                                    this.f4684a.f4703R.m7127m();
                                    return;
                                case 2:
                                    LogUtil.d(PhoneFragment.f4685a, "current status is CALL_STATE_OFFHOOK");
                                    return;
                                default:
                                    return;
                            }
                        } else if (this.f4684a.f4698M != null && this.f4684a.isDialogShown()) {
                            String temp = this.f4684a.f4698M.getInputString();
                            if (!TextUtils.isEmpty(temp)) {
                                this.f4684a.f4703R.m7107a(this.f4684a.getContext(), temp);
                                this.f4684a.m5754f();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case CommonParams.fT /*2027*/:
                        this.f4684a.f4703R.m7106a(BaseFragment.mActivity);
                        return;
                    case CommonParams.fU /*2028*/:
                        this.f4684a.m5758h();
                        return;
                    case 4001:
                    case 4003:
                    case 4004:
                        this.f4684a.m5754f();
                        this.f4684a.m5756g();
                        return;
                    case CommonParams.bU /*16875523*/:
                        if (msg.obj == null) {
                            if (this.f4684a.f4722l != null) {
                                this.f4684a.f4722l.setVisibility(4);
                                return;
                            }
                            return;
                        } else if (C1342a.m4926a().m4929b()) {
                            if (this.f4684a.f4722l != null) {
                                this.f4684a.f4722l.setVisibility(0);
                                return;
                            }
                            return;
                        } else if (C1343b.m4932a().m4935b()) {
                            this.f4684a.m5752e(FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving());
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            } catch (Exception ex) {
                LogUtil.m4445e(PhoneFragment.f4685a, "handler in phonefragment get exception");
                ex.printStackTrace();
            }
            LogUtil.m4445e(PhoneFragment.f4685a, "handler in phonefragment get exception");
            ex.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        LogUtil.m4434b(f4685a);
    }

    /* renamed from: a */
    private void m5740a(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (view.getChildAt(0) != null) {
            if (this.f4728r == 0 || this.f4730t == 0 || this.f4733w != totalItemCount) {
                this.f4733w = totalItemCount;
                this.f4730t = view.getHeight();
                this.f4732v = view.getChildAt(0).getHeight();
                this.f4731u = (this.f4732v * this.f4733w) - 10;
                this.f4728r = this.f4725o.getHeight();
                if (this.f4728r != 0) {
                    LayoutParams lp = this.f4726p.getLayoutParams();
                    this.f4729s = ((this.f4730t * this.f4728r) / this.f4733w) / this.f4732v;
                    int minScrollBarHeight = CarlifeScreenUtil.m4331a().m4343c(12);
                    if (this.f4729s < minScrollBarHeight) {
                        this.f4728r -= minScrollBarHeight - this.f4729s;
                        this.f4729s = minScrollBarHeight;
                    }
                    lp.height = this.f4729s;
                    this.f4726p.setLayoutParams(lp);
                } else {
                    return;
                }
            }
            int scrollY = ((-((this.f4732v * firstVisibleItem) - view.getChildAt(0).getTop())) * this.f4728r) / this.f4731u;
            if (scrollY == 0) {
                if (this.f4734x) {
                    this.f4734x = false;
                    this.f4723m.setImageResource(R.drawable.com_ic_prev_disable);
                    this.f4723m.setEnabled(false);
                }
                if (this.f4735y) {
                    if ((-((this.f4728r - this.f4729s) - 2)) >= 0) {
                        this.f4735y = false;
                        this.f4724n.setImageResource(R.drawable.com_ic_next_disable);
                        this.f4724n.setEnabled(false);
                    }
                } else if ((-((this.f4728r - this.f4729s) - 2)) < 0) {
                    this.f4735y = true;
                    this.f4724n.setImageResource(R.drawable.com_ic_next);
                    this.f4724n.setEnabled(true);
                }
            } else if (scrollY <= (-((this.f4728r - this.f4729s) - 2))) {
                if (this.f4735y) {
                    this.f4735y = false;
                    this.f4724n.setImageResource(R.drawable.com_ic_next_disable);
                    this.f4724n.setEnabled(false);
                }
                if (!(scrollY == 0 || this.f4734x)) {
                    this.f4734x = true;
                    this.f4723m.setImageResource(R.drawable.com_ic_prev);
                    this.f4723m.setEnabled(true);
                }
            } else {
                if (!this.f4734x) {
                    this.f4734x = true;
                    this.f4723m.setImageResource(R.drawable.com_ic_prev);
                    this.f4723m.setEnabled(true);
                }
                if (!this.f4735y) {
                    this.f4735y = true;
                    this.f4724n.setImageResource(R.drawable.com_ic_next);
                    this.f4724n.setEnabled(true);
                }
            }
            this.f4702Q = firstVisibleItem;
            this.f4725o.scrollTo(0, scrollY);
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.frag_phone, null);
        this.f4713c = new ArrayList();
        this.f4712b = new ArrayList();
        this.f4703R = C1868q.m7089f();
        this.f4703R.m7109a((C1564b) this);
        this.f4703R.m7110a((C1565d) this);
        this.f4703R.m7111a((C1060g) this);
        this.f4703R.m7108a(this.ac);
        this.f4736z = this.mContentView.findViewById(R.id.layout_phone);
        this.f4686A = (CommonTipView) this.mContentView.findViewById(R.id.common_tip_view);
        this.f4687B = this.mContentView.findViewById(R.id.btn_title_calllog);
        this.f4687B.setOnClickListener(this);
        this.f4687B.setBackground(C2251b.m8530d(mActivity));
        this.f4689D = this.mContentView.findViewById(R.id.tv_title_calllog);
        View view = this.f4689D;
        this.f4700O = true;
        view.setSelected(true);
        this.f4691F = (ListView) this.mContentView.findViewById(R.id.lv_calllog);
        this.f4691F.setOverScrollMode(2);
        this.f4693H = new CallLogListAdapter(getContext());
        this.f4691F.setOnItemClickListener(this.f4711Z);
        this.f4691F.setOnScrollListener(this.ab);
        this.f4691F.setOnTouchListener(this);
        this.f4691F.setAdapter(this.f4693H);
        this.f4691F.setVisibility(0);
        this.f4688C = this.mContentView.findViewById(R.id.btn_title_contacts);
        this.f4688C.setOnClickListener(this);
        this.f4688C.setBackgroundResource(R.drawable.common_btn_bg_focus);
        this.f4690E = this.mContentView.findViewById(R.id.tv_title_contacts);
        view = this.f4690E;
        this.f4701P = false;
        view.setSelected(false);
        this.f4692G = (ListView) this.mContentView.findViewById(R.id.lv_contacts);
        this.f4692G.setVisibility(8);
        this.f4692G.setOverScrollMode(2);
        this.f4692G.setOnItemClickListener(this.f4711Z);
        this.f4692G.setOnScrollListener(this.aa);
        this.f4692G.setOnTouchListener(this);
        this.f4727q = this.f4692G;
        this.f4694I = new PhoneContactsListAdapter(getContext());
        this.f4692G.setAdapter(this.f4694I);
        this.f4692G.setVisibility(8);
        this.f4722l = this.mContentView.findViewById(R.id.btnlistview_left);
        if (C1342a.m4926a().m4929b()) {
            this.f4722l.setVisibility(0);
        }
        if (C1343b.m4932a().m4935b()) {
            m5752e(FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving());
        }
        this.f4725o = (ViewGroup) this.mContentView.findViewById(R.id.btnlistview_scroller);
        this.f4726p = this.mContentView.findViewById(R.id.btnlistview_scroll_bar);
        this.f4723m = (ImageButton) this.mContentView.findViewById(R.id.btnlistview_btn_prev);
        this.f4724n = (ImageButton) this.mContentView.findViewById(R.id.btnlistview_btn_next);
        this.f4723m.setOnClickListener(this);
        this.f4724n.setOnClickListener(this);
        this.f4697L = (ImageButton) this.mContentView.findViewById(R.id.btn_keyboard);
        this.f4697L.setOnClickListener(this);
        this.f4697L.setBackground(C2251b.m8527a(mActivity));
        this.f4714d = (CommonTipView) this.mContentView.findViewById(R.id.layout_nobt);
        this.f4714d.m8398a((int) R.string.phone_state_nobt, (int) R.drawable.com_ic_callhistory_empty);
        this.f4715e = (RelativeLayout) this.mContentView.findViewById(R.id.layout_incoming);
        this.f4716f = (RelativeLayout) this.mContentView.findViewById(R.id.layout_offhook);
        this.f4717g = this.mContentView.findViewById(R.id.ib_incoming_break);
        this.f4717g.setOnClickListener(this);
        this.f4718h = this.mContentView.findViewById(R.id.ib_offhook_break);
        this.f4718h.setOnClickListener(this);
        this.f4719i = this.mContentView.findViewById(R.id.ib_incoming_answer);
        this.f4719i.setOnClickListener(this);
        this.f4720j = this.mContentView.findViewById(R.id.ib_offhook_voice);
        this.f4720j.setOnClickListener(this);
        this.f4721k = this.mContentView.findViewById(R.id.ib_offhook_keyboard);
        this.f4721k.setOnClickListener(this);
        mo1599b();
        switch (this.f4703R.m7116c()) {
            case 1:
                mo1391b(this.f4703R.m7115b());
                break;
            case 2:
                mo1392c(this.f4703R.m7115b());
                mo1389a();
                break;
            default:
                mo1390a(this.f4703R.m7115b());
                break;
        }
        this.f4707V = new C1563a();
        MsgHandlerCenter.m4460a(this.f4707V);
        return this.mContentView;
    }

    public void onClick(View v) {
        View view;
        switch (v.getId()) {
            case R.id.btnlistview_btn_prev:
                if (this.f4732v != 0) {
                    this.f4727q.smoothScrollToPositionFromTop(this.f4702Q - (this.f4730t / this.f4732v), -1);
                    return;
                }
                return;
            case R.id.btnlistview_btn_next:
                if (this.f4732v != 0) {
                    this.f4727q.smoothScrollToPositionFromTop(this.f4702Q + (this.f4730t / this.f4732v), -1);
                    return;
                }
                return;
            case R.id.btn_title_contacts:
                if (!this.f4701P) {
                    this.f4687B.setBackground(C2251b.m8530d(mActivity));
                    this.f4688C.setBackgroundResource(R.drawable.common_btn_bg_focus);
                }
                this.f4691F.setVisibility(8);
                this.f4692G.setVisibility(0);
                view = this.f4689D;
                this.f4700O = false;
                view.setSelected(false);
                this.f4727q = this.f4692G;
                this.f4692G.scrollBy(0, 1);
                this.f4692G.scrollBy(0, -1);
                view = this.f4690E;
                this.f4701P = true;
                view.setSelected(true);
                this.mContentView.findViewById(R.id.line_title_calllog).setVisibility(8);
                this.mContentView.findViewById(R.id.line_title_contacts).setVisibility(0);
                mo1600c();
                return;
            case R.id.btn_title_calllog:
                if (!this.f4700O) {
                    this.f4687B.setBackgroundResource(R.drawable.common_btn_bg_focus);
                    this.f4688C.setBackground(C2251b.m8530d(mActivity));
                }
                this.f4691F.setVisibility(0);
                this.f4692G.setVisibility(8);
                view = this.f4690E;
                this.f4701P = false;
                view.setSelected(false);
                view = this.f4689D;
                this.f4700O = true;
                view.setSelected(true);
                this.f4727q = this.f4691F;
                this.f4691F.scrollBy(0, 1);
                this.f4691F.scrollBy(0, -1);
                this.mContentView.findViewById(R.id.line_title_calllog).setVisibility(0);
                this.mContentView.findViewById(R.id.line_title_contacts).setVisibility(8);
                mo1599b();
                return;
            case R.id.btn_keyboard:
                m5749d();
                return;
            case R.id.ib_incoming_answer:
                this.f4703R.m7127m();
                return;
            case R.id.ib_incoming_break:
            case R.id.ib_offhook_break:
                this.f4703R.m7106a(getContext());
                return;
            case R.id.ib_offhook_voice:
                this.f4703R.m7126l();
                return;
            case R.id.ib_offhook_keyboard:
                m5751e();
                return;
            default:
                return;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ((C1342a.m4926a().m4929b() || C1343b.m4932a().m4935b()) && motionEvent.getAction() == 2 && FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving()) {
            motionEvent.setAction(0);
        }
        return false;
    }

    /* renamed from: d */
    private void m5749d() {
        if (this.f4698M == null) {
            this.f4698M = new C2325s(AppContext.m3876a(), false);
        }
        showDialog(this.f4698M, C1265a.Right);
    }

    /* renamed from: e */
    private void m5751e() {
        if (this.f4699N == null) {
            this.f4699N = new C2325s(AppContext.m3876a(), true);
        }
        showDialog(this.f4699N, C1265a.Right);
    }

    /* renamed from: f */
    private void m5754f() {
        if (isDialogShown()) {
            dismissDialog(this.f4698M);
        }
    }

    /* renamed from: g */
    private void m5756g() {
        if (isDialogShown()) {
            dismissDialog(this.f4699N);
        }
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
    }

    /* renamed from: b */
    public void mo1599b() {
        if (this.f4689D.isSelected()) {
            m5758h();
            dismissDialog();
            if (!(this.f4703R.m7120e() == null || this.f4703R.m7120e().isEmpty())) {
                try {
                    this.f4713c.clear();
                    this.f4713c.addAll(this.f4703R.m7120e());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (this.f4713c.isEmpty()) {
                this.f4686A.setVisibility(0);
                this.f4686A.m8403b(R.string.phone_calllog_nulltip);
                this.f4686A.m8401a(true);
                this.f4686A.setCommonTipCallBack(this.f4709X);
                this.f4691F.setEmptyView(this.f4686A);
            } else {
                this.f4686A.setVisibility(8);
                this.f4693H.m3174a(this.f4713c);
            }
            this.f4693H.notifyDataSetChanged();
            onInitFocusAreas();
        }
    }

    /* renamed from: c */
    public void mo1600c() {
        if (this.f4690E.isSelected()) {
            m5758h();
            dismissDialog(this.f4699N);
            dismissDialog(this.f4698M);
            CarlifeProgressDialogContainer.m4686a().mo1468c();
            if (!(this.f4703R.m7118d() == null || this.f4703R.m7118d().isEmpty())) {
                this.f4712b.clear();
                this.f4712b.addAll(this.f4703R.m7118d());
            }
            if (this.f4712b.isEmpty()) {
                this.f4686A.setVisibility(0);
                this.f4686A.m8403b(R.string.phone_contract_nulltip);
                this.f4686A.m8401a(true);
                this.f4686A.setCommonTipCallBack(this.f4710Y);
                this.f4692G.setEmptyView(this.f4686A);
            } else {
                this.f4686A.setVisibility(8);
                this.f4694I.m3216a(this.f4712b);
            }
            this.f4694I.notifyDataSetChanged();
            onInitFocusAreas();
        }
    }

    /* renamed from: h */
    private void m5758h() {
        if (this.f4695J != null && this.f4695J.isShowing()) {
            this.f4695J.dismiss();
        }
    }

    /* renamed from: a */
    private void m5745a(String text) {
        if (this.f4695J == null) {
            this.f4696K = new TextView(getContext());
            this.f4696K.setBackground(C2188r.m8331b(R.drawable.phone_bg_index_circle));
            this.f4696K.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_bgtext));
            this.f4696K.setTextSize(40.0f);
            this.f4696K.setGravity(17);
            int size = getResources().getDimensionPixelSize(R.dimen.bladeview_popup_height);
            this.f4695J = new PopupWindow(this.f4696K, size, size, false);
            this.f4695J.setOutsideTouchable(true);
        }
        this.f4696K.setText(text);
        if (this.f4695J.isShowing()) {
            this.f4695J.update();
        } else {
            this.f4695J.showAtLocation(this.mContentView, 17, 0, 0);
        }
        this.f4707V.removeMessages(CommonParams.fU);
        this.f4707V.sendEmptyMessageDelayed(CommonParams.fU, 1500);
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtil.m4434b(f4685a);
        this.f4704S = hidden;
        if (hidden) {
            m5758h();
        }
    }

    public boolean onBackPressed() {
        if (mActivity != null) {
            mActivity.m3108d();
        }
        return true;
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    /* renamed from: a */
    public void mo1390a(boolean isBTConnected) {
        this.f4736z.setVisibility(0);
        this.f4714d.setVisibility(8);
        this.f4715e.setVisibility(8);
        this.f4716f.setVisibility(8);
        Chronometer startTimeOffHookView = (Chronometer) this.mContentView.findViewById(R.id.view_offhook_start_timing);
        startTimeOffHookView.setVisibility(8);
        startTimeOffHookView.stop();
        this.f4708W = "";
        this.mContentView.findViewById(R.id.phone_toast_tv).setVisibility(8);
        this.mContentView.findViewById(R.id.tv_offhook_desc).setVisibility(8);
        m5754f();
        m5756g();
        onInitFocusAreas();
    }

    /* renamed from: b */
    public void mo1391b(boolean isBTConnected) {
        this.f4736z.setVisibility(8);
        if (isBTConnected) {
            this.f4714d.setVisibility(8);
            this.f4715e.setVisibility(0);
            this.f4716f.setVisibility(8);
            ((TextView) this.mContentView.findViewById(R.id.tv_incoming_name)).setText(this.f4703R.m7102a());
        } else {
            this.f4714d.setVisibility(0);
            this.f4715e.setVisibility(8);
            this.f4716f.setVisibility(8);
            this.f4714d.m8396a();
            this.mContentView.findViewById(R.id.phone_toast_tv).setVisibility(8);
        }
        m5754f();
        m5756g();
        onInitFocusAreas();
    }

    /* renamed from: c */
    public void mo1392c(boolean isBTConnected) {
        this.f4736z.setVisibility(8);
        if (isBTConnected) {
            this.f4714d.setVisibility(8);
            this.f4715e.setVisibility(8);
            this.f4716f.setVisibility(0);
            TextView tvOutgoing = (TextView) this.mContentView.findViewById(R.id.tv_offhook_name);
            this.f4708W = TextUtils.isEmpty(this.f4708W) ? this.f4703R.m7102a() : this.f4708W;
            tvOutgoing.setText(this.f4708W);
            this.f4720j.setSelected(false);
            if (this.f4703R.m7124j() || this.mContentView.findViewById(R.id.view_offhook_start_timing).isShown()) {
                this.mContentView.findViewById(R.id.tv_offhook_desc).setVisibility(8);
            } else {
                this.mContentView.findViewById(R.id.tv_offhook_desc).setVisibility(0);
            }
        } else {
            this.f4714d.setVisibility(0);
            this.f4715e.setVisibility(8);
            this.f4716f.setVisibility(8);
            this.f4714d.m8396a();
            this.mContentView.findViewById(R.id.phone_toast_tv).setVisibility(8);
        }
        m5754f();
        m5756g();
        onInitFocusAreas();
    }

    /* renamed from: a */
    public void mo1389a() {
        Chronometer startTimeOffHookView = (Chronometer) this.mContentView.findViewById(R.id.view_offhook_start_timing);
        startTimeOffHookView.setVisibility(0);
        startTimeOffHookView.setBase(SystemClock.elapsedRealtime());
        startTimeOffHookView.start();
        this.mContentView.findViewById(R.id.tv_offhook_desc).setVisibility(8);
    }

    /* renamed from: d */
    public void mo1393d(boolean isMultiCall) {
        ((TextView) this.mContentView.findViewById(R.id.phone_toast_tv)).setVisibility(isMultiCall ? 0 : 8);
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4705T == null) {
                this.f4705T = C1440d.m5251a();
            }
            if (this.f4706U == null) {
                this.f4706U = new C1443g(this.mContentView.findViewById(R.id.layout_title), 2);
                this.f4706U.m5300d(this.f4687B).m5300d(this.f4688C).m5300d(this.f4697L);
                this.f4706U.m5297b(this.f4687B);
            }
            if (this.f4703R.m7115b()) {
                C1443g mFocusAreaMiddleViewGroup;
                switch (this.f4703R.m7116c()) {
                    case 1:
                        mFocusAreaMiddleViewGroup = new C1443g(this.f4715e, 4);
                        mFocusAreaMiddleViewGroup.m5300d(this.f4719i).m5300d(this.f4717g);
                        mFocusAreaMiddleViewGroup.m5297b(this.f4719i);
                        this.f4705T.m5256b(this.f4706U, mFocusAreaMiddleViewGroup);
                        this.f4705T.m5268h(mFocusAreaMiddleViewGroup);
                        return;
                    case 2:
                        mFocusAreaMiddleViewGroup = new C1443g(this.f4716f, 4);
                        mFocusAreaMiddleViewGroup.m5300d(this.f4720j).m5300d(this.f4718h).m5300d(this.f4721k);
                        mFocusAreaMiddleViewGroup.m5297b(this.f4718h);
                        this.f4705T.m5256b(this.f4706U, mFocusAreaMiddleViewGroup);
                        this.f4705T.m5268h(mFocusAreaMiddleViewGroup);
                        return;
                    default:
                        m5759i();
                        return;
                }
            }
            m5759i();
        }
    }

    public boolean onVoiceCommand(String strCommand, String strIntent) {
        LogUtil.d(f4685a, "Voice CMD: [" + strCommand + "][" + strIntent + "]");
        if (strIntent.equals(C2736p.f8992v)) {
            onClick(this.f4688C);
            return true;
        } else if (!strIntent.equals(C2736p.f8993w)) {
            return false;
        } else {
            onClick(this.f4687B);
            return true;
        }
    }

    /* renamed from: i */
    private void m5759i() {
        C1438c mFocusAreaMiddleListView;
        if (this.f4689D.isSelected()) {
            mFocusAreaMiddleListView = new C1438c(this.f4691F, 4);
        } else {
            mFocusAreaMiddleListView = new C1438c(this.f4692G, 4);
        }
        if (this.f4686A.getVisibility() == 0) {
            new C1443g(this.f4686A, 4).m5300d(this.f4686A.getFocusView());
            this.f4705T.m5256b(this.f4706U, mFocusAreaMiddleViewGroup);
        } else {
            this.f4705T.m5256b(this.f4706U, mFocusAreaMiddleListView);
        }
        if (!CarlifeViewContainer.m4699a().isDialogShown()) {
            if (this.f4686A.getVisibility() == 0) {
                this.f4705T.m5268h(this.f4706U);
                return;
            }
            this.f4705T.m5268h(mFocusAreaMiddleListView);
            mFocusAreaMiddleListView.m5250e();
        }
    }

    public void driving() {
        if (C1343b.m4932a().m4935b()) {
            m5752e(true);
        }
    }

    public void stopDriving() {
        if (C1343b.m4932a().m4935b()) {
            m5752e(false);
        }
    }

    /* renamed from: e */
    private void m5752e(boolean isShow) {
        if (isShow) {
            if (this.f4722l != null) {
                this.f4722l.setVisibility(0);
            }
        } else if (this.f4722l != null) {
            this.f4722l.setVisibility(4);
        }
    }
}
