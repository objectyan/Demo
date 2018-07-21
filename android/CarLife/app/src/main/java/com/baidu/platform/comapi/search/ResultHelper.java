package com.baidu.platform.comapi.search;

import com.baidu.entity.pb.ReverseGeocoding;
import com.baidu.entity.pb.ReverseGeocoding.AddressDetail;
import com.baidu.entity.pb.ReverseGeocoding.SurroundPoi;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class ResultHelper
{
  public static boolean parseStringToAddrResult(MessageMicro paramMessageMicro, AddrResult paramAddrResult)
  {
    if ((paramMessageMicro == null) || (!(paramMessageMicro instanceof ReverseGeocoding))) {
      return false;
    }
    Object localObject = (ReverseGeocoding)paramMessageMicro;
    paramMessageMicro = paramAddrResult;
    if (paramAddrResult == null) {
      paramMessageMicro = new AddrResult();
    }
    paramMessageMicro.address = ((ReverseGeocoding)localObject).getAddress();
    paramMessageMicro.floorId = ((ReverseGeocoding)localObject).getFloor();
    paramMessageMicro.buildingId = ((ReverseGeocoding)localObject).getBuildId();
    paramMessageMicro.nearby = ((ReverseGeocoding)localObject).getNearby();
    paramAddrResult = ((ReverseGeocoding)localObject).getAddressDetail();
    if (paramAddrResult != null)
    {
      paramMessageMicro.getClass();
      paramMessageMicro.addressDetail = new AddrResult.AddressDetail(paramMessageMicro);
      paramMessageMicro.addressDetail.country = paramAddrResult.getCountry();
      paramMessageMicro.addressDetail.countryCode = paramAddrResult.getCountryCode();
      paramMessageMicro.addressDetail.cityCode = paramAddrResult.getCityCode();
      paramMessageMicro.addressDetail.cityName = paramAddrResult.getCity();
      paramMessageMicro.addressDetail.district = paramAddrResult.getDistrict();
      paramMessageMicro.addressDetail.province = paramAddrResult.getProvince();
      paramMessageMicro.addressDetail.street = paramAddrResult.getStreet();
    }
    for (paramMessageMicro.addressDetail.streetNum = paramAddrResult.getStreetNumber();; paramMessageMicro.addressDetail.streetNum = "")
    {
      paramMessageMicro.pano = ((ReverseGeocoding)localObject).getPano();
      paramMessageMicro.streetId = ((ReverseGeocoding)localObject).getStreetScapeID();
      paramMessageMicro.business = ((ReverseGeocoding)localObject).getBusiness();
      paramAddrResult = ((ReverseGeocoding)localObject).getPoint();
      int j;
      if (paramAddrResult != null)
      {
        i = paramAddrResult.getX();
        j = paramAddrResult.getY();
        paramMessageMicro.setPoint(new com.baidu.platform.comapi.basestruct.Point(i, j));
      }
      if (paramMessageMicro.getSurround_poi() != null) {
        paramMessageMicro.getSurround_poi().clear();
      }
      paramAddrResult = ((ReverseGeocoding)localObject).getSurroundPoiList();
      if ((paramAddrResult == null) || (paramAddrResult.isEmpty())) {
        break;
      }
      int i = 0;
      while (i < paramAddrResult.size())
      {
        paramMessageMicro.getClass();
        localObject = new AddrResult.GeoPoiInfo(paramMessageMicro);
        ReverseGeocoding.SurroundPoi localSurroundPoi = (ReverseGeocoding.SurroundPoi)paramAddrResult.get(i);
        ((AddrResult.GeoPoiInfo)localObject).distance = localSurroundPoi.getDistance();
        ((AddrResult.GeoPoiInfo)localObject).addr = localSurroundPoi.getAddr();
        ((AddrResult.GeoPoiInfo)localObject).uid = localSurroundPoi.getUid();
        ((AddrResult.GeoPoiInfo)localObject).floorId = localSurroundPoi.getFloorId();
        ((AddrResult.GeoPoiInfo)localObject).buildingId = localSurroundPoi.getBuildingId();
        ((AddrResult.GeoPoiInfo)localObject).name = localSurroundPoi.getName();
        ((AddrResult.GeoPoiInfo)localObject).pano = localSurroundPoi.getPano();
        ((AddrResult.GeoPoiInfo)localObject).indoorPano = localSurroundPoi.getIndoorPano();
        com.baidu.entity.pb.Point localPoint = localSurroundPoi.getPoint();
        if (localPoint != null)
        {
          j = localPoint.getX();
          int k = localPoint.getY();
          ((AddrResult.GeoPoiInfo)localObject).setPoint(new com.baidu.platform.comapi.basestruct.Point(j, k));
        }
        ((AddrResult.GeoPoiInfo)localObject).tag = localSurroundPoi.getTag();
        paramMessageMicro.setSurround_poi((AddrResult.GeoPoiInfo)localObject);
        i += 1;
      }
      paramMessageMicro.getClass();
      paramMessageMicro.addressDetail = new AddrResult.AddressDetail(paramMessageMicro);
      paramMessageMicro.addressDetail.country = "";
      paramMessageMicro.addressDetail.countryCode = 0;
      paramMessageMicro.addressDetail.cityCode = 0;
      paramMessageMicro.addressDetail.cityName = "";
      paramMessageMicro.addressDetail.district = "";
      paramMessageMicro.addressDetail.province = "";
      paramMessageMicro.addressDetail.street = "";
    }
    return true;
  }
  
  public static boolean parseStringToCityInfoResult(String paramString, CityInfo paramCityInfo)
  {
    if (paramString != null) {
      try
      {
        if (!paramString.equals(""))
        {
          if (paramCityInfo == null) {
            return false;
          }
          paramString = new JSONObject(paramString);
          paramCityInfo.mResultType = paramString.optInt("result_type");
          paramCityInfo.mCityType = paramString.optInt("type");
          if (paramCityInfo.mResultType == 4)
          {
            paramCityInfo.mCityCode = paramString.optInt("code");
            paramCityInfo.mCityName = paramString.optString("name");
          }
          if (paramCityInfo.mResultType == 2)
          {
            JSONObject localJSONObject = paramString.optJSONObject("current_city");
            if (localJSONObject != null)
            {
              paramCityInfo.mCityCode = localJSONObject.optInt("code");
              paramCityInfo.mCityName = localJSONObject.optString("name");
            }
          }
          paramCityInfo.mcName = paramString.optString("name");
          paramCityInfo.mLevel = paramString.optInt("level");
          paramCityInfo.mCityUid = paramString.optString("uid");
          paramCityInfo.mSup_bus = paramString.optBoolean("sup_bus");
          paramCityInfo.mSup_subway = paramString.optBoolean("sup_subway");
          paramCityInfo.mSup_lukuang = paramString.optBoolean("sup_lukuang");
          paramString = paramString.optJSONObject("current_city");
          if (paramString != null) {
            paramCityInfo.mCityGeo = CoordinateUtil.geoStringToPoint(paramString.optString("geo"));
          }
          return true;
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  public static boolean parseStringToCityListResult(String paramString, CityListResult paramCityListResult)
  {
    if (paramString != null) {
      try
      {
        if (!paramString.equals(""))
        {
          if (paramCityListResult == null) {
            return false;
          }
          paramString = new JSONObject(paramString);
          paramCityListResult.mResultType = paramString.optInt("result_type");
          paramCityListResult.setCityCount(paramString.optInt("count"));
          paramCityListResult.mCurrent_null = paramString.optBoolean("current_null");
          Object localObject1 = paramString.optJSONObject("current_city");
          Object localObject2 = new CityInfo();
          ((CityInfo)localObject2).mCityType = ((JSONObject)localObject1).optInt("type");
          ((CityInfo)localObject2).mCityCode = ((JSONObject)localObject1).optInt("code");
          ((CityInfo)localObject2).mCityName = ((JSONObject)localObject1).optString("name");
          ((CityInfo)localObject2).mLevel = ((JSONObject)localObject1).optInt("level");
          ((CityInfo)localObject2).mCityUid = ((JSONObject)localObject1).optString("uid");
          ((CityInfo)localObject2).mSup_bus = ((JSONObject)localObject1).optBoolean("sup_bus");
          ((CityInfo)localObject2).mSup_lukuang = ((JSONObject)localObject1).optBoolean("sup_lukuang");
          ((CityInfo)localObject2).mSup_subway = ((JSONObject)localObject1).optBoolean("sup_subway");
          ((CityInfo)localObject2).mCityGeo = CoordinateUtil.geoStringToPoint(((JSONObject)localObject1).optString("geo"));
          paramCityListResult.setCityinfo((CityInfo)localObject2);
          paramString = paramString.optJSONArray("citys");
          if (paramString != null)
          {
            localObject1 = new ArrayList();
            int i = 0;
            while (i < paramString.length())
            {
              localObject2 = paramString.optJSONObject(i);
              paramCityListResult.getClass();
              CityListResult.Citys localCitys = new CityListResult.Citys(paramCityListResult);
              localCitys.mCode = ((JSONObject)localObject2).optInt("code");
              localCitys.mNum = ((JSONObject)localObject2).optInt("num");
              localCitys.mName = ((JSONObject)localObject2).optString("name");
              ((ArrayList)localObject1).add(localCitys);
              i += 1;
            }
            paramCityListResult.setCitys((ArrayList)localObject1);
          }
          return true;
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  /* Error */
  public static boolean parseStringToPoiDetailResult(String paramString, PoiDetailInfo paramPoiDetailInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +1596 -> 1597
    //   4: aload_0
    //   5: ldc -18
    //   7: invokevirtual 248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifne +1587 -> 1597
    //   13: aload_1
    //   14: ifnonnull +6 -> 20
    //   17: goto +1580 -> 1597
    //   20: new 250	org/json/JSONObject
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 253	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: astore_0
    //   29: aload_0
    //   30: ldc_w 397
    //   33: invokevirtual 288	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   36: astore_3
    //   37: aload_1
    //   38: aload_0
    //   39: ldc -1
    //   41: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   44: putfield 400	com/baidu/platform/comapi/search/PoiDetailInfo:mResultType	I
    //   47: aload_1
    //   48: new 144	com/baidu/platform/comapi/basestruct/Point
    //   51: dup
    //   52: dconst_0
    //   53: dconst_0
    //   54: invokespecial 147	com/baidu/platform/comapi/basestruct/Point:<init>	(DD)V
    //   57: putfield 402	com/baidu/platform/comapi/search/PoiDetailInfo:geo	Lcom/baidu/platform/comapi/basestruct/Point;
    //   60: aload_3
    //   61: ldc_w 322
    //   64: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokestatic 328	com/baidu/platform/comapi/location/CoordinateUtil:geoStringToPoint	(Ljava/lang/String;)Lcom/baidu/platform/comapi/basestruct/Point;
    //   70: astore 4
    //   72: aload_1
    //   73: getfield 402	com/baidu/platform/comapi/search/PoiDetailInfo:geo	Lcom/baidu/platform/comapi/basestruct/Point;
    //   76: aload 4
    //   78: invokevirtual 405	com/baidu/platform/comapi/basestruct/Point:getDoubleX	()D
    //   81: aload 4
    //   83: invokevirtual 408	com/baidu/platform/comapi/basestruct/Point:getDoubleY	()D
    //   86: invokevirtual 411	com/baidu/platform/comapi/basestruct/Point:setTo	(DD)V
    //   89: aload_3
    //   90: ldc_w 413
    //   93: invokevirtual 416	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   96: ifeq +37 -> 133
    //   99: aload_3
    //   100: ldc_w 413
    //   103: invokevirtual 419	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   106: astore 4
    //   108: aload_1
    //   109: getfield 402	com/baidu/platform/comapi/search/PoiDetailInfo:geo	Lcom/baidu/platform/comapi/basestruct/Point;
    //   112: aload 4
    //   114: ldc_w 421
    //   117: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   120: i2d
    //   121: aload 4
    //   123: ldc_w 423
    //   126: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   129: i2d
    //   130: invokevirtual 411	com/baidu/platform/comapi/basestruct/Point:setTo	(DD)V
    //   133: aload_1
    //   134: aload_3
    //   135: ldc_w 275
    //   138: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   141: putfield 424	com/baidu/platform/comapi/search/PoiDetailInfo:name	Ljava/lang/String;
    //   144: aload_1
    //   145: aload_3
    //   146: ldc_w 266
    //   149: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   152: putfield 426	com/baidu/platform/comapi/search/PoiDetailInfo:type	I
    //   155: aload_1
    //   156: aload_3
    //   157: ldc_w 297
    //   160: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: putfield 427	com/baidu/platform/comapi/search/PoiDetailInfo:uid	Ljava/lang/String;
    //   166: aload_1
    //   167: aload_3
    //   168: ldc_w 428
    //   171: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: putfield 429	com/baidu/platform/comapi/search/PoiDetailInfo:addr	Ljava/lang/String;
    //   177: aload_1
    //   178: aload_3
    //   179: ldc_w 431
    //   182: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 433	com/baidu/platform/comapi/search/PoiDetailInfo:tel	Ljava/lang/String;
    //   188: aload_1
    //   189: aload_3
    //   190: ldc_w 435
    //   193: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: putfield 437	com/baidu/platform/comapi/search/PoiDetailInfo:zip	Ljava/lang/String;
    //   199: aload_1
    //   200: aload_3
    //   201: ldc_w 439
    //   204: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   207: putfield 442	com/baidu/platform/comapi/search/PoiDetailInfo:cityId	I
    //   210: aload_1
    //   211: aload_3
    //   212: ldc_w 443
    //   215: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   218: i2l
    //   219: putfield 446	com/baidu/platform/comapi/search/PoiDetailInfo:distance	J
    //   222: aload_1
    //   223: aload_0
    //   224: ldc_w 447
    //   227: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   230: putfield 448	com/baidu/platform/comapi/search/PoiDetailInfo:pano	I
    //   233: aload_1
    //   234: aload_0
    //   235: ldc_w 450
    //   238: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 452	com/baidu/platform/comapi/search/PoiDetailInfo:indoor_pano	Ljava/lang/String;
    //   244: aload_3
    //   245: ldc_w 454
    //   248: invokevirtual 359	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   251: astore_3
    //   252: aload_3
    //   253: ifnull +128 -> 381
    //   256: new 157	java/util/ArrayList
    //   259: dup
    //   260: invokespecial 360	java/util/ArrayList:<init>	()V
    //   263: astore 4
    //   265: iconst_0
    //   266: istore_2
    //   267: iload_2
    //   268: aload_3
    //   269: invokevirtual 365	org/json/JSONArray:length	()I
    //   272: if_icmpge +103 -> 375
    //   275: aload_3
    //   276: iload_2
    //   277: invokevirtual 368	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   280: astore 6
    //   282: aload_1
    //   283: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   286: pop
    //   287: new 456	com/baidu/platform/comapi/search/PoiDetailInfo$BusLine
    //   290: dup
    //   291: aload_1
    //   292: invokespecial 459	com/baidu/platform/comapi/search/PoiDetailInfo$BusLine:<init>	(Lcom/baidu/platform/comapi/search/PoiDetailInfo;)V
    //   295: astore 5
    //   297: aload 5
    //   299: aload 6
    //   301: ldc_w 460
    //   304: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   307: putfield 461	com/baidu/platform/comapi/search/PoiDetailInfo$BusLine:addr	Ljava/lang/String;
    //   310: aload 5
    //   312: aload 6
    //   314: ldc_w 275
    //   317: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   320: putfield 462	com/baidu/platform/comapi/search/PoiDetailInfo$BusLine:name	Ljava/lang/String;
    //   323: aload 5
    //   325: aload 6
    //   327: ldc_w 297
    //   330: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   333: putfield 463	com/baidu/platform/comapi/search/PoiDetailInfo$BusLine:uid	Ljava/lang/String;
    //   336: aload 6
    //   338: ldc_w 465
    //   341: invokevirtual 288	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   344: astore 6
    //   346: aload 6
    //   348: ifnull +12 -> 360
    //   351: aload 6
    //   353: ldc_w 467
    //   356: invokevirtual 288	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   359: pop
    //   360: aload 4
    //   362: aload 5
    //   364: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   367: pop
    //   368: iload_2
    //   369: iconst_1
    //   370: iadd
    //   371: istore_2
    //   372: goto -105 -> 267
    //   375: aload_1
    //   376: aload 4
    //   378: invokevirtual 470	com/baidu/platform/comapi/search/PoiDetailInfo:setArrayBuslines	(Ljava/util/ArrayList;)V
    //   381: aload_0
    //   382: ldc_w 472
    //   385: invokevirtual 288	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   388: astore_3
    //   389: aload_3
    //   390: ifnull +1194 -> 1584
    //   393: aload_1
    //   394: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   397: pop
    //   398: new 474	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail
    //   401: dup
    //   402: aload_1
    //   403: invokespecial 475	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:<init>	(Lcom/baidu/platform/comapi/search/PoiDetailInfo;)V
    //   406: astore_0
    //   407: aload_0
    //   408: aload_3
    //   409: ldc_w 266
    //   412: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   415: putfield 476	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:type	I
    //   418: aload_3
    //   419: ldc_w 478
    //   422: invokevirtual 359	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   425: astore 4
    //   427: aload 4
    //   429: ifnull +93 -> 522
    //   432: new 157	java/util/ArrayList
    //   435: dup
    //   436: invokespecial 360	java/util/ArrayList:<init>	()V
    //   439: astore 5
    //   441: iconst_0
    //   442: istore_2
    //   443: iload_2
    //   444: aload 4
    //   446: invokevirtual 365	org/json/JSONArray:length	()I
    //   449: if_icmpge +67 -> 516
    //   452: aload_1
    //   453: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   456: pop
    //   457: new 480	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo
    //   460: dup
    //   461: aload_1
    //   462: invokespecial 481	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:<init>	(Lcom/baidu/platform/comapi/search/PoiDetailInfo;)V
    //   465: astore 6
    //   467: aload 4
    //   469: iload_2
    //   470: invokevirtual 368	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   473: astore 7
    //   475: aload 6
    //   477: aload 7
    //   479: ldc_w 483
    //   482: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   485: putfield 485	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:title	Ljava/lang/String;
    //   488: aload 6
    //   490: aload 7
    //   492: ldc_w 487
    //   495: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   498: putfield 489	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:value	Ljava/lang/String;
    //   501: aload 5
    //   503: aload 6
    //   505: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   508: pop
    //   509: iload_2
    //   510: iconst_1
    //   511: iadd
    //   512: istore_2
    //   513: goto -70 -> 443
    //   516: aload_0
    //   517: aload 5
    //   519: putfield 493	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:detailInfos	Ljava/util/ArrayList;
    //   522: aload_3
    //   523: ldc_w 495
    //   526: invokevirtual 359	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   529: astore 4
    //   531: aload 4
    //   533: ifnull +93 -> 626
    //   536: new 157	java/util/ArrayList
    //   539: dup
    //   540: invokespecial 360	java/util/ArrayList:<init>	()V
    //   543: astore 5
    //   545: iconst_0
    //   546: istore_2
    //   547: iload_2
    //   548: aload 4
    //   550: invokevirtual 365	org/json/JSONArray:length	()I
    //   553: if_icmpge +67 -> 620
    //   556: aload_1
    //   557: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   560: pop
    //   561: new 480	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo
    //   564: dup
    //   565: aload_1
    //   566: invokespecial 481	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:<init>	(Lcom/baidu/platform/comapi/search/PoiDetailInfo;)V
    //   569: astore 6
    //   571: aload 4
    //   573: iload_2
    //   574: invokevirtual 368	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   577: astore 7
    //   579: aload 6
    //   581: aload 7
    //   583: ldc_w 483
    //   586: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: putfield 485	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:title	Ljava/lang/String;
    //   592: aload 6
    //   594: aload 7
    //   596: ldc_w 487
    //   599: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   602: putfield 489	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:value	Ljava/lang/String;
    //   605: aload 5
    //   607: aload 6
    //   609: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   612: pop
    //   613: iload_2
    //   614: iconst_1
    //   615: iadd
    //   616: istore_2
    //   617: goto -70 -> 547
    //   620: aload_0
    //   621: aload 5
    //   623: putfield 498	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:titleLinks	Ljava/util/ArrayList;
    //   626: aload_3
    //   627: ldc_w 500
    //   630: invokevirtual 359	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   633: astore 4
    //   635: aload 4
    //   637: ifnull +53 -> 690
    //   640: aload 4
    //   642: invokevirtual 365	org/json/JSONArray:length	()I
    //   645: ifle +45 -> 690
    //   648: aload_0
    //   649: aload 4
    //   651: invokevirtual 365	org/json/JSONArray:length	()I
    //   654: anewarray 244	java/lang/String
    //   657: putfield 504	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:picLinks	[Ljava/lang/String;
    //   660: iconst_0
    //   661: istore_2
    //   662: iload_2
    //   663: aload 4
    //   665: invokevirtual 365	org/json/JSONArray:length	()I
    //   668: if_icmpge +22 -> 690
    //   671: aload_0
    //   672: getfield 504	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:picLinks	[Ljava/lang/String;
    //   675: iload_2
    //   676: aload 4
    //   678: iload_2
    //   679: invokevirtual 507	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   682: aastore
    //   683: iload_2
    //   684: iconst_1
    //   685: iadd
    //   686: istore_2
    //   687: goto -25 -> 662
    //   690: aload_0
    //   691: aload_3
    //   692: ldc_w 509
    //   695: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   698: putfield 511	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:price	Ljava/lang/String;
    //   701: aload_3
    //   702: ldc_w 513
    //   705: invokevirtual 359	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   708: astore 4
    //   710: aload 4
    //   712: ifnull +93 -> 805
    //   715: new 157	java/util/ArrayList
    //   718: dup
    //   719: invokespecial 360	java/util/ArrayList:<init>	()V
    //   722: astore 5
    //   724: iconst_0
    //   725: istore_2
    //   726: iload_2
    //   727: aload 4
    //   729: invokevirtual 365	org/json/JSONArray:length	()I
    //   732: if_icmpge +67 -> 799
    //   735: aload_1
    //   736: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   739: pop
    //   740: new 480	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo
    //   743: dup
    //   744: aload_1
    //   745: invokespecial 481	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:<init>	(Lcom/baidu/platform/comapi/search/PoiDetailInfo;)V
    //   748: astore 6
    //   750: aload 4
    //   752: iload_2
    //   753: invokevirtual 368	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   756: astore 7
    //   758: aload 6
    //   760: aload 7
    //   762: ldc_w 483
    //   765: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   768: putfield 485	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:title	Ljava/lang/String;
    //   771: aload 6
    //   773: aload 7
    //   775: ldc_w 487
    //   778: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   781: putfield 489	com/baidu/platform/comapi/search/PoiDetailInfo$DetailInfo:value	Ljava/lang/String;
    //   784: aload 5
    //   786: aload 6
    //   788: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   791: pop
    //   792: iload_2
    //   793: iconst_1
    //   794: iadd
    //   795: istore_2
    //   796: goto -70 -> 726
    //   799: aload_0
    //   800: aload 5
    //   802: putfield 515	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:housearos	Ljava/util/ArrayList;
    //   805: aload_3
    //   806: ldc_w 517
    //   809: invokevirtual 359	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   812: astore 4
    //   814: aload 4
    //   816: ifnull +171 -> 987
    //   819: new 157	java/util/ArrayList
    //   822: dup
    //   823: invokespecial 360	java/util/ArrayList:<init>	()V
    //   826: astore 5
    //   828: iconst_0
    //   829: istore_2
    //   830: iload_2
    //   831: aload 4
    //   833: invokevirtual 365	org/json/JSONArray:length	()I
    //   836: if_icmpge +145 -> 981
    //   839: aload_1
    //   840: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   843: pop
    //   844: new 519	com/baidu/platform/comapi/search/PoiDetailInfo$Lines
    //   847: dup
    //   848: aload_1
    //   849: invokespecial 520	com/baidu/platform/comapi/search/PoiDetailInfo$Lines:<init>	(Lcom/baidu/platform/comapi/search/PoiDetailInfo;)V
    //   852: astore 6
    //   854: aload 4
    //   856: iload_2
    //   857: invokevirtual 368	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   860: astore 7
    //   862: aload 6
    //   864: aload 7
    //   866: ldc_w 522
    //   869: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   872: putfield 525	com/baidu/platform/comapi/search/PoiDetailInfo$Lines:firstTime	Ljava/lang/String;
    //   875: aload 6
    //   877: aload 7
    //   879: ldc_w 527
    //   882: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   885: putfield 530	com/baidu/platform/comapi/search/PoiDetailInfo$Lines:lastTime	Ljava/lang/String;
    //   888: aload 6
    //   890: aload 7
    //   892: ldc_w 275
    //   895: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   898: putfield 531	com/baidu/platform/comapi/search/PoiDetailInfo$Lines:name	Ljava/lang/String;
    //   901: aload 6
    //   903: aload 7
    //   905: ldc_w 533
    //   908: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   911: putfield 535	com/baidu/platform/comapi/search/PoiDetailInfo$Lines:terminal	Ljava/lang/String;
    //   914: aload 6
    //   916: aload 7
    //   918: ldc_w 297
    //   921: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   924: putfield 536	com/baidu/platform/comapi/search/PoiDetailInfo$Lines:uid	Ljava/lang/String;
    //   927: aload 6
    //   929: aload 7
    //   931: ldc_w 538
    //   934: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   937: putfield 540	com/baidu/platform/comapi/search/PoiDetailInfo$Lines:abb	Ljava/lang/String;
    //   940: aload 6
    //   942: aload 4
    //   944: iload_2
    //   945: invokevirtual 368	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   948: ldc_w 542
    //   951: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   954: ldc_w 544
    //   957: ldc_w 546
    //   960: invokevirtual 550	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   963: putfield 552	com/baidu/platform/comapi/search/PoiDetailInfo$Lines:clr	Ljava/lang/String;
    //   966: aload 5
    //   968: aload 6
    //   970: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   973: pop
    //   974: iload_2
    //   975: iconst_1
    //   976: iadd
    //   977: istore_2
    //   978: goto -148 -> 830
    //   981: aload_0
    //   982: aload 5
    //   984: putfield 554	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:lines	Ljava/util/ArrayList;
    //   987: aload_3
    //   988: ldc_w 556
    //   991: invokevirtual 359	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   994: astore 4
    //   996: aload 4
    //   998: ifnull +106 -> 1104
    //   1001: new 157	java/util/ArrayList
    //   1004: dup
    //   1005: invokespecial 360	java/util/ArrayList:<init>	()V
    //   1008: astore 5
    //   1010: iconst_0
    //   1011: istore_2
    //   1012: iload_2
    //   1013: aload 4
    //   1015: invokevirtual 365	org/json/JSONArray:length	()I
    //   1018: if_icmpge +80 -> 1098
    //   1021: aload_1
    //   1022: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1025: pop
    //   1026: new 558	com/baidu/platform/comapi/search/PoiDetailInfo$ArroundInfos
    //   1029: dup
    //   1030: aload_1
    //   1031: invokespecial 559	com/baidu/platform/comapi/search/PoiDetailInfo$ArroundInfos:<init>	(Lcom/baidu/platform/comapi/search/PoiDetailInfo;)V
    //   1034: astore 6
    //   1036: aload 4
    //   1038: iload_2
    //   1039: invokevirtual 368	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   1042: astore 7
    //   1044: aload 6
    //   1046: aload 7
    //   1048: ldc_w 561
    //   1051: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1054: putfield 564	com/baidu/platform/comapi/search/PoiDetailInfo$ArroundInfos:bsInfo	Ljava/lang/String;
    //   1057: aload 6
    //   1059: aload 7
    //   1061: ldc_w 566
    //   1064: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1067: putfield 569	com/baidu/platform/comapi/search/PoiDetailInfo$ArroundInfos:exitName	Ljava/lang/String;
    //   1070: aload 6
    //   1072: aload 7
    //   1074: ldc_w 571
    //   1077: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1080: putfield 574	com/baidu/platform/comapi/search/PoiDetailInfo$ArroundInfos:exitRound	Ljava/lang/String;
    //   1083: aload 5
    //   1085: aload 6
    //   1087: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1090: pop
    //   1091: iload_2
    //   1092: iconst_1
    //   1093: iadd
    //   1094: istore_2
    //   1095: goto -83 -> 1012
    //   1098: aload_0
    //   1099: aload 5
    //   1101: putfield 577	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:arroundInfos	Ljava/util/ArrayList;
    //   1104: aload_3
    //   1105: ldc_w 579
    //   1108: invokevirtual 288	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1111: astore 4
    //   1113: aload 4
    //   1115: ifnull +464 -> 1579
    //   1118: aload_0
    //   1119: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1122: ldc_w 585
    //   1125: aload_3
    //   1126: ldc_w 585
    //   1129: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1132: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1135: pop
    //   1136: aload_0
    //   1137: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1140: ldc_w 593
    //   1143: aload 4
    //   1145: ldc_w 593
    //   1148: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1151: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1154: pop
    //   1155: aload_0
    //   1156: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1159: ldc_w 595
    //   1162: aload 4
    //   1164: ldc_w 595
    //   1167: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1170: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1173: pop
    //   1174: aload_0
    //   1175: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1178: ldc_w 509
    //   1181: aload 4
    //   1183: ldc_w 509
    //   1186: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1189: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1192: pop
    //   1193: aload_0
    //   1194: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1197: ldc_w 596
    //   1200: aload 4
    //   1202: ldc_w 596
    //   1205: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1208: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1211: pop
    //   1212: aload_0
    //   1213: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1216: ldc_w 598
    //   1219: aload 4
    //   1221: ldc_w 598
    //   1224: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1227: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1230: pop
    //   1231: aload_0
    //   1232: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1235: ldc_w 600
    //   1238: aload 4
    //   1240: ldc_w 600
    //   1243: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1246: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1249: pop
    //   1250: aload_0
    //   1251: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1254: ldc_w 602
    //   1257: aload 4
    //   1259: ldc_w 602
    //   1262: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1265: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1268: pop
    //   1269: aload 4
    //   1271: ldc_w 604
    //   1274: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1277: ifnull +22 -> 1299
    //   1280: aload_0
    //   1281: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1284: ldc_w 604
    //   1287: aload 4
    //   1289: ldc_w 604
    //   1292: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1295: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1298: pop
    //   1299: aload 4
    //   1301: ldc_w 606
    //   1304: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1307: ifnull +22 -> 1329
    //   1310: aload_0
    //   1311: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1314: ldc_w 606
    //   1317: aload 4
    //   1319: ldc_w 606
    //   1322: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1325: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1328: pop
    //   1329: aload 4
    //   1331: ldc_w 608
    //   1334: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1337: ifnull +22 -> 1359
    //   1340: aload_0
    //   1341: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1344: ldc_w 608
    //   1347: aload 4
    //   1349: ldc_w 608
    //   1352: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1355: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1358: pop
    //   1359: aload 4
    //   1361: ldc_w 610
    //   1364: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1367: ifnull +22 -> 1389
    //   1370: aload_0
    //   1371: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1374: ldc_w 610
    //   1377: aload 4
    //   1379: ldc_w 610
    //   1382: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1385: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1388: pop
    //   1389: aload 4
    //   1391: ldc_w 612
    //   1394: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1397: ifnull +22 -> 1419
    //   1400: aload_0
    //   1401: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1404: ldc_w 612
    //   1407: aload 4
    //   1409: ldc_w 612
    //   1412: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1415: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1418: pop
    //   1419: aload 4
    //   1421: ldc_w 614
    //   1424: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1427: ifnull +22 -> 1449
    //   1430: aload_0
    //   1431: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1434: ldc_w 614
    //   1437: aload 4
    //   1439: ldc_w 614
    //   1442: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1445: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1448: pop
    //   1449: aload 4
    //   1451: ldc_w 616
    //   1454: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1457: ifnull +22 -> 1479
    //   1460: aload_0
    //   1461: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1464: ldc_w 616
    //   1467: aload 4
    //   1469: ldc_w 616
    //   1472: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1475: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1478: pop
    //   1479: aload 4
    //   1481: ldc_w 618
    //   1484: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1487: ifnull +22 -> 1509
    //   1490: aload_0
    //   1491: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1494: ldc_w 618
    //   1497: aload 4
    //   1499: ldc_w 618
    //   1502: invokevirtual 279	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1505: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1508: pop
    //   1509: aload 4
    //   1511: ldc_w 620
    //   1514: invokevirtual 359	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1517: astore_3
    //   1518: aload_3
    //   1519: ifnull +60 -> 1579
    //   1522: aload_3
    //   1523: invokevirtual 365	org/json/JSONArray:length	()I
    //   1526: ifle +53 -> 1579
    //   1529: new 157	java/util/ArrayList
    //   1532: dup
    //   1533: invokespecial 360	java/util/ArrayList:<init>	()V
    //   1536: astore 4
    //   1538: iconst_0
    //   1539: istore_2
    //   1540: iload_2
    //   1541: aload_3
    //   1542: invokevirtual 365	org/json/JSONArray:length	()I
    //   1545: if_icmpge +21 -> 1566
    //   1548: aload 4
    //   1550: aload_3
    //   1551: iload_2
    //   1552: invokevirtual 623	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1555: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1558: pop
    //   1559: iload_2
    //   1560: iconst_1
    //   1561: iadd
    //   1562: istore_2
    //   1563: goto -23 -> 1540
    //   1566: aload_0
    //   1567: getfield 583	com/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail:placeParam	Ljava/util/HashMap;
    //   1570: ldc_w 620
    //   1573: aload 4
    //   1575: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1578: pop
    //   1579: aload_1
    //   1580: aload_0
    //   1581: invokevirtual 627	com/baidu/platform/comapi/search/PoiDetailInfo:setDeepDetail	(Lcom/baidu/platform/comapi/search/PoiDetailInfo$DeepDetail;)V
    //   1584: iconst_1
    //   1585: ireturn
    //   1586: astore_0
    //   1587: iconst_0
    //   1588: ireturn
    //   1589: astore_0
    //   1590: iconst_0
    //   1591: ireturn
    //   1592: astore 7
    //   1594: goto -628 -> 966
    //   1597: iconst_0
    //   1598: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1599	0	paramString	String
    //   0	1599	1	paramPoiDetailInfo	PoiDetailInfo
    //   266	1297	2	i	int
    //   36	1515	3	localObject1	Object
    //   70	1504	4	localObject2	Object
    //   295	805	5	localObject3	Object
    //   280	806	6	localObject4	Object
    //   473	600	7	localJSONObject	JSONObject
    //   1592	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	13	1586	java/lang/RuntimeException
    //   20	133	1586	java/lang/RuntimeException
    //   133	252	1586	java/lang/RuntimeException
    //   256	265	1586	java/lang/RuntimeException
    //   267	346	1586	java/lang/RuntimeException
    //   351	360	1586	java/lang/RuntimeException
    //   360	368	1586	java/lang/RuntimeException
    //   375	381	1586	java/lang/RuntimeException
    //   381	389	1586	java/lang/RuntimeException
    //   393	427	1586	java/lang/RuntimeException
    //   432	441	1586	java/lang/RuntimeException
    //   443	509	1586	java/lang/RuntimeException
    //   516	522	1586	java/lang/RuntimeException
    //   522	531	1586	java/lang/RuntimeException
    //   536	545	1586	java/lang/RuntimeException
    //   547	613	1586	java/lang/RuntimeException
    //   620	626	1586	java/lang/RuntimeException
    //   626	635	1586	java/lang/RuntimeException
    //   640	660	1586	java/lang/RuntimeException
    //   662	683	1586	java/lang/RuntimeException
    //   690	710	1586	java/lang/RuntimeException
    //   715	724	1586	java/lang/RuntimeException
    //   726	792	1586	java/lang/RuntimeException
    //   799	805	1586	java/lang/RuntimeException
    //   805	814	1586	java/lang/RuntimeException
    //   819	828	1586	java/lang/RuntimeException
    //   830	940	1586	java/lang/RuntimeException
    //   940	966	1586	java/lang/RuntimeException
    //   966	974	1586	java/lang/RuntimeException
    //   981	987	1586	java/lang/RuntimeException
    //   987	996	1586	java/lang/RuntimeException
    //   1001	1010	1586	java/lang/RuntimeException
    //   1012	1091	1586	java/lang/RuntimeException
    //   1098	1104	1586	java/lang/RuntimeException
    //   1104	1113	1586	java/lang/RuntimeException
    //   1118	1299	1586	java/lang/RuntimeException
    //   1299	1329	1586	java/lang/RuntimeException
    //   1329	1359	1586	java/lang/RuntimeException
    //   1359	1389	1586	java/lang/RuntimeException
    //   1389	1419	1586	java/lang/RuntimeException
    //   1419	1449	1586	java/lang/RuntimeException
    //   1449	1479	1586	java/lang/RuntimeException
    //   1479	1509	1586	java/lang/RuntimeException
    //   1509	1518	1586	java/lang/RuntimeException
    //   1522	1538	1586	java/lang/RuntimeException
    //   1540	1559	1586	java/lang/RuntimeException
    //   1566	1579	1586	java/lang/RuntimeException
    //   1579	1584	1586	java/lang/RuntimeException
    //   4	13	1589	java/lang/Exception
    //   20	133	1589	java/lang/Exception
    //   133	252	1589	java/lang/Exception
    //   256	265	1589	java/lang/Exception
    //   267	346	1589	java/lang/Exception
    //   351	360	1589	java/lang/Exception
    //   360	368	1589	java/lang/Exception
    //   375	381	1589	java/lang/Exception
    //   381	389	1589	java/lang/Exception
    //   393	427	1589	java/lang/Exception
    //   432	441	1589	java/lang/Exception
    //   443	509	1589	java/lang/Exception
    //   516	522	1589	java/lang/Exception
    //   522	531	1589	java/lang/Exception
    //   536	545	1589	java/lang/Exception
    //   547	613	1589	java/lang/Exception
    //   620	626	1589	java/lang/Exception
    //   626	635	1589	java/lang/Exception
    //   640	660	1589	java/lang/Exception
    //   662	683	1589	java/lang/Exception
    //   690	710	1589	java/lang/Exception
    //   715	724	1589	java/lang/Exception
    //   726	792	1589	java/lang/Exception
    //   799	805	1589	java/lang/Exception
    //   805	814	1589	java/lang/Exception
    //   819	828	1589	java/lang/Exception
    //   830	940	1589	java/lang/Exception
    //   966	974	1589	java/lang/Exception
    //   981	987	1589	java/lang/Exception
    //   987	996	1589	java/lang/Exception
    //   1001	1010	1589	java/lang/Exception
    //   1012	1091	1589	java/lang/Exception
    //   1098	1104	1589	java/lang/Exception
    //   1104	1113	1589	java/lang/Exception
    //   1118	1299	1589	java/lang/Exception
    //   1299	1329	1589	java/lang/Exception
    //   1329	1359	1589	java/lang/Exception
    //   1359	1389	1589	java/lang/Exception
    //   1389	1419	1589	java/lang/Exception
    //   1419	1449	1589	java/lang/Exception
    //   1449	1479	1589	java/lang/Exception
    //   1479	1509	1589	java/lang/Exception
    //   1509	1518	1589	java/lang/Exception
    //   1522	1538	1589	java/lang/Exception
    //   1540	1559	1589	java/lang/Exception
    //   1566	1579	1589	java/lang/Exception
    //   1579	1584	1589	java/lang/Exception
    //   940	966	1592	java/lang/Exception
  }
  
  public static boolean parseStringToPoiPKGResult(String paramString, PoiBKGResult paramPoiBKGResult)
  {
    if (paramString != null) {}
    for (;;)
    {
      int j;
      try
      {
        if ((!paramString.equals("")) && (paramPoiBKGResult != null))
        {
          paramString = new JSONObject(paramString);
          paramPoiBKGResult.mResultType = paramString.optInt("result_type");
          paramPoiBKGResult.mCount = paramString.optInt("count");
          paramPoiBKGResult.mError = paramString.optInt("error");
          paramPoiBKGResult.mKeyWord = paramString.optString("keyword");
          paramString = paramString.optJSONArray("dataelem");
          if ((paramString != null) && (paramString.length() > 0))
          {
            paramPoiBKGResult.mBlockList = new ArrayList();
            int i = 0;
            if (i < paramString.length())
            {
              Object localObject = paramString.optJSONObject(i);
              if (localObject != null)
              {
                paramPoiBKGResult.getClass();
                PoiBKGResult.PoiBKGBlock localPoiBKGBlock = new PoiBKGResult.PoiBKGBlock(paramPoiBKGResult);
                localPoiBKGBlock.mLevel = ((JSONObject)localObject).optInt("level");
                localPoiBKGBlock.mIndexX = ((JSONObject)localObject).optInt("indexX");
                localPoiBKGBlock.mIndexY = ((JSONObject)localObject).optInt("indexY");
                localObject = ((JSONObject)localObject).optJSONArray("data");
                if ((localObject != null) && (((JSONArray)localObject).length() > 0))
                {
                  localPoiBKGBlock.mItemList = new ArrayList();
                  j = 0;
                  if (j < ((JSONArray)localObject).length())
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(j);
                    if (localJSONObject == null) {
                      break label637;
                    }
                    localPoiBKGBlock.getClass();
                    PoiBKGResult.PoiBKGBlock.PoiBKGItem localPoiBKGItem = new PoiBKGResult.PoiBKGBlock.PoiBKGItem(localPoiBKGBlock);
                    localPoiBKGItem.mLocation = new com.baidu.platform.comapi.basestruct.Point(localJSONObject.optInt("x"), localJSONObject.optInt("y"));
                    localPoiBKGItem.mName = localJSONObject.optString("name");
                    localPoiBKGItem.mUid = localJSONObject.optString("uid");
                    localPoiBKGItem.mTel = localJSONObject.optString("tel");
                    localPoiBKGItem.mAddr = localJSONObject.optString("addr");
                    localPoiBKGItem.indoor_pano = localJSONObject.optString("indoor_pano");
                    localPoiBKGItem.pano = localJSONObject.optInt("pano");
                    localJSONObject = localJSONObject.optJSONObject("place");
                    if (localJSONObject != null)
                    {
                      localPoiBKGItem.placeParam.put("src_name", localJSONObject.optString("src_name"));
                      localPoiBKGItem.placeParam.put("overall_rating", localJSONObject.optString("overall_rating"));
                      localPoiBKGItem.placeParam.put("image", localJSONObject.optString("image"));
                      localPoiBKGItem.placeParam.put("price", localJSONObject.optString("price"));
                      localPoiBKGItem.placeParam.put("tag", localJSONObject.optString("tag"));
                      localPoiBKGItem.placeParam.put("premium_flag", localJSONObject.optString("premium_flag"));
                      localPoiBKGItem.placeParam.put("comment_num", localJSONObject.optString("comment_num"));
                      localPoiBKGItem.placeParam.put("groupon_flag", localJSONObject.optString("groupon_flag"));
                      if (localJSONObject.optString("wap_bookable") != null) {
                        localPoiBKGItem.placeParam.put("wap_bookable", localJSONObject.optString("wap_bookable"));
                      }
                      if (localJSONObject.optString("wise_fullroom") != null) {
                        localPoiBKGItem.placeParam.put("wise_fullroom", localJSONObject.optString("wise_fullroom"));
                      }
                    }
                    localPoiBKGBlock.mItemList.add(localPoiBKGItem);
                    break label637;
                  }
                }
                paramPoiBKGResult.mBlockList.add(localPoiBKGBlock);
              }
              i += 1;
              continue;
            }
          }
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      return false;
      label637:
      j += 1;
    }
  }
  
  public static boolean parseStringToPoiRGCDetailResult(String paramString, PoiRGCDetailResult paramPoiRGCDetailResult)
  {
    if (paramString != null) {
      try
      {
        if (!paramString.equals(""))
        {
          if (paramPoiRGCDetailResult == null) {
            return false;
          }
          paramString = new JSONObject(paramString);
          paramPoiRGCDetailResult.mResultType = paramString.optInt("result_type");
          paramPoiRGCDetailResult.mName = paramString.optString("name");
          paramPoiRGCDetailResult.mAddress = paramString.optString("address");
          paramPoiRGCDetailResult.mLocation = new com.baidu.platform.comapi.basestruct.Point(paramString.optInt("x"), paramString.optInt("y"));
          return true;
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  public static boolean parseStringToRTBusResult(String paramString, RTBusResult paramRTBusResult)
  {
    if (paramString != null) {
      try
      {
        if ((!paramString.equals("")) && (paramRTBusResult != null))
        {
          paramString = new JSONObject(paramString);
          Object localObject1 = paramString.optJSONObject("result");
          if (localObject1 != null)
          {
            paramRTBusResult.getClass();
            paramRTBusResult.result = new RTBusResult.Result(paramRTBusResult);
            paramRTBusResult.result.error = ((JSONObject)localObject1).optInt("error");
            paramRTBusResult.result.has_rtbus = ((JSONObject)localObject1).optInt("has_rtbus");
          }
          paramString = paramString.optJSONObject("content");
          if (paramString != null)
          {
            paramRTBusResult.getClass();
            paramRTBusResult.content = new RTBusResult.Content(paramRTBusResult);
            paramRTBusResult.content.rtbus_nu = paramString.optInt("rtbus_nu");
            paramRTBusResult.content.rtbus_update_time = paramString.optInt("rtbus_update_time");
            paramRTBusResult.content.rtbusVersion = paramString.optInt("rtbus_version");
            paramString = paramString.optJSONArray("stations");
            paramRTBusResult.content.stations = new ArrayList();
            if (paramString != null)
            {
              int i = 0;
              while (i < paramString.length())
              {
                Object localObject2 = paramString.optJSONObject(i);
                if (localObject2 != null)
                {
                  paramRTBusResult.getClass();
                  localObject1 = new RTBusResult.Station(paramRTBusResult);
                  ((RTBusResult.Station)localObject1).name = ((JSONObject)localObject2).optString("name");
                  ((RTBusResult.Station)localObject1).tip_rtbus = ((JSONObject)localObject2).optString("tip_rtbus");
                  ((RTBusResult.Station)localObject1).uid = ((JSONObject)localObject2).optString("uid");
                  ((RTBusResult.Station)localObject1).imageTipRtbus = ((JSONObject)localObject2).optString("image_tip_rtbus", "");
                  localObject1.getClass();
                  Object localObject3 = new RTBusResult.Station.Line((RTBusResult.Station)localObject1);
                  JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject("line");
                  if (localJSONObject != null)
                  {
                    ((RTBusResult.Station.Line)localObject3).name = localJSONObject.optString("name");
                    ((RTBusResult.Station.Line)localObject3).uid = localJSONObject.optString("uid");
                    ((RTBusResult.Station.Line)localObject3).rawName = localJSONObject.optString("raw_name");
                    ((RTBusResult.Station)localObject1).line = ((RTBusResult.Station.Line)localObject3);
                  }
                  localObject1.getClass();
                  localObject3 = new RTBusResult.Station.NextBusInfo((RTBusResult.Station)localObject1);
                  localObject2 = ((JSONObject)localObject2).optJSONObject("next_bus_info");
                  if (localObject2 != null)
                  {
                    ((RTBusResult.Station.NextBusInfo)localObject3).remain_dist = ((JSONObject)localObject2).optInt("remain_dist");
                    ((RTBusResult.Station.NextBusInfo)localObject3).remain_stops = ((JSONObject)localObject2).optInt("remain_stops");
                    ((RTBusResult.Station.NextBusInfo)localObject3).remain_time = ((JSONObject)localObject2).optInt("remain_time");
                    ((RTBusResult.Station.NextBusInfo)localObject3).x = ((JSONObject)localObject2).optInt("x");
                    ((RTBusResult.Station.NextBusInfo)localObject3).y = ((JSONObject)localObject2).optInt("y");
                    ((RTBusResult.Station.NextBusInfo)localObject3).spath = new ArrayList();
                    localObject2 = ((JSONObject)localObject2).optJSONArray("spath");
                    int j = 0;
                    while (j < ((JSONArray)localObject2).length())
                    {
                      int k = ((JSONArray)localObject2).optInt(j);
                      ((RTBusResult.Station.NextBusInfo)localObject3).spath.add(Integer.valueOf(k));
                      j += 1;
                    }
                    ((RTBusResult.Station)localObject1).nextBusInfo = ((RTBusResult.Station.NextBusInfo)localObject3);
                  }
                  paramRTBusResult.content.stations.add(localObject1);
                }
                i += 1;
              }
            }
          }
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
    }
    return false;
  }
  
  public static boolean parseStringToShareUrlResult(String paramString, ShareUrlResult paramShareUrlResult)
  {
    if (paramString != null) {
      try
      {
        if (!paramString.equals(""))
        {
          if (paramShareUrlResult == null) {
            return false;
          }
          paramString = new JSONObject(paramString);
          paramShareUrlResult.mResultType = paramString.optInt("result_type");
          paramShareUrlResult.mUrl = paramString.optString("url");
          return true;
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  public static boolean parseStringToSuggestionResult(String paramString, SugResult paramSugResult)
  {
    if (paramString != null) {
      try
      {
        if (!paramString.equals(""))
        {
          if (paramSugResult == null) {
            return false;
          }
          Object localObject = new JSONObject(paramString);
          paramSugResult.mResultType = ((JSONObject)localObject).optInt("result_type");
          paramSugResult.keyword = ((JSONObject)localObject).optString("keyword");
          paramSugResult.ispinyin = ((JSONObject)localObject).optBoolean("ispinyin", false);
          paramSugResult.type = ((JSONObject)localObject).optInt("type");
          paramString = ((JSONObject)localObject).optJSONArray("poiname");
          JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("subtitle");
          localObject = ((JSONObject)localObject).optJSONArray("cityid");
          if ((paramString != null) && (paramString.length() > 0))
          {
            int j = paramString.length();
            String[] arrayOfString1 = new String[j];
            String[] arrayOfString2 = new String[j];
            String[] arrayOfString3 = new String[j];
            int i = 0;
            while (i < j)
            {
              arrayOfString1[i] = paramString.optString(i);
              if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
                arrayOfString2[i] = localJSONArray.optString(i);
              }
              arrayOfString3[i] = ((JSONArray)localObject).optString(i);
              i += 1;
            }
            paramSugResult.setPoiname(arrayOfString1);
            paramSugResult.setSubtitle(arrayOfString2);
            paramSugResult.setCityid(arrayOfString3);
          }
          return true;
        }
      }
      catch (JSONException paramString) {}
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comapi/search/ResultHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */