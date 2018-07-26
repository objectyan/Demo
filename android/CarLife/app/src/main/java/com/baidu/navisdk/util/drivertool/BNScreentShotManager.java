package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.InputDeviceCompat;
import android.view.View;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolImageShowDialog;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.IntBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BNScreentShotManager {
    public static final String SCREEN_IN_HANDLE = "截图正在处理中...请稍候再试";
    public static final int TYPE_COLLADA = 2;
    public static final int TYPE_MAP_RENDER = 1;
    public static final int TYPE_SWITCH = 3;
    private static BNScreentShotManager mInstance;
    public static boolean sIsInThread = false;
    private CaptureMapListener captureMapListener;
    public boolean isSaveShot = false;
    private Bitmap mBitmap = null;
    public String mCachePath = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/naving/capture.png");
    public Bitmap mColladaBitmap = null;
    private View mDecorView = null;
    public Handler mHandler = new C46651();
    private boolean mIsCommomViewShow = false;
    public boolean mIsCross = false;
    public Bitmap mMapRenderBitmap = null;
    public int mScreenState = 0;
    private BNDrivingToolImageShowDialog mShowDialog = null;
    public Bitmap mSwitchBitmap = null;
    private BNWorkerNormalTask mergeTask = new BNWorkerNormalTask<String, String>("mergeTask", null) {
        protected String execute() {
            BNScreentShotManager.this.mergeBitmap();
            return null;
        }
    };

    /* renamed from: com.baidu.navisdk.util.drivertool.BNScreentShotManager$1 */
    class C46651 extends Handler {
        C46651() {
        }

        public void handleMessage(Message msg) {
            int type = msg.what;
            if (type == 256) {
                if (BNDrivingToolUtils.sScreenShotCount == BNDrivingToolUtils.getCurrentScreenCount()) {
                    BNDrivingToolUtils.setSurfaceViewState(false);
                    BNWorkerCenter.getInstance().submitMainThreadTask(BNScreentShotManager.this.mergeTask, new BNWorkerConfig(100, 0));
                    BNDrivingToolUtils.sScreenShotCount = 0;
                }
            } else if (type == 261) {
                BNDrivingToolUtils.sMapRenderShow = false;
                if (msg.obj == null) {
                    BNScreentShotManager.this.mMapRenderBitmap = null;
                    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "大屏截图失败");
                } else {
                    BNScreentShotManager.this.mMapRenderBitmap = (Bitmap) msg.obj;
                    BNDrivingToolUtils.sScreenShotCount++;
                }
                if (BNDrivingToolUtils.sScreenShotCount == BNDrivingToolUtils.getCurrentScreenCount()) {
                    BNDrivingToolUtils.setSurfaceViewState(false);
                    BNWorkerCenter.getInstance().submitMainThreadTask(BNScreentShotManager.this.mergeTask, new BNWorkerConfig(100, 0));
                    BNDrivingToolUtils.sScreenShotCount = 0;
                }
            } else if (type == 258) {
                if (BNScreentShotManager.this.mShowDialog != null) {
                    BNScreentShotManager.this.mShowDialog.updateImage(BNScreentShotManager.this.mBitmap);
                    BNScreentShotManager.this.mHandler.sendEmptyMessageDelayed(260, 1500);
                }
            } else if (type == 257) {
                if (BNScreentShotManager.this.mShowDialog != null) {
                    BNScreentShotManager.this.mShowDialog.updateImage(BNScreentShotManager.this.mBitmap);
                    BNScreentShotManager.this.mHandler.sendEmptyMessageDelayed(259, 1500);
                }
            } else if (type == 260) {
                if (BNScreentShotManager.this.mShowDialog != null) {
                    BNScreentShotManager.this.mShowDialog.dismiss();
                }
            } else if (type == 259 && BNScreentShotManager.this.mShowDialog != null) {
                BNScreentShotManager.this.mShowDialog.dismiss();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.BNScreentShotManager$3 */
    class C46673 implements OnDismissListener {
        C46673() {
        }

        public void onDismiss(DialogInterface dialog) {
            BNScreentShotManager.this.screenShot();
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.BNScreentShotManager$4 */
    class C46684 implements OnCancelListener {
        C46684() {
        }

        public void onCancel(DialogInterface dialog) {
            if (!BNScreentShotManager.this.isSaveShot) {
                BNScreentShotManager.this.handleCancel();
            }
            BNScreentShotManager.this.isSaveShot = false;
        }
    }

    public interface CaptureMapListener {
        void getMapScreenshot(String str, Handler handler, int i);
    }

    public void screenShortByMsg() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0043 in list [B:19:0x004e]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r4 = this;
        r1 = 0;
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r3 = "su";	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r1 = r2.exec(r3);	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r0 = 0;
        r0 = r1.getOutputStream();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r2.<init>();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r3 = "screencap -p ";	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r3 = r4.getRootPath();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r3 = "utf-8";	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r2 = r2.getBytes(r3);	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r0.write(r2);	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        r0.flush();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        if (r0 == 0) goto L_0x003b;
    L_0x0038:
        r0.close();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
    L_0x003b:
        r1.waitFor();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        if (r1 == 0) goto L_0x0043;
    L_0x0040:
        r1.destroy();
    L_0x0043:
        return;
    L_0x0044:
        r2 = move-exception;
        if (r0 == 0) goto L_0x003b;
    L_0x0047:
        r0.close();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
        goto L_0x003b;
    L_0x004b:
        r2 = move-exception;
        if (r1 == 0) goto L_0x0043;
    L_0x004e:
        r1.destroy();
        goto L_0x0043;
    L_0x0052:
        r2 = move-exception;
        if (r0 == 0) goto L_0x0058;
    L_0x0055:
        r0.close();	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
    L_0x0058:
        throw r2;	 Catch:{ Exception -> 0x0044, all -> 0x0052, Exception -> 0x004b, all -> 0x0059 }
    L_0x0059:
        r2 = move-exception;
        if (r1 == 0) goto L_0x005f;
    L_0x005c:
        r1.destroy();
    L_0x005f:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.drivertool.BNScreentShotManager.screenShortByMsg():void");
    }

    private BNScreentShotManager() {
    }

    public CaptureMapListener getCaptureMapListener() {
        return this.captureMapListener;
    }

    public void setCaptureMapListener(CaptureMapListener captureMapListener) {
        this.captureMapListener = captureMapListener;
    }

    private void mergeBitmap() {
        Canvas canvas;
        LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "mergeBitmap state is " + this.mScreenState + "isCross is " + this.mIsCross);
        Bitmap uiBitmap = getInstance().takeScreenShot();
        List<Drawable> drawbleList = new ArrayList();
        LayerDrawable la = null;
        drawbleList.add(new BitmapDrawable(this.mMapRenderBitmap));
        drawbleList.add(new BitmapDrawable(uiBitmap));
        if (this.mScreenState == 0) {
            la = new LayerDrawable((Drawable[]) drawbleList.toArray(new Drawable[drawbleList.size()]));
            la.setLayerInset(0, 0, 0, 0, 0);
            la.setLayerInset(1, 0, 0, 0, 0);
        } else if (this.mScreenState == 1) {
            drawbleList.add(new BitmapDrawable(this.mColladaBitmap));
            la = new LayerDrawable((Drawable[]) drawbleList.toArray(new Drawable[drawbleList.size()]));
            la.setLayerInset(0, 0, 0, 0, 0);
            la.setLayerInset(1, 0, 0, 0, 0);
            la.setLayerInset(2, 0, 0, getColladaRightPx(), getColladaBottomPx());
        } else if (this.mScreenState == 2) {
            drawbleList.add(new BitmapDrawable(this.mSwitchBitmap));
            la = new LayerDrawable((Drawable[]) drawbleList.toArray(new Drawable[drawbleList.size()]));
            la.setLayerInset(0, 0, 0, 0, 0);
            la.setLayerInset(1, 0, 0, 0, 0);
            la.setLayerInset(2, getSmallSurfaceLeftPx(), getSmallSurfaceTopPx(), ScreenUtil.getInstance().dip2px(8), getSwitchViewBottomPix());
        } else if (this.mScreenState == 3) {
            Bitmap enlagreMap = RGMapModeViewController.getInstance().getEnlargeBitmap();
            if (enlagreMap != null) {
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "dingbin merge enlarge map");
                drawbleList.add(new BitmapDrawable(enlagreMap));
                la = new LayerDrawable((Drawable[]) drawbleList.toArray(new Drawable[drawbleList.size()]));
                la.setLayerInset(0, 0, 0, 0, 0);
                la.setLayerInset(1, 0, 0, 0, 0);
                la.setLayerInset(2, getSmallSurfaceLeftPx(), getSmallSurfaceTopPx(), ScreenUtil.getInstance().dip2px(8), getSwitchViewBottomPix());
            } else {
                la = new LayerDrawable((Drawable[]) drawbleList.toArray(new Drawable[drawbleList.size()]));
                la.setLayerInset(0, 0, 0, 0, 0);
                la.setLayerInset(1, 0, 0, 0, 0);
            }
        }
        if (this.mIsCross) {
            this.mBitmap = Bitmap.createBitmap(ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels(), Config.ARGB_8888);
            canvas = new Canvas(this.mBitmap);
            la.setBounds(0, 0, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels());
        } else {
            this.mBitmap = Bitmap.createBitmap(ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels(), Config.ARGB_8888);
            canvas = new Canvas(this.mBitmap);
            la.setBounds(0, 0, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels());
        }
        la.draw(canvas);
        showImageInDialog(0);
    }

    public void showImageInDialog(int src) {
        this.mShowDialog = new BNDrivingToolImageShowDialog(BNaviModuleManager.getNaviActivity());
        this.mShowDialog.show();
        this.mShowDialog.setOnDismissListener(new C46673());
        if (src == 0) {
            this.mHandler.sendEmptyMessage(258);
        } else if (src == 1) {
            this.mHandler.sendEmptyMessage(257);
        }
    }

    public void uninit() {
        if (this.mDecorView != null) {
            this.mDecorView.destroyDrawingCache();
            this.mDecorView.setDrawingCacheEnabled(false);
        }
    }

    private int getSwitchViewBottomPix() {
        if (this.mIsCommomViewShow) {
            return ScreenUtil.getInstance().dip2px(120);
        }
        return ScreenUtil.getInstance().dip2px(8);
    }

    public void testSavePic(Bitmap bitmap, String name) {
        FileOutputStream fileOutputStream;
        Exception e;
        try {
            FileOutputStream ous = new FileOutputStream(new File("/sdcard/" + name + BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX));
            try {
                bitmap.compress(CompressFormat.PNG, 90, ous);
                ous.flush();
                ous.close();
                fileOutputStream = ous;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = ous;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    private int getColladaRightPx() {
        if (this.mIsCross) {
            return ScreenUtil.getInstance().getHeightPixels() / 2;
        }
        return 0;
    }

    private int getColladaBottomPx() {
        if (this.mIsCross) {
            return 0;
        }
        return ScreenUtil.getInstance().getHeightPixels() / 2;
    }

    private int getSmallSurfaceLeftPx() {
        if (this.mIsCross) {
            return ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().dip2px(RouteLineResConst.LINE_DARK_RED_NORMAL);
        }
        return ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(RouteLineResConst.LINE_DARK_RED_NORMAL);
    }

    private int getSmallSurfaceTopPx() {
        int commomViewDip = 0;
        if (this.mIsCommomViewShow) {
            commomViewDip = 112;
        }
        if (this.mIsCross) {
            return ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(commomViewDip + RouteLineResConst.LINE_DARK_RED_NORMAL);
        }
        return ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().dip2px(commomViewDip + RouteLineResConst.LINE_DARK_RED_NORMAL);
    }

    public static BNScreentShotManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNScreentShotManager();
        }
        return mInstance;
    }

    public void initParams() {
        this.mScreenState = BNDrivingToolUtils.getCurrentScreenState();
        if (BNaviModuleManager.getNaviActivity() != null) {
            if (2 == 2) {
                this.mIsCross = true;
            } else {
                this.mIsCross = false;
            }
            if (RGMapModeViewController.getInstance().isCommomViewShow()) {
                this.mIsCommomViewShow = true;
            } else {
                this.mIsCommomViewShow = false;
            }
            BNDrivingToolUtils.setSurfaceViewState(true);
        }
    }

    public boolean screenShot() {
        Context ctx = BNaviModuleManager.getNaviActivity();
        if (ctx != null) {
            BNDrivingToolManager.getInstance().asynAntiGeoSearch(ctx);
        }
        return true;
    }

    public void rootScreenShot() {
        if (screenShotByCommand()) {
            readPictureInBitmap();
            showImageInDialog(1);
            return;
        }
        BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
    }

    public void screenShotFinish() {
        if (this.mBitmap == null) {
            BNSettingManager.setRootScreenshotState(false);
            releaseResource();
            BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            return;
        }
        BNDrivingToolUtils.sIssueOccurTime = System.currentTimeMillis();
        BNDrivingToolIssueStoreDialog mIssueDialog = BNDrivingToolManager.getInstance().getIssueStoreDialog(3);
        mIssueDialog.show();
        this.isSaveShot = false;
        mIssueDialog.setOnCancelListener(new C46684());
    }

    public void handleCancel() {
        uninit();
        releaseResource();
    }

    public void handleSave() {
        this.mBitmap = BNDrivingToolUtils.addWaterMark(this.mBitmap, BNDrivingToolUtils.getLocationInfo(), BNDrivingToolUtils.getCurrentTimeInfo(), null);
        savePicture(getPicturePath());
        LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "finish time is " + System.currentTimeMillis());
        this.isSaveShot = true;
        handleCancel();
    }

    private void releaseResource() {
        if (!(this.mMapRenderBitmap == null || this.mMapRenderBitmap.isRecycled())) {
            this.mMapRenderBitmap.recycle();
            this.mMapRenderBitmap = null;
        }
        if (!(this.mColladaBitmap == null || this.mColladaBitmap.isRecycled())) {
            this.mColladaBitmap.recycle();
            this.mColladaBitmap = null;
        }
        if (this.mSwitchBitmap != null && !this.mSwitchBitmap.isRecycled()) {
            this.mSwitchBitmap.recycle();
            this.mSwitchBitmap = null;
        }
    }

    public static String getEnlargeImgPath() {
        File file = new File(SysOSAPI.getInstance().GetSDCardPath() + File.separator + "EnlargeDir");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator + new SimpleDateFormat("yyyyMMddHHmm", Locale.getDefault()).format(new Date()) + BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX;
    }

    private String getPicturePath() {
        return BNDrivingToolUtils.getAbsoluteFilePath(3);
    }

    private String getInfo() {
        return "dingbbin";
    }

    private void savePicture(String filePathStr) {
        Throwable th;
        FileOutputStream fos = null;
        try {
            FileOutputStream fos2 = new FileOutputStream(filePathStr);
            if (fos2 != null) {
                try {
                    this.mBitmap.compress(CompressFormat.PNG, 90, fos2);
                } catch (Exception e) {
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.flush();
                            fos.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
                        this.mBitmap.recycle();
                        this.mBitmap = null;
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.flush();
                            fos.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                        this.mBitmap.recycle();
                        this.mBitmap = null;
                    }
                    throw th;
                }
            }
            if (fos2 != null) {
                try {
                    fos2.flush();
                    fos2.close();
                } catch (Exception e4) {
                }
            }
            if (this.mBitmap == null || this.mBitmap.isRecycled()) {
                fos = fos2;
                return;
            }
            this.mBitmap.recycle();
            this.mBitmap = null;
            fos = fos2;
        } catch (Exception e5) {
            if (fos != null) {
                fos.flush();
                fos.close();
            }
            if (this.mBitmap != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (fos != null) {
                fos.flush();
                fos.close();
            }
            this.mBitmap.recycle();
            this.mBitmap = null;
            throw th;
        }
    }

    private Bitmap takeScreenShot() {
        Activity activity = BNaviModuleManager.getNaviActivity();
        if (activity == null) {
            return null;
        }
        this.mDecorView = activity.getWindow().getDecorView();
        int colorId = ((ColorDrawable) this.mDecorView.getBackground()).getColor();
        LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "colorid is, alph " + colorId);
        this.mDecorView.setBackgroundColor(0);
        this.mDecorView.setDrawingCacheEnabled(true);
        this.mDecorView.buildDrawingCache();
        Bitmap bitmap = this.mDecorView.getDrawingCache();
        Rect frame = new Rect();
        this.mDecorView.getWindowVisibleDisplayFrame(frame);
        int statusHeight = frame.top;
        bitmap = Bitmap.createBitmap(bitmap, 0, statusHeight, activity.getWindowManager().getDefaultDisplay().getWidth(), activity.getWindowManager().getDefaultDisplay().getHeight() - statusHeight);
        this.mDecorView.setBackgroundColor(colorId);
        return bitmap;
    }

    private void addWaterMark(String info) {
        int width = this.mBitmap.getWidth();
        int height = this.mBitmap.getHeight();
        Canvas canvas = new Canvas(this.mBitmap);
        Paint textPaint = new Paint(257);
        textPaint.setTextSize(30.0f);
        textPaint.setColor(InputDeviceCompat.SOURCE_ANY);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setShadowLayer(3.0f, 1.0f, 1.0f, -65536);
        canvas.drawText(info, (float) (width / 3), (float) (((double) height) * 0.9d), textPaint);
        canvas.save(31);
        canvas.restore();
    }

    private String getTmpStorePath() {
        return "/sdcard/drivingToolPic.temp";
    }

    public boolean screenShotByCommand() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            OutputStream outputStream = null;
            try {
                outputStream = process.getOutputStream();
                outputStream.write(("screencap -p " + getTmpStorePath()).getBytes("utf-8"));
                outputStream.flush();
                if (outputStream != null) {
                    outputStream.close();
                }
                process.waitFor();
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e) {
                BNSettingManager.setRootScreenshotState(false);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (process == null) {
                    return false;
                }
                process.destroy();
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (Exception e2) {
            if (process != null) {
                process.destroy();
            }
        } catch (Throwable th2) {
            if (process != null) {
                process.destroy();
            }
        }
        return true;
    }

    public void rootScreenByMsg() {
        if (BNSettingManager.isShowJavaLog()) {
            BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask<String, String>(RGEnlargeRoadMapModel.class.getSimpleName() + "setRasterImage", null) {
                protected String execute() {
                    BNScreentShotManager.getInstance().screenShortByMsg();
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 100);
        }
    }

    public void saveImgDirect(final Bitmap bitmap) {
        if (BNSettingManager.isShowJavaLog()) {
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>(RGEnlargeRoadMapModel.class.getSimpleName() + "savImg", null) {
                protected String execute() {
                    FileOutputStream fileOutputStream;
                    Exception e;
                    try {
                        FileOutputStream ous = new FileOutputStream(new File(BNScreentShotManager.getEnlargeImgPath()));
                        try {
                            bitmap.compress(CompressFormat.PNG, 90, ous);
                            ous.flush();
                            ous.close();
                            fileOutputStream = ous;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = ous;
                            e.printStackTrace();
                            return null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        return null;
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }
    }

    private String getRootPath() {
        return getEnlargeImgPath();
    }

    private void readPictureInBitmap() {
        File picSrc = new File(getTmpStorePath());
        try {
            FileInputStream in = new FileInputStream(picSrc);
            FileInputStream fileInputStream;
            try {
                this.mBitmap = BitmapFactory.decodeStream(in).copy(Config.RGB_565, true);
                picSrc.delete();
                fileInputStream = in;
            } catch (Exception e) {
                fileInputStream = in;
            }
        } catch (Exception e2) {
        }
    }

    public void captureSurfaceView(int surfaceWidth, int surfaceHeight, int surfaceViewType) {
        if (surfaceViewType != 1) {
            if (surfaceViewType == 2) {
                BNDrivingToolUtils.sColladaRenderShow = false;
            } else if (surfaceViewType == 3) {
                BNDrivingToolUtils.sSwitchRenderShow = false;
            }
            int w = surfaceWidth;
            int h = surfaceHeight;
            int[] b = new int[(w * h)];
            int[] bt = new int[(w * h)];
            IntBuffer buffer = IntBuffer.wrap(b);
            buffer.position(0);
            GLES20.glReadPixels(0, 0, w, h, 6408, 5121, buffer);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    int pix = b[(i * w) + j];
                    bt[(((h - i) - 1) * w) + j] = ((-16711936 & pix) | ((pix << 16) & 16711680)) | ((pix >> 16) & 255);
                }
            }
            Bitmap.createBitmap(w, h, Config.RGB_565).copyPixelsFromBuffer(buffer);
            Bitmap inBitmap = Bitmap.createBitmap(bt, w, h, Config.RGB_565);
            if (surfaceViewType == 2) {
                this.mColladaBitmap = inBitmap;
            } else if (surfaceViewType == 3) {
                this.mSwitchBitmap = inBitmap;
            }
            BNDrivingToolUtils.sScreenShotCount++;
            this.mHandler.sendEmptyMessage(256);
        } else if (getCaptureMapListener() != null) {
            getCaptureMapListener().getMapScreenshot(this.mCachePath, this.mHandler, 261);
        }
    }

    private void test(Bitmap inBitmap, String str) {
        File f = new File("/sdcard/dingbin9.4" + str + BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX);
        try {
            f.createNewFile();
            FileOutputStream fOut = new FileOutputStream(f);
            FileOutputStream fileOutputStream;
            try {
                inBitmap.compress(CompressFormat.PNG, 100, fOut);
                fOut.flush();
                fOut.close();
                fileOutputStream = fOut;
            } catch (Exception e) {
                fileOutputStream = fOut;
            }
        } catch (Exception e2) {
        }
    }
}
