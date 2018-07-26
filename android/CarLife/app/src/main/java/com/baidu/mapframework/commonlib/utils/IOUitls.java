package com.baidu.mapframework.commonlib.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class IOUitls {
    private IOUitls() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        byte[] buf = new byte[512];
        while (true) {
            int count = inputStream.read(buf);
            if (count != -1) {
                outputStream.write(buf, 0, count);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public static void copyQuietly(InputStream inputStream, OutputStream outputStream) {
        try {
            copy(inputStream, outputStream);
        } catch (IOException e) {
        } finally {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
        }
    }

    public static byte[] readFile(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("filePath is empty");
        }
        File file = new File(filePath);
        if (file.isFile()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                copyQuietly(new FileInputStream(file), outputStream);
                return outputStream.toByteArray();
            } catch (FileNotFoundException e) {
                return new byte[0];
            }
        }
        throw new IllegalArgumentException(filePath + " is not a File");
    }

    public static byte[] readFile(File file) {
        if (file.isFile()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                copyQuietly(new FileInputStream(file), outputStream);
                return outputStream.toByteArray();
            } catch (FileNotFoundException e) {
                return new byte[0];
            }
        }
        throw new IllegalArgumentException(file.getAbsolutePath() + " is not a File");
    }

    public static String readFile(String filePath, String charset) {
        if (TextUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("filePath is empty");
        }
        File file = new File(filePath);
        if (file.isFile()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                copyQuietly(new FileInputStream(file), outputStream);
                return outputStream.toString(charset);
            } catch (FileNotFoundException e) {
                return "";
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException(filePath + " is not a File");
    }

    public static String readFile(File file, String charset) {
        if (file.isFile()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                copyQuietly(new FileInputStream(file), outputStream);
                return outputStream.toString(charset);
            } catch (FileNotFoundException e) {
                return "";
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException(file.getAbsolutePath() + " is not a File");
    }

    public static void writeToFile(String filePath, InputStream inputStream) {
        if (TextUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("filePath is empty");
        }
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        if (parent.exists()) {
            try {
                copyQuietly(inputStream, new FileOutputStream(file));
                return;
            } catch (FileNotFoundException e) {
                return;
            }
        }
        throw new IllegalStateException("Can't create dir " + parent.getAbsolutePath());
    }

    public static void writeToFile(File file, InputStream inputStream) {
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        if (parent.exists()) {
            try {
                copyQuietly(inputStream, new FileOutputStream(file));
                return;
            } catch (FileNotFoundException e) {
                return;
            }
        }
        throw new IllegalStateException("Can't create dir " + parent.getAbsolutePath());
    }

    public static void writeToFile(String filePath, byte[] data) {
        writeToFile(filePath, new ByteArrayInputStream(data));
    }

    public static void writeToFile(File file, byte[] data) {
        writeToFile(file.getAbsolutePath(), data);
    }

    public static void writeToFile(String filePath, String data, String charset) {
        try {
            writeToFile(filePath, data.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void writeToFile(File file, String data, String charset) {
        try {
            writeToFile(file, data.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
