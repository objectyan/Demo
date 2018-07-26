package com.baidu.android.pushservice.p032k;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;

/* renamed from: com.baidu.android.pushservice.k.c */
public class C0583c {
    /* renamed from: a */
    public static ArrayList<String> m2632a(String str, File file) {
        Exception e;
        Throwable th;
        FileWriter fileWriter = null;
        ArrayList<String> arrayList = new ArrayList();
        String str2 = "no su";
        Reader inputStreamReader;
        try {
            Process exec = Runtime.getRuntime().exec(str);
            inputStreamReader = new InputStreamReader(exec.getInputStream(), "utf-8");
            try {
                BufferedReader lineNumberReader = new LineNumberReader(inputStreamReader);
                if (file != null) {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileWriter = new FileWriter(file, true);
                    fileWriter.append("\n\n\n---------------   CMD : " + str + "   ---------------\n\n\n");
                }
                while (true) {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                    if (fileWriter != null) {
                        fileWriter.append(readLine + "\n");
                    }
                }
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
                exec.waitFor();
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    arrayList.add(str2);
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamReader = null;
            e.printStackTrace();
            arrayList.add(str2);
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
        return arrayList;
    }
}
