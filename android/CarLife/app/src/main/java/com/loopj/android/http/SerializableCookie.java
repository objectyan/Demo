package com.loopj.android.http;

import cz.msebera.android.httpclient.p164f.C6329b;
import cz.msebera.android.httpclient.p173i.p181d.C6468c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class SerializableCookie implements Serializable {
    private static final long serialVersionUID = 6374381828722046732L;
    private transient C6468c clientCookie;
    private final transient C6329b cookie;

    public SerializableCookie(C6329b cookie) {
        this.cookie = cookie;
    }

    public C6329b getCookie() {
        C6329b bestCookie = this.cookie;
        if (this.clientCookie != null) {
            return this.clientCookie;
        }
        return bestCookie;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(this.cookie.mo5190a());
        out.writeObject(this.cookie.mo5195b());
        out.writeObject(this.cookie.mo5198c());
        out.writeObject(this.cookie.mo5206g());
        out.writeObject(this.cookie.mo5202e());
        out.writeObject(this.cookie.mo5207h());
        out.writeInt(this.cookie.mo5210k());
        out.writeBoolean(this.cookie.mo5209j());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.clientCookie = new C6468c((String) in.readObject(), (String) in.readObject());
        this.clientCookie.mo5201d((String) in.readObject());
        this.clientCookie.mo5203e((String) in.readObject());
        this.clientCookie.mo5196b((Date) in.readObject());
        this.clientCookie.mo5204f((String) in.readObject());
        this.clientCookie.mo5192a(in.readInt());
        this.clientCookie.mo5193a(in.readBoolean());
    }
}
