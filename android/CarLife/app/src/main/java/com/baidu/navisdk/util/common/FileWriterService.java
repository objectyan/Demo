package com.baidu.navisdk.util.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {
    private static BufferedWriter fileWriter;
    private static FileWriterService instance;

    private FileWriterService(String filePath) {
    }

    public static FileWriterService getInstance(String filePath) {
        if (instance == null) {
            instance = new FileWriterService(filePath);
        }
        return instance;
    }

    private void initFile(String filePath) {
        try {
            fileWriter = new BufferedWriter(new FileWriter(new File(SysOSAPI.getInstance().GetSDCardPath(), filePath), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeline(String content) {
        if (fileWriter != null) {
        }
    }

    public void uninit() {
        try {
            if (fileWriter != null) {
                fileWriter.flush();
                fileWriter.close();
                fileWriter = null;
            }
        } catch (Exception e) {
        }
    }
}
