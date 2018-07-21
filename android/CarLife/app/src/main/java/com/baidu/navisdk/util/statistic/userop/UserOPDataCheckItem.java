package com.baidu.navisdk.util.statistic.userop;

import android.os.Bundle;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

public class UserOPDataCheckItem
  implements StatisitcsDataCheck
{
  private Bundle mDataCheckBundle = null;
  
  public UserOPDataCheckItem(ArrayList<NameValuePair> paramArrayList)
  {
    if (this.mDataCheckBundle == null) {
      this.mDataCheckBundle = new Bundle();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (NameValuePair)paramArrayList.next();
      String str = ((NameValuePair)localObject).getName();
      localObject = ((NameValuePair)localObject).getValue();
      this.mDataCheckBundle.putString(str, (String)localObject);
    }
  }
  
  public void check()
  {
    DataCheckCenter.getInstance().check(this);
  }
  
  public Bundle getDataBundle()
  {
    return this.mDataCheckBundle;
  }
  
  public String getID()
  {
    return "50008";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/userop/UserOPDataCheckItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */