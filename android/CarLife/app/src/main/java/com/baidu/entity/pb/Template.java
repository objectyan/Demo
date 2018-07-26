package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.carlife.core.C1253f;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Template extends MessageMicro {
    public static final int BTABLE_FIELD_NUMBER = 7;
    public static final int IMAGE_FIELD_NUMBER = 2;
    public static final int LTABLE_FIELD_NUMBER = 9;
    public static final int MAPSEARCHALADDINNORMAL_FIELD_NUMBER = 5;
    public static final int MAPSEARCHALADDINPANEL_FIELD_NUMBER = 4;
    public static final int NORMAL_FIELD_NUMBER = 1;
    public static final int PANEL_FIELD_NUMBER = 3;
    public static final int SINGLECARD_FIELD_NUMBER = 8;
    public static final int VTABLE_FIELD_NUMBER = 6;
    /* renamed from: a */
    private boolean f16217a;
    /* renamed from: b */
    private NormalTemplate f16218b = null;
    /* renamed from: c */
    private boolean f16219c;
    /* renamed from: d */
    private ImageTemplate f16220d = null;
    /* renamed from: e */
    private boolean f16221e;
    /* renamed from: f */
    private PanelTemplate f16222f = null;
    /* renamed from: g */
    private boolean f16223g;
    /* renamed from: h */
    private MapSearchaladdinPanelTemplate f16224h = null;
    /* renamed from: i */
    private boolean f16225i;
    /* renamed from: j */
    private MapSearchaladdinNormalTemplate f16226j = null;
    /* renamed from: k */
    private boolean f16227k;
    /* renamed from: l */
    private VtableTemplate f16228l = null;
    /* renamed from: m */
    private boolean f16229m;
    /* renamed from: n */
    private BtableTemplate f16230n = null;
    /* renamed from: o */
    private boolean f16231o;
    /* renamed from: p */
    private SingleCardTemplate f16232p = null;
    /* renamed from: q */
    private boolean f16233q;
    /* renamed from: r */
    private LtableTemplate f16234r = null;
    /* renamed from: s */
    private int f16235s = -1;

    public static final class BtableTemplate extends MessageMicro {
        public static final int R1C1_FIELD_NUMBER = 1;
        public static final int R1C2_FIELD_NUMBER = 2;
        public static final int R1C4_FIELD_NUMBER = 3;
        public static final int R2C1_FIELD_NUMBER = 4;
        public static final int R2C2_FIELD_NUMBER = 5;
        public static final int R3C1_FIELD_NUMBER = 6;
        public static final int R3C2_FIELD_NUMBER = 7;
        public static final int R4C1_FIELD_NUMBER = 8;
        public static final int R5C1_FIELD_NUMBER = 9;
        public static final int R6C1_FIELD_NUMBER = 10;
        public static final int R7C1_FIELD_NUMBER = 11;
        /* renamed from: a */
        private boolean f15950a;
        /* renamed from: b */
        private RichText f15951b = null;
        /* renamed from: c */
        private boolean f15952c;
        /* renamed from: d */
        private RichText f15953d = null;
        /* renamed from: e */
        private List<Button> f15954e = Collections.emptyList();
        /* renamed from: f */
        private boolean f15955f;
        /* renamed from: g */
        private Score f15956g = null;
        /* renamed from: h */
        private boolean f15957h;
        /* renamed from: i */
        private RichText f15958i = null;
        /* renamed from: j */
        private boolean f15959j;
        /* renamed from: k */
        private RichText f15960k = null;
        /* renamed from: l */
        private boolean f15961l;
        /* renamed from: m */
        private RichText f15962m = null;
        /* renamed from: n */
        private List<RichText> f15963n = Collections.emptyList();
        /* renamed from: o */
        private boolean f15964o;
        /* renamed from: p */
        private ComboBox f15965p = null;
        /* renamed from: q */
        private boolean f15966q;
        /* renamed from: r */
        private Fatherson f15967r = null;
        /* renamed from: s */
        private boolean f15968s;
        /* renamed from: t */
        private Composit f15969t = null;
        /* renamed from: u */
        private int f15970u = -1;

        public static BtableTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BtableTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static BtableTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BtableTemplate) new BtableTemplate().mergeFrom(bArr);
        }

        public BtableTemplate addR1C4(Button button) {
            if (button != null) {
                if (this.f15954e.isEmpty()) {
                    this.f15954e = new ArrayList();
                }
                this.f15954e.add(button);
            }
            return this;
        }

        public BtableTemplate addR4C1(RichText richText) {
            if (richText != null) {
                if (this.f15963n.isEmpty()) {
                    this.f15963n = new ArrayList();
                }
                this.f15963n.add(richText);
            }
            return this;
        }

        public final BtableTemplate clear() {
            clearR1C1();
            clearR1C2();
            clearR1C4();
            clearR2C1();
            clearR2C2();
            clearR3C1();
            clearR3C2();
            clearR4C1();
            clearR5C1();
            clearR6C1();
            clearR7C1();
            this.f15970u = -1;
            return this;
        }

        public BtableTemplate clearR1C1() {
            this.f15950a = false;
            this.f15951b = null;
            return this;
        }

        public BtableTemplate clearR1C2() {
            this.f15952c = false;
            this.f15953d = null;
            return this;
        }

        public BtableTemplate clearR1C4() {
            this.f15954e = Collections.emptyList();
            return this;
        }

        public BtableTemplate clearR2C1() {
            this.f15955f = false;
            this.f15956g = null;
            return this;
        }

        public BtableTemplate clearR2C2() {
            this.f15957h = false;
            this.f15958i = null;
            return this;
        }

        public BtableTemplate clearR3C1() {
            this.f15959j = false;
            this.f15960k = null;
            return this;
        }

        public BtableTemplate clearR3C2() {
            this.f15961l = false;
            this.f15962m = null;
            return this;
        }

        public BtableTemplate clearR4C1() {
            this.f15963n = Collections.emptyList();
            return this;
        }

        public BtableTemplate clearR5C1() {
            this.f15964o = false;
            this.f15965p = null;
            return this;
        }

        public BtableTemplate clearR6C1() {
            this.f15966q = false;
            this.f15967r = null;
            return this;
        }

        public BtableTemplate clearR7C1() {
            this.f15968s = false;
            this.f15969t = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15970u < 0) {
                getSerializedSize();
            }
            return this.f15970u;
        }

        public RichText getR1C1() {
            return this.f15951b;
        }

        public RichText getR1C2() {
            return this.f15953d;
        }

        public Button getR1C4(int i) {
            return (Button) this.f15954e.get(i);
        }

        public int getR1C4Count() {
            return this.f15954e.size();
        }

        public List<Button> getR1C4List() {
            return this.f15954e;
        }

        public Score getR2C1() {
            return this.f15956g;
        }

        public RichText getR2C2() {
            return this.f15958i;
        }

        public RichText getR3C1() {
            return this.f15960k;
        }

        public RichText getR3C2() {
            return this.f15962m;
        }

        public RichText getR4C1(int i) {
            return (RichText) this.f15963n.get(i);
        }

        public int getR4C1Count() {
            return this.f15963n.size();
        }

        public List<RichText> getR4C1List() {
            return this.f15963n;
        }

        public ComboBox getR5C1() {
            return this.f15965p;
        }

        public Fatherson getR6C1() {
            return this.f15967r;
        }

        public Composit getR7C1() {
            return this.f15969t;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasR1C1()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getR1C1());
            }
            if (hasR1C2()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getR1C2());
            }
            int i2 = i;
            for (Button computeMessageSize : getR1C4List()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
            }
            if (hasR2C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(4, getR2C1());
            }
            if (hasR2C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getR2C2());
            }
            if (hasR3C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, getR3C1());
            }
            if (hasR3C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getR3C2());
            }
            for (RichText computeMessageSize2 : getR4C1List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize2);
            }
            if (hasR5C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, getR5C1());
            }
            if (hasR6C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, getR6C1());
            }
            if (hasR7C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(11, getR7C1());
            }
            this.f15970u = i2;
            return i2;
        }

        public boolean hasR1C1() {
            return this.f15950a;
        }

        public boolean hasR1C2() {
            return this.f15952c;
        }

        public boolean hasR2C1() {
            return this.f15955f;
        }

        public boolean hasR2C2() {
            return this.f15957h;
        }

        public boolean hasR3C1() {
            return this.f15959j;
        }

        public boolean hasR3C2() {
            return this.f15961l;
        }

        public boolean hasR5C1() {
            return this.f15964o;
        }

        public boolean hasR6C1() {
            return this.f15966q;
        }

        public boolean hasR7C1() {
            return this.f15968s;
        }

        public final boolean isInitialized() {
            return true;
        }

        public BtableTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro richText;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setR1C1(richText);
                        continue;
                    case 18:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setR1C2(richText);
                        continue;
                    case 26:
                        richText = new Button();
                        codedInputStreamMicro.readMessage(richText);
                        addR1C4(richText);
                        continue;
                    case 34:
                        richText = new Score();
                        codedInputStreamMicro.readMessage(richText);
                        setR2C1(richText);
                        continue;
                    case 42:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setR2C2(richText);
                        continue;
                    case 50:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setR3C1(richText);
                        continue;
                    case 58:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setR3C2(richText);
                        continue;
                    case 66:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        addR4C1(richText);
                        continue;
                    case 74:
                        richText = new ComboBox();
                        codedInputStreamMicro.readMessage(richText);
                        setR5C1(richText);
                        continue;
                    case 82:
                        richText = new Fatherson();
                        codedInputStreamMicro.readMessage(richText);
                        setR6C1(richText);
                        continue;
                    case 90:
                        richText = new Composit();
                        codedInputStreamMicro.readMessage(richText);
                        setR7C1(richText);
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

        public BtableTemplate setR1C1(RichText richText) {
            if (richText == null) {
                return clearR1C1();
            }
            this.f15950a = true;
            this.f15951b = richText;
            return this;
        }

        public BtableTemplate setR1C2(RichText richText) {
            if (richText == null) {
                return clearR1C2();
            }
            this.f15952c = true;
            this.f15953d = richText;
            return this;
        }

        public BtableTemplate setR1C4(int i, Button button) {
            if (button != null) {
                this.f15954e.set(i, button);
            }
            return this;
        }

        public BtableTemplate setR2C1(Score score) {
            if (score == null) {
                return clearR2C1();
            }
            this.f15955f = true;
            this.f15956g = score;
            return this;
        }

        public BtableTemplate setR2C2(RichText richText) {
            if (richText == null) {
                return clearR2C2();
            }
            this.f15957h = true;
            this.f15958i = richText;
            return this;
        }

        public BtableTemplate setR3C1(RichText richText) {
            if (richText == null) {
                return clearR3C1();
            }
            this.f15959j = true;
            this.f15960k = richText;
            return this;
        }

        public BtableTemplate setR3C2(RichText richText) {
            if (richText == null) {
                return clearR3C2();
            }
            this.f15961l = true;
            this.f15962m = richText;
            return this;
        }

        public BtableTemplate setR4C1(int i, RichText richText) {
            if (richText != null) {
                this.f15963n.set(i, richText);
            }
            return this;
        }

        public BtableTemplate setR5C1(ComboBox comboBox) {
            if (comboBox == null) {
                return clearR5C1();
            }
            this.f15964o = true;
            this.f15965p = comboBox;
            return this;
        }

        public BtableTemplate setR6C1(Fatherson fatherson) {
            if (fatherson == null) {
                return clearR6C1();
            }
            this.f15966q = true;
            this.f15967r = fatherson;
            return this;
        }

        public BtableTemplate setR7C1(Composit composit) {
            if (composit == null) {
                return clearR7C1();
            }
            this.f15968s = true;
            this.f15969t = composit;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasR1C1()) {
                codedOutputStreamMicro.writeMessage(1, getR1C1());
            }
            if (hasR1C2()) {
                codedOutputStreamMicro.writeMessage(2, getR1C2());
            }
            for (Button writeMessage : getR1C4List()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
            if (hasR2C1()) {
                codedOutputStreamMicro.writeMessage(4, getR2C1());
            }
            if (hasR2C2()) {
                codedOutputStreamMicro.writeMessage(5, getR2C2());
            }
            if (hasR3C1()) {
                codedOutputStreamMicro.writeMessage(6, getR3C1());
            }
            if (hasR3C2()) {
                codedOutputStreamMicro.writeMessage(7, getR3C2());
            }
            for (RichText writeMessage2 : getR4C1List()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage2);
            }
            if (hasR5C1()) {
                codedOutputStreamMicro.writeMessage(9, getR5C1());
            }
            if (hasR6C1()) {
                codedOutputStreamMicro.writeMessage(10, getR6C1());
            }
            if (hasR7C1()) {
                codedOutputStreamMicro.writeMessage(11, getR7C1());
            }
        }
    }

    public static final class Button extends MessageMicro {
        public static final int ACTION_ID_FIELD_NUMBER = 3;
        public static final int ACTION_OPENAPI_FIELD_NUMBER = 4;
        public static final int ICON_ID_FIELD_NUMBER = 1;
        public static final int ICON_URL_FIELD_NUMBER = 2;
        public static final int TEXT_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f15971a;
        /* renamed from: b */
        private int f15972b = 0;
        /* renamed from: c */
        private boolean f15973c;
        /* renamed from: d */
        private String f15974d = "";
        /* renamed from: e */
        private boolean f15975e;
        /* renamed from: f */
        private int f15976f = 0;
        /* renamed from: g */
        private boolean f15977g;
        /* renamed from: h */
        private String f15978h = "";
        /* renamed from: i */
        private boolean f15979i;
        /* renamed from: j */
        private RichText f15980j = null;
        /* renamed from: k */
        private int f15981k = -1;

        public static Button parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Button().mergeFrom(codedInputStreamMicro);
        }

        public static Button parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Button) new Button().mergeFrom(bArr);
        }

        public final Button clear() {
            clearIconId();
            clearIconUrl();
            clearActionId();
            clearActionOpenapi();
            clearText();
            this.f15981k = -1;
            return this;
        }

        public Button clearActionId() {
            this.f15975e = false;
            this.f15976f = 0;
            return this;
        }

        public Button clearActionOpenapi() {
            this.f15977g = false;
            this.f15978h = "";
            return this;
        }

        public Button clearIconId() {
            this.f15971a = false;
            this.f15972b = 0;
            return this;
        }

        public Button clearIconUrl() {
            this.f15973c = false;
            this.f15974d = "";
            return this;
        }

        public Button clearText() {
            this.f15979i = false;
            this.f15980j = null;
            return this;
        }

        public int getActionId() {
            return this.f15976f;
        }

        public String getActionOpenapi() {
            return this.f15978h;
        }

        public int getCachedSize() {
            if (this.f15981k < 0) {
                getSerializedSize();
            }
            return this.f15981k;
        }

        public int getIconId() {
            return this.f15972b;
        }

        public String getIconUrl() {
            return this.f15974d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIconId()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIconId());
            }
            if (hasIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getIconUrl());
            }
            if (hasActionId()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getActionId());
            }
            if (hasActionOpenapi()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getActionOpenapi());
            }
            if (hasText()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, getText());
            }
            this.f15981k = i;
            return i;
        }

        public RichText getText() {
            return this.f15980j;
        }

        public boolean hasActionId() {
            return this.f15975e;
        }

        public boolean hasActionOpenapi() {
            return this.f15977g;
        }

        public boolean hasIconId() {
            return this.f15971a;
        }

        public boolean hasIconUrl() {
            return this.f15973c;
        }

        public boolean hasText() {
            return this.f15979i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Button mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIconId(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setActionId(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        setActionOpenapi(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        MessageMicro richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setText(richText);
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

        public Button setActionId(int i) {
            this.f15975e = true;
            this.f15976f = i;
            return this;
        }

        public Button setActionOpenapi(String str) {
            this.f15977g = true;
            this.f15978h = str;
            return this;
        }

        public Button setIconId(int i) {
            this.f15971a = true;
            this.f15972b = i;
            return this;
        }

        public Button setIconUrl(String str) {
            this.f15973c = true;
            this.f15974d = str;
            return this;
        }

        public Button setText(RichText richText) {
            if (richText == null) {
                return clearText();
            }
            this.f15979i = true;
            this.f15980j = richText;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIconId()) {
                codedOutputStreamMicro.writeInt32(1, getIconId());
            }
            if (hasIconUrl()) {
                codedOutputStreamMicro.writeString(2, getIconUrl());
            }
            if (hasActionId()) {
                codedOutputStreamMicro.writeInt32(3, getActionId());
            }
            if (hasActionOpenapi()) {
                codedOutputStreamMicro.writeString(4, getActionOpenapi());
            }
            if (hasText()) {
                codedOutputStreamMicro.writeMessage(5, getText());
            }
        }
    }

    public static final class ChildrenBtn extends MessageMicro {
        public static final int TITLE_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15982a;
        /* renamed from: b */
        private String f15983b = "";
        /* renamed from: c */
        private boolean f15984c;
        /* renamed from: d */
        private String f15985d = "";
        /* renamed from: e */
        private int f15986e = -1;

        public static ChildrenBtn parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ChildrenBtn().mergeFrom(codedInputStreamMicro);
        }

        public static ChildrenBtn parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ChildrenBtn) new ChildrenBtn().mergeFrom(bArr);
        }

        public final ChildrenBtn clear() {
            clearUid();
            clearTitle();
            this.f15986e = -1;
            return this;
        }

        public ChildrenBtn clearTitle() {
            this.f15984c = false;
            this.f15985d = "";
            return this;
        }

        public ChildrenBtn clearUid() {
            this.f15982a = false;
            this.f15983b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15986e < 0) {
                getSerializedSize();
            }
            return this.f15986e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasUid()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            this.f15986e = i;
            return i;
        }

        public String getTitle() {
            return this.f15985d;
        }

        public String getUid() {
            return this.f15983b;
        }

        public boolean hasTitle() {
            return this.f15984c;
        }

        public boolean hasUid() {
            return this.f15982a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ChildrenBtn mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
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

        public ChildrenBtn setTitle(String str) {
            this.f15984c = true;
            this.f15985d = str;
            return this;
        }

        public ChildrenBtn setUid(String str) {
            this.f15982a = true;
            this.f15983b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasUid()) {
                codedOutputStreamMicro.writeString(1, getUid());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
        }
    }

    public static final class ComboBox extends MessageMicro {
        public static final int ICON_ID_FIELD_NUMBER = 2;
        public static final int ICON_URL_FIELD_NUMBER = 3;
        public static final int TEXT_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15987a;
        /* renamed from: b */
        private RichText f15988b = null;
        /* renamed from: c */
        private boolean f15989c;
        /* renamed from: d */
        private int f15990d = 0;
        /* renamed from: e */
        private boolean f15991e;
        /* renamed from: f */
        private String f15992f = "";
        /* renamed from: g */
        private int f15993g = -1;

        public static ComboBox parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ComboBox().mergeFrom(codedInputStreamMicro);
        }

        public static ComboBox parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ComboBox) new ComboBox().mergeFrom(bArr);
        }

        public final ComboBox clear() {
            clearText();
            clearIconId();
            clearIconUrl();
            this.f15993g = -1;
            return this;
        }

        public ComboBox clearIconId() {
            this.f15989c = false;
            this.f15990d = 0;
            return this;
        }

        public ComboBox clearIconUrl() {
            this.f15991e = false;
            this.f15992f = "";
            return this;
        }

        public ComboBox clearText() {
            this.f15987a = false;
            this.f15988b = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15993g < 0) {
                getSerializedSize();
            }
            return this.f15993g;
        }

        public int getIconId() {
            return this.f15990d;
        }

        public String getIconUrl() {
            return this.f15992f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasText()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getText());
            }
            if (hasIconId()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getIconId());
            }
            if (hasIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getIconUrl());
            }
            this.f15993g = i;
            return i;
        }

        public RichText getText() {
            return this.f15988b;
        }

        public boolean hasIconId() {
            return this.f15989c;
        }

        public boolean hasIconUrl() {
            return this.f15991e;
        }

        public boolean hasText() {
            return this.f15987a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ComboBox mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setText(richText);
                        continue;
                    case 16:
                        setIconId(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setIconUrl(codedInputStreamMicro.readString());
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

        public ComboBox setIconId(int i) {
            this.f15989c = true;
            this.f15990d = i;
            return this;
        }

        public ComboBox setIconUrl(String str) {
            this.f15991e = true;
            this.f15992f = str;
            return this;
        }

        public ComboBox setText(RichText richText) {
            if (richText == null) {
                return clearText();
            }
            this.f15987a = true;
            this.f15988b = richText;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasText()) {
                codedOutputStreamMicro.writeMessage(1, getText());
            }
            if (hasIconId()) {
                codedOutputStreamMicro.writeInt32(2, getIconId());
            }
            if (hasIconUrl()) {
                codedOutputStreamMicro.writeString(3, getIconUrl());
            }
        }
    }

    public static final class Composit extends MessageMicro {
        public static final int ICON_ID_FIELD_NUMBER = 1;
        public static final int TAB_ID_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 2;
        public static final int VALUE_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f15994a;
        /* renamed from: b */
        private int f15995b = 0;
        /* renamed from: c */
        private boolean f15996c;
        /* renamed from: d */
        private String f15997d = "";
        /* renamed from: e */
        private boolean f15998e;
        /* renamed from: f */
        private int f15999f = 0;
        /* renamed from: g */
        private List<String> f16000g = Collections.emptyList();
        /* renamed from: h */
        private int f16001h = -1;

        public static Composit parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Composit().mergeFrom(codedInputStreamMicro);
        }

        public static Composit parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Composit) new Composit().mergeFrom(bArr);
        }

        public Composit addValue(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f16000g.isEmpty()) {
                this.f16000g = new ArrayList();
            }
            this.f16000g.add(str);
            return this;
        }

        public final Composit clear() {
            clearIconId();
            clearTitle();
            clearTabId();
            clearValue();
            this.f16001h = -1;
            return this;
        }

        public Composit clearIconId() {
            this.f15994a = false;
            this.f15995b = 0;
            return this;
        }

        public Composit clearTabId() {
            this.f15998e = false;
            this.f15999f = 0;
            return this;
        }

        public Composit clearTitle() {
            this.f15996c = false;
            this.f15997d = "";
            return this;
        }

        public Composit clearValue() {
            this.f16000g = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f16001h < 0) {
                getSerializedSize();
            }
            return this.f16001h;
        }

        public int getIconId() {
            return this.f15995b;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasIconId() ? CodedOutputStreamMicro.computeInt32Size(1, getIconId()) + 0 : 0;
            if (hasTitle()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            int computeInt32Size2 = hasTabId() ? computeInt32Size + CodedOutputStreamMicro.computeInt32Size(3, getTabId()) : computeInt32Size;
            for (String computeStringSizeNoTag : getValueList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeInt32Size = (computeInt32Size2 + i) + (getValueList().size() * 1);
            this.f16001h = computeInt32Size;
            return computeInt32Size;
        }

        public int getTabId() {
            return this.f15999f;
        }

        public String getTitle() {
            return this.f15997d;
        }

        public String getValue(int i) {
            return (String) this.f16000g.get(i);
        }

        public int getValueCount() {
            return this.f16000g.size();
        }

        public List<String> getValueList() {
            return this.f16000g;
        }

        public boolean hasIconId() {
            return this.f15994a;
        }

        public boolean hasTabId() {
            return this.f15998e;
        }

        public boolean hasTitle() {
            return this.f15996c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Composit mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIconId(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setTabId(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        addValue(codedInputStreamMicro.readString());
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

        public Composit setIconId(int i) {
            this.f15994a = true;
            this.f15995b = i;
            return this;
        }

        public Composit setTabId(int i) {
            this.f15998e = true;
            this.f15999f = i;
            return this;
        }

        public Composit setTitle(String str) {
            this.f15996c = true;
            this.f15997d = str;
            return this;
        }

        public Composit setValue(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f16000g.set(i, str);
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIconId()) {
                codedOutputStreamMicro.writeInt32(1, getIconId());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasTabId()) {
                codedOutputStreamMicro.writeInt32(3, getTabId());
            }
            for (String writeString : getValueList()) {
                codedOutputStreamMicro.writeString(4, writeString);
            }
        }
    }

    public static final class Fatherson extends MessageMicro {
        public static final int ACT_FIELD_NUMBER = 1;
        public static final int CHILDREN_BTN_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16002a;
        /* renamed from: b */
        private int f16003b = 0;
        /* renamed from: c */
        private boolean f16004c;
        /* renamed from: d */
        private String f16005d = "";
        /* renamed from: e */
        private List<ChildrenBtn> f16006e = Collections.emptyList();
        /* renamed from: f */
        private int f16007f = -1;

        public static Fatherson parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Fatherson().mergeFrom(codedInputStreamMicro);
        }

        public static Fatherson parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Fatherson) new Fatherson().mergeFrom(bArr);
        }

        public Fatherson addChildrenBtn(ChildrenBtn childrenBtn) {
            if (childrenBtn != null) {
                if (this.f16006e.isEmpty()) {
                    this.f16006e = new ArrayList();
                }
                this.f16006e.add(childrenBtn);
            }
            return this;
        }

        public final Fatherson clear() {
            clearAct();
            clearTitle();
            clearChildrenBtn();
            this.f16007f = -1;
            return this;
        }

        public Fatherson clearAct() {
            this.f16002a = false;
            this.f16003b = 0;
            return this;
        }

        public Fatherson clearChildrenBtn() {
            this.f16006e = Collections.emptyList();
            return this;
        }

        public Fatherson clearTitle() {
            this.f16004c = false;
            this.f16005d = "";
            return this;
        }

        public int getAct() {
            return this.f16003b;
        }

        public int getCachedSize() {
            if (this.f16007f < 0) {
                getSerializedSize();
            }
            return this.f16007f;
        }

        public ChildrenBtn getChildrenBtn(int i) {
            return (ChildrenBtn) this.f16006e.get(i);
        }

        public int getChildrenBtnCount() {
            return this.f16006e.size();
        }

        public List<ChildrenBtn> getChildrenBtnList() {
            return this.f16006e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAct()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getAct());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            int i2 = i;
            for (ChildrenBtn computeMessageSize : getChildrenBtnList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
            }
            this.f16007f = i2;
            return i2;
        }

        public String getTitle() {
            return this.f16005d;
        }

        public boolean hasAct() {
            return this.f16002a;
        }

        public boolean hasTitle() {
            return this.f16004c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Fatherson mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setAct(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        MessageMicro childrenBtn = new ChildrenBtn();
                        codedInputStreamMicro.readMessage(childrenBtn);
                        addChildrenBtn(childrenBtn);
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

        public Fatherson setAct(int i) {
            this.f16002a = true;
            this.f16003b = i;
            return this;
        }

        public Fatherson setChildrenBtn(int i, ChildrenBtn childrenBtn) {
            if (childrenBtn != null) {
                this.f16006e.set(i, childrenBtn);
            }
            return this;
        }

        public Fatherson setTitle(String str) {
            this.f16004c = true;
            this.f16005d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAct()) {
                codedOutputStreamMicro.writeInt32(1, getAct());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            for (ChildrenBtn writeMessage : getChildrenBtnList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
        }
    }

    public static final class Image extends MessageMicro {
        public static final int ICON_ID_FIELD_NUMBER = 3;
        public static final int LINK_FIELD_NUMBER = 2;
        public static final int ORI_VALUE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16008a;
        /* renamed from: b */
        private int f16009b = 0;
        /* renamed from: c */
        private boolean f16010c;
        /* renamed from: d */
        private String f16011d = "";
        /* renamed from: e */
        private boolean f16012e;
        /* renamed from: f */
        private int f16013f = 0;
        /* renamed from: g */
        private int f16014g = -1;

        public static Image parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Image().mergeFrom(codedInputStreamMicro);
        }

        public static Image parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Image) new Image().mergeFrom(bArr);
        }

        public final Image clear() {
            clearOriValue();
            clearLink();
            clearIconId();
            this.f16014g = -1;
            return this;
        }

        public Image clearIconId() {
            this.f16012e = false;
            this.f16013f = 0;
            return this;
        }

        public Image clearLink() {
            this.f16010c = false;
            this.f16011d = "";
            return this;
        }

        public Image clearOriValue() {
            this.f16008a = false;
            this.f16009b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f16014g < 0) {
                getSerializedSize();
            }
            return this.f16014g;
        }

        public int getIconId() {
            return this.f16013f;
        }

        public String getLink() {
            return this.f16011d;
        }

        public int getOriValue() {
            return this.f16009b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasOriValue()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getOriValue());
            }
            if (hasLink()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getLink());
            }
            if (hasIconId()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getIconId());
            }
            this.f16014g = i;
            return i;
        }

        public boolean hasIconId() {
            return this.f16012e;
        }

        public boolean hasLink() {
            return this.f16010c;
        }

        public boolean hasOriValue() {
            return this.f16008a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Image mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setOriValue(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setLink(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setIconId(codedInputStreamMicro.readInt32());
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

        public Image setIconId(int i) {
            this.f16012e = true;
            this.f16013f = i;
            return this;
        }

        public Image setLink(String str) {
            this.f16010c = true;
            this.f16011d = str;
            return this;
        }

        public Image setOriValue(int i) {
            this.f16008a = true;
            this.f16009b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasOriValue()) {
                codedOutputStreamMicro.writeInt32(1, getOriValue());
            }
            if (hasLink()) {
                codedOutputStreamMicro.writeString(2, getLink());
            }
            if (hasIconId()) {
                codedOutputStreamMicro.writeInt32(3, getIconId());
            }
        }
    }

    public static final class ImageTemplate extends MessageMicro {
        public static final int FAIMAGEL5_FIELD_NUMBER = 13;
        public static final int IMAGEL1C1_FIELD_NUMBER = 1;
        public static final int IMAGEL1C2_FIELD_NUMBER = 2;
        public static final int IMAGEL1C3_FIELD_NUMBER = 3;
        public static final int IMAGEL2C1_FIELD_NUMBER = 4;
        public static final int IMAGEL2C2_FIELD_NUMBER = 5;
        public static final int IMAGEL2C3_FIELD_NUMBER = 6;
        public static final int IMAGEL3C1_FIELD_NUMBER = 7;
        public static final int IMAGEL3C2_FIELD_NUMBER = 8;
        public static final int IMAGEL4LAB_FIELD_NUMBER = 14;
        public static final int IMAGEL4_FIELD_NUMBER = 9;
        public static final int IMAGEL5_FIELD_NUMBER = 10;
        public static final int IMAGEL6_FIELD_NUMBER = 11;
        public static final int UPPERLEFTCORNER_FIELD_NUMBER = 12;
        /* renamed from: A */
        private int f16015A = -1;
        /* renamed from: a */
        private boolean f16016a;
        /* renamed from: b */
        private Image f16017b = null;
        /* renamed from: c */
        private boolean f16018c;
        /* renamed from: d */
        private RichText f16019d = null;
        /* renamed from: e */
        private List<Resource> f16020e = Collections.emptyList();
        /* renamed from: f */
        private boolean f16021f;
        /* renamed from: g */
        private String f16022g = "";
        /* renamed from: h */
        private boolean f16023h;
        /* renamed from: i */
        private RichText f16024i = null;
        /* renamed from: j */
        private boolean f16025j;
        /* renamed from: k */
        private RichText f16026k = null;
        /* renamed from: l */
        private boolean f16027l;
        /* renamed from: m */
        private RichText f16028m = null;
        /* renamed from: n */
        private boolean f16029n;
        /* renamed from: o */
        private RichText f16030o = null;
        /* renamed from: p */
        private boolean f16031p;
        /* renamed from: q */
        private RichText f16032q = null;
        /* renamed from: r */
        private boolean f16033r;
        /* renamed from: s */
        private int f16034s = 0;
        /* renamed from: t */
        private boolean f16035t;
        /* renamed from: u */
        private Composit f16036u = null;
        /* renamed from: v */
        private boolean f16037v;
        /* renamed from: w */
        private Resource f16038w = null;
        /* renamed from: x */
        private boolean f16039x;
        /* renamed from: y */
        private Fatherson f16040y = null;
        /* renamed from: z */
        private List<String> f16041z = Collections.emptyList();

        public static ImageTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ImageTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static ImageTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ImageTemplate) new ImageTemplate().mergeFrom(bArr);
        }

        public ImageTemplate addImagel1C3(Resource resource) {
            if (resource != null) {
                if (this.f16020e.isEmpty()) {
                    this.f16020e = new ArrayList();
                }
                this.f16020e.add(resource);
            }
            return this;
        }

        public ImageTemplate addImagel4Lab(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f16041z.isEmpty()) {
                this.f16041z = new ArrayList();
            }
            this.f16041z.add(str);
            return this;
        }

        public final ImageTemplate clear() {
            clearImagel1C1();
            clearImagel1C2();
            clearImagel1C3();
            clearImagel2C1();
            clearImagel2C2();
            clearImagel2C3();
            clearImagel3C1();
            clearImagel3C2();
            clearImagel4();
            clearImagel5();
            clearImagel6();
            clearUpperleftcorner();
            clearFaimagel5();
            clearImagel4Lab();
            this.f16015A = -1;
            return this;
        }

        public ImageTemplate clearFaimagel5() {
            this.f16039x = false;
            this.f16040y = null;
            return this;
        }

        public ImageTemplate clearImagel1C1() {
            this.f16016a = false;
            this.f16017b = null;
            return this;
        }

        public ImageTemplate clearImagel1C2() {
            this.f16018c = false;
            this.f16019d = null;
            return this;
        }

        public ImageTemplate clearImagel1C3() {
            this.f16020e = Collections.emptyList();
            return this;
        }

        public ImageTemplate clearImagel2C1() {
            this.f16021f = false;
            this.f16022g = "";
            return this;
        }

        public ImageTemplate clearImagel2C2() {
            this.f16023h = false;
            this.f16024i = null;
            return this;
        }

        public ImageTemplate clearImagel2C3() {
            this.f16025j = false;
            this.f16026k = null;
            return this;
        }

        public ImageTemplate clearImagel3C1() {
            this.f16027l = false;
            this.f16028m = null;
            return this;
        }

        public ImageTemplate clearImagel3C2() {
            this.f16029n = false;
            this.f16030o = null;
            return this;
        }

        public ImageTemplate clearImagel4() {
            this.f16031p = false;
            this.f16032q = null;
            return this;
        }

        public ImageTemplate clearImagel4Lab() {
            this.f16041z = Collections.emptyList();
            return this;
        }

        public ImageTemplate clearImagel5() {
            this.f16033r = false;
            this.f16034s = 0;
            return this;
        }

        public ImageTemplate clearImagel6() {
            this.f16035t = false;
            this.f16036u = null;
            return this;
        }

        public ImageTemplate clearUpperleftcorner() {
            this.f16037v = false;
            this.f16038w = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f16015A < 0) {
                getSerializedSize();
            }
            return this.f16015A;
        }

        public Fatherson getFaimagel5() {
            return this.f16040y;
        }

        public Image getImagel1C1() {
            return this.f16017b;
        }

        public RichText getImagel1C2() {
            return this.f16019d;
        }

        public Resource getImagel1C3(int i) {
            return (Resource) this.f16020e.get(i);
        }

        public int getImagel1C3Count() {
            return this.f16020e.size();
        }

        public List<Resource> getImagel1C3List() {
            return this.f16020e;
        }

        public String getImagel2C1() {
            return this.f16022g;
        }

        public RichText getImagel2C2() {
            return this.f16024i;
        }

        public RichText getImagel2C3() {
            return this.f16026k;
        }

        public RichText getImagel3C1() {
            return this.f16028m;
        }

        public RichText getImagel3C2() {
            return this.f16030o;
        }

        public RichText getImagel4() {
            return this.f16032q;
        }

        public String getImagel4Lab(int i) {
            return (String) this.f16041z.get(i);
        }

        public int getImagel4LabCount() {
            return this.f16041z.size();
        }

        public List<String> getImagel4LabList() {
            return this.f16041z;
        }

        public int getImagel5() {
            return this.f16034s;
        }

        public Composit getImagel6() {
            return this.f16036u;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeMessageSize = hasImagel1C1() ? CodedOutputStreamMicro.computeMessageSize(1, getImagel1C1()) + 0 : 0;
            if (hasImagel1C2()) {
                computeMessageSize += CodedOutputStreamMicro.computeMessageSize(2, getImagel1C2());
            }
            int i2 = computeMessageSize;
            for (Resource computeMessageSize2 : getImagel1C3List()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize2) + i2;
            }
            if (hasImagel2C1()) {
                i2 += CodedOutputStreamMicro.computeStringSize(4, getImagel2C1());
            }
            if (hasImagel2C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getImagel2C2());
            }
            if (hasImagel2C3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, getImagel2C3());
            }
            if (hasImagel3C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getImagel3C1());
            }
            if (hasImagel3C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, getImagel3C2());
            }
            if (hasImagel4()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, getImagel4());
            }
            if (hasImagel5()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(10, getImagel5());
            }
            if (hasImagel6()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(11, getImagel6());
            }
            if (hasUpperleftcorner()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(12, getUpperleftcorner());
            }
            if (hasFaimagel5()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(13, getFaimagel5());
            }
            for (String computeStringSizeNoTag : getImagel4LabList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeMessageSize = (i2 + i) + (getImagel4LabList().size() * 1);
            this.f16015A = computeMessageSize;
            return computeMessageSize;
        }

        public Resource getUpperleftcorner() {
            return this.f16038w;
        }

        public boolean hasFaimagel5() {
            return this.f16039x;
        }

        public boolean hasImagel1C1() {
            return this.f16016a;
        }

        public boolean hasImagel1C2() {
            return this.f16018c;
        }

        public boolean hasImagel2C1() {
            return this.f16021f;
        }

        public boolean hasImagel2C2() {
            return this.f16023h;
        }

        public boolean hasImagel2C3() {
            return this.f16025j;
        }

        public boolean hasImagel3C1() {
            return this.f16027l;
        }

        public boolean hasImagel3C2() {
            return this.f16029n;
        }

        public boolean hasImagel4() {
            return this.f16031p;
        }

        public boolean hasImagel5() {
            return this.f16033r;
        }

        public boolean hasImagel6() {
            return this.f16035t;
        }

        public boolean hasUpperleftcorner() {
            return this.f16037v;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ImageTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro image;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        image = new Image();
                        codedInputStreamMicro.readMessage(image);
                        setImagel1C1(image);
                        continue;
                    case 18:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setImagel1C2(image);
                        continue;
                    case 26:
                        image = new Resource();
                        codedInputStreamMicro.readMessage(image);
                        addImagel1C3(image);
                        continue;
                    case 34:
                        setImagel2C1(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setImagel2C2(image);
                        continue;
                    case 50:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setImagel2C3(image);
                        continue;
                    case 58:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setImagel3C1(image);
                        continue;
                    case 66:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setImagel3C2(image);
                        continue;
                    case 74:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setImagel4(image);
                        continue;
                    case 80:
                        setImagel5(codedInputStreamMicro.readInt32());
                        continue;
                    case 90:
                        image = new Composit();
                        codedInputStreamMicro.readMessage(image);
                        setImagel6(image);
                        continue;
                    case 98:
                        image = new Resource();
                        codedInputStreamMicro.readMessage(image);
                        setUpperleftcorner(image);
                        continue;
                    case 106:
                        image = new Fatherson();
                        codedInputStreamMicro.readMessage(image);
                        setFaimagel5(image);
                        continue;
                    case 114:
                        addImagel4Lab(codedInputStreamMicro.readString());
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

        public ImageTemplate setFaimagel5(Fatherson fatherson) {
            if (fatherson == null) {
                return clearFaimagel5();
            }
            this.f16039x = true;
            this.f16040y = fatherson;
            return this;
        }

        public ImageTemplate setImagel1C1(Image image) {
            if (image == null) {
                return clearImagel1C1();
            }
            this.f16016a = true;
            this.f16017b = image;
            return this;
        }

        public ImageTemplate setImagel1C2(RichText richText) {
            if (richText == null) {
                return clearImagel1C2();
            }
            this.f16018c = true;
            this.f16019d = richText;
            return this;
        }

        public ImageTemplate setImagel1C3(int i, Resource resource) {
            if (resource != null) {
                this.f16020e.set(i, resource);
            }
            return this;
        }

        public ImageTemplate setImagel2C1(String str) {
            this.f16021f = true;
            this.f16022g = str;
            return this;
        }

        public ImageTemplate setImagel2C2(RichText richText) {
            if (richText == null) {
                return clearImagel2C2();
            }
            this.f16023h = true;
            this.f16024i = richText;
            return this;
        }

        public ImageTemplate setImagel2C3(RichText richText) {
            if (richText == null) {
                return clearImagel2C3();
            }
            this.f16025j = true;
            this.f16026k = richText;
            return this;
        }

        public ImageTemplate setImagel3C1(RichText richText) {
            if (richText == null) {
                return clearImagel3C1();
            }
            this.f16027l = true;
            this.f16028m = richText;
            return this;
        }

        public ImageTemplate setImagel3C2(RichText richText) {
            if (richText == null) {
                return clearImagel3C2();
            }
            this.f16029n = true;
            this.f16030o = richText;
            return this;
        }

        public ImageTemplate setImagel4(RichText richText) {
            if (richText == null) {
                return clearImagel4();
            }
            this.f16031p = true;
            this.f16032q = richText;
            return this;
        }

        public ImageTemplate setImagel4Lab(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f16041z.set(i, str);
            return this;
        }

        public ImageTemplate setImagel5(int i) {
            this.f16033r = true;
            this.f16034s = i;
            return this;
        }

        public ImageTemplate setImagel6(Composit composit) {
            if (composit == null) {
                return clearImagel6();
            }
            this.f16035t = true;
            this.f16036u = composit;
            return this;
        }

        public ImageTemplate setUpperleftcorner(Resource resource) {
            if (resource == null) {
                return clearUpperleftcorner();
            }
            this.f16037v = true;
            this.f16038w = resource;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasImagel1C1()) {
                codedOutputStreamMicro.writeMessage(1, getImagel1C1());
            }
            if (hasImagel1C2()) {
                codedOutputStreamMicro.writeMessage(2, getImagel1C2());
            }
            for (Resource writeMessage : getImagel1C3List()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
            if (hasImagel2C1()) {
                codedOutputStreamMicro.writeString(4, getImagel2C1());
            }
            if (hasImagel2C2()) {
                codedOutputStreamMicro.writeMessage(5, getImagel2C2());
            }
            if (hasImagel2C3()) {
                codedOutputStreamMicro.writeMessage(6, getImagel2C3());
            }
            if (hasImagel3C1()) {
                codedOutputStreamMicro.writeMessage(7, getImagel3C1());
            }
            if (hasImagel3C2()) {
                codedOutputStreamMicro.writeMessage(8, getImagel3C2());
            }
            if (hasImagel4()) {
                codedOutputStreamMicro.writeMessage(9, getImagel4());
            }
            if (hasImagel5()) {
                codedOutputStreamMicro.writeInt32(10, getImagel5());
            }
            if (hasImagel6()) {
                codedOutputStreamMicro.writeMessage(11, getImagel6());
            }
            if (hasUpperleftcorner()) {
                codedOutputStreamMicro.writeMessage(12, getUpperleftcorner());
            }
            if (hasFaimagel5()) {
                codedOutputStreamMicro.writeMessage(13, getFaimagel5());
            }
            for (String writeString : getImagel4LabList()) {
                codedOutputStreamMicro.writeString(14, writeString);
            }
        }
    }

    public static final class LtableTemplate extends MessageMicro {
        public static final int BUTTON = 3;
        public static final int INTERNATION_FIELD_NUMBER = 6;
        public static final int LONG_IMAGE = 2;
        public static final int LONG_IMAGE_BUTTON = 4;
        public static final int R1C1_FIELD_NUMBER = 2;
        public static final int R1C2_FIELD_NUMBER = 3;
        public static final int R1C3_FIELD_NUMBER = 4;
        public static final int R1C4_FIELD_NUMBER = 5;
        public static final int R2C1_FIELD_NUMBER = 7;
        public static final int R2C2_FIELD_NUMBER = 8;
        public static final int R3C1_FIELD_NUMBER = 9;
        public static final int R3C2_FIELD_NUMBER = 10;
        public static final int R3C3_FIELD_NUMBER = 11;
        public static final int R4C1_FIELD_NUMBER = 12;
        public static final int R4C2_FIELD_NUMBER = 13;
        public static final int R4C3_FIELD_NUMBER = 14;
        public static final int R5C1_FIELD_NUMBER = 15;
        public static final int R5C2_FIELD_NUMBER = 16;
        public static final int R5C3_FIELD_NUMBER = 17;
        public static final int R6C1_FIELD_NUMBER = 18;
        public static final int R7C1_FIELD_NUMBER = 19;
        public static final int SHORT_IMAGE = 1;
        public static final int TYPE_FIELD_NUMBER = 1;
        /* renamed from: A */
        private boolean f16042A;
        /* renamed from: B */
        private Fatherson f16043B = null;
        /* renamed from: C */
        private boolean f16044C;
        /* renamed from: D */
        private Composit f16045D = null;
        /* renamed from: E */
        private int f16046E = -1;
        /* renamed from: a */
        private boolean f16047a;
        /* renamed from: b */
        private int f16048b = 1;
        /* renamed from: c */
        private boolean f16049c;
        /* renamed from: d */
        private Image f16050d = null;
        /* renamed from: e */
        private boolean f16051e;
        /* renamed from: f */
        private RichText f16052f = null;
        /* renamed from: g */
        private boolean f16053g;
        /* renamed from: h */
        private RichText f16054h = null;
        /* renamed from: i */
        private List<Button> f16055i = Collections.emptyList();
        /* renamed from: j */
        private boolean f16056j;
        /* renamed from: k */
        private RichText f16057k = null;
        /* renamed from: l */
        private boolean f16058l;
        /* renamed from: m */
        private RichText f16059m = null;
        /* renamed from: n */
        private List<ScatterStyle> f16060n = Collections.emptyList();
        /* renamed from: o */
        private boolean f16061o;
        /* renamed from: p */
        private Score f16062p = null;
        /* renamed from: q */
        private List<ComboBox> f16063q = Collections.emptyList();
        /* renamed from: r */
        private List<ScatterStyle> f16064r = Collections.emptyList();
        /* renamed from: s */
        private boolean f16065s;
        /* renamed from: t */
        private Score f16066t = null;
        /* renamed from: u */
        private List<ComboBox> f16067u = Collections.emptyList();
        /* renamed from: v */
        private List<ScatterStyle> f16068v = Collections.emptyList();
        /* renamed from: w */
        private boolean f16069w;
        /* renamed from: x */
        private Score f16070x = null;
        /* renamed from: y */
        private List<ComboBox> f16071y = Collections.emptyList();
        /* renamed from: z */
        private List<ScatterStyle> f16072z = Collections.emptyList();

        public static LtableTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new LtableTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static LtableTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (LtableTemplate) new LtableTemplate().mergeFrom(bArr);
        }

        public LtableTemplate addR1C4(Button button) {
            if (button != null) {
                if (this.f16055i.isEmpty()) {
                    this.f16055i = new ArrayList();
                }
                this.f16055i.add(button);
            }
            return this;
        }

        public LtableTemplate addR2C2(ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                if (this.f16060n.isEmpty()) {
                    this.f16060n = new ArrayList();
                }
                this.f16060n.add(scatterStyle);
            }
            return this;
        }

        public LtableTemplate addR3C2(ComboBox comboBox) {
            if (comboBox != null) {
                if (this.f16063q.isEmpty()) {
                    this.f16063q = new ArrayList();
                }
                this.f16063q.add(comboBox);
            }
            return this;
        }

        public LtableTemplate addR3C3(ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                if (this.f16064r.isEmpty()) {
                    this.f16064r = new ArrayList();
                }
                this.f16064r.add(scatterStyle);
            }
            return this;
        }

        public LtableTemplate addR4C2(ComboBox comboBox) {
            if (comboBox != null) {
                if (this.f16067u.isEmpty()) {
                    this.f16067u = new ArrayList();
                }
                this.f16067u.add(comboBox);
            }
            return this;
        }

        public LtableTemplate addR4C3(ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                if (this.f16068v.isEmpty()) {
                    this.f16068v = new ArrayList();
                }
                this.f16068v.add(scatterStyle);
            }
            return this;
        }

        public LtableTemplate addR5C2(ComboBox comboBox) {
            if (comboBox != null) {
                if (this.f16071y.isEmpty()) {
                    this.f16071y = new ArrayList();
                }
                this.f16071y.add(comboBox);
            }
            return this;
        }

        public LtableTemplate addR5C3(ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                if (this.f16072z.isEmpty()) {
                    this.f16072z = new ArrayList();
                }
                this.f16072z.add(scatterStyle);
            }
            return this;
        }

        public final LtableTemplate clear() {
            clearType();
            clearR1C1();
            clearR1C2();
            clearR1C3();
            clearR1C4();
            clearInternation();
            clearR2C1();
            clearR2C2();
            clearR3C1();
            clearR3C2();
            clearR3C3();
            clearR4C1();
            clearR4C2();
            clearR4C3();
            clearR5C1();
            clearR5C2();
            clearR5C3();
            clearR6C1();
            clearR7C1();
            this.f16046E = -1;
            return this;
        }

        public LtableTemplate clearInternation() {
            this.f16056j = false;
            this.f16057k = null;
            return this;
        }

        public LtableTemplate clearR1C1() {
            this.f16049c = false;
            this.f16050d = null;
            return this;
        }

        public LtableTemplate clearR1C2() {
            this.f16051e = false;
            this.f16052f = null;
            return this;
        }

        public LtableTemplate clearR1C3() {
            this.f16053g = false;
            this.f16054h = null;
            return this;
        }

        public LtableTemplate clearR1C4() {
            this.f16055i = Collections.emptyList();
            return this;
        }

        public LtableTemplate clearR2C1() {
            this.f16058l = false;
            this.f16059m = null;
            return this;
        }

        public LtableTemplate clearR2C2() {
            this.f16060n = Collections.emptyList();
            return this;
        }

        public LtableTemplate clearR3C1() {
            this.f16061o = false;
            this.f16062p = null;
            return this;
        }

        public LtableTemplate clearR3C2() {
            this.f16063q = Collections.emptyList();
            return this;
        }

        public LtableTemplate clearR3C3() {
            this.f16064r = Collections.emptyList();
            return this;
        }

        public LtableTemplate clearR4C1() {
            this.f16065s = false;
            this.f16066t = null;
            return this;
        }

        public LtableTemplate clearR4C2() {
            this.f16067u = Collections.emptyList();
            return this;
        }

        public LtableTemplate clearR4C3() {
            this.f16068v = Collections.emptyList();
            return this;
        }

        public LtableTemplate clearR5C1() {
            this.f16069w = false;
            this.f16070x = null;
            return this;
        }

        public LtableTemplate clearR5C2() {
            this.f16071y = Collections.emptyList();
            return this;
        }

        public LtableTemplate clearR5C3() {
            this.f16072z = Collections.emptyList();
            return this;
        }

        public LtableTemplate clearR6C1() {
            this.f16042A = false;
            this.f16043B = null;
            return this;
        }

        public LtableTemplate clearR7C1() {
            this.f16044C = false;
            this.f16045D = null;
            return this;
        }

        public LtableTemplate clearType() {
            this.f16047a = false;
            this.f16048b = 1;
            return this;
        }

        public int getCachedSize() {
            if (this.f16046E < 0) {
                getSerializedSize();
            }
            return this.f16046E;
        }

        public RichText getInternation() {
            return this.f16057k;
        }

        public Image getR1C1() {
            return this.f16050d;
        }

        public RichText getR1C2() {
            return this.f16052f;
        }

        public RichText getR1C3() {
            return this.f16054h;
        }

        public Button getR1C4(int i) {
            return (Button) this.f16055i.get(i);
        }

        public int getR1C4Count() {
            return this.f16055i.size();
        }

        public List<Button> getR1C4List() {
            return this.f16055i;
        }

        public RichText getR2C1() {
            return this.f16059m;
        }

        public ScatterStyle getR2C2(int i) {
            return (ScatterStyle) this.f16060n.get(i);
        }

        public int getR2C2Count() {
            return this.f16060n.size();
        }

        public List<ScatterStyle> getR2C2List() {
            return this.f16060n;
        }

        public Score getR3C1() {
            return this.f16062p;
        }

        public ComboBox getR3C2(int i) {
            return (ComboBox) this.f16063q.get(i);
        }

        public int getR3C2Count() {
            return this.f16063q.size();
        }

        public List<ComboBox> getR3C2List() {
            return this.f16063q;
        }

        public ScatterStyle getR3C3(int i) {
            return (ScatterStyle) this.f16064r.get(i);
        }

        public int getR3C3Count() {
            return this.f16064r.size();
        }

        public List<ScatterStyle> getR3C3List() {
            return this.f16064r;
        }

        public Score getR4C1() {
            return this.f16066t;
        }

        public ComboBox getR4C2(int i) {
            return (ComboBox) this.f16067u.get(i);
        }

        public int getR4C2Count() {
            return this.f16067u.size();
        }

        public List<ComboBox> getR4C2List() {
            return this.f16067u;
        }

        public ScatterStyle getR4C3(int i) {
            return (ScatterStyle) this.f16068v.get(i);
        }

        public int getR4C3Count() {
            return this.f16068v.size();
        }

        public List<ScatterStyle> getR4C3List() {
            return this.f16068v;
        }

        public Score getR5C1() {
            return this.f16070x;
        }

        public ComboBox getR5C2(int i) {
            return (ComboBox) this.f16071y.get(i);
        }

        public int getR5C2Count() {
            return this.f16071y.size();
        }

        public List<ComboBox> getR5C2List() {
            return this.f16071y;
        }

        public ScatterStyle getR5C3(int i) {
            return (ScatterStyle) this.f16072z.get(i);
        }

        public int getR5C3Count() {
            return this.f16072z.size();
        }

        public List<ScatterStyle> getR5C3List() {
            return this.f16072z;
        }

        public Fatherson getR6C1() {
            return this.f16043B;
        }

        public Composit getR7C1() {
            return this.f16045D;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasType()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
            }
            if (hasR1C1()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getR1C1());
            }
            if (hasR1C2()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getR1C2());
            }
            if (hasR1C3()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getR1C3());
            }
            int i2 = i;
            for (Button computeMessageSize : getR1C4List()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize) + i2;
            }
            if (hasInternation()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, getInternation());
            }
            if (hasR2C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getR2C1());
            }
            for (ScatterStyle computeMessageSize2 : getR2C2List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize2);
            }
            if (hasR3C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, getR3C1());
            }
            for (ComboBox computeMessageSize3 : getR3C2List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, computeMessageSize3);
            }
            for (ScatterStyle computeMessageSize22 : getR3C3List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(11, computeMessageSize22);
            }
            if (hasR4C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(12, getR4C1());
            }
            for (ComboBox computeMessageSize32 : getR4C2List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(13, computeMessageSize32);
            }
            for (ScatterStyle computeMessageSize222 : getR4C3List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(14, computeMessageSize222);
            }
            if (hasR5C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(15, getR5C1());
            }
            for (ComboBox computeMessageSize322 : getR5C2List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(16, computeMessageSize322);
            }
            for (ScatterStyle computeMessageSize2222 : getR5C3List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(17, computeMessageSize2222);
            }
            if (hasR6C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(18, getR6C1());
            }
            if (hasR7C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(19, getR7C1());
            }
            this.f16046E = i2;
            return i2;
        }

        public int getType() {
            return this.f16048b;
        }

        public boolean hasInternation() {
            return this.f16056j;
        }

        public boolean hasR1C1() {
            return this.f16049c;
        }

        public boolean hasR1C2() {
            return this.f16051e;
        }

        public boolean hasR1C3() {
            return this.f16053g;
        }

        public boolean hasR2C1() {
            return this.f16058l;
        }

        public boolean hasR3C1() {
            return this.f16061o;
        }

        public boolean hasR4C1() {
            return this.f16065s;
        }

        public boolean hasR5C1() {
            return this.f16069w;
        }

        public boolean hasR6C1() {
            return this.f16042A;
        }

        public boolean hasR7C1() {
            return this.f16044C;
        }

        public boolean hasType() {
            return this.f16047a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public LtableTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro image;
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setType(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        image = new Image();
                        codedInputStreamMicro.readMessage(image);
                        setR1C1(image);
                        continue;
                    case 26:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setR1C2(image);
                        continue;
                    case 34:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setR1C3(image);
                        continue;
                    case 42:
                        image = new Button();
                        codedInputStreamMicro.readMessage(image);
                        addR1C4(image);
                        continue;
                    case 50:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setInternation(image);
                        continue;
                    case 58:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setR2C1(image);
                        continue;
                    case 66:
                        image = new ScatterStyle();
                        codedInputStreamMicro.readMessage(image);
                        addR2C2(image);
                        continue;
                    case 74:
                        image = new Score();
                        codedInputStreamMicro.readMessage(image);
                        setR3C1(image);
                        continue;
                    case 82:
                        image = new ComboBox();
                        codedInputStreamMicro.readMessage(image);
                        addR3C2(image);
                        continue;
                    case 90:
                        image = new ScatterStyle();
                        codedInputStreamMicro.readMessage(image);
                        addR3C3(image);
                        continue;
                    case 98:
                        image = new Score();
                        codedInputStreamMicro.readMessage(image);
                        setR4C1(image);
                        continue;
                    case 106:
                        image = new ComboBox();
                        codedInputStreamMicro.readMessage(image);
                        addR4C2(image);
                        continue;
                    case 114:
                        image = new ScatterStyle();
                        codedInputStreamMicro.readMessage(image);
                        addR4C3(image);
                        continue;
                    case C1253f.df /*122*/:
                        image = new Score();
                        codedInputStreamMicro.readMessage(image);
                        setR5C1(image);
                        continue;
                    case 130:
                        image = new ComboBox();
                        codedInputStreamMicro.readMessage(image);
                        addR5C2(image);
                        continue;
                    case 138:
                        image = new ScatterStyle();
                        codedInputStreamMicro.readMessage(image);
                        addR5C3(image);
                        continue;
                    case 146:
                        image = new Fatherson();
                        codedInputStreamMicro.readMessage(image);
                        setR6C1(image);
                        continue;
                    case 154:
                        image = new Composit();
                        codedInputStreamMicro.readMessage(image);
                        setR7C1(image);
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

        public LtableTemplate setInternation(RichText richText) {
            if (richText == null) {
                return clearInternation();
            }
            this.f16056j = true;
            this.f16057k = richText;
            return this;
        }

        public LtableTemplate setR1C1(Image image) {
            if (image == null) {
                return clearR1C1();
            }
            this.f16049c = true;
            this.f16050d = image;
            return this;
        }

        public LtableTemplate setR1C2(RichText richText) {
            if (richText == null) {
                return clearR1C2();
            }
            this.f16051e = true;
            this.f16052f = richText;
            return this;
        }

        public LtableTemplate setR1C3(RichText richText) {
            if (richText == null) {
                return clearR1C3();
            }
            this.f16053g = true;
            this.f16054h = richText;
            return this;
        }

        public LtableTemplate setR1C4(int i, Button button) {
            if (button != null) {
                this.f16055i.set(i, button);
            }
            return this;
        }

        public LtableTemplate setR2C1(RichText richText) {
            if (richText == null) {
                return clearR2C1();
            }
            this.f16058l = true;
            this.f16059m = richText;
            return this;
        }

        public LtableTemplate setR2C2(int i, ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                this.f16060n.set(i, scatterStyle);
            }
            return this;
        }

        public LtableTemplate setR3C1(Score score) {
            if (score == null) {
                return clearR3C1();
            }
            this.f16061o = true;
            this.f16062p = score;
            return this;
        }

        public LtableTemplate setR3C2(int i, ComboBox comboBox) {
            if (comboBox != null) {
                this.f16063q.set(i, comboBox);
            }
            return this;
        }

        public LtableTemplate setR3C3(int i, ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                this.f16064r.set(i, scatterStyle);
            }
            return this;
        }

        public LtableTemplate setR4C1(Score score) {
            if (score == null) {
                return clearR4C1();
            }
            this.f16065s = true;
            this.f16066t = score;
            return this;
        }

        public LtableTemplate setR4C2(int i, ComboBox comboBox) {
            if (comboBox != null) {
                this.f16067u.set(i, comboBox);
            }
            return this;
        }

        public LtableTemplate setR4C3(int i, ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                this.f16068v.set(i, scatterStyle);
            }
            return this;
        }

        public LtableTemplate setR5C1(Score score) {
            if (score == null) {
                return clearR5C1();
            }
            this.f16069w = true;
            this.f16070x = score;
            return this;
        }

        public LtableTemplate setR5C2(int i, ComboBox comboBox) {
            if (comboBox != null) {
                this.f16071y.set(i, comboBox);
            }
            return this;
        }

        public LtableTemplate setR5C3(int i, ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                this.f16072z.set(i, scatterStyle);
            }
            return this;
        }

        public LtableTemplate setR6C1(Fatherson fatherson) {
            if (fatherson == null) {
                return clearR6C1();
            }
            this.f16042A = true;
            this.f16043B = fatherson;
            return this;
        }

        public LtableTemplate setR7C1(Composit composit) {
            if (composit == null) {
                return clearR7C1();
            }
            this.f16044C = true;
            this.f16045D = composit;
            return this;
        }

        public LtableTemplate setType(int i) {
            this.f16047a = true;
            this.f16048b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(1, getType());
            }
            if (hasR1C1()) {
                codedOutputStreamMicro.writeMessage(2, getR1C1());
            }
            if (hasR1C2()) {
                codedOutputStreamMicro.writeMessage(3, getR1C2());
            }
            if (hasR1C3()) {
                codedOutputStreamMicro.writeMessage(4, getR1C3());
            }
            for (Button writeMessage : getR1C4List()) {
                codedOutputStreamMicro.writeMessage(5, writeMessage);
            }
            if (hasInternation()) {
                codedOutputStreamMicro.writeMessage(6, getInternation());
            }
            if (hasR2C1()) {
                codedOutputStreamMicro.writeMessage(7, getR2C1());
            }
            for (ScatterStyle writeMessage2 : getR2C2List()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage2);
            }
            if (hasR3C1()) {
                codedOutputStreamMicro.writeMessage(9, getR3C1());
            }
            for (ComboBox writeMessage3 : getR3C2List()) {
                codedOutputStreamMicro.writeMessage(10, writeMessage3);
            }
            for (ScatterStyle writeMessage22 : getR3C3List()) {
                codedOutputStreamMicro.writeMessage(11, writeMessage22);
            }
            if (hasR4C1()) {
                codedOutputStreamMicro.writeMessage(12, getR4C1());
            }
            for (ComboBox writeMessage32 : getR4C2List()) {
                codedOutputStreamMicro.writeMessage(13, writeMessage32);
            }
            for (ScatterStyle writeMessage222 : getR4C3List()) {
                codedOutputStreamMicro.writeMessage(14, writeMessage222);
            }
            if (hasR5C1()) {
                codedOutputStreamMicro.writeMessage(15, getR5C1());
            }
            for (ComboBox writeMessage322 : getR5C2List()) {
                codedOutputStreamMicro.writeMessage(16, writeMessage322);
            }
            for (ScatterStyle writeMessage2222 : getR5C3List()) {
                codedOutputStreamMicro.writeMessage(17, writeMessage2222);
            }
            if (hasR6C1()) {
                codedOutputStreamMicro.writeMessage(18, getR6C1());
            }
            if (hasR7C1()) {
                codedOutputStreamMicro.writeMessage(19, getR7C1());
            }
        }
    }

    public static final class MapSearchaladdinNormalTemplate extends MessageMicro {
        public static final int ALADDINNORMALL1_FIELD_NUMBER = 1;
        public static final int ALADDINNORMALL2_FIELD_NUMBER = 2;
        public static final int ALADDINNORMALL3_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f16073a;
        /* renamed from: b */
        private RichText f16074b = null;
        /* renamed from: c */
        private boolean f16075c;
        /* renamed from: d */
        private RichText f16076d = null;
        /* renamed from: e */
        private boolean f16077e;
        /* renamed from: f */
        private RichText f16078f = null;
        /* renamed from: g */
        private int f16079g = -1;

        public static MapSearchaladdinNormalTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MapSearchaladdinNormalTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static MapSearchaladdinNormalTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MapSearchaladdinNormalTemplate) new MapSearchaladdinNormalTemplate().mergeFrom(bArr);
        }

        public final MapSearchaladdinNormalTemplate clear() {
            clearAladdinnormall1();
            clearAladdinnormall2();
            clearAladdinnormall3();
            this.f16079g = -1;
            return this;
        }

        public MapSearchaladdinNormalTemplate clearAladdinnormall1() {
            this.f16073a = false;
            this.f16074b = null;
            return this;
        }

        public MapSearchaladdinNormalTemplate clearAladdinnormall2() {
            this.f16075c = false;
            this.f16076d = null;
            return this;
        }

        public MapSearchaladdinNormalTemplate clearAladdinnormall3() {
            this.f16077e = false;
            this.f16078f = null;
            return this;
        }

        public RichText getAladdinnormall1() {
            return this.f16074b;
        }

        public RichText getAladdinnormall2() {
            return this.f16076d;
        }

        public RichText getAladdinnormall3() {
            return this.f16078f;
        }

        public int getCachedSize() {
            if (this.f16079g < 0) {
                getSerializedSize();
            }
            return this.f16079g;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAladdinnormall1()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getAladdinnormall1());
            }
            if (hasAladdinnormall2()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getAladdinnormall2());
            }
            if (hasAladdinnormall3()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getAladdinnormall3());
            }
            this.f16079g = i;
            return i;
        }

        public boolean hasAladdinnormall1() {
            return this.f16073a;
        }

        public boolean hasAladdinnormall2() {
            return this.f16075c;
        }

        public boolean hasAladdinnormall3() {
            return this.f16077e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MapSearchaladdinNormalTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro richText;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinnormall1(richText);
                        continue;
                    case 18:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinnormall2(richText);
                        continue;
                    case 26:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinnormall3(richText);
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

        public MapSearchaladdinNormalTemplate setAladdinnormall1(RichText richText) {
            if (richText == null) {
                return clearAladdinnormall1();
            }
            this.f16073a = true;
            this.f16074b = richText;
            return this;
        }

        public MapSearchaladdinNormalTemplate setAladdinnormall2(RichText richText) {
            if (richText == null) {
                return clearAladdinnormall2();
            }
            this.f16075c = true;
            this.f16076d = richText;
            return this;
        }

        public MapSearchaladdinNormalTemplate setAladdinnormall3(RichText richText) {
            if (richText == null) {
                return clearAladdinnormall3();
            }
            this.f16077e = true;
            this.f16078f = richText;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAladdinnormall1()) {
                codedOutputStreamMicro.writeMessage(1, getAladdinnormall1());
            }
            if (hasAladdinnormall2()) {
                codedOutputStreamMicro.writeMessage(2, getAladdinnormall2());
            }
            if (hasAladdinnormall3()) {
                codedOutputStreamMicro.writeMessage(3, getAladdinnormall3());
            }
        }
    }

    public static final class MapSearchaladdinPanelTemplate extends MessageMicro {
        public static final int ALADDINPANELL1C1_FIELD_NUMBER = 1;
        public static final int ALADDINPANELL1C2_FIELD_NUMBER = 2;
        public static final int ALADDINPANELL2C1_FIELD_NUMBER = 3;
        public static final int ALADDINPANELL2C2_FIELD_NUMBER = 4;
        public static final int ALADDINPANELL2C3_FIELD_NUMBER = 5;
        public static final int ALADDINPANELL3_FIELD_NUMBER = 6;
        public static final int ALADDINPANELL4_FIELD_NUMBER = 7;
        public static final int ALADDINPANELL5_FIELD_NUMBER = 8;
        public static final int ALADDINPANELL6_FIELD_NUMBER = 9;
        public static final int UPPERLEFTCORNER_FIELD_NUMBER = 10;
        /* renamed from: a */
        private boolean f16080a;
        /* renamed from: b */
        private RichText f16081b = null;
        /* renamed from: c */
        private List<Resource> f16082c = Collections.emptyList();
        /* renamed from: d */
        private boolean f16083d;
        /* renamed from: e */
        private String f16084e = "";
        /* renamed from: f */
        private boolean f16085f;
        /* renamed from: g */
        private RichText f16086g = null;
        /* renamed from: h */
        private boolean f16087h;
        /* renamed from: i */
        private RichText f16088i = null;
        /* renamed from: j */
        private boolean f16089j;
        /* renamed from: k */
        private RichText f16090k = null;
        /* renamed from: l */
        private boolean f16091l;
        /* renamed from: m */
        private RichText f16092m = null;
        /* renamed from: n */
        private List<ChildrenBtn> f16093n = Collections.emptyList();
        /* renamed from: o */
        private boolean f16094o;
        /* renamed from: p */
        private RichText f16095p = null;
        /* renamed from: q */
        private boolean f16096q;
        /* renamed from: r */
        private Resource f16097r = null;
        /* renamed from: s */
        private int f16098s = -1;

        public static MapSearchaladdinPanelTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MapSearchaladdinPanelTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static MapSearchaladdinPanelTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MapSearchaladdinPanelTemplate) new MapSearchaladdinPanelTemplate().mergeFrom(bArr);
        }

        public MapSearchaladdinPanelTemplate addAladdinpanell1C2(Resource resource) {
            if (resource != null) {
                if (this.f16082c.isEmpty()) {
                    this.f16082c = new ArrayList();
                }
                this.f16082c.add(resource);
            }
            return this;
        }

        public MapSearchaladdinPanelTemplate addAladdinpanell5(ChildrenBtn childrenBtn) {
            if (childrenBtn != null) {
                if (this.f16093n.isEmpty()) {
                    this.f16093n = new ArrayList();
                }
                this.f16093n.add(childrenBtn);
            }
            return this;
        }

        public final MapSearchaladdinPanelTemplate clear() {
            clearAladdinpanell1C1();
            clearAladdinpanell1C2();
            clearAladdinpanell2C1();
            clearAladdinpanell2C2();
            clearAladdinpanell2C3();
            clearAladdinpanell3();
            clearAladdinpanell4();
            clearAladdinpanell5();
            clearAladdinpanell6();
            clearUpperleftcorner();
            this.f16098s = -1;
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell1C1() {
            this.f16080a = false;
            this.f16081b = null;
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell1C2() {
            this.f16082c = Collections.emptyList();
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell2C1() {
            this.f16083d = false;
            this.f16084e = "";
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell2C2() {
            this.f16085f = false;
            this.f16086g = null;
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell2C3() {
            this.f16087h = false;
            this.f16088i = null;
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell3() {
            this.f16089j = false;
            this.f16090k = null;
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell4() {
            this.f16091l = false;
            this.f16092m = null;
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell5() {
            this.f16093n = Collections.emptyList();
            return this;
        }

        public MapSearchaladdinPanelTemplate clearAladdinpanell6() {
            this.f16094o = false;
            this.f16095p = null;
            return this;
        }

        public MapSearchaladdinPanelTemplate clearUpperleftcorner() {
            this.f16096q = false;
            this.f16097r = null;
            return this;
        }

        public RichText getAladdinpanell1C1() {
            return this.f16081b;
        }

        public Resource getAladdinpanell1C2(int i) {
            return (Resource) this.f16082c.get(i);
        }

        public int getAladdinpanell1C2Count() {
            return this.f16082c.size();
        }

        public List<Resource> getAladdinpanell1C2List() {
            return this.f16082c;
        }

        public String getAladdinpanell2C1() {
            return this.f16084e;
        }

        public RichText getAladdinpanell2C2() {
            return this.f16086g;
        }

        public RichText getAladdinpanell2C3() {
            return this.f16088i;
        }

        public RichText getAladdinpanell3() {
            return this.f16090k;
        }

        public RichText getAladdinpanell4() {
            return this.f16092m;
        }

        public ChildrenBtn getAladdinpanell5(int i) {
            return (ChildrenBtn) this.f16093n.get(i);
        }

        public int getAladdinpanell5Count() {
            return this.f16093n.size();
        }

        public List<ChildrenBtn> getAladdinpanell5List() {
            return this.f16093n;
        }

        public RichText getAladdinpanell6() {
            return this.f16095p;
        }

        public int getCachedSize() {
            if (this.f16098s < 0) {
                getSerializedSize();
            }
            return this.f16098s;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAladdinpanell1C1()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getAladdinpanell1C1());
            }
            int i2 = i;
            for (Resource computeMessageSize : getAladdinpanell1C2List()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            if (hasAladdinpanell2C1()) {
                i2 += CodedOutputStreamMicro.computeStringSize(3, getAladdinpanell2C1());
            }
            if (hasAladdinpanell2C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(4, getAladdinpanell2C2());
            }
            if (hasAladdinpanell2C3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getAladdinpanell2C3());
            }
            if (hasAladdinpanell3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, getAladdinpanell3());
            }
            if (hasAladdinpanell4()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getAladdinpanell4());
            }
            for (ChildrenBtn computeMessageSize2 : getAladdinpanell5List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize2);
            }
            if (hasAladdinpanell6()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, getAladdinpanell6());
            }
            if (hasUpperleftcorner()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, getUpperleftcorner());
            }
            this.f16098s = i2;
            return i2;
        }

        public Resource getUpperleftcorner() {
            return this.f16097r;
        }

        public boolean hasAladdinpanell1C1() {
            return this.f16080a;
        }

        public boolean hasAladdinpanell2C1() {
            return this.f16083d;
        }

        public boolean hasAladdinpanell2C2() {
            return this.f16085f;
        }

        public boolean hasAladdinpanell2C3() {
            return this.f16087h;
        }

        public boolean hasAladdinpanell3() {
            return this.f16089j;
        }

        public boolean hasAladdinpanell4() {
            return this.f16091l;
        }

        public boolean hasAladdinpanell6() {
            return this.f16094o;
        }

        public boolean hasUpperleftcorner() {
            return this.f16096q;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MapSearchaladdinPanelTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro richText;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinpanell1C1(richText);
                        continue;
                    case 18:
                        richText = new Resource();
                        codedInputStreamMicro.readMessage(richText);
                        addAladdinpanell1C2(richText);
                        continue;
                    case 26:
                        setAladdinpanell2C1(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinpanell2C2(richText);
                        continue;
                    case 42:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinpanell2C3(richText);
                        continue;
                    case 50:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinpanell3(richText);
                        continue;
                    case 58:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinpanell4(richText);
                        continue;
                    case 66:
                        richText = new ChildrenBtn();
                        codedInputStreamMicro.readMessage(richText);
                        addAladdinpanell5(richText);
                        continue;
                    case 74:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setAladdinpanell6(richText);
                        continue;
                    case 82:
                        richText = new Resource();
                        codedInputStreamMicro.readMessage(richText);
                        setUpperleftcorner(richText);
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

        public MapSearchaladdinPanelTemplate setAladdinpanell1C1(RichText richText) {
            if (richText == null) {
                return clearAladdinpanell1C1();
            }
            this.f16080a = true;
            this.f16081b = richText;
            return this;
        }

        public MapSearchaladdinPanelTemplate setAladdinpanell1C2(int i, Resource resource) {
            if (resource != null) {
                this.f16082c.set(i, resource);
            }
            return this;
        }

        public MapSearchaladdinPanelTemplate setAladdinpanell2C1(String str) {
            this.f16083d = true;
            this.f16084e = str;
            return this;
        }

        public MapSearchaladdinPanelTemplate setAladdinpanell2C2(RichText richText) {
            if (richText == null) {
                return clearAladdinpanell2C2();
            }
            this.f16085f = true;
            this.f16086g = richText;
            return this;
        }

        public MapSearchaladdinPanelTemplate setAladdinpanell2C3(RichText richText) {
            if (richText == null) {
                return clearAladdinpanell2C3();
            }
            this.f16087h = true;
            this.f16088i = richText;
            return this;
        }

        public MapSearchaladdinPanelTemplate setAladdinpanell3(RichText richText) {
            if (richText == null) {
                return clearAladdinpanell3();
            }
            this.f16089j = true;
            this.f16090k = richText;
            return this;
        }

        public MapSearchaladdinPanelTemplate setAladdinpanell4(RichText richText) {
            if (richText == null) {
                return clearAladdinpanell4();
            }
            this.f16091l = true;
            this.f16092m = richText;
            return this;
        }

        public MapSearchaladdinPanelTemplate setAladdinpanell5(int i, ChildrenBtn childrenBtn) {
            if (childrenBtn != null) {
                this.f16093n.set(i, childrenBtn);
            }
            return this;
        }

        public MapSearchaladdinPanelTemplate setAladdinpanell6(RichText richText) {
            if (richText == null) {
                return clearAladdinpanell6();
            }
            this.f16094o = true;
            this.f16095p = richText;
            return this;
        }

        public MapSearchaladdinPanelTemplate setUpperleftcorner(Resource resource) {
            if (resource == null) {
                return clearUpperleftcorner();
            }
            this.f16096q = true;
            this.f16097r = resource;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAladdinpanell1C1()) {
                codedOutputStreamMicro.writeMessage(1, getAladdinpanell1C1());
            }
            for (Resource writeMessage : getAladdinpanell1C2List()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasAladdinpanell2C1()) {
                codedOutputStreamMicro.writeString(3, getAladdinpanell2C1());
            }
            if (hasAladdinpanell2C2()) {
                codedOutputStreamMicro.writeMessage(4, getAladdinpanell2C2());
            }
            if (hasAladdinpanell2C3()) {
                codedOutputStreamMicro.writeMessage(5, getAladdinpanell2C3());
            }
            if (hasAladdinpanell3()) {
                codedOutputStreamMicro.writeMessage(6, getAladdinpanell3());
            }
            if (hasAladdinpanell4()) {
                codedOutputStreamMicro.writeMessage(7, getAladdinpanell4());
            }
            for (ChildrenBtn writeMessage2 : getAladdinpanell5List()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage2);
            }
            if (hasAladdinpanell6()) {
                codedOutputStreamMicro.writeMessage(9, getAladdinpanell6());
            }
            if (hasUpperleftcorner()) {
                codedOutputStreamMicro.writeMessage(10, getUpperleftcorner());
            }
        }
    }

    public static final class NormalTemplate extends MessageMicro {
        public static final int FANORMALL5_FIELD_NUMBER = 13;
        public static final int FLAG_FIELD_NUMBER = 12;
        public static final int NORMALL1C1_FIELD_NUMBER = 1;
        public static final int NORMALL1C2_FIELD_NUMBER = 2;
        public static final int NORMALL1C3_FIELD_NUMBER = 3;
        public static final int NORMALL2C1_FIELD_NUMBER = 4;
        public static final int NORMALL2C2_FIELD_NUMBER = 5;
        public static final int NORMALL2C3_FIELD_NUMBER = 6;
        public static final int NORMALL3_FIELD_NUMBER = 7;
        public static final int NORMALL4LAB_FIELD_NUMBER = 14;
        public static final int NORMALL4_FIELD_NUMBER = 8;
        public static final int NORMALL5_FIELD_NUMBER = 9;
        public static final int NORMALL6_FIELD_NUMBER = 10;
        public static final int UPPERLEFTCORNER_FIELD_NUMBER = 11;
        /* renamed from: a */
        private boolean f16099a;
        /* renamed from: b */
        private RichText f16100b = null;
        /* renamed from: c */
        private List<Resource> f16101c = Collections.emptyList();
        /* renamed from: d */
        private boolean f16102d;
        /* renamed from: e */
        private RichText f16103e = null;
        /* renamed from: f */
        private boolean f16104f;
        /* renamed from: g */
        private String f16105g = "";
        /* renamed from: h */
        private boolean f16106h;
        /* renamed from: i */
        private RichText f16107i = null;
        /* renamed from: j */
        private boolean f16108j;
        /* renamed from: k */
        private RichText f16109k = null;
        /* renamed from: l */
        private boolean f16110l;
        /* renamed from: m */
        private RichText f16111m = null;
        /* renamed from: n */
        private boolean f16112n;
        /* renamed from: o */
        private RichText f16113o = null;
        /* renamed from: p */
        private boolean f16114p;
        /* renamed from: q */
        private int f16115q = 0;
        /* renamed from: r */
        private boolean f16116r;
        /* renamed from: s */
        private Composit f16117s = null;
        /* renamed from: t */
        private boolean f16118t;
        /* renamed from: u */
        private Resource f16119u = null;
        /* renamed from: v */
        private List<String> f16120v = Collections.emptyList();
        /* renamed from: w */
        private boolean f16121w;
        /* renamed from: x */
        private Fatherson f16122x = null;
        /* renamed from: y */
        private List<String> f16123y = Collections.emptyList();
        /* renamed from: z */
        private int f16124z = -1;

        public static NormalTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new NormalTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static NormalTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (NormalTemplate) new NormalTemplate().mergeFrom(bArr);
        }

        public NormalTemplate addFlag(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f16120v.isEmpty()) {
                this.f16120v = new ArrayList();
            }
            this.f16120v.add(str);
            return this;
        }

        public NormalTemplate addNormall1C2(Resource resource) {
            if (resource != null) {
                if (this.f16101c.isEmpty()) {
                    this.f16101c = new ArrayList();
                }
                this.f16101c.add(resource);
            }
            return this;
        }

        public NormalTemplate addNormall4Lab(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f16123y.isEmpty()) {
                this.f16123y = new ArrayList();
            }
            this.f16123y.add(str);
            return this;
        }

        public final NormalTemplate clear() {
            clearNormall1C1();
            clearNormall1C2();
            clearNormall1C3();
            clearNormall2C1();
            clearNormall2C2();
            clearNormall2C3();
            clearNormall3();
            clearNormall4();
            clearNormall5();
            clearNormall6();
            clearUpperleftcorner();
            clearFlag();
            clearFanormall5();
            clearNormall4Lab();
            this.f16124z = -1;
            return this;
        }

        public NormalTemplate clearFanormall5() {
            this.f16121w = false;
            this.f16122x = null;
            return this;
        }

        public NormalTemplate clearFlag() {
            this.f16120v = Collections.emptyList();
            return this;
        }

        public NormalTemplate clearNormall1C1() {
            this.f16099a = false;
            this.f16100b = null;
            return this;
        }

        public NormalTemplate clearNormall1C2() {
            this.f16101c = Collections.emptyList();
            return this;
        }

        public NormalTemplate clearNormall1C3() {
            this.f16102d = false;
            this.f16103e = null;
            return this;
        }

        public NormalTemplate clearNormall2C1() {
            this.f16104f = false;
            this.f16105g = "";
            return this;
        }

        public NormalTemplate clearNormall2C2() {
            this.f16106h = false;
            this.f16107i = null;
            return this;
        }

        public NormalTemplate clearNormall2C3() {
            this.f16108j = false;
            this.f16109k = null;
            return this;
        }

        public NormalTemplate clearNormall3() {
            this.f16110l = false;
            this.f16111m = null;
            return this;
        }

        public NormalTemplate clearNormall4() {
            this.f16112n = false;
            this.f16113o = null;
            return this;
        }

        public NormalTemplate clearNormall4Lab() {
            this.f16123y = Collections.emptyList();
            return this;
        }

        public NormalTemplate clearNormall5() {
            this.f16114p = false;
            this.f16115q = 0;
            return this;
        }

        public NormalTemplate clearNormall6() {
            this.f16116r = false;
            this.f16117s = null;
            return this;
        }

        public NormalTemplate clearUpperleftcorner() {
            this.f16118t = false;
            this.f16119u = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f16124z < 0) {
                getSerializedSize();
            }
            return this.f16124z;
        }

        public Fatherson getFanormall5() {
            return this.f16122x;
        }

        public String getFlag(int i) {
            return (String) this.f16120v.get(i);
        }

        public int getFlagCount() {
            return this.f16120v.size();
        }

        public List<String> getFlagList() {
            return this.f16120v;
        }

        public RichText getNormall1C1() {
            return this.f16100b;
        }

        public Resource getNormall1C2(int i) {
            return (Resource) this.f16101c.get(i);
        }

        public int getNormall1C2Count() {
            return this.f16101c.size();
        }

        public List<Resource> getNormall1C2List() {
            return this.f16101c;
        }

        public RichText getNormall1C3() {
            return this.f16103e;
        }

        public String getNormall2C1() {
            return this.f16105g;
        }

        public RichText getNormall2C2() {
            return this.f16107i;
        }

        public RichText getNormall2C3() {
            return this.f16109k;
        }

        public RichText getNormall3() {
            return this.f16111m;
        }

        public RichText getNormall4() {
            return this.f16113o;
        }

        public String getNormall4Lab(int i) {
            return (String) this.f16123y.get(i);
        }

        public int getNormall4LabCount() {
            return this.f16123y.size();
        }

        public List<String> getNormall4LabList() {
            return this.f16123y;
        }

        public int getNormall5() {
            return this.f16115q;
        }

        public Composit getNormall6() {
            return this.f16117s;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeMessageSize = hasNormall1C1() ? CodedOutputStreamMicro.computeMessageSize(1, getNormall1C1()) + 0 : 0;
            int i2 = computeMessageSize;
            for (Resource computeMessageSize2 : getNormall1C2List()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2) + i2;
            }
            if (hasNormall1C3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(3, getNormall1C3());
            }
            if (hasNormall2C1()) {
                i2 += CodedOutputStreamMicro.computeStringSize(4, getNormall2C1());
            }
            if (hasNormall2C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getNormall2C2());
            }
            if (hasNormall2C3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, getNormall2C3());
            }
            if (hasNormall3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getNormall3());
            }
            if (hasNormall4()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, getNormall4());
            }
            if (hasNormall5()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(9, getNormall5());
            }
            if (hasNormall6()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, getNormall6());
            }
            if (hasUpperleftcorner()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(11, getUpperleftcorner());
            }
            int i3 = 0;
            for (String computeStringSizeNoTag : getFlagList()) {
                i3 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i3;
            }
            computeMessageSize = (i2 + i3) + (getFlagList().size() * 1);
            i2 = hasFanormall5() ? computeMessageSize + CodedOutputStreamMicro.computeMessageSize(13, getFanormall5()) : computeMessageSize;
            for (String computeStringSizeNoTag2 : getNormall4LabList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag2);
            }
            computeMessageSize = (i2 + i) + (getNormall4LabList().size() * 1);
            this.f16124z = computeMessageSize;
            return computeMessageSize;
        }

        public Resource getUpperleftcorner() {
            return this.f16119u;
        }

        public boolean hasFanormall5() {
            return this.f16121w;
        }

        public boolean hasNormall1C1() {
            return this.f16099a;
        }

        public boolean hasNormall1C3() {
            return this.f16102d;
        }

        public boolean hasNormall2C1() {
            return this.f16104f;
        }

        public boolean hasNormall2C2() {
            return this.f16106h;
        }

        public boolean hasNormall2C3() {
            return this.f16108j;
        }

        public boolean hasNormall3() {
            return this.f16110l;
        }

        public boolean hasNormall4() {
            return this.f16112n;
        }

        public boolean hasNormall5() {
            return this.f16114p;
        }

        public boolean hasNormall6() {
            return this.f16116r;
        }

        public boolean hasUpperleftcorner() {
            return this.f16118t;
        }

        public final boolean isInitialized() {
            return true;
        }

        public NormalTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro richText;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setNormall1C1(richText);
                        continue;
                    case 18:
                        richText = new Resource();
                        codedInputStreamMicro.readMessage(richText);
                        addNormall1C2(richText);
                        continue;
                    case 26:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setNormall1C3(richText);
                        continue;
                    case 34:
                        setNormall2C1(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setNormall2C2(richText);
                        continue;
                    case 50:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setNormall2C3(richText);
                        continue;
                    case 58:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setNormall3(richText);
                        continue;
                    case 66:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setNormall4(richText);
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setNormall5(codedInputStreamMicro.readInt32());
                        continue;
                    case 82:
                        richText = new Composit();
                        codedInputStreamMicro.readMessage(richText);
                        setNormall6(richText);
                        continue;
                    case 90:
                        richText = new Resource();
                        codedInputStreamMicro.readMessage(richText);
                        setUpperleftcorner(richText);
                        continue;
                    case 98:
                        addFlag(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        richText = new Fatherson();
                        codedInputStreamMicro.readMessage(richText);
                        setFanormall5(richText);
                        continue;
                    case 114:
                        addNormall4Lab(codedInputStreamMicro.readString());
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

        public NormalTemplate setFanormall5(Fatherson fatherson) {
            if (fatherson == null) {
                return clearFanormall5();
            }
            this.f16121w = true;
            this.f16122x = fatherson;
            return this;
        }

        public NormalTemplate setFlag(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f16120v.set(i, str);
            return this;
        }

        public NormalTemplate setNormall1C1(RichText richText) {
            if (richText == null) {
                return clearNormall1C1();
            }
            this.f16099a = true;
            this.f16100b = richText;
            return this;
        }

        public NormalTemplate setNormall1C2(int i, Resource resource) {
            if (resource != null) {
                this.f16101c.set(i, resource);
            }
            return this;
        }

        public NormalTemplate setNormall1C3(RichText richText) {
            if (richText == null) {
                return clearNormall1C3();
            }
            this.f16102d = true;
            this.f16103e = richText;
            return this;
        }

        public NormalTemplate setNormall2C1(String str) {
            this.f16104f = true;
            this.f16105g = str;
            return this;
        }

        public NormalTemplate setNormall2C2(RichText richText) {
            if (richText == null) {
                return clearNormall2C2();
            }
            this.f16106h = true;
            this.f16107i = richText;
            return this;
        }

        public NormalTemplate setNormall2C3(RichText richText) {
            if (richText == null) {
                return clearNormall2C3();
            }
            this.f16108j = true;
            this.f16109k = richText;
            return this;
        }

        public NormalTemplate setNormall3(RichText richText) {
            if (richText == null) {
                return clearNormall3();
            }
            this.f16110l = true;
            this.f16111m = richText;
            return this;
        }

        public NormalTemplate setNormall4(RichText richText) {
            if (richText == null) {
                return clearNormall4();
            }
            this.f16112n = true;
            this.f16113o = richText;
            return this;
        }

        public NormalTemplate setNormall4Lab(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f16123y.set(i, str);
            return this;
        }

        public NormalTemplate setNormall5(int i) {
            this.f16114p = true;
            this.f16115q = i;
            return this;
        }

        public NormalTemplate setNormall6(Composit composit) {
            if (composit == null) {
                return clearNormall6();
            }
            this.f16116r = true;
            this.f16117s = composit;
            return this;
        }

        public NormalTemplate setUpperleftcorner(Resource resource) {
            if (resource == null) {
                return clearUpperleftcorner();
            }
            this.f16118t = true;
            this.f16119u = resource;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasNormall1C1()) {
                codedOutputStreamMicro.writeMessage(1, getNormall1C1());
            }
            for (Resource writeMessage : getNormall1C2List()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasNormall1C3()) {
                codedOutputStreamMicro.writeMessage(3, getNormall1C3());
            }
            if (hasNormall2C1()) {
                codedOutputStreamMicro.writeString(4, getNormall2C1());
            }
            if (hasNormall2C2()) {
                codedOutputStreamMicro.writeMessage(5, getNormall2C2());
            }
            if (hasNormall2C3()) {
                codedOutputStreamMicro.writeMessage(6, getNormall2C3());
            }
            if (hasNormall3()) {
                codedOutputStreamMicro.writeMessage(7, getNormall3());
            }
            if (hasNormall4()) {
                codedOutputStreamMicro.writeMessage(8, getNormall4());
            }
            if (hasNormall5()) {
                codedOutputStreamMicro.writeInt32(9, getNormall5());
            }
            if (hasNormall6()) {
                codedOutputStreamMicro.writeMessage(10, getNormall6());
            }
            if (hasUpperleftcorner()) {
                codedOutputStreamMicro.writeMessage(11, getUpperleftcorner());
            }
            for (String writeString : getFlagList()) {
                codedOutputStreamMicro.writeString(12, writeString);
            }
            if (hasFanormall5()) {
                codedOutputStreamMicro.writeMessage(13, getFanormall5());
            }
            for (String writeString2 : getNormall4LabList()) {
                codedOutputStreamMicro.writeString(14, writeString2);
            }
        }
    }

    public static final class PanelTemplate extends MessageMicro {
        public static final int PANELL1C1_FIELD_NUMBER = 1;
        public static final int PANELL1C2_FIELD_NUMBER = 2;
        public static final int PANELL2C1_FIELD_NUMBER = 3;
        public static final int PANELL2C2_FIELD_NUMBER = 4;
        public static final int PANELL2C3_FIELD_NUMBER = 5;
        public static final int PANELL3_FIELD_NUMBER = 6;
        public static final int UPPERLEFTCORNER_FIELD_NUMBER = 7;
        /* renamed from: a */
        private boolean f16125a;
        /* renamed from: b */
        private RichText f16126b = null;
        /* renamed from: c */
        private List<Resource> f16127c = Collections.emptyList();
        /* renamed from: d */
        private boolean f16128d;
        /* renamed from: e */
        private String f16129e = "";
        /* renamed from: f */
        private boolean f16130f;
        /* renamed from: g */
        private RichText f16131g = null;
        /* renamed from: h */
        private boolean f16132h;
        /* renamed from: i */
        private RichText f16133i = null;
        /* renamed from: j */
        private boolean f16134j;
        /* renamed from: k */
        private RichText f16135k = null;
        /* renamed from: l */
        private boolean f16136l;
        /* renamed from: m */
        private Resource f16137m = null;
        /* renamed from: n */
        private int f16138n = -1;

        public static PanelTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new PanelTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static PanelTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (PanelTemplate) new PanelTemplate().mergeFrom(bArr);
        }

        public PanelTemplate addPanell1C2(Resource resource) {
            if (resource != null) {
                if (this.f16127c.isEmpty()) {
                    this.f16127c = new ArrayList();
                }
                this.f16127c.add(resource);
            }
            return this;
        }

        public final PanelTemplate clear() {
            clearPanell1C1();
            clearPanell1C2();
            clearPanell2C1();
            clearPanell2C2();
            clearPanell2C3();
            clearPanell3();
            clearUpperleftcorner();
            this.f16138n = -1;
            return this;
        }

        public PanelTemplate clearPanell1C1() {
            this.f16125a = false;
            this.f16126b = null;
            return this;
        }

        public PanelTemplate clearPanell1C2() {
            this.f16127c = Collections.emptyList();
            return this;
        }

        public PanelTemplate clearPanell2C1() {
            this.f16128d = false;
            this.f16129e = "";
            return this;
        }

        public PanelTemplate clearPanell2C2() {
            this.f16130f = false;
            this.f16131g = null;
            return this;
        }

        public PanelTemplate clearPanell2C3() {
            this.f16132h = false;
            this.f16133i = null;
            return this;
        }

        public PanelTemplate clearPanell3() {
            this.f16134j = false;
            this.f16135k = null;
            return this;
        }

        public PanelTemplate clearUpperleftcorner() {
            this.f16136l = false;
            this.f16137m = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f16138n < 0) {
                getSerializedSize();
            }
            return this.f16138n;
        }

        public RichText getPanell1C1() {
            return this.f16126b;
        }

        public Resource getPanell1C2(int i) {
            return (Resource) this.f16127c.get(i);
        }

        public int getPanell1C2Count() {
            return this.f16127c.size();
        }

        public List<Resource> getPanell1C2List() {
            return this.f16127c;
        }

        public String getPanell2C1() {
            return this.f16129e;
        }

        public RichText getPanell2C2() {
            return this.f16131g;
        }

        public RichText getPanell2C3() {
            return this.f16133i;
        }

        public RichText getPanell3() {
            return this.f16135k;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPanell1C1()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getPanell1C1());
            }
            int i2 = i;
            for (Resource computeMessageSize : getPanell1C2List()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            if (hasPanell2C1()) {
                i2 += CodedOutputStreamMicro.computeStringSize(3, getPanell2C1());
            }
            if (hasPanell2C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(4, getPanell2C2());
            }
            if (hasPanell2C3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getPanell2C3());
            }
            if (hasPanell3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, getPanell3());
            }
            if (hasUpperleftcorner()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getUpperleftcorner());
            }
            this.f16138n = i2;
            return i2;
        }

        public Resource getUpperleftcorner() {
            return this.f16137m;
        }

        public boolean hasPanell1C1() {
            return this.f16125a;
        }

        public boolean hasPanell2C1() {
            return this.f16128d;
        }

        public boolean hasPanell2C2() {
            return this.f16130f;
        }

        public boolean hasPanell2C3() {
            return this.f16132h;
        }

        public boolean hasPanell3() {
            return this.f16134j;
        }

        public boolean hasUpperleftcorner() {
            return this.f16136l;
        }

        public final boolean isInitialized() {
            return true;
        }

        public PanelTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro richText;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setPanell1C1(richText);
                        continue;
                    case 18:
                        richText = new Resource();
                        codedInputStreamMicro.readMessage(richText);
                        addPanell1C2(richText);
                        continue;
                    case 26:
                        setPanell2C1(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setPanell2C2(richText);
                        continue;
                    case 42:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setPanell2C3(richText);
                        continue;
                    case 50:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setPanell3(richText);
                        continue;
                    case 58:
                        richText = new Resource();
                        codedInputStreamMicro.readMessage(richText);
                        setUpperleftcorner(richText);
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

        public PanelTemplate setPanell1C1(RichText richText) {
            if (richText == null) {
                return clearPanell1C1();
            }
            this.f16125a = true;
            this.f16126b = richText;
            return this;
        }

        public PanelTemplate setPanell1C2(int i, Resource resource) {
            if (resource != null) {
                this.f16127c.set(i, resource);
            }
            return this;
        }

        public PanelTemplate setPanell2C1(String str) {
            this.f16128d = true;
            this.f16129e = str;
            return this;
        }

        public PanelTemplate setPanell2C2(RichText richText) {
            if (richText == null) {
                return clearPanell2C2();
            }
            this.f16130f = true;
            this.f16131g = richText;
            return this;
        }

        public PanelTemplate setPanell2C3(RichText richText) {
            if (richText == null) {
                return clearPanell2C3();
            }
            this.f16132h = true;
            this.f16133i = richText;
            return this;
        }

        public PanelTemplate setPanell3(RichText richText) {
            if (richText == null) {
                return clearPanell3();
            }
            this.f16134j = true;
            this.f16135k = richText;
            return this;
        }

        public PanelTemplate setUpperleftcorner(Resource resource) {
            if (resource == null) {
                return clearUpperleftcorner();
            }
            this.f16136l = true;
            this.f16137m = resource;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPanell1C1()) {
                codedOutputStreamMicro.writeMessage(1, getPanell1C1());
            }
            for (Resource writeMessage : getPanell1C2List()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasPanell2C1()) {
                codedOutputStreamMicro.writeString(3, getPanell2C1());
            }
            if (hasPanell2C2()) {
                codedOutputStreamMicro.writeMessage(4, getPanell2C2());
            }
            if (hasPanell2C3()) {
                codedOutputStreamMicro.writeMessage(5, getPanell2C3());
            }
            if (hasPanell3()) {
                codedOutputStreamMicro.writeMessage(6, getPanell3());
            }
            if (hasUpperleftcorner()) {
                codedOutputStreamMicro.writeMessage(7, getUpperleftcorner());
            }
        }
    }

    public static final class Resource extends MessageMicro {
        public static final int RESOURCE_ID_FIELD_NUMBER = 1;
        public static final int RESOURCE_URL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16139a;
        /* renamed from: b */
        private int f16140b = 0;
        /* renamed from: c */
        private boolean f16141c;
        /* renamed from: d */
        private String f16142d = "";
        /* renamed from: e */
        private int f16143e = -1;

        public static Resource parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Resource().mergeFrom(codedInputStreamMicro);
        }

        public static Resource parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Resource) new Resource().mergeFrom(bArr);
        }

        public final Resource clear() {
            clearResourceId();
            clearResourceUrl();
            this.f16143e = -1;
            return this;
        }

        public Resource clearResourceId() {
            this.f16139a = false;
            this.f16140b = 0;
            return this;
        }

        public Resource clearResourceUrl() {
            this.f16141c = false;
            this.f16142d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16143e < 0) {
                getSerializedSize();
            }
            return this.f16143e;
        }

        public int getResourceId() {
            return this.f16140b;
        }

        public String getResourceUrl() {
            return this.f16142d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasResourceId()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getResourceId());
            }
            if (hasResourceUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getResourceUrl());
            }
            this.f16143e = i;
            return i;
        }

        public boolean hasResourceId() {
            return this.f16139a;
        }

        public boolean hasResourceUrl() {
            return this.f16141c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Resource mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setResourceId(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setResourceUrl(codedInputStreamMicro.readString());
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

        public Resource setResourceId(int i) {
            this.f16139a = true;
            this.f16140b = i;
            return this;
        }

        public Resource setResourceUrl(String str) {
            this.f16141c = true;
            this.f16142d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasResourceId()) {
                codedOutputStreamMicro.writeInt32(1, getResourceId());
            }
            if (hasResourceUrl()) {
                codedOutputStreamMicro.writeString(2, getResourceUrl());
            }
        }
    }

    public static final class RichText extends MessageMicro {
        public static final int ORI_VALUE_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16144a;
        /* renamed from: b */
        private int f16145b = 0;
        /* renamed from: c */
        private boolean f16146c;
        /* renamed from: d */
        private String f16147d = "";
        /* renamed from: e */
        private int f16148e = -1;

        public static RichText parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new RichText().mergeFrom(codedInputStreamMicro);
        }

        public static RichText parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (RichText) new RichText().mergeFrom(bArr);
        }

        public final RichText clear() {
            clearOriValue();
            clearValue();
            this.f16148e = -1;
            return this;
        }

        public RichText clearOriValue() {
            this.f16144a = false;
            this.f16145b = 0;
            return this;
        }

        public RichText clearValue() {
            this.f16146c = false;
            this.f16147d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16148e < 0) {
                getSerializedSize();
            }
            return this.f16148e;
        }

        public int getOriValue() {
            return this.f16145b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasOriValue()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getOriValue());
            }
            if (hasValue()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getValue());
            }
            this.f16148e = i;
            return i;
        }

        public String getValue() {
            return this.f16147d;
        }

        public boolean hasOriValue() {
            return this.f16144a;
        }

        public boolean hasValue() {
            return this.f16146c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public RichText mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setOriValue(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setValue(codedInputStreamMicro.readString());
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

        public RichText setOriValue(int i) {
            this.f16144a = true;
            this.f16145b = i;
            return this;
        }

        public RichText setValue(String str) {
            this.f16146c = true;
            this.f16147d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasOriValue()) {
                codedOutputStreamMicro.writeInt32(1, getOriValue());
            }
            if (hasValue()) {
                codedOutputStreamMicro.writeString(2, getValue());
            }
        }
    }

    public static final class ScatterStyle extends MessageMicro {
        public static final int COLOR_VALUE_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16149a;
        /* renamed from: b */
        private int f16150b = 0;
        /* renamed from: c */
        private boolean f16151c;
        /* renamed from: d */
        private String f16152d = "";
        /* renamed from: e */
        private int f16153e = -1;

        public static ScatterStyle parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ScatterStyle().mergeFrom(codedInputStreamMicro);
        }

        public static ScatterStyle parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ScatterStyle) new ScatterStyle().mergeFrom(bArr);
        }

        public final ScatterStyle clear() {
            clearColorValue();
            clearValue();
            this.f16153e = -1;
            return this;
        }

        public ScatterStyle clearColorValue() {
            this.f16149a = false;
            this.f16150b = 0;
            return this;
        }

        public ScatterStyle clearValue() {
            this.f16151c = false;
            this.f16152d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16153e < 0) {
                getSerializedSize();
            }
            return this.f16153e;
        }

        public int getColorValue() {
            return this.f16150b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasColorValue()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getColorValue());
            }
            if (hasValue()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getValue());
            }
            this.f16153e = i;
            return i;
        }

        public String getValue() {
            return this.f16152d;
        }

        public boolean hasColorValue() {
            return this.f16149a;
        }

        public boolean hasValue() {
            return this.f16151c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ScatterStyle mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setColorValue(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setValue(codedInputStreamMicro.readString());
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

        public ScatterStyle setColorValue(int i) {
            this.f16149a = true;
            this.f16150b = i;
            return this;
        }

        public ScatterStyle setValue(String str) {
            this.f16151c = true;
            this.f16152d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasColorValue()) {
                codedOutputStreamMicro.writeInt32(1, getColorValue());
            }
            if (hasValue()) {
                codedOutputStreamMicro.writeString(2, getValue());
            }
        }
    }

    public static final class Score extends MessageMicro {
        public static final int TEXT_FIELD_NUMBER = 2;
        public static final int VAL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16154a;
        /* renamed from: b */
        private float f16155b = 0.0f;
        /* renamed from: c */
        private boolean f16156c;
        /* renamed from: d */
        private RichText f16157d = null;
        /* renamed from: e */
        private int f16158e = -1;

        public static Score parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Score().mergeFrom(codedInputStreamMicro);
        }

        public static Score parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Score) new Score().mergeFrom(bArr);
        }

        public final Score clear() {
            clearVal();
            clearText();
            this.f16158e = -1;
            return this;
        }

        public Score clearText() {
            this.f16156c = false;
            this.f16157d = null;
            return this;
        }

        public Score clearVal() {
            this.f16154a = false;
            this.f16155b = 0.0f;
            return this;
        }

        public int getCachedSize() {
            if (this.f16158e < 0) {
                getSerializedSize();
            }
            return this.f16158e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasVal()) {
                i = 0 + CodedOutputStreamMicro.computeFloatSize(1, getVal());
            }
            if (hasText()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getText());
            }
            this.f16158e = i;
            return i;
        }

        public RichText getText() {
            return this.f16157d;
        }

        public float getVal() {
            return this.f16155b;
        }

        public boolean hasText() {
            return this.f16156c;
        }

        public boolean hasVal() {
            return this.f16154a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Score mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 13:
                        setVal(codedInputStreamMicro.readFloat());
                        continue;
                    case 18:
                        MessageMicro richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setText(richText);
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

        public Score setText(RichText richText) {
            if (richText == null) {
                return clearText();
            }
            this.f16156c = true;
            this.f16157d = richText;
            return this;
        }

        public Score setVal(float f) {
            this.f16154a = true;
            this.f16155b = f;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasVal()) {
                codedOutputStreamMicro.writeFloat(1, getVal());
            }
            if (hasText()) {
                codedOutputStreamMicro.writeMessage(2, getText());
            }
        }
    }

    public static final class SingleCardTemplate extends MessageMicro {
        public static final int L1C1_FIELD_NUMBER = 1;
        public static final int L2C1_FIELD_NUMBER = 2;
        public static final int L2C2_FIELD_NUMBER = 3;
        public static final int L3C1_FIELD_NUMBER = 4;
        public static final int L3C2_FIELD_NUMBER = 5;
        public static final int L3C3_FIELD_NUMBER = 6;
        public static final int L4C1_FIELD_NUMBER = 7;
        public static final int L4C2_FIELD_NUMBER = 8;
        public static final int L5_FIELD_NUMBER = 9;
        public static final int L6_FIELD_NUMBER = 10;
        /* renamed from: a */
        private boolean f16159a;
        /* renamed from: b */
        private RichText f16160b = null;
        /* renamed from: c */
        private boolean f16161c;
        /* renamed from: d */
        private RichText f16162d = null;
        /* renamed from: e */
        private List<ScatterStyle> f16163e = Collections.emptyList();
        /* renamed from: f */
        private boolean f16164f;
        /* renamed from: g */
        private Score f16165g = null;
        /* renamed from: h */
        private boolean f16166h;
        /* renamed from: i */
        private RichText f16167i = null;
        /* renamed from: j */
        private List<ScatterStyle> f16168j = Collections.emptyList();
        /* renamed from: k */
        private boolean f16169k;
        /* renamed from: l */
        private RichText f16170l = null;
        /* renamed from: m */
        private List<ComboBox> f16171m = Collections.emptyList();
        /* renamed from: n */
        private List<ChildrenBtn> f16172n = Collections.emptyList();
        /* renamed from: o */
        private boolean f16173o;
        /* renamed from: p */
        private ComboBox f16174p = null;
        /* renamed from: q */
        private int f16175q = -1;

        public static SingleCardTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SingleCardTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static SingleCardTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SingleCardTemplate) new SingleCardTemplate().mergeFrom(bArr);
        }

        public SingleCardTemplate addL2C2(ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                if (this.f16163e.isEmpty()) {
                    this.f16163e = new ArrayList();
                }
                this.f16163e.add(scatterStyle);
            }
            return this;
        }

        public SingleCardTemplate addL3C3(ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                if (this.f16168j.isEmpty()) {
                    this.f16168j = new ArrayList();
                }
                this.f16168j.add(scatterStyle);
            }
            return this;
        }

        public SingleCardTemplate addL4C2(ComboBox comboBox) {
            if (comboBox != null) {
                if (this.f16171m.isEmpty()) {
                    this.f16171m = new ArrayList();
                }
                this.f16171m.add(comboBox);
            }
            return this;
        }

        public SingleCardTemplate addL5(ChildrenBtn childrenBtn) {
            if (childrenBtn != null) {
                if (this.f16172n.isEmpty()) {
                    this.f16172n = new ArrayList();
                }
                this.f16172n.add(childrenBtn);
            }
            return this;
        }

        public final SingleCardTemplate clear() {
            clearL1C1();
            clearL2C1();
            clearL2C2();
            clearL3C1();
            clearL3C2();
            clearL3C3();
            clearL4C1();
            clearL4C2();
            clearL5();
            clearL6();
            this.f16175q = -1;
            return this;
        }

        public SingleCardTemplate clearL1C1() {
            this.f16159a = false;
            this.f16160b = null;
            return this;
        }

        public SingleCardTemplate clearL2C1() {
            this.f16161c = false;
            this.f16162d = null;
            return this;
        }

        public SingleCardTemplate clearL2C2() {
            this.f16163e = Collections.emptyList();
            return this;
        }

        public SingleCardTemplate clearL3C1() {
            this.f16164f = false;
            this.f16165g = null;
            return this;
        }

        public SingleCardTemplate clearL3C2() {
            this.f16166h = false;
            this.f16167i = null;
            return this;
        }

        public SingleCardTemplate clearL3C3() {
            this.f16168j = Collections.emptyList();
            return this;
        }

        public SingleCardTemplate clearL4C1() {
            this.f16169k = false;
            this.f16170l = null;
            return this;
        }

        public SingleCardTemplate clearL4C2() {
            this.f16171m = Collections.emptyList();
            return this;
        }

        public SingleCardTemplate clearL5() {
            this.f16172n = Collections.emptyList();
            return this;
        }

        public SingleCardTemplate clearL6() {
            this.f16173o = false;
            this.f16174p = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f16175q < 0) {
                getSerializedSize();
            }
            return this.f16175q;
        }

        public RichText getL1C1() {
            return this.f16160b;
        }

        public RichText getL2C1() {
            return this.f16162d;
        }

        public ScatterStyle getL2C2(int i) {
            return (ScatterStyle) this.f16163e.get(i);
        }

        public int getL2C2Count() {
            return this.f16163e.size();
        }

        public List<ScatterStyle> getL2C2List() {
            return this.f16163e;
        }

        public Score getL3C1() {
            return this.f16165g;
        }

        public RichText getL3C2() {
            return this.f16167i;
        }

        public ScatterStyle getL3C3(int i) {
            return (ScatterStyle) this.f16168j.get(i);
        }

        public int getL3C3Count() {
            return this.f16168j.size();
        }

        public List<ScatterStyle> getL3C3List() {
            return this.f16168j;
        }

        public RichText getL4C1() {
            return this.f16170l;
        }

        public ComboBox getL4C2(int i) {
            return (ComboBox) this.f16171m.get(i);
        }

        public int getL4C2Count() {
            return this.f16171m.size();
        }

        public List<ComboBox> getL4C2List() {
            return this.f16171m;
        }

        public ChildrenBtn getL5(int i) {
            return (ChildrenBtn) this.f16172n.get(i);
        }

        public int getL5Count() {
            return this.f16172n.size();
        }

        public List<ChildrenBtn> getL5List() {
            return this.f16172n;
        }

        public ComboBox getL6() {
            return this.f16174p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasL1C1()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getL1C1());
            }
            if (hasL2C1()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getL2C1());
            }
            int i2 = i;
            for (ScatterStyle computeMessageSize : getL2C2List()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
            }
            if (hasL3C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(4, getL3C1());
            }
            if (hasL3C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getL3C2());
            }
            for (ScatterStyle computeMessageSize2 : getL3C3List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize2);
            }
            if (hasL4C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getL4C1());
            }
            for (ComboBox computeMessageSize3 : getL4C2List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize3);
            }
            for (ChildrenBtn computeMessageSize4 : getL5List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, computeMessageSize4);
            }
            if (hasL6()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, getL6());
            }
            this.f16175q = i2;
            return i2;
        }

        public boolean hasL1C1() {
            return this.f16159a;
        }

        public boolean hasL2C1() {
            return this.f16161c;
        }

        public boolean hasL3C1() {
            return this.f16164f;
        }

        public boolean hasL3C2() {
            return this.f16166h;
        }

        public boolean hasL4C1() {
            return this.f16169k;
        }

        public boolean hasL6() {
            return this.f16173o;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SingleCardTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro richText;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setL1C1(richText);
                        continue;
                    case 18:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setL2C1(richText);
                        continue;
                    case 26:
                        richText = new ScatterStyle();
                        codedInputStreamMicro.readMessage(richText);
                        addL2C2(richText);
                        continue;
                    case 34:
                        richText = new Score();
                        codedInputStreamMicro.readMessage(richText);
                        setL3C1(richText);
                        continue;
                    case 42:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setL3C2(richText);
                        continue;
                    case 50:
                        richText = new ScatterStyle();
                        codedInputStreamMicro.readMessage(richText);
                        addL3C3(richText);
                        continue;
                    case 58:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setL4C1(richText);
                        continue;
                    case 66:
                        richText = new ComboBox();
                        codedInputStreamMicro.readMessage(richText);
                        addL4C2(richText);
                        continue;
                    case 74:
                        richText = new ChildrenBtn();
                        codedInputStreamMicro.readMessage(richText);
                        addL5(richText);
                        continue;
                    case 82:
                        richText = new ComboBox();
                        codedInputStreamMicro.readMessage(richText);
                        setL6(richText);
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

        public SingleCardTemplate setL1C1(RichText richText) {
            if (richText == null) {
                return clearL1C1();
            }
            this.f16159a = true;
            this.f16160b = richText;
            return this;
        }

        public SingleCardTemplate setL2C1(RichText richText) {
            if (richText == null) {
                return clearL2C1();
            }
            this.f16161c = true;
            this.f16162d = richText;
            return this;
        }

        public SingleCardTemplate setL2C2(int i, ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                this.f16163e.set(i, scatterStyle);
            }
            return this;
        }

        public SingleCardTemplate setL3C1(Score score) {
            if (score == null) {
                return clearL3C1();
            }
            this.f16164f = true;
            this.f16165g = score;
            return this;
        }

        public SingleCardTemplate setL3C2(RichText richText) {
            if (richText == null) {
                return clearL3C2();
            }
            this.f16166h = true;
            this.f16167i = richText;
            return this;
        }

        public SingleCardTemplate setL3C3(int i, ScatterStyle scatterStyle) {
            if (scatterStyle != null) {
                this.f16168j.set(i, scatterStyle);
            }
            return this;
        }

        public SingleCardTemplate setL4C1(RichText richText) {
            if (richText == null) {
                return clearL4C1();
            }
            this.f16169k = true;
            this.f16170l = richText;
            return this;
        }

        public SingleCardTemplate setL4C2(int i, ComboBox comboBox) {
            if (comboBox != null) {
                this.f16171m.set(i, comboBox);
            }
            return this;
        }

        public SingleCardTemplate setL5(int i, ChildrenBtn childrenBtn) {
            if (childrenBtn != null) {
                this.f16172n.set(i, childrenBtn);
            }
            return this;
        }

        public SingleCardTemplate setL6(ComboBox comboBox) {
            if (comboBox == null) {
                return clearL6();
            }
            this.f16173o = true;
            this.f16174p = comboBox;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasL1C1()) {
                codedOutputStreamMicro.writeMessage(1, getL1C1());
            }
            if (hasL2C1()) {
                codedOutputStreamMicro.writeMessage(2, getL2C1());
            }
            for (ScatterStyle writeMessage : getL2C2List()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
            if (hasL3C1()) {
                codedOutputStreamMicro.writeMessage(4, getL3C1());
            }
            if (hasL3C2()) {
                codedOutputStreamMicro.writeMessage(5, getL3C2());
            }
            for (ScatterStyle writeMessage2 : getL3C3List()) {
                codedOutputStreamMicro.writeMessage(6, writeMessage2);
            }
            if (hasL4C1()) {
                codedOutputStreamMicro.writeMessage(7, getL4C1());
            }
            for (ComboBox writeMessage3 : getL4C2List()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage3);
            }
            for (ChildrenBtn writeMessage4 : getL5List()) {
                codedOutputStreamMicro.writeMessage(9, writeMessage4);
            }
            if (hasL6()) {
                codedOutputStreamMicro.writeMessage(10, getL6());
            }
        }
    }

    public static final class VcomboText extends MessageMicro {
        public static final int ORI_FIELD_NUMBER = 1;
        public static final int VAL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16176a;
        /* renamed from: b */
        private RichText f16177b = null;
        /* renamed from: c */
        private boolean f16178c;
        /* renamed from: d */
        private RichText f16179d = null;
        /* renamed from: e */
        private int f16180e = -1;

        public static VcomboText parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new VcomboText().mergeFrom(codedInputStreamMicro);
        }

        public static VcomboText parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (VcomboText) new VcomboText().mergeFrom(bArr);
        }

        public final VcomboText clear() {
            clearOri();
            clearVal();
            this.f16180e = -1;
            return this;
        }

        public VcomboText clearOri() {
            this.f16176a = false;
            this.f16177b = null;
            return this;
        }

        public VcomboText clearVal() {
            this.f16178c = false;
            this.f16179d = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f16180e < 0) {
                getSerializedSize();
            }
            return this.f16180e;
        }

        public RichText getOri() {
            return this.f16177b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasOri()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOri());
            }
            if (hasVal()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getVal());
            }
            this.f16180e = i;
            return i;
        }

        public RichText getVal() {
            return this.f16179d;
        }

        public boolean hasOri() {
            return this.f16176a;
        }

        public boolean hasVal() {
            return this.f16178c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public VcomboText mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro richText;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setOri(richText);
                        continue;
                    case 18:
                        richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setVal(richText);
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

        public VcomboText setOri(RichText richText) {
            if (richText == null) {
                return clearOri();
            }
            this.f16176a = true;
            this.f16177b = richText;
            return this;
        }

        public VcomboText setVal(RichText richText) {
            if (richText == null) {
                return clearVal();
            }
            this.f16178c = true;
            this.f16179d = richText;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasOri()) {
                codedOutputStreamMicro.writeMessage(1, getOri());
            }
            if (hasVal()) {
                codedOutputStreamMicro.writeMessage(2, getVal());
            }
        }
    }

    public static final class Vgray extends MessageMicro {
        public static final int LONG = 2;
        public static final int SHORT = 1;
        public static final int STYLE_FIELD_NUMBER = 2;
        public static final int TEXT_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16181a;
        /* renamed from: b */
        private RichText f16182b = null;
        /* renamed from: c */
        private boolean f16183c;
        /* renamed from: d */
        private int f16184d = 1;
        /* renamed from: e */
        private int f16185e = -1;

        public static Vgray parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Vgray().mergeFrom(codedInputStreamMicro);
        }

        public static Vgray parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Vgray) new Vgray().mergeFrom(bArr);
        }

        public final Vgray clear() {
            clearText();
            clearStyle();
            this.f16185e = -1;
            return this;
        }

        public Vgray clearStyle() {
            this.f16183c = false;
            this.f16184d = 1;
            return this;
        }

        public Vgray clearText() {
            this.f16181a = false;
            this.f16182b = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f16185e < 0) {
                getSerializedSize();
            }
            return this.f16185e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasText()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getText());
            }
            if (hasStyle()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getStyle());
            }
            this.f16185e = i;
            return i;
        }

        public int getStyle() {
            return this.f16184d;
        }

        public RichText getText() {
            return this.f16182b;
        }

        public boolean hasStyle() {
            return this.f16183c;
        }

        public boolean hasText() {
            return this.f16181a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Vgray mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro richText = new RichText();
                        codedInputStreamMicro.readMessage(richText);
                        setText(richText);
                        continue;
                    case 16:
                        setStyle(codedInputStreamMicro.readInt32());
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

        public Vgray setStyle(int i) {
            this.f16183c = true;
            this.f16184d = i;
            return this;
        }

        public Vgray setText(RichText richText) {
            if (richText == null) {
                return clearText();
            }
            this.f16181a = true;
            this.f16182b = richText;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasText()) {
                codedOutputStreamMicro.writeMessage(1, getText());
            }
            if (hasStyle()) {
                codedOutputStreamMicro.writeInt32(2, getStyle());
            }
        }
    }

    public static final class Vmagicbox extends MessageMicro {
        public static final int RES_FIELD_NUMBER = 1;
        public static final int TEXT_FIELD_NUMBER = 2;
        /* renamed from: a */
        private List<Resource> f16186a = Collections.emptyList();
        /* renamed from: b */
        private boolean f16187b;
        /* renamed from: c */
        private RichText f16188c = null;
        /* renamed from: d */
        private int f16189d = -1;

        public static Vmagicbox parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Vmagicbox().mergeFrom(codedInputStreamMicro);
        }

        public static Vmagicbox parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Vmagicbox) new Vmagicbox().mergeFrom(bArr);
        }

        public Vmagicbox addRes(Resource resource) {
            if (resource != null) {
                if (this.f16186a.isEmpty()) {
                    this.f16186a = new ArrayList();
                }
                this.f16186a.add(resource);
            }
            return this;
        }

        public final Vmagicbox clear() {
            clearRes();
            clearText();
            this.f16189d = -1;
            return this;
        }

        public Vmagicbox clearRes() {
            this.f16186a = Collections.emptyList();
            return this;
        }

        public Vmagicbox clearText() {
            this.f16187b = false;
            this.f16188c = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f16189d < 0) {
                getSerializedSize();
            }
            return this.f16189d;
        }

        public Resource getRes(int i) {
            return (Resource) this.f16186a.get(i);
        }

        public int getResCount() {
            return this.f16186a.size();
        }

        public List<Resource> getResList() {
            return this.f16186a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Resource computeMessageSize : getResList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            if (hasText()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getText());
            }
            this.f16189d = i;
            return i;
        }

        public RichText getText() {
            return this.f16188c;
        }

        public boolean hasText() {
            return this.f16187b;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Vmagicbox mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro resource;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        resource = new Resource();
                        codedInputStreamMicro.readMessage(resource);
                        addRes(resource);
                        continue;
                    case 18:
                        resource = new RichText();
                        codedInputStreamMicro.readMessage(resource);
                        setText(resource);
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

        public Vmagicbox setRes(int i, Resource resource) {
            if (resource != null) {
                this.f16186a.set(i, resource);
            }
            return this;
        }

        public Vmagicbox setText(RichText richText) {
            if (richText == null) {
                return clearText();
            }
            this.f16187b = true;
            this.f16188c = richText;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Resource writeMessage : getResList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            if (hasText()) {
                codedOutputStreamMicro.writeMessage(2, getText());
            }
        }
    }

    public static final class VtableTemplate extends MessageMicro {
        public static final int R1C1_FIELD_NUMBER = 1;
        public static final int R1C2_FIELD_NUMBER = 2;
        public static final int R1C3_FIELD_NUMBER = 3;
        public static final int R2C1_FIELD_NUMBER = 4;
        public static final int R3C1_FIELD_NUMBER = 5;
        public static final int R3C2_FIELD_NUMBER = 6;
        public static final int R3C3_FIELD_NUMBER = 7;
        public static final int R4C1_FIELD_NUMBER = 8;
        public static final int R4C2_FIELD_NUMBER = 9;
        public static final int R5C1_FIELD_NUMBER = 10;
        public static final int R6C1_FIELD_NUMBER = 11;
        public static final int R7C1_FIELD_NUMBER = 12;
        public static final int R8C1_FIELD_NUMBER = 13;
        public static final int UPPERLEFTCORNER_FIELD_NUMBER = 14;
        /* renamed from: A */
        private int f16190A = -1;
        /* renamed from: a */
        private boolean f16191a;
        /* renamed from: b */
        private Image f16192b = null;
        /* renamed from: c */
        private boolean f16193c;
        /* renamed from: d */
        private RichText f16194d = null;
        /* renamed from: e */
        private List<Resource> f16195e = Collections.emptyList();
        /* renamed from: f */
        private boolean f16196f;
        /* renamed from: g */
        private RichText f16197g = null;
        /* renamed from: h */
        private boolean f16198h;
        /* renamed from: i */
        private Score f16199i = null;
        /* renamed from: j */
        private boolean f16200j;
        /* renamed from: k */
        private Vmagicbox f16201k = null;
        /* renamed from: l */
        private boolean f16202l;
        /* renamed from: m */
        private VcomboText f16203m = null;
        /* renamed from: n */
        private boolean f16204n;
        /* renamed from: o */
        private RichText f16205o = null;
        /* renamed from: p */
        private boolean f16206p;
        /* renamed from: q */
        private RichText f16207q = null;
        /* renamed from: r */
        private List<RichText> f16208r = Collections.emptyList();
        /* renamed from: s */
        private boolean f16209s;
        /* renamed from: t */
        private Vgray f16210t = null;
        /* renamed from: u */
        private boolean f16211u;
        /* renamed from: v */
        private Fatherson f16212v = null;
        /* renamed from: w */
        private boolean f16213w;
        /* renamed from: x */
        private Composit f16214x = null;
        /* renamed from: y */
        private boolean f16215y;
        /* renamed from: z */
        private Resource f16216z = null;

        public static VtableTemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new VtableTemplate().mergeFrom(codedInputStreamMicro);
        }

        public static VtableTemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (VtableTemplate) new VtableTemplate().mergeFrom(bArr);
        }

        public VtableTemplate addR1C3(Resource resource) {
            if (resource != null) {
                if (this.f16195e.isEmpty()) {
                    this.f16195e = new ArrayList();
                }
                this.f16195e.add(resource);
            }
            return this;
        }

        public VtableTemplate addR5C1(RichText richText) {
            if (richText != null) {
                if (this.f16208r.isEmpty()) {
                    this.f16208r = new ArrayList();
                }
                this.f16208r.add(richText);
            }
            return this;
        }

        public final VtableTemplate clear() {
            clearR1C1();
            clearR1C2();
            clearR1C3();
            clearR2C1();
            clearR3C1();
            clearR3C2();
            clearR3C3();
            clearR4C1();
            clearR4C2();
            clearR5C1();
            clearR6C1();
            clearR7C1();
            clearR8C1();
            clearUpperleftcorner();
            this.f16190A = -1;
            return this;
        }

        public VtableTemplate clearR1C1() {
            this.f16191a = false;
            this.f16192b = null;
            return this;
        }

        public VtableTemplate clearR1C2() {
            this.f16193c = false;
            this.f16194d = null;
            return this;
        }

        public VtableTemplate clearR1C3() {
            this.f16195e = Collections.emptyList();
            return this;
        }

        public VtableTemplate clearR2C1() {
            this.f16196f = false;
            this.f16197g = null;
            return this;
        }

        public VtableTemplate clearR3C1() {
            this.f16198h = false;
            this.f16199i = null;
            return this;
        }

        public VtableTemplate clearR3C2() {
            this.f16200j = false;
            this.f16201k = null;
            return this;
        }

        public VtableTemplate clearR3C3() {
            this.f16202l = false;
            this.f16203m = null;
            return this;
        }

        public VtableTemplate clearR4C1() {
            this.f16204n = false;
            this.f16205o = null;
            return this;
        }

        public VtableTemplate clearR4C2() {
            this.f16206p = false;
            this.f16207q = null;
            return this;
        }

        public VtableTemplate clearR5C1() {
            this.f16208r = Collections.emptyList();
            return this;
        }

        public VtableTemplate clearR6C1() {
            this.f16209s = false;
            this.f16210t = null;
            return this;
        }

        public VtableTemplate clearR7C1() {
            this.f16211u = false;
            this.f16212v = null;
            return this;
        }

        public VtableTemplate clearR8C1() {
            this.f16213w = false;
            this.f16214x = null;
            return this;
        }

        public VtableTemplate clearUpperleftcorner() {
            this.f16215y = false;
            this.f16216z = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f16190A < 0) {
                getSerializedSize();
            }
            return this.f16190A;
        }

        public Image getR1C1() {
            return this.f16192b;
        }

        public RichText getR1C2() {
            return this.f16194d;
        }

        public Resource getR1C3(int i) {
            return (Resource) this.f16195e.get(i);
        }

        public int getR1C3Count() {
            return this.f16195e.size();
        }

        public List<Resource> getR1C3List() {
            return this.f16195e;
        }

        public RichText getR2C1() {
            return this.f16197g;
        }

        public Score getR3C1() {
            return this.f16199i;
        }

        public Vmagicbox getR3C2() {
            return this.f16201k;
        }

        public VcomboText getR3C3() {
            return this.f16203m;
        }

        public RichText getR4C1() {
            return this.f16205o;
        }

        public RichText getR4C2() {
            return this.f16207q;
        }

        public RichText getR5C1(int i) {
            return (RichText) this.f16208r.get(i);
        }

        public int getR5C1Count() {
            return this.f16208r.size();
        }

        public List<RichText> getR5C1List() {
            return this.f16208r;
        }

        public Vgray getR6C1() {
            return this.f16210t;
        }

        public Fatherson getR7C1() {
            return this.f16212v;
        }

        public Composit getR8C1() {
            return this.f16214x;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasR1C1()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getR1C1());
            }
            if (hasR1C2()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getR1C2());
            }
            int i2 = i;
            for (Resource computeMessageSize : getR1C3List()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
            }
            if (hasR2C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(4, getR2C1());
            }
            if (hasR3C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getR3C1());
            }
            if (hasR3C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, getR3C2());
            }
            if (hasR3C3()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getR3C3());
            }
            if (hasR4C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, getR4C1());
            }
            if (hasR4C2()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, getR4C2());
            }
            for (RichText computeMessageSize2 : getR5C1List()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, computeMessageSize2);
            }
            if (hasR6C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(11, getR6C1());
            }
            if (hasR7C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(12, getR7C1());
            }
            if (hasR8C1()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(13, getR8C1());
            }
            if (hasUpperleftcorner()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(14, getUpperleftcorner());
            }
            this.f16190A = i2;
            return i2;
        }

        public Resource getUpperleftcorner() {
            return this.f16216z;
        }

        public boolean hasR1C1() {
            return this.f16191a;
        }

        public boolean hasR1C2() {
            return this.f16193c;
        }

        public boolean hasR2C1() {
            return this.f16196f;
        }

        public boolean hasR3C1() {
            return this.f16198h;
        }

        public boolean hasR3C2() {
            return this.f16200j;
        }

        public boolean hasR3C3() {
            return this.f16202l;
        }

        public boolean hasR4C1() {
            return this.f16204n;
        }

        public boolean hasR4C2() {
            return this.f16206p;
        }

        public boolean hasR6C1() {
            return this.f16209s;
        }

        public boolean hasR7C1() {
            return this.f16211u;
        }

        public boolean hasR8C1() {
            return this.f16213w;
        }

        public boolean hasUpperleftcorner() {
            return this.f16215y;
        }

        public final boolean isInitialized() {
            return true;
        }

        public VtableTemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro image;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        image = new Image();
                        codedInputStreamMicro.readMessage(image);
                        setR1C1(image);
                        continue;
                    case 18:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setR1C2(image);
                        continue;
                    case 26:
                        image = new Resource();
                        codedInputStreamMicro.readMessage(image);
                        addR1C3(image);
                        continue;
                    case 34:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setR2C1(image);
                        continue;
                    case 42:
                        image = new Score();
                        codedInputStreamMicro.readMessage(image);
                        setR3C1(image);
                        continue;
                    case 50:
                        image = new Vmagicbox();
                        codedInputStreamMicro.readMessage(image);
                        setR3C2(image);
                        continue;
                    case 58:
                        image = new VcomboText();
                        codedInputStreamMicro.readMessage(image);
                        setR3C3(image);
                        continue;
                    case 66:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setR4C1(image);
                        continue;
                    case 74:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        setR4C2(image);
                        continue;
                    case 82:
                        image = new RichText();
                        codedInputStreamMicro.readMessage(image);
                        addR5C1(image);
                        continue;
                    case 90:
                        image = new Vgray();
                        codedInputStreamMicro.readMessage(image);
                        setR6C1(image);
                        continue;
                    case 98:
                        image = new Fatherson();
                        codedInputStreamMicro.readMessage(image);
                        setR7C1(image);
                        continue;
                    case 106:
                        image = new Composit();
                        codedInputStreamMicro.readMessage(image);
                        setR8C1(image);
                        continue;
                    case 114:
                        image = new Resource();
                        codedInputStreamMicro.readMessage(image);
                        setUpperleftcorner(image);
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

        public VtableTemplate setR1C1(Image image) {
            if (image == null) {
                return clearR1C1();
            }
            this.f16191a = true;
            this.f16192b = image;
            return this;
        }

        public VtableTemplate setR1C2(RichText richText) {
            if (richText == null) {
                return clearR1C2();
            }
            this.f16193c = true;
            this.f16194d = richText;
            return this;
        }

        public VtableTemplate setR1C3(int i, Resource resource) {
            if (resource != null) {
                this.f16195e.set(i, resource);
            }
            return this;
        }

        public VtableTemplate setR2C1(RichText richText) {
            if (richText == null) {
                return clearR2C1();
            }
            this.f16196f = true;
            this.f16197g = richText;
            return this;
        }

        public VtableTemplate setR3C1(Score score) {
            if (score == null) {
                return clearR3C1();
            }
            this.f16198h = true;
            this.f16199i = score;
            return this;
        }

        public VtableTemplate setR3C2(Vmagicbox vmagicbox) {
            if (vmagicbox == null) {
                return clearR3C2();
            }
            this.f16200j = true;
            this.f16201k = vmagicbox;
            return this;
        }

        public VtableTemplate setR3C3(VcomboText vcomboText) {
            if (vcomboText == null) {
                return clearR3C3();
            }
            this.f16202l = true;
            this.f16203m = vcomboText;
            return this;
        }

        public VtableTemplate setR4C1(RichText richText) {
            if (richText == null) {
                return clearR4C1();
            }
            this.f16204n = true;
            this.f16205o = richText;
            return this;
        }

        public VtableTemplate setR4C2(RichText richText) {
            if (richText == null) {
                return clearR4C2();
            }
            this.f16206p = true;
            this.f16207q = richText;
            return this;
        }

        public VtableTemplate setR5C1(int i, RichText richText) {
            if (richText != null) {
                this.f16208r.set(i, richText);
            }
            return this;
        }

        public VtableTemplate setR6C1(Vgray vgray) {
            if (vgray == null) {
                return clearR6C1();
            }
            this.f16209s = true;
            this.f16210t = vgray;
            return this;
        }

        public VtableTemplate setR7C1(Fatherson fatherson) {
            if (fatherson == null) {
                return clearR7C1();
            }
            this.f16211u = true;
            this.f16212v = fatherson;
            return this;
        }

        public VtableTemplate setR8C1(Composit composit) {
            if (composit == null) {
                return clearR8C1();
            }
            this.f16213w = true;
            this.f16214x = composit;
            return this;
        }

        public VtableTemplate setUpperleftcorner(Resource resource) {
            if (resource == null) {
                return clearUpperleftcorner();
            }
            this.f16215y = true;
            this.f16216z = resource;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasR1C1()) {
                codedOutputStreamMicro.writeMessage(1, getR1C1());
            }
            if (hasR1C2()) {
                codedOutputStreamMicro.writeMessage(2, getR1C2());
            }
            for (Resource writeMessage : getR1C3List()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
            if (hasR2C1()) {
                codedOutputStreamMicro.writeMessage(4, getR2C1());
            }
            if (hasR3C1()) {
                codedOutputStreamMicro.writeMessage(5, getR3C1());
            }
            if (hasR3C2()) {
                codedOutputStreamMicro.writeMessage(6, getR3C2());
            }
            if (hasR3C3()) {
                codedOutputStreamMicro.writeMessage(7, getR3C3());
            }
            if (hasR4C1()) {
                codedOutputStreamMicro.writeMessage(8, getR4C1());
            }
            if (hasR4C2()) {
                codedOutputStreamMicro.writeMessage(9, getR4C2());
            }
            for (RichText writeMessage2 : getR5C1List()) {
                codedOutputStreamMicro.writeMessage(10, writeMessage2);
            }
            if (hasR6C1()) {
                codedOutputStreamMicro.writeMessage(11, getR6C1());
            }
            if (hasR7C1()) {
                codedOutputStreamMicro.writeMessage(12, getR7C1());
            }
            if (hasR8C1()) {
                codedOutputStreamMicro.writeMessage(13, getR8C1());
            }
            if (hasUpperleftcorner()) {
                codedOutputStreamMicro.writeMessage(14, getUpperleftcorner());
            }
        }
    }

    public static Template parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Template().mergeFrom(codedInputStreamMicro);
    }

    public static Template parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Template) new Template().mergeFrom(bArr);
    }

    public final Template clear() {
        clearNormal();
        clearImage();
        clearPanel();
        clearMapsearchaladdinpanel();
        clearMapsearchaladdinnormal();
        clearVtable();
        clearBtable();
        clearSinglecard();
        clearLtable();
        this.f16235s = -1;
        return this;
    }

    public Template clearBtable() {
        this.f16229m = false;
        this.f16230n = null;
        return this;
    }

    public Template clearImage() {
        this.f16219c = false;
        this.f16220d = null;
        return this;
    }

    public Template clearLtable() {
        this.f16233q = false;
        this.f16234r = null;
        return this;
    }

    public Template clearMapsearchaladdinnormal() {
        this.f16225i = false;
        this.f16226j = null;
        return this;
    }

    public Template clearMapsearchaladdinpanel() {
        this.f16223g = false;
        this.f16224h = null;
        return this;
    }

    public Template clearNormal() {
        this.f16217a = false;
        this.f16218b = null;
        return this;
    }

    public Template clearPanel() {
        this.f16221e = false;
        this.f16222f = null;
        return this;
    }

    public Template clearSinglecard() {
        this.f16231o = false;
        this.f16232p = null;
        return this;
    }

    public Template clearVtable() {
        this.f16227k = false;
        this.f16228l = null;
        return this;
    }

    public BtableTemplate getBtable() {
        return this.f16230n;
    }

    public int getCachedSize() {
        if (this.f16235s < 0) {
            getSerializedSize();
        }
        return this.f16235s;
    }

    public ImageTemplate getImage() {
        return this.f16220d;
    }

    public LtableTemplate getLtable() {
        return this.f16234r;
    }

    public MapSearchaladdinNormalTemplate getMapsearchaladdinnormal() {
        return this.f16226j;
    }

    public MapSearchaladdinPanelTemplate getMapsearchaladdinpanel() {
        return this.f16224h;
    }

    public NormalTemplate getNormal() {
        return this.f16218b;
    }

    public PanelTemplate getPanel() {
        return this.f16222f;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasNormal()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getNormal());
        }
        if (hasImage()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getImage());
        }
        if (hasPanel()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getPanel());
        }
        if (hasMapsearchaladdinpanel()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, getMapsearchaladdinpanel());
        }
        if (hasMapsearchaladdinnormal()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, getMapsearchaladdinnormal());
        }
        if (hasVtable()) {
            i += CodedOutputStreamMicro.computeMessageSize(6, getVtable());
        }
        if (hasBtable()) {
            i += CodedOutputStreamMicro.computeMessageSize(7, getBtable());
        }
        if (hasSinglecard()) {
            i += CodedOutputStreamMicro.computeMessageSize(8, getSinglecard());
        }
        if (hasLtable()) {
            i += CodedOutputStreamMicro.computeMessageSize(9, getLtable());
        }
        this.f16235s = i;
        return i;
    }

    public SingleCardTemplate getSinglecard() {
        return this.f16232p;
    }

    public VtableTemplate getVtable() {
        return this.f16228l;
    }

    public boolean hasBtable() {
        return this.f16229m;
    }

    public boolean hasImage() {
        return this.f16219c;
    }

    public boolean hasLtable() {
        return this.f16233q;
    }

    public boolean hasMapsearchaladdinnormal() {
        return this.f16225i;
    }

    public boolean hasMapsearchaladdinpanel() {
        return this.f16223g;
    }

    public boolean hasNormal() {
        return this.f16217a;
    }

    public boolean hasPanel() {
        return this.f16221e;
    }

    public boolean hasSinglecard() {
        return this.f16231o;
    }

    public boolean hasVtable() {
        return this.f16227k;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Template mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro normalTemplate;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    normalTemplate = new NormalTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setNormal(normalTemplate);
                    continue;
                case 18:
                    normalTemplate = new ImageTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setImage(normalTemplate);
                    continue;
                case 26:
                    normalTemplate = new PanelTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setPanel(normalTemplate);
                    continue;
                case 34:
                    normalTemplate = new MapSearchaladdinPanelTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setMapsearchaladdinpanel(normalTemplate);
                    continue;
                case 42:
                    normalTemplate = new MapSearchaladdinNormalTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setMapsearchaladdinnormal(normalTemplate);
                    continue;
                case 50:
                    normalTemplate = new VtableTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setVtable(normalTemplate);
                    continue;
                case 58:
                    normalTemplate = new BtableTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setBtable(normalTemplate);
                    continue;
                case 66:
                    normalTemplate = new SingleCardTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setSinglecard(normalTemplate);
                    continue;
                case 74:
                    normalTemplate = new LtableTemplate();
                    codedInputStreamMicro.readMessage(normalTemplate);
                    setLtable(normalTemplate);
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

    public Template setBtable(BtableTemplate btableTemplate) {
        if (btableTemplate == null) {
            return clearBtable();
        }
        this.f16229m = true;
        this.f16230n = btableTemplate;
        return this;
    }

    public Template setImage(ImageTemplate imageTemplate) {
        if (imageTemplate == null) {
            return clearImage();
        }
        this.f16219c = true;
        this.f16220d = imageTemplate;
        return this;
    }

    public Template setLtable(LtableTemplate ltableTemplate) {
        if (ltableTemplate == null) {
            return clearLtable();
        }
        this.f16233q = true;
        this.f16234r = ltableTemplate;
        return this;
    }

    public Template setMapsearchaladdinnormal(MapSearchaladdinNormalTemplate mapSearchaladdinNormalTemplate) {
        if (mapSearchaladdinNormalTemplate == null) {
            return clearMapsearchaladdinnormal();
        }
        this.f16225i = true;
        this.f16226j = mapSearchaladdinNormalTemplate;
        return this;
    }

    public Template setMapsearchaladdinpanel(MapSearchaladdinPanelTemplate mapSearchaladdinPanelTemplate) {
        if (mapSearchaladdinPanelTemplate == null) {
            return clearMapsearchaladdinpanel();
        }
        this.f16223g = true;
        this.f16224h = mapSearchaladdinPanelTemplate;
        return this;
    }

    public Template setNormal(NormalTemplate normalTemplate) {
        if (normalTemplate == null) {
            return clearNormal();
        }
        this.f16217a = true;
        this.f16218b = normalTemplate;
        return this;
    }

    public Template setPanel(PanelTemplate panelTemplate) {
        if (panelTemplate == null) {
            return clearPanel();
        }
        this.f16221e = true;
        this.f16222f = panelTemplate;
        return this;
    }

    public Template setSinglecard(SingleCardTemplate singleCardTemplate) {
        if (singleCardTemplate == null) {
            return clearSinglecard();
        }
        this.f16231o = true;
        this.f16232p = singleCardTemplate;
        return this;
    }

    public Template setVtable(VtableTemplate vtableTemplate) {
        if (vtableTemplate == null) {
            return clearVtable();
        }
        this.f16227k = true;
        this.f16228l = vtableTemplate;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasNormal()) {
            codedOutputStreamMicro.writeMessage(1, getNormal());
        }
        if (hasImage()) {
            codedOutputStreamMicro.writeMessage(2, getImage());
        }
        if (hasPanel()) {
            codedOutputStreamMicro.writeMessage(3, getPanel());
        }
        if (hasMapsearchaladdinpanel()) {
            codedOutputStreamMicro.writeMessage(4, getMapsearchaladdinpanel());
        }
        if (hasMapsearchaladdinnormal()) {
            codedOutputStreamMicro.writeMessage(5, getMapsearchaladdinnormal());
        }
        if (hasVtable()) {
            codedOutputStreamMicro.writeMessage(6, getVtable());
        }
        if (hasBtable()) {
            codedOutputStreamMicro.writeMessage(7, getBtable());
        }
        if (hasSinglecard()) {
            codedOutputStreamMicro.writeMessage(8, getSinglecard());
        }
        if (hasLtable()) {
            codedOutputStreamMicro.writeMessage(9, getLtable());
        }
    }
}
