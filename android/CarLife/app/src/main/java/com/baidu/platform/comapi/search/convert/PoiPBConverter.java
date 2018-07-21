package com.baidu.platform.comapi.search.convert;

import android.text.TextUtils;
import com.baidu.entity.pb.CityResult;
import com.baidu.entity.pb.CityResult.Content;
import com.baidu.entity.pb.CityResult.PreviousCity;
import com.baidu.entity.pb.CurrentCity;
import com.baidu.entity.pb.Inf;
import com.baidu.entity.pb.Inf.Content;
import com.baidu.entity.pb.Inf.Content.Blinfo;
import com.baidu.entity.pb.Inf.Content.Blinfo.RtInfo;
import com.baidu.entity.pb.Inf.Content.Ext;
import com.baidu.entity.pb.Inf.Content.Ext.DetailInfo;
import com.baidu.entity.pb.Inf.Content.Ext.DetailInfo.Meishipaihao;
import com.baidu.entity.pb.Inf.Content.Ext.DetailInfo.Meishipaihao.Main;
import com.baidu.entity.pb.Inf.Content.Ext.LineInfo;
import com.baidu.entity.pb.Inf.Content.HeadIcon;
import com.baidu.entity.pb.Inf.Content.HeatMap;
import com.baidu.entity.pb.Inf.Content.HeatMap.Points;
import com.baidu.entity.pb.Inf.Content.HeatMap.Points.GeoElements;
import com.baidu.entity.pb.Inf.Content.OtherStations;
import com.baidu.entity.pb.Inf.Option;
import com.baidu.entity.pb.SusvrResponse;
import com.baidu.entity.pb.SusvrResponse.PoiElement;
import com.baidu.entity.pb.TrafficCitys;
import com.baidu.entity.pb.TrafficCitys.Contents;
import com.baidu.entity.pb.TrafficCitys.Contents.Pois;
import com.baidu.entity.pb.TrafficCitys.SuggestQuery;
import com.baidu.entity.pb.TrafficPois;
import com.baidu.entity.pb.TrafficPois.Content;
import com.baidu.entity.pb.TrafficPois.Content.End;
import com.baidu.entity.pb.TrafficPois.Content.Start;
import com.baidu.entity.pb.TrafficPois.Content.WayPoints;
import com.baidu.entity.pb.TrafficPois.ImageShow;
import com.baidu.entity.pb.TrafficPois.Option;
import com.baidu.entity.pb.TrafficPois.Option.EndCity;
import com.baidu.entity.pb.TrafficPois.Option.StartCity;
import com.baidu.entity.pb.TrafficPois.SuggestQuery;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.search.AddrListResult;
import com.baidu.platform.comapi.search.AddrListResult.Citys;
import com.baidu.platform.comapi.search.AddrListResult.Points;
import com.baidu.platform.comapi.search.CityInfo;
import com.baidu.platform.comapi.search.CityListResult;
import com.baidu.platform.comapi.search.CityListResult.Citys;
import com.baidu.platform.comapi.search.CityListResult.Pois;
import com.baidu.platform.comapi.search.PoiDetailInfo;
import com.baidu.platform.comapi.search.PoiDetailInfo.BusLine;
import com.baidu.platform.comapi.search.PoiDetailInfo.CaterQueueInfo;
import com.baidu.platform.comapi.search.PoiDetailInfo.DeepDetail;
import com.baidu.platform.comapi.search.PoiDetailInfo.HeadIcon;
import com.baidu.platform.comapi.search.PoiDetailInfo.HeatMap;
import com.baidu.platform.comapi.search.PoiDetailInfo.Lines;
import com.baidu.platform.comapi.search.SugResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PoiPBConverter
{
  public static AddrListResult convertAddressListResult(TrafficPois paramTrafficPois)
  {
    AddrListResult localAddrListResult = new AddrListResult();
    localAddrListResult.mResultType = 23;
    if (paramTrafficPois.hasOption())
    {
      int i;
      if (paramTrafficPois.getOption().getCityListCount() > 1)
      {
        localAddrListResult.mHaveStCitylist = PBConvertUtil.stringToBool(paramTrafficPois.getOption().getCityList(0));
        localAddrListResult.mHaveEnCityList = PBConvertUtil.stringToBool(paramTrafficPois.getOption().getCityList(paramTrafficPois.getOption().getCityListCount() - 1));
        if (paramTrafficPois.getOption().getCityListCount() > 2)
        {
          i = 1;
          while (i < paramTrafficPois.getOption().getCityListCount() - 1)
          {
            if (PBConvertUtil.stringToBool(paramTrafficPois.getOption().getCityList(i))) {
              localAddrListResult.mHaveThroughCityList = true;
            }
            i += 1;
          }
        }
      }
      if (paramTrafficPois.hasImgeShow())
      {
        if (paramTrafficPois.getImgeShow().hasImageExt()) {
          localAddrListResult.mImgExt = paramTrafficPois.getImgeShow().getImageExt();
        }
        if (paramTrafficPois.getImgeShow().hasResBound()) {
          localAddrListResult.mResBound = paramTrafficPois.getImgeShow().getResBound();
        }
      }
      if (paramTrafficPois.getOption().getPrioFlagCount() > 1)
      {
        localAddrListResult.mHaveStPrio = PBConvertUtil.stringToBool(paramTrafficPois.getOption().getPrioFlag(0));
        localAddrListResult.mHaveEnPrio = PBConvertUtil.stringToBool(paramTrafficPois.getOption().getPrioFlag(paramTrafficPois.getOption().getPrioFlagCount() - 1));
        if (paramTrafficPois.getOption().getPrioFlagCount() > 2)
        {
          i = 1;
          while (i < paramTrafficPois.getOption().getPrioFlagCount() - 1)
          {
            if (PBConvertUtil.stringToBool(paramTrafficPois.getOption().getPrioFlag(i))) {
              localAddrListResult.mHaveThroughPrio = true;
            }
            i += 1;
          }
        }
      }
      localAddrListResult.mStKeyword = paramTrafficPois.getOption().getSWd();
      if (paramTrafficPois.getOption().getEWdCount() > 0) {
        localAddrListResult.mEnKeyWord = paramTrafficPois.getOption().getEWd(paramTrafficPois.getOption().getEWdCount() - 1);
      }
      if (paramTrafficPois.getOption().getEWdCount() > 1) {
        localAddrListResult.mThroughKeyword = paramTrafficPois.getOption().getEWd(0);
      }
      localAddrListResult.mIfNav = paramTrafficPois.getOption().getIfNav();
      if (paramTrafficPois.getOption().hasStartCity())
      {
        localAddrListResult.mStCityname = paramTrafficPois.getOption().getStartCity().getCname();
        localAddrListResult.mStCityCode = paramTrafficPois.getOption().getStartCity().getCode();
      }
      if (paramTrafficPois.getOption().getEndCityCount() > 0)
      {
        localAddrListResult.mEnCityname = paramTrafficPois.getOption().getEndCity(paramTrafficPois.getOption().getEndCityCount() - 1).getCname();
        localAddrListResult.mEnCityCode = paramTrafficPois.getOption().getEndCity(paramTrafficPois.getOption().getEndCityCount() - 1).getCode();
      }
      if (paramTrafficPois.getOption().getEndCityCount() > 1)
      {
        localAddrListResult.mThroughCityName = paramTrafficPois.getOption().getEndCity(0).getCname();
        localAddrListResult.mThroughCityCode = Integer.valueOf(paramTrafficPois.getOption().getEndCity(0).getCode());
      }
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    ArrayList localArrayList7 = new ArrayList();
    Iterator localIterator;
    if (paramTrafficPois.hasContent())
    {
      localAddrListResult.mStCount = paramTrafficPois.getContent().getStartCount();
      localAddrListResult.mEnCount = paramTrafficPois.getContent().getEndCount();
      localAddrListResult.mThroughCount = paramTrafficPois.getContent().getWayPointsCount();
      Object localObject1;
      Object localObject2;
      if (localAddrListResult.mHaveStCitylist)
      {
        localIterator = paramTrafficPois.getContent().getStartList().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (TrafficPois.Content.Start)localIterator.next();
          localAddrListResult.getClass();
          localObject2 = new AddrListResult.Citys(localAddrListResult);
          ((AddrListResult.Citys)localObject2).code = ((TrafficPois.Content.Start)localObject1).getCode();
          ((AddrListResult.Citys)localObject2).name = ((TrafficPois.Content.Start)localObject1).getName();
          ((AddrListResult.Citys)localObject2).num = ((TrafficPois.Content.Start)localObject1).getNum();
          localArrayList1.add(localObject2);
        }
      }
      localIterator = paramTrafficPois.getContent().getStartList().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (TrafficPois.Content.Start)localIterator.next();
        localAddrListResult.getClass();
        localObject2 = new AddrListResult.Points(localAddrListResult);
        ((AddrListResult.Points)localObject2).addr = ((TrafficPois.Content.Start)localObject1).getAddr();
        ((AddrListResult.Points)localObject2).name = ((TrafficPois.Content.Start)localObject1).getName();
        ((AddrListResult.Points)localObject2).pt = PBConvertUtil.decryptPoint(((TrafficPois.Content.Start)localObject1).getGeo());
        ((AddrListResult.Points)localObject2).uid = ((TrafficPois.Content.Start)localObject1).getUid();
        ((AddrListResult.Points)localObject2).floor = ((TrafficPois.Content.Start)localObject1).getIndoorFloor();
        ((AddrListResult.Points)localObject2).buidingId = ((TrafficPois.Content.Start)localObject1).getIndoorParentUid();
        ((AddrListResult.Points)localObject2).describe = ((TrafficPois.Content.Start)localObject1).getDescribe();
        localArrayList4.add(localObject2);
      }
      if (localArrayList4.size() == 1) {
        localAddrListResult.mHaveStCitylist = true;
      }
      if (localAddrListResult.mHaveThroughCityList)
      {
        localIterator = paramTrafficPois.getContent().getWayPointsList().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (TrafficPois.Content.WayPoints)localIterator.next();
          localAddrListResult.getClass();
          localObject2 = new AddrListResult.Citys(localAddrListResult);
          ((AddrListResult.Citys)localObject2).code = ((TrafficPois.Content.WayPoints)localObject1).getCode();
          ((AddrListResult.Citys)localObject2).name = ((TrafficPois.Content.WayPoints)localObject1).getName();
          ((AddrListResult.Citys)localObject2).num = ((TrafficPois.Content.WayPoints)localObject1).getNum();
          localArrayList3.add(localObject2);
        }
      }
      localIterator = paramTrafficPois.getContent().getWayPointsList().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (TrafficPois.Content.WayPoints)localIterator.next();
        localAddrListResult.getClass();
        localObject2 = new AddrListResult.Points(localAddrListResult);
        ((AddrListResult.Points)localObject2).addr = ((TrafficPois.Content.WayPoints)localObject1).getAddr();
        ((AddrListResult.Points)localObject2).name = ((TrafficPois.Content.WayPoints)localObject1).getName();
        ((AddrListResult.Points)localObject2).pt = PBConvertUtil.decryptPoint(((TrafficPois.Content.WayPoints)localObject1).getGeo());
        ((AddrListResult.Points)localObject2).uid = ((TrafficPois.Content.WayPoints)localObject1).getUid();
        ((AddrListResult.Points)localObject2).floor = ((TrafficPois.Content.WayPoints)localObject1).getIndoorFloor();
        ((AddrListResult.Points)localObject2).buidingId = ((TrafficPois.Content.WayPoints)localObject1).getIndoorParentUid();
        ((AddrListResult.Points)localObject2).dist = ((TrafficPois.Content.WayPoints)localObject1).getDist();
        ((AddrListResult.Points)localObject2).direction = ((TrafficPois.Content.WayPoints)localObject1).getDirection();
        ((AddrListResult.Points)localObject2).hasDist = ((TrafficPois.Content.WayPoints)localObject1).hasDist();
        ((AddrListResult.Points)localObject2).hasDirect = ((TrafficPois.Content.WayPoints)localObject1).hasDirection();
        ((AddrListResult.Points)localObject2).describe = ((TrafficPois.Content.WayPoints)localObject1).getDescribe();
        localArrayList6.add(localObject2);
      }
      if (localArrayList6.size() == 1) {
        localAddrListResult.mHaveThroughCityList = true;
      }
      if (localAddrListResult.mHaveEnCityList)
      {
        localIterator = paramTrafficPois.getContent().getEndList().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (TrafficPois.Content.End)localIterator.next();
          localAddrListResult.getClass();
          localObject2 = new AddrListResult.Citys(localAddrListResult);
          ((AddrListResult.Citys)localObject2).code = ((TrafficPois.Content.End)localObject1).getCode();
          ((AddrListResult.Citys)localObject2).name = ((TrafficPois.Content.End)localObject1).getName();
          ((AddrListResult.Citys)localObject2).num = ((TrafficPois.Content.End)localObject1).getNum();
          localArrayList2.add(localObject2);
        }
      }
      localIterator = paramTrafficPois.getContent().getEndList().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (TrafficPois.Content.End)localIterator.next();
        localAddrListResult.getClass();
        localObject2 = new AddrListResult.Points(localAddrListResult);
        ((AddrListResult.Points)localObject2).addr = ((TrafficPois.Content.End)localObject1).getAddr();
        ((AddrListResult.Points)localObject2).name = ((TrafficPois.Content.End)localObject1).getName();
        ((AddrListResult.Points)localObject2).pt = PBConvertUtil.decryptPoint(((TrafficPois.Content.End)localObject1).getGeo());
        ((AddrListResult.Points)localObject2).uid = ((TrafficPois.Content.End)localObject1).getUid();
        ((AddrListResult.Points)localObject2).ext = ((TrafficPois.Content.End)localObject1).getExt();
        ((AddrListResult.Points)localObject2).poiType = ((TrafficPois.Content.End)localObject1).getPoiType();
        ((AddrListResult.Points)localObject2).floor = ((TrafficPois.Content.End)localObject1).getIndoorFloor();
        ((AddrListResult.Points)localObject2).buidingId = ((TrafficPois.Content.End)localObject1).getIndoorParentUid();
        ((AddrListResult.Points)localObject2).dist = ((TrafficPois.Content.End)localObject1).getDist();
        ((AddrListResult.Points)localObject2).direction = ((TrafficPois.Content.End)localObject1).getDirection();
        ((AddrListResult.Points)localObject2).hasDist = ((TrafficPois.Content.End)localObject1).hasDist();
        ((AddrListResult.Points)localObject2).hasDirect = ((TrafficPois.Content.End)localObject1).hasDirection();
        ((AddrListResult.Points)localObject2).describe = ((TrafficPois.Content.End)localObject1).getDescribe();
        localArrayList5.add(localObject2);
      }
      if (localArrayList5.size() == 1) {
        localAddrListResult.mHaveEnCityList = true;
      }
    }
    if (paramTrafficPois.getSuggestQueryCount() > 0)
    {
      localIterator = paramTrafficPois.getSuggestQueryList().iterator();
      while (localIterator.hasNext()) {
        localArrayList7.add((TrafficPois.SuggestQuery)localIterator.next());
      }
      if (!paramTrafficPois.getSuggestQueryList().isEmpty()) {
        localAddrListResult.hasSuggestQuery = true;
      }
    }
    if (paramTrafficPois.hasSuggestQueryFlag()) {
      localAddrListResult.suggestQueryFlag = paramTrafficPois.getSuggestQueryFlag();
    }
    localAddrListResult.mStartCitys = localArrayList1;
    localAddrListResult.mStartPoints = localArrayList4;
    localAddrListResult.mEndCitys = localArrayList2;
    localAddrListResult.mEndPoints = localArrayList5;
    localAddrListResult.mThroughCitys = localArrayList3;
    localAddrListResult.mThroughPoints = localArrayList6;
    localAddrListResult.suggestQuery = localArrayList7;
    return localAddrListResult;
  }
  
  public static CityInfo convertCityInfo(CityResult paramCityResult)
  {
    CityInfo localCityInfo = new CityInfo();
    localCityInfo.mResultType = 2;
    if (paramCityResult.hasCurrentCity())
    {
      localCityInfo.mCityCode = paramCityResult.getCurrentCity().getCode();
      localCityInfo.mCityName = paramCityResult.getCurrentCity().getName();
    }
    if (paramCityResult.hasPreviousCity())
    {
      localCityInfo.mPreCityCode = paramCityResult.getPreviousCity().getCode();
      localCityInfo.mPreCityName = paramCityResult.getPreviousCity().getName();
    }
    if (paramCityResult.hasContent())
    {
      localCityInfo.mCityType = paramCityResult.getContent().getCityType();
      localCityInfo.mcName = paramCityResult.getContent().getCname();
      localCityInfo.mLevel = transformCityLevel(paramCityResult.getContent().getLevel(), paramCityResult.getContent().getCityType());
      localCityInfo.mCityUid = paramCityResult.getContent().getUid();
      localCityInfo.mSup_lukuang = paramCityResult.getContent().getSupLukuang();
      localCityInfo.mCityGeo = PBConvertUtil.decryptPoint(paramCityResult.getContent().getGeo());
      localCityInfo.mSgeo = paramCityResult.getContent().getSgeo();
    }
    return localCityInfo;
  }
  
  public static CityListResult convertCityResult(TrafficCitys paramTrafficCitys)
  {
    CityListResult localCityListResult = new CityListResult();
    localCityListResult.mResultType = 7;
    localCityListResult.setCityCount(paramTrafficCitys.getContentsCount());
    Object localObject1 = new CityInfo();
    if (paramTrafficCitys.hasCurrentCity())
    {
      ((CityInfo)localObject1).mCityCode = paramTrafficCitys.getCurrentCity().getCode();
      ((CityInfo)localObject1).mCityName = paramTrafficCitys.getCurrentCity().getName();
      ((CityInfo)localObject1).mLevel = paramTrafficCitys.getCurrentCity().getLevel();
      ((CityInfo)localObject1).mCityUid = paramTrafficCitys.getCurrentCity().getUid();
      ((CityInfo)localObject1).mSup_subway = paramTrafficCitys.getCurrentCity().getSupSubway();
      ((CityInfo)localObject1).mSup_lukuang = paramTrafficCitys.getCurrentCity().getSupLukuang();
      ((CityInfo)localObject1).mCityGeo = PBConvertUtil.decryptPoint(paramTrafficCitys.getCurrentCity().getGeo());
    }
    localCityListResult.setCityinfo((CityInfo)localObject1);
    localObject1 = new ArrayList();
    Object localObject2 = paramTrafficCitys.getContentsList().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (TrafficCitys.Contents)((Iterator)localObject2).next();
      CityListResult.Citys localCitys;
      if (((TrafficCitys.Contents)localObject3).hasType())
      {
        localCityListResult.getClass();
        localCitys = new CityListResult.Citys(localCityListResult);
        localCitys.mCode = ((TrafficCitys.Contents)localObject3).getCode();
        localCitys.mName = ((TrafficCitys.Contents)localObject3).getName();
        localCitys.mNum = ((TrafficCitys.Contents)localObject3).getNum();
        localCitys.extinfo = ((TrafficCitys.Contents)localObject3).getExtInfo();
        localCitys.searchquery = ((TrafficCitys.Contents)localObject3).getSearchQuery();
        localCitys.type = ((TrafficCitys.Contents)localObject3).getType();
        localCitys.viewName = ((TrafficCitys.Contents)localObject3).getViewName();
        localCitys.poiNum = ((TrafficCitys.Contents)localObject3).getPoiNum();
        if (localCitys.poiNum >= 1)
        {
          ArrayList localArrayList = new ArrayList();
          localObject3 = ((TrafficCitys.Contents)localObject3).getPoisList().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            TrafficCitys.Contents.Pois localPois = (TrafficCitys.Contents.Pois)((Iterator)localObject3).next();
            localCityListResult.getClass();
            CityListResult.Pois localPois1 = new CityListResult.Pois(localCityListResult);
            localPois1.addr = localPois.getAddr();
            localPois1.bid = localPois.getBid();
            localPois1.name = localPois.getName();
            localPois1.stdtag = localPois.getStdtag();
            localPois1.searchpoi = localPois.getPoiQuery();
            localArrayList.add(localPois1);
          }
          localCitys.poiList = localArrayList;
        }
        ((ArrayList)localObject1).add(localCitys);
      }
      else
      {
        localCityListResult.getClass();
        localCitys = new CityListResult.Citys(localCityListResult);
        localCitys.mCode = ((TrafficCitys.Contents)localObject3).getCode();
        localCitys.viewName = ((TrafficCitys.Contents)localObject3).getName();
        localCitys.type = 1;
        localCitys.extinfo = ("约" + ((TrafficCitys.Contents)localObject3).getNum() + "个");
        localCitys.poiNum = 0;
        ((ArrayList)localObject1).add(localCitys);
      }
    }
    localCityListResult.setCitys((ArrayList)localObject1);
    localObject1 = new ArrayList();
    paramTrafficCitys = paramTrafficCitys.getSuggestQueryList().iterator();
    while (paramTrafficCitys.hasNext())
    {
      localObject2 = ((TrafficCitys.SuggestQuery)paramTrafficCitys.next()).getQuery();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    localCityListResult.setSuggestQueries((ArrayList)localObject1);
    return localCityListResult;
  }
  
  public static PoiDetailInfo convertPoiDetailInfo(int paramInt, Inf paramInf)
  {
    PoiDetailInfo localPoiDetailInfo = new PoiDetailInfo();
    localPoiDetailInfo.geo = new Point(0.0D, 0.0D);
    Object localObject1 = CoordinateUtil.geoStringToPoint(paramInf.getContent().getGeo());
    localPoiDetailInfo.geo.setTo(((Point)localObject1).getDoubleX(), ((Point)localObject1).getDoubleY());
    localPoiDetailInfo.newCatelogId = paramInf.getContent().getNewCatalogId();
    if (paramInf.getContent().hasServiceTag()) {
      localPoiDetailInfo.serviceTag = paramInf.getContent().getServiceTag();
    }
    localPoiDetailInfo.name = paramInf.getContent().getName();
    localPoiDetailInfo.ismodified = paramInf.getContent().getIsmodified();
    localPoiDetailInfo.type = paramInf.getContent().getPoiType();
    localPoiDetailInfo.uid = paramInf.getContent().getUid();
    localPoiDetailInfo.addr = paramInf.getContent().getAddr();
    localPoiDetailInfo.tel = paramInf.getContent().getTel();
    localPoiDetailInfo.floorId = paramInf.getContent().getIndoorFloor();
    localPoiDetailInfo.buildingId = paramInf.getContent().getIndoorParentUid();
    localPoiDetailInfo.indoorOverLooking = paramInf.getContent().getIndoorOverLooking();
    localPoiDetailInfo.cityId = paramInf.getContent().getCityId();
    localPoiDetailInfo.pano = paramInf.getContent().getPano();
    localPoiDetailInfo.indoor_pano = paramInf.getContent().getIndoorPano();
    localPoiDetailInfo.rtbusUpdateTime = paramInf.getContent().getRtbusUpdateTime();
    localPoiDetailInfo.poi_type_text = paramInf.getContent().getPoiTypeText();
    localPoiDetailInfo.streetId = paramInf.getContent().getStreetId();
    localPoiDetailInfo.stationNum = paramInf.getContent().getStationNum();
    localPoiDetailInfo.iconId = paramInf.getContent().getIconId();
    localPoiDetailInfo.stdTag = paramInf.getContent().getStdTag();
    if (paramInf.hasOption())
    {
      localPoiDetailInfo.ldata = paramInf.getOption().getLdata();
      localPoiDetailInfo.regionType = paramInf.getOption().getRegionType();
    }
    localPoiDetailInfo.offline = paramInf.getOffline();
    if ((paramInf.getContent().hasExt()) && (paramInf.getContent().getExt().hasDetailInfo())) {
      localPoiDetailInfo.isScopeRouteCommand = paramInf.getContent().getExt().getDetailInfo().getGuide();
    }
    if (paramInf.getContent().hasHeatMap())
    {
      localPoiDetailInfo.getClass();
      localPoiDetailInfo.heatMap = new PoiDetailInfo.HeatMap(localPoiDetailInfo);
      localPoiDetailInfo.heatMap.rankStr = paramInf.getContent().getHeatMap().getRankstr();
      localPoiDetailInfo.heatMap.type = paramInf.getContent().getHeatMap().getType();
      if (paramInf.getContent().getHeatMap().hasPoints()) {
        localPoiDetailInfo.heatMap.pointDiffs = new ArrayList(paramInf.getContent().getHeatMap().getPoints().getGeoElements(0).getPointList());
      }
    }
    Object localObject2;
    Object localObject3;
    if (paramInf.getContent().getBlinfoCount() > 0)
    {
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < paramInf.getContent().getBlinfoCount())
      {
        localObject2 = paramInf.getContent().getBlinfo(paramInt);
        localPoiDetailInfo.getClass();
        localObject3 = new PoiDetailInfo.BusLine(localPoiDetailInfo);
        ((PoiDetailInfo.BusLine)localObject3).addr = ((Inf.Content.Blinfo)localObject2).getAddr();
        ((PoiDetailInfo.BusLine)localObject3).name = ((Inf.Content.Blinfo)localObject2).getName();
        ((PoiDetailInfo.BusLine)localObject3).uid = ((Inf.Content.Blinfo)localObject2).getUid();
        ((PoiDetailInfo.BusLine)localObject3).pairUid = ((Inf.Content.Blinfo)localObject2).getPairUid();
        ((PoiDetailInfo.BusLine)localObject3).iconId = ((Inf.Content.Blinfo)localObject2).getIconId();
        ((PoiDetailInfo.BusLine)localObject3).nextstation = ((Inf.Content.Blinfo)localObject2).getNextStation();
        ((PoiDetailInfo.BusLine)localObject3).sonUid = ((Inf.Content.Blinfo)localObject2).getSonUid();
        if ((((Inf.Content.Blinfo)localObject2).hasRtInfo()) && (((Inf.Content.Blinfo)localObject2).getRtInfo().hasTipRtbus())) {
          ((PoiDetailInfo.BusLine)localObject3).rtbusInfo = ((Inf.Content.Blinfo)localObject2).getRtInfo().getTipRtbus();
        }
        ((ArrayList)localObject1).add(localObject3);
        paramInt += 1;
      }
      localPoiDetailInfo.setArrayBuslines((ArrayList)localObject1);
    }
    if (paramInf.getContent().getOtherStationsCount() > 0)
    {
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < paramInf.getContent().getOtherStationsCount())
      {
        localObject2 = paramInf.getContent().getOtherStations(paramInt);
        localPoiDetailInfo.getClass();
        localObject3 = new PoiDetailInfo.BusLine(localPoiDetailInfo);
        ((PoiDetailInfo.BusLine)localObject3).otherStationUid = ((Inf.Content.OtherStations)localObject2).getUid();
        ((PoiDetailInfo.BusLine)localObject3).otherStationIconid = ((Inf.Content.OtherStations)localObject2).getIconId();
        ((PoiDetailInfo.BusLine)localObject3).otherStationAddr = ((Inf.Content.OtherStations)localObject2).getAddr();
        ((ArrayList)localObject1).add(localObject3);
        paramInt += 1;
      }
      localPoiDetailInfo.setArrayOtherStations((ArrayList)localObject1);
    }
    if (paramInf.getContent().hasExt())
    {
      localPoiDetailInfo.getClass();
      localObject1 = new PoiDetailInfo.DeepDetail(localPoiDetailInfo);
      ((PoiDetailInfo.DeepDetail)localObject1).type = paramInf.getContent().getExtType();
      if (paramInf.getContent().getExt().getLineInfoCount() > 0)
      {
        localObject2 = new ArrayList();
        paramInt = 0;
      }
    }
    for (;;)
    {
      Inf.Content.Ext.LineInfo localLineInfo;
      if (paramInt < paramInf.getContent().getExt().getLineInfoCount())
      {
        localPoiDetailInfo.getClass();
        localObject3 = new PoiDetailInfo.Lines(localPoiDetailInfo);
        localLineInfo = paramInf.getContent().getExt().getLineInfo(paramInt);
        ((PoiDetailInfo.Lines)localObject3).firstTime = localLineInfo.getFirstTime();
        ((PoiDetailInfo.Lines)localObject3).lastTime = localLineInfo.getLastTime();
        ((PoiDetailInfo.Lines)localObject3).terminal = localLineInfo.getTerminals();
        ((PoiDetailInfo.Lines)localObject3).uid = localLineInfo.getUid();
        ((PoiDetailInfo.Lines)localObject3).abb = localLineInfo.getAbb();
      }
      try
      {
        if (localLineInfo.hasClr()) {
          ((PoiDetailInfo.Lines)localObject3).clr = localLineInfo.getClr().replace("0x", "#");
        }
        ((ArrayList)localObject2).add(localObject3);
        paramInt += 1;
        continue;
        ((PoiDetailInfo.DeepDetail)localObject1).lines = ((ArrayList)localObject2);
        ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("src_name", paramInf.getContent().getExt().getSrcName());
        if (!TextUtils.isEmpty(paramInf.getContent().getNewCatalogId())) {
          ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("new_catalog_id", paramInf.getContent().getNewCatalogId());
        }
        if (paramInf.getContent().hasServiceTag()) {
          ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("service_tag", paramInf.getContent().getServiceTag());
        }
        if (paramInf.getContent().getExt().hasSrcName()) {
          localPoiDetailInfo.fromSource = paramInf.getContent().getExt().getSrcName();
        }
        if (paramInf.getContent().getExt().hasDetailInfo())
        {
          localObject2 = paramInf.getContent().getExt().getDetailInfo();
          ((PoiDetailInfo.DeepDetail)localObject1).price = ((Inf.Content.Ext.DetailInfo)localObject2).getPrice();
          if (paramInf.getContent().hasPhotoList()) {
            localPoiDetailInfo.mPhotoList = paramInf.getContent().getPhotoList();
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasOverallRating()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("overall_rating", ((Inf.Content.Ext.DetailInfo)localObject2).getOverallRating());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasImage()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("image", ((Inf.Content.Ext.DetailInfo)localObject2).getImage());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasPrice()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("price", ((Inf.Content.Ext.DetailInfo)localObject2).getPrice());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasPriceText()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("price_text", ((Inf.Content.Ext.DetailInfo)localObject2).getPriceText());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasTag()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("tag", ((Inf.Content.Ext.DetailInfo)localObject2).getTag());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasPremiumFlag()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("premium_flag", Integer.valueOf(((Inf.Content.Ext.DetailInfo)localObject2).getPremiumFlag()));
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasCommentNum()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("comment_num", ((Inf.Content.Ext.DetailInfo)localObject2).getCommentNum());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasGrouponFlag()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("groupon_flag", Integer.valueOf(((Inf.Content.Ext.DetailInfo)localObject2).getGrouponFlag()));
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasGrouponTotal()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("groupon_total", Integer.valueOf(((Inf.Content.Ext.DetailInfo)localObject2).getGrouponTotal()));
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasWiseRealtimePriceFlag()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("wise_realtime_price_flag", ((Inf.Content.Ext.DetailInfo)localObject2).getWiseRealtimePriceFlag());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasWiseRealtimePrice()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("wise_realtime_price", ((Inf.Content.Ext.DetailInfo)localObject2).getWiseRealtimePrice());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasWiseHotelType()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("wise_hotel_type", ((Inf.Content.Ext.DetailInfo)localObject2).getWiseHotelType());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasTonightSaleFlag()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("tonight_sale_flag", ((Inf.Content.Ext.DetailInfo)localObject2).getTonightSaleFlag());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasTonightPrice()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("tonight_price", ((Inf.Content.Ext.DetailInfo)localObject2).getTonightPrice());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasWapBookable()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("wap_bookable", ((Inf.Content.Ext.DetailInfo)localObject2).getWapBookable());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasWiseFullroom()) {
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("wise_fullroom", ((Inf.Content.Ext.DetailInfo)localObject2).getWiseFullroom());
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).getFlagCount() > 0)
          {
            localObject3 = new ArrayList();
            paramInt = 0;
            while (paramInt < ((Inf.Content.Ext.DetailInfo)localObject2).getFlagCount())
            {
              ((ArrayList)localObject3).add(((Inf.Content.Ext.DetailInfo)localObject2).getFlag(paramInt));
              paramInt += 1;
            }
            ((PoiDetailInfo.DeepDetail)localObject1).placeParam.put("flag", localObject3);
          }
          if (((Inf.Content.Ext.DetailInfo)localObject2).hasMeishipaihao())
          {
            localPoiDetailInfo.getClass();
            localObject3 = new PoiDetailInfo.CaterQueueInfo(localPoiDetailInfo);
            if ((!((Inf.Content.Ext.DetailInfo)localObject2).getMeishipaihao().hasIsOk()) || (((Inf.Content.Ext.DetailInfo)localObject2).getMeishipaihao().getIsOk() <= 0)) {
              break label1825;
            }
          }
        }
        label1825:
        for (boolean bool = true;; bool = false)
        {
          ((PoiDetailInfo.CaterQueueInfo)localObject3).isOk = bool;
          if (((Inf.Content.Ext.DetailInfo)localObject2).getMeishipaihao().hasMain())
          {
            if (((Inf.Content.Ext.DetailInfo)localObject2).getMeishipaihao().getMain().hasThirdFrom()) {
              ((PoiDetailInfo.CaterQueueInfo)localObject3).thirdFrom = ((Inf.Content.Ext.DetailInfo)localObject2).getMeishipaihao().getMain().getThirdFrom();
            }
            if (((Inf.Content.Ext.DetailInfo)localObject2).getMeishipaihao().getMain().hasThirdId()) {
              ((PoiDetailInfo.CaterQueueInfo)localObject3).thirdId = ((Inf.Content.Ext.DetailInfo)localObject2).getMeishipaihao().getMain().getThirdId();
            }
          }
          localPoiDetailInfo.caterQueueInfo = ((PoiDetailInfo.CaterQueueInfo)localObject3);
          localPoiDetailInfo.setDeepDetail((PoiDetailInfo.DeepDetail)localObject1);
          if ((paramInf.getContent().hasHeadIcon()) && (paramInf.getContent().getHeadIcon() != null))
          {
            localPoiDetailInfo.headIcon = new PoiDetailInfo.HeadIcon();
            localPoiDetailInfo.headIcon.url = paramInf.getContent().getHeadIcon().getUrl();
            localPoiDetailInfo.headIcon.type = paramInf.getContent().getHeadIcon().getType();
            localPoiDetailInfo.headIcon.pid = paramInf.getContent().getHeadIcon().getPid();
            localPoiDetailInfo.headIcon.links = paramInf.getContent().getHeadIcon().getLinks();
          }
          return localPoiDetailInfo;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private static void convertStringMap(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, String.valueOf(paramMap.get(str)));
    }
  }
  
  public static SugResult convertSuggestResult(SusvrResponse paramSusvrResponse)
  {
    SugResult localSugResult = new SugResult();
    int j = paramSusvrResponse.getPoiArrayCount();
    String[] arrayOfString1 = new String[j];
    String[] arrayOfString2 = new String[j];
    String[] arrayOfString3 = new String[j];
    String[] arrayOfString4 = new String[j];
    int i = 0;
    while (i < j)
    {
      SusvrResponse.PoiElement localPoiElement = paramSusvrResponse.getPoiArray(i);
      if (localPoiElement.hasPoiName()) {
        arrayOfString1[i] = localPoiElement.getPoiName();
      }
      if (localPoiElement.hasSubTitle()) {
        arrayOfString2[i] = localPoiElement.getDistance();
      }
      if (localPoiElement.hasCityid()) {
        arrayOfString3[i] = Integer.toString(localPoiElement.getCityid());
      }
      if (localPoiElement.hasDistance()) {
        arrayOfString4[i] = localPoiElement.getDistance();
      }
      i += 1;
    }
    localSugResult.setPoiname(arrayOfString1);
    localSugResult.setSubtitle(arrayOfString2);
    localSugResult.setCityid(arrayOfString3);
    localSugResult.setDistance(arrayOfString4);
    return localSugResult;
  }
  
  private static int transformCityLevel(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 == 0) {}
    switch (paramInt2)
    {
    default: 
      i = 0;
      return i;
    case 0: 
      return 4;
    case 1: 
      return 11;
    case 2: 
      return 12;
    }
    return 13;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/convert/PoiPBConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */