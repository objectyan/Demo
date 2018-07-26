package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.UIMsg.m_AppUI;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class LocalMapManager {
    private static volatile LocalMapManager instance;
    private AppBaseMap baseMap = null;
    private LocalMapHandler handler = null;

    private LocalMapManager() {
    }

    public static LocalMapManager getInstance() {
        if (instance == null) {
            synchronized (LocalMapManager.class) {
                if (instance == null) {
                    instance = new LocalMapManager();
                }
            }
        }
        return instance;
    }

    public boolean init(MapController controller) {
        if (controller == null) {
            return false;
        }
        if (this.handler == null) {
            this.handler = new LocalMapHandler();
            MessageProxy.registerMessageHandler(m_AppUI.V_WM_VDATAENGINE, this.handler);
        }
        this.baseMap = controller.getBaseMap();
        if (this.baseMap == null) {
            return false;
        }
        this.baseMap.OnUsrcityMsgInterval(1500);
        return true;
    }

    public void destroy() {
        if (this.handler != null) {
            MessageProxy.unRegisterMessageHandler(m_AppUI.V_WM_VDATAENGINE, this.handler);
            this.handler = null;
        }
    }

    public void registerListener(LocalMapListener listener) {
        if (this.handler != null) {
            this.handler.registListener(listener);
        }
    }

    public void removeListener(LocalMapListener listener) {
        if (this.handler != null) {
            this.handler.removeListener(listener);
        }
    }

    public boolean start(int cityId) {
        if (this.baseMap == null || cityId < 0) {
            return false;
        }
        return this.baseMap.OnRecordAdd(cityId);
    }

    public boolean resume(int cityId) {
        if (this.baseMap == null || cityId < 0) {
            return false;
        }
        return this.baseMap.OnRecordStart(cityId, false, 0);
    }

    public boolean resumeAll(int type) {
        if (this.baseMap == null) {
            return false;
        }
        return this.baseMap.OnRecordStart(0, true, type);
    }

    public boolean pause(int cityId) {
        if (this.baseMap == null || cityId < 0) {
            return false;
        }
        return this.baseMap.OnRecordSuspend(cityId, false, 0);
    }

    public boolean pauseAll(int type) {
        if (this.baseMap == null) {
            return false;
        }
        return this.baseMap.OnRecordSuspend(0, true, type);
    }

    public boolean delete(int cityId) {
        if (this.baseMap == null || cityId < 0) {
            return false;
        }
        return this.baseMap.OnRecordRemove(cityId, false);
    }

    public boolean deleteAll() {
        if (this.baseMap == null) {
            return false;
        }
        return this.baseMap.OnRecordRemove(0, true);
    }

    public boolean importMap(boolean deleteFailed, boolean offImport) {
        if (this.baseMap == null) {
            return false;
        }
        return this.baseMap.OnRecordImport(deleteFailed, offImport);
    }

    public boolean update(int cityId) {
        if (this.baseMap == null || cityId < 0) {
            return false;
        }
        return this.baseMap.OnRecordReload(cityId, false);
    }

    public boolean updateAll() {
        if (this.baseMap == null) {
            return false;
        }
        return this.baseMap.OnRecordReload(0, true);
    }

    public List<LocalMapResource> getHotCities() {
        if (this.baseMap == null) {
            return null;
        }
        return toResources(this.baseMap.OnHotcityGet());
    }

    public List<LocalMapResource> getAllCities() {
        if (this.baseMap == null) {
            return null;
        }
        return toResources(this.baseMap.OnSchcityGet(""));
    }

    public List<LocalMapResource> getCitiesByName(String key) {
        if (this.baseMap == null || key == null || key.equals("")) {
            return null;
        }
        return toResources(this.baseMap.OnSchcityGet(key));
    }

    public LocalMapResource getCityById(int cityId) {
        if (this.baseMap == null || cityId < 0) {
            return null;
        }
        return LocalMapResource.fromJson(this.baseMap.OnRecordGetAt(cityId));
    }

    public List<LocalMapResource> getUserResources() {
        if (this.baseMap == null) {
            return null;
        }
        return toResources(this.baseMap.OnRecordGetAll());
    }

    public int autoDownloadRoadNetworkViaWifi(int cityId) {
        if (this.baseMap == null || cityId < 0) {
            return 0;
        }
        return this.baseMap.OnWifiRecordAdd(cityId);
    }

    private List<LocalMapResource> toResources(String raw) {
        if (raw == null || raw.length() == 0) {
            return null;
        }
        try {
            JSONArray array = new JSONObject(raw).optJSONArray("dataset");
            List<LocalMapResource> list = new ArrayList(array.length());
            for (int i = 0; i < array.length(); i++) {
                list.add(LocalMapResource.fromJson(array.getJSONObject(i)));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
