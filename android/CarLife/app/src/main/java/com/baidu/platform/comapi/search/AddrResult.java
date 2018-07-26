package com.baidu.platform.comapi.search;

import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.protocol.model.GeoPointInfo;
import com.baidu.navi.track.sync.SyncChannelConstant.Key;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddrResult implements ResultBase {
    public String address;
    public AddressDetail addressDetail;
    public String buildingId;
    public String business;
    public String floorId;
    public String indoorPano;
    public String nearby;
    public int pano;
    private Point point;
    private int requestId;
    public String streetId;
    private ArrayList<GeoPoiInfo> surround_poi;

    public class AddressDetail {
        public int cityCode;
        public String cityName;
        public String country;
        public int countryCode;
        public String district;
        public String province;
        public String street;
        public String streetNum;
    }

    public class GeoPoiInfo {
        public String addr;
        public String buildingId;
        public double distance;
        public String floorId;
        public String indoorPano;
        public String name;
        public int pano;
        private Point point;
        public String tag;
        public String tel;
        public String uid;

        void setPoint(Point point) {
            this.point = point;
        }

        public Point getPoint() {
            return this.point;
        }
    }

    public ArrayList<GeoPoiInfo> getSurround_poi() {
        return this.surround_poi;
    }

    void setSurround_poi(ArrayList<GeoPoiInfo> surround_poi) {
        this.surround_poi = surround_poi;
    }

    void setSurround_poi(GeoPoiInfo geoPoi) {
        if (this.surround_poi == null) {
            this.surround_poi = new ArrayList();
        }
        this.surround_poi.add(geoPoi);
    }

    public GeoPoiInfo getSurround_poi(int index) {
        if (this.surround_poi.size() > index) {
            return (GeoPoiInfo) this.surround_poi.get(index);
        }
        return null;
    }

    public Point getPoint() {
        return this.point;
    }

    void setPoint(Point point) {
        this.point = point;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public String toJson() {
        JSONObject content = new JSONObject();
        try {
            content.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, this.address);
            content.put(SearchParamKey.PANO, this.pano);
            content.put(Key.BUSINESS, this.business);
            content.put("id", this.streetId);
            content.put("floor", this.floorId);
            content.put("build_id", this.buildingId);
            content.put("nearby", this.nearby);
            JSONObject point = new JSONObject();
            point.put("x", this.point.getIntX());
            point.put("y", this.point.getIntY());
            content.put("point", point);
            JSONObject addrDetail = new JSONObject();
            addrDetail.put("city_code", this.addressDetail.cityCode);
            addrDetail.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY, this.addressDetail.cityName);
            addrDetail.put("district", this.addressDetail.district);
            addrDetail.put("province", this.addressDetail.province);
            addrDetail.put("street", this.addressDetail.street);
            addrDetail.put("street_number", this.addressDetail.streetNum);
            content.put("addr_detail", addrDetail);
            if (!(getSurround_poi() == null || getSurround_poi().isEmpty())) {
                JSONArray pois = new JSONArray();
                for (int i = 0; i < getSurround_poi().size(); i++) {
                    JSONObject poi = new JSONObject();
                    GeoPoiInfo info = getSurround_poi(i);
                    poi.put(GeoPointInfo.KEY_ADDR, info.addr);
                    poi.put("uid", info.uid);
                    poi.put("floor", info.floorId);
                    poi.put("build_id", info.buildingId);
                    poi.put("name", info.name);
                    poi.put(SearchParamKey.PANO, info.pano);
                    poi.put(SearchParamKey.INDOOR_PANO, info.indoorPano);
                    poi.put("distance", info.distance);
                    poi.put("tag", info.tag);
                    JSONObject pt = new JSONObject();
                    pt.put("x", info.getPoint().getIntX());
                    pt.put("y", info.getPoint().getIntY());
                    poi.put("point", pt);
                    pois.put(poi);
                }
                content.put("surround_poi", pois);
            }
        } catch (JSONException e) {
        }
        return content.toString();
    }
}
