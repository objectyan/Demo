package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class LiveShare extends MessageMicro {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    public static final int SHARE_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f11907a;
    /* renamed from: b */
    private int f11908b = 0;
    /* renamed from: c */
    private boolean f11909c;
    /* renamed from: d */
    private String f11910d = "";
    /* renamed from: e */
    private boolean f11911e;
    /* renamed from: f */
    private Share f11912f = null;
    /* renamed from: g */
    private int f11913g = -1;

    public static final class Share extends MessageMicro {
        public static final int BIGICON_FIELD_NUMBER = 6;
        public static final int LONGCONTENT_FIELD_NUMBER = 4;
        public static final int SHORTCONTENT_FIELD_NUMBER = 3;
        public static final int SMALLICON_FIELD_NUMBER = 5;
        public static final int TITLE_FIELD_NUMBER = 2;
        public static final int URL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f11894a;
        /* renamed from: b */
        private String f11895b = "";
        /* renamed from: c */
        private boolean f11896c;
        /* renamed from: d */
        private String f11897d = "";
        /* renamed from: e */
        private boolean f11898e;
        /* renamed from: f */
        private String f11899f = "";
        /* renamed from: g */
        private boolean f11900g;
        /* renamed from: h */
        private String f11901h = "";
        /* renamed from: i */
        private boolean f11902i;
        /* renamed from: j */
        private String f11903j = "";
        /* renamed from: k */
        private boolean f11904k;
        /* renamed from: l */
        private String f11905l = "";
        /* renamed from: m */
        private int f11906m = -1;

        public static Share parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Share().mergeFrom(codedInputStreamMicro);
        }

        public static Share parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Share) new Share().mergeFrom(bArr);
        }

        public final Share clear() {
            clearUrl();
            clearTitle();
            clearShortcontent();
            clearLongcontent();
            clearSmallicon();
            clearBigicon();
            this.f11906m = -1;
            return this;
        }

        public Share clearBigicon() {
            this.f11904k = false;
            this.f11905l = "";
            return this;
        }

        public Share clearLongcontent() {
            this.f11900g = false;
            this.f11901h = "";
            return this;
        }

        public Share clearShortcontent() {
            this.f11898e = false;
            this.f11899f = "";
            return this;
        }

        public Share clearSmallicon() {
            this.f11902i = false;
            this.f11903j = "";
            return this;
        }

        public Share clearTitle() {
            this.f11896c = false;
            this.f11897d = "";
            return this;
        }

        public Share clearUrl() {
            this.f11894a = false;
            this.f11895b = "";
            return this;
        }

        public String getBigicon() {
            return this.f11905l;
        }

        public int getCachedSize() {
            if (this.f11906m < 0) {
                getSerializedSize();
            }
            return this.f11906m;
        }

        public String getLongcontent() {
            return this.f11901h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasUrl()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasShortcontent()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getShortcontent());
            }
            if (hasLongcontent()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getLongcontent());
            }
            if (hasSmallicon()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getSmallicon());
            }
            if (hasBigicon()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getBigicon());
            }
            this.f11906m = i;
            return i;
        }

        public String getShortcontent() {
            return this.f11899f;
        }

        public String getSmallicon() {
            return this.f11903j;
        }

        public String getTitle() {
            return this.f11897d;
        }

        public String getUrl() {
            return this.f11895b;
        }

        public boolean hasBigicon() {
            return this.f11904k;
        }

        public boolean hasLongcontent() {
            return this.f11900g;
        }

        public boolean hasShortcontent() {
            return this.f11898e;
        }

        public boolean hasSmallicon() {
            return this.f11902i;
        }

        public boolean hasTitle() {
            return this.f11896c;
        }

        public boolean hasUrl() {
            return this.f11894a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Share mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setUrl(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setShortcontent(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setLongcontent(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setSmallicon(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setBigicon(codedInputStreamMicro.readString());
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

        public Share setBigicon(String str) {
            this.f11904k = true;
            this.f11905l = str;
            return this;
        }

        public Share setLongcontent(String str) {
            this.f11900g = true;
            this.f11901h = str;
            return this;
        }

        public Share setShortcontent(String str) {
            this.f11898e = true;
            this.f11899f = str;
            return this;
        }

        public Share setSmallicon(String str) {
            this.f11902i = true;
            this.f11903j = str;
            return this;
        }

        public Share setTitle(String str) {
            this.f11896c = true;
            this.f11897d = str;
            return this;
        }

        public Share setUrl(String str) {
            this.f11894a = true;
            this.f11895b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasUrl()) {
                codedOutputStreamMicro.writeString(1, getUrl());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasShortcontent()) {
                codedOutputStreamMicro.writeString(3, getShortcontent());
            }
            if (hasLongcontent()) {
                codedOutputStreamMicro.writeString(4, getLongcontent());
            }
            if (hasSmallicon()) {
                codedOutputStreamMicro.writeString(5, getSmallicon());
            }
            if (hasBigicon()) {
                codedOutputStreamMicro.writeString(6, getBigicon());
            }
        }
    }

    public static LiveShare parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new LiveShare().mergeFrom(codedInputStreamMicro);
    }

    public static LiveShare parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (LiveShare) new LiveShare().mergeFrom(bArr);
    }

    public final LiveShare clear() {
        clearError();
        clearMsg();
        clearShare();
        this.f11913g = -1;
        return this;
    }

    public LiveShare clearError() {
        this.f11907a = false;
        this.f11908b = 0;
        return this;
    }

    public LiveShare clearMsg() {
        this.f11909c = false;
        this.f11910d = "";
        return this;
    }

    public LiveShare clearShare() {
        this.f11911e = false;
        this.f11912f = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f11913g < 0) {
            getSerializedSize();
        }
        return this.f11913g;
    }

    public int getError() {
        return this.f11908b;
    }

    public String getMsg() {
        return this.f11910d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        if (hasMsg()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
        }
        if (hasShare()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getShare());
        }
        this.f11913g = i;
        return i;
    }

    public Share getShare() {
        return this.f11912f;
    }

    public boolean hasError() {
        return this.f11907a;
    }

    public boolean hasMsg() {
        return this.f11909c;
    }

    public boolean hasShare() {
        return this.f11911e;
    }

    public final boolean isInitialized() {
        return true;
    }

    public LiveShare mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setMsg(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    MessageMicro share = new Share();
                    codedInputStreamMicro.readMessage(share);
                    setShare(share);
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

    public LiveShare setError(int i) {
        this.f11907a = true;
        this.f11908b = i;
        return this;
    }

    public LiveShare setMsg(String str) {
        this.f11909c = true;
        this.f11910d = str;
        return this;
    }

    public LiveShare setShare(Share share) {
        if (share == null) {
            return clearShare();
        }
        this.f11911e = true;
        this.f11912f = share;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        if (hasMsg()) {
            codedOutputStreamMicro.writeString(2, getMsg());
        }
        if (hasShare()) {
            codedOutputStreamMicro.writeMessage(3, getShare());
        }
    }
}
