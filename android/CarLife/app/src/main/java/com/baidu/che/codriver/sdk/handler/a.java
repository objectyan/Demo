package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.a.a.b;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements l.a
{
  public static final String a = "AsrControlHandler";
  private List<String> b = new CopyOnWriteArrayList();
  private Map<String, a.b> c = new HashMap();
  private a.b d;
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd_id", paramString1);
      paramString1 = new JSONObject();
      paramString1.put("cmd_key", paramString2);
      paramString1.put("cmd_text", paramString3);
      localJSONObject.put("cmd_content", paramString1);
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.e("AsrControlHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3);
    if ("set".equals(paramString3)) {
      l.a().a(paramString1, paramString2);
    }
    for (;;)
    {
      return null;
      if ("open_dialog".equals(paramString3))
      {
        h.e("AsrControlHandler", "open_dialog-cmdType:" + paramString2 + ";param:" + paramString3);
        com.baidu.che.codriver.sdk.a.a.a().c();
      }
      else if ("close_dialog".equals(paramString3))
      {
        h.e("AsrControlHandler", "close_dialog-cmdType:" + paramString2 + ";param:" + paramString3);
        com.baidu.che.codriver.sdk.a.a.a().d();
      }
      else if ("start_record".equals(paramString3))
      {
        h.e("AsrControlHandler", "start_record-cmdType:" + paramString2 + ";param:" + paramString3);
      }
      else if ("stop_record".equals(paramString3))
      {
        h.e("AsrControlHandler", "stop_record-cmdType:" + paramString2 + ";param:" + paramString3);
      }
      else if ("register_cmd".equals(paramString3))
      {
        a(paramString4);
      }
      else if ("unregister_cmd".equals(paramString3))
      {
        b(paramString4);
      }
      else if ("add_wakeup".equals(paramString3))
      {
        com.baidu.che.codriver.sdk.a.a.a().a(paramString4, false);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    this.d = new a.b()
    {
      public void onCommand(String paramAnonymousString1, String paramAnonymousString2)
      {
        Iterator localIterator = a.a(a.this).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (equals(localEntry.getValue())) {
            com.baidu.che.codriver.sdk.a.a.a().a("register_cmd", a.a(a.this, localEntry.getKey().toString(), paramAnonymousString1, paramAnonymousString2));
          }
        }
        h.e("AsrControlHandler", "mSceneCommand onCommand(): type=" + paramAnonymousString1 + " cmd=" + paramAnonymousString2);
      }
    };
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).getJSONArray("cmd_content");
        localObject1 = ((JSONObject)localObject1).optString("cmd_id");
        if (!this.c.containsKey(localObject1)) {
          break label272;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        Object localObject1;
        Object localObject2;
        String str;
        String[] arrayOfString;
        int j;
        h.e("AsrControlHandler", paramString.getMessage().toString());
        return false;
      }
      if (i < paramString.length())
      {
        localObject2 = paramString.optJSONObject(i);
        str = ((JSONObject)localObject2).optString("cmd_key");
        localObject2 = ((JSONObject)localObject2).getJSONArray("cmd_text");
        arrayOfString = new String[((JSONArray)localObject2).length()];
        j = 0;
        if (j < ((JSONArray)localObject2).length())
        {
          arrayOfString[j] = ((JSONArray)localObject2).optString(j);
          j += 1;
        }
        else
        {
          h.e("AsrControlHandler", "cmdKey:" + str + ";cmdText:" + arrayOfString[0].toString());
          this.d.addCommand(str, arrayOfString);
          i += 1;
        }
      }
      else
      {
        this.c.put(localObject1, this.d);
        this.b.add(localObject1);
        com.baidu.che.codriver.sdk.a.a.a().a(this.d);
        h.e("AsrControlHandler", "mCmdMap.size():" + this.c.size());
        return true;
        label272:
        i = 0;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.c.containsKey(paramString))
    {
      com.baidu.che.codriver.sdk.a.a.a().b((a.b)this.c.get(paramString));
      this.c.remove(paramString);
      this.b.remove(paramString);
      h.e("AsrControlHandler", "mCmdMap.size():" + this.c.size() + ";data=" + paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */