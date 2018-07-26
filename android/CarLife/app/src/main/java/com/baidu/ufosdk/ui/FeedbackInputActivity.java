package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Html.ImageGetter;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p247a.C5165a;
import com.baidu.ufosdk.p248b.C5168a;
import com.baidu.ufosdk.p248b.C5170c;
import com.baidu.ufosdk.p248b.C5171d;
import com.baidu.ufosdk.p248b.C5172e;
import com.baidu.ufosdk.p249c.C5174a;
import com.baidu.ufosdk.p251e.C5181b;
import com.baidu.ufosdk.util.C5208a;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5211d;
import com.baidu.ufosdk.util.C5215h;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5219l;
import com.baidu.ufosdk.util.C5220m;
import com.baidu.ufosdk.util.C5223p;
import com.baidu.ufosdk.util.C5225r;
import com.baidu.ufosdk.util.C5226s;
import com.baidu.ufosdk.util.C5227t;
import com.baidu.ufosdk.util.C5228u;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"NewApi", "HandlerLeak"})
public class FeedbackInputActivity extends Activity {
    /* renamed from: a */
    public static ArrayList f21455a;
    /* renamed from: b */
    public static Bitmap f21456b;
    /* renamed from: A */
    private final int f21457A = C0965R.menu.base;
    /* renamed from: B */
    private final int f21458B = C0965R.menu.main;
    /* renamed from: C */
    private final int f21459C = 2131755010;
    /* renamed from: D */
    private Intent f21460D;
    /* renamed from: E */
    private LinearLayout f21461E;
    /* renamed from: F */
    private LinearLayout f21462F;
    /* renamed from: G */
    private LinearLayout f21463G;
    /* renamed from: H */
    private RelativeLayout f21464H;
    /* renamed from: I */
    private ImageView f21465I;
    /* renamed from: J */
    private Button f21466J;
    /* renamed from: K */
    private LinearLayout f21467K;
    /* renamed from: L */
    private String f21468L = "";
    /* renamed from: M */
    private String f21469M = "";
    /* renamed from: N */
    private C5165a f21470N;
    /* renamed from: O */
    private List f21471O = new ArrayList();
    /* renamed from: P */
    private ListView f21472P;
    /* renamed from: Q */
    private br f21473Q;
    /* renamed from: R */
    private View f21474R;
    /* renamed from: S */
    private ExecutorService f21475S;
    /* renamed from: T */
    private View f21476T;
    /* renamed from: U */
    private TextView f21477U;
    /* renamed from: V */
    private boolean f21478V = false;
    /* renamed from: W */
    private boolean f21479W = false;
    /* renamed from: X */
    private LinearLayout f21480X;
    /* renamed from: Y */
    private List f21481Y;
    /* renamed from: Z */
    private int f21482Z = -1;
    private Editor aa;
    private SharedPreferences ab;
    private View ac;
    private int ad = 0;
    private int ae = 0;
    private boolean af = true;
    private boolean ag = false;
    private boolean ah = false;
    private boolean ai = false;
    private ArrayList aj;
    private Handler ak = new aj(this);
    private BroadcastReceiver al = new be(this);
    private View am;
    private boolean an = false;
    private boolean ao = false;
    private EditText ap;
    private String aq = "";
    private boolean ar = true;
    private LinearLayout as;
    private String at;
    private boolean au = true;
    private TextView av;
    private String aw;
    private Button ax;
    /* renamed from: c */
    protected boolean f21483c = false;
    /* renamed from: d */
    protected boolean f21484d = false;
    /* renamed from: e */
    protected boolean f21485e = false;
    /* renamed from: f */
    protected int f21486f;
    /* renamed from: g */
    ImageGetter f21487g = new bk(this);
    /* renamed from: h */
    private final int f21488h = C0965R.string.add_rescue_info;
    /* renamed from: i */
    private final int f21489i = C0965R.string.agreement;
    /* renamed from: j */
    private final int f21490j = C0965R.string.alert_cancel;
    /* renamed from: k */
    private final int f21491k = C0965R.string.auth_title;
    /* renamed from: l */
    private final int f21492l = C0965R.string.alert_download_apk_title;
    /* renamed from: m */
    private final int f21493m = C0965R.string.alert_confirm_a;
    /* renamed from: n */
    private final int f21494n = C0965R.string.alert_continue_last_navi_tips;
    /* renamed from: o */
    private final int f21495o = C0965R.string.alert_delete;
    /* renamed from: p */
    private final int f21496p = C0965R.string.alert_delete_comp_addr;
    /* renamed from: q */
    private final int f21497q = C0965R.string.alert_disclaimer;
    /* renamed from: r */
    private final int f21498r = C0965R.string.alert_delete_home_addr;
    /* renamed from: s */
    private final int f21499s = C0965R.string.alert_delete_navi_cache;
    /* renamed from: t */
    private final int f21500t = C0965R.string.alert_clean;
    /* renamed from: u */
    private final int f21501u = C0965R.string.alert_clear_history_des;
    /* renamed from: v */
    private final int f21502v = C0965R.string.alert_close;
    /* renamed from: w */
    private final int f21503w = C0965R.string.alert_common_data_not_download;
    /* renamed from: x */
    private final int f21504x = C0965R.string.alert_no_valid_data_info;
    /* renamed from: y */
    private final int f21505y = C0965R.string.carlife_feedback_content_num_count;
    /* renamed from: z */
    private final int f21506z = C0965R.string.alert_confirm;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        this.ab = getSharedPreferences("UfoSharePreference", 0);
        this.aa = this.ab.edit();
        this.aq = getIntent().getStringExtra("faq_id");
        this.f21468L = getIntent().getStringExtra("msgid");
        this.at = getIntent().getStringExtra("no_result");
        if (TextUtils.isEmpty(this.f21468L)) {
            this.f21468L = "newMessage";
        }
        if (TextUtils.isEmpty(this.aq)) {
            this.aq = "";
        }
        String string = this.ab.getString("contact", "N/A");
        C5210c.m17732a("************************加密后的联系方式：tempContactStr: " + string);
        this.aw = C5220m.m17773b(string);
        C5210c.m17732a("************************解密后的联系方式：contactStr: " + this.aw);
        this.aa.putBoolean("ADD_PIC_FLAG", true);
        this.aa.commit();
        if (this.aw == null) {
            this.aw = "";
        }
        C5167a.f21362h = getIntent().getIntExtra("feedback_channel", 0);
        f21455a = new ArrayList();
        this.f21464H = new RelativeLayout(this);
        this.f21464H.setId(C0965R.string.alert_clean);
        this.f21464H.setBackgroundColor(C5167a.f21379y);
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(C0965R.string.alert_clear_history_des);
        new RelativeLayout(this).setId(C0965R.string.alert_common_data_not_download);
        this.f21466J = new Button(this);
        this.f21466J.setText(C5228u.m17794a("23"));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f21464H.addView(this.f21466J, layoutParams);
        this.f21466J.setVisibility(8);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        layoutParams = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams.setMargins(C5216i.m17757a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.f21465I = new ImageView(this);
        this.f21465I.setId(C0965R.string.add_rescue_info);
        this.f21465I.setScaleType(ScaleType.CENTER_CROP);
        this.f21465I.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_back_icon.png")));
        linearLayout.addView(this.f21465I, layoutParams);
        View textView = new TextView(this);
        textView.setText(C5167a.f21361g);
        textView.setTextSize(C5167a.f21339K);
        textView.setTextColor(C5167a.f21332D);
        textView.setGravity(16);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, C5216i.m17757a(getApplicationContext(), 8.0f), 0);
        linearLayout.addView(textView, layoutParams2);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        relativeLayout.addView(linearLayout, layoutParams);
        View textView2 = new TextView(this);
        textView2.setId(C0965R.string.agreement);
        textView2.setTextColor(C5167a.f21373s);
        textView2.setTextSize(C5167a.f21340L);
        textView2.setGravity(17);
        layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        relativeLayout.addView(textView2, layoutParams);
        this.ax = new Button(this);
        this.ax.setVisibility(8);
        this.ax.setText(C5228u.m17794a(PerformStatItem.RP_SUCCESS_NORMAL_STEP_INDEX));
        this.ax.setId(2131755010);
        this.ax.setTextColor(C5167a.f21374t);
        this.ax.setTextSize(C5167a.f21347S);
        this.ax.setGravity(17);
        this.ax.setTextColor(C5216i.m17759a(C5167a.f21374t, C5167a.f21375u, C5167a.f21374t, C5167a.f21374t));
        this.ax.setBackgroundColor(16777215);
        this.ax.setPadding(C5216i.m17757a(getApplicationContext(), 8.0f), 0, C5216i.m17757a(getApplicationContext(), 8.0f), 0);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.setMargins(0, 0, C5216i.m17757a(getApplicationContext(), 10.0f), 0);
        relativeLayout.addView(this.ax, layoutParams);
        try {
            relativeLayout.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_nav_bg.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        layoutParams = new RelativeLayout.LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams.addRule(10);
        this.f21464H.addView(relativeLayout, layoutParams);
        this.ac = C5216i.m17765b(this, C5228u.m17794a("25"));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f21464H.addView(this.ac, layoutParams);
        this.ac.setVisibility(8);
        this.f21463G = new LinearLayout(this);
        this.f21463G.setId(C0965R.string.alert_download_apk_title);
        this.f21463G.setOrientation(0);
        this.f21462F = new LinearLayout(this);
        this.f21462F.setId(C0965R.string.alert_cancel);
        this.f21462F.setOrientation(1);
        this.f21462F.setBackgroundColor(C5167a.f21333E);
        textView = new RelativeLayout(this);
        textView.setId(C0965R.string.alert_confirm_a);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        this.av = new TextView(this);
        this.av.setText("发送");
        this.av.setTextColor(C5167a.f21377w);
        this.av.setTextSize(13.0f);
        this.av.setGravity(17);
        this.av.setId(C0965R.string.auth_title);
        this.av.setBackgroundColor(C5167a.f21333E);
        this.av.setClickable(true);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.setMargins(C5216i.m17757a(getApplicationContext(), 7.0f), 0, 0, 0);
        textView.addView(this.av, layoutParams3);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        linearLayout2.setClickable(true);
        linearLayout2.setId(C0965R.string.auto_mode);
        View imageView = new ImageView(this);
        imageView.setId(C0965R.string.alert_delete);
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_pluspic_icon.png")));
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams4.setMargins(C5216i.m17757a(getApplicationContext(), 5.0f), C5216i.m17757a(getApplicationContext(), 5.0f), C5216i.m17757a(getApplicationContext(), 5.0f), C5216i.m17757a(getApplicationContext(), 5.0f));
        linearLayout2.addView(imageView, layoutParams4);
        LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 33.0f), C5216i.m17757a(getApplicationContext(), 33.0f));
        layoutParams5.addRule(15);
        layoutParams5.addRule(9);
        textView.addView(linearLayout2, layoutParams5);
        this.ap = new EditText(this);
        this.ap.setImeOptions(4);
        this.ap.setInputType(262144);
        this.ap.setSingleLine(false);
        this.ap.setId(C0965R.string.alert_continue_last_navi_tips);
        this.ap.setVisibility(0);
        this.ap.setTextSize(14.0f);
        this.ap.setGravity(16);
        this.ap.setPadding(C5216i.m17757a(getApplicationContext(), 5.0f), 0, C5216i.m17757a(getApplicationContext(), 5.0f), 0);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(1, -2697514);
        float a = (float) C5216i.m17757a(getApplicationContext(), 4.0f);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(a);
        this.ap.setBackgroundDrawable(gradientDrawable);
        layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(1, linearLayout2.getId());
        layoutParams5.addRule(0, this.av.getId());
        layoutParams5.addRule(15);
        textView.addView(this.ap, layoutParams5);
        this.ap.setOnEditorActionListener(new bl(this));
        this.ap.addTextChangedListener(new bm(this));
        this.av.setOnClickListener(new bn(this));
        linearLayout2.setOnClickListener(new bo(this));
        this.ax.setOnClickListener(new bp(this));
        this.f21463G.addView(textView, new LinearLayout.LayoutParams(-1, -1));
        this.f21463G.setGravity(16);
        layoutParams = new LinearLayout.LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 40.0f));
        this.f21463G.setPadding(0, C5216i.m17757a(getApplicationContext(), 3.0f), C5216i.m17757a(getApplicationContext(), 4.0f), C5216i.m17757a(getApplicationContext(), 3.0f));
        this.f21462F.setGravity(3);
        this.f21462F.addView(this.f21463G, layoutParams);
        this.am = new View(this);
        this.am.setId(C0965R.string.alert_disclaimer);
        this.am.setBackgroundColor(C5167a.f21331C);
        layoutParams = new LinearLayout.LayoutParams(-1, 1);
        layoutParams.setMargins(0, C5216i.m17757a(getApplicationContext(), 3.0f), 0, C5216i.m17757a(getApplicationContext(), 3.0f));
        this.f21462F.addView(this.am, layoutParams);
        this.am.setVisibility(8);
        this.f21480X = new LinearLayout(this);
        this.f21480X.setOrientation(0);
        this.f21480X.setPadding(0, C5216i.m17757a(getApplicationContext(), 8.0f), 0, C5216i.m17757a(getApplicationContext(), 8.0f));
        this.f21480X.setId(C0965R.string.alert_delete_navi_cache);
        this.f21480X.setVisibility(8);
        this.f21481Y = new ArrayList();
        Object byteArrayExtra = getIntent().getByteArrayExtra("shot");
        if (byteArrayExtra == null || byteArrayExtra.length <= 0) {
            this.f21481Y.add(C5223p.m17782a(this));
            this.f21480X.setVisibility(8);
        } else {
            this.f21481Y.add(byteArrayExtra);
            this.f21481Y.add(C5223p.m17783b(this));
            this.f21480X.setVisibility(0);
        }
        m17653b();
        this.f21462F.addView(this.f21480X, new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 229.0f), C5216i.m17757a(getApplicationContext(), 64.0f)));
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f21462F.setPadding(C5216i.m17757a(getApplicationContext(), 7.0f), C5216i.m17757a(getApplicationContext(), 5.0f), C5216i.m17757a(getApplicationContext(), 7.0f), C5216i.m17757a(getApplicationContext(), 5.0f));
        this.f21462F.bringToFront();
        this.f21464H.addView(this.f21462F, layoutParams);
        this.f21472P = new ListView(this);
        this.f21472P.setBackgroundColor(C5167a.f21334F);
        this.f21472P.setDivider(new ColorDrawable(C5167a.f21334F));
        this.f21472P.setDividerHeight(0);
        this.f21473Q = new br(this, this);
        this.f21472P.setAdapter(this.f21473Q);
        this.f21472P.setFocusable(false);
        this.f21472P.setCacheColorHint(C5167a.f21334F);
        this.f21472P.setClickable(false);
        this.f21472P.setTranscriptMode(2);
        this.f21472P.setRecyclerListener(new bq(this));
        textView = new LinearLayout(this);
        textView.setId(C0965R.string.carlife_feedback_content_num_count);
        textView.setBackgroundColor(0);
        textView.setOrientation(1);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f21467K = new LinearLayout(this);
        this.f21467K.setId(C0965R.string.alert_no_valid_data_info);
        this.f21467K.setBackgroundColor(C5167a.f21334F);
        this.f21467K.clearAnimation();
        layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(3, relativeLayout.getId());
        layoutParams5.addRule(2, textView.getId());
        layoutParams5.setMargins(0, 0, 0, 0);
        this.f21467K.addView(this.f21472P, layoutParams3);
        this.f21464H.addView(this.f21467K, layoutParams5);
        this.as = new LinearLayout(this);
        this.as.setId(C0965R.string.alert_delete_home_addr);
        this.as.setOrientation(0);
        this.as.setBackgroundColor(C5167a.f21335G);
        this.as.setGravity(16);
        this.as.setVisibility(8);
        relativeLayout = new TextView(this);
        relativeLayout.setText("以上内容是否解决了您的问题？");
        relativeLayout.setTextColor(C5167a.f21337I);
        relativeLayout.setSingleLine(false);
        relativeLayout.setTextSize(12.0f);
        relativeLayout.setGravity(17);
        layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.setMargins(C5216i.m17757a(getApplicationContext(), 10.0f), 0, C5216i.m17757a(getApplicationContext(), 15.0f), 0);
        layoutParams3.weight = 1.0f;
        this.as.addView(relativeLayout, layoutParams3);
        relativeLayout = new Button(this);
        relativeLayout.setText("解决了");
        relativeLayout.setTextColor(C5167a.f21336H);
        relativeLayout.setTextSize(13.0f);
        relativeLayout.setGravity(17);
        relativeLayout.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), "ufo_feedback_btn_defult.9.png", "ufo_feedback_btn_press.9.png"));
        layoutParams3 = new LinearLayout.LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 43.0f));
        layoutParams3.weight = 1.0f;
        this.as.addView(relativeLayout, layoutParams3);
        linearLayout2 = new View(this);
        linearLayout2.setBackgroundColor(0);
        this.as.addView(linearLayout2, new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 10.0f), -1));
        linearLayout2 = new Button(this);
        linearLayout2.setText("没有解决\n提交人工处理");
        linearLayout2.setTextColor(C5167a.f21336H);
        linearLayout2.setTextSize(10.0f);
        linearLayout2.setGravity(17);
        linearLayout2.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), "ufo_loading_bg_n.9.png", "ufo_loading_bg.9.png"));
        layoutParams5 = new LinearLayout.LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 45.0f));
        layoutParams5.weight = 1.0f;
        this.as.addView(linearLayout2, layoutParams5);
        relativeLayout.setOnClickListener(new ao(this));
        linearLayout2.setOnClickListener(new aq(this));
        LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 60.0f));
        this.as.bringToFront();
        this.as.setPadding(C5216i.m17757a(getApplicationContext(), 0.0f), C5216i.m17757a(getApplicationContext(), 0.0f), C5216i.m17757a(getApplicationContext(), 15.0f), C5216i.m17757a(getApplicationContext(), 0.0f));
        textView.addView(this.as, layoutParams6);
        this.f21476T = new View(this);
        this.f21476T.setId(C0965R.string.alert_delete_comp_addr);
        this.f21476T.setBackgroundColor(-2236963);
        textView.addView(this.f21476T, new LinearLayout.LayoutParams(-1, 1));
        layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(2, this.f21462F.getId());
        this.f21464H.addView(textView, layoutParams6);
        this.f21461E = new LinearLayout(this);
        this.f21461E.setOrientation(1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        relativeLayout = new ImageView(this);
        layoutParams3 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 115.0f), C5216i.m17757a(getApplicationContext(), 101.0f));
        try {
            relativeLayout.setBackgroundDrawable(C5225r.m17786a(getApplicationContext(), "ufo_no_netwrok.png"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f21461E.addView(relativeLayout, layoutParams3);
        this.f21477U = new TextView(this);
        this.f21477U.setPadding(C5216i.m17757a(getApplicationContext(), 10.0f), C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 10.0f), C5216i.m17757a(getApplicationContext(), 11.0f));
        this.f21477U.setTextSize(C5167a.f21341M);
        this.f21477U.setTextColor(-10066330);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        C5216i.m17762a(getApplicationContext(), this.f21477U);
        this.f21461E.addView(this.f21477U, layoutParams);
        this.f21466J = new Button(this);
        this.f21466J.setText(C5228u.m17794a("22"));
        this.f21466J.setTextSize(C5167a.f21342N);
        this.f21466J.setTextColor(-13421773);
        try {
            this.f21466J.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        this.f21461E.addView(this.f21466J, new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 122.0f), C5216i.m17757a(getApplicationContext(), 40.0f)));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f21464H.addView(this.f21461E, layoutParams);
        this.f21461E.setGravity(17);
        this.f21461E.setVisibility(8);
        setContentView(this.f21464H, new LayoutParams(-1, -1));
        this.f21474R = C5216i.m17765b(this, C5228u.m17794a("13"));
        layoutParams = new RelativeLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 114.0f), C5216i.m17757a(getApplicationContext(), 39.0f));
        layoutParams.addRule(13);
        this.f21464H.addView(this.f21474R, layoutParams);
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(getApplicationContext(), C5228u.m17794a("18"), 1).show();
            Intent intent = new Intent(this, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", C5167a.f21362h);
            startActivity(intent);
            finish();
            return;
        }
        this.f21460D = getIntent();
        this.f21468L = this.f21460D.getStringExtra("msgid");
        if (this.f21468L == null || this.f21468L.length() <= 0 || this.f21468L.equals("newMessage")) {
            textView2.setText("意见反馈");
            if (UfoSDK.isShowFeedbackBtn) {
                this.ax.setVisibility(0);
            } else {
                this.ax.setVisibility(8);
            }
            this.af = true;
            this.au = false;
            this.f21485e = false;
            this.f21474R.setVisibility(8);
            this.ac.setVisibility(8);
            this.ak.obtainMessage(5, "newMessage").sendToTarget();
        } else {
            textView2.setText("反馈详情");
            this.ax.setVisibility(8);
            this.af = false;
            this.au = true;
            this.f21485e = true;
            this.f21475S = Executors.newSingleThreadExecutor();
            this.f21475S.execute(new as(this));
        }
        linearLayout.setOnClickListener(new at(this));
        this.f21462F.setOnClickListener(new au(this));
        this.f21466J.setOnClickListener(new av(this));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.f21483c = true;
        m17642a();
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        if (motionEvent.getAction() == 0) {
            InputMethodManager inputMethodManager;
            View view = this.f21462F;
            if (view != null && (view instanceof LinearLayout)) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                int height = view.getHeight() + i3;
                int width = view.getWidth() + i2;
                if (motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i3) || motionEvent.getY() >= ((float) height)) {
                    if (this.aj != null) {
                        Iterator it = this.aj.iterator();
                        while (it.hasNext()) {
                            View view2 = (View) it.next();
                            int[] iArr2 = new int[2];
                            view2.getLocationOnScreen(iArr2);
                            width = iArr2[0];
                            height = iArr2[1];
                            if (motionEvent.getX() < ((float) width) || motionEvent.getX() > ((float) (width + view2.getWidth())) || motionEvent.getY() < ((float) height) || motionEvent.getY() > ((float) (view2.getHeight() + height))) {
                                i3 = 0;
                                continue;
                            } else {
                                i3 = 1;
                                continue;
                            }
                            if (i3 != 0) {
                            }
                        }
                    }
                    if (i != 0) {
                        inputMethodManager = (InputMethodManager) getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            i = 0;
            if (i != 0) {
                inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        } else if (getWindow().superDispatchTouchEvent(motionEvent)) {
            return true;
        } else {
            return onTouchEvent(motionEvent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m17642a() {
        if (this.ac.getVisibility() == 0) {
            this.ac.setVisibility(8);
            this.ao = false;
            this.av.setTextColor(C5216i.m17759a(C5167a.f21377w, C5167a.f21378x, C5167a.f21377w, C5167a.f21377w));
            this.ap.setEnabled(true);
            return;
        }
        if (f21455a != null) {
            f21455a.clear();
        }
        getApplicationContext();
        new cb(this).execute(new Void[0]);
    }

    /* renamed from: J */
    static /* synthetic */ void m17630J(FeedbackInputActivity feedbackInputActivity) {
        feedbackInputActivity.as.setVisibility(8);
        if (!feedbackInputActivity.ao) {
            if (feedbackInputActivity.ap.getText().toString().trim().length() <= 0) {
                Toast.makeText(feedbackInputActivity, C5228u.m17794a(PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX), 0).show();
            } else if (feedbackInputActivity.ap.getText().toString().trim().length() > C5167a.af) {
                Toast.makeText(feedbackInputActivity, C5228u.m17794a("16"), 0).show();
            } else if (C5170c.m17557b(feedbackInputActivity.getApplicationContext()).contains("UNKNOWN") || C5170c.m17557b(feedbackInputActivity.getApplicationContext()).contains("NONE")) {
                Toast.makeText(feedbackInputActivity, C5228u.m17794a("18"), 1).show();
            } else if (UfoSDK.clientid.length() == 0) {
                Toast.makeText(feedbackInputActivity, C5228u.m17794a("18"), 1).show();
                new Thread(new ax(feedbackInputActivity)).start();
            } else {
                if (!(feedbackInputActivity.getCurrentFocus() == null || feedbackInputActivity.getCurrentFocus().getWindowToken() == null)) {
                    ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 2);
                }
                feedbackInputActivity.ao = true;
                feedbackInputActivity.av.setTextColor(C5167a.f21378x);
                feedbackInputActivity.ap.setEnabled(false);
                C5210c.m17734b("000000000000000000000000000 联系方式：" + feedbackInputActivity.aw + "  msgId : " + feedbackInputActivity.f21468L);
                if (!feedbackInputActivity.f21468L.equals("newMessage") || !UfoSDK.contactDialogSwitch) {
                    feedbackInputActivity.ac.setVisibility(0);
                    feedbackInputActivity.ac.bringToFront();
                    new Thread(new ay(feedbackInputActivity)).start();
                } else if (feedbackInputActivity.aw == null || feedbackInputActivity.aw.equals("null")) {
                    feedbackInputActivity.m17650a("");
                } else {
                    feedbackInputActivity.m17650a(feedbackInputActivity.aw);
                }
            }
        }
    }

    /* renamed from: P */
    static /* synthetic */ void m17636P(FeedbackInputActivity feedbackInputActivity) {
        int i = 0;
        if (feedbackInputActivity.f21481Y.size() < 2) {
            if (feedbackInputActivity.m17651a(feedbackInputActivity.getApplicationContext(), UfoSDK.clientid, feedbackInputActivity.f21468L, C5167a.f21364j + feedbackInputActivity.ap.getText().toString() + C5167a.f21365k, feedbackInputActivity.aw, null, feedbackInputActivity.ak)) {
                C5210c.m17734b("反馈发送成功！--" + feedbackInputActivity.ap.getText().toString());
                feedbackInputActivity.ak.obtainMessage(1, feedbackInputActivity.ap.getText().toString()).sendToTarget();
                if ((!UfoSDK.robotAnswer || !feedbackInputActivity.af) && !feedbackInputActivity.f21468L.contains("newMessage") && !feedbackInputActivity.f21484d) {
                    feedbackInputActivity.ak.obtainMessage(8).sendToTarget();
                    return;
                }
                return;
            }
            C5210c.m17736d("反馈发送失败！");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < feedbackInputActivity.f21481Y.size() - 1; i2++) {
            jSONArray.put(Base64.encodeToString((byte[]) feedbackInputActivity.f21481Y.get(i2), 0));
        }
        if (jSONArray.toString().length() < 2097152) {
            if (feedbackInputActivity.m17651a(feedbackInputActivity.getApplicationContext(), UfoSDK.clientid, feedbackInputActivity.f21468L, C5167a.f21364j + feedbackInputActivity.ap.getText().toString() + C5167a.f21365k, feedbackInputActivity.aw, jSONArray.toString(), feedbackInputActivity.ak)) {
                feedbackInputActivity.ak.obtainMessage(1, feedbackInputActivity.ap.getText().toString()).sendToTarget();
                while (i < feedbackInputActivity.f21481Y.size() - 1) {
                    feedbackInputActivity.ak.obtainMessage(3, feedbackInputActivity.f21481Y.get(i)).sendToTarget();
                    i++;
                }
                if ((!UfoSDK.robotAnswer || !feedbackInputActivity.af) && !feedbackInputActivity.f21468L.contains("newMessage") && !feedbackInputActivity.f21484d) {
                    feedbackInputActivity.ak.obtainMessage(8).sendToTarget();
                    return;
                }
                return;
            }
            C5210c.m17736d("发送失败");
            return;
        }
        Toast.makeText(feedbackInputActivity, C5228u.m17794a("21"), 1).show();
    }

    /* renamed from: a */
    private boolean m17651a(Context context, String str, String str2, String str3, String str4, String str5, Handler handler) {
        boolean z;
        int i;
        long availableBlocks;
        if (C5167a.ai != null) {
            C5167a.ai.onSubmitMessageBeforeCallback(str3, str2.contains("newMessage") ? null : str2);
        }
        String str6 = C5167a.as;
        Map hashMap = new HashMap();
        hashMap.put("clientid", str);
        hashMap.put(SpeechConstant.APP_ID, UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        if (UfoSDK.robotAnswer && this.af) {
            hashMap.put("answerPerson", "robot");
        }
        if (!str2.contains("newMessage")) {
            hashMap.put("id", str2);
        }
        hashMap.put("content", str3);
        if (str4 == null) {
            z = false;
        } else {
            z = Pattern.compile("[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}").matcher(str4).matches();
        }
        if (z) {
            i = 1;
        } else {
            if (str4 == null) {
                z = false;
            } else {
                z = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\\d{8}$").matcher(str4).matches();
            }
            if (z) {
                i = 2;
            } else {
                if (str4 == null) {
                    z = false;
                } else {
                    z = Pattern.compile("^[1-9][0-9]{4,}$").matcher(str4).matches();
                }
                if (z) {
                    i = 3;
                } else {
                    i = 0;
                }
            }
        }
        C5210c.m17735c("contactWay is " + str4);
        if (i == 0) {
            hashMap.put("contact_way", str4);
        } else if (i == 1) {
            C5210c.m17735c("contactWay is email");
            hashMap.put("email", str4);
        } else if (i == 2) {
            C5210c.m17735c("contactWay is tel");
            hashMap.put(SearchParamKey.TEL, str4);
        } else {
            C5210c.m17735c("contactWay is qq");
            hashMap.put("qq", str4);
        }
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sdkvn", "1.7.13");
        hashMap.put("os", "android");
        hashMap.put("appvn", C5171d.m17561c());
        String str7 = "freespace";
        if (C5226s.m17792a("android.permission.MOUNT_UNMOUNT_FILESYSTEMS")) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } else {
            availableBlocks = -1;
        }
        hashMap.put(str7, String.valueOf(availableBlocks));
        hashMap.put("uid", C5167a.f21356b);
        hashMap.put("osvn", VERSION.RELEASE);
        hashMap.put("extra", C5167a.f21358d);
        hashMap.put("extend_feedback_channel", Integer.valueOf(C5167a.f21362h));
        hashMap.put("osvc", String.valueOf(C5219l.m17768a()));
        hashMap.put("referer", C5167a.f21368n);
        hashMap.put("baiducuid", C5167a.f21357c);
        if (!TextUtils.isEmpty(this.aq)) {
            hashMap.put("faq_id", this.aq);
        }
        hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
        if (C5226s.m17792a("android.permission.ACCESS_NETWORK_STATE")) {
            hashMap.put("nettype", C5170c.m17556a(context));
        } else {
            hashMap.put("nettype", "N/A");
        }
        hashMap.put("screenSize", C5172e.m17563b(context));
        if (C5167a.f21355a) {
            hashMap.put("logcat", C5168a.m17555a());
        }
        if (!TextUtils.isEmpty(C5167a.f21360f)) {
            hashMap.put("ip_location", C5167a.f21360f);
        }
        String a = C5220m.m17770a(C5174a.m17564a(hashMap));
        try {
            if (TextUtils.isEmpty(str5)) {
                a = "sdk_encrypt=" + URLEncoder.encode(a, "UTF-8");
            } else {
                a = "sdk_encrypt=" + URLEncoder.encode(a, "UTF-8") + "&screenshot=" + URLEncoder.encode(str5, "UTF-8");
            }
            Object a2 = C5181b.m17578a(str6, a);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(C5220m.m17773b(a2));
                C5210c.m17732a("response is -----------------> " + jSONObject.toString());
                if (UfoSDK.robotAnswer && this.af) {
                    if (jSONObject.has("round")) {
                        this.ad = ((Integer) jSONObject.get("round")).intValue();
                    } else {
                        this.af = false;
                    }
                }
                if (((Integer) jSONObject.get(C2125n.f6745M)).intValue() == 0) {
                    UfoSDK.neverFeedback = false;
                    UfoSDK.lastSendTime = System.currentTimeMillis();
                    Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                    edit.putBoolean("UfoNeverFeedback", false);
                    edit.putLong("Ufolastsendtime", UfoSDK.lastSendTime);
                    edit.commit();
                    a = String.valueOf(jSONObject.get("id"));
                    if (C5167a.ai != null) {
                        C5167a.ai.onSubmitMessageAfterCallback(str3, a);
                    }
                    if (str2.contains("newMessage")) {
                        handler.obtainMessage(14, a).sendToTarget();
                    } else {
                        handler.obtainMessage(12, a).sendToTarget();
                    }
                    return true;
                }
            }
        } catch (Throwable e) {
            C5210c.m17733a("sendRecord fail.", e);
            Looper.prepare();
            Toast.makeText(context, C5228u.m17794a("18"), 1).show();
            handler.obtainMessage(13).sendToTarget();
            Looper.loop();
        }
        return false;
    }

    /* renamed from: a */
    private void m17650a(String str) {
        cx cxVar = new cx(this, str);
        cxVar.m17722a(new az(this, cxVar));
        cxVar.show();
    }

    /* renamed from: a */
    private static Bitmap m17641a(Bitmap bitmap, int i) {
        if (bitmap == null || i <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= i || height <= i) {
            return bitmap;
        }
        int max = (Math.max(width, height) * i) / Math.min(width, height);
        int i2 = width > height ? max : i;
        if (width > height) {
            max = i;
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, max, true);
            try {
                bitmap = Bitmap.createBitmap(createScaledBitmap, (i2 - i) / 2, (max - i) / 2, i, i);
                createScaledBitmap.recycle();
                return bitmap;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: b */
    private void m17653b() {
        if (this.f21480X != null) {
            this.f21480X.removeAllViews();
            for (int i = 0; i < this.f21481Y.size(); i++) {
                View relativeLayout = new RelativeLayout(this);
                View dbVar;
                Bitmap bitmap;
                if (i != this.f21481Y.size() - 1) {
                    dbVar = new db(this);
                    dbVar.setTag(Integer.valueOf(i));
                    dbVar.setBackgroundDrawable(null);
                    dbVar.setPadding(0, 0, 0, 0);
                    dbVar.setScaleType(ScaleType.CENTER_CROP);
                    dbVar.setMaxHeight(C5216i.m17757a(getApplicationContext(), 48.0f));
                    dbVar.setMinimumHeight(C5216i.m17757a(getApplicationContext(), 48.0f));
                    dbVar.setMaxWidth(C5216i.m17757a(getApplicationContext(), 48.0f));
                    dbVar.setMinimumWidth(C5216i.m17757a(getApplicationContext(), 48.0f));
                    relativeLayout.addView(dbVar, new RelativeLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 48.0f), C5216i.m17757a(getApplicationContext(), 48.0f)));
                    try {
                        if (this.f21481Y.get(i) == null) {
                            bitmap = null;
                        } else if (BitmapFactory.decodeByteArray((byte[]) this.f21481Y.get(i), 0, ((byte[]) this.f21481Y.get(i)).length) != null) {
                            bitmap = BitmapFactory.decodeByteArray((byte[]) this.f21481Y.get(i), 0, ((byte[]) this.f21481Y.get(i)).length);
                        } else {
                            return;
                        }
                        if (bitmap != null && m17641a(bitmap, C5216i.m17757a(getApplicationContext(), 45.0f)) != null) {
                            dbVar.setImageBitmap(bitmap);
                            View imageButton = new ImageButton(this);
                            imageButton.setTag(Integer.valueOf(i));
                            imageButton.setBackgroundDrawable(null);
                            imageButton.setPadding(C5216i.m17757a(getApplicationContext(), 9.0f), 0, 0, C5216i.m17757a(getApplicationContext(), 9.0f));
                            imageButton.setScaleType(ScaleType.FIT_XY);
                            Bitmap a = C5223p.m17779a(getApplicationContext(), "ufo_delete_little_icon.png");
                            if (a != null) {
                                imageButton.setImageBitmap(a);
                                LayoutParams layoutParams = new RelativeLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 24.0f), C5216i.m17757a(getApplicationContext(), 24.0f));
                                layoutParams.addRule(11);
                                layoutParams.addRule(10);
                                layoutParams.setMargins(0, 0, 0, 0);
                                relativeLayout.addView(imageButton, layoutParams);
                                imageButton.setOnClickListener(new bd(this));
                            } else {
                                return;
                            }
                        }
                        return;
                    } catch (OutOfMemoryError e) {
                        System.gc();
                        return;
                    }
                }
                dbVar = new ImageView(this);
                dbVar.setTag(Integer.valueOf(i));
                dbVar.setBackgroundDrawable(null);
                dbVar.setPadding(0, 0, 0, 0);
                dbVar.setScaleType(ScaleType.CENTER_CROP);
                dbVar.setMaxHeight(C5216i.m17757a(getApplicationContext(), 48.0f));
                dbVar.setMinimumHeight(C5216i.m17757a(getApplicationContext(), 48.0f));
                dbVar.setMaxWidth(C5216i.m17757a(getApplicationContext(), 48.0f));
                dbVar.setMinimumWidth(C5216i.m17757a(getApplicationContext(), 48.0f));
                relativeLayout.addView(dbVar, new RelativeLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 48.0f), C5216i.m17757a(getApplicationContext(), 48.0f)));
                try {
                    bitmap = BitmapFactory.decodeByteArray((byte[]) this.f21481Y.get(i), 0, ((byte[]) this.f21481Y.get(i)).length);
                    if (bitmap != null && m17641a(bitmap, C5216i.m17757a(getApplicationContext(), 45.0f)) != null) {
                        dbVar.setImageBitmap(bitmap);
                        dbVar.setOnClickListener(new bf(this));
                    } else {
                        return;
                    }
                } catch (OutOfMemoryError e2) {
                    System.gc();
                    return;
                }
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 48.0f), C5216i.m17757a(getApplicationContext(), 48.0f));
                if (i == 0) {
                    layoutParams2.setMargins(C5216i.m17757a(getApplicationContext(), 6.0f), 0, 0, 0);
                } else {
                    layoutParams2.setMargins(C5216i.m17757a(getApplicationContext(), 10.0f), 0, 0, 0);
                }
                layoutParams2.gravity = 80;
                this.f21480X.addView(relativeLayout, layoutParams2);
            }
        }
    }

    protected void onRestart() {
        super.onRestart();
    }

    public void onResume() {
        super.onResume();
        if (C5167a.ah != null) {
            C5167a.ah.onResumeCallback();
        }
        this.f21466J.setText(C5228u.m17794a("22"));
        C5216i.m17763a((RelativeLayout) this.f21474R, C5228u.m17794a("13"));
        if (this.f21468L != null && this.f21468L.length() > 0) {
            if (this.f21470N == null) {
                this.f21470N = new C5165a(getApplicationContext(), this.f21468L);
            }
            this.f21470N.m17552b();
            if (!this.f21470N.isAlive()) {
                this.f21470N.start();
            }
        }
        C5211d c5211d = new C5211d(this);
        c5211d.m17740a(c5211d.m17739a() + 1);
        if (C5167a.ah != null) {
            C5167a.ah.onResumeCallback();
        }
        C5216i.m17763a((RelativeLayout) this.ac, C5228u.m17794a("25"));
        this.ar = true;
        if (this.f21468L == null) {
            this.f21468L = "newMessage";
        } else if (this.f21468L.length() == 0) {
            this.f21468L = "newMessage";
        }
        String str = "";
        if (this.at != null) {
            this.ap.setText(this.at);
        } else if (TextUtils.isEmpty(this.aq)) {
            str = this.ab.getString(this.f21468L, "");
            this.ap.setText(str);
        } else {
            str = this.ab.getString(this.aq, "");
            this.ap.setText(str);
        }
        this.ap.setSelection(str.length());
        if (this.ap.getText().toString().trim().length() <= 0) {
            this.av.setTextColor(C5167a.f21378x);
        } else {
            this.av.setTextColor(C5216i.m17759a(C5167a.f21377w, C5167a.f21378x, C5167a.f21377w, C5167a.f21377w));
        }
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new bg(this)).start();
        } else {
            new Thread(new bh(this)).start();
        }
    }

    public void onPause() {
        super.onPause();
        super.onPause();
        this.aa.putString("contactWay", null);
        if (this.ar) {
            if (TextUtils.isEmpty(this.aq)) {
                this.aa.putString(this.f21468L, this.ap.getText().toString());
            } else {
                this.aa.putString(this.aq, this.ap.getText().toString());
            }
        }
        this.aa.commit();
        if (this.f21470N != null) {
            this.f21470N.m17550a();
            this.f21470N = null;
        }
    }

    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ufosdk.getchat");
        intentFilter.addAction("com.baidu.ufosdk.getmsgid");
        intentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
        intentFilter.addAction("com.baidu.ufosdk.reload");
        registerReceiver(this.al, intentFilter);
    }

    public void onStop() {
        super.onStop();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
            }
        }
        unregisterReceiver(this.al);
    }

    protected void onDestroy() {
        super.onDestroy();
        C5208a.f21687a = null;
    }

    /* renamed from: a */
    private int m17640a(Uri uri) {
        Cursor query;
        Cursor cursor;
        Throwable th;
        if (uri == null) {
            return 0;
        }
        try {
            int i;
            query = getContentResolver().query(uri, null, null, null, null);
            if (query != null) {
                try {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("orientation"));
                    if (string == null) {
                        i = 0;
                    } else {
                        i = Integer.parseInt(string);
                    }
                } catch (Exception e) {
                    cursor = query;
                    try {
                        cursor.close();
                        return 0;
                    } catch (Exception e2) {
                        return 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        query.close();
                    } catch (Exception e3) {
                    }
                    throw th;
                }
            }
            i = 0;
            try {
                query.close();
            } catch (Exception e4) {
            }
            return i;
        } catch (Exception e5) {
            cursor = null;
            cursor.close();
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            query.close();
            throw th;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Object obj;
        Exception exception;
        super.onActivityResult(i, i2, intent);
        if (!this.an) {
            C5211d c5211d = new C5211d(this);
            c5211d.m17744c(c5211d.m17743c() + 1);
            this.an = true;
        }
        if (i2 == -1) {
            this.f21479W = false;
            if (intent != null) {
                Uri data;
                try {
                    data = intent.getData();
                } catch (Exception e) {
                    data = null;
                }
                if (data != null) {
                    try {
                        InputStream openInputStream = getContentResolver().openInputStream(data);
                        if (openInputStream.available() < MapGLSurfaceView.FLAG_OVERLAY_BMBAR_DYNAMCI_MAP) {
                            byte[] bArr = new byte[1024];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                int read = openInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            Object toByteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            openInputStream.close();
                            if (toByteArray == null) {
                                try {
                                    Toast.makeText(this, C5228u.m17794a("21"), 1).show();
                                    return;
                                } catch (Exception e2) {
                                    Exception exception2 = e2;
                                    obj = toByteArray;
                                    exception = exception2;
                                    System.out.println(exception.getMessage());
                                    if (i != this.f21481Y.size() - 1) {
                                        Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                                        C5210c.m17734b("picBytesList--->clear");
                                        this.f21481Y.clear();
                                        this.f21481Y.add(C5223p.m17783b(this));
                                    } else {
                                        this.f21481Y.set(i, obj);
                                        this.f21481Y.add(C5223p.m17783b(this));
                                    }
                                    m17653b();
                                    this.ap.setFocusable(true);
                                    this.ap.setFocusableInTouchMode(true);
                                    return;
                                }
                            }
                            toByteArray = C5227t.m17793a(toByteArray, m17640a(data));
                            if (toByteArray == null) {
                                Toast.makeText(this, C5228u.m17794a("21"), 1).show();
                                return;
                            } else if (toByteArray.length > 1048576) {
                                Toast.makeText(this, C5228u.m17794a("21"), 1).show();
                                return;
                            } else if (toByteArray.length == 0) {
                                Toast.makeText(this, "图片选择错误，请重新选择一张。", 1).show();
                                return;
                            } else {
                                ActivityManager activityManager = (ActivityManager) getSystemService(BusinessActivityManager.AUDIO_DIR);
                                MemoryInfo memoryInfo = new MemoryInfo();
                                activityManager.getMemoryInfo(memoryInfo);
                                if (memoryInfo.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID < 35000) {
                                    Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                                    System.gc();
                                    return;
                                }
                                obj = toByteArray;
                                if (i != this.f21481Y.size() - 1) {
                                    this.f21481Y.set(i, obj);
                                    this.f21481Y.add(C5223p.m17783b(this));
                                } else {
                                    Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                                    C5210c.m17734b("picBytesList--->clear");
                                    this.f21481Y.clear();
                                    this.f21481Y.add(C5223p.m17783b(this));
                                }
                                m17653b();
                                this.ap.setFocusable(true);
                                this.ap.setFocusableInTouchMode(true);
                                return;
                            }
                        }
                        Toast.makeText(this, C5228u.m17794a("21"), 1).show();
                    } catch (Exception e22) {
                        exception = e22;
                        obj = null;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected final void m17682a(View view) {
        View button = new Button(this);
        button.setBackgroundDrawable(null);
        button.setText("复制");
        button.setTextSize(12.0f);
        button.setTextColor(-1);
        button.setGravity(17);
        PopupWindow popupWindow = new PopupWindow(button, C5216i.m17757a(getApplicationContext(), 60.0f), C5216i.m17757a(getApplicationContext(), 35.0f), true);
        popupWindow.setTouchable(true);
        popupWindow.getContentView().setOnClickListener(new bi(this, view, popupWindow));
        popupWindow.setTouchInterceptor(new bj(this));
        try {
            popupWindow.setBackgroundDrawable(C5225r.m17786a((Context) this, "ufo_loading_bg.9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        popupWindow.showAsDropDown(view);
    }

    /* renamed from: a */
    static /* synthetic */ void m17643a(FeedbackInputActivity feedbackInputActivity) {
        feedbackInputActivity.f21480X.removeAllViews();
        feedbackInputActivity.f21481Y.removeAll(feedbackInputActivity.f21481Y);
        feedbackInputActivity.f21481Y.add(C5223p.m17782a(feedbackInputActivity));
        feedbackInputActivity.m17653b();
    }

    /* renamed from: S */
    static /* synthetic */ void m17639S(FeedbackInputActivity feedbackInputActivity) {
        if (!C5215h.m17755a()) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            if (feedbackInputActivity.f21482Z == feedbackInputActivity.f21481Y.size() - 1) {
                if (!(feedbackInputActivity.getCurrentFocus() == null || feedbackInputActivity.getCurrentFocus().getWindowToken() == null)) {
                    ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 2);
                }
                try {
                    feedbackInputActivity.f21479W = true;
                    feedbackInputActivity.startActivityForResult(intent, feedbackInputActivity.f21482Z);
                    try {
                        feedbackInputActivity.overridePendingTransition(C5216i.m17758a(feedbackInputActivity.getApplicationContext(), "ufo_slide_in_from_bottom"), 0);
                    } catch (Exception e) {
                    }
                } catch (ActivityNotFoundException e2) {
                    Toast.makeText(feedbackInputActivity, C5228u.m17794a("0"), 1).show();
                }
            }
        }
    }
}
