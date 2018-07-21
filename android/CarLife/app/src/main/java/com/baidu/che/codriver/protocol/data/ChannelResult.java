package com.baidu.che.codriver.protocol.data;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.JsonObject;

public class ChannelResult
  implements INoProguard
{
  public JsonObject data;
  public String errmsg;
  public int errno;
  
  public String toString()
  {
    return "BaseResult{errno='" + this.errno + '\'' + ", errmsg='" + this.errmsg + '\'' + ", data='" + this.data + '\'' + '}';
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/data/ChannelResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */