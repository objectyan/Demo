package com.baidu.che.codriver.protocol.a;

import com.baidu.che.codriver.protocol.b;
import com.baidu.che.codriver.protocol.d;
import com.baidu.che.codriver.protocol.data.ChannelResult;
import com.baidu.che.codriver.util.c;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class a
  extends b<ChannelResult>
{
  public static final String a = a.class.getSimpleName();
  
  public a(d<ChannelResult> paramd, Class<ChannelResult> paramClass)
  {
    super(paramd, paramClass);
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected String b()
  {
    return com.baidu.che.codriver.protocol.a.c();
  }
  
  protected byte[] h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("uuid", c.n()));
    localArrayList.add(new BasicNameValuePair("cn", c.j()));
    localArrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
    localArrayList.add(new BasicNameValuePair("an", c.f()));
    localArrayList.add(new BasicNameValuePair("ac", String.valueOf(c.g())));
    return URLEncodedUtils.format(localArrayList, "UTF-8").getBytes();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */