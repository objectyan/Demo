package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.d;
import com.baidu.android.pushservice.j.h;
import com.baidu.android.pushservice.j.p;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends c
{
  private Context b;
  
  public j(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext.getApplicationContext();
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    int i = 0;
    if (i < paramArrayOfByte.length) {
      if (paramArrayOfByte[i] != 0) {}
    }
    for (;;)
    {
      return new String(paramArrayOfByte, 0, i);
      i += 1;
      break;
      i = 0;
    }
  }
  
  public g a(e parame)
  {
    parame.e = true;
    localg = new g();
    localg.a(-1);
    Object localObject1 = parame.c;
    if (localObject1 == null) {
      return localg;
    }
    Object localObject2 = new ByteArrayInputStream((byte[])localObject1);
    h localh = new h((InputStream)localObject2);
    try
    {
      k localk = new k();
      Object localObject3 = new byte[''];
      localh.a((byte[])localObject3);
      localk.a(a((byte[])localObject3));
      localk.d(localh.d());
      int i = localh.c();
      localk.a(i);
      int j = localh.c();
      localObject3 = new byte[64];
      localh.a((byte[])localObject3);
      localk.a((byte[])localObject3);
      if (j > 0)
      {
        localObject3 = new byte[j];
        localh.a((byte[])localObject3);
        localObject3 = new String((byte[])localObject3);
        try
        {
          localObject3 = new JSONObject((String)localObject3);
          if (!((JSONObject)localObject3).isNull("package_name"))
          {
            str = ((JSONObject)localObject3).getString("package_name");
            if (!TextUtils.isEmpty(str)) {
              localk.b(str);
            }
          }
          if (!((JSONObject)localObject3).isNull("expiretime")) {
            localk.c(((JSONObject)localObject3).getLong("expiretime"));
          }
          if ((com.baidu.android.pushservice.message.a.l.j.a() != i) && (com.baidu.android.pushservice.message.a.l.k.a() != i) && (com.baidu.android.pushservice.message.a.l.l.a() != i)) {
            break label582;
          }
          localk.a(true);
          d.a().a(new com.baidu.android.pushservice.i.c("deleteInvalidAlarmMsg", (short)95)
          {
            public void a()
            {
              com.baidu.android.pushservice.d.a.c(j.this.a);
            }
          });
          if (((JSONObject)localObject3).isNull("alarmmsgid")) {
            break label535;
          }
          String str = ((JSONObject)localObject3).getString("alarmmsgid");
          if (((JSONObject)localObject3).isNull("alarmmsgenable")) {
            break label535;
          }
          i = ((JSONObject)localObject3).getInt("alarmmsgenable");
          i = com.baidu.android.pushservice.d.a.a(this.a, str, i);
          parame.a(localk);
          if (i >= 0) {
            break label530;
          }
          i = 3;
          localg.a(i);
          return localg;
        }
        catch (JSONException localJSONException) {}
        label358:
        ((ByteArrayInputStream)localObject2).close();
        localh.a();
        parame.a(localk);
        if (j <= 0) {
          break label600;
        }
        i = j;
        label380:
        j = i + 204;
        i = localObject1.length - j;
        if (i <= 0) {
          break label605;
        }
      }
      for (;;)
      {
        localObject2 = new byte[i];
        System.arraycopy(localObject1, j, localObject2, 0, i);
        p.b("New MSG: " + localk.toString(), this.a);
        if (!com.baidu.android.pushservice.d.c.c(this.a, localk.g())) {
          break label610;
        }
        com.baidu.android.pushservice.g.a.a("PushMessageHandler", "Message ID(" + localk.h() + ") received duplicated, ack success to server directly.", this.b);
        com.baidu.android.pushservice.h.l.a(this.a, localk.e(), localk.h(), localk.i(), (byte[])localObject2, 4, com.baidu.android.pushservice.h.j.a);
        localg.a(4);
        return localg;
        label530:
        i = 0;
        break;
        label535:
        if (!localJSONException.isNull("sendtime")) {
          localk.a(localJSONException.getLong("sendtime"));
        }
        if (localJSONException.isNull("showtime")) {
          break label358;
        }
        localk.b(localJSONException.getLong("showtime"));
        break label358;
        label582:
        localk.a(false);
        break label358;
        localk.a(false);
        break label358;
        label600:
        i = 0;
        break label380;
        label605:
        i = 0;
      }
      label610:
      localObject1 = com.baidu.android.pushservice.message.a.l.a(localk.i());
      parame = new com.baidu.android.pushservice.message.a.k(this.a).a((com.baidu.android.pushservice.message.a.l)localObject1);
      if (parame != null)
      {
        parame = parame.a(localk, (byte[])localObject2);
        if ((localObject1 != com.baidu.android.pushservice.message.a.l.b) && (localObject1 != com.baidu.android.pushservice.message.a.l.c) && (localObject1 != com.baidu.android.pushservice.message.a.l.g)) {
          break label769;
        }
        com.baidu.android.pushservice.d.c.a(this.a, localk.e(), localk.i(), localk.g(), (byte[])localObject2, localk.j(), localk.d(), parame.a());
        label712:
        if (!p.F(this.a)) {
          break label801;
        }
      }
      label769:
      label801:
      for (;;)
      {
        i = com.baidu.android.pushservice.h.j.a;
        com.baidu.android.pushservice.h.l.a(this.a, localk.e(), localk.h(), localk.i(), (byte[])localObject2, parame.a(), i);
        return parame;
        localg.a(2);
        parame = localg;
        break;
        com.baidu.android.pushservice.d.c.a(this.a, localk.e(), localk.i(), localk.g(), null, null, 0L, parame.a());
        break label712;
      }
      return localg;
    }
    catch (IOException parame) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */