package com.baidu.ufosdk.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.mobstat.Config;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5216i;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FeedbackInputActivity */
final class aj extends Handler {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21546a;
    /* renamed from: b */
    private String f21547b;

    aj(FeedbackInputActivity feedbackInputActivity) {
        this.f21546a = feedbackInputActivity;
    }

    public final void handleMessage(Message message) {
        String str;
        Map hashMap;
        String replace;
        String[] split;
        int i;
        super.handleMessage(message);
        if (message.what == 0) {
            C5210c.m17735c("msg.what==0");
        }
        if (message.what == 12) {
            FeedbackInputActivity.m17643a(this.f21546a);
            if (this.f21546a.f21483c) {
                this.f21546a.f21483c = false;
                return;
            }
            this.f21546a.ac.setVisibility(8);
            this.f21546a.ao = false;
            this.f21546a.ap.setEnabled(true);
            this.f21546a.ap.setText("");
            this.f21546a.f21480X.setVisibility(8);
            this.f21546a.am.setVisibility(8);
            this.f21546a.f21469M = (String) message.obj;
            this.f21546a.f21468L = this.f21546a.f21469M;
            if (UfoSDK.robotAnswer && this.f21546a.af && this.f21546a.f21469M != null && this.f21546a.f21469M.length() > 0) {
                this.f21546a.f21475S = Executors.newSingleThreadExecutor();
                this.f21546a.f21475S.execute(new ak(this));
            }
        } else if (message.what == 13) {
            this.f21546a.ao = false;
            this.f21546a.ac.setVisibility(8);
            this.f21546a.ap.setEnabled(true);
            this.f21546a.av.setTextColor(C5216i.m17759a(C5167a.f21377w, C5167a.f21378x, C5167a.f21377w, C5167a.f21377w));
        } else if (message.what == 14) {
            this.f21546a.f21484d = false;
            FeedbackInputActivity.m17643a(this.f21546a);
            if (this.f21546a.f21483c) {
                this.f21546a.f21483c = false;
                return;
            }
            this.f21546a.ar = false;
            if (!TextUtils.isEmpty(this.f21546a.f21468L) && TextUtils.isEmpty(this.f21546a.aq)) {
                this.f21546a.aa.putString(this.f21546a.f21468L, "");
            }
            if (!TextUtils.isEmpty(this.f21546a.aq)) {
                this.f21546a.aa.putString(this.f21546a.aq, "");
            }
            this.f21546a.ac.setVisibility(8);
            this.f21546a.ao = false;
            this.f21546a.ap.setEnabled(true);
            this.f21546a.ap.setText("");
            this.f21546a.f21480X.setVisibility(8);
            this.f21546a.am.setVisibility(8);
            this.f21546a.f21469M = (String) message.obj;
            this.f21546a.f21468L = this.f21546a.f21469M;
            if (this.f21546a.f21470N != null) {
                this.f21546a.f21470N.m17551a(this.f21546a.f21468L);
            }
            this.f21546a.aa.putString(new StringBuilder(Config.TRACE_VISIT_FIRST).append(this.f21546a.f21469M).toString(), this.f21547b);
            this.f21546a.aa.commit();
            if (!UfoSDK.robotAnswer || !this.f21546a.af || this.f21546a.f21469M == null || this.f21546a.f21469M.length() <= 0) {
                this.f21546a.f21475S = Executors.newSingleThreadExecutor();
                this.f21546a.f21475S.execute(new am(this));
            } else {
                this.f21546a.f21475S = Executors.newSingleThreadExecutor();
                this.f21546a.f21475S.execute(new al(this));
            }
        } else if (message.what == 15) {
            try {
                ((InputMethodManager) this.f21546a.ap.getContext().getSystemService("input_method")).showSoftInput(this.f21546a.ap, 0);
            } catch (Exception e) {
            }
        } else if (!(message.what != 16 || this.f21546a.getCurrentFocus() == null || this.f21546a.getCurrentFocus().getWindowToken() == null)) {
            ((InputMethodManager) this.f21546a.getSystemService("input_method")).hideSoftInputFromWindow(this.f21546a.getCurrentFocus().getWindowToken(), 2);
        }
        if (message.what == 1) {
            C5210c.m17734b("1111111111111111111111111");
            Map hashMap2 = new HashMap();
            hashMap2.put(PlatformConstants.CONNECT_EXTRA_KEY, Integer.valueOf(0));
            hashMap2.put("content", message.obj);
            hashMap2.put("contenttype", "0");
            hashMap2.put(BaiduNaviParams.KEY_TIME, String.valueOf(System.currentTimeMillis()));
            this.f21546a.f21471O.add(hashMap2);
            this.f21546a.f21473Q.notifyDataSetChanged();
            this.f21546a.f21472P.setSelection(this.f21546a.f21472P.getBottom());
            this.f21546a.ac.setVisibility(8);
        } else if (message.what == 2) {
            FeedbackInputActivity feedbackInputActivity = this.f21546a;
            feedbackInputActivity.ae = feedbackInputActivity.ae + 1;
            C5210c.m17734b("@@@@@@@@: 规定交互轮次：" + this.f21546a.ad + " ***当前交互次数" + this.f21546a.ae);
            if (this.f21546a.ae >= this.f21546a.ad && this.f21546a.af) {
                if (!this.f21546a.ag) {
                    C5180a.m17571a(this.f21546a.f21469M, QPlayAutoJNI.SONG_LIST_ROOT_ID);
                }
                this.f21546a.af = false;
            }
            if (this.f21546a.au) {
                this.f21546a.f21469M = this.f21546a.f21468L;
            }
            this.f21546a.f21484d = false;
            this.f21546a.f21467K.setVisibility(0);
            ArrayList arrayList = (ArrayList) message.obj;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                str = (String) ((Map) arrayList.get(i2)).get("id");
                if (str != null && str.equals(this.f21546a.f21469M)) {
                    hashMap = new HashMap();
                    hashMap.put(PlatformConstants.CONNECT_EXTRA_KEY, Integer.valueOf(1));
                    hashMap.put("content", (String) ((Map) arrayList.get(i2)).get("content"));
                    hashMap.put(BaiduNaviParams.KEY_TIME, (String) ((Map) arrayList.get(i2)).get(BaiduNaviParams.KEY_TIME));
                    hashMap.put("contenttype", "0");
                    str = (String) ((Map) arrayList.get(i2)).get("toggle");
                    if (str == null || !str.equals(C2848p.f9291R) || this.f21546a.ag) {
                        this.f21546a.ah = false;
                    } else {
                        this.f21546a.ah = true;
                    }
                    str = (String) hashMap.get("content");
                    if (((String) hashMap.get("content")).contains("</br>")) {
                        replace = str.replace("</br>", "\n");
                    } else {
                        replace = str;
                    }
                    if (((String) hashMap.get("content")).contains("</a>")) {
                        split = replace.split("</a>");
                        for (i = 0; i < split.length - 1; i++) {
                            split[i] = split[i].replace("<a href= \"", "\n");
                            split[i] = split[i].substring(0, split[i].indexOf("target=\"_blank\">"));
                            split[i] = split[i].replace("\"", "\n");
                        }
                        replace = "";
                        for (String replace2 : split) {
                            replace2 = new StringBuilder(String.valueOf(replace2)).append(replace2).append("\n").toString();
                        }
                        str = replace2.replace("\n\n", "\n");
                    } else {
                        str = replace2;
                    }
                    hashMap.remove("content");
                    hashMap.put("content", str);
                    if (str.contains(".jpg") && str.contains("http")) {
                        hashMap.remove("contenttype");
                        hashMap.put("contenttype", "1");
                    }
                    str = (String) ((Map) arrayList.get(i2)).get("toggle");
                    if (str != null && str.equals(C2848p.f9292S)) {
                        this.f21546a.af = false;
                    }
                    this.f21546a.f21471O.add(hashMap);
                    this.f21546a.f21473Q.notifyDataSetChanged();
                    this.f21546a.f21472P.setSelection(this.f21546a.f21472P.getBottom());
                }
            }
            if (this.f21546a.ah) {
                this.f21546a.as.setVisibility(0);
            } else {
                this.f21546a.as.setVisibility(8);
            }
        }
        if (message.what == 3) {
            this.f21546a.f21484d = false;
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    FeedbackInputActivity.f21455a.add(decodeByteArray);
                    if (decodeByteArray != null) {
                        Map hashMap3 = new HashMap();
                        hashMap3.put(PlatformConstants.CONNECT_EXTRA_KEY, Integer.valueOf(0));
                        hashMap3.put("content", decodeByteArray);
                        hashMap3.put("contenttype", "2");
                        hashMap3.put(BaiduNaviParams.KEY_TIME, String.valueOf(System.currentTimeMillis()));
                        this.f21546a.f21471O.add(hashMap3);
                        this.f21546a.f21473Q.notifyDataSetChanged();
                        this.f21546a.f21472P.setSelection(this.f21546a.f21472P.getBottom());
                    } else {
                        return;
                    }
                } catch (OutOfMemoryError e2) {
                    System.gc();
                    return;
                }
            }
            return;
        }
        if (message.what == 4) {
            this.f21546a.f21467K.setVisibility(8);
            this.f21546a.f21462F.setVisibility(8);
            this.f21546a.f21476T.setVisibility(8);
            C5216i.m17762a(this.f21546a.getApplicationContext(), this.f21546a.f21477U);
            this.f21546a.f21461E.setVisibility(0);
            this.f21546a.f21474R.setVisibility(8);
            this.f21546a.as.setVisibility(8);
        }
        if (message.what == 5) {
            Object obj;
            this.f21546a.f21484d = false;
            this.f21546a.f21471O.clear();
            Map hashMap4 = new HashMap();
            hashMap4.put(PlatformConstants.CONNECT_EXTRA_KEY, Integer.valueOf(1));
            hashMap4.put("content", UfoSDK.firstServerText);
            hashMap4.put("contenttype", "0");
            String str2 = (String) message.obj;
            if (str2 == null || !(str2.equals("newMessage") || str2.length() == 0)) {
                replace2 = this.f21546a.ab.getString(new StringBuilder(Config.TRACE_VISIT_FIRST).append(this.f21546a.f21468L).toString(), "0");
                if (replace2.equals("0")) {
                    try {
                        obj = (String) new JSONArray(str2).getJSONObject(0).get(BaiduNaviParams.KEY_TIME);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    hashMap4.put(BaiduNaviParams.KEY_TIME, obj);
                }
                str = replace2;
                try {
                    hashMap4.put(BaiduNaviParams.KEY_TIME, obj);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    C5210c.m17736d("handleMessage error !!");
                    return;
                }
            }
            this.f21547b = String.valueOf(System.currentTimeMillis());
            hashMap4.put(BaiduNaviParams.KEY_TIME, this.f21547b);
            this.f21546a.f21471O.add(hashMap4);
            if (this.f21546a.f21473Q != null) {
                this.f21546a.f21473Q.notifyDataSetChanged();
            }
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    hashMap = new HashMap();
                    i = ((Integer) jSONArray.getJSONObject(i3).get(PlatformConstants.CONNECT_EXTRA_KEY)).intValue();
                    hashMap.put(PlatformConstants.CONNECT_EXTRA_KEY, Integer.valueOf(i));
                    str2 = (String) jSONArray.getJSONObject(i3).get("contenttype");
                    hashMap.put("contenttype", str2);
                    String string = jSONArray.getJSONObject(i3).getString("extra");
                    if (string.length() == 0 || string == null) {
                        hashMap.put("content", (String) jSONArray.getJSONObject(i3).get("content"));
                    } else {
                        JSONObject jSONObject = new JSONObject(string);
                        if (str2 != null && i == 1 && str2.equals("0")) {
                            str2 = jSONObject.has("answer") ? jSONObject.getString("answer") : "";
                            if (str2 == null || str2.length() == 0 || str2.equals("") || str2.equals("null")) {
                                hashMap.put("content", jSONArray.getJSONObject(i3).getString("content"));
                            } else {
                                hashMap.put("content", str2);
                            }
                        } else {
                            hashMap.put("content", (String) jSONArray.getJSONObject(i3).get("content"));
                        }
                    }
                    str2 = (String) hashMap.get("content");
                    if (((String) hashMap.get("content")).contains("</br>")) {
                        obj = str2.replace("</br>", "\n");
                    } else {
                        str = str2;
                    }
                    if (((String) hashMap.get("content")).contains("</a>")) {
                        split = obj.split("</a>");
                        for (int i4 = 0; i4 < split.length - 1; i4++) {
                            split[i4] = split[i4].replace("<a href= \"", "\n");
                            split[i4] = split[i4].substring(0, split[i4].indexOf("target=\"_blank\">"));
                            split[i4] = split[i4].replace("\"", "\n");
                        }
                        str2 = "";
                        for (String str22 : split) {
                            str22 = new StringBuilder(String.valueOf(str22)).append(str22).append("\n").toString();
                        }
                        obj = str22.replace("\n\n", "\n");
                    }
                    hashMap.remove("content");
                    hashMap.put("content", obj);
                    hashMap.put(BaiduNaviParams.KEY_TIME, (String) jSONArray.getJSONObject(i3).get(BaiduNaviParams.KEY_TIME));
                    this.f21546a.f21471O.add(hashMap);
                }
                this.f21546a.f21473Q.notifyDataSetChanged();
                this.f21546a.f21467K.setVisibility(0);
                this.f21546a.f21462F.setVisibility(0);
                this.f21546a.f21476T.setVisibility(0);
                this.f21546a.f21461E.setVisibility(8);
                this.f21546a.f21474R.setVisibility(8);
                this.f21546a.f21472P.setSelection(this.f21546a.f21472P.getBottom());
                this.f21546a.f21478V = true;
                new Handler().postDelayed(new an(this), 1500);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        if (message.what == 6 && this.f21546a.f21478V) {
            this.f21546a.f21472P.setSelection(this.f21546a.f21472P.getBottom());
        }
        if (message.what == 7) {
            hashMap2 = new HashMap();
            hashMap2.put(PlatformConstants.CONNECT_EXTRA_KEY, Integer.valueOf(1));
            hashMap2.put("content", UfoSDK.solvedReplyText);
            hashMap2.put("contenttype", "0");
            hashMap2.put(BaiduNaviParams.KEY_TIME, String.valueOf(System.currentTimeMillis()));
            this.f21546a.f21484d = false;
            this.f21546a.f21471O.add(hashMap2);
            this.f21546a.f21473Q.notifyDataSetChanged();
            this.f21546a.f21472P.setSelection(this.f21546a.f21472P.getBottom());
        }
        if (message.what == 8) {
            hashMap2 = new HashMap();
            hashMap2.put(PlatformConstants.CONNECT_EXTRA_KEY, Integer.valueOf(1));
            if (this.f21546a.f21485e) {
                hashMap2.put("content", UfoSDK.notSolvedReplyText);
            } else {
                hashMap2.put("content", UfoSDK.notSolvedReplyText + "您可到我的反馈中查看。");
            }
            hashMap2.put("contenttype", "0");
            hashMap2.put(BaiduNaviParams.KEY_TIME, String.valueOf(System.currentTimeMillis()));
            this.f21546a.f21484d = true;
            this.f21546a.f21471O.add(hashMap2);
            this.f21546a.f21473Q.notifyDataSetChanged();
            this.f21546a.f21472P.setSelection(this.f21546a.f21472P.getBottom());
        }
    }
}
