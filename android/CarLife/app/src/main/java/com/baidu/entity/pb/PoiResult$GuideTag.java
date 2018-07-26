package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiResult$GuideTag extends MessageMicro {
    public static final int CAPTION_FIELD_NUMBER = 5;
    public static final int CONTENTS_FIELD_NUMBER = 3;
    public static final int GUIDE_CONTENT_FIELD_NUMBER = 6;
    public static final int LOCATION_FIELD_NUMBER = 4;
    public static final int POSITION_FIELD_NUMBER = 1;
    public static final int TITLE_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f14031a;
    /* renamed from: b */
    private int f14032b = 0;
    /* renamed from: c */
    private boolean f14033c;
    /* renamed from: d */
    private String f14034d = "";
    /* renamed from: e */
    private List<String> f14035e = Collections.emptyList();
    /* renamed from: f */
    private boolean f14036f;
    /* renamed from: g */
    private int f14037g = 0;
    /* renamed from: h */
    private boolean f14038h;
    /* renamed from: i */
    private String f14039i = "";
    /* renamed from: j */
    private List<GuideContent> f14040j = Collections.emptyList();
    /* renamed from: k */
    private int f14041k = -1;

    /* renamed from: com.baidu.entity.pb.PoiResult$GuideTag$GuideContent */
    public static final class GuideContent extends MessageMicro {
        public static final int ALIGNMENT_FIELD_NUMBER = 2;
        public static final int QT_FIELD_NUMBER = 3;
        public static final int TEXT_FIELD_NUMBER = 1;
        public static final int X_FIELD_NUMBER = 4;
        public static final int Y_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f14020a;
        /* renamed from: b */
        private String f14021b = "";
        /* renamed from: c */
        private boolean f14022c;
        /* renamed from: d */
        private String f14023d = "";
        /* renamed from: e */
        private boolean f14024e;
        /* renamed from: f */
        private String f14025f = "";
        /* renamed from: g */
        private boolean f14026g;
        /* renamed from: h */
        private String f14027h = "";
        /* renamed from: i */
        private boolean f14028i;
        /* renamed from: j */
        private String f14029j = "";
        /* renamed from: k */
        private int f14030k = -1;

        public static GuideContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new GuideContent().mergeFrom(codedInputStreamMicro);
        }

        public static GuideContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (GuideContent) new GuideContent().mergeFrom(bArr);
        }

        public final GuideContent clear() {
            clearText();
            clearAlignment();
            clearQt();
            clearX();
            clearY();
            this.f14030k = -1;
            return this;
        }

        public GuideContent clearAlignment() {
            this.f14022c = false;
            this.f14023d = "";
            return this;
        }

        public GuideContent clearQt() {
            this.f14024e = false;
            this.f14025f = "";
            return this;
        }

        public GuideContent clearText() {
            this.f14020a = false;
            this.f14021b = "";
            return this;
        }

        public GuideContent clearX() {
            this.f14026g = false;
            this.f14027h = "";
            return this;
        }

        public GuideContent clearY() {
            this.f14028i = false;
            this.f14029j = "";
            return this;
        }

        public String getAlignment() {
            return this.f14023d;
        }

        public int getCachedSize() {
            if (this.f14030k < 0) {
                getSerializedSize();
            }
            return this.f14030k;
        }

        public String getQt() {
            return this.f14025f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasText()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getText());
            }
            if (hasAlignment()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getAlignment());
            }
            if (hasQt()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getQt());
            }
            if (hasX()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getX());
            }
            if (hasY()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getY());
            }
            this.f14030k = i;
            return i;
        }

        public String getText() {
            return this.f14021b;
        }

        public String getX() {
            return this.f14027h;
        }

        public String getY() {
            return this.f14029j;
        }

        public boolean hasAlignment() {
            return this.f14022c;
        }

        public boolean hasQt() {
            return this.f14024e;
        }

        public boolean hasText() {
            return this.f14020a;
        }

        public boolean hasX() {
            return this.f14026g;
        }

        public boolean hasY() {
            return this.f14028i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public GuideContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setText(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setAlignment(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setQt(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setX(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setY(codedInputStreamMicro.readString());
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

        public GuideContent setAlignment(String str) {
            this.f14022c = true;
            this.f14023d = str;
            return this;
        }

        public GuideContent setQt(String str) {
            this.f14024e = true;
            this.f14025f = str;
            return this;
        }

        public GuideContent setText(String str) {
            this.f14020a = true;
            this.f14021b = str;
            return this;
        }

        public GuideContent setX(String str) {
            this.f14026g = true;
            this.f14027h = str;
            return this;
        }

        public GuideContent setY(String str) {
            this.f14028i = true;
            this.f14029j = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasText()) {
                codedOutputStreamMicro.writeString(1, getText());
            }
            if (hasAlignment()) {
                codedOutputStreamMicro.writeString(2, getAlignment());
            }
            if (hasQt()) {
                codedOutputStreamMicro.writeString(3, getQt());
            }
            if (hasX()) {
                codedOutputStreamMicro.writeString(4, getX());
            }
            if (hasY()) {
                codedOutputStreamMicro.writeString(5, getY());
            }
        }
    }

    public static PoiResult$GuideTag parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$GuideTag().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$GuideTag parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$GuideTag) new PoiResult$GuideTag().mergeFrom(bArr);
    }

    public PoiResult$GuideTag addContents(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (this.f14035e.isEmpty()) {
            this.f14035e = new ArrayList();
        }
        this.f14035e.add(str);
        return this;
    }

    public PoiResult$GuideTag addGuideContent(GuideContent guideContent) {
        if (guideContent != null) {
            if (this.f14040j.isEmpty()) {
                this.f14040j = new ArrayList();
            }
            this.f14040j.add(guideContent);
        }
        return this;
    }

    public final PoiResult$GuideTag clear() {
        clearPosition();
        clearTitle();
        clearContents();
        clearLocation();
        clearCaption();
        clearGuideContent();
        this.f14041k = -1;
        return this;
    }

    public PoiResult$GuideTag clearCaption() {
        this.f14038h = false;
        this.f14039i = "";
        return this;
    }

    public PoiResult$GuideTag clearContents() {
        this.f14035e = Collections.emptyList();
        return this;
    }

    public PoiResult$GuideTag clearGuideContent() {
        this.f14040j = Collections.emptyList();
        return this;
    }

    public PoiResult$GuideTag clearLocation() {
        this.f14036f = false;
        this.f14037g = 0;
        return this;
    }

    public PoiResult$GuideTag clearPosition() {
        this.f14031a = false;
        this.f14032b = 0;
        return this;
    }

    public PoiResult$GuideTag clearTitle() {
        this.f14033c = false;
        this.f14034d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f14041k < 0) {
            getSerializedSize();
        }
        return this.f14041k;
    }

    public String getCaption() {
        return this.f14039i;
    }

    public String getContents(int i) {
        return (String) this.f14035e.get(i);
    }

    public int getContentsCount() {
        return this.f14035e.size();
    }

    public List<String> getContentsList() {
        return this.f14035e;
    }

    public GuideContent getGuideContent(int i) {
        return (GuideContent) this.f14040j.get(i);
    }

    public int getGuideContentCount() {
        return this.f14040j.size();
    }

    public List<GuideContent> getGuideContentList() {
        return this.f14040j;
    }

    public int getLocation() {
        return this.f14037g;
    }

    public int getPosition() {
        return this.f14032b;
    }

    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = hasPosition() ? CodedOutputStreamMicro.computeInt32Size(1, getPosition()) + 0 : 0;
        int computeStringSize = hasTitle() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(2, getTitle()) : computeInt32Size;
        for (String computeStringSizeNoTag : getContentsList()) {
            i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
        }
        computeInt32Size = (computeStringSize + i) + (getContentsList().size() * 1);
        if (hasLocation()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getLocation());
        }
        if (hasCaption()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getCaption());
        }
        i = computeInt32Size;
        for (GuideContent computeMessageSize : getGuideContentList()) {
            i = CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize) + i;
        }
        this.f14041k = i;
        return i;
    }

    public String getTitle() {
        return this.f14034d;
    }

    public boolean hasCaption() {
        return this.f14038h;
    }

    public boolean hasLocation() {
        return this.f14036f;
    }

    public boolean hasPosition() {
        return this.f14031a;
    }

    public boolean hasTitle() {
        return this.f14033c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$GuideTag mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setPosition(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setTitle(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    addContents(codedInputStreamMicro.readString());
                    continue;
                case 32:
                    setLocation(codedInputStreamMicro.readInt32());
                    continue;
                case 42:
                    setCaption(codedInputStreamMicro.readString());
                    continue;
                case 50:
                    MessageMicro guideContent = new GuideContent();
                    codedInputStreamMicro.readMessage(guideContent);
                    addGuideContent(guideContent);
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

    public PoiResult$GuideTag setCaption(String str) {
        this.f14038h = true;
        this.f14039i = str;
        return this;
    }

    public PoiResult$GuideTag setContents(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f14035e.set(i, str);
        return this;
    }

    public PoiResult$GuideTag setGuideContent(int i, GuideContent guideContent) {
        if (guideContent != null) {
            this.f14040j.set(i, guideContent);
        }
        return this;
    }

    public PoiResult$GuideTag setLocation(int i) {
        this.f14036f = true;
        this.f14037g = i;
        return this;
    }

    public PoiResult$GuideTag setPosition(int i) {
        this.f14031a = true;
        this.f14032b = i;
        return this;
    }

    public PoiResult$GuideTag setTitle(String str) {
        this.f14033c = true;
        this.f14034d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasPosition()) {
            codedOutputStreamMicro.writeInt32(1, getPosition());
        }
        if (hasTitle()) {
            codedOutputStreamMicro.writeString(2, getTitle());
        }
        for (String writeString : getContentsList()) {
            codedOutputStreamMicro.writeString(3, writeString);
        }
        if (hasLocation()) {
            codedOutputStreamMicro.writeInt32(4, getLocation());
        }
        if (hasCaption()) {
            codedOutputStreamMicro.writeString(5, getCaption());
        }
        for (GuideContent writeMessage : getGuideContentList()) {
            codedOutputStreamMicro.writeMessage(6, writeMessage);
        }
    }
}
