package com.baidu.navisdk.ui.disclaimer.control;

import java.io.Serializable;

public class Disclaimer implements Serializable {
    private final int mLayoutId;
    private final Type mType;

    public enum Type {
        INTERNATIONAL("international");
        
        String mName;

        private Type(String name) {
            this.mName = name;
        }

        public String getName() {
            return this.mName;
        }
    }

    Disclaimer(Type type, int layoutId) {
        this.mType = type;
        this.mLayoutId = layoutId;
    }

    public Type getType() {
        return this.mType;
    }

    public int getLayoutId() {
        return this.mLayoutId;
    }
}
