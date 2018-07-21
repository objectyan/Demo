package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Template
  extends MessageMicro
{
  public static final int BTABLE_FIELD_NUMBER = 7;
  public static final int IMAGE_FIELD_NUMBER = 2;
  public static final int LTABLE_FIELD_NUMBER = 9;
  public static final int MAPSEARCHALADDINNORMAL_FIELD_NUMBER = 5;
  public static final int MAPSEARCHALADDINPANEL_FIELD_NUMBER = 4;
  public static final int NORMAL_FIELD_NUMBER = 1;
  public static final int PANEL_FIELD_NUMBER = 3;
  public static final int SINGLECARD_FIELD_NUMBER = 8;
  public static final int VTABLE_FIELD_NUMBER = 6;
  private boolean a;
  private NormalTemplate b = null;
  private boolean c;
  private ImageTemplate d = null;
  private boolean e;
  private PanelTemplate f = null;
  private boolean g;
  private MapSearchaladdinPanelTemplate h = null;
  private boolean i;
  private MapSearchaladdinNormalTemplate j = null;
  private boolean k;
  private VtableTemplate l = null;
  private boolean m;
  private BtableTemplate n = null;
  private boolean o;
  private SingleCardTemplate p = null;
  private boolean q;
  private LtableTemplate r = null;
  private int s = -1;
  
  public static Template parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Template().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Template parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Template)new Template().mergeFrom(paramArrayOfByte);
  }
  
  public final Template clear()
  {
    clearNormal();
    clearImage();
    clearPanel();
    clearMapsearchaladdinpanel();
    clearMapsearchaladdinnormal();
    clearVtable();
    clearBtable();
    clearSinglecard();
    clearLtable();
    this.s = -1;
    return this;
  }
  
  public Template clearBtable()
  {
    this.m = false;
    this.n = null;
    return this;
  }
  
  public Template clearImage()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Template clearLtable()
  {
    this.q = false;
    this.r = null;
    return this;
  }
  
  public Template clearMapsearchaladdinnormal()
  {
    this.i = false;
    this.j = null;
    return this;
  }
  
  public Template clearMapsearchaladdinpanel()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public Template clearNormal()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public Template clearPanel()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public Template clearSinglecard()
  {
    this.o = false;
    this.p = null;
    return this;
  }
  
  public Template clearVtable()
  {
    this.k = false;
    this.l = null;
    return this;
  }
  
  public BtableTemplate getBtable()
  {
    return this.n;
  }
  
  public int getCachedSize()
  {
    if (this.s < 0) {
      getSerializedSize();
    }
    return this.s;
  }
  
  public ImageTemplate getImage()
  {
    return this.d;
  }
  
  public LtableTemplate getLtable()
  {
    return this.r;
  }
  
  public MapSearchaladdinNormalTemplate getMapsearchaladdinnormal()
  {
    return this.j;
  }
  
  public MapSearchaladdinPanelTemplate getMapsearchaladdinpanel()
  {
    return this.h;
  }
  
  public NormalTemplate getNormal()
  {
    return this.b;
  }
  
  public PanelTemplate getPanel()
  {
    return this.f;
  }
  
  public int getSerializedSize()
  {
    int i2 = 0;
    if (hasNormal()) {
      i2 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getNormal());
    }
    int i1 = i2;
    if (hasImage()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(2, getImage());
    }
    i2 = i1;
    if (hasPanel()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(3, getPanel());
    }
    i1 = i2;
    if (hasMapsearchaladdinpanel()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getMapsearchaladdinpanel());
    }
    i2 = i1;
    if (hasMapsearchaladdinnormal()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getMapsearchaladdinnormal());
    }
    i1 = i2;
    if (hasVtable()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getVtable());
    }
    i2 = i1;
    if (hasBtable()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getBtable());
    }
    i1 = i2;
    if (hasSinglecard()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getSinglecard());
    }
    i2 = i1;
    if (hasLtable()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(9, getLtable());
    }
    this.s = i2;
    return i2;
  }
  
  public SingleCardTemplate getSinglecard()
  {
    return this.p;
  }
  
  public VtableTemplate getVtable()
  {
    return this.l;
  }
  
  public boolean hasBtable()
  {
    return this.m;
  }
  
  public boolean hasImage()
  {
    return this.c;
  }
  
  public boolean hasLtable()
  {
    return this.q;
  }
  
  public boolean hasMapsearchaladdinnormal()
  {
    return this.i;
  }
  
  public boolean hasMapsearchaladdinpanel()
  {
    return this.g;
  }
  
  public boolean hasNormal()
  {
    return this.a;
  }
  
  public boolean hasPanel()
  {
    return this.e;
  }
  
  public boolean hasSinglecard()
  {
    return this.o;
  }
  
  public boolean hasVtable()
  {
    return this.k;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Template mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i1 = paramCodedInputStreamMicro.readTag();
      Object localObject;
      switch (i1)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
        break;
      case 0: 
        return this;
      case 10: 
        localObject = new NormalTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setNormal((NormalTemplate)localObject);
        break;
      case 18: 
        localObject = new ImageTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setImage((ImageTemplate)localObject);
        break;
      case 26: 
        localObject = new PanelTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setPanel((PanelTemplate)localObject);
        break;
      case 34: 
        localObject = new MapSearchaladdinPanelTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setMapsearchaladdinpanel((MapSearchaladdinPanelTemplate)localObject);
        break;
      case 42: 
        localObject = new MapSearchaladdinNormalTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setMapsearchaladdinnormal((MapSearchaladdinNormalTemplate)localObject);
        break;
      case 50: 
        localObject = new VtableTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setVtable((VtableTemplate)localObject);
        break;
      case 58: 
        localObject = new BtableTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setBtable((BtableTemplate)localObject);
        break;
      case 66: 
        localObject = new SingleCardTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setSinglecard((SingleCardTemplate)localObject);
        break;
      case 74: 
        localObject = new LtableTemplate();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setLtable((LtableTemplate)localObject);
      }
    }
  }
  
  public Template setBtable(BtableTemplate paramBtableTemplate)
  {
    if (paramBtableTemplate == null) {
      return clearBtable();
    }
    this.m = true;
    this.n = paramBtableTemplate;
    return this;
  }
  
  public Template setImage(ImageTemplate paramImageTemplate)
  {
    if (paramImageTemplate == null) {
      return clearImage();
    }
    this.c = true;
    this.d = paramImageTemplate;
    return this;
  }
  
  public Template setLtable(LtableTemplate paramLtableTemplate)
  {
    if (paramLtableTemplate == null) {
      return clearLtable();
    }
    this.q = true;
    this.r = paramLtableTemplate;
    return this;
  }
  
  public Template setMapsearchaladdinnormal(MapSearchaladdinNormalTemplate paramMapSearchaladdinNormalTemplate)
  {
    if (paramMapSearchaladdinNormalTemplate == null) {
      return clearMapsearchaladdinnormal();
    }
    this.i = true;
    this.j = paramMapSearchaladdinNormalTemplate;
    return this;
  }
  
  public Template setMapsearchaladdinpanel(MapSearchaladdinPanelTemplate paramMapSearchaladdinPanelTemplate)
  {
    if (paramMapSearchaladdinPanelTemplate == null) {
      return clearMapsearchaladdinpanel();
    }
    this.g = true;
    this.h = paramMapSearchaladdinPanelTemplate;
    return this;
  }
  
  public Template setNormal(NormalTemplate paramNormalTemplate)
  {
    if (paramNormalTemplate == null) {
      return clearNormal();
    }
    this.a = true;
    this.b = paramNormalTemplate;
    return this;
  }
  
  public Template setPanel(PanelTemplate paramPanelTemplate)
  {
    if (paramPanelTemplate == null) {
      return clearPanel();
    }
    this.e = true;
    this.f = paramPanelTemplate;
    return this;
  }
  
  public Template setSinglecard(SingleCardTemplate paramSingleCardTemplate)
  {
    if (paramSingleCardTemplate == null) {
      return clearSinglecard();
    }
    this.o = true;
    this.p = paramSingleCardTemplate;
    return this;
  }
  
  public Template setVtable(VtableTemplate paramVtableTemplate)
  {
    if (paramVtableTemplate == null) {
      return clearVtable();
    }
    this.k = true;
    this.l = paramVtableTemplate;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasNormal()) {
      paramCodedOutputStreamMicro.writeMessage(1, getNormal());
    }
    if (hasImage()) {
      paramCodedOutputStreamMicro.writeMessage(2, getImage());
    }
    if (hasPanel()) {
      paramCodedOutputStreamMicro.writeMessage(3, getPanel());
    }
    if (hasMapsearchaladdinpanel()) {
      paramCodedOutputStreamMicro.writeMessage(4, getMapsearchaladdinpanel());
    }
    if (hasMapsearchaladdinnormal()) {
      paramCodedOutputStreamMicro.writeMessage(5, getMapsearchaladdinnormal());
    }
    if (hasVtable()) {
      paramCodedOutputStreamMicro.writeMessage(6, getVtable());
    }
    if (hasBtable()) {
      paramCodedOutputStreamMicro.writeMessage(7, getBtable());
    }
    if (hasSinglecard()) {
      paramCodedOutputStreamMicro.writeMessage(8, getSinglecard());
    }
    if (hasLtable()) {
      paramCodedOutputStreamMicro.writeMessage(9, getLtable());
    }
  }
  
  public static final class BtableTemplate
    extends MessageMicro
  {
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
    private boolean a;
    private Template.RichText b = null;
    private boolean c;
    private Template.RichText d = null;
    private List<Template.Button> e = Collections.emptyList();
    private boolean f;
    private Template.Score g = null;
    private boolean h;
    private Template.RichText i = null;
    private boolean j;
    private Template.RichText k = null;
    private boolean l;
    private Template.RichText m = null;
    private List<Template.RichText> n = Collections.emptyList();
    private boolean o;
    private Template.ComboBox p = null;
    private boolean q;
    private Template.Fatherson r = null;
    private boolean s;
    private Template.Composit t = null;
    private int u = -1;
    
    public static BtableTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new BtableTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static BtableTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (BtableTemplate)new BtableTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public BtableTemplate addR1C4(Template.Button paramButton)
    {
      if (paramButton == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramButton);
      return this;
    }
    
    public BtableTemplate addR4C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return this;
      }
      if (this.n.isEmpty()) {
        this.n = new ArrayList();
      }
      this.n.add(paramRichText);
      return this;
    }
    
    public final BtableTemplate clear()
    {
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
      this.u = -1;
      return this;
    }
    
    public BtableTemplate clearR1C1()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public BtableTemplate clearR1C2()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public BtableTemplate clearR1C4()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public BtableTemplate clearR2C1()
    {
      this.f = false;
      this.g = null;
      return this;
    }
    
    public BtableTemplate clearR2C2()
    {
      this.h = false;
      this.i = null;
      return this;
    }
    
    public BtableTemplate clearR3C1()
    {
      this.j = false;
      this.k = null;
      return this;
    }
    
    public BtableTemplate clearR3C2()
    {
      this.l = false;
      this.m = null;
      return this;
    }
    
    public BtableTemplate clearR4C1()
    {
      this.n = Collections.emptyList();
      return this;
    }
    
    public BtableTemplate clearR5C1()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public BtableTemplate clearR6C1()
    {
      this.q = false;
      this.r = null;
      return this;
    }
    
    public BtableTemplate clearR7C1()
    {
      this.s = false;
      this.t = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.u < 0) {
        getSerializedSize();
      }
      return this.u;
    }
    
    public Template.RichText getR1C1()
    {
      return this.b;
    }
    
    public Template.RichText getR1C2()
    {
      return this.d;
    }
    
    public Template.Button getR1C4(int paramInt)
    {
      return (Template.Button)this.e.get(paramInt);
    }
    
    public int getR1C4Count()
    {
      return this.e.size();
    }
    
    public List<Template.Button> getR1C4List()
    {
      return this.e;
    }
    
    public Template.Score getR2C1()
    {
      return this.g;
    }
    
    public Template.RichText getR2C2()
    {
      return this.i;
    }
    
    public Template.RichText getR3C1()
    {
      return this.k;
    }
    
    public Template.RichText getR3C2()
    {
      return this.m;
    }
    
    public Template.RichText getR4C1(int paramInt)
    {
      return (Template.RichText)this.n.get(paramInt);
    }
    
    public int getR4C1Count()
    {
      return this.n.size();
    }
    
    public List<Template.RichText> getR4C1List()
    {
      return this.n;
    }
    
    public Template.ComboBox getR5C1()
    {
      return this.p;
    }
    
    public Template.Fatherson getR6C1()
    {
      return this.r;
    }
    
    public Template.Composit getR7C1()
    {
      return this.t;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasR1C1()) {
        i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getR1C1());
      }
      int i2 = i1;
      if (hasR1C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(2, getR1C2());
      }
      Iterator localIterator = getR1C4List().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(3, (Template.Button)localIterator.next()) + i2;
      }
      i1 = i2;
      if (hasR2C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getR2C1());
      }
      i2 = i1;
      if (hasR2C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getR2C2());
      }
      i1 = i2;
      if (hasR3C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getR3C1());
      }
      i2 = i1;
      if (hasR3C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getR3C2());
      }
      localIterator = getR4C1List().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(8, (Template.RichText)localIterator.next());
      }
      i1 = i2;
      if (hasR5C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(9, getR5C1());
      }
      i2 = i1;
      if (hasR6C1()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(10, getR6C1());
      }
      i1 = i2;
      if (hasR7C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(11, getR7C1());
      }
      this.u = i1;
      return i1;
    }
    
    public boolean hasR1C1()
    {
      return this.a;
    }
    
    public boolean hasR1C2()
    {
      return this.c;
    }
    
    public boolean hasR2C1()
    {
      return this.f;
    }
    
    public boolean hasR2C2()
    {
      return this.h;
    }
    
    public boolean hasR3C1()
    {
      return this.j;
    }
    
    public boolean hasR3C2()
    {
      return this.l;
    }
    
    public boolean hasR5C1()
    {
      return this.o;
    }
    
    public boolean hasR6C1()
    {
      return this.q;
    }
    
    public boolean hasR7C1()
    {
      return this.s;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public BtableTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR1C1((Template.RichText)localObject);
          break;
        case 18: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR1C2((Template.RichText)localObject);
          break;
        case 26: 
          localObject = new Template.Button();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR1C4((Template.Button)localObject);
          break;
        case 34: 
          localObject = new Template.Score();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR2C1((Template.Score)localObject);
          break;
        case 42: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR2C2((Template.RichText)localObject);
          break;
        case 50: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR3C1((Template.RichText)localObject);
          break;
        case 58: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR3C2((Template.RichText)localObject);
          break;
        case 66: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR4C1((Template.RichText)localObject);
          break;
        case 74: 
          localObject = new Template.ComboBox();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR5C1((Template.ComboBox)localObject);
          break;
        case 82: 
          localObject = new Template.Fatherson();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR6C1((Template.Fatherson)localObject);
          break;
        case 90: 
          localObject = new Template.Composit();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR7C1((Template.Composit)localObject);
        }
      }
    }
    
    public BtableTemplate setR1C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR1C1();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public BtableTemplate setR1C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR1C2();
      }
      this.c = true;
      this.d = paramRichText;
      return this;
    }
    
    public BtableTemplate setR1C4(int paramInt, Template.Button paramButton)
    {
      if (paramButton == null) {
        return this;
      }
      this.e.set(paramInt, paramButton);
      return this;
    }
    
    public BtableTemplate setR2C1(Template.Score paramScore)
    {
      if (paramScore == null) {
        return clearR2C1();
      }
      this.f = true;
      this.g = paramScore;
      return this;
    }
    
    public BtableTemplate setR2C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR2C2();
      }
      this.h = true;
      this.i = paramRichText;
      return this;
    }
    
    public BtableTemplate setR3C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR3C1();
      }
      this.j = true;
      this.k = paramRichText;
      return this;
    }
    
    public BtableTemplate setR3C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR3C2();
      }
      this.l = true;
      this.m = paramRichText;
      return this;
    }
    
    public BtableTemplate setR4C1(int paramInt, Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return this;
      }
      this.n.set(paramInt, paramRichText);
      return this;
    }
    
    public BtableTemplate setR5C1(Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return clearR5C1();
      }
      this.o = true;
      this.p = paramComboBox;
      return this;
    }
    
    public BtableTemplate setR6C1(Template.Fatherson paramFatherson)
    {
      if (paramFatherson == null) {
        return clearR6C1();
      }
      this.q = true;
      this.r = paramFatherson;
      return this;
    }
    
    public BtableTemplate setR7C1(Template.Composit paramComposit)
    {
      if (paramComposit == null) {
        return clearR7C1();
      }
      this.s = true;
      this.t = paramComposit;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasR1C1()) {
        paramCodedOutputStreamMicro.writeMessage(1, getR1C1());
      }
      if (hasR1C2()) {
        paramCodedOutputStreamMicro.writeMessage(2, getR1C2());
      }
      Iterator localIterator = getR1C4List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (Template.Button)localIterator.next());
      }
      if (hasR2C1()) {
        paramCodedOutputStreamMicro.writeMessage(4, getR2C1());
      }
      if (hasR2C2()) {
        paramCodedOutputStreamMicro.writeMessage(5, getR2C2());
      }
      if (hasR3C1()) {
        paramCodedOutputStreamMicro.writeMessage(6, getR3C1());
      }
      if (hasR3C2()) {
        paramCodedOutputStreamMicro.writeMessage(7, getR3C2());
      }
      localIterator = getR4C1List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (Template.RichText)localIterator.next());
      }
      if (hasR5C1()) {
        paramCodedOutputStreamMicro.writeMessage(9, getR5C1());
      }
      if (hasR6C1()) {
        paramCodedOutputStreamMicro.writeMessage(10, getR6C1());
      }
      if (hasR7C1()) {
        paramCodedOutputStreamMicro.writeMessage(11, getR7C1());
      }
    }
  }
  
  public static final class Button
    extends MessageMicro
  {
    public static final int ACTION_ID_FIELD_NUMBER = 3;
    public static final int ACTION_OPENAPI_FIELD_NUMBER = 4;
    public static final int ICON_ID_FIELD_NUMBER = 1;
    public static final int ICON_URL_FIELD_NUMBER = 2;
    public static final int TEXT_FIELD_NUMBER = 5;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private boolean g;
    private String h = "";
    private boolean i;
    private Template.RichText j = null;
    private int k = -1;
    
    public static Button parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Button().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Button parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Button)new Button().mergeFrom(paramArrayOfByte);
    }
    
    public final Button clear()
    {
      clearIconId();
      clearIconUrl();
      clearActionId();
      clearActionOpenapi();
      clearText();
      this.k = -1;
      return this;
    }
    
    public Button clearActionId()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Button clearActionOpenapi()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Button clearIconId()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Button clearIconUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Button clearText()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public int getActionId()
    {
      return this.f;
    }
    
    public String getActionOpenapi()
    {
      return this.h;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public int getIconId()
    {
      return this.b;
    }
    
    public String getIconUrl()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasIconId()) {
        n = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIconId());
      }
      int m = n;
      if (hasIconUrl()) {
        m = n + CodedOutputStreamMicro.computeStringSize(2, getIconUrl());
      }
      n = m;
      if (hasActionId()) {
        n = m + CodedOutputStreamMicro.computeInt32Size(3, getActionId());
      }
      m = n;
      if (hasActionOpenapi()) {
        m = n + CodedOutputStreamMicro.computeStringSize(4, getActionOpenapi());
      }
      n = m;
      if (hasText()) {
        n = m + CodedOutputStreamMicro.computeMessageSize(5, getText());
      }
      this.k = n;
      return n;
    }
    
    public Template.RichText getText()
    {
      return this.j;
    }
    
    public boolean hasActionId()
    {
      return this.e;
    }
    
    public boolean hasActionOpenapi()
    {
      return this.g;
    }
    
    public boolean hasIconId()
    {
      return this.a;
    }
    
    public boolean hasIconUrl()
    {
      return this.c;
    }
    
    public boolean hasText()
    {
      return this.i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Button mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int m = paramCodedInputStreamMicro.readTag();
        switch (m)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setIconId(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setActionId(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          setActionOpenapi(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          Template.RichText localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setText(localRichText);
        }
      }
    }
    
    public Button setActionId(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Button setActionOpenapi(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Button setIconId(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Button setIconUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Button setText(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearText();
      }
      this.i = true;
      this.j = paramRichText;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIconId()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIconId());
      }
      if (hasIconUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getIconUrl());
      }
      if (hasActionId()) {
        paramCodedOutputStreamMicro.writeInt32(3, getActionId());
      }
      if (hasActionOpenapi()) {
        paramCodedOutputStreamMicro.writeString(4, getActionOpenapi());
      }
      if (hasText()) {
        paramCodedOutputStreamMicro.writeMessage(5, getText());
      }
    }
  }
  
  public static final class ChildrenBtn
    extends MessageMicro
  {
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int UID_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static ChildrenBtn parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ChildrenBtn().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ChildrenBtn parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ChildrenBtn)new ChildrenBtn().mergeFrom(paramArrayOfByte);
    }
    
    public final ChildrenBtn clear()
    {
      clearUid();
      clearTitle();
      this.e = -1;
      return this;
    }
    
    public ChildrenBtn clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public ChildrenBtn clearUid()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasUid()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
      }
      int j = i;
      if (hasTitle()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      this.e = j;
      return j;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public String getUid()
    {
      return this.b;
    }
    
    public boolean hasTitle()
    {
      return this.c;
    }
    
    public boolean hasUid()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ChildrenBtn mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ChildrenBtn setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public ChildrenBtn setUid(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(1, getUid());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
    }
  }
  
  public static final class ComboBox
    extends MessageMicro
  {
    public static final int ICON_ID_FIELD_NUMBER = 2;
    public static final int ICON_URL_FIELD_NUMBER = 3;
    public static final int TEXT_FIELD_NUMBER = 1;
    private boolean a;
    private Template.RichText b = null;
    private boolean c;
    private int d = 0;
    private boolean e;
    private String f = "";
    private int g = -1;
    
    public static ComboBox parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ComboBox().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ComboBox parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ComboBox)new ComboBox().mergeFrom(paramArrayOfByte);
    }
    
    public final ComboBox clear()
    {
      clearText();
      clearIconId();
      clearIconUrl();
      this.g = -1;
      return this;
    }
    
    public ComboBox clearIconId()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public ComboBox clearIconUrl()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public ComboBox clearText()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public int getIconId()
    {
      return this.d;
    }
    
    public String getIconUrl()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasText()) {
        j = 0 + CodedOutputStreamMicro.computeMessageSize(1, getText());
      }
      int i = j;
      if (hasIconId()) {
        i = j + CodedOutputStreamMicro.computeInt32Size(2, getIconId());
      }
      j = i;
      if (hasIconUrl()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getIconUrl());
      }
      this.g = j;
      return j;
    }
    
    public Template.RichText getText()
    {
      return this.b;
    }
    
    public boolean hasIconId()
    {
      return this.c;
    }
    
    public boolean hasIconUrl()
    {
      return this.e;
    }
    
    public boolean hasText()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ComboBox mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          Template.RichText localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setText(localRichText);
          break;
        case 16: 
          setIconId(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setIconUrl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ComboBox setIconId(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public ComboBox setIconUrl(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public ComboBox setText(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearText();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasText()) {
        paramCodedOutputStreamMicro.writeMessage(1, getText());
      }
      if (hasIconId()) {
        paramCodedOutputStreamMicro.writeInt32(2, getIconId());
      }
      if (hasIconUrl()) {
        paramCodedOutputStreamMicro.writeString(3, getIconUrl());
      }
    }
  }
  
  public static final class Composit
    extends MessageMicro
  {
    public static final int ICON_ID_FIELD_NUMBER = 1;
    public static final int TAB_ID_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int VALUE_FIELD_NUMBER = 4;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private List<String> g = Collections.emptyList();
    private int h = -1;
    
    public static Composit parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Composit().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Composit parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Composit)new Composit().mergeFrom(paramArrayOfByte);
    }
    
    public Composit addValue(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.g.isEmpty()) {
        this.g = new ArrayList();
      }
      this.g.add(paramString);
      return this;
    }
    
    public final Composit clear()
    {
      clearIconId();
      clearTitle();
      clearTabId();
      clearValue();
      this.h = -1;
      return this;
    }
    
    public Composit clearIconId()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Composit clearTabId()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Composit clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Composit clearValue()
    {
      this.g = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.h < 0) {
        getSerializedSize();
      }
      return this.h;
    }
    
    public int getIconId()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasIconId()) {}
      for (int i = CodedOutputStreamMicro.computeInt32Size(1, getIconId()) + 0;; i = 0)
      {
        int j = i;
        if (hasTitle()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getTitle());
        }
        if (hasTabId()) {}
        for (i = j + CodedOutputStreamMicro.computeInt32Size(3, getTabId());; i = j)
        {
          Iterator localIterator = getValueList().iterator();
          j = k;
          while (localIterator.hasNext()) {
            j += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
          }
          i = i + j + getValueList().size() * 1;
          this.h = i;
          return i;
        }
      }
    }
    
    public int getTabId()
    {
      return this.f;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public String getValue(int paramInt)
    {
      return (String)this.g.get(paramInt);
    }
    
    public int getValueCount()
    {
      return this.g.size();
    }
    
    public List<String> getValueList()
    {
      return this.g;
    }
    
    public boolean hasIconId()
    {
      return this.a;
    }
    
    public boolean hasTabId()
    {
      return this.e;
    }
    
    public boolean hasTitle()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Composit mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setIconId(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setTabId(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          addValue(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Composit setIconId(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Composit setTabId(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Composit setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Composit setValue(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.g.set(paramInt, paramString);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIconId()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIconId());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
      if (hasTabId()) {
        paramCodedOutputStreamMicro.writeInt32(3, getTabId());
      }
      Iterator localIterator = getValueList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(4, (String)localIterator.next());
      }
    }
  }
  
  public static final class Fatherson
    extends MessageMicro
  {
    public static final int ACT_FIELD_NUMBER = 1;
    public static final int CHILDREN_BTN_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private List<Template.ChildrenBtn> e = Collections.emptyList();
    private int f = -1;
    
    public static Fatherson parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Fatherson().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Fatherson parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Fatherson)new Fatherson().mergeFrom(paramArrayOfByte);
    }
    
    public Fatherson addChildrenBtn(Template.ChildrenBtn paramChildrenBtn)
    {
      if (paramChildrenBtn == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramChildrenBtn);
      return this;
    }
    
    public final Fatherson clear()
    {
      clearAct();
      clearTitle();
      clearChildrenBtn();
      this.f = -1;
      return this;
    }
    
    public Fatherson clearAct()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Fatherson clearChildrenBtn()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public Fatherson clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getAct()
    {
      return this.b;
    }
    
    public int getCachedSize()
    {
      if (this.f < 0) {
        getSerializedSize();
      }
      return this.f;
    }
    
    public Template.ChildrenBtn getChildrenBtn(int paramInt)
    {
      return (Template.ChildrenBtn)this.e.get(paramInt);
    }
    
    public int getChildrenBtnCount()
    {
      return this.e.size();
    }
    
    public List<Template.ChildrenBtn> getChildrenBtnList()
    {
      return this.e;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasAct()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getAct());
      }
      int j = i;
      if (hasTitle()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      Iterator localIterator = getChildrenBtnList().iterator();
      while (localIterator.hasNext()) {
        j = CodedOutputStreamMicro.computeMessageSize(3, (Template.ChildrenBtn)localIterator.next()) + j;
      }
      this.f = j;
      return j;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public boolean hasAct()
    {
      return this.a;
    }
    
    public boolean hasTitle()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Fatherson mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setAct(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          Template.ChildrenBtn localChildrenBtn = new Template.ChildrenBtn();
          paramCodedInputStreamMicro.readMessage(localChildrenBtn);
          addChildrenBtn(localChildrenBtn);
        }
      }
    }
    
    public Fatherson setAct(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Fatherson setChildrenBtn(int paramInt, Template.ChildrenBtn paramChildrenBtn)
    {
      if (paramChildrenBtn == null) {
        return this;
      }
      this.e.set(paramInt, paramChildrenBtn);
      return this;
    }
    
    public Fatherson setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAct()) {
        paramCodedOutputStreamMicro.writeInt32(1, getAct());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
      Iterator localIterator = getChildrenBtnList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (Template.ChildrenBtn)localIterator.next());
      }
    }
  }
  
  public static final class Image
    extends MessageMicro
  {
    public static final int ICON_ID_FIELD_NUMBER = 3;
    public static final int LINK_FIELD_NUMBER = 2;
    public static final int ORI_VALUE_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private int g = -1;
    
    public static Image parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Image().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Image parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Image)new Image().mergeFrom(paramArrayOfByte);
    }
    
    public final Image clear()
    {
      clearOriValue();
      clearLink();
      clearIconId();
      this.g = -1;
      return this;
    }
    
    public Image clearIconId()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Image clearLink()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Image clearOriValue()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public int getIconId()
    {
      return this.f;
    }
    
    public String getLink()
    {
      return this.d;
    }
    
    public int getOriValue()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasOriValue()) {
        j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getOriValue());
      }
      int i = j;
      if (hasLink()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getLink());
      }
      j = i;
      if (hasIconId()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getIconId());
      }
      this.g = j;
      return j;
    }
    
    public boolean hasIconId()
    {
      return this.e;
    }
    
    public boolean hasLink()
    {
      return this.c;
    }
    
    public boolean hasOriValue()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Image mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setOriValue(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setLink(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setIconId(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Image setIconId(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Image setLink(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Image setOriValue(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasOriValue()) {
        paramCodedOutputStreamMicro.writeInt32(1, getOriValue());
      }
      if (hasLink()) {
        paramCodedOutputStreamMicro.writeString(2, getLink());
      }
      if (hasIconId()) {
        paramCodedOutputStreamMicro.writeInt32(3, getIconId());
      }
    }
  }
  
  public static final class ImageTemplate
    extends MessageMicro
  {
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
    private int A = -1;
    private boolean a;
    private Template.Image b = null;
    private boolean c;
    private Template.RichText d = null;
    private List<Template.Resource> e = Collections.emptyList();
    private boolean f;
    private String g = "";
    private boolean h;
    private Template.RichText i = null;
    private boolean j;
    private Template.RichText k = null;
    private boolean l;
    private Template.RichText m = null;
    private boolean n;
    private Template.RichText o = null;
    private boolean p;
    private Template.RichText q = null;
    private boolean r;
    private int s = 0;
    private boolean t;
    private Template.Composit u = null;
    private boolean v;
    private Template.Resource w = null;
    private boolean x;
    private Template.Fatherson y = null;
    private List<String> z = Collections.emptyList();
    
    public static ImageTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ImageTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ImageTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ImageTemplate)new ImageTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public ImageTemplate addImagel1C3(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramResource);
      return this;
    }
    
    public ImageTemplate addImagel4Lab(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.z.isEmpty()) {
        this.z = new ArrayList();
      }
      this.z.add(paramString);
      return this;
    }
    
    public final ImageTemplate clear()
    {
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
      this.A = -1;
      return this;
    }
    
    public ImageTemplate clearFaimagel5()
    {
      this.x = false;
      this.y = null;
      return this;
    }
    
    public ImageTemplate clearImagel1C1()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public ImageTemplate clearImagel1C2()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public ImageTemplate clearImagel1C3()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public ImageTemplate clearImagel2C1()
    {
      this.f = false;
      this.g = "";
      return this;
    }
    
    public ImageTemplate clearImagel2C2()
    {
      this.h = false;
      this.i = null;
      return this;
    }
    
    public ImageTemplate clearImagel2C3()
    {
      this.j = false;
      this.k = null;
      return this;
    }
    
    public ImageTemplate clearImagel3C1()
    {
      this.l = false;
      this.m = null;
      return this;
    }
    
    public ImageTemplate clearImagel3C2()
    {
      this.n = false;
      this.o = null;
      return this;
    }
    
    public ImageTemplate clearImagel4()
    {
      this.p = false;
      this.q = null;
      return this;
    }
    
    public ImageTemplate clearImagel4Lab()
    {
      this.z = Collections.emptyList();
      return this;
    }
    
    public ImageTemplate clearImagel5()
    {
      this.r = false;
      this.s = 0;
      return this;
    }
    
    public ImageTemplate clearImagel6()
    {
      this.t = false;
      this.u = null;
      return this;
    }
    
    public ImageTemplate clearUpperleftcorner()
    {
      this.v = false;
      this.w = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.A < 0) {
        getSerializedSize();
      }
      return this.A;
    }
    
    public Template.Fatherson getFaimagel5()
    {
      return this.y;
    }
    
    public Template.Image getImagel1C1()
    {
      return this.b;
    }
    
    public Template.RichText getImagel1C2()
    {
      return this.d;
    }
    
    public Template.Resource getImagel1C3(int paramInt)
    {
      return (Template.Resource)this.e.get(paramInt);
    }
    
    public int getImagel1C3Count()
    {
      return this.e.size();
    }
    
    public List<Template.Resource> getImagel1C3List()
    {
      return this.e;
    }
    
    public String getImagel2C1()
    {
      return this.g;
    }
    
    public Template.RichText getImagel2C2()
    {
      return this.i;
    }
    
    public Template.RichText getImagel2C3()
    {
      return this.k;
    }
    
    public Template.RichText getImagel3C1()
    {
      return this.m;
    }
    
    public Template.RichText getImagel3C2()
    {
      return this.o;
    }
    
    public Template.RichText getImagel4()
    {
      return this.q;
    }
    
    public String getImagel4Lab(int paramInt)
    {
      return (String)this.z.get(paramInt);
    }
    
    public int getImagel4LabCount()
    {
      return this.z.size();
    }
    
    public List<String> getImagel4LabList()
    {
      return this.z;
    }
    
    public int getImagel5()
    {
      return this.s;
    }
    
    public Template.Composit getImagel6()
    {
      return this.u;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasImagel1C1()) {}
      for (int i1 = CodedOutputStreamMicro.computeMessageSize(1, getImagel1C1()) + 0;; i1 = 0)
      {
        int i2 = i1;
        if (hasImagel1C2()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(2, getImagel1C2());
        }
        Iterator localIterator = getImagel1C3List().iterator();
        while (localIterator.hasNext()) {
          i2 = CodedOutputStreamMicro.computeMessageSize(3, (Template.Resource)localIterator.next()) + i2;
        }
        i1 = i2;
        if (hasImagel2C1()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getImagel2C1());
        }
        i2 = i1;
        if (hasImagel2C2()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getImagel2C2());
        }
        i1 = i2;
        if (hasImagel2C3()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getImagel2C3());
        }
        i2 = i1;
        if (hasImagel3C1()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getImagel3C1());
        }
        i1 = i2;
        if (hasImagel3C2()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getImagel3C2());
        }
        i2 = i1;
        if (hasImagel4()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(9, getImagel4());
        }
        i1 = i2;
        if (hasImagel5()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getImagel5());
        }
        i2 = i1;
        if (hasImagel6()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(11, getImagel6());
        }
        i1 = i2;
        if (hasUpperleftcorner()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(12, getUpperleftcorner());
        }
        i2 = i1;
        if (hasFaimagel5()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(13, getFaimagel5());
        }
        localIterator = getImagel4LabList().iterator();
        i1 = i3;
        while (localIterator.hasNext()) {
          i1 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
        }
        i1 = i2 + i1 + getImagel4LabList().size() * 1;
        this.A = i1;
        return i1;
      }
    }
    
    public Template.Resource getUpperleftcorner()
    {
      return this.w;
    }
    
    public boolean hasFaimagel5()
    {
      return this.x;
    }
    
    public boolean hasImagel1C1()
    {
      return this.a;
    }
    
    public boolean hasImagel1C2()
    {
      return this.c;
    }
    
    public boolean hasImagel2C1()
    {
      return this.f;
    }
    
    public boolean hasImagel2C2()
    {
      return this.h;
    }
    
    public boolean hasImagel2C3()
    {
      return this.j;
    }
    
    public boolean hasImagel3C1()
    {
      return this.l;
    }
    
    public boolean hasImagel3C2()
    {
      return this.n;
    }
    
    public boolean hasImagel4()
    {
      return this.p;
    }
    
    public boolean hasImagel5()
    {
      return this.r;
    }
    
    public boolean hasImagel6()
    {
      return this.t;
    }
    
    public boolean hasUpperleftcorner()
    {
      return this.v;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ImageTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Template.Image();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setImagel1C1((Template.Image)localObject);
          break;
        case 18: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setImagel1C2((Template.RichText)localObject);
          break;
        case 26: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addImagel1C3((Template.Resource)localObject);
          break;
        case 34: 
          setImagel2C1(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setImagel2C2((Template.RichText)localObject);
          break;
        case 50: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setImagel2C3((Template.RichText)localObject);
          break;
        case 58: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setImagel3C1((Template.RichText)localObject);
          break;
        case 66: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setImagel3C2((Template.RichText)localObject);
          break;
        case 74: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setImagel4((Template.RichText)localObject);
          break;
        case 80: 
          setImagel5(paramCodedInputStreamMicro.readInt32());
          break;
        case 90: 
          localObject = new Template.Composit();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setImagel6((Template.Composit)localObject);
          break;
        case 98: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUpperleftcorner((Template.Resource)localObject);
          break;
        case 106: 
          localObject = new Template.Fatherson();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setFaimagel5((Template.Fatherson)localObject);
          break;
        case 114: 
          addImagel4Lab(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ImageTemplate setFaimagel5(Template.Fatherson paramFatherson)
    {
      if (paramFatherson == null) {
        return clearFaimagel5();
      }
      this.x = true;
      this.y = paramFatherson;
      return this;
    }
    
    public ImageTemplate setImagel1C1(Template.Image paramImage)
    {
      if (paramImage == null) {
        return clearImagel1C1();
      }
      this.a = true;
      this.b = paramImage;
      return this;
    }
    
    public ImageTemplate setImagel1C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearImagel1C2();
      }
      this.c = true;
      this.d = paramRichText;
      return this;
    }
    
    public ImageTemplate setImagel1C3(int paramInt, Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      this.e.set(paramInt, paramResource);
      return this;
    }
    
    public ImageTemplate setImagel2C1(String paramString)
    {
      this.f = true;
      this.g = paramString;
      return this;
    }
    
    public ImageTemplate setImagel2C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearImagel2C2();
      }
      this.h = true;
      this.i = paramRichText;
      return this;
    }
    
    public ImageTemplate setImagel2C3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearImagel2C3();
      }
      this.j = true;
      this.k = paramRichText;
      return this;
    }
    
    public ImageTemplate setImagel3C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearImagel3C1();
      }
      this.l = true;
      this.m = paramRichText;
      return this;
    }
    
    public ImageTemplate setImagel3C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearImagel3C2();
      }
      this.n = true;
      this.o = paramRichText;
      return this;
    }
    
    public ImageTemplate setImagel4(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearImagel4();
      }
      this.p = true;
      this.q = paramRichText;
      return this;
    }
    
    public ImageTemplate setImagel4Lab(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.z.set(paramInt, paramString);
      return this;
    }
    
    public ImageTemplate setImagel5(int paramInt)
    {
      this.r = true;
      this.s = paramInt;
      return this;
    }
    
    public ImageTemplate setImagel6(Template.Composit paramComposit)
    {
      if (paramComposit == null) {
        return clearImagel6();
      }
      this.t = true;
      this.u = paramComposit;
      return this;
    }
    
    public ImageTemplate setUpperleftcorner(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return clearUpperleftcorner();
      }
      this.v = true;
      this.w = paramResource;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasImagel1C1()) {
        paramCodedOutputStreamMicro.writeMessage(1, getImagel1C1());
      }
      if (hasImagel1C2()) {
        paramCodedOutputStreamMicro.writeMessage(2, getImagel1C2());
      }
      Iterator localIterator = getImagel1C3List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (Template.Resource)localIterator.next());
      }
      if (hasImagel2C1()) {
        paramCodedOutputStreamMicro.writeString(4, getImagel2C1());
      }
      if (hasImagel2C2()) {
        paramCodedOutputStreamMicro.writeMessage(5, getImagel2C2());
      }
      if (hasImagel2C3()) {
        paramCodedOutputStreamMicro.writeMessage(6, getImagel2C3());
      }
      if (hasImagel3C1()) {
        paramCodedOutputStreamMicro.writeMessage(7, getImagel3C1());
      }
      if (hasImagel3C2()) {
        paramCodedOutputStreamMicro.writeMessage(8, getImagel3C2());
      }
      if (hasImagel4()) {
        paramCodedOutputStreamMicro.writeMessage(9, getImagel4());
      }
      if (hasImagel5()) {
        paramCodedOutputStreamMicro.writeInt32(10, getImagel5());
      }
      if (hasImagel6()) {
        paramCodedOutputStreamMicro.writeMessage(11, getImagel6());
      }
      if (hasUpperleftcorner()) {
        paramCodedOutputStreamMicro.writeMessage(12, getUpperleftcorner());
      }
      if (hasFaimagel5()) {
        paramCodedOutputStreamMicro.writeMessage(13, getFaimagel5());
      }
      localIterator = getImagel4LabList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(14, (String)localIterator.next());
      }
    }
  }
  
  public static final class LtableTemplate
    extends MessageMicro
  {
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
    private boolean A;
    private Template.Fatherson B = null;
    private boolean C;
    private Template.Composit D = null;
    private int E = -1;
    private boolean a;
    private int b = 1;
    private boolean c;
    private Template.Image d = null;
    private boolean e;
    private Template.RichText f = null;
    private boolean g;
    private Template.RichText h = null;
    private List<Template.Button> i = Collections.emptyList();
    private boolean j;
    private Template.RichText k = null;
    private boolean l;
    private Template.RichText m = null;
    private List<Template.ScatterStyle> n = Collections.emptyList();
    private boolean o;
    private Template.Score p = null;
    private List<Template.ComboBox> q = Collections.emptyList();
    private List<Template.ScatterStyle> r = Collections.emptyList();
    private boolean s;
    private Template.Score t = null;
    private List<Template.ComboBox> u = Collections.emptyList();
    private List<Template.ScatterStyle> v = Collections.emptyList();
    private boolean w;
    private Template.Score x = null;
    private List<Template.ComboBox> y = Collections.emptyList();
    private List<Template.ScatterStyle> z = Collections.emptyList();
    
    public static LtableTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new LtableTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static LtableTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (LtableTemplate)new LtableTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public LtableTemplate addR1C4(Template.Button paramButton)
    {
      if (paramButton == null) {
        return this;
      }
      if (this.i.isEmpty()) {
        this.i = new ArrayList();
      }
      this.i.add(paramButton);
      return this;
    }
    
    public LtableTemplate addR2C2(Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      if (this.n.isEmpty()) {
        this.n = new ArrayList();
      }
      this.n.add(paramScatterStyle);
      return this;
    }
    
    public LtableTemplate addR3C2(Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return this;
      }
      if (this.q.isEmpty()) {
        this.q = new ArrayList();
      }
      this.q.add(paramComboBox);
      return this;
    }
    
    public LtableTemplate addR3C3(Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      if (this.r.isEmpty()) {
        this.r = new ArrayList();
      }
      this.r.add(paramScatterStyle);
      return this;
    }
    
    public LtableTemplate addR4C2(Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return this;
      }
      if (this.u.isEmpty()) {
        this.u = new ArrayList();
      }
      this.u.add(paramComboBox);
      return this;
    }
    
    public LtableTemplate addR4C3(Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      if (this.v.isEmpty()) {
        this.v = new ArrayList();
      }
      this.v.add(paramScatterStyle);
      return this;
    }
    
    public LtableTemplate addR5C2(Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return this;
      }
      if (this.y.isEmpty()) {
        this.y = new ArrayList();
      }
      this.y.add(paramComboBox);
      return this;
    }
    
    public LtableTemplate addR5C3(Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      if (this.z.isEmpty()) {
        this.z = new ArrayList();
      }
      this.z.add(paramScatterStyle);
      return this;
    }
    
    public final LtableTemplate clear()
    {
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
      this.E = -1;
      return this;
    }
    
    public LtableTemplate clearInternation()
    {
      this.j = false;
      this.k = null;
      return this;
    }
    
    public LtableTemplate clearR1C1()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public LtableTemplate clearR1C2()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public LtableTemplate clearR1C3()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public LtableTemplate clearR1C4()
    {
      this.i = Collections.emptyList();
      return this;
    }
    
    public LtableTemplate clearR2C1()
    {
      this.l = false;
      this.m = null;
      return this;
    }
    
    public LtableTemplate clearR2C2()
    {
      this.n = Collections.emptyList();
      return this;
    }
    
    public LtableTemplate clearR3C1()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public LtableTemplate clearR3C2()
    {
      this.q = Collections.emptyList();
      return this;
    }
    
    public LtableTemplate clearR3C3()
    {
      this.r = Collections.emptyList();
      return this;
    }
    
    public LtableTemplate clearR4C1()
    {
      this.s = false;
      this.t = null;
      return this;
    }
    
    public LtableTemplate clearR4C2()
    {
      this.u = Collections.emptyList();
      return this;
    }
    
    public LtableTemplate clearR4C3()
    {
      this.v = Collections.emptyList();
      return this;
    }
    
    public LtableTemplate clearR5C1()
    {
      this.w = false;
      this.x = null;
      return this;
    }
    
    public LtableTemplate clearR5C2()
    {
      this.y = Collections.emptyList();
      return this;
    }
    
    public LtableTemplate clearR5C3()
    {
      this.z = Collections.emptyList();
      return this;
    }
    
    public LtableTemplate clearR6C1()
    {
      this.A = false;
      this.B = null;
      return this;
    }
    
    public LtableTemplate clearR7C1()
    {
      this.C = false;
      this.D = null;
      return this;
    }
    
    public LtableTemplate clearType()
    {
      this.a = false;
      this.b = 1;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.E < 0) {
        getSerializedSize();
      }
      return this.E;
    }
    
    public Template.RichText getInternation()
    {
      return this.k;
    }
    
    public Template.Image getR1C1()
    {
      return this.d;
    }
    
    public Template.RichText getR1C2()
    {
      return this.f;
    }
    
    public Template.RichText getR1C3()
    {
      return this.h;
    }
    
    public Template.Button getR1C4(int paramInt)
    {
      return (Template.Button)this.i.get(paramInt);
    }
    
    public int getR1C4Count()
    {
      return this.i.size();
    }
    
    public List<Template.Button> getR1C4List()
    {
      return this.i;
    }
    
    public Template.RichText getR2C1()
    {
      return this.m;
    }
    
    public Template.ScatterStyle getR2C2(int paramInt)
    {
      return (Template.ScatterStyle)this.n.get(paramInt);
    }
    
    public int getR2C2Count()
    {
      return this.n.size();
    }
    
    public List<Template.ScatterStyle> getR2C2List()
    {
      return this.n;
    }
    
    public Template.Score getR3C1()
    {
      return this.p;
    }
    
    public Template.ComboBox getR3C2(int paramInt)
    {
      return (Template.ComboBox)this.q.get(paramInt);
    }
    
    public int getR3C2Count()
    {
      return this.q.size();
    }
    
    public List<Template.ComboBox> getR3C2List()
    {
      return this.q;
    }
    
    public Template.ScatterStyle getR3C3(int paramInt)
    {
      return (Template.ScatterStyle)this.r.get(paramInt);
    }
    
    public int getR3C3Count()
    {
      return this.r.size();
    }
    
    public List<Template.ScatterStyle> getR3C3List()
    {
      return this.r;
    }
    
    public Template.Score getR4C1()
    {
      return this.t;
    }
    
    public Template.ComboBox getR4C2(int paramInt)
    {
      return (Template.ComboBox)this.u.get(paramInt);
    }
    
    public int getR4C2Count()
    {
      return this.u.size();
    }
    
    public List<Template.ComboBox> getR4C2List()
    {
      return this.u;
    }
    
    public Template.ScatterStyle getR4C3(int paramInt)
    {
      return (Template.ScatterStyle)this.v.get(paramInt);
    }
    
    public int getR4C3Count()
    {
      return this.v.size();
    }
    
    public List<Template.ScatterStyle> getR4C3List()
    {
      return this.v;
    }
    
    public Template.Score getR5C1()
    {
      return this.x;
    }
    
    public Template.ComboBox getR5C2(int paramInt)
    {
      return (Template.ComboBox)this.y.get(paramInt);
    }
    
    public int getR5C2Count()
    {
      return this.y.size();
    }
    
    public List<Template.ComboBox> getR5C2List()
    {
      return this.y;
    }
    
    public Template.ScatterStyle getR5C3(int paramInt)
    {
      return (Template.ScatterStyle)this.z.get(paramInt);
    }
    
    public int getR5C3Count()
    {
      return this.z.size();
    }
    
    public List<Template.ScatterStyle> getR5C3List()
    {
      return this.z;
    }
    
    public Template.Fatherson getR6C1()
    {
      return this.B;
    }
    
    public Template.Composit getR7C1()
    {
      return this.D;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasType()) {
        i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
      }
      int i1 = i2;
      if (hasR1C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(2, getR1C1());
      }
      i2 = i1;
      if (hasR1C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(3, getR1C2());
      }
      i1 = i2;
      if (hasR1C3()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getR1C3());
      }
      Iterator localIterator = getR1C4List().iterator();
      for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(5, (Template.Button)localIterator.next()) + i2) {}
      i1 = i2;
      if (hasInternation()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getInternation());
      }
      i2 = i1;
      if (hasR2C1()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getR2C1());
      }
      localIterator = getR2C2List().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(8, (Template.ScatterStyle)localIterator.next());
      }
      i1 = i2;
      if (hasR3C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(9, getR3C1());
      }
      localIterator = getR3C2List().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(10, (Template.ComboBox)localIterator.next());
      }
      localIterator = getR3C3List().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(11, (Template.ScatterStyle)localIterator.next());
      }
      i2 = i1;
      if (hasR4C1()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(12, getR4C1());
      }
      localIterator = getR4C2List().iterator();
      i1 = i2;
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(13, (Template.ComboBox)localIterator.next());
      }
      localIterator = getR4C3List().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(14, (Template.ScatterStyle)localIterator.next());
      }
      i2 = i1;
      if (hasR5C1()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(15, getR5C1());
      }
      localIterator = getR5C2List().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(16, (Template.ComboBox)localIterator.next());
      }
      localIterator = getR5C3List().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(17, (Template.ScatterStyle)localIterator.next());
      }
      i1 = i2;
      if (hasR6C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(18, getR6C1());
      }
      i2 = i1;
      if (hasR7C1()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(19, getR7C1());
      }
      this.E = i2;
      return i2;
    }
    
    public int getType()
    {
      return this.b;
    }
    
    public boolean hasInternation()
    {
      return this.j;
    }
    
    public boolean hasR1C1()
    {
      return this.c;
    }
    
    public boolean hasR1C2()
    {
      return this.e;
    }
    
    public boolean hasR1C3()
    {
      return this.g;
    }
    
    public boolean hasR2C1()
    {
      return this.l;
    }
    
    public boolean hasR3C1()
    {
      return this.o;
    }
    
    public boolean hasR4C1()
    {
      return this.s;
    }
    
    public boolean hasR5C1()
    {
      return this.w;
    }
    
    public boolean hasR6C1()
    {
      return this.A;
    }
    
    public boolean hasR7C1()
    {
      return this.C;
    }
    
    public boolean hasType()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public LtableTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setType(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          localObject = new Template.Image();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR1C1((Template.Image)localObject);
          break;
        case 26: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR1C2((Template.RichText)localObject);
          break;
        case 34: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR1C3((Template.RichText)localObject);
          break;
        case 42: 
          localObject = new Template.Button();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR1C4((Template.Button)localObject);
          break;
        case 50: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setInternation((Template.RichText)localObject);
          break;
        case 58: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR2C1((Template.RichText)localObject);
          break;
        case 66: 
          localObject = new Template.ScatterStyle();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR2C2((Template.ScatterStyle)localObject);
          break;
        case 74: 
          localObject = new Template.Score();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR3C1((Template.Score)localObject);
          break;
        case 82: 
          localObject = new Template.ComboBox();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR3C2((Template.ComboBox)localObject);
          break;
        case 90: 
          localObject = new Template.ScatterStyle();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR3C3((Template.ScatterStyle)localObject);
          break;
        case 98: 
          localObject = new Template.Score();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR4C1((Template.Score)localObject);
          break;
        case 106: 
          localObject = new Template.ComboBox();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR4C2((Template.ComboBox)localObject);
          break;
        case 114: 
          localObject = new Template.ScatterStyle();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR4C3((Template.ScatterStyle)localObject);
          break;
        case 122: 
          localObject = new Template.Score();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR5C1((Template.Score)localObject);
          break;
        case 130: 
          localObject = new Template.ComboBox();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR5C2((Template.ComboBox)localObject);
          break;
        case 138: 
          localObject = new Template.ScatterStyle();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR5C3((Template.ScatterStyle)localObject);
          break;
        case 146: 
          localObject = new Template.Fatherson();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR6C1((Template.Fatherson)localObject);
          break;
        case 154: 
          localObject = new Template.Composit();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR7C1((Template.Composit)localObject);
        }
      }
    }
    
    public LtableTemplate setInternation(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearInternation();
      }
      this.j = true;
      this.k = paramRichText;
      return this;
    }
    
    public LtableTemplate setR1C1(Template.Image paramImage)
    {
      if (paramImage == null) {
        return clearR1C1();
      }
      this.c = true;
      this.d = paramImage;
      return this;
    }
    
    public LtableTemplate setR1C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR1C2();
      }
      this.e = true;
      this.f = paramRichText;
      return this;
    }
    
    public LtableTemplate setR1C3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR1C3();
      }
      this.g = true;
      this.h = paramRichText;
      return this;
    }
    
    public LtableTemplate setR1C4(int paramInt, Template.Button paramButton)
    {
      if (paramButton == null) {
        return this;
      }
      this.i.set(paramInt, paramButton);
      return this;
    }
    
    public LtableTemplate setR2C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR2C1();
      }
      this.l = true;
      this.m = paramRichText;
      return this;
    }
    
    public LtableTemplate setR2C2(int paramInt, Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      this.n.set(paramInt, paramScatterStyle);
      return this;
    }
    
    public LtableTemplate setR3C1(Template.Score paramScore)
    {
      if (paramScore == null) {
        return clearR3C1();
      }
      this.o = true;
      this.p = paramScore;
      return this;
    }
    
    public LtableTemplate setR3C2(int paramInt, Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return this;
      }
      this.q.set(paramInt, paramComboBox);
      return this;
    }
    
    public LtableTemplate setR3C3(int paramInt, Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      this.r.set(paramInt, paramScatterStyle);
      return this;
    }
    
    public LtableTemplate setR4C1(Template.Score paramScore)
    {
      if (paramScore == null) {
        return clearR4C1();
      }
      this.s = true;
      this.t = paramScore;
      return this;
    }
    
    public LtableTemplate setR4C2(int paramInt, Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return this;
      }
      this.u.set(paramInt, paramComboBox);
      return this;
    }
    
    public LtableTemplate setR4C3(int paramInt, Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      this.v.set(paramInt, paramScatterStyle);
      return this;
    }
    
    public LtableTemplate setR5C1(Template.Score paramScore)
    {
      if (paramScore == null) {
        return clearR5C1();
      }
      this.w = true;
      this.x = paramScore;
      return this;
    }
    
    public LtableTemplate setR5C2(int paramInt, Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return this;
      }
      this.y.set(paramInt, paramComboBox);
      return this;
    }
    
    public LtableTemplate setR5C3(int paramInt, Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      this.z.set(paramInt, paramScatterStyle);
      return this;
    }
    
    public LtableTemplate setR6C1(Template.Fatherson paramFatherson)
    {
      if (paramFatherson == null) {
        return clearR6C1();
      }
      this.A = true;
      this.B = paramFatherson;
      return this;
    }
    
    public LtableTemplate setR7C1(Template.Composit paramComposit)
    {
      if (paramComposit == null) {
        return clearR7C1();
      }
      this.C = true;
      this.D = paramComposit;
      return this;
    }
    
    public LtableTemplate setType(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasType()) {
        paramCodedOutputStreamMicro.writeInt32(1, getType());
      }
      if (hasR1C1()) {
        paramCodedOutputStreamMicro.writeMessage(2, getR1C1());
      }
      if (hasR1C2()) {
        paramCodedOutputStreamMicro.writeMessage(3, getR1C2());
      }
      if (hasR1C3()) {
        paramCodedOutputStreamMicro.writeMessage(4, getR1C3());
      }
      Iterator localIterator = getR1C4List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(5, (Template.Button)localIterator.next());
      }
      if (hasInternation()) {
        paramCodedOutputStreamMicro.writeMessage(6, getInternation());
      }
      if (hasR2C1()) {
        paramCodedOutputStreamMicro.writeMessage(7, getR2C1());
      }
      localIterator = getR2C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (Template.ScatterStyle)localIterator.next());
      }
      if (hasR3C1()) {
        paramCodedOutputStreamMicro.writeMessage(9, getR3C1());
      }
      localIterator = getR3C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(10, (Template.ComboBox)localIterator.next());
      }
      localIterator = getR3C3List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(11, (Template.ScatterStyle)localIterator.next());
      }
      if (hasR4C1()) {
        paramCodedOutputStreamMicro.writeMessage(12, getR4C1());
      }
      localIterator = getR4C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(13, (Template.ComboBox)localIterator.next());
      }
      localIterator = getR4C3List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(14, (Template.ScatterStyle)localIterator.next());
      }
      if (hasR5C1()) {
        paramCodedOutputStreamMicro.writeMessage(15, getR5C1());
      }
      localIterator = getR5C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(16, (Template.ComboBox)localIterator.next());
      }
      localIterator = getR5C3List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(17, (Template.ScatterStyle)localIterator.next());
      }
      if (hasR6C1()) {
        paramCodedOutputStreamMicro.writeMessage(18, getR6C1());
      }
      if (hasR7C1()) {
        paramCodedOutputStreamMicro.writeMessage(19, getR7C1());
      }
    }
  }
  
  public static final class MapSearchaladdinNormalTemplate
    extends MessageMicro
  {
    public static final int ALADDINNORMALL1_FIELD_NUMBER = 1;
    public static final int ALADDINNORMALL2_FIELD_NUMBER = 2;
    public static final int ALADDINNORMALL3_FIELD_NUMBER = 3;
    private boolean a;
    private Template.RichText b = null;
    private boolean c;
    private Template.RichText d = null;
    private boolean e;
    private Template.RichText f = null;
    private int g = -1;
    
    public static MapSearchaladdinNormalTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MapSearchaladdinNormalTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MapSearchaladdinNormalTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MapSearchaladdinNormalTemplate)new MapSearchaladdinNormalTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public final MapSearchaladdinNormalTemplate clear()
    {
      clearAladdinnormall1();
      clearAladdinnormall2();
      clearAladdinnormall3();
      this.g = -1;
      return this;
    }
    
    public MapSearchaladdinNormalTemplate clearAladdinnormall1()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public MapSearchaladdinNormalTemplate clearAladdinnormall2()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public MapSearchaladdinNormalTemplate clearAladdinnormall3()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public Template.RichText getAladdinnormall1()
    {
      return this.b;
    }
    
    public Template.RichText getAladdinnormall2()
    {
      return this.d;
    }
    
    public Template.RichText getAladdinnormall3()
    {
      return this.f;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasAladdinnormall1()) {
        j = 0 + CodedOutputStreamMicro.computeMessageSize(1, getAladdinnormall1());
      }
      int i = j;
      if (hasAladdinnormall2()) {
        i = j + CodedOutputStreamMicro.computeMessageSize(2, getAladdinnormall2());
      }
      j = i;
      if (hasAladdinnormall3()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(3, getAladdinnormall3());
      }
      this.g = j;
      return j;
    }
    
    public boolean hasAladdinnormall1()
    {
      return this.a;
    }
    
    public boolean hasAladdinnormall2()
    {
      return this.c;
    }
    
    public boolean hasAladdinnormall3()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MapSearchaladdinNormalTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        Template.RichText localRichText;
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setAladdinnormall1(localRichText);
          break;
        case 18: 
          localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setAladdinnormall2(localRichText);
          break;
        case 26: 
          localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setAladdinnormall3(localRichText);
        }
      }
    }
    
    public MapSearchaladdinNormalTemplate setAladdinnormall1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinnormall1();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public MapSearchaladdinNormalTemplate setAladdinnormall2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinnormall2();
      }
      this.c = true;
      this.d = paramRichText;
      return this;
    }
    
    public MapSearchaladdinNormalTemplate setAladdinnormall3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinnormall3();
      }
      this.e = true;
      this.f = paramRichText;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAladdinnormall1()) {
        paramCodedOutputStreamMicro.writeMessage(1, getAladdinnormall1());
      }
      if (hasAladdinnormall2()) {
        paramCodedOutputStreamMicro.writeMessage(2, getAladdinnormall2());
      }
      if (hasAladdinnormall3()) {
        paramCodedOutputStreamMicro.writeMessage(3, getAladdinnormall3());
      }
    }
  }
  
  public static final class MapSearchaladdinPanelTemplate
    extends MessageMicro
  {
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
    private boolean a;
    private Template.RichText b = null;
    private List<Template.Resource> c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private boolean f;
    private Template.RichText g = null;
    private boolean h;
    private Template.RichText i = null;
    private boolean j;
    private Template.RichText k = null;
    private boolean l;
    private Template.RichText m = null;
    private List<Template.ChildrenBtn> n = Collections.emptyList();
    private boolean o;
    private Template.RichText p = null;
    private boolean q;
    private Template.Resource r = null;
    private int s = -1;
    
    public static MapSearchaladdinPanelTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MapSearchaladdinPanelTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MapSearchaladdinPanelTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MapSearchaladdinPanelTemplate)new MapSearchaladdinPanelTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public MapSearchaladdinPanelTemplate addAladdinpanell1C2(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramResource);
      return this;
    }
    
    public MapSearchaladdinPanelTemplate addAladdinpanell5(Template.ChildrenBtn paramChildrenBtn)
    {
      if (paramChildrenBtn == null) {
        return this;
      }
      if (this.n.isEmpty()) {
        this.n = new ArrayList();
      }
      this.n.add(paramChildrenBtn);
      return this;
    }
    
    public final MapSearchaladdinPanelTemplate clear()
    {
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
      this.s = -1;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell1C1()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell1C2()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell2C1()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell2C2()
    {
      this.f = false;
      this.g = null;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell2C3()
    {
      this.h = false;
      this.i = null;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell3()
    {
      this.j = false;
      this.k = null;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell4()
    {
      this.l = false;
      this.m = null;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell5()
    {
      this.n = Collections.emptyList();
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearAladdinpanell6()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate clearUpperleftcorner()
    {
      this.q = false;
      this.r = null;
      return this;
    }
    
    public Template.RichText getAladdinpanell1C1()
    {
      return this.b;
    }
    
    public Template.Resource getAladdinpanell1C2(int paramInt)
    {
      return (Template.Resource)this.c.get(paramInt);
    }
    
    public int getAladdinpanell1C2Count()
    {
      return this.c.size();
    }
    
    public List<Template.Resource> getAladdinpanell1C2List()
    {
      return this.c;
    }
    
    public String getAladdinpanell2C1()
    {
      return this.e;
    }
    
    public Template.RichText getAladdinpanell2C2()
    {
      return this.g;
    }
    
    public Template.RichText getAladdinpanell2C3()
    {
      return this.i;
    }
    
    public Template.RichText getAladdinpanell3()
    {
      return this.k;
    }
    
    public Template.RichText getAladdinpanell4()
    {
      return this.m;
    }
    
    public Template.ChildrenBtn getAladdinpanell5(int paramInt)
    {
      return (Template.ChildrenBtn)this.n.get(paramInt);
    }
    
    public int getAladdinpanell5Count()
    {
      return this.n.size();
    }
    
    public List<Template.ChildrenBtn> getAladdinpanell5List()
    {
      return this.n;
    }
    
    public Template.RichText getAladdinpanell6()
    {
      return this.p;
    }
    
    public int getCachedSize()
    {
      if (this.s < 0) {
        getSerializedSize();
      }
      return this.s;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasAladdinpanell1C1()) {
        i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getAladdinpanell1C1());
      }
      Iterator localIterator = getAladdinpanell1C2List().iterator();
      for (int i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(2, (Template.Resource)localIterator.next()) + i2) {}
      i1 = i2;
      if (hasAladdinpanell2C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(3, getAladdinpanell2C1());
      }
      i2 = i1;
      if (hasAladdinpanell2C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(4, getAladdinpanell2C2());
      }
      i1 = i2;
      if (hasAladdinpanell2C3()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(5, getAladdinpanell2C3());
      }
      i2 = i1;
      if (hasAladdinpanell3()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(6, getAladdinpanell3());
      }
      i1 = i2;
      if (hasAladdinpanell4()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(7, getAladdinpanell4());
      }
      localIterator = getAladdinpanell5List().iterator();
      i2 = i1;
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(8, (Template.ChildrenBtn)localIterator.next());
      }
      i1 = i2;
      if (hasAladdinpanell6()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(9, getAladdinpanell6());
      }
      i2 = i1;
      if (hasUpperleftcorner()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(10, getUpperleftcorner());
      }
      this.s = i2;
      return i2;
    }
    
    public Template.Resource getUpperleftcorner()
    {
      return this.r;
    }
    
    public boolean hasAladdinpanell1C1()
    {
      return this.a;
    }
    
    public boolean hasAladdinpanell2C1()
    {
      return this.d;
    }
    
    public boolean hasAladdinpanell2C2()
    {
      return this.f;
    }
    
    public boolean hasAladdinpanell2C3()
    {
      return this.h;
    }
    
    public boolean hasAladdinpanell3()
    {
      return this.j;
    }
    
    public boolean hasAladdinpanell4()
    {
      return this.l;
    }
    
    public boolean hasAladdinpanell6()
    {
      return this.o;
    }
    
    public boolean hasUpperleftcorner()
    {
      return this.q;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MapSearchaladdinPanelTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setAladdinpanell1C1((Template.RichText)localObject);
          break;
        case 18: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addAladdinpanell1C2((Template.Resource)localObject);
          break;
        case 26: 
          setAladdinpanell2C1(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setAladdinpanell2C2((Template.RichText)localObject);
          break;
        case 42: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setAladdinpanell2C3((Template.RichText)localObject);
          break;
        case 50: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setAladdinpanell3((Template.RichText)localObject);
          break;
        case 58: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setAladdinpanell4((Template.RichText)localObject);
          break;
        case 66: 
          localObject = new Template.ChildrenBtn();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addAladdinpanell5((Template.ChildrenBtn)localObject);
          break;
        case 74: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setAladdinpanell6((Template.RichText)localObject);
          break;
        case 82: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUpperleftcorner((Template.Resource)localObject);
        }
      }
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell1C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinpanell1C1();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell1C2(int paramInt, Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      this.c.set(paramInt, paramResource);
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell2C1(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell2C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinpanell2C2();
      }
      this.f = true;
      this.g = paramRichText;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell2C3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinpanell2C3();
      }
      this.h = true;
      this.i = paramRichText;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinpanell3();
      }
      this.j = true;
      this.k = paramRichText;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell4(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinpanell4();
      }
      this.l = true;
      this.m = paramRichText;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell5(int paramInt, Template.ChildrenBtn paramChildrenBtn)
    {
      if (paramChildrenBtn == null) {
        return this;
      }
      this.n.set(paramInt, paramChildrenBtn);
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setAladdinpanell6(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearAladdinpanell6();
      }
      this.o = true;
      this.p = paramRichText;
      return this;
    }
    
    public MapSearchaladdinPanelTemplate setUpperleftcorner(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return clearUpperleftcorner();
      }
      this.q = true;
      this.r = paramResource;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAladdinpanell1C1()) {
        paramCodedOutputStreamMicro.writeMessage(1, getAladdinpanell1C1());
      }
      Iterator localIterator = getAladdinpanell1C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Template.Resource)localIterator.next());
      }
      if (hasAladdinpanell2C1()) {
        paramCodedOutputStreamMicro.writeString(3, getAladdinpanell2C1());
      }
      if (hasAladdinpanell2C2()) {
        paramCodedOutputStreamMicro.writeMessage(4, getAladdinpanell2C2());
      }
      if (hasAladdinpanell2C3()) {
        paramCodedOutputStreamMicro.writeMessage(5, getAladdinpanell2C3());
      }
      if (hasAladdinpanell3()) {
        paramCodedOutputStreamMicro.writeMessage(6, getAladdinpanell3());
      }
      if (hasAladdinpanell4()) {
        paramCodedOutputStreamMicro.writeMessage(7, getAladdinpanell4());
      }
      localIterator = getAladdinpanell5List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (Template.ChildrenBtn)localIterator.next());
      }
      if (hasAladdinpanell6()) {
        paramCodedOutputStreamMicro.writeMessage(9, getAladdinpanell6());
      }
      if (hasUpperleftcorner()) {
        paramCodedOutputStreamMicro.writeMessage(10, getUpperleftcorner());
      }
    }
  }
  
  public static final class NormalTemplate
    extends MessageMicro
  {
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
    private boolean a;
    private Template.RichText b = null;
    private List<Template.Resource> c = Collections.emptyList();
    private boolean d;
    private Template.RichText e = null;
    private boolean f;
    private String g = "";
    private boolean h;
    private Template.RichText i = null;
    private boolean j;
    private Template.RichText k = null;
    private boolean l;
    private Template.RichText m = null;
    private boolean n;
    private Template.RichText o = null;
    private boolean p;
    private int q = 0;
    private boolean r;
    private Template.Composit s = null;
    private boolean t;
    private Template.Resource u = null;
    private List<String> v = Collections.emptyList();
    private boolean w;
    private Template.Fatherson x = null;
    private List<String> y = Collections.emptyList();
    private int z = -1;
    
    public static NormalTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new NormalTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static NormalTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (NormalTemplate)new NormalTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public NormalTemplate addFlag(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.v.isEmpty()) {
        this.v = new ArrayList();
      }
      this.v.add(paramString);
      return this;
    }
    
    public NormalTemplate addNormall1C2(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramResource);
      return this;
    }
    
    public NormalTemplate addNormall4Lab(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.y.isEmpty()) {
        this.y = new ArrayList();
      }
      this.y.add(paramString);
      return this;
    }
    
    public final NormalTemplate clear()
    {
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
      this.z = -1;
      return this;
    }
    
    public NormalTemplate clearFanormall5()
    {
      this.w = false;
      this.x = null;
      return this;
    }
    
    public NormalTemplate clearFlag()
    {
      this.v = Collections.emptyList();
      return this;
    }
    
    public NormalTemplate clearNormall1C1()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public NormalTemplate clearNormall1C2()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public NormalTemplate clearNormall1C3()
    {
      this.d = false;
      this.e = null;
      return this;
    }
    
    public NormalTemplate clearNormall2C1()
    {
      this.f = false;
      this.g = "";
      return this;
    }
    
    public NormalTemplate clearNormall2C2()
    {
      this.h = false;
      this.i = null;
      return this;
    }
    
    public NormalTemplate clearNormall2C3()
    {
      this.j = false;
      this.k = null;
      return this;
    }
    
    public NormalTemplate clearNormall3()
    {
      this.l = false;
      this.m = null;
      return this;
    }
    
    public NormalTemplate clearNormall4()
    {
      this.n = false;
      this.o = null;
      return this;
    }
    
    public NormalTemplate clearNormall4Lab()
    {
      this.y = Collections.emptyList();
      return this;
    }
    
    public NormalTemplate clearNormall5()
    {
      this.p = false;
      this.q = 0;
      return this;
    }
    
    public NormalTemplate clearNormall6()
    {
      this.r = false;
      this.s = null;
      return this;
    }
    
    public NormalTemplate clearUpperleftcorner()
    {
      this.t = false;
      this.u = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.z < 0) {
        getSerializedSize();
      }
      return this.z;
    }
    
    public Template.Fatherson getFanormall5()
    {
      return this.x;
    }
    
    public String getFlag(int paramInt)
    {
      return (String)this.v.get(paramInt);
    }
    
    public int getFlagCount()
    {
      return this.v.size();
    }
    
    public List<String> getFlagList()
    {
      return this.v;
    }
    
    public Template.RichText getNormall1C1()
    {
      return this.b;
    }
    
    public Template.Resource getNormall1C2(int paramInt)
    {
      return (Template.Resource)this.c.get(paramInt);
    }
    
    public int getNormall1C2Count()
    {
      return this.c.size();
    }
    
    public List<Template.Resource> getNormall1C2List()
    {
      return this.c;
    }
    
    public Template.RichText getNormall1C3()
    {
      return this.e;
    }
    
    public String getNormall2C1()
    {
      return this.g;
    }
    
    public Template.RichText getNormall2C2()
    {
      return this.i;
    }
    
    public Template.RichText getNormall2C3()
    {
      return this.k;
    }
    
    public Template.RichText getNormall3()
    {
      return this.m;
    }
    
    public Template.RichText getNormall4()
    {
      return this.o;
    }
    
    public String getNormall4Lab(int paramInt)
    {
      return (String)this.y.get(paramInt);
    }
    
    public int getNormall4LabCount()
    {
      return this.y.size();
    }
    
    public List<String> getNormall4LabList()
    {
      return this.y;
    }
    
    public int getNormall5()
    {
      return this.q;
    }
    
    public Template.Composit getNormall6()
    {
      return this.s;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasNormall1C1()) {}
      for (int i1 = CodedOutputStreamMicro.computeMessageSize(1, getNormall1C1()) + 0;; i1 = 0)
      {
        Iterator localIterator = getNormall1C2List().iterator();
        for (int i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(2, (Template.Resource)localIterator.next()) + i2) {}
        i1 = i2;
        if (hasNormall1C3()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(3, getNormall1C3());
        }
        i2 = i1;
        if (hasNormall2C1()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(4, getNormall2C1());
        }
        i1 = i2;
        if (hasNormall2C2()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(5, getNormall2C2());
        }
        i2 = i1;
        if (hasNormall2C3()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(6, getNormall2C3());
        }
        i1 = i2;
        if (hasNormall3()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(7, getNormall3());
        }
        i2 = i1;
        if (hasNormall4()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(8, getNormall4());
        }
        i1 = i2;
        if (hasNormall5()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(9, getNormall5());
        }
        i2 = i1;
        if (hasNormall6()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(10, getNormall6());
        }
        i1 = i2;
        if (hasUpperleftcorner()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(11, getUpperleftcorner());
        }
        localIterator = getFlagList().iterator();
        for (i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i2) {}
        i1 = i1 + i2 + getFlagList().size() * 1;
        if (hasFanormall5()) {
          i1 += CodedOutputStreamMicro.computeMessageSize(13, getFanormall5());
        }
        for (;;)
        {
          localIterator = getNormall4LabList().iterator();
          i2 = i3;
          while (localIterator.hasNext()) {
            i2 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
          }
          i1 = i1 + i2 + getNormall4LabList().size() * 1;
          this.z = i1;
          return i1;
        }
      }
    }
    
    public Template.Resource getUpperleftcorner()
    {
      return this.u;
    }
    
    public boolean hasFanormall5()
    {
      return this.w;
    }
    
    public boolean hasNormall1C1()
    {
      return this.a;
    }
    
    public boolean hasNormall1C3()
    {
      return this.d;
    }
    
    public boolean hasNormall2C1()
    {
      return this.f;
    }
    
    public boolean hasNormall2C2()
    {
      return this.h;
    }
    
    public boolean hasNormall2C3()
    {
      return this.j;
    }
    
    public boolean hasNormall3()
    {
      return this.l;
    }
    
    public boolean hasNormall4()
    {
      return this.n;
    }
    
    public boolean hasNormall5()
    {
      return this.p;
    }
    
    public boolean hasNormall6()
    {
      return this.r;
    }
    
    public boolean hasUpperleftcorner()
    {
      return this.t;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public NormalTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setNormall1C1((Template.RichText)localObject);
          break;
        case 18: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addNormall1C2((Template.Resource)localObject);
          break;
        case 26: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setNormall1C3((Template.RichText)localObject);
          break;
        case 34: 
          setNormall2C1(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setNormall2C2((Template.RichText)localObject);
          break;
        case 50: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setNormall2C3((Template.RichText)localObject);
          break;
        case 58: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setNormall3((Template.RichText)localObject);
          break;
        case 66: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setNormall4((Template.RichText)localObject);
          break;
        case 72: 
          setNormall5(paramCodedInputStreamMicro.readInt32());
          break;
        case 82: 
          localObject = new Template.Composit();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setNormall6((Template.Composit)localObject);
          break;
        case 90: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUpperleftcorner((Template.Resource)localObject);
          break;
        case 98: 
          addFlag(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          localObject = new Template.Fatherson();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setFanormall5((Template.Fatherson)localObject);
          break;
        case 114: 
          addNormall4Lab(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public NormalTemplate setFanormall5(Template.Fatherson paramFatherson)
    {
      if (paramFatherson == null) {
        return clearFanormall5();
      }
      this.w = true;
      this.x = paramFatherson;
      return this;
    }
    
    public NormalTemplate setFlag(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.v.set(paramInt, paramString);
      return this;
    }
    
    public NormalTemplate setNormall1C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearNormall1C1();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public NormalTemplate setNormall1C2(int paramInt, Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      this.c.set(paramInt, paramResource);
      return this;
    }
    
    public NormalTemplate setNormall1C3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearNormall1C3();
      }
      this.d = true;
      this.e = paramRichText;
      return this;
    }
    
    public NormalTemplate setNormall2C1(String paramString)
    {
      this.f = true;
      this.g = paramString;
      return this;
    }
    
    public NormalTemplate setNormall2C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearNormall2C2();
      }
      this.h = true;
      this.i = paramRichText;
      return this;
    }
    
    public NormalTemplate setNormall2C3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearNormall2C3();
      }
      this.j = true;
      this.k = paramRichText;
      return this;
    }
    
    public NormalTemplate setNormall3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearNormall3();
      }
      this.l = true;
      this.m = paramRichText;
      return this;
    }
    
    public NormalTemplate setNormall4(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearNormall4();
      }
      this.n = true;
      this.o = paramRichText;
      return this;
    }
    
    public NormalTemplate setNormall4Lab(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.y.set(paramInt, paramString);
      return this;
    }
    
    public NormalTemplate setNormall5(int paramInt)
    {
      this.p = true;
      this.q = paramInt;
      return this;
    }
    
    public NormalTemplate setNormall6(Template.Composit paramComposit)
    {
      if (paramComposit == null) {
        return clearNormall6();
      }
      this.r = true;
      this.s = paramComposit;
      return this;
    }
    
    public NormalTemplate setUpperleftcorner(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return clearUpperleftcorner();
      }
      this.t = true;
      this.u = paramResource;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasNormall1C1()) {
        paramCodedOutputStreamMicro.writeMessage(1, getNormall1C1());
      }
      Iterator localIterator = getNormall1C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Template.Resource)localIterator.next());
      }
      if (hasNormall1C3()) {
        paramCodedOutputStreamMicro.writeMessage(3, getNormall1C3());
      }
      if (hasNormall2C1()) {
        paramCodedOutputStreamMicro.writeString(4, getNormall2C1());
      }
      if (hasNormall2C2()) {
        paramCodedOutputStreamMicro.writeMessage(5, getNormall2C2());
      }
      if (hasNormall2C3()) {
        paramCodedOutputStreamMicro.writeMessage(6, getNormall2C3());
      }
      if (hasNormall3()) {
        paramCodedOutputStreamMicro.writeMessage(7, getNormall3());
      }
      if (hasNormall4()) {
        paramCodedOutputStreamMicro.writeMessage(8, getNormall4());
      }
      if (hasNormall5()) {
        paramCodedOutputStreamMicro.writeInt32(9, getNormall5());
      }
      if (hasNormall6()) {
        paramCodedOutputStreamMicro.writeMessage(10, getNormall6());
      }
      if (hasUpperleftcorner()) {
        paramCodedOutputStreamMicro.writeMessage(11, getUpperleftcorner());
      }
      localIterator = getFlagList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(12, (String)localIterator.next());
      }
      if (hasFanormall5()) {
        paramCodedOutputStreamMicro.writeMessage(13, getFanormall5());
      }
      localIterator = getNormall4LabList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(14, (String)localIterator.next());
      }
    }
  }
  
  public static final class PanelTemplate
    extends MessageMicro
  {
    public static final int PANELL1C1_FIELD_NUMBER = 1;
    public static final int PANELL1C2_FIELD_NUMBER = 2;
    public static final int PANELL2C1_FIELD_NUMBER = 3;
    public static final int PANELL2C2_FIELD_NUMBER = 4;
    public static final int PANELL2C3_FIELD_NUMBER = 5;
    public static final int PANELL3_FIELD_NUMBER = 6;
    public static final int UPPERLEFTCORNER_FIELD_NUMBER = 7;
    private boolean a;
    private Template.RichText b = null;
    private List<Template.Resource> c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private boolean f;
    private Template.RichText g = null;
    private boolean h;
    private Template.RichText i = null;
    private boolean j;
    private Template.RichText k = null;
    private boolean l;
    private Template.Resource m = null;
    private int n = -1;
    
    public static PanelTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new PanelTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static PanelTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (PanelTemplate)new PanelTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public PanelTemplate addPanell1C2(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramResource);
      return this;
    }
    
    public final PanelTemplate clear()
    {
      clearPanell1C1();
      clearPanell1C2();
      clearPanell2C1();
      clearPanell2C2();
      clearPanell2C3();
      clearPanell3();
      clearUpperleftcorner();
      this.n = -1;
      return this;
    }
    
    public PanelTemplate clearPanell1C1()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public PanelTemplate clearPanell1C2()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public PanelTemplate clearPanell2C1()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public PanelTemplate clearPanell2C2()
    {
      this.f = false;
      this.g = null;
      return this;
    }
    
    public PanelTemplate clearPanell2C3()
    {
      this.h = false;
      this.i = null;
      return this;
    }
    
    public PanelTemplate clearPanell3()
    {
      this.j = false;
      this.k = null;
      return this;
    }
    
    public PanelTemplate clearUpperleftcorner()
    {
      this.l = false;
      this.m = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.n < 0) {
        getSerializedSize();
      }
      return this.n;
    }
    
    public Template.RichText getPanell1C1()
    {
      return this.b;
    }
    
    public Template.Resource getPanell1C2(int paramInt)
    {
      return (Template.Resource)this.c.get(paramInt);
    }
    
    public int getPanell1C2Count()
    {
      return this.c.size();
    }
    
    public List<Template.Resource> getPanell1C2List()
    {
      return this.c;
    }
    
    public String getPanell2C1()
    {
      return this.e;
    }
    
    public Template.RichText getPanell2C2()
    {
      return this.g;
    }
    
    public Template.RichText getPanell2C3()
    {
      return this.i;
    }
    
    public Template.RichText getPanell3()
    {
      return this.k;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasPanell1C1()) {
        i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getPanell1C1());
      }
      Iterator localIterator = getPanell1C2List().iterator();
      for (int i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(2, (Template.Resource)localIterator.next()) + i2) {}
      i1 = i2;
      if (hasPanell2C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(3, getPanell2C1());
      }
      i2 = i1;
      if (hasPanell2C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(4, getPanell2C2());
      }
      i1 = i2;
      if (hasPanell2C3()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(5, getPanell2C3());
      }
      i2 = i1;
      if (hasPanell3()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(6, getPanell3());
      }
      i1 = i2;
      if (hasUpperleftcorner()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(7, getUpperleftcorner());
      }
      this.n = i1;
      return i1;
    }
    
    public Template.Resource getUpperleftcorner()
    {
      return this.m;
    }
    
    public boolean hasPanell1C1()
    {
      return this.a;
    }
    
    public boolean hasPanell2C1()
    {
      return this.d;
    }
    
    public boolean hasPanell2C2()
    {
      return this.f;
    }
    
    public boolean hasPanell2C3()
    {
      return this.h;
    }
    
    public boolean hasPanell3()
    {
      return this.j;
    }
    
    public boolean hasUpperleftcorner()
    {
      return this.l;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public PanelTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setPanell1C1((Template.RichText)localObject);
          break;
        case 18: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addPanell1C2((Template.Resource)localObject);
          break;
        case 26: 
          setPanell2C1(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setPanell2C2((Template.RichText)localObject);
          break;
        case 42: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setPanell2C3((Template.RichText)localObject);
          break;
        case 50: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setPanell3((Template.RichText)localObject);
          break;
        case 58: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUpperleftcorner((Template.Resource)localObject);
        }
      }
    }
    
    public PanelTemplate setPanell1C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearPanell1C1();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public PanelTemplate setPanell1C2(int paramInt, Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      this.c.set(paramInt, paramResource);
      return this;
    }
    
    public PanelTemplate setPanell2C1(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public PanelTemplate setPanell2C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearPanell2C2();
      }
      this.f = true;
      this.g = paramRichText;
      return this;
    }
    
    public PanelTemplate setPanell2C3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearPanell2C3();
      }
      this.h = true;
      this.i = paramRichText;
      return this;
    }
    
    public PanelTemplate setPanell3(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearPanell3();
      }
      this.j = true;
      this.k = paramRichText;
      return this;
    }
    
    public PanelTemplate setUpperleftcorner(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return clearUpperleftcorner();
      }
      this.l = true;
      this.m = paramResource;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPanell1C1()) {
        paramCodedOutputStreamMicro.writeMessage(1, getPanell1C1());
      }
      Iterator localIterator = getPanell1C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Template.Resource)localIterator.next());
      }
      if (hasPanell2C1()) {
        paramCodedOutputStreamMicro.writeString(3, getPanell2C1());
      }
      if (hasPanell2C2()) {
        paramCodedOutputStreamMicro.writeMessage(4, getPanell2C2());
      }
      if (hasPanell2C3()) {
        paramCodedOutputStreamMicro.writeMessage(5, getPanell2C3());
      }
      if (hasPanell3()) {
        paramCodedOutputStreamMicro.writeMessage(6, getPanell3());
      }
      if (hasUpperleftcorner()) {
        paramCodedOutputStreamMicro.writeMessage(7, getUpperleftcorner());
      }
    }
  }
  
  public static final class Resource
    extends MessageMicro
  {
    public static final int RESOURCE_ID_FIELD_NUMBER = 1;
    public static final int RESOURCE_URL_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static Resource parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Resource().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Resource parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Resource)new Resource().mergeFrom(paramArrayOfByte);
    }
    
    public final Resource clear()
    {
      clearResourceId();
      clearResourceUrl();
      this.e = -1;
      return this;
    }
    
    public Resource clearResourceId()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Resource clearResourceUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public int getResourceId()
    {
      return this.b;
    }
    
    public String getResourceUrl()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasResourceId()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getResourceId());
      }
      int j = i;
      if (hasResourceUrl()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getResourceUrl());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasResourceId()
    {
      return this.a;
    }
    
    public boolean hasResourceUrl()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Resource mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setResourceId(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setResourceUrl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Resource setResourceId(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Resource setResourceUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasResourceId()) {
        paramCodedOutputStreamMicro.writeInt32(1, getResourceId());
      }
      if (hasResourceUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getResourceUrl());
      }
    }
  }
  
  public static final class RichText
    extends MessageMicro
  {
    public static final int ORI_VALUE_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static RichText parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new RichText().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static RichText parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (RichText)new RichText().mergeFrom(paramArrayOfByte);
    }
    
    public final RichText clear()
    {
      clearOriValue();
      clearValue();
      this.e = -1;
      return this;
    }
    
    public RichText clearOriValue()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public RichText clearValue()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public int getOriValue()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasOriValue()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getOriValue());
      }
      int j = i;
      if (hasValue()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getValue());
      }
      this.e = j;
      return j;
    }
    
    public String getValue()
    {
      return this.d;
    }
    
    public boolean hasOriValue()
    {
      return this.a;
    }
    
    public boolean hasValue()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public RichText mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setOriValue(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setValue(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public RichText setOriValue(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public RichText setValue(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasOriValue()) {
        paramCodedOutputStreamMicro.writeInt32(1, getOriValue());
      }
      if (hasValue()) {
        paramCodedOutputStreamMicro.writeString(2, getValue());
      }
    }
  }
  
  public static final class ScatterStyle
    extends MessageMicro
  {
    public static final int COLOR_VALUE_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static ScatterStyle parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ScatterStyle().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ScatterStyle parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ScatterStyle)new ScatterStyle().mergeFrom(paramArrayOfByte);
    }
    
    public final ScatterStyle clear()
    {
      clearColorValue();
      clearValue();
      this.e = -1;
      return this;
    }
    
    public ScatterStyle clearColorValue()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public ScatterStyle clearValue()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public int getColorValue()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasColorValue()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getColorValue());
      }
      int j = i;
      if (hasValue()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getValue());
      }
      this.e = j;
      return j;
    }
    
    public String getValue()
    {
      return this.d;
    }
    
    public boolean hasColorValue()
    {
      return this.a;
    }
    
    public boolean hasValue()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ScatterStyle mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setColorValue(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setValue(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ScatterStyle setColorValue(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public ScatterStyle setValue(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasColorValue()) {
        paramCodedOutputStreamMicro.writeInt32(1, getColorValue());
      }
      if (hasValue()) {
        paramCodedOutputStreamMicro.writeString(2, getValue());
      }
    }
  }
  
  public static final class Score
    extends MessageMicro
  {
    public static final int TEXT_FIELD_NUMBER = 2;
    public static final int VAL_FIELD_NUMBER = 1;
    private boolean a;
    private float b = 0.0F;
    private boolean c;
    private Template.RichText d = null;
    private int e = -1;
    
    public static Score parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Score().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Score parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Score)new Score().mergeFrom(paramArrayOfByte);
    }
    
    public final Score clear()
    {
      clearVal();
      clearText();
      this.e = -1;
      return this;
    }
    
    public Score clearText()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public Score clearVal()
    {
      this.a = false;
      this.b = 0.0F;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasVal()) {
        i = 0 + CodedOutputStreamMicro.computeFloatSize(1, getVal());
      }
      int j = i;
      if (hasText()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getText());
      }
      this.e = j;
      return j;
    }
    
    public Template.RichText getText()
    {
      return this.d;
    }
    
    public float getVal()
    {
      return this.b;
    }
    
    public boolean hasText()
    {
      return this.c;
    }
    
    public boolean hasVal()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Score mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 13: 
          setVal(paramCodedInputStreamMicro.readFloat());
          break;
        case 18: 
          Template.RichText localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setText(localRichText);
        }
      }
    }
    
    public Score setText(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearText();
      }
      this.c = true;
      this.d = paramRichText;
      return this;
    }
    
    public Score setVal(float paramFloat)
    {
      this.a = true;
      this.b = paramFloat;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasVal()) {
        paramCodedOutputStreamMicro.writeFloat(1, getVal());
      }
      if (hasText()) {
        paramCodedOutputStreamMicro.writeMessage(2, getText());
      }
    }
  }
  
  public static final class SingleCardTemplate
    extends MessageMicro
  {
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
    private boolean a;
    private Template.RichText b = null;
    private boolean c;
    private Template.RichText d = null;
    private List<Template.ScatterStyle> e = Collections.emptyList();
    private boolean f;
    private Template.Score g = null;
    private boolean h;
    private Template.RichText i = null;
    private List<Template.ScatterStyle> j = Collections.emptyList();
    private boolean k;
    private Template.RichText l = null;
    private List<Template.ComboBox> m = Collections.emptyList();
    private List<Template.ChildrenBtn> n = Collections.emptyList();
    private boolean o;
    private Template.ComboBox p = null;
    private int q = -1;
    
    public static SingleCardTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SingleCardTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SingleCardTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SingleCardTemplate)new SingleCardTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public SingleCardTemplate addL2C2(Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramScatterStyle);
      return this;
    }
    
    public SingleCardTemplate addL3C3(Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      if (this.j.isEmpty()) {
        this.j = new ArrayList();
      }
      this.j.add(paramScatterStyle);
      return this;
    }
    
    public SingleCardTemplate addL4C2(Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return this;
      }
      if (this.m.isEmpty()) {
        this.m = new ArrayList();
      }
      this.m.add(paramComboBox);
      return this;
    }
    
    public SingleCardTemplate addL5(Template.ChildrenBtn paramChildrenBtn)
    {
      if (paramChildrenBtn == null) {
        return this;
      }
      if (this.n.isEmpty()) {
        this.n = new ArrayList();
      }
      this.n.add(paramChildrenBtn);
      return this;
    }
    
    public final SingleCardTemplate clear()
    {
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
      this.q = -1;
      return this;
    }
    
    public SingleCardTemplate clearL1C1()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public SingleCardTemplate clearL2C1()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public SingleCardTemplate clearL2C2()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public SingleCardTemplate clearL3C1()
    {
      this.f = false;
      this.g = null;
      return this;
    }
    
    public SingleCardTemplate clearL3C2()
    {
      this.h = false;
      this.i = null;
      return this;
    }
    
    public SingleCardTemplate clearL3C3()
    {
      this.j = Collections.emptyList();
      return this;
    }
    
    public SingleCardTemplate clearL4C1()
    {
      this.k = false;
      this.l = null;
      return this;
    }
    
    public SingleCardTemplate clearL4C2()
    {
      this.m = Collections.emptyList();
      return this;
    }
    
    public SingleCardTemplate clearL5()
    {
      this.n = Collections.emptyList();
      return this;
    }
    
    public SingleCardTemplate clearL6()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.q < 0) {
        getSerializedSize();
      }
      return this.q;
    }
    
    public Template.RichText getL1C1()
    {
      return this.b;
    }
    
    public Template.RichText getL2C1()
    {
      return this.d;
    }
    
    public Template.ScatterStyle getL2C2(int paramInt)
    {
      return (Template.ScatterStyle)this.e.get(paramInt);
    }
    
    public int getL2C2Count()
    {
      return this.e.size();
    }
    
    public List<Template.ScatterStyle> getL2C2List()
    {
      return this.e;
    }
    
    public Template.Score getL3C1()
    {
      return this.g;
    }
    
    public Template.RichText getL3C2()
    {
      return this.i;
    }
    
    public Template.ScatterStyle getL3C3(int paramInt)
    {
      return (Template.ScatterStyle)this.j.get(paramInt);
    }
    
    public int getL3C3Count()
    {
      return this.j.size();
    }
    
    public List<Template.ScatterStyle> getL3C3List()
    {
      return this.j;
    }
    
    public Template.RichText getL4C1()
    {
      return this.l;
    }
    
    public Template.ComboBox getL4C2(int paramInt)
    {
      return (Template.ComboBox)this.m.get(paramInt);
    }
    
    public int getL4C2Count()
    {
      return this.m.size();
    }
    
    public List<Template.ComboBox> getL4C2List()
    {
      return this.m;
    }
    
    public Template.ChildrenBtn getL5(int paramInt)
    {
      return (Template.ChildrenBtn)this.n.get(paramInt);
    }
    
    public int getL5Count()
    {
      return this.n.size();
    }
    
    public List<Template.ChildrenBtn> getL5List()
    {
      return this.n;
    }
    
    public Template.ComboBox getL6()
    {
      return this.p;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasL1C1()) {
        i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getL1C1());
      }
      int i2 = i1;
      if (hasL2C1()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(2, getL2C1());
      }
      Iterator localIterator = getL2C2List().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(3, (Template.ScatterStyle)localIterator.next()) + i2;
      }
      i1 = i2;
      if (hasL3C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getL3C1());
      }
      i2 = i1;
      if (hasL3C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getL3C2());
      }
      localIterator = getL3C3List().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(6, (Template.ScatterStyle)localIterator.next());
      }
      i1 = i2;
      if (hasL4C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(7, getL4C1());
      }
      localIterator = getL4C2List().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(8, (Template.ComboBox)localIterator.next());
      }
      localIterator = getL5List().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(9, (Template.ChildrenBtn)localIterator.next());
      }
      i2 = i1;
      if (hasL6()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(10, getL6());
      }
      this.q = i2;
      return i2;
    }
    
    public boolean hasL1C1()
    {
      return this.a;
    }
    
    public boolean hasL2C1()
    {
      return this.c;
    }
    
    public boolean hasL3C1()
    {
      return this.f;
    }
    
    public boolean hasL3C2()
    {
      return this.h;
    }
    
    public boolean hasL4C1()
    {
      return this.k;
    }
    
    public boolean hasL6()
    {
      return this.o;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SingleCardTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setL1C1((Template.RichText)localObject);
          break;
        case 18: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setL2C1((Template.RichText)localObject);
          break;
        case 26: 
          localObject = new Template.ScatterStyle();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addL2C2((Template.ScatterStyle)localObject);
          break;
        case 34: 
          localObject = new Template.Score();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setL3C1((Template.Score)localObject);
          break;
        case 42: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setL3C2((Template.RichText)localObject);
          break;
        case 50: 
          localObject = new Template.ScatterStyle();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addL3C3((Template.ScatterStyle)localObject);
          break;
        case 58: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setL4C1((Template.RichText)localObject);
          break;
        case 66: 
          localObject = new Template.ComboBox();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addL4C2((Template.ComboBox)localObject);
          break;
        case 74: 
          localObject = new Template.ChildrenBtn();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addL5((Template.ChildrenBtn)localObject);
          break;
        case 82: 
          localObject = new Template.ComboBox();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setL6((Template.ComboBox)localObject);
        }
      }
    }
    
    public SingleCardTemplate setL1C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearL1C1();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public SingleCardTemplate setL2C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearL2C1();
      }
      this.c = true;
      this.d = paramRichText;
      return this;
    }
    
    public SingleCardTemplate setL2C2(int paramInt, Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      this.e.set(paramInt, paramScatterStyle);
      return this;
    }
    
    public SingleCardTemplate setL3C1(Template.Score paramScore)
    {
      if (paramScore == null) {
        return clearL3C1();
      }
      this.f = true;
      this.g = paramScore;
      return this;
    }
    
    public SingleCardTemplate setL3C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearL3C2();
      }
      this.h = true;
      this.i = paramRichText;
      return this;
    }
    
    public SingleCardTemplate setL3C3(int paramInt, Template.ScatterStyle paramScatterStyle)
    {
      if (paramScatterStyle == null) {
        return this;
      }
      this.j.set(paramInt, paramScatterStyle);
      return this;
    }
    
    public SingleCardTemplate setL4C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearL4C1();
      }
      this.k = true;
      this.l = paramRichText;
      return this;
    }
    
    public SingleCardTemplate setL4C2(int paramInt, Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return this;
      }
      this.m.set(paramInt, paramComboBox);
      return this;
    }
    
    public SingleCardTemplate setL5(int paramInt, Template.ChildrenBtn paramChildrenBtn)
    {
      if (paramChildrenBtn == null) {
        return this;
      }
      this.n.set(paramInt, paramChildrenBtn);
      return this;
    }
    
    public SingleCardTemplate setL6(Template.ComboBox paramComboBox)
    {
      if (paramComboBox == null) {
        return clearL6();
      }
      this.o = true;
      this.p = paramComboBox;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasL1C1()) {
        paramCodedOutputStreamMicro.writeMessage(1, getL1C1());
      }
      if (hasL2C1()) {
        paramCodedOutputStreamMicro.writeMessage(2, getL2C1());
      }
      Iterator localIterator = getL2C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (Template.ScatterStyle)localIterator.next());
      }
      if (hasL3C1()) {
        paramCodedOutputStreamMicro.writeMessage(4, getL3C1());
      }
      if (hasL3C2()) {
        paramCodedOutputStreamMicro.writeMessage(5, getL3C2());
      }
      localIterator = getL3C3List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(6, (Template.ScatterStyle)localIterator.next());
      }
      if (hasL4C1()) {
        paramCodedOutputStreamMicro.writeMessage(7, getL4C1());
      }
      localIterator = getL4C2List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (Template.ComboBox)localIterator.next());
      }
      localIterator = getL5List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(9, (Template.ChildrenBtn)localIterator.next());
      }
      if (hasL6()) {
        paramCodedOutputStreamMicro.writeMessage(10, getL6());
      }
    }
  }
  
  public static final class VcomboText
    extends MessageMicro
  {
    public static final int ORI_FIELD_NUMBER = 1;
    public static final int VAL_FIELD_NUMBER = 2;
    private boolean a;
    private Template.RichText b = null;
    private boolean c;
    private Template.RichText d = null;
    private int e = -1;
    
    public static VcomboText parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new VcomboText().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static VcomboText parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (VcomboText)new VcomboText().mergeFrom(paramArrayOfByte);
    }
    
    public final VcomboText clear()
    {
      clearOri();
      clearVal();
      this.e = -1;
      return this;
    }
    
    public VcomboText clearOri()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public VcomboText clearVal()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public Template.RichText getOri()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasOri()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOri());
      }
      int j = i;
      if (hasVal()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getVal());
      }
      this.e = j;
      return j;
    }
    
    public Template.RichText getVal()
    {
      return this.d;
    }
    
    public boolean hasOri()
    {
      return this.a;
    }
    
    public boolean hasVal()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public VcomboText mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        Template.RichText localRichText;
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setOri(localRichText);
          break;
        case 18: 
          localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setVal(localRichText);
        }
      }
    }
    
    public VcomboText setOri(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearOri();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public VcomboText setVal(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearVal();
      }
      this.c = true;
      this.d = paramRichText;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasOri()) {
        paramCodedOutputStreamMicro.writeMessage(1, getOri());
      }
      if (hasVal()) {
        paramCodedOutputStreamMicro.writeMessage(2, getVal());
      }
    }
  }
  
  public static final class Vgray
    extends MessageMicro
  {
    public static final int LONG = 2;
    public static final int SHORT = 1;
    public static final int STYLE_FIELD_NUMBER = 2;
    public static final int TEXT_FIELD_NUMBER = 1;
    private boolean a;
    private Template.RichText b = null;
    private boolean c;
    private int d = 1;
    private int e = -1;
    
    public static Vgray parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Vgray().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Vgray parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Vgray)new Vgray().mergeFrom(paramArrayOfByte);
    }
    
    public final Vgray clear()
    {
      clearText();
      clearStyle();
      this.e = -1;
      return this;
    }
    
    public Vgray clearStyle()
    {
      this.c = false;
      this.d = 1;
      return this;
    }
    
    public Vgray clearText()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasText()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getText());
      }
      int j = i;
      if (hasStyle()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(2, getStyle());
      }
      this.e = j;
      return j;
    }
    
    public int getStyle()
    {
      return this.d;
    }
    
    public Template.RichText getText()
    {
      return this.b;
    }
    
    public boolean hasStyle()
    {
      return this.c;
    }
    
    public boolean hasText()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Vgray mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          Template.RichText localRichText = new Template.RichText();
          paramCodedInputStreamMicro.readMessage(localRichText);
          setText(localRichText);
          break;
        case 16: 
          setStyle(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Vgray setStyle(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Vgray setText(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearText();
      }
      this.a = true;
      this.b = paramRichText;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasText()) {
        paramCodedOutputStreamMicro.writeMessage(1, getText());
      }
      if (hasStyle()) {
        paramCodedOutputStreamMicro.writeInt32(2, getStyle());
      }
    }
  }
  
  public static final class Vmagicbox
    extends MessageMicro
  {
    public static final int RES_FIELD_NUMBER = 1;
    public static final int TEXT_FIELD_NUMBER = 2;
    private List<Template.Resource> a = Collections.emptyList();
    private boolean b;
    private Template.RichText c = null;
    private int d = -1;
    
    public static Vmagicbox parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Vmagicbox().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Vmagicbox parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Vmagicbox)new Vmagicbox().mergeFrom(paramArrayOfByte);
    }
    
    public Vmagicbox addRes(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramResource);
      return this;
    }
    
    public final Vmagicbox clear()
    {
      clearRes();
      clearText();
      this.d = -1;
      return this;
    }
    
    public Vmagicbox clearRes()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Vmagicbox clearText()
    {
      this.b = false;
      this.c = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public Template.Resource getRes(int paramInt)
    {
      return (Template.Resource)this.a.get(paramInt);
    }
    
    public int getResCount()
    {
      return this.a.size();
    }
    
    public List<Template.Resource> getResList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getResList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Template.Resource)localIterator.next()) + i) {}
      int j = i;
      if (hasText()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getText());
      }
      this.d = j;
      return j;
    }
    
    public Template.RichText getText()
    {
      return this.c;
    }
    
    public boolean hasText()
    {
      return this.b;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Vmagicbox mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addRes((Template.Resource)localObject);
          break;
        case 18: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setText((Template.RichText)localObject);
        }
      }
    }
    
    public Vmagicbox setRes(int paramInt, Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      this.a.set(paramInt, paramResource);
      return this;
    }
    
    public Vmagicbox setText(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearText();
      }
      this.b = true;
      this.c = paramRichText;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getResList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Template.Resource)localIterator.next());
      }
      if (hasText()) {
        paramCodedOutputStreamMicro.writeMessage(2, getText());
      }
    }
  }
  
  public static final class VtableTemplate
    extends MessageMicro
  {
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
    private int A = -1;
    private boolean a;
    private Template.Image b = null;
    private boolean c;
    private Template.RichText d = null;
    private List<Template.Resource> e = Collections.emptyList();
    private boolean f;
    private Template.RichText g = null;
    private boolean h;
    private Template.Score i = null;
    private boolean j;
    private Template.Vmagicbox k = null;
    private boolean l;
    private Template.VcomboText m = null;
    private boolean n;
    private Template.RichText o = null;
    private boolean p;
    private Template.RichText q = null;
    private List<Template.RichText> r = Collections.emptyList();
    private boolean s;
    private Template.Vgray t = null;
    private boolean u;
    private Template.Fatherson v = null;
    private boolean w;
    private Template.Composit x = null;
    private boolean y;
    private Template.Resource z = null;
    
    public static VtableTemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new VtableTemplate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static VtableTemplate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (VtableTemplate)new VtableTemplate().mergeFrom(paramArrayOfByte);
    }
    
    public VtableTemplate addR1C3(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramResource);
      return this;
    }
    
    public VtableTemplate addR5C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return this;
      }
      if (this.r.isEmpty()) {
        this.r = new ArrayList();
      }
      this.r.add(paramRichText);
      return this;
    }
    
    public final VtableTemplate clear()
    {
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
      this.A = -1;
      return this;
    }
    
    public VtableTemplate clearR1C1()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public VtableTemplate clearR1C2()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public VtableTemplate clearR1C3()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public VtableTemplate clearR2C1()
    {
      this.f = false;
      this.g = null;
      return this;
    }
    
    public VtableTemplate clearR3C1()
    {
      this.h = false;
      this.i = null;
      return this;
    }
    
    public VtableTemplate clearR3C2()
    {
      this.j = false;
      this.k = null;
      return this;
    }
    
    public VtableTemplate clearR3C3()
    {
      this.l = false;
      this.m = null;
      return this;
    }
    
    public VtableTemplate clearR4C1()
    {
      this.n = false;
      this.o = null;
      return this;
    }
    
    public VtableTemplate clearR4C2()
    {
      this.p = false;
      this.q = null;
      return this;
    }
    
    public VtableTemplate clearR5C1()
    {
      this.r = Collections.emptyList();
      return this;
    }
    
    public VtableTemplate clearR6C1()
    {
      this.s = false;
      this.t = null;
      return this;
    }
    
    public VtableTemplate clearR7C1()
    {
      this.u = false;
      this.v = null;
      return this;
    }
    
    public VtableTemplate clearR8C1()
    {
      this.w = false;
      this.x = null;
      return this;
    }
    
    public VtableTemplate clearUpperleftcorner()
    {
      this.y = false;
      this.z = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.A < 0) {
        getSerializedSize();
      }
      return this.A;
    }
    
    public Template.Image getR1C1()
    {
      return this.b;
    }
    
    public Template.RichText getR1C2()
    {
      return this.d;
    }
    
    public Template.Resource getR1C3(int paramInt)
    {
      return (Template.Resource)this.e.get(paramInt);
    }
    
    public int getR1C3Count()
    {
      return this.e.size();
    }
    
    public List<Template.Resource> getR1C3List()
    {
      return this.e;
    }
    
    public Template.RichText getR2C1()
    {
      return this.g;
    }
    
    public Template.Score getR3C1()
    {
      return this.i;
    }
    
    public Template.Vmagicbox getR3C2()
    {
      return this.k;
    }
    
    public Template.VcomboText getR3C3()
    {
      return this.m;
    }
    
    public Template.RichText getR4C1()
    {
      return this.o;
    }
    
    public Template.RichText getR4C2()
    {
      return this.q;
    }
    
    public Template.RichText getR5C1(int paramInt)
    {
      return (Template.RichText)this.r.get(paramInt);
    }
    
    public int getR5C1Count()
    {
      return this.r.size();
    }
    
    public List<Template.RichText> getR5C1List()
    {
      return this.r;
    }
    
    public Template.Vgray getR6C1()
    {
      return this.t;
    }
    
    public Template.Fatherson getR7C1()
    {
      return this.v;
    }
    
    public Template.Composit getR8C1()
    {
      return this.x;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasR1C1()) {
        i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getR1C1());
      }
      int i2 = i1;
      if (hasR1C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(2, getR1C2());
      }
      Iterator localIterator = getR1C3List().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(3, (Template.Resource)localIterator.next()) + i2;
      }
      i1 = i2;
      if (hasR2C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getR2C1());
      }
      i2 = i1;
      if (hasR3C1()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getR3C1());
      }
      i1 = i2;
      if (hasR3C2()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getR3C2());
      }
      i2 = i1;
      if (hasR3C3()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getR3C3());
      }
      i1 = i2;
      if (hasR4C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getR4C1());
      }
      i2 = i1;
      if (hasR4C2()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(9, getR4C2());
      }
      localIterator = getR5C1List().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(10, (Template.RichText)localIterator.next());
      }
      i1 = i2;
      if (hasR6C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(11, getR6C1());
      }
      i2 = i1;
      if (hasR7C1()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(12, getR7C1());
      }
      i1 = i2;
      if (hasR8C1()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(13, getR8C1());
      }
      i2 = i1;
      if (hasUpperleftcorner()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(14, getUpperleftcorner());
      }
      this.A = i2;
      return i2;
    }
    
    public Template.Resource getUpperleftcorner()
    {
      return this.z;
    }
    
    public boolean hasR1C1()
    {
      return this.a;
    }
    
    public boolean hasR1C2()
    {
      return this.c;
    }
    
    public boolean hasR2C1()
    {
      return this.f;
    }
    
    public boolean hasR3C1()
    {
      return this.h;
    }
    
    public boolean hasR3C2()
    {
      return this.j;
    }
    
    public boolean hasR3C3()
    {
      return this.l;
    }
    
    public boolean hasR4C1()
    {
      return this.n;
    }
    
    public boolean hasR4C2()
    {
      return this.p;
    }
    
    public boolean hasR6C1()
    {
      return this.s;
    }
    
    public boolean hasR7C1()
    {
      return this.u;
    }
    
    public boolean hasR8C1()
    {
      return this.w;
    }
    
    public boolean hasUpperleftcorner()
    {
      return this.y;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public VtableTemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Template.Image();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR1C1((Template.Image)localObject);
          break;
        case 18: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR1C2((Template.RichText)localObject);
          break;
        case 26: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR1C3((Template.Resource)localObject);
          break;
        case 34: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR2C1((Template.RichText)localObject);
          break;
        case 42: 
          localObject = new Template.Score();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR3C1((Template.Score)localObject);
          break;
        case 50: 
          localObject = new Template.Vmagicbox();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR3C2((Template.Vmagicbox)localObject);
          break;
        case 58: 
          localObject = new Template.VcomboText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR3C3((Template.VcomboText)localObject);
          break;
        case 66: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR4C1((Template.RichText)localObject);
          break;
        case 74: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR4C2((Template.RichText)localObject);
          break;
        case 82: 
          localObject = new Template.RichText();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addR5C1((Template.RichText)localObject);
          break;
        case 90: 
          localObject = new Template.Vgray();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR6C1((Template.Vgray)localObject);
          break;
        case 98: 
          localObject = new Template.Fatherson();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR7C1((Template.Fatherson)localObject);
          break;
        case 106: 
          localObject = new Template.Composit();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setR8C1((Template.Composit)localObject);
          break;
        case 114: 
          localObject = new Template.Resource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUpperleftcorner((Template.Resource)localObject);
        }
      }
    }
    
    public VtableTemplate setR1C1(Template.Image paramImage)
    {
      if (paramImage == null) {
        return clearR1C1();
      }
      this.a = true;
      this.b = paramImage;
      return this;
    }
    
    public VtableTemplate setR1C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR1C2();
      }
      this.c = true;
      this.d = paramRichText;
      return this;
    }
    
    public VtableTemplate setR1C3(int paramInt, Template.Resource paramResource)
    {
      if (paramResource == null) {
        return this;
      }
      this.e.set(paramInt, paramResource);
      return this;
    }
    
    public VtableTemplate setR2C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR2C1();
      }
      this.f = true;
      this.g = paramRichText;
      return this;
    }
    
    public VtableTemplate setR3C1(Template.Score paramScore)
    {
      if (paramScore == null) {
        return clearR3C1();
      }
      this.h = true;
      this.i = paramScore;
      return this;
    }
    
    public VtableTemplate setR3C2(Template.Vmagicbox paramVmagicbox)
    {
      if (paramVmagicbox == null) {
        return clearR3C2();
      }
      this.j = true;
      this.k = paramVmagicbox;
      return this;
    }
    
    public VtableTemplate setR3C3(Template.VcomboText paramVcomboText)
    {
      if (paramVcomboText == null) {
        return clearR3C3();
      }
      this.l = true;
      this.m = paramVcomboText;
      return this;
    }
    
    public VtableTemplate setR4C1(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR4C1();
      }
      this.n = true;
      this.o = paramRichText;
      return this;
    }
    
    public VtableTemplate setR4C2(Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return clearR4C2();
      }
      this.p = true;
      this.q = paramRichText;
      return this;
    }
    
    public VtableTemplate setR5C1(int paramInt, Template.RichText paramRichText)
    {
      if (paramRichText == null) {
        return this;
      }
      this.r.set(paramInt, paramRichText);
      return this;
    }
    
    public VtableTemplate setR6C1(Template.Vgray paramVgray)
    {
      if (paramVgray == null) {
        return clearR6C1();
      }
      this.s = true;
      this.t = paramVgray;
      return this;
    }
    
    public VtableTemplate setR7C1(Template.Fatherson paramFatherson)
    {
      if (paramFatherson == null) {
        return clearR7C1();
      }
      this.u = true;
      this.v = paramFatherson;
      return this;
    }
    
    public VtableTemplate setR8C1(Template.Composit paramComposit)
    {
      if (paramComposit == null) {
        return clearR8C1();
      }
      this.w = true;
      this.x = paramComposit;
      return this;
    }
    
    public VtableTemplate setUpperleftcorner(Template.Resource paramResource)
    {
      if (paramResource == null) {
        return clearUpperleftcorner();
      }
      this.y = true;
      this.z = paramResource;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasR1C1()) {
        paramCodedOutputStreamMicro.writeMessage(1, getR1C1());
      }
      if (hasR1C2()) {
        paramCodedOutputStreamMicro.writeMessage(2, getR1C2());
      }
      Iterator localIterator = getR1C3List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (Template.Resource)localIterator.next());
      }
      if (hasR2C1()) {
        paramCodedOutputStreamMicro.writeMessage(4, getR2C1());
      }
      if (hasR3C1()) {
        paramCodedOutputStreamMicro.writeMessage(5, getR3C1());
      }
      if (hasR3C2()) {
        paramCodedOutputStreamMicro.writeMessage(6, getR3C2());
      }
      if (hasR3C3()) {
        paramCodedOutputStreamMicro.writeMessage(7, getR3C3());
      }
      if (hasR4C1()) {
        paramCodedOutputStreamMicro.writeMessage(8, getR4C1());
      }
      if (hasR4C2()) {
        paramCodedOutputStreamMicro.writeMessage(9, getR4C2());
      }
      localIterator = getR5C1List().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(10, (Template.RichText)localIterator.next());
      }
      if (hasR6C1()) {
        paramCodedOutputStreamMicro.writeMessage(11, getR6C1());
      }
      if (hasR7C1()) {
        paramCodedOutputStreamMicro.writeMessage(12, getR7C1());
      }
      if (hasR8C1()) {
        paramCodedOutputStreamMicro.writeMessage(13, getR8C1());
      }
      if (hasUpperleftcorner()) {
        paramCodedOutputStreamMicro.writeMessage(14, getUpperleftcorner());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Template.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */