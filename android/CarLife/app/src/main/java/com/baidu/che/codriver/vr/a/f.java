package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.protocol.data.nlp.TtsData;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.ImageSearchData;
import com.baidu.che.codriver.vr.m;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class f
  extends a
{
  ImageSearchData e;
  String f;
  private NLPResponseData g;
  
  public f(NLPResponseData paramNLPResponseData, m paramm, Context paramContext)
  {
    super(null, paramm, paramContext);
    this.g = paramNLPResponseData;
    this.d = paramContext;
    j();
  }
  
  private void a()
  {
    h.b("CoDriverVoice", "---存在多个相关地点，再次发起语音识别------");
    c.a().b(this);
    g localg = new g(this.e);
    localg.g = this.f;
    this.c.a(localg);
  }
  
  public void a(a parama)
  {
    super.a(parama);
  }
  
  public void h()
  {
    a();
  }
  
  protected void j()
  {
    if (this.g == null) {
      return;
    }
    NLPResponseData.Result localResult = com.baidu.che.codriver.ui.d.g.a(this.g);
    this.f = localResult.ttsStatus.tts;
    try
    {
      Type localType = new TypeToken() {}.getType();
      this.e = ((ImageSearchData)new Gson().fromJson(localResult.data, localType));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */