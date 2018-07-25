package com.baidu.carlife.p086j;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo;
import com.baidu.carlife.protobuf.CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.Builder;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider$OnRGSubStatusListener;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.BNavR;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: RGEventHUDCollection */
/* renamed from: com.baidu.carlife.j.a */
public class C1612a {
    /* renamed from: c */
    private static final String f4920c = C1612a.class.getSimpleName();
    /* renamed from: i */
    private static C1612a f4921i;
    /* renamed from: a */
    HashMap<String, Integer> f4922a = new HashMap();
    /* renamed from: b */
    HashMap<String, Integer> f4923b = new HashMap();
    /* renamed from: d */
    private boolean f4924d = false;
    /* renamed from: e */
    private boolean f4925e = false;
    /* renamed from: f */
    private boolean f4926f = false;
    /* renamed from: g */
    private boolean f4927g = false;
    /* renamed from: h */
    private boolean f4928h = false;
    /* renamed from: j */
    private BNRouteGuider$OnRGSubStatusListener f4929j = new C16101(this);
    /* renamed from: k */
    private OnRGInfoListener f4930k = new C16112(this);

    /* compiled from: RGEventHUDCollection */
    /* renamed from: com.baidu.carlife.j.a$1 */
    class C16101 implements BNRouteGuider$OnRGSubStatusListener {
        /* renamed from: a */
        final /* synthetic */ C1612a f4918a;

        C16101(C1612a this$0) {
            this.f4918a = this$0;
        }

        public void onRoutePlanYawing(Message message) {
        }

        public void onReRouteComplete(Message message) {
        }

        public void onReRouteCarFree(Message message) {
        }

        public void onArriveDestNear(Message message) {
        }

        public void onArriveDest(Message message) {
            LogUtil.d(C1612a.f4920c, "onArriveDest " + message.toString());
            this.f4918a.m5895d();
        }
    }

    /* compiled from: RGEventHUDCollection */
    /* renamed from: com.baidu.carlife.j.a$2 */
    class C16112 implements OnRGInfoListener {
        /* renamed from: a */
        final /* synthetic */ C1612a f4919a;

        C16112(C1612a this$0) {
            this.f4919a = this$0;
        }

        public void onSimpleGuideInfoShow(Message message) {
        }

        public void onSimpleGuideInfoUpdate(Message message) {
            this.f4919a.m5890f();
        }

        public void onSimpleGuideInfoHide(Message message) {
        }

        public void onTotalRemainDistTimeUpdate(Message message) {
        }

        public void onAssistInfoShow(Message message) {
        }

        public void onAssistInfoUpdate(Message message) {
        }

        public void onAssistInfoHide(Message message) {
        }

        public void onRasterExpandMapShow(Message message) {
        }

        public void onRasterExpandMapUpdate(Message message) {
        }

        public void onRasterExpandMapHide(Message message) {
        }

        public void onDirectBoardShow(Message message) {
        }

        public void onDirectBoardUpdate(Message message) {
        }

        public void onDirectBoardHide(Message message) {
        }

        public void onVectorExpandMapShow(Message message) {
        }

        public void onVectorExpandMapUpdate(Message message) {
        }

        public void onVectorExpandMapHide(Message message) {
        }

        public void onCurRoadNameUpdate(Message message) {
        }

        public void onHUDUpdate(Message message) {
        }

        public void onRGSyncOperation(Message message) {
        }

        public void onHighwayInfoShow(Message message) {
        }

        public void onHighwayInfoUpdate(Message message) {
        }

        public void onHighwayInfoHide(Message message) {
        }

        public void onDestStreetViewShow(Message message) {
        }

        public void onDestStreetViewUpdate(Message message) {
        }

        public void onDestStreetViewHide(Message message) {
        }

        public void onDestStreetViewStartDownload(Message message) {
        }

        public void onDestStreetViewDownloadSuccess(Message message) {
        }

        public void onOtherRGInfo(Message message) {
        }

        public void onSimpleBoardShow(Message message) {
        }

        public void onSimpleBoardUpdate(Message message) {
        }

        public void onSimpleBoardHide(Message message) {
        }

        public void onUGCEventTipsShow() {
        }

        public void onUGCEventTipsHide() {
        }

        public void onGPSWeak(Message message) {
        }
    }

    private C1612a() {
        for (int i = 0; i < C1615b.f4944b.length; i++) {
            this.f4922a.put(C1615b.f4944b[i], Integer.valueOf(BNavR.gTurnIconID[i + 1]));
            this.f4923b.put(C1615b.f4944b[i], Integer.valueOf(C1615b.f4943a[i]));
        }
    }

    /* renamed from: a */
    public static C1612a m5884a() {
        if (f4921i == null) {
            f4921i = new C1612a();
        }
        return f4921i;
    }

    /* renamed from: b */
    public void m5892b() {
        if (!this.f4924d) {
            this.f4924d = true;
            this.f4925e = false;
            if (BNavigator.getInstance().isNaviBegin()) {
                this.f4927g = true;
                this.f4926f = false;
            } else {
                this.f4927g = false;
                this.f4926f = true;
            }
            BNRouteGuider.getInstance().addRGInfoListeners(this.f4930k);
            BNRouteGuider.getInstance().addRGSubStatusListener(this.f4929j);
            LogUtil.d(f4920c, "init isInit:" + this.f4924d + " isSendActionShow:" + this.f4925e + " isNaviBegin:" + this.f4927g + " isArriveDest:" + this.f4926f);
        }
    }

    /* renamed from: c */
    public void m5894c() {
        if (this.f4924d) {
            BNRouteGuider.getInstance().removeRGInfoListeners(this.f4930k);
            BNRouteGuider.getInstance().removeRGSubStatusListener(this.f4929j);
            this.f4924d = false;
            this.f4925e = false;
            this.f4927g = false;
            this.f4926f = true;
            LogUtil.d(f4920c, "unInit isInit:" + this.f4924d + " isSendActionShow:" + this.f4925e + " isNaviBegin:" + this.f4927g + " isArriveDest:" + this.f4926f);
        }
    }

    /* renamed from: f */
    private void m5890f() {
        if (!this.f4926f) {
            Builder builder = CarlifeNaviNextTurnInfo.newBuilder();
            if (builder != null) {
                String nextRoadName = "";
                if (this.f4925e) {
                    builder.setAction(2);
                } else {
                    builder.setAction(1);
                    this.f4925e = true;
                }
                if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("icon_name")) {
                    String turnIconName = RGSimpleGuideModel.sSimpleGuideBundle.getString("icon_name");
                    if (!TextUtils.isEmpty(turnIconName) && this.f4923b.containsKey(turnIconName)) {
                        builder.setNextTurn(((Integer) this.f4923b.get(turnIconName)).intValue());
                        if (this.f4922a.containsKey(turnIconName)) {
                            Drawable icon = BNStyleManager.getDrawable(((Integer) this.f4922a.get(turnIconName)).intValue());
                            if (icon != null) {
                                Bitmap bitmap = ((BitmapDrawable) icon).getBitmap();
                                byte[] turnIcon = m5887a(bitmap);
                                if (turnIcon.length > 30720) {
                                    Bitmap smallImage = Bitmap.createScaledBitmap(bitmap, 160, 160, true);
                                    turnIcon = m5887a(smallImage);
                                    int tmp = 100;
                                    while (turnIcon.length >= 30720 && tmp >= 10) {
                                        turnIcon = m5888a(smallImage, tmp);
                                        tmp -= 10;
                                    }
                                    try {
                                        if (turnIcon.length > 30720) {
                                            LogUtil.d(f4920c, "bitmap is too large");
                                            return;
                                        }
                                    } catch (Exception e) {
                                        LogUtil.d(f4920c, e.toString());
                                        return;
                                    }
                                }
                                builder.setTurnIconData(ByteString.copyFrom(turnIcon));
                                if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("straight")) {
                                    if (RGSimpleGuideModel.sSimpleGuideBundle.getInt("straight", 0) > 0) {
                                        builder.setNextTurn(1);
                                    }
                                }
                                if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("road_name")) {
                                    nextRoadName = RGSimpleGuideModel.sSimpleGuideBundle.getString("road_name");
                                    if (TextUtils.isEmpty(nextRoadName)) {
                                        builder.setRoadName(TrackDataShop.SPECIAL_ADDR_IN_TRACK);
                                    } else {
                                        builder.setRoadName(nextRoadName);
                                    }
                                } else {
                                    builder.setRoadName(TrackDataShop.SPECIAL_ADDR_IN_TRACK);
                                }
                                if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.StartDist)) {
                                    builder.setTotalDistance(RGSimpleGuideModel.sSimpleGuideBundle.getInt(SimpleGuideInfo.StartDist));
                                } else {
                                    builder.setTotalDistance(0);
                                }
                                if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.RemainDist)) {
                                    builder.setRemainDistance(RGSimpleGuideModel.sSimpleGuideBundle.getInt(SimpleGuideInfo.RemainDist));
                                } else {
                                    builder.setRemainDistance(0);
                                }
                                m5886a(builder.build());
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void m5895d() {
        if (this.f4925e) {
            this.f4926f = true;
            this.f4925e = false;
            Builder builder = CarlifeNaviNextTurnInfo.newBuilder();
            if (builder != null) {
                builder.setAction(3);
                builder.setRemainDistance(0);
                builder.setTotalDistance(0);
                builder.setNextTurn(24);
                builder.setRoadName(RoutePlanParams.TURN_TYPE_ID_END);
                builder.setTurnIconData(ByteString.copyFrom(new byte[0]));
                m5886a(builder.build());
            }
        }
    }

    /* renamed from: a */
    private void m5886a(CarlifeNaviNextTurnInfo carlifeNaviNextTurnInfo) {
        if (carlifeNaviNextTurnInfo != null) {
            CarlifeCmdMessage hudCommand = new CarlifeCmdMessage(true);
            hudCommand.m4201c(CommonParams.ag);
            hudCommand.m4199b(carlifeNaviNextTurnInfo.toByteArray());
            hudCommand.m4203d(carlifeNaviNextTurnInfo.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, hudCommand.getServiceType(), 1001, 0, hudCommand));
        }
    }

    /* renamed from: a */
    public void m5891a(boolean isNaviBegin) {
        LogUtil.d(f4920c, "onNaviBegin isNaviBegin:" + isNaviBegin);
        if (isNaviBegin && this.f4928h) {
            m5892b();
            return;
        }
        m5895d();
        m5894c();
    }

    /* renamed from: b */
    public void m5893b(boolean isConnected) {
        LogUtil.d(f4920c, "setConnected isConnected:" + isConnected);
        this.f4928h = isConnected;
        if (isConnected && BNavigator.getInstance().isNaviBegin()) {
            m5892b();
        } else {
            m5894c();
        }
    }

    /* renamed from: a */
    private byte[] m5887a(Bitmap bm) {
        return m5888a(bm, 100);
    }

    /* renamed from: a */
    private byte[] m5888a(Bitmap bm, int quality) {
        if (bm == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(CompressFormat.PNG, quality, baos);
        byte[] result = baos.toByteArray();
        try {
            baos.close();
            return result;
        } catch (IOException e) {
            return result;
        }
    }

    /* renamed from: a */
    private Bitmap m5883a(byte[] buf) {
        if (buf == null || buf.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(buf, 0, buf.length);
    }
}
