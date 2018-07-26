package com.baidu.navisdk.util.db.model;

import android.text.TextUtils;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import com.baidu.navisdk.util.db.object.SearchNameDBObject;
import com.baidu.navisdk.util.db.table.BaseDBTable;
import com.baidu.navisdk.util.db.table.SearchNameDBTable;
import java.util.ArrayList;
import java.util.List;

public class SearchNameHistroyModel {
    private static final int SIZE_LIMIT = 50;
    public List<SearchNameDBObject> mSearchNameDBObjects;
    private SearchNameDBTable mTable;

    static class InnerHolder {
        static SearchNameHistroyModel mInstance = new SearchNameHistroyModel();

        InnerHolder() {
        }
    }

    private SearchNameHistroyModel() {
        this.mTable = new SearchNameDBTable();
        this.mTable.beginTransaction();
        this.mSearchNameDBObjects = this.mTable.queryAll(SearchNameDBTable.ID, BaseDBTable.ORDERBY_DOWN);
        if (this.mSearchNameDBObjects == null) {
            this.mSearchNameDBObjects = new ArrayList(0);
        }
        consumeSize();
        this.mTable.endTransaction();
    }

    public static SearchNameHistroyModel getInstance() {
        return InnerHolder.mInstance;
    }

    public int getSize() {
        return this.mSearchNameDBObjects.size();
    }

    public int removeSearchName(String name) {
        if (TextUtils.isEmpty(name) || name.trim().equals("")) {
            return -1;
        }
        int i = 0;
        while (i < this.mSearchNameDBObjects.size()) {
            SearchNameDBObject tempobj = (SearchNameDBObject) this.mSearchNameDBObjects.get(i);
            if (tempobj == null || !name.equalsIgnoreCase(tempobj.getName())) {
                i++;
            } else {
                this.mSearchNameDBObjects.remove(i);
                this.mTable.delete(tempobj.getId());
                return i;
            }
        }
        return -1;
    }

    public String getName(int index) {
        if (index >= 0 && index < this.mSearchNameDBObjects.size()) {
            SearchNameDBObject obj = (SearchNameDBObject) this.mSearchNameDBObjects.get(index);
            if (obj != null) {
                return obj.getName();
            }
        }
        return null;
    }

    public void clear() {
        this.mTable.deleteAll();
        this.mSearchNameDBObjects.clear();
    }

    public void addSearchName(String name) {
        if (!TextUtils.isEmpty(name) && !name.trim().equals("")) {
            SearchNameDBObject newobj = new SearchNameDBObject();
            newobj.setName(name);
            int index = removeSearchName(name);
            if (index >= 0 && index < this.mSearchNameDBObjects.size()) {
                newobj.setCount(newobj.getCount() + 1);
            }
            this.mTable.insert((BaseDBObject) newobj);
            this.mSearchNameDBObjects.add(0, newobj);
            consumeSize();
        }
    }

    private void consumeSize() {
        if (this.mSearchNameDBObjects.size() > 50) {
            SearchNameDBObject obj = (SearchNameDBObject) this.mSearchNameDBObjects.get(this.mSearchNameDBObjects.size() - 1);
            if (obj != null) {
                this.mTable.delete(obj.getId());
            }
            this.mSearchNameDBObjects.remove(this.mSearchNameDBObjects.size() - 1);
        }
    }
}
