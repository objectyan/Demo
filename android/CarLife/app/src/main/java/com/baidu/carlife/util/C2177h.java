package com.baidu.carlife.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.navi.common.util.FileUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPOutputStream;
import org.apache.http.util.EncodingUtils;

/* compiled from: FileUtil */
/* renamed from: com.baidu.carlife.util.h */
public class C2177h {
    /* renamed from: a */
    public static String m8268a(Context ctx, String file) {
        String result = "";
        InputStream in = null;
        try {
            in = ctx.getResources().getAssets().open(file);
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            result = EncodingUtils.getString(buffer, "utf-8");
        } catch (Exception e) {
        } finally {
            FileUtils.close(in);
        }
        return result;
    }

    /* renamed from: a */
    public static void m8272a(byte[] byteArray, FileOutputStream fout) {
        Exception ex;
        Throwable th;
        GZIPOutputStream gzout = null;
        try {
            GZIPOutputStream gzout2 = new GZIPOutputStream(fout);
            try {
                gzout2.write(byteArray, 0, byteArray.length);
                if (gzout2 != null) {
                    try {
                        gzout2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        gzout = gzout2;
                        return;
                    }
                }
                gzout = gzout2;
            } catch (Exception e2) {
                ex = e2;
                gzout = gzout2;
                try {
                    ex.printStackTrace();
                    if (gzout != null) {
                        try {
                            gzout.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (gzout != null) {
                        try {
                            gzout.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                gzout = gzout2;
                if (gzout != null) {
                    gzout.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            ex = e4;
            ex.printStackTrace();
            if (gzout != null) {
                gzout.close();
            }
        }
    }

    /* renamed from: a */
    public static void m8270a(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                file.delete();
                return;
            }
            for (File a : childFiles) {
                C2177h.m8270a(a);
            }
            file.delete();
        }
    }

    /* renamed from: a */
    public static boolean m8273a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: a */
    public static String m8269a(String aPath) {
        return C2177h.m8274b(aPath);
    }

    /* renamed from: b */
    public static String m8274b(String fileName) {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            File file = new File(fileName);
            if (file.exists()) {
                InputStream is2 = new FileInputStream(file);
                try {
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
                    try {
                        String str = "";
                        while (true) {
                            str = br2.readLine();
                            if (str == null) {
                                break;
                            }
                            builder.append(str);
                        }
                        if (br2 != null) {
                            try {
                                br2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (is2 != null) {
                            try {
                                is2.close();
                                br = br2;
                                is = is2;
                            } catch (IOException e32) {
                                e32.printStackTrace();
                                br = br2;
                                is = is2;
                            }
                        } else {
                            is = is2;
                        }
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        br = br2;
                        is = is2;
                        try {
                            e2.printStackTrace();
                            if (br != null) {
                                try {
                                    br.close();
                                } catch (IOException e322) {
                                    e322.printStackTrace();
                                }
                            }
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (IOException e3222) {
                                    e3222.printStackTrace();
                                }
                            }
                            return C2177h.m8275c(builder.toString());
                        } catch (Throwable th2) {
                            th = th2;
                            if (br != null) {
                                try {
                                    br.close();
                                } catch (IOException e32222) {
                                    e32222.printStackTrace();
                                }
                            }
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (IOException e322222) {
                                    e322222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e322222 = e5;
                        br = br2;
                        is = is2;
                        e322222.printStackTrace();
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException e3222222) {
                                e3222222.printStackTrace();
                            }
                        }
                        if (is != null) {
                            try {
                                is.close();
                            } catch (IOException e32222222) {
                                e32222222.printStackTrace();
                            }
                        }
                        return C2177h.m8275c(builder.toString());
                    } catch (Throwable th3) {
                        th = th3;
                        br = br2;
                        is = is2;
                        if (br != null) {
                            br.close();
                        }
                        if (is != null) {
                            is.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e6) {
                    e2 = e6;
                    is = is2;
                    e2.printStackTrace();
                    if (br != null) {
                        br.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                    return C2177h.m8275c(builder.toString());
                } catch (IOException e7) {
                    e32222222 = e7;
                    is = is2;
                    e32222222.printStackTrace();
                    if (br != null) {
                        br.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                    return C2177h.m8275c(builder.toString());
                } catch (Throwable th4) {
                    th = th4;
                    is = is2;
                    if (br != null) {
                        br.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                    throw th;
                }
                return C2177h.m8275c(builder.toString());
            }
            String str2 = "";
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e322222222) {
                    e322222222.printStackTrace();
                }
            }
            if (is == null) {
                return str2;
            }
            try {
                is.close();
                return str2;
            } catch (IOException e3222222222) {
                e3222222222.printStackTrace();
                return str2;
            }
        } catch (FileNotFoundException e8) {
            e2 = e8;
            e2.printStackTrace();
            if (br != null) {
                br.close();
            }
            if (is != null) {
                is.close();
            }
            return C2177h.m8275c(builder.toString());
        } catch (IOException e9) {
            e3222222222 = e9;
            e3222222222.printStackTrace();
            if (br != null) {
                br.close();
            }
            if (is != null) {
                is.close();
            }
            return C2177h.m8275c(builder.toString());
        }
    }

    /* renamed from: c */
    private static String m8275c(String content) {
        if (content == null || !content.startsWith("﻿")) {
            return content;
        }
        return content.substring(1);
    }

    /* renamed from: a */
    public static void m8271a(String filePath, String content) {
        Exception e;
        Throwable th;
        if (!TextUtils.isEmpty(filePath)) {
            BufferedWriter writer = null;
            try {
                File file = new File(filePath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedWriter writer2 = new BufferedWriter(new FileWriter(file));
                try {
                    writer2.write(content);
                    writer2.flush();
                    if (writer2 != null) {
                        try {
                            writer2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            writer = writer2;
                            return;
                        }
                    }
                    writer = writer2;
                } catch (Exception e3) {
                    e = e3;
                    writer = writer2;
                    try {
                        e.printStackTrace();
                        if (writer != null) {
                            try {
                                writer.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (writer != null) {
                            try {
                                writer.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    writer = writer2;
                    if (writer != null) {
                        writer.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (writer != null) {
                    writer.close();
                }
            }
        }
    }
}
