package com.baidu.navisdk.util.db;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.model.NaviCurRoutePoiModel;
import com.baidu.navisdk.util.db.model.NaviDestHistroyModel;
import com.baidu.navisdk.util.db.model.NaviFavoriteDestModel;
import com.baidu.navisdk.util.db.model.NaviRouteHistoryModel;
import java.util.ArrayList;

class DBManager$1 extends Handler {
    DBManager$DBOperateResultCallback callback = null;
    RoutePlanNode node = null;
    ArrayList<RoutePlanNode> nodesList = null;
    DBManager$DBOperateParams params = null;
    int position = -1;

    DBManager$1(Looper x0) {
        super(x0);
    }

    public void handleMessage(Message msg) {
        this.position = -1;
        this.node = null;
        this.nodesList = null;
        switch (msg.what) {
            case 1:
                this.callback = (DBManager$DBOperateResultCallback) msg.obj;
                NaviDestHistroyModel.getInstance().getAllHistoryDestPoints();
                if (this.callback != null) {
                    this.callback.onQuerySuccess();
                    return;
                }
                return;
            case 2:
                this.node = (RoutePlanNode) msg.obj;
                NaviDestHistroyModel.getInstance().addNaviDest(this.node);
                return;
            case 3:
                this.params = (DBManager$DBOperateParams) msg.obj;
                this.node = this.params.node;
                this.callback = this.params.callback;
                NaviDestHistroyModel.getInstance().removeNaviDest(this.node);
                if (this.callback != null) {
                    this.callback.onAddOrDeleteSuccess();
                    return;
                }
                return;
            case 4:
                this.callback = (DBManager$DBOperateResultCallback) msg.obj;
                NaviDestHistroyModel.getInstance().clear();
                if (this.callback != null) {
                    this.callback.onAddOrDeleteSuccess();
                    return;
                }
                return;
            case 17:
                this.callback = (DBManager$DBOperateResultCallback) msg.obj;
                NaviRouteHistoryModel.getInstance().getAllHistoryRoutes();
                if (this.callback != null) {
                    this.callback.onQuerySuccess();
                    return;
                }
                return;
            case 18:
                this.nodesList = (ArrayList) msg.obj;
                NaviRouteHistoryModel.getInstance().addNaviRoute(this.nodesList);
                return;
            case 19:
                this.params = (DBManager$DBOperateParams) msg.obj;
                this.position = this.params.position;
                this.callback = this.params.callback;
                NaviRouteHistoryModel.getInstance().removeNaviRouteHistoryByPosition(this.position);
                if (this.callback != null) {
                    this.callback.onAddOrDeleteSuccess();
                    return;
                }
                return;
            case 20:
                this.callback = (DBManager$DBOperateResultCallback) msg.obj;
                NaviRouteHistoryModel.getInstance().clear();
                if (this.callback != null) {
                    this.callback.onAddOrDeleteSuccess();
                    return;
                }
                return;
            case 33:
                this.callback = (DBManager$DBOperateResultCallback) msg.obj;
                NaviCurRoutePoiModel.getInstance().getLastNaviPointsFromDB();
                if (this.callback != null) {
                    this.callback.onQuerySuccess();
                    return;
                }
                return;
            case 34:
                this.nodesList = (ArrayList) msg.obj;
                NaviCurRoutePoiModel.getInstance().addCurNaviNodes(this.nodesList);
                return;
            case 35:
                NaviCurRoutePoiModel.getInstance().removeCurNaviViaNode(msg.obj);
                return;
            case 36:
                NaviCurRoutePoiModel.getInstance().clear();
                return;
            case 65:
                this.callback = (DBManager$DBOperateResultCallback) msg.obj;
                NaviFavoriteDestModel.getInstance().getAllHistoryDestPoints();
                if (this.callback != null) {
                    this.callback.onQuerySuccess();
                    return;
                }
                return;
            case 66:
                this.node = (RoutePlanNode) msg.obj;
                NaviFavoriteDestModel.getInstance().addNaviDest(this.node);
                return;
            case 67:
                this.params = (DBManager$DBOperateParams) msg.obj;
                this.node = this.params.node;
                this.callback = this.params.callback;
                NaviFavoriteDestModel.getInstance().removeNaviDest(this.node);
                if (this.callback != null) {
                    this.callback.onAddOrDeleteSuccess();
                    return;
                }
                return;
            case 68:
                this.callback = (DBManager$DBOperateResultCallback) msg.obj;
                NaviFavoriteDestModel.getInstance().clear();
                if (this.callback != null) {
                    this.callback.onAddOrDeleteSuccess();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
