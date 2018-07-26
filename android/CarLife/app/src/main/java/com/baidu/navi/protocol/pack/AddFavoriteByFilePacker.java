package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import com.baidu.navi.protocol.model.AddFavoriteByFileDataStruct;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AddFavoriteByFilePacker extends BasePacker {
    public String packResult(DataStruct ds) {
        String result = null;
        if (ds != null) {
            Bundle bundle = ds.commandResult.params;
            try {
                JSONObject extDataObj = new JSONObject();
                String filePath = bundle.getString(AddFavoriteByFileDataStruct.KEY_FAVFILEPATH);
                int favNum = bundle.getInt(AddFavoriteByFileDataStruct.KEY_FAVNUM);
                extDataObj.put(AddFavoriteByFileDataStruct.KEY_FAVFILEPATH, filePath);
                extDataObj.put(AddFavoriteByFileDataStruct.KEY_FAVNUM, favNum);
                extDataObj.put(AddFavoriteByFileDataStruct.KEY_ERROR_CODE, bundle.get("errorCode"));
                JSONObject obj = PackerUtil.createProtocolJSON(BNaviProtocolDef.COMMAND_ADD_FAVORITE_BY_FILE, extDataObj);
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
        if (obj == null) {
            return null;
        }
        JSONObject extDataObj = PackerUtil.getExtDataObj(obj);
        if (extDataObj == null) {
            return null;
        }
        AddFavoriteByFileDataStruct ds = new AddFavoriteByFileDataStruct();
        ds.mFavFile = extDataObj.optString(AddFavoriteByFileDataStruct.KEY_FAVFILEPATH, "");
        ds.mFavNum = extDataObj.optInt(AddFavoriteByFileDataStruct.KEY_FAVNUM);
        ds.commandResult.errCode = extDataObj.optInt(AddFavoriteByFileDataStruct.KEY_ERROR_CODE);
        return ds;
    }
}
