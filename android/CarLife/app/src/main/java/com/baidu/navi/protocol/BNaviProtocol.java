package com.baidu.navi.protocol;

import android.text.TextUtils;
import com.baidu.navi.protocol.model.DataStruct;
import com.baidu.navi.protocol.pack.BasePacker;
import com.baidu.navi.protocol.pack.PackerFactory;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navi.protocol.util.PackerUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class BNaviProtocol {
    private static BNaviProtocol instance;

    public static BNaviProtocol getInstance() {
        if (instance == null) {
            synchronized (BNaviProtocol.class) {
                if (instance == null) {
                    instance = new BNaviProtocol();
                }
            }
        }
        return instance;
    }

    public void setModuleName(String moduleName) {
        BNaviProtocolDef.moduleName = moduleName;
    }

    public static int getVersion() {
        return 2;
    }

    public String pack(DataStruct ds) {
        if (ds == null || TextUtils.isEmpty(ds.mCmd)) {
            return null;
        }
        BasePacker packer = PackerFactory.getPacker(ds.mCmd);
        if (packer != null) {
            return packer.pack(ds);
        }
        return null;
    }

    public DataStruct unpack(String json) {
        DataStruct ds = null;
        if (!TextUtils.isEmpty(json)) {
            try {
                JSONObject obj = new JSONObject(json);
                BasePacker packer = PackerFactory.getPacker(PackerUtil.getCommand(obj));
                if (packer != null) {
                    ds = packer.unpack(obj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ds;
    }

    public String packResult(DataStruct ds) {
        if (ds == null || TextUtils.isEmpty(ds.mCmd)) {
            return null;
        }
        BasePacker packer = PackerFactory.getPacker(ds.mCmd);
        if (packer != null) {
            return packer.packResult(ds);
        }
        return null;
    }
}
