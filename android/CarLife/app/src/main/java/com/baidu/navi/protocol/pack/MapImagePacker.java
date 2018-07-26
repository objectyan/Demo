package com.baidu.navi.protocol.pack;

import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.MapImageUpdateDataStruct;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class MapImagePacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = null;
        if (ds != null) {
            MapImageUpdateDataStruct mapDs = (MapImageUpdateDataStruct) ds;
            try {
                JSONObject extDataObj = new JSONObject();
                extDataObj.put("image", mapDs.imagePath);
                extDataObj.put("imagetype", mapDs.imageType);
                JSONObject obj = PackerUtil.createProtocolJSON(BNaviProtocolDef.COMMAND_NOTIFY_MAP_UPDATE, extDataObj);
                if (obj != null) {
                    result = obj.toString();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(result)) {
            return result;
        }
        return result.replace("\\", "");
    }

    public DataStruct unpack(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        JSONObject extDataObj = PackerUtil.getExtDataObj(obj);
        if (extDataObj == null) {
            return null;
        }
        MapImageUpdateDataStruct ds = new MapImageUpdateDataStruct();
        ds.imagePath = extDataObj.optString("image", "");
        ds.imageType = extDataObj.optString("imagetype", "");
        return ds;
    }
}
