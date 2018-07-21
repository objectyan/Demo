package com.baidu.tts.l.a;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.a;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class b
  implements Callable<ModelFileBags>
{
  private Set<String> a;
  private a b;
  
  public b(a parama, Set<String> paramSet)
  {
    this.a = paramSet;
    this.b = parama;
  }
  
  public ModelFileBags a()
    throws Exception
  {
    List localList = this.b.a(this.a);
    ModelFileBags localModelFileBags = new ModelFileBags();
    localModelFileBags.setList(localList);
    return localModelFileBags;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/l/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */