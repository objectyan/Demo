package com.baidu.navisdk.util.db.object;

import android.text.TextUtils;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import java.util.List;

public class RoutePlanNodeDBObject extends RoutePlanNode implements BaseDBObject {
    private static final long serialVersionUID = 2089580738007876476L;
    private int mArg1;
    private int mArg2;
    private int mId;

    public RoutePlanNodeDBObject(int latitude, int longitude, int from, String name, String description) {
        super(latitude, longitude, from, name, description, null);
    }

    public RoutePlanNodeDBObject(int latitude, int longitude, int from, String name, String description, String uid) {
        super(latitude, longitude, from, name, description, uid);
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getArg1() {
        return this.mArg1;
    }

    public void setArg1(int arg1) {
        this.mArg1 = arg1;
    }

    public int getArg2() {
        return this.mArg2;
    }

    public void setArg2(int arg2) {
        this.mArg2 = arg2;
    }

    public static ArrayList<RoutePlanNode> convertToRoutePlanNodeList(List<RoutePlanNodeDBObject> models) {
        ArrayList<RoutePlanNode> nodes = null;
        if (models != null) {
            nodes = new ArrayList(models.size());
            for (int i = 0; i < models.size(); i++) {
                nodes.add(models.get(i));
            }
        }
        if (nodes == null) {
            return new ArrayList(0);
        }
        return nodes;
    }

    public static boolean compare(RoutePlanNode src, RoutePlanNode other) {
        boolean isSame = false;
        if (src == null || other == null) {
            return 0;
        }
        String srcName = src.getName();
        String otherName = other.getName();
        if (TextUtils.isEmpty(srcName) || TextUtils.isEmpty(otherName)) {
            if (Math.abs(src.getLatitudeE6() - other.getLatitudeE6()) <= 3 && Math.abs(src.getLongitudeE6() - other.getLongitudeE6()) <= 3) {
                isSame = true;
            }
        } else if (srcName.equals(otherName)) {
            if (TextUtils.isEmpty(src.getDescription()) || TextUtils.isEmpty(other.getDescription())) {
                if (Math.abs(src.getLatitudeE6() - other.getLatitudeE6()) <= 3 && Math.abs(src.getLongitudeE6() - other.getLongitudeE6()) <= 3) {
                    isSame = true;
                }
            } else if (src.getDescription().equals(other.getDescription())) {
                isSame = true;
            }
        }
        return isSame;
    }
}
