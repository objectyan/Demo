package com.baidu.navisdk.ui.voice.model;

public class VoiceShareData {
    public static final int Share_Type_PengYouQuan = 2;
    public static final int Share_Type_SMS = 3;
    public static final int Share_Type_WeiBo = 0;
    public static final int Share_Type_WeiXin = 1;
    public String content;
    public String imageUrl;
    public int shareType = -1;
    public String shareUrl;
    public String subject;

    public VoiceShareData(int st, String sub, String con, String su, String imgUrl) {
        this.shareType = st;
        this.subject = sub;
        this.content = con;
        this.shareUrl = su;
        this.imageUrl = imgUrl;
    }
}
