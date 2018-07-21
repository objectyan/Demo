package com.baidu.mobstat;

import java.io.File;
import java.io.FilenameFilter;

class cd
  implements FilenameFilter
{
  cd(cc paramcc) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("__send_data_");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */