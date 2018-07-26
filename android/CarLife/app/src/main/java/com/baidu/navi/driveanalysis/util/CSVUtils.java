package com.baidu.navi.driveanalysis.util;

import com.baidu.navi.driveanalysis.CommonConstants;
import com.baidu.navi.driveanalysis.model.TrackModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    private static final String SEPARATOR = ",";
    private static final String TAILED = "\r\n";

    public static boolean exportCsv(File file, List<TrackModel> dataList) {
        boolean isSucess;
        Throwable th;
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            FileOutputStream out2 = new FileOutputStream(file);
            try {
                OutputStreamWriter osw2 = new OutputStreamWriter(out2);
                try {
                    BufferedWriter bw2 = new BufferedWriter(osw2);
                    if (dataList != null) {
                        try {
                            if (!dataList.isEmpty()) {
                                bw2.append("latitude");
                                bw2.append(",");
                                bw2.append("longitude");
                                bw2.append(",");
                                bw2.append("coord_type");
                                bw2.append(",");
                                bw2.append("speed");
                                bw2.append(",");
                                bw2.append("direction");
                                bw2.append(",");
                                bw2.append("height");
                                bw2.append(",");
                                bw2.append(CommonConstants.RADIUS);
                                bw2.append(",");
                                bw2.append("loc_time");
                                bw2.append(",");
                                bw2.append("connected");
                                bw2.append(TAILED);
                                int cnt = dataList.size();
                                for (TrackModel model : dataList) {
                                    bw2.append("" + model.latitude);
                                    bw2.append(",");
                                    bw2.append("" + model.longitude);
                                    bw2.append(",");
                                    bw2.append("" + model.coordType);
                                    bw2.append(",");
                                    bw2.append("" + model.speed);
                                    bw2.append(",");
                                    bw2.append("" + model.direction);
                                    bw2.append(",");
                                    bw2.append("" + model.height);
                                    bw2.append(",");
                                    bw2.append("" + model.radius);
                                    bw2.append(",");
                                    bw2.append("" + model.localTime);
                                    bw2.append(",");
                                    bw2.append("" + model.isConnectWithVehicle);
                                    cnt--;
                                    if (cnt > 0) {
                                        bw2.append(TAILED);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            bw = bw2;
                            osw = osw2;
                            out = out2;
                            isSucess = false;
                            if (bw != null) {
                                try {
                                    bw.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (osw != null) {
                                try {
                                    osw.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                            }
                            if (out != null) {
                                try {
                                    out.close();
                                } catch (IOException e222) {
                                    e222.printStackTrace();
                                }
                            }
                            return isSucess;
                        } catch (Throwable th2) {
                            th = th2;
                            bw = bw2;
                            osw = osw2;
                            out = out2;
                            if (bw != null) {
                                try {
                                    bw.close();
                                } catch (IOException e2222) {
                                    e2222.printStackTrace();
                                }
                            }
                            if (osw != null) {
                                try {
                                    osw.close();
                                } catch (IOException e22222) {
                                    e22222.printStackTrace();
                                }
                            }
                            if (out != null) {
                                try {
                                    out.close();
                                } catch (IOException e222222) {
                                    e222222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    isSucess = true;
                    if (bw2 != null) {
                        try {
                            bw2.close();
                        } catch (IOException e2222222) {
                            e2222222.printStackTrace();
                        }
                        if (osw2 != null) {
                            try {
                                osw2.close();
                            } catch (IOException e22222222) {
                                e22222222.printStackTrace();
                            }
                            if (out2 == null) {
                                try {
                                    out2.close();
                                } catch (IOException e222222222) {
                                    e222222222.printStackTrace();
                                    out = out2;
                                }
                            }
                            return isSucess;
                        }
                        osw = osw2;
                        if (out2 == null) {
                        } else {
                            out2.close();
                        }
                        return isSucess;
                    }
                    bw = bw2;
                    if (osw2 != null) {
                        osw2.close();
                        if (out2 == null) {
                            out2.close();
                        }
                        return isSucess;
                    }
                    osw = osw2;
                    if (out2 == null) {
                    } else {
                        out2.close();
                    }
                } catch (Exception e3) {
                    osw = osw2;
                    out = out2;
                    isSucess = false;
                    if (bw != null) {
                        bw.close();
                    }
                    if (osw != null) {
                        osw.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                    return isSucess;
                } catch (Throwable th3) {
                    th = th3;
                    osw = osw2;
                    out = out2;
                    if (bw != null) {
                        bw.close();
                    }
                    if (osw != null) {
                        osw.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                out = out2;
                isSucess = false;
                if (bw != null) {
                    bw.close();
                }
                if (osw != null) {
                    osw.close();
                }
                if (out != null) {
                    out.close();
                }
                return isSucess;
            } catch (Throwable th4) {
                th = th4;
                out = out2;
                if (bw != null) {
                    bw.close();
                }
                if (osw != null) {
                    osw.close();
                }
                if (out != null) {
                    out.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            isSucess = false;
            if (bw != null) {
                bw.close();
            }
            if (osw != null) {
                osw.close();
            }
            if (out != null) {
                out.close();
            }
            return isSucess;
        } catch (Throwable th5) {
            th = th5;
            if (bw != null) {
                bw.close();
            }
            if (osw != null) {
                osw.close();
            }
            if (out != null) {
                out.close();
            }
            throw th;
        }
        return isSucess;
    }

    public static List<String> importCsv(File file) {
        Throwable th;
        List<String> dataList = new ArrayList();
        BufferedReader br = null;
        try {
            BufferedReader br2 = new BufferedReader(new FileReader(file));
            try {
                String str = "";
                while (true) {
                    str = br2.readLine();
                    if (str == null) {
                        break;
                    }
                    dataList.add(str);
                }
                if (br2 != null) {
                    try {
                        br2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        br = br2;
                    }
                }
            } catch (Exception e2) {
                br = br2;
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return dataList;
            } catch (Throwable th2) {
                th = th2;
                br = br2;
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            if (br != null) {
                br.close();
            }
            return dataList;
        } catch (Throwable th3) {
            th = th3;
            if (br != null) {
                br.close();
            }
            throw th;
        }
        return dataList;
    }
}
