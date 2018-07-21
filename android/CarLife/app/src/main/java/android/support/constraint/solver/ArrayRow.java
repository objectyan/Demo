package android.support.constraint.solver;

public class ArrayRow
{
  private static final boolean DEBUG = false;
  float constantValue = 0.0F;
  boolean isSimpleDefinition = false;
  boolean used = false;
  SolverVariable variable = null;
  final ArrayLinkedVariables variables;
  
  public ArrayRow(Cache paramCache)
  {
    this.variables = new ArrayLinkedVariables(this, paramCache);
  }
  
  public ArrayRow addError(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2)
  {
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    return this;
  }
  
  ArrayRow addSingleError(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variables.put(paramSolverVariable, paramInt);
    return this;
  }
  
  ArrayRow createRowCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2)
  {
    if (paramSolverVariable2 == paramSolverVariable3)
    {
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      this.variables.put(paramSolverVariable2, -2.0F);
    }
    do
    {
      do
      {
        return this;
        if (paramFloat != 0.5F) {
          break;
        }
        this.variables.put(paramSolverVariable1, 1.0F);
        this.variables.put(paramSolverVariable2, -1.0F);
        this.variables.put(paramSolverVariable3, -1.0F);
        this.variables.put(paramSolverVariable4, 1.0F);
      } while ((paramInt1 <= 0) && (paramInt2 <= 0));
      this.constantValue = (-paramInt1 + paramInt2);
      return this;
      if (paramFloat <= 0.0F)
      {
        this.variables.put(paramSolverVariable1, -1.0F);
        this.variables.put(paramSolverVariable2, 1.0F);
        this.constantValue = paramInt1;
        return this;
      }
      if (paramFloat >= 1.0F)
      {
        this.variables.put(paramSolverVariable3, -1.0F);
        this.variables.put(paramSolverVariable4, 1.0F);
        this.constantValue = paramInt2;
        return this;
      }
      this.variables.put(paramSolverVariable1, (1.0F - paramFloat) * 1.0F);
      this.variables.put(paramSolverVariable2, (1.0F - paramFloat) * -1.0F);
      this.variables.put(paramSolverVariable3, -1.0F * paramFloat);
      this.variables.put(paramSolverVariable4, 1.0F * paramFloat);
    } while ((paramInt1 <= 0) && (paramInt2 <= 0));
    this.constantValue = (-paramInt1 * (1.0F - paramFloat) + paramInt2 * paramFloat);
    return this;
  }
  
  ArrayRow createRowDefinition(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variable = paramSolverVariable;
    paramSolverVariable.computedValue = paramInt;
    this.constantValue = paramInt;
    this.isSimpleDefinition = true;
    return this;
  }
  
  ArrayRow createRowDimensionPercent(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, 1.0F - paramFloat);
    this.variables.put(paramSolverVariable3, paramFloat);
    return this;
  }
  
  public ArrayRow createRowDimensionRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, 1.0F);
    this.variables.put(paramSolverVariable3, paramFloat);
    this.variables.put(paramSolverVariable4, -paramFloat);
    return this;
  }
  
  public ArrayRow createRowEqualDimension(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, int paramInt1, SolverVariable paramSolverVariable2, int paramInt2, SolverVariable paramSolverVariable3, int paramInt3, SolverVariable paramSolverVariable4, int paramInt4)
  {
    if ((paramFloat2 == 0.0F) || (paramFloat1 == paramFloat3))
    {
      this.constantValue = (-paramInt1 - paramInt2 + paramInt3 + paramInt4);
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
    this.constantValue = (-paramInt1 - paramInt2 + paramInt3 * paramFloat1 + paramInt4 * paramFloat1);
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable4, paramFloat1);
    this.variables.put(paramSolverVariable3, -paramFloat1);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable, int paramInt)
  {
    if (paramInt < 0)
    {
      this.constantValue = (paramInt * -1);
      this.variables.put(paramSolverVariable, 1.0F);
      return this;
    }
    this.constantValue = paramInt;
    this.variables.put(paramSolverVariable, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = paramInt;
      paramInt = j;
      j = i;
      if (i < 0)
      {
        j = i * -1;
        paramInt = 1;
      }
      this.constantValue = j;
      i = paramInt;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    return this;
  }
  
  public ArrayRow createRowGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = paramInt;
      paramInt = j;
      j = i;
      if (i < 0)
      {
        j = i * -1;
        paramInt = 1;
      }
      this.constantValue = j;
      i = paramInt;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      this.variables.put(paramSolverVariable3, 1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = paramInt;
      paramInt = j;
      j = i;
      if (i < 0)
      {
        j = i * -1;
        paramInt = 1;
      }
      this.constantValue = j;
      i = paramInt;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable3, 1.0F);
    return this;
  }
  
  void ensurePositiveConstant()
  {
    if (this.constantValue < 0.0F)
    {
      this.constantValue *= -1.0F;
      this.variables.invert();
    }
  }
  
  boolean hasAtLeastOnePositiveVariable()
  {
    return this.variables.hasAtLeastOnePositiveVariable();
  }
  
  boolean hasKeyVariable()
  {
    return (this.variable != null) && ((this.variable.mType == SolverVariable.Type.UNRESTRICTED) || (this.constantValue >= 0.0F));
  }
  
  boolean hasVariable(SolverVariable paramSolverVariable)
  {
    return this.variables.containsKey(paramSolverVariable);
  }
  
  void pickRowVariable()
  {
    SolverVariable localSolverVariable = this.variables.pickPivotCandidate();
    if (localSolverVariable != null) {
      pivot(localSolverVariable);
    }
    if (this.variables.currentSize == 0) {
      this.isSimpleDefinition = true;
    }
  }
  
  void pivot(SolverVariable paramSolverVariable)
  {
    if (this.variable != null)
    {
      this.variables.put(this.variable, -1.0F);
      this.variable = null;
    }
    float f = this.variables.remove(paramSolverVariable) * -1.0F;
    this.variable = paramSolverVariable;
    if (f == 1.0F) {
      return;
    }
    this.constantValue /= f;
    this.variables.divideByAmount(f);
  }
  
  public void reset()
  {
    this.variable = null;
    this.variables.clear();
    this.constantValue = 0.0F;
    this.isSimpleDefinition = false;
  }
  
  int sizeInBytes()
  {
    int i = 0;
    if (this.variable != null) {
      i = 0 + 4;
    }
    return i + 4 + 4 + this.variables.sizeInBytes();
  }
  
  String toReadableString()
  {
    if (this.variable == null) {}
    int i;
    int j;
    for (Object localObject1 = "" + "0";; localObject1 = "" + this.variable)
    {
      localObject2 = (String)localObject1 + " = ";
      i = 0;
      localObject1 = localObject2;
      if (this.constantValue != 0.0F)
      {
        localObject1 = (String)localObject2 + this.constantValue;
        i = 1;
      }
      int k = this.variables.currentSize;
      j = 0;
      for (;;)
      {
        if (j >= k) {
          break label353;
        }
        localObject2 = this.variables.getVariable(j);
        if (localObject2 != null) {
          break;
        }
        j += 1;
      }
    }
    float f2 = this.variables.getVariableValue(j);
    String str = ((SolverVariable)localObject2).toString();
    float f1;
    if (i == 0)
    {
      f1 = f2;
      localObject2 = localObject1;
      if (f2 < 0.0F)
      {
        localObject2 = (String)localObject1 + "- ";
        f1 = f2 * -1.0F;
      }
      label223:
      if (f1 != 1.0F) {
        break label319;
      }
    }
    label319:
    for (localObject1 = (String)localObject2 + str;; localObject1 = (String)localObject2 + f1 + " " + str)
    {
      i = 1;
      break;
      if (f2 > 0.0F)
      {
        localObject2 = (String)localObject1 + " + ";
        f1 = f2;
        break label223;
      }
      localObject2 = (String)localObject1 + " - ";
      f1 = f2 * -1.0F;
      break label223;
    }
    label353:
    Object localObject2 = localObject1;
    if (i == 0) {
      localObject2 = (String)localObject1 + "0.0";
    }
    return (String)localObject2;
  }
  
  public String toString()
  {
    return toReadableString();
  }
  
  void updateClientEquations()
  {
    this.variables.updateClientEquations(this);
  }
  
  boolean updateRowWithEquation(ArrayRow paramArrayRow)
  {
    this.variables.updateFromRow(this, paramArrayRow);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/ArrayRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */