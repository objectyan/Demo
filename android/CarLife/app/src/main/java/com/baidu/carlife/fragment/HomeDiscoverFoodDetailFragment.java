package com.baidu.carlife.fragment;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.model.C1925e;
import com.baidu.carlife.model.C1926f;
import com.baidu.carlife.p054k.C1645f;
import com.baidu.carlife.p054k.C1646g;
import com.baidu.carlife.p054k.C1648i;
import com.baidu.carlife.p054k.C1649j;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.MultiImageView;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2282f;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeDiscoverFoodDetailFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private C1648i f4347a;
    /* renamed from: b */
    private C1646g f4348b;
    /* renamed from: c */
    private C1649j f4349c;
    /* renamed from: d */
    private C1645f f4350d;
    /* renamed from: e */
    private C1925e f4351e;
    /* renamed from: f */
    private C1926f f4352f;
    /* renamed from: g */
    private int f4353g;
    /* renamed from: h */
    private int f4354h;
    /* renamed from: i */
    private C2282f f4355i;
    /* renamed from: j */
    private C1953c f4356j;
    /* renamed from: k */
    private C1953c f4357k;
    /* renamed from: l */
    private C1953c f4358l;
    /* renamed from: m */
    private CommonTipView f4359m;
    /* renamed from: n */
    private boolean f4360n = false;
    /* renamed from: o */
    private C1443g f4361o;
    /* renamed from: p */
    private C1443g f4362p;
    /* renamed from: q */
    private C0924a f4363q = new C14711(this);
    /* renamed from: r */
    private C0924a f4364r = new C14722(this);
    /* renamed from: s */
    private C0924a f4365s = new C14733(this);
    /* renamed from: t */
    private C0924a f4366t = new C14744(this);

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment$1 */
    class C14711 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodDetailFragment f4340a;

        /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment$1$1 */
        class C14701 implements C0672b {
            /* renamed from: a */
            final /* synthetic */ C14711 f4339a;

            C14701(C14711 this$1) {
                this.f4339a = this$1;
            }

            public void onClick() {
                this.f4339a.f4340a.back();
            }
        }

        C14711(HomeDiscoverFoodDetailFragment this$0) {
            this.f4340a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            C1307e.m4686a().mo1468c();
            if (responseCode == -2) {
                C2201w.m8371a((int) C0965R.string.common_error_nonetwork, 0);
            } else if (responseCode == 0 && this.f4340a.isAdded()) {
                if (this.f4340a.f4357k == null) {
                    this.f4340a.f4357k = new C1953c(this.f4340a.getContext()).m7442b((int) C0965R.string.home_food_menu_reqsuc_title).m7435a((int) C0965R.string.home_food_menu_reqsuc_content).m7458q().m7447c((int) C0965R.string.positive).m7438a(new C14701(this));
                }
                this.f4340a.showDialog(this.f4340a.f4357k);
            } else if (this.f4340a.f4347a != null) {
                String msg = BaiduNaviApplication.getInstance().getApplicationContext().getString(C0965R.string.common_error_nonetwork);
                if (!TextUtils.isEmpty(this.f4340a.f4347a.getErrMsg())) {
                    msg = this.f4340a.f4347a.getErrMsg();
                }
                C2201w.m8373a(msg, 0);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment$2 */
    class C14722 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodDetailFragment f4341a;

        C14722(HomeDiscoverFoodDetailFragment this$0) {
            this.f4341a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            C1307e.m4686a().mo1468c();
            if (responseCode == -2) {
                C2201w.m8371a((int) C0965R.string.common_error_nonetwork, 0);
            } else if (responseCode == 0) {
                this.f4341a.back();
            } else if (this.f4341a.f4348b != null) {
                String msg = BaiduNaviApplication.getInstance().getApplicationContext().getString(C0965R.string.common_error_nonetwork);
                if (!TextUtils.isEmpty(this.f4341a.f4348b.getErrMsg())) {
                    msg = this.f4341a.f4348b.getErrMsg();
                }
                C2201w.m8373a(msg, 0);
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment$3 */
    class C14733 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodDetailFragment f4342a;

        C14733(HomeDiscoverFoodDetailFragment this$0) {
            this.f4342a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            if (this.f4342a.isAdded()) {
                this.f4342a.f4351e = this.f4342a.f4350d.m5955a();
                if (this.f4342a.f4354h == 1) {
                    C1307e.m4686a().mo1468c();
                    if (responseCode == 0) {
                        this.f4342a.m5377a(this.f4342a.mContentView);
                        this.f4342a.f4360n = false;
                    } else if (responseCode == -2) {
                        this.f4342a.f4359m.m8397a(1);
                        this.f4342a.f4360n = true;
                    } else {
                        this.f4342a.f4359m.m8397a(0);
                        this.f4342a.f4360n = true;
                    }
                } else if (this.f4342a.f4351e != null) {
                    this.f4342a.f4349c = new C1649j();
                    this.f4342a.f4349c.m5960a(this.f4342a.f4352f.f6002j, this.f4342a.f4352f.f6003k);
                    this.f4342a.f4349c.registerResponseListener(this.f4342a.f4366t);
                    this.f4342a.f4349c.toPostRequest();
                    this.f4342a.f4360n = false;
                } else if (responseCode == -2) {
                    C1307e.m4686a().mo1468c();
                    this.f4342a.f4359m.m8397a(1);
                    this.f4342a.f4360n = true;
                } else {
                    C1307e.m4686a().mo1468c();
                    this.f4342a.f4359m.m8397a(0);
                    this.f4342a.f4360n = true;
                }
                this.f4342a.onInitFocusAreas();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment$4 */
    class C14744 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodDetailFragment f4343a;

        C14744(HomeDiscoverFoodDetailFragment this$0) {
            this.f4343a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            if (this.f4343a.isAdded()) {
                C1307e.m4686a().mo1468c();
                if (responseCode == 0) {
                    this.f4343a.m5377a(this.f4343a.mContentView);
                    List<C1926f> temp = this.f4343a.f4349c.m5959a();
                    if (temp != null && temp.size() > 0) {
                        this.f4343a.f4352f = (C1926f) this.f4343a.f4349c.m5959a().get(0);
                        TextView distantTV = (TextView) this.f4343a.mContentView.findViewById(C0965R.id.tv_distant);
                        if (TextUtils.isEmpty(this.f4343a.f4352f.f6005m)) {
                            distantTV.setText("");
                        } else {
                            distantTV.setText(this.f4343a.f4352f.f6005m);
                        }
                        TextView noticeTV = (TextView) this.f4343a.mContentView.findViewById(C0965R.id.tv_notice);
                        if (TextUtils.isEmpty(this.f4343a.f4351e.f5971D)) {
                            noticeTV.setText("");
                        } else {
                            noticeTV.setText(this.f4343a.f4351e.f5971D);
                        }
                        Button stateBtn = (Button) this.f4343a.mContentView.findViewById(C0965R.id.btn_state);
                        if (C1926f.m7390a(this.f4343a.f4352f.f6004l)) {
                            this.f4343a.f4353g = 200;
                            stateBtn.setBackgroundResource(C0965R.drawable.com_bg_btn_c_selector);
                            stateBtn.setEnabled(true);
                            stateBtn.setAlpha(1.0f);
                            stateBtn.setVisibility(0);
                            stateBtn.setText(C0965R.string.home_food_btn_cancel);
                        } else {
                            stateBtn.setVisibility(8);
                        }
                        View queueingView = ((ViewStub) this.f4343a.mContentView.findViewById(C0965R.id.view_queueing)).inflate();
                        TextView queueNameTV = (TextView) queueingView.findViewById(C0965R.id.tv_queue_name);
                        if (TextUtils.isEmpty(this.f4343a.f4352f.f6008p)) {
                            queueNameTV.setText(C0965R.string.home_food_queue_default);
                        } else {
                            queueNameTV.setText(this.f4343a.f4352f.f6008p);
                        }
                        TextView queueWaitNumTV = (TextView) queueingView.findViewById(C0965R.id.tv_queue_waitnum);
                        if (C1926f.m7390a(this.f4343a.f4352f.f6004l)) {
                            queueWaitNumTV.setText(this.f4343a.getString(C0965R.string.home_food_waitnum1, new Object[]{Integer.valueOf(this.f4343a.f4352f.f5996d)}));
                        } else {
                            queueWaitNumTV.setText(C0965R.string.home_food_queue_default);
                        }
                        TextView queueWaittimeTV = (TextView) queueingView.findViewById(C0965R.id.tv_queue_waittime);
                        if (TextUtils.isEmpty(this.f4343a.f4352f.f6001i) || !C1926f.m7390a(this.f4343a.f4352f.f6004l)) {
                            queueWaittimeTV.setText(C0965R.string.home_food_queue_default);
                        } else {
                            queueWaittimeTV.setText(this.f4343a.f4352f.f6001i);
                        }
                        this.f4343a.mContentView.findViewById(C0965R.id.temp).setVisibility(0);
                    }
                    this.f4343a.f4360n = false;
                } else if (responseCode == -2) {
                    this.f4343a.f4359m.m8397a(1);
                    this.f4343a.f4360n = true;
                } else {
                    this.f4343a.f4359m.m8397a(0);
                    this.f4343a.f4360n = true;
                }
                this.f4343a.onInitFocusAreas();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment$5 */
    class C14755 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodDetailFragment f4344a;

        C14755(HomeDiscoverFoodDetailFragment this$0) {
            this.f4344a = this$0;
        }

        public void onClick() {
            StatisticManager.onEvent(StatisticConstants.HOME_DISCOVERY_FOOD_CALL, StatisticConstants.HOME_DISCOVERY_FOOD_CALL);
            C1868q.m7089f().m7107a(this.f4344a.getContext(), this.f4344a.f4351e.f5991y);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment$6 */
    class C14766 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodDetailFragment f4345a;

        C14766(HomeDiscoverFoodDetailFragment this$0) {
            this.f4345a = this$0;
        }

        public void onClick() {
            C1307e.m4686a().mo1467b(this.f4345a.getString(C0965R.string.progress_requesting));
            this.f4345a.f4348b = new C1646g(this.f4345a.f4352f.f6002j, this.f4345a.f4352f.f6003k);
            this.f4345a.f4348b.registerResponseListener(this.f4345a.f4364r);
            this.f4345a.f4348b.toPostRequest();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment$7 */
    class C14777 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverFoodDetailFragment f4346a;

        C14777(HomeDiscoverFoodDetailFragment this$0) {
            this.f4346a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            this.f4346a.dismissDialog(this.f4346a.f4355i);
            String phone = NaviAccountUtils.getInstance().getSecurePhoneNum();
            C1926f queue = (C1926f) this.f4346a.f4351e.f5973F.get(position);
            if (queue != null) {
                C1307e.m4686a().mo1467b(this.f4346a.getString(C0965R.string.progress_requesting));
                this.f4346a.f4347a = new C1648i(phone, this.f4346a.f4351e.f5974h, this.f4346a.f4351e.f5980n.intValue(), queue.f5999g, queue.f5997e);
                this.f4346a.f4347a.registerResponseListener(this.f4346a.f4363q);
                this.f4346a.f4347a.toPostRequest();
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(C0965R.layout.frag_home_discover_food_detail, null);
        this.f4359m = (CommonTipView) contentView.findViewById(C0965R.id.common_tip_view);
        if (this.mShowBundle != null) {
            Serializable model = this.mShowBundle.getSerializable("model");
            if (model != null) {
                if (model instanceof C1926f) {
                    this.f4354h = 0;
                    this.f4352f = (C1926f) model;
                    setCommonTitleBar(contentView, this.f4352f.f6009q);
                    this.f4350d = new C1645f(this.f4352f.f6010r, null);
                } else {
                    this.f4354h = 1;
                    this.f4351e = (C1925e) model;
                    setCommonTitleBar(contentView, this.f4351e.f5975i);
                    this.f4350d = new C1645f(this.f4351e.f5974h, this.f4351e);
                }
                ((ScrollView) contentView.findViewById(C0965R.id.layout_content)).setOverScrollMode(2);
                C1307e.m4686a().mo1467b(getString(C0965R.string.progress_loading));
                this.f4350d.registerResponseListener(this.f4365s);
                this.f4350d.toPostRequest();
                return contentView;
            }
        }
        this.f4359m.m8397a(0);
        setCommonTitleBar(contentView, null);
        return contentView;
    }

    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            setBottomBarStatus(false);
        }
        super.onHiddenChanged(hidden);
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    /* renamed from: a */
    private void m5377a(View contentView) {
        if (this.f4351e != null) {
            contentView.findViewById(C0965R.id.layout_content).setVisibility(0);
            MultiImageView logoIV = (MultiImageView) contentView.findViewById(C0965R.id.iv_logo);
            logoIV.setDefaultDrawable(C2188r.m8331b(C0965R.drawable.home_bg_food_albumcover));
            logoIV.setImageUrl(this.f4351e.f5976j);
            TextView distantTV = (TextView) contentView.findViewById(C0965R.id.tv_distant);
            if (this.f4351e.f5980n.intValue() > 0) {
                CharSequence spannableString = new SpannableString(String.format(getString(C0965R.string.home_food_distance), new Object[]{C1925e.m7388a(this.f4351e.f5980n.intValue())}));
                spannableString.setSpan(new RelativeSizeSpan(0.78f), 0, 2, 17);
                distantTV.setText(spannableString);
            }
            TextView nameTV = (TextView) contentView.findViewById(C0965R.id.tv_name);
            m5379a(this.f4351e.f5975i, nameTV);
            TextView addrTV = (TextView) contentView.findViewById(C0965R.id.tv_addr);
            if (!TextUtils.isEmpty(this.f4351e.f5989w)) {
                addrTV.setText(this.f4351e.f5989w);
            }
            TextView openTV = (TextView) contentView.findViewById(C0965R.id.tv_open);
            if (!TextUtils.isEmpty(this.f4351e.f5992z)) {
                openTV.setText(String.format(getString(C0965R.string.home_food_open), new Object[]{this.f4351e.f5992z}));
            }
            RatingBar scoreRB = (RatingBar) contentView.findViewById(C0965R.id.rb_score);
            float temp = 0.0f;
            try {
                temp = Float.parseFloat(this.f4351e.f5969B + "");
            } catch (Exception e) {
            }
            if (temp > 0.0f) {
                scoreRB.setVisibility(0);
                scoreRB.setRating(temp);
            } else {
                scoreRB.setVisibility(4);
            }
            TextView styleTV = (TextView) contentView.findViewById(C0965R.id.tv_style);
            if (!TextUtils.isEmpty(this.f4351e.f5990x)) {
                styleTV.setText(this.f4351e.f5990x);
            }
            TextView priceTV = (TextView) contentView.findViewById(C0965R.id.tv_price);
            if (this.f4351e.f5968A > 0) {
                priceTV.setText(String.format(getString(C0965R.string.home_food_perprice), new Object[]{Integer.valueOf(this.f4351e.f5968A)}));
            }
            TextView discountTV = (TextView) contentView.findViewById(C0965R.id.tv_discount);
            if (TextUtils.isEmpty(this.f4351e.f5972E)) {
                discountTV.setVisibility(8);
                contentView.findViewById(C0965R.id.temp1).setVisibility(8);
            } else {
                discountTV.setText(this.f4351e.f5972E.replace("\t", "\n"));
            }
            View gothereBtn = contentView.findViewById(C0965R.id.btn_gothere);
            if (C1253f.jr) {
                gothereBtn.setVisibility(0);
                gothereBtn.setOnClickListener(this);
            } else {
                gothereBtn.setVisibility(8);
            }
            contentView.findViewById(C0965R.id.btn_tel).setOnClickListener(this);
            TextView noticeTV = (TextView) contentView.findViewById(C0965R.id.tv_notice);
            if (!TextUtils.isEmpty(this.f4351e.f5978l)) {
                noticeTV.setText(this.f4351e.f5978l);
            }
            Button stateBtn = (Button) contentView.findViewById(C0965R.id.btn_state);
            stateBtn.setOnClickListener(this);
            stateBtn.setBackgroundResource(C0965R.drawable.com_bg_btn_b_selector);
            this.f4353g = C1925e.m7385a(this.f4351e);
            switch (this.f4353g) {
                case 0:
                    stateBtn.setEnabled(true);
                    stateBtn.setAlpha(1.0f);
                    stateBtn.setVisibility(0);
                    stateBtn.setText(C0965R.string.home_food_btn_available);
                    break;
                case 100:
                    stateBtn.setEnabled(false);
                    stateBtn.setAlpha(0.2f);
                    stateBtn.setVisibility(0);
                    stateBtn.setText(C0965R.string.home_food_btn_noqueue);
                    break;
                case 102:
                    stateBtn.setEnabled(false);
                    stateBtn.setAlpha(0.2f);
                    stateBtn.setVisibility(0);
                    stateBtn.setText(C0965R.string.home_food_btn_toofar);
                    break;
                case 103:
                    stateBtn.setEnabled(false);
                    stateBtn.setAlpha(0.2f);
                    stateBtn.setVisibility(0);
                    stateBtn.setText(C0965R.string.home_food_btn_live);
                    break;
                case 104:
                    stateBtn.setEnabled(false);
                    stateBtn.setAlpha(0.2f);
                    stateBtn.setVisibility(0);
                    stateBtn.setText(C0965R.string.home_food_btn_disable);
                    break;
                default:
                    stateBtn.setVisibility(8);
                    break;
            }
            if (this.f4351e.f5973F == null || this.f4354h != 1) {
                contentView.findViewById(C0965R.id.temp).setVisibility(8);
                return;
            }
            if (!TextUtils.isEmpty(this.f4351e.f5971D)) {
                noticeTV.setText(this.f4351e.f5971D);
            }
            LinearLayout queuesLL = (LinearLayout) ((ViewStub) contentView.findViewById(C0965R.id.view_queues)).inflate().findViewById(C0965R.id.ll_queues);
            for (C1926f queue : this.f4351e.f5973F) {
                View view = View.inflate(getContext(), C0965R.layout.item_food_queue, null);
                ((TextView) view.findViewById(C0965R.id.tv_queue_name)).setText(queue.f5994b + "(" + queue.f5995c + ")");
                ((TextView) view.findViewById(C0965R.id.tv_queue_waitnum)).setText(queue.f5996d + "桌");
                TextView queueWaittimeTV = (TextView) view.findViewById(C0965R.id.tv_queue_waittime);
                if (TextUtils.isEmpty(queue.f6001i)) {
                    queueWaittimeTV.setText(C0965R.string.home_food_queue_default);
                } else {
                    queueWaittimeTV.setText(queue.f6001i);
                }
                queuesLL.addView(view);
            }
        }
    }

    /* renamed from: a */
    private void m5379a(String name, TextView nameTV) {
        if (TextUtils.isEmpty(name)) {
            nameTV.setText("");
            return;
        }
        int index = name.indexOf("(");
        if (index >= 0) {
            SpannableString span = new SpannableString(name);
            span.setSpan(new RelativeSizeSpan(0.78f), index, name.length(), 17);
            nameTV.setText(span);
            return;
        }
        nameTV.setText(name);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.btn_state:
                if (this.f4353g == 0) {
                    if (this.f4351e.f5973F != null) {
                        StatisticManager.onEvent(StatisticConstants.DISCOVER_ZMS_0002, StatisticConstants.DISCOVER_ZMS_0002);
                        m5382b();
                        return;
                    }
                    return;
                } else if (this.f4353g == 200) {
                    StatisticManager.onEvent(StatisticConstants.HOME_DISCOVERY_FOOD_CANCLE, StatisticConstants.HOME_DISCOVERY_FOOD_CANCLE);
                    m5376a();
                    return;
                } else {
                    return;
                }
            case C0965R.id.btn_gothere:
                if (this.f4351e != null && !TextUtils.isEmpty(this.f4351e.f5975i)) {
                    StatisticManager.onEvent(StatisticConstants.DISCOVER_ZMS_0003, StatisticConstants.DISCOVER_ZMS_0003);
                    if (this.f4353g == 200) {
                        StatisticManager.onEvent(StatisticConstants.DISCOVER_ZMS_0004, StatisticConstants.DISCOVER_ZMS_0004);
                    }
                    innerNameSearch(this.f4351e.f5975i);
                    return;
                }
                return;
            case C0965R.id.btn_tel:
                if (TextUtils.isEmpty(this.f4351e.f5991y)) {
                    C2201w.m8371a((int) C0965R.string.home_food_notel, 0);
                    return;
                }
                if (this.f4356j == null) {
                    this.f4356j = new C1953c(getContext()).m7457g(17).m7444b(this.f4351e.f5991y).m7458q().m7447c((int) C0965R.string.btn_call).m7450d((int) C0965R.string.negative);
                    this.f4356j.m7438a(new C14755(this));
                }
                showDialog(this.f4356j);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m5376a() {
        if (this.f4358l == null) {
            this.f4358l = new C1953c(getContext()).m7435a((int) C0965R.string.home_food_menu_cancelqueuetip).m7447c((int) C0965R.string.positive).m7450d((int) C0965R.string.negative).m7438a(new C14766(this));
        }
        showDialog(this.f4358l);
    }

    /* renamed from: b */
    private void m5382b() {
        if (this.f4355i == null) {
            List<Map<String, String>> list = new ArrayList();
            for (C1926f queue : this.f4351e.f5973F) {
                Map<String, String> map = new HashMap();
                map.put("text", queue.f5994b + "(" + queue.f5995c + ")");
                list.add(map);
            }
            this.f4355i = new C2282f(getContext(), C0965R.string.home_food_menu_queuetype, new SimpleAdapter(getContext(), list, C0965R.layout.item_food_style, new String[]{"text"}, new int[]{C0965R.id.textview}), new C14777(this));
        }
        if (NaviAccountUtils.getInstance().isLogin()) {
            showDialog(this.f4355i, C1265a.Right);
        } else if (!showConnectForbidDialog()) {
            showFragment(NaviFragmentManager.TYPE_LOGIN, null);
        }
    }

    public void driving() {
        C1260i.m4435b("yftech", "HomeDiscoverFoodDetailFragment driving");
        C1307e.m4686a().mo1468c();
        m5384c();
        back();
        back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
    }

    /* renamed from: c */
    private void m5384c() {
        if (this.f4355i != null && this.f4355i.isShown()) {
            this.f4355i.mo1526d();
        }
        if (this.f4356j != null && this.f4356j.isShown()) {
            this.f4356j.mo1526d();
        }
        if (this.f4357k != null && this.f4357k.isShown()) {
            this.f4357k.mo1526d();
        }
        if (this.f4358l != null && this.f4358l.isShown()) {
            this.f4358l.mo1526d();
        }
        dismissDialog();
    }

    public void onInitFocusAreas() {
        if (getCurrentFragmentType() == NaviFragmentManager.TYPE_HOME_DISCOVER_FOOD_DETAIL) {
            if (this.f4361o == null) {
                this.f4361o = new C1443g(this.mContentView.findViewById(C0965R.id.common_top_bar), 2);
                this.f4361o.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
            }
            if (this.f4362p == null) {
                this.f4362p = new C1443g(this.mContentView.findViewById(C0965R.id.layout_content), 6);
                if (this.f4352f != null && C1926f.m7390a(this.f4352f.f6004l)) {
                    this.f4362p.m5300d(this.mContentView.findViewById(C0965R.id.btn_state));
                }
                this.f4362p.m5300d(this.mContentView.findViewById(C0965R.id.btn_gothere)).m5300d(this.mContentView.findViewById(C0965R.id.btn_tel));
            }
            if (this.f4360n) {
                C1440d.m5251a().m5256b(this.f4361o);
                C1440d.m5251a().m5268h(this.f4361o);
                return;
            }
            C1440d.m5251a().m5256b(this.f4361o, this.f4362p);
            C1440d.m5251a().m5268h(this.f4362p);
        }
    }
}
