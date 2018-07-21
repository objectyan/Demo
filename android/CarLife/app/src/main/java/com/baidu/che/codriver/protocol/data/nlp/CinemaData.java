package com.baidu.che.codriver.protocol.data.nlp;

import com.baidu.che.codriver.util.INoProguard;
import java.util.List;

public class CinemaData
  implements INoProguard
{
  public int curPage;
  public List<CinemaBean> list;
  
  public String toString()
  {
    return "CinemaData{curPage=" + this.curPage + ", list=" + this.list + '}';
  }
  
  public static class CinemaBean
    implements INoProguard
  {
    public String name;
    public String post;
    public String score;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/data/nlp/CinemaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */