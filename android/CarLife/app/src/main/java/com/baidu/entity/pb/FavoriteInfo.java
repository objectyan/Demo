package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FavoriteInfo extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f11166a;
    /* renamed from: b */
    private int f11167b = 0;
    /* renamed from: c */
    private boolean f11168c;
    /* renamed from: d */
    private String f11169d = "";
    /* renamed from: e */
    private List<Data> f11170e = Collections.emptyList();
    /* renamed from: f */
    private int f11171f = -1;

    public static final class Data extends MessageMicro {
        public static final int DETAILS_FIELD_NUMBER = 2;
        public static final int SUBKEY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f11162a;
        /* renamed from: b */
        private String f11163b = "";
        /* renamed from: c */
        private List<Details> f11164c = Collections.emptyList();
        /* renamed from: d */
        private int f11165d = -1;

        public static final class Details extends MessageMicro {
            public static final int CTIME_FIELD_NUMBER = 4;
            public static final int DO_COUNT_FIELD_NUMBER = 3;
            public static final int IF_DO_FIELD_NUMBER = 2;
            public static final int THEME_ID_FIELD_NUMBER = 1;
            public static final int ZHIDAHAO_FOLLOW_FIELD_NUMBER = 5;
            /* renamed from: a */
            private boolean f11151a;
            /* renamed from: b */
            private String f11152b = "";
            /* renamed from: c */
            private boolean f11153c;
            /* renamed from: d */
            private String f11154d = "";
            /* renamed from: e */
            private boolean f11155e;
            /* renamed from: f */
            private String f11156f = "";
            /* renamed from: g */
            private boolean f11157g;
            /* renamed from: h */
            private String f11158h = "";
            /* renamed from: i */
            private boolean f11159i;
            /* renamed from: j */
            private ZhidahaoFollow f11160j = null;
            /* renamed from: k */
            private int f11161k = -1;

            public static final class ZhidahaoFollow extends MessageMicro {
                public static final int LOGO_URL_FIELD_NUMBER = 3;
                public static final int MSGDATA_FIELD_NUMBER = 5;
                public static final int NEWNUM_FIELD_NUMBER = 4;
                public static final int SCREEN_NAME_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f11143a;
                /* renamed from: b */
                private String f11144b = "";
                /* renamed from: c */
                private boolean f11145c;
                /* renamed from: d */
                private String f11146d = "";
                /* renamed from: e */
                private boolean f11147e;
                /* renamed from: f */
                private int f11148f = 0;
                /* renamed from: g */
                private List<Msgdata> f11149g = Collections.emptyList();
                /* renamed from: h */
                private int f11150h = -1;

                public static final class Msgdata extends MessageMicro {
                    public static final int CONTENTURL_FIELD_NUMBER = 2;
                    public static final int TIMESTR_FIELD_NUMBER = 3;
                    public static final int TITLE_FIELD_NUMBER = 1;
                    /* renamed from: a */
                    private boolean f11136a;
                    /* renamed from: b */
                    private String f11137b = "";
                    /* renamed from: c */
                    private boolean f11138c;
                    /* renamed from: d */
                    private String f11139d = "";
                    /* renamed from: e */
                    private boolean f11140e;
                    /* renamed from: f */
                    private String f11141f = "";
                    /* renamed from: g */
                    private int f11142g = -1;

                    public static Msgdata parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Msgdata().mergeFrom(codedInputStreamMicro);
                    }

                    public static Msgdata parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Msgdata) new Msgdata().mergeFrom(bArr);
                    }

                    public final Msgdata clear() {
                        clearTitle();
                        clearContenturl();
                        clearTimestr();
                        this.f11142g = -1;
                        return this;
                    }

                    public Msgdata clearContenturl() {
                        this.f11138c = false;
                        this.f11139d = "";
                        return this;
                    }

                    public Msgdata clearTimestr() {
                        this.f11140e = false;
                        this.f11141f = "";
                        return this;
                    }

                    public Msgdata clearTitle() {
                        this.f11136a = false;
                        this.f11137b = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11142g < 0) {
                            getSerializedSize();
                        }
                        return this.f11142g;
                    }

                    public String getContenturl() {
                        return this.f11139d;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasTitle()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                        }
                        if (hasContenturl()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getContenturl());
                        }
                        if (hasTimestr()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getTimestr());
                        }
                        this.f11142g = i;
                        return i;
                    }

                    public String getTimestr() {
                        return this.f11141f;
                    }

                    public String getTitle() {
                        return this.f11137b;
                    }

                    public boolean hasContenturl() {
                        return this.f11138c;
                    }

                    public boolean hasTimestr() {
                        return this.f11140e;
                    }

                    public boolean hasTitle() {
                        return this.f11136a;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Msgdata mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setTitle(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setContenturl(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setTimestr(codedInputStreamMicro.readString());
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

                    public Msgdata setContenturl(String str) {
                        this.f11138c = true;
                        this.f11139d = str;
                        return this;
                    }

                    public Msgdata setTimestr(String str) {
                        this.f11140e = true;
                        this.f11141f = str;
                        return this;
                    }

                    public Msgdata setTitle(String str) {
                        this.f11136a = true;
                        this.f11137b = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasTitle()) {
                            codedOutputStreamMicro.writeString(1, getTitle());
                        }
                        if (hasContenturl()) {
                            codedOutputStreamMicro.writeString(2, getContenturl());
                        }
                        if (hasTimestr()) {
                            codedOutputStreamMicro.writeString(3, getTimestr());
                        }
                    }
                }

                public static ZhidahaoFollow parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ZhidahaoFollow().mergeFrom(codedInputStreamMicro);
                }

                public static ZhidahaoFollow parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ZhidahaoFollow) new ZhidahaoFollow().mergeFrom(bArr);
                }

                public ZhidahaoFollow addMsgdata(Msgdata msgdata) {
                    if (msgdata != null) {
                        if (this.f11149g.isEmpty()) {
                            this.f11149g = new ArrayList();
                        }
                        this.f11149g.add(msgdata);
                    }
                    return this;
                }

                public final ZhidahaoFollow clear() {
                    clearScreenName();
                    clearLogoUrl();
                    clearNewnum();
                    clearMsgdata();
                    this.f11150h = -1;
                    return this;
                }

                public ZhidahaoFollow clearLogoUrl() {
                    this.f11145c = false;
                    this.f11146d = "";
                    return this;
                }

                public ZhidahaoFollow clearMsgdata() {
                    this.f11149g = Collections.emptyList();
                    return this;
                }

                public ZhidahaoFollow clearNewnum() {
                    this.f11147e = false;
                    this.f11148f = 0;
                    return this;
                }

                public ZhidahaoFollow clearScreenName() {
                    this.f11143a = false;
                    this.f11144b = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f11150h < 0) {
                        getSerializedSize();
                    }
                    return this.f11150h;
                }

                public String getLogoUrl() {
                    return this.f11146d;
                }

                public Msgdata getMsgdata(int i) {
                    return (Msgdata) this.f11149g.get(i);
                }

                public int getMsgdataCount() {
                    return this.f11149g.size();
                }

                public List<Msgdata> getMsgdataList() {
                    return this.f11149g;
                }

                public int getNewnum() {
                    return this.f11148f;
                }

                public String getScreenName() {
                    return this.f11144b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasScreenName()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(2, getScreenName());
                    }
                    if (hasLogoUrl()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getLogoUrl());
                    }
                    if (hasNewnum()) {
                        i += CodedOutputStreamMicro.computeInt32Size(4, getNewnum());
                    }
                    int i2 = i;
                    for (Msgdata computeMessageSize : getMsgdataList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize) + i2;
                    }
                    this.f11150h = i2;
                    return i2;
                }

                public boolean hasLogoUrl() {
                    return this.f11145c;
                }

                public boolean hasNewnum() {
                    return this.f11147e;
                }

                public boolean hasScreenName() {
                    return this.f11143a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public ZhidahaoFollow mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 18:
                                setScreenName(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                setLogoUrl(codedInputStreamMicro.readString());
                                continue;
                            case 32:
                                setNewnum(codedInputStreamMicro.readInt32());
                                continue;
                            case 42:
                                MessageMicro msgdata = new Msgdata();
                                codedInputStreamMicro.readMessage(msgdata);
                                addMsgdata(msgdata);
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

                public ZhidahaoFollow setLogoUrl(String str) {
                    this.f11145c = true;
                    this.f11146d = str;
                    return this;
                }

                public ZhidahaoFollow setMsgdata(int i, Msgdata msgdata) {
                    if (msgdata != null) {
                        this.f11149g.set(i, msgdata);
                    }
                    return this;
                }

                public ZhidahaoFollow setNewnum(int i) {
                    this.f11147e = true;
                    this.f11148f = i;
                    return this;
                }

                public ZhidahaoFollow setScreenName(String str) {
                    this.f11143a = true;
                    this.f11144b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasScreenName()) {
                        codedOutputStreamMicro.writeString(2, getScreenName());
                    }
                    if (hasLogoUrl()) {
                        codedOutputStreamMicro.writeString(3, getLogoUrl());
                    }
                    if (hasNewnum()) {
                        codedOutputStreamMicro.writeInt32(4, getNewnum());
                    }
                    for (Msgdata writeMessage : getMsgdataList()) {
                        codedOutputStreamMicro.writeMessage(5, writeMessage);
                    }
                }
            }

            public static Details parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Details().mergeFrom(codedInputStreamMicro);
            }

            public static Details parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Details) new Details().mergeFrom(bArr);
            }

            public final Details clear() {
                clearThemeId();
                clearIfDo();
                clearDoCount();
                clearCtime();
                clearZhidahaoFollow();
                this.f11161k = -1;
                return this;
            }

            public Details clearCtime() {
                this.f11157g = false;
                this.f11158h = "";
                return this;
            }

            public Details clearDoCount() {
                this.f11155e = false;
                this.f11156f = "";
                return this;
            }

            public Details clearIfDo() {
                this.f11153c = false;
                this.f11154d = "";
                return this;
            }

            public Details clearThemeId() {
                this.f11151a = false;
                this.f11152b = "";
                return this;
            }

            public Details clearZhidahaoFollow() {
                this.f11159i = false;
                this.f11160j = null;
                return this;
            }

            public int getCachedSize() {
                if (this.f11161k < 0) {
                    getSerializedSize();
                }
                return this.f11161k;
            }

            public String getCtime() {
                return this.f11158h;
            }

            public String getDoCount() {
                return this.f11156f;
            }

            public String getIfDo() {
                return this.f11154d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasThemeId()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThemeId());
                }
                if (hasIfDo()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getIfDo());
                }
                if (hasDoCount()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getDoCount());
                }
                if (hasCtime()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getCtime());
                }
                if (hasZhidahaoFollow()) {
                    i += CodedOutputStreamMicro.computeMessageSize(5, getZhidahaoFollow());
                }
                this.f11161k = i;
                return i;
            }

            public String getThemeId() {
                return this.f11152b;
            }

            public ZhidahaoFollow getZhidahaoFollow() {
                return this.f11160j;
            }

            public boolean hasCtime() {
                return this.f11157g;
            }

            public boolean hasDoCount() {
                return this.f11155e;
            }

            public boolean hasIfDo() {
                return this.f11153c;
            }

            public boolean hasThemeId() {
                return this.f11151a;
            }

            public boolean hasZhidahaoFollow() {
                return this.f11159i;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Details mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setThemeId(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setIfDo(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setDoCount(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setCtime(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            MessageMicro zhidahaoFollow = new ZhidahaoFollow();
                            codedInputStreamMicro.readMessage(zhidahaoFollow);
                            setZhidahaoFollow(zhidahaoFollow);
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

            public Details setCtime(String str) {
                this.f11157g = true;
                this.f11158h = str;
                return this;
            }

            public Details setDoCount(String str) {
                this.f11155e = true;
                this.f11156f = str;
                return this;
            }

            public Details setIfDo(String str) {
                this.f11153c = true;
                this.f11154d = str;
                return this;
            }

            public Details setThemeId(String str) {
                this.f11151a = true;
                this.f11152b = str;
                return this;
            }

            public Details setZhidahaoFollow(ZhidahaoFollow zhidahaoFollow) {
                if (zhidahaoFollow == null) {
                    return clearZhidahaoFollow();
                }
                this.f11159i = true;
                this.f11160j = zhidahaoFollow;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasThemeId()) {
                    codedOutputStreamMicro.writeString(1, getThemeId());
                }
                if (hasIfDo()) {
                    codedOutputStreamMicro.writeString(2, getIfDo());
                }
                if (hasDoCount()) {
                    codedOutputStreamMicro.writeString(3, getDoCount());
                }
                if (hasCtime()) {
                    codedOutputStreamMicro.writeString(4, getCtime());
                }
                if (hasZhidahaoFollow()) {
                    codedOutputStreamMicro.writeMessage(5, getZhidahaoFollow());
                }
            }
        }

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public Data addDetails(Details details) {
            if (details != null) {
                if (this.f11164c.isEmpty()) {
                    this.f11164c = new ArrayList();
                }
                this.f11164c.add(details);
            }
            return this;
        }

        public final Data clear() {
            clearSubkey();
            clearDetails();
            this.f11165d = -1;
            return this;
        }

        public Data clearDetails() {
            this.f11164c = Collections.emptyList();
            return this;
        }

        public Data clearSubkey() {
            this.f11162a = false;
            this.f11163b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f11165d < 0) {
                getSerializedSize();
            }
            return this.f11165d;
        }

        public Details getDetails(int i) {
            return (Details) this.f11164c.get(i);
        }

        public int getDetailsCount() {
            return this.f11164c.size();
        }

        public List<Details> getDetailsList() {
            return this.f11164c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasSubkey()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSubkey());
            }
            int i2 = i;
            for (Details computeMessageSize : getDetailsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f11165d = i2;
            return i2;
        }

        public String getSubkey() {
            return this.f11163b;
        }

        public boolean hasSubkey() {
            return this.f11162a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Data mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setSubkey(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro details = new Details();
                        codedInputStreamMicro.readMessage(details);
                        addDetails(details);
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

        public Data setDetails(int i, Details details) {
            if (details != null) {
                this.f11164c.set(i, details);
            }
            return this;
        }

        public Data setSubkey(String str) {
            this.f11162a = true;
            this.f11163b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasSubkey()) {
                codedOutputStreamMicro.writeString(1, getSubkey());
            }
            for (Details writeMessage : getDetailsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static FavoriteInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new FavoriteInfo().mergeFrom(codedInputStreamMicro);
    }

    public static FavoriteInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (FavoriteInfo) new FavoriteInfo().mergeFrom(bArr);
    }

    public FavoriteInfo addData(Data data) {
        if (data != null) {
            if (this.f11170e.isEmpty()) {
                this.f11170e = new ArrayList();
            }
            this.f11170e.add(data);
        }
        return this;
    }

    public final FavoriteInfo clear() {
        clearError();
        clearMsg();
        clearData();
        this.f11171f = -1;
        return this;
    }

    public FavoriteInfo clearData() {
        this.f11170e = Collections.emptyList();
        return this;
    }

    public FavoriteInfo clearError() {
        this.f11166a = false;
        this.f11167b = 0;
        return this;
    }

    public FavoriteInfo clearMsg() {
        this.f11168c = false;
        this.f11169d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f11171f < 0) {
            getSerializedSize();
        }
        return this.f11171f;
    }

    public Data getData(int i) {
        return (Data) this.f11170e.get(i);
    }

    public int getDataCount() {
        return this.f11170e.size();
    }

    public List<Data> getDataList() {
        return this.f11170e;
    }

    public int getError() {
        return this.f11167b;
    }

    public String getMsg() {
        return this.f11169d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        if (hasMsg()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
        }
        int i2 = i;
        for (Data computeMessageSize : getDataList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
        }
        this.f11171f = i2;
        return i2;
    }

    public boolean hasError() {
        return this.f11166a;
    }

    public boolean hasMsg() {
        return this.f11168c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public FavoriteInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    MessageMicro data = new Data();
                    codedInputStreamMicro.readMessage(data);
                    addData(data);
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

    public FavoriteInfo setData(int i, Data data) {
        if (data != null) {
            this.f11170e.set(i, data);
        }
        return this;
    }

    public FavoriteInfo setError(int i) {
        this.f11166a = true;
        this.f11167b = i;
        return this;
    }

    public FavoriteInfo setMsg(String str) {
        this.f11168c = true;
        this.f11169d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        if (hasMsg()) {
            codedOutputStreamMicro.writeString(2, getMsg());
        }
        for (Data writeMessage : getDataList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage);
        }
    }
}
