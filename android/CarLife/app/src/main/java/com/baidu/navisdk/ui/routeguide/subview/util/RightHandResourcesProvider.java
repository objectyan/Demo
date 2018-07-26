package com.baidu.navisdk.ui.routeguide.subview.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class RightHandResourcesProvider {
    private static final int[] NEED_ROTATION_TURN_ID = new int[]{C4048R.drawable.nsdk_drawable_rg_ic_turn_back, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_out, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_front, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_left, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_leftback, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_leftfront, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_right, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_rightback, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_rightfront, C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_turnback, C4048R.drawable.nsdk_drawable_rg_hud_turn_back};
    private static final Rect THAILAND_BOUND = new Rect(622634, 10837256, 2313605, 11760548);
    private static GeoPoint lastEndPoint = null;
    private static boolean lastIsRightHand = false;
    private static GeoPoint lastStartPoint = null;

    private RightHandResourcesProvider() {
    }

    private static final boolean isRightHand() {
        RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        if (routePlanModel.getEnNaviType() == 1) {
            RoutePlanNode startNode = routePlanModel.getStartNode();
            RoutePlanNode endNode = routePlanModel.getEndNode();
            if (!(startNode == null || endNode == null)) {
                if (lastStartPoint != null && lastStartPoint.equals(startNode.getGeoPoint()) && lastEndPoint != null && lastEndPoint.equals(endNode.getGeoPoint())) {
                    return lastIsRightHand;
                }
                lastStartPoint = startNode.getGeoPoint();
                lastEndPoint = endNode.getGeoPoint();
                if (isInThailandBound(transNodeToGeoPoint(startNode)) && isInThailandBound(transNodeToGeoPoint(endNode))) {
                    lastIsRightHand = true;
                    return true;
                }
            }
        }
        lastIsRightHand = false;
        return false;
    }

    private static GeoPoint transNodeToGeoPoint(RoutePlanNode node) {
        GeoPoint geoPoint = new GeoPoint();
        if (node == null) {
            return geoPoint;
        }
        Bundle bundle = CoordinateTransformUtil.LLE62MC(node.getLongitudeE6(), node.getLatitudeE6());
        if (bundle != null) {
            return new GeoPoint(bundle.getInt("MCy"), bundle.getInt("MCx"));
        }
        return geoPoint;
    }

    public static final int getEnNaviType() {
        return ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getEnNaviType();
    }

    private static boolean isInThailandBound(GeoPoint point) {
        if (point == null || !THAILAND_BOUND.contains(point.getLongitudeE6(), point.getLatitudeE6())) {
            return false;
        }
        return true;
    }

    private static final int getIconIdIncludeRightHandIcon(int leftHandIconId) {
        if (isRightHand()) {
            return getRightHandIconId(leftHandIconId);
        }
        return leftHandIconId;
    }

    private static boolean isNeedRotate(int resId) {
        if (!lastIsRightHand) {
            return false;
        }
        for (int id : NEED_ROTATION_TURN_ID) {
            if (resId == id) {
                return true;
            }
        }
        return false;
    }

    public static final Drawable getDrawableIncludeRightHandIcon(int leftHandId) {
        int iconId = getIconIdIncludeRightHandIcon(leftHandId);
        Drawable drawable = JarUtils.getResources().getDrawable(iconId);
        if (drawable == null || !isNeedRotate(iconId)) {
            return drawable;
        }
        try {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Matrix matrix = new Matrix();
            matrix.postScale(-1.0f, 1.0f);
            return new BitmapDrawable(JarUtils.getResources(), Bitmap.createBitmap(bitmap, 0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), matrix, false));
        } catch (Exception e) {
            e.printStackTrace();
            return drawable;
        }
    }

    private static final int getRightHandIconId(int leftHandId) {
        switch (leftHandId) {
            case C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_left /*1711407741*/:
                return C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_right;
            case C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_leftback /*1711407742*/:
                return C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_rightback;
            case C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_leftfront /*1711407743*/:
                return C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_rightfront;
            case C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_right /*1711407745*/:
                return C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_left;
            case C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_rightback /*1711407746*/:
                return C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_leftback;
            case C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_rightfront /*1711407747*/:
                return C4048R.drawable.nsdk_drawable_rg_ic_turn_ring_leftfront;
            default:
                return leftHandId;
        }
    }

    private static boolean isInternational() {
        RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        if (routePlanModel == null || routePlanModel.getEnNaviType() == 0) {
            return false;
        }
        return true;
    }

    public static boolean isInternationalWithToast(Context context) {
        if (!isInternational()) {
            return false;
        }
        TipTool.onCreateToastDialog(context, JarUtils.getResources().getString(C4048R.string.nsdk_string_global_not_support));
        return true;
    }
}
