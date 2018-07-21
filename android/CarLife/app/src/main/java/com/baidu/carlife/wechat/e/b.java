package com.baidu.carlife.wechat.e;

import android.text.TextUtils;
import com.baidu.carlife.wechat.a.a.c.c;
import com.baidu.carlife.wechat.b.c.b;
import com.baidu.carlife.wechat.b.d;
import com.baidu.carlife.wechat.b.h;
import com.baidu.carlife.wechat.b.i;
import com.baidu.carlife.wechat.b.j;
import com.baidu.carlife.wechat.b.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static String a(String paramString)
  {
    while (paramString.contains("\\")) {
      paramString = paramString.replace("\\", "");
    }
    return paramString;
  }
  
  public static void a(d paramd)
  {
    paramd = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.b();
          return;
        }
        this.a.a();
      }
      
      public void a(Exception paramAnonymousException)
      {
        this.a.b();
      }
    };
    HashMap localHashMap = new HashMap();
    j localj = com.baidu.carlife.wechat.b.c.a().g();
    if (localj != null)
    {
      localHashMap.put("sid", localj.b());
      localHashMap.put("uin", localj.c());
    }
    com.baidu.carlife.wechat.a.a.c.a(c.h(), paramd, localHashMap);
  }
  
  public static void a(g paramg)
  {
    paramg = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        com.baidu.carlife.wechat.a.b.c.c("sync check response:\n" + paramAnonymousa.b());
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.c();
          return;
        }
        paramAnonymousa = Pattern.compile("window.synccheck=\\{retcode:\"([0-9]+)\",selector:\"([0-9]+)\"\\}").matcher(paramAnonymousa.b());
        int i = 0;
        int j = 0;
        if (paramAnonymousa.find())
        {
          i = Integer.valueOf(paramAnonymousa.group(1)).intValue();
          j = Integer.valueOf(paramAnonymousa.group(2)).intValue();
        }
        com.baidu.carlife.wechat.a.b.c.c("synccheck result： code = " + i + " ; selector = " + j);
        if (i == 0)
        {
          if (j != 0)
          {
            this.a.a();
            return;
          }
          this.a.b();
          return;
        }
        this.a.e();
      }
      
      public void a(Exception paramAnonymousException)
      {
        if ("sync check response onError:  " + paramAnonymousException == null) {}
        for (String str = null;; str = paramAnonymousException.toString())
        {
          com.baidu.carlife.wechat.a.b.c.e(str);
          if ((paramAnonymousException == null) || (!paramAnonymousException.toString().contains("Canceled"))) {
            break;
          }
          this.a.d();
          return;
        }
        this.a.c();
      }
    };
    com.baidu.carlife.wechat.a.a.c.a(c.f(), paramg);
  }
  
  public static void a(h paramh)
  {
    paramh = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        com.baidu.carlife.wechat.a.b.c.c("load uuid response: " + paramAnonymousa.b());
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.b("statusCode=" + paramAnonymousa.a());
          return;
        }
        Matcher localMatcher = Pattern.compile("window.QRLogin.code = ([0-9]+);").matcher(paramAnonymousa.b());
        int i = 0;
        if (localMatcher.find()) {
          i = Integer.valueOf(localMatcher.group(1)).intValue();
        }
        if (i != 200)
        {
          this.a.b("code=" + i);
          return;
        }
        paramAnonymousa = Pattern.compile("window.QRLogin.uuid = \"([0-9a-zA-Z_\\-]+==)\";").matcher(paramAnonymousa.b());
        if (paramAnonymousa.find())
        {
          paramAnonymousa = paramAnonymousa.group(1);
          this.a.a(paramAnonymousa);
          return;
        }
        this.a.b("uuid_not_found");
      }
      
      public void a(Exception paramAnonymousException)
      {
        this.a.b(paramAnonymousException.toString());
      }
    };
    com.baidu.carlife.wechat.a.a.c.a(c.b(), paramh);
  }
  
  public static void a(i parami)
  {
    parami = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        if (paramAnonymousa.a().intValue() != 200)
        {
          com.baidu.carlife.wechat.a.b.c.e("webwx init failed: statusCode = " + paramAnonymousa.a());
          this.a.a("statusCode=" + paramAnonymousa.a());
          return;
        }
        int i;
        try
        {
          paramAnonymousa = new JSONObject(paramAnonymousa.b());
          i = paramAnonymousa.getJSONObject("BaseResponse").getInt("Ret");
          if (i != 0)
          {
            this.a.a("ret=" + i);
            return;
          }
        }
        catch (Exception paramAnonymousa)
        {
          paramAnonymousa.printStackTrace();
          this.a.a(paramAnonymousa.toString());
          return;
        }
        Object localObject1 = i.a(paramAnonymousa.getJSONObject("User"));
        com.baidu.carlife.wechat.b.c.a().a((i)localObject1);
        localObject1 = paramAnonymousa.optJSONObject("SyncKey");
        ArrayList localArrayList;
        int j;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("List");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            localArrayList = new ArrayList();
            i = 0;
            j = ((JSONArray)localObject1).length();
            while (i < j)
            {
              localObject2 = ((JSONArray)localObject1).getJSONObject(i);
              localArrayList.add(new h(((JSONObject)localObject2).getString("Key"), ((JSONObject)localObject2).getString("Val")));
              i += 1;
            }
            com.baidu.carlife.wechat.b.c.a().a(localArrayList);
          }
        }
        if (paramAnonymousa.optInt("Count") > 0)
        {
          localObject1 = b.a(paramAnonymousa.optJSONArray("ContactList"));
          localArrayList = new ArrayList();
          i = 0;
          j = ((List)localObject1).size();
          if (i < j)
          {
            localObject2 = (com.baidu.carlife.wechat.b.b)((List)localObject1).get(i);
            if ((!((com.baidu.carlife.wechat.b.b)localObject2).k()) || (((com.baidu.carlife.wechat.b.b)localObject2).m())) {
              localArrayList.add(new com.baidu.carlife.wechat.b.a((com.baidu.carlife.wechat.b.b)localObject2, 0 - i));
            }
          }
          else
          {
            k.a().a(localArrayList);
          }
        }
        else
        {
          paramAnonymousa = paramAnonymousa.optString("ChatSet");
          if (!TextUtils.isEmpty(paramAnonymousa))
          {
            paramAnonymousa = paramAnonymousa.split(",");
            j = paramAnonymousa.length;
            i = 0;
          }
        }
        for (;;)
        {
          if (i < j)
          {
            localObject1 = paramAnonymousa[i];
            if (((String)localObject1).startsWith("@")) {
              k.a().a((String)localObject1);
            }
          }
          else
          {
            this.a.a();
            return;
            i += 1;
            break;
          }
          i += 1;
        }
      }
      
      public void a(Exception paramAnonymousException)
      {
        this.a.a(paramAnonymousException.toString());
      }
    };
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("BaseRequest", com.baidu.carlife.wechat.b.c.a().j());
      localObject = a(((JSONObject)localObject).toString());
      com.baidu.carlife.wechat.a.a.c.a(c.c(), parami, (String)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void a(j paramj)
  {
    paramj = new c.c()
    {
      public void a(final com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        com.baidu.carlife.wechat.a.b.c.c("webwxSync response:\n" + paramAnonymousa.b());
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.a();
          return;
        }
        try
        {
          paramAnonymousa = new JSONObject(paramAnonymousa.b());
          com.baidu.carlife.wechat.a.b.c.c("webwx Sync BaseResponse  : " + paramAnonymousa.getJSONObject("BaseResponse").toString());
          if (paramAnonymousa.getJSONObject("BaseResponse").getInt("Ret") != 0)
          {
            this.a.a();
            return;
          }
        }
        catch (Exception paramAnonymousa)
        {
          paramAnonymousa.printStackTrace();
          this.a.a();
          return;
        }
        Object localObject1 = paramAnonymousa.getJSONArray("ModContactList");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          localObject1 = b.a((JSONArray)localObject1);
          k.a().b((List)localObject1);
        }
        localObject1 = paramAnonymousa.optJSONObject("SyncKey");
        Object localObject2;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("List");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            localObject2 = new ArrayList();
            int i = 0;
            int j = ((JSONArray)localObject1).length();
            while (i < j)
            {
              localObject3 = ((JSONArray)localObject1).getJSONObject(i);
              ((List)localObject2).add(new h(((JSONObject)localObject3).getString("Key"), ((JSONObject)localObject3).getString("Val")));
              i += 1;
            }
            com.baidu.carlife.wechat.b.c.a().a((List)localObject2);
          }
        }
        label312:
        com.baidu.carlife.wechat.b.b localb;
        if (paramAnonymousa.optInt("AddMsgCount") > 0)
        {
          paramAnonymousa = b.b(paramAnonymousa.optJSONArray("AddMsgList"));
          localObject1 = new ArrayList();
          localObject2 = paramAnonymousa.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (d)((Iterator)localObject2).next();
          } while (((d)localObject3).g() != null);
          localb = new com.baidu.carlife.wechat.b.b();
          if (!com.baidu.carlife.wechat.b.c.a().a(((d)localObject3).e())) {
            break label399;
          }
          localb.a(((d)localObject3).d());
        }
        for (;;)
        {
          ((List)localObject1).add(localb);
          break label312;
          paramAnonymousa = new ArrayList();
          break;
          label399:
          localb.a(((d)localObject3).e());
        }
        if (((List)localObject1).size() == 0)
        {
          k.a().c(paramAnonymousa);
          this.a.a(paramAnonymousa.size());
          return;
        }
        com.baidu.carlife.wechat.a.b.c.c("收到消息，但发送者的信息未缓存，需重新查询.............");
        b.a((List)localObject1, 0, new b.a()
        {
          public void a(int paramAnonymous2Int)
          {
            k.a().c(paramAnonymousa);
            b.10.this.a.a(paramAnonymousa.size());
          }
          
          public void a(int paramAnonymous2Int, List<com.baidu.carlife.wechat.b.b> paramAnonymous2List)
          {
            if (paramAnonymous2List != null) {
              k.a().b(paramAnonymous2List);
            }
            paramAnonymous2List = paramAnonymousa.iterator();
            while (paramAnonymous2List.hasNext())
            {
              d locald = (d)paramAnonymous2List.next();
              if (locald.g() == null) {
                if (com.baidu.carlife.wechat.b.c.a().a(locald.e())) {
                  locald.a(com.baidu.carlife.wechat.b.c.a().b(locald.d()));
                } else {
                  locald.a(com.baidu.carlife.wechat.b.c.a().b(locald.e()));
                }
              }
            }
            k.a().c(paramAnonymousa);
            b.10.this.a.a(paramAnonymousa.size());
          }
        });
      }
      
      public void a(Exception paramAnonymousException)
      {
        this.a.a();
      }
    };
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("BaseRequest", com.baidu.carlife.wechat.b.c.a().j());
      ((JSONObject)localObject).put("SyncKey", com.baidu.carlife.wechat.b.c.a().k());
      ((JSONObject)localObject).put("rr", new Date().getTime() ^ 0xFFFFFFFFFFFFFFFF);
      localObject = a(((JSONObject)localObject).toString());
      com.baidu.carlife.wechat.a.a.c.a(c.g(), paramj, (String)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString, b paramb)
  {
    paramb = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        com.baidu.carlife.wechat.a.b.c.c("load contact response:");
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.a();
          return;
        }
        try
        {
          paramAnonymousa = new JSONObject(paramAnonymousa.b());
          com.baidu.carlife.wechat.a.b.c.c(paramAnonymousa.getJSONObject("BaseResponse").toString());
          if (paramAnonymousa.getJSONObject("BaseResponse").getInt("Ret") != 0)
          {
            this.a.a();
            return;
          }
        }
        catch (Exception paramAnonymousa)
        {
          paramAnonymousa.printStackTrace();
          this.a.a();
          return;
        }
        List localList = b.a(paramAnonymousa.optJSONArray("MemberList"));
        com.baidu.carlife.wechat.b.c.a().b(localList);
        paramAnonymousa = paramAnonymousa.getString("Seq");
        this.a.a(paramAnonymousa);
      }
      
      public void a(Exception paramAnonymousException)
      {
        this.a.a();
      }
    };
    com.baidu.carlife.wechat.a.a.c.a(c.d(paramString), paramb);
  }
  
  public static void a(String paramString, c paramc)
  {
    paramc = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        com.baidu.carlife.wechat.a.b.c.c("login check response : statusCode = " + paramAnonymousa.a());
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.a();
          return;
        }
        Object localObject = Pattern.compile("window.code=([0-9]+);").matcher(paramAnonymousa.b());
        int i = 0;
        if (((Matcher)localObject).find()) {
          i = Integer.valueOf(((Matcher)localObject).group(1)).intValue();
        }
        com.baidu.carlife.wechat.a.b.c.c("login check response : code = " + i);
        switch (i)
        {
        default: 
          this.a.c();
          return;
        case 400: 
          this.a.b();
          return;
        case 201: 
          localObject = Pattern.compile("window.userAvatar = '(.*)';").matcher(paramAnonymousa.b());
          paramAnonymousa = "";
          if (((Matcher)localObject).find()) {
            paramAnonymousa = ((Matcher)localObject).group(1);
          }
          this.a.b(paramAnonymousa);
          this.a.c();
          return;
        }
        com.baidu.carlife.wechat.b.c.a().a(c.b.b);
        paramAnonymousa = Pattern.compile("window.redirect_uri=\"(.+)\";").matcher(paramAnonymousa.b());
        if (paramAnonymousa.find())
        {
          localObject = paramAnonymousa.group(1);
          paramAnonymousa = "";
          if (((String)localObject).startsWith("https://")) {
            paramAnonymousa = ((String)localObject).substring("https://".length());
          }
          for (;;)
          {
            paramAnonymousa = paramAnonymousa.split("/", 2)[0];
            com.baidu.carlife.wechat.a.b.c.c("login check >> redirect host = " + paramAnonymousa);
            c.a(paramAnonymousa);
            this.a.a((String)localObject);
            return;
            if (((String)localObject).startsWith("http://")) {
              paramAnonymousa = ((String)localObject).substring("http://".length());
            }
          }
        }
        this.a.a();
      }
      
      public void a(Exception paramAnonymousException)
      {
        if ("login check response  onError :\n" + paramAnonymousException == null) {}
        for (String str = null;; str = paramAnonymousException.toString())
        {
          com.baidu.carlife.wechat.a.b.c.c(str);
          if ((paramAnonymousException == null) || (!paramAnonymousException.toString().contains("Canceled"))) {
            break;
          }
          this.a.d();
          return;
        }
        this.a.a();
      }
    };
    com.baidu.carlife.wechat.a.a.c.a(c.c(paramString), paramc);
  }
  
  public static void a(String paramString, e parame)
  {
    parame = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        com.baidu.carlife.wechat.a.b.c.c("redirect uri response : statusCode = " + paramAnonymousa.a() + "\n" + paramAnonymousa.b());
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.b();
          return;
        }
        Object localObject = Pattern.compile("<ret>([0-9]*)</ret>").matcher(paramAnonymousa.b());
        if ((((Matcher)localObject).find()) && (Integer.parseInt(((Matcher)localObject).group(1)) != 0))
        {
          this.a.b();
          return;
        }
        localObject = paramAnonymousa.c();
        j localj = new j();
        Matcher localMatcher = Pattern.compile("<skey>(.+)</skey>").matcher(paramAnonymousa.b());
        if (localMatcher.find()) {
          localj.a(localMatcher.group(1));
        }
        paramAnonymousa = Pattern.compile("<pass_ticket>(.+)</pass_ticket>").matcher(paramAnonymousa.b());
        if (paramAnonymousa.find()) {
          localj.f(paramAnonymousa.group(1));
        }
        localj.b((String)((Map)localObject).get("wxsid"));
        localj.c((String)((Map)localObject).get("wxuin"));
        localj.e((String)((Map)localObject).get("webwx_data_ticket"));
        localj.d((String)((Map)localObject).get("webwxuvid"));
        localj.g((String)((Map)localObject).get("mm_lang"));
        localj.h((String)((Map)localObject).get("wxloadtime"));
        com.baidu.carlife.wechat.b.c.a().a(localj);
        this.a.a();
      }
      
      public void a(Exception paramAnonymousException)
      {
        paramAnonymousException.printStackTrace();
        this.a.b();
      }
    };
    com.baidu.carlife.wechat.a.a.c.a(paramString + "&fun=new&version=v2&lang=zh_CN", parame);
  }
  
  public static void a(String paramString1, String paramString2, f paramf)
  {
    paramf = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        com.baidu.carlife.wechat.a.b.c.c("send msg response:\n" + paramAnonymousa.b());
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.a("statusCode=" + paramAnonymousa.a());
          return;
        }
        int i;
        try
        {
          i = new JSONObject(paramAnonymousa.b()).getJSONObject("BaseResponse").getInt("Ret");
          if (i == 0)
          {
            this.a.a();
            return;
          }
        }
        catch (Exception paramAnonymousa)
        {
          paramAnonymousa.printStackTrace();
          this.a.a(paramAnonymousa.toString());
          return;
        }
        if ((i == 1100) || (i == 1100))
        {
          this.a.b();
          return;
        }
        this.a.a("ret=" + i);
      }
      
      public void a(Exception paramAnonymousException)
      {
        this.a.a(paramAnonymousException.toString());
      }
    };
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("BaseRequest", com.baidu.carlife.wechat.b.c.a().j());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("Type", "1");
      localJSONObject2.put("Content", paramString2);
      localJSONObject2.put("FromUserName", com.baidu.carlife.wechat.b.c.a().e());
      localJSONObject2.put("ToUserName", paramString1);
      paramString1 = com.baidu.carlife.wechat.g.c.a();
      localJSONObject2.put("ClientMsgId", paramString1);
      localJSONObject2.put("LocalID", paramString1);
      localJSONObject1.put("Msg", localJSONObject2);
      localJSONObject1.put("Scene", "0");
      paramString1 = a(localJSONObject1.toString());
      com.baidu.carlife.wechat.a.a.c.a(c.e(), paramf, paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void a(List<com.baidu.carlife.wechat.b.b> paramList, int paramInt, a parama)
  {
    int i = paramList.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      parama.a(-1, null);
      return;
    }
    parama = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        com.baidu.carlife.wechat.a.b.c.c("load batch contact response:\n" + paramAnonymousa.b());
        if (paramAnonymousa.a().intValue() != 200)
        {
          this.a.a(this.b);
          return;
        }
        try
        {
          paramAnonymousa = new JSONObject(paramAnonymousa.b());
          com.baidu.carlife.wechat.a.b.c.c(paramAnonymousa.getJSONObject("BaseResponse").toString());
          if (paramAnonymousa.getJSONObject("BaseResponse").getInt("Ret") != 0)
          {
            this.a.a(this.b);
            return;
          }
        }
        catch (Exception paramAnonymousa)
        {
          paramAnonymousa.printStackTrace();
          this.a.a(this.b);
          return;
        }
        paramAnonymousa = b.a(paramAnonymousa.optJSONArray("ContactList"));
        this.a.a(this.b, paramAnonymousa);
      }
      
      public void a(Exception paramAnonymousException)
      {
        this.a.a(this.b);
      }
    };
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      localJSONObject1.put("BaseRequest", com.baidu.carlife.wechat.b.c.a().j());
      localJSONObject1.put("Count", paramList.size());
      localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.baidu.carlife.wechat.b.b localb = (com.baidu.carlife.wechat.b.b)paramList.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("UserName", localb.a());
        localJSONObject2.put("EncryChatRoomId", localb.h());
        localJSONArray.put(localJSONObject2);
        continue;
        paramList = a(localJSONObject1.toString());
      }
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
    for (;;)
    {
      com.baidu.carlife.wechat.a.a.c.a(c.d(), parama, paramList);
      return;
      localJSONObject1.put("List", localJSONArray);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    com.baidu.carlife.wechat.a.a.c.a(paramBoolean);
  }
  
  private static List<d> c(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = paramJSONArray.length();
    while (i < j)
    {
      d locald = d.a(paramJSONArray.getJSONObject(i));
      if ((locald != null) && (locald.o())) {
        localArrayList.add(locald);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static List<com.baidu.carlife.wechat.b.b> d(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = paramJSONArray.length();
    if (i < j)
    {
      com.baidu.carlife.wechat.b.b localb = com.baidu.carlife.wechat.b.b.a(paramJSONArray.optJSONObject(i));
      if ((localb == null) || (localb.j())) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localb);
      }
    }
    return localArrayList;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt, List<com.baidu.carlife.wechat.b.b> paramList);
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(String paramString);
    
    public abstract void b();
    
    public abstract void b(String paramString);
    
    public abstract void c();
    
    public abstract void d();
  }
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface e
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface f
  {
    public abstract void a();
    
    public abstract void a(String paramString);
    
    public abstract void b();
  }
  
  public static abstract interface g
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
  }
  
  public static abstract interface h
  {
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
  
  public static abstract interface i
  {
    public abstract void a();
    
    public abstract void a(String paramString);
  }
  
  public static abstract interface j
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */