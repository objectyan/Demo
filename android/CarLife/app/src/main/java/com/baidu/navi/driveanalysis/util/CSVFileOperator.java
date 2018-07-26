package com.baidu.navi.driveanalysis.util;

import com.baidu.navi.driveanalysis.model.TrackModel;
import java.io.File;
import java.util.List;

public class CSVFileOperator {
    private static final int MAX_COLUMN = 9;

    public static void write(List<TrackModel> list, String fileName) {
        if (list != null && list.size() != 0) {
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            CSVUtils.exportCsv(file, list);
        }
    }
}
