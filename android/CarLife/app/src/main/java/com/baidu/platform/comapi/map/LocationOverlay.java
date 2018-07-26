package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class LocationOverlay extends InnerOverlay {
    private AppBaseMap mAppBaseMap;

    public LocationOverlay() {
        super(7);
    }

    public LocationOverlay(AppBaseMap baseMap) {
        super(7, baseMap);
        this.mAppBaseMap = baseMap;
    }

    public String getLayerTag() {
        return "location";
    }

    public boolean getDefaultShowStatus() {
        return true;
    }

    public void setLocationLayerData(List<OverlayLocationData> list) {
        if (list != null && list.size() > 0 && this.mLayerID != 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("locationaddr", this.mLayerID);
            ArrayList<ParcelItem> parcle = new ArrayList();
            int i = 0;
            while (i < list.size()) {
                OverlayLocationData subItem = (OverlayLocationData) list.get(i);
                if (subItem.getImage() != null) {
                    ParcelItem subParacel = new ParcelItem();
                    Bitmap bmp = subItem.getImage();
                    Bundle subBunle = new Bundle();
                    ByteBuffer dstBuffer = ByteBuffer.allocate((bmp.getWidth() * bmp.getHeight()) * 4);
                    bmp.copyPixelsToBuffer(dstBuffer);
                    subBunle.putByteArray("imgbin", dstBuffer.array());
                    subBunle.putInt(Config.DEVICE_WIDTH, subItem.getImgWidth());
                    subBunle.putInt("h", subItem.getImgHeight());
                    subBunle.putInt(MapObjKey.OBJ_SS_ARROW_ROTATION, subItem.isRotation());
                    subBunle.putString("name", subItem.getImgName());
                    subParacel.setBundle(subBunle);
                    parcle.add(subParacel);
                    i++;
                } else {
                    return;
                }
            }
            if (parcle.size() > 0) {
                ParcelItem[] midpar = new ParcelItem[parcle.size()];
                for (int j = 0; j < parcle.size(); j++) {
                    midpar[j] = (ParcelItem) parcle.get(j);
                }
                bundle.putParcelableArray("imagedata", midpar);
            }
            this.mAppBaseMap.SetLocationLayerData(bundle);
        }
    }

    public void clearLocationLayerData(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("locationaddr", this.mLayerID);
        this.mAppBaseMap.ClearLocationLayerData(bundle);
    }
}
