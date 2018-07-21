package com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor;

import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse.RetState;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceTTSListener;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class XDQueryInstruction
  extends InstructionExecutorAbs
{
  private String formatDistanceToChineseString()
  {
    String str2 = StringUtils.formatDistanceToChineseString(RGSimpleGuideModel.getInstance().getTotalRemainDist());
    if ((!StringUtils.isEmpty(str2)) && (str2.contains("点2"))) {
      str2.replaceAll("点2", "点二");
    }
    String str1 = str2;
    if (StringUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  private StringBuilder getRemainTimeStr(StringBuilder paramStringBuilder)
  {
    String str2 = RGSimpleGuideModel.getInstance().getTotalRemainTimeString();
    if (!StringUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.contains("分"))
      {
        str1 = str2;
        if (!str2.endsWith("分")) {
          str1 = str2.substring(0, str2.indexOf("分") + 1);
        }
      }
    }
    for (String str1 = str1 + "钟";; str1 = "")
    {
      paramStringBuilder.append(str1);
      str1 = RGSimpleGuideModel.getInstance().getArriveTimeChineseString();
      if (!StringUtils.isEmpty(str1))
      {
        paramStringBuilder.append(",预计");
        paramStringBuilder.append(str1);
      }
      return paramStringBuilder;
    }
  }
  
  public void execute(String paramString, XDVoiceTTSListener paramXDVoiceTTSListener)
  {
    XDVoiceInstructionResponse localXDVoiceInstructionResponse = null;
    if ("remaining_time".equals(paramString))
    {
      localXDVoiceInstructionResponse = getRemainTime();
      UserOPController.getInstance().add("3.c.2");
    }
    for (;;)
    {
      paramXDVoiceTTSListener.onResponse(localXDVoiceInstructionResponse);
      return;
      if ("remaining_distance".equals(paramString))
      {
        localXDVoiceInstructionResponse = getRemainDistance();
        UserOPController.getInstance().add("3.c.3");
      }
      else if ("remaining_distance_and_time".equals(paramString))
      {
        localXDVoiceInstructionResponse = getRemainTimeAndDistance();
        UserOPController.getInstance().add("3.c.f");
      }
      else if ("traffic_info".equals(paramString))
      {
        localXDVoiceInstructionResponse = queryRouteInfo();
        UserOPController.getInstance().add("3.c.9");
      }
    }
  }
  
  public XDVoiceInstructionResponse getRemainDistance()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = formatDistanceToChineseString();
    if (str != null)
    {
      localStringBuilder.append("离目的地");
      localStringBuilder.append(str);
    }
    return new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, localStringBuilder.toString());
  }
  
  public XDVoiceInstructionResponse getRemainTime()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("离目的地还有");
    localStringBuilder = getRemainTimeStr(localStringBuilder);
    return new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, localStringBuilder.toString());
  }
  
  public XDVoiceInstructionResponse getRemainTimeAndDistance()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = formatDistanceToChineseString();
    if (str != null)
    {
      localStringBuilder.append("离目的地");
      localStringBuilder.append(str);
    }
    localStringBuilder.append("大约需要");
    localStringBuilder = getRemainTimeStr(localStringBuilder);
    return new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, localStringBuilder.toString());
  }
  
  public XDVoiceInstructionResponse queryRouteInfo()
  {
    Object localObject2 = BNRouteGuider.getInstance().getCurRoadConditionText();
    Object localObject1 = localObject2;
    if (!StringUtils.isEmpty((String)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).contains(",")) {
        localObject1 = ((String)localObject2).replaceAll(",", "");
      }
      localObject2 = localObject1;
      if (((String)localObject1).contains("，")) {
        localObject2 = ((String)localObject1).replaceAll("，", "");
      }
      localObject1 = localObject2;
      if (((String)localObject2).contains("无名路")) {
        localObject1 = ((String)localObject2).replaceAll("无名路", "前方道路");
      }
      localObject1 = (String)localObject1 + ",请小心驾驶";
    }
    return new XDVoiceInstructionResponse(XDVoiceInstructionResponse.RetState.SUCCESS, (String)localObject1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/xdvoice/executor/XDQueryInstruction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */