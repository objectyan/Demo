package com.baidu.navisdk.vi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;

public class EnvDrawText {
    public static boolean bBmpChange = false;
    public static Bitmap bmp = null;
    public static int[] buffer = null;
    public static Canvas canvasTemp = null;
    public static int iWordHightMax = 0;
    public static int iWordWidthMax = 0;
    public static Paint pt = null;

    public static int[] drawText(String mstr, int iFontSize, int iFontStyle, int[] iParam, int txtrgb, int srgb, int colorbg, int iHaloWidth) {
        if (pt == null) {
            pt = new Paint();
        } else {
            pt.reset();
        }
        pt.setSubpixelText(true);
        pt.setAntiAlias(true);
        pt.setTextSize((float) iFontSize);
        int iPos = mstr.indexOf(92, 0);
        FontMetrics fm;
        int iWordWidth;
        int iWordHight;
        if (iPos == -1) {
            fm = pt.getFontMetrics();
            iWordWidth = (int) pt.measureText(mstr);
            iWordHight = (int) Math.ceil((double) (fm.descent - fm.ascent));
            iParam[0] = iWordWidth;
            iParam[1] = iWordHight;
            double d = Math.log(2.0d);
            if (d > 1.0E-7d || d < -1.0E-7d) {
                iWordWidth = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log((double) iWordWidth) / d)));
                iWordHight = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log((double) iWordHight) / d)));
            }
            if (iWordWidthMax < iWordWidth || iWordHightMax < iWordHight) {
                bBmpChange = true;
                iWordWidthMax = iWordWidth;
                iWordHightMax = iWordHight;
            }
            iParam[2] = iWordWidthMax;
            iParam[3] = iWordHightMax;
            if (!bBmpChange) {
                bmp.eraseColor(0);
            } else if (iWordWidthMax <= 0 || iWordHightMax <= 0) {
                bBmpChange = false;
                return null;
            } else {
                bmp = Bitmap.createBitmap(iWordWidthMax, iWordHightMax, Config.ARGB_8888);
                canvasTemp = new Canvas(bmp);
            }
            if ((-16777216 & colorbg) == 0) {
                canvasTemp.drawColor(33554431);
            } else {
                canvasTemp.drawColor(colorbg);
            }
            if (iHaloWidth != 0) {
                pt.setStrokeWidth((float) iHaloWidth);
                pt.setStrokeCap(Cap.ROUND);
                pt.setStrokeJoin(Join.ROUND);
                pt.setStyle(Style.STROKE);
                pt.setColor(srgb);
                canvasTemp.drawText(mstr, 0.0f, 0.0f - fm.ascent, pt);
            }
            pt.setStyle(Style.FILL);
            pt.setColor(txtrgb);
            canvasTemp.drawText(mstr, 0.0f, 0.0f - fm.ascent, pt);
        } else {
            int iMaxTmp;
            String strTxt;
            int iPosTmp = iPos + 1;
            int iRow = 2;
            int iMax = (int) pt.measureText(mstr.substring(0, iPos));
            while (true) {
                iPos = mstr.indexOf(92, iPosTmp);
                if (iPos <= 0) {
                    break;
                }
                iMaxTmp = (int) pt.measureText(mstr.substring(iPosTmp, iPos));
                if (iMaxTmp > iMax) {
                    iMax = iMaxTmp;
                }
                iPosTmp = iPos + 1;
                iRow++;
            }
            if (iPosTmp != mstr.length()) {
                iMaxTmp = (int) pt.measureText(mstr.substring(iPosTmp, mstr.length()));
                if (iMaxTmp > iMax) {
                    iMax = iMaxTmp;
                }
            }
            fm = pt.getFontMetrics();
            int iRowHeight = (int) Math.ceil((double) (fm.descent - fm.ascent));
            iWordWidth = iMax;
            iWordHight = iRowHeight * iRow;
            iParam[0] = iWordWidth;
            iParam[1] = iWordHight;
            iWordWidth = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log((double) iWordWidth) / Math.log(2.0d))));
            iWordHight = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log((double) iWordHight) / Math.log(2.0d))));
            if (iWordWidthMax < iWordWidth || iWordHightMax < iWordHight) {
                if (iWordWidthMax <= 0 || iWordHightMax <= 0) {
                    bBmpChange = false;
                    return null;
                }
                bBmpChange = true;
                iWordWidthMax = iWordWidth;
                iWordHightMax = iWordHight;
            }
            iParam[2] = iWordWidthMax;
            iParam[3] = iWordHightMax;
            if (bBmpChange) {
                try {
                    bmp = Bitmap.createBitmap(iWordWidthMax, iWordHightMax, Config.ARGB_8888);
                } catch (OutOfMemoryError e) {
                    bmp = null;
                }
                canvasTemp = new Canvas(bmp);
            } else {
                bmp.eraseColor(0);
            }
            if ((-16777216 & colorbg) == 0) {
                canvasTemp.drawColor(33554431);
            } else {
                canvasTemp.drawColor(colorbg);
            }
            iPosTmp = 0;
            iRow = 0;
            while (true) {
                iPos = mstr.indexOf(92, iPosTmp);
                if (iPos <= 0) {
                    break;
                }
                strTxt = mstr.substring(iPosTmp, iPos);
                iMax = (int) pt.measureText(strTxt);
                iPosTmp = iPos + 1;
                if (iHaloWidth != 0) {
                    pt.setStrokeWidth((float) iHaloWidth);
                    pt.setStrokeCap(Cap.ROUND);
                    pt.setStrokeJoin(Join.ROUND);
                    pt.setStyle(Style.STROKE);
                    pt.setColor(srgb);
                    canvasTemp.drawText(strTxt, (float) ((iParam[0] - iMax) / 2), ((float) (iRow * iRowHeight)) - fm.ascent, pt);
                }
                pt.setStyle(Style.FILL);
                pt.setColor(txtrgb);
                canvasTemp.drawText(strTxt, (float) ((iParam[0] - iMax) / 2), ((float) (iRow * iRowHeight)) - fm.ascent, pt);
                iRow++;
            }
            if (iPosTmp != mstr.length()) {
                strTxt = mstr.substring(iPosTmp, mstr.length());
                iMax = (int) pt.measureText(strTxt);
                if (iHaloWidth != 0) {
                    pt.setStrokeWidth((float) iHaloWidth);
                    pt.setStrokeCap(Cap.ROUND);
                    pt.setStrokeJoin(Join.ROUND);
                    pt.setStyle(Style.STROKE);
                    pt.setColor(srgb);
                    canvasTemp.drawText(strTxt, (float) ((iParam[0] - iMax) / 2), ((float) (iRow * iRowHeight)) - fm.ascent, pt);
                }
                pt.setStyle(Style.FILL);
                pt.setColor(txtrgb);
                canvasTemp.drawText(strTxt, (float) ((iParam[0] - iMax) / 2), ((float) (iRow * iRowHeight)) - fm.ascent, pt);
            }
        }
        int iSizedata = iWordWidthMax * iWordHightMax;
        if (bBmpChange) {
            buffer = new int[iSizedata];
        }
        bmp.getPixels(buffer, 0, iWordWidthMax, 0, 0, iWordWidthMax, iWordHightMax);
        bBmpChange = false;
        return buffer;
    }

    public static short[] getTextSize(String mstr, int iFontSize) {
        int iLen = mstr.length();
        if (iLen == 0) {
            return null;
        }
        Paint pt = new Paint();
        pt.setSubpixelText(true);
        pt.setAntiAlias(true);
        pt.setTextSize((float) iFontSize);
        short[] buffer = new short[iLen];
        int i = 0;
        while (i < iLen) {
            if (iLen > 0 && i + 1 <= iLen) {
                buffer[i] = (short) ((int) pt.measureText(mstr.substring(0, i + 1)));
            }
            i++;
        }
        return buffer;
    }
}
