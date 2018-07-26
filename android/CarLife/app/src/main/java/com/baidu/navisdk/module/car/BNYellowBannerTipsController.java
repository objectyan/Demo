package com.baidu.navisdk.module.car;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.module.car.BNYellowBannerTipsModel.TipsType;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions$Builder;
import com.baidu.navisdk.util.navimageloader.BNImageLoader;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;
import java.util.ArrayList;

public class BNYellowBannerTipsController {
    public static final int MAX_LOCAL_POSITION = 256;
    private static final String OFFLINE_DATA_TIPS = "offline.data.tips";
    public static final int POSITION_BAD_WEATER = 259;
    public static final int POSITION_NAVI_LIGHT = 258;
    public static final int POSITION_NO_NET = 257;
    public static final int POSITION_PASS_AREAT = 261;
    public static final int POSITION_SERVIER_AREA = 260;
    private static final int SHOW_TIME = 10;
    private static BNYellowBannerTipsController instance;
    ArrayList<Integer> PriorityList = null;

    /* renamed from: com.baidu.navisdk.module.car.BNYellowBannerTipsController$1 */
    class C41621 implements BNImageLoadingListener {
        C41621() {
        }

        public void onLoadingStarted(String imageUri, View view) {
        }

        public void onLoadingFailed(String imageUri, View view, String failReason) {
            view.setVisibility(8);
        }

        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage, int from) {
        }
    }

    public static BNYellowBannerTipsController getInstance() {
        if (instance == null) {
            instance = new BNYellowBannerTipsController();
        }
        return instance;
    }

    public int getPriorityPosistion(ArrayList<Integer> list) {
        if (this.PriorityList == null || this.PriorityList.size() <= 0) {
            initPriorityList();
        }
        if (this.PriorityList == null || list == null) {
            return -1;
        }
        int position = -1;
        for (int i = 0; i < this.PriorityList.size() && position == -1; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                if (((Integer) list.get(j)).intValue() == ((Integer) this.PriorityList.get(i)).intValue()) {
                    position = j;
                    break;
                }
            }
        }
        return position;
    }

    public String getBackground(int postition) {
        if (BNYellowBannerTipsModel.getInstance().bgcolors == null) {
            BNYellowBannerTipsModel.getInstance().initBackGroundColor();
        }
        try {
            if (BNYellowBannerTipsModel.getInstance().bgcolors.length <= postition || postition < 0) {
                return BNYellowBannerTipsModel.getInstance().bgcolors[0];
            }
            return BNYellowBannerTipsModel.getInstance().bgcolors[postition];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getShowTime() {
        if (BNYellowBannerTipsModel.getInstance().expireTime > 0) {
            return BNYellowBannerTipsModel.getInstance().expireTime;
        }
        return 10;
    }

    private void initPriorityList() {
        int i;
        TipsType[] tipsArr = clonTipsTypeList(BNYellowBannerTipsModel.getInstance().TipsTypeList);
        if (tipsArr != null) {
            for (i = 0; i < tipsArr.length; i++) {
                for (int j = i + 1; j < tipsArr.length; j++) {
                    if (compareTo(tipsArr[i], tipsArr[j])) {
                        TipsType temp = tipsArr[i];
                        tipsArr[i] = tipsArr[j];
                        tipsArr[j] = temp;
                    }
                }
            }
        }
        this.PriorityList = new ArrayList();
        if (tipsArr != null) {
            for (TipsType tipsType : tipsArr) {
                this.PriorityList.add(Integer.valueOf(tipsType.type));
            }
        }
    }

    private boolean compareTo(TipsType mType1, TipsType mType2) {
        if (mType1 == null || mType2 == null || mType1.priority >= mType2.priority) {
            return true;
        }
        return false;
    }

    private TipsType[] clonTipsTypeList(ArrayList<TipsType> List) {
        if (List == null || List.size() <= 0) {
            return null;
        }
        try {
            TipsType[] retArr = new TipsType[List.size()];
            for (int i = 0; i < List.size(); i++) {
                retArr[i] = (TipsType) List.get(i);
            }
            return retArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loadImage(ImageView view, int iconPosition) {
        if (view != null) {
            if (iconPosition <= 0) {
                view.setVisibility(8);
            }
            if (iconPosition >= 256) {
                switch (iconPosition) {
                    case 258:
                        view.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.yellow_banner_lxld));
                        return;
                    case 260:
                        view.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.yellow_banner_fwq));
                        return;
                    default:
                        view.setVisibility(8);
                        return;
                }
            }
            boolean noNetUrl = false;
            boolean defaultDrawbleId = false;
            if (BNYellowBannerTipsModel.getInstance().icons == null || BNYellowBannerTipsModel.getInstance().icons.length <= iconPosition || BNYellowBannerTipsModel.getInstance().icons[iconPosition] == null) {
                noNetUrl = true;
            }
            if (BNYellowBannerTipsModel.getInstance().iconsId == null || BNYellowBannerTipsModel.getInstance().iconsId.length <= iconPosition) {
                defaultDrawbleId = true;
            }
            if (noNetUrl && defaultDrawbleId) {
                view.setVisibility(8);
            } else if (!noNetUrl || defaultDrawbleId) {
                if (!noNetUrl && defaultDrawbleId) {
                    BNImageLoader.getInstance().displayImage(BNYellowBannerTipsModel.getInstance().icons[iconPosition], view, null, new C41621());
                }
                if (!noNetUrl && !defaultDrawbleId) {
                    BNImageLoader.getInstance().displayImage(BNYellowBannerTipsModel.getInstance().icons[iconPosition], view, new BNDisplayImageOptions$Builder().showImageOnLoading(BNYellowBannerTipsModel.getInstance().iconsId[iconPosition]).build(), null);
                }
            } else {
                view.setImageDrawable(BNStyleManager.getDrawable(BNYellowBannerTipsModel.getInstance().iconsId[iconPosition]));
            }
        }
    }

    public boolean shouldShowOfflineDataTips(Context mContext) {
        if (mContext == null) {
            return false;
        }
        if (!PreferenceHelper.getInstance(mContext).contains(OFFLINE_DATA_TIPS)) {
            PreferenceHelper.getInstance(mContext).putBoolean(OFFLINE_DATA_TIPS, BNOfflineDataManager.getInstance().hasContainOfflineData());
        }
        return PreferenceHelper.getInstance(mContext).getBoolean(OFFLINE_DATA_TIPS, false);
    }

    public void setOfflineDataTipsFlag(Context mContext, boolean flag) {
        if (mContext != null) {
            PreferenceHelper.getInstance(mContext).putBoolean(OFFLINE_DATA_TIPS, flag);
        }
    }
}
