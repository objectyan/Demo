package com.baidu.che.codriver.protocol.a;

import com.baidu.che.codriver.protocol.a;
import com.baidu.che.codriver.protocol.d;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;

public class b
  extends com.baidu.che.codriver.protocol.b<NLPResponseData>
{
  private String a;
  
  public b(d<NLPResponseData> paramd, Class<NLPResponseData> paramClass, String paramString)
  {
    super(paramd, paramClass);
    this.a = paramString;
  }
  
  public b(d<NLPResponseData> paramd, Class<NLPResponseData> paramClass, String paramString, boolean paramBoolean)
  {
    super(paramd, paramClass);
    this.a = paramString;
  }
  
  protected String b()
  {
    return a.a(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */