package com.baidu.speech.core;

import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import com.baidu.speech.core.BDSParamBase.BDSBooleanParam;
import com.baidu.speech.core.BDSParamBase.BDSFloatParam;
import com.baidu.speech.core.BDSParamBase.BDSIntParam;
import com.baidu.speech.core.BDSParamBase.BDSObjectParam;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class BDSMessage {
    public long m_dataOffset;
    public byte[] m_messageData;
    public String m_messageName;
    public HashMap<String, BDSParamBase> m_messageParams;

    public String toString() {
        String str = this.m_messageName;
        Set<Entry> entrySet = this.m_messageParams.entrySet();
        str = str + " messageParamsCount=" + this.m_messageParams.size() + " messageParams:{  ";
        String str2 = str;
        for (Entry entry : entrySet) {
            String str3 = (String) entry.getKey();
            str = str3.endsWith(Regular.TYPE_INT) ? str2 + " (" + ((String) entry.getKey()) + " , " + ((BDSIntParam) entry.getValue()).iValue + ") " : str3.endsWith(Regular.TYPE_STRING) ? str2 + " (" + ((String) entry.getKey()) + " , " + ((BDSObjectParam) entry.getValue()).iValue + ") " : str3.endsWith("float") ? str2 + " (" + ((String) entry.getKey()) + " , " + ((BDSFloatParam) entry.getValue()).iValue + ") " : str3.endsWith("bool") ? str2 + " (" + ((String) entry.getKey()) + " , " + ((BDSBooleanParam) entry.getValue()).iValue + ") " : str2;
            str2 = str;
        }
        return str2 + "  } ";
    }
}
