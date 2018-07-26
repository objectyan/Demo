package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.IndoorNavi;
import com.baidu.entity.pb.IndoorNavi.Routes.Legs;
import com.baidu.entity.pb.IndoorNavi.Routes.Legs.Steps;
import com.baidu.entity.pb.IndoorNavi.Routes.Legs.Steps.Pois;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.LinkedList;
import java.util.List;

public class IndoorRouteProvider implements RenderProvider {
    private static final String TAG = IndoorRouteProvider.class.getSimpleName();
    private JsonBuilder builder;
    private List<Steps> highLightSteps = new LinkedList();
    private final Legs indoorLeg;
    private int nodeIndex;

    public IndoorRouteProvider(Legs indoorLeg) {
        this.indoorLeg = indoorLeg;
    }

    public synchronized void setHighLightSteps(List<Steps> highLightSteps) {
        this.highLightSteps = highLightSteps;
    }

    public synchronized String getRenderData() {
        this.nodeIndex = 0;
        this.builder = new JsonBuilder();
        this.builder.object().key("dataset").arrayValue();
        this.builder.object();
        this.builder.key(OVERLAY_KEY.INDOOR).value(true);
        this.builder.endObject();
        renderSteps();
        renderPois();
        renderStart();
        renderEnd();
        this.builder.endArrayValue().endObject();
        return this.builder.getJson();
    }

    private void renderSteps() {
        for (Steps step : this.indoorLeg.getStepsList()) {
            int i;
            boolean isSelected = this.highLightSteps != null && this.highLightSteps.contains(step);
            this.builder.object();
            this.builder.key("ty").value(2);
            JsonBuilder key = this.builder.key("in");
            int i2 = this.nodeIndex;
            this.nodeIndex = i2 + 1;
            key.value(i2);
            JsonBuilder key2 = this.builder.key("nst");
            if (isSelected) {
                i = 154;
            } else {
                i = 155;
            }
            key2.value(i);
            key2 = this.builder.key("fst");
            if (isSelected) {
                i = 154;
            } else {
                i = 155;
            }
            key2.value(i);
            this.builder.key("path").objectValue(ProviderUtils.pathToJson(step.getSpathList()));
            this.builder.endObject();
        }
    }

    private void renderStart() {
        this.builder.object();
        this.builder.key("ty").value(1);
        this.builder.key("nst").value(17);
        this.builder.key("fst").value(17);
        this.builder.key("tx").value("起点");
        JsonBuilder key = this.builder.key("in");
        int i = this.nodeIndex;
        this.nodeIndex = i + 1;
        key.value(i);
        this.builder.key(OVERLAY_KEY.ALIGN).value(2);
        this.builder.key("path").objectValue(ProviderUtils.pathToJson(this.indoorLeg.getSstartLocationList()));
        this.builder.endObject();
    }

    private void renderEnd() {
        this.builder.object();
        this.builder.key("ty").value(2);
        this.builder.key("nst").value(18);
        this.builder.key("fst").value(18);
        this.builder.key("tx").value("终点");
        JsonBuilder key = this.builder.key("in");
        int i = this.nodeIndex;
        this.nodeIndex = i + 1;
        key.value(i);
        this.builder.key(OVERLAY_KEY.ALIGN).value(2);
        this.builder.key("path").objectValue(ProviderUtils.pathToJson(this.indoorLeg.getSendLocationList()));
        this.builder.endObject();
    }

    private void renderPois() {
        if (this.highLightSteps != null) {
            for (Steps step : this.highLightSteps) {
                for (Pois poi : step.getPoisList()) {
                    this.builder.object();
                    this.builder.key("ty").value(3);
                    switch (poi.getType()) {
                        case 1:
                            this.builder.key("nst").value(204);
                            this.builder.key("fst").value(204);
                            break;
                        case 2:
                            this.builder.key("nst").value(203);
                            this.builder.key("fst").value(203);
                            break;
                        case 3:
                            this.builder.key("nst").value(202);
                            this.builder.key("fst").value(202);
                            break;
                        case 4:
                            this.builder.key("nst").value(201);
                            this.builder.key("fst").value(201);
                            break;
                        default:
                            break;
                    }
                    this.builder.key("tx").value(poi.getName());
                    JsonBuilder key = this.builder.key("in");
                    int i = this.nodeIndex;
                    this.nodeIndex = i + 1;
                    key.value(i);
                    this.builder.key(OVERLAY_KEY.ALIGN).value(1);
                    this.builder.key("of").value(15);
                    this.builder.key("path").objectValue(ProviderUtils.pathToJson(poi.getLocationList()));
                    this.builder.endObject();
                }
            }
        }
    }

    public static Legs extractRouteLeg(IndoorNavi indoorNavi) throws Exception {
        Legs resultLegs = new Legs();
        for (Legs leg : indoorNavi.getRoutes(0).getLegsList()) {
            resultLegs.setDistance(resultLegs.getDistance() + leg.getDistance());
            resultLegs.setDuration(resultLegs.getDuration() + leg.getDuration());
            List<Steps> stepsList = leg.getStepsList();
            if (stepsList != null) {
                for (Steps steps : stepsList) {
                    resultLegs.addSteps(steps);
                }
            }
        }
        for (Double d : indoorNavi.getRoutes(0).getLegs(0).getSstartLocationList()) {
            resultLegs.addSstartLocation(d.doubleValue());
        }
        for (Double d2 : indoorNavi.getRoutes(0).getLegs(indoorNavi.getRoutes(0).getLegsCount() - 1).getSendLocationList()) {
            resultLegs.addSendLocation(d2.doubleValue());
        }
        return resultLegs;
    }
}
