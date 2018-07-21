package com.google.zxing.common.reedsolomon;

public final class ReedSolomonDecoder
{
  private final GenericGF field;
  
  public ReedSolomonDecoder(GenericGF paramGenericGF)
  {
    this.field = paramGenericGF;
  }
  
  private int[] findErrorLocations(GenericGFPoly paramGenericGFPoly)
    throws ReedSolomonException
  {
    int m = paramGenericGFPoly.getDegree();
    int[] arrayOfInt;
    if (m == 1)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = paramGenericGFPoly.getCoefficient(1);
      paramGenericGFPoly = arrayOfInt;
    }
    int j;
    do
    {
      return paramGenericGFPoly;
      arrayOfInt = new int[m];
      j = 0;
      int i = 1;
      while ((i < this.field.getSize()) && (j < m))
      {
        int k = j;
        if (paramGenericGFPoly.evaluateAt(i) == 0)
        {
          arrayOfInt[j] = this.field.inverse(i);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      paramGenericGFPoly = arrayOfInt;
    } while (j == m);
    throw new ReedSolomonException("Error locator degree does not match number of roots");
  }
  
  private int[] findErrorMagnitudes(GenericGFPoly paramGenericGFPoly, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int n = paramArrayOfInt.length;
    int[] arrayOfInt = new int[n];
    int i = 0;
    while (i < n)
    {
      int i1 = this.field.inverse(paramArrayOfInt[i]);
      int k = 1;
      int j = 0;
      if (j < n)
      {
        int m = k;
        if (i != j)
        {
          m = this.field.multiply(paramArrayOfInt[j], i1);
          if ((m & 0x1) != 0) {
            break label111;
          }
          m |= 0x1;
        }
        for (;;)
        {
          m = this.field.multiply(k, m);
          j += 1;
          k = m;
          break;
          label111:
          m &= 0xFFFFFFFE;
        }
      }
      arrayOfInt[i] = this.field.multiply(paramGenericGFPoly.evaluateAt(i1), this.field.inverse(k));
      if (paramBoolean) {
        arrayOfInt[i] = this.field.multiply(arrayOfInt[i], i1);
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly paramGenericGFPoly1, GenericGFPoly paramGenericGFPoly2, int paramInt)
    throws ReedSolomonException
  {
    Object localObject2 = paramGenericGFPoly1;
    Object localObject1 = paramGenericGFPoly2;
    if (paramGenericGFPoly1.getDegree() < paramGenericGFPoly2.getDegree())
    {
      localObject1 = paramGenericGFPoly1;
      localObject2 = paramGenericGFPoly2;
    }
    GenericGFPoly localGenericGFPoly1 = this.field.getOne();
    paramGenericGFPoly2 = this.field.getZero();
    GenericGFPoly localGenericGFPoly2 = this.field.getZero();
    GenericGFPoly localGenericGFPoly3;
    for (paramGenericGFPoly1 = this.field.getOne();; paramGenericGFPoly1 = paramGenericGFPoly1.multiply(localGenericGFPoly2).addOrSubtract(localGenericGFPoly3))
    {
      localGenericGFPoly3 = localGenericGFPoly2;
      GenericGFPoly localGenericGFPoly4 = localGenericGFPoly1;
      Object localObject3 = localObject2;
      if (((GenericGFPoly)localObject1).getDegree() < paramInt / 2) {
        break;
      }
      localObject2 = localObject1;
      localGenericGFPoly1 = paramGenericGFPoly2;
      localGenericGFPoly2 = paramGenericGFPoly1;
      if (((GenericGFPoly)localObject2).isZero()) {
        throw new ReedSolomonException("r_{i-1} was zero");
      }
      localObject1 = localObject3;
      paramGenericGFPoly1 = this.field.getZero();
      int i = ((GenericGFPoly)localObject2).getCoefficient(((GenericGFPoly)localObject2).getDegree());
      i = this.field.inverse(i);
      while ((((GenericGFPoly)localObject1).getDegree() >= ((GenericGFPoly)localObject2).getDegree()) && (!((GenericGFPoly)localObject1).isZero()))
      {
        int j = ((GenericGFPoly)localObject1).getDegree() - ((GenericGFPoly)localObject2).getDegree();
        int k = this.field.multiply(((GenericGFPoly)localObject1).getCoefficient(((GenericGFPoly)localObject1).getDegree()), i);
        paramGenericGFPoly1 = paramGenericGFPoly1.addOrSubtract(this.field.buildMonomial(j, k));
        localObject1 = ((GenericGFPoly)localObject1).addOrSubtract(((GenericGFPoly)localObject2).multiplyByMonomial(j, k));
      }
      paramGenericGFPoly2 = paramGenericGFPoly1.multiply(localGenericGFPoly1).addOrSubtract(localGenericGFPoly4);
    }
    paramInt = paramGenericGFPoly1.getCoefficient(0);
    if (paramInt == 0) {
      throw new ReedSolomonException("sigmaTilde(0) was zero");
    }
    paramInt = this.field.inverse(paramInt);
    return new GenericGFPoly[] { paramGenericGFPoly1.multiply(paramInt), ((GenericGFPoly)localObject1).multiply(paramInt) };
  }
  
  public void decode(int[] paramArrayOfInt, int paramInt)
    throws ReedSolomonException
  {
    Object localObject1 = new GenericGFPoly(this.field, paramArrayOfInt);
    Object localObject2 = new int[paramInt];
    boolean bool = this.field.equals(GenericGF.DATA_MATRIX_FIELD_256);
    int j = 1;
    int i = 0;
    if (i < paramInt)
    {
      GenericGF localGenericGF = this.field;
      if (bool) {}
      for (int k = i + 1;; k = i)
      {
        k = ((GenericGFPoly)localObject1).evaluateAt(localGenericGF.exp(k));
        localObject2[(localObject2.length - 1 - i)] = k;
        if (k != 0) {
          j = 0;
        }
        i += 1;
        break;
      }
    }
    if (j != 0) {}
    for (;;)
    {
      return;
      localObject1 = new GenericGFPoly(this.field, (int[])localObject2);
      localObject2 = runEuclideanAlgorithm(this.field.buildMonomial(paramInt, 1), (GenericGFPoly)localObject1, paramInt);
      localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      localObject1 = findErrorLocations((GenericGFPoly)localObject1);
      localObject2 = findErrorMagnitudes((GenericGFPoly)localObject2, (int[])localObject1, bool);
      paramInt = 0;
      while (paramInt < localObject1.length)
      {
        i = paramArrayOfInt.length - 1 - this.field.log(localObject1[paramInt]);
        if (i < 0) {
          throw new ReedSolomonException("Bad error location");
        }
        paramArrayOfInt[i] = GenericGF.addOrSubtract(paramArrayOfInt[i], localObject2[paramInt]);
        paramInt += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/common/reedsolomon/ReedSolomonDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */