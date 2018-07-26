package com.baidu.speech.core;

import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;

public abstract class BDSParamBase {
    public String iParamType;

    public static class BDSBooleanParam extends BDSParamBase {
        public boolean iValue;

        public BDSBooleanParam(boolean z) {
            this.iParamType = "boolean";
            this.iValue = z;
        }
    }

    public static class BDSFloatParam extends BDSParamBase {
        public float iValue;

        public BDSFloatParam(float f) {
            this.iParamType = "float";
            this.iValue = f;
        }
    }

    public static class BDSIntParam extends BDSParamBase {
        public int iValue;

        public BDSIntParam(int i) {
            this.iParamType = Regular.TYPE_INT;
            this.iValue = i;
        }
    }

    public static class BDSObjectParam extends BDSParamBase {
        public Object iValue;

        public BDSObjectParam(Object obj) {
            this.iParamType = "object";
            this.iValue = obj;
        }
    }

    public static BDSBooleanParam boolParam(boolean z) {
        return new BDSBooleanParam(z);
    }

    public static BDSFloatParam floatParam(float f) {
        return new BDSFloatParam(f);
    }

    public static BDSIntParam intParam(int i) {
        return new BDSIntParam(i);
    }

    public static BDSObjectParam objectParam(Object obj, String str) {
        BDSObjectParam bDSObjectParam = new BDSObjectParam(obj);
        if (str.length() > 0) {
            bDSObjectParam.iParamType = str;
        }
        return bDSObjectParam;
    }
}
