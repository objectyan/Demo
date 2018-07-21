package com.baidu.che.codriver.sdk.handler;

import android.text.TextUtils;
import com.baidu.che.codriver.c.a;
import com.baidu.che.codriver.sdk.a.f;
import com.baidu.che.codriver.sdk.a.f.a;
import com.baidu.che.codriver.sdk.a.f.a.a;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.List;

public class MusicCommandHandler
  implements l.a
{
  private f.a.a a;
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("set".equals(paramString3))
    {
      f.a().b(new a(paramString1));
      l.a().a(paramString1, paramString2);
    }
    do
    {
      return null;
      if ("reset".equals(paramString3))
      {
        f.a().b(null);
        return null;
      }
    } while ((!"search".equals(paramString3)) || (this.a == null) || (TextUtils.isEmpty(paramString4)));
    try
    {
      paramString1 = (PlayList)new Gson().fromJson(paramString4, PlayList.class);
      this.a.a(paramString1.list);
      return null;
    }
    catch (JsonSyntaxException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  static class PlayList
    implements INoProguard
  {
    List<a> list;
    int position;
    
    public PlayList(List<a> paramList, int paramInt)
    {
      this.list = paramList;
      this.position = paramInt;
    }
  }
  
  private class a
    implements f.a
  {
    private String b;
    
    public a(String paramString)
    {
      this.b = paramString;
    }
    
    public String a()
    {
      return this.b;
    }
    
    public void a(a parama, int paramInt)
    {
      l.a().a("music.tool", "play.music", new Gson().toJson(parama));
    }
    
    public void a(String paramString1, String paramString2, String paramString3, String paramString4, f.a.a parama)
    {
      paramString3 = new a();
      paramString3.i = paramString1;
      paramString3.e = paramString2;
      MusicCommandHandler.a(MusicCommandHandler.this, parama);
      l.a().a("music.tool", "search", new Gson().toJson(paramString3));
    }
    
    public void a(List<a> paramList, int paramInt)
    {
      paramList = new MusicCommandHandler.PlayList(paramList, paramInt);
      l.a().a("music.tool", "play.list", new Gson().toJson(paramList));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/MusicCommandHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */