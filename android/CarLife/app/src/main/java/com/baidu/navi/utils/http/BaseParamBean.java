package com.baidu.navi.utils.http;

import android.os.Build;
import com.baidu.navisdk.util.common.PackageUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class BaseParamBean
{
  public int appvercode = PackageUtil.getVersionCode();
  public String channel = PackageUtil.getChannel();
  public String cuid = PackageUtil.getCuid();
  public String mobile = Build.MODEL;
  public String os = "android";
  
  public List<BasicNameValuePair> toValuePair()
  {
    ArrayList localArrayList = new ArrayList(5);
    localArrayList.add(new BasicNameValuePair("os", this.os));
    localArrayList.add(new BasicNameValuePair("mobile", this.mobile));
    if (this.cuid == null) {}
    for (String str = "";; str = this.cuid)
    {
      localArrayList.add(new BasicNameValuePair("cuid", str));
      localArrayList.add(new BasicNameValuePair("channel", this.channel));
      localArrayList.add(new BasicNameValuePair("appvercode", this.appvercode + ""));
      return localArrayList;
    }
  }
  
  public List<BasicNameValuePair> toValuePairEncode()
  {
    ArrayList localArrayList = new ArrayList(5);
    localArrayList.add(new BasicNameValuePair("os", this.os));
    for (;;)
    {
      try
      {
        localArrayList.add(new BasicNameValuePair("mobile", URLEncoder.encode(this.mobile, "utf-8")));
        if (this.cuid != null) {
          continue;
        }
        str = "";
        localArrayList.add(new BasicNameValuePair("cuid", str));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        String str;
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      localArrayList.add(new BasicNameValuePair("channel", this.channel));
      localArrayList.add(new BasicNameValuePair("appvercode", this.appvercode + ""));
      return localArrayList;
      str = URLEncoder.encode(this.cuid, "utf-8");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/http/BaseParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */