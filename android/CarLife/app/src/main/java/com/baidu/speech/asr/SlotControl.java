package com.baidu.speech.asr;

import android.content.Context;
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
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SlotControl
  implements BDSSDKLoader.BDSCoreEventListener
{
  private static String ASR_PARAM_KEY_NETWORK_STATUS = "asr_param_key_network_status.int";
  private static String ASR_PARAM_KEY_PLATFORM;
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
  private BDSSDKLoader.BDSSDKInterface m_Uploadcore;
  private String outFile = null;
  
  static
  {
    ASR_PARAM_KEY_PLATFORM = "asr_param_key_platform.string";
  }
  
  public SlotControl(Context paramContext)
    throws Exception
  {
    this.context = paramContext;
    try
    {
      BDSSDKLoader.loadLibraries();
      this.m_Uploadcore = BDSSDKLoader.getSDKObjectForSDKType("UploaderCore", paramContext);
      if (this.m_Uploadcore == null) {
        throw new Exception("ASR core support is not linked in package");
      }
    }
    catch (Exception paramContext)
    {
      throw new Exception("Can not load so library");
    }
    if (!this.m_Uploadcore.instanceInitialized()) {
      throw new Exception("Failed initialize ASR Core native layer");
    }
    this.m_Uploadcore.setListener(this);
  }
  
  private void asrCallBack(BDSMessage paramBDSMessage, EventListener paramEventListener)
  {
    if (paramBDSMessage.m_messageName.equals("UPLOAD.callback"))
    {
      int i = ((BDSParamBase.BDSIntParam)paramBDSMessage.m_messageParams.get("cb.error.domain.int16_t")).iValue;
      String str = (String)((BDSParamBase.BDSObjectParam)paramBDSMessage.m_messageParams.get("cb.error.desc.string")).iValue;
      int j = ((BDSParamBase.BDSIntParam)paramBDSMessage.m_messageParams.get("cb.error.code.int16_t")).iValue;
      paramBDSMessage = new HashMap();
      paramBDSMessage.put("errorDomain", Integer.valueOf(i));
      paramBDSMessage.put("errorCode", Integer.valueOf(j));
      paramBDSMessage.put("errorDesc", str);
      paramEventListener.onEvent("uploader.finish", new JSONObject(paramBDSMessage).toString(), null, 0, 0);
    }
  }
  
  private BDSErrorDescription postEvent(BDSErrorDescription paramBDSErrorDescription, String paramString)
  {
    BDSMessage localBDSMessage = new BDSMessage();
    localBDSMessage.m_messageName = paramString;
    localBDSMessage.m_messageParams = new HashMap();
    this.mParams.optString("decoder-server.app", Policy.app(this.context));
    paramString = this.mParams.optString("pid");
    String str1 = this.mParams.optString("url", "https://upl.baidu.com//words/add");
    String str2 = this.mParams.optString("decoder-server.uid", Policy.uid(this.context));
    localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam("Android", "java.lang.String"));
    localBDSMessage.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam("C++ ASR core", "java.lang.String"));
    localBDSMessage.m_messageParams.put("upl_param_key_network_status.int", BDSParamBase.intParam(Utility.getWifiOr2gOr3G(this.context)));
    localBDSMessage.m_messageParams.put("upl_param_key_product_id.string", BDSParamBase.objectParam(paramString, "java.lang.String"));
    localBDSMessage.m_messageParams.put("upl_param_key_url.string", BDSParamBase.objectParam(str1, "java.lang.String"));
    localBDSMessage.m_messageParams.put("upl_param_key_cuid.string", BDSParamBase.objectParam(str2, "java.lang.String"));
    int i = this.m_Uploadcore.postMessage(localBDSMessage);
    if (i != 0)
    {
      paramBDSErrorDescription = new BDSErrorDescription();
      paramBDSErrorDescription.errorCode = -2;
      paramBDSErrorDescription.errorDomain = 1;
      paramBDSErrorDescription.errorDescription = ("JNI: readyParamsAsrStart Call to Native layer returned error! err( " + i + " )");
    }
    return paramBDSErrorDescription;
  }
  
  private BDSErrorDescription uploadSlotWords(BDSErrorDescription paramBDSErrorDescription, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("name");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("words");
    paramJSONObject = paramBDSErrorDescription;
    if (this.m_Uploadcore.instanceInitialized())
    {
      paramJSONObject = new BDSMessage();
      paramJSONObject.m_messageName = "uploader.config";
      paramJSONObject.m_messageParams = new HashMap();
      Vector localVector = new Vector();
      if (localJSONArray != null)
      {
        i = 0;
        for (;;)
        {
          if (i < localJSONArray.length()) {
            try
            {
              localVector.add(localJSONArray.getString(i));
              i += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
      }
      paramJSONObject.m_messageParams.put(ASR_PARAM_KEY_PLATFORM, BDSParamBase.objectParam("Android", "java.lang.String"));
      paramJSONObject.m_messageParams.put(ASR_PARAM_KEY_SDK_VERSION, BDSParamBase.objectParam("C++ ASR core", "java.lang.String"));
      paramJSONObject.m_messageParams.put("upl_param_key_network_status.int", BDSParamBase.intParam(Utility.getWifiOr2gOr3G(this.context)));
      paramJSONObject.m_messageParams.put("upl_param_key_upload_slot_name.string", BDSParamBase.objectParam(str, "java.lang.String"));
      paramJSONObject.m_messageParams.put("upl_param_key_upload_words.vector<string>", BDSParamBase.objectParam(localVector, "java.util.Vector;"));
      int i = this.m_Uploadcore.postMessage(paramJSONObject);
      paramJSONObject = paramBDSErrorDescription;
      if (i != 0)
      {
        paramJSONObject = new BDSErrorDescription();
        paramJSONObject.errorCode = -2;
        paramJSONObject.errorDomain = 1;
        paramJSONObject.errorDescription = ("JNI: readyParamsAsrStart Call to Native layer returned error! err( " + i + " )");
      }
    }
    return paramJSONObject;
  }
  
  public BDSErrorDescription postEvent(String paramString1, String paramString2)
  {
    if (!this.m_Uploadcore.instanceInitialized())
    {
      paramString2 = new BDSErrorDescription();
      paramString2.errorCode = -1;
      paramString2.errorDomain = 1;
      paramString2.errorDescription = "JNI: ASR Core native layer is not initialized!";
      return paramString2;
    }
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if (!paramString2.equals("")) {
          continue;
        }
        this.mParams = new JSONObject();
      }
      catch (JSONException paramString2)
      {
        BDSErrorDescription localBDSErrorDescription;
        paramString2.printStackTrace();
        this.mParams = new JSONObject();
        continue;
      }
      localBDSErrorDescription = uploadSlotWords(null, this.mParams);
      paramString2 = localBDSErrorDescription;
      if (localBDSErrorDescription != null) {
        break;
      }
      return postEvent(localBDSErrorDescription, paramString1);
      this.mParams = new JSONObject(paramString2);
    }
  }
  
  public void receiveCoreEvent(BDSMessage paramBDSMessage, BDSSDKLoader.BDSSDKInterface paramBDSSDKInterface)
  {
    if ((this.mListener != null) && (paramBDSMessage != null)) {
      asrCallBack(paramBDSMessage, this.mListener);
    }
  }
  
  public void setListener(EventListener paramEventListener)
  {
    this.mListener = paramEventListener;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/asr/SlotControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */