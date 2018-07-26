package com.baidu.mapframework.commonlib.asynchttp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class SerializableCookie implements Serializable {
    /* renamed from: a */
    private static final long f18913a = 6374381828722046732L;
    /* renamed from: b */
    private final transient Cookie f18914b;
    /* renamed from: c */
    private transient BasicClientCookie f18915c;

    public SerializableCookie(Cookie cookie) {
        this.f18914b = cookie;
    }

    public Cookie getCookie() {
        Cookie bestCookie = this.f18914b;
        if (this.f18915c != null) {
            return this.f18915c;
        }
        return bestCookie;
    }

    /* renamed from: a */
    private void m14971a(ObjectOutputStream out) throws IOException {
        out.writeObject(this.f18914b.getName());
        out.writeObject(this.f18914b.getValue());
        out.writeObject(this.f18914b.getComment());
        out.writeObject(this.f18914b.getDomain());
        out.writeObject(this.f18914b.getExpiryDate());
        out.writeObject(this.f18914b.getPath());
        out.writeInt(this.f18914b.getVersion());
        out.writeBoolean(this.f18914b.isSecure());
    }

    /* renamed from: a */
    private void m14970a(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.f18915c = new BasicClientCookie((String) in.readObject(), (String) in.readObject());
        this.f18915c.setComment((String) in.readObject());
        this.f18915c.setDomain((String) in.readObject());
        this.f18915c.setExpiryDate((Date) in.readObject());
        this.f18915c.setPath((String) in.readObject());
        this.f18915c.setVersion(in.readInt());
        this.f18915c.setSecure(in.readBoolean());
    }
}
