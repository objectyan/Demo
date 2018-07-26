package com.baidu.platform.comapi.search.convert;

import android.text.TextUtils;
import com.baidu.entity.pb.CityResult;
import com.baidu.entity.pb.Inf;
import com.baidu.entity.pb.Inf.Content.Blinfo;
import com.baidu.entity.pb.Inf.Content.Ext.DetailInfo;
import com.baidu.entity.pb.Inf.Content.Ext.LineInfo;
import com.baidu.entity.pb.Inf.Content.OtherStations;
import com.baidu.entity.pb.SusvrResponse;
import com.baidu.entity.pb.SusvrResponse.PoiElement;
import com.baidu.entity.pb.TrafficCitys;
import com.baidu.entity.pb.TrafficCitys.Contents;
import com.baidu.entity.pb.TrafficCitys.SuggestQuery;
import com.baidu.entity.pb.TrafficPois;
import com.baidu.entity.pb.TrafficPois.Content.End;
import com.baidu.entity.pb.TrafficPois.Content.Start;
import com.baidu.entity.pb.TrafficPois.Content.WayPoints;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.navisdk.comapi.mapcontrol.MapParams.Const;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.search.AddrListResult;
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
import java.util.Map;

public class PoiPBConverter {
    public static PoiDetailInfo convertPoiDetailInfo(int resultType, Inf pbResult) {
        int i;
        BusLine info;
        PoiDetailInfo result = new PoiDetailInfo();
        result.geo = new Point(0.0d, 0.0d);
        Point pt = CoordinateUtil.geoStringToPoint(pbResult.getContent().getGeo());
        result.geo.setTo(pt.getDoubleX(), pt.getDoubleY());
        result.newCatelogId = pbResult.getContent().getNewCatalogId();
        if (pbResult.getContent().hasServiceTag()) {
            result.serviceTag = pbResult.getContent().getServiceTag();
        }
        result.name = pbResult.getContent().getName();
        result.ismodified = pbResult.getContent().getIsmodified();
        result.type = pbResult.getContent().getPoiType();
        result.uid = pbResult.getContent().getUid();
        result.addr = pbResult.getContent().getAddr();
        result.tel = pbResult.getContent().getTel();
        result.floorId = pbResult.getContent().getIndoorFloor();
        result.buildingId = pbResult.getContent().getIndoorParentUid();
        result.indoorOverLooking = pbResult.getContent().getIndoorOverLooking();
        result.cityId = pbResult.getContent().getCityId();
        result.pano = pbResult.getContent().getPano();
        result.indoor_pano = pbResult.getContent().getIndoorPano();
        result.rtbusUpdateTime = pbResult.getContent().getRtbusUpdateTime();
        result.poi_type_text = pbResult.getContent().getPoiTypeText();
        result.streetId = pbResult.getContent().getStreetId();
        result.stationNum = pbResult.getContent().getStationNum();
        result.iconId = pbResult.getContent().getIconId();
        result.stdTag = pbResult.getContent().getStdTag();
        if (pbResult.hasOption()) {
            result.ldata = pbResult.getOption().getLdata();
            result.regionType = pbResult.getOption().getRegionType();
        }
        result.offline = pbResult.getOffline();
        if (pbResult.getContent().hasExt() && pbResult.getContent().getExt().hasDetailInfo()) {
            result.isScopeRouteCommand = pbResult.getContent().getExt().getDetailInfo().getGuide();
        }
        if (pbResult.getContent().hasHeatMap()) {
            result.getClass();
            result.heatMap = new HeatMap();
            result.heatMap.rankStr = pbResult.getContent().getHeatMap().getRankstr();
            result.heatMap.type = pbResult.getContent().getHeatMap().getType();
            if (pbResult.getContent().getHeatMap().hasPoints()) {
                result.heatMap.pointDiffs = new ArrayList(pbResult.getContent().getHeatMap().getPoints().getGeoElements(0).getPointList());
            }
        }
        if (pbResult.getContent().getBlinfoCount() > 0) {
            ArrayList<BusLine> arrayBusLine = new ArrayList();
            for (i = 0; i < pbResult.getContent().getBlinfoCount(); i++) {
                Blinfo test = pbResult.getContent().getBlinfo(i);
                result.getClass();
                info = new BusLine();
                info.addr = test.getAddr();
                info.name = test.getName();
                info.uid = test.getUid();
                info.pairUid = test.getPairUid();
                info.iconId = test.getIconId();
                info.nextstation = test.getNextStation();
                info.sonUid = test.getSonUid();
                if (test.hasRtInfo() && test.getRtInfo().hasTipRtbus()) {
                    info.rtbusInfo = test.getRtInfo().getTipRtbus();
                }
                arrayBusLine.add(info);
            }
            result.setArrayBuslines(arrayBusLine);
        }
        if (pbResult.getContent().getOtherStationsCount() > 0) {
            ArrayList<BusLine> arrayOtherStations = new ArrayList();
            for (i = 0; i < pbResult.getContent().getOtherStationsCount(); i++) {
                OtherStations test2 = pbResult.getContent().getOtherStations(i);
                result.getClass();
                info = new BusLine();
                info.otherStationUid = test2.getUid();
                info.otherStationIconid = test2.getIconId();
                info.otherStationAddr = test2.getAddr();
                arrayOtherStations.add(info);
            }
            result.setArrayOtherStations(arrayOtherStations);
        }
        if (pbResult.getContent().hasExt()) {
            result.getClass();
            DeepDetail mdetail = new DeepDetail();
            mdetail.type = pbResult.getContent().getExtType();
            if (pbResult.getContent().getExt().getLineInfoCount() > 0) {
                ArrayList<Lines> arrayInfos1 = new ArrayList();
                for (i = 0; i < pbResult.getContent().getExt().getLineInfoCount(); i++) {
                    result.getClass();
                    Lines mid1 = new Lines();
                    LineInfo lineInfo = pbResult.getContent().getExt().getLineInfo(i);
                    mid1.firstTime = lineInfo.getFirstTime();
                    mid1.lastTime = lineInfo.getLastTime();
                    mid1.terminal = lineInfo.getTerminals();
                    mid1.uid = lineInfo.getUid();
                    mid1.abb = lineInfo.getAbb();
                    try {
                        if (lineInfo.hasClr()) {
                            mid1.clr = lineInfo.getClr().replace("0x", "#");
                        }
                    } catch (Exception e) {
                    }
                    arrayInfos1.add(mid1);
                }
                mdetail.lines = arrayInfos1;
            }
            mdetail.placeParam.put(Const.SRC_NAME, pbResult.getContent().getExt().getSrcName());
            if (!TextUtils.isEmpty(pbResult.getContent().getNewCatalogId())) {
                mdetail.placeParam.put("new_catalog_id", pbResult.getContent().getNewCatalogId());
            }
            if (pbResult.getContent().hasServiceTag()) {
                mdetail.placeParam.put("service_tag", pbResult.getContent().getServiceTag());
            }
            if (pbResult.getContent().getExt().hasSrcName()) {
                result.fromSource = pbResult.getContent().getExt().getSrcName();
            }
            if (pbResult.getContent().getExt().hasDetailInfo()) {
                DetailInfo info2 = pbResult.getContent().getExt().getDetailInfo();
                mdetail.price = info2.getPrice();
                if (pbResult.getContent().hasPhotoList()) {
                    result.mPhotoList = pbResult.getContent().getPhotoList();
                }
                if (info2.hasOverallRating()) {
                    mdetail.placeParam.put("overall_rating", info2.getOverallRating());
                }
                if (info2.hasImage()) {
                    mdetail.placeParam.put("image", info2.getImage());
                }
                if (info2.hasPrice()) {
                    mdetail.placeParam.put(SearchParamKey.PRICE, info2.getPrice());
                }
                if (info2.hasPriceText()) {
                    mdetail.placeParam.put("price_text", info2.getPriceText());
                }
                if (info2.hasTag()) {
                    mdetail.placeParam.put("tag", info2.getTag());
                }
                if (info2.hasPremiumFlag()) {
                    mdetail.placeParam.put("premium_flag", Integer.valueOf(info2.getPremiumFlag()));
                }
                if (info2.hasCommentNum()) {
                    mdetail.placeParam.put("comment_num", info2.getCommentNum());
                }
                if (info2.hasGrouponFlag()) {
                    mdetail.placeParam.put("groupon_flag", Integer.valueOf(info2.getGrouponFlag()));
                }
                if (info2.hasGrouponTotal()) {
                    mdetail.placeParam.put("groupon_total", Integer.valueOf(info2.getGrouponTotal()));
                }
                if (info2.hasWiseRealtimePriceFlag()) {
                    mdetail.placeParam.put("wise_realtime_price_flag", info2.getWiseRealtimePriceFlag());
                }
                if (info2.hasWiseRealtimePrice()) {
                    mdetail.placeParam.put("wise_realtime_price", info2.getWiseRealtimePrice());
                }
                if (info2.hasWiseHotelType()) {
                    mdetail.placeParam.put("wise_hotel_type", info2.getWiseHotelType());
                }
                if (info2.hasTonightSaleFlag()) {
                    mdetail.placeParam.put("tonight_sale_flag", info2.getTonightSaleFlag());
                }
                if (info2.hasTonightPrice()) {
                    mdetail.placeParam.put("tonight_price", info2.getTonightPrice());
                }
                if (info2.hasWapBookable()) {
                    mdetail.placeParam.put("wap_bookable", info2.getWapBookable());
                }
                if (info2.hasWiseFullroom()) {
                    mdetail.placeParam.put("wise_fullroom", info2.getWiseFullroom());
                }
                if (info2.getFlagCount() > 0) {
                    ArrayList<String> arrayList = new ArrayList();
                    for (int index = 0; index < info2.getFlagCount(); index++) {
                        arrayList.add(info2.getFlag(index));
                    }
                    mdetail.placeParam.put("flag", arrayList);
                }
                if (info2.hasMeishipaihao()) {
                    result.getClass();
                    CaterQueueInfo caterQueue = new CaterQueueInfo();
                    boolean z = info2.getMeishipaihao().hasIsOk() && info2.getMeishipaihao().getIsOk() > 0;
                    caterQueue.isOk = z;
                    if (info2.getMeishipaihao().hasMain()) {
                        if (info2.getMeishipaihao().getMain().hasThirdFrom()) {
                            caterQueue.thirdFrom = info2.getMeishipaihao().getMain().getThirdFrom();
                        }
                        if (info2.getMeishipaihao().getMain().hasThirdId()) {
                            caterQueue.thirdId = info2.getMeishipaihao().getMain().getThirdId();
                        }
                    }
                    result.caterQueueInfo = caterQueue;
                }
            }
            result.setDeepDetail(mdetail);
        }
        if (pbResult.getContent().hasHeadIcon() && pbResult.getContent().getHeadIcon() != null) {
            result.headIcon = new HeadIcon();
            result.headIcon.url = pbResult.getContent().getHeadIcon().getUrl();
            result.headIcon.type = pbResult.getContent().getHeadIcon().getType();
            result.headIcon.pid = pbResult.getContent().getHeadIcon().getPid();
            result.headIcon.links = pbResult.getContent().getHeadIcon().getLinks();
        }
        return result;
    }

    private static void convertStringMap(Map<String, Object> map) {
        for (String key : map.keySet()) {
            map.put(key, String.valueOf(map.get(key)));
        }
    }

    public static CityListResult convertCityResult(TrafficCitys pbResult) {
        CityListResult oldResult = new CityListResult();
        oldResult.mResultType = 7;
        oldResult.setCityCount(pbResult.getContentsCount());
        CityInfo cityInfo = new CityInfo();
        if (pbResult.hasCurrentCity()) {
            cityInfo.mCityCode = pbResult.getCurrentCity().getCode();
            cityInfo.mCityName = pbResult.getCurrentCity().getName();
            cityInfo.mLevel = pbResult.getCurrentCity().getLevel();
            cityInfo.mCityUid = pbResult.getCurrentCity().getUid();
            cityInfo.mSup_subway = pbResult.getCurrentCity().getSupSubway();
            cityInfo.mSup_lukuang = pbResult.getCurrentCity().getSupLukuang();
            cityInfo.mCityGeo = PBConvertUtil.decryptPoint(pbResult.getCurrentCity().getGeo());
        }
        oldResult.setCityinfo(cityInfo);
        ArrayList<Citys> cityList = new ArrayList();
        for (Contents city : pbResult.getContentsList()) {
            Citys c;
            if (city.hasType()) {
                oldResult.getClass();
                c = new Citys();
                c.mCode = city.getCode();
                c.mName = city.getName();
                c.mNum = city.getNum();
                c.extinfo = city.getExtInfo();
                c.searchquery = city.getSearchQuery();
                c.type = city.getType();
                c.viewName = city.getViewName();
                c.poiNum = city.getPoiNum();
                if (c.poiNum >= 1) {
                    ArrayList<Pois> poiList = new ArrayList();
                    for (Contents.Pois poi : city.getPoisList()) {
                        oldResult.getClass();
                        Pois po = new Pois();
                        po.addr = poi.getAddr();
                        po.bid = poi.getBid();
                        po.name = poi.getName();
                        po.stdtag = poi.getStdtag();
                        po.searchpoi = poi.getPoiQuery();
                        poiList.add(po);
                    }
                    c.poiList = poiList;
                }
                cityList.add(c);
            } else {
                oldResult.getClass();
                c = new Citys();
                c.mCode = city.getCode();
                c.viewName = city.getName();
                c.type = 1;
                c.extinfo = "约" + city.getNum() + "个";
                c.poiNum = 0;
                cityList.add(c);
            }
        }
        oldResult.setCitys(cityList);
        ArrayList<String> sugs = new ArrayList();
        for (SuggestQuery sug : pbResult.getSuggestQueryList()) {
            String query = sug.getQuery();
            if (!TextUtils.isEmpty(query)) {
                sugs.add(query);
            }
        }
        oldResult.setSuggestQueries(sugs);
        return oldResult;
    }

    public static CityInfo convertCityInfo(CityResult pbResult) {
        CityInfo oldResult = new CityInfo();
        oldResult.mResultType = 2;
        if (pbResult.hasCurrentCity()) {
            oldResult.mCityCode = pbResult.getCurrentCity().getCode();
            oldResult.mCityName = pbResult.getCurrentCity().getName();
        }
        if (pbResult.hasPreviousCity()) {
            oldResult.mPreCityCode = pbResult.getPreviousCity().getCode();
            oldResult.mPreCityName = pbResult.getPreviousCity().getName();
        }
        if (pbResult.hasContent()) {
            oldResult.mCityType = pbResult.getContent().getCityType();
            oldResult.mcName = pbResult.getContent().getCname();
            oldResult.mLevel = transformCityLevel(pbResult.getContent().getLevel(), pbResult.getContent().getCityType());
            oldResult.mCityUid = pbResult.getContent().getUid();
            oldResult.mSup_lukuang = pbResult.getContent().getSupLukuang();
            oldResult.mCityGeo = PBConvertUtil.decryptPoint(pbResult.getContent().getGeo());
            oldResult.mSgeo = pbResult.getContent().getSgeo();
        }
        return oldResult;
    }

    private static int transformCityLevel(int level, int cityType) {
        if (level != 0) {
            return level;
        }
        switch (cityType) {
            case 0:
                return 4;
            case 1:
                return 11;
            case 2:
                return 12;
            case 3:
                return 13;
            default:
                return 0;
        }
    }

    public static AddrListResult convertAddressListResult(TrafficPois pbResult) {
        AddrListResult oldResult = new AddrListResult();
        oldResult.mResultType = 23;
        if (pbResult.hasOption()) {
            int i;
            if (pbResult.getOption().getCityListCount() > 1) {
                oldResult.mHaveStCitylist = PBConvertUtil.stringToBool(pbResult.getOption().getCityList(0));
                oldResult.mHaveEnCityList = PBConvertUtil.stringToBool(pbResult.getOption().getCityList(pbResult.getOption().getCityListCount() - 1));
                if (pbResult.getOption().getCityListCount() > 2) {
                    for (i = 1; i < pbResult.getOption().getCityListCount() - 1; i++) {
                        if (PBConvertUtil.stringToBool(pbResult.getOption().getCityList(i))) {
                            oldResult.mHaveThroughCityList = true;
                        }
                    }
                }
            }
            if (pbResult.hasImgeShow()) {
                if (pbResult.getImgeShow().hasImageExt()) {
                    oldResult.mImgExt = pbResult.getImgeShow().getImageExt();
                }
                if (pbResult.getImgeShow().hasResBound()) {
                    oldResult.mResBound = pbResult.getImgeShow().getResBound();
                }
            }
            if (pbResult.getOption().getPrioFlagCount() > 1) {
                oldResult.mHaveStPrio = PBConvertUtil.stringToBool(pbResult.getOption().getPrioFlag(0));
                oldResult.mHaveEnPrio = PBConvertUtil.stringToBool(pbResult.getOption().getPrioFlag(pbResult.getOption().getPrioFlagCount() - 1));
                if (pbResult.getOption().getPrioFlagCount() > 2) {
                    for (i = 1; i < pbResult.getOption().getPrioFlagCount() - 1; i++) {
                        if (PBConvertUtil.stringToBool(pbResult.getOption().getPrioFlag(i))) {
                            oldResult.mHaveThroughPrio = true;
                        }
                    }
                }
            }
            oldResult.mStKeyword = pbResult.getOption().getSWd();
            if (pbResult.getOption().getEWdCount() > 0) {
                oldResult.mEnKeyWord = pbResult.getOption().getEWd(pbResult.getOption().getEWdCount() - 1);
            }
            if (pbResult.getOption().getEWdCount() > 1) {
                oldResult.mThroughKeyword = pbResult.getOption().getEWd(0);
            }
            oldResult.mIfNav = pbResult.getOption().getIfNav();
            if (pbResult.getOption().hasStartCity()) {
                oldResult.mStCityname = pbResult.getOption().getStartCity().getCname();
                oldResult.mStCityCode = pbResult.getOption().getStartCity().getCode();
            }
            if (pbResult.getOption().getEndCityCount() > 0) {
                oldResult.mEnCityname = pbResult.getOption().getEndCity(pbResult.getOption().getEndCityCount() - 1).getCname();
                oldResult.mEnCityCode = pbResult.getOption().getEndCity(pbResult.getOption().getEndCityCount() - 1).getCode();
            }
            if (pbResult.getOption().getEndCityCount() > 1) {
                oldResult.mThroughCityName = pbResult.getOption().getEndCity(0).getCname();
                oldResult.mThroughCityCode = Integer.valueOf(pbResult.getOption().getEndCity(0).getCode());
            }
        }
        ArrayList<AddrListResult.Citys> startCityList = new ArrayList();
        ArrayList<AddrListResult.Citys> endCityList = new ArrayList();
        ArrayList<AddrListResult.Citys> throughCityList = new ArrayList();
        ArrayList<Points> startCityPointList = new ArrayList();
        ArrayList<Points> endCityPointList = new ArrayList();
        ArrayList<Points> throughCityPointList = new ArrayList();
        ArrayList<TrafficPois.SuggestQuery> suggestQueryList = new ArrayList();
        if (pbResult.hasContent()) {
            AddrListResult.Citys city;
            Points point;
            oldResult.mStCount = pbResult.getContent().getStartCount();
            oldResult.mEnCount = pbResult.getContent().getEndCount();
            oldResult.mThroughCount = pbResult.getContent().getWayPointsCount();
            if (oldResult.mHaveStCitylist) {
                for (Start item : pbResult.getContent().getStartList()) {
                    oldResult.getClass();
                    city = new AddrListResult.Citys();
                    city.code = item.getCode();
                    city.name = item.getName();
                    city.num = item.getNum();
                    startCityList.add(city);
                }
            } else {
                for (Start item2 : pbResult.getContent().getStartList()) {
                    oldResult.getClass();
                    point = new Points();
                    point.addr = item2.getAddr();
                    point.name = item2.getName();
                    point.pt = PBConvertUtil.decryptPoint(item2.getGeo());
                    point.uid = item2.getUid();
                    point.floor = item2.getIndoorFloor();
                    point.buidingId = item2.getIndoorParentUid();
                    point.describe = item2.getDescribe();
                    startCityPointList.add(point);
                }
                if (startCityPointList.size() == 1) {
                    oldResult.mHaveStCitylist = true;
                }
            }
            if (oldResult.mHaveThroughCityList) {
                for (WayPoints item3 : pbResult.getContent().getWayPointsList()) {
                    oldResult.getClass();
                    city = new AddrListResult.Citys();
                    city.code = item3.getCode();
                    city.name = item3.getName();
                    city.num = item3.getNum();
                    throughCityList.add(city);
                }
            } else {
                for (WayPoints item32 : pbResult.getContent().getWayPointsList()) {
                    oldResult.getClass();
                    point = new Points();
                    point.addr = item32.getAddr();
                    point.name = item32.getName();
                    point.pt = PBConvertUtil.decryptPoint(item32.getGeo());
                    point.uid = item32.getUid();
                    point.floor = item32.getIndoorFloor();
                    point.buidingId = item32.getIndoorParentUid();
                    point.dist = item32.getDist();
                    point.direction = item32.getDirection();
                    point.hasDist = item32.hasDist();
                    point.hasDirect = item32.hasDirection();
                    point.describe = item32.getDescribe();
                    throughCityPointList.add(point);
                }
                if (throughCityPointList.size() == 1) {
                    oldResult.mHaveThroughCityList = true;
                }
            }
            if (oldResult.mHaveEnCityList) {
                for (End item4 : pbResult.getContent().getEndList()) {
                    oldResult.getClass();
                    city = new AddrListResult.Citys();
                    city.code = item4.getCode();
                    city.name = item4.getName();
                    city.num = item4.getNum();
                    endCityList.add(city);
                }
            } else {
                for (End item42 : pbResult.getContent().getEndList()) {
                    oldResult.getClass();
                    point = new Points();
                    point.addr = item42.getAddr();
                    point.name = item42.getName();
                    point.pt = PBConvertUtil.decryptPoint(item42.getGeo());
                    point.uid = item42.getUid();
                    point.ext = item42.getExt();
                    point.poiType = item42.getPoiType();
                    point.floor = item42.getIndoorFloor();
                    point.buidingId = item42.getIndoorParentUid();
                    point.dist = item42.getDist();
                    point.direction = item42.getDirection();
                    point.hasDist = item42.hasDist();
                    point.hasDirect = item42.hasDirection();
                    point.describe = item42.getDescribe();
                    endCityPointList.add(point);
                }
                if (endCityPointList.size() == 1) {
                    oldResult.mHaveEnCityList = true;
                }
            }
        }
        if (pbResult.getSuggestQueryCount() > 0) {
            for (TrafficPois.SuggestQuery item5 : pbResult.getSuggestQueryList()) {
                suggestQueryList.add(item5);
            }
            if (!pbResult.getSuggestQueryList().isEmpty()) {
                oldResult.hasSuggestQuery = true;
            }
        }
        if (pbResult.hasSuggestQueryFlag()) {
            oldResult.suggestQueryFlag = pbResult.getSuggestQueryFlag();
        }
        oldResult.mStartCitys = startCityList;
        oldResult.mStartPoints = startCityPointList;
        oldResult.mEndCitys = endCityList;
        oldResult.mEndPoints = endCityPointList;
        oldResult.mThroughCitys = throughCityList;
        oldResult.mThroughPoints = throughCityPointList;
        oldResult.suggestQuery = suggestQueryList;
        return oldResult;
    }

    public static SugResult convertSuggestResult(SusvrResponse pbResult) {
        SugResult sug = new SugResult();
        int length = pbResult.getPoiArrayCount();
        String[] strPoiname = new String[length];
        String[] strSubtitle = new String[length];
        String[] strCityid = new String[length];
        String[] strDistance = new String[length];
        for (int i = 0; i < length; i++) {
            PoiElement item = pbResult.getPoiArray(i);
            if (item.hasPoiName()) {
                strPoiname[i] = item.getPoiName();
            }
            if (item.hasSubTitle()) {
                strSubtitle[i] = item.getDistance();
            }
            if (item.hasCityid()) {
                strCityid[i] = Integer.toString(item.getCityid());
            }
            if (item.hasDistance()) {
                strDistance[i] = item.getDistance();
            }
        }
        sug.setPoiname(strPoiname);
        sug.setSubtitle(strSubtitle);
        sug.setCityid(strCityid);
        sug.setDistance(strDistance);
        return sug;
    }
}
