package com.baidu.navisdk.util.http.center;

import java.io.File;
import java.util.HashMap;

public class BNHttpParams
{
  public String charset = "UTF-8";
  public File file = null;
  public String fileKey = null;
  public boolean isAsync = true;
  public HashMap<String, File> postFileMap = null;
  @Deprecated
  public HashMap<String, String> postMethodParams = null;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/util/http/center/BNHttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */