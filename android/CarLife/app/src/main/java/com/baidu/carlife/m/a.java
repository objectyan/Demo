package com.baidu.carlife.m;

import android.content.Context;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.tts.AudioUtils;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.IBNTTSPlayerPCMListener;
import com.baidu.baidunavis.tts.IBNTTSPlayerWeChatListener;
import com.baidu.baidunavis.tts.IBNTTSVoiceHintListener;

public class a
{
  public static a a()
  {
    return a.a();
  }
  
  /* Error */
  public int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic 29	com/baidu/baidunavis/tts/BaseTTSPlayer:getInstance	()Lcom/baidu/baidunavis/tts/BaseTTSPlayer;
    //   10: astore 6
    //   12: iconst_1
    //   13: iload_2
    //   14: if_icmpne +26 -> 40
    //   17: aload 6
    //   19: aload_1
    //   20: iload 5
    //   22: invokevirtual 33	com/baidu/baidunavis/tts/BaseTTSPlayer:playTTSText	(Ljava/lang/String;Z)I
    //   25: istore 4
    //   27: iload_3
    //   28: istore_2
    //   29: iload 4
    //   31: ifne +5 -> 36
    //   34: iconst_m1
    //   35: istore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: iconst_0
    //   41: istore 5
    //   43: goto -26 -> 17
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	a
    //   0	51	1	paramString	String
    //   0	51	2	paramInt	int
    //   4	24	3	i	int
    //   25	5	4	j	int
    //   1	41	5	bool	boolean
    //   10	8	6	localBaseTTSPlayer	BaseTTSPlayer
    // Exception table:
    //   from	to	target	type
    //   7	12	46	finally
    //   17	27	46	finally
  }
  
  public void a(IBNTTSPlayerPCMListener paramIBNTTSPlayerPCMListener)
  {
    BaseTTSPlayer.getInstance().setIBNTTSPlayerPCMListener(paramIBNTTSPlayerPCMListener);
  }
  
  public void a(IBNTTSPlayerWeChatListener paramIBNTTSPlayerWeChatListener)
  {
    BaseTTSPlayer.getInstance().setBNTTSPlayerStatusChangedWeChat(paramIBNTTSPlayerWeChatListener);
  }
  
  public void a(IBNTTSVoiceHintListener paramIBNTTSVoiceHintListener)
  {
    BaseTTSPlayer.getInstance().setIBNTTSVoiceHintListener(paramIBNTTSVoiceHintListener);
  }
  
  public void a(b paramb)
  {
    BaseTTSPlayer.getInstance().setIBNTTSBtStatusInterface(paramb);
  }
  
  public void a(boolean paramBoolean)
  {
    BaseTTSPlayer.getInstance().setCarLifeConnected(paramBoolean);
  }
  
  /* Error */
  public int b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 58	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   6: invokevirtual 62	com/baidu/carlife/l/a:N	()Z
    //   9: invokevirtual 64	com/baidu/carlife/m/a:a	(Z)V
    //   12: ldc 66
    //   14: new 68	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   21: ldc 71
    //   23: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 84	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: invokestatic 29	com/baidu/baidunavis/tts/BaseTTSPlayer:getInstance	()Lcom/baidu/baidunavis/tts/BaseTTSPlayer;
    //   39: aload_1
    //   40: iload_2
    //   41: invokevirtual 87	com/baidu/baidunavis/tts/BaseTTSPlayer:playVoiceTTSText	(Ljava/lang/String;I)I
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +9 -> 55
    //   49: iconst_m1
    //   50: istore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_2
    //   54: ireturn
    //   55: iconst_0
    //   56: istore_2
    //   57: goto -6 -> 51
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	a
    //   0	65	1	paramString	String
    //   0	65	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	45	60	finally
  }
  
  public void b()
  {
    BaseTTSPlayer.getInstance().stopTTS();
  }
  
  public void b(boolean paramBoolean)
  {
    BaseTTSPlayer.getInstance().setVoiceState(paramBoolean);
  }
  
  /* Error */
  public int c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 29	com/baidu/baidunavis/tts/BaseTTSPlayer:getInstance	()Lcom/baidu/baidunavis/tts/BaseTTSPlayer;
    //   5: aload_1
    //   6: iload_2
    //   7: invokevirtual 97	com/baidu/baidunavis/tts/BaseTTSPlayer:playWeChatTTSText	(Ljava/lang/String;I)I
    //   10: istore_2
    //   11: iload_2
    //   12: ifne +9 -> 21
    //   15: iconst_m1
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	a
    //   0	31	1	paramString	String
    //   0	31	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
  
  public void c()
  {
    BaseTTSPlayer.getInstance().stopTTSWX();
  }
  
  public void c(boolean paramBoolean)
  {
    BaseTTSPlayer.getInstance().setNaviMuteState(paramBoolean);
  }
  
  public void d()
  {
    BaseTTSPlayer.getInstance().stopTTSVR();
    h();
  }
  
  public void e()
  {
    BaseTTSPlayer.getInstance().stopTTS();
    Context localContext = NavCommonFuncModel.getInstance().getContext();
    if (localContext != null) {
      AudioUtils.releaseAudioFocus(localContext);
    }
  }
  
  public boolean f()
  {
    return BaseTTSPlayer.getInstance().getVoiceState();
  }
  
  public boolean g()
  {
    return BaseTTSPlayer.getInstance().isNaviMuteState();
  }
  
  public void h()
  {
    byte[] arrayOfByte = com.baidu.carlife.l.a.a().a(327686, 0);
    com.baidu.carlife.l.a.a().d(arrayOfByte, arrayOfByte.length);
  }
  
  private static class a
  {
    private static a a = new a(null);
  }
  
  public static abstract interface b
  {
    public abstract boolean a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */