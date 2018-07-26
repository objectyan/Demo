package com.baidu.navisdk.module.ugc.data.datastatus;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.net.URLEncoder;
import java.text.NumberFormat;

public class UgcReportInfoUploadPackage {
    public int businessTrigger = 1;
    public int cityId = -1;
    public String cityName = null;
    public String contact = "";
    public String content = null;
    public String cuid = null;
    public int detailPosition = -1;
    public int detailType = -1;
    public String endName = null;
    public String endPoint = null;
    public String fromName = null;
    public String fromPoint = "";
    public String fromUid = null;
    public String guid = null;
    public int id = -1;
    public int isChange = 0;
    public boolean isInSubView = false;
    public int lanePosition = -1;
    public int laneType = -1;
    public String linkid = null;
    public GeoPoint mGeoPoint;
    public int mainPosition = -1;
    public int mark = -1;
    public String mrsl = null;
    public String name = null;
    public int os = 0;
    public String osv = null;
    public int parentType = -1;
    public String photoPicPath = null;
    public String photoPoint = null;
    public String point = null;
    public int recordTime = -1;
    public String roadName = null;
    public String screenshotPicPath = null;
    public String sessionId = null;
    public int speedLimit = -1;
    public String startName = null;
    public String startPoint = null;
    public int subPosition = -1;
    public int subType = -1;
    public int supply = 0;
    public String sv = null;
    public String toName = null;
    public String toPoint = null;
    public String toUid = null;
    public String userPoint = null;
    public String voicePath = null;

    private void formatInfo() {
        this.userPoint = formatPoint(this.userPoint);
        this.point = formatPoint(this.point);
        this.guid = formatStr(this.guid);
        this.content = formatUTF8Encode(this.content);
        this.photoPoint = formatPoint(this.photoPoint);
        this.roadName = formatUTF8Encode(this.roadName);
        this.osv = formatStr(this.osv);
        this.sv = formatStr(this.sv);
        this.cuid = formatStr(this.cuid);
        this.name = formatUTF8Encode(this.name);
        this.sessionId = formatStr(this.sessionId);
        this.mrsl = formatStr(this.mrsl);
        this.fromName = formatUTF8Encode(this.fromName);
        this.toPoint = formatPoint(this.toPoint);
        this.fromUid = formatStr(this.fromUid);
        this.cityName = formatUTF8Encode(this.cityName);
        this.toUid = formatStr(this.toUid);
        this.toName = formatUTF8Encode(this.toName);
        this.startPoint = formatPoint(this.startPoint);
        this.endPoint = formatPoint(this.endPoint);
        this.startName = formatUTF8Encode(this.startName);
        this.endName = formatUTF8Encode(this.endName);
        this.linkid = formatStr(this.linkid);
    }

    public static UgcReportInfoUploadPackage getNewFormatPackage(UgcReportInfoUploadPackage infoPackage) {
        UgcReportInfoUploadPackage newInfoPackage = copy(infoPackage);
        if (newInfoPackage == null) {
            return null;
        }
        newInfoPackage.formatInfo();
        return newInfoPackage;
    }

    private static UgcReportInfoUploadPackage copy(UgcReportInfoUploadPackage oldPackage) {
        if (oldPackage == null) {
            return null;
        }
        UgcReportInfoUploadPackage copyPackage = new UgcReportInfoUploadPackage();
        copyPackage.id = oldPackage.id;
        copyPackage.userPoint = oldPackage.userPoint;
        copyPackage.point = oldPackage.point;
        copyPackage.businessTrigger = oldPackage.businessTrigger;
        copyPackage.parentType = oldPackage.parentType;
        copyPackage.subType = oldPackage.subType;
        copyPackage.guid = oldPackage.guid;
        copyPackage.content = oldPackage.content;
        copyPackage.photoPicPath = oldPackage.photoPicPath;
        copyPackage.photoPoint = oldPackage.photoPoint;
        copyPackage.roadName = oldPackage.roadName;
        copyPackage.isChange = oldPackage.isChange;
        copyPackage.contact = oldPackage.contact;
        copyPackage.voicePath = oldPackage.voicePath;
        copyPackage.os = oldPackage.os;
        copyPackage.osv = oldPackage.osv;
        copyPackage.sv = oldPackage.sv;
        copyPackage.cuid = oldPackage.cuid;
        copyPackage.name = oldPackage.name;
        copyPackage.sessionId = oldPackage.sessionId;
        copyPackage.mrsl = oldPackage.mrsl;
        copyPackage.fromName = oldPackage.fromName;
        copyPackage.fromPoint = oldPackage.fromPoint;
        copyPackage.toPoint = oldPackage.toPoint;
        copyPackage.fromUid = oldPackage.fromUid;
        copyPackage.cityId = oldPackage.cityId;
        copyPackage.cityName = oldPackage.cityName;
        copyPackage.toUid = oldPackage.toUid;
        copyPackage.toName = oldPackage.toName;
        copyPackage.screenshotPicPath = oldPackage.screenshotPicPath;
        copyPackage.laneType = oldPackage.laneType;
        copyPackage.detailType = oldPackage.detailType;
        copyPackage.speedLimit = oldPackage.speedLimit;
        copyPackage.startPoint = oldPackage.startPoint;
        copyPackage.endPoint = oldPackage.endPoint;
        copyPackage.startName = oldPackage.startName;
        copyPackage.endName = oldPackage.endName;
        copyPackage.mark = oldPackage.mark;
        copyPackage.supply = oldPackage.supply;
        copyPackage.linkid = oldPackage.linkid;
        return copyPackage;
    }

    private String formatUTF8Encode(String str) {
        String ret = "";
        if (str != null) {
            try {
                ret = URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    private String formatStr(String str) {
        return str == null ? "" : str;
    }

    public void clearInfo() {
        this.id = -1;
        this.userPoint = null;
        this.point = null;
        this.businessTrigger = 1;
        this.parentType = -1;
        this.subType = -1;
        this.guid = null;
        this.content = null;
        this.photoPicPath = null;
        this.photoPoint = null;
        this.roadName = null;
        this.isChange = 0;
        this.contact = "";
        this.voicePath = null;
        this.os = 0;
        this.osv = null;
        this.sv = null;
        this.cuid = null;
        this.name = null;
        this.sessionId = null;
        this.mrsl = null;
        this.fromName = null;
        this.fromPoint = "";
        this.toPoint = null;
        this.fromUid = null;
        this.cityId = -1;
        this.cityName = null;
        this.toUid = null;
        this.toName = null;
        this.screenshotPicPath = null;
        this.laneType = -1;
        this.detailType = -1;
        this.speedLimit = -1;
        this.startPoint = null;
        this.endPoint = null;
        this.startName = null;
        this.endName = null;
        this.mark = -1;
        this.supply = 0;
        this.linkid = null;
        this.mGeoPoint = null;
        this.isInSubView = false;
    }

    public void showLog(String flag) {
        LogUtil.m15791e(flag + ":UgcReportInfoUploadPackage", "parentType:" + this.parentType + "laneType:" + this.laneType + "detailType" + this.detailType + "os:" + this.os + "cuid" + this.cuid);
    }

    private String formatPoint(String point) {
        if (TextUtils.isEmpty(point)) {
            return "";
        }
        String retPoint = null;
        Double retX = Double.valueOf(0.0d);
        Double retY = Double.valueOf(0.0d);
        int i = point.indexOf(",");
        if (i > 0 && i < point.length() - 1) {
            String xStr = point.substring(0, i);
            String yStr = point.substring(i + 1, point.length());
            try {
                retX = Double.valueOf(Double.parseDouble(xStr));
                retY = Double.valueOf(Double.parseDouble(yStr));
                NumberFormat nf = NumberFormat.getInstance();
                nf.setGroupingUsed(false);
                retPoint = nf.format(retX) + "," + nf.format(retY);
            } catch (Exception e) {
            }
        }
        if (retPoint == null) {
            return point;
        }
        return retPoint;
    }
}
