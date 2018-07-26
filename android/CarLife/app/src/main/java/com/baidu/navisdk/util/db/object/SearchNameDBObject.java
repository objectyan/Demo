package com.baidu.navisdk.util.db.object;

public class SearchNameDBObject implements BaseDBObject {
    private int mCount = 1;
    private int mId;
    private String mName;

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    public int getCount() {
        return this.mCount;
    }
}
