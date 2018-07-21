package android.support.constraint.solver;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem
{
  private static final boolean DEBUG = false;
  private static int POOL_SIZE = 1000;
  private int TABLE_SIZE = 32;
  private boolean[] mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
  final Cache mCache;
  private Goal mGoal = new Goal();
  private int mMaxColumns = this.TABLE_SIZE;
  private int mMaxRows = this.TABLE_SIZE;
  int mNumColumns = 1;
  private int mNumRows = 0;
  private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
  private int mPoolVariablesCount = 0;
  private ArrayRow[] mRows = null;
  private HashMap<String, SolverVariable> mVariables = null;
  int mVariablesID = 0;
  private ArrayRow[] tempClientsCopy = new ArrayRow[this.TABLE_SIZE];
  
  public LinearSystem()
  {
    releaseRows();
    this.mCache = new Cache();
  }
  
  private SolverVariable acquireSolverVariable(SolverVariable.Type paramType)
  {
    Object localObject = (SolverVariable)this.mCache.solverVariablePool.acquire();
    if (localObject == null) {}
    for (paramType = new SolverVariable(paramType);; paramType = (SolverVariable.Type)localObject)
    {
      if (this.mPoolVariablesCount >= POOL_SIZE)
      {
        POOL_SIZE *= 2;
        this.mPoolVariables = ((SolverVariable[])Arrays.copyOf(this.mPoolVariables, POOL_SIZE));
      }
      localObject = this.mPoolVariables;
      int i = this.mPoolVariablesCount;
      this.mPoolVariablesCount = (i + 1);
      localObject[i] = paramType;
      return paramType;
      ((SolverVariable)localObject).reset();
      ((SolverVariable)localObject).setType(paramType);
    }
  }
  
  private void addError(ArrayRow paramArrayRow)
  {
    paramArrayRow.addError(createErrorVariable(), createErrorVariable());
  }
  
  private void addSingleError(ArrayRow paramArrayRow, int paramInt)
  {
    paramArrayRow.addSingleError(createErrorVariable(), paramInt);
  }
  
  private void computeValues()
  {
    int i = 0;
    while (i < this.mNumRows)
    {
      ArrayRow localArrayRow = this.mRows[i];
      localArrayRow.variable.computedValue = localArrayRow.constantValue;
      i += 1;
    }
  }
  
  public static ArrayRow createRowCentering(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramBoolean)
    {
      paramSolverVariable1 = paramLinearSystem.createErrorVariable();
      paramLinearSystem = paramLinearSystem.createErrorVariable();
      paramSolverVariable1.strength = 4;
      paramLinearSystem.strength = 4;
      localArrayRow.addError(paramSolverVariable1, paramLinearSystem);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowDimensionPercent(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    if (paramBoolean) {
      paramLinearSystem.addError(localArrayRow);
    }
    return localArrayRow.createRowDimensionPercent(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramFloat);
  }
  
  public static ArrayRow createRowEquals(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, 1);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowGreaterThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(-1.0F * localArrayRow.variables.get(localSolverVariable)));
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowLowerThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(-1.0F * localArrayRow.variables.get(localSolverVariable)));
    }
    return localArrayRow;
  }
  
  private SolverVariable createVariable(String paramString, SolverVariable.Type paramType)
  {
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    paramType = acquireSolverVariable(paramType);
    paramType.setName(paramString);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    paramType.id = this.mVariablesID;
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    this.mVariables.put(paramString, paramType);
    this.mCache.mIndexedVariables[this.mVariablesID] = paramType;
    return paramType;
  }
  
  private void displayRows()
  {
    displaySolverVariables();
    String str1 = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      str1 = str1 + this.mRows[i];
      str1 = str1 + "\n";
      i += 1;
    }
    String str2 = str1;
    if (this.mGoal.variables.size() != 0) {
      str2 = str1 + this.mGoal + "\n";
    }
    System.out.println(str2);
  }
  
  private void displaySolverVariables()
  {
    String str = "Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ") :\n\t | C | ";
    int i = 1;
    while (i <= this.mNumColumns)
    {
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[i];
      str = str + localSolverVariable;
      str = str + " | ";
      i += 1;
    }
    str = str + "\n";
    System.out.println(str);
  }
  
  private int enforceBFS(Goal paramGoal)
    throws Exception
  {
    int k = 0;
    int m = 0;
    int j = 0;
    int i = m;
    if (j < this.mNumRows)
    {
      if (this.mRows[j].variable.mType == SolverVariable.Type.UNRESTRICTED) {}
      while (this.mRows[j].constantValue >= 0.0F)
      {
        j += 1;
        break;
      }
      i = 1;
    }
    j = k;
    if (i != 0)
    {
      int i2 = 0;
      i = 0;
      for (;;)
      {
        j = i;
        if (i2 != 0) {
          break;
        }
        int i6 = i + 1;
        float f1 = Float.MAX_VALUE;
        k = 0;
        j = -1;
        i = -1;
        m = 0;
        ArrayRow localArrayRow;
        if (m < this.mNumRows)
        {
          localArrayRow = this.mRows[m];
          int i4;
          float f2;
          if (localArrayRow.variable.mType == SolverVariable.Type.UNRESTRICTED)
          {
            i4 = k;
            i3 = j;
            i1 = i;
            f2 = f1;
          }
          do
          {
            m += 1;
            f1 = f2;
            i = i1;
            j = i3;
            k = i4;
            break;
            f2 = f1;
            i1 = i;
            i3 = j;
            i4 = k;
          } while (localArrayRow.constantValue >= 0.0F);
          int n = 1;
          SolverVariable localSolverVariable;
          float f3;
          int i5;
          for (;;)
          {
            f2 = f1;
            i1 = i;
            i3 = j;
            i4 = k;
            if (n >= this.mNumColumns) {
              break;
            }
            localSolverVariable = this.mCache.mIndexedVariables[n];
            f3 = localArrayRow.variables.get(localSolverVariable);
            if (f3 > 0.0F) {
              break label301;
            }
            i3 = k;
            i4 = j;
            i5 = i;
            f2 = f1;
            n += 1;
            f1 = f2;
            i = i5;
            j = i4;
            k = i3;
          }
          label301:
          int i3 = 0;
          int i1 = i;
          i = i3;
          for (;;)
          {
            f2 = f1;
            i5 = i1;
            i4 = j;
            i3 = k;
            if (i >= 6) {
              break;
            }
            f2 = localSolverVariable.strengthVector[i] / f3;
            if ((f2 >= f1) || (i != k))
            {
              i3 = k;
              if (i <= k) {}
            }
            else
            {
              f1 = f2;
              j = m;
              i1 = n;
              i3 = i;
            }
            i += 1;
            k = i3;
          }
        }
        if (j != -1)
        {
          localArrayRow = this.mRows[j];
          localArrayRow.variable.definitionId = -1;
          localArrayRow.pivot(this.mCache.mIndexedVariables[i]);
          localArrayRow.variable.definitionId = j;
          i = 0;
          while (i < this.mNumRows)
          {
            this.mRows[i].updateRowWithEquation(localArrayRow);
            i += 1;
          }
          paramGoal.updateFromSystem(this);
          i = i6;
        }
        else
        {
          i2 = 1;
          i = i6;
        }
      }
    }
    i = 0;
    if (i < this.mNumRows)
    {
      if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED) {}
      while (this.mRows[i].constantValue >= 0.0F)
      {
        i += 1;
        break;
      }
    }
    return j;
  }
  
  private String getDisplaySize(int paramInt)
  {
    int i = paramInt * 4 / 1024 / 1024;
    if (i > 0) {
      return "" + i + " Mb";
    }
    i = paramInt * 4 / 1024;
    if (i > 0) {
      return "" + i + " Kb";
    }
    return "" + paramInt * 4 + " bytes";
  }
  
  private void increaseTableSize()
  {
    this.TABLE_SIZE *= 2;
    this.mRows = ((ArrayRow[])Arrays.copyOf(this.mRows, this.TABLE_SIZE));
    this.mCache.mIndexedVariables = ((SolverVariable[])Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE));
    this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
    this.mMaxColumns = this.TABLE_SIZE;
    this.mMaxRows = this.TABLE_SIZE;
    this.mGoal.variables.clear();
  }
  
  private int optimize(Goal paramGoal)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    while (i < this.mNumColumns)
    {
      this.mAlreadyTestedCandidates[i] = false;
      i += 1;
    }
    int m = 0;
    i = k;
    while (i == 0)
    {
      int i1 = j + 1;
      Object localObject2 = paramGoal.getPivotCandidate();
      k = i;
      Object localObject1 = localObject2;
      j = m;
      float f1;
      label115:
      int n;
      float f2;
      if (localObject2 != null)
      {
        if (this.mAlreadyTestedCandidates[localObject2.id] != 0)
        {
          localObject1 = null;
          j = m;
          k = i;
        }
      }
      else
      {
        if (localObject1 == null) {
          break label432;
        }
        f1 = Float.MAX_VALUE;
        m = -1;
        i = 0;
        if (i >= this.mNumRows) {
          break label295;
        }
        localObject2 = this.mRows[i];
        if (((ArrayRow)localObject2).variable.mType != SolverVariable.Type.UNRESTRICTED) {
          break label220;
        }
        n = m;
        f2 = f1;
      }
      for (;;)
      {
        i += 1;
        f1 = f2;
        m = n;
        break label115;
        this.mAlreadyTestedCandidates[localObject2.id] = true;
        m += 1;
        k = i;
        localObject1 = localObject2;
        j = m;
        if (m < this.mNumColumns) {
          break;
        }
        k = 1;
        localObject1 = localObject2;
        j = m;
        break;
        label220:
        f2 = f1;
        n = m;
        if (((ArrayRow)localObject2).hasVariable((SolverVariable)localObject1))
        {
          float f3 = ((ArrayRow)localObject2).variables.get((SolverVariable)localObject1);
          f2 = f1;
          n = m;
          if (f3 < 0.0F)
          {
            f3 = -((ArrayRow)localObject2).constantValue / f3;
            f2 = f1;
            n = m;
            if (f3 < f1)
            {
              f2 = f3;
              n = i;
            }
          }
        }
      }
      label295:
      if (m > -1)
      {
        localObject2 = this.mRows[m];
        ((ArrayRow)localObject2).variable.definitionId = -1;
        ((ArrayRow)localObject2).pivot((SolverVariable)localObject1);
        ((ArrayRow)localObject2).variable.definitionId = m;
        i = 0;
        while (i < this.mNumRows)
        {
          this.mRows[i].updateRowWithEquation((ArrayRow)localObject2);
          i += 1;
        }
        paramGoal.updateFromSystem(this);
        try
        {
          enforceBFS(paramGoal);
          i = k;
          m = j;
          j = i1;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = k;
          m = j;
          j = i1;
        }
      }
      else
      {
        i = 1;
        m = j;
        j = i1;
        continue;
        label432:
        i = 1;
        m = j;
        j = i1;
      }
    }
    return j;
  }
  
  private void releaseRows()
  {
    int i = 0;
    while (i < this.mRows.length)
    {
      ArrayRow localArrayRow = this.mRows[i];
      if (localArrayRow != null) {
        this.mCache.arrayRowPool.release(localArrayRow);
      }
      this.mRows[i] = null;
      i += 1;
    }
  }
  
  private void updateRowFromVariables(ArrayRow paramArrayRow)
  {
    if (this.mNumRows > 0)
    {
      paramArrayRow.variables.updateFromSystem(paramArrayRow, this.mRows);
      if (paramArrayRow.variables.currentSize == 0) {
        paramArrayRow.isSimpleDefinition = true;
      }
    }
  }
  
  public void addCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    paramSolverVariable1 = createErrorVariable();
    paramSolverVariable2 = createErrorVariable();
    paramSolverVariable1.strength = paramInt3;
    paramSolverVariable2.strength = paramInt3;
    localArrayRow.addError(paramSolverVariable1, paramSolverVariable2);
    addConstraint(localArrayRow);
  }
  
  public void addConstraint(ArrayRow paramArrayRow)
  {
    if (paramArrayRow == null) {}
    int j;
    do
    {
      do
      {
        return;
        if ((this.mNumRows + 1 >= this.mMaxRows) || (this.mNumColumns + 1 >= this.mMaxColumns)) {
          increaseTableSize();
        }
        if (paramArrayRow.isSimpleDefinition) {
          break;
        }
        updateRowFromVariables(paramArrayRow);
        paramArrayRow.ensurePositiveConstant();
        paramArrayRow.pickRowVariable();
      } while (!paramArrayRow.hasKeyVariable());
      if (this.mRows[this.mNumRows] != null) {
        this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
      }
      if (!paramArrayRow.isSimpleDefinition) {
        paramArrayRow.updateClientEquations();
      }
      this.mRows[this.mNumRows] = paramArrayRow;
      paramArrayRow.variable.definitionId = this.mNumRows;
      this.mNumRows += 1;
      j = paramArrayRow.variable.mClientEquationsCount;
    } while (j <= 0);
    while (this.tempClientsCopy.length < j) {
      this.tempClientsCopy = new ArrayRow[this.tempClientsCopy.length * 2];
    }
    ArrayRow[] arrayOfArrayRow = this.tempClientsCopy;
    int i = 0;
    while (i < j)
    {
      arrayOfArrayRow[i] = paramArrayRow.variable.mClientEquations[i];
      i += 1;
    }
    i = 0;
    label211:
    ArrayRow localArrayRow;
    if (i < j)
    {
      localArrayRow = arrayOfArrayRow[i];
      if (localArrayRow != paramArrayRow) {
        break label235;
      }
    }
    for (;;)
    {
      i += 1;
      break label211;
      break;
      label235:
      localArrayRow.variables.updateFromRow(localArrayRow, paramArrayRow);
      localArrayRow.updateClientEquations();
    }
  }
  
  public ArrayRow addEquality(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt1);
    paramSolverVariable1 = createErrorVariable();
    paramSolverVariable2 = createErrorVariable();
    paramSolverVariable1.strength = paramInt2;
    paramSolverVariable2.strength = paramInt2;
    localArrayRow.addError(paramSolverVariable1, paramSolverVariable2);
    addConstraint(localArrayRow);
    return localArrayRow;
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt)
  {
    int i = paramSolverVariable.definitionId;
    if (paramSolverVariable.definitionId != -1)
    {
      localArrayRow = this.mRows[i];
      if (localArrayRow.isSimpleDefinition)
      {
        localArrayRow.constantValue = paramInt;
        return;
      }
      localArrayRow = createRow();
      localArrayRow.createRowEquals(paramSolverVariable, paramInt);
      addConstraint(localArrayRow);
      return;
    }
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDefinition(paramSolverVariable, paramInt);
    addConstraint(localArrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = paramInt2;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    addConstraint(localArrayRow);
  }
  
  public void addLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = paramInt2;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    addConstraint(localArrayRow);
  }
  
  public SolverVariable createErrorVariable()
  {
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    SolverVariable localSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    localSolverVariable.id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = localSolverVariable;
    return localSolverVariable;
  }
  
  public SolverVariable createObjectVariable(Object paramObject)
  {
    Object localObject2;
    if (paramObject == null) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      do
      {
        return (SolverVariable)localObject2;
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
          increaseTableSize();
        }
        localObject2 = null;
      } while (!(paramObject instanceof ConstraintAnchor));
      localObject2 = ((ConstraintAnchor)paramObject).getSolverVariable();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ((ConstraintAnchor)paramObject).resetSolverVariable(this.mCache);
        localObject1 = ((ConstraintAnchor)paramObject).getSolverVariable();
      }
      if ((((SolverVariable)localObject1).id == -1) || (((SolverVariable)localObject1).id > this.mVariablesID)) {
        break;
      }
      localObject2 = localObject1;
    } while (this.mCache.mIndexedVariables[localObject1.id] != null);
    if (((SolverVariable)localObject1).id != -1) {
      ((SolverVariable)localObject1).reset();
    }
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    ((SolverVariable)localObject1).id = this.mVariablesID;
    ((SolverVariable)localObject1).mType = SolverVariable.Type.UNRESTRICTED;
    this.mCache.mIndexedVariables[this.mVariablesID] = localObject1;
    return (SolverVariable)localObject1;
  }
  
  public ArrayRow createRow()
  {
    ArrayRow localArrayRow = (ArrayRow)this.mCache.arrayRowPool.acquire();
    if (localArrayRow == null) {
      return new ArrayRow(this.mCache);
    }
    localArrayRow.reset();
    return localArrayRow;
  }
  
  public SolverVariable createSlackVariable()
  {
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    SolverVariable localSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    localSolverVariable.id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = localSolverVariable;
    return localSolverVariable;
  }
  
  void displayReadableRows()
  {
    displaySolverVariables();
    String str1 = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      str1 = str1 + this.mRows[i].toReadableString();
      str1 = str1 + "\n";
      i += 1;
    }
    String str2 = str1;
    if (this.mGoal != null) {
      str2 = str1 + this.mGoal + "\n";
    }
    System.out.println(str2);
  }
  
  void displaySystemInformations()
  {
    int i = 0;
    int j = 0;
    while (j < this.TABLE_SIZE)
    {
      k = i;
      if (this.mRows[j] != null) {
        k = i + this.mRows[j].sizeInBytes();
      }
      j += 1;
      i = k;
    }
    int k = 0;
    j = 0;
    while (j < this.mNumRows)
    {
      int m = k;
      if (this.mRows[j] != null) {
        m = k + this.mRows[j].sizeInBytes();
      }
      j += 1;
      k = m;
    }
    System.out.println("Linear System -> Table size: " + this.TABLE_SIZE + " (" + getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE) + ") -- row sizes: " + getDisplaySize(i) + ", actual size: " + getDisplaySize(k) + " rows: " + this.mNumRows + "/" + this.mMaxRows + " cols: " + this.mNumColumns + "/" + this.mMaxColumns + " " + 0 + " occupied cells, " + getDisplaySize(0));
  }
  
  public void displayVariablesReadableRows()
  {
    displaySolverVariables();
    Object localObject1 = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      localObject2 = localObject1;
      if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED)
      {
        localObject1 = (String)localObject1 + this.mRows[i].toReadableString();
        localObject2 = (String)localObject1 + "\n";
      }
      i += 1;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (this.mGoal.variables.size() != 0) {
      localObject2 = (String)localObject1 + this.mGoal + "\n";
    }
    System.out.println((String)localObject2);
  }
  
  public Cache getCache()
  {
    return this.mCache;
  }
  
  Goal getGoal()
  {
    return this.mGoal;
  }
  
  public int getMemoryUsed()
  {
    int j = 0;
    int i = 0;
    while (i < this.mNumRows)
    {
      int k = j;
      if (this.mRows[i] != null) {
        k = j + this.mRows[i].sizeInBytes();
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public int getNumEquations()
  {
    return this.mNumRows;
  }
  
  public int getNumVariables()
  {
    return this.mVariablesID;
  }
  
  public int getObjectVariableValue(Object paramObject)
  {
    paramObject = ((ConstraintAnchor)paramObject).getSolverVariable();
    if (paramObject != null) {
      return (int)(((SolverVariable)paramObject).computedValue + 0.5F);
    }
    return 0;
  }
  
  ArrayRow getRow(int paramInt)
  {
    return this.mRows[paramInt];
  }
  
  float getValueFor(String paramString)
  {
    paramString = getVariable(paramString, SolverVariable.Type.UNRESTRICTED);
    if (paramString == null) {
      return 0.0F;
    }
    return paramString.computedValue;
  }
  
  SolverVariable getVariable(String paramString, SolverVariable.Type paramType)
  {
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    SolverVariable localSolverVariable2 = (SolverVariable)this.mVariables.get(paramString);
    SolverVariable localSolverVariable1 = localSolverVariable2;
    if (localSolverVariable2 == null) {
      localSolverVariable1 = createVariable(paramString, paramType);
    }
    return localSolverVariable1;
  }
  
  public void minimize()
    throws Exception
  {
    minimizeGoal(this.mGoal);
  }
  
  void minimizeGoal(Goal paramGoal)
    throws Exception
  {
    paramGoal.updateFromSystem(this);
    enforceBFS(paramGoal);
    optimize(paramGoal);
    computeValues();
  }
  
  void rebuildGoalFromErrors()
  {
    this.mGoal.updateFromSystem(this);
  }
  
  public void reset()
  {
    int i = 0;
    while (i < this.mCache.mIndexedVariables.length)
    {
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[i];
      if (localSolverVariable != null) {
        localSolverVariable.reset();
      }
      i += 1;
    }
    this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
    this.mPoolVariablesCount = 0;
    Arrays.fill(this.mCache.mIndexedVariables, null);
    if (this.mVariables != null) {
      this.mVariables.clear();
    }
    this.mVariablesID = 0;
    this.mGoal.variables.clear();
    this.mNumColumns = 1;
    i = 0;
    while (i < this.mNumRows)
    {
      this.mRows[i].used = false;
      i += 1;
    }
    releaseRows();
    this.mNumRows = 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/LinearSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */