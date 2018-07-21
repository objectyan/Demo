package com.baidu.navisdk.lightnavi.utils;

import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class LightNaviCalculateUtils
{
  public static String calculateArriveTime(int paramInt)
  {
    long l = System.currentTimeMillis();
    Date localDate1 = new Date(l);
    Date localDate2 = new Date(l + paramInt * 1000);
    String str = new SimpleDateFormat("HH:mm").format(localDate2);
    if (localDate1.getDay() == localDate2.getDay()) {
      return String.format(BNStyleManager.getString(1711669855), new Object[] { str });
    }
    paramInt = getIntervalDays(localDate1, localDate2);
    if (paramInt == 1) {
      return String.format(BNStyleManager.getString(1711669855), new Object[] { BNStyleManager.getString(1711669853) });
    }
    if (paramInt == 2) {
      return String.format(BNStyleManager.getString(1711669855), new Object[] { BNStyleManager.getString(1711669854) });
    }
    if (paramInt > 2) {
      return String.format(BNStyleManager.getString(1711669857), new Object[] { "" + paramInt });
    }
    return String.format(BNStyleManager.getString(1711669855), new Object[] { str });
  }
  
  public static String calculateNaviRemainTimeString(int paramInt)
  {
    long l = System.currentTimeMillis();
    Date localDate1 = new Date(l);
    Date localDate2 = new Date(l + paramInt * 1000);
    String str = new SimpleDateFormat("HH:mm").format(localDate2);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    localGregorianCalendar1.setTime(localDate1);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTime(localDate2);
    if (localGregorianCalendar1.get(5) == localGregorianCalendar2.get(5))
    {
      if (localGregorianCalendar2.get(11) == 0) {
        return String.format(BNStyleManager.getString(1711669856), new Object[] { str });
      }
      return String.format(BNStyleManager.getString(1711669855), new Object[] { str });
    }
    paramInt = getIntervalDays(localDate1, localDate2);
    if (paramInt == 1)
    {
      if ((localGregorianCalendar2.get(11) >= 0) && (localGregorianCalendar2.get(11) < 4)) {
        return String.format(BNStyleManager.getString(1711669855), new Object[] { BNStyleManager.getString(1711669852) });
      }
      return String.format(BNStyleManager.getString(1711669855), new Object[] { BNStyleManager.getString(1711669853) });
    }
    if (paramInt == 2) {
      return String.format(BNStyleManager.getString(1711669855), new Object[] { BNStyleManager.getString(1711669854) });
    }
    if (paramInt > 2) {
      return String.format(BNStyleManager.getString(1711669857), new Object[] { "" + paramInt });
    }
    return String.format(BNStyleManager.getString(1711669855), new Object[] { str });
  }
  
  public static String calculateTotalRemainDistString(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringUtils.formatDistance(paramInt, StringUtils.UnitLangEnum.ZH, localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static String calculateTotalRemainTimeString(int paramInt)
  {
    Object localObject = new StringBuffer();
    StringUtils.formatTime2(paramInt, 2, (StringBuffer)localObject);
    String str = ((StringBuffer)localObject).toString();
    localObject = str;
    if (str.equals("0分钟")) {
      localObject = "1分钟";
    }
    return "剩余 " + ((String)localObject).toString();
  }
  
  private static int getIntervalDays(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 == null) || (paramDate2 == null)) {
      return 0;
    }
    return (int)((paramDate2.getTime() - paramDate1.getTime()) / 86400000L);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/utils/LightNaviCalculateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */