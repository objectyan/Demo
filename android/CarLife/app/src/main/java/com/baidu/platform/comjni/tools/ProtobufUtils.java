package com.baidu.platform.comjni.tools;

import android.text.TextUtils;
import com.baidu.entity.pb.RepHead;
import com.baidu.entity.pb.RepHead.MessageHead;
import com.google.protobuf.micro.MessageMicro;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtobufUtils {
    /* renamed from: a */
    static final String f20007a = ProtobufUtils.class.getSimpleName();
    /* renamed from: b */
    private static final boolean f20008b = false;
    /* renamed from: c */
    private static Map<String, Method> f20009c = new HashMap();

    /* renamed from: com.baidu.platform.comjni.tools.ProtobufUtils$a */
    public static class C4838a {
        /* renamed from: a */
        private MessageMicro f20004a;
        /* renamed from: b */
        private String f20005b;
        /* renamed from: c */
        private byte[] f20006c;

        C4838a(MessageMicro messageLite) {
            if (messageLite == null) {
                throw new NullPointerException();
            }
            this.f20004a = messageLite;
        }

        /* renamed from: a */
        public MessageMicro m16045a() {
            return this.f20004a;
        }

        /* renamed from: b */
        public String m16046b() {
            if (this.f20005b == null) {
                String canonicalName = this.f20004a.getClass().getCanonicalName();
                if (canonicalName.startsWith("com.baidu.entity.pb.")) {
                    this.f20005b = canonicalName.substring(20);
                }
            }
            return this.f20005b;
        }

        /* renamed from: c */
        public byte[] m16047c() {
            if (this.f20006c == null) {
                this.f20006c = this.f20004a.toByteArray();
            }
            return this.f20006c;
        }
    }

    /* renamed from: a */
    private static Method m16048a(ClassLoader classLoader, String classname) throws ClassNotFoundException, NoSuchMethodException {
        String key = classname + "@" + classLoader.hashCode();
        Method method = (Method) f20009c.get(key);
        if (method != null) {
            return method;
        }
        method = Class.forName(classname, true, classLoader).getDeclaredMethod("parseFrom", new Class[]{byte[].class});
        if (method != null) {
            method.setAccessible(true);
            f20009c.put(key, method);
        }
        return method;
    }

    public static MessageMicro getMessageLite(ClassLoader classLoader, String packageName, String messageName, byte[] data, int start, int length) {
        if (!(data == null || TextUtils.isEmpty(messageName))) {
            try {
                return (MessageMicro) m16048a(classLoader, packageName + "." + messageName.replace("\\.", "\\$")).invoke(null, new Object[]{readStream(new ByteArrayInputStream(data, start, length))});
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static MessageMicro getMessageLite(String packageName, String messageName, byte[] data, int start, int length) {
        if (!(data == null || TextUtils.isEmpty(messageName))) {
            try {
                return (MessageMicro) m16048a(ProtobufUtils.class.getClassLoader(), packageName + "." + messageName.replace("\\.", "\\$")).invoke(null, new Object[]{readStream(new ByteArrayInputStream(data, start, length))});
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static MessageMicro getMessageLite(ClassLoader classLoader, String messageName, byte[] data, int start, int length) {
        return getMessageLite(classLoader, "com.baidu.entity.pb", messageName, data, start, length);
    }

    public static MessageMicro getMessageLite(String messageName, byte[] data, int start, int length) {
        return getMessageLite("com.baidu.entity.pb", messageName, data, start, length);
    }

    public static MessageMicro getMessageLite(ClassLoader classLoader, String packageName, String messageName, byte[] data) {
        if (!(data == null || TextUtils.isEmpty(messageName))) {
            try {
                return (MessageMicro) m16048a(classLoader, packageName + "." + messageName.replace("\\.", "\\$")).invoke(null, new Object[]{data});
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static MessageMicro getMessageLite(String packageName, String messageName, byte[] data) {
        if (!(data == null || TextUtils.isEmpty(messageName))) {
            try {
                return (MessageMicro) m16048a(ProtobufUtils.class.getClassLoader(), packageName + "." + messageName.replace("\\.", "\\$")).invoke(null, new Object[]{data});
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static MessageMicro getMessageLite(ClassLoader classLoader, String messageName, byte[] data) {
        return getMessageLite(classLoader, "com.baidu.entity.pb", messageName, data);
    }

    public static MessageMicro getMessageLite(String messageName, byte[] data) {
        return getMessageLite("com.baidu.entity.pb", messageName, data);
    }

    public static C4838a fromMessageLite(MessageMicro messageLite) {
        return new C4838a(messageLite);
    }

    public static List<MessageMicro> getMessageLiteList(ClassLoader classLoaders, byte[] data, String packageName) throws IOException {
        ArrayList<MessageMicro> messageLites = new ArrayList();
        byte[] bindata = data;
        if (!(bindata == null || bindata.length == 0)) {
            int length = ByteBuffer.wrap(bindata, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
            RepHead repHead = RepHead.parseFrom(readStream(new ByteArrayInputStream(bindata, 4, length)));
            int messageheadCount = repHead.getMessageHeadCount();
            int START_OFFSET = length + 4;
            for (int i = 0; i < messageheadCount; i++) {
                MessageHead messageHead = repHead.getMessageHead(i);
                int msgOffset = START_OFFSET + messageHead.getOffset();
                MessageMicro messageLite = getMessageLite(classLoaders, packageName, messageHead.getName(), bindata, msgOffset, messageHead.getLength());
                if (messageLite != null) {
                    messageLites.add(messageLite);
                }
            }
        }
        return messageLites;
    }

    public static List<MessageMicro> getMessageLiteList(byte[] data, String packageName) throws IOException {
        ArrayList<MessageMicro> messageLites = new ArrayList();
        byte[] bindata = data;
        if (!(bindata == null || bindata.length == 0)) {
            int length = ByteBuffer.wrap(bindata, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
            RepHead repHead = RepHead.parseFrom(readStream(new ByteArrayInputStream(bindata, 4, length)));
            int messageheadCount = repHead.getMessageHeadCount();
            int START_OFFSET = length + 4;
            for (int i = 0; i < messageheadCount; i++) {
                MessageHead messageHead = repHead.getMessageHead(i);
                String msgName = messageHead.getName();
                int msgLength = messageHead.getLength();
                int msgOffset = START_OFFSET + messageHead.getOffset();
                if (msgName.equals("M")) {
                    MagicMsg msg = new MagicMsg();
                    msg.buffer = readStream(new ByteArrayInputStream(bindata, msgOffset, msgLength));
                    messageLites.add(msg);
                } else {
                    MessageMicro messageLite = getMessageLite(packageName, msgName, bindata, msgOffset, msgLength);
                    if (messageLite != null) {
                        messageLites.add(messageLite);
                    }
                }
            }
        }
        return messageLites;
    }

    public static List<MessageMicro> getMessageLiteList(ClassLoader classLoader, byte[] data) throws IOException {
        return getMessageLiteList(classLoader, data, "com.baidu.entity.pb");
    }

    public static List<MessageMicro> getMessageLiteList(byte[] data) throws IOException {
        return getMessageLiteList(data, "com.baidu.entity.pb");
    }

    public static byte[] readStream(InputStream inputStream) throws IOException {
        OutputStream output = new ByteArrayOutputStream();
        m16049a(inputStream, output);
        return output.toByteArray();
    }

    /* renamed from: a */
    private static void m16049a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        byte[] buf = new byte[512];
        while (true) {
            try {
                int count = inputStream.read(buf);
                if (count == -1) {
                    break;
                }
                outputStream.write(buf, 0, count);
            } finally {
                inputStream.close();
                outputStream.close();
            }
        }
        outputStream.flush();
    }
}
