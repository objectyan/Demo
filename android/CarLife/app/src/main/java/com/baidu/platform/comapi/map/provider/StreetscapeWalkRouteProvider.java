package com.baidu.platform.comapi.map.provider;

import android.os.Bundle;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.JsonBuilder;

public class StreetscapeWalkRouteProvider implements RenderProvider {
    private static final String TAG = StreetscapeWalkRouteProvider.class.getSimpleName();
    private JsonBuilder mJsonBuilder;
    private int mNodeCount;
    private Bundle walkPosBundle;

    public StreetscapeWalkRouteProvider(Bundle walkpos) {
        this.walkPosBundle = walkpos;
    }

    public String getRenderData() {
        resetTemporaryField();
        try {
            this.mJsonBuilder.object().key("dataset").arrayValue();
            addPath();
            this.mJsonBuilder.endArrayValue().endObject();
            return this.mJsonBuilder.getJson();
        } catch (Exception e) {
            C2911f.a(TAG, "getRenderData error", e);
            return "";
        }
    }

    private void resetTemporaryField() {
        this.mJsonBuilder = new JsonBuilder();
        this.mNodeCount = 0;
    }

    private void addPath() {
        this.mJsonBuilder.object();
        double[] posX = this.walkPosBundle.getDoubleArray("x");
        double[] posY = this.walkPosBundle.getDoubleArray("y");
        JsonBuilder builder = new JsonBuilder();
        builder.arrayValue();
        for (int i = 0; i < posX.length; i++) {
            builder.value(posX[i]);
            builder.value(posY[i]);
            builder.value(-2);
        }
        builder.endArrayValue();
        this.mJsonBuilder.key("path").objectValue(builder.getJson());
        this.mJsonBuilder.endObject();
    }

    public Bundle getWalkPosBundle() {
        return this.walkPosBundle;
    }

    public void setWalkPosBundle(Bundle walkPosBundle) {
        this.walkPosBundle = walkPosBundle;
    }
}
