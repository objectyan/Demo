package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p248b.C5170c;
import com.baidu.ufosdk.p250d.C5176a;
import com.baidu.ufosdk.util.C5208a;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5223p;
import com.baidu.ufosdk.util.C5225r;
import com.baidu.ufosdk.util.C5228u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
@TargetApi(11)
public class FeedbackFacePageActivity extends Activity {
    /* renamed from: A */
    private EditText f21402A;
    /* renamed from: B */
    private LinearLayout f21403B;
    /* renamed from: C */
    private TextView f21404C;
    /* renamed from: D */
    private TextView f21405D;
    /* renamed from: E */
    private RelativeLayout f21406E;
    /* renamed from: F */
    private LinearLayout f21407F;
    /* renamed from: G */
    private TextView f21408G;
    /* renamed from: H */
    private LinearLayout f21409H;
    /* renamed from: a */
    Runnable f21410a = new C5182a(this);
    /* renamed from: b */
    private Editor f21411b;
    /* renamed from: c */
    private SharedPreferences f21412c;
    /* renamed from: d */
    private String f21413d = "";
    /* renamed from: e */
    private String f21414e = "";
    /* renamed from: f */
    private String f21415f = "";
    /* renamed from: g */
    private RelativeLayout f21416g;
    /* renamed from: h */
    private LinearLayout f21417h;
    /* renamed from: i */
    private ImageView f21418i;
    /* renamed from: j */
    private Button f21419j;
    /* renamed from: k */
    private Button f21420k;
    /* renamed from: l */
    private TextView f21421l;
    /* renamed from: m */
    private TextView f21422m;
    /* renamed from: n */
    private RelativeLayout f21423n;
    /* renamed from: o */
    private View f21424o;
    /* renamed from: p */
    private WebView f21425p;
    /* renamed from: q */
    private Timer f21426q;
    /* renamed from: r */
    private TextView f21427r;
    /* renamed from: s */
    private String f21428s;
    /* renamed from: t */
    private boolean f21429t = false;
    /* renamed from: u */
    private boolean f21430u = false;
    /* renamed from: v */
    private ListView f21431v;
    /* renamed from: w */
    private C5205x f21432w;
    /* renamed from: x */
    private ArrayList f21433x = new ArrayList();
    /* renamed from: y */
    private ArrayList f21434y = new ArrayList();
    @SuppressLint({"HandlerLeak"})
    /* renamed from: z */
    private Handler f21435z = new C5194m(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        getWindow().setSoftInputMode(32);
        try {
            this.f21412c = getSharedPreferences("UfoSharePreference", 0);
            if (this.f21412c != null) {
                this.f21411b = this.f21412c.edit();
            }
            if (this.f21411b != null) {
                this.f21411b.putBoolean("ADD_PIC_FLAG", true);
                this.f21411b.commit();
            }
            C5167a.f21362h = getIntent().getIntExtra("feedback_channel", 0);
            C5167a.f21363i = getIntent().getIntExtra("faq_channel", 0);
            this.f21415f = getIntent().getStringExtra("faq_id");
            this.f21428s = getIntent().getStringExtra("msgid");
            if (TextUtils.isEmpty(this.f21428s)) {
                this.f21428s = "newMessage";
            }
            if (TextUtils.isEmpty(this.f21415f)) {
                this.f21415f = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f21416g = new RelativeLayout(this);
        this.f21416g.setId(C0965R.array.feedback_image);
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(C0965R.string.alert_cancel);
        this.f21416g.setBackgroundColor(C5167a.f21379y);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams3.setMargins(C5216i.m17757a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.f21418i = new ImageView(this);
        this.f21418i.setId(C0965R.array.carlife_setting_name_elh);
        this.f21418i.setScaleType(ScaleType.CENTER_CROP);
        this.f21418i.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_back_icon.png")));
        linearLayout.addView(this.f21418i, layoutParams3);
        View textView = new TextView(this);
        textView.setText(C5167a.f21361g);
        textView.setTextSize(C5167a.f21339K);
        textView.setTextColor(C5167a.f21332D);
        textView.setGravity(16);
        ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, 0, C5216i.m17757a(getApplicationContext(), 8.0f), 0);
        linearLayout.addView(textView, layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = new LayoutParams(-2, -2);
        layoutParams5.addRule(9);
        layoutParams5.addRule(15);
        relativeLayout.addView(linearLayout, layoutParams5);
        this.f21421l = new TextView(this);
        this.f21421l.setId(C0965R.array.carlife_setting_name_usb);
        this.f21421l.setText(C5228u.m17794a("7"));
        this.f21421l.setTextColor(C5167a.f21373s);
        this.f21421l.setTextSize(C5167a.f21346R);
        this.f21421l.setGravity(17);
        layoutParams5 = new LayoutParams(-2, -1);
        layoutParams5.addRule(13);
        relativeLayout.addView(this.f21421l, layoutParams5);
        this.f21419j = new Button(this);
        this.f21419j.setText(C5228u.m17794a(PerformStatItem.RP_SUCCESS_NORMAL_STEP_INDEX));
        this.f21419j.setId(C0965R.string.alert_close);
        this.f21419j.setTextColor(C5167a.f21374t);
        this.f21419j.setTextSize(C5167a.f21347S);
        this.f21419j.setGravity(17);
        this.f21419j.setTextColor(C5216i.m17759a(C5167a.f21374t, C5167a.f21375u, C5167a.f21374t, C5167a.f21374t));
        this.f21419j.setBackgroundColor(16777215);
        this.f21419j.setPadding(C5216i.m17757a(getApplicationContext(), 8.0f), 0, C5216i.m17757a(getApplicationContext(), 8.0f), 0);
        layoutParams5 = new LayoutParams(-2, -2);
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        layoutParams5.setMargins(0, 0, C5216i.m17757a(getApplicationContext(), 10.0f), 0);
        relativeLayout.addView(this.f21419j, layoutParams5);
        this.f21422m = new TextView(this);
        layoutParams3 = new LayoutParams(C5216i.m17757a(getApplicationContext(), 9.0f), C5216i.m17757a(getApplicationContext(), 9.0f));
        this.f21422m.setTextColor(-1);
        this.f21422m.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_newmsg_flag.png")));
        this.f21422m.setGravity(17);
        this.f21422m.setVisibility(8);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(0, C5216i.m17757a(getApplicationContext(), 13.0f), C5216i.m17757a(getApplicationContext(), 14.0f), 0);
        relativeLayout.addView(this.f21422m, layoutParams3);
        try {
            relativeLayout.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_nav_bg.png")));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        layoutParams5 = new LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams5.addRule(10);
        this.f21416g.addView(relativeLayout, layoutParams5);
        View relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setId(C0965R.string.alert_clean);
        relativeLayout2.setBackgroundColor(C5167a.f21379y);
        float a = (float) C5216i.m17757a(getApplicationContext(), 4.0f);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(a);
        gradientDrawable.setStroke(1, -2500135);
        this.f21406E = new RelativeLayout(this);
        this.f21406E.setId(C0965R.array.nsdk_cruise_camera_slop_names);
        this.f21406E.setClickable(true);
        this.f21406E.setVisibility(0);
        this.f21406E.setGravity(17);
        this.f21406E.setBackgroundDrawable(gradientDrawable);
        gradientDrawable = new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_search_icon.png"));
        gradientDrawable.setBounds(0, 0, C5216i.m17757a(getApplicationContext(), 12.0f), C5216i.m17757a(getApplicationContext(), 12.0f));
        View imageView = new ImageView(this);
        imageView.setId(C0965R.array.space_catalog_id_life);
        imageView.setBackgroundDrawable(gradientDrawable);
        ViewGroup.LayoutParams layoutParams6 = new LayoutParams(C5216i.m17757a(getApplicationContext(), 12.0f), C5216i.m17757a(getApplicationContext(), 12.0f));
        layoutParams6.addRule(13);
        layoutParams6.setMargins(0, 0, C5216i.m17757a(getApplicationContext(), 5.0f), 0);
        this.f21406E.addView(imageView, layoutParams6);
        View textView2 = new TextView(this);
        textView2.setId(C0965R.array.person_ctrl_menu_item);
        textView2.setVisibility(0);
        textView2.setClickable(true);
        textView2.setText("搜索");
        textView2.setTextColor(-10066330);
        textView2.setTextSize(13.0f);
        textView2.setGravity(16);
        ViewGroup.LayoutParams layoutParams7 = new LayoutParams(-2, -2);
        layoutParams7.addRule(13);
        layoutParams7.addRule(1, imageView.getId());
        this.f21406E.addView(textView2, layoutParams7);
        ViewGroup.LayoutParams layoutParams8 = new LayoutParams(-1, -1);
        layoutParams8.addRule(13);
        relativeLayout2.addView(this.f21406E, layoutParams8);
        this.f21409H = new LinearLayout(this);
        this.f21409H.setBackgroundColor(0);
        this.f21409H.setOrientation(0);
        this.f21409H.setGravity(17);
        this.f21409H.setVisibility(8);
        this.f21402A = new EditText(this);
        this.f21402A.setId(C0965R.array.space_catalog_name_main);
        this.f21402A.setHint("请输入内容");
        this.f21402A.setHintTextColor(-3355444);
        this.f21402A.setTextSize(11.0f);
        this.f21402A.setGravity(16);
        this.f21402A.setBackgroundColor(-1);
        this.f21402A.setCompoundDrawables(gradientDrawable, null, null, null);
        this.f21402A.setCompoundDrawablePadding(10);
        this.f21402A.setPadding(C5216i.m17757a(getApplicationContext(), 7.0f), 0, 0, 0);
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(a);
        gradientDrawable.setStroke(1, -2500135);
        this.f21402A.setBackgroundDrawable(gradientDrawable);
        layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.f21409H.addView(this.f21402A, layoutParams5);
        this.f21405D = new TextView(this);
        this.f21405D.setText("取消");
        this.f21405D.setId(C0965R.string.alert_continue_last_navi_tips);
        this.f21405D.setTextColor(C5167a.f21377w);
        this.f21405D.setTextSize(13.0f);
        this.f21405D.setGravity(17);
        this.f21405D.setTextColor(C5216i.m17759a(C5167a.f21377w, C5167a.f21375u, C5167a.f21377w, C5167a.f21377w));
        this.f21405D.setBackgroundColor(0);
        this.f21405D.setPadding(C5216i.m17757a(getApplicationContext(), 5.0f), 0, 0, 0);
        layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 5.0f;
        this.f21409H.addView(this.f21405D, layoutParams5);
        layoutParams5 = new LayoutParams(-1, -1);
        layoutParams5.addRule(13);
        relativeLayout2.addView(this.f21409H, layoutParams5);
        this.f21406E.setOnClickListener(new C5195n(this));
        this.f21405D.setOnClickListener(new C5196o(this));
        a = 30.0f;
        if (C5216i.m17756a() < 14) {
            a = 35.0f;
        }
        layoutParams3 = new LayoutParams(-1, C5216i.m17757a(getApplicationContext(), a));
        layoutParams3.setMargins(C5216i.m17757a(getApplicationContext(), 8.0f), C5216i.m17757a(getApplicationContext(), 5.0f), C5216i.m17757a(getApplicationContext(), 8.0f), C5216i.m17757a(getApplicationContext(), 5.0f));
        layoutParams3.addRule(3, relativeLayout.getId());
        this.f21416g.addView(relativeLayout2, layoutParams3);
        textView = new View(this);
        textView.setId(C0965R.string.alert_disclaimer);
        textView.setBackgroundColor(-3355444);
        ViewGroup.LayoutParams layoutParams9 = new LayoutParams(-1, 1);
        layoutParams9.addRule(3, relativeLayout2.getId());
        this.f21416g.addView(textView, layoutParams9);
        this.f21403B = new LinearLayout(this);
        this.f21403B.setBackgroundColor(-723724);
        this.f21403B.setVisibility(8);
        this.f21403B.setOrientation(1);
        this.f21431v = new ListView(this);
        this.f21431v.setSelector(new ColorDrawable(0));
        this.f21431v.setCacheColorHint(-1);
        this.f21431v.setDivider(new ColorDrawable(-3355444));
        this.f21431v.setDividerHeight(1);
        this.f21403B.addView(this.f21431v, new LinearLayout.LayoutParams(-1, -1));
        layoutParams9 = new LayoutParams(-1, -1);
        layoutParams9.addRule(3, textView.getId());
        layoutParams9.addRule(12);
        this.f21416g.addView(this.f21403B, layoutParams9);
        this.f21404C = new TextView(this);
        this.f21404C.setVisibility(8);
        this.f21404C.setTextSize(13.0f);
        this.f21404C.setClickable(true);
        this.f21404C.setGravity(17);
        layoutParams9 = new LayoutParams(-2, -2);
        layoutParams9.addRule(13);
        this.f21416g.addView(this.f21404C, layoutParams9);
        this.f21404C.setOnClickListener(new C5197p(this));
        this.f21432w = new C5205x(this, this);
        this.f21431v.setAdapter(this.f21432w);
        this.f21431v.setOnItemClickListener(new C5199r(this));
        this.f21431v.setOnScrollListener(new C5200s(this));
        this.f21402A.addTextChangedListener(new C5201t(this));
        this.f21402A.setOnFocusChangeListener(new C5202u(this));
        this.f21408G = new TextView(this);
        this.f21408G.setId(C0965R.array.home_discovery_closenavi_etcp);
        this.f21408G.setText("常见问题");
        this.f21408G.setTextColor(-10066330);
        this.f21408G.setTextSize(15.0f);
        this.f21408G.setGravity(16);
        this.f21408G.setPadding(C5216i.m17757a(getApplicationContext(), 10.0f), 0, 0, 0);
        layoutParams9 = new LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 35.0f));
        layoutParams9.addRule(3, textView.getId());
        this.f21416g.addView(this.f21408G, layoutParams9);
        textView = new View(this);
        textView.setId(C0965R.string.alert_engine_init_failed);
        textView.setBackgroundColor(-3355444);
        layoutParams9 = new LayoutParams(-1, 1);
        layoutParams9.addRule(3, this.f21408G.getId());
        this.f21416g.addView(textView, layoutParams9);
        this.f21407F = new LinearLayout(this);
        this.f21407F.setId(C0965R.string.alert_exit_cur_navi);
        this.f21407F.setOrientation(0);
        this.f21407F.setBackgroundColor(-526345);
        relativeLayout = new LinearLayout(this);
        relativeLayout.setOrientation(1);
        relativeLayout.setGravity(1);
        relativeLayout.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        relativeLayout.setClickable(true);
        relativeLayout2 = new TextView(this);
        relativeLayout2.setText("全部问题");
        relativeLayout2.setTextColor(C5167a.f21375u);
        relativeLayout2.setTextSize(C5167a.ac);
        relativeLayout2.setGravity(16);
        gradientDrawable = new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_all_pro_icon.png"));
        gradientDrawable.setBounds(0, 0, C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 18.0f));
        relativeLayout2.setCompoundDrawables(gradientDrawable, null, null, null);
        relativeLayout2.setCompoundDrawablePadding(C5216i.m17757a(getApplicationContext(), 8.0f));
        relativeLayout.addView(relativeLayout2, new LinearLayout.LayoutParams(-2, -1));
        relativeLayout2 = new LinearLayout(this);
        relativeLayout2.setOrientation(1);
        relativeLayout2.setGravity(1);
        relativeLayout2.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        relativeLayout2.setClickable(true);
        View textView3 = new TextView(this);
        textView3.setText("我要反馈");
        textView3.setTextColor(C5167a.f21375u);
        textView3.setTextSize(C5167a.ac);
        textView3.setGravity(16);
        Drawable bitmapDrawable = new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_feedback_icon.png"));
        bitmapDrawable.setBounds(0, 0, C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 18.0f));
        textView3.setCompoundDrawables(bitmapDrawable, null, null, null);
        textView3.setCompoundDrawablePadding(C5216i.m17757a(getApplicationContext(), 8.0f));
        relativeLayout2.addView(textView3, new LinearLayout.LayoutParams(-2, -1));
        layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.weight = 1.0f;
        this.f21407F.addView(relativeLayout, layoutParams3);
        textView3 = new View(this);
        layoutParams8 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 0.8f), -1);
        layoutParams8.setMargins(0, C5216i.m17757a(getApplicationContext(), 8.0f), 0, C5216i.m17757a(getApplicationContext(), 8.0f));
        textView3.setBackgroundColor(-6710887);
        this.f21407F.addView(textView3, layoutParams8);
        layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.weight = 1.0f;
        this.f21407F.addView(relativeLayout2, layoutParams3);
        layoutParams3 = new LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams3.addRule(12);
        this.f21416g.addView(this.f21407F, layoutParams3);
        relativeLayout.setOnClickListener(new C5183b(this));
        relativeLayout2.setOnClickListener(new C5184c(this));
        linearLayout.setOnClickListener(new C5186e(this));
        this.f21419j.setOnClickListener(new C5187f(this));
        int id = textView.getId();
        int id2 = this.f21407F.getId();
        this.f21423n = new RelativeLayout(this);
        this.f21423n.setLayoutParams(new LayoutParams(-1, -1));
        this.f21417h = new LinearLayout(this);
        this.f21417h.setOrientation(1);
        this.f21417h.setGravity(17);
        this.f21417h.setVisibility(8);
        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        relativeLayout2 = new ImageView(this);
        layoutParams8 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 115.0f), C5216i.m17757a(getApplicationContext(), 101.0f));
        try {
            relativeLayout2.setBackgroundDrawable(C5225r.m17786a(getApplicationContext(), "ufo_no_netwrok.png"));
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        this.f21417h.addView(relativeLayout2, layoutParams8);
        this.f21427r = new TextView(this);
        this.f21427r.setPadding(C5216i.m17757a(getApplicationContext(), 10.0f), C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 10.0f), C5216i.m17757a(getApplicationContext(), 11.0f));
        this.f21427r.setTextSize(C5167a.f21341M);
        this.f21427r.setTextColor(-10066330);
        layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        C5216i.m17762a(getApplicationContext(), this.f21427r);
        this.f21417h.addView(this.f21427r, layoutParams5);
        this.f21420k = new Button(this);
        this.f21420k.setText(C5228u.m17794a("22"));
        this.f21420k.setTextSize(C5167a.f21342N);
        this.f21420k.setTextColor(-13421773);
        try {
            this.f21420k.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        } catch (Exception e222) {
            e222.printStackTrace();
        }
        this.f21417h.addView(this.f21420k, new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 122.0f), C5216i.m17757a(getApplicationContext(), 40.0f)));
        layoutParams5 = new LayoutParams(-2, -2);
        layoutParams5.addRule(13);
        this.f21423n.addView(this.f21417h, layoutParams5);
        this.f21420k.setOnClickListener(new C5188g(this));
        textView = new LinearLayout(this);
        textView.setOrientation(0);
        textView.setGravity(16);
        layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        this.f21425p = new WebView(this);
        if (Integer.parseInt(VERSION.SDK) >= 11) {
            this.f21425p.setLayerType(1, null);
        }
        textView.addView(this.f21425p, layoutParams4);
        this.f21423n.addView(textView, new LayoutParams(-1, -1));
        this.f21424o = C5216i.m17765b(this, C5228u.m17794a("13"));
        layoutParams5 = new LayoutParams(-2, -2);
        layoutParams5.addRule(13);
        this.f21423n.addView(this.f21424o, layoutParams5);
        layoutParams5 = new LayoutParams(-1, -1);
        layoutParams5.addRule(3, id);
        layoutParams5.addRule(2, id2);
        this.f21416g.addView(this.f21423n, layoutParams5);
        this.f21425p.getSettings().setJavaScriptEnabled(true);
        this.f21425p.getSettings().setRenderPriority(RenderPriority.HIGH);
        try {
            this.f21425p.getClass().getMethod("removeJavascriptInterface", new Class[]{String.class});
            this.f21425p.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f21425p.removeJavascriptInterface("accessibility");
            this.f21425p.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e3) {
            C5210c.m17732a("webView : This API level do not support `removeJavascriptInterface`");
        }
        if (C5170c.m17557b(getApplicationContext()).contains("UNKNOWN") || C5170c.m17557b(getApplicationContext()).contains("NONE")) {
            this.f21425p.getSettings().setCacheMode(1);
            if (this.f21412c.getBoolean("CHECK_WEBVIEW", true)) {
                C5216i.m17762a(getApplicationContext(), this.f21427r);
                this.f21417h.setVisibility(0);
                this.f21425p.setVisibility(8);
            }
            this.f21424o.setVisibility(8);
        } else {
            this.f21411b.putBoolean("CHECK_WEBVIEW", false);
            this.f21411b.commit();
            this.f21417h.setVisibility(8);
            this.f21425p.setVisibility(0);
            this.f21425p.getSettings().setCacheMode(-1);
        }
        this.f21425p.getSettings().setAppCacheMaxSize(8388608);
        String stringBuilder = new StringBuilder(String.valueOf(getFilesDir().getAbsolutePath())).append("/UfoCacheFile").toString();
        File file = new File(stringBuilder);
        C5210c.m17734b("cacheDirPath=" + stringBuilder);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f21425p.getSettings().setBlockNetworkImage(false);
        this.f21425p.getSettings().setDatabaseEnabled(true);
        this.f21425p.getSettings().setDomStorageEnabled(true);
        this.f21425p.getSettings().setDatabasePath(stringBuilder);
        this.f21425p.getSettings().setAppCachePath(stringBuilder);
        this.f21425p.getSettings().setAppCacheEnabled(true);
        this.f21425p.getSettings().setAppCacheMaxSize(10);
        this.f21425p.getSettings().setAllowFileAccess(true);
        this.f21425p.setWebViewClient(new C5207z());
        this.f21425p.setWebChromeClient(new C5176a("ufo", UfoJavaScriptInterface.class));
        setContentView(this.f21416g);
        if (UfoSDK.clientid.length() != 0 || UfoSDK.clientid == null) {
            m17585b();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.f21429t = true;
        if (!this.f21430u) {
            m17588c();
        } else if (UfoSDK.clientid.length() != 0) {
            this.f21403B.setVisibility(8);
            this.f21409H.setVisibility(8);
            this.f21406E.setVisibility(0);
            this.f21402A.setFocusable(false);
            this.f21402A.setFocusableInTouchMode(false);
            if (!(getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null)) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            this.f21435z.obtainMessage(2, null).sendToTarget();
            this.f21407F.setVisibility(0);
            this.f21408G.setText("常用问题");
            C5210c.m17734b("onKeyDown-->handler.obtainMessage(2");
        }
        return true;
    }

    protected void onStop() {
        super.onStop();
    }

    /* renamed from: b */
    private void m17585b() {
        if (UfoSDK.clientid.length() != 0) {
            this.f21435z.obtainMessage(2, null).sendToTarget();
        }
    }

    protected void onRestart() {
        super.onRestart();
        this.f21404C.setVisibility(8);
        this.f21425p.setVisibility(0);
    }

    protected void onStart() {
        super.onStart();
        this.f21404C.setVisibility(8);
        this.f21425p.setVisibility(0);
    }

    protected void onResume() {
        super.onResume();
        String editable = this.f21402A.getText().toString();
        if (editable == null || editable.length() == 0) {
            this.f21404C.setVisibility(8);
        }
        this.f21425p.setVisibility(0);
        if (C5167a.ah != null) {
            C5167a.ah.onResumeCallback();
        }
        this.f21421l.setText(C5228u.m17794a("7"));
        this.f21419j.setText(C5228u.m17794a(PerformStatItem.RP_SUCCESS_NORMAL_STEP_INDEX));
        C5216i.m17762a(getApplicationContext(), this.f21427r);
        this.f21420k.setText(C5228u.m17794a("22"));
        C5216i.m17763a((RelativeLayout) this.f21424o, C5228u.m17794a("13"));
        this.f21419j.setTextSize(C5167a.f21347S);
        if (this.f21428s == null) {
            this.f21428s = "newMessage";
        } else if (this.f21428s.length() == 0) {
            this.f21428s = "newMessage";
        }
        this.f21425p.resumeTimers();
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new C5191j(this)).start();
        } else {
            new Thread(new C5192k(this)).start();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        C5208a.f21687a = null;
    }

    /* renamed from: a */
    public final void m17610a() {
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(getApplicationContext(), C5228u.m17794a("18"), 1).show();
            String b = C5170c.m17557b(getApplicationContext());
            boolean contains = b.contains("UNKNOWN");
            boolean contains2 = b.contains("NONE");
            if (!contains || contains2) {
                new Thread(new C5193l(this)).start();
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        intent.putExtra("url", this.f21413d);
        intent.putExtra("feedback_channel", C5167a.f21362h);
        intent.putExtra("extra", this.f21414e);
        intent.setClass(this, FeedbackListActivity.class);
        startActivity(intent);
    }

    /* renamed from: c */
    private void m17588c() {
        getApplicationContext();
        new C5204w(this).execute(new Void[0]);
    }

    /* renamed from: a */
    static /* synthetic */ void m17580a(FeedbackFacePageActivity feedbackFacePageActivity, ArrayList arrayList, String str) {
        Iterator it = feedbackFacePageActivity.f21433x.iterator();
        while (it.hasNext()) {
            dc dcVar = (dc) it.next();
            if (dcVar.f21661b.contains(str)) {
                arrayList.add(dcVar);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m17582a(FeedbackFacePageActivity feedbackFacePageActivity, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(C2125n.f6746N);
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String valueOf = String.valueOf(keys.next());
                JSONArray jSONArray = (JSONArray) jSONObject2.get(valueOf);
                dc dcVar = new dc(valueOf, jSONArray.getString(0), jSONArray.getString(1));
                feedbackFacePageActivity.f21433x.add(dcVar);
                feedbackFacePageActivity.f21434y.add(dcVar);
            }
            feedbackFacePageActivity.f21435z.obtainMessage(17).sendToTarget();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
