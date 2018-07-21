package com.baidu.navisdk.ui.voice.model;

public class VoiceShareData
{
  public static final int Share_Type_PengYouQuan = 2;
  public static final int Share_Type_SMS = 3;
  public static final int Share_Type_WeiBo = 0;
  public static final int Share_Type_WeiXin = 1;
  public String content;
  public String imageUrl;
  public int shareType = -1;
  public String shareUrl;
  public String subject;
  
  public VoiceShareData() {}
  
  public VoiceShareData(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.shareType = paramInt;
    this.subject = paramString1;
    this.content = paramString2;
    this.shareUrl = paramString3;
    this.imageUrl = paramString4;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/model/VoiceShareData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */