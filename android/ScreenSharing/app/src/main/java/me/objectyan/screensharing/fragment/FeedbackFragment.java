package com.baidu.carlife.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.p054k.C1643d;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2288h;
import com.baidu.carlife.view.dialog.C2288h.C1464a;
import com.baidu.navi.controller.FeedbackController;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.drivertool.BNDrivingToolParams;
import java.io.File;
import java.util.UUID;

public class FeedbackFragment extends ContentFragment implements OnClickListener {
    /* renamed from: b */
    private static final int f4304b = 400;
    /* renamed from: c */
    private static final int f4305c = 4;
    /* renamed from: d */
    private static final String f4306d = "key_content";
    /* renamed from: e */
    private static final String f4307e = "key_contact";
    /* renamed from: f */
    private static final String f4308f = "key_type";
    /* renamed from: g */
    private static final String f4309g = "28170";
    /* renamed from: h */
    private static final String f4310h = "28172";
    /* renamed from: i */
    private static final String f4311i = "28171";
    /* renamed from: j */
    private static final int f4312j = 40;
    /* renamed from: A */
    private String f4313A = f4309g;
    /* renamed from: B */
    private GridView f4314B;
    /* renamed from: C */
    private C1469a f4315C;
    /* renamed from: D */
    private LayoutInflater f4316D;
    /* renamed from: E */
    private String f4317E;
    /* renamed from: F */
    private String f4318F;
    /* renamed from: G */
    private Animation f4319G;
    /* renamed from: H */
    private C0924a f4320H = new C14561(this);
    /* renamed from: I */
    private C1464a f4321I = new C14659(this);
    /* renamed from: a */
    public C0924a f4322a = new C14572(this);
    /* renamed from: k */
    private EditText f4323k;
    /* renamed from: l */
    private EditText f4324l;
    /* renamed from: m */
    private boolean f4325m = false;
    /* renamed from: n */
    private RelativeLayout f4326n;
    /* renamed from: o */
    private TextView f4327o;
    /* renamed from: p */
    private ImageView f4328p;
    /* renamed from: q */
    private ImageView f4329q;
    /* renamed from: r */
    private ImageButton f4330r;
    /* renamed from: s */
    private TextView f4331s;
    /* renamed from: t */
    private TextView f4332t;
    /* renamed from: u */
    private LinearLayout f4333u;
    /* renamed from: v */
    private LinearLayout f4334v;
    /* renamed from: w */
    private LinearLayout f4335w;
    /* renamed from: x */
    private ImageView f4336x;
    /* renamed from: y */
    private ImageView f4337y;
    /* renamed from: z */
    private ImageView f4338z;

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$1 */
    class C14561 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4287a;

        C14561(FeedbackFragment this$0) {
            this.f4287a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            if (this.f4287a.isAdded()) {
                this.f4287a.m5342a(true);
                if (responseCode == 0) {
                    if (this.f4287a.f4323k != null) {
                        this.f4287a.f4323k.setText("");
                    }
                    if (this.f4287a.f4324l != null) {
                        this.f4287a.f4324l.setText("");
                    }
                    this.f4287a.f4313A = FeedbackFragment.f4309g;
                    TipTool.onCreateToastDialog(BaseFragment.mActivity, StyleManager.getString(R.string.feedback_success));
                    this.f4287a.onBackPressed();
                    return;
                }
                this.f4287a.m5366a(this.f4287a.getStringUtil(R.string.feedback_failure));
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$2 */
    class C14572 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4288a;

        C14572(FeedbackFragment this$0) {
            this.f4288a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            if (!this.f4288a.isAdded()) {
                return;
            }
            if (responseCode == 0) {
                FeedbackController.getInstance().startUploadFeedback(this.f4288a.f4320H, this.f4288a.f4317E, this.f4288a.f4318F, this.f4288a.f4313A, BaseFragment.getNaviActivity());
                return;
            }
            this.f4288a.m5342a(true);
            this.f4288a.m5366a(this.f4288a.getStringUtil(R.string.feedback_failure));
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$3 */
    class C14583 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4289a;
        /* renamed from: b */
        private long f4290b;

        C14583(FeedbackFragment this$0) {
            this.f4289a = this$0;
        }

        public void onClick(View v) {
            long curentTime = System.currentTimeMillis() / 1000;
            this.f4289a.f4317E = this.f4289a.f4324l.getText().toString().trim();
            this.f4289a.f4318F = this.f4289a.f4323k.getText().toString().trim();
            if (StringUtils.isEmpty(this.f4289a.f4317E)) {
                this.f4289a.f4324l.setText("");
                this.f4289a.m5366a(this.f4289a.getStringUtil(R.string.feedback_content_error));
            } else if (this.f4289a.f4317E.length() > 400) {
                this.f4289a.m5366a(this.f4289a.getStringUtil(R.string.feedback_content_max_length));
            } else if (StringUtils.isEmpty(this.f4289a.f4318F)) {
                this.f4289a.f4323k.setText("");
                this.f4289a.m5366a(this.f4289a.getStringUtil(R.string.feedback_email_hint_carmode));
            } else if (this.f4289a.f4318F.length() > 40) {
                TipTool.onCreateToastDialog(BaseFragment.mActivity, this.f4289a.getStringUtil(R.string.feedback_contact_max_length));
            } else if (NetworkUtils.mConnectState == 0) {
                TipTool.onCreateToastDialog(BaseFragment.mActivity, StyleManager.getString(R.string.network_unconnected));
            } else {
                this.f4290b = curentTime;
                this.f4289a.m5342a(false);
                String clientid = PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getString(CommonParams.jE, "");
                String appid = PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getString(CommonParams.jF, "");
                String deviceid = PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getString(CommonParams.jG, "");
                if (TextUtils.isEmpty(clientid) || TextUtils.isEmpty(appid) || TextUtils.isEmpty(deviceid)) {
                    C1643d feedBackRegisterRequest = new C1643d(this.f4289a.getStringUtil(R.string.app_name), BaseFragment.getNaviActivity());
                    feedBackRegisterRequest.registerResponseListener(this.f4289a.f4322a);
                    feedBackRegisterRequest.toPostRequest();
                    return;
                }
                FeedbackController.getInstance().startUploadFeedback(this.f4289a.f4320H, this.f4289a.f4317E, this.f4289a.f4318F, this.f4289a.f4313A, BaseFragment.getNaviActivity());
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$4 */
    class C14594 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4291a;

        C14594(FeedbackFragment this$0) {
            this.f4291a = this$0;
        }

        public void onClick(View v) {
            this.f4291a.onBackPressed();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$5 */
    class C14605 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4292a;

        C14605(FeedbackFragment this$0) {
            this.f4292a = this$0;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == R.id.edittext_content && this.f4292a.m5343a(this.f4292a.f4324l)) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$6 */
    class C14616 implements TextWatcher {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4293a;

        C14616(FeedbackFragment this$0) {
            this.f4293a = this$0;
        }

        public void afterTextChanged(Editable s) {
            if (s != null) {
                this.f4293a.f4331s.setText("" + s.length());
                if (s.length() > 400) {
                    this.f4293a.f4331s.setTextColor(C2188r.m8328a((int) R.color.cl_other_a_highlight));
                } else {
                    this.f4293a.f4331s.setTextColor(C2188r.m8328a((int) R.color.cl_text_a1));
                }
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$7 */
    class C14627 implements TextWatcher {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4294a;

        C14627(FeedbackFragment this$0) {
            this.f4294a = this$0;
        }

        public void afterTextChanged(Editable s) {
            if (this.f4294a.f4325m) {
                this.f4294a.f4325m = false;
                return;
            }
            boolean nOverMaxLength;
            int nSelStart = this.f4294a.f4323k.getSelectionStart();
            int nSelEnd = this.f4294a.f4323k.getSelectionEnd();
            if (s.length() > 40) {
                nOverMaxLength = true;
            } else {
                nOverMaxLength = false;
            }
            if (nOverMaxLength) {
                TipTool.onCreateToastDialog(BaseFragment.mActivity, R.string.feedback_contact_max_length);
                try {
                    s.delete(40, nSelEnd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String str = s.toString();
            boolean haveChinese = false;
            int length = s.length();
            int offset = 0;
            for (int i = 0; i < length; i++) {
                if (str.substring(i, i + 1).matches("[一-龥]")) {
                    haveChinese = true;
                    this.f4294a.f4325m = true;
                    try {
                        s.delete(i - offset, (i + 1) - offset);
                        offset++;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (haveChinese) {
                TipTool.onCreateToastDialog(BaseFragment.mActivity, R.string.feedback_contact_error);
            }
            this.f4294a.f4325m = false;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$8 */
    class C14638 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4295a;

        C14638(FeedbackFragment this$0) {
            this.f4295a = this$0;
        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$9 */
    class C14659 implements C1464a {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4296a;

        C14659(FeedbackFragment this$0) {
            this.f4296a = this$0;
        }

        /* renamed from: a */
        public void mo1555a(int pos) {
        }

        /* renamed from: b */
        public void mo1556b(int pos) {
        }

        /* renamed from: c */
        public void mo1557c(int pos) {
        }

        /* renamed from: d */
        public void mo1558d(int pos) {
        }

        /* renamed from: e */
        public void mo1559e(int pos) {
            if (pos == 0) {
                this.f4296a.m5367b();
            } else if (pos == 1) {
                this.f4296a.m5365a();
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.FeedbackFragment$a */
    public class C1469a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ FeedbackFragment f4303a;

        public C1469a(FeedbackFragment this$0) {
            this.f4303a = this$0;
        }

        public int getCount() {
            if (FeedbackController.getInstance().getmPicList() == null) {
                return 0;
            }
            this.f4303a.f4332t.setText((FeedbackController.getInstance().getmPicList().size() - 1) + "");
            return FeedbackController.getInstance().getmPicList().size();
        }

        public Object getItem(int position) {
            if (position < FeedbackController.getInstance().getmPicList().size()) {
                return FeedbackController.getInstance().getmPicList().get(position);
            }
            return null;
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            if (this.f4303a.f4316D == null) {
                this.f4303a.f4316D = LayoutInflater.from(this.f4303a.getContext());
            }
            if (position == FeedbackController.getInstance().getmPicList().size() - 1) {
                View addView = this.f4303a.f4316D.inflate(R.layout.carlife_feedback_gv_item_add, null);
                this.f4303a.f4329q = (ImageView) addView.findViewById(R.id.add);
                if (FeedbackController.getInstance().getmPicList().size() == 4) {
                    this.f4303a.f4329q.setVisibility(4);
                }
                this.f4303a.f4329q.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C1469a f4298b;

                    public void onClick(View v) {
                        if (FeedbackController.getInstance().getmPicList().size() != 4) {
                            this.f4298b.f4303a.showDialog(new C2288h(BaseFragment.mActivity, 4, position, this.f4298b.f4303a.f4321I));
                        }
                    }
                });
                return addView;
            }
            View picView = this.f4303a.f4316D.inflate(R.layout.carlife_feedback_gv_item_pic, null);
            ImageView picIBtn = (ImageView) picView.findViewById(R.id.pic);
            picIBtn.setImageBitmap((Bitmap) FeedbackController.getInstance().getmPicList().get(position));
            picIBtn.setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C1469a f4300b;

                public void onClick(View v) {
                    FeedbackController.getInstance().openPicSrc(BaseFragment.mActivity, position);
                }
            });
            picView.findViewById(R.id.delete).setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C1469a f4302b;

                public void onClick(View v) {
                    FeedbackController.getInstance().getmPicList().remove(position);
                    FeedbackController.getInstance().getmPicListPath().remove(position);
                    this.f4302b.f4303a.f4315C.notifyDataSetChanged();
                }
            });
            return picView;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FeedbackController.getInstance().getmPicList() == null || FeedbackController.getInstance().getmPicListPath() == null) {
            FeedbackController.getInstance().initPicList();
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.frag_carlife_feedback, null);
        setCommonTitleBar(this.mContentView, getString(R.string.feedback));
        m5339a(this.mContentView);
        return this.mContentView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        String content;
        String contact;
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            content = savedInstanceState.getString(f4306d);
            contact = savedInstanceState.getString(f4307e);
            if (!(TextUtils.isEmpty(savedInstanceState.getString(f4308f)) || TextUtils.isEmpty(content))) {
                this.f4313A = savedInstanceState.getString(f4308f);
            }
        } else {
            content = FeedbackController.getInstance().getmContent();
            contact = FeedbackController.getInstance().getmContact();
            if (!(TextUtils.isEmpty(FeedbackController.getInstance().getType()) || TextUtils.isEmpty(content))) {
                this.f4313A = FeedbackController.getInstance().getType();
            }
        }
        if (this.f4323k != null) {
            this.f4323k.setText(contact);
        }
        if (this.f4324l != null) {
            this.f4324l.setText(content);
        }
        if (this.f4331s != null) {
            if (content == null) {
                this.f4331s.setText("0");
            } else {
                this.f4331s.setText(content.length() + "");
            }
        }
        if (!(this.f4331s == null || content == null)) {
            if (content.length() > 400) {
                this.f4331s.setTextColor(C2188r.m8328a((int) R.color.cl_other_a_highlight));
            } else {
                this.f4331s.setTextColor(C2188r.m8328a((int) R.color.cl_text_a1));
            }
        }
        m5347b(this.f4313A);
        SpannableString contentString = new SpannableString(getStringUtil(R.string.carlife_feedback_content_hint));
        contentString.setSpan(new AbsoluteSizeSpan(18, true), 0, contentString.length(), 33);
        this.f4324l.setHint(contentString);
        SpannableString s = new SpannableString(getStringUtil(R.string.carlife_feedback_email_hint));
        s.setSpan(new AbsoluteSizeSpan(18, true), 0, s.length(), 33);
        this.f4323k.setHint(s);
        this.f4319G = AnimationUtils.loadAnimation(getNaviActivity(), R.anim.feedback_btn_commit);
        this.f4319G.setInterpolator(new LinearInterpolator());
    }

    /* renamed from: a */
    private void m5339a(View view) {
        this.f4326n = (RelativeLayout) view.findViewById(R.id.feedback_commit);
        this.f4327o = (TextView) view.findViewById(R.id.feedback_commit_tv);
        this.f4328p = (ImageView) view.findViewById(R.id.feedback_commit_iv);
        this.f4324l = (EditText) view.findViewById(R.id.edittext_content);
        this.f4323k = (EditText) view.findViewById(R.id.edittext_email);
        this.f4333u = (LinearLayout) view.findViewById(R.id.feedback_linear_function_exection);
        this.f4334v = (LinearLayout) view.findViewById(R.id.feedback_linear_function_suggest);
        this.f4335w = (LinearLayout) view.findViewById(R.id.feedback_linear_other_question);
        this.f4336x = (ImageView) view.findViewById(R.id.feedback_iv_function_exection);
        this.f4337y = (ImageView) view.findViewById(R.id.feedback_iv_function_suggest);
        this.f4338z = (ImageView) view.findViewById(R.id.feedback_iv_other_question);
        this.f4330r = (ImageButton) view.findViewById(R.id.ib_left);
        this.f4331s = (TextView) view.findViewById(R.id.calife_edittext_content_num_count);
        this.f4332t = (TextView) view.findViewById(R.id.feedback_image_count);
        this.f4314B = (GridView) view.findViewById(R.id.gridView);
        if (FeedbackController.getInstance().getmPicList().isEmpty()) {
            FeedbackController.getInstance().getmPicList().add(null);
        }
        this.f4315C = new C1469a(this);
        this.f4314B.setAdapter(this.f4315C);
        this.f4323k.clearFocus();
    }

    protected void onInitView() {
        m5351c();
        m5355e();
    }

    /* renamed from: c */
    private void m5351c() {
        OnClickListener commitBtnListener = new C14583(this);
        OnClickListener backBtnListener = new C14594(this);
        this.f4324l.setOnTouchListener(new C14605(this));
        this.f4330r.setOnClickListener(backBtnListener);
        this.f4326n.setOnClickListener(commitBtnListener);
        this.f4333u.setOnClickListener(this);
        this.f4334v.setOnClickListener(this);
        this.f4335w.setOnClickListener(this);
    }

    /* renamed from: a */
    private void m5342a(boolean clickable) {
        if (clickable) {
            this.f4326n.setClickable(true);
            this.f4327o.setText(getStringUtil(R.string.feedback_commit));
            this.f4328p.clearAnimation();
            this.f4328p.setVisibility(8);
            return;
        }
        this.f4326n.setClickable(false);
        this.f4327o.setText(getStringUtil(R.string.feedback_commiting));
        this.f4328p.startAnimation(this.f4319G);
        this.f4328p.setVisibility(0);
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
        this.mContentView.findViewById(R.id.edittext_content_layout).setBackground(C2188r.m8331b(R.drawable.bnav_feedback_bg));
        EditText contentET = (EditText) this.mContentView.findViewById(R.id.edittext_content);
        contentET.setHintTextColor(C2188r.m8328a((int) R.color.cl_text_a1));
        contentET.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
        ((TextView) this.mContentView.findViewById(R.id.calife_edittext_content_num_amount)).setTextColor(C2188r.m8328a((int) R.color.cl_text_a1));
        if (FeedbackController.getInstance().getmContent() == null || FeedbackController.getInstance().getmContent().length() <= 400) {
            this.f4331s.setTextColor(C2188r.m8328a((int) R.color.cl_text_a1));
        } else {
            this.f4331s.setTextColor(C2188r.m8328a((int) R.color.cl_other_a_highlight));
        }
        this.mContentView.findViewById(R.id.pic_layout).setBackground(C2188r.m8331b(R.drawable.bnav_feedback_bg));
        EditText contactET = (EditText) this.mContentView.findViewById(R.id.edittext_email);
        contactET.setBackground(C2188r.m8331b(R.drawable.bnav_feedback_bg));
        contactET.setHintTextColor(C2188r.m8328a((int) R.color.cl_text_a1));
        contactET.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
        ((RelativeLayout) this.mContentView.findViewById(R.id.feedback_commit)).setBackground(C2188r.m8331b(R.drawable.com_bg_btn_submit_selector));
        ((TextView) this.mContentView.findViewById(R.id.feedback_commit_tv)).setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_bgtext));
    }

    public boolean onBackPressed() {
        mActivity.m3117m();
        m5353d();
        m5357f();
        back(null);
        return true;
    }

    /* renamed from: d */
    private void m5353d() {
        if (this.f4324l != null) {
            FeedbackController.getInstance().setmContent(this.f4324l.getText().toString().trim());
        }
        if (this.f4323k != null) {
            FeedbackController.getInstance().setmContact(this.f4323k.getText().toString().trim());
        }
        FeedbackController.getInstance().setType(this.f4313A);
    }

    public void onSaveInstanceState(Bundle outState) {
        if (!(this.f4323k == null || this.f4324l == null)) {
            outState.putString(f4306d, this.f4324l.getText().toString().trim());
            outState.putString(f4307e, this.f4323k.getText().toString().trim());
            outState.putString(f4308f, this.f4313A);
        }
        super.onSaveInstanceState(outState);
    }

    /* renamed from: e */
    private void m5355e() {
        TextWatcher mContentTextWatcher = new C14616(this);
        TextWatcher mContactTextWatcher = new C14627(this);
        this.f4324l.addTextChangedListener(mContentTextWatcher);
        this.f4323k.addTextChangedListener(mContactTextWatcher);
        this.f4323k.setOnClickListener(new C14638(this));
    }

    protected void onUpdateOrientation(int orientation) {
        if (mActivity != null) {
        }
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    /* renamed from: a */
    public void m5365a() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        try {
            startActivityForResult(intent, 4610);
        } catch (ActivityNotFoundException e) {
            C2201w.m8373a("您的手机没有图库应用", 0);
        }
    }

    /* renamed from: b */
    public void m5367b() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (FeedbackController.getInstance().hasSdcard()) {
            FeedbackController.getInstance().setTempFile(new File(Environment.getExternalStorageDirectory(), UUID.randomUUID().toString() + BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX));
            intent.putExtra("output", FileProvider.getUriForFile(getNaviActivity(), "com.baidu.carlife.fileprovider", FeedbackController.getInstance().getTempFile()));
        }
        try {
            startActivityForResult(intent, 4609);
        } catch (ActivityNotFoundException e) {
            C2201w.m8373a("您的手机没有摄像应用", 0);
        }
    }

    /* renamed from: f */
    private void m5357f() {
        FeedbackController.getInstance().getmPicList().clear();
        FeedbackController.getInstance().getmPicList().add(null);
        FeedbackController.getInstance().getmPicListPath().clear();
        if (this.f4315C != null) {
            this.f4315C.notifyDataSetChanged();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String picturePath = FeedbackController.getInstance().getBitmapFilePath(mActivity, requestCode, resultCode, data);
        Bitmap bmp = FeedbackController.getInstance().getBitmapByOpt(picturePath);
        if (bmp != null) {
            FeedbackController.getInstance().getmPicList().add(0, bmp);
            FeedbackController.getInstance().getmPicListPath().add(0, picturePath);
            this.f4315C.notifyDataSetChanged();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.feedback_linear_function_exection:
                this.f4313A = f4309g;
                m5340a(this.f4336x);
                return;
            case R.id.feedback_linear_function_suggest:
                this.f4313A = f4310h;
                m5340a(this.f4337y);
                return;
            case R.id.feedback_linear_other_question:
                this.f4313A = f4311i;
                m5340a(this.f4338z);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m5347b(String type) {
        if (f4310h.equals(type)) {
            m5340a(this.f4337y);
        } else if (f4311i.equals(type)) {
            m5340a(this.f4338z);
        } else {
            m5340a(this.f4336x);
        }
    }

    /* renamed from: a */
    private void m5340a(ImageView imageView) {
        this.f4338z.setBackgroundResource(R.drawable.com_ic_radiobuttion_unselected);
        this.f4337y.setBackgroundResource(R.drawable.com_ic_radiobuttion_unselected);
        this.f4336x.setBackgroundResource(R.drawable.com_ic_radiobuttion_unselected);
        imageView.setBackgroundResource(R.drawable.com_ic_radiobuttion_selected);
    }

    public void driving() {
        LogUtil.d("yftech", "FeedbackFragment driving");
        getNaviFragmentManager().back();
        getNaviFragmentManager().back();
        C1342a.m4926a().m4931d();
    }

    /* renamed from: a */
    public void m5366a(String msg) {
        showDialog(new C1953c(mActivity).m7444b(msg).m7457g(17).m7447c((int) R.string.alert_close));
    }

    public void stopDriving() {
    }

    /* renamed from: a */
    private boolean m5343a(EditText editText) {
        int scrollY = editText.getScrollY();
        int scrollDifference = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
        if (scrollDifference == 0) {
            return false;
        }
        if (scrollY > 0 || scrollY < scrollDifference - 1) {
            return true;
        }
        return false;
    }
}
