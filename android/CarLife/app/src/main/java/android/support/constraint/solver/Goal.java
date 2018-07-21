package android.support.constraint.solver;

import java.util.ArrayList;

public class Goal
{
  ArrayList<SolverVariable> variables = new ArrayList();
  
  private void initFromSystemErrors(LinearSystem paramLinearSystem)
  {
    this.variables.clear();
    int i = 1;
    if (i < paramLinearSystem.mNumColumns)
    {
      SolverVariable localSolverVariable = paramLinearSystem.mCache.mIndexedVariables[i];
      int j = 0;
      while (j < 6)
      {
        localSolverVariable.strengthVector[j] = 0.0F;
        j += 1;
      }
      localSolverVariable.strengthVector[localSolverVariable.strength] = 1.0F;
      if (localSolverVariable.mType != SolverVariable.Type.ERROR) {}
      for (;;)
      {
        i += 1;
        break;
        this.variables.add(localSolverVariable);
      }
    }
  }
  
  SolverVariable getPivotCandidate()
  {
    int n = this.variables.size();
    Object localObject2 = null;
    int j = 0;
    int m = 0;
    while (m < n)
    {
      SolverVariable localSolverVariable = (SolverVariable)this.variables.get(m);
      int i = 5;
      while (i >= 0)
      {
        float f = localSolverVariable.strengthVector[i];
        Object localObject1 = localObject2;
        int k = j;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          k = j;
          if (f < 0.0F)
          {
            localObject1 = localObject2;
            k = j;
            if (i >= j)
            {
              k = i;
              localObject1 = localSolverVariable;
            }
          }
        }
        localObject2 = localObject1;
        j = k;
        if (f > 0.0F)
        {
          localObject2 = localObject1;
          j = k;
          if (i > k)
          {
            j = i;
            localObject2 = null;
          }
        }
        i -= 1;
      }
      m += 1;
    }
    return (SolverVariable)localObject2;
  }
  
  public String toString()
  {
    String str = "Goal: ";
    int j = this.variables.size();
    int i = 0;
    while (i < j)
    {
      SolverVariable localSolverVariable = (SolverVariable)this.variables.get(i);
      str = str + localSolverVariable.strengthsToString();
      i += 1;
    }
    return str;
  }
  
  void updateFromSystem(LinearSystem paramLinearSystem)
  {
    initFromSystemErrors(paramLinearSystem);
    int m = this.variables.size();
    int i = 0;
    while (i < m)
    {
      SolverVariable localSolverVariable1 = (SolverVariable)this.variables.get(i);
      if (localSolverVariable1.definitionId != -1)
      {
        ArrayLinkedVariables localArrayLinkedVariables = paramLinearSystem.getRow(localSolverVariable1.definitionId).variables;
        int n = localArrayLinkedVariables.currentSize;
        int j = 0;
        if (j < n)
        {
          SolverVariable localSolverVariable2 = localArrayLinkedVariables.getVariable(j);
          if (localSolverVariable2 == null) {}
          for (;;)
          {
            j += 1;
            break;
            float f = localArrayLinkedVariables.getVariableValue(j);
            int k = 0;
            while (k < 6)
            {
              float[] arrayOfFloat = localSolverVariable2.strengthVector;
              arrayOfFloat[k] += localSolverVariable1.strengthVector[k] * f;
              k += 1;
            }
            if (!this.variables.contains(localSolverVariable2)) {
              this.variables.add(localSolverVariable2);
            }
          }
        }
        localSolverVariable1.clearStrengths();
      }
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/Goal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */