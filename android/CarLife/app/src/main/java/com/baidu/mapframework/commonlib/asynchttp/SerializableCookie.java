package com.baidu.mapframework.commonlib.asynchttp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class SerializableCookie
  implements Serializable
{
  private static final long a = 6374381828722046732L;
  private final transient Cookie b;
  private transient BasicClientCookie c;
  
  public SerializableCookie(Cookie paramCookie)
  {
    this.b = paramCookie;
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.c = new BasicClientCookie((String)paramObjectInputStream.readObject(), (String)paramObjectInputStream.readObject());
    this.c.setComment((String)paramObjectInputStream.readObject());
    this.c.setDomain((String)paramObjectInputStream.readObject());
    this.c.setExpiryDate((Date)paramObjectInputStream.readObject());
    this.c.setPath((String)paramObjectInputStream.readObject());
    this.c.setVersion(paramObjectInputStream.readInt());
    this.c.setSecure(paramObjectInputStream.readBoolean());
  }
  
  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this.b.getName());
    paramObjectOutputStream.writeObject(this.b.getValue());
    paramObjectOutputStream.writeObject(this.b.getComment());
    paramObjectOutputStream.writeObject(this.b.getDomain());
    paramObjectOutputStream.writeObject(this.b.getExpiryDate());
    paramObjectOutputStream.writeObject(this.b.getPath());
    paramObjectOutputStream.writeInt(this.b.getVersion());
    paramObjectOutputStream.writeBoolean(this.b.isSecure());
  }
  
  public Cookie getCookie()
  {
    Object localObject = this.b;
    if (this.c != null) {
      localObject = this.c;
    }
    return (Cookie)localObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/SerializableCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */