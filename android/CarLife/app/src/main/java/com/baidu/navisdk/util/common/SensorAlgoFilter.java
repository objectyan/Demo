package com.baidu.navisdk.util.common;

public class SensorAlgoFilter
{
  private float mBarrier = 2.0F;
  private float mOldV;
  
  public SensorAlgoFilter() {}
  
  public SensorAlgoFilter(float paramFloat)
  {
    this.mBarrier = paramFloat;
  }
  
  private float checkAndCalc(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = paramFloat1 - paramFloat2;
    float f1;
    if ((f2 > 180.0F) || (f2 < -180.0F)) {
      f1 = paramFloat2;
    }
    do
    {
      return f1;
      if (f2 < -paramFloat3) {
        break;
      }
      f1 = paramFloat1;
    } while (paramFloat3 >= f2);
    return (paramFloat1 + paramFloat2) / 2.0F;
  }
  
  public float execute(float paramFloat)
  {
    this.mOldV = checkAndCalc(this.mOldV, paramFloat, this.mBarrier);
    return this.mOldV;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/SensorAlgoFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */