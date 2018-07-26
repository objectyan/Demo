package com.baidu.navi.track.model;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.navi.track.TrackCarDataSolveModel;
import com.baidu.navisdk.util.common.SysOSAPI;

public class CarNaviModel {
    private CarNavi carNavi;
    private String car_channel;
    private String car_cuid;
    private String car_version;
    private boolean isConnect;
    private String sdcard_path;
    private int sync_state;
    private String useId;

    public CarNaviModel() {
        setPBData(new CarNavi());
        setCarCuid(TrackCarDataSolveModel.carCUID);
        setCarChannel(TrackCarDataSolveModel.carChannel);
        setCarVersion(TrackCarDataSolveModel.carVersion);
        setIsConnect(TrackCarDataSolveModel.isConnect);
        setUseId(NavMapAdapter.getInstance().getUid());
        setSDcardPath(SysOSAPI.getInstance().GetSDCardPath() + "/trajectory");
    }

    public void cleanCarInfo() {
        setCarCuid("");
        setCarChannel("");
        setCarVersion("");
        setIsConnect(false);
        setUseId("");
        setSDcardPath("");
    }

    public CarNavi getPBData() {
        return this.carNavi;
    }

    public void setPBData(CarNavi value) {
        this.carNavi = value;
    }

    public String getCarCuid() {
        return this.car_cuid;
    }

    public void setCarCuid(String value) {
        this.car_cuid = value;
    }

    public String getCarChannel() {
        return this.car_channel;
    }

    public void setCarChannel(String value) {
        this.car_channel = value;
    }

    public String getCarVersion() {
        return this.car_version;
    }

    public void setCarVersion(String value) {
        this.car_version = value;
    }

    public boolean isConnect() {
        return this.isConnect;
    }

    public void setIsConnect(boolean value) {
        this.isConnect = value;
    }

    public String getUseId() {
        return this.useId;
    }

    public void setUseId(String value) {
        this.useId = value;
    }

    public String getSDcardPath() {
        return this.sdcard_path;
    }

    public void setSDcardPath(String value) {
        this.sdcard_path = value;
    }

    public int getSyncState() {
        return this.sync_state;
    }

    public void setSyncState(int value) {
        this.sync_state = value;
    }

    public String toString() {
        return "CarNaviModel [carNavi=" + this.carNavi + ", car_cuid=" + this.car_cuid + ", car_channel=" + this.car_channel + ", car_version=" + this.car_version + ", isConnect=" + this.isConnect + ", useId=" + this.useId + ", sdcard_path=" + this.sdcard_path + ", syncState=" + this.sync_state + "]";
    }

    public CarNaviModel clone() {
        CarNaviModel model = new CarNaviModel();
        model.setCarCuid(getCarCuid());
        model.setCarChannel(getCarChannel());
        model.setCarVersion(getCarVersion());
        model.setIsConnect(isConnect());
        model.setUseId(getUseId());
        model.setSDcardPath(getSDcardPath());
        model.setSyncState(getSyncState());
        if (getPBData() == null) {
            model.setPBData(null);
        } else {
            CarNavi oriCarnavi = getPBData();
            CarNavi carNavi = new CarNavi();
            if (oriCarnavi.hasSid()) {
                carNavi.setSid(oriCarnavi.getSid());
            }
            if (oriCarnavi.hasGuid()) {
                carNavi.setGuid(oriCarnavi.getGuid());
            }
            if (oriCarnavi.hasType()) {
                carNavi.setType(oriCarnavi.getType());
            }
            if (oriCarnavi.hasAvgSpeed()) {
                carNavi.setAvgSpeed(oriCarnavi.getAvgSpeed());
            }
            if (oriCarnavi.hasDistance()) {
                carNavi.setDistance(oriCarnavi.getDistance());
            }
            if (oriCarnavi.hasMaxSpeed()) {
                carNavi.setMaxSpeed(oriCarnavi.getMaxSpeed());
            }
            if (oriCarnavi.hasCtime()) {
                carNavi.setCtime(oriCarnavi.getCtime());
            }
            if (oriCarnavi.hasModifyTtime()) {
                carNavi.setModifyTime(oriCarnavi.getModifyTime());
            }
            if (oriCarnavi.hasDuration()) {
                carNavi.setDuration(oriCarnavi.getDuration());
            }
            if (oriCarnavi.hasSign()) {
                carNavi.setSign(oriCarnavi.getSign());
            }
            if (oriCarnavi.hasStartPoint()) {
                carNavi.setStartPoint(oriCarnavi.getStartPoint());
            }
            if (oriCarnavi.hasEndPoint()) {
                carNavi.setEndPoint(oriCarnavi.getEndPoint());
            }
            model.setPBData(carNavi);
        }
        return model;
    }
}
