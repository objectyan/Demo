package com.google.zxing.common.reedsolomon;

public final class GenericGF
{
  public static final GenericGF AZTEC_DATA_10;
  public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, 4096);
  public static final GenericGF AZTEC_DATA_6;
  public static final GenericGF AZTEC_DATA_8 = DATA_MATRIX_FIELD_256;
  public static final GenericGF AZTEC_PARAM;
  public static final GenericGF DATA_MATRIX_FIELD_256;
  private static final int INITIALIZATION_THRESHOLD = 0;
  public static final GenericGF MAXICODE_FIELD_64 = AZTEC_DATA_6;
  public static final GenericGF QR_CODE_FIELD_256;
  private int[] expTable;
  private boolean initialized = false;
  private int[] logTable;
  private GenericGFPoly one;
  private final int primitive;
  private final int size;
  private GenericGFPoly zero;
  
  static
  {
    AZTEC_DATA_10 = new GenericGF(1033, 1024);
    AZTEC_DATA_6 = new GenericGF(67, 64);
    AZTEC_PARAM = new GenericGF(19, 16);
    QR_CODE_FIELD_256 = new GenericGF(285, 256);
    DATA_MATRIX_FIELD_256 = new GenericGF(301, 256);
  }
  
  public GenericGF(int paramInt1, int paramInt2)
  {
    this.primitive = paramInt1;
    this.size = paramInt2;
    if (paramInt2 <= 0) {
      initialize();
    }
  }
  
  static int addOrSubtract(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  private void checkInit()
  {
    if (!this.initialized) {
      initialize();
    }
  }
  
  private void initialize()
  {
    this.expTable = new int[this.size];
    this.logTable = new int[this.size];
    int i = 1;
    int j = 0;
    while (j < this.size)
    {
      this.expTable[j] = i;
      int k = i << 1;
      i = k;
      if (k >= this.size) {
        i = (k ^ this.primitive) & this.size - 1;
      }
      j += 1;
    }
    i = 0;
    while (i < this.size - 1)
    {
      this.logTable[this.expTable[i]] = i;
      i += 1;
    }
    this.zero = new GenericGFPoly(this, new int[] { 0 });
    this.one = new GenericGFPoly(this, new int[] { 1 });
    this.initialized = true;
  }
  
  GenericGFPoly buildMonomial(int paramInt1, int paramInt2)
  {
    checkInit();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.zero;
    }
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new GenericGFPoly(this, arrayOfInt);
  }
  
  int exp(int paramInt)
  {
    checkInit();
    return this.expTable[paramInt];
  }
  
  GenericGFPoly getOne()
  {
    checkInit();
    return this.one;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  GenericGFPoly getZero()
  {
    checkInit();
    return this.zero;
  }
  
  int inverse(int paramInt)
  {
    checkInit();
    if (paramInt == 0) {
      throw new ArithmeticException();
    }
    return this.expTable[(this.size - this.logTable[paramInt] - 1)];
  }
  
  int log(int paramInt)
  {
    checkInit();
    if (paramInt == 0) {
      throw new IllegalArgumentException();
    }
    return this.logTable[paramInt];
  }
  
  int multiply(int paramInt1, int paramInt2)
  {
    checkInit();
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    int i;
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 < this.size))
    {
      i = paramInt1;
      if (paramInt2 < this.size) {}
    }
    else
    {
      i = paramInt1 + 1;
    }
    paramInt1 = this.logTable[i] + this.logTable[paramInt2];
    return this.expTable[(paramInt1 % this.size + paramInt1 / this.size)];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/common/reedsolomon/GenericGF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */