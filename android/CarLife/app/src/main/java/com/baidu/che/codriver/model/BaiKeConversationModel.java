package com.baidu.che.codriver.model;

import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.util.INoProguard;
import java.util.ArrayList;

public class BaiKeConversationModel
  extends b
{
  public BaiKe a;
  
  public BaiKeConversationModel(BaiKe paramBaiKe)
  {
    this.f = b.a.n;
    this.a = paramBaiKe;
  }
  
  public static class BaiKe
    implements INoProguard
  {
    public ArrayList<String> images;
    public String title;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/model/BaiKeConversationModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */