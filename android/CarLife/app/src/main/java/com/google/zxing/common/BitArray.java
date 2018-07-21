package com.google.zxing.common;

public final class BitArray
{
  private int[] bits;
  private int size;
  
  public BitArray()
  {
    this.size = 0;
    this.bits = new int[1];
  }
  
  public BitArray(int paramInt)
  {
    this.size = paramInt;
    this.bits = makeArray(paramInt);
  }
  
  private void ensureCapacity(int paramInt)
  {
    if (paramInt > this.bits.length << 5)
    {
      int[] arrayOfInt = makeArray(paramInt);
      System.arraycopy(this.bits, 0, arrayOfInt, 0, this.bits.length);
      this.bits = arrayOfInt;
    }
  }
  
  private static int[] makeArray(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }
  
  public void appendBit(boolean paramBoolean)
  {
    ensureCapacity(this.size + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.bits;
      int i = this.size >> 5;
      arrayOfInt[i] |= 1 << (this.size & 0x1F);
    }
    this.size += 1;
  }
  
  public void appendBitArray(BitArray paramBitArray)
  {
    int j = paramBitArray.size;
    ensureCapacity(this.size + j);
    int i = 0;
    while (i < j)
    {
      appendBit(paramBitArray.get(i));
      i += 1;
    }
  }
  
  public void appendBits(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32)) {
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
    ensureCapacity(this.size + paramInt2);
    if (paramInt2 > 0)
    {
      if ((paramInt1 >> paramInt2 - 1 & 0x1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        appendBit(bool);
        paramInt2 -= 1;
        break;
      }
    }
  }
  
  public void clear()
  {
    int j = this.bits.length;
    int i = 0;
    while (i < j)
    {
      this.bits[i] = 0;
      i += 1;
    }
  }
  
  public void flip(int paramInt)
  {
    int[] arrayOfInt = this.bits;
    int i = paramInt >> 5;
    arrayOfInt[i] ^= 1 << (paramInt & 0x1F);
  }
  
  public boolean get(int paramInt)
  {
    return (this.bits[(paramInt >> 5)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public int[] getBitArray()
  {
    return this.bits;
  }
  
  public int getNextSet(int paramInt)
  {
    if (paramInt >= this.size) {
      paramInt = this.size;
    }
    int i;
    do
    {
      return paramInt;
      int j = paramInt >> 5;
      i = this.bits[j] & ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF);
      paramInt = j;
      while (i == 0)
      {
        paramInt += 1;
        if (paramInt == this.bits.length) {
          return this.size;
        }
        i = this.bits[paramInt];
      }
      i = (paramInt << 5) + Integer.numberOfTrailingZeros(i);
      paramInt = i;
    } while (i <= this.size);
    return this.size;
  }
  
  public int getNextUnset(int paramInt)
  {
    if (paramInt >= this.size) {
      paramInt = this.size;
    }
    int i;
    do
    {
      return paramInt;
      int j = paramInt >> 5;
      i = (this.bits[j] ^ 0xFFFFFFFF) & ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF);
      paramInt = j;
      while (i == 0)
      {
        paramInt += 1;
        if (paramInt == this.bits.length) {
          return this.size;
        }
        i = this.bits[paramInt] ^ 0xFFFFFFFF;
      }
      i = (paramInt << 5) + Integer.numberOfTrailingZeros(i);
      paramInt = i;
    } while (i <= this.size);
    return this.size;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getSizeInBytes()
  {
    return this.size + 7 >> 3;
  }
  
  public boolean isRange(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == paramInt1) {}
    for (;;)
    {
      return true;
      int i1 = paramInt2 - 1;
      int n = paramInt1 >> 5;
      int i2 = i1 >> 5;
      int j = n;
      while (j <= i2)
      {
        int k;
        if (j > n)
        {
          paramInt2 = 0;
          if (j >= i2) {
            break label115;
          }
          k = 31;
          label67:
          if ((paramInt2 != 0) || (k != 31)) {
            break label125;
          }
          paramInt2 = -1;
          k = this.bits[j];
          if (!paramBoolean) {
            break label159;
          }
        }
        label115:
        label125:
        label159:
        for (int i = paramInt2;; i = 0)
        {
          if ((k & paramInt2) == i) {
            break label165;
          }
          return false;
          paramInt2 = paramInt1 & 0x1F;
          break;
          k = i1 & 0x1F;
          break label67;
          i = 0;
          int m = paramInt2;
          for (;;)
          {
            paramInt2 = i;
            if (m > k) {
              break;
            }
            i |= 1 << m;
            m += 1;
          }
        }
        label165:
        j += 1;
      }
    }
  }
  
  public void reverse()
  {
    int[] arrayOfInt = new int[this.bits.length];
    int j = this.size;
    int i = 0;
    while (i < j)
    {
      if (get(j - i - 1))
      {
        int k = i >> 5;
        arrayOfInt[k] |= 1 << (i & 0x1F);
      }
      i += 1;
    }
    this.bits = arrayOfInt;
  }
  
  public void set(int paramInt)
  {
    int[] arrayOfInt = this.bits;
    int i = paramInt >> 5;
    arrayOfInt[i] |= 1 << (paramInt & 0x1F);
  }
  
  public void setBulk(int paramInt1, int paramInt2)
  {
    this.bits[(paramInt1 >> 5)] = paramInt2;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == paramInt1) {
      return;
    }
    int i1 = paramInt2 - 1;
    int n = paramInt1 >> 5;
    int i2 = i1 >> 5;
    int i = n;
    label38:
    if (i <= i2)
    {
      if (i <= n) {
        break label100;
      }
      paramInt2 = 0;
      label52:
      if (i >= i2) {
        break label108;
      }
    }
    label100:
    label108:
    for (int j = 31;; j = i1 & 0x1F)
    {
      if ((paramInt2 != 0) || (j != 31)) {
        break label118;
      }
      m = -1;
      int[] arrayOfInt = this.bits;
      arrayOfInt[i] |= m;
      i += 1;
      break label38;
      break;
      paramInt2 = paramInt1 & 0x1F;
      break label52;
    }
    label118:
    int m = 0;
    int k = paramInt2;
    paramInt2 = m;
    for (;;)
    {
      m = paramInt2;
      if (k > j) {
        break;
      }
      paramInt2 |= 1 << k;
      k += 1;
    }
  }
  
  public void toBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramInt3)
    {
      int k = 0;
      j = 0;
      while (j < 8)
      {
        int m = k;
        if (get(i)) {
          m = k | 1 << 7 - j;
        }
        i += 1;
        j += 1;
        k = m;
      }
      paramArrayOfByte[(paramInt2 + paramInt1)] = ((byte)k);
      paramInt1 += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.size);
    int i = 0;
    if (i < this.size)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      if (get(i)) {}
      for (char c = 'X';; c = '.')
      {
        localStringBuilder.append(c);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void xor(BitArray paramBitArray)
  {
    if (this.bits.length != paramBitArray.bits.length) {
      throw new IllegalArgumentException("Sizes don't match");
    }
    int i = 0;
    while (i < this.bits.length)
    {
      int[] arrayOfInt = this.bits;
      arrayOfInt[i] ^= paramBitArray.bits[i];
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/common/BitArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */