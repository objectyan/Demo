package com.baidu.navisdk.util.statistic.datacheck;

import android.os.Bundle;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;

public class DataCheckTest {

    public static class Data50001 implements StatisitcsDataCheck {
        private long rTime = -1;
        private int seaRet = -1;
        private int seaType = -1;

        public Data50001(int st, int sr, long rt) {
            this.seaType = st;
            this.seaRet = sr;
            this.rTime = rt;
        }

        public String getID() {
            return "50001";
        }

        public Bundle getDataBundle() {
            Bundle bd = new Bundle();
            bd.putInt(NaviStatConstants.K_NSC_KEY_POISEARCH_TYPE, this.seaType);
            bd.putInt(NaviStatConstants.K_NSC_KEY_POISEARCH_RET, this.seaRet);
            bd.putLong("re_time", this.rTime);
            return bd;
        }
    }

    public static class Test12345 implements StatisitcsDataCheck {
        private long mArea = -1;
        private int mF = -1;
        private int mR1 = -1;
        private String mR2 = null;
        private int mV = -1;
        private int vArr = -1;

        public Test12345(int f, int v, int arr, long area, int r1, String r2) {
            this.mF = f;
            this.mV = v;
            this.vArr = arr;
            this.mArea = area;
            this.mR1 = r1;
            this.mR2 = r2;
        }

        public String getID() {
            return "12345";
        }

        public Bundle getDataBundle() {
            Bundle bd = new Bundle();
            bd.putInt("testattr_f", this.mF);
            bd.putInt("testattr_v", this.mV);
            bd.putInt("testattr_arr", this.vArr);
            bd.putLong("testattr_area", this.mArea);
            bd.putInt("testattr_r1", this.mR1);
            bd.putString("testattr_r2", this.mR2);
            return bd;
        }
    }

    public static void test() {
        if (LogUtil.LOGGABLE) {
            test12345();
        }
    }

    private static void test50001() {
        DataCheckCenter.getInstance().check(new Data50001(1, 0, 1000));
        DataCheckCenter.getInstance().check(new Data50001(5, 1, 8000));
    }

    private static void test12345() {
        DataCheckCenter.getInstance().check(new Test12345(1, 99, 0, 1000, -400, "3/1"));
        DataCheckCenter.getInstance().check(new Test12345(9, 100, 4, 70001, 6, NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL));
    }
}
