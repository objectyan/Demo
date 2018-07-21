package com.baidu.navi.track.model;

import com.baidu.carlife.core.e;
import com.baidu.carlife.util.c;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;

public class TrackSyncRequestModel
{
  public String actionType;
  public String appVer;
  public String bduss;
  public String channel;
  public String createTime;
  public String cuid;
  public String dataVersion;
  public String distance;
  public String duration;
  public String endPosition;
  public String fileSign;
  public String guid;
  public String guidList;
  public String imei;
  public String isConn;
  public String isResponse;
  public String loc;
  public String mCuid;
  public String maxSpeed;
  public String mb;
  public String name;
  public String orbtisStatus;
  public String os;
  public String osVersion;
  public String sign;
  public String speed;
  public String startPosition;
  public String startTime;
  public String trackFilePath;
  public String type;
  public String uid;
  public String updateTime;
  public String uploadTime;
  public String version;
  
  public String toString()
  {
    return "TrackSyncRequestModel [isResponse=" + this.isResponse + ", actionType=" + this.actionType + ", cuid=" + this.cuid + ", channel" + this.channel + ", version=" + this.version + ", os=" + this.os + ", mb=" + this.mb + ", mCuid=" + this.mCuid + ", appVer=" + this.appVer + ", loc=" + this.loc + ", isConn" + this.isConn + ", imei" + this.imei + ", osVersion=" + this.osVersion + ", bduss" + this.bduss + ", uid" + this.uid + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", orbtisStatus=" + this.orbtisStatus + ", guid=" + this.guid + ", name=" + this.name + ", distance=" + this.distance + ", startTime=" + this.startTime + ", duration=" + this.duration + ", speed=" + this.speed + ", maxSpeed" + this.maxSpeed + ", type=" + this.type + ", dataVersion" + this.dataVersion + ", uploadTime" + this.uploadTime + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + ", fileSign=" + this.fileSign + ", sign=" + this.sign + ", trackFilePath" + this.trackFilePath + ", guidList" + this.guidList + "]";
  }
  
  public void updatePhoneInfo()
  {
    this.mCuid = c.b();
    this.os = "android";
    this.appVer = e.g();
    this.osVersion = e.i();
    this.imei = e.b();
    this.mb = e.j();
    this.loc = (GeoLocateModel.getInstance().getCurrentDistrict().mId + "");
    this.bduss = NaviAccountUtils.getInstance().syncGetBduss();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/model/TrackSyncRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */