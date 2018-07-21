package com.baidu.speech.asr;

public class ASRMessage
{
  private static final String TAG = "ASRMessage";
  public String mCommand = "";
  public byte[] mData = null;
  public boolean mIsVip = false;
  public int mLength = 0;
  public int mOffset = 0;
  public String mParam = "";
  
  public ASRMessage(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.mCommand = paramString1;
    this.mParam = paramString2;
    this.mData = paramArrayOfByte;
    this.mOffset = paramInt1;
    this.mLength = paramInt2;
    this.mIsVip = false;
  }
  
  public ASRMessage(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mCommand = paramString1;
    this.mParam = paramString2;
    this.mData = paramArrayOfByte;
    this.mOffset = paramInt1;
    this.mLength = paramInt2;
    this.mIsVip = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/asr/ASRMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */