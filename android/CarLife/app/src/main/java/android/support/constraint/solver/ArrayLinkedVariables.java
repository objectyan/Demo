package android.support.constraint.solver;

import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables
{
  private static final boolean DEBUG = false;
  private static final int NONE = -1;
  private int ROW_SIZE = 8;
  private SolverVariable candidate = null;
  int currentSize = 0;
  private int[] mArrayIndices = new int[this.ROW_SIZE];
  private int[] mArrayNextIndices = new int[this.ROW_SIZE];
  private float[] mArrayValues = new float[this.ROW_SIZE];
  private final Cache mCache;
  private boolean mDidFillOnce = false;
  private int mHead = -1;
  private int mLast = -1;
  private final ArrayRow mRow;
  
  ArrayLinkedVariables(ArrayRow paramArrayRow, Cache paramCache)
  {
    this.mRow = paramArrayRow;
    this.mCache = paramCache;
  }
  
  public final void add(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    do
    {
      return;
      if (this.mHead != -1) {
        break;
      }
      this.mHead = 0;
      this.mArrayValues[this.mHead] = paramFloat;
      this.mArrayIndices[this.mHead] = paramSolverVariable.id;
      this.mArrayNextIndices[this.mHead] = -1;
      this.currentSize += 1;
    } while (this.mDidFillOnce);
    this.mLast += 1;
    return;
    int i = this.mHead;
    int m = -1;
    int j = 0;
    int k;
    for (;;)
    {
      if ((i == -1) || (j >= this.currentSize)) {
        break label253;
      }
      k = this.mArrayIndices[i];
      if (k == paramSolverVariable.id)
      {
        paramSolverVariable = this.mArrayValues;
        paramSolverVariable[i] += paramFloat;
        if (this.mArrayValues[i] != 0.0F) {
          break;
        }
        if (i == this.mHead) {
          this.mHead = this.mArrayNextIndices[i];
        }
        for (;;)
        {
          this.mCache.mIndexedVariables[k].removeClientEquation(this.mRow);
          if (this.mDidFillOnce) {
            this.mLast = i;
          }
          this.currentSize -= 1;
          return;
          this.mArrayNextIndices[m] = this.mArrayNextIndices[i];
        }
      }
      if (this.mArrayIndices[i] < paramSolverVariable.id) {
        m = i;
      }
      i = this.mArrayNextIndices[i];
      j += 1;
    }
    label253:
    i = this.mLast + 1;
    if (this.mDidFillOnce)
    {
      if (this.mArrayIndices[this.mLast] == -1) {
        i = this.mLast;
      }
    }
    else
    {
      label285:
      j = i;
      if (i >= this.mArrayIndices.length)
      {
        j = i;
        if (this.currentSize < this.mArrayIndices.length)
        {
          k = 0;
          label315:
          j = i;
          if (k < this.mArrayIndices.length)
          {
            if (this.mArrayIndices[k] != -1) {
              break label538;
            }
            j = k;
          }
        }
      }
      i = j;
      if (j >= this.mArrayIndices.length)
      {
        i = this.mArrayIndices.length;
        this.ROW_SIZE *= 2;
        this.mDidFillOnce = false;
        this.mLast = (i - 1);
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
      }
      this.mArrayIndices[i] = paramSolverVariable.id;
      this.mArrayValues[i] = paramFloat;
      if (m == -1) {
        break label547;
      }
      this.mArrayNextIndices[i] = this.mArrayNextIndices[m];
      this.mArrayNextIndices[m] = i;
    }
    for (;;)
    {
      this.currentSize += 1;
      if (!this.mDidFillOnce) {
        this.mLast += 1;
      }
      if (this.mLast < this.mArrayIndices.length) {
        break;
      }
      this.mDidFillOnce = true;
      this.mLast = (this.mArrayIndices.length - 1);
      return;
      i = this.mArrayIndices.length;
      break label285;
      label538:
      k += 1;
      break label315;
      label547:
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
  }
  
  public final void clear()
  {
    this.mHead = -1;
    this.mLast = -1;
    this.mDidFillOnce = false;
    this.currentSize = 0;
  }
  
  final boolean containsKey(SolverVariable paramSolverVariable)
  {
    if (this.mHead == -1) {}
    for (;;)
    {
      return false;
      int j = this.mHead;
      int i = 0;
      while ((j != -1) && (i < this.currentSize))
      {
        if (this.mArrayIndices[j] == paramSolverVariable.id) {
          return true;
        }
        j = this.mArrayNextIndices[j];
        i += 1;
      }
    }
  }
  
  public void display()
  {
    int j = this.currentSize;
    System.out.print("{ ");
    int i = 0;
    if (i < j)
    {
      SolverVariable localSolverVariable = getVariable(i);
      if (localSolverVariable == null) {}
      for (;;)
      {
        i += 1;
        break;
        System.out.print(localSolverVariable + " = " + getVariableValue(i) + " ");
      }
    }
    System.out.println(" }");
  }
  
  void divideByAmount(float paramFloat)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[j] /= paramFloat;
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  public final float get(SolverVariable paramSolverVariable)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (this.mArrayIndices[j] == paramSolverVariable.id) {
        return this.mArrayValues[j];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return 0.0F;
  }
  
  SolverVariable getPivotCandidate()
  {
    if (this.candidate == null)
    {
      int j = this.mHead;
      int i = 0;
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (j == -1) {
          break;
        }
        localObject2 = localObject1;
        if (i >= this.currentSize) {
          break;
        }
        localObject2 = localObject1;
        if (this.mArrayValues[j] < 0.0F)
        {
          SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((SolverVariable)localObject1).strength >= localSolverVariable.strength) {}
          }
          else
          {
            localObject2 = localSolverVariable;
          }
        }
        j = this.mArrayNextIndices[j];
        i += 1;
      }
    }
    Object localObject2 = this.candidate;
    return (SolverVariable)localObject2;
  }
  
  final SolverVariable getVariable(int paramInt)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (i == paramInt) {
        return this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return null;
  }
  
  final float getVariableValue(int paramInt)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (i == paramInt) {
        return this.mArrayValues[j];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return 0.0F;
  }
  
  boolean hasAtLeastOnePositiveVariable()
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (this.mArrayValues[j] > 0.0F) {
        return true;
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return false;
  }
  
  void invert()
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[j] *= -1.0F;
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  SolverVariable pickPivotCandidate()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = this.mHead;
    int i = 0;
    if ((j != -1) && (i < this.currentSize))
    {
      float f2 = this.mArrayValues[j];
      float f1;
      if (f2 < 0.0F)
      {
        f1 = f2;
        if (f2 > -0.001F)
        {
          this.mArrayValues[j] = 0.0F;
          f1 = 0.0F;
        }
      }
      SolverVariable localSolverVariable;
      for (;;)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (f1 == 0.0F) {
          break label156;
        }
        localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
        if (localSolverVariable.mType != SolverVariable.Type.UNRESTRICTED) {
          break label180;
        }
        if (f1 >= 0.0F) {
          break;
        }
        return localSolverVariable;
        f1 = f2;
        if (f2 < 0.001F)
        {
          this.mArrayValues[j] = 0.0F;
          f1 = 0.0F;
        }
      }
      Object localObject3 = localObject2;
      Object localObject4 = localObject1;
      if (localObject1 == null)
      {
        localObject4 = localSolverVariable;
        localObject3 = localObject2;
      }
      for (;;)
      {
        label156:
        j = this.mArrayNextIndices[j];
        i += 1;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        label180:
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (f1 < 0.0F) {
          if (localObject2 != null)
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localSolverVariable.strength >= ((SolverVariable)localObject2).strength) {}
          }
          else
          {
            localObject3 = localSolverVariable;
            localObject4 = localObject1;
          }
        }
      }
    }
    if (localObject1 != null) {
      return (SolverVariable)localObject1;
    }
    return (SolverVariable)localObject2;
  }
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F) {
      remove(paramSolverVariable);
    }
    do
    {
      return;
      if (this.mHead != -1) {
        break;
      }
      this.mHead = 0;
      this.mArrayValues[this.mHead] = paramFloat;
      this.mArrayIndices[this.mHead] = paramSolverVariable.id;
      this.mArrayNextIndices[this.mHead] = -1;
      this.currentSize += 1;
    } while (this.mDidFillOnce);
    this.mLast += 1;
    return;
    int i = this.mHead;
    int m = -1;
    int j = 0;
    while ((i != -1) && (j < this.currentSize))
    {
      if (this.mArrayIndices[i] == paramSolverVariable.id)
      {
        this.mArrayValues[i] = paramFloat;
        return;
      }
      if (this.mArrayIndices[i] < paramSolverVariable.id) {
        m = i;
      }
      i = this.mArrayNextIndices[i];
      j += 1;
    }
    i = this.mLast + 1;
    label197:
    int k;
    if (this.mDidFillOnce)
    {
      if (this.mArrayIndices[this.mLast] == -1) {
        i = this.mLast;
      }
    }
    else
    {
      j = i;
      if (i >= this.mArrayIndices.length)
      {
        j = i;
        if (this.currentSize < this.mArrayIndices.length)
        {
          k = 0;
          label227:
          j = i;
          if (k < this.mArrayIndices.length)
          {
            if (this.mArrayIndices[k] != -1) {
              break label439;
            }
            j = k;
          }
        }
      }
      i = j;
      if (j >= this.mArrayIndices.length)
      {
        i = this.mArrayIndices.length;
        this.ROW_SIZE *= 2;
        this.mDidFillOnce = false;
        this.mLast = (i - 1);
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
      }
      this.mArrayIndices[i] = paramSolverVariable.id;
      this.mArrayValues[i] = paramFloat;
      if (m == -1) {
        break label448;
      }
      this.mArrayNextIndices[i] = this.mArrayNextIndices[m];
      this.mArrayNextIndices[m] = i;
    }
    for (;;)
    {
      this.currentSize += 1;
      if (!this.mDidFillOnce) {
        this.mLast += 1;
      }
      if (this.currentSize < this.mArrayIndices.length) {
        break;
      }
      this.mDidFillOnce = true;
      return;
      i = this.mArrayIndices.length;
      break label197;
      label439:
      k += 1;
      break label227;
      label448:
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
  }
  
  public final float remove(SolverVariable paramSolverVariable)
  {
    if (this.candidate == paramSolverVariable) {
      this.candidate = null;
    }
    if (this.mHead == -1) {}
    for (;;)
    {
      return 0.0F;
      int i = this.mHead;
      int k = -1;
      int j = 0;
      while ((i != -1) && (j < this.currentSize))
      {
        int m = this.mArrayIndices[i];
        if (m == paramSolverVariable.id)
        {
          if (i == this.mHead) {
            this.mHead = this.mArrayNextIndices[i];
          }
          for (;;)
          {
            this.mCache.mIndexedVariables[m].removeClientEquation(this.mRow);
            this.currentSize -= 1;
            this.mArrayIndices[i] = -1;
            if (this.mDidFillOnce) {
              this.mLast = i;
            }
            return this.mArrayValues[i];
            this.mArrayNextIndices[k] = this.mArrayNextIndices[i];
          }
        }
        k = i;
        i = this.mArrayNextIndices[i];
        j += 1;
      }
    }
  }
  
  int sizeInBytes()
  {
    return 0 + this.mArrayIndices.length * 4 * 3 + 36;
  }
  
  public String toString()
  {
    String str = "";
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      str = str + " -> ";
      str = str + this.mArrayValues[j] + " : ";
      str = str + this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return str;
  }
  
  void updateClientEquations(ArrayRow paramArrayRow)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      this.mCache.mIndexedVariables[this.mArrayIndices[j]].addClientEquation(paramArrayRow);
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  void updateFromRow(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize)) {
      if (this.mArrayIndices[j] == paramArrayRow2.variable.id)
      {
        float f = this.mArrayValues[j];
        remove(paramArrayRow2.variable);
        ArrayLinkedVariables localArrayLinkedVariables = paramArrayRow2.variables;
        j = localArrayLinkedVariables.mHead;
        i = 0;
        while ((j != -1) && (i < localArrayLinkedVariables.currentSize))
        {
          add(this.mCache.mIndexedVariables[localArrayLinkedVariables.mArrayIndices[j]], localArrayLinkedVariables.mArrayValues[j] * f);
          j = localArrayLinkedVariables.mArrayNextIndices[j];
          i += 1;
        }
        paramArrayRow1.constantValue += paramArrayRow2.constantValue * f;
        paramArrayRow2.variable.removeClientEquation(paramArrayRow1);
        j = this.mHead;
        i = 0;
      }
      else
      {
        j = this.mArrayNextIndices[j];
        i += 1;
      }
    }
  }
  
  void updateFromSystem(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      Object localObject = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      if (((SolverVariable)localObject).definitionId != -1)
      {
        float f = this.mArrayValues[j];
        remove((SolverVariable)localObject);
        localObject = paramArrayOfArrayRow[localObject.definitionId];
        if (!((ArrayRow)localObject).isSimpleDefinition)
        {
          ArrayLinkedVariables localArrayLinkedVariables = ((ArrayRow)localObject).variables;
          j = localArrayLinkedVariables.mHead;
          i = 0;
          while ((j != -1) && (i < localArrayLinkedVariables.currentSize))
          {
            add(this.mCache.mIndexedVariables[localArrayLinkedVariables.mArrayIndices[j]], localArrayLinkedVariables.mArrayValues[j] * f);
            j = localArrayLinkedVariables.mArrayNextIndices[j];
            i += 1;
          }
        }
        paramArrayRow.constantValue += ((ArrayRow)localObject).constantValue * f;
        ((ArrayRow)localObject).variable.removeClientEquation(paramArrayRow);
        j = this.mHead;
        i = 0;
      }
      else
      {
        j = this.mArrayNextIndices[j];
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/ArrayLinkedVariables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */