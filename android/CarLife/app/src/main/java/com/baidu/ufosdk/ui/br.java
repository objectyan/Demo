package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5208a;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5223p;
import com.baidu.ufosdk.util.C5224q;
import com.baidu.ufosdk.util.C5225r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FeedbackInputActivity */
public final class br extends BaseAdapter {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21586a;
    /* renamed from: b */
    private Context f21587b;

    public br(FeedbackInputActivity feedbackInputActivity, Context context) {
        this.f21586a = feedbackInputActivity;
        this.f21587b = context;
    }

    public final int getCount() {
        return this.f21586a.f21471O.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (((Integer) ((Map) this.f21586a.f21471O.get(i)).get(PlatformConstants.CONNECT_EXTRA_KEY)).equals(Integer.valueOf(0))) {
            if (((String) ((Map) this.f21586a.f21471O.get(i)).get("contenttype")).contentEquals("1")) {
                i2 = 1;
            } else if (((String) ((Map) this.f21586a.f21471O.get(i)).get("contenttype")).contentEquals("2")) {
                i2 = 1;
            } else {
                i2 = 2;
            }
        } else if (!((Integer) ((Map) this.f21586a.f21471O.get(i)).get(PlatformConstants.CONNECT_EXTRA_KEY)).equals(Integer.valueOf(1))) {
            i2 = 3;
        } else if (((String) ((Map) this.f21586a.f21471O.get(i)).get("contenttype")).contentEquals("1")) {
            i2 = 4;
        } else if (((String) ((Map) this.f21586a.f21471O.get(i)).get("contenttype")).contentEquals("2")) {
            i2 = 4;
        } else if (((Map) this.f21586a.f21471O.get(i)).get("content").toString().startsWith("http://bs.baidu.com") || ((Map) this.f21586a.f21471O.get(i)).get("content").toString().startsWith("https://bs.baidu.com")) {
            i2 = 4;
        } else {
            i2 = 3;
        }
        cc ccVar = null;
        cd cdVar = null;
        ce ceVar = null;
        cf cfVar = null;
        if (view == null || ((Integer) view.getTag(C0965R.menu.base)).intValue() != i2) {
            View relativeLayout;
            View relativeLayout2;
            View relativeLayout3;
            View textView;
            LayoutParams layoutParams;
            View relativeLayout4;
            View imageView;
            LayoutParams layoutParams2;
            if (i2 == 1) {
                ceVar = new ce();
                relativeLayout = new RelativeLayout(this.f21587b);
                relativeLayout2 = new RelativeLayout(this.f21587b);
                relativeLayout3 = new RelativeLayout(this.f21587b);
                relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                relativeLayout3.setId(C0965R.string.alert_confirm);
                textView = new TextView(this.f21586a);
                try {
                    textView.setBackgroundDrawable(C5225r.m17786a(this.f21586a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                textView.setTextColor(-1);
                textView.setTextSize(C5167a.f21343O);
                textView.setGravity(17);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setPadding(C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 2, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f));
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams.addRule(14);
                relativeLayout3.addView(textView, layoutParams);
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout3.setPadding(0, C5216i.m17757a(this.f21586a.getApplicationContext(), 6.0f), 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f));
                relativeLayout.addView(relativeLayout3, layoutParams);
                ceVar.f21607a = textView;
                ceVar.f21610d = relativeLayout3;
                textView = new ImageView(this.f21586a);
                textView.setId(C0965R.string.alert_close);
                layoutParams = new RelativeLayout.LayoutParams(C5216i.m17757a(this.f21586a.getApplicationContext(), 40.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 40.0f));
                layoutParams.addRule(11);
                layoutParams.setMargins(C5216i.m17757a(this.f21586a.getApplicationContext(), 6.0f), 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f), 0);
                relativeLayout2.addView(textView, layoutParams);
                ceVar.f21608b = textView;
                relativeLayout4 = new RelativeLayout(this.f21586a);
                try {
                    relativeLayout4.setBackgroundDrawable(C5225r.m17786a(this.f21586a.getApplicationContext(), "ufo_me_send_bg.9.png"));
                    relativeLayout4.setPadding(C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 10, C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 5, C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 10, C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 5);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                imageView = new ImageView(this.f21586a);
                imageView.setOnClickListener(new bs(this));
                imageView.setScaleType(ScaleType.FIT_XY);
                if (C5216i.m17756a() < 23) {
                    imageView.setAdjustViewBounds(true);
                }
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 0, 0, 0);
                relativeLayout4.addView(imageView, layoutParams2);
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 0, 0, 0);
                layoutParams2.addRule(0, textView.getId());
                relativeLayout2.addView(relativeLayout4, layoutParams2);
                ceVar.f21609c = imageView;
                relativeLayout2.setPadding(0, 0, 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f));
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(3, relativeLayout3.getId());
                relativeLayout.addView(relativeLayout2, layoutParams);
                relativeLayout.setOnClickListener(new bt(this));
                relativeLayout.setTag(C0965R.menu.main, ceVar);
                relativeLayout.setTag(C0965R.menu.base, Integer.valueOf(i2));
            } else if (i2 == 2) {
                cfVar = new cf();
                relativeLayout = new RelativeLayout(this.f21587b);
                relativeLayout2 = new RelativeLayout(this.f21587b);
                relativeLayout3 = new RelativeLayout(this.f21587b);
                relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                relativeLayout3.setId(C0965R.string.alert_confirm);
                textView = new TextView(this.f21586a);
                try {
                    textView.setBackgroundDrawable(C5225r.m17786a(this.f21586a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
                textView.setTextColor(-1);
                textView.setTextSize(C5167a.f21343O);
                textView.setGravity(17);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setPadding(C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 2, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f));
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams.addRule(14);
                relativeLayout3.addView(textView, layoutParams);
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout3.setPadding(0, C5216i.m17757a(this.f21586a.getApplicationContext(), 6.0f), 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f));
                relativeLayout.addView(relativeLayout3, layoutParams);
                cfVar.f21611a = textView;
                cfVar.f21614d = relativeLayout3;
                textView = new ImageView(this.f21586a);
                textView.setId(C0965R.string.alert_close);
                layoutParams = new RelativeLayout.LayoutParams(C5216i.m17757a(this.f21586a.getApplicationContext(), 40.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 40.0f));
                layoutParams.addRule(11);
                layoutParams.setMargins(C5216i.m17757a(this.f21586a.getApplicationContext(), 6.0f), 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f), 0);
                relativeLayout2.addView(textView, layoutParams);
                cfVar.f21612b = textView;
                relativeLayout4 = new TextView(this.f21586a);
                relativeLayout4.setTextColor(-13421773);
                relativeLayout4.setTextSize(C5167a.f21344P);
                relativeLayout4.setLineSpacing(4.0f, 1.0f);
                try {
                    relativeLayout4.setBackgroundDrawable(C5225r.m17786a(this.f21586a.getApplicationContext(), "ufo_me_send_bg.9.png"));
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (Exception e222) {
                    e222.printStackTrace();
                }
                relativeLayout4.setGravity(16);
                relativeLayout4.setPadding(C5216i.m17757a(this.f21586a.getApplicationContext(), 21.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 22.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f));
                relativeLayout4.setLineSpacing(5.0f, 1.0f);
                relativeLayout4.setAutoLinkMask(1);
                relativeLayout4.setMovementMethod(LinkMovementMethod.getInstance());
                relativeLayout4.setOnLongClickListener(new bu(this));
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(C5216i.m17757a(this.f21586a.getApplicationContext(), 26.0f), 0, 0, 0);
                layoutParams.addRule(0, textView.getId());
                relativeLayout2.addView(relativeLayout4, layoutParams);
                cfVar.f21613c = relativeLayout4;
                relativeLayout2.setPadding(0, 0, 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f));
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(3, relativeLayout3.getId());
                relativeLayout.addView(relativeLayout2, layoutParams);
                relativeLayout.setOnClickListener(new bv(this));
                relativeLayout.setTag(C0965R.menu.main, cfVar);
                relativeLayout.setTag(C0965R.menu.base, Integer.valueOf(i2));
            } else if (i2 == 3) {
                cdVar = new cd();
                relativeLayout = new RelativeLayout(this.f21587b);
                relativeLayout2 = new RelativeLayout(this.f21587b);
                relativeLayout3 = new RelativeLayout(this.f21587b);
                relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                relativeLayout3.setId(C0965R.string.alert_confirm);
                textView = new TextView(this.f21586a);
                try {
                    textView.setBackgroundDrawable(C5225r.m17786a(this.f21586a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e2222) {
                    e2222.printStackTrace();
                }
                textView.setTextColor(-1);
                textView.setTextSize(C5167a.f21343O);
                textView.setGravity(17);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setPadding(C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 2, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f));
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams.addRule(14);
                relativeLayout3.addView(textView, layoutParams);
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout3.setPadding(0, C5216i.m17757a(this.f21586a.getApplicationContext(), 6.0f), 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f));
                relativeLayout.addView(relativeLayout3, layoutParams);
                cdVar.f21603a = textView;
                cdVar.f21606d = relativeLayout3;
                textView = new ImageView(this.f21586a);
                textView.setId(C0965R.string.alert_close);
                layoutParams = new RelativeLayout.LayoutParams(C5216i.m17757a(this.f21586a.getApplicationContext(), 40.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 40.0f));
                layoutParams.setMargins(C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f), 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 4.0f), 0);
                layoutParams.addRule(9);
                relativeLayout2.addView(textView, layoutParams);
                cdVar.f21604b = textView;
                relativeLayout4 = new TextView(this.f21586a);
                try {
                    relativeLayout4.setBackgroundDrawable(C5225r.m17786a(this.f21586a.getApplicationContext(), "ufo_server_send_bg.9.png"));
                } catch (IOException e32) {
                    e32.printStackTrace();
                } catch (Exception e22222) {
                    e22222.printStackTrace();
                }
                relativeLayout4.setPadding(C5216i.m17757a(this.f21586a.getApplicationContext(), 23.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 9.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 17.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 7.0f));
                relativeLayout4.setGravity(16);
                relativeLayout4.setLineSpacing(5.0f, 1.0f);
                relativeLayout4.setTextColor(-13421773);
                relativeLayout4.setTextSize(C5167a.f21344P);
                relativeLayout4.setAutoLinkMask(1);
                relativeLayout4.setMovementMethod(LinkMovementMethod.getInstance());
                relativeLayout4.setOnLongClickListener(new bw(this));
                relativeLayout4.setOnClickListener(new bx(this));
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 27.0f), 0);
                layoutParams.addRule(1, textView.getId());
                relativeLayout2.addView(relativeLayout4, layoutParams);
                cdVar.f21605c = relativeLayout4;
                relativeLayout2.setPadding(0, 0, 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f));
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(3, relativeLayout3.getId());
                relativeLayout.addView(relativeLayout2, layoutParams);
                relativeLayout.setOnClickListener(new by(this));
                relativeLayout.setTag(C0965R.menu.main, cdVar);
                relativeLayout.setTag(C0965R.menu.base, Integer.valueOf(i2));
            } else if (i2 == 4) {
                ccVar = new cc();
                relativeLayout = new RelativeLayout(this.f21587b);
                relativeLayout2 = new RelativeLayout(this.f21587b);
                relativeLayout3 = new RelativeLayout(this.f21587b);
                relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                relativeLayout3.setId(C0965R.string.alert_confirm);
                textView = new TextView(this.f21586a);
                try {
                    textView.setBackgroundDrawable(C5225r.m17786a(this.f21586a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e222222) {
                    e222222.printStackTrace();
                }
                textView.setTextColor(-1);
                textView.setTextSize(C5167a.f21343O);
                textView.setGravity(17);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setPadding(C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 2, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f));
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams.addRule(14);
                relativeLayout3.addView(textView, layoutParams);
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout3.setPadding(0, C5216i.m17757a(this.f21586a.getApplicationContext(), 6.0f), 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f));
                relativeLayout.addView(relativeLayout3, layoutParams);
                ccVar.f21599a = textView;
                ccVar.f21602d = relativeLayout3;
                textView = new ImageView(this.f21586a);
                textView.setId(C0965R.string.alert_close);
                layoutParams = new RelativeLayout.LayoutParams(C5216i.m17757a(this.f21586a.getApplicationContext(), 40.0f), C5216i.m17757a(this.f21586a.getApplicationContext(), 40.0f));
                layoutParams.setMargins(C5216i.m17757a(this.f21586a.getApplicationContext(), 8.0f), 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 4.0f), 0);
                layoutParams.addRule(9);
                relativeLayout2.addView(textView, layoutParams);
                ccVar.f21600b = textView;
                relativeLayout4 = new RelativeLayout(this.f21586a);
                try {
                    relativeLayout4.setBackgroundDrawable(C5225r.m17786a(this.f21586a.getApplicationContext(), "ufo_server_send_bg.9.png"));
                    relativeLayout4.setPadding(C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 10, C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 5, C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 10, C5216i.m17757a(this.f21586a.getApplicationContext(), 2.0f) + 5);
                } catch (Exception e2222222) {
                    e2222222.printStackTrace();
                }
                imageView = new ImageView(this.f21586a);
                imageView.setOnClickListener(new bz(this));
                imageView.setScaleType(ScaleType.FIT_XY);
                if (C5216i.m17756a() < 23) {
                    imageView.setAdjustViewBounds(true);
                }
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 0, 0, 0);
                relativeLayout4.addView(imageView, layoutParams2);
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 0, 0, 0);
                layoutParams2.addRule(1, textView.getId());
                relativeLayout2.addView(relativeLayout4, layoutParams2);
                ccVar.f21601c = imageView;
                relativeLayout2.setPadding(0, 0, 0, C5216i.m17757a(this.f21586a.getApplicationContext(), 10.0f));
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(3, relativeLayout3.getId());
                relativeLayout.addView(relativeLayout2, layoutParams);
                relativeLayout.setOnClickListener(new ca(this));
                relativeLayout.setTag(C0965R.menu.main, ccVar);
                relativeLayout.setTag(C0965R.menu.base, Integer.valueOf(i2));
            }
        } else if (i2 == 1) {
            ceVar = (ce) view.getTag(C0965R.menu.main);
        } else if (i2 == 2) {
            cfVar = (cf) view.getTag(C0965R.menu.main);
        } else if (i2 == 3) {
            cdVar = (cd) view.getTag(C0965R.menu.main);
        } else if (i2 == 4) {
            ccVar = (cc) view.getTag(C0965R.menu.main);
        }
        long parseLong;
        long parseLong2;
        String str;
        Bitmap a;
        if (i2 == 1) {
            ceVar.f21610d.setVisibility(0);
            if (i == 0) {
                ceVar.f21607a.setText(C5216i.m17760a(Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i)).get(BaiduNaviParams.KEY_TIME))));
            }
            if (i != 0) {
                parseLong = Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i - 1)).get(BaiduNaviParams.KEY_TIME));
                parseLong2 = Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i)).get(BaiduNaviParams.KEY_TIME));
                if (parseLong - parseLong2 > 3600000 || parseLong2 - parseLong > 3600000) {
                    ceVar.f21607a.setText(C5216i.m17766b(parseLong2));
                    if (parseLong - parseLong2 > 86400000 || parseLong2 - parseLong > 86400000) {
                        ceVar.f21607a.setText(C5216i.m17760a(parseLong2));
                    }
                } else {
                    ceVar.f21610d.setVisibility(8);
                }
            }
            try {
                ceVar.f21608b.setBackgroundDrawable(new BitmapDrawable(C5223p.m17784c(this.f21586a.getApplicationContext())));
            } catch (Exception e22222222) {
                e22222222.printStackTrace();
            }
            if (((String) ((Map) this.f21586a.f21471O.get(i)).get("contenttype")).contentEquals("1")) {
                str = (String) ((Map) this.f21586a.f21471O.get(i)).get("content");
                ceVar.f21609c.setImageBitmap(C5223p.m17779a(this.f21587b, "ufo_pic_defult_icon.png"));
                a = C5208a.m17729a().m17731a(new C5224q(this.f21586a.getApplicationContext(), ceVar.f21609c, this.f21586a.ak), str);
                if (a != null) {
                    FeedbackInputActivity.f21455a.add(a);
                    ceVar.f21609c.setImageBitmap(a);
                    if (a.getHeight() > a.getWidth()) {
                        ceVar.f21609c.setMaxWidth(C5216i.m17757a(this.f21586a.getApplicationContext(), 80.0f));
                        ceVar.f21609c.setMaxHeight(C5216i.m17757a(this.f21586a.getApplicationContext(), 120.0f));
                    } else {
                        ceVar.f21609c.setMaxWidth(C5216i.m17757a(this.f21586a.getApplicationContext(), 120.0f));
                        ceVar.f21609c.setMaxHeight(C5216i.m17757a(this.f21586a.getApplicationContext(), 80.0f));
                    }
                }
            } else if (((String) ((Map) this.f21586a.f21471O.get(i)).get("contenttype")).contentEquals("2") && ceVar.f21609c != null) {
                a = (Bitmap) ((Map) this.f21586a.f21471O.get(i)).get("content");
                if (a.getHeight() > a.getWidth()) {
                    ceVar.f21609c.setMaxWidth(C5216i.m17757a(this.f21586a.getApplicationContext(), 80.0f));
                    ceVar.f21609c.setMaxHeight(C5216i.m17757a(this.f21586a.getApplicationContext(), 120.0f));
                } else {
                    ceVar.f21609c.setMaxWidth(C5216i.m17757a(this.f21586a.getApplicationContext(), 120.0f));
                    ceVar.f21609c.setMaxHeight(C5216i.m17757a(this.f21586a.getApplicationContext(), 80.0f));
                }
                ceVar.f21609c.setImageBitmap(a);
            }
        } else if (i2 == 2) {
            cfVar.f21614d.setVisibility(0);
            if (i == 0) {
                cfVar.f21611a.setText(C5216i.m17760a(Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i)).get(BaiduNaviParams.KEY_TIME))));
            }
            if (i != 0) {
                r4 = Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i - 1)).get(BaiduNaviParams.KEY_TIME));
                parseLong = Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i)).get(BaiduNaviParams.KEY_TIME));
                if (r4 - parseLong > 3600000 || parseLong - r4 > 3600000) {
                    cfVar.f21611a.setText(C5216i.m17766b(parseLong));
                    if (r4 - parseLong > 86400000 || parseLong - r4 > 86400000) {
                        cfVar.f21611a.setText(C5216i.m17760a(parseLong));
                    }
                } else {
                    cfVar.f21614d.setVisibility(8);
                }
            }
            try {
                cfVar.f21612b.setBackgroundDrawable(new BitmapDrawable(C5223p.m17784c(this.f21586a.getApplicationContext())));
            } catch (Exception e222222222) {
                e222222222.printStackTrace();
            }
            cfVar.f21613c.setText((String) ((Map) this.f21586a.f21471O.get(i)).get("content"));
        } else if (i2 == 3) {
            cdVar.f21606d.setVisibility(0);
            if (i == 0) {
                cdVar.f21603a.setText(C5216i.m17760a(Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i)).get(BaiduNaviParams.KEY_TIME))));
            }
            if (i != 0) {
                parseLong = Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i - 1)).get(BaiduNaviParams.KEY_TIME));
                parseLong2 = Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i)).get(BaiduNaviParams.KEY_TIME));
                if (parseLong - parseLong2 > 3600000 || parseLong2 - parseLong > 3600000) {
                    cdVar.f21603a.setText(C5216i.m17766b(parseLong2));
                    if (parseLong - parseLong2 > 86400000 || parseLong2 - parseLong > 86400000) {
                        cdVar.f21603a.setText(C5216i.m17760a(parseLong2));
                    }
                } else {
                    cdVar.f21606d.setVisibility(8);
                }
            }
            r3 = null;
            try {
                r3 = this.f21587b.getApplicationContext().getPackageManager();
                r2 = r3.getApplicationInfo(this.f21587b.getPackageName(), 0);
            } catch (NameNotFoundException e4) {
                r2 = null;
            }
            try {
                cdVar.f21604b.setBackgroundDrawable(new BitmapDrawable(((BitmapDrawable) r3.getApplicationIcon(r2)).getBitmap()));
            } catch (Exception e2222222222) {
                e2222222222.printStackTrace();
            }
            if (cdVar.f21605c != null) {
                str = (String) ((Map) this.f21586a.f21471O.get(i)).get("content");
                if (str.startsWith("http://bs.baidu.com") || str.startsWith("https://bs.baidu.com")) {
                    a = C5208a.m17729a().m17731a(new C5224q(this.f21586a.getApplicationContext(), cdVar.f21605c, this.f21586a.ak), str);
                    if (a != null) {
                        ImageSpan imageSpan = new ImageSpan(this.f21586a.getApplicationContext(), a);
                        CharSequence spannableString = new SpannableString(HUDGuideDataStruct.KEY_ICON_NAME);
                        spannableString.setSpan(imageSpan, 0, 4, 33);
                        cdVar.f21605c.setText(spannableString);
                    }
                } else if (str.contains("我的反馈")) {
                    this.f21586a.f21484d = true;
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-11821318), str.length() - 8, str.length() - 4, 33);
                    cdVar.f21605c.setText(spannableStringBuilder);
                    if (this.f21586a.aj == null) {
                        this.f21586a.aj = new ArrayList();
                        this.f21586a.aj.add(cdVar.f21605c);
                    }
                } else {
                    cdVar.f21605c.setText(str);
                }
            }
        } else if (i2 == 4) {
            ccVar.f21602d.setVisibility(0);
            if (i == 0) {
                ccVar.f21599a.setText(C5216i.m17760a(Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i)).get(BaiduNaviParams.KEY_TIME))));
            }
            if (i != 0) {
                r4 = Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i - 1)).get(BaiduNaviParams.KEY_TIME));
                parseLong2 = Long.parseLong((String) ((Map) this.f21586a.f21471O.get(i)).get(BaiduNaviParams.KEY_TIME));
                if (r4 - parseLong2 > 3600000 || parseLong2 - r4 > 3600000) {
                    ccVar.f21599a.setText(C5216i.m17766b(parseLong2));
                    if (r4 - parseLong2 > 86400000 || parseLong2 - r4 > 86400000) {
                        ccVar.f21599a.setText(C5216i.m17760a(parseLong2));
                    }
                } else {
                    ccVar.f21602d.setVisibility(8);
                }
            }
            r3 = null;
            try {
                r3 = this.f21587b.getApplicationContext().getPackageManager();
                r2 = r3.getApplicationInfo(this.f21587b.getPackageName(), 0);
            } catch (NameNotFoundException e5) {
                r2 = null;
            }
            try {
                ccVar.f21600b.setBackgroundDrawable(new BitmapDrawable(((BitmapDrawable) r3.getApplicationIcon(r2)).getBitmap()));
            } catch (Exception e22222222222) {
                e22222222222.printStackTrace();
            }
            if (((String) ((Map) this.f21586a.f21471O.get(i)).get("contenttype")).contentEquals("1") || ((Map) this.f21586a.f21471O.get(i)).get("content").toString().startsWith("http://bs.baidu.com") || ((Map) this.f21586a.f21471O.get(i)).get("content").toString().startsWith("https://bs.baidu.com")) {
                str = (String) ((Map) this.f21586a.f21471O.get(i)).get("content");
                ccVar.f21601c.setImageBitmap(C5223p.m17779a(this.f21587b, "ufo_pic_defult_icon.png"));
                a = C5208a.m17729a().m17731a(new C5224q(this.f21586a.getApplicationContext(), ccVar.f21601c, this.f21586a.ak), str);
                if (a != null) {
                    FeedbackInputActivity.f21455a.add(a);
                    ccVar.f21601c.setImageBitmap(a);
                    if (a.getHeight() > a.getWidth()) {
                        ccVar.f21601c.setMaxWidth(C5216i.m17757a(this.f21586a.getApplicationContext(), 80.0f));
                        ccVar.f21601c.setMaxHeight(C5216i.m17757a(this.f21586a.getApplicationContext(), 120.0f));
                    } else {
                        ccVar.f21601c.setMaxWidth(C5216i.m17757a(this.f21586a.getApplicationContext(), 120.0f));
                        ccVar.f21601c.setMaxHeight(C5216i.m17757a(this.f21586a.getApplicationContext(), 80.0f));
                    }
                }
            } else if (((String) ((Map) this.f21586a.f21471O.get(i)).get("contenttype")).contentEquals("2") && ccVar.f21601c != null) {
                a = (Bitmap) ((Map) this.f21586a.f21471O.get(i)).get("content");
                if (a.getHeight() > a.getWidth()) {
                    ccVar.f21601c.setMaxWidth(C5216i.m17757a(this.f21586a.getApplicationContext(), 80.0f));
                    ccVar.f21601c.setMaxHeight(C5216i.m17757a(this.f21586a.getApplicationContext(), 120.0f));
                } else {
                    ccVar.f21601c.setMaxWidth(C5216i.m17757a(this.f21586a.getApplicationContext(), 120.0f));
                    ccVar.f21601c.setMaxHeight(C5216i.m17757a(this.f21586a.getApplicationContext(), 80.0f));
                }
                ccVar.f21601c.setImageBitmap(a);
            }
        }
        return view;
    }
}
