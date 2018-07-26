package com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor;

import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionParams.VoiceInstructionType;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse.RetState;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceTTSListener;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class XDQueryInstruction extends InstructionExecutorAbs {
    public void execute(String subType, XDVoiceTTSListener xdVoiceTTSListener) {
        XDVoiceInstructionResponse speakContent = null;
        if (VoiceInstructionType.REMAINING_TIME.equals(subType)) {
            speakContent = getRemainTime();
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_c_2);
        } else if (VoiceInstructionType.REMAINING_DISTANCE.equals(subType)) {
            speakContent = getRemainDistance();
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_c_3);
        } else if (VoiceInstructionType.REMAINING_DISTANCE_AND_TIME.equals(subType)) {
            speakContent = getRemainTimeAndDistance();
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_c_f);
        } else if (VoiceInstructionType.TRAFFIC_INFO.equals(subType)) {
            speakContent = queryRouteInfo();
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_c_9);
        }
        xdVoiceTTSListener.onResponse(speakContent);
    }

    public XDVoiceInstructionResponse getRemainTime() {
        StringBuilder sb = new StringBuilder();
        sb.append("离目的地还有");
        return new XDVoiceInstructionResponse(RetState.SUCCESS, getRemainTimeStr(sb).toString());
    }

    public XDVoiceInstructionResponse getRemainDistance() {
        StringBuilder sb = new StringBuilder();
        String distS = formatDistanceToChineseString();
        if (distS != null) {
            sb.append("离目的地");
            sb.append(distS);
        }
        return new XDVoiceInstructionResponse(RetState.SUCCESS, sb.toString());
    }

    public XDVoiceInstructionResponse getRemainTimeAndDistance() {
        StringBuilder sb = new StringBuilder();
        String distS = formatDistanceToChineseString();
        if (distS != null) {
            sb.append("离目的地");
            sb.append(distS);
        }
        sb.append("大约需要");
        return new XDVoiceInstructionResponse(RetState.SUCCESS, getRemainTimeStr(sb).toString());
    }

    public XDVoiceInstructionResponse queryRouteInfo() {
        String speakContent = BNRouteGuider.getInstance().getCurRoadConditionText();
        if (!StringUtils.isEmpty(speakContent)) {
            if (speakContent.contains(",")) {
                speakContent = speakContent.replaceAll(",", "");
            }
            if (speakContent.contains("，")) {
                speakContent = speakContent.replaceAll("，", "");
            }
            if (speakContent.contains(TrackDataShop.SPECIAL_ADDR_IN_TRACK)) {
                speakContent = speakContent.replaceAll(TrackDataShop.SPECIAL_ADDR_IN_TRACK, "前方道路");
            }
            speakContent = speakContent + ",请小心驾驶";
        }
        return new XDVoiceInstructionResponse(RetState.SUCCESS, speakContent);
    }

    private StringBuilder getRemainTimeStr(StringBuilder stringBuilder) {
        String arriveTime = RGSimpleGuideModel.getInstance().getTotalRemainTimeString();
        if (StringUtils.isEmpty(arriveTime)) {
            arriveTime = "";
        } else {
            if (arriveTime.contains("分") && !arriveTime.endsWith("分")) {
                arriveTime = arriveTime.substring(0, arriveTime.indexOf("分") + 1);
            }
            arriveTime = arriveTime + "钟";
        }
        stringBuilder.append(arriveTime);
        String estimationTime = RGSimpleGuideModel.getInstance().getArriveTimeChineseString();
        if (!StringUtils.isEmpty(estimationTime)) {
            stringBuilder.append(",预计");
            stringBuilder.append(estimationTime);
        }
        return stringBuilder;
    }

    private String formatDistanceToChineseString() {
        String distS = StringUtils.formatDistanceToChineseString(RGSimpleGuideModel.getInstance().getTotalRemainDist());
        if (!StringUtils.isEmpty(distS) && distS.contains("点2")) {
            distS.replaceAll("点2", "点二");
        }
        return StringUtils.isEmpty(distS) ? "" : distS;
    }
}
