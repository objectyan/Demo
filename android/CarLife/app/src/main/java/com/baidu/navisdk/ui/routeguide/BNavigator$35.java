package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.model.datastruct.RoadConditionItem;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.List;

class BNavigator$35 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$35(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        if (BNavigator.access$4300(this.this$0) < 2) {
            List<RoadConditionItem> roadConditionList = RGAssistGuideModel.getInstance().getRoadConditionData();
            if (roadConditionList == null || roadConditionList.isEmpty()) {
                BNavigator.access$4302(this.this$0, 2);
            } else {
                boolean hasRoadCondition = false;
                for (RoadConditionItem item : roadConditionList) {
                    if (item.roadConditionType != 0) {
                        hasRoadCondition = true;
                        break;
                    }
                }
                if (hasRoadCondition) {
                    RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(true);
                    RGNotificationController.getInstance().showUpdateRCFail();
                    BNavigator.access$2002(this.this$0, true);
                    BNavigator.access$4308(this.this$0);
                } else {
                    BNavigator.access$4302(this.this$0, 2);
                }
            }
        }
        return null;
    }
}
