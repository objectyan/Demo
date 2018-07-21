package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.h.d;
import com.baidu.che.codriver.h.d.a;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.h;
import com.baidu.tts.client.SpeechError;

public class j
  implements l.a
{
  private void a(String paramString1, String paramString2)
  {
    l.a().a("tts.tool", paramString1, paramString2);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.e(j.class.getName(), "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3 + ";data:" + paramString4);
    if ("set".equals(paramString3)) {
      l.a().a(paramString1, paramString2);
    }
    for (;;)
    {
      return null;
      if ("stop".equals(paramString3))
      {
        d.a().c();
      }
      else if ("switch".equals(paramString3))
      {
        int i = -1;
        switch (paramString4.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            d.a().a(d.a.b);
            break;
            if (paramString4.equals("emotionfemale"))
            {
              i = 0;
              continue;
              if (paramString4.equals("emotionmale"))
              {
                i = 1;
                continue;
                if (paramString4.equals("nomalfemale"))
                {
                  i = 2;
                  continue;
                  if (paramString4.equals("nomalmale")) {
                    i = 3;
                  }
                }
              }
            }
            break;
          }
        }
        d.a().a(d.a.d);
        continue;
        d.a().a(d.a.a);
        continue;
        d.a().a(d.a.c);
      }
      else if ("play".equals(paramString3))
      {
        d.a().a(paramString4, new com.baidu.che.codriver.h.b()
        {
          public void onError(String paramAnonymousString, SpeechError paramAnonymousSpeechError)
          {
            j.a(j.this, "onError", paramAnonymousString);
          }
          
          public void onSpeechFinish(String paramAnonymousString)
          {
            j.a(j.this, "onSpeechFinish", paramAnonymousString);
          }
          
          public void onSpeechProgressChanged(String paramAnonymousString, int paramAnonymousInt) {}
          
          public void onSpeechStart(String paramAnonymousString)
          {
            j.a(j.this, "onSpeechStart", paramAnonymousString);
          }
          
          public void onSynthesizeDataArrived(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt) {}
          
          public void onSynthesizeFinish(String paramAnonymousString) {}
          
          public void onSynthesizeStart(String paramAnonymousString) {}
        });
      }
      else if ("play_and_show".equals(paramString3))
      {
        paramString1 = new com.baidu.che.codriver.ui.d.b();
        paramString1.g = paramString4;
        paramString1.j = 2;
        com.baidu.che.codriver.ui.b.b.b().b(paramString1);
      }
      else if (!"set_stream_type".equals(paramString3)) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */