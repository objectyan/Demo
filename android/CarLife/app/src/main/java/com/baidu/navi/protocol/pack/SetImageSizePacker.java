package com.baidu.navi.protocol.pack;

import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.SetImageSizeDataStruct;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class SetImageSizePacker extends BasePacker {
    public String pack(DataStruct ds) {
        String result = null;
        if (ds != null) {
            SetImageSizeDataStruct imageDS = (SetImageSizeDataStruct) ds;
            try {
                JSONObject extDataObj = new JSONObject();
                extDataObj.put("width", imageDS.imageWidth);
                extDataObj.put("height", imageDS.imageHeight);
                JSONObject obj = PackerUtil.createProtocolJSON(BNaviProtocolDef.COMMAND_SET_IMAGE_SIZE, extDataObj);
                if (obj != null) {
                    result = obj.toString();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public DataStruct unpack(JSONObject obj) {
        SetImageSizeDataStruct imageDS = null;
        if (obj != null) {
            JSONObject extDataObj = PackerUtil.getExtDataObj(obj);
            if (extDataObj != null) {
                imageDS = new SetImageSizeDataStruct();
                int width = extDataObj.optInt("width", 0);
                int height = extDataObj.optInt("height", 0);
                if (width <= 0) {
                    width = 400;
                }
                if (height <= 0) {
                    height = BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT;
                }
                imageDS.imageWidth = width;
                imageDS.imageHeight = height;
            }
        }
        return imageDS;
    }
}
