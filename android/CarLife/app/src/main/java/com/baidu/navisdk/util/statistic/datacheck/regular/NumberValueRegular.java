package com.baidu.navisdk.util.statistic.datacheck.regular;

import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import java.util.List;

public class NumberValueRegular<T extends Number>
  extends Regular
{
  public List<T> arrValues = null;
  public String category = null;
  public T fixValue = null;
  
  public NumberValueRegular(GeneralRegularData paramGeneralRegularData, String paramString)
  {
    super(paramGeneralRegularData, paramString, null, null);
  }
  
  public boolean check()
  {
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/regular/NumberValueRegular.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */