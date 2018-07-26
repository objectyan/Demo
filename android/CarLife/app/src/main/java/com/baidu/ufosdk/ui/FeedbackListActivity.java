package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p247a.C5166b;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5223p;
import com.baidu.ufosdk.util.C5225r;
import com.baidu.ufosdk.util.C5228u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint({"HandlerLeak", "InlinedApi"})
@TargetApi(8)
public class FeedbackListActivity extends Activity {
    /* renamed from: y */
    private static C5166b f21507y;
    /* renamed from: A */
    private PopupWindow f21508A;
    /* renamed from: B */
    private Handler f21509B = new cg(this);
    /* renamed from: C */
    private BroadcastReceiver f21510C = new cj(this);
    /* renamed from: a */
    private RelativeLayout f21511a;
    /* renamed from: b */
    private LinearLayout f21512b;
    /* renamed from: c */
    private LinearLayout f21513c;
    /* renamed from: d */
    private TextView f21514d;
    /* renamed from: e */
    private List f21515e;
    /* renamed from: f */
    private final int f21516f = 2132344833;
    /* renamed from: g */
    private final int f21517g = 2132344834;
    /* renamed from: h */
    private final int f21518h = 2132344836;
    /* renamed from: i */
    private final int f21519i = 2132344837;
    /* renamed from: j */
    private final int f21520j = 2132344838;
    /* renamed from: k */
    private final int f21521k = 2132344839;
    /* renamed from: l */
    private final int f21522l = 2132344840;
    /* renamed from: m */
    private final int f21523m = 2132344842;
    /* renamed from: n */
    private final int f21524n = 2132344844;
    /* renamed from: o */
    private final int f21525o = 2132344845;
    /* renamed from: p */
    private final int f21526p = 2132344846;
    /* renamed from: q */
    private int f21527q = -1;
    /* renamed from: r */
    private Button f21528r;
    /* renamed from: s */
    private ImageView f21529s;
    /* renamed from: t */
    private TextView f21530t;
    /* renamed from: u */
    private ListView f21531u;
    /* renamed from: v */
    private cw f21532v;
    /* renamed from: w */
    private View f21533w;
    /* renamed from: x */
    private View f21534x;
    /* renamed from: z */
    private ExecutorService f21535z;

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            finish();
            try {
                overridePendingTransition(C5216i.m17758a(getApplicationContext(), "ufo_slide_in_from_left"), C5216i.m17758a(getApplicationContext(), "ufo_slide_out_to_right"));
            } catch (Exception e) {
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        C5167a.f21362h = getIntent().getIntExtra("feedback_channel", 0);
        this.f21535z = Executors.newSingleThreadExecutor();
        this.f21527q = C5216i.m17757a(getApplicationContext(), 10.0f);
        this.f21515e = new ArrayList();
        this.f21511a = new RelativeLayout(this);
        this.f21511a.setId(2132344836);
        this.f21511a.setBackgroundColor(C5167a.f21379y);
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(2132344837);
        try {
            relativeLayout.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_nav_bg.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(2132344838);
        this.f21513c = new LinearLayout(this);
        this.f21513c.setId(2132344839);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams2.setMargins(C5216i.m17757a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.f21529s = new ImageView(this);
        this.f21529s.setId(2132344833);
        this.f21529s.setScaleType(ScaleType.CENTER_CROP);
        this.f21529s.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_back_icon.png")));
        linearLayout2.addView(this.f21529s, layoutParams2);
        View textView = new TextView(this);
        textView.setText(C5167a.f21361g);
        textView.setTextSize(C5167a.f21339K);
        textView.setTextColor(C5167a.f21332D);
        textView.setGravity(16);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, C5216i.m17757a(getApplicationContext(), 8.0f), 0);
        linearLayout2.addView(textView, layoutParams3);
        layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        relativeLayout.addView(linearLayout2, layoutParams2);
        textView = new TextView(this);
        textView.setId(2132344834);
        textView.setText(C5228u.m17794a(PerformStatItem.RP_SUCCESS_NORMAL_STEP_INDEX));
        textView.setTextSize(C5167a.f21351W);
        textView.setGravity(17);
        textView.setTextColor(C5167a.f21373s);
        textView.setBackgroundDrawable(null);
        layoutParams3 = new LayoutParams(-2, -1);
        layoutParams3.addRule(13);
        relativeLayout.addView(textView, layoutParams3);
        new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, this.f21527q, 0);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        this.f21531u = new ListView(this);
        this.f21531u.setSelector(new ColorDrawable(0));
        this.f21531u.setCacheColorHint(-1);
        this.f21531u.setDivider(new ColorDrawable(C5167a.f21331C));
        this.f21531u.setDividerHeight(1);
        this.f21513c.addView(this.f21531u, new LinearLayout.LayoutParams(-1, -1));
        layoutParams2 = new LayoutParams(-1, -1);
        layoutParams2.addRule(3, relativeLayout.getId());
        layoutParams2.addRule(2, linearLayout.getId());
        this.f21511a.addView(this.f21513c, layoutParams2);
        this.f21530t = new TextView(this);
        this.f21530t.setText(C5228u.m17794a("20"));
        this.f21530t.setTextSize(C5167a.f21352X);
        ViewGroup.LayoutParams layoutParams4 = new LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.f21511a.addView(this.f21530t, layoutParams4);
        this.f21530t.setVisibility(8);
        this.f21512b = new LinearLayout(this);
        this.f21512b.setOrientation(1);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        textView = new ImageView(this);
        layoutParams3 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 115.0f), C5216i.m17757a(getApplicationContext(), 101.0f));
        try {
            textView.setBackgroundDrawable(C5225r.m17786a(getApplicationContext(), "ufo_no_netwrok.png"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f21512b.addView(textView, layoutParams3);
        this.f21514d = new TextView(this);
        this.f21514d.setTextColor(-10066330);
        this.f21514d.setPadding(C5216i.m17757a(getApplicationContext(), 10.0f), C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 10.0f), C5216i.m17757a(getApplicationContext(), 11.0f));
        this.f21514d.setTextSize(C5167a.f21341M);
        layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        C5216i.m17762a(getApplicationContext(), this.f21514d);
        this.f21512b.addView(this.f21514d, layoutParams4);
        this.f21528r = new Button(this);
        this.f21528r.setText(C5228u.m17794a("22"));
        this.f21528r.setTextSize(C5167a.f21342N);
        this.f21528r.setTextColor(-13421773);
        try {
            this.f21528r.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        this.f21512b.addView(this.f21528r, new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 122.0f), C5216i.m17757a(getApplicationContext(), 40.0f)));
        layoutParams4 = new LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.f21511a.addView(this.f21512b, layoutParams4);
        this.f21512b.setGravity(17);
        this.f21512b.setVisibility(8);
        layoutParams4 = new LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams4.addRule(10);
        this.f21511a.addView(relativeLayout, layoutParams4);
        setContentView(this.f21511a, new ViewGroup.LayoutParams(-1, -1));
        this.f21533w = C5216i.m17765b(this, C5228u.m17794a("13"));
        layoutParams4 = new LayoutParams(C5216i.m17757a(getApplicationContext(), 114.0f), C5216i.m17757a(getApplicationContext(), 39.0f));
        layoutParams4.addRule(13);
        this.f21511a.addView(this.f21533w, layoutParams4);
        this.f21534x = C5216i.m17765b(this, C5228u.m17794a("4"));
        layoutParams4 = new LayoutParams(C5216i.m17757a(getApplicationContext(), 114.0f), C5216i.m17757a(getApplicationContext(), 39.0f));
        layoutParams4.addRule(13);
        this.f21534x.setVisibility(8);
        this.f21511a.addView(this.f21534x, layoutParams4);
        linearLayout2.setOnClickListener(new cm(this));
        this.f21528r.setOnClickListener(new cn(this));
        this.f21532v = new cw(this, this);
        this.f21531u.setAdapter(this.f21532v);
        this.f21531u.setFocusable(false);
        this.f21531u.setCacheColorHint(-1);
        this.f21531u.setDividerHeight(1);
        this.f21531u.setRecyclerListener(new cq(this));
        this.f21531u.setOnItemClickListener(new cr(this));
        this.f21531u.setOnItemLongClickListener(new cs(this));
    }

    protected void onRestart() {
        super.onRestart();
    }

    public void onResume() {
        super.onResume();
        if (C5167a.ah != null) {
            C5167a.ah.onResumeCallback();
        }
        this.f21530t.setText(C5228u.m17794a("20"));
        ((TextView) findViewById(2132344834)).setText((CharSequence) C5167a.ag.get(PerformStatItem.RP_SUCCESS_NORMAL_STEP_INDEX));
        this.f21528r.setText(C5228u.m17794a("22"));
        C5216i.m17763a((RelativeLayout) this.f21533w, C5228u.m17794a("13"));
        C5216i.m17763a((RelativeLayout) this.f21534x, C5228u.m17794a("4"));
        for (int i = 0; i < this.f21515e.size(); i++) {
            if (!((String) ((Map) this.f21515e.get(i)).get("newmsg")).equals("0")) {
                this.f21509B.obtainMessage(2, Integer.valueOf(i)).sendToTarget();
                break;
            }
        }
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new ct(this)).start();
        } else {
            this.f21535z.execute(new cu(this));
        }
    }

    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ufosdk.gethistorylist");
        intentFilter.addAction("com.baidu.ufosdk.getnewhistoryflag");
        intentFilter.addAction("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag");
        intentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
        intentFilter.addAction("com.baidu.ufosdk.reload");
        registerReceiver(this.f21510C, intentFilter);
    }

    public void onPause() {
        super.onPause();
        try {
            if (f21507y != null) {
                f21507y.m17553a();
                f21507y = null;
            }
            this.f21534x.setVisibility(8);
            unregisterReceiver(this.f21510C);
        } catch (Exception e) {
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: a */
    public static String m17686a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        Date date = new Date(Long.parseLong(str));
        return new StringBuilder(String.valueOf(new SimpleDateFormat("dd").format(date))).append("\n").append(simpleDateFormat.format(date).replace("星期", "周")).toString();
    }

    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: b */
    public static String m17691b(String str) {
        return new SimpleDateFormat("yyyy年MM月").format(new Date(Long.parseLong(str)));
    }

    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: a */
    public static boolean m17690a(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
        if (simpleDateFormat.format(new Date(Long.parseLong(str2))).equals(simpleDateFormat.format(new Date(Long.parseLong(str))))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private View m17683a(Context context, String str, String str2) {
        View relativeLayout = new RelativeLayout(context);
        View relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setBackgroundDrawable(null);
        try {
            relativeLayout.setBackgroundDrawable(C5225r.m17786a(context, "ufo_delete_bg.9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(C5216i.m17757a(context, 19.0f), C5216i.m17757a(context, 23.0f));
        relativeLayout2.setLayoutParams(layoutParams);
        View imageView = new ImageView(context);
        imageView.setId(2132345067);
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setAdjustViewBounds(true);
        imageView.setImageBitmap(C5223p.m17779a(context, "ufo_delete_btn_icon.png"));
        layoutParams.addRule(14);
        relativeLayout2.addView(imageView, layoutParams);
        View textView = new TextView(context);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.setMargins(0, C5216i.m17757a(context, 5.0f), 0, 0);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(C5167a.ab);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, imageView.getId());
        relativeLayout2.addView(textView, layoutParams2);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        relativeLayout2.setPadding(0, 0, 0, 0);
        layoutParams.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams);
        relativeLayout.setOnClickListener(new ch(this, context, str2));
        return relativeLayout;
    }

    /* renamed from: k */
    static /* synthetic */ void m17701k(FeedbackListActivity feedbackListActivity) {
        if (f21507y == null) {
            f21507y = new C5166b(feedbackListActivity.getApplicationContext());
        }
        f21507y.m17554b();
        if (!f21507y.isAlive()) {
            f21507y.start();
        }
    }

    /* renamed from: m */
    static /* synthetic */ Bitmap m17703m(FeedbackListActivity feedbackListActivity) {
        int a = C5216i.m17757a(feedbackListActivity.getApplicationContext(), 20.0f);
        Bitmap createBitmap = Bitmap.createBitmap(a, a, Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setColor(-1551537);
        canvas.drawCircle((float) (a / 2), (float) (a / 2), (float) (a / 2), paint);
        return createBitmap;
    }
}
