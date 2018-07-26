package com.baidu.che.codriver.protocol.data.nlp;

import android.text.TextUtils;
import com.baidu.che.codriver.util.INoProguard;

public class CustomItem implements INoProguard {
    private String domain;
    private int index;
    private String indexList;
    private String intent;
    private String label;
    private String scene;
    private Slots slots;
    private String url;
    /* renamed from: x */
    private int f8524x;
    /* renamed from: y */
    private int f8525y;

    public String getLabel() {
        if (TextUtils.isEmpty(this.label)) {
            return "";
        }
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getScene() {
        if (TextUtils.isEmpty(this.scene)) {
            return "";
        }
        return this.scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getX() {
        return this.f8524x;
    }

    public void setX(int x) {
        this.f8524x = x;
    }

    public int getY() {
        return this.f8525y;
    }

    public void setY(int y) {
        this.f8525y = y;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getIndexList() {
        if (TextUtils.isEmpty(this.indexList)) {
            return "";
        }
        return this.indexList;
    }

    public void setIndexList(String indexList) {
        this.indexList = indexList;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIntent() {
        return this.intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public Slots getSlots() {
        return this.slots;
    }

    public void setSlots(Slots slots) {
        this.slots = slots;
    }
}
