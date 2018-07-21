package com.baidu.nplatform.comapi.map;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class MapUtils
{
  static double[][] LL2MC = { { -0.0015702102444D, 111320.7020616939D, 1.704480524535203E15D, -1.033898737604234E16D, 2.611266785660388E16D, -3.51496691766537E16D, 2.659570071840392E16D, -1.072501245418824E16D, 1.800819912950474E15D, 82.5D }, { 8.277824516172526E-4D, 111320.7020463578D, 6.477955746671607E8D, -4.082003173641316E9D, 1.077490566351142E10D, -1.517187553151559E10D, 1.205306533862167E10D, -5.124939663577472E9D, 9.133119359512032E8D, 67.5D }, { 0.00337398766765D, 111320.7020202162D, 4481351.045890365D, -2.339375119931662E7D, 7.968221547186455E7D, -1.159649932797253E8D, 9.723671115602145E7D, -4.366194633752821E7D, 8477230.501135234D, 52.5D }, { 0.00220636496208D, 111320.7020209128D, 51751.86112841131D, 3796837.749470245D, 992013.7397791013D, -1221952.21711287D, 1340652.697009075D, -620943.6990984312D, 144416.9293806241D, 37.5D }, { -3.441963504368392E-4D, 111320.7020576856D, 278.2353980772752D, 2485758.690035394D, 6070.750963243378D, 54821.18345352118D, 9540.606633304236D, -2710.55326746645D, 1405.483844121726D, 22.5D }, { -3.218135878613132E-4D, 111320.7020701615D, 0.00369383431289D, 823725.6402795718D, 0.46104986909093D, 2351.343141331292D, 1.58060784298199D, 8.77738589078284D, 0.37238884252424D, 7.45D } };
  static double[] LLBAND;
  static double[][] MC2LL;
  static double[] MCBAND = { 1.289059486E7D, 8362377.87D, 5591021.0D, 3481989.83D, 1678043.12D, 0.0D };
  
  static
  {
    LLBAND = new double[] { 7.5E7D, 6.0E7D, 4.5E7D, 3.0E7D, 1.5E7D, 0.0D };
    double[] arrayOfDouble1 = { -7.435856389565537E-9D, 8.983055097726239E-6D, -0.78625201886289D, 96.32687599759846D, -1.85204757529826D, -59.36935905485877D, 47.40033549296737D, -16.50741931063887D, 2.28786674699375D, 1.026014486E7D };
    double[] arrayOfDouble2 = { 3.09191371068437E-9D, 8.983055096812155E-6D, 6.995724062E-5D, 23.10934304144901D, -2.3663490511E-4D, -0.6321817810242D, -0.00663494467273D, 0.03430082397953D, -0.00466043876332D, 2555164.4D };
    MC2LL = new double[][] { { 1.410526172116255E-8D, 8.98305509648872E-6D, -1.9939833816331D, 200.9824383106796D, -187.2403703815547D, 91.6087516669843D, -23.38765649603339D, 2.57121317296198D, -0.03801003308653D, 1.73379812E7D }, arrayOfDouble1, { -3.030883460898826E-8D, 8.98305509983578E-6D, 0.30071316287616D, 59.74293618442277D, 7.357984074871D, -25.38371002664745D, 13.45380521110908D, -3.29883767235584D, 0.32710905363475D, 6856817.37D }, { -1.981981304930552E-8D, 8.983055099779535E-6D, 0.03278182852591D, 40.31678527705744D, 0.65659298677277D, -4.44255534477492D, 0.85341911805263D, 0.12923347998204D, -0.04625736007561D, 4482777.06D }, arrayOfDouble2, { 2.890871144776878E-9D, 8.983055095805407E-6D, -3.068298E-8D, 7.47137025468032D, -3.53937994E-6D, -0.02145144861037D, -1.234426596E-5D, 1.0322952773E-4D, -3.23890364E-6D, 826088.5D } };
  }
  
  static VDPOINT _conv_(VDPOINT paramVDPOINT, double[] paramArrayOfDouble)
  {
    int j = -1;
    VDPOINT localVDPOINT = new VDPOINT();
    localVDPOINT.x = (paramArrayOfDouble[0] + paramArrayOfDouble[1] * Math.abs(paramVDPOINT.x));
    double d = Math.abs(paramVDPOINT.y) / paramArrayOfDouble[9];
    localVDPOINT.y = (paramArrayOfDouble[2] + paramArrayOfDouble[3] * d + paramArrayOfDouble[4] * d * d + paramArrayOfDouble[5] * d * d * d + paramArrayOfDouble[6] * d * d * d * d + paramArrayOfDouble[7] * d * d * d * d * d + paramArrayOfDouble[8] * d * d * d * d * d * d);
    d = localVDPOINT.x;
    if (paramVDPOINT.x < 0.0D)
    {
      i = -1;
      localVDPOINT.x = (d * i);
      d = localVDPOINT.y;
      if (paramVDPOINT.y >= 0.0D) {
        break label188;
      }
    }
    label188:
    for (int i = j;; i = 1)
    {
      localVDPOINT.y = (i * d);
      return localVDPOINT;
      i = 1;
      break;
    }
  }
  
  public static GeoPoint ll2mc(GeoPoint paramGeoPoint)
  {
    VDPOINT localVDPOINT = new VDPOINT();
    Object localObject2 = null;
    localVDPOINT.y = Math.abs(paramGeoPoint.getLatitudeE6());
    if (localVDPOINT.y < 0.1D) {
      localVDPOINT.y = 0.1D;
    }
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < LLBAND.length)
      {
        if (localVDPOINT.y > LLBAND[i]) {
          localObject1 = LL2MC[i];
        }
      }
      else
      {
        localVDPOINT.x = (paramGeoPoint.getLongitudeE6() / 1000000.0D);
        localVDPOINT.y = (paramGeoPoint.getLatitudeE6() / 1000000.0D);
        paramGeoPoint = _conv_(localVDPOINT, (double[])localObject1);
        return new GeoPoint((int)paramGeoPoint.y, (int)paramGeoPoint.x);
      }
      i += 1;
    }
  }
  
  public static GeoPoint mc2ll(GeoPoint paramGeoPoint)
  {
    VDPOINT localVDPOINT1 = new VDPOINT();
    localVDPOINT1.x = paramGeoPoint.getLongitudeE6();
    localVDPOINT1.y = paramGeoPoint.getLatitudeE6();
    VDPOINT localVDPOINT2 = new VDPOINT();
    localVDPOINT2.x = localVDPOINT1.x;
    label95:
    int i;
    if (localVDPOINT2.x > 2.0037508342E7D)
    {
      localVDPOINT2.x = 2.0037508342E7D;
      localVDPOINT2.y = localVDPOINT1.y;
      if ((localVDPOINT2.y >= 1.0E-6D) || (localVDPOINT2.y < 0.0D)) {
        break label182;
      }
      localVDPOINT2.y = 1.0E-6D;
      localVDPOINT1 = null;
      i = 0;
    }
    for (;;)
    {
      paramGeoPoint = localVDPOINT1;
      if (i < 6)
      {
        if (Math.abs(localVDPOINT2.y) > MCBAND[i]) {
          paramGeoPoint = MC2LL[i];
        }
      }
      else
      {
        paramGeoPoint = _conv_(localVDPOINT2, paramGeoPoint);
        return new GeoPoint((int)(paramGeoPoint.y * 1000000.0D), (int)(paramGeoPoint.x * 1000000.0D));
        if (localVDPOINT2.x >= -2.0037508342E7D) {
          break;
        }
        localVDPOINT2.x = -2.0037508342E7D;
        break;
        label182:
        if ((localVDPOINT2.y < 0.0D) && (localVDPOINT2.y > -1.0E-6D))
        {
          localVDPOINT2.y = -1.0E-6D;
          break label95;
        }
        if (localVDPOINT2.y > 2.0037508342E7D)
        {
          localVDPOINT2.y = 2.0037508342E7D;
          break label95;
        }
        if (localVDPOINT2.y >= -2.0037508342E7D) {
          break label95;
        }
        localVDPOINT2.y = -2.0037508342E7D;
        break label95;
      }
      i += 1;
    }
  }
  
  static class VDPOINT
  {
    double x;
    double y;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/MapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */