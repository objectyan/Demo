package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocalMapResource {
    public Point center;
    public List<LocalMapResource> children;
    public int downloadProgress;
    public int downloadStatus;
    public int formatVersion;
    public int frc;
    public int id;
    public int level;
    public long mapoldsize;
    public long mappatchsize;
    public long mapsize;
    public String name;
    public boolean needUpdate;
    public String pinyin;
    public long remainSize;
    public long searcholdsize;
    public long searchpatchsize;
    public long searchsize;
    public int type;
    public int updateStatus;
    public int version;

    public static LocalMapResource fromJson(String raw) {
        LocalMapResource localMapResource = null;
        if (!(raw == null || raw.length() == 0)) {
            try {
                localMapResource = fromJson(new JSONObject(raw));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return localMapResource;
    }

    public static LocalMapResource fromJson(JSONObject json) {
        boolean z = true;
        LocalMapResource resource = new LocalMapResource();
        resource.id = json.optInt("id");
        resource.name = json.optString("name");
        resource.pinyin = json.optString("pinyin");
        resource.frc = json.optInt("frc");
        resource.type = json.optInt(OfflineMapKey.OFFLINE_CITY_TYPE);
        resource.center = new Point((double) json.optInt("x"), (double) json.optInt("y"));
        resource.level = json.optInt(OfflineMapKey.OFFLINE_LEVEL);
        resource.mapsize = json.optLong("mapsize");
        resource.mappatchsize = json.optLong("mappatchsize");
        resource.searchsize = json.optLong("searchsize");
        resource.searchpatchsize = json.optLong("searchpatchsize");
        resource.mapoldsize = json.optLong("mapoldsize");
        resource.searcholdsize = json.optLong("searcholdsize");
        resource.downloadProgress = json.optInt(OfflineMapKey.OFFLINE_RATION);
        resource.version = json.optInt("ver");
        resource.formatVersion = json.optInt("fm");
        resource.downloadStatus = json.optInt("status");
        if (json.optInt(OfflineMapKey.OFFLINE_UPDATE) != 1) {
            z = false;
        }
        resource.needUpdate = z;
        resource.updateStatus = json.optInt("note");
        if (json.has(OfflineMapKey.OFFLINE_CHILD)) {
            JSONArray array = json.optJSONArray(OfflineMapKey.OFFLINE_CHILD);
            resource.children = new ArrayList(array.length() + 1);
            for (int i = 0; i < array.length(); i++) {
                resource.children.add(fromJson(array.optJSONObject(i)));
            }
        }
        if (resource.children != null && resource.children.size() > 0) {
            LocalMapResource provincePack = new LocalMapResource();
            provincePack.id = resource.id;
            provincePack.name = "所有城市";
            provincePack.pinyin = resource.pinyin;
            provincePack.version = resource.version;
            provincePack.formatVersion = json.optInt("fm");
            provincePack.type = resource.type;
            provincePack.center = new Point((double) resource.center.getIntX(), (double) resource.center.getIntY());
            provincePack.level = resource.level;
            provincePack.mapsize = 0;
            provincePack.searchsize = 0;
            provincePack.downloadProgress = 0;
            provincePack.needUpdate = resource.needUpdate;
            provincePack.updateStatus = resource.updateStatus;
            provincePack.downloadStatus = resource.downloadStatus;
            for (LocalMapResource child : resource.children) {
                provincePack.mapsize += child.mapsize;
                provincePack.searchsize += child.searchsize;
            }
            resource.mapsize = provincePack.mapsize;
            resource.searchsize = provincePack.searchsize;
            resource.children.add(0, provincePack);
        }
        return resource;
    }
}
