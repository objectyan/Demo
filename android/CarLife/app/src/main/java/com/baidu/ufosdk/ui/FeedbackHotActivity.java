package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p248b.C5170c;
import com.baidu.ufosdk.p248b.C5171d;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5223p;
import com.baidu.ufosdk.util.C5225r;
import com.baidu.ufosdk.util.C5228u;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"InlinedApi", "SetJavaScriptEnabled", "JavascriptInterface", "NewApi"})
public class FeedbackHotActivity extends Activity {
    /* renamed from: a */
    private final int f21436a = C0965R.string.add_rescue_info;
    /* renamed from: b */
    private final int f21437b = C0965R.string.agreement;
    /* renamed from: c */
    private final int f21438c = C0965R.string.alert_cancel;
    /* renamed from: d */
    private final int f21439d = C0965R.string.alert_clean;
    /* renamed from: e */
    private final String f21440e = "UfoCacheFile";
    /* renamed from: f */
    private RelativeLayout f21441f;
    /* renamed from: g */
    private LinearLayout f21442g;
    /* renamed from: h */
    private ImageView f21443h;
    /* renamed from: i */
    private WebView f21444i;
    /* renamed from: j */
    private Button f21445j;
    /* renamed from: k */
    private View f21446k;
    /* renamed from: l */
    private TextView f21447l;
    /* renamed from: m */
    private TextView f21448m;
    /* renamed from: n */
    private String f21449n = "";
    /* renamed from: o */
    private String f21450o = "";
    /* renamed from: p */
    private Timer f21451p;
    @SuppressLint({"NewApi", "HandlerLeak"})
    /* renamed from: q */
    private Handler f21452q = new ab(this);

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
        try {
            overridePendingTransition(C5216i.m17758a(getApplicationContext(), "ufo_slide_in_from_right"), C5216i.m17758a(getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception e) {
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        this.f21441f = new RelativeLayout(this);
        this.f21441f.setId(C0965R.string.alert_clean);
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(C0965R.string.alert_cancel);
        this.f21441f.setBackgroundColor(C5167a.f21379y);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.f21442g = new LinearLayout(this);
        this.f21442g.setOrientation(1);
        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        View imageView = new ImageView(this);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 115.0f), C5216i.m17757a(getApplicationContext(), 101.0f));
        try {
            imageView.setBackgroundDrawable(C5225r.m17786a(getApplicationContext(), "ufo_no_netwrok.png"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f21442g.addView(imageView, layoutParams3);
        this.f21447l = new TextView(this);
        this.f21447l.setPadding(C5216i.m17757a(getApplicationContext(), 10.0f), C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 10.0f), C5216i.m17757a(getApplicationContext(), 11.0f));
        this.f21447l.setTextSize(C5167a.f21341M);
        this.f21447l.setTextColor(-10066330);
        ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        C5216i.m17762a(getApplicationContext(), this.f21447l);
        this.f21442g.addView(this.f21447l, layoutParams4);
        this.f21445j = new Button(this);
        this.f21445j.setText(C5228u.m17794a("22"));
        this.f21445j.setTextSize(C5167a.f21342N);
        this.f21445j.setTextColor(-13421773);
        try {
            this.f21445j.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        this.f21442g.addView(this.f21445j, new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 122.0f), C5216i.m17757a(getApplicationContext(), 40.0f)));
        layoutParams4 = new LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.f21441f.addView(this.f21442g, layoutParams4);
        this.f21442g.setGravity(17);
        this.f21442g.setVisibility(8);
        imageView = new LinearLayout(this);
        imageView.setOrientation(0);
        imageView.setGravity(16);
        imageView.setBackgroundDrawable(C5223p.m17781a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        layoutParams4 = new LinearLayout.LayoutParams(C5216i.m17757a(getApplicationContext(), 18.0f), C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams4.setMargins(C5216i.m17757a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.f21443h = new ImageView(this);
        this.f21443h.setId(C0965R.string.add_rescue_info);
        this.f21443h.setScaleType(ScaleType.CENTER_CROP);
        this.f21443h.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_back_icon.png")));
        imageView.addView(this.f21443h, layoutParams4);
        View textView = new TextView(this);
        textView.setText(C5167a.f21361g);
        textView.setTextSize(C5167a.f21339K);
        textView.setTextColor(C5167a.f21332D);
        textView.setGravity(16);
        layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, C5216i.m17757a(getApplicationContext(), 8.0f), 0);
        imageView.addView(textView, layoutParams3);
        layoutParams4 = new LayoutParams(-2, -2);
        layoutParams4.addRule(9);
        layoutParams4.addRule(15);
        relativeLayout.addView(imageView, layoutParams4);
        this.f21448m = new TextView(this);
        this.f21448m.setId(C0965R.string.agreement);
        this.f21448m.setText(C5228u.m17794a(NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL));
        this.f21448m.setTextColor(C5167a.f21373s);
        this.f21448m.setTextSize(C5167a.f21345Q);
        this.f21448m.setGravity(17);
        layoutParams4 = new LayoutParams(-2, -1);
        layoutParams4.addRule(13);
        relativeLayout.addView(this.f21448m, layoutParams4);
        try {
            relativeLayout.setBackgroundDrawable(new BitmapDrawable(C5223p.m17779a(getApplicationContext(), "ufo_nav_bg.png")));
        } catch (Exception e222) {
            e222.printStackTrace();
        }
        layoutParams4 = new LayoutParams(-1, C5216i.m17757a(getApplicationContext(), 50.0f));
        layoutParams4.addRule(10);
        this.f21441f.addView(relativeLayout, layoutParams4);
        this.f21444i = new WebView(this);
        this.f21444i.setBackgroundColor(C5167a.f21379y);
        this.f21444i.getSettings().setRenderPriority(RenderPriority.HIGH);
        layoutParams4 = new LayoutParams(-1, -1);
        layoutParams4.addRule(12);
        layoutParams4.addRule(3, relativeLayout.getId());
        this.f21441f.addView(this.f21444i, layoutParams4);
        layoutParams = new LayoutParams(-1, -1);
        this.f21441f.setLayoutParams(layoutParams3);
        setContentView(this.f21441f);
        this.f21446k = C5216i.m17765b(this, C5228u.m17794a("13"));
        layoutParams4 = new LayoutParams(C5216i.m17757a(getApplicationContext(), 114.0f), C5216i.m17757a(getApplicationContext(), 39.0f));
        layoutParams4.addRule(13);
        this.f21441f.addView(this.f21446k, layoutParams4);
        this.f21444i.getSettings().setJavaScriptEnabled(true);
        this.f21444i.getSettings().setBlockNetworkImage(false);
        try {
            this.f21444i.getClass().getMethod("removeJavascriptInterface", new Class[]{String.class});
            this.f21444i.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f21444i.removeJavascriptInterface("accessibility");
            this.f21444i.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e3) {
            C5210c.m17732a("webView-->This API level do not support `removeJavascriptInterface`");
        }
        if (C5170c.m17557b(getApplicationContext()).contains("UNKNOWN") || C5170c.m17557b(getApplicationContext()).contains("NONE")) {
            this.f21444i.getSettings().setCacheMode(1);
            this.f21446k.setVisibility(8);
        } else {
            this.f21442g.setVisibility(8);
            this.f21444i.setVisibility(0);
            this.f21444i.getSettings().setCacheMode(-1);
        }
        this.f21444i.getSettings().setAppCacheMaxSize(8388608);
        String stringBuilder = new StringBuilder(String.valueOf(getApplicationContext().getFilesDir().getAbsolutePath())).append("UfoCacheFile").toString();
        File file = new File(new StringBuilder(String.valueOf(getFilesDir().getAbsolutePath())).append("UfoCacheFile").toString());
        if (!file.exists()) {
            file.mkdir();
        }
        this.f21444i.getSettings().setDatabaseEnabled(true);
        this.f21444i.getSettings().setDatabasePath(stringBuilder);
        this.f21444i.getSettings().setAppCachePath(stringBuilder);
        this.f21444i.getSettings().setAppCacheEnabled(true);
        this.f21444i.setWebViewClient(new ag());
        imageView.setOnClickListener(new ac(this));
        this.f21445j.setOnClickListener(new ad(this));
        m17612a();
    }

    /* renamed from: a */
    private void m17612a() {
        if (UfoSDK.clientid.length() != 0) {
            this.f21449n = getIntent().getStringExtra("hoturl");
            if (!TextUtils.isEmpty(this.f21449n)) {
                C5210c.m17734b("****url is " + this.f21449n);
                this.f21449n = this.f21449n.replace("http://ufosdk.baidu.com/", C5167a.ak);
                C5210c.m17734b("****url is222" + this.f21449n);
                String[] split = this.f21449n.split("&");
                if (split.length > 0) {
                    for (String str : split) {
                        String str2;
                        if (str2.startsWith("faq_id=")) {
                            str2 = str2.replace("faq_id=", "");
                            try {
                                Integer.parseInt(str2);
                                this.f21450o = str2;
                            } catch (NumberFormatException e) {
                                this.f21450o = "";
                            }
                        }
                    }
                }
                if (this.f21449n.contains("uxsurvey.baidu.com")) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("os", "android");
                        jSONObject.put("appvn", C5171d.m17561c());
                        jSONObject.put("devid", UfoSDK.devid);
                        jSONObject.put("osvn", VERSION.RELEASE);
                        jSONObject.put("appname", C5171d.m17558a());
                        jSONObject.put("channel_id", C5167a.f21362h);
                        jSONObject.put("nettype", C5170c.m17557b(this));
                        jSONObject.put("model", Build.MODEL);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    Object obj = "";
                    if (jSONObject.length() > 0) {
                        obj = jSONObject.toString();
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("refertype", "mobile");
                    hashMap.put("newreferer", obj);
                    if (C5216i.m17756a() >= 8) {
                        this.f21444i.loadUrl(this.f21449n, hashMap);
                    } else {
                        this.f21444i.loadUrl(this.f21449n);
                    }
                } else if (this.f21449n.contains("http")) {
                    this.f21444i.loadUrl(this.f21449n);
                } else {
                    this.f21444i.loadUrl("https://" + this.f21449n);
                }
            }
        }
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onResume() {
        super.onResume();
        if (C5167a.ah != null) {
            C5167a.ah.onResumeCallback();
        }
        this.f21445j.setText(C5228u.m17794a("22"));
        this.f21448m.setText(C5228u.m17794a(NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL));
        C5216i.m17763a((RelativeLayout) this.f21446k, C5228u.m17794a("13"));
        this.f21444i.resumeTimers();
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new ae(this)).start();
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m17617e(FeedbackHotActivity feedbackHotActivity) {
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(feedbackHotActivity.getApplicationContext(), C5228u.m17794a("18"), 1).show();
            if (!C5170c.m17557b(feedbackHotActivity.getApplicationContext()).contains("UNKNOWN") && !C5170c.m17557b(feedbackHotActivity.getApplicationContext()).contains("NONE")) {
                new Thread(new af(feedbackHotActivity)).start();
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setClass(feedbackHotActivity, FeedbackInputActivity.class);
        intent.putExtra("msgid", "newMessage");
        intent.putExtra("faq_id", feedbackHotActivity.f21450o);
        intent.putExtra("currentview", 1);
        intent.putExtra("continue", 1);
        intent.putExtra("feedback_channel", C5167a.f21362h);
        feedbackHotActivity.startActivity(intent);
        feedbackHotActivity.finish();
        try {
            feedbackHotActivity.overridePendingTransition(C5216i.m17758a(feedbackHotActivity.getApplicationContext(), "ufo_slide_in_from_right"), C5216i.m17758a(feedbackHotActivity.getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception e) {
        }
    }
}
