package com.baidu.tts.client;

import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.StringTool;
import java.io.File;

public class SynthesizerTool {
    public static boolean verifyModelFile(String filePath) {
        if (StringTool.isEmpty(filePath)) {
            return false;
        }
        try {
            if (EmbeddedSynthesizerEngine.bdTTSVerifyDataFile(ResourceTools.stringToByteArrayAddNull(filePath)) >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getEngineInfo() {
        return EmbeddedSynthesizerEngine.bdTTSGetEngineParam();
    }

    public static int getEngineVersion() {
        return EmbeddedSynthesizerEngine.getEngineMinVersion();
    }

    public static String getModelInfo(String filePath) {
        if (!StringTool.isEmpty(filePath)) {
            File file = new File(filePath);
            if (file.exists() && file.canRead()) {
                return EmbeddedSynthesizerEngine.bdTTSGetDatParam(filePath);
            }
        }
        return null;
    }
}
