package com.baidu.navi.protocol.pack;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.model.GetAddressDataStruct;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAddressPacker extends BasePacker {
    public String packResult(DataStruct ds) {
        String result = null;
        if (ds != null) {
            GetAddressDataStruct addressDS = (GetAddressDataStruct) ds;
            try {
                JSONObject extDataObj = new JSONObject();
                prePackResult(extDataObj, addressDS);
                Bundle params = addressDS.commandResult.params;
                if (params != null) {
                    if (params.containsKey("home")) {
                        String strHome = params.getString("home", "");
                        if (!TextUtils.isEmpty(strHome)) {
                            JSONObject homeObj = new JSONObject(strHome);
                            if (homeObj != null) {
                                extDataObj.put("home", homeObj);
                            }
                        }
                    }
                    if (params.containsKey("company")) {
                        String strCompany = params.getString("company", "");
                        if (!TextUtils.isEmpty(strCompany)) {
                            JSONObject companyObj = new JSONObject(strCompany);
                            if (companyObj != null) {
                                extDataObj.put("company", companyObj);
                            }
                        }
                    }
                }
                JSONObject obj = PackerUtil.createResultJSON(extDataObj);
                if (obj != null) {
                    result = obj.toString();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
