package com.baidu.speech.asr;

import android.content.Context;
import com.baidu.carlife.core.C1253f;
import com.baidu.speech.EventListener;
import com.baidu.speech.core.BDSErrorDescription;
import com.baidu.speech.core.BDSMessage;
import com.baidu.speech.core.BDSParamBase;
import com.baidu.speech.core.BDSParamBase.BDSIntParam;
import com.baidu.speech.core.BDSParamBase.BDSObjectParam;
import com.baidu.speech.core.BDSSDKLoader;
import com.baidu.speech.core.BDSSDKLoader.BDSCoreEventListener;
import com.baidu.speech.core.BDSSDKLoader.BDSSDKInterface;
import com.baidu.speech.utils.Policy;
import com.baidu.speech.utils.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SlotControl implements BDSCoreEventListener {
    private static String ASR_PARAM_KEY_NETWORK_STATUS = "asr_param_key_network_status.int";
    private static String ASR_PARAM_KEY_PLATFORM = "asr_param_key_platform.string";
    private static String ASR_PARAM_KEY_SDK_VERSION = "asr_param_key_sdk_version.string";
    private static final int PLOADER_ERROR_CODE_REQUEST_ERROR = 2;
    private static final String UPLOADER_CMD_CANCEL = "uploader.cancel";
    private static final String UPLOADER_CMD_CONFIG = "uploader.config";
    private static final String UPLOADER_CMD_START = "uploader.start";
    private static final String UPLOADER_CUID = "upl_param_key_cuid.string";
    private static final int UPLOADER_ERROR_CODE_NET_UNAVAILAVLE = 4;
    private static final int UPLOADER_ERROR_CODE_OK = 0;
    private static final int UPLOADER_ERROR_CODE_PARAM_ERROR = 1;
    private static final int UPLOADER_ERROR_CODE_RESPONSE_ERROR = 3;
    private static final String UPLOADER_NET_STATUS_KEY = "upl_param_key_network_status.int";
    private static final String UPLOADER_PRODUCT_ID = "upl_param_key_product_id.string";
    private static final String UPLOADER_SLOT_NAME_KEY = "upl_param_key_upload_slot_name.string";
    private static final String UPLOADER_URL = "upl_param_key_url.string";
    private static final String UPLOADER_WORDS_KEY = "upl_param_key_upload_words.vector<string>";
    private Context context;
    private EventListener mListener;
    private JSONObject mParams;
    private BDSSDKInterface m_Uploadcore;
    private String outFile = null;

    public SlotControl(Context context) throws Exception {
        this.context = context;
        try {
            BDSSDKLoader.loadLibraries();
            this.m_Uploadcore = BDSSDKLoader.getSDKObjectForSDKType("UploaderCore", context);
            if (this.m_Uploadcore == null) {
                throw new Exception("ASR core support is not linked in package");
            } else if (this.m_Uploadcore.instanceInitialized()) {
                this.m_Uploadcore.setListener(this);
            } else {
                throw new Exception("Failed initialize ASR Core native layer");
            }
        } catch (Exception e) {
            throw new Exception("Can not load so library");
        }
    }

    private void asrCallBack(BDSMessage bDSMessage, EventListener eventListener) {
        if (bDSMessage.m_messageName.equals(SpeechConstant.UPLOAD_CALLBACK_NAME)) {
            int i = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_DOMAIN)).iValue;
            String str = (String) ((BDSObjectParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_DESC)).iValue;
            int i2 = ((BDSIntParam) bDSMessage.m_messageParams.get(SpeechConstant.CALLBACK_ERROR_CODE)).iValue;
            Map hashMap = new HashMap();
            hashMap.put("errorDomain", Integer.valueOf(i));
            hashMap.put("errorCode", Integer.valueOf(i2));
            hashMap.put("errorDesc", str);
            eventListener.onEvent(SpeechConstant.CALLBACK_EVENT_UPLOAD_FINISH, new JSONObject(hashMap).toString(), null, 0, 0);
        }
    }

    private BDSErrorDescription postEvent(BDSErrorDescription bDSErrorDescription, String str) {
        BDSMessage bDSMessage = new BDSMessage();
        bDSMessage.m_messageName = str;
        bDSMessage.m_messageParams = new HashMap();
        this.mParams.optString(SpeechConstant.APP_NAME, Policy.app(this.context));
        String optString = this.mParams.optString("pid");
        String optString2 = this.mParams.optString("url", "https://upl.baidu.com//words/add");
        String optString3 = this.mParams.optString("decoder-server.uid", Policy.uid(this.context));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam(C1253f.jb, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam("C++ ASR core", "java.lang.String"));
        bDSMessage.m_messageParams.put(UPLOADER_NET_STATUS_KEY, BDSParamBase.intParam(Utility.getWifiOr2gOr3G(this.context)));
        bDSMessage.m_messageParams.put(UPLOADER_PRODUCT_ID, BDSParamBase.objectParam(optString, "java.lang.String"));
        bDSMessage.m_messageParams.put(UPLOADER_URL, BDSParamBase.objectParam(optString2, "java.lang.String"));
        bDSMessage.m_messageParams.put(UPLOADER_CUID, BDSParamBase.objectParam(optString3, "java.lang.String"));
        int postMessage = this.m_Uploadcore.postMessage(bDSMessage);
        if (postMessage == 0) {
            return bDSErrorDescription;
        }
        bDSErrorDescription = new BDSErrorDescription();
        bDSErrorDescription.errorCode = -2;
        bDSErrorDescription.errorDomain = 1;
        bDSErrorDescription.errorDescription = "JNI: readyParamsAsrStart Call to Native layer returned error! err( " + postMessage + " )";
        return bDSErrorDescription;
    }

    private BDSErrorDescription uploadSlotWords(BDSErrorDescription bDSErrorDescription, JSONObject jSONObject) {
        String optString = jSONObject.optString("name");
        JSONArray optJSONArray = jSONObject.optJSONArray("words");
        if (!this.m_Uploadcore.instanceInitialized()) {
            return bDSErrorDescription;
        }
        int i;
        BDSMessage bDSMessage = new BDSMessage();
        bDSMessage.m_messageName = UPLOADER_CMD_CONFIG;
        bDSMessage.m_messageParams = new HashMap();
        Vector vector = new Vector();
        if (optJSONArray != null) {
            for (i = 0; i < optJSONArray.length(); i++) {
                try {
                    vector.add(optJSONArray.getString(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam(C1253f.jb, "java.lang.String"));
        bDSMessage.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam("C++ ASR core", "java.lang.String"));
        bDSMessage.m_messageParams.put(UPLOADER_NET_STATUS_KEY, BDSParamBase.intParam(Utility.getWifiOr2gOr3G(this.context)));
        bDSMessage.m_messageParams.put(UPLOADER_SLOT_NAME_KEY, BDSParamBase.objectParam(optString, "java.lang.String"));
        bDSMessage.m_messageParams.put(UPLOADER_WORDS_KEY, BDSParamBase.objectParam(vector, "java.util.Vector;"));
        i = this.m_Uploadcore.postMessage(bDSMessage);
        if (i == 0) {
            return bDSErrorDescription;
        }
        bDSErrorDescription = new BDSErrorDescription();
        bDSErrorDescription.errorCode = -2;
        bDSErrorDescription.errorDomain = 1;
        bDSErrorDescription.errorDescription = "JNI: readyParamsAsrStart Call to Native layer returned error! err( " + i + " )";
        return bDSErrorDescription;
    }

    public BDSErrorDescription postEvent(String str, String str2) {
        BDSErrorDescription uploadSlotWords;
        if (this.m_Uploadcore.instanceInitialized()) {
            if (str2 != null) {
                try {
                    if (!str2.equals("")) {
                        this.mParams = new JSONObject(str2);
                        uploadSlotWords = uploadSlotWords(null, this.mParams);
                        return uploadSlotWords != null ? postEvent(uploadSlotWords, str) : uploadSlotWords;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.mParams = new JSONObject();
                }
            }
            this.mParams = new JSONObject();
            uploadSlotWords = uploadSlotWords(null, this.mParams);
            if (uploadSlotWords != null) {
            }
        }
        uploadSlotWords = new BDSErrorDescription();
        uploadSlotWords.errorCode = -1;
        uploadSlotWords.errorDomain = 1;
        uploadSlotWords.errorDescription = "JNI: ASR Core native layer is not initialized!";
        return uploadSlotWords;
    }

    public void receiveCoreEvent(BDSMessage bDSMessage, BDSSDKInterface bDSSDKInterface) {
        if (this.mListener != null && bDSMessage != null) {
            asrCallBack(bDSMessage, this.mListener);
        }
    }

    public void setListener(EventListener eventListener) {
        this.mListener = eventListener;
    }
}
