package com.baidu.navisdk.util.statistic.datacheck.regular;

import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import java.util.List;

public class NumberValueRegular<T extends Number> extends Regular {
    public List<T> arrValues = null;
    public String category = null;
    public T fixValue = null;

    public NumberValueRegular(GeneralRegularData regularData, String n) {
        super(regularData, n, null, null);
    }

    public boolean check() {
        return false;
    }
}
