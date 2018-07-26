package com.baidu.platform.comapi.search;

import android.text.TextUtils;
import com.baidu.entity.pb.Bsl;
import com.baidu.entity.pb.Bsl.Content;
import com.baidu.entity.pb.Bsl.Content.PairLine;
import com.baidu.entity.pb.Bsl.Content.Stations;
import com.baidu.entity.pb.Bsl.Content.Stations.RtInfo.NextVehicle;
import com.baidu.entity.pb.Bsl.Content.Stations.Subways;
import com.baidu.entity.pb.Bsl.Content.Stations.TriRtInfo.VehicleInfo;
import com.baidu.entity.pb.Bsl.Content.UgcInfo;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.tools.AppTools;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BusDetailResult implements ResultBase {
    public int count;
    public int currentCity;
    public String drawJsonStr;
    public byte[] exImageByte;
    public boolean exceedOperateTime;
    public boolean hasRtBus;
    public String headway;
    private ArrayList<OneLineInfo> mDetails;
    private int requestId;
    public int rtinfoSY;
    public int total;

    public class OneLineInfo {
        public String endtime;
        public String geo;
        private int isDisplay;
        public boolean ismonticket;
        public int kindtype;
        public String lineDirection;
        private ArrayList<Station> mStations;
        public int maxprice;
        public String name;
        public int nearestStationIdx = -1;
        private PairLine pairLine;
        public ComplexPt pathGeo;
        public int rtbusNu;
        public int rtbusUpdateInterval;
        public int rtbusUpdateTime;
        public String starttime;
        public String triRtbusTip;
        public ArrayList<UgcInfo> ugcInfoList;
        public String uid;
        private ArrayList<WorkTime> workTimes;
        public List<String> workingTimeDesc;

        public class PairLine {
            public String direction;
            public String endTime;
            public int kindType;
            public String name;
            public String startTime;
            public String uid;
        }

        public class Station {
            public String geo;
            public String name;
            public Point pt;
            public RealTimeInfo realTimeInfo = null;
            public ArrayList<SubwayInfo> subwaysInfo = null;
            public TriRtInf triRtInf = new TriRtInf();
            public String uid;

            public class RealTimeInfo {
                public NextVehicle nextVehicle = null;

                public class NextVehicle {
                    public int has_next_vehicle;
                    public int remain_dist;
                    public int remain_stops;
                    public int remain_time;
                }

                public RealTimeInfo(com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
                    /*
                    r1 = this;
                    com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station.this = r2;
                    r1.<init>();
                    r0 = 0;
                    r1.nextVehicle = r0;
                    r0 = r1.nextVehicle;
                    if (r0 != 0) goto L_0x0013;
                L_0x000c:
                    r0 = new com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$Station$RealTimeInfo$NextVehicle;
                    r0.<init>();
                    r1.nextVehicle = r0;
                L_0x0013:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station.RealTimeInfo.<init>(com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$Station):void");
                }
            }

            public class SubwayInfo {
                public String backgroundColor;
                public String name;
            }

            public class TriRtInf {
                public List<VehicleInfo> vehicleInfos = new ArrayList();

                public class VehicleInfo {
                    public String remainTip = null;
                    public double vehicleX = 0.0d;
                    public double vehicleY = 0.0d;
                }
            }

            public com.baidu.platform.comapi.basestruct.Point getmPtGeo() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
                /*
                r1 = this;
                r0 = r1.pt;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station.getmPtGeo():com.baidu.platform.comapi.basestruct.Point");
            }

            void setmPtGeo(com.baidu.platform.comapi.basestruct.Point r1) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
                /*
                r0 = this;
                r0.pt = r1;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station.setmPtGeo(com.baidu.platform.comapi.basestruct.Point):void");
            }

            public boolean hasValidRealTimeInfo() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
                /*
                r2 = this;
                r0 = 1;
                r1 = r2.realTimeInfo;
                if (r1 == 0) goto L_0x0014;
            L_0x0005:
                r1 = r2.realTimeInfo;
                r1 = r1.nextVehicle;
                if (r1 == 0) goto L_0x0014;
            L_0x000b:
                r1 = r2.realTimeInfo;
                r1 = r1.nextVehicle;
                r1 = r1.has_next_vehicle;
                if (r1 != r0) goto L_0x0014;
            L_0x0013:
                return r0;
            L_0x0014:
                r0 = 0;
                goto L_0x0013;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station.hasValidRealTimeInfo():boolean");
            }
        }

        public class UgcInfo {
            public String time;
            public int type;
            public String user;
        }

        public class WorkTime {
            public String end;
            public String start;
        }

        public void setPairLine(com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.PairLine r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r0 = this;
            r0.pairLine = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.setPairLine(com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$PairLine):void");
        }

        public com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.PairLine getPairLine() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r1 = this;
            r0 = r1.pairLine;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.getPairLine():com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$PairLine");
        }

        public int getIsDisplay() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r1 = this;
            r0 = r1.isDisplay;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.getIsDisplay():int");
        }

        public void setIsDisplay(int r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r0 = this;
            r0.isDisplay = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.setIsDisplay(int):void");
        }

        public java.util.ArrayList<com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.WorkTime> getWorkTimes() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r1 = this;
            r0 = r1.workTimes;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.getWorkTimes():java.util.ArrayList<com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$WorkTime>");
        }

        public void setWorkTime(com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.WorkTime r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r1 = this;
            r0 = r1.workTimes;
            if (r0 != 0) goto L_0x000b;
        L_0x0004:
            r0 = new java.util.ArrayList;
            r0.<init>();
            r1.workTimes = r0;
        L_0x000b:
            r0 = r1.workTimes;
            r0.add(r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.setWorkTime(com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$WorkTime):void");
        }

        public java.util.ArrayList<com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.UgcInfo> getUgcInfoList() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r1 = this;
            r0 = r1.ugcInfoList;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.getUgcInfoList():java.util.ArrayList<com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$UgcInfo>");
        }

        public void setUgcInfoList(java.util.ArrayList<com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.UgcInfo> r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r0 = this;
            r0.ugcInfoList = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.setUgcInfoList(java.util.ArrayList):void");
        }

        public java.util.ArrayList<com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station> getStations() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r1 = this;
            r0 = r1.mStations;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.getStations():java.util.ArrayList<com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$Station>");
        }

        public com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station getStations(int r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r1 = this;
            r0 = r1.mStations;
            r0 = r0.size();
            if (r0 <= r2) goto L_0x0011;
        L_0x0008:
            r0 = r1.mStations;
            r0 = r0.get(r2);
            r0 = (com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station) r0;
        L_0x0010:
            return r0;
        L_0x0011:
            r0 = 0;
            goto L_0x0010;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.getStations(int):com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$Station");
        }

        void setStations(java.util.ArrayList<com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station> r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r0 = this;
            r0.mStations = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.setStations(java.util.ArrayList):void");
        }

        void setStations(com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.Station r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r1 = this;
            r0 = r1.mStations;
            if (r0 != 0) goto L_0x000b;
        L_0x0004:
            r0 = new java.util.ArrayList;
            r0.<init>();
            r1.mStations = r0;
        L_0x000b:
            r0 = r1.mStations;
            r0.add(r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.search.BusDetailResult.OneLineInfo.setStations(com.baidu.platform.comapi.search.BusDetailResult$OneLineInfo$Station):void");
        }
    }

    public ArrayList<OneLineInfo> getDetails() {
        return this.mDetails;
    }

    public boolean hasDetails() {
        return this.mDetails != null && this.mDetails.size() > 0;
    }

    public OneLineInfo getDetails(int index) {
        if (this.mDetails.size() > index) {
            return (OneLineInfo) this.mDetails.get(index);
        }
        return null;
    }

    void setDetails(ArrayList<OneLineInfo> details) {
        this.mDetails = details;
    }

    void setDetails(OneLineInfo oneLineInfo) {
        if (this.mDetails == null) {
            this.mDetails = new ArrayList();
        }
        this.mDetails.add(oneLineInfo);
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public static String parseDrawerJson(Bsl bsl) {
        JSONObject jo = new JSONObject();
        JSONArray jrDetail = new JSONArray();
        for (Content content : bsl.getContentList()) {
            JSONObject joLineInfo = new JSONObject();
            try {
                joLineInfo.put("uid", content.getUid());
                joLineInfo.put("geo", content.getGeo());
                joLineInfo.put("name", content.getName());
                JSONArray jrStation = new JSONArray();
                for (Stations station : content.getStationsList()) {
                    JSONObject joStation = new JSONObject();
                    joStation.put("name", station.getName());
                    joStation.put("uid", station.getUid());
                    joStation.put("geo", station.getGeo());
                    if (station.hasRtInfo() && station.getRtInfo().hasNextVehicle()) {
                        JSONObject joRtinfo = new JSONObject();
                        NextVehicle nextVehicle = station.getRtInfo().getNextVehicle();
                        JSONObject joNextVehicle = new JSONObject();
                        joNextVehicle.put("vehicle_x", nextVehicle.getVehicleX());
                        joNextVehicle.put("vehicle_y", nextVehicle.getVehicleY());
                        joRtinfo.put("next_vehicle", joNextVehicle);
                        joStation.put("rt_info", joRtinfo);
                    }
                    if (station.hasTriRtInfo()) {
                        JSONObject joTriRtinfo = new JSONObject();
                        JSONArray jrVehicleInfo = new JSONArray();
                        for (VehicleInfo info : station.getTriRtInfo().getVehicleInfoList()) {
                            JSONObject joInfo = new JSONObject();
                            joInfo.put("vehicle_x", info.getVehicleX());
                            joInfo.put("vehicle_y", info.getVehicleY());
                            jrVehicleInfo.put(joInfo);
                        }
                        joTriRtinfo.put("vehicle_info", jrVehicleInfo);
                        joStation.put("tri_rt_info", joTriRtinfo);
                    }
                    jrStation.put(joStation);
                }
                joLineInfo.put("stations", jrStation);
            } catch (Exception e) {
                e.printStackTrace();
            }
            jrDetail.put(joLineInfo);
        }
        try {
            jo.put("details", jrDetail);
            jo.put("result_type", 18);
            jo.put(ParamKey.KEY_MSG_ERRORS, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jo.toString();
    }

    public static BusDetailResult fromPB(Bsl b) {
        BusDetailResult result = new BusDetailResult();
        result.drawJsonStr = parseDrawerJson(b);
        if (b.getContent(0).hasImage()) {
            result.exImageByte = b.getContent(0).getImage().toByteArray();
        }
        result.count = b.getContentCount();
        result.hasRtBus = b.getOption().getHasRtbus() == 1;
        result.headway = b.getContentCount() > 0 ? b.getContent(0).getHeadway() : "";
        if (b.getContent(0).hasRunState()) {
            result.exceedOperateTime = b.getContent(0).getRunState() == 1;
        }
        result.currentCity = b.hasCurrentCity() ? b.getCurrentCity().getCode() : 0;
        result.total = b.getOption().getTotal();
        result.rtinfoSY = b.getOption().getRtinfoSy();
        if (result.getDetails() != null) {
            result.getDetails().clear();
        }
        for (Content content : b.getContentList()) {
            result.getClass();
            OneLineInfo oneBusLine = new OneLineInfo();
            oneBusLine.starttime = content.getStartTime();
            oneBusLine.triRtbusTip = content.getTriRtbusTip();
            oneBusLine.maxprice = content.getMaxPrice();
            oneBusLine.ismonticket = content.getIsMonTicket() == 1;
            oneBusLine.setIsDisplay(content.getIsDisplay());
            oneBusLine.endtime = content.getEndTime();
            oneBusLine.uid = content.getUid();
            oneBusLine.name = content.getName();
            oneBusLine.getClass();
            WorkTime workTime = new WorkTime();
            workTime.start = oneBusLine.starttime;
            workTime.end = oneBusLine.endtime;
            oneBusLine.setWorkTime(workTime);
            oneBusLine.rtbusUpdateTime = content.getRtbusUpdateTime();
            oneBusLine.rtbusUpdateInterval = content.getRtbusUpdateInterval();
            oneBusLine.lineDirection = content.getLineDirection();
            oneBusLine.nearestStationIdx = content.getNearestStationIdx();
            oneBusLine.rtbusNu = content.getRtbusNu();
            oneBusLine.pathGeo = AppTools.getGeoComplexPtBoundFromString(content.getGeo());
            oneBusLine.geo = content.getGeo();
            oneBusLine.kindtype = content.getKindtype();
            oneBusLine.workingTimeDesc = new ArrayList();
            for (String workTimeDesc : content.getWorkingTimeDescList()) {
                oneBusLine.workingTimeDesc.add(workTimeDesc);
            }
            for (Stations station : content.getStationsList()) {
                oneBusLine.getClass();
                Station oneStation = new Station();
                oneStation.uid = station.getUid();
                oneStation.name = station.getName();
                oneStation.geo = station.getGeo();
                oneStation.setmPtGeo(AppTools.getGeoPointFromString(oneStation.geo));
                if (station.hasRtInfo() && station.getRtInfo().hasNextVehicle()) {
                    NextVehicle nextVehicle = station.getRtInfo().getNextVehicle();
                    oneStation.getClass();
                    oneStation.realTimeInfo = new RealTimeInfo();
                    oneStation.realTimeInfo.nextVehicle.has_next_vehicle = nextVehicle.getHasNextVehicle();
                    oneStation.realTimeInfo.nextVehicle.remain_time = nextVehicle.getRemainTime();
                    oneStation.realTimeInfo.nextVehicle.remain_dist = nextVehicle.getRemainDist();
                    oneStation.realTimeInfo.nextVehicle.remain_stops = nextVehicle.getRemainStops();
                }
                if (station.hasTriRtInfo()) {
                    for (VehicleInfo vehicleInfo : station.getTriRtInfo().getVehicleInfoList()) {
                        TriRtInf triRtInf = oneStation.triRtInf;
                        triRtInf.getClass();
                        VehicleInfo vehicleInfo2 = new VehicleInfo();
                        vehicleInfo2.remainTip = vehicleInfo.getRemainTip();
                        vehicleInfo2.vehicleX = vehicleInfo.getVehicleX();
                        vehicleInfo2.vehicleY = vehicleInfo.getVehicleY();
                        oneStation.triRtInf.vehicleInfos.add(vehicleInfo2);
                    }
                }
                oneStation.subwaysInfo = new ArrayList();
                for (Subways subway : station.getSubwaysList()) {
                    oneStation.getClass();
                    SubwayInfo subwayInfo = new SubwayInfo();
                    subwayInfo.name = TextUtils.isEmpty(subway.getName()) ? "" : subway.getName();
                    subwayInfo.backgroundColor = TextUtils.isEmpty(subway.getBackgroundColor()) ? "" : subway.getBackgroundColor();
                    oneStation.subwaysInfo.add(subwayInfo);
                }
                oneBusLine.setStations(oneStation);
            }
            if (content.hasPairLine()) {
                PairLine pairLinePb = content.getPairLine();
                BusDetailResult busDetailResult = new BusDetailResult();
                busDetailResult.getClass();
                OneLineInfo oneLineInfo = new OneLineInfo();
                oneLineInfo.getClass();
                PairLine pairLine = new PairLine();
                pairLine.name = pairLinePb.getName();
                pairLine.uid = pairLinePb.getUid();
                pairLine.startTime = pairLinePb.getStartTime();
                pairLine.endTime = pairLinePb.getEndTime();
                pairLine.kindType = pairLinePb.getKindtype();
                pairLine.direction = pairLinePb.getDirection();
                oneBusLine.setPairLine(pairLine);
            } else {
                oneBusLine.setPairLine(null);
            }
            ArrayList<UgcInfo> ugcInfos = new ArrayList();
            for (UgcInfo ugcInfo : content.getUgcinfoList()) {
                oneBusLine.getClass();
                UgcInfo ugcInfo2 = new UgcInfo();
                ugcInfo2.user = ugcInfo.getUser();
                ugcInfo2.time = ugcInfo.getTime();
                ugcInfo2.type = ugcInfo.getType();
                ugcInfos.add(ugcInfo2);
            }
            if (ugcInfos.size() > 0) {
                oneBusLine.setUgcInfoList(ugcInfos);
            }
            result.setDetails(oneBusLine);
        }
        return result;
    }
}
