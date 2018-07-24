package com.baidu.carlife.wechat.p108b;

import android.text.TextUtils;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p110e.C2436c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: Msg */
/* renamed from: com.baidu.carlife.wechat.b.d */
public class C2382d {
    /* renamed from: a */
    private C2376b f7879a;
    /* renamed from: b */
    private int f7880b;
    /* renamed from: c */
    private int f7881c;
    /* renamed from: d */
    private String f7882d;
    /* renamed from: e */
    private String f7883e;
    /* renamed from: f */
    private String f7884f;
    /* renamed from: g */
    private String f7885g;
    /* renamed from: h */
    private int f7886h;
    /* renamed from: i */
    private long f7887i;
    /* renamed from: j */
    private String f7888j;
    /* renamed from: k */
    private C2383e f7889k;
    /* renamed from: l */
    private C2384f f7890l;
    /* renamed from: m */
    private String f7891m;
    /* renamed from: n */
    private int f7892n;
    /* renamed from: o */
    private C2381a f7893o;

    /* compiled from: Msg */
    /* renamed from: com.baidu.carlife.wechat.b.d$a */
    public enum C2381a {
        Play,
        Reply,
        Navi
    }

    public C2382d() {
        this.f7892n = 0;
    }

    public C2382d(C2376b contact, String content) {
        this.f7892n = 0;
        this.f7883e = C2380c.m9070a().m9084e();
        this.f7884f = contact.m9052a();
        this.f7880b = 1;
        this.f7885g = content;
        this.f7887i = System.currentTimeMillis() / 1000;
        this.f7892n = 1;
        this.f7879a = contact;
    }

    /* renamed from: a */
    public static C2382d m9092a(JSONObject json) {
        try {
            C2382d msg = new C2382d();
            msg.f7882d = json.getString("MsgId");
            msg.f7880b = json.getInt("MsgType");
            msg.f7881c = json.getInt("AppMsgType");
            msg.f7883e = json.getString("FromUserName");
            msg.f7884f = json.getString("ToUserName");
            if (msg.f7883e.startsWith("@") && msg.f7884f.startsWith("@")) {
                String contactUserName;
                if (C2380c.m9070a().m9077a(msg.f7884f)) {
                    msg.f7879a = C2380c.m9070a().m9078b(msg.f7883e);
                    contactUserName = msg.f7883e;
                } else {
                    msg.f7879a = C2380c.m9070a().m9078b(msg.f7884f);
                    contactUserName = msg.f7884f;
                }
                msg.f7885g = json.getString("Content");
                msg.f7885g = msg.f7885g.trim();
                if (contactUserName.startsWith("@@")) {
                    String[] contents = msg.f7885g.split(":<br/>", 2);
                    if (contents == null || contents.length != 2) {
                        msg.f7891m = contactUserName;
                    } else {
                        msg.f7891m = contents[0];
                        msg.f7885g = contents[1];
                    }
                } else {
                    msg.f7891m = contactUserName;
                }
                msg.f7886h = json.getInt("Status");
                msg.f7887i = json.getLong("CreateTime");
                msg.f7888j = json.getString("Url");
                switch (msg.f7880b) {
                    case 1:
                        if (msg.f7885g.endsWith("pictype=location")) {
                            String address = msg.f7885g.split(":<br/>")[0];
                            String patternStr = "coord=([0-9\\.]+),([0-9\\.]+)";
                            if (msg.f7888j.contains("www.google.com/maps")) {
                                patternStr = "q=([0-9\\.]+),([0-9\\.]+)";
                            }
                            Matcher matcher = Pattern.compile(patternStr).matcher(msg.f7888j);
                            if (matcher.find()) {
                                msg.f7890l = new C2384f(address, matcher.group(1), matcher.group(2));
                            } else {
                                msg.f7890l = null;
                            }
                        }
                        msg.f7885g = msg.f7885g.replaceAll("【以上文字由语音转换】", "");
                        break;
                    case 49:
                        if (msg.f7881c != 3) {
                            msg.f7889k = null;
                            break;
                        }
                        msg.m9093q();
                        break;
                }
                msg.f7892n = 0;
                return msg;
            }
            C2372c.m9036e("非联系人或群聊消息，丢弃");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: q */
    private void m9093q() {
        String title = "";
        String singer = "";
        String url = "";
        Matcher matcher = Pattern.compile("&lt;title&gt;(.*)&lt;/title&gt;(.*)&lt;des&gt;(.*)&lt;/des&gt;").matcher(this.f7885g);
        if (matcher.find()) {
            title = matcher.group(1).replace("分享歌曲：", "");
            singer = matcher.group(3);
        }
        matcher = Pattern.compile("&lt;dataurl&gt;(.*)&lt;/dataurl&gt;").matcher(this.f7885g);
        if (matcher.find()) {
            url = matcher.group(1);
        }
        if (TextUtils.isEmpty(url)) {
            this.f7889k = null;
            C2372c.m9036e("music msg parse failed");
            return;
        }
        this.f7889k = new C2383e(title, singer, url);
        C2372c.m9030c("music msg： " + this.f7889k.toString());
    }

    /* renamed from: a */
    public void m9098a(String content) {
        this.f7885g = content;
    }

    /* renamed from: a */
    public void m9096a(C2376b contact) {
        this.f7879a = contact;
    }

    /* renamed from: a */
    public String m9094a() {
        return this.f7882d;
    }

    /* renamed from: b */
    public int m9099b() {
        return this.f7880b;
    }

    /* renamed from: c */
    public int m9101c() {
        return this.f7881c;
    }

    /* renamed from: d */
    public String m9102d() {
        return this.f7883e;
    }

    /* renamed from: e */
    public String m9103e() {
        return this.f7884f;
    }

    /* renamed from: f */
    public String m9104f() {
        return this.f7885g;
    }

    /* renamed from: g */
    public C2376b m9105g() {
        return this.f7879a;
    }

    /* renamed from: h */
    public C2383e m9106h() {
        return this.f7889k;
    }

    /* renamed from: i */
    public C2384f m9107i() {
        return this.f7890l;
    }

    /* renamed from: j */
    public int m9108j() {
        return this.f7886h;
    }

    /* renamed from: k */
    public long m9109k() {
        return this.f7887i;
    }

    /* renamed from: l */
    public int m9110l() {
        return this.f7892n;
    }

    /* renamed from: a */
    public void m9095a(int readState) {
        this.f7892n = readState;
    }

    /* renamed from: b */
    public void m9100b(String senderUserName) {
        this.f7891m = senderUserName;
    }

    /* renamed from: m */
    public String m9111m() {
        return this.f7891m;
    }

    /* renamed from: n */
    public String m9112n() {
        return C2436c.m9321j() + "/cgi-bin/mmwebwx-bin/webwxgetvoice?msgid=" + this.f7882d + "&skey=" + C2380c.m9070a().m9086g().m9138a();
    }

    /* renamed from: o */
    public boolean m9113o() {
        if (this.f7879a != null && this.f7879a.m9065j()) {
            C2372c.m9036e("公众号 || 微信官方号 || 文件传输助手，忽略。。。。。。");
            return false;
        } else if (this.f7880b >= 10000 || this.f7880b == 51 || (this.f7880b == 49 && this.f7881c != 3)) {
            C2372c.m9036e("type >=10000 || type ==51 || (type==49 && appMsgType!=3)，忽略。。。。。。");
            return false;
        } else if (this.f7880b != 49 || this.f7881c != 3 || this.f7889k != null) {
            return true;
        } else {
            C2372c.m9036e("音乐分享，musicUrl解析失败，忽略。。。。。。");
            return false;
        }
    }

    /* renamed from: a */
    public void m9097a(C2381a showType) {
        this.f7893o = showType;
    }

    /* renamed from: p */
    public C2381a m9114p() {
        return this.f7893o;
    }
}
