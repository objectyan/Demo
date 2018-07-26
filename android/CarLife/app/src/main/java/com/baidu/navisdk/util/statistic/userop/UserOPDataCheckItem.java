package com.baidu.navisdk.util.statistic.userop;

import android.os.Bundle;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

public class UserOPDataCheckItem implements StatisitcsDataCheck {
    private Bundle mDataCheckBundle = null;

    public UserOPDataCheckItem(ArrayList<NameValuePair> statPairList) {
        if (this.mDataCheckBundle == null) {
            this.mDataCheckBundle = new Bundle();
        }
        Iterator it = statPairList.iterator();
        while (it.hasNext()) {
            NameValuePair mNameValuePair = (NameValuePair) it.next();
            this.mDataCheckBundle.putString(mNameValuePair.getName(), mNameValuePair.getValue());
        }
    }

    public String getID() {
        return "50008";
    }

    public Bundle getDataBundle() {
        return this.mDataCheckBundle;
    }

    public void check() {
        DataCheckCenter.getInstance().check(this);
    }
}
