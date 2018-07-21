package com.baidu.navisdk.util.common;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
  private static final String HTML_DIST = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
  private static final String HTML_DIST_NO_DECIMAL = "<font color=\"#ffffff\">%.0f</font><font color=\"#b5b7b6\">%s</font>";
  private static final String HTML_DIST_TIME = "<font color=\"#b5b7b6\">剩:</font>%s&nbsp;&nbsp;%s";
  private static final String HTML_DIST_WITH_DECIMAL = "<font color=\"#ffffff\">%.1f</font><font color=\"#b5b7b6\">%s</font>";
  public static final String HTML_TIME_HOUR = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
  public static final String HTML_TIME_HOUR_MINUTE = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font><font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
  public static final String HTML_TIME_MINUTE = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
  private static final int SECOND_OF_DAY = 86400;
  private static final int SECOND_OF_HOUR = 3600;
  private static final int SECOND_OF_MINUTE = 60;
  public static final int TIME_EN_UNIT = -1;
  public static final int TIME_ZH_UNIT = 2;
  private static final String UNIT_MINUTE = "分";
  public static final String lessOneMinute = "少于1分钟";
  public static final String[] unitDistArray = { "m", "km", "米", "公里" };
  public static final String[] unitTimeArray = { "m", "h", "分钟", "小时" };
  public static final String[] unitTimeArray2 = { "m", "h", "d", "分钟", "小时", "天" };
  
  public static String ByteSizeToString(int paramInt)
  {
    try
    {
      Object localObject = new DecimalFormat();
      if (paramInt < 1024) {
        return paramInt + "B";
      }
      if (paramInt < 1048576)
      {
        ((DecimalFormat)localObject).applyPattern("0");
        d = paramInt / 1024.0D;
        return ((DecimalFormat)localObject).format(d) + "K";
      }
      if (paramInt < 1073741824)
      {
        ((DecimalFormat)localObject).applyPattern("0.0");
        d = paramInt / 1048576.0D;
        return ((DecimalFormat)localObject).format(d) + "M";
      }
      ((DecimalFormat)localObject).applyPattern("0.0");
      double d = paramInt / 1.073741824E9D;
      localObject = ((DecimalFormat)localObject).format(d) + "G";
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "0";
  }
  
  public static String ByteSizeToStringForLong(Long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    if (paramLong.longValue() < 1024L) {
      return paramLong + "B";
    }
    if (paramLong.longValue() < 1048576L)
    {
      localDecimalFormat.applyPattern("0");
      d = paramLong.longValue() / 1024.0D;
      return localDecimalFormat.format(d) + "K";
    }
    if (paramLong.longValue() < 1073741824L)
    {
      localDecimalFormat.applyPattern("0.0");
      d = paramLong.longValue() / 1048576.0D;
      return localDecimalFormat.format(d) + "M";
    }
    localDecimalFormat.applyPattern("0.0");
    double d = paramLong.longValue() / 1.073741824E9D;
    return localDecimalFormat.format(d) + "G";
  }
  
  public static String charArrayToString(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfChar.length;
      int i = 0;
      for (;;)
      {
        char c;
        if (i < j)
        {
          c = paramArrayOfChar[i];
          if (c != 0) {}
        }
        else
        {
          return localStringBuilder.toString();
        }
        localStringBuilder.append(c);
        i += 1;
      }
    }
    return null;
  }
  
  public static void createDir(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString);
    } while (paramString.exists());
    paramString.mkdirs();
  }
  
  public static String customedFormatTime(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (localStringBuffer != null)
    {
      if (paramInt < 60) {
        localStringBuffer.append("少于1分钟");
      }
      for (;;)
      {
        return localStringBuffer.toString();
        String str = paramString1;
        if (paramString1 == null) {
          str = unitTimeArray2[5];
        }
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = unitTimeArray2[4];
        }
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = unitTimeArray2[3];
        }
        int i = paramInt / 3600 % 24;
        int j = paramInt / 60 % 60;
        if (paramInt < 3600)
        {
          localStringBuffer.append(j).append(paramString2);
        }
        else if (paramInt < 86400)
        {
          localStringBuffer.append(i).append(paramString1);
          if (j > 0) {
            localStringBuffer.append(j).append(paramString2);
          }
        }
        else
        {
          localStringBuffer.append(paramInt / 86400).append(str);
          if (i > 0) {
            localStringBuffer.append(i).append(paramString1);
          }
        }
      }
    }
    return "";
  }
  
  public static String doubleNumberToChineseWord(int paramInt)
  {
    paramInt %= 100;
    if (paramInt < 10) {
      return singleNumberToChineseWord(paramInt);
    }
    if (paramInt == 10) {
      return "十";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt >= 20) {
      localStringBuffer.append(singleNumberToChineseWord(paramInt / 10));
    }
    localStringBuffer.append("十");
    if (paramInt % 10 != 0) {
      localStringBuffer.append(singleNumberToChineseWord(paramInt % 10));
    }
    return localStringBuffer.toString();
  }
  
  public static String extractionChinese(String paramString)
  {
    Matcher localMatcher = Pattern.compile("([一-龥]+)").matcher(paramString);
    if (localMatcher.find()) {
      paramString = localMatcher.group(0);
    }
    return paramString;
  }
  
  public static void formatDistAndTime(int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null) {
      return;
    }
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    formatHtmlDistance(paramInt1, localStringBuffer1);
    formatHtmlTime(paramInt2, localStringBuffer2);
    paramStringBuffer.append(String.format("<font color=\"#b5b7b6\">剩:</font>%s&nbsp;&nbsp;%s", new Object[] { localStringBuffer1, localStringBuffer2 }));
  }
  
  public static String formatDistToChStrForGuide(int paramInt)
  {
    if (paramInt <= 0) {
      return "未知";
    }
    if (paramInt < 1000) {
      return numberToChineseWord(paramInt) + "米";
    }
    paramInt /= 1000;
    return numberToChineseWord(paramInt) + "公里";
  }
  
  public static String formatDistance(int paramInt, StringBuffer paramStringBuffer)
  {
    int i = 0;
    int j;
    String str;
    if (paramInt >= 1000)
    {
      j = 1;
      if (paramInt % 1000 == 0) {
        i = 1;
      }
      if (i != 0)
      {
        str = "%.0f";
        i = j;
        if (paramStringBuffer != null)
        {
          i = paramInt / 1000;
          if (i < 100) {
            break label85;
          }
          paramStringBuffer.append(String.format("%d", new Object[] { Integer.valueOf(i) }));
          i = j;
        }
      }
    }
    for (;;)
    {
      return unitDistArray[(0 + i)];
      str = "%.1f";
      break;
      label85:
      paramStringBuffer.append(String.format(str, new Object[] { Double.valueOf(paramInt / 1000.0D) }));
      i = j;
      continue;
      j = 0;
      i = j;
      if (paramStringBuffer != null)
      {
        paramStringBuffer.append(String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
        i = j;
      }
    }
  }
  
  public static void formatDistance(int paramInt, UnitLangEnum paramUnitLangEnum, StringBuffer paramStringBuffer)
  {
    int j = 0;
    int k = paramUnitLangEnum.getnUnit();
    int i = k;
    if (k != 0) {
      i = k + 1;
    }
    if (paramInt >= 1000)
    {
      if (paramInt % 1000 == 0) {
        j = 1;
      }
      if (j != 0)
      {
        paramUnitLangEnum = "%.0f%s";
        if (paramStringBuffer != null)
        {
          j = paramInt / 1000;
          if (j < 100) {
            break label107;
          }
          paramStringBuffer.append(String.format("%d%s", new Object[] { Integer.valueOf(j), unitDistArray[(i + 1)] }));
        }
      }
    }
    label107:
    while (paramStringBuffer == null)
    {
      for (;;)
      {
        return;
        paramUnitLangEnum = "%.1f%s";
      }
      paramStringBuffer.append(String.format(paramUnitLangEnum, new Object[] { Double.valueOf(paramInt / 1000.0D), unitDistArray[(i + 1)] }));
      return;
    }
    paramStringBuffer.append(String.format("%d%s", new Object[] { Integer.valueOf(paramInt), unitDistArray[(i + 0)] }));
  }
  
  public static String[] formatDistance(int paramInt, UnitLangEnum paramUnitLangEnum)
  {
    String[] arrayOfString = new String[2];
    int j = 0;
    int k = paramUnitLangEnum.getnUnit();
    int i = k;
    if (k != 0) {
      i = k + 1;
    }
    if (paramInt >= 1000)
    {
      if (paramInt % 1000 == 0) {
        j = 1;
      }
      if (j != 0)
      {
        arrayOfString[0] = String.format("%.0f", new Object[] { Double.valueOf(paramInt / 1000.0D) });
        arrayOfString[1] = unitDistArray[(i + 1)];
        return arrayOfString;
      }
      arrayOfString[0] = String.format("%.1f", new Object[] { Double.valueOf(paramInt / 1000.0D) });
      arrayOfString[1] = unitDistArray[(i + 1)];
      return arrayOfString;
    }
    arrayOfString[0] = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
    arrayOfString[1] = unitDistArray[(i + 0)];
    return arrayOfString;
  }
  
  public static String formatDistanceToChineseString(int paramInt)
  {
    if (paramInt <= 0) {
      return "未知";
    }
    if ((!XDVoiceInstructManager.XD_ROUSED) && (paramInt >= 100000)) {
      return "未知";
    }
    if (paramInt < 1000) {
      return numberToChineseWord(paramInt) + "米";
    }
    int i = paramInt % 1000 / 100;
    paramInt /= 1000;
    if (i == 0) {
      return numberToChineseWord(paramInt) + "公里";
    }
    return numberToChineseWord(paramInt) + "点" + singleNumberToChineseWord(i) + "公里";
  }
  
  public static String formatDistanceToString(int paramInt, UnitLangEnum paramUnitLangEnum)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    formatDistance(paramInt, paramUnitLangEnum, localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static void formatHtmlDistance(int paramInt, StringBuffer paramStringBuffer)
  {
    int i = 0;
    if (paramInt >= 1000)
    {
      if (paramInt % 1000 == 0) {
        i = 1;
      }
      if (i != 0)
      {
        str = "<font color=\"#ffffff\">%.0f</font><font color=\"#b5b7b6\">%s</font>";
        if (paramStringBuffer != null)
        {
          i = paramInt / 1000;
          if (i < 100) {
            break label78;
          }
          paramStringBuffer.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[] { Integer.valueOf(i), unitDistArray[1] }));
        }
      }
    }
    label78:
    while (paramStringBuffer == null)
    {
      String str;
      for (;;)
      {
        return;
        str = "<font color=\"#ffffff\">%.1f</font><font color=\"#b5b7b6\">%s</font>";
      }
      paramStringBuffer.append(String.format(str, new Object[] { Double.valueOf(paramInt / 1000.0D), unitDistArray[1] }));
      return;
    }
    paramStringBuffer.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[] { Integer.valueOf(paramInt), unitDistArray[0] }));
  }
  
  public static void formatHtmlTime(int paramInt, StringBuffer paramStringBuffer)
  {
    int i;
    if (paramInt >= 3600)
    {
      i = paramInt / 3600;
      paramInt = paramInt / 60 % 60;
      if (paramStringBuffer != null)
      {
        if (paramInt <= 0) {
          break label74;
        }
        paramStringBuffer.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font><font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[] { Integer.valueOf(i), unitTimeArray[1], Integer.valueOf(paramInt), unitTimeArray[0] }));
      }
    }
    label74:
    do
    {
      do
      {
        return;
        paramStringBuffer.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[] { Integer.valueOf(i), unitTimeArray[1] }));
        return;
        i = paramInt / 60;
        if (paramInt >= 60) {
          break;
        }
      } while (paramStringBuffer == null);
      paramStringBuffer.append("少于1分钟");
      return;
    } while (paramStringBuffer == null);
    paramStringBuffer.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[] { Integer.valueOf(i), unitTimeArray[0] }));
  }
  
  public static void formatTime(int paramInt, UnitLangEnum paramUnitLangEnum, StringBuffer paramStringBuffer)
  {
    int j = paramUnitLangEnum.getnUnit();
    int i = j;
    if (j != 0) {
      i = j + 1;
    }
    if (paramInt >= 3600) {
      if (((paramInt % 3600 < 0) || (paramInt % 3600 >= 360)) || (paramStringBuffer != null))
      {
        if (0 == 0) {
          break label91;
        }
        paramStringBuffer.append(String.format("%.1f%s", new Object[] { Double.valueOf(paramInt / 3600.0D), unitTimeArray[(i + 1)] }));
      }
    }
    label91:
    do
    {
      do
      {
        return;
        paramStringBuffer.append(String.format("%.0f%s", new Object[] { Double.valueOf(paramInt / 3600.0D), unitTimeArray[(i + 1)] }));
        return;
        if (paramInt >= 60) {
          break;
        }
      } while (paramStringBuffer == null);
      paramStringBuffer.append("少于1分钟");
      return;
    } while (paramStringBuffer == null);
    paramStringBuffer.append(String.format("%d%s", new Object[] { Integer.valueOf(paramInt / 60), unitTimeArray[(i + 0)] }));
  }
  
  public static String formatTime2(int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    formatTime2(paramInt1, paramInt2, localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static void formatTime2(int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer != null)
    {
      if (paramInt1 >= 60) {
        break label18;
      }
      paramStringBuffer.append("少于1分钟");
    }
    label18:
    int i;
    do
    {
      int j;
      do
      {
        return;
        i = paramInt1 / 3600 % 24;
        j = paramInt1 / 60 % 60;
        if (paramInt1 < 3600)
        {
          paramStringBuffer.append(j).append(unitTimeArray2[(paramInt2 + 1)]);
          return;
        }
        if (paramInt1 >= 86400) {
          break;
        }
        paramStringBuffer.append(i).append(unitTimeArray2[(paramInt2 + 2)]);
      } while (j <= 0);
      paramStringBuffer.append(j).append("分");
      return;
      paramStringBuffer.append(paramInt1 / 86400).append(unitTimeArray2[(paramInt2 + 3)]);
    } while (i <= 0);
    paramStringBuffer.append(i).append(unitTimeArray2[(paramInt2 + 2)]);
  }
  
  protected static int formatZeroInt(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    int j = paramInt1 / paramInt2;
    int i = j;
    if (0.5D + paramInt1 / paramInt2 >= j + 1) {
      i = j + 1;
    }
    return i * paramInt2;
  }
  
  public static double geoSphereDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d = paramDouble2 - paramDouble4;
    paramDouble1 = (paramDouble1 - paramDouble3) * Math.cos((paramDouble2 + paramDouble4) / 2.0D * 1.7453292519943294E-7D);
    return Math.sqrt((paramDouble1 * paramDouble1 + d * d) * 1.1119104D);
  }
  
  public static String getDirection(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 == 0.0D)
    {
      if (paramDouble2 == 0.0D) {
        return "无";
      }
      if (paramDouble2 > 0.0D) {
        return "北";
      }
      if (paramDouble2 < 0.0D) {
        return "南";
      }
    }
    paramDouble2 = Math.atan(paramDouble2 / paramDouble1);
    if (paramDouble1 > 0.0D)
    {
      if (paramDouble2 < -1.1780972450961724D) {
        return "南";
      }
      if (paramDouble2 < -0.39269908169872414D) {
        return "东南";
      }
      if (paramDouble2 < 0.39269908169872414D) {
        return "东";
      }
      if (paramDouble2 < 1.1780972450961724D) {
        return "东北";
      }
      return "北";
    }
    if (paramDouble2 < -1.1780972450961724D) {
      return "北";
    }
    if (paramDouble2 < -0.39269908169872414D) {
      return "西北";
    }
    if (paramDouble2 < 0.39269908169872414D) {
      return "西";
    }
    if (paramDouble2 < 1.1780972450961724D) {
      return "西南";
    }
    return "南";
  }
  
  public static String getDirection(double paramDouble, String paramString)
  {
    while (paramDouble < 0.0D) {
      paramDouble += 360.0D;
    }
    paramDouble %= 360.0D;
    String str;
    if ((paramDouble >= 330.0D) || (paramDouble <= 30.0D)) {
      str = BNStyleManager.getString(1711669375);
    }
    do
    {
      do
      {
        return str;
        if ((paramDouble > 30.0D) && (paramDouble <= 60.0D)) {
          return BNStyleManager.getString(1711669376);
        }
        if ((paramDouble > 60.0D) && (paramDouble <= 120.0D)) {
          return BNStyleManager.getString(1711669377);
        }
        if ((paramDouble > 120.0D) && (paramDouble <= 150.0D)) {
          return BNStyleManager.getString(1711669378);
        }
        if ((paramDouble > 150.0D) && (paramDouble <= 210.0D)) {
          return BNStyleManager.getString(1711669379);
        }
        if ((paramDouble > 210.0D) && (paramDouble <= 240.0D)) {
          return BNStyleManager.getString(1711669380);
        }
        if ((paramDouble > 240.0D) && (paramDouble <= 300.0D)) {
          return BNStyleManager.getString(1711669381);
        }
        str = paramString;
      } while (paramDouble <= 300.0D);
      str = paramString;
    } while (paramDouble >= 330.0D);
    return BNStyleManager.getString(1711669382);
  }
  
  public static String getDirectionStrByAngle(double paramDouble, String paramString)
  {
    double d = paramDouble;
    if (paramDouble < 0.0D) {
      d = paramDouble + 360.0D;
    }
    paramDouble = d % 360.0D;
    String str;
    if ((paramDouble > 315.0D) || (paramDouble <= 45.0D)) {
      str = BNStyleManager.getString(1711669375);
    }
    do
    {
      do
      {
        return str;
        if ((paramDouble > 45.0D) && (paramDouble <= 135.0D)) {
          return BNStyleManager.getString(1711669377);
        }
        if ((paramDouble > 135.0D) && (paramDouble <= 225.0D)) {
          return BNStyleManager.getString(1711669379);
        }
        str = paramString;
      } while (paramDouble <= 225.0D);
      str = paramString;
    } while (paramDouble > 315.0D);
    return BNStyleManager.getString(1711669381);
  }
  
  public static String getDistance(double paramDouble1, double paramDouble2)
  {
    paramDouble1 = Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2);
    if (paramDouble1 >= 1.0E7D) {
      return " ";
    }
    String str1;
    String str2;
    if (paramDouble1 >= 100000.0D)
    {
      str1 = String.valueOf((int)(paramDouble1 / 1000.0D));
      str2 = "km";
    }
    for (;;)
    {
      return str1 + str2;
      if (paramDouble1 >= 1000.0D)
      {
        str1 = String.valueOf((int)(paramDouble1 / 100.0D) / 10.0D);
        str2 = "km";
      }
      else
      {
        str1 = String.valueOf((int)paramDouble1);
        str2 = "m";
      }
    }
  }
  
  public static String getFormatTime(long paramLong)
  {
    if (paramLong < 60L) {
      return "小于1分钟";
    }
    long l3 = paramLong / 3600L;
    long l2 = paramLong % 3600L / 60L;
    long l1 = l2;
    if (paramLong % 60L >= 30L) {
      l1 = l2 + 1L;
    }
    l2 = l3;
    paramLong = l1;
    if (l1 > 59L)
    {
      l2 = l3 + 1L;
      paramLong = 0L;
    }
    String str1;
    if (l2 < 1L)
    {
      str1 = "";
      if (paramLong >= 1L) {
        break label139;
      }
    }
    label139:
    for (String str2 = "";; str2 = paramLong + "分钟")
    {
      return String.format("%s%s", new Object[] { str1, str2 });
      str1 = l2 + "小时";
      break;
    }
  }
  
  public static String getPoiAddress(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.endsWith("附近")) {
        str = "在" + paramString + "附近";
      }
    }
    else {
      return str;
    }
    return "在" + paramString;
  }
  
  public static String getUrlDecodeString(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String getUrlEncodeString(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isNavSetEndPointInvalid(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return Math.sqrt((paramInt3 - paramInt1) * (paramInt3 - paramInt1) + (paramInt4 - paramInt2) * (paramInt4 - paramInt2)) < 50.0D;
  }
  
  public static int isNavStartEndPointInvalid(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt3 == paramInt5) && (paramInt4 == paramInt6)) {
      return 1;
    }
    if (lineDistance(paramInt1, paramInt2, paramInt5, paramInt6) > 50.0D) {
      return 2;
    }
    if (lineDistance(paramInt1, paramInt2, paramInt3, paramInt4) < 100.0D) {
      return 3;
    }
    return 0;
  }
  
  public static boolean isNotEmpty(String paramString)
  {
    return (paramString != null) && (paramString.length() != 0);
  }
  
  public static double lineDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return Math.sqrt((paramDouble3 - paramDouble1) * (paramDouble3 - paramDouble1) + (paramDouble4 - paramDouble2) * (paramDouble4 - paramDouble2));
  }
  
  public static String numberToChineseWord(int paramInt)
  {
    Object localObject2 = "";
    if (paramInt < 0) {
      return "";
    }
    if (paramInt < 10) {
      return singleNumberToChineseWord(paramInt);
    }
    if (paramInt < 100) {
      return doubleNumberToChineseWord(paramInt);
    }
    int i = paramInt % 100000;
    if (i >= 10000) {
      localObject2 = "" + singleNumberToChineseWord(i / 10000) + "万";
    }
    i = paramInt % 10000;
    Object localObject1 = localObject2;
    if (i >= 1000) {
      localObject1 = (String)localObject2 + singleNumberToChineseWord(i / 1000) + "千";
    }
    i = paramInt % 1000;
    localObject2 = localObject1;
    if (i >= 100) {
      localObject2 = (String)localObject1 + singleNumberToChineseWord(i / 100) + "百";
    }
    i = paramInt % 100;
    localObject1 = localObject2;
    if (i >= 10) {
      localObject1 = (String)localObject2 + singleNumberToChineseWord(i / 10) + "十";
    }
    paramInt %= 10;
    localObject2 = localObject1;
    if (paramInt >= 1) {
      localObject2 = (String)localObject1 + singleNumberToChineseWord(paramInt);
    }
    return (String)localObject2;
  }
  
  public static String shortArrayToString(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfShort.length;
      int i = 0;
      for (;;)
      {
        int k;
        if (i < j)
        {
          k = paramArrayOfShort[i];
          if (k != 0) {}
        }
        else
        {
          return localStringBuilder.toString();
        }
        localStringBuilder.append((char)k);
        i += 1;
      }
    }
    return null;
  }
  
  public static void showToastText(Context paramContext, String paramString)
  {
    TipTool.onCreateToastDialog(paramContext, paramString);
  }
  
  public static String singleNumberToChineseWord(int paramInt)
  {
    switch (paramInt % 10)
    {
    default: 
      return "";
    case 0: 
      return "零";
    case 1: 
      return "一";
    case 2: 
      return "二";
    case 3: 
      return "三";
    case 4: 
      return "四";
    case 5: 
      return "五";
    case 6: 
      return "六";
    case 7: 
      return "七";
    case 8: 
      return "八";
    }
    return "九";
  }
  
  public static String trimString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Html.fromHtml(Html.fromHtml(paramString.toLowerCase(Locale.getDefault()).replace("\\t", "&#x0009;").replace("\\r", "&#x000d;").replace("\\n", "&#x000a;")).toString()).toString().toUpperCase();
  }
  
  public static enum UnitLangEnum
  {
    EN(0),  ZH(1);
    
    private int nUnit;
    
    private UnitLangEnum(int paramInt)
    {
      this.nUnit = paramInt;
    }
    
    public int getnUnit()
    {
      return this.nUnit;
    }
    
    public void setnUnit(int paramInt)
    {
      this.nUnit = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */