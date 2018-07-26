package com.baidu.navi.controller;

import android.text.TextUtils;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager$DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviFavoriteDestModel;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDestinationController {
    private static final String TAG = FavoriteDestinationController.class.getSimpleName();
    private DBManager$DBOperateResultCallback mCallback;
    private List<RoutePlanNode> mDataList;

    public interface FavoriteDestResultCallBack {
        void onAddResult(boolean z);

        void onCheckResult(boolean z);

        void onCleanResult(boolean z);

        void onRemoveResult(boolean z);
    }

    /* renamed from: com.baidu.navi.controller.FavoriteDestinationController$1 */
    class C36831 implements DBManager$DBOperateResultCallback {
        C36831() {
        }

        public void onAddOrDeleteSuccess() {
            FavoriteDestinationController.this.notifyHistoryDataSetChanged();
        }

        public void onQuerySuccess() {
            FavoriteDestinationController.this.notifyHistoryDataSetChanged();
        }
    }

    static class InnerHolder {
        static FavoriteDestinationController mInstance = new FavoriteDestinationController();

        InnerHolder() {
        }
    }

    private FavoriteDestinationController() {
        this.mDataList = new ArrayList();
        this.mCallback = new C36831();
    }

    public static FavoriteDestinationController getInstance() {
        return InnerHolder.mInstance;
    }

    private void notifyHistoryDataSetChanged() {
        this.mDataList = NaviFavoriteDestModel.getInstance().getRoutePlanNode();
    }

    public List<RoutePlanNode> getFavoriteDestList() {
        return this.mDataList;
    }

    public boolean checkFavoriteDest(SearchPoi point) {
        if (this.mDataList == null || point == null) {
            return false;
        }
        if (point == null || point.mGuidePoint == null) {
            return false;
        }
        if (point == null || point.mGuidePoint.getLatitudeE6() == Integer.MIN_VALUE || point.mGuidePoint.getLongitudeE6() == Integer.MIN_VALUE) {
            return false;
        }
        for (int i = 0; i < this.mDataList.size(); i++) {
            RoutePlanNode mRoutePlanNode = (RoutePlanNode) this.mDataList.get(i);
            if (!(mRoutePlanNode.mGeoPoint == null || mRoutePlanNode.mGeoPoint.getLatitudeE6() == Integer.MIN_VALUE || mRoutePlanNode.mGeoPoint.getLongitudeE6() == Integer.MIN_VALUE)) {
                if (mRoutePlanNode.mGeoPoint.getLatitudeE6() == point.mGuidePoint.getLatitudeE6() && mRoutePlanNode.mGeoPoint.getLongitudeE6() == point.mGuidePoint.getLongitudeE6()) {
                    return true;
                }
                if (!TextUtils.isEmpty(mRoutePlanNode.mName) && !TextUtils.isEmpty(point.mName) && mRoutePlanNode.mName.equals(point.mName) && getDistance(point.mGuidePoint, mRoutePlanNode.mGeoPoint) <= 5.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkFavoriteDest(final SearchPoi point, final FavoriteDestResultCallBack callback) {
        if (this.mDataList == null || point == null || callback == null) {
            if (callback != null) {
                callback.onCheckResult(false);
            }
        } else if (point == null || point.mGuidePoint == null) {
            callback.onCheckResult(false);
        } else if (point == null || point.mGuidePoint.getLatitudeE6() == Integer.MIN_VALUE || point.mGuidePoint.getLongitudeE6() == Integer.MIN_VALUE) {
            callback.onCheckResult(false);
        } else {
            new Thread(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    r11 = this;
                    r10 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
                    r2 = 0;
                    r6 = com.baidu.navi.controller.FavoriteDestinationController.this;
                    r6 = r6.mDataList;
                    if (r6 == 0) goto L_0x0013;
                L_0x000b:
                    r6 = r4;
                    if (r6 == 0) goto L_0x0013;
                L_0x000f:
                    r6 = r5;
                    if (r6 != 0) goto L_0x0014;
                L_0x0013:
                    r2 = 1;
                L_0x0014:
                    if (r2 != 0) goto L_0x0020;
                L_0x0016:
                    r6 = r4;
                    if (r6 == 0) goto L_0x0020;
                L_0x001a:
                    r6 = r4;
                    r6 = r6.mGuidePoint;
                    if (r6 != 0) goto L_0x0021;
                L_0x0020:
                    r2 = 1;
                L_0x0021:
                    if (r2 != 0) goto L_0x003b;
                L_0x0023:
                    r6 = r4;
                    if (r6 == 0) goto L_0x003b;
                L_0x0027:
                    r6 = r4;
                    r6 = r6.mGuidePoint;
                    r6 = r6.getLatitudeE6();
                    if (r6 == r10) goto L_0x003b;
                L_0x0031:
                    r6 = r4;
                    r6 = r6.mGuidePoint;
                    r6 = r6.getLongitudeE6();
                    if (r6 != r10) goto L_0x003c;
                L_0x003b:
                    r2 = 1;
                L_0x003c:
                    r4 = 0;
                    r1 = 0;
                L_0x003e:
                    if (r2 != 0) goto L_0x004c;
                L_0x0040:
                    r6 = com.baidu.navi.controller.FavoriteDestinationController.this;
                    r6 = r6.mDataList;
                    r6 = r6.size();
                    if (r1 >= r6) goto L_0x0090;
                L_0x004c:
                    r6 = com.baidu.navi.controller.FavoriteDestinationController.this;
                    r6 = r6.mDataList;
                    r5 = r6.get(r1);
                    r5 = (com.baidu.navisdk.model.datastruct.RoutePlanNode) r5;
                    r6 = r5.mGeoPoint;
                    if (r6 != 0) goto L_0x005f;
                L_0x005c:
                    r1 = r1 + 1;
                    goto L_0x003e;
                L_0x005f:
                    r6 = r5.mGeoPoint;
                    r6 = r6.getLatitudeE6();
                    if (r6 == r10) goto L_0x005c;
                L_0x0067:
                    r6 = r5.mGeoPoint;
                    r6 = r6.getLongitudeE6();
                    if (r6 == r10) goto L_0x005c;
                L_0x006f:
                    r6 = r5.mGeoPoint;
                    r6 = r6.getLatitudeE6();
                    r7 = r4;
                    r7 = r7.mGuidePoint;
                    r7 = r7.getLatitudeE6();
                    if (r6 != r7) goto L_0x00a3;
                L_0x007f:
                    r6 = r5.mGeoPoint;
                    r6 = r6.getLongitudeE6();
                    r7 = r4;
                    r7 = r7.mGuidePoint;
                    r7 = r7.getLongitudeE6();
                    if (r6 != r7) goto L_0x00a3;
                L_0x008f:
                    r4 = 1;
                L_0x0090:
                    r3 = r4;
                    r0 = new android.os.Handler;
                    r6 = android.os.Looper.getMainLooper();
                    r0.<init>(r6);
                    r6 = new com.baidu.navi.controller.FavoriteDestinationController$2$1;
                    r6.<init>(r3);
                    r0.post(r6);
                    return;
                L_0x00a3:
                    r6 = r5.mName;
                    r6 = android.text.TextUtils.isEmpty(r6);
                    if (r6 != 0) goto L_0x005c;
                L_0x00ab:
                    r6 = r4;
                    r6 = r6.mName;
                    r6 = android.text.TextUtils.isEmpty(r6);
                    if (r6 != 0) goto L_0x005c;
                L_0x00b5:
                    r6 = r5.mName;
                    r7 = r4;
                    r7 = r7.mName;
                    r6 = r6.equals(r7);
                    if (r6 == 0) goto L_0x005c;
                L_0x00c1:
                    r6 = com.baidu.navi.controller.FavoriteDestinationController.this;
                    r7 = r4;
                    r7 = r7.mGuidePoint;
                    r8 = r5.mGeoPoint;
                    r6 = r6.getDistance(r7, r8);
                    r8 = 4617315517961601024; // 0x4014000000000000 float:0.0 double:5.0;
                    r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
                    if (r6 > 0) goto L_0x005c;
                L_0x00d3:
                    r4 = 1;
                    goto L_0x0090;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.navi.controller.FavoriteDestinationController.2.run():void");
                }
            }).start();
        }
    }

    private double getDistance(GeoPoint point, GeoPoint center) {
        double dx = (double) (point.getLongitudeE6() - center.getLongitudeE6());
        double dy = (double) (point.getLatitudeE6() - center.getLatitudeE6());
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    public void queryAllFavoriteDestFromDB(DBManager$DBOperateResultCallback callback) {
        if (!NaviFavoriteDestModel.getInstance().checkIsQueryDB()) {
            if (callback == null) {
                DBManager.getAllFavoriteDestPoints(this.mCallback);
            } else {
                DBManager.getAllFavoriteDestPoints(callback);
            }
        }
    }

    public void cleanAllFavoriteDest(final FavoriteDestResultCallBack callback) {
        DBManager.clearFavoriteDestFromDB(new DBManager$DBOperateResultCallback() {
            public void onQuerySuccess() {
            }

            public void onAddOrDeleteSuccess() {
                FavoriteDestinationController.this.notifyHistoryDataSetChanged();
                if (callback != null) {
                    callback.onCleanResult(true);
                }
            }
        });
    }

    public void deleteFavoriteDestFromDB(RoutePlanNode node, final FavoriteDestResultCallBack callback) {
        if (node != null) {
            DBManager.deleteFavoriteDestFromDB(node, new DBManager$DBOperateResultCallback() {
                public void onQuerySuccess() {
                }

                public void onAddOrDeleteSuccess() {
                    FavoriteDestinationController.this.notifyHistoryDataSetChanged();
                    if (callback != null) {
                        callback.onRemoveResult(true);
                    }
                }
            });
        } else if (callback != null) {
            callback.onRemoveResult(false);
        }
    }

    public void addFavoriteDestFromDB(RoutePlanNode node, FavoriteDestResultCallBack callback) {
        if (node != null) {
            DBManager.addFavoriteDestPointToDB(node);
            DBManager.getAllFavoriteDestPoints(this.mCallback);
            if (callback != null) {
                callback.onAddResult(true);
            }
        } else if (callback != null) {
            callback.onAddResult(false);
        }
    }

    public RoutePlanNode createRoutePlanNode(SearchPoi node) {
        if (node == null) {
            return null;
        }
        return new RoutePlanNode(node.mGuidePoint, node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
    }
}
