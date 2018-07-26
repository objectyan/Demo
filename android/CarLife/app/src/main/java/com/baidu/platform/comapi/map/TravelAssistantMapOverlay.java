package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class TravelAssistantMapOverlay extends InnerOverlay {
    public static final int PB_LENGTH_SIGN = 32;
    private byte[] extData;

    public TravelAssistantMapOverlay() {
        super(37);
    }

    public TravelAssistantMapOverlay(AppBaseMap baseMap) {
        super(37, baseMap);
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(0, 0, MapController.DYNAMIC_MAP_LAYER_TAG);
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }

    public void setExtData(byte[] extData) {
        this.extData = getExtData(extData);
    }

    private byte[] getExtData(byte[] data) {
        byte[] bArr = null;
        if (data != null && data.length >= 32) {
            int sign = ((((data[0] & 255) << 24) | ((data[1] & 255) << 16)) | ((data[2] & 255) << 8)) | (data[3] & 255);
            int len = data.length;
            if (sign == len - 32) {
                bArr = new byte[(len - 32)];
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = data[i + 32];
                }
            }
        }
        return bArr;
    }

    public Bundle getParam() {
        Bundle bundle = new Bundle();
        if (this.extData != null && this.extData.length > 1) {
            Bundle data = new Bundle();
            data.putByteArray("data", this.extData);
            data.putInt(OVERLAY_KEY.IMG_EXT_LEN, this.extData.length);
            bundle.putParcelableArray(OVERLAY_KEY.IMG_EXT, new Bundle[]{data});
        }
        return bundle;
    }
}
