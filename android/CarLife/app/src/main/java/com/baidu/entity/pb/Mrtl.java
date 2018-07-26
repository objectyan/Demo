package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Mrtl extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<Content> f12128a = Collections.emptyList();
    /* renamed from: b */
    private int f12129b = -1;

    public static final class Content extends MessageMicro {
        public static final int LABEL_FIELD_NUMBER = 1;
        public static final int RET_CODE_FIELD_NUMBER = 2;
        public static final int ROUTE_FIELD_NUMBER = 3;
        public static final int TRAFFIC_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f12119a;
        /* renamed from: b */
        private Route f12120b = null;
        /* renamed from: c */
        private boolean f12121c;
        /* renamed from: d */
        private Traffic f12122d = null;
        /* renamed from: e */
        private boolean f12123e;
        /* renamed from: f */
        private String f12124f = "";
        /* renamed from: g */
        private boolean f12125g;
        /* renamed from: h */
        private int f12126h = 0;
        /* renamed from: i */
        private int f12127i = -1;

        public static final class Route extends MessageMicro {
            public static final int DISTANCE_FIELD_NUMBER = 1;
            public static final int DURATION_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f12111a;
            /* renamed from: b */
            private int f12112b = 0;
            /* renamed from: c */
            private boolean f12113c;
            /* renamed from: d */
            private int f12114d = 0;
            /* renamed from: e */
            private int f12115e = -1;

            public static Route parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Route().mergeFrom(codedInputStreamMicro);
            }

            public static Route parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Route) new Route().mergeFrom(bArr);
            }

            public final Route clear() {
                clearDistance();
                clearDuration();
                this.f12115e = -1;
                return this;
            }

            public Route clearDistance() {
                this.f12111a = false;
                this.f12112b = 0;
                return this;
            }

            public Route clearDuration() {
                this.f12113c = false;
                this.f12114d = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f12115e < 0) {
                    getSerializedSize();
                }
                return this.f12115e;
            }

            public int getDistance() {
                return this.f12112b;
            }

            public int getDuration() {
                return this.f12114d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasDistance()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
                }
                if (hasDuration()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                }
                this.f12115e = i;
                return i;
            }

            public boolean hasDistance() {
                return this.f12111a;
            }

            public boolean hasDuration() {
                return this.f12113c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Route mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setDistance(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            setDuration(codedInputStreamMicro.readInt32());
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

            public Route setDistance(int i) {
                this.f12111a = true;
                this.f12112b = i;
                return this;
            }

            public Route setDuration(int i) {
                this.f12113c = true;
                this.f12114d = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(1, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(2, getDuration());
                }
            }
        }

        public static final class Traffic extends MessageMicro {
            public static final int LENGTH_FIELD_NUMBER = 1;
            public static final int STATUS_FIELD_NUMBER = 2;
            /* renamed from: a */
            private List<Integer> f12116a = Collections.emptyList();
            /* renamed from: b */
            private List<Integer> f12117b = Collections.emptyList();
            /* renamed from: c */
            private int f12118c = -1;

            public static Traffic parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Traffic().mergeFrom(codedInputStreamMicro);
            }

            public static Traffic parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Traffic) new Traffic().mergeFrom(bArr);
            }

            public Traffic addLength(int i) {
                if (this.f12116a.isEmpty()) {
                    this.f12116a = new ArrayList();
                }
                this.f12116a.add(Integer.valueOf(i));
                return this;
            }

            public Traffic addStatus(int i) {
                if (this.f12117b.isEmpty()) {
                    this.f12117b = new ArrayList();
                }
                this.f12117b.add(Integer.valueOf(i));
                return this;
            }

            public final Traffic clear() {
                clearLength();
                clearStatus();
                this.f12118c = -1;
                return this;
            }

            public Traffic clearLength() {
                this.f12116a = Collections.emptyList();
                return this;
            }

            public Traffic clearStatus() {
                this.f12117b = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f12118c < 0) {
                    getSerializedSize();
                }
                return this.f12118c;
            }

            public int getLength(int i) {
                return ((Integer) this.f12116a.get(i)).intValue();
            }

            public int getLengthCount() {
                return this.f12116a.size();
            }

            public List<Integer> getLengthList() {
                return this.f12116a;
            }

            public int getSerializedSize() {
                int i = 0;
                int i2 = 0;
                for (Integer intValue : getLengthList()) {
                    i2 = CodedOutputStreamMicro.computeInt32SizeNoTag(intValue.intValue()) + i2;
                }
                i2 = (getLengthList().size() * 1) + (0 + i2);
                for (Integer intValue2 : getStatusList()) {
                    i += CodedOutputStreamMicro.computeInt32SizeNoTag(intValue2.intValue());
                }
                int size = (i2 + i) + (getStatusList().size() * 1);
                this.f12118c = size;
                return size;
            }

            public int getStatus(int i) {
                return ((Integer) this.f12117b.get(i)).intValue();
            }

            public int getStatusCount() {
                return this.f12117b.size();
            }

            public List<Integer> getStatusList() {
                return this.f12117b;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Traffic mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            addLength(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            addStatus(codedInputStreamMicro.readInt32());
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

            public Traffic setLength(int i, int i2) {
                this.f12116a.set(i, Integer.valueOf(i2));
                return this;
            }

            public Traffic setStatus(int i, int i2) {
                this.f12117b.set(i, Integer.valueOf(i2));
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer intValue : getLengthList()) {
                    codedOutputStreamMicro.writeInt32(1, intValue.intValue());
                }
                for (Integer intValue2 : getStatusList()) {
                    codedOutputStreamMicro.writeInt32(2, intValue2.intValue());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearRoute();
            clearTraffic();
            clearLabel();
            clearRetCode();
            this.f12127i = -1;
            return this;
        }

        public Content clearLabel() {
            this.f12123e = false;
            this.f12124f = "";
            return this;
        }

        public Content clearRetCode() {
            this.f12125g = false;
            this.f12126h = 0;
            return this;
        }

        public Content clearRoute() {
            this.f12119a = false;
            this.f12120b = null;
            return this;
        }

        public Content clearTraffic() {
            this.f12121c = false;
            this.f12122d = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f12127i < 0) {
                getSerializedSize();
            }
            return this.f12127i;
        }

        public String getLabel() {
            return this.f12124f;
        }

        public int getRetCode() {
            return this.f12126h;
        }

        public Route getRoute() {
            return this.f12120b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLabel()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLabel());
            }
            if (hasRetCode()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getRetCode());
            }
            if (hasRoute()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getRoute());
            }
            if (hasTraffic()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getTraffic());
            }
            this.f12127i = i;
            return i;
        }

        public Traffic getTraffic() {
            return this.f12122d;
        }

        public boolean hasLabel() {
            return this.f12123e;
        }

        public boolean hasRetCode() {
            return this.f12125g;
        }

        public boolean hasRoute() {
            return this.f12119a;
        }

        public boolean hasTraffic() {
            return this.f12121c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro route;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setLabel(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setRetCode(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        route = new Route();
                        codedInputStreamMicro.readMessage(route);
                        setRoute(route);
                        continue;
                    case 34:
                        route = new Traffic();
                        codedInputStreamMicro.readMessage(route);
                        setTraffic(route);
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

        public Content setLabel(String str) {
            this.f12123e = true;
            this.f12124f = str;
            return this;
        }

        public Content setRetCode(int i) {
            this.f12125g = true;
            this.f12126h = i;
            return this;
        }

        public Content setRoute(Route route) {
            if (route == null) {
                return clearRoute();
            }
            this.f12119a = true;
            this.f12120b = route;
            return this;
        }

        public Content setTraffic(Traffic traffic) {
            if (traffic == null) {
                return clearTraffic();
            }
            this.f12121c = true;
            this.f12122d = traffic;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLabel()) {
                codedOutputStreamMicro.writeString(1, getLabel());
            }
            if (hasRetCode()) {
                codedOutputStreamMicro.writeInt32(2, getRetCode());
            }
            if (hasRoute()) {
                codedOutputStreamMicro.writeMessage(3, getRoute());
            }
            if (hasTraffic()) {
                codedOutputStreamMicro.writeMessage(4, getTraffic());
            }
        }
    }

    public static Mrtl parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Mrtl().mergeFrom(codedInputStreamMicro);
    }

    public static Mrtl parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Mrtl) new Mrtl().mergeFrom(bArr);
    }

    public Mrtl addContent(Content content) {
        if (content != null) {
            if (this.f12128a.isEmpty()) {
                this.f12128a = new ArrayList();
            }
            this.f12128a.add(content);
        }
        return this;
    }

    public final Mrtl clear() {
        clearContent();
        this.f12129b = -1;
        return this;
    }

    public Mrtl clearContent() {
        this.f12128a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f12129b < 0) {
            getSerializedSize();
        }
        return this.f12129b;
    }

    public Content getContent(int i) {
        return (Content) this.f12128a.get(i);
    }

    public int getContentCount() {
        return this.f12128a.size();
    }

    public List<Content> getContentList() {
        return this.f12128a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Content computeMessageSize : getContentList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f12129b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Mrtl mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro content = new Content();
                    codedInputStreamMicro.readMessage(content);
                    addContent(content);
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

    public Mrtl setContent(int i, Content content) {
        if (content != null) {
            this.f12128a.set(i, content);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
