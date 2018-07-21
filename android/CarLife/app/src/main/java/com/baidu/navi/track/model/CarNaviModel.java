package com.baidu.navi.track.model;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.navi.track.TrackCarDataSolveModel;
import com.baidu.navisdk.util.common.SysOSAPI;

public class CarNaviModel
{
  private CarNavi carNavi;
  private String car_channel;
  private String car_cuid;
  private String car_version;
  private boolean isConnect;
  private String sdcard_path;
  private int sync_state;
  private String useId;
  
  public CarNaviModel()
  {
    setPBData(new CarNavi());
    setCarCuid(TrackCarDataSolveModel.carCUID);
    setCarChannel(TrackCarDataSolveModel.carChannel);
    setCarVersion(TrackCarDataSolveModel.carVersion);
    setIsConnect(TrackCarDataSolveModel.isConnect);
    setUseId(NavMapAdapter.getInstance().getUid());
    setSDcardPath(SysOSAPI.getInstance().GetSDCardPath() + "/trajectory");
  }
  
  public void cleanCarInfo()
  {
    setCarCuid("");
    setCarChannel("");
    setCarVersion("");
    setIsConnect(false);
    setUseId("");
    setSDcardPath("");
  }
  
  public CarNaviModel clone()
  {
    CarNaviModel localCarNaviModel = new CarNaviModel();
    localCarNaviModel.setCarCuid(getCarCuid());
    localCarNaviModel.setCarChannel(getCarChannel());
    localCarNaviModel.setCarVersion(getCarVersion());
    localCarNaviModel.setIsConnect(isConnect());
    localCarNaviModel.setUseId(getUseId());
    localCarNaviModel.setSDcardPath(getSDcardPath());
    localCarNaviModel.setSyncState(getSyncState());
    if (getPBData() == null)
    {
      localCarNaviModel.setPBData(null);
      return localCarNaviModel;
    }
    CarNavi localCarNavi1 = getPBData();
    CarNavi localCarNavi2 = new CarNavi();
    if (localCarNavi1.hasSid()) {
      localCarNavi2.setSid(localCarNavi1.getSid());
    }
    if (localCarNavi1.hasGuid()) {
      localCarNavi2.setGuid(localCarNavi1.getGuid());
    }
    if (localCarNavi1.hasType()) {
      localCarNavi2.setType(localCarNavi1.getType());
    }
    if (localCarNavi1.hasAvgSpeed()) {
      localCarNavi2.setAvgSpeed(localCarNavi1.getAvgSpeed());
    }
    if (localCarNavi1.hasDistance()) {
      localCarNavi2.setDistance(localCarNavi1.getDistance());
    }
    if (localCarNavi1.hasMaxSpeed()) {
      localCarNavi2.setMaxSpeed(localCarNavi1.getMaxSpeed());
    }
    if (localCarNavi1.hasCtime()) {
      localCarNavi2.setCtime(localCarNavi1.getCtime());
    }
    if (localCarNavi1.hasModifyTtime()) {
      localCarNavi2.setModifyTime(localCarNavi1.getModifyTime());
    }
    if (localCarNavi1.hasDuration()) {
      localCarNavi2.setDuration(localCarNavi1.getDuration());
    }
    if (localCarNavi1.hasSign()) {
      localCarNavi2.setSign(localCarNavi1.getSign());
    }
    if (localCarNavi1.hasStartPoint()) {
      localCarNavi2.setStartPoint(localCarNavi1.getStartPoint());
    }
    if (localCarNavi1.hasEndPoint()) {
      localCarNavi2.setEndPoint(localCarNavi1.getEndPoint());
    }
    localCarNaviModel.setPBData(localCarNavi2);
    return localCarNaviModel;
  }
  
  public String getCarChannel()
  {
    return this.car_channel;
  }
  
  public String getCarCuid()
  {
    return this.car_cuid;
  }
  
  public String getCarVersion()
  {
    return this.car_version;
  }
  
  public CarNavi getPBData()
  {
    return this.carNavi;
  }
  
  public String getSDcardPath()
  {
    return this.sdcard_path;
  }
  
  public int getSyncState()
  {
    return this.sync_state;
  }
  
  public String getUseId()
  {
    return this.useId;
  }
  
  public boolean isConnect()
  {
    return this.isConnect;
  }
  
  public void setCarChannel(String paramString)
  {
    this.car_channel = paramString;
  }
  
  public void setCarCuid(String paramString)
  {
    this.car_cuid = paramString;
  }
  
  public void setCarVersion(String paramString)
  {
    this.car_version = paramString;
  }
  
  public void setIsConnect(boolean paramBoolean)
  {
    this.isConnect = paramBoolean;
  }
  
  public void setPBData(CarNavi paramCarNavi)
  {
    this.carNavi = paramCarNavi;
  }
  
  public void setSDcardPath(String paramString)
  {
    this.sdcard_path = paramString;
  }
  
  public void setSyncState(int paramInt)
  {
    this.sync_state = paramInt;
  }
  
  public void setUseId(String paramString)
  {
    this.useId = paramString;
  }
  
  public String toString()
  {
    return "CarNaviModel [carNavi=" + this.carNavi + ", car_cuid=" + this.car_cuid + ", car_channel=" + this.car_channel + ", car_version=" + this.car_version + ", isConnect=" + this.isConnect + ", useId=" + this.useId + ", sdcard_path=" + this.sdcard_path + ", syncState=" + this.sync_state + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/model/CarNaviModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */