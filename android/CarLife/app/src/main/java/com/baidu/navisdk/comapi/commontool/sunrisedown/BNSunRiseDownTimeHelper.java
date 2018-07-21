package com.baidu.navisdk.comapi.commontool.sunrisedown;

import java.util.Calendar;
import java.util.TimeZone;

public class BNSunRiseDownTimeHelper
{
  private static final double AirRefr = 0.5666666666666667D;
  private static final double DEGS = 57.29577951308232D;
  private static final double PI = 3.141592653589793D;
  private static final double RADS = 0.017453292519943295D;
  private static final double SUNDIA = 0.53D;
  private static final double TPI = 6.283185307179586D;
  private static BNSunRiseDownTimeHelper me;
  private double L;
  private double daylen;
  private double g;
  
  private double FNday(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    return ((paramInt2 + 9) / 12 + paramInt1) * -7 / 4 + paramInt2 * 275 / 9 + paramInt3 + paramInt1 * 367L - 730531.5D + paramFloat / 24.0D;
  }
  
  private double FNrange(double paramDouble)
  {
    paramDouble /= 6.283185307179586D;
    double d = 6.283185307179586D * (paramDouble - paramDouble);
    paramDouble = d;
    if (d < 0.0D) {
      paramDouble = d + 6.283185307179586D;
    }
    return paramDouble;
  }
  
  private double FNsun(double paramDouble)
  {
    this.L = FNrange(4.894967873435816D + 0.017202792393721557D * paramDouble);
    this.g = FNrange(6.240040768070287D + 0.017201970343643867D * paramDouble);
    return FNrange(this.L + 0.03342305517569141D * Math.sin(this.g) + 3.4906585039886593E-4D * Math.sin(2.0D * this.g));
  }
  
  private double f0(double paramDouble1, double paramDouble2)
  {
    double d = 0.014515321612419507D;
    if (paramDouble1 < 0.0D) {
      d = -0.014515321612419507D;
    }
    paramDouble2 = Math.tan(paramDouble2 + d) * Math.tan(0.017453292519943295D * paramDouble1);
    paramDouble1 = paramDouble2;
    if (paramDouble2 > 0.99999D) {
      paramDouble1 = 1.0D;
    }
    return Math.asin(paramDouble1) + 1.5707963267948966D;
  }
  
  private double f1(double paramDouble1, double paramDouble2)
  {
    double d = 0.10471975511965978D;
    if (paramDouble1 < 0.0D) {
      d = -0.10471975511965978D;
    }
    paramDouble2 = Math.tan(paramDouble2 + d) * Math.tan(0.017453292519943295D * paramDouble1);
    paramDouble1 = paramDouble2;
    if (paramDouble2 > 0.99999D) {
      paramDouble1 = 1.0D;
    }
    return Math.asin(paramDouble1) + 1.5707963267948966D;
  }
  
  public static BNSunRiseDownTimeHelper getIntanse()
  {
    if (me == null) {
      me = new BNSunRiseDownTimeHelper();
    }
    return me;
  }
  
  private int getTimeZoneHourDiff()
  {
    Object localObject2 = TimeZone.getTimeZone("Etc/GMT-8");
    Object localObject1 = TimeZone.getDefault();
    if ((localObject2 == null) || (localObject1 == null)) {}
    do
    {
      return 0;
      localObject2 = Calendar.getInstance((TimeZone)localObject2);
      localObject1 = Calendar.getInstance((TimeZone)localObject1);
    } while ((localObject2 == null) || (localObject1 == null));
    return (((Calendar)localObject1).get(15) + ((Calendar)localObject1).get(16) - ((Calendar)localObject2).get(15)) / 3600000;
  }
  
  private void showhrmn(double paramDouble, int paramInt, SunInteger paramSunInteger1, SunInteger paramSunInteger2)
  {
    int i = (int)paramDouble;
    int j = (int)((paramDouble - i) * 60.0D);
    paramSunInteger1.integer = (i + paramInt);
    paramSunInteger2.integer = j;
  }
  
  public SunRiseDownHM calulatetm(double paramDouble1, double paramDouble2)
  {
    SunRiseDownHM localSunRiseDownHM = new SunRiseDownHM();
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    double d3 = (int)(paramDouble2 / 15.0D + 1.0D);
    int m = 8 - (int)d3;
    double d2 = FNday(i, j + 1, k, 12);
    double d1 = FNsun(d2);
    double d4 = 0.4090877233749509D - 6.981317007977318E-9D * d2;
    d2 = Math.atan2(Math.cos(d4) * Math.sin(d1), Math.cos(d1));
    d4 = Math.asin(Math.sin(d4) * Math.sin(d1));
    d2 = this.L - d2;
    d1 = d2;
    if (this.L < 3.141592653589793D) {
      d1 = d2 + 6.283185307179586D;
    }
    d2 = 1440.0D * (1.0D - d1 / 6.283185307179586D);
    paramDouble1 = f0(paramDouble1, d4);
    this.daylen = (57.29577951308232D * paramDouble1 / 7.5D);
    if (this.daylen < 1.0E-4D) {
      this.daylen = 0.0D;
    }
    d1 = 12.0D - 12.0D * paramDouble1 / 3.141592653589793D + d3 - paramDouble2 / 15.0D + d2 / 60.0D;
    d2 = 12.0D + 12.0D * paramDouble1 / 3.141592653589793D + d3 - paramDouble2 / 15.0D + d2 / 60.0D;
    paramDouble1 = d1;
    if (d1 > 24.0D) {
      paramDouble1 = d1 - 24.0D;
    }
    paramDouble2 = d2;
    if (d2 > 24.0D) {
      paramDouble2 = d2 - 24.0D;
    }
    showhrmn(paramDouble1, m, localSunRiseDownHM.riseHour, localSunRiseDownHM.riseMin);
    showhrmn(paramDouble2, m, localSunRiseDownHM.downHour, localSunRiseDownHM.downMin);
    return localSunRiseDownHM;
  }
  
  public void updateInternationalTimeZone(SunRiseDownHM paramSunRiseDownHM)
  {
    if ((paramSunRiseDownHM == null) || (paramSunRiseDownHM.downHour == null) || (paramSunRiseDownHM.riseHour == null)) {
      return;
    }
    int i = getTimeZoneHourDiff();
    SunInteger localSunInteger = paramSunRiseDownHM.downHour;
    localSunInteger.integer += i;
    paramSunRiseDownHM = paramSunRiseDownHM.riseHour;
    paramSunRiseDownHM.integer += i;
  }
  
  private class SunInteger
  {
    int integer;
    
    private SunInteger() {}
    
    public int getInteger()
    {
      return this.integer;
    }
    
    public void setInteger(int paramInt)
    {
      this.integer = paramInt;
    }
  }
  
  public class SunRiseDownHM
  {
    private BNSunRiseDownTimeHelper.SunInteger downHour = new BNSunRiseDownTimeHelper.SunInteger(BNSunRiseDownTimeHelper.this, null);
    private BNSunRiseDownTimeHelper.SunInteger downMin = new BNSunRiseDownTimeHelper.SunInteger(BNSunRiseDownTimeHelper.this, null);
    private BNSunRiseDownTimeHelper.SunInteger riseHour = new BNSunRiseDownTimeHelper.SunInteger(BNSunRiseDownTimeHelper.this, null);
    private BNSunRiseDownTimeHelper.SunInteger riseMin = new BNSunRiseDownTimeHelper.SunInteger(BNSunRiseDownTimeHelper.this, null);
    
    public SunRiseDownHM() {}
    
    public int getDownHour()
    {
      return this.downHour.getInteger();
    }
    
    public int getDownMin()
    {
      return this.downMin.getInteger();
    }
    
    public int getRiseHour()
    {
      return this.riseHour.getInteger();
    }
    
    public int getRiseMin()
    {
      return this.riseMin.getInteger();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/commontool/sunrisedown/BNSunRiseDownTimeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */