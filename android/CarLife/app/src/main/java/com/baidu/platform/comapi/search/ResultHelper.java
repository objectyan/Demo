package com.baidu.platform.comapi.search;

import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.entity.pb.ReverseGeocoding;
import com.baidu.entity.pb.ReverseGeocoding.AddressDetail;
import com.baidu.entity.pb.ReverseGeocoding.SurroundPoi;
import com.baidu.navi.protocol.model.GeoPointInfo;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.navisdk.comapi.mapcontrol.MapParams.Const;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.search.AddrResult.GeoPoiInfo;
import com.baidu.platform.comapi.search.CityListResult.Citys;
import com.baidu.platform.comapi.search.PoiBKGResult.PoiBKGBlock;
import com.baidu.platform.comapi.search.PoiBKGResult.PoiBKGBlock.PoiBKGItem;
import com.baidu.platform.comapi.search.PoiDetailInfo.ArroundInfos;
import com.baidu.platform.comapi.search.PoiDetailInfo.BusLine;
import com.baidu.platform.comapi.search.PoiDetailInfo.DeepDetail;
import com.baidu.platform.comapi.search.PoiDetailInfo.DetailInfo;
import com.baidu.platform.comapi.search.PoiDetailInfo.Lines;
import com.baidu.platform.comapi.search.RTBusResult.Content;
import com.baidu.platform.comapi.search.RTBusResult.Result;
import com.baidu.platform.comapi.search.RTBusResult.Station;
import com.baidu.platform.comapi.search.RTBusResult.Station.Line;
import com.baidu.platform.comapi.search.RTBusResult.Station.NextBusInfo;
import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class ResultHelper {
    public static boolean parseStringToPoiRGCDetailResult(String strRst, PoiRGCDetailResult result) {
        if (strRst == null) {
            return false;
        }
        try {
            if (strRst.equals("") || result == null) {
                return false;
            }
            JSONObject jsonRoot = new JSONObject(strRst);
            result.mResultType = jsonRoot.optInt("result_type");
            result.mName = jsonRoot.optString("name");
            result.mAddress = jsonRoot.optString(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS);
            result.mLocation = new Point((double) jsonRoot.optInt("x"), (double) jsonRoot.optInt("y"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean parseStringToPoiPKGResult(String strRst, PoiBKGResult result) {
        if (strRst != null) {
            try {
                if (!(strRst.equals("") || result == null)) {
                    JSONObject jsonRoot = new JSONObject(strRst);
                    result.mResultType = jsonRoot.optInt("result_type");
                    result.mCount = jsonRoot.optInt("count");
                    result.mError = jsonRoot.optInt(ParamKey.KEY_MSG_ERRORS);
                    result.mKeyWord = jsonRoot.optString("keyword");
                    JSONArray jsonArrayDataelems = jsonRoot.optJSONArray("dataelem");
                    if (jsonArrayDataelems != null && jsonArrayDataelems.length() > 0) {
                        result.mBlockList = new ArrayList();
                        for (int i = 0; i < jsonArrayDataelems.length(); i++) {
                            JSONObject jsonElem = jsonArrayDataelems.optJSONObject(i);
                            if (jsonElem != null) {
                                result.getClass();
                                PoiBKGBlock block = new PoiBKGBlock(result);
                                block.mLevel = jsonElem.optInt("level");
                                block.mIndexX = jsonElem.optInt("indexX");
                                block.mIndexY = jsonElem.optInt("indexY");
                                JSONArray jsonArrayDatas = jsonElem.optJSONArray("data");
                                if (jsonArrayDatas != null && jsonArrayDatas.length() > 0) {
                                    block.mItemList = new ArrayList();
                                    for (int j = 0; j < jsonArrayDatas.length(); j++) {
                                        JSONObject jsonData = jsonArrayDatas.optJSONObject(j);
                                        if (jsonData != null) {
                                            block.getClass();
                                            PoiBKGItem bkg = new PoiBKGItem(block);
                                            bkg.mLocation = new Point((double) jsonData.optInt("x"), (double) jsonData.optInt("y"));
                                            bkg.mName = jsonData.optString("name");
                                            bkg.mUid = jsonData.optString("uid");
                                            bkg.mTel = jsonData.optString(SearchParamKey.TEL);
                                            bkg.mAddr = jsonData.optString(GeoPointInfo.KEY_ADDR);
                                            bkg.indoor_pano = jsonData.optString(SearchParamKey.INDOOR_PANO);
                                            bkg.pano = jsonData.optInt(SearchParamKey.PANO);
                                            JSONObject midbundle = jsonData.optJSONObject("place");
                                            if (midbundle != null) {
                                                bkg.placeParam.put(Const.SRC_NAME, midbundle.optString(Const.SRC_NAME));
                                                bkg.placeParam.put("overall_rating", midbundle.optString("overall_rating"));
                                                bkg.placeParam.put("image", midbundle.optString("image"));
                                                bkg.placeParam.put(SearchParamKey.PRICE, midbundle.optString(SearchParamKey.PRICE));
                                                bkg.placeParam.put("tag", midbundle.optString("tag"));
                                                bkg.placeParam.put("premium_flag", midbundle.optString("premium_flag"));
                                                bkg.placeParam.put("comment_num", midbundle.optString("comment_num"));
                                                bkg.placeParam.put("groupon_flag", midbundle.optString("groupon_flag"));
                                                if (midbundle.optString("wap_bookable") != null) {
                                                    bkg.placeParam.put("wap_bookable", midbundle.optString("wap_bookable"));
                                                }
                                                if (midbundle.optString("wise_fullroom") != null) {
                                                    bkg.placeParam.put("wise_fullroom", midbundle.optString("wise_fullroom"));
                                                }
                                            }
                                            block.mItemList.add(bkg);
                                        }
                                    }
                                }
                                result.mBlockList.add(block);
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean parseStringToShareUrlResult(String strRst, ShareUrlResult result) {
        if (strRst == null) {
            return false;
        }
        try {
            if (strRst.equals("") || result == null) {
                return false;
            }
            JSONObject jsonRoot = new JSONObject(strRst);
            result.mResultType = jsonRoot.optInt("result_type");
            result.mUrl = jsonRoot.optString("url");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean parseStringToSuggestionResult(String strRst, SugResult result) {
        if (strRst == null) {
            return false;
        }
        try {
            if (strRst.equals("") || result == null) {
                return false;
            }
            JSONObject jsonObject = new JSONObject(strRst);
            result.mResultType = jsonObject.optInt("result_type");
            result.keyword = jsonObject.optString("keyword");
            result.ispinyin = jsonObject.optBoolean("ispinyin", false);
            result.type = jsonObject.optInt("type");
            JSONArray poiname = jsonObject.optJSONArray("poiname");
            JSONArray subtitle = jsonObject.optJSONArray("subtitle");
            JSONArray cityid = jsonObject.optJSONArray("cityid");
            if (poiname != null && poiname.length() > 0) {
                int length = poiname.length();
                String[] strPoiname = new String[length];
                String[] strSubtitle = new String[length];
                String[] strCityid = new String[length];
                for (int index = 0; index < length; index++) {
                    strPoiname[index] = poiname.optString(index);
                    if (subtitle != null && subtitle.length() > 0) {
                        strSubtitle[index] = subtitle.optString(index);
                    }
                    strCityid[index] = cityid.optString(index);
                }
                result.setPoiname(strPoiname);
                result.setSubtitle(strSubtitle);
                result.setCityid(strCityid);
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public static boolean parseStringToAddrResult(MessageMicro dataresult, AddrResult result) {
        if (dataresult == null || !(dataresult instanceof ReverseGeocoding)) {
            return false;
        }
        ReverseGeocoding reverseGeocoding = (ReverseGeocoding) dataresult;
        if (result == null) {
            result = new AddrResult();
        }
        result.address = reverseGeocoding.getAddress();
        result.floorId = reverseGeocoding.getFloor();
        result.buildingId = reverseGeocoding.getBuildId();
        result.nearby = reverseGeocoding.getNearby();
        AddressDetail addressDetail = reverseGeocoding.getAddressDetail();
        if (addressDetail != null) {
            result.getClass();
            result.addressDetail = new AddrResult.AddressDetail(result);
            result.addressDetail.country = addressDetail.getCountry();
            result.addressDetail.countryCode = addressDetail.getCountryCode();
            result.addressDetail.cityCode = addressDetail.getCityCode();
            result.addressDetail.cityName = addressDetail.getCity();
            result.addressDetail.district = addressDetail.getDistrict();
            result.addressDetail.province = addressDetail.getProvince();
            result.addressDetail.street = addressDetail.getStreet();
            result.addressDetail.streetNum = addressDetail.getStreetNumber();
        } else {
            result.getClass();
            result.addressDetail = new AddrResult.AddressDetail(result);
            result.addressDetail.country = "";
            result.addressDetail.countryCode = 0;
            result.addressDetail.cityCode = 0;
            result.addressDetail.cityName = "";
            result.addressDetail.district = "";
            result.addressDetail.province = "";
            result.addressDetail.street = "";
            result.addressDetail.streetNum = "";
        }
        result.pano = reverseGeocoding.getPano();
        result.streetId = reverseGeocoding.getStreetScapeID();
        result.business = reverseGeocoding.getBusiness();
        com.baidu.entity.pb.Point point = reverseGeocoding.getPoint();
        if (point != null) {
            result.setPoint(new Point((double) point.getX(), (double) point.getY()));
        }
        if (result.getSurround_poi() != null) {
            result.getSurround_poi().clear();
        }
        List<SurroundPoi> surroundPois = reverseGeocoding.getSurroundPoiList();
        if (!(surroundPois == null || surroundPois.isEmpty())) {
            for (int i = 0; i < surroundPois.size(); i++) {
                result.getClass();
                GeoPoiInfo geoinfo = new GeoPoiInfo(result);
                SurroundPoi info = (SurroundPoi) surroundPois.get(i);
                geoinfo.distance = info.getDistance();
                geoinfo.addr = info.getAddr();
                geoinfo.uid = info.getUid();
                geoinfo.floorId = info.getFloorId();
                geoinfo.buildingId = info.getBuildingId();
                geoinfo.name = info.getName();
                geoinfo.pano = info.getPano();
                geoinfo.indoorPano = info.getIndoorPano();
                com.baidu.entity.pb.Point pt = info.getPoint();
                if (pt != null) {
                    geoinfo.setPoint(new Point((double) pt.getX(), (double) pt.getY()));
                }
                geoinfo.tag = info.getTag();
                result.setSurround_poi(geoinfo);
            }
        }
        return true;
    }

    public static boolean parseStringToPoiDetailResult(String strRst, PoiDetailInfo result) {
        if (strRst != null) {
            try {
                if (!(strRst.equals("") || result == null)) {
                    int i;
                    JSONObject bundle = new JSONObject(strRst);
                    JSONObject mid = bundle.optJSONObject("baseinfo");
                    result.mResultType = bundle.optInt("result_type");
                    result.geo = new Point(0.0d, 0.0d);
                    Point pt = CoordinateUtil.geoStringToPoint(mid.optString("geo"));
                    result.geo.setTo(pt.getDoubleX(), pt.getDoubleY());
                    if (mid.has("point")) {
                        JSONObject point = mid.getJSONObject("point");
                        result.geo.setTo((double) point.optInt("x"), (double) point.optInt("y"));
                    }
                    result.name = mid.optString("name");
                    result.type = mid.optInt("type");
                    result.uid = mid.optString("uid");
                    result.addr = mid.optString(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS);
                    result.tel = mid.optString(SearchParamKey.TEL);
                    result.zip = mid.optString("zip");
                    result.cityId = mid.optInt("cityid");
                    result.distance = (long) mid.optInt("distance");
                    result.pano = bundle.optInt(SearchParamKey.PANO);
                    result.indoor_pano = bundle.optString(SearchParamKey.INDOOR_PANO);
                    JSONArray pacelitem = mid.optJSONArray("buslines");
                    if (pacelitem != null) {
                        ArrayList<BusLine> arrayBusLine = new ArrayList();
                        for (i = 0; i < pacelitem.length(); i++) {
                            JSONObject test = pacelitem.optJSONObject(i);
                            result.getClass();
                            BusLine busLine = new BusLine(result);
                            busLine.addr = test.optString(GeoPointInfo.KEY_ADDR);
                            busLine.name = test.optString("name");
                            busLine.uid = test.optString("uid");
                            JSONObject jsRtInfo = test.optJSONObject("rt_info");
                            if (jsRtInfo != null) {
                                jsRtInfo.optJSONObject("next_vehicle");
                            }
                            arrayBusLine.add(busLine);
                        }
                        result.setArrayBuslines(arrayBusLine);
                    }
                    JSONObject jsonObj = bundle.optJSONObject("deepdetail");
                    if (jsonObj != null) {
                        DetailInfo detailInfo;
                        JSONObject pacelitemJson1;
                        Lines lines;
                        result.getClass();
                        DeepDetail deepDetail = new DeepDetail(result);
                        deepDetail.type = jsonObj.optInt("type");
                        JSONArray pacelitem1 = jsonObj.optJSONArray("detailinfos");
                        if (pacelitem1 != null) {
                            ArrayList<DetailInfo> arrayInfos = new ArrayList();
                            for (i = 0; i < pacelitem1.length(); i++) {
                                result.getClass();
                                detailInfo = new DetailInfo(result);
                                pacelitemJson1 = pacelitem1.optJSONObject(i);
                                detailInfo.title = pacelitemJson1.optString("title");
                                detailInfo.value = pacelitemJson1.optString("value");
                                arrayInfos.add(detailInfo);
                            }
                            deepDetail.detailInfos = arrayInfos;
                        }
                        pacelitem1 = jsonObj.optJSONArray("titlelinks");
                        if (pacelitem1 != null) {
                            ArrayList<DetailInfo> arrayInfos2 = new ArrayList();
                            for (i = 0; i < pacelitem1.length(); i++) {
                                result.getClass();
                                detailInfo = new DetailInfo(result);
                                pacelitemJson1 = pacelitem1.optJSONObject(i);
                                detailInfo.title = pacelitemJson1.optString("title");
                                detailInfo.value = pacelitemJson1.optString("value");
                                arrayInfos2.add(detailInfo);
                            }
                            deepDetail.titleLinks = arrayInfos2;
                        }
                        JSONArray jsonArray = jsonObj.optJSONArray("piclinks");
                        if (jsonArray != null && jsonArray.length() > 0) {
                            deepDetail.picLinks = new String[jsonArray.length()];
                            for (i = 0; i < jsonArray.length(); i++) {
                                deepDetail.picLinks[i] = jsonArray.optString(i);
                            }
                        }
                        deepDetail.price = jsonObj.optString(SearchParamKey.PRICE);
                        pacelitem1 = jsonObj.optJSONArray("housearos");
                        if (pacelitem1 != null) {
                            ArrayList<DetailInfo> arrayInfos3 = new ArrayList();
                            for (i = 0; i < pacelitem1.length(); i++) {
                                result.getClass();
                                detailInfo = new DetailInfo(result);
                                pacelitemJson1 = pacelitem1.optJSONObject(i);
                                detailInfo.title = pacelitemJson1.optString("title");
                                detailInfo.value = pacelitemJson1.optString("value");
                                arrayInfos3.add(detailInfo);
                            }
                            deepDetail.housearos = arrayInfos3;
                        }
                        pacelitem1 = jsonObj.optJSONArray("lines");
                        if (pacelitem1 != null) {
                            ArrayList<Lines> arrayInfos1 = new ArrayList();
                            for (i = 0; i < pacelitem1.length(); i++) {
                                result.getClass();
                                lines = new Lines(result);
                                pacelitemJson1 = pacelitem1.optJSONObject(i);
                                lines.firstTime = pacelitemJson1.optString("firsttime");
                                lines.lastTime = pacelitemJson1.optString("lasttime");
                                lines.name = pacelitemJson1.optString("name");
                                lines.terminal = pacelitemJson1.optString("terminal");
                                lines.uid = pacelitemJson1.optString("uid");
                                lines.abb = pacelitemJson1.optString("abb");
                                try {
                                    lines.clr = pacelitem1.optJSONObject(i).optString("clr").replace("0x", "#");
                                } catch (Exception e) {
                                } catch (RuntimeException e2) {
                                    return false;
                                }
                                arrayInfos1.add(lines);
                            }
                            deepDetail.lines = arrayInfos1;
                        }
                        pacelitem1 = jsonObj.optJSONArray("aroundinfos");
                        if (pacelitem1 != null) {
                            ArrayList<ArroundInfos> arrayInfos22 = new ArrayList();
                            for (i = 0; i < pacelitem1.length(); i++) {
                                result.getClass();
                                lines = new ArroundInfos(result);
                                pacelitemJson1 = pacelitem1.optJSONObject(i);
                                lines.bsInfo = pacelitemJson1.optString("bsinfo");
                                lines.exitName = pacelitemJson1.optString("exitname");
                                lines.exitRound = pacelitemJson1.optString("exitround");
                                arrayInfos22.add(lines);
                            }
                            deepDetail.arroundInfos = arrayInfos22;
                        }
                        JSONObject midPlacebundle = jsonObj.optJSONObject("place");
                        if (midPlacebundle != null) {
                            deepDetail.placeParam.put(Const.SRC_NAME, jsonObj.optString(Const.SRC_NAME));
                            deepDetail.placeParam.put("overall_rating", midPlacebundle.optString("overall_rating"));
                            deepDetail.placeParam.put("image", midPlacebundle.optString("image"));
                            deepDetail.placeParam.put(SearchParamKey.PRICE, midPlacebundle.optString(SearchParamKey.PRICE));
                            deepDetail.placeParam.put("tag", midPlacebundle.optString("tag"));
                            deepDetail.placeParam.put("premium_flag", midPlacebundle.optString("premium_flag"));
                            deepDetail.placeParam.put("comment_num", midPlacebundle.optString("comment_num"));
                            deepDetail.placeParam.put("groupon_flag", midPlacebundle.optString("groupon_flag"));
                            if (midPlacebundle.optString("groupon_total") != null) {
                                deepDetail.placeParam.put("groupon_total", midPlacebundle.optString("groupon_total"));
                            }
                            if (midPlacebundle.optString("wise_realtime_price_flag") != null) {
                                deepDetail.placeParam.put("wise_realtime_price_flag", midPlacebundle.optString("wise_realtime_price_flag"));
                            }
                            if (midPlacebundle.optString("wise_realtime_price") != null) {
                                deepDetail.placeParam.put("wise_realtime_price", midPlacebundle.optString("wise_realtime_price"));
                            }
                            if (midPlacebundle.optString("wise_hotel_type") != null) {
                                deepDetail.placeParam.put("wise_hotel_type", midPlacebundle.optString("wise_hotel_type"));
                            }
                            if (midPlacebundle.optString("tonight_sale_flag") != null) {
                                deepDetail.placeParam.put("tonight_sale_flag", midPlacebundle.optString("tonight_sale_flag"));
                            }
                            if (midPlacebundle.optString("tonight_price") != null) {
                                deepDetail.placeParam.put("tonight_price", midPlacebundle.optString("tonight_price"));
                            }
                            if (midPlacebundle.optString("wap_bookable") != null) {
                                deepDetail.placeParam.put("wap_bookable", midPlacebundle.optString("wap_bookable"));
                            }
                            if (midPlacebundle.optString("wise_fullroom") != null) {
                                deepDetail.placeParam.put("wise_fullroom", midPlacebundle.optString("wise_fullroom"));
                            }
                            JSONArray array = midPlacebundle.optJSONArray("flag");
                            if (array != null && array.length() > 0) {
                                ArrayList<String> arrayList = new ArrayList();
                                for (int index = 0; index < array.length(); index++) {
                                    arrayList.add(array.getString(index));
                                }
                                deepDetail.placeParam.put("flag", arrayList);
                            }
                        }
                        result.setDeepDetail(deepDetail);
                    }
                    return true;
                }
            } catch (RuntimeException e22) {
                return false;
            } catch (Exception e3) {
                return false;
            }
        }
        return false;
    }

    public static boolean parseStringToCityListResult(String strRst, CityListResult result) {
        if (strRst == null) {
            return false;
        }
        try {
            if (strRst.equals("") || result == null) {
                return false;
            }
            JSONObject bundle = new JSONObject(strRst);
            result.mResultType = bundle.optInt("result_type");
            result.setCityCount(bundle.optInt("count"));
            result.mCurrent_null = bundle.optBoolean("current_null");
            JSONObject mid = bundle.optJSONObject("current_city");
            CityInfo pCity = new CityInfo();
            pCity.mCityType = mid.optInt("type");
            pCity.mCityCode = mid.optInt("code");
            pCity.mCityName = mid.optString("name");
            pCity.mLevel = mid.optInt("level");
            pCity.mCityUid = mid.optString("uid");
            pCity.mSup_bus = mid.optBoolean("sup_bus");
            pCity.mSup_lukuang = mid.optBoolean("sup_lukuang");
            pCity.mSup_subway = mid.optBoolean("sup_subway");
            pCity.mCityGeo = CoordinateUtil.geoStringToPoint(mid.optString("geo"));
            result.setCityinfo(pCity);
            JSONArray pacelitem = bundle.optJSONArray("citys");
            if (pacelitem != null) {
                ArrayList<Citys> arrayCitys = new ArrayList();
                for (int i = 0; i < pacelitem.length(); i++) {
                    JSONObject test = pacelitem.optJSONObject(i);
                    result.getClass();
                    Citys info = new Citys(result);
                    info.mCode = test.optInt("code");
                    info.mNum = test.optInt("num");
                    info.mName = test.optString("name");
                    arrayCitys.add(info);
                }
                result.setCitys(arrayCitys);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean parseStringToCityInfoResult(String strRst, CityInfo result) {
        if (strRst == null) {
            return false;
        }
        try {
            if (strRst.equals("") || result == null) {
                return false;
            }
            JSONObject curCity;
            JSONObject bundle = new JSONObject(strRst);
            result.mResultType = bundle.optInt("result_type");
            result.mCityType = bundle.optInt("type");
            if (result.mResultType == 4) {
                result.mCityCode = bundle.optInt("code");
                result.mCityName = bundle.optString("name");
            }
            if (result.mResultType == 2) {
                curCity = bundle.optJSONObject("current_city");
                if (curCity != null) {
                    result.mCityCode = curCity.optInt("code");
                    result.mCityName = curCity.optString("name");
                }
            }
            result.mcName = bundle.optString("name");
            result.mLevel = bundle.optInt("level");
            result.mCityUid = bundle.optString("uid");
            result.mSup_bus = bundle.optBoolean("sup_bus");
            result.mSup_subway = bundle.optBoolean("sup_subway");
            result.mSup_lukuang = bundle.optBoolean("sup_lukuang");
            curCity = bundle.optJSONObject("current_city");
            if (curCity != null) {
                result.mCityGeo = CoordinateUtil.geoStringToPoint(curCity.optString("geo"));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean parseStringToRTBusResult(String strRst, RTBusResult result) {
        if (strRst != null) {
            try {
                if (!(strRst.equals("") || result == null)) {
                    JSONObject jsonObject = new JSONObject(strRst);
                    JSONObject jsonResult = jsonObject.optJSONObject("result");
                    if (jsonResult != null) {
                        result.getClass();
                        result.result = new Result(result);
                        result.result.error = jsonResult.optInt(ParamKey.KEY_MSG_ERRORS);
                        result.result.has_rtbus = jsonResult.optInt("has_rtbus");
                    }
                    JSONObject jsonContent = jsonObject.optJSONObject("content");
                    if (jsonContent != null) {
                        result.getClass();
                        result.content = new Content(result);
                        result.content.rtbus_nu = jsonContent.optInt("rtbus_nu");
                        result.content.rtbus_update_time = jsonContent.optInt("rtbus_update_time");
                        result.content.rtbusVersion = jsonContent.optInt("rtbus_version");
                        JSONArray stations = jsonContent.optJSONArray("stations");
                        result.content.stations = new ArrayList();
                        if (stations != null) {
                            for (int i = 0; i < stations.length(); i++) {
                                JSONObject stationJson = stations.optJSONObject(i);
                                if (stationJson != null) {
                                    result.getClass();
                                    Station station = new Station(result);
                                    station.name = stationJson.optString("name");
                                    station.tip_rtbus = stationJson.optString("tip_rtbus");
                                    station.uid = stationJson.optString("uid");
                                    station.imageTipRtbus = stationJson.optString("image_tip_rtbus", "");
                                    station.getClass();
                                    Line line = new Line(station);
                                    JSONObject lineJson = stationJson.optJSONObject("line");
                                    if (lineJson != null) {
                                        line.name = lineJson.optString("name");
                                        line.uid = lineJson.optString("uid");
                                        line.rawName = lineJson.optString("raw_name");
                                        station.line = line;
                                    }
                                    station.getClass();
                                    NextBusInfo busInfo = new NextBusInfo(station);
                                    JSONObject busInfoJson = stationJson.optJSONObject("next_bus_info");
                                    if (busInfoJson != null) {
                                        busInfo.remain_dist = busInfoJson.optInt(SimpleGuideInfo.RemainDist);
                                        busInfo.remain_stops = busInfoJson.optInt("remain_stops");
                                        busInfo.remain_time = busInfoJson.optInt("remain_time");
                                        busInfo.f19867x = busInfoJson.optInt("x");
                                        busInfo.f19868y = busInfoJson.optInt("y");
                                        busInfo.spath = new ArrayList();
                                        JSONArray jsonArray = busInfoJson.optJSONArray("spath");
                                        for (int k = 0; k < jsonArray.length(); k++) {
                                            busInfo.spath.add(Integer.valueOf(jsonArray.optInt(k)));
                                        }
                                        station.nextBusInfo = busInfo;
                                    }
                                    result.content.stations.add(station);
                                }
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
