package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WalkPano extends MessageMicro {
    public static final int JPEG_FIELD_NUMBER = 2;
    public static final int LINKS_FIELD_NUMBER = 1;
    public static final int OPTION_FIELD_NUMBER = 3;
    /* renamed from: a */
    private List<Links> f16857a = Collections.emptyList();
    /* renamed from: b */
    private boolean f16858b;
    /* renamed from: c */
    private Option f16859c = null;
    /* renamed from: d */
    private boolean f16860d;
    /* renamed from: e */
    private String f16861e = "";
    /* renamed from: f */
    private int f16862f = -1;

    public static final class Links extends MessageMicro {
        public static final int LINK_FIELD_NUMBER = 1;
        public static final int LINK_ID_FIELD_NUMBER = 2;
        /* renamed from: a */
        private List<Link> f16846a = Collections.emptyList();
        /* renamed from: b */
        private boolean f16847b;
        /* renamed from: c */
        private String f16848c = "";
        /* renamed from: d */
        private int f16849d = -1;

        public static final class Link extends MessageMicro {
            public static final int PID_FIELD_NUMBER = 1;
            public static final int RX_FIELD_NUMBER = 2;
            public static final int RY_FIELD_NUMBER = 3;
            public static final int X_FIELD_NUMBER = 4;
            public static final int Y_FIELD_NUMBER = 5;
            /* renamed from: a */
            private boolean f16835a;
            /* renamed from: b */
            private String f16836b = "";
            /* renamed from: c */
            private boolean f16837c;
            /* renamed from: d */
            private int f16838d = 0;
            /* renamed from: e */
            private boolean f16839e;
            /* renamed from: f */
            private int f16840f = 0;
            /* renamed from: g */
            private boolean f16841g;
            /* renamed from: h */
            private int f16842h = 0;
            /* renamed from: i */
            private boolean f16843i;
            /* renamed from: j */
            private int f16844j = 0;
            /* renamed from: k */
            private int f16845k = -1;

            public static Link parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Link().mergeFrom(codedInputStreamMicro);
            }

            public static Link parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Link) new Link().mergeFrom(bArr);
            }

            public final Link clear() {
                clearPid();
                clearRx();
                clearRy();
                clearX();
                clearY();
                this.f16845k = -1;
                return this;
            }

            public Link clearPid() {
                this.f16835a = false;
                this.f16836b = "";
                return this;
            }

            public Link clearRx() {
                this.f16837c = false;
                this.f16838d = 0;
                return this;
            }

            public Link clearRy() {
                this.f16839e = false;
                this.f16840f = 0;
                return this;
            }

            public Link clearX() {
                this.f16841g = false;
                this.f16842h = 0;
                return this;
            }

            public Link clearY() {
                this.f16843i = false;
                this.f16844j = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f16845k < 0) {
                    getSerializedSize();
                }
                return this.f16845k;
            }

            public String getPid() {
                return this.f16836b;
            }

            public int getRx() {
                return this.f16838d;
            }

            public int getRy() {
                return this.f16840f;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasPid()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPid());
                }
                if (hasRx()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getRx());
                }
                if (hasRy()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getRy());
                }
                if (hasX()) {
                    i += CodedOutputStreamMicro.computeInt32Size(4, getX());
                }
                if (hasY()) {
                    i += CodedOutputStreamMicro.computeInt32Size(5, getY());
                }
                this.f16845k = i;
                return i;
            }

            public int getX() {
                return this.f16842h;
            }

            public int getY() {
                return this.f16844j;
            }

            public boolean hasPid() {
                return this.f16835a;
            }

            public boolean hasRx() {
                return this.f16837c;
            }

            public boolean hasRy() {
                return this.f16839e;
            }

            public boolean hasX() {
                return this.f16841g;
            }

            public boolean hasY() {
                return this.f16843i;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Link mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setPid(codedInputStreamMicro.readString());
                            continue;
                        case 16:
                            setRx(codedInputStreamMicro.readInt32());
                            continue;
                        case 24:
                            setRy(codedInputStreamMicro.readInt32());
                            continue;
                        case 32:
                            setX(codedInputStreamMicro.readInt32());
                            continue;
                        case 40:
                            setY(codedInputStreamMicro.readInt32());
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public Link setPid(String str) {
                this.f16835a = true;
                this.f16836b = str;
                return this;
            }

            public Link setRx(int i) {
                this.f16837c = true;
                this.f16838d = i;
                return this;
            }

            public Link setRy(int i) {
                this.f16839e = true;
                this.f16840f = i;
                return this;
            }

            public Link setX(int i) {
                this.f16841g = true;
                this.f16842h = i;
                return this;
            }

            public Link setY(int i) {
                this.f16843i = true;
                this.f16844j = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPid()) {
                    codedOutputStreamMicro.writeString(1, getPid());
                }
                if (hasRx()) {
                    codedOutputStreamMicro.writeInt32(2, getRx());
                }
                if (hasRy()) {
                    codedOutputStreamMicro.writeInt32(3, getRy());
                }
                if (hasX()) {
                    codedOutputStreamMicro.writeInt32(4, getX());
                }
                if (hasY()) {
                    codedOutputStreamMicro.writeInt32(5, getY());
                }
            }
        }

        public static Links parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Links().mergeFrom(codedInputStreamMicro);
        }

        public static Links parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Links) new Links().mergeFrom(bArr);
        }

        public Links addLink(Link link) {
            if (link != null) {
                if (this.f16846a.isEmpty()) {
                    this.f16846a = new ArrayList();
                }
                this.f16846a.add(link);
            }
            return this;
        }

        public final Links clear() {
            clearLink();
            clearLinkId();
            this.f16849d = -1;
            return this;
        }

        public Links clearLink() {
            this.f16846a = Collections.emptyList();
            return this;
        }

        public Links clearLinkId() {
            this.f16847b = false;
            this.f16848c = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16849d < 0) {
                getSerializedSize();
            }
            return this.f16849d;
        }

        public Link getLink(int i) {
            return (Link) this.f16846a.get(i);
        }

        public int getLinkCount() {
            return this.f16846a.size();
        }

        public String getLinkId() {
            return this.f16848c;
        }

        public List<Link> getLinkList() {
            return this.f16846a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Link computeMessageSize : getLinkList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            if (hasLinkId()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getLinkId());
            }
            this.f16849d = i;
            return i;
        }

        public boolean hasLinkId() {
            return this.f16847b;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Links mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro link = new Link();
                        codedInputStreamMicro.readMessage(link);
                        addLink(link);
                        continue;
                    case 18:
                        setLinkId(codedInputStreamMicro.readString());
                        continue;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public Links setLink(int i, Link link) {
            if (link != null) {
                this.f16846a.set(i, link);
            }
            return this;
        }

        public Links setLinkId(String str) {
            this.f16847b = true;
            this.f16848c = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Link writeMessage : getLinkList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            if (hasLinkId()) {
                codedOutputStreamMicro.writeString(2, getLinkId());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int HAS_PANO_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f16850a;
        /* renamed from: b */
        private int f16851b = 0;
        /* renamed from: c */
        private boolean f16852c;
        /* renamed from: d */
        private int f16853d = 0;
        /* renamed from: e */
        private boolean f16854e;
        /* renamed from: f */
        private int f16855f = 0;
        /* renamed from: g */
        private int f16856g = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearError();
            clearHasPano();
            clearType();
            this.f16856g = -1;
            return this;
        }

        public Option clearError() {
            this.f16850a = false;
            this.f16851b = 0;
            return this;
        }

        public Option clearHasPano() {
            this.f16852c = false;
            this.f16853d = 0;
            return this;
        }

        public Option clearType() {
            this.f16854e = false;
            this.f16855f = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f16856g < 0) {
                getSerializedSize();
            }
            return this.f16856g;
        }

        public int getError() {
            return this.f16851b;
        }

        public int getHasPano() {
            return this.f16853d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasError()) {
                i = 0 + CodedOutputStreamMicro.computeSInt32Size(1, getError());
            }
            if (hasHasPano()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getHasPano());
            }
            if (hasType()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getType());
            }
            this.f16856g = i;
            return i;
        }

        public int getType() {
            return this.f16855f;
        }

        public boolean hasError() {
            return this.f16850a;
        }

        public boolean hasHasPano() {
            return this.f16852c;
        }

        public boolean hasType() {
            return this.f16854e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setError(codedInputStreamMicro.readSInt32());
                        continue;
                    case 16:
                        setHasPano(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setType(codedInputStreamMicro.readInt32());
                        continue;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public Option setError(int i) {
            this.f16850a = true;
            this.f16851b = i;
            return this;
        }

        public Option setHasPano(int i) {
            this.f16852c = true;
            this.f16853d = i;
            return this;
        }

        public Option setType(int i) {
            this.f16854e = true;
            this.f16855f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeSInt32(1, getError());
            }
            if (hasHasPano()) {
                codedOutputStreamMicro.writeInt32(2, getHasPano());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(3, getType());
            }
        }
    }

    public static WalkPano parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new WalkPano().mergeFrom(codedInputStreamMicro);
    }

    public static WalkPano parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (WalkPano) new WalkPano().mergeFrom(bArr);
    }

    public WalkPano addLinks(Links links) {
        if (links != null) {
            if (this.f16857a.isEmpty()) {
                this.f16857a = new ArrayList();
            }
            this.f16857a.add(links);
        }
        return this;
    }

    public final WalkPano clear() {
        clearLinks();
        clearOption();
        clearJpeg();
        this.f16862f = -1;
        return this;
    }

    public WalkPano clearJpeg() {
        this.f16860d = false;
        this.f16861e = "";
        return this;
    }

    public WalkPano clearLinks() {
        this.f16857a = Collections.emptyList();
        return this;
    }

    public WalkPano clearOption() {
        this.f16858b = false;
        this.f16859c = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f16862f < 0) {
            getSerializedSize();
        }
        return this.f16862f;
    }

    public String getJpeg() {
        return this.f16861e;
    }

    public Links getLinks(int i) {
        return (Links) this.f16857a.get(i);
    }

    public int getLinksCount() {
        return this.f16857a.size();
    }

    public List<Links> getLinksList() {
        return this.f16857a;
    }

    public Option getOption() {
        return this.f16859c;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Links computeMessageSize : getLinksList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        if (hasJpeg()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getJpeg());
        }
        if (hasOption()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getOption());
        }
        this.f16862f = i;
        return i;
    }

    public boolean hasJpeg() {
        return this.f16860d;
    }

    public boolean hasOption() {
        return this.f16858b;
    }

    public final boolean isInitialized() {
        return true;
    }

    public WalkPano mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro links;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    links = new Links();
                    codedInputStreamMicro.readMessage(links);
                    addLinks(links);
                    continue;
                case 18:
                    setJpeg(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    links = new Option();
                    codedInputStreamMicro.readMessage(links);
                    setOption(links);
                    continue;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public WalkPano setJpeg(String str) {
        this.f16860d = true;
        this.f16861e = str;
        return this;
    }

    public WalkPano setLinks(int i, Links links) {
        if (links != null) {
            this.f16857a.set(i, links);
        }
        return this;
    }

    public WalkPano setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f16858b = true;
        this.f16859c = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Links writeMessage : getLinksList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasJpeg()) {
            codedOutputStreamMicro.writeString(2, getJpeg());
        }
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(3, getOption());
        }
    }
}
