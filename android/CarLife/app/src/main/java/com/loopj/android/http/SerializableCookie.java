package com.loopj.android.http;

import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.i.d.c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class SerializableCookie
  implements Serializable
{
  private static final long serialVersionUID = 6374381828722046732L;
  private transient c clientCookie;
  private final transient b cookie;
  
  public SerializableCookie(b paramb)
  {
    this.cookie = paramb;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.clientCookie = new c((String)paramObjectInputStream.readObject(), (String)paramObjectInputStream.readObject());
    this.clientCookie.d((String)paramObjectInputStream.readObject());
    this.clientCookie.e((String)paramObjectInputStream.readObject());
    this.clientCookie.b((Date)paramObjectInputStream.readObject());
    this.clientCookie.f((String)paramObjectInputStream.readObject());
    this.clientCookie.a(paramObjectInputStream.readInt());
    this.clientCookie.a(paramObjectInputStream.readBoolean());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this.cookie.a());
    paramObjectOutputStream.writeObject(this.cookie.b());
    paramObjectOutputStream.writeObject(this.cookie.c());
    paramObjectOutputStream.writeObject(this.cookie.g());
    paramObjectOutputStream.writeObject(this.cookie.e());
    paramObjectOutputStream.writeObject(this.cookie.h());
    paramObjectOutputStream.writeInt(this.cookie.k());
    paramObjectOutputStream.writeBoolean(this.cookie.j());
  }
  
  public b getCookie()
  {
    Object localObject = this.cookie;
    if (this.clientCookie != null) {
      localObject = this.clientCookie;
    }
    return (b)localObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/SerializableCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */